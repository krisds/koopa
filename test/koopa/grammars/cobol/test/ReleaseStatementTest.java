package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class ReleaseStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testReleaseStatement_1() {
      Parser parser = grammar.releaseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RELEASE", "MY-SORT-RECORD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReleaseStatement_2() {
      Parser parser = grammar.releaseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RELEASE", "MY-SORT-RECORD", "FROM", 
        "MY-FILE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }
}