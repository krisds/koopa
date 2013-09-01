package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from SortStatement.stage. */
public class SortStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testSortStatement_1() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING bar\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_2() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON DESCENDING bar\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_3() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY bar\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_4() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY IS bar\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_5() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY bar baz\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_6() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY IS bar\n     DUPLICATES\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_7() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY IS bar\n     WITH DUPLICATES\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_8() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY IS bar\n     WITH DUPLICATES IN ORDER\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_9() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY IS bar\n     WITH DUPLICATES IN ORDER\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_10() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY IS bar\n     SEQUENCE abc\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_11() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY IS bar\n     COLLATING SEQUENCE abc\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_12() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY IS bar\n     COLLATING SEQUENCE IS abc\n     INPUT PROCEDURE p1\n     OUTPUT PROCEDURE p2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_13() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY IS bar\n     INPUT PROCEDURE p1 THROUGH p3\n     OUTPUT PROCEDURE p2 THROUGH p4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_14() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY IS bar\n     INPUT PROCEDURE p1 THRU p3\n     OUTPUT PROCEDURE p2 THRU p4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_15() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY IS bar\n     USING f1\n     OUTPUT PROCEDURE p2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_16() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY IS bar\n     INPUT PROCEDURE p1\n     GIVING f1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_17() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY IS bar\n     USING f1\n     GIVING f2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_18() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY IS bar\n     USING f1 f2\n     GIVING f3 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_19() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING KEY IS bar\n     USING f1 f2\n     GIVING f3 f4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_20() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON ASCENDING bar DESCENDING baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_21() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON DESCENDING KEY bar DESCENDING KEY baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_22() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON DESCENDING KEY IS bar DESCENDING KEY IS baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_23() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON DESCENDING KEY IS bar\n     WITH DUPLICATES IN ORDER ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_24() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT foo ON DESCENDING KEY IS bar\n     WITH DUPLICATES IN ORDER\n     COLLATING SEQUENCE IS abc ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_25() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT ST-FS1\n     ON ASCENDING KEY A-KEY OF SORT-KEY\n     ASCENDING N-KEY OF NON-KEY-2\n     USING SQ-FS1\n     GIVING SQ-FS2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSortStatement_26() {
      Parser parser = grammar.sortStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SORT SORT1\n     ON DESCENDING KEY S1-1\n     ON ASCENDING KEY S1-2\n     USING FILE1\n     GIVING FILE2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}