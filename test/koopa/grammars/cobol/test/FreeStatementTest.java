package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from FreeStatement.stage. */
public class FreeStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testFreeStatement_1() {
      Parser parser = grammar.freeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FREE ADDRESS OF A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFreeStatement_2() {
      Parser parser = grammar.freeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FREE ADDRESS A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFreeStatement_3() {
      Parser parser = grammar.freeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FREE A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFreeStatement_4() {
      Parser parser = grammar.freeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FREE\n   ADDRESS OF A\n   ADDRESS OF B ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFreeStatement_5() {
      Parser parser = grammar.freeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FREE \n   ADDRESS A\n   ADDRESS B ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFreeStatement_6() {
      Parser parser = grammar.freeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FREE\n   A\n   B ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFreeStatement_7() {
      Parser parser = grammar.freeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FREE\n   ADDRESS OF A\n   ADDRESS B\n   C ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFreeStatement_8() {
      Parser parser = grammar.freeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FREE\n   A\n   ADDRESS OF B\n   ADDRESS C ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFreeStatement_9() {
      Parser parser = grammar.freeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FREE\n   ADDRESS A\n   B\n   ADDRESS OF C ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}