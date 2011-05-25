package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from UnstringStatement.stage. */
public class UnstringStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testUnstringStatement_1() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT INTO PART1 PART2 PART3 \u2022 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_2() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT INTO PART1 PART2 PART3\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_3() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     DELIMITED BY MARKER\n     INTO PART1 PART2 PART3\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_4() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     DELIMITED BY \"Z\"\n     INTO PART1 PART2 PART3\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_5() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     DELIMITED BY ALL MARKER\n     INTO PART1 PART2 PART3\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_6() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     DELIMITED BY ALL \"Z\"\n     INTO PART1 PART2 PART3\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_7() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     DELIMITED MARKER\n     INTO PART1 PART2 PART3\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_8() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     DELIMITED \"Z\"\n     INTO PART1 PART2 PART3\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_9() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     DELIMITED ALL MARKER\n     INTO PART1 PART2 PART3\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_10() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     DELIMITED ALL \"Z\"\n     INTO PART1 PART2 PART3\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_11() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     DELIMITED BY ALL M1 OR ALL M2\n     INTO PART1 PART2 PART3\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_12() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     DELIMITED BY ALL \"Z\" OR ALL \"Y\"\n     INTO PART1 PART2 PART3\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_13() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     DELIMITED BY M1 OR M2\n     INTO PART1 PART2 PART3\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_14() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     DELIMITED BY \"Z\" OR \"Y\"\n     INTO PART1 PART2 PART3\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_15() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     DELIMITED BY M1 OR ALL \"X\" OR ALL M2 OR \"Y\"\n     INTO PART1 PART2 PART3\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_16() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     INTO PART1\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_17() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     INTO PART1 DELIMITER IN X\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_18() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     INTO PART1 DELIMITER X\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_19() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     INTO PART1 COUNT IN Y\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_20() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     INTO PART1 COUNT Y\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_21() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     INTO PART1 DELIMITER IN X COUNT IN Y\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_22() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     INTO PART1 DELIMITER X COUNT Y\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_23() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     INTO PART1 DELIMITER X COUNT Y\n          PART2 DELIMITER A COUNT B\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_24() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     INTO PART1\n          PART2 DELIMITER A\n          PART3 COUNT B\n          PART4 DELIMITER A COUNT B\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_25() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     INTO PART1\n     WITH POINTER MY-POINTER\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_26() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     INTO PART1\n     POINTER MY-POINTER\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_27() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     INTO PART1\n     TALLYING IN MY-COUNT\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_28() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     INTO PART1\n     TALLYING MY-COUNT\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_29() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT\n     DELIMITED BY M1 OR ALL \"X\" OR ALL M2 OR \"Y\"\n     INTO PART1\n          PART2 DELIMITER A\n          PART3 COUNT B\n          PART4 DELIMITER A COUNT B\n     WITH POINTER MY-POINTER\n     TALLYING IN MY-COUNT\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_30() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT INTO PART1 PART2 PART3\n     ON OVERFLOW DISPLAY \"Oops.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_31() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT INTO PART1 PART2 PART3\n     ON OVERFLOW DISPLAY \"Oops.\"\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_32() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT INTO PART1 PART2 PART3\n     NOT ON OVERFLOW DISPLAY \"AOK.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_33() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT INTO PART1 PART2 PART3\n     NOT ON OVERFLOW DISPLAY \"AOK.\"\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_34() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT INTO PART1 PART2 PART3\n     OVERFLOW DISPLAY \"Oops.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_35() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT INTO PART1 PART2 PART3\n     OVERFLOW DISPLAY \"Oops.\"\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_36() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT INTO PART1 PART2 PART3\n     NOT OVERFLOW DISPLAY \"AOK.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_37() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT INTO PART1 PART2 PART3\n     NOT OVERFLOW DISPLAY \"AOK.\"\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_38() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT INTO PART1 PART2 PART3\n     OVERFLOW DISPLAY \"Oops.\"\n     NOT OVERFLOW DISPLAY \"AOK.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnstringStatement_39() {
      Parser parser = grammar.unstringStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " UNSTRING TEXT INTO PART1 PART2 PART3\n     OVERFLOW DISPLAY \"Oops.\"\n     NOT OVERFLOW DISPLAY \"AOK.\"\n   END-UNSTRING ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}