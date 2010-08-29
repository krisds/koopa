package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class ReadStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testReadStatement_1() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_2() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_3() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "WITH", "NO", 
        "LOCK", "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_4() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "NO", "LOCK", 
        "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_5() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "NEXT", "RECORD", 
        "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_6() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "PREVIOUS", 
        "RECORD", "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_7() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "RECORD", "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_8() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "INTO", "MY-VALUE", 
        "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_9() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "KEY", "IS", 
        "MY-KEY", "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_10() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "KEY", "MY-KEY", 
        "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_11() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "AT", "END", 
        "DISPLAY", "\"Nothing more to see here.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_12() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "END", "DISPLAY", 
        "\"Nothing more to see here.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_13() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "NOT", "AT", 
        "END", "DISPLAY", "\"Look at that...\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_14() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "NOT", "END", 
        "DISPLAY", "\"Look at that...\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_15() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "INVALID", 
        "KEY", "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_16() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "INVALID", 
        "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_17() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "NOT", "INVALID", 
        "KEY", "DISPLAY", "\"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_18() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "NOT", "INVALID", 
        "DISPLAY", "\"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_19() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "AT", "END", 
        "DISPLAY", "\"Nothing more to see here.\"", "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_20() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "END", "DISPLAY", 
        "\"Nothing more to see here.\"", "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_21() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "NOT", "AT", 
        "END", "DISPLAY", "\"Look at that...\"", "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_22() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "NOT", "END", 
        "DISPLAY", "\"Look at that...\"", "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_23() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "INVALID", 
        "KEY", "DISPLAY", "\"Oops.\"", "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_24() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "INVALID", 
        "DISPLAY", "\"Oops.\"", "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_25() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "NOT", "INVALID", 
        "KEY", "DISPLAY", "\"A-OK.\"", "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testReadStatement_26() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("READ", "MY-FILE", "NOT", "INVALID", 
        "DISPLAY", "\"A-OK.\"", "END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }
}