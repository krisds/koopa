package koopa.cobol.grammar.test;

import static koopa.core.data.tags.IslandTag.WATER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.StringReader;

import org.junit.jupiter.api.Test;

import koopa.cobol.CobolProject;
import koopa.cobol.CobolTokens;
import koopa.cobol.projects.BasicCobolProject;
import koopa.cobol.projects.StandardCobolProject;
import koopa.core.data.Token;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.sources.Source;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;

public class CompilerDirectiveRegressionTest {

	private static final String PROGRAM = "" //
			+ "       IDENTIFICATION DIVISION.\n" //
			+ "       PROGRAM-ID. EJECTRG.\n" //
			+ "       DATA DIVISION.\n" //
			+ "       WORKING-STORAGE SECTION.\n" //
			+ "       77  WS-FLAG            PIC X.\n" //
			+ ejectLine() //
			+ "           EXEC SQL INCLUDE SQLCA END-EXEC.\n" //
			+ "       PROCEDURE DIVISION.\n" //
			+ "       P0001.\n" //
			+ "           GOBACK.\n";

	/**
	 * The shape which used to break whole parses: an EJECT statement inside
	 * the WORKING-STORAGE SECTION, with a sequence number in columns 1-6 and
	 * a listing number in columns 73-80.
	 */
	private static String ejectLine() {
		final StringBuilder line = new StringBuilder("001317     EJECT");
		while (line.length() < 72)
			line.append(' ');
		return line.append("00101700\n").toString();
	}

	@Test
	public void ejectDoesNotHideTheSqlcaInclude() throws Exception {
		final File file = new File("EJECTRG.cbl");

		final CobolProject project = new BasicCobolProject();
		final Source source = CobolTokens.getNewSource(file,
				new StringReader(PROGRAM), project);

		final KoopaTreeBuilder builder = new KoopaTreeBuilder(null);
		final Parse parse = Parse.of(source).to(builder);
		final ParserCombinator parser = project.parserFor(file);

		assertTrue(parser.accepts(parse), "the program should parse");

		final Tree ast = builder.getTree();

		int water = 0;
		for (Token token : ast.allTokens())
			if (token.hasTag(WATER))
				water++;
		assertEquals(0, water, "the program should parse with no water");

		assertEquals(1, count(ast, "directive"),
				"the EJECT should be a directive tree");
		assertEquals(1, count(ast, "includeStatement"),
				"the SQLCA include should be seen");
	}

	// Copy regression gaurd
	@Test
	public void copybooksCarryTheirDirectivesToo() throws Exception {
		final String program = "" //
				+ "       IDENTIFICATION DIVISION.\n" //
				+ "       PROGRAM-ID. COPYDIR.\n" //
				+ "       DATA DIVISION.\n" //
				+ "       WORKING-STORAGE SECTION.\n" //
				// ./DIRECT.CPY pulled in
				+ "       COPY DIRECT.\n" //
				+ "       PROCEDURE DIVISION.\n" //
				+ "       P0001.\n" //
				+ "           GOBACK.\n";

		final File file = new File("COPYDIR.cbl");

		final StandardCobolProject project = new StandardCobolProject();
		project.setDefaultPreprocessing(true);
		project.addCopybookPath(new File("test/cobol/koopa/cobol/grammar/test/"));

		final Source source = CobolTokens.getNewSource(file,
				new StringReader(program), project);

		final KoopaTreeBuilder builder = new KoopaTreeBuilder(null);
		final Parse parse = Parse.of(source).to(builder);
		final ParserCombinator parser = project.parserFor(file);

		assertTrue(parser.accepts(parse), "the program should parse");

		final Tree ast = builder.getTree();
		assertEquals(1, count(ast, "directive"),
				"the copybook's EJECT should be a directive tree");
		assertTrue(ast.getProgramText().contains("WS-FROM-COPY"),
				"the copybook's data item should be in the program");
	}

	private static int count(Tree tree, String name) {
		int found = tree.isNode(name) ? 1 : 0;
		for (int i = 0; i < tree.getChildCount(); i++)
			found += count(tree.getChild(i), name);
		return found;
	}
}
