package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class WriteStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testWriteStatement_1() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_2() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_3() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "FROM", 
        "MY-SOMETHING", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_4() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AFTER", 
        "ADVANCING", "1", "LINE", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_5() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AFTER", 
        "1", "LINE", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_6() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AFTER", 
        "ADVANCING", "1", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_7() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AFTER", 
        "1", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_8() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "BEFORE", 
        "ADVANCING", "1", "LINE", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_9() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "BEFORE", 
        "1", "LINE", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_10() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "BEFORE", 
        "ADVANCING", "1", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_11() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "BEFORE", 
        "1", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_12() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AFTER", 
        "ADVANCING", "N", "LINE", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_13() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AFTER", 
        "N", "LINE", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_14() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AFTER", 
        "ADVANCING", "N", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_15() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AFTER", 
        "N", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_16() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "BEFORE", 
        "ADVANCING", "N", "LINE", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_17() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "BEFORE", 
        "N", "LINE", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_18() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "BEFORE", 
        "ADVANCING", "N", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_19() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "BEFORE", 
        "N", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_20() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AFTER", 
        "ADVANCING", "MY-MNEMONIC", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_21() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AFTER", 
        "MY-MNEMONIC", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_22() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "BEFORE", 
        "ADVANCING", "MY-MNEMONIC", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_23() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "BEFORE", 
        "MY-MNEMONIC", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_24() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AFTER", 
        "ADVANCING", "PAGE", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_25() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AFTER", 
        "PAGE", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_26() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "BEFORE", 
        "ADVANCING", "PAGE", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_27() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "BEFORE", 
        "PAGE", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_28() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "BEFORE", 
        "ADVANCING", "ZERO", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_29() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AT", "END-OF-PAGE", 
        "DISPLAY", "\"End of page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_30() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AT", "EOP", 
        "DISPLAY", "\"End of page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_31() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "END-OF-PAGE", 
        "DISPLAY", "\"End of page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_32() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "EOP", "DISPLAY", 
        "\"End of page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_33() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "NOT", "AT", 
        "END-OF-PAGE", "DISPLAY", "\"Elsewhere on page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_34() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "NOT", "AT", 
        "EOP", "DISPLAY", "\"Elsewhere on page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_35() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "NOT", "END-OF-PAGE", 
        "DISPLAY", "\"Elsewhere on page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_36() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "NOT", "EOP", 
        "DISPLAY", "\"Elsewhere on page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_37() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "INVALID", 
        "KEY", "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_38() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "INVALID", 
        "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_39() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "NOT", "INVALID", 
        "KEY", "DISPLAY", "\"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_40() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "NOT", "INVALID", 
        "DISPLAY", "\"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_41() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AT", "END-OF-PAGE", 
        "DISPLAY", "\"End of page.\"", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_42() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "AT", "EOP", 
        "DISPLAY", "\"End of page.\"", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_43() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "END-OF-PAGE", 
        "DISPLAY", "\"End of page.\"", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_44() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "EOP", "DISPLAY", 
        "\"End of page.\"", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_45() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "NOT", "AT", 
        "END-OF-PAGE", "DISPLAY", "\"Elsewhere on page.\"", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_46() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "NOT", "AT", 
        "EOP", "DISPLAY", "\"Elsewhere on page.\"", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_47() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "NOT", "END-OF-PAGE", 
        "DISPLAY", "\"Elsewhere on page.\"", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_48() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "NOT", "EOP", 
        "DISPLAY", "\"Elsewhere on page.\"", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_49() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "INVALID", 
        "KEY", "DISPLAY", "\"Oops.\"", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_50() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "INVALID", 
        "DISPLAY", "\"Oops.\"", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_51() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "NOT", "INVALID", 
        "KEY", "DISPLAY", "\"A-OK.\"", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testWriteStatement_52() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WRITE", "MY-RECORD", "NOT", "INVALID", 
        "DISPLAY", "\"A-OK.\"", "END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }
}