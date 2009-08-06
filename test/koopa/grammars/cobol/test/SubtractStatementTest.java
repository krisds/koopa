package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class SubtractStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testSubtractStatement_1() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_2() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_3() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_4() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_5() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_6() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_7() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "NOT", "ON", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_8() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", "NOT", "ON", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_9() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "NOT", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_10() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", "NOT", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_11() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", "ERROR", 
        "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(14, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_12() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", 
        "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(16, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_13() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", "ERROR", 
        "DISPLAY", "\"AOK\"", "END-SUBTRACT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(16, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_14() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", 
        "SIZE", "ERROR", "DISPLAY", "\"AOK\"", "END-SUBTRACT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(18, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_15() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "END-SUBTRACT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSubtractStatement_16() {
      Parser parser = grammar.subtractStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SUBTRACT", "A", "FROM", "B", 
        "GIVING", "C", "END-SUBTRACT");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }
}