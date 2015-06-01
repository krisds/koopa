package koopa.cobol.sql.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from IncludeStatement.stage. */
public class IncludeStatementTest extends TestCase {

  private static koopa.cobol.sql.grammar.SQLGrammar grammar = new koopa.cobol.sql.grammar.SQLGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testIncludeStatement_1() {
      ParserCombinator parser = grammar.includeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INCLUDE SQLCA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}