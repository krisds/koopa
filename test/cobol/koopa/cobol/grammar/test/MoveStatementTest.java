package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
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
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE EMPLOYEE-RECORD TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_2() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE \"TEXT\" TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_3() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE 42 TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_4() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE 42.42 TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_5() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE ZERO TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_6() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE ALL ZEROES TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_7() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORRESPONDING EMPLOYEE-RECORD TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_8() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORR EMPLOYEE-RECORD TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_9() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORRESPONDING EMPLOYEE-RECORD TO PAYROLL-CHECK EMPLOYEE-LIST "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_10() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORR EMPLOYEE-RECORD TO PAYROLL-CHECK EMPLOYEE-LIST "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_11() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORRESPONDING \"TEXT\" TO PAYROLL-CHECK "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_12() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORRESPONDING 42 TO PAYROLL-CHECK "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_13() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORRESPONDING 42.42 TO PAYROLL-CHECK "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_14() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORR \"TEXT\" TO PAYROLL-CHECK "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_15() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORR 42 TO PAYROLL-CHECK "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_16() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE CORR 42.42 TO PAYROLL-CHECK "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_17() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE DEBUG-LINE TO DBLINE-HOLD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_18() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE LINE-COUNTER TO COMPUTED-18V0 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_19() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE PAGE-COUNTER TO COMPUTED-18V0 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_20() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE \"0\" TO PAYROLL-CHECK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_21() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE \"0\" TO CURSOR OF TPGM4N "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMoveStatement_22() {
      ParserCombinator parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MOVE 10 TO WS-A,WS-B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}