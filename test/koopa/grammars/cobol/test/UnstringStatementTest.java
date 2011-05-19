package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class UnstringStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testUnstringStatement_1() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_2() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_3() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "DELIMITED", 
        "BY", "MARKER", "INTO", "PART1", "PART2", "PART3", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_4() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "DELIMITED", 
        "BY", "\"Z\"", "INTO", "PART1", "PART2", "PART3", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_5() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "DELIMITED", 
        "BY", "ALL", "MARKER", "INTO", "PART1", "PART2", "PART3", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_6() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "DELIMITED", 
        "BY", "ALL", "\"Z\"", "INTO", "PART1", "PART2", "PART3", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_7() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "DELIMITED", 
        "MARKER", "INTO", "PART1", "PART2", "PART3", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_8() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "DELIMITED", 
        "\"Z\"", "INTO", "PART1", "PART2", "PART3", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_9() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "DELIMITED", 
        "ALL", "MARKER", "INTO", "PART1", "PART2", "PART3", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_10() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "DELIMITED", 
        "ALL", "\"Z\"", "INTO", "PART1", "PART2", "PART3", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_11() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "DELIMITED", 
        "BY", "ALL", "M1", "OR", "ALL", "M2", "INTO", "PART1", "PART2", "PART3", 
        "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(14, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_12() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "DELIMITED", 
        "BY", "ALL", "\"Z\"", "OR", "ALL", "\"Y\"", "INTO", "PART1", "PART2", "PART3", 
        "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(14, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_13() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "DELIMITED", 
        "BY", "M1", "OR", "M2", "INTO", "PART1", "PART2", "PART3", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_14() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "DELIMITED", 
        "BY", "\"Z\"", "OR", "\"Y\"", "INTO", "PART1", "PART2", "PART3", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_15() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "DELIMITED", 
        "BY", "M1", "OR", "ALL", "\"X\"", "OR", "ALL", "M2", "OR", "\"Y\"", "INTO", 
        "PART1", "PART2", "PART3", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(18, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_16() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_17() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "DELIMITER", "IN", "X", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_18() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "DELIMITER", "X", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_19() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "COUNT", "IN", "Y", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_20() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "COUNT", "Y", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_21() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "DELIMITER", "IN", "X", "COUNT", "IN", "Y", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_22() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "DELIMITER", "X", "COUNT", "Y", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_23() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "DELIMITER", "X", "COUNT", "Y", "PART2", "DELIMITER", "A", "COUNT", "B", 
        "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(14, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_24() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "DELIMITER", "A", "PART3", "COUNT", "B", "PART4", "DELIMITER", 
        "A", "COUNT", "B", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(16, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_25() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "WITH", "POINTER", "MY-POINTER", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_26() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "POINTER", "MY-POINTER", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_27() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "TALLYING", "IN", "MY-COUNT", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_28() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "TALLYING", "MY-COUNT", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_29() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "DELIMITED", 
        "BY", "M1", "OR", "ALL", "\"X\"", "OR", "ALL", "M2", "OR", "\"Y\"", "INTO", 
        "PART1", "PART2", "DELIMITER", "A", "PART3", "COUNT", "B", "PART4", "DELIMITER", 
        "A", "COUNT", "B", "WITH", "POINTER", "MY-POINTER", "TALLYING", "IN", "MY-COUNT", 
        "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(33, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_30() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "ON", "OVERFLOW", "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_31() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "ON", "OVERFLOW", "DISPLAY", "\"Oops.\"", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_32() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "NOT", "ON", "OVERFLOW", "DISPLAY", "\"AOK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_33() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "NOT", "ON", "OVERFLOW", "DISPLAY", "\"AOK.\"", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_34() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "OVERFLOW", "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_35() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "OVERFLOW", "DISPLAY", "\"Oops.\"", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_36() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "NOT", "OVERFLOW", "DISPLAY", "\"AOK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_37() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "NOT", "OVERFLOW", "DISPLAY", "\"AOK.\"", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_38() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "OVERFLOW", "DISPLAY", "\"Oops.\"", "NOT", "OVERFLOW", 
        "DISPLAY", "\"AOK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(13, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_39() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "OVERFLOW", "DISPLAY", "\"Oops.\"", "NOT", "OVERFLOW", 
        "DISPLAY", "\"AOK.\"", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(14, tokenizer.getNumberOfProcessedTokens());
    }
}