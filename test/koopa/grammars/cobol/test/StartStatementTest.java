package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class StartStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testStartStatement_1() {
      Parser parser = grammar.startStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("START", "MY-FILE", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStartStatement_2() {
      Parser parser = grammar.startStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("START", "MY-FILE", "END-START");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStartStatement_3() {
      Parser parser = grammar.startStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("START", "MY-FILE", "INVALID", 
        "KEY", "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStartStatement_4() {
      Parser parser = grammar.startStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("START", "MY-FILE", "INVALID", 
        "DISPLAY", "\"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStartStatement_5() {
      Parser parser = grammar.startStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("START", "MY-FILE", "NOT", "INVALID", 
        "KEY", "DISPLAY", "\"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStartStatement_6() {
      Parser parser = grammar.startStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("START", "MY-FILE", "NOT", "INVALID", 
        "DISPLAY", "\"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStartStatement_7() {
      Parser parser = grammar.startStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("START", "MY-FILE", "INVALID", 
        "KEY", "DISPLAY", "\"Oops.\"", "END-START");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStartStatement_8() {
      Parser parser = grammar.startStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("START", "MY-FILE", "INVALID", 
        "DISPLAY", "\"Oops.\"", "END-START");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStartStatement_9() {
      Parser parser = grammar.startStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("START", "MY-FILE", "NOT", "INVALID", 
        "KEY", "DISPLAY", "\"A-OK.\"", "END-START");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStartStatement_10() {
      Parser parser = grammar.startStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("START", "MY-FILE", "NOT", "INVALID", 
        "DISPLAY", "\"A-OK.\"", "END-START");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }
}