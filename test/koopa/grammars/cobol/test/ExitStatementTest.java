package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class ExitStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testExitStatement_1() {
      Parser parser = grammar.exitStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EXIT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testExitStatement_2() {
      Parser parser = grammar.exitStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EXIT", "PROGRAM");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }
}