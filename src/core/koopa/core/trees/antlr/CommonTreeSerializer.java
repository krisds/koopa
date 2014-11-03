package koopa.core.trees.antlr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import koopa.core.data.Position;
import koopa.core.util.ANTLR;

import org.antlr.runtime.tree.CommonTree;
import org.apache.log4j.Logger;

public class CommonTreeSerializer {

	protected static final Logger LOGGER = Logger.getLogger("to_xml");

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
		// UTF-8 is the default encoding for documents without prolog
		// See http://www.w3.org/TR/REC-xml/#charencoding
		// So it's necessary to add the XML declaration to ensure readability (if UTF-8 isn't used)
		// Usually ISO-8859-1, Windows-1252, and ASCII is also recognized
		// FileWriter uses default encoding, which might not be appropriate
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
		serialize(tree, writer);
	}

	public static String serialize(CommonTree tree) throws IOException {
		StringWriter writer = new StringWriter();
		serialize(tree, writer);
		return writer.toString();
	}

	public static void serialize(CommonTree tree, Writer writer)
			throws IOException {
		TokenTypes types = ANTLRTokenTypesLoader
				.load("/koopa/cobol/grammar/antlr/Cobol.tokens");

		writer.append("<?xml version='1.0' encoding='UTF-8'?>\n"); // XML prolog/declaration
		
		writer.append("<koopa>\n");
		walk(writer, tree, "  ", types);
		writer.append("</koopa>\n");

		writer.flush();
		writer.close();
	}

	private static void walk(Writer writer, CommonTree tree, String dent,
			TokenTypes types) throws IOException {

		final int type = tree.getType();

		LOGGER.trace(tree.getText());
		
		if (type == types.forType("COMMENT")) {
			// TODO Should escape stuff where necessary.
			// According to http://www.w3.org/TR/REC-xml/#dt-comment -- is not allowed
			// Reading comments with double-hyphen will fail in compliant XML parsers
			// For convenience '--' is replaced by '-_'. Otherwise, we'd have to throw an error
			writer.append(dent + "<!-- " + tree.getText().replaceAll("--", "-_") + " -->\n");
			return;
		}

		if (types.isLiteral(type) || types.isToken(type)) {
			// TODO Should escape stuff where necessary.
			// A command like DISPLAY ']]>' would generate invalid XML without substitution
			writer.append(dent + "<t><![CDATA[" + tree.getText().replaceAll("]]>", "]]]]><![CDATA[>") + "]]></t>\n");
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
