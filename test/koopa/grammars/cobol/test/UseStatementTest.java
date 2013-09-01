package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from UseStatement.stage. */
public class UseStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testUseStatement_1() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER ERROR PROCEDURE foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_2() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER EXCEPTION PROCEDURE foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_3() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE GLOBAL AFTER ERROR PROCEDURE foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_4() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE GLOBAL AFTER EXCEPTION PROCEDURE foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_5() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER STANDARD ERROR PROCEDURE foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_6() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER STANDARD EXCEPTION PROCEDURE foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_7() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE GLOBAL AFTER STANDARD ERROR PROCEDURE foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_8() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE GLOBAL AFTER STANDARD EXCEPTION PROCEDURE foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_9() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER ERROR PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_10() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER ERROR PROCEDURE ON foo bar . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_11() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER ERROR PROCEDURE ON INPUT . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_12() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER ERROR PROCEDURE ON OUTPUT . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_13() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER ERROR PROCEDURE ON I-O . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_14() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER ERROR PROCEDURE ON EXTEND . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_15() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER ERROR\n    PROCEDURE ON foo\n    GIVING bar . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_16() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER ERROR\n    PROCEDURE ON foo\n    GIVING bar baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_17() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE GLOBAL AFTER LABEL PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_18() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE GLOBAL AFTER STANDARD LABEL PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_19() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER LABEL PROCEDURE foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_20() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER LABEL PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_21() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER LABEL PROCEDURE ON foo bar . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_22() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER LABEL PROCEDURE ON OUTPUT . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_23() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER LABEL PROCEDURE ON INPUT . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_24() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER LABEL PROCEDURE ON I-O . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_25() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER LABEL PROCEDURE ON EXTEND . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_26() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER STANDARD LABEL PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_27() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER STANDARD BEGINNING LABEL PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_28() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER STANDARD ENDING LABEL PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_29() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER STANDARD FILE LABEL PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_30() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER STANDARD REEL LABEL PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_31() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER STANDARD UNIT LABEL PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_32() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER BEGINNING FILE LABEL PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_33() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER BEGINNING REEL LABEL PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_34() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER BEGINNING UNIT LABEL PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_35() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER ENDING FILE LABEL PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_36() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER ENDING REEL LABEL PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_37() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USE AFTER ENDING UNIT LABEL PROCEDURE ON foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}