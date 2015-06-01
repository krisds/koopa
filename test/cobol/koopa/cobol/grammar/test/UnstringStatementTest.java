package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from UnstringStatement.stage. */
public class UnstringStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testUnstringStatement_1() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT INTO PART1 PART2 PART3 # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_2() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT INTO PART1 PART2 PART3\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_3() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     DELIMITED BY MARKER\n     INTO PART1 PART2 PART3\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_4() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     DELIMITED BY \"Z\"\n     INTO PART1 PART2 PART3\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_5() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     DELIMITED BY ALL MARKER\n     INTO PART1 PART2 PART3\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_6() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     DELIMITED BY ALL \"Z\"\n     INTO PART1 PART2 PART3\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_7() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     DELIMITED MARKER\n     INTO PART1 PART2 PART3\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_8() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     DELIMITED \"Z\"\n     INTO PART1 PART2 PART3\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_9() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     DELIMITED ALL MARKER\n     INTO PART1 PART2 PART3\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_10() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     DELIMITED ALL \"Z\"\n     INTO PART1 PART2 PART3\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_11() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     DELIMITED BY ALL M1 OR ALL M2\n     INTO PART1 PART2 PART3\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_12() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     DELIMITED BY ALL \"Z\" OR ALL \"Y\"\n     INTO PART1 PART2 PART3\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_13() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     DELIMITED BY M1 OR M2\n     INTO PART1 PART2 PART3\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_14() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     DELIMITED BY \"Z\" OR \"Y\"\n     INTO PART1 PART2 PART3\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_15() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     DELIMITED BY M1 OR ALL \"X\" OR ALL M2 OR \"Y\"\n     INTO PART1 PART2 PART3\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_16() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     INTO PART1\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_17() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     INTO PART1 DELIMITER IN X\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_18() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     INTO PART1 DELIMITER X\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_19() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     INTO PART1 COUNT IN Y\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_20() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     INTO PART1 COUNT Y\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_21() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     INTO PART1 DELIMITER IN X COUNT IN Y\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_22() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     INTO PART1 DELIMITER X COUNT Y\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_23() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     INTO PART1 DELIMITER X COUNT Y\n          PART2 DELIMITER A COUNT B\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_24() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     INTO PART1\n          PART2 DELIMITER A\n          PART3 COUNT B\n          PART4 DELIMITER A COUNT B\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_25() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     INTO PART1\n     WITH POINTER MY-POINTER\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_26() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     INTO PART1\n     POINTER MY-POINTER\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_27() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     INTO PART1\n     TALLYING IN MY-COUNT\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_28() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     INTO PART1\n     TALLYING MY-COUNT\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_29() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT\n     DELIMITED BY M1 OR ALL \"X\" OR ALL M2 OR \"Y\"\n     INTO PART1\n          PART2 DELIMITER A\n          PART3 COUNT B\n          PART4 DELIMITER A COUNT B\n     WITH POINTER MY-POINTER\n     TALLYING IN MY-COUNT\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_30() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT INTO PART1 PART2 PART3\n     ON OVERFLOW DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_31() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT INTO PART1 PART2 PART3\n     ON OVERFLOW DISPLAY \"Oops.\"\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_32() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT INTO PART1 PART2 PART3\n     NOT ON OVERFLOW DISPLAY \"AOK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_33() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT INTO PART1 PART2 PART3\n     NOT ON OVERFLOW DISPLAY \"AOK.\"\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_34() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT INTO PART1 PART2 PART3\n     OVERFLOW DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_35() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT INTO PART1 PART2 PART3\n     OVERFLOW DISPLAY \"Oops.\"\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_36() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT INTO PART1 PART2 PART3\n     NOT OVERFLOW DISPLAY \"AOK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_37() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT INTO PART1 PART2 PART3\n     NOT OVERFLOW DISPLAY \"AOK.\"\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_38() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT INTO PART1 PART2 PART3\n     OVERFLOW DISPLAY \"Oops.\"\n     NOT OVERFLOW DISPLAY \"AOK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_39() {
      ParserCombinator parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNSTRING TEXT INTO PART1 PART2 PART3\n     OVERFLOW DISPLAY \"Oops.\"\n     NOT OVERFLOW DISPLAY \"AOK.\"\n   END-UNSTRING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}