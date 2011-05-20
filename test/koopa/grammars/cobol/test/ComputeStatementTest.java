package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from ComputeStatement.stage. */
public class ComputeStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testComputeStatement_1() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE A = B + C  KOOPAH_TO_HERE  .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_2() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE A = B + C\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_3() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE A = B + C\n     SIZE ERROR\n        DISPLAY \"OOPS\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_4() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE A = B + C\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_5() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE A = B + C\n     NOT SIZE ERROR\n        DISPLAY \"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_6() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE A = B + C\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_7() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE A = B + C\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\"\n   END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_8() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE A = B + C\n   END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_9() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE WS-NUM = FUNCTION ACOS ( IND ( 5 ) / 9 ) \n   END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_10() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE WS-NUM = FUNCTION ANNUITY ( B / 2  8 )\n   END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_11() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE WS-INT = FUNCTION LENGTH ( \"A\" )\n   END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_12() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE WS-NUM = FUNCTION MAX ( A * B  ( C + 1 ) / 2  3 + 4 )\n   END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_13() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE WS-NUM = FUNCTION RANDOM END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testComputeStatement_14() {
      Parser parser = grammar.computeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COMPUTE WS-NUM = FUNCTION SUM ( 5 -2 -14 0 ) END-COMPUTE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}