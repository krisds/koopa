package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from OnStatement.stage. */
public class OnStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testOnStatement_1() {
      ParserCombinator parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo PERFORM bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_2() {
      ParserCombinator parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON \"foo\" PERFORM bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_3() {
      ParserCombinator parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo NEXT SENTENCE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_4() {
      ParserCombinator parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     AND EVERY bar\n     PERFORM baz\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_5() {
      ParserCombinator parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     AND EVERY \"bar\"\n     PERFORM baz\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_6() {
      ParserCombinator parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     AND EVERY bar\n     UNTIL baz\n     PERFORM boojum\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_7() {
      ParserCombinator parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     AND EVERY bar\n     UNTIL \"baz\"\n     PERFORM boojum\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_8() {
      ParserCombinator parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     AND EVERY \"bar\"\n     UNTIL \"baz\"\n     PERFORM boojum\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_9() {
      ParserCombinator parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     PERFORM bar\n   ELSE\n     PERFORM baz\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_10() {
      ParserCombinator parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     PERFORM bar\n   OTHERWISE\n     PERFORM baz\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_11() {
      ParserCombinator parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     PERFORM bar\n   ELSE\n     NEXT SENTENCE\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_12() {
      ParserCombinator parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     PERFORM bar\n   OTHERWISE\n     NEXT SENTENCE\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_13() {
      ParserCombinator parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     AND EVERY bar\n     UNTIL baz\n     PERFORM boojum\n   OTHERWISE\n     PERFORM snark\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}