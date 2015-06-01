package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from ComputeStatement.stage. */
public class ComputeStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testComputeStatement_1() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE A = B + C # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_2() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE A = B + C\n     ON SIZE ERROR\n        DISPLAY \"OOPS\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_3() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE A = B + C\n     SIZE ERROR\n        DISPLAY \"OOPS\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_4() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE A = B + C\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_5() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE A = B + C\n     NOT SIZE ERROR\n        DISPLAY \"AOK\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_6() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE A = B + C\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_7() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE A = B + C\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\"\n   END-COMPUTE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_8() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE A = B + C\n   END-COMPUTE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_9() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE WS-NUM = FUNCTION ACOS ( IND ( 5 ) / 9 ) \n   END-COMPUTE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_10() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE WS-NUM = FUNCTION ANNUITY ( B / 2  8 )\n   END-COMPUTE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_11() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE WS-INT = FUNCTION LENGTH ( \"A\" )\n   END-COMPUTE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_12() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE WS-NUM = FUNCTION MAX ( A * B  ( C + 1 ) / 2  3 + 4 )\n   END-COMPUTE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_13() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE WS-NUM = FUNCTION RANDOM END-COMPUTE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_14() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE WS-NUM = FUNCTION SUM ( 5 -2 -14 0 ) END-COMPUTE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_15() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE FUNCTION FN ( X ) = A + B "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_16() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE EXCEPTION-OBJECT = A + B "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_17() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE NULL = A + B "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_18() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE SELF = A + B "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_19() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE SUPER = A + B "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_20() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE MY-CLASS-NAME OF SUPER = A + B "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_21() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE ADDRESS OF SOMETHING = A + B "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_22() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE A = B * LENGTH OF C "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_23() {
      ParserCombinator parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTE XYZ OF TEST-RESP =\n    PACKET-COUNT OF TEST-RESP *\n    LENGTH OF RESPONSE-RECORD OF TEST-RESP\n   END-COMPUTE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}