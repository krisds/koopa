package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from GoToStatement.stage. */
public class GoToStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testGoToStatement_1() {
      ParserCombinator parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_2() {
      ParserCombinator parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GO TO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_3() {
      ParserCombinator parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GO TO OTHER-PLACE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_4() {
      ParserCombinator parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GO OTHER-PLACE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_5() {
      ParserCombinator parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GO TO 42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_6() {
      ParserCombinator parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GO 42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_7() {
      ParserCombinator parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GO TO OTHER-PLACE\n     DEPENDING ON SOME-VALUE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_8() {
      ParserCombinator parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GO OTHER-PLACE\n     DEPENDING ON SOME-VALUE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_9() {
      ParserCombinator parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GO TO OTHER-PLACE\n         YET-ANOTHER-PLACE\n         STILL-SOME-OTHER-PLACE\n     DEPENDING ON SOME-VALUE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_10() {
      ParserCombinator parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GO OTHER-PLACE\n         YET-ANOTHER-PLACE\n         STILL-SOME-OTHER-PLACE\n     DEPENDING ON SOME-VALUE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_11() {
      ParserCombinator parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GO TO OTHER-PLACE\n         YET-ANOTHER-PLACE\n         STILL-SOME-OTHER-PLACE\n     DEPENDING SOME-VALUE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_12() {
      ParserCombinator parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GO OTHER-PLACE\n         YET-ANOTHER-PLACE\n         STILL-SOME-OTHER-PLACE\n     DEPENDING SOME-VALUE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}