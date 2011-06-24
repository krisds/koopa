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
		return new FutureParser() {
			protected boolean accepts(TokenStream stream) {
				if (LOGGER.isTraceEnabled()) {
					push(name + " ?");
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

				stream.mark(KoopaMarkers.down(name));
				boolean accepts = parser.accepts(stream);
				stream.mark(KoopaMarkers.up(name));

				scope.pop();

				if (LOGGER.isTraceEnabled()) {
					pop(name + (accepts ? ": yes" : ": no"));
				}
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
				if (LOGGER.isTraceEnabled()) {
					push("[skip>");
				}

				TokenStream sub = new SubordinateTokenStream(stream);

				WaterMarker water = null;
				while (!parser.accepts(sub)) {
					sub.restore();

					if (water == null) {
						water = KoopaMarkers.water();
						sub.mark(water);
					}

					final Token skipped = sub.nextToken();

					sub.commit();

					if (skipped == null) {
						return false;
					}
				}

				sub.restore();
				if (water != null) {
					sub.mark(KoopaMarkers.land());
				}

				if (LOGGER.isTraceEnabled()) {
					pop("<skip]");
				}

				return true;
			}
		};
	}

	protected Parser not(final Parser parser) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				if (LOGGER.isTraceEnabled()) {
					push("[not>");
				}

				TokenStream sub = new SubordinateTokenStream(stream);

				final boolean accepted = parser.accepts(sub);

				sub.restore();

				if (LOGGER.isTraceEnabled()) {
					pop("<not]");
				}

				return !accepted;
			}
		};
	}

	protected Parser star(final Parser parser) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				if (LOGGER.isTraceEnabled()) {
					push("[star>");
				}

				TokenStream sub = new SubordinateTokenStream(stream);

				while (parser.accepts(sub)) {
					sub.commit();
				}

				sub.restore();

				if (LOGGER.isTraceEnabled()) {
					pop("<star]");
				}

				return true;
			}
		};
	}

	protected Parser plus(final Parser parser) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				if (LOGGER.isTraceEnabled()) {
					push("[plus>");
				}

				TokenStream sub = new SubordinateTokenStream(stream);

				if (!parser.accepts(sub)) {
					sub.restore();

					if (LOGGER.isTraceEnabled()) {
						pop("<plus]");
					}

					return false;
				}

				do {
					sub.commit();
				} while (parser.accepts(sub));

				sub.restore();

				if (LOGGER.isTraceEnabled()) {
					pop("<plus]");
				}

				return true;
			}
		};
	}

	protected Parser sequence(final Parser... parsers) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				// if (LOGGER.isTraceEnabled()) {
				// push("[sequence>");
				// }

				for (Parser parser : parsers) {
					if (!parser.accepts(stream)) {
						// if (LOGGER.isTraceEnabled()) {
						// pop("<sequence]");
						// }

						return false;
					}
				}

				// if (LOGGER.isTraceEnabled()) {
				// pop("<sequence]");
				// }

				return true;
			}
		};
	};

	protected Parser choice(final Parser... parsers) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				// if (LOGGER.isTraceEnabled()) {
				// push("[choice>");
				// }

				TokenStream sub = new SubordinateTokenStream(stream);

				for (int i = 0; i < parsers.length; i++) {
					final Parser parser = parsers[i];

					if (parser.accepts(sub)) {
						return true;

					} else {
						if (LOGGER.isTraceEnabled() && i + 1 < parsers.length) {
							trace("or");
						}

						sub.restore();
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
			protected boolean accepts(TokenStream stream) {
				if (LOGGER.isTraceEnabled()) {
					push("[permuted>");
				}

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

				if (LOGGER.isTraceEnabled()) {
					pop("<permuted]");
				}

				return true;
			}
		};
	};

	protected Parser optional(final Parser parser) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				if (LOGGER.isTraceEnabled()) {
					push("[optional>");
				}

				TokenStream sub = new SubordinateTokenStream(stream);

				if (parser.accepts(sub)) {
					sub.commit();

					if (LOGGER.isTraceEnabled()) {
						pop("<optional]");
					}

					return true;

				} else {
					sub.restore();
				}

				if (LOGGER.isTraceEnabled()) {
					pop("<optional]");
				}

				return true;
			}
		};
	}

	protected Parser token(final String text) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				final Token token = stream.nextToken();

				if (token != null && token.getText().equalsIgnoreCase(text)) {

					if (LOGGER.isTraceEnabled()) {
						trace(token + " =~ " + text + " : yes");
					}

					Assign assign = (Assign) scope().get("=");
					if (assign != null) {
						assign.apply(token);
					}

					return true;

				} else {
					if (LOGGER.isTraceEnabled()) {
						trace(token + " =~ " + text + " : no");
					}

					return false;
				}
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
