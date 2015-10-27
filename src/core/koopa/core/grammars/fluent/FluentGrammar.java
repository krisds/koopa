package koopa.core.grammars.fluent;

import static koopa.core.grammars.combinators.Scoped.Visibility.PUBLIC;

import java.util.HashMap;
import java.util.Map;

import koopa.core.grammars.Grammar;
import koopa.core.grammars.combinators.MatchAny;
import koopa.core.grammars.combinators.MatchEndOfFile;
import koopa.core.grammars.combinators.MatchToken;
import koopa.core.grammars.combinators.Opt;
import koopa.core.grammars.combinators.Scoped;
import koopa.core.grammars.combinators.TestTag;
import koopa.core.grammars.combinators.WithOption;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.combinators.Choice;
import koopa.core.parsers.combinators.Optional;
import koopa.core.parsers.combinators.Plus;
import koopa.core.parsers.combinators.Sequence;
import koopa.core.parsers.combinators.SkipTo;
import koopa.core.parsers.combinators.Star;

public abstract class FluentGrammar extends Grammar {

	private Map<String, DelayedDefinition> definitions = new HashMap<String, DelayedDefinition>();

	protected NamedDefinition define(String name) {
		assert (!definitions.containsKey(name));

		NamedDefinition def = new NamedDefinition(name);
		definitions.put(name, def);
		return def;
	}

	protected DelayedDefinition defineHelper(String name) {
		assert (!definitions.containsKey(name));

		DelayedDefinition def = new DelayedDefinition();
		definitions.put(name, def);
		return def;
	}

	protected NamedDefinition with(String name) {
		return new NamedDefinition(name);
	}

	protected Definition definitionOf(String name) {
		return definitions.get(name);
	}

	protected Definition all(final Object... elements) {
		return new Definition() {
			@Override
			public ParserCombinator asParser() {
				if (elements.length == 1)
					return convertToParser(elements[0]);
				else
					return new Sequence(convertAllToParsers(elements));
			}
		};
	}

	protected Definition oneOf(final Object... elements) {
		return new Definition() {
			@Override
			public ParserCombinator asParser() {
				if (elements.length == 1)
					return convertToParser(elements[0]);
				else
					return new Choice(convertAllToParsers(elements));
			}
		};
	}

	protected Definition many(final Object... elements) {
		return new Definition() {
			private Definition def = all(elements);

			@Override
			public ParserCombinator asParser() {
				return new Star(def.asParser());
			}
		};
	}

	protected Definition oneOrMore(final Object... elements) {
		return new Definition() {
			private Definition def = all(elements);

			@Override
			public ParserCombinator asParser() {
				return new Plus(def.asParser());
			}
		};
	}

	protected Definition skipTo(final Object... elements) {
		return new Definition() {
			private Definition def = all(elements);

			@Override
			public ParserCombinator asParser() {
				return new SkipTo(def.asParser());
			}
		};
	}

	protected Definition optional(final Object... elements) {
		return new Definition() {
			private Definition def = all(elements);

			@Override
			public ParserCombinator asParser() {
				return new Optional(def.asParser());
			}
		};
	}

	protected Definition alternating(final Object element,
			final Object separator) {
		return all(element, many(separator, element));
	}

	protected Definition noskip(final Object... elements) {
		return new Definition() {
			private Definition def = all(elements);

			@Override
			public ParserCombinator asParser() {
				return new WithOption(Opt.NOSKIP, def.asParser());
			}
		};
	}

	protected Definition token(final String text) {
		return new Definition() {
			@Override
			public ParserCombinator asParser() {
				return new MatchToken(FluentGrammar.this, text);
			}
		};
	}

	protected Definition tagged(final Object tag) {
		return new Definition() {
			@Override
			public ParserCombinator asParser() {
				return new TestTag(FluentGrammar.this, tag);
			}
		};
	}

	protected Definition any() {
		return new Definition() {
			@Override
			public ParserCombinator asParser() {
				return new MatchAny(FluentGrammar.this);
			}
		};
	}

	protected Definition userDefined() {
		return new Definition() {
			@Override
			public ParserCombinator asParser() {
				return new MatchAny(FluentGrammar.this, true);
			}
		};
	}

	protected Definition eof() {
		return new Definition() {
			@Override
			public ParserCombinator asParser() {
				return new MatchEndOfFile(FluentGrammar.this);
			}
		};
	}

	// ---

	private ParserCombinator convertToParser(Object object) {
		if (object instanceof ParserCombinator)
			return (ParserCombinator) object;
		else if (object instanceof Definition)
			return ((Definition) object).asParser();
		else if (object instanceof String) {
			String text = (String) object;
			if (text.startsWith("==") && text.endsWith("=="))
				return new MatchToken(FluentGrammar.this, text.substring(2,
						text.length() - 2));
			else if (definitions.containsKey(text))
				return definitionOf(text).asParser();
			else
				throw new InternalError("Don't know how to convert: " + text);
		} else
			throw new InternalError("Don't know how to convert: " + object);
	}

	private ParserCombinator[] convertAllToParsers(Object... elements) {
		ParserCombinator[] pcs = new ParserCombinator[elements.length];
		for (int i = 0; i < elements.length; i++)
			pcs[i] = convertToParser(elements[i]);
		return pcs;
	}

	public abstract class Definition {
		public abstract ParserCombinator asParser();
	}

	public class DelayedDefinition extends Definition {
		private Definition body = null;
		private FutureParser parser = null;

		public DelayedDefinition as(Object... elements) {
			assert (body == null);

			body = all(elements);
			return this;
		}

		public DelayedDefinition with(String name) {
			assert (body == null);

			NamedDefinition named = new NamedDefinition(name);
			body = named;
			return named;
		}

		@Override
		public ParserCombinator asParser() {
			if (parser == null) {
				parser = new FutureParser();
				parser.setParser(body.asParser());
			}

			return parser;
		}
	}

	public class NamedDefinition extends DelayedDefinition {
		private final String name;
		private Scoped parser = null;

		public NamedDefinition(String name) {
			this.name = name;
		}

		@Override
		public ParserCombinator asParser() {
			if (parser == null) {
				parser = new Scoped(FluentGrammar.this, name, PUBLIC);
				parser.setParser(super.asParser());
			}
			return parser;
		}
	}
}
