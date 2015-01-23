package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parser;
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
      Parser parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo PERFORM bar "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_2() {
      Parser parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON \"foo\" PERFORM bar "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_3() {
      Parser parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo NEXT SENTENCE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_4() {
      Parser parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     AND EVERY bar\n     PERFORM baz\n "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_5() {
      Parser parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     AND EVERY \"bar\"\n     PERFORM baz\n "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_6() {
      Parser parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     AND EVERY bar\n     UNTIL baz\n     PERFORM boojum\n "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_7() {
      Parser parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     AND EVERY bar\n     UNTIL \"baz\"\n     PERFORM boojum\n "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_8() {
      Parser parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     AND EVERY \"bar\"\n     UNTIL \"baz\"\n     PERFORM boojum\n "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_9() {
      Parser parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     PERFORM bar\n   ELSE\n     PERFORM baz\n "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_10() {
      Parser parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     PERFORM bar\n   OTHERWISE\n     PERFORM baz\n "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_11() {
      Parser parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     PERFORM bar\n   ELSE\n     NEXT SENTENCE\n "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_12() {
      Parser parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     PERFORM bar\n   OTHERWISE\n     NEXT SENTENCE\n "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOnStatement_13() {
      Parser parser = grammar.onStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ON foo\n     AND EVERY bar\n     UNTIL baz\n     PERFORM boojum\n   OTHERWISE\n     PERFORM snark\n "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}