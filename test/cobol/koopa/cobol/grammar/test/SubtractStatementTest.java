package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from SubtractStatement.stage. */
public class SubtractStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testSubtraction_format1_1() {
      ParserCombinator parser = grammar.subtraction_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CORRESPONDING A FROM B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format1_2() {
      ParserCombinator parser = grammar.subtraction_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CORR A FROM B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format1_3() {
      ParserCombinator parser = grammar.subtraction_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CORRESPONDING A FROM B ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format1_4() {
      ParserCombinator parser = grammar.subtraction_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CORR A FROM B ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_5() {
      ParserCombinator parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A FROM B GIVING C "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_6() {
      ParserCombinator parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A FROM B GIVING C ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_7() {
      ParserCombinator parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A B FROM C GIVING D E "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_8() {
      ParserCombinator parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A B FROM C GIVING D ROUNDED E ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_9() {
      ParserCombinator parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A B GIVING C "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_10() {
      ParserCombinator parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A B GIVING C ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_11() {
      ParserCombinator parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A B C GIVING D E "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_12() {
      ParserCombinator parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A B C GIVING D ROUNDED E ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_13() {
      ParserCombinator parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO FROM B GIVING C "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_14() {
      ParserCombinator parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A FROM ZERO GIVING C "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format3_15() {
      ParserCombinator parser = grammar.subtraction_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A FROM B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format3_16() {
      ParserCombinator parser = grammar.subtraction_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A FROM B ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format3_17() {
      ParserCombinator parser = grammar.subtraction_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A B FROM C D "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format3_18() {
      ParserCombinator parser = grammar.subtraction_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A B FROM C ROUNDED D ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format3_19() {
      ParserCombinator parser = grammar.subtraction_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A ZERO FROM C D "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_20() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_21() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B GIVING C # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_22() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B\n     ON SIZE ERROR\n        DISPLAY \"OOPS\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_23() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B GIVING C\n     ON SIZE ERROR\n        DISPLAY \"OOPS\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_24() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B\n     SIZE ERROR\n        DISPLAY \"OOPS\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_25() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B GIVING C\n     SIZE ERROR\n        DISPLAY \"OOPS\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_26() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_27() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B GIVING C\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_28() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B\n     NOT SIZE ERROR\n        DISPLAY \"AOK\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_29() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B GIVING C\n     NOT SIZE ERROR\n        DISPLAY \"AOK\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_30() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_31() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B GIVING C\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_32() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\"\n   END-SUBTRACT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_33() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B GIVING C\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\"\n   END-SUBTRACT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_34() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B\n   END-SUBTRACT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_35() {
      ParserCombinator parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SUBTRACT A FROM B GIVING C\n   END-SUBTRACT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}