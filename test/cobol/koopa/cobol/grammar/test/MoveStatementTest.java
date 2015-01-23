package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parser;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from MoveStatement.stage. */
public class MoveStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testMoveStatement_1() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE EMPLOYEE-RECORD TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_2() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE \"TEXT\" TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_3() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE 42 TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_4() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE 42.42 TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_5() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE ZERO TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_6() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE ALL ZEROES TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_7() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORRESPONDING EMPLOYEE-RECORD TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_8() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORR EMPLOYEE-RECORD TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_9() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORRESPONDING EMPLOYEE-RECORD TO PAYROLL-CHECK EMPLOYEE-LIST "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_10() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORR EMPLOYEE-RECORD TO PAYROLL-CHECK EMPLOYEE-LIST "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_11() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORRESPONDING \"TEXT\" TO PAYROLL-CHECK "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_12() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORRESPONDING 42 TO PAYROLL-CHECK "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_13() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORRESPONDING 42.42 TO PAYROLL-CHECK "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_14() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORR \"TEXT\" TO PAYROLL-CHECK "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_15() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORR 42 TO PAYROLL-CHECK "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_16() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORR 42.42 TO PAYROLL-CHECK "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_17() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE DEBUG-LINE TO DBLINE-HOLD "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_18() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE LINE-COUNTER TO COMPUTED-18V0 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_19() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE PAGE-COUNTER TO COMPUTED-18V0 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_20() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE \"0\" TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_21() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE \"0\" TO CURSOR OF TPGM4N "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_22() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE 10 TO WS-A,WS-B "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}