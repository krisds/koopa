package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class ComputeStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testComputeStatement_1() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE", "A", "=", "B", "+", 
        "C", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testComputeStatement_2() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE", "A", "=", "B", "+", 
        "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testComputeStatement_3() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE", "A", "=", "B", "+", 
        "C", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testComputeStatement_4() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE", "A", "=", "B", "+", 
        "C", "NOT", "ON", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testComputeStatement_5() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE", "A", "=", "B", "+", 
        "C", "NOT", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testComputeStatement_6() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE", "A", "=", "B", "+", 
        "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(17, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testComputeStatement_7() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE", "A", "=", "B", "+", 
        "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"AOK\"", "END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(18, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testComputeStatement_8() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE", "A", "=", "B", "+", 
        "C", "END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testComputeStatement_9() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE", "WS-NUM", "=", "FUNCTION", 
        "ACOS", "(", "IND", "(", "5", ")", "/", "9", ")", "END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(14, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testComputeStatement_10() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE", "WS-NUM", "=", "FUNCTION", 
        "ANNUITY", "(", "B", "/", "2", "8", ")", "END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testComputeStatement_11() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE", "WS-INT", "=", "FUNCTION", 
        "LENGTH", "(", "\"A\"", ")", "END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testComputeStatement_12() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE", "WS-NUM", "=", "FUNCTION", 
        "MAX", "(", "A", "*", "B", "(", "C", "+", "1", ")", "/", "2", "3", "+", 
        "4", ")", "END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(21, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testComputeStatement_13() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE", "WS-NUM", "=", "FUNCTION", 
        "RANDOM", "END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testComputeStatement_14() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE", "WS-NUM", "=", "FUNCTION", 
        "SUM", "(", "5", "-2", "-14", "0", ")", "END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }
}