package koopa.cobol.sources.test;

import static koopa.cobol.data.tags.CobolAreaTag.IDENTIFICATION_AREA;
import static koopa.cobol.data.tags.CobolTag.SOURCE_FORMAT_DIRECTIVE;
import static koopa.cobol.data.tags.CobolAreaTag.INDICATOR_AREA;
import static koopa.cobol.data.tags.CobolAreaTag.SEQUENCE_NUMBER_AREA;
import static koopa.core.data.tags.AreaTag.COMPILER_DIRECTIVE;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import koopa.cobol.sources.CompilerDirectives;
import koopa.cobol.sources.ProgramArea;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.Source;
import koopa.core.trees.Tree;
import koopa.core.util.TabStops;

/**
 * The directive placement is the interface between
 * {@linkplain CompilerDirectives} and {@linkplain ProgramArea}:
 * A directive line is transformed to area tokens around a single directive tree.
 */
public class CompilerDirectivesTest {

	private static List<Data> through(SourceFormat format, String text) {
		final LineSplitter lineSplitter //
				= new LineSplitter(new StringReader(text));
		final CompilerDirectives compilerDirectives //
				= new CompilerDirectives(lineSplitter, format);
		final ProgramArea programArea //
				= new ProgramArea(compilerDirectives, 1, new TabStops());

		return drained(programArea);
	}

	private static List<Data> parsedOnly(SourceFormat format, String text) {
		final LineSplitter lineSplitter //
				= new LineSplitter(new StringReader(text));
		final CompilerDirectives compilerDirectives //
				= new CompilerDirectives(lineSplitter, format);

		return drained(compilerDirectives);
	}

	private static List<Data> drained(Source source) {
		final List<Data> stream = new LinkedList<>();
		Data d;
		while ((d = source.next()) != null)
			stream.add(d);
		return stream;
	}

	private static Tree directive(List<Data> stream) {
		Tree found = null;
		for (Data d : stream)
			if (d instanceof Tree) {
				assertNull(found, "expected a single tree");
				found = (Tree) d;
			}
		return found;
	}

	private static Token token(List<Data> stream, int index) {
		return (Token) stream.get(index);
	}

	@Test
	public void sequenceNumberBecomesAnAreaToken() {
		final List<Data> stream = through(SourceFormat.FIXED,
				"000010 CBL LIST,MAP\n");

		final Token sequenceNumber = token(stream, 0);
		assertEquals("000010", sequenceNumber.getText());
		assertTrue(sequenceNumber.hasTag(SEQUENCE_NUMBER_AREA));
		assertFalse(sequenceNumber.hasTag(COMPILER_DIRECTIVE));

		final Token indicator = token(stream, 1);
		assertTrue(indicator.hasTag(INDICATOR_AREA));
		assertFalse(indicator.hasTag(COMPILER_DIRECTIVE));

		final Tree directive = directive(stream);
		assertEquals("CBL LIST,MAP", directive.getAllText());
		assertNull(directive.getDescendant("ibm", "process", "sequenceNumber"));
	}

	@Test
	public void columnOneCardStandsAlone() {
		final List<Data> stream = through(SourceFormat.FIXED,
				"PROCESS OPTIMIZE(0)\n");

		final Tree directive = directive(stream);
		assertEquals(directive, stream.get(0));
		assertEquals("PROCESS OPTIMIZE(0)", directive.getAllText());
		assertEquals("OPTIMIZE(0)", directive.getDescendant( //
				"ibm", "process", "optionsList", "option").getAllText());
	}

	@Test
	public void identificationAreaLeavesTheDirective() {
		final StringBuilder line = new StringBuilder("       EJECT");
		while (line.length() < 72)
			line.append(' ');
		line.append("00101700\n");

		final List<Data> stream = through(SourceFormat.FIXED, line.toString());

		final Tree directive = directive(stream);
		assertEquals("EJECT", directive.getAllText());

		Token identification = null;
		for (Data d : stream)
			if (d instanceof Token && ((Token) d).hasTag(IDENTIFICATION_AREA))
				identification = (Token) d;
		assertEquals("00101700", identification.getText());
		assertFalse(identification.hasTag(PROGRAM_TEXT_AREA));
	}

	@Test
	public void directiveContentIsNoProgramText() {
		final List<Data> stream = through(SourceFormat.FIXED,
				"000010 CBL LIST\n");

		final Tree directive = directive(stream);
		for (Token token : collect(directive)) {
			assertTrue(token.hasTag(COMPILER_DIRECTIVE), token.toString());
			assertFalse(token.hasTag(PROGRAM_TEXT_AREA), token.toString());
		}
	}

	@Test
	public void formatSwitchTagsTheTail() {
		final List<Data> stream = through(SourceFormat.FIXED,
				"       >> source format is free    *> witty remark\n");

		final Tree directive = directive(stream);
		assertEquals(">> source format is free", directive.getAllText());

		final int at = stream.indexOf(directive);
		final Token tail = token(stream, at + 1);
		assertEquals("    *> witty remark", tail.getText());
		assertTrue(tail.hasTag(PROGRAM_TEXT_AREA));
		assertTrue(tail.hasTag(SourceFormat.FREE));

		final Token endOfLine = token(stream, at + 2);
		assertTrue(endOfLine.hasTag(SourceFormat.FREE));
	}

	@Test
	public void indicatorBecomesAnAreaToken() {
		final List<Data> stream = through(SourceFormat.FIXED,
				"      $SET SOURCEFORMAT\"FREE\"\n");

		final Token indicator = token(stream, 1);
		assertEquals("$", indicator.getText());
		assertTrue(indicator.hasTag(INDICATOR_AREA));

		final Tree directive = directive(stream);
		assertEquals("SET SOURCEFORMAT\"FREE\"", directive.getAllText());
		assertNull(directive.getDescendant("mf", "set", "indicator"));
		for (Token token : collect(directive))
			assertTrue(token.hasTag(SOURCE_FORMAT_DIRECTIVE), token.toString());
	}

	@Test
	public void rawDirectiveStillHoldsItsSequenceNumber() {
		final List<Data> stream = parsedOnly(SourceFormat.FIXED,
				"000010 CBL LIST\n");

		final Tree directive = directive(stream);
		assertEquals("000010", directive.getDescendant( //
				"ibm", "process", "sequenceNumber").getAllText());
	}

	@Test
	public void rawRemainderHasNoAreaYet() {
		final StringBuilder line = new StringBuilder("       EJECT");
		while (line.length() < 72)
			line.append(' ');
		line.append("00101700\n");

		final List<Data> stream = parsedOnly(SourceFormat.FIXED,
				line.toString());

		final Tree directive = directive(stream);
		final int at = stream.indexOf(directive);
		final Token remainder = token(stream, at + 1);
		assertTrue(remainder.getText().endsWith("00101700"));
		assertFalse(remainder.hasTag(PROGRAM_TEXT_AREA));
		assertFalse(remainder.hasTag(IDENTIFICATION_AREA));
	}

	@Test
	public void trailingTextMakesItNoDirective() {
		// The grammar bounds a directive at: identification area, an inline comment or line end.
		// Anything else after the directive statement is no directive.
		final List<Data> stream = parsedOnly(SourceFormat.FIXED,
				"       EJECT        CBL LIST\n");

		assertNull(directive(stream));
	}

	@Test
	public void aSetSettingIsNoDirectiveNode() {
		final List<Data> stream = parsedOnly(SourceFormat.FIXED,
				"      $SET LINKCOUNT(64)\n");

		final Tree directive = directive(stream);
		assertEquals("LINKCOUNT(64)", directive.getDescendant( //
				"mf", "set", "setting").getAllText());
		// The directive node is the root and nothing else
		assertNull(directive.getDescendant("mf", "set", "directive"));
	}

	private static List<Token> collect(Tree tree) {
		final List<Token> tokens = new LinkedList<>();
		for (Token token : tree.allTokens())
			tokens.add(token);
		return tokens;
	}
}
