package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class GoToStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testGoToStatement_1() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("GO", "TO", "OTHER-PLACE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testGoToStatement_2() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("GO", "OTHER-PLACE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testGoToStatement_3() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("GO", "TO", "42");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testGoToStatement_4() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("GO", "42");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testGoToStatement_5() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("GO", "TO", "OTHER-PLACE", "DEPENDING", 
        "ON", "SOME-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testGoToStatement_6() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("GO", "OTHER-PLACE", "DEPENDING", 
        "ON", "SOME-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testGoToStatement_7() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("GO", "TO", "OTHER-PLACE", "YET-ANOTHER-PLACE", 
        "STILL-SOME-OTHER-PLACE", "DEPENDING", "ON", "SOME-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testGoToStatement_8() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("GO", "OTHER-PLACE", "YET-ANOTHER-PLACE", 
        "STILL-SOME-OTHER-PLACE", "DEPENDING", "ON", "SOME-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testGoToStatement_9() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("GO", "TO", "OTHER-PLACE", "YET-ANOTHER-PLACE", 
        "STILL-SOME-OTHER-PLACE", "DEPENDING", "SOME-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testGoToStatement_10() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("GO", "OTHER-PLACE", "YET-ANOTHER-PLACE", 
        "STILL-SOME-OTHER-PLACE", "DEPENDING", "SOME-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }
}