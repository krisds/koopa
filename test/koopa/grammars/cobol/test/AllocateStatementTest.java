package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from AllocateStatement.stage. */
public class AllocateStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testAllocateStatement_1() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE based-var\n   INITIALIZED\n   RETURNING pointer-var ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_2() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE based-var\n   INITIALIZED ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_3() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE based-var\n   RETURNING pointer-var ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_4() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE based-var ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_5() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE 13 CHARACTERS\n   INITIALIZED\n   RETURNING pointer-var ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_6() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE 13 CHARACTERS\n   INITIALIZED ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_7() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE 13 CHARACTERS\n   RETURNING pointer-var ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_8() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE 13 CHARACTERS ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_9() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE N + 2 CHARACTERS\n   INITIALIZED\n   RETURNING pointer-var ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_10() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE N + 2 CHARACTERS\n   INITIALIZED ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_11() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE N + 2 CHARACTERS\n   RETURNING pointer-var ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_12() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE N + 2 CHARACTERS ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}