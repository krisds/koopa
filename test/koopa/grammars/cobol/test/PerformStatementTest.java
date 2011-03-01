package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class PerformStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testTimes_1() {
      Parser parser = grammar.times();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("42", "TIMES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testTimes_2() {
      Parser parser = grammar.times();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("42.0", "TIMES");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testTimes_3() {
      Parser parser = grammar.times();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEVERAL", "TIMES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUntil_4() {
      Parser parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNTIL", "MY-COUNT", ">", "42", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUntil_5() {
      Parser parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WITH", "TEST", "BEFORE", "UNTIL", 
        "MY-COUNT", ">", "42", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUntil_6() {
      Parser parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TEST", "BEFORE", "UNTIL", "MY-COUNT", 
        ">", "42", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUntil_7() {
      Parser parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WITH", "TEST", "AFTER", "UNTIL", 
        "MY-COUNT", ">", "42", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUntil_8() {
      Parser parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TEST", "AFTER", "UNTIL", "MY-COUNT", 
        ">", "42", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testVarying_9() {
      Parser parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("VARYING", "MY-COUNT", "FROM", 
        "LOWER", "BY", "STEP", "UNTIL", "MY-COUNT", ">", "UPPER", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testVarying_10() {
      Parser parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WITH", "TEST", "BEFORE", "VARYING", 
        "MY-COUNT", "FROM", "LOWER", "BY", "STEP", "UNTIL", "MY-COUNT", ">", "UPPER", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(13, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testVarying_11() {
      Parser parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TEST", "BEFORE", "VARYING", "MY-COUNT", 
        "FROM", "LOWER", "BY", "STEP", "UNTIL", "MY-COUNT", ">", "UPPER", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testVarying_12() {
      Parser parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WITH", "TEST", "AFTER", "VARYING", 
        "MY-COUNT", "FROM", "LOWER", "BY", "STEP", "UNTIL", "MY-COUNT", ">", "UPPER", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(13, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testVarying_13() {
      Parser parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TEST", "AFTER", "VARYING", "MY-COUNT", 
        "FROM", "LOWER", "BY", "STEP", "UNTIL", "MY-COUNT", ">", "UPPER", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testVarying_14() {
      Parser parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("VARYING", "MY-COUNT", "FROM", 
        "LOWER", "BY", "STEP", "UNTIL", "MY-COUNT", ">", "UPPER", "AFTER", "OTHER-COUNT", 
        "FROM", "A-1", "BY", "A-2", "UNTIL", "OTHER-COUNT", ">", "A-3", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(20, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testVarying_15() {
      Parser parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("VARYING", "MY-COUNT", "FROM", 
        "LOWER", "BY", "STEP", "UNTIL", "MY-COUNT", ">", "UPPER", "AFTER", "OTHER-COUNT", 
        "FROM", "A-1", "BY", "A-2", "UNTIL", "OTHER-COUNT", ">", "A-3", "AFTER", 
        "OTHER-COUNT", "FROM", "B-1", "BY", "B-2", "UNTIL", "OTHER-COUNT", ">", 
        "B-3", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(30, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_16() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_17() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A", "THROUGH", 
        "SUB-B");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_18() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A", "THRU", "SUB-B");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_19() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "24");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_20() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "24", "THROUGH", "42");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_21() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "24", "THRU", "42");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_22() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "DISPLAY", "1", "END-PERFORM");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_23() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "DISPLAY", "1", "DISPLAY", 
        "2", "DISPLAY", "3", "END-PERFORM");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_24() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A", "7", "TIMES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_25() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A", "THROUGH", 
        "SUB-B", "7", "TIMES");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_26() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "7", "TIMES", "DISPLAY", 
        "1", "DISPLAY", "2", "DISPLAY", "3", "END-PERFORM");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_27() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A", "UNTIL", "MY-COUNT", 
        ">", "42", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_28() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A", "THROUGH", 
        "SUB-B", "UNTIL", "MY-COUNT", ">", "42", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_29() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A", "THRU", "SUB-B", 
        "UNTIL", "MY-COUNT", ">", "42", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_30() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "UNTIL", "MY-COUNT", 
        ">", "42", "DISPLAY", "1", "DISPLAY", "2", "DISPLAY", "3", "END-PERFORM");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_31() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A", "VARYING", 
        "MY-COUNT", "FROM", "LOWER", "BY", "STEP", "UNTIL", "MY-COUNT", ">", "UPPER", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_32() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A", "THROUGH", 
        "SUB-B", "VARYING", "MY-COUNT", "FROM", "LOWER", "BY", "STEP", "UNTIL", 
        "MY-COUNT", ">", "UPPER", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(14, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_33() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A", "THRU", "SUB-B", 
        "WITH", "TEST", "BEFORE", "VARYING", "MY-COUNT", "FROM", "LOWER", "BY", 
        "STEP", "UNTIL", "MY-COUNT", ">", "UPPER", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(17, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_34() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A", "THRU", "SUB-B", 
        "TEST", "BEFORE", "VARYING", "MY-COUNT", "FROM", "LOWER", "BY", "STEP", 
        "UNTIL", "MY-COUNT", ">", "UPPER", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(16, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_35() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A", "THRU", "SUB-B", 
        "WITH", "TEST", "AFTER", "VARYING", "MY-COUNT", "FROM", "LOWER", "BY", "STEP", 
        "UNTIL", "MY-COUNT", ">", "UPPER", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(17, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_36() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A", "THRU", "SUB-B", 
        "TEST", "AFTER", "VARYING", "MY-COUNT", "FROM", "LOWER", "BY", "STEP", "UNTIL", 
        "MY-COUNT", ">", "UPPER", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(16, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_37() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A", "THRU", "SUB-B", 
        "VARYING", "MY-COUNT", "FROM", "LOWER", "BY", "STEP", "UNTIL", "MY-COUNT", 
        ">", "UPPER", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(14, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_38() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "SUB-A", "THRU", "SUB-B", 
        "VARYING", "MY-COUNT", "FROM", "LOWER", "BY", "STEP", "UNTIL", "MY-COUNT", 
        ">", "UPPER", "AFTER", "OTHER-COUNT", "FROM", "A-1", "BY", "A-2", "UNTIL", 
        "OTHER-COUNT", ">", "A-3", "AFTER", "OTHER-COUNT", "FROM", "B-1", "BY", 
        "B-2", "UNTIL", "OTHER-COUNT", ">", "B-3", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(34, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testPerformStatement_39() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PERFORM", "VARYING", "MY-COUNT", 
        "FROM", "1", "BY", "1", "UNTIL", "MY-VALUE", "(", "MY-INDEX", ")", "NOT", 
        "<", "THE-RETURN-CODE", "END-PERFORM");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(16, tokenizer.getNumberOfProcessedTokens());
    }
}