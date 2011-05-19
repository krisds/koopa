package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class ReturnStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testReturnStatement_1() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testReturnStatement_2() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testReturnStatement_3() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "AT", "END", 
        "DISPLAY", "\"At end.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReturnStatement_4() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "AT", "END", 
        "DISPLAY", "\"At end.\"", "END-RETURN");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReturnStatement_5() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "RECORD", 
        "AT", "END", "DISPLAY", "\"At end.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReturnStatement_6() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "RECORD", 
        "AT", "END", "DISPLAY", "\"At end.\"", "END-RETURN");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReturnStatement_7() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "INTO", "MY-FIELD", 
        "AT", "END", "DISPLAY", "\"At end.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReturnStatement_8() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "INTO", "MY-FIELD", 
        "AT", "END", "DISPLAY", "\"At end.\"", "END-RETURN");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReturnStatement_9() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "RECORD", 
        "INTO", "MY-FIELD", "AT", "END", "DISPLAY", "\"At end.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReturnStatement_10() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "RECORD", 
        "INTO", "MY-FIELD", "AT", "END", "DISPLAY", "\"At end.\"", "END-RETURN");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReturnStatement_11() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "AT", "END", 
        "DISPLAY", "\"At end.\"", "NOT", "AT", "END", "DISPLAY", "\"Not at end.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReturnStatement_12() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "AT", "END", 
        "DISPLAY", "\"At end.\"", "NOT", "AT", "END", "DISPLAY", "\"Not at end.\"", 
        "END-RETURN");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReturnStatement_13() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "RECORD", 
        "AT", "END", "DISPLAY", "\"At end.\"", "NOT", "AT", "END", "DISPLAY", "\"Not at end.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReturnStatement_14() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "RECORD", 
        "AT", "END", "DISPLAY", "\"At end.\"", "NOT", "AT", "END", "DISPLAY", "\"Not at end.\"", 
        "END-RETURN");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(13, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReturnStatement_15() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "INTO", "MY-FIELD", 
        "AT", "END", "DISPLAY", "\"At end.\"", "NOT", "AT", "END", "DISPLAY", "\"Not at end.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(13, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReturnStatement_16() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "INTO", "MY-FIELD", 
        "AT", "END", "DISPLAY", "\"At end.\"", "NOT", "AT", "END", "DISPLAY", "\"Not at end.\"", 
        "END-RETURN");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(14, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReturnStatement_17() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "RECORD", 
        "INTO", "MY-FIELD", "AT", "END", "DISPLAY", "\"At end.\"", "NOT", "AT", 
        "END", "DISPLAY", "\"Not at end.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(14, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReturnStatement_18() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("RETURN", "MY-FILE", "RECORD", 
        "INTO", "MY-FIELD", "AT", "END", "DISPLAY", "\"At end.\"", "NOT", "AT", 
        "END", "DISPLAY", "\"Not at end.\"", "END-RETURN");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(15, tokenizer.getNumberOfProcessedTokens());
    }
}