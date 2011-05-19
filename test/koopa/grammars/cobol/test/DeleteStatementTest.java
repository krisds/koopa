package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class DeleteStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testDeleteStatement_1() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_2() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "RECORD", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_3() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "END-DELETE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_4() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "RECORD", 
        "END-DELETE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_5() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "INVALID", 
        "KEY", "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_6() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "RECORD", 
        "INVALID", "KEY", "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_7() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "INVALID", 
        "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_8() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "RECORD", 
        "INVALID", "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_9() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "NOT", "INVALID", 
        "KEY", "DISPLAY", "\"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_10() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "RECORD", 
        "NOT", "INVALID", "KEY", "DISPLAY", "\"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_11() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "NOT", "INVALID", 
        "DISPLAY", "\"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_12() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "RECORD", 
        "NOT", "INVALID", "DISPLAY", "\"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_13() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "INVALID", 
        "KEY", "DISPLAY", "\"Oops.\"", "END-DELETE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_14() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "RECORD", 
        "INVALID", "KEY", "DISPLAY", "\"Oops.\"", "END-DELETE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_15() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "INVALID", 
        "DISPLAY", "\"Oops.\"", "END-DELETE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_16() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "RECORD", 
        "INVALID", "DISPLAY", "\"Oops.\"", "END-DELETE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_17() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "NOT", "INVALID", 
        "KEY", "DISPLAY", "\"A-OK.\"", "END-DELETE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_18() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "RECORD", 
        "NOT", "INVALID", "KEY", "DISPLAY", "\"A-OK.\"", "END-DELETE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_19() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "NOT", "INVALID", 
        "DISPLAY", "\"A-OK.\"", "END-DELETE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeleteStatement_20() {
      Parser parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DELETE", "MY-FILE", "RECORD", 
        "NOT", "INVALID", "DISPLAY", "\"A-OK.\"", "END-DELETE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }
}