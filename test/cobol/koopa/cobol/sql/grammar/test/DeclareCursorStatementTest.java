package koopa.cobol.sql.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parser;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from DeclareCursorStatement.stage. */
public class DeclareCursorStatementTest extends TestCase {

  private static koopa.cobol.sql.grammar.SQLGrammar grammar = new koopa.cobol.sql.grammar.SQLGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testDeclareCursorStatement_1() {
      Parser parser = grammar.declareCursorStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DECLARE AB05 CURSOR WITH RETURN FOR                 \n   SELECT                                                       \n      PPPPPPP_CODE                                            \n     ,RRRRRRR_DESC                                            \n     ,IIPACT_CONDITION                                        \n     ,VVVVVV_ID                                               \n     ,CARR_ID                                              \n   FROM SESSION.AB05 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}