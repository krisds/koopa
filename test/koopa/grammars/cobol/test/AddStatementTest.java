package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class AddStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testAddition_format1_1() {
      Parser parser = grammar.addition_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CORRESPONDING", "A", "TO", "B");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format1_2() {
      Parser parser = grammar.addition_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CORR", "A", "TO", "B");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format1_3() {
      Parser parser = grammar.addition_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CORRESPONDING", "A", "TO", "B", 
        "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format1_4() {
      Parser parser = grammar.addition_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CORR", "A", "TO", "B", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format2_5() {
      Parser parser = grammar.addition_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "TO", "B", "GIVING", "C");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format2_6() {
      Parser parser = grammar.addition_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "TO", "B", "GIVING", "C", 
        "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format2_7() {
      Parser parser = grammar.addition_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "TO", "C", "GIVING", 
        "D", "E");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format2_8() {
      Parser parser = grammar.addition_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "TO", "C", "GIVING", 
        "D", "ROUNDED", "E", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format2_9() {
      Parser parser = grammar.addition_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "GIVING", "C");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format2_10() {
      Parser parser = grammar.addition_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "GIVING", "C", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format2_11() {
      Parser parser = grammar.addition_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "C", "GIVING", "D", 
        "E");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format2_12() {
      Parser parser = grammar.addition_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "C", "GIVING", "D", 
        "ROUNDED", "E", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format2_13() {
      Parser parser = grammar.addition_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO", "TO", "B", "GIVING", "C");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format2_14() {
      Parser parser = grammar.addition_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "TO", "ZERO", "GIVING", "C");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format3_15() {
      Parser parser = grammar.addition_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "TO", "B");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format3_16() {
      Parser parser = grammar.addition_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "TO", "B", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format3_17() {
      Parser parser = grammar.addition_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "TO", "C", "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format3_18() {
      Parser parser = grammar.addition_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "B", "TO", "C", "ROUNDED", 
        "D", "ROUNDED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddition_format3_19() {
      Parser parser = grammar.addition_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("A", "ZERO", "TO", "C", "D");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_20() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_21() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_22() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_23() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_24() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "SIZE", 
        "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_25() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_26() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "NOT", 
        "ON", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_27() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", "NOT", "ON", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_28() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "NOT", 
        "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_29() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", "NOT", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_30() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", "ERROR", "DISPLAY", 
        "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(15, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_31() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(17, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_32() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", "ERROR", "DISPLAY", 
        "\"AOK\"", "END-ADD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(16, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_33() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"AOK\"", "END-ADD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(18, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_34() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "END-ADD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_35() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", "END-ADD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }
}