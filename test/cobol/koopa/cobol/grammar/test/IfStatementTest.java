package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from IfStatement.stage. */
public class IfStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testIfStatement_1() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2 THEN\n     DISPLAY GOOD \n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_2() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2\n     DISPLAY GOOD\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_3() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2 THEN\n     DISPLAY GOOD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_4() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2\n     DISPLAY GOOD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_5() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2 THEN\n     DISPLAY 'GOOD'\n     DISPLAY BETTER\n     DISPLAY BEST\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_6() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2\n     DISPLAY GOOD\n     DISPLAY BETTER\n     DISPLAY BEST\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_7() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2 THEN\n     DISPLAY GOOD\n     DISPLAY BETTER\n     DISPLAY BEST "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_8() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2 \n     DISPLAY GOOD\n     DISPLAY BETTER\n     DISPLAY BEST "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_9() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2 THEN\n     DISPLAY GOOD\n   ELSE\n     DISPLAY BAD\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_10() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2\n     DISPLAY GOOD\n   ELSE\n     DISPLAY BAD\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_11() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2 THEN\n     DISPLAY GOOD\n     DISPLAY BETTER\n     DISPLAY BEST\n   ELSE\n     DISPLAY BAD\n     DISPLAY WORSE\n     DISPLAY WORST\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_12() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2 THEN\n     DISPLAY GOOD\n     DISPLAY BETTER\n     DISPLAY BEST\n   ELSE\n     DISPLAY BAD\n     DISPLAY WORSE\n     DISPLAY WORST "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_13() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2 THEN\n     DISPLAY GOOD\n   ELSE\n     DISPLAY BAD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_14() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2\n     DISPLAY GOOD\n   ELSE\n     DISPLAY BAD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_15() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2 THEN\n     DISPLAY GOOD\n     DISPLAY BETTER\n     DISPLAY BEST\n   ELSE\n     DISPLAY BAD\n     DISPLAY WORSE\n     DISPLAY WORST "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_16() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2\n     DISPLAY GOOD\n     DISPLAY BETTER\n     DISPLAY BEST\n   ELSE\n     DISPLAY BAD\n     DISPLAY WORSE\n     DISPLAY WORST "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_17() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2\n     DISPLAY GOOD\n   ELSE\n     NEXT SENTENCE\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_18() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2\n     NEXT SENTENCE\n   ELSE\n     DISPLAY BAD\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_19() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2 AND 2 > 1\n       DISPLAY GOOD\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_20() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF 1 < 2 AND 2 > 1 AND V-ARIABLE = 0\n       DISPLAY GOOD\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_21() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF V-ARIABLE = 2 OR = 3\n       DISPLAY PERFECT\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_22() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF ( V-ARIABLE = 2 OR = 3 ) THEN\n       DISPLAY PERFECT\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_23() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF ( V-ARIABLE = 2 OR = 3 ) AND V-ARIABLE NOT = 3\n       DISPLAY PERFECT\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_24() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF V-ARIABLE NOT = 3 AND ( V-ARIABLE = 2 OR = 3 )\n       DISPLAY PERFECT\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_25() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF B GREATER THAN C OR EQUAL TO A OR 42 OR C - 1 THEN\n       DISPLAY PERFECT\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_26() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF ZERO - A IS NEGATIVE THEN\n       DISPLAY PERFECT\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIfStatement_27() {
      ParserCombinator parser = grammar.ifStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IF SMALLEST-VALU GREATER THAN SMALL-VALU\n      AND IS NOT LESS THAN EVEN-SMALLER OR SMALLER-VALU\n       DISPLAY FAIL\n   END-IF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}