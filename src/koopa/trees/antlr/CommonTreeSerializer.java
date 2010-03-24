package koopa.trees.antlr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.antlr.runtime.tree.CommonTree;

public class CommonTreeSerializer {
	public static void serialize(CommonTree tree, File file) throws IOException {
		TokenTypes types = new ANTLRTokenTypesLoader()
				.load("/koopa/grammars/cobol/antlr/Cobol.tokens");

		Writer writer = new BufferedWriter(new FileWriter(file));

		walk(writer, tree, "  ", types);

		writer.flush();
		writer.close();
	}

	private static void walk(Writer writer, CommonTree tree, String dent,
			TokenTypes types) throws IOException {

		final int type = tree.getType();

		if (types.isLiteral(type) || types.isToken(type)) {
			// TODO Should escape stuff where necessary.
			writer.append(dent + "<![CDATA[" + tree.getText() + "]]>\n");
			return;
		}

		if (tree.getChildCount() == 0) {
			writer.append(dent + "<" + tree.getText() + " />\n");

		} else {
			writer.append(dent + "<" + tree.getText() + ">\n");

			for (Object child : tree.getChildren()) {
				walk(writer, (CommonTree) child, dent + "  ", types);
			}

			writer.append(dent + "</" + tree.getText() + ">\n");
		}
	}
}
