package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from SpecialNamesParagraph.stage. */
public class SpecialNamesParagraphTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testSpecialNamesParagraph_1() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     CALL-CONVENTION 74 IS winapi . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_2() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     CONSOLE CRT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_3() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     CONSOLE IS CRT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_4() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     SYSIN IS foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_5() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     CONSOLE IS foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_6() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     SWITCH-0 IS foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_7() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     SWITCH-0 IS foo\n        ON STATUS IS bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_8() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     SWITCH-0 IS foo\n        OFF STATUS IS bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_9() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     SWITCH-0 IS foo\n        ON STATUS IS bar\n        OFF STATUS IS baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_10() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     C01 IS foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_11() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     S01 IS foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_12() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     ALPHABET foo IS NATIVE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_13() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     ALPHABET foo IS STANDARD-1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_14() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     ALPHABET foo IS EBCDIC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_15() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     ALPHABET foo IS \"f\" THROUGH \"o\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_16() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     ALPHABET foo IS \"f\" THROUGH \"o\" ALSO \"b\" ALSO \"a\" ALSO \"z\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_17() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     CLASS foo IS \"f\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_18() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     CLASS foo IS \"f\" THROUGH \"o\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_19() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     CLASS Hexadecimal IS \"0\" THRU \"9\", \"A\" THRU \"F\", \"a\" THRU \"f\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_20() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     LOCALE foo IS bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_21() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     CURRENCY \"$\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_22() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     CURRENCY SIGN \"$\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_23() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     CURRENCY SIGN IS \"$\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_24() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     DECIMAL-POINT COMMA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_25() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     DECIMAL-POINT IS COMMA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_26() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     CURSOR IS foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_27() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     CRT STATUS IS foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_28() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     SCREEN CONTROL IS foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_29() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     EVENT STATUS IS foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_30() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     SYMBOLIC CHARACTERS \"a\" IS 1 IN foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_31() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     SYMBOLIC CHARACTERS \"a\" \"b\" ARE 1 2 IN foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_32() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     NUMERIC SIGN IS TRAILING SEPARATE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_33() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     XML-SCHEMA foo IS \"foo\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_34() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     XML-SCHEMA foo IS \"foo\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_35() {
      Parser parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SPECIAL-NAMES.\n     XML-SCHEMA foo IS bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}