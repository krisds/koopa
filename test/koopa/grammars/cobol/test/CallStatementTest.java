package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class CallStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testCallStatement_1() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_2() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "\"MY-SERVICE\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_3() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "42");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testCallStatement_4() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "42.42");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testCallStatement_5() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "MY-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_6() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "MY-DATA", "MY-OTHER-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_7() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "BY", "REFERENCE", "MY-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_8() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "BY", "REFERENCE", "MY-DATA", "MY-OTHER-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_9() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "REFERENCE", "MY-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_10() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "REFERENCE", "MY-DATA", "MY-OTHER-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_11() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "BY", "CONTENT", "MY-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_12() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "BY", "CONTENT", "MY-DATA", "MY-OTHER-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_13() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "CONTENT", "MY-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_14() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "CONTENT", "MY-DATA", "MY-OTHER-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_15() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "BY", "REFERENCE", "MY-REFERENCED-DATA", "BY", "CONTENT", "MY-CONTENT-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_16() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "BY", "CONTENT", "MY-CONTENT-DATA", "BY", "REFERENCE", "MY-REFERENCED-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_17() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "REFERENCE", "MY-REFERENCED-DATA", "CONTENT", "MY-CONTENT-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_18() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "CONTENT", "MY-CONTENT-DATA", "REFERENCE", "MY-REFERENCED-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_19() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "MY-REFERENCED-DATA", "BY", "CONTENT", "MY-CONTENT-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_20() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "BY", "REFERENCE", "MY-REFERENCED-DATA", "BY", "CONTENT", "MY-CONTENT-DATA", 
        "BY", "REFERENCE", "MY-OTHER-REFERENCED-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_21() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "BY", "CONTENT", "MY-CONTENT-DATA", "BY", "REFERENCE", "MY-REFERENCED-DATA", 
        "BY", "CONTENT", "MY-OTHER-CONTENT-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_22() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "BY", "REFERENCE", "MY-REFERENCED-DATA", "BY", "CONTENT", "MY-CONTENT-DATA", 
        "BY", "REFERENCE", "MY-OTHER-REFERENCED-DATA", "BY", "CONTENT", "MY-OTHER-CONTENT-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(15, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_23() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "BY", "CONTENT", "MY-CONTENT-DATA", "BY", "REFERENCE", "MY-REFERENCED-DATA", 
        "BY", "CONTENT", "MY-OTHER-CONTENT-DATA", "BY", "REFERENCE", "MY-OTHER-REFERENCED-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(15, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_24() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "MY-REFERENCED-DATA", "BY", "CONTENT", "MY-CONTENT-DATA", "BY", "REFERENCE", 
        "MY-OTHER-REFERENCED-DATA", "BY", "CONTENT", "MY-OTHER-CONTENT-DATA");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(13, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_25() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "ON", "OVERFLOW", 
        "DISPLAY", "\"SERVICE OVERFLOW\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_26() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "OVERFLOW", 
        "DISPLAY", "\"SERVICE OVERFLOW\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_27() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "ON", "EXCEPTION", 
        "DISPLAY", "\"SERVICE EXCEPTION\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_28() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "EXCEPTION", 
        "DISPLAY", "\"SERVICE EXCEPTION\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_29() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "NOT", "ON", 
        "EXCEPTION", "DISPLAY", "\"NO SERVICE EXCEPTION\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_30() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "NOT", "EXCEPTION", 
        "DISPLAY", "\"NO SERVICE EXCEPTION\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_31() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "END-CALL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_32() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "USING", 
        "MY-DATA", "END-CALL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCallStatement_33() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("CALL", "MY-SERVICE", "ON", "EXCEPTION", 
        "DISPLAY", "\"SERVICE EXCEPTION\"", "END-CALL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }
}