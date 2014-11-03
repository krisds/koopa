package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.sources.test.TestTokenizer;
import koopa.core.parsers.Parser;

import org.junit.Test;

/** This code was generated from StringStatement.stage. */
public class StringStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

    @Test
    public void testStringStatement_1() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STRING A B C INTO TEXT # . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_2() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STRING A B C INTO TEXT WITH POINTER MY-POINTER # . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_3() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STRING A B C INTO TEXT WITH POINTER MY-POINTER\n   END-STRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_4() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STRING A B C INTO TEXT\n   END-STRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_5() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STRING A B C INTO TEXT\n     ON OVERFLOW DISPLAY \"Oops.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_6() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STRING A B C INTO TEXT\n     ON OVERFLOW DISPLAY \"Oops.\"\n   END-STRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_7() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STRING A B C INTO TEXT\n     NOT ON OVERFLOW DISPLAY \"AOK.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_8() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STRING A B C INTO TEXT\n     NOT ON OVERFLOW DISPLAY \"AOK.\"\n   END-STRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_9() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STRING A B C INTO TEXT\n     OVERFLOW DISPLAY \"Oops.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_10() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STRING A B C INTO TEXT\n     OVERFLOW DISPLAY \"Oops.\"\n   END-STRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_11() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STRING A B C INTO TEXT\n     NOT OVERFLOW DISPLAY \"AOK.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_12() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STRING A B C INTO TEXT\n     NOT OVERFLOW DISPLAY \"AOK.\"\n   END-STRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_13() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STRING A B C INTO TEXT\n     OVERFLOW DISPLAY \"Oops.\"\n     NOT OVERFLOW DISPLAY \"AOK.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_14() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STRING A B C INTO TEXT\n     OVERFLOW DISPLAY \"Oops.\"\n     NOT OVERFLOW DISPLAY \"AOK.\"\n   END-STRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStringStatement_15() {
      Parser parser = grammar.stringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STRING\n      'ABCD001. CALL TO T456 FAILED. STATUS= '\n      T6O4-TRANS-STATUS(1,2) \n      ' '  \n     DELIMITED BY SIZE INTO P122-TEXT\n   END-STRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}