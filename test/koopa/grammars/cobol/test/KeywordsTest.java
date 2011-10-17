package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from Keywords.stage. */
public class KeywordsTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testCallStatement_1() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MQ-OPEN-PGM USING\n     HCONN\n     OBJECT-DESCRIPTOR\n     OPTIONS\n     REPLY-HANDLE\n     OPEN-CODE2\n     REASON\n   END-CALL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}