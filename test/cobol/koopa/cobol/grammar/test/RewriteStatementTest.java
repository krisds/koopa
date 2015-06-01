package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from RewriteStatement.stage. */
public class RewriteStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testRewriteStatement_1() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_2() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD FROM MY-IDENTIFIER # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_3() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD FROM \"some literal\" # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_4() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD\n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_5() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD FROM MY-IDENTIFIER\n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_6() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD FROM \"some literal\"\n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_7() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD \n   INVALID KEY\n      DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_8() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD FROM MY-IDENTIFIER\n   INVALID KEY\n      DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_9() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD \n   INVALID\n      DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_10() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD FROM MY-IDENTIFIER\n   INVALID\n      DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_11() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD \n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_12() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD FROM MY-IDENTIFIER\n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_13() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD \n   NOT INVALID\n      DISPLAY \"A-OK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_14() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD FROM MY-IDENTIFIER\n   NOT INVALID\n      DISPLAY \"A-OK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_15() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD \n   INVALID KEY\n      DISPLAY \"Oops.\" \n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_16() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD FROM MY-IDENTIFIER\n   INVALID KEY\n      DISPLAY \"Oops.\" \n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_17() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD \n   INVALID\n      DISPLAY \"Oops.\" \n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_18() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD FROM MY-IDENTIFIER\n   INVALID\n      DISPLAY \"Oops.\" \n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_19() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD \n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" \n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_20() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD FROM MY-IDENTIFIER\n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" \n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_21() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD \n   NOT INVALID\n      DISPLAY \"A-OK.\" \n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_22() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD FROM MY-IDENTIFIER\n   NOT INVALID\n      DISPLAY \"A-OK.\" \n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_23() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD\n     WITH NO LOCK \n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_24() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD\n     WITH LOCK \n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_25() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD\n     NO LOCK \n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_26() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD\n     LOCK \n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_27() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD \n     RETRY N TIMES\n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_28() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD \n     RETRY 3 TIMES\n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_29() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD \n     RETRY FOR N SECONDS\n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_30() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD \n     RETRY FOR 3 SECONDS\n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_31() {
      ParserCombinator parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REWRITE MY-RECORD \n     RETRY FOREVER\n   END-REWRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}