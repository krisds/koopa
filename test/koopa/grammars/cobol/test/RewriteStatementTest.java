package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from RewriteStatement.stage. */
public class RewriteStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testRewriteStatement_1() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD # . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_2() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD FROM MY-IDENTIFIER # . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_3() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD FROM \"some literal\" # . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_4() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD\n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_5() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD FROM MY-IDENTIFIER\n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_6() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD FROM \"some literal\"\n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_7() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD \n   INVALID KEY\n      DISPLAY \"Oops.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_8() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD FROM MY-IDENTIFIER\n   INVALID KEY\n      DISPLAY \"Oops.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_9() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD \n   INVALID\n      DISPLAY \"Oops.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_10() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD FROM MY-IDENTIFIER\n   INVALID\n      DISPLAY \"Oops.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_11() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD \n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_12() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD FROM MY-IDENTIFIER\n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_13() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD \n   NOT INVALID\n      DISPLAY \"A-OK.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_14() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD FROM MY-IDENTIFIER\n   NOT INVALID\n      DISPLAY \"A-OK.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_15() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD \n   INVALID KEY\n      DISPLAY \"Oops.\" \n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_16() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD FROM MY-IDENTIFIER\n   INVALID KEY\n      DISPLAY \"Oops.\" \n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_17() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD \n   INVALID\n      DISPLAY \"Oops.\" \n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_18() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD FROM MY-IDENTIFIER\n   INVALID\n      DISPLAY \"Oops.\" \n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_19() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD \n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" \n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_20() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD FROM MY-IDENTIFIER\n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" \n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_21() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD \n   NOT INVALID\n      DISPLAY \"A-OK.\" \n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_22() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD FROM MY-IDENTIFIER\n   NOT INVALID\n      DISPLAY \"A-OK.\" \n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_23() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD\n     WITH NO LOCK \n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_24() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD\n     WITH LOCK \n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_25() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD\n     NO LOCK \n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_26() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD\n     LOCK \n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_27() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD \n     RETRY N TIMES\n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_28() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD \n     RETRY 3 TIMES\n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_29() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD \n     RETRY FOR N SECONDS\n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_30() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD \n     RETRY FOR 3 SECONDS\n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRewriteStatement_31() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REWRITE MY-RECORD \n     RETRY FOREVER\n   END-REWRITE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}