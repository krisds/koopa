package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
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
      ParserCombinator parser = grammar.times();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 42 TIMES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTimes_2() {
      ParserCombinator parser = grammar.times();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 42.0 TIMES "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testTimes_3() {
      ParserCombinator parser = grammar.times();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEVERAL TIMES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUntil_4() {
      ParserCombinator parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUntil_5() {
      ParserCombinator parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WITH TEST BEFORE UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUntil_6() {
      ParserCombinator parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TEST BEFORE UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUntil_7() {
      ParserCombinator parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WITH TEST AFTER UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUntil_8() {
      ParserCombinator parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TEST AFTER UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUntil_9() {
      ParserCombinator parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNTIL EXIT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUntil_10() {
      ParserCombinator parser = grammar.until();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FOREVER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testVarying_11() {
      ParserCombinator parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testVarying_12() {
      ParserCombinator parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WITH TEST BEFORE\n   VARYING MY-COUNT\n   FROM LOWER\n   BY STEP\n   UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testVarying_13() {
      ParserCombinator parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TEST BEFORE\n   VARYING MY-COUNT\n   FROM LOWER\n   BY STEP\n   UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testVarying_14() {
      ParserCombinator parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WITH TEST AFTER\n   VARYING MY-COUNT\n   FROM LOWER\n   BY STEP\n   UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testVarying_15() {
      ParserCombinator parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TEST AFTER\n   VARYING MY-COUNT\n   FROM LOWER\n   BY STEP\n   UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testVarying_16() {
      ParserCombinator parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER\n   AFTER OTHER-COUNT FROM A-1 BY A-2 UNTIL OTHER-COUNT > A-3 # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testVarying_17() {
      ParserCombinator parser = grammar.varying();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER\n   AFTER OTHER-COUNT FROM A-1 BY A-2 UNTIL OTHER-COUNT > A-3\n   AFTER OTHER-COUNT FROM B-1 BY B-2 UNTIL OTHER-COUNT > B-3 # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_18() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_19() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THROUGH SUB-B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_20() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_21() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM 24 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_22() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM 24 THROUGH 42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_23() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM 24 THRU 42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_24() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM\n     DISPLAY 1\n   END-PERFORM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_25() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM\n     DISPLAY 1\n     DISPLAY 2\n     DISPLAY 3\n   END-PERFORM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_26() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A 7 TIMES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_27() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THROUGH SUB-B 7 TIMES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_28() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM 7 TIMES\n     DISPLAY 1\n     DISPLAY 2\n     DISPLAY 3\n   END-PERFORM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_29() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_30() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THROUGH SUB-B UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_31() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B UNTIL MY-COUNT > 42 # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_32() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM UNTIL MY-COUNT > 42\n     DISPLAY 1\n     DISPLAY 2\n     DISPLAY 3\n   END-PERFORM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_33() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_34() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THROUGH SUB-B\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_35() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B\n     WITH TEST BEFORE\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_36() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B\n     TEST BEFORE\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_37() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B\n     WITH TEST AFTER\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_38() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B\n     TEST AFTER\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_39() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_40() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM SUB-A THRU SUB-B\n     VARYING MY-COUNT FROM LOWER BY STEP UNTIL MY-COUNT > UPPER\n     AFTER OTHER-COUNT FROM A-1 BY A-2 UNTIL OTHER-COUNT > A-3\n     AFTER OTHER-COUNT FROM B-1 BY B-2 UNTIL OTHER-COUNT > B-3 # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_41() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM\n     VARYING MY-COUNT FROM 1 BY 1\n     UNTIL MY-VALUE ( MY-INDEX ) NOT < THE-RETURN-CODE\n   END-PERFORM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_42() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM WITH TEST AFTER\n     UNTIL char NOT = \"Y\" AND char NOT = \"y\"\n     CALL clear-screen\n   END-PERFORM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_43() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM WITH TEST AFTER\n     UNTIL char NOT = \"Y\" AND char NOT = \"y\"\n     PERFORM init\n   END-PERFORM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_44() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM foo WITH TEST AFTER UNTIL EXIT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_45() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM foo THROUGH bar WITH TEST AFTER UNTIL EXIT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_46() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM VARYING foo THROUGH bar\n     DISPLAY 1\n     DISPLAY 2\n     DISPLAY 3\n   END-PERFORM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_47() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM FOREVER\n     DISPLAY \".\"\n   END-PERFORM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPerformStatement_48() {
      ParserCombinator parser = grammar.performStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PERFORM COMMIT THRU COMMIT-EXIT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}