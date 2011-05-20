package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from StringStatement.stage. */
public class StringStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testStringStatement_1() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING A B C INTO TEXT  KOOPAH_TO_HERE  .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_2() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING A B C INTO TEXT WITH POINTER MY-POINTER  KOOPAH_TO_HERE  .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_3() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING A B C INTO TEXT WITH POINTER MY-POINTER\n   END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_4() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING A B C INTO TEXT\n   END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_5() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING A B C INTO TEXT\n     ON OVERFLOW DISPLAY \"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_6() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING A B C INTO TEXT\n     ON OVERFLOW DISPLAY \"Oops.\"\n   END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_7() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING A B C INTO TEXT\n     NOT ON OVERFLOW DISPLAY \"AOK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_8() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING A B C INTO TEXT\n     NOT ON OVERFLOW DISPLAY \"AOK.\"\n   END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_9() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING A B C INTO TEXT\n     OVERFLOW DISPLAY \"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_10() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING A B C INTO TEXT\n     OVERFLOW DISPLAY \"Oops.\"\n   END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_11() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING A B C INTO TEXT\n     NOT OVERFLOW DISPLAY \"AOK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_12() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING A B C INTO TEXT\n     NOT OVERFLOW DISPLAY \"AOK.\"\n   END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_13() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING A B C INTO TEXT\n     OVERFLOW DISPLAY \"Oops.\"\n     NOT OVERFLOW DISPLAY \"AOK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_14() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("STRING A B C INTO TEXT\n     OVERFLOW DISPLAY \"Oops.\"\n     NOT OVERFLOW DISPLAY \"AOK.\"\n   END-STRING");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}