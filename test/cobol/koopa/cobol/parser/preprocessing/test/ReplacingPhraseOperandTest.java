package koopa.cobol.parser.preprocessing.test;

import static koopa.cobol.data.tags.SyntacticTag.SEPARATOR;
import static koopa.cobol.parser.preprocessing.ReplacingPhrase.Mode.MATCHING;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.util.test.Util.asTokens;

import java.util.List;

import koopa.cobol.parser.preprocessing.ReplacingPhrase.Mode;
import koopa.cobol.parser.preprocessing.ReplacingPhraseOperand;
import koopa.core.data.Token;
import koopa.core.sources.test.HardcodedSource;

import org.junit.Assert;
import org.junit.Test;

public class ReplacingPhraseOperandTest {

	@Test
	public void canMatchWord() {
		List<Token> tokens = asTokens("COBOL");
		ReplacingPhraseOperand operand = new ReplacingPhraseOperand(
				ReplacingPhraseOperand.Type.WORD, tokens);

		assertMatches(operand, MATCHING, PROGRAM_TEXT_AREA, "COBOL");
		assertMatches(operand, MATCHING, PROGRAM_TEXT_AREA, "cobol");

		assertRejects(operand, MATCHING, "COBOL");
		assertRejects(operand, MATCHING, PROGRAM_TEXT_AREA, "PL/I");
	}

	@Test
	public void canMatchPseudoTextSingleWord() {
		List<Token> tokens = asTokens("==", "COBOL", "==");
		ReplacingPhraseOperand operand = new ReplacingPhraseOperand(
				ReplacingPhraseOperand.Type.PSEUDO, tokens);

		assertMatches(operand, MATCHING, PROGRAM_TEXT_AREA, "COBOL");

		assertRejects(operand, MATCHING, "COBOL");
		assertRejects(operand, MATCHING, PROGRAM_TEXT_AREA, "PL/I");
	}

	@Test
	public void canMatchPseudoTextMultiWord() {
		List<Token> tokens = asTokens("==", "GRACE", "HOPPER", "==");
		ReplacingPhraseOperand operand = new ReplacingPhraseOperand(
				ReplacingPhraseOperand.Type.PSEUDO, tokens);

		assertMatches(operand, MATCHING, PROGRAM_TEXT_AREA, "GRACE",
				PROGRAM_TEXT_AREA, "HOPPER");

		assertRejects(operand, MATCHING, PROGRAM_TEXT_AREA, "GRACE");
		assertRejects(operand, MATCHING, PROGRAM_TEXT_AREA, "HOPPER");
		assertRejects(operand, MATCHING, PROGRAM_TEXT_AREA, "HOPPER",
				PROGRAM_TEXT_AREA, "GRACE");
	}

	@Test
	public void canMatchPseudoTextWithSurroundingSpaces() {
		List<Token> tokens = asTokens("==", SEPARATOR, " ", "GRACE", "HOPPER",
				SEPARATOR, " ", "==");
		ReplacingPhraseOperand operand = new ReplacingPhraseOperand(
				ReplacingPhraseOperand.Type.PSEUDO, tokens);

		assertMatches(operand, MATCHING, PROGRAM_TEXT_AREA, "GRACE",
				PROGRAM_TEXT_AREA, "HOPPER");

		assertRejects(operand, MATCHING, PROGRAM_TEXT_AREA, "GRACE");
		assertRejects(operand, MATCHING, PROGRAM_TEXT_AREA, "HOPPER");
		assertRejects(operand, MATCHING, PROGRAM_TEXT_AREA, "HOPPER",
				PROGRAM_TEXT_AREA, "GRACE");
	}

	@Test
	public void canMatchPseudoTextWithMultiSpaces() {
		List<Token> tokens = asTokens("==", "GRACE", SEPARATOR, " ", SEPARATOR,
				" ", "HOPPER", "==");

		ReplacingPhraseOperand operand = new ReplacingPhraseOperand(
				ReplacingPhraseOperand.Type.PSEUDO, tokens);

		assertMatches(operand, MATCHING, PROGRAM_TEXT_AREA, "GRACE",
				PROGRAM_TEXT_AREA, "HOPPER");
		assertMatches(operand, MATCHING, PROGRAM_TEXT_AREA, "GRACE",
				PROGRAM_TEXT_AREA, SEPARATOR, " ", PROGRAM_TEXT_AREA, "HOPPER");
		assertMatches(operand, MATCHING, PROGRAM_TEXT_AREA, "GRACE",
				PROGRAM_TEXT_AREA, SEPARATOR, " ", PROGRAM_TEXT_AREA,
				SEPARATOR, " ", PROGRAM_TEXT_AREA, "HOPPER");
	}

	// Cfr. #54 COPY-REPLACING statement not interpreted
	@Test
	public void canHandleIssue54() {
		List<Token> tokens = asTokens("==", SEPARATOR, " ", ":", "L", ":",
				SEPARATOR, " ", "==");
		ReplacingPhraseOperand operand = new ReplacingPhraseOperand(
				ReplacingPhraseOperand.Type.PSEUDO, tokens);

		assertMatches(operand, MATCHING, PROGRAM_TEXT_AREA, ":",
				PROGRAM_TEXT_AREA, "L", PROGRAM_TEXT_AREA, ":");
	}

	// ------------------------------------------------------------------------

	private static void assertMatches(ReplacingPhraseOperand operand,
			Mode mode, Object... tagsAndTokens) {
		final HardcodedSource library = HardcodedSource.from(tagsAndTokens);
		Assert.assertTrue(operand.matches(library, mode));
		Assert.assertNull(library.next());
	}

	private static void assertRejects(ReplacingPhraseOperand operand,
			Mode mode, Object... tagsAndTokens) {
		final HardcodedSource library = HardcodedSource.from(tagsAndTokens);

		final Token firstToken = library.next();
		if (firstToken != null)
			library.unshift(firstToken);

		Assert.assertFalse(operand.matches(library, mode));
		Assert.assertSame(firstToken, library.next());
	}
}
