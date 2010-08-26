package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class StringStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testStringStatement_1() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING", "A", "B", "C", "INTO", 
        "TEXT", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStringStatement_2() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING", "A", "B", "C", "INTO", 
        "TEXT", "WITH", "POINTER", "MY-POINTER", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStringStatement_3() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING", "A", "B", "C", "INTO", 
        "TEXT", "WITH", "POINTER", "MY-POINTER", "END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStringStatement_4() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING", "A", "B", "C", "INTO", 
        "TEXT", "END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStringStatement_5() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING", "A", "B", "C", "INTO", 
        "TEXT", "ON", "OVERFLOW", "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStringStatement_6() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING", "A", "B", "C", "INTO", 
        "TEXT", "ON", "OVERFLOW", "DISPLAY", "\"Oops.\"", "END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStringStatement_7() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING", "A", "B", "C", "INTO", 
        "TEXT", "NOT", "ON", "OVERFLOW", "DISPLAY", "\"AOK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStringStatement_8() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING", "A", "B", "C", "INTO", 
        "TEXT", "NOT", "ON", "OVERFLOW", "DISPLAY", "\"AOK.\"", "END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStringStatement_9() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING", "A", "B", "C", "INTO", 
        "TEXT", "OVERFLOW", "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStringStatement_10() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING", "A", "B", "C", "INTO", 
        "TEXT", "OVERFLOW", "DISPLAY", "\"Oops.\"", "END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStringStatement_11() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING", "A", "B", "C", "INTO", 
        "TEXT", "NOT", "OVERFLOW", "DISPLAY", "\"AOK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStringStatement_12() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING", "A", "B", "C", "INTO", 
        "TEXT", "NOT", "OVERFLOW", "DISPLAY", "\"AOK.\"", "END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStringStatement_13() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING", "A", "B", "C", "INTO", 
        "TEXT", "OVERFLOW", "DISPLAY", "\"Oops.\"", "NOT", "OVERFLOW", "DISPLAY", 
        "\"AOK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStringStatement_14() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING", "A", "B", "C", "INTO", 
        "TEXT", "OVERFLOW", "DISPLAY", "\"Oops.\"", "NOT", "OVERFLOW", "DISPLAY", 
        "\"AOK.\"", "END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(14, tokenizer.getNumberOfProcessedTokens());
    }
}