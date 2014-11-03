package koopa.core.grammars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.OnLand;
import koopa.core.data.markers.Start;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.ParseStream;
import koopa.core.parsers.Parser;
import koopa.core.util.Tuple;
import koopa.core.util.WeakSet;

import org.apache.log4j.Logger;

/**
 * This provides the basis for implementing full grammars. It basically gives
 * you a form of parser combinators with which you can define more complex
 * grammar rules.
 * <p>
 * Note that you shouldn't be using this class directly. Instead the actual code
 * will get generated from actual Koopa grammar definitions.
 */
public abstract class KoopaGrammar {

	protected static final Logger LOGGER = Logger.getLogger("grammar");

	// The dictionary will have to get pushed and popped as we enter/leave
	// certain parsers. Otherwise, recursion will screw up the lexical scopes.
	final Stack<Map<String, Object>> scope = new Stack<Map<String, Object>>();

	private List<Tuple<Token, String>> warnings = new LinkedList<Tuple<Token, String>>();

	/**
	 * Option which toggles whether or not to skip separators as defined by
	 * {@linkplain #isSeparator(String)} and {@linkplain #isSeparator(Token)}.
	 */
	private boolean noskip = false;

	public KoopaGrammar() {
	}

	protected void warn(Token t, String msg) {
		if (msg != null) {
			this.warnings.add(new Tuple<Token, String>(t, msg));
		}
	}

	public boolean hasWarnings() {
		return !this.warnings.isEmpty();
	}

	public List<Tuple<Token, String>> getWarnings() {
		return this.warnings;
	}

	private int depth = 0;

	private String indent() {
		String s = "";
		for (int i = 0; i < depth; i++) {
			s += "  ";
		}
		return s;
	}

	private void push(final String message) {
		LOGGER.trace(indent() + message);
		depth += 1;
	}

	private void trace(final String message) {
		LOGGER.trace(indent() + message);
	}

	private void pop(final String message) {
		depth -= 1;
		LOGGER.trace(indent() + message);
	}

	protected FutureParser scoped(final String name) {
		// Using this for memoization because, as it turns out, it occurs often
		// enough that the same grammar rule gets evaluated on the same token.
		// If we already know it has failed before then we can shortcircuit a
		// lot of duplicate work.
		final WeakSet<Token> failures = new WeakSet<Token>();

		return new FutureParser() {
			public boolean accepts(ParseStream stream) {
				Token peek = stream.peek();

				if (LOGGER.isTraceEnabled())
					push(name + " ? " + peek + "...");

				if (failures.has(stream.peek())) {
					if (LOGGER.isTraceEnabled())
						pop(name + ": no (memoized)");

					return false;
				}

				Assign assign = null;

				if (scope.size() > 0) {
					// Get the "lvalue".
					assign = (Assign) scope.peek().get("=");
				}

				Map<String, Object> newScope = new HashMap<String, Object>();
				// Push the "lvalue" as the return target.
				newScope.put("return", assign);

				scope.push(newScope);

				stream.bookmark();
				stream.insert(Start.on(name));

				boolean accepts = parser.accepts(stream);

				if (accepts) {
					stream.insert(End.on(name));
					stream.commit();

				} else {
					stream.rewind();
					failures.put(stream.peek());
				}

				scope.pop();

				if (LOGGER.isTraceEnabled())
					pop(name + (accepts ? ": yes " : ": no ") + peek + " // "
							+ stream.peek() + "...");

				return accepts;
			}
		};
	}

	protected Parser assign(final String name, final Parser parser) {
		return new Parser() {
			public boolean accepts(ParseStream stream) {
				scope().put("=", new Assign(scope(), name));
				boolean accepts = parser.accepts(stream);
				scope().remove("=");
				return accepts;
			}
		};
	}

	protected Parser returning(final String name) {
		return new Parser() {
			public boolean accepts(ParseStream stream) {
				Assign func = (Assign) scope().get("return");
				if (func != null) {
					func.apply(scope().get(name));
				}
				return true;
			}
		};
	}

	private class Assign {
		private final String var;
		private final Map<String, Object> scope;

		public Assign(final Map<String, Object> scope, final String var) {
			this.var = var;
			this.scope = scope;
		}

		public void apply(Object object) {
			scope.put(var, object);
		}
	}

	protected Map<String, Object> scope() {
		return scope.peek();
	}

	protected Parser apply(final Block func) {
		return new Parser() {
			public boolean accepts(ParseStream stream) {
				func.apply();
				return true;
			}
		};
	}

	protected Parser skipto(final Parser parser) {
		return new Parser() {
			public boolean accepts(ParseStream stream) {
				if (LOGGER.isTraceEnabled())
					push("[skipto>");

				boolean inWater = false;

				stream.bookmark();
				while (!parser.accepts(stream)) {
					stream.rewind();

					if (!inWater) {
						stream.insert(InWater.getInstance());
						inWater = true;
					}

					final Token skipped = stream.forward();

					if (skipped == null) {
						if (LOGGER.isTraceEnabled())
							pop("<skipto]: no");

						return false;
					}

					stream.bookmark();
				}

				stream.rewind();

				if (inWater)
					stream.insert(OnLand.getInstance());

				if (LOGGER.isTraceEnabled())
					pop("<skipto]: yes");

				return true;
			}
		};
	}

	protected Parser not(final Parser parser) {
		return new Parser() {
			public boolean accepts(ParseStream stream) {
				if (LOGGER.isTraceEnabled())
					push("[not>");

				stream.bookmark();
				final boolean accepted = parser.accepts(stream);
				stream.rewind();

				if (LOGGER.isTraceEnabled())
					pop("<not]");

				return !accepted;
			}
		};
	}

	protected Parser star(final Parser parser) {
		return new Parser() {
			public boolean accepts(ParseStream stream) {
				if (LOGGER.isTraceEnabled())
					push("[star>");

				while (true) {
					stream.bookmark();

					if (!parser.accepts(stream)) {
						stream.rewind();
						break;
					}

					stream.commit();
				}

				if (LOGGER.isTraceEnabled())
					pop("<star]: yes");

				return true;
			}
		};
	}

	protected Parser plus(final Parser parser) {
		return new Parser() {
			public boolean accepts(ParseStream stream) {
				if (LOGGER.isTraceEnabled())
					push("[plus>");

				stream.bookmark();

				if (!parser.accepts(stream)) {
					stream.rewind();

					if (LOGGER.isTraceEnabled())
						pop("<plus]: no");

					return false;
				}

				stream.commit();

				while (true) {
					stream.bookmark();

					if (!parser.accepts(stream)) {
						stream.rewind();
						break;
					}

					stream.commit();
				}

				if (LOGGER.isTraceEnabled())
					pop("<plus]: yes");

				return true;
			}
		};
	}

	protected Parser sequence(final Parser... parsers) {
		return new Parser() {
			public boolean accepts(ParseStream stream) {
				for (Parser parser : parsers)
					if (!parser.accepts(stream))
						return false;

				return true;
			}
		};
	};

	protected Parser choice(final Parser... parsers) {
		return new Parser() {
			public boolean accepts(ParseStream stream) {
				// if (LOGGER.isTraceEnabled()) {
				// push("[choice>");
				// }

				for (int i = 0; i < parsers.length; i++) {
					final Parser parser = parsers[i];

					stream.bookmark();
					if (parser.accepts(stream)) {
						stream.commit();
						return true;

					} else {
						stream.rewind();

						if (LOGGER.isTraceEnabled() && i + 1 < parsers.length)
							trace("or");
					}
				}

				// if (LOGGER.isTraceEnabled()) {
				// pop("<choice]");
				// }

				return false;
			}
		};
	};

	protected Parser permuted(final Parser... parsers) {
		final List<Parser> choices = new ArrayList<Parser>(parsers.length);
		for (Parser parser : parsers) {
			choices.add(parser);
		}

		return new Parser() {
			public boolean accepts(ParseStream stream) {
				if (LOGGER.isTraceEnabled())
					push("[permuted>");

				List<Parser> remaining = new ArrayList<Parser>(choices);

				int i = 0;
				while (i < remaining.size()) {
					stream.bookmark();

					if (remaining.get(i).accepts(stream)) {
						stream.commit();
						remaining.remove(i);
						i = 0;

					} else {
						stream.rewind();
						i++;
					}
				}

				if (LOGGER.isTraceEnabled())
					pop("<permuted]");

				return true;
			}
		};
	};

	protected Parser optional(final Parser parser) {
		return new Parser() {
			public boolean accepts(ParseStream stream) {
				if (LOGGER.isTraceEnabled())
					push("[optional>");

				stream.bookmark();

				boolean accepts = parser.accepts(stream);
				if (accepts) {
					stream.commit();

				} else {
					stream.rewind();
				}

				if (LOGGER.isTraceEnabled())
					pop("<optional]: " + accepts);

				return true;
			}
		};
	}

	/**
	 * Accepts a single token if its text matches the given text.
	 * <p>
	 * This will skip all intermediate separators, unless the given text is a
	 * separator.
	 */
	protected Parser token(final String text) {
		final boolean isSeparator = isSeparator(text);
		return new Parser() {
			public boolean accepts(ParseStream stream) {
				if (!isSeparator)
					skipSeparators(stream);

				final Token token = stream.forward();

				if (token != null && token.getText().equalsIgnoreCase(text)) {

					if (LOGGER.isTraceEnabled())
						trace(token + " =~ " + text + " : yes");

					assignIfNeeded(token);

					return true;

				} else {
					if (LOGGER.isTraceEnabled())
						trace(token + " =~ " + text + " : no");

					return false;
				}
			}
		};
	}

	/**
	 * Accepts any and all tokens. Will only fail when there are no more tokens
	 * on the token stream.
	 * <p>
	 * This will skip all intermediate separators.
	 */
	protected Parser any() {
		return new Parser() {
			public boolean accepts(ParseStream stream) {
				skipSeparators(stream);

				final Token token = stream.forward();

				if (token != null) {

					if (LOGGER.isTraceEnabled())
						trace(token + " != null : yes");

					assignIfNeeded(token);

					return true;

				} else {
					if (LOGGER.isTraceEnabled())
						trace(token + " != null : no");

					return false;
				}
			}
		};
	}

	/**
	 * Checks whether the following token in the stream has a given tag. That
	 * token is <b>not</b> consumed by this parser.
	 * <p>
	 * This will skip all intermediate separators.
	 */
	protected Parser tagged(final Object tag) {
		return new Parser() {
			public boolean accepts(ParseStream stream) {
				skipSeparators(stream);

				final Token token = stream.forward();

				if (token == null) {
					if (LOGGER.isTraceEnabled())
						trace(token + " has tag " + tag + " : no");

					return false;
				}

				if (token.hasTag(tag)) {
					if (LOGGER.isTraceEnabled())
						trace(token + " has tag " + tag + " : yes");

					stream.rewind(token);
					return true;

				} else {
					if (LOGGER.isTraceEnabled())
						trace(token + " has tag " + tag + " : no");

					stream.rewind(token);
					return false;
				}
			}
		};
	}

	protected Parser opt(final Opt opt, final Parser parser) {
		return new Parser() {
			public boolean accepts(ParseStream stream) {
				boolean prv = false;

				switch (opt) {
				case NOSKIP:
					prv = noskip;
					noskip = true;
					break;
				}

				final boolean accepts = parser.accepts(stream);

				switch (opt) {
				case NOSKIP:
					noskip = prv;
					break;
				}

				return accepts;
			}
		};
	}

	protected void returnToken(Token token) {
		Assign assign = (Assign) scope().get("return");
		if (assign != null)
			assign.apply(token);
	}

	/**
	 * Check whether the token should be assigned to a variable in the current
	 * scope. If so, do that.
	 */
	private void assignIfNeeded(final Token token) {
		if (scope.isEmpty())
			return;

		Assign assign = (Assign) scope().get("=");

		if (assign == null)
			return;

		assign.apply(token);
	}

	/**
	 * Whether or not a token contributes to program text.
	 * <p>
	 * It is up to actual grammars to override this and implement as needed.
	 */
	public abstract boolean isProgramText(Token token);

	/**
	 * Whether or not a piece of text represents a separator (or whitespace).
	 * <p>
	 * It is up to actual grammars to override this and implement as needed.
	 */
	protected abstract boolean isSeparator(String text);

	/**
	 * Whether or not a token represents a separator.
	 * <p>
	 * By default this delegates to
	 * {@linkplain KoopaGrammar#isSeparator(String)}.
	 */
	public boolean isSeparator(Token token) {
		return isSeparator(token.getText());
	}

	/**
	 * Skips all tokens which are either not program text, or which are
	 * separators.
	 * <p>
	 * If the {@linkplain #noskip} option is active then this will only skip
	 * tokens which are not program text.
	 * <p>
	 * Subclasses may use this as needed in custom parsers.
	 */
	protected void skipSeparators(ParseStream stream) {
		while (true) {
			Token token = stream.forward();

			if (token == null)
				return;

			if (!isProgramText(token))
				continue;

			if (noskip) {
				stream.rewind(token);
				return;
			}

			if (isSeparator(token))
				continue;

			stream.rewind(token);
			return;
		}
	}
}
