package koopa.parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import koopa.parsers.markers.WaterMarker;
import koopa.tokens.Token;
import koopa.tokenstreams.TokenStream;
import koopa.tokenstreams.generic.SubordinateTokenStream;
import koopa.util.Tuple;

import org.apache.log4j.Logger;

public abstract class KoopaGrammar {

	private static final Logger LOGGER = Logger.getLogger("grammar");

	// The dictionary will have to get pushed and popped as we enter/leave
	// certain parsers. Otherwise, recursion will screw up the lexical scopes.
	final Stack<Map<String, Object>> scope = new Stack<Map<String, Object>>();

	private List<Tuple<Token, String>> warnings = new LinkedList<Tuple<Token, String>>();

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

	protected FutureParser scoped(final String name) {
		return new FutureParser() {
			protected boolean accepts(TokenStream stream) {
				LOGGER.trace("Enter " + name);

				Assign assign = null;

				if (scope.size() > 0) {
					// Get the "lvalue".
					assign = (Assign) scope.peek().get("=");
				}

				Map<String, Object> newScope = new HashMap<String, Object>();
				// Push the "lvalue" as the return target.
				newScope.put("return", assign);

				scope.push(newScope);

				stream.mark(KoopaMarkers.down(name));
				boolean accepts = parser.accepts(stream);
				stream.mark(KoopaMarkers.up(name));

				scope.pop();

				LOGGER.trace((accepts ? "Exit " : "Fail ") + name);

				return accepts;
			}
		};
	}

	protected Parser assign(final String name, final Parser parser) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				scope().put("=", new Assign(scope(), name));
				boolean accepts = parser.accepts(stream);
				scope().remove("=");
				return accepts;
			}
		};
	}

	protected Parser returning(final String name) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
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
			protected boolean accepts(TokenStream stream) {
				func.apply();
				return true;
			}
		};
	}

	protected Parser skipto(final Parser parser) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				LOGGER.trace("[skip>");

				TokenStream sub = new SubordinateTokenStream(stream);

				WaterMarker water = null;
				while (!parser.accepts(sub)) {
					sub.restore();

					if (water == null) {
						water = KoopaMarkers.water();
						sub.mark(water);
					}

					Token skipped = sub.nextToken();
					// System.out.println("Skipping token " + skipped);

					if (water.getToken() == null) {
						water.setToken(skipped);
					}

					sub.commit();

					if (skipped == null)
						return false;
				}

				sub.restore();
				if (water != null) {
					sub.mark(KoopaMarkers.land());
				}

				LOGGER.trace("<skip]");

				return true;
			}
		};
	}

	protected Parser star(final Parser parser) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				LOGGER.trace("[star>");

				TokenStream sub = new SubordinateTokenStream(stream);

				while (parser.accepts(sub)) {
					sub.commit();
				}

				sub.restore();

				LOGGER.trace("<star]");

				return true;
			}
		};
	}

	protected Parser plus(final Parser parser) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				LOGGER.trace("[plus>");

				TokenStream sub = new SubordinateTokenStream(stream);

				if (!parser.accepts(sub)) {
					sub.restore();

					LOGGER.trace("<plus]");

					return false;
				}

				do {
					sub.commit();
				} while (parser.accepts(sub));

				sub.restore();

				LOGGER.trace("<plus]");

				return true;
			}
		};
	}

	protected Parser sequence(final Parser... parsers) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				LOGGER.trace("[sequence>");

				for (Parser parser : parsers) {
					if (!parser.accepts(stream)) {
						return false;
					}
				}

				LOGGER.trace("<sequence]");

				return true;
			}
		};
	};

	protected Parser choice(final Parser... parsers) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				LOGGER.trace("[choice>");

				TokenStream sub = new SubordinateTokenStream(stream);

				for (Parser parser : parsers) {
					if (parser.accepts(sub)) {
						LOGGER.trace("<choice]");

						return true;
					}
					sub.restore();
				}

				LOGGER.trace("<choice]");

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
			protected boolean accepts(TokenStream stream) {
				LOGGER.trace("[permuted>");

				List<Parser> remaining = new ArrayList<Parser>(choices);
				TokenStream sub = new SubordinateTokenStream(stream);

				int i = 0;
				while (i < remaining.size()) {
					if (remaining.get(i).accepts(sub)) {
						sub.commit();
						remaining.remove(i);
						i = 0;

					} else {
						sub.restore();
						i++;
					}
				}

				LOGGER.trace("<permuted]");

				return true;
			}
		};
	};

	protected Parser optional(final Parser parser) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				LOGGER.trace("[optional>");

				TokenStream sub = new SubordinateTokenStream(stream);

				if (parser.accepts(sub)) {
					sub.commit();

					LOGGER.trace("<optional]");

					return true;

				} else {
					sub.restore();
				}

				LOGGER.trace("<optional]");

				return true;
			}
		};
	}

	protected Parser token(final String text) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				final Token token = stream.nextToken();

				LOGGER.trace(token + " =~ " + text + " ?");

				if (token != null && token.getText().equalsIgnoreCase(text)) {

					Assign assign = (Assign) scope().get("=");
					if (assign != null) {
						assign.apply(token);
					}

					return true;

				} else
					return false;
			}
		};
	}

	protected void returnToken(Token token) {
		Assign assign = (Assign) scope().get("return");
		if (assign != null) {
			assign.apply(token);
		}
	}
}
