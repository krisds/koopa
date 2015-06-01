package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from ServiceStatement.stage. */
public class ServiceStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testServiceStatement_1() {
      ParserCombinator parser = grammar.serviceStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SERVICE "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testServiceStatement_2() {
      ParserCombinator parser = grammar.serviceStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SERVICE LABEL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testServiceStatement_3() {
      ParserCombinator parser = grammar.serviceStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SERVICE RELOAD "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testServiceStatement_4() {
      ParserCombinator parser = grammar.serviceStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SERVICE RELOAD foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}