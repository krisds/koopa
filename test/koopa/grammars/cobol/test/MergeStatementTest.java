package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from MergeStatement.stage. */
public class MergeStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testMergeStatement_1() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_2() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 DESCENDING data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_3() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ON ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_4() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ON DESCENDING data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_5() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING KEY data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_6() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ON ASCENDING KEY data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_7() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING KEY IS data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_8() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ON ASCENDING IS data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_9() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     GIVING file-name-4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_10() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3 file-name-4\n     GIVING file-name-5 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_11() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING data-name-1\n     SEQUENCE alphabet-name\n     USING file-name-2 file-name-3\n     GIVING file-name-4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_12() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING data-name-1\n     SEQUENCE IS alphabet-name\n     USING file-name-2 file-name-3\n     GIVING file-name-4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_13() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING data-name-1\n     COLLATING SEQUENCE alphabet-name\n     USING file-name-2 file-name-3\n     GIVING file-name-4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_14() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING data-name-1\n     COLLATING SEQUENCE IS alphabet-name\n     USING file-name-2 file-name-3\n     GIVING file-name-4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_15() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING data-name-1\n     COLLATING SEQUENCE IS alphabet-name\n     USING file-name-2 file-name-3\n     GIVING file-name-4 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_16() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     OUTPUT PROCEDURE procedure-name-1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_17() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     OUTPUT PROCEDURE IS procedure-name-1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_18() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     OUTPUT PROCEDURE procedure-name-1 THROUGH procedure-name-2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_19() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     OUTPUT PROCEDURE IS procedure-name-1 THROUGH procedure-name-2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_20() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     OUTPUT PROCEDURE procedure-name-1 THRU procedure-name-2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_21() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1 ASCENDING data-name-1\n     USING file-name-2 file-name-3\n     OUTPUT PROCEDURE IS procedure-name-1 THRU procedure-name-2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMergeStatement_22() {
      Parser parser = grammar.mergeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " MERGE file-name-1\n     DESCENDING KEY IS data-name-1\n     ASCENDING KEY IS data-name-2\n     COLLATING SEQUENCE IS alphabet-name\n     USING file-name-2 file-name-3\n     OUTPUT PROCEDURE procedure-name-1 THROUGH procedure-name-2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}