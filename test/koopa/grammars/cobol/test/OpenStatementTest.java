package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class OpenStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testOpenStatement_1() {
      Parser parser = grammar.openStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OPEN", "INPUT", "MY-FILE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOpenStatement_2() {
      Parser parser = grammar.openStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OPEN", "INPUT", "MY-FILE", "REVERSED");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOpenStatement_3() {
      Parser parser = grammar.openStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OPEN", "INPUT", "MY-FILE", "WITH", 
        "NO", "REWIND");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOpenStatement_4() {
      Parser parser = grammar.openStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OPEN", "INPUT", "MY-FILE", "NO", 
        "REWIND");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOpenStatement_5() {
      Parser parser = grammar.openStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OPEN", "INPUT", "MY-ONE-FILE", 
        "MY-SECOND-FILE", "REVERSED", "MY-THIRD-FILE", "WITH", "NO", "REWIND", "MY-FOURTH-FILE", 
        "NO", "REWIND");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOpenStatement_6() {
      Parser parser = grammar.openStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OPEN", "OUTPUT", "MY-FILE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOpenStatement_7() {
      Parser parser = grammar.openStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OPEN", "OUTPUT", "MY-FILE", "WITH", 
        "NO", "REWIND");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOpenStatement_8() {
      Parser parser = grammar.openStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OPEN", "OUTPUT", "MY-FILE", "NO", 
        "REWIND");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOpenStatement_9() {
      Parser parser = grammar.openStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OPEN", "OUTPUT", "MY-ONE-FILE", 
        "MY-SECOND-FILE", "WITH", "NO", "REWIND", "MY-THIRD-FILE", "NO", "REWIND");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOpenStatement_10() {
      Parser parser = grammar.openStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OPEN", "I-O", "MY-FILE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOpenStatement_11() {
      Parser parser = grammar.openStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OPEN", "I-O", "MY-ONE-FILE", 
        "MY-SECOND-FILE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOpenStatement_12() {
      Parser parser = grammar.openStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OPEN", "EXTEND", "MY-FILE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testOpenStatement_13() {
      Parser parser = grammar.openStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("OPEN", "EXTEND", "MY-ONE-FILE", 
        "MY-SECOND-FILE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }
}