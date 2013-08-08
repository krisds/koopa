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

    @Test
    public void testAllocateStatement_13() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE FUNCTION FN ( X ) ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_14() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE based-var RETURNING FUNCTION FN ( X ) ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_15() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE EXCEPTION-OBJECT ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_16() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE based-var RETURNING EXCEPTION-OBJECT ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_17() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE NULL ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_18() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE based-var RETURNING NULL ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_19() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE SELF ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_20() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE based-var RETURNING SELF ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_21() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE SUPER ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_22() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE based-var RETURNING SUPER ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_23() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE MY-CLASS-NAME OF SUPER ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_24() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE based-var RETURNING MY-CLASS-NAME OF SUPER ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_25() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE ADDRESS OF SOMETHING ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_26() {
      Parser parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ALLOCATE based-var RETURNING ADDRESS OF SOMETHING ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }
}