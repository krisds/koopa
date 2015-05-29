package koopa.core.grammars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.OnLand;
import koopa.core.data.markers.Start;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.LimitedParseStream;
import koopa.core.parsers.ParseStack;
import koopa.core.parsers.ParseStack.Frame;
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
	// TODO Refactor this to make use of ParsingContext.
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
		return scoped(name, true);
	}

	protected FutureParser scoped(final String name, final boolean publik) {
		// Using this for memoization because, as it turns out, it occurs often
		// enough that the same grammar rule gets evaluated on the same token.
		// If we already know it has failed before then we can shortcircuit a
		// lot of duplicate work.
		final WeakSet<Token> failures = new WeakSet<Token>();

		return new FutureParser() {
			public boolean matches(ParseStream stream) {
				Token peek = stream.peek();

				if (LOGGER.isTraceEnabled())
					push(name + " ? " + stream.peekMore() + "...");

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
				if (publik)
					stream.insert(Start.on(getNamespace(), name));

				boolean accepts = parser.accepts(stream);

				if (accepts) {
					if (publik)
						stream.insert(End.on(getNamespace(), name));

					stream.commit();

				} else {
					stream.rewind();
					failures.put(stream.peek());
				}

				scope.pop();

				if (LOGGER.isTraceEnabled())
					pop(name + (accepts ? ": yes " : ": no ") + peek
							+ " - up to " + stream.peekMore() + "...");

				return accepts;
			}

			/**
			 * It's subtle, but when asking a scoped parser for all keywords
			 * "in scope", we're asking for all keywords in the scope it's being
			 * referenced from.
			 * <p>
			 * If we were to add all keywords within its own scope, then the
			 * keywords list for the root scope would end up containing all
			 * keywords in the grammar. For instance, a Cobol program would know
			 * about all SQL-related keywords found in an EXEC SQL. This is not
			 * what we want.
			 * <p>
			 * Instead what we need is to add all leading keywords of our own
			 * scope. This should give the parent scope just enough information
			 * about tokens it probably should know about, without telling it
			 * about all tokens. Taking the Cobol program example again, it
			 * would now only know about the markers for the overall structure
			 * of the program, and little else.
			 */
			public void addAllKeywordsInScopeTo(Set<String> keywords) {
				parser.addAllLeadingKeywordsTo(keywords);
			}

			public void addAllLeadingKeywordsTo(Set<String> keywords) {
				parser.addAllLeadingKeywordsTo(keywords);
			}

			public boolean canMatchEmptyInputs() {
				return parser.canMatchEmptyInputs();
			}

			public boolean isMatching(String n) {
				return name.equals(n);
			}

			public String toString() {
				return "def " + name;
			}
		};
	}

	protected Parser as(final String name, final Parser parser) {
		return new Parser() {
			public boolean matches(ParseStream stream) {
				if (LOGGER.isTraceEnabled())
					push(name + " ? " + stream.peekMore() + "...");

				stream.bookmark();
				stream.insert(Start.on(getNamespace(), name));

				boolean accepts = parser.accepts(stream);

				if (accepts) {
					stream.insert(End.on(getNamespace(), name));
					stream.commit();

				} else {
					stream.rewind();
				}

				return accepts;
			}

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
				parser.addAllKeywordsInScopeTo(keywords);
			}

			public void addAllLeadingKeywordsTo(Set<String> keywords) {
				parser.addAllLeadingKeywordsTo(keywords);
			}

			public boolean canMatchEmptyInputs() {
				return parser.canMatchEmptyInputs();
			}

			public boolean isMatching(String n) {
				return name.equals(n);
			}

			public String toString() {
				return "... %as " + name;
			}
		};
	}

	protected Parser assign(final String name, final Parser parser) {
		return new Parser() {
			public boolean matches(ParseStream stream) {
				scope().put("=", new Assign(scope(), name));
				boolean accepts = parser.accepts(stream);
				scope().remove("=");
				return accepts;
			}

			public String toString() {
				return name + " = ...";
			}
		};
	}

	protected Parser returning(final String name) {
		return new Parser() {
			public boolean matches(ParseStream stream) {
				Assign func = (Assign) scope().get("return");
				if (func != null) {
					func.apply(scope().get(name));
				}
				return true;
			}

			public String toString() {
				return "return " + name;
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
			public boolean matches(ParseStream stream) {
				func.apply();
				return true;
			}

			public String toString() {
				return "fn()";
			}
		};
	}

	protected Parser skipto(final Parser parser) {
		return new Parser() {
			public boolean matches(ParseStream stream) {
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

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
			}

			public boolean canMatchEmptyInputs() {
				return true;
			}

			public String toString() {
				return "--> ...";
			}
		};
	}

	protected Parser not(final Parser parser) {
		return new Parser() {
			public boolean matches(ParseStream stream) {
				if (LOGGER.isTraceEnabled())
					push("[not>");

				stream.bookmark();
				final boolean accepted = parser.accepts(stream);
				stream.rewind();

				if (LOGGER.isTraceEnabled())
					pop("<not]");

				return !accepted;
			}

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
			}

			public boolean canMatchEmptyInputs() {
				return true;
			}

			public String toString() {
				return "%not " + parser.toString();
			}
		};
	}

	protected Parser star(final Parser parser) {
		return new Parser() {
			public boolean matches(ParseStream stream) {
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

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
				parser.addAllKeywordsInScopeTo(keywords);
			}

			public void addAllLeadingKeywordsTo(Set<String> keywords) {
				parser.addAllLeadingKeywordsTo(keywords);
			}

			public boolean canMatchEmptyInputs() {
				return true;
			}

			public String toString() {
				return "...*";
			}
		};
	}

	protected Parser plus(final Parser parser) {
		return new Parser() {
			public boolean matches(ParseStream stream) {
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

			public boolean canMatchEmptyInputs() {
				return parser.canMatchEmptyInputs();
			}

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
				parser.addAllKeywordsInScopeTo(keywords);
			}

			public void addAllLeadingKeywordsTo(Set<String> keywords) {
				parser.addAllLeadingKeywordsTo(keywords);
			}

			public String toString() {
				return "...+";
			}
		};
	}

	protected Parser sequence(final Parser... parsers) {
		return new Parser() {
			public boolean matches(ParseStream stream) {
				for (Parser parser : parsers)
					if (!parser.accepts(stream))
						return false;

				return true;
			}

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
				for (Parser parser : parsers)
					parser.addAllKeywordsInScopeTo(keywords);
			}

			public void addAllLeadingKeywordsTo(Set<String> keywords) {
				for (int i = 0; i < parsers.length; i++) {
					parsers[i].addAllLeadingKeywordsTo(keywords);
					if (!parsers[i].canMatchEmptyInputs())
						break;
				}
			}

			public boolean canMatchEmptyInputs() {
				for (Parser parser : parsers)
					if (!parser.canMatchEmptyInputs())
						return false;

				return true;
			}

			public String toString() {
				return "(...)";
			}
		};
	};

	protected Parser choice(final Parser... parsers) {
		return new Parser() {
			public boolean matches(ParseStream stream) {
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

				return false;
			}

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
				for (Parser parser : parsers)
					parser.addAllKeywordsInScopeTo(keywords);
			}

			public void addAllLeadingKeywordsTo(Set<String> keywords) {
				for (Parser parser : parsers)
					parser.addAllLeadingKeywordsTo(keywords);
			}

			public boolean canMatchEmptyInputs() {
				for (Parser parser : parsers)
					if (parser.canMatchEmptyInputs())
						return true;

				return false;
			}

			public String toString() {
				return "...|...";
			}
		};
	};

	protected Parser permuted(final Parser... parsers) {
		final List<Parser> choices = new ArrayList<Parser>(parsers.length);
		for (Parser parser : parsers) {
			choices.add(parser);
		}

		return new Parser() {
			public boolean matches(ParseStream stream) {
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

				boolean accepts = remaining.size() < choices.size();

				if (LOGGER.isTraceEnabled())
					pop("<permuted]: " + accepts);

				return accepts;
			}

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
				for (Parser parser : parsers)
					parser.addAllKeywordsInScopeTo(keywords);
			}

			public void addAllLeadingKeywordsTo(Set<String> keywords) {
				for (Parser parser : parsers)
					parser.addAllLeadingKeywordsTo(keywords);
			}

			public boolean canMatchEmptyInputs() {
				for (Parser parser : parsers)
					if (parser.canMatchEmptyInputs())
						return true;

				return false;
			}

			public String toString() {
				return "!(...|...)";
			}
		};
	};

	protected Parser optional(final Parser parser) {
		return new Parser() {
			public boolean matches(ParseStream stream) {
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

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
				parser.addAllKeywordsInScopeTo(keywords);
			}

			public void addAllLeadingKeywordsTo(Set<String> keywords) {
				parser.addAllLeadingKeywordsTo(keywords);
			}

			public boolean canMatchEmptyInputs() {
				return true;
			}

			public String toString() {
				return "[...]";
			}
		};
	}

	protected Parser token(final String text) {
		return token(text, true);
	}

	protected Parser literal(final String text) {
		return token(text, false);
	}

	/**
	 * Accepts a single token if its text matches the given text.
	 * <p>
	 * This will skip all intermediate separators, other than the text itself.
	 */
	protected Parser token(final String text, final boolean isKeyword) {
		final boolean isSeparator = isSeparator(text);
		return new Parser() {
			public boolean matches(ParseStream stream) {
				if (!isSeparator)
					skipSeparators(stream);
				else
					skipOtherSeparators(stream, text);

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

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
				if (isKeyword)
					keywords.add(text);
			}

			public void addAllLeadingKeywordsTo(Set<String> keywords) {
				keywords.add(text);
			}

			public boolean isKeyword(String word, Frame frame) {
				return frame.up().isKeyword(word);
			}

			public String toString() {
				return "'" + text + "'";
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
			public boolean matches(ParseStream stream) {
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

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
			}

			public String toString() {
				return "_";
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
			public boolean matches(ParseStream stream) {
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

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
			}

			public boolean canMatchEmptyInputs() {
				return true;
			}

			public String toString() {
				return "@" + tag.toString();
			}
		};
	}

	protected Parser opt(final Opt opt, final Parser parser) {
		return new Parser() {
			public boolean matches(ParseStream stream) {
				boolean prv = false;

				switch (opt) {
				case NOSKIP:
					prv = noskip;
					noskip = true;
					if (LOGGER.isTraceEnabled())
						trace("%noskip: " + noskip);
					break;
				}

				final boolean accepts = parser.accepts(stream);

				switch (opt) {
				case NOSKIP:
					noskip = prv;
					if (LOGGER.isTraceEnabled())
						trace("%noskip: " + noskip);
					break;
				}

				return accepts;
			}

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
				parser.addAllKeywordsInScopeTo(keywords);
			}

			public void addAllLeadingKeywordsTo(Set<String> keywords) {
				parser.addAllLeadingKeywordsTo(keywords);
			}

			public boolean canMatchEmptyInputs() {
				return parser.canMatchEmptyInputs();
			}

			public String toString() {
				return "%" + opt.toString();
			}
		};
	}

	protected Parser limited(final Parser target, final Parser limiter) {
		return new Parser() {
			public boolean matches(ParseStream stream) {
				return target.accepts(new LimitedParseStream(stream, limiter));
			}

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
				target.addAllKeywordsInScopeTo(keywords);
				// Not: limiter.addAllKeywordsInScopeTo(keywords);
			}

			public void addAllLeadingKeywordsTo(Set<String> keywords) {
				target.addAllLeadingKeywordsTo(keywords);
			}

			public boolean canMatchEmptyInputs() {
				return target.canMatchEmptyInputs();
			}

			public String toString() {
				return "%limit " + target + " %by " + limiter;
			}
		};
	}

	protected Parser dispatched(final String[] keys, final Parser[] parsers) {
		assert (keys.length == parsers.length);

		final Map<String, Parser> lookupTable = new HashMap<String, Parser>();
		for (int i = 0; i < keys.length; i++)
			lookupTable.put(keys[i].toUpperCase(), parsers[i]);

		return new Parser() {
			public boolean matches(ParseStream stream) {
				skipSeparators(stream);

				Token peek = stream.peek();
				if (peek == null) {
					if (LOGGER.isTraceEnabled())
						trace("dispatch: null");
					return false;
				}

				String text = peek.getText().toUpperCase();
				if (!lookupTable.containsKey(text)) {
					if (LOGGER.isTraceEnabled())
						trace("dispatch: " + text + " - not found");
					return false;
				}

				if (LOGGER.isTraceEnabled())
					trace("dispatch: " + text);
				Parser parser = lookupTable.get(text);
				return parser.accepts(stream);
			}

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
				for (Parser parser : parsers)
					parser.addAllKeywordsInScopeTo(keywords);
			}

			public void addAllLeadingKeywordsTo(Set<String> keywords) {
				for (String key : keys)
					keywords.add(key);
			}

			public String toString() {
				return "$(...|...)";
			}
		};
	}

	/**
	 * Accepts when the token stream is at the end of the input (ignoring
	 * separators).
	 * <p>
	 * This will skip all intermediate separators.
	 */
	protected Parser eof() {
		return new Parser() {
			public boolean matches(ParseStream stream) {
				skipSeparators(stream);

				final Token token = stream.forward();
				final boolean atEndOfFile = token == null;

				if (LOGGER.isTraceEnabled())
					trace(token + " == null : " + atEndOfFile);

				return atEndOfFile;
			}

			public void addAllKeywordsInScopeTo(Set<String> keywords) {
			}

			public void addAllLeadingKeywordsTo(Set<String> keywords) {
			}

			public boolean canMatchEmptyInputs() {
				return true;
			}

			public String toString() {
				return "eof";
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
	public boolean isSeparator(Token token, ParseStack parseStack) {
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
		skipOtherSeparators(stream, null);
	}

	/**
	 * Skips all tokens which are either not program text, or which are
	 * separators other than the given one.
	 * <p>
	 * If the {@linkplain #noskip} option is active then this will only skip
	 * tokens which are not program text.
	 * <p>
	 * Subclasses may use this as needed in custom parsers.
	 */
	protected void skipOtherSeparators(ParseStream stream, String sep) {
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

			if (sep != null && sep.equals(token.getText())) {
				stream.rewind(token);
				return;
			}

			if (isSeparator(token, stream.getStack()))
				continue;

			stream.rewind(token);
			return;
		}
	}

	/**
	 * What is this grammar's namespace ? This will help separate grammar rules
	 * with matching names from different grammars, which is of importance when
	 * composing grammars.
	 */
	protected abstract String getNamespace();
}
