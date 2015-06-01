package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from SortStatement.stage. */
public class SortStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testSortStatement_1() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING bar\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_2() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON DESCENDING bar\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_3() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY bar\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_4() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY IS bar\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_5() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY bar baz\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_6() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY IS bar\n     DUPLICATES\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_7() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY IS bar\n     WITH DUPLICATES\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_8() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY IS bar\n     WITH DUPLICATES IN ORDER\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_9() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY IS bar\n     WITH DUPLICATES IN ORDER\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_10() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY IS bar\n     SEQUENCE abc\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_11() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY IS bar\n     COLLATING SEQUENCE abc\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_12() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY IS bar\n     COLLATING SEQUENCE IS abc\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_13() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY IS bar\n     INPUT PROCEDURE p1 THROUGH p3\n     OUTPUT PROCEDURE p2 THROUGH p4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_14() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY IS bar\n     INPUT PROCEDURE p1 THRU p3\n     OUTPUT PROCEDURE p2 THRU p4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_15() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY IS bar\n     USING f1\n     OUTPUT PROCEDURE p2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_16() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY IS bar\n     INPUT PROCEDURE p1\n     GIVING f1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_17() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY IS bar\n     USING f1\n     GIVING f2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_18() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY IS bar\n     USING f1 f2\n     GIVING f3 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_19() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING KEY IS bar\n     USING f1 f2\n     GIVING f3 f4 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_20() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON ASCENDING bar DESCENDING baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_21() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON DESCENDING KEY bar DESCENDING KEY baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_22() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON DESCENDING KEY IS bar DESCENDING KEY IS baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_23() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON DESCENDING KEY IS bar\n     WITH DUPLICATES IN ORDER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_24() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT foo ON DESCENDING KEY IS bar\n     WITH DUPLICATES IN ORDER\n     COLLATING SEQUENCE IS abc "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_25() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT ST-FS1\n     ON ASCENDING KEY A-KEY OF SORT-KEY\n     ASCENDING N-KEY OF NON-KEY-2\n     USING SQ-FS1\n     GIVING SQ-FS2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_26() {
      ParserCombinator parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SORT SORT1\n     ON DESCENDING KEY S1-1\n     ON ASCENDING KEY S1-2\n     USING FILE1\n     GIVING FILE2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}