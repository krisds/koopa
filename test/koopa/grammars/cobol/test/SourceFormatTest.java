package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from SourceFormat.stage. */
public class SourceFormatTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testStringStatement_1() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "STRING A, B, C INTO TEXT\n   END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_2() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "KOOPAH STRING A, B, C INTO TEXT\nKOOPAH END-STRING");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testStringStatement_3() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FIXED, "STRING A, B, C INTO TEXT\n   END-STRING");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testStringStatement_4() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FIXED, "KOOPAH STRING A, B, C INTO TEXT\nKOOPAH END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}