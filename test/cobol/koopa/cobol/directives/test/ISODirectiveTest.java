package koopa.cobol.directives.test;

import static koopa.cobol.sources.SourceFormat.FIXED;
import static koopa.cobol.sources.SourceFormat.FREE;

import java.util.LinkedList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import koopa.cobol.directives.ISODirective;
import koopa.cobol.sources.SourceFormat;

public class ISODirectiveTest extends TestCase {

	private static final List<String> samples = new LinkedList<String>();

	@BeforeClass
	public static void initialize() {
		samples.add("CALL-CONVENTION cobol");
		samples.add("DEFINE");
		samples.add("EVALUATE");
		samples.add("WHEN");
		samples.add("END-EVALUATE");
		samples.add("FLAG-02");
		samples.add("FLAG-85");
		samples.add("FLAG-NATIVE-ARITHMETIC");
		samples.add("IF");
		samples.add("ELSE");
		samples.add("END-IF");
		samples.add("LEAP-SECOND");
		samples.add("LISTING");
		samples.add("PAGE");
		samples.add("PROPAGATE");
		samples.add("SOURCE");
		samples.add("TURN");
	}

	@Test
	public void testMatchesFixed() {
		for (String sample : samples) {
			accepts(FIXED, "       >>" + sample);
			accepts(FIXED, "       >> " + sample);
			accepts(FIXED, "           >> " + sample);

			rejects(FIXED, "      >> " + sample);
			rejects(FIXED, ">> " + sample);
		}
	}

	@Test
	public void testMatchesFree() {
		for (String sample : samples) {
			accepts(FREE, ">> " + sample);
			accepts(FREE, ">>" + sample);
		}
	}

	@Test
	public void testSourceFormatParameter() {
		sourceFormatIs("12456 >> SOURCE FORMAT IS FREE  *> foo", FREE);
		sourceFormatIs("12456 >> SOURCE FORMAT    FREE  *> foo", FREE);
		sourceFormatIs("12456 >> SOURCE        IS FREE  *> foo", FREE);
		sourceFormatIs("12456 >> SOURCE           FREE  *> foo", FREE);

		sourceFormatIs("12456 >> SOURCE FORMAT IS FIXED  *> foo", FIXED);
		sourceFormatIs("12456 >> SOURCE FORMAT    FIXED  *> foo", FIXED);
		sourceFormatIs("12456 >> SOURCE        IS FIXED  *> foo", FIXED);
		sourceFormatIs("12456 >> SOURCE           FIXED  *> foo", FIXED);
	}

	private static void accepts(SourceFormat format, String sample) {
		assertTrue(sample, ISODirective.matches(format, sample));
		assertTrue(sample.toLowerCase(),
				ISODirective.matches(format, sample.toLowerCase()));
		assertTrue(sample.toUpperCase(),
				ISODirective.matches(format, sample.toUpperCase()));
	}

	private static void rejects(SourceFormat format, String sample) {
		assertFalse(sample, ISODirective.matches(format, sample));
		assertFalse(sample.toLowerCase(),
				ISODirective.matches(format, sample.toLowerCase()));
		assertFalse(sample.toUpperCase(),
				ISODirective.matches(format, sample.toUpperCase()));
	}

	private static void sourceFormatIs(String sample, SourceFormat format) {
		assertSame(sample, format, ISODirective.getSourceFormat(sample));
		assertSame(sample.toLowerCase(), format,
				ISODirective.getSourceFormat(sample.toLowerCase()));
		assertSame(sample.toUpperCase(), format,
				ISODirective.getSourceFormat(sample.toUpperCase()));
	}
}
