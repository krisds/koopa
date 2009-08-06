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


public abstract class KoopaGrammar {
	// The dictionary will have to get pushed and popped as we enter/leave
	// certain parsers. Otherwise, recursion will screw up the lexical scopes.
	final Stack<Map<String, Object>> scope = new Stack<Map<String, Object>>();

	private List<Tuple<Token, String>> warnings = new LinkedList<Tuple<Token, String>>();

	protected final static boolean DEBUG_MODE = false;
	private static final int LOD = 1;

	public KoopaGrammar() {
	}

	protected final static void log(String msg, int lod) {
		if (lod <= LOD) {
			System.err.println(msg);
		}
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
				if (DEBUG_MODE) {
					log("Enter " + name, 1);
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

				if (DEBUG_MODE) {
					log((accepts ? "Exit " : "Fail ") + name, 1);
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
				if (DEBUG_MODE) {
					log("[skip>", 1);
				}

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

				if (DEBUG_MODE) {
					log("<skip]", 1);
				}

				return true;
			}
		};
	}

	protected Parser star(final Parser parser) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				if (DEBUG_MODE) {
					log("[star>", 2);
				}

				TokenStream sub = new SubordinateTokenStream(stream);

				while (parser.accepts(sub)) {
					sub.commit();
				}

				sub.restore();

				if (DEBUG_MODE) {
					log("<star]", 2);
				}

				return true;
			}
		};
	}

	protected Parser plus(final Parser parser) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				if (DEBUG_MODE) {
					log("[plus>", 2);
				}

				TokenStream sub = new SubordinateTokenStream(stream);

				if (!parser.accepts(sub)) {
					sub.restore();

					if (DEBUG_MODE) {
						log("<plus]", 2);
					}

					return false;
				}

				do {
					sub.commit();
				} while (parser.accepts(sub));

				sub.restore();

				if (DEBUG_MODE) {
					log("<plus]", 2);
				}

				return true;
			}
		};
	}

	protected Parser sequence(final Parser... parsers) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				if (DEBUG_MODE) {
					log("[sequence>", 2);
				}

				for (Parser parser : parsers) {
					if (!parser.accepts(stream))
						return false;
				}

				if (DEBUG_MODE) {
					log("<sequence]", 2);
				}

				return true;
			}
		};
	};

	protected Parser choice(final Parser... parsers) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				if (DEBUG_MODE) {
					log("[choice>", 2);
				}

				TokenStream sub = new SubordinateTokenStream(stream);

				for (Parser parser : parsers) {
					if (parser.accepts(sub)) {
						if (DEBUG_MODE) {
							log("<choice]", 2);
						}

						return true;
					}
					sub.restore();
				}

				if (DEBUG_MODE) {
					log("<choice]", 2);
				}

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
				if (DEBUG_MODE) {
					log("[permuted>", 2);
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

				if (DEBUG_MODE) {
					log("<permuted]", 2);
				}

				return true;
			}
		};
	};

	protected Parser optional(final Parser parser) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				if (DEBUG_MODE) {
					log("[optional>", 2);
				}

				TokenStream sub = new SubordinateTokenStream(stream);

				if (parser.accepts(sub)) {
					sub.commit();

					if (DEBUG_MODE) {
						log("<optional]", 2);
					}

					return true;

				} else {
					sub.restore();
				}

				if (DEBUG_MODE) {
					log("<optional]", 2);
				}

				return true;
			}
		};
	}

	protected Parser token(final String text) {
		return new Parser() {
			protected boolean accepts(TokenStream stream) {
				final Token token = stream.nextToken();

				if (DEBUG_MODE) {
					log(token + " =~ " + text + " ?", 1);
				}

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
