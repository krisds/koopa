package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from DeleteFileStatement.stage. */
public class DeleteFileStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testDeleteFileStatement_1() {
      ParserCombinator parser = grammar.deleteFileStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE FILE "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteFileStatement_2() {
      ParserCombinator parser = grammar.deleteFileStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE FILE \"foo\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteFileStatement_3() {
      ParserCombinator parser = grammar.deleteFileStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE FILE \"foo\" \"bar\" baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}