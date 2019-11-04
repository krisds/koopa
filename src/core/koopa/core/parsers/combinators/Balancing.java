package koopa.core.parsers.combinators;

import java.util.LinkedList;
import java.util.Stack;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;
import koopa.core.streams.BaseStream;
import koopa.core.targets.HoldingTarget;

/**
 * This {@linkplain ParserCombinator} tracks the nesting (opening and closing)
 * of parentheses (or whatever you tell it to balance) during the matching of
 * another given {@linkplain ParserCombinator}. At any time during that match
 * you can ask this {@linkplain ParserCombinator} whether or not it is in a
 * balanced state (which is defined at {@linkplain Balancer#isBalanced()}).
 */
public class Balancing extends UnaryParserDecorator {

	/**
	 * Continuous testing of the {@link #pairs} introduces a lot of extra
	 * logging. This flag toggles it off by default.
	 */
	private static final boolean SILENCE = true;

	private final Grammar grammar;

	/**
	 * These are the things we're trying to balance.
	 * <p>
	 * They will be placed in a {@linkplain Closure} at the time the actual
	 * {@linkplain Balancer} starts matching.
	 */
	private final Pair[] pairs;

	public Balancing(Grammar grammar, ParserCombinator parser,
			ParserCombinator... pairs) {
		super(parser);

		this.grammar = grammar;

		assert (pairs.length % 2 == 0);

		// TODO Closure the pairs, if needed.
		this.pairs = new Pair[pairs.length / 2];
		for (int i = 0; i < this.pairs.length; i++)
			this.pairs[i] = new Pair(pairs[2 * i], pairs[2 * i + 1]);
	}

	@Override
	protected boolean matches(Parse parse) {
		final BaseStream baseStream = parse.getFlow().getBaseStream();
		final HoldingTarget target = baseStream.getTarget();

		final Balancer newBalancer = new Balancer(parser, parse);

		addObserver(target, newBalancer);

		final boolean accepts = newBalancer.accepts(parse);

		removeObserver(target, newBalancer);

		return accepts;
	}

	private void addObserver(HoldingTarget target, Balancer replacing) {
		if (replacing != null) {
			target.addObserver(replacing);
		}
	}

	private void removeObserver(HoldingTarget target, Balancer existing) {
		if (existing != null) {
			target.removeObserver(existing);
			existing.pause();
		}
	}

	@Override
	public String toString() {
		return "%balancing <" + pairs.length + " pairs> ...";
	}

	/**
	 * A pair of {@linkplain ParserCombinator}s marking the start and end of
	 * something.
	 */
	private class Pair {
		public final ParserCombinator open;
		public final ParserCombinator close;

		public Pair(ParserCombinator open, ParserCombinator close) {
			this.open = open;
			this.close = close;
		}

		@Override
		public String toString() {
			return "<" + open + " " + close + ">";
		}
	}

	/**
	 * This observes the {@linkplain Data} being pushed/popped by the
	 * {@linkplain Stream}.
	 */
	public class Balancer extends UnaryParserDecorator
			implements HoldingTarget.Observer {

		private final Parse parse;

		/**
		 * These are the things we're trying to balance.
		 */
		private final Pair[] closedPairs;

		private final LinkedList<Match> pushed = new LinkedList<>();
		private final LinkedList<Match> popped = new LinkedList<>();
		private final Stack<Pair> open = new Stack<>();

		public Balancer(ParserCombinator parser, Parse parse) {
			super(parser);

			this.parse = parse;

			this.closedPairs = new Pair[pairs.length];
			for (int i = 0; i < pairs.length; i++) {
				final Pair pair = pairs[i];
				this.closedPairs[i] = new Pair(new Closure(pair.open, parse),
						new Closure(pair.close, parse));
			}
		}

		@Override
		protected boolean matches(Parse parse) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().indent(toString() + " ?");

			final boolean accepts = parser.accepts(parse);

			if (parse.getTrace().isEnabled())
				parse.getTrace()
						.dedent(toString() + " : " + (accepts ? "yes" : "no"));

			return accepts;
		}

		/**
		 * This is the whole reason for this class: so that we may ask whether
		 * or not we're inside a balanced set of parentheses.
		 * <p>
		 * We are not balanced when:
		 * <ul>
		 * <li>We are within any open pair.</li>
		 * <li>We are at the opening of a pair.</li>
		 * <li>We are at the closing of a pair.</li>
		 * </ul>
		 * In any other case we are balanced.
		 */
		public boolean isBalanced() {
			return isNowBalanced();
		}

		public void pause() {
			if (parse.getTrace().isEnabled()) {
				parse.getTrace().add("# " + hashCode() + ", pausing ...");
				parse.getTrace().add(getReport());
			}
		}

		@Override
		public void start(HoldingTarget holdingTarget, Token last) {
			if (parse.getTrace().isEnabled())
				parse.getTrace()
						.add("# " + hashCode() + ", start(" + last + ") ...");

			if (SILENCE)
				parse.getTrace().silence(true);

			if (tryClosing(parse.getFlow().getStream())) {
				final Pair closed = open.peek();
				push(new Match(last, Kind.CLOSE, closed));

			} else {
				for (Pair pair : closedPairs)
					if (tryOpening(parse.getFlow().getStream(), pair)) {
						// pairMatchingAtStart = pair;
						push(new Match(last, Kind.OPEN, pair));
						break;
					}
			}

			if (SILENCE)
				parse.getTrace().silence(false);
		}

		@Override
		public void pushed(HoldingTarget holdingTarget, Token token) {
			if (!locationInProgramTextChanged(token))
				return;

			if (SILENCE)
				parse.getTrace().silence(true);

			if (parse.getTrace().isEnabled())
				parse.getTrace()
						.add("# " + hashCode() + ", pushed(" + token + ") ...");

			if (!popped.isEmpty()) {
				if (popped.peek().data == token) {
					recyclePopped(token);
				}

			} else {
				if (tryClosing(parse.getFlow().getStream())) {
					final Pair closed = open.peek();
					push(new Match(token, Kind.CLOSE, closed));

				} else {
					for (Pair pair : closedPairs)
						if (tryOpening(parse.getFlow().getStream(), pair)) {
							push(new Match(token, Kind.OPEN, pair));
							break;
						}
				}
			}

			if (SILENCE)
				parse.getTrace().silence(false);
		}

		@Override
		public void popping(HoldingTarget holdingTarget, Token last) {
			if (!locationInProgramTextChanged(last))
				return;

			if (SILENCE)
				parse.getTrace().silence(true);

			if (parse.getTrace().isEnabled())
				parse.getTrace()
						.add("# " + hashCode() + ", popping(" + last + ") ...");

			pop(last);

			if (SILENCE)
				parse.getTrace().silence(false);
		}

		private boolean locationInProgramTextChanged(Token token) {
			return grammar.isProgramText(token);
		}

		private boolean tryClosing(Stream stream) {
			if (open.isEmpty())
				return false;

			final Pair pair = open.peek();

			if (parse.getTrace().isEnabled())
				parse.getTrace()
						.indent(toString() + ", close " + pair.close + " ?");

			stream.bookmark();
			final boolean couldClose = pair.close.accepts(parse);
			stream.rewind();

			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(toString() + ", close " + pair.close
						+ " : " + (couldClose ? "yes" : "no"));

			return couldClose;
		}

		private boolean tryOpening(Stream stream, Pair pair) {
			if (parse.getTrace().isEnabled())
				parse.getTrace()
						.indent(toString() + ", open " + pair.open + " ?");

			stream.bookmark();
			final boolean couldOpen = pair.open.accepts(parse);
			stream.rewind();

			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(toString() + ", open " + pair.open
						+ " : " + (couldOpen ? "yes" : "no"));

			return couldOpen;
		}

		private void push(Match match) {
			pushed.addFirst(match);

			if (match.kind == Kind.OPEN)
				open(match.pair);
			else
				close(match.pair);

			if (parse.getTrace().isEnabled()) {
				parse.getTrace().add("# " + hashCode() + ", pushed " + match);
				parse.getTrace().add(getReport());
			}
		}

		private void pop(Data data) {
			while (!pushed.isEmpty() && pushed.peek().data == data) {
				final Match match = pushed.removeFirst();

				// If this looks strange, don't forget we're inverting the logic
				// here.
				if (match.kind == Kind.OPEN)
					close(match.pair);
				else
					open(match.pair);

				popped.addFirst(match);

				if (parse.getTrace().isEnabled()) {
					parse.getTrace()
							.add("# " + hashCode() + ", popped " + match);
					parse.getTrace().add(getReport());
				}
			}
		}

		private void recyclePopped(Data data) {
			while (!popped.isEmpty() && popped.peek().data == data) {
				final Match match = popped.removeFirst();
				pushed.addFirst(match);

				if (match.kind == Kind.OPEN)
					open(match.pair);
				else
					close(match.pair);

				if (parse.getTrace().isEnabled())
					parse.getTrace()
							.add("# " + hashCode() + ", recycled " + match);
			}

			if (parse.getTrace().isEnabled())
				parse.getTrace().add(getReport());
		}

		private void open(Pair pair) {
			open.push(pair);
		}

		private void close(Pair pair) {
			Pair p = open.pop();
			assert (p == pair);
		}

		public String getReport() {
			return "# " + hashCode() + ", " //
					+ pushed.size() + " matches, " //
					+ popped.size() + " popped, " //
					+ open.size() + " open, " //
					+ (wasJustClosed() ? "just closed a pair, " : "")
					+ "and so it is "
					+ (isNowBalanced() ? "balanced" : "unbalanced");
		}

		private boolean wasJustClosed() {
			if (pushed.isEmpty())
				return false;

			final Match lastMatch = pushed.peek();
			if (lastMatch.kind != Kind.CLOSE)
				return false;

			// TODO Do we care about seeing skipped tokens ?
			final Data lastData = parse.getFlow().getBaseStream().getTarget()
					.peekAtLastToken();
			return lastMatch.data == lastData;
		}

		private boolean isNowBalanced() {
			return open.isEmpty() && !wasJustClosed();
		}

		@Override
		public String toString() {
			return "%balancing#" + hashCode();
		}

		private final class Match {
			public Data data;

			public final Kind kind;
			public final Pair pair;

			public Match(Data data, Kind kind, Pair pair) {
				this.data = data;
				this.kind = kind;
				this.pair = pair;
			}

			@Override
			public String toString() {
				if (kind == Kind.OPEN)
					return "opening of " + pair.open + " after " + data;
				else
					return "closing of " + pair.close + " after " + data;
			}
		}
	}

	private enum Kind {
		OPEN, CLOSE
	};
}
