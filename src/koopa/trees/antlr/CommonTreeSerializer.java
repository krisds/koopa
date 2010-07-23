package koopa.trees.antlr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import koopa.tokens.Position;
import koopa.util.ANTLR;

import org.antlr.runtime.tree.CommonTree;

public class CommonTreeSerializer {

	private static final boolean INCLUDE_POSITIONING;
	static {
		final String property = System.getProperty(
				"koopa.xml.include_positioning", "false");

		boolean includePositioning;
		try {
			includePositioning = Boolean.valueOf(property);

		} catch (Exception e) {
			includePositioning = false;
		}

		INCLUDE_POSITIONING = includePositioning;
	}

	public static void serialize(CommonTree tree, File file) throws IOException {
		Writer writer = new BufferedWriter(new FileWriter(file));
		serialize(tree, writer);
	}

	public static String serialize(CommonTree tree) throws IOException {
		StringWriter writer = new StringWriter();
		serialize(tree, writer);
		return writer.toString();
	}

	public static void serialize(CommonTree tree, Writer writer)
			throws IOException {
		TokenTypes types = new ANTLRTokenTypesLoader()
				.load("/koopa/grammars/cobol/antlr/Cobol.tokens");

		writer.append("<koopa>\n");
		walk(writer, tree, "  ", types);
		writer.append("</koopa>\n");

		writer.flush();
		writer.close();
	}

	private static void walk(Writer writer, CommonTree tree, String dent,
			TokenTypes types) throws IOException {

		final int type = tree.getType();

		if (types.isLiteral(type) || types.isToken(type)) {
			// TODO Should escape stuff where necessary.
			writer.append(dent + "<t><![CDATA[" + tree.getText() + "]]></t>\n");
			return;
		}

		if (tree.getChildCount() == 0) {
			writer.append(dent + "<" + tree.getText());
			writePositions(writer, tree);
			writer.append(" />\n");

		} else {
			writer.append(dent + "<" + tree.getText());
			writePositions(writer, tree);
			writer.append(">\n");

			for (Object child : tree.getChildren()) {
				walk(writer, (CommonTree) child, dent + "  ", types);
			}

			writer.append(dent + "</" + tree.getText() + ">\n");
		}
	}

	private static void writePositions(Writer writer, CommonTree tree)
			throws IOException {

		if (!INCLUDE_POSITIONING) {
			return;
		}

		final Position start = ANTLR.getStart(tree);
		final Position end = ANTLR.getEnd(tree);

		if (start != null) {
			writer.append(" from=\"" + start.getPositionInFile() + "\"");
			writer.append(" from-line=\"" + start.getLinenumber() + "\"");
			writer.append(" from-column=\"" + start.getPositionInLine() + "\"");
		}

		if (end != null) {
			writer.append(" to=\"" + end.getPositionInFile() + "\"");
			writer.append(" to-line=\"" + end.getLinenumber() + "\"");
			writer.append(" to-column=\"" + end.getPositionInLine() + "\"");
		}
	}
}
