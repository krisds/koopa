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
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.sources.Source;
import koopa.core.targets.ListTarget;


public class EmbeddedSqlBalancerRegressionTest {

	private static final String PROGRAM = "" //
			+ "       IDENTIFICATION DIVISION.\n" //
			+ "       PROGRAM-ID. BALREG.\n" //
			+ "       DATA DIVISION.\n" //
			+ "       WORKING-STORAGE SECTION.\n" //
			+ "       01  WS-DUMMY           PIC X.\n" //
			+ "       PROCEDURE DIVISION.\n" //
			+ "       P0001.\n" //
			+ "           EXEC SQL\n" //
			+ "               SELECT A INTO :C FROM T\n" //
			+ "                WHERE X NOT IN\n" //
			+ "                      (\n" //
			+ "                        SELECT Y FROM T2\n" //
			+ "                      )\n" //
			+ "                ORDER BY A\n" //
			+ "           END-EXEC\n" //
			+ "           CONTINUE.\n" //
			+ "           GOBACK.\n";

	@Test
	public void testSubqueryWhereThenOrderByLeavesNoWater()
			throws Exception {
		final File file = new File("BALREG.cbl");
		final CobolProject project = new BasicCobolProject();

		final Source source = CobolTokens.getNewSource(file, //
								new StringReader(PROGRAM), project);

		final ListTarget data = new ListTarget();
		final Parse parse = Parse.of(source).to(data);
		final ParserCombinator parser = project.parserFor(file);

		assertTrue(parser.accepts(parse), "the program should parse");

		int water = 0;
		for (Data d : data)
			if (d instanceof Token && ((Token) d).hasTag(WATER))
				water++;

		// Broken engine leaves the WHERE's subquery and the ORDER BY after
		// it as water (27 tokens in this program); the fix clears it.
		assertEquals(0, water,
				"the embedded SELECT should parse with no water");
	}
}
