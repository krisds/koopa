package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from DisplayStatement.stage. */
public class DisplayStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testDisplayStatement_1() {
      Parser parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FIXED, "       DISPLAY A,B ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}