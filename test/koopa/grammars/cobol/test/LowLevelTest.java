package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class LowLevelTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testCobolWord_1() {
      Parser parser = grammar.cobolWord();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COBOL-WORD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCobolWord_2() {
      Parser parser = grammar.cobolWord();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("cobol-word");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCobolWord_3() {
      Parser parser = grammar.cobolWord();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("aC0b0lW0rd");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCobolWord_4() {
      Parser parser = grammar.cobolWord();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ABCDEFGHIJKLMNOPQRSTUVWXYZ78901");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testCobolWord_5() {
      Parser parser = grammar.cobolWord();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ABCDEFGHIJKLMNOPQRSTUVWXYZ789012");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testInteger_6() {
      Parser parser = grammar.integer();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("1");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testInteger_7() {
      Parser parser = grammar.integer();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("2.0");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testInteger_8() {
      Parser parser = grammar.integer();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("\"ABC\"");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testInteger_9() {
      Parser parser = grammar.integer();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DEF");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testDecimal_10() {
      Parser parser = grammar.decimal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("1");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testDecimal_11() {
      Parser parser = grammar.decimal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("2.0");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDecimal_12() {
      Parser parser = grammar.decimal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("\"ABC\"");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testDecimal_13() {
      Parser parser = grammar.decimal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DEF");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testAlphanumeric_14() {
      Parser parser = grammar.alphanumeric();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("1");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testAlphanumeric_15() {
      Parser parser = grammar.alphanumeric();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("2.0");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testAlphanumeric_16() {
      Parser parser = grammar.alphanumeric();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("\"ABC\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAlphanumeric_17() {
      Parser parser = grammar.alphanumeric();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DEF");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testLiteral_18() {
      Parser parser = grammar.literal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("\"this is a literal\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testLiteral_19() {
      Parser parser = grammar.literal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("\" 0 \"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testLiteral_20() {
      Parser parser = grammar.literal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("\" 1 \"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testLiteral_21() {
      Parser parser = grammar.literal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("\" 00 \"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_22() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZERO");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_23() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ALL", "ZERO");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_24() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZEROS");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_25() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ALL", "ZEROS");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_26() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ZEROES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_27() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ALL", "ZEROES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_28() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SPACE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_29() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ALL", "SPACE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_30() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SPACES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_31() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ALL", "SPACES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_32() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("HIGH-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_33() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ALL", "HIGH-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_34() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("HIGH-VALUES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_35() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ALL", "HIGH-VALUES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_36() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("LOW-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_37() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ALL", "LOW-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_38() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("LOW-VALUES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_39() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ALL", "LOW-VALUES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_40() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("QUOTE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_41() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ALL", "QUOTE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_42() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("QUOTES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_43() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ALL", "QUOTES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_44() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ALL", "\"A\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_45() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("\"A\"");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testFigurativeConstant_46() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ALL", "42");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_47() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("42");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testFigurativeConstant_48() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ALL", "42.10");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testFigurativeConstant_49() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("42.10");
      assertFalse(parser.accepts(tokenizer));
    }
}