package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from SearchStatement.stage. */
public class SearchStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testAtEnd_1() {
      Parser parser = grammar.atEnd();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " AT END DISPLAY \"FOO\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAtEnd_2() {
      Parser parser = grammar.atEnd();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " END DISPLAY \"FOO\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testNotAtEnd_3() {
      Parser parser = grammar.notAtEnd();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " NOT AT END DISPLAY \"FOO\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testNotAtEnd_4() {
      Parser parser = grammar.notAtEnd();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " NOT END DISPLAY \"FOO\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_5() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_6() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_7() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES\n   WHEN TRUE\n        NEXT SENTENCE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_8() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES\n   WHEN TRUE\n        NEXT SENTENCE\n   END-SEARCH ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_9() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES VARYING EMPLOYEE-NUMBER\n   WHEN TRUE\n        DISPLAY \"Found one.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_10() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES VARYING EMPLOYEE-NUMBER\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_11() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES\n   AT END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_12() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES\n   AT END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_13() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES VARYING EMPLOYEE-NUMBER\n   AT END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_14() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES VARYING EMPLOYEE-NUMBER\n   AT END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_15() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES\n   END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_16() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES\n   END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_17() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES VARYING EMPLOYEE-NUMBER\n   END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_18() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES VARYING EMPLOYEE-NUMBER\n   END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_19() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n        DISPLAY \"Really!\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_20() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n        DISPLAY \"Really!\"\n   END-SEARCH ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_21() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   WHEN FALSE\n        DISPLAY \"Found one... not!\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_22() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   WHEN FALSE\n        DISPLAY \"Found one... not!\"\n   END-SEARCH ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_23() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n        DISPLAY \"Really!\"\n   WHEN FALSE\n        DISPLAY \"Found one... not!\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_24() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n        DISPLAY \"Really!\"\n   WHEN FALSE\n        DISPLAY \"Found one... not!\"\n   END-SEARCH ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_25() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH ALL EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_26() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH ALL EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_27() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH ALL EMPLOYEES\n   AT END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_28() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH ALL EMPLOYEES\n   AT END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_29() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH ALL EMPLOYEES\n   END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_30() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH ALL EMPLOYEES\n   END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_31() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEARCH ALL EMPLOYEES VARYING EMPLOYEE-NUMBER\n   WHEN TRUE\n        DISPLAY \"Found one.\" ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }
}