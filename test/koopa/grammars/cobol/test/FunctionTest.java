package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from Function.stage. */
public class FunctionTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testIdentifier_format1_1() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION ACOS ( IND ( 5 ) / 9 )");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_2() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION ANNUITY ( B / 2  8 )");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_3() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION LENGTH ( \"A\" )");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_4() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION MAX ( A * B  ( C + 1 ) / 2  3 + 4 )");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_5() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION RANDOM");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_6() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FUNCTION SUM ( 5 -2 -14 0 )");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}