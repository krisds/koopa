package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class CopyStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testCopyStatement_1() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY", "FOO", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCopyStatement_2() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY", "FOO", "IN", "FUM", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCopyStatement_3() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY", "FOO", "REPLACING", "==FEE==", 
        "BY", "==FUM==", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCopyStatement_4() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY", "FOO", "REPLACING", "FEE", 
        "BY", "FUM", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCopyStatement_5() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY", "FOO", "REPLACING", "\"FEE\"", 
        "BY", "\"FUM\"", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }
}