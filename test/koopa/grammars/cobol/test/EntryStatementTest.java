package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class EntryStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testEntryStatement_1() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ENTRY");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testEntryStatement_2() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ENTRY", "\"MAIN-ENTRANCE\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testEntryStatement_3() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ENTRY", "\"MAIN-ENTRANCE\"", 
        "USING", "FIELD-A");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testEntryStatement_4() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ENTRY", "\"MAIN-ENTRANCE\"", 
        "USING", "FIELD-A", "FIELD-B");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testEntryStatement_5() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ENTRY", "\"MAIN-ENTRANCE\"", 
        "FIELD-A");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testEntryStatement_6() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ENTRY", "\"MAIN-ENTRANCE\"", 
        "USING", "FIELD-A", "USING", "FIELD-B");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }
}