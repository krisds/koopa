package koopa.cobol.parser.cobol.preprocessing;

import static koopa.core.trees.jaxen.Jaxen.getMatch;
import static koopa.core.trees.jaxen.Jaxen.getText;
import koopa.core.data.markers.Start;
import koopa.core.treeparsers.Tree;

public class ReplacementInstruction {

	public static enum Mode {
		MATCHING, LEADING, TRAILING;

		public static Mode from(Tree instruction) {
			if (getMatch(instruction, "leading") != null)
				return LEADING;
			else if (getMatch(instruction, "trailing") != null)
				return TRAILING;
			else
				return MATCHING;
		}
	}

	private final Mode mode;
	private final Operand replacing;
	private final Operand by;

	public ReplacementInstruction(Tree instruction) {
		this.mode = Mode.from(instruction);
		this.replacing = new Operand(
				getMatch(instruction, "copyOperandName[1]"));
		this.by = new Operand(getMatch(instruction, "copyOperandName[2]"));
	}

	@Override
	public String toString() {
		return "REPLACING " + mode + " " + replacing + " BY " + by;
	}

	public static class Operand {
		public static enum Type {
			PSEUDO, LITERAL, WORD;

			public static Type from(Tree operand) {
				Tree child = operand.getChild(0);
				Start start = (Start) child.getData();
				final String name = start.getName();

				if ("pseudoLiteral".equals(name))
					return PSEUDO;
				else if ("literal".equals(name))
					return LITERAL;
				else if ("cobolWord".equals(name))
					return WORD;
				else
					return null;
			}
		}

		private final Type type;
		private final String text;

		public Operand(Tree operand) {
			this.type = Type.from(operand);
			this.text = getText(operand, ".//text()");
		}

		@Override
		public String toString() {
			return type + ":" + text;
		}
	}
}
