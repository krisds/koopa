package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class SubtractStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testSubtraction_format1_1() {
      Parser parser = grammar.subtraction_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CORRESPONDING", "A", "FROM", 
        "B");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format1_2() {
      Parser parser = grammar.subtraction_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CORR", "A", "FROM", "B");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format1_3() {
      Parser parser = grammar.subtraction_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CORRESPONDING", "A", "FROM", 
        "B", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format1_4() {
      Parser parser = grammar.subtraction_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CORR", "A", "FROM", "B", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format2_5() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "FROM", "B", "GIVING", "C");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format2_6() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "FROM", "B", "GIVING", "C", 
        "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format2_7() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "FROM", "C", "GIVING", 
        "D", "E");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format2_8() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "FROM", "C", "GIVING", 
        "D", "ROUNDED", "E", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format2_9() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "GIVING", "C");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format2_10() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "GIVING", "C", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format2_11() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "C", "GIVING", "D", 
        "E");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format2_12() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "C", "GIVING", "D", 
        "ROUNDED", "E", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format2_13() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "FROM", "B", "GIVING", 
        "C");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format2_14() {
      Parser parser = grammar.subtraction_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "FROM", "ZERO", "GIVING", 
        "C");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format3_15() {
      Parser parser = grammar.subtraction_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "FROM", "B");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format3_16() {
      Parser parser = grammar.subtraction_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "FROM", "B", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format3_17() {
      Parser parser = grammar.subtraction_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "FROM", "C", "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format3_18() {
      Parser parser = grammar.subtraction_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "FROM", "C", "ROUNDED", 
        "D", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtraction_format3_19() {
      Parser parser = grammar.subtraction_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "ZERO", "FROM", "C", "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_20() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_21() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_22() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_23() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_24() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_25() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_26() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "NOT", "ON", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_27() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", "NOT", "ON", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_28() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "NOT", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_29() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", "NOT", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_30() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", "ERROR", 
        "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(15, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_31() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", 
        "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(17, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_32() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", "ERROR", 
        "DISPLAY", "\"AOK\"", "END-SUBTRACT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(16, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_33() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", 
        "SIZE", "ERROR", "DISPLAY", "\"AOK\"", "END-SUBTRACT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(18, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_34() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "END-SUBTRACT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_35() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", "END-SUBTRACT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }
}