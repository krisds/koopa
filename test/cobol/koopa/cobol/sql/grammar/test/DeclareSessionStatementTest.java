package koopa.cobol.sql.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from DeclareSessionStatement.stage. */
public class DeclareSessionStatementTest extends TestCase {

  private static koopa.cobol.sql.grammar.SQLGrammar grammar = new koopa.cobol.sql.grammar.SQLGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testDeclareSessionStatement_1() {
      ParserCombinator parser = grammar.declareSessionStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DECLARE SESSION.AB05 TABLE                      \n     (  PPPPPPP_CODE       CHAR(10)                        \n       ,RRRRRRR_DESC       CHAR(40)                        \n       ,IIPACT_CONDITION   CHAR(01)                        \n       ,VVVVVV_ID          CHAR(03)                        \n       ,CARR_ID            CHAR(04)) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}