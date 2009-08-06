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
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "ON", "OVERFLOW", "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_4() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "ON", "OVERFLOW", "DISPLAY", "\"Oops.\"", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_5() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "NOT", "ON", "OVERFLOW", "DISPLAY", "\"AOK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_6() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "NOT", "ON", "OVERFLOW", "DISPLAY", "\"AOK.\"", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_7() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "OVERFLOW", "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_8() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "OVERFLOW", "DISPLAY", "\"Oops.\"", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_9() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "NOT", "OVERFLOW", "DISPLAY", "\"AOK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_10() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "NOT", "OVERFLOW", "DISPLAY", "\"AOK.\"", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_11() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "OVERFLOW", "DISPLAY", "\"Oops.\"", "NOT", "OVERFLOW", 
        "DISPLAY", "\"AOK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUnstringStatement_12() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("UNSTRING", "TEXT", "INTO", "PART1", 
        "PART2", "PART3", "OVERFLOW", "DISPLAY", "\"Oops.\"", "NOT", "OVERFLOW", 
        "DISPLAY", "\"AOK.\"", "END-UNSTRING");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(14, tokenizer.getNumberOfProcessedTokens());
    }
}