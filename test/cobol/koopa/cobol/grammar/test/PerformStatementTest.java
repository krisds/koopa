package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parser;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from PerformStatement.stage. */
public class PerformStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testTimes_1() {
      Parser parser = grammar.times();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 42 TIMES "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTimes_2() {
      Parser parser = grammar.times();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 42.0 TIMES "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testTimes_3() {
      Parser parser = grammar.times();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEVERAL TIMES "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUntil_4() {
      Parser parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUntil_5() {
      Parser parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WITH TEST BEFORE UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUntil_6() {
      Parser parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TEST BEFORE UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUntil_7() {
      Parser parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WITH TEST AFTER UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUntil_8() {
      Parser parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TEST AFTER UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testVarying_9() {
      Parser parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testVarying_10() {
      Parser parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WITH TEST BEFORE\n   VARYING MY-COUNT\n   FROM LOWER\n   BY STEP\n   UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testVarying_11() {
      Parser parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TEST BEFORE\n   VARYING MY-COUNT\n   FROM LOWER\n   BY STEP\n   UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testVarying_12() {
      Parser parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WITH TEST AFTER\n   VARYING MY-COUNT\n   FROM LOWER\n   BY STEP\n   UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testVarying_13() {
      Parser parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TEST AFTER\n   VARYING MY-COUNT\n   FROM LOWER\n   BY STEP\n   UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testVarying_14() {
      Parser parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER\n   AFTER OTHER-COUNT FROM A-1 BY A-2 UNTIL OTHER-COUNT > A-3 # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testVarying_15() {
      Parser parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER\n   AFTER OTHER-COUNT FROM A-1 BY A-2 UNTIL OTHER-COUNT > A-3\n   AFTER OTHER-COUNT FROM B-1 BY B-2 UNTIL OTHER-COUNT > B-3 # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_16() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_17() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THROUGH SUB-B "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_18() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_19() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM 24 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_20() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM 24 THROUGH 42 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_21() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM 24 THRU 42 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_22() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM\n     DISPLAY 1\n   END-PERFORM "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_23() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM\n     DISPLAY 1\n     DISPLAY 2\n     DISPLAY 3\n   END-PERFORM "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_24() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A 7 TIMES "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_25() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THROUGH SUB-B 7 TIMES "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_26() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM 7 TIMES\n     DISPLAY 1\n     DISPLAY 2\n     DISPLAY 3\n   END-PERFORM "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_27() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_28() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THROUGH SUB-B UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_29() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_30() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM UNTIL MY-COUNT > 42\n     DISPLAY 1\n     DISPLAY 2\n     DISPLAY 3\n   END-PERFORM "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_31() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_32() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THROUGH SUB-B\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_33() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B\n     WITH TEST BEFORE\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_34() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B\n     TEST BEFORE\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_35() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B\n     WITH TEST AFTER\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_36() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B\n     TEST AFTER\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_37() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_38() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER\n     AFTER OTHER-COUNT FROM A-1 BY A-2 UNTIL OTHER-COUNT > A-3\n     AFTER OTHER-COUNT FROM B-1 BY B-2 UNTIL OTHER-COUNT > B-3 # . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_39() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM\n     VARYING MY-COUNT FROM 1 BY 1\n     UNTIL MY-VALUE ( MY-INDEX ) NOT < THE-RETURN-CODE\n   END-PERFORM "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_40() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM WITH TEST AFTER\n     UNTIL char NOT = \"Y\" AND char NOT = \"y\"\n     CALL clear-screen\n   END-PERFORM "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_41() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM WITH TEST AFTER\n     UNTIL char NOT = \"Y\" AND char NOT = \"y\"\n     PERFORM init\n   END-PERFORM "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_42() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM foo WITH TEST AFTER UNTIL EXIT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_43() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM foo THROUGH bar WITH TEST AFTER UNTIL EXIT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_44() {
      Parser parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM VARYING foo THROUGH bar\n     DISPLAY 1\n     DISPLAY 2\n     DISPLAY 3\n   END-PERFORM "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}