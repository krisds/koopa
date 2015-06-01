package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from EntryStatement.stage. */
public class EntryStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testEntryStatement_1() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_2() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_3() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\" M-E "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_4() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_5() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A FIELD-B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_6() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\" M-E\n         USING FIELD-A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_7() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\"\n         # FIELD-A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_8() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A\n         # USING FIELD-B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_9() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\" USING\n         REFERENCE FIELD-A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_10() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\" USING\n         BY REFERENCE FIELD-A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_11() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\" USING\n         BY REFERENCE FIELD-A DELIMITED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_12() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\" USING\n         BY REFERENCE FIELD-A DELIMITED BY SIZE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_13() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\" USING\n         BY REFERENCE ANY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_14() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\" USING\n         VALUE FIELD-A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_15() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\" USING\n         BY VALUE FIELD-A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_16() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\" USING\n         BY VALUE ANY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_17() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\" USING\n         BY REFERENCE FIELD-A FIELD-B\n         BY VALUE FIELD-C FIELD-D "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_18() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\" \n         USING FIELD-A\n         REPEATED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_19() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A\n         REPEATED 1 TO 100 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_20() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A\n         GIVING FIELD-B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_21() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\"\n         GIVING FIELD-A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_22() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A\n         RETURNING FIELD-B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_23() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\"\n         RETURNING FIELD-A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_24() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A\n         REPEATED 1 TO 100 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_25() {
      ParserCombinator parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A\n         REPEATED 1 TO 100\n         GIVING FIELD-B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}