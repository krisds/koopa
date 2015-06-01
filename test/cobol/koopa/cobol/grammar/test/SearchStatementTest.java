package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from SearchStatement.stage. */
public class SearchStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testAtEnd_1() {
      ParserCombinator parser = grammar.atEnd();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" AT END DISPLAY \"FOO\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAtEnd_2() {
      ParserCombinator parser = grammar.atEnd();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" END DISPLAY \"FOO\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testNotAtEnd_3() {
      ParserCombinator parser = grammar.notAtEnd();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" NOT AT END DISPLAY \"FOO\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testNotAtEnd_4() {
      ParserCombinator parser = grammar.notAtEnd();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" NOT END DISPLAY \"FOO\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_5() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_6() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_7() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES\n   WHEN TRUE\n        NEXT SENTENCE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_8() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES\n   WHEN TRUE\n        NEXT SENTENCE\n   END-SEARCH "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_9() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES VARYING EMPLOYEE-NUMBER\n   WHEN TRUE\n        DISPLAY \"Found one.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_10() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES VARYING EMPLOYEE-NUMBER\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_11() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES\n   AT END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_12() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES\n   AT END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_13() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES VARYING EMPLOYEE-NUMBER\n   AT END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_14() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES VARYING EMPLOYEE-NUMBER\n   AT END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_15() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES\n   END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_16() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES\n   END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_17() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES VARYING EMPLOYEE-NUMBER\n   END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_18() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES VARYING EMPLOYEE-NUMBER\n   END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_19() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n        DISPLAY \"Really!\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_20() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n        DISPLAY \"Really!\"\n   END-SEARCH "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_21() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   WHEN FALSE\n        DISPLAY \"Found one... not!\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_22() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   WHEN FALSE\n        DISPLAY \"Found one... not!\"\n   END-SEARCH "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_23() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n        DISPLAY \"Really!\"\n   WHEN FALSE\n        DISPLAY \"Found one... not!\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_24() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n        DISPLAY \"Really!\"\n   WHEN FALSE\n        DISPLAY \"Found one... not!\"\n   END-SEARCH "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_25() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH ALL EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_26() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH ALL EMPLOYEES\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_27() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH ALL EMPLOYEES\n   AT END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_28() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH ALL EMPLOYEES\n   AT END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_29() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH ALL EMPLOYEES\n   END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_30() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH ALL EMPLOYEES\n   END\n        DISPLAY \"No-one found.\"\n   WHEN TRUE\n        DISPLAY \"Found one.\"\n   END-SEARCH "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSearchStatement_31() {
      ParserCombinator parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEARCH ALL EMPLOYEES VARYING EMPLOYEE-NUMBER\n   WHEN TRUE\n        DISPLAY \"Found one.\" "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }
}