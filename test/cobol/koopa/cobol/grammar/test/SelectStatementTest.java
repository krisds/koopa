package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parser;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from SelectStatement.stage. */
public class SelectStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testSelectStatement_1() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT MER-FILE\n     ASSIGN TO 'MER.DAT'\n     ORGANIZATION IS INDEXED\n     ACCESS MODE IS SEQUENTIAL\n     RECORD KEY IS MER-ID-KEY\n     ALTERNATE RECORD KEY IS MER-NAME-KEY\n     ALTERNATE RECORD KEY IS MER-EMAIL-KEY\n     ALTERNATE RECORD KEY IS MER-PHONE-KEY\n     FILE STATUS IS WS-STAT . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}