package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from SubtractStatement.stage. */
public class SubtractStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testSubtraction_format1_1() {
      Parser parser = grammar.subtraction_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CORRESPONDING A FROM B");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format1_2() {
      Parser parser = grammar.subtraction_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CORR A FROM B");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format1_3() {
      Parser parser = grammar.subtraction_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CORRESPONDING A FROM B ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format1_4() {
      Parser parser = grammar.subtraction_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CORR A FROM B ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_5() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A FROM B GIVING C");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_6() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A FROM B GIVING C ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_7() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A B FROM C GIVING D E");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_8() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A B FROM C GIVING D ROUNDED E ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_9() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A B GIVING C");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_10() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A B GIVING C ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_11() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A B C GIVING D E");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_12() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A B C GIVING D ROUNDED E ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_13() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO FROM B GIVING C");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format2_14() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A FROM ZERO GIVING C");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format3_15() {
      Parser parser = grammar.subtraction_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A FROM B");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format3_16() {
      Parser parser = grammar.subtraction_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A FROM B ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format3_17() {
      Parser parser = grammar.subtraction_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A B FROM C D");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format3_18() {
      Parser parser = grammar.subtraction_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A B FROM C ROUNDED D ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtraction_format3_19() {
      Parser parser = grammar.subtraction_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A ZERO FROM C D");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_20() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B  KOOPAH_TO_HERE  .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_21() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B GIVING C  KOOPAH_TO_HERE  .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_22() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_23() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B GIVING C\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_24() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B\n     SIZE ERROR\n        DISPLAY \"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_25() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B GIVING C\n     SIZE ERROR\n        DISPLAY \"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_26() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_27() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B GIVING C\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_28() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B\n     NOT SIZE ERROR\n        DISPLAY \"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_29() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B GIVING C\n     NOT SIZE ERROR\n        DISPLAY \"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_30() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_31() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B GIVING C\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_32() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\"\n   END-SUBTRACT");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_33() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B GIVING C\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\"\n   END-SUBTRACT");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_34() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B\n   END-SUBTRACT");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSubtractStatement_35() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT A FROM B GIVING C\n   END-SUBTRACT");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}