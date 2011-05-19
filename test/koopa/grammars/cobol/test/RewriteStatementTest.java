package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class RewriteStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testRewriteStatement_1() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_2() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "FROM", 
        "MY-IDENTIFIER", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_3() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "END-REWRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_4() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "FROM", 
        "MY-IDENTIFIER", "END-REWRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_5() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "INVALID", 
        "KEY", "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_6() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "FROM", 
        "MY-IDENTIFIER", "INVALID", "KEY", "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_7() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "INVALID", 
        "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_8() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "FROM", 
        "MY-IDENTIFIER", "INVALID", "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_9() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "NOT", 
        "INVALID", "KEY", "DISPLAY", "\"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_10() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "FROM", 
        "MY-IDENTIFIER", "NOT", "INVALID", "KEY", "DISPLAY", "\"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_11() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "NOT", 
        "INVALID", "DISPLAY", "\"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_12() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "FROM", 
        "MY-IDENTIFIER", "NOT", "INVALID", "DISPLAY", "\"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_13() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "INVALID", 
        "KEY", "DISPLAY", "\"Oops.\"", "END-REWRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_14() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "FROM", 
        "MY-IDENTIFIER", "INVALID", "KEY", "DISPLAY", "\"Oops.\"", "END-REWRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_15() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "INVALID", 
        "DISPLAY", "\"Oops.\"", "END-REWRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_16() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "FROM", 
        "MY-IDENTIFIER", "INVALID", "DISPLAY", "\"Oops.\"", "END-REWRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_17() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "NOT", 
        "INVALID", "KEY", "DISPLAY", "\"A-OK.\"", "END-REWRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_18() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "FROM", 
        "MY-IDENTIFIER", "NOT", "INVALID", "KEY", "DISPLAY", "\"A-OK.\"", "END-REWRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_19() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "NOT", 
        "INVALID", "DISPLAY", "\"A-OK.\"", "END-REWRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testRewriteStatement_20() {
      Parser parser = grammar.rewriteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REWRITE", "MY-RECORD", "FROM", 
        "MY-IDENTIFIER", "NOT", "INVALID", "DISPLAY", "\"A-OK.\"", "END-REWRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }
}