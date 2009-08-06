package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class IfStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testIfStatement_1() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "THEN", "DISPLAY", 
        "GOOD", "END-IF");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIfStatement_2() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "DISPLAY", 
        "GOOD", "END-IF");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIfStatement_3() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "THEN", "DISPLAY", 
        "GOOD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIfStatement_4() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "DISPLAY", 
        "GOOD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIfStatement_5() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "THEN", "DISPLAY", 
        "GOOD", "DISPLAY", "BETTER", "DISPLAY", "BEST", "END-IF");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIfStatement_6() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "DISPLAY", 
        "GOOD", "DISPLAY", "BETTER", "DISPLAY", "BEST", "END-IF");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIfStatement_7() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "THEN", "DISPLAY", 
        "GOOD", "DISPLAY", "BETTER", "DISPLAY", "BEST");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIfStatement_8() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "DISPLAY", 
        "GOOD", "DISPLAY", "BETTER", "DISPLAY", "BEST");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIfStatement_9() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "THEN", "DISPLAY", 
        "GOOD", "ELSE", "DISPLAY", "BAD", "END-IF");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIfStatement_10() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "DISPLAY", 
        "GOOD", "ELSE", "DISPLAY", "BAD", "END-IF");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIfStatement_11() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "THEN", "DISPLAY", 
        "GOOD", "DISPLAY", "BETTER", "DISPLAY", "BEST", "ELSE", "DISPLAY", "BAD", 
        "DISPLAY", "WORSE", "DISPLAY", "WORST", "END-IF");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(19, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIfStatement_12() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "THEN", "DISPLAY", 
        "GOOD", "DISPLAY", "BETTER", "DISPLAY", "BEST", "ELSE", "DISPLAY", "BAD", 
        "DISPLAY", "WORSE", "DISPLAY", "WORST");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(17, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIfStatement_13() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "THEN", "DISPLAY", 
        "GOOD", "ELSE", "DISPLAY", "BAD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIfStatement_14() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "DISPLAY", 
        "GOOD", "ELSE", "DISPLAY", "BAD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIfStatement_15() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "THEN", "DISPLAY", 
        "GOOD", "DISPLAY", "BETTER", "DISPLAY", "BEST", "ELSE", "DISPLAY", "BAD", 
        "DISPLAY", "WORSE", "DISPLAY", "WORST");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(17, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIfStatement_16() {
      Parser parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IF", "1", "<", "2", "DISPLAY", 
        "GOOD", "DISPLAY", "BETTER", "DISPLAY", "BEST", "ELSE", "DISPLAY", "BAD", 
        "DISPLAY", "WORSE", "DISPLAY", "WORST");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(16, tokenizer.getNumberOfProcessedTokens());
    }
}