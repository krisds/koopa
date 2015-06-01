package koopa.core.treegrammars;

import java.util.ArrayList;
import java.util.List;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.grammars.combinators.Opt;
import koopa.core.parsers.combinators.Block;
import koopa.core.treeparsers.FutureTreeParser;
import koopa.core.treeparsers.LimitedTreeStream;
import koopa.core.treeparsers.Tree;
import koopa.core.treeparsers.TreeParser;
import koopa.core.treeparsers.TreeStream;

import org.apache.log4j.Logger;

// TODO Much of this is Copy/Paste of code in KoopaGrammar.
public class TreeGrammar {

	protected static final Logger LOGGER = Logger.getLogger("treegrammar");

	protected final ParsingContext scope = new ParsingContext();

	private boolean noskip = false;

	protected Tree getCurrentTree() {
		return (Tree) scope.getReference();
	}

	public TreeParser token(final String text) {
		return new TreeParser() {
			public boolean accepts(TreeStream stream) {
				while (true) {
					Data data = stream.forward();

					if (data == null) {
						if (LOGGER.isTraceEnabled())
							trace(text + " =~ <END OF (SUB)TREE> : no");
						return false;
					}

					if (!(data instanceof Token)) {
						if (noskip) {
							if (LOGGER.isTraceEnabled())
								trace("not a token: " + data + "; not skipping");

							return false;
						}

						continue;
					}

					Token token = (Token) data;

					if (text.equalsIgnoreCase(token.getText())) {
						if (LOGGER.isTraceEnabled())
							trace(text + " =~ " + token + " : yes");

						// assignIfNeeded(stream.getTree());
						scope.assignLValue(stream.getTree());

						return true;
					}

					if (noskip) {
						if (LOGGER.isTraceEnabled())
							trace(text + " =~ " + token + " : no; not skipping");

						return false;
					}

					if (LOGGER.isTraceEnabled())
						trace(text + " =~ " + token + " : no; skipping");
				}
			}
		};
	}

	public FutureTreeParser scoped(final String name) {
		return new FutureTreeParser() {
			public boolean accepts(TreeStream stream) {
				while (true) {
					Data data = stream.forward();

					if (data == null) {
						if (LOGGER.isTraceEnabled())
							trace("SCOPED <" + name + "> at end of stream");
						return false;
					}

					if (!(data instanceof Start)) {
						if (noskip) {
							if (LOGGER.isTraceEnabled())
								trace("not a node: " + data + "; not skipping");

							return false;
						}

						continue;
					}

					Start start = (Start) data;

					if (name.equalsIgnoreCase(start.getName())) {
						if (parser == null) {
							if (LOGGER.isTraceEnabled())
								push("SCOPED <" + name
										+ "> : yes (unconditional)");

							return true;
						}

						TreeStream substream = stream.forSubtree();
						if (LOGGER.isTraceEnabled())
							push("SCOPED <" + name + "> scoping to " + start
									+ " : ...");

						Tree subTree = stream.getTree();
						scope.enter(name, subTree);
						// By default a grammar rule returns the root of the
						// subtree matching it.
						scope.setReturnValue(subTree);

						final boolean accepts = parser.accepts(substream);

						if (LOGGER.isTraceEnabled())
							pop("SCOPED <" + name + "> accepts "
									+ start.getName() + " : "
									+ (accepts ? "yes" : "no"));

						if (accepts)
							substream.commitSubtree();
						else
							substream.rewindSubtree();

						scope.leave(name);

						return accepts;
					}

					if (noskip) {
						if (LOGGER.isTraceEnabled())
							trace("SCOPED <" + name + "> matches " + start
									+ " : no; not skipping");

						return false;
					}

					if (LOGGER.isTraceEnabled())
						trace("SCOPED <" + name + "> matches " + start
								+ " : no; skipping");
				}
			}
		};
	}

	public TreeParser optional(final TreeParser parser) {
		return new TreeParser() {
			public boolean accepts(TreeStream stream) {
				if (LOGGER.isTraceEnabled())
					push("[optional>");

				stream.bookmark();

				boolean accepts = parser.accepts(stream);

				if (accepts)
					stream.commit();
				else
					stream.rewind();

				if (LOGGER.isTraceEnabled())
					pop("<optional]: " + accepts);

				return true;
			}
		};
	}

	public TreeParser sequence(final TreeParser... parsers) {
		return new TreeParser() {
			public boolean accepts(TreeStream stream) {
				for (TreeParser parser : parsers)
					if (!parser.accepts(stream))
						return false;

				return true;
			}
		};
	};

	public TreeParser choice(final TreeParser... parsers) {
		return new TreeParser() {
			public boolean accepts(TreeStream stream) {
				// if (LOGGER.isTraceEnabled()) {
				// push("[choice>");
				// }

				for (int i = 0; i < parsers.length; i++) {
					final TreeParser parser = parsers[i];

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

	public TreeParser star(final TreeParser parser) {
		return new TreeParser() {
			public boolean accepts(TreeStream stream) {
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

	public TreeParser plus(final TreeParser parser) {
		return new TreeParser() {
			public boolean accepts(TreeStream stream) {
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

	public TreeParser not(final TreeParser parser) {
		return new TreeParser() {
			public boolean accepts(TreeStream stream) {
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

	public TreeParser permuted(final TreeParser... parsers) {
		final List<TreeParser> choices = new ArrayList<TreeParser>(
				parsers.length);
		for (TreeParser parser : parsers) {
			choices.add(parser);
		}

		return new TreeParser() {
			public boolean accepts(TreeStream stream) {
				if (LOGGER.isTraceEnabled())
					push("[permuted>");

				List<TreeParser> remaining = new ArrayList<TreeParser>(choices);

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

	public TreeParser any() {
		return new TreeParser() {
			public boolean accepts(TreeStream stream) {
				final Data data = stream.forward();

				if (data != null) {
					if (LOGGER.isTraceEnabled())
						trace(data + " != null : yes");

					// assignIfNeeded(stream.getTree());
					scope.assignLValue(stream.getTree());

					return true;

				} else {
					if (LOGGER.isTraceEnabled())
						trace(data + " != null : no");

					return false;
				}
			}
		};
	}

	/**
	 * Skipping is the basics of tree parsers, so it pretty much comes for free.
	 */
	public TreeParser skipto(final TreeParser parser) {
		return new TreeParser() {
			public boolean accepts(TreeStream stream) {
				if (LOGGER.isTraceEnabled())
					push("[skipto>");

				boolean accepts = parser.accepts(stream);

				if (LOGGER.isTraceEnabled())
					pop("<skipto]: " + (accepts ? "yes" : "no"));

				return accepts;
			}
		};
	}

	public TreeParser apply(final Block func) {
		return new TreeParser() {
			public boolean accepts(TreeStream stream) {
				// TODO Tree parsers will need a variation on Block.
				func.apply(null);
				return true;
			}
		};
	}

	public TreeParser assign(final String name, final TreeParser parser) {
		return new TreeParser() {
			public boolean accepts(TreeStream stream) {
				scope.setLValueReceiver(name);
				// scope().put("=", new Assign(scope(), name));
				boolean accepts = parser.accepts(stream);
				// scope().remove("=");
				return accepts;
			}
		};
	}

	public TreeParser returning(final String name) {
		return new TreeParser() {
			public boolean accepts(TreeStream stream) {
				scope.setReturnValueFrom(name);
				return true;
			}
		};
	}

	public TreeParser limited(final TreeParser target, final TreeParser limiter) {
		return new TreeParser() {
			public boolean accepts(TreeStream stream) {
				return target.accepts(new LimitedTreeStream(stream, limiter));
			}
		};
	}

	public TreeParser opt(final Opt opt, final TreeParser parser) {
		return new TreeParser() {
			public boolean accepts(TreeStream stream) {
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
		};
	}

	// ------------------------------------------------------------------------

	private int depth = 0;

	private String indent() {
		String s = "";
		for (int i = 0; i < depth; i++)
			s += "  ";
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
}
