package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class AddStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testAddStatement_1() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_2() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_3() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_4() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_5() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "SIZE", 
        "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_6() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_7() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "NOT", 
        "ON", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_8() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", "NOT", "ON", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_9() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "NOT", 
        "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_10() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", "NOT", "SIZE", "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_11() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", "ERROR", "DISPLAY", 
        "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(14, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_12() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(16, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_13() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", "ERROR", "DISPLAY", 
        "\"AOK\"", "END-ADD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(16, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_14() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", "ON", "SIZE", "ERROR", "DISPLAY", "\"OOPS\"", "NOT", "ON", "SIZE", 
        "ERROR", "DISPLAY", "\"AOK\"", "END-ADD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(18, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_15() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "END-ADD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAddStatement_16() {
      Parser parser = grammar.addStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "GIVING", 
        "C", "END-ADD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }
}