package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from LowLevel.stage. */
public class LowLevelTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testCobolWord_1() {
      Parser parser = grammar.cobolWord();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "COBOL-WORD");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCobolWord_2() {
      Parser parser = grammar.cobolWord();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "cobol-word");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCobolWord_3() {
      Parser parser = grammar.cobolWord();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "COBOL_WORD");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCobolWord_4() {
      Parser parser = grammar.cobolWord();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "cobol_word");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCobolWord_5() {
      Parser parser = grammar.cobolWord();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "aC0b0lW0rd");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCobolWord_6() {
      Parser parser = grammar.cobolWord();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ABCDEFGHIJKLMNOPQRSTUVWXYZ78901");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCobolWord_7() {
      Parser parser = grammar.cobolWord();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ABCDEFGHIJKLMNOPQRSTUVWXYZ789012");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testInteger_8() {
      Parser parser = grammar.integer();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "1");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInteger_9() {
      Parser parser = grammar.integer();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "2.0");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testInteger_10() {
      Parser parser = grammar.integer();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "\"ABC\"");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testInteger_11() {
      Parser parser = grammar.integer();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "DEF");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testDecimal_12() {
      Parser parser = grammar.decimal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "1");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testDecimal_13() {
      Parser parser = grammar.decimal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "2.0");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDecimal_14() {
      Parser parser = grammar.decimal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "\"ABC\"");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testDecimal_15() {
      Parser parser = grammar.decimal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "DEF");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testAlphanumeric_16() {
      Parser parser = grammar.alphanumeric();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "1");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testAlphanumeric_17() {
      Parser parser = grammar.alphanumeric();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "2.0");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testAlphanumeric_18() {
      Parser parser = grammar.alphanumeric();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "\"ABC\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAlphanumeric_19() {
      Parser parser = grammar.alphanumeric();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "DEF");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testLiteral_20() {
      Parser parser = grammar.literal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "\"this is a literal\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLiteral_21() {
      Parser parser = grammar.literal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "\" 0 \"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLiteral_22() {
      Parser parser = grammar.literal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "\" 1 \"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLiteral_23() {
      Parser parser = grammar.literal();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "\" 00 \"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_24() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ZERO");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_25() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ALL ZERO");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_26() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ZEROS");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_27() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ALL ZEROS");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_28() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ZEROES");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_29() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ALL ZEROES");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_30() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "SPACE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_31() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ALL SPACE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_32() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "SPACES");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_33() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ALL SPACES");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_34() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "HIGH-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_35() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ALL HIGH-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_36() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "HIGH-VALUES");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_37() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ALL HIGH-VALUES");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_38() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "LOW-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_39() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ALL LOW-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_40() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "LOW-VALUES");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_41() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ALL LOW-VALUES");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_42() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "QUOTE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_43() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ALL QUOTE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_44() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "QUOTES");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_45() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ALL QUOTES");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_46() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ALL \"A\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_47() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "\"A\"");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testFigurativeConstant_48() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ALL 42");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_49() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "42");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testFigurativeConstant_50() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "ALL 42.10");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFigurativeConstant_51() {
      Parser parser = grammar.figurativeConstant();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "42.10");
      assertFalse(parser.accepts(tokenizer));
    }
}