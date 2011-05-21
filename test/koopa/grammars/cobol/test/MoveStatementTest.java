package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from MoveStatement.stage. */
public class MoveStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testMoveStatement_1() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE EMPLOYEE-RECORD TO PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_2() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE \"TEXT\" TO PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_3() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE 42 TO PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_4() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE 42.42 TO PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_5() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE ZERO TO PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_6() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE ALL ZEROES TO PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_7() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE CORRESPONDING EMPLOYEE-RECORD TO PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_8() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE CORR EMPLOYEE-RECORD TO PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_9() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE CORRESPONDING EMPLOYEE-RECORD TO PAYROLL-CHECK EMPLOYEE-LIST");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_10() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE CORR EMPLOYEE-RECORD TO PAYROLL-CHECK EMPLOYEE-LIST");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_11() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE CORRESPONDING \"TEXT\" TO PAYROLL-CHECK");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testMoveStatement_12() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE CORRESPONDING 42 TO PAYROLL-CHECK");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testMoveStatement_13() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE CORRESPONDING 42.42 TO PAYROLL-CHECK");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testMoveStatement_14() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE CORR \"TEXT\" TO PAYROLL-CHECK");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testMoveStatement_15() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE CORR 42 TO PAYROLL-CHECK");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testMoveStatement_16() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE CORR 42.42 TO PAYROLL-CHECK");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testMoveStatement_17() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE DEBUG-LINE TO DBLINE-HOLD");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_18() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE LINE-COUNTER TO COMPUTED-18V0");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_19() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE PAGE-COUNTER TO COMPUTED-18V0");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_20() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE \"0\" TO PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_21() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "MOVE \"0\" TO CURSOR OF TPGM4N");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}