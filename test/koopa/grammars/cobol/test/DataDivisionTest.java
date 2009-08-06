package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class DataDivisionTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testRedefines_1() {
      Parser parser = grammar.redefines();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("REDEFINES", "TEST-1");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testBlankWhenZero_2() {
      Parser parser = grammar.blankWhenZero();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("BLANK", "WHEN", "ZERO");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testBlankWhenZero_3() {
      Parser parser = grammar.blankWhenZero();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("BLANK", "WHEN", "ZEROS");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testBlankWhenZero_4() {
      Parser parser = grammar.blankWhenZero();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("BLANK", "WHEN", "ZEROES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testBlankWhenZero_5() {
      Parser parser = grammar.blankWhenZero();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("BLANK", "ZERO");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testBlankWhenZero_6() {
      Parser parser = grammar.blankWhenZero();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("BLANK", "ZEROS");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testBlankWhenZero_7() {
      Parser parser = grammar.blankWhenZero();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("BLANK", "ZEROES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testExternal_8() {
      Parser parser = grammar.external();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IS", "EXTERNAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testExternal_9() {
      Parser parser = grammar.external();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EXTERNAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testGlobal_10() {
      Parser parser = grammar.global();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IS", "GLOBAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testGlobal_11() {
      Parser parser = grammar.global();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("GLOBAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testJustified_12() {
      Parser parser = grammar.justified();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("JUSTIFIED", "RIGHT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testJustified_13() {
      Parser parser = grammar.justified();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("JUST", "RIGHT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_14() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42", "TIMES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_15() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_16() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42.0", "TIMES");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testOccurs_17() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42.0");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testOccurs_18() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42", "TIMES", "ASCENDING", 
        "KEY", "IS", "MY-KEY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_19() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42", "TIMES", "DESCENDING", 
        "KEY", "IS", "MY-KEY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_20() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42", "TIMES", "ASCENDING", 
        "MY-KEY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_21() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42", "TIMES", "DESCENDING", 
        "MY-KEY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_22() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42", "TIMES", "ASCENDING", 
        "MY-KEY", "MY-OTHER-KEY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_23() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42", "TIMES", "DESCENDING", 
        "MY-KEY", "MY-OTHER-KEY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_24() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42", "TIMES", "ASCENDING", 
        "KEY", "IS", "MY-KEY", "MY-OTHER-KEY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_25() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42", "TIMES", "DESCENDING", 
        "KEY", "IS", "MY-KEY", "MY-OTHER-KEY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_26() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42", "TIMES", "ASCENDING", 
        "KEY", "IS", "MY-ASC-KEY", "MY-OTHER-ASC-KEY", "DESCENDING", "KEY", "IS", 
        "MY-DESC-KEY", "MY-OTHER-DESC-KEY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(13, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_27() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42", "TIMES", "DESCENDING", 
        "KEY", "IS", "MY-DESC-KEY", "MY-OTHER-DESC-KEY", "ASCENDING", "KEY", "IS", 
        "MY-ASC-KEY", "MY-OTHER-ASC-KEY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(13, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_28() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42", "TIMES", "INDEXED", 
        "BY", "MY-INDEX");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_29() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42", "TIMES", "INDEXED", 
        "BY", "MY-INDEX", "MY-OTHER-INDEX");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_30() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42", "TIMES", "DESCENDING", 
        "KEY", "IS", "MY-DESC-KEY", "MY-OTHER-DESC-KEY", "ASCENDING", "MY-ASC-KEY", 
        "MY-OTHER-ASC-KEY", "INDEXED", "BY", "MY-INDEX", "MY-OTHER-INDEX");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(15, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_31() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "7", "TO", "42", "TIMES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_32() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "7", "TO", "42.0", "TIMES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_33() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "7.0", "TO", "42", "TIMES");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testOccurs_34() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "7.0", "TO", "42.0", 
        "TIMES");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testOccurs_35() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "7", "TO", "42", "TIMES", 
        "DEPENDING", "ON", "MY-FIELD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_36() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "7", "TO", "42", "TIMES", 
        "DEPENDING", "ON", "MY-FIELD", "OF", "MY-RECORD", "IN", "MY-OTHER-RECORD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_37() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "42", "TIMES", "DEPENDING", 
        "ON", "MY-FIELD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOccurs_38() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OCCURS", "7", "TO", "42", "TIMES", 
        "DEPENDING", "ON", "MY-FIELD", "DESCENDING", "KEY", "IS", "MY-DESC-KEY", 
        "MY-OTHER-DESC-KEY", "ASCENDING", "MY-ASC-KEY", "MY-OTHER-ASC-KEY", "INDEXED", 
        "BY", "MY-INDEX", "MY-OTHER-INDEX");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(20, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_39() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("LEADING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_40() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TRAILING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_41() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("LEADING", "SEPARATE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_42() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TRAILING", "SEPARATE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_43() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("LEADING", "SEPARATE", "CHARACTER");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_44() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TRAILING", "SEPARATE", "CHARACTER");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_45() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SIGN", "LEADING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_46() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SIGN", "TRAILING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_47() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SIGN", "IS", "LEADING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_48() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SIGN", "IS", "TRAILING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_49() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SIGN", "LEADING", "SEPARATE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_50() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SIGN", "TRAILING", "SEPARATE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_51() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SIGN", "IS", "LEADING", "SEPARATE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_52() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SIGN", "IS", "TRAILING", "SEPARATE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_53() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SIGN", "LEADING", "SEPARATE", 
        "CHARACTER");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_54() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SIGN", "TRAILING", "SEPARATE", 
        "CHARACTER");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_55() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SIGN", "IS", "LEADING", "SEPARATE", 
        "CHARACTER");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSign_56() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SIGN", "IS", "TRAILING", "SEPARATE", 
        "CHARACTER");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSync_57() {
      Parser parser = grammar.sync();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SYNCHRONIZED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSync_58() {
      Parser parser = grammar.sync();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SYNC");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSync_59() {
      Parser parser = grammar.sync();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SYNCHRONIZED", "LEFT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSync_60() {
      Parser parser = grammar.sync();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SYNC", "LEFT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSync_61() {
      Parser parser = grammar.sync();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SYNCHRONIZED", "RIGHT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSync_62() {
      Parser parser = grammar.sync();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SYNC", "RIGHT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_63() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("BINARY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_64() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "BINARY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_65() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "IS", "BINARY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_66() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTATIONAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_67() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "COMPUTATIONAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_68() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "IS", "COMPUTATIONAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_69() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMP");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_70() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "COMP");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_71() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "IS", "COMP");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_72() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DISPLAY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_73() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "DISPLAY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_74() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "IS", "DISPLAY");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_75() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("INDEX");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_76() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "INDEX");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_77() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "IS", "INDEX");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_78() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PACKED-DECIMAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_79() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "PACKED-DECIMAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_80() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "IS", "PACKED-DECIMAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_81() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTATIONAL-1");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_82() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "COMPUTATIONAL-1");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_83() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "IS", "COMPUTATIONAL-1");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_84() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMP-1");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_85() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "COMP-1");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_86() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "IS", "COMP-1");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_87() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTATIONAL-2");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_88() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "COMPUTATIONAL-2");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_89() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "IS", "COMPUTATIONAL-2");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_90() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMP-2");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_91() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "COMP-2");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_92() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "IS", "COMP-2");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_93() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTATIONAL-3");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_94() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "COMPUTATIONAL-3");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_95() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "IS", "COMPUTATIONAL-3");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_96() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMP-3");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_97() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "COMP-3");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_98() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "IS", "COMP-3");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_99() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTATIONAL-5");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_100() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "COMPUTATIONAL-5");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_101() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "IS", "COMPUTATIONAL-5");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_102() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMP-5");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_103() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "COMP-5");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_104() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "IS", "COMP-5");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_105() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("POINTER");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_106() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "POINTER");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUsage_107() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USAGE", "IS", "POINTER");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testValue_108() {
      Parser parser = grammar.value();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("VALUE", "IS", "ZERO");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testValue_109() {
      Parser parser = grammar.value();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("VALUE", "42");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testValue_110() {
      Parser parser = grammar.value();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("VALUE", "IS", "42.10");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testValue_111() {
      Parser parser = grammar.value();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("VALUE", "\"UNDEFINED\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_112() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("01", "FILLER", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_113() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("01", "TEST-2", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_114() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("01", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_115() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("1", "TEST-3", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_116() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("11", "TEST-4", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_117() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("49", "TEST-5", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_118() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("77", "TEST-6", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_119() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("0", "TEST-7", ".");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testDataDescriptionEntry_120() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("50", "TEST-8", ".");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testDataDescriptionEntry_121() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("AA", "TEST-9", ".");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testDataDescriptionEntry_122() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("66", "TEST-10", "RENAMES", "TEST-1", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_123() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("66", "TEST-11", "RENAMES", "TEST-2", 
        "THROUGH", "TEST-3", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_124() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("66", "TEST-12", "RENAMES", "TEST-4", 
        "THRU", "TEST-5", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_125() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("66", "TEST-10B", "RENAMES", "TEST-1", 
        "OF", "TESTSUITE", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_126() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("66", "TEST-11B", "RENAMES", "TEST-2", 
        "OF", "TESTSUITE", "THROUGH", "TEST-3", "OF", "TESTSUITE", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_127() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("66", "TEST-12B", "RENAMES", "TEST-4", 
        "OF", "TESTSUITE", "THRU", "TEST-5", "OF", "TESTSUITE", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_128() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("88", "TEST-13", "VALUE", "IS", 
        "\"AAA\"", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_129() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("88", "TEST-14", "VALUE", "\"BBB\"", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_130() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("88", "TEST-15", "VALUES", "ARE", 
        "\"CCC\"", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_131() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("88", "TEST-16", "VALUES", "\"DDD\"", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_132() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("88", "TEST-17", "VALUES", "ARE", 
        "0", "THROUGH", "10", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_133() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("88", "TEST-18", "VALUES", "ARE", 
        "0", "THROUGH", "10", "20", "THROUGH", "30", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_134() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("88", "TEST-19", "VALUES", "ARE", 
        "0", "THROUGH", "10", "20", "THROUGH", "30", "66", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_135() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("88", "TEST-20", "VALUES", "ARE", 
        "0", "THROUGH", "10", "15", "20", "THROUGH", "30", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDataDescriptionEntry_136() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("88", "TEST-21", "VALUE", "IS", 
        "ZERO", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }
}