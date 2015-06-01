package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from SpecialNamesParagraph.stage. */
public class SpecialNamesParagraphTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testSpecialNamesParagraph_1() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     CALL-CONVENTION 74 IS winapi . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_2() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     CONSOLE CRT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_3() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     CONSOLE IS CRT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_4() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     SYSIN IS foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_5() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     CONSOLE IS foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_6() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     SWITCH-0 IS foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_7() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     SWITCH-0 IS foo\n        ON STATUS IS bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_8() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     SWITCH-0 IS foo\n        OFF STATUS IS bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_9() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     SWITCH-0 IS foo\n        ON STATUS IS bar\n        OFF STATUS IS baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_10() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     C01 IS foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_11() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     S01 IS foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_12() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     ALPHABET foo IS NATIVE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_13() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     ALPHABET foo IS STANDARD-1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_14() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     ALPHABET foo IS EBCDIC "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_15() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     ALPHABET foo IS \"f\" THROUGH \"o\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_16() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     ALPHABET foo IS \"f\" THROUGH \"o\" ALSO \"b\" ALSO \"a\" ALSO \"z\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_17() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     CLASS foo IS \"f\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_18() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     CLASS foo IS \"f\" THROUGH \"o\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_19() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     CLASS Hexadecimal IS \"0\" THRU \"9\", \"A\" THRU \"F\", \"a\" THRU \"f\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_20() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     LOCALE foo IS bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_21() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     CURRENCY \"$\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_22() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     CURRENCY SIGN \"$\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_23() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     CURRENCY SIGN IS \"$\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_24() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     DECIMAL-POINT COMMA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_25() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     DECIMAL-POINT IS COMMA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_26() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     CURSOR IS foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_27() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     CRT STATUS IS foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_28() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     SCREEN CONTROL IS foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_29() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     EVENT STATUS IS foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_30() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     SYMBOLIC CHARACTERS \"a\" IS 1 IN foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_31() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     SYMBOLIC CHARACTERS \"a\" \"b\" ARE 1 2 IN foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_32() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     NUMERIC SIGN IS TRAILING SEPARATE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_33() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     XML-SCHEMA foo IS \"foo\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_34() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     XML-SCHEMA foo IS \"foo\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpecialNamesParagraph_35() {
      ParserCombinator parser = grammar.specialNamesParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES.\n     XML-SCHEMA foo IS bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}