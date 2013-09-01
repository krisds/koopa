package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from EntryStatement.stage. */
public class EntryStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testEntryStatement_1() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_2() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_3() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\" M-E ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_4() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_5() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A FIELD-B ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_6() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\" M-E\n         USING FIELD-A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_7() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\"\n         # FIELD-A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_8() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A\n         # USING FIELD-B ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_9() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\" USING\n         REFERENCE FIELD-A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_10() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\" USING\n         BY REFERENCE FIELD-A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_11() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\" USING\n         BY REFERENCE FIELD-A DELIMITED ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_12() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\" USING\n         BY REFERENCE FIELD-A DELIMITED BY SIZE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_13() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\" USING\n         BY REFERENCE ANY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_14() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\" USING\n         VALUE FIELD-A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_15() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\" USING\n         BY VALUE FIELD-A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_16() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\" USING\n         BY VALUE ANY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_17() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\" USING\n         BY REFERENCE FIELD-A FIELD-B\n         BY VALUE FIELD-C FIELD-D ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_18() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\" \n         USING FIELD-A\n         REPEATED ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_19() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A\n         REPEATED 1 TO 100 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_20() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A\n         GIVING FIELD-B ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_21() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\"\n         GIVING FIELD-A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_22() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A\n         RETURNING FIELD-B ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_23() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\"\n         RETURNING FIELD-A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_24() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A\n         REPEATED 1 TO 100 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEntryStatement_25() {
      Parser parser = grammar.entryStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENTRY \"MAIN-ENTRANCE\"\n         USING FIELD-A\n         REPEATED 1 TO 100\n         GIVING FIELD-B ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}