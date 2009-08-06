package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class DivideStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testDivideStatement_1() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_2() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", "GIVING", 
        "C", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_3() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", "ON", 
        "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_4() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", "GIVING", 
        "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_5() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", "SIZE", 
        "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_6() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", "GIVING", 
        "C", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_7() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", "NOT", 
        "ON", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_8() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", "GIVING", 
        "C", "NOT", "ON", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_9() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", "NOT", 
        "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_10() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", "GIVING", 
        "C", "NOT", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_11() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", "ON", 
        "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", "ERROR", "DISPLAY", 
        "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(14, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_12() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", "GIVING", 
        "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(16, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_13() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", "ON", 
        "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", "ERROR", "DISPLAY", 
        "\"AOK\"", "END-DIVIDE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(16, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_14() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", "GIVING", 
        "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"AOK\"", "END-DIVIDE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(18, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_15() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", "END-DIVIDE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDivideStatement_16() {
      Parser parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DIVIDE", "A", "BY", "B", "GIVING", 
        "C", "END-DIVIDE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }
}