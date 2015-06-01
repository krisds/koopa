package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from MergeStatement.stage. */
public class MergeStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testMergeStatement_1() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_2() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 DESCENDING data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_3() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ON ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_4() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ON DESCENDING data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_5() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING KEY data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_6() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ON ASCENDING KEY data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_7() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING KEY IS data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_8() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ON ASCENDING IS data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_9() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_10() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3 file-name-4\n     GIVING file-name-5 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_11() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING data-name-1\n     SEQUENCE alphabet-name\n     USING file-name-2 file-name-3\n     GIVING file-name-4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_12() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING data-name-1\n     SEQUENCE IS alphabet-name\n     USING file-name-2 file-name-3\n     GIVING file-name-4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_13() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING data-name-1\n     COLLATING SEQUENCE alphabet-name\n     USING file-name-2 file-name-3\n     GIVING file-name-4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_14() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING data-name-1\n     COLLATING SEQUENCE IS alphabet-name\n     USING file-name-2 file-name-3\n     GIVING file-name-4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_15() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING data-name-1\n     COLLATING SEQUENCE IS alphabet-name\n     USING file-name-2 file-name-3\n     GIVING file-name-4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_16() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     OUTPUT PROCEDURE procedure-name-1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_17() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     OUTPUT PROCEDURE IS procedure-name-1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_18() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     OUTPUT PROCEDURE procedure-name-1 THROUGH procedure-name-2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_19() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     OUTPUT PROCEDURE IS procedure-name-1 THROUGH procedure-name-2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_20() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     OUTPUT PROCEDURE procedure-name-1 THRU procedure-name-2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_21() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     OUTPUT PROCEDURE IS procedure-name-1 THRU procedure-name-2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_22() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1\n     DESCENDING KEY IS data-name-1\n     ASCENDING KEY IS data-name-2\n     COLLATING SEQUENCE IS alphabet-name\n     USING file-name-2 file-name-3\n     OUTPUT PROCEDURE procedure-name-1 THROUGH procedure-name-2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_23() {
      ParserCombinator parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MERGE file-name-1\n     DESCENDING data-name-1 OF qualification-1\n     ON DESCENDING KEY data-name-2 OF qualification-2\n     USING file-name-2 file-name-3\n     GIVING file-name-4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}