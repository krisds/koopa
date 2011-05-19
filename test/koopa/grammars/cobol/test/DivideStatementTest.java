package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class DivideStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testDivision_format1_1() {
      Parser parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "INTO", "B", "GIVING", "C", 
        "REMAINDER", "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format1_2() {
      Parser parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "INTO", "B", "GIVING", "C", 
        "ROUNDED", "REMAINDER", "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format1_3() {
      Parser parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "BY", "B", "GIVING", "C", 
        "REMAINDER", "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format1_4() {
      Parser parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "BY", "B", "GIVING", "C", 
        "ROUNDED", "REMAINDER", "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format1_5() {
      Parser parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "INTO", "2", "GIVING", 
        "C", "REMAINDER", "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format1_6() {
      Parser parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "INTO", "2", "GIVING", 
        "C", "ROUNDED", "REMAINDER", "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format1_7() {
      Parser parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "BY", "2", "GIVING", "C", 
        "REMAINDER", "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format1_8() {
      Parser parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "BY", "2", "GIVING", "C", 
        "ROUNDED", "REMAINDER", "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_9() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "INTO", "B", "GIVING", "C");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_10() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "INTO", "B", "GIVING", "C", 
        "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_11() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "BY", "B", "GIVING", "C");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_12() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "BY", "B", "GIVING", "C", 
        "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_13() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "INTO", "B", "GIVING", "C", 
        "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_14() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "INTO", "B", "GIVING", "C", 
        "ROUNDED", "D", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_15() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "BY", "B", "GIVING", "C", 
        "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_16() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "BY", "B", "GIVING", "C", 
        "ROUNDED", "D", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_17() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "INTO", "2", "GIVING", 
        "C");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_18() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "INTO", "2", "GIVING", 
        "C", "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_19() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "BY", "2", "GIVING", "C");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_20() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "BY", "2", "GIVING", "C", 
        "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_21() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "INTO", "2", "GIVING", 
        "C", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_22() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "INTO", "2", "GIVING", 
        "C", "ROUNDED", "D", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_23() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "BY", "2", "GIVING", "C", 
        "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format2_24() {
      Parser parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "BY", "2", "GIVING", "C", 
        "ROUNDED", "D", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format3_25() {
      Parser parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "INTO", "B");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format3_26() {
      Parser parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "INTO", "B", "C");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format3_27() {
      Parser parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "INTO", "B", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format3_28() {
      Parser parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "INTO", "B", "ROUNDED", "C", 
        "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format3_29() {
      Parser parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "INTO", "B");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format3_30() {
      Parser parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "INTO", "B", "C");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format3_31() {
      Parser parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "INTO", "B", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivision_format3_32() {
      Parser parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "INTO", "B", "ROUNDED", 
        "C", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_33() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_34() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "GIVING", 
        "C", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_35() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "ON", 
        "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_36() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "GIVING", 
        "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_37() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "SIZE", 
        "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_38() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "GIVING", 
        "C", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_39() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "NOT", 
        "ON", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_40() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "GIVING", 
        "C", "NOT", "ON", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_41() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "NOT", 
        "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_42() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "GIVING", 
        "C", "NOT", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_43() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "ON", 
        "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", "ERROR", "DISPLAY", 
        "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(15, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_44() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "GIVING", 
        "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(17, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_45() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "ON", 
        "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", "ERROR", "DISPLAY", 
        "\"AOK\"", "END-DIVIDE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(16, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_46() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "GIVING", 
        "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"AOK\"", "END-DIVIDE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(18, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_47() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "END-DIVIDE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_48() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "GIVING", 
        "C", "END-DIVIDE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_49() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "INTO", "B", "GIVING", 
        "TALLY", "END-DIVIDE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }
}