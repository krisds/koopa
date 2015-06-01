package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from UseStatement.stage. */
public class UseStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testUseStatement_1() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER ERROR PROCEDURE foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_2() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER EXCEPTION PROCEDURE foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_3() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE GLOBAL AFTER ERROR PROCEDURE foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_4() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE GLOBAL AFTER EXCEPTION PROCEDURE foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_5() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER STANDARD ERROR PROCEDURE foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_6() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER STANDARD EXCEPTION PROCEDURE foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_7() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE GLOBAL AFTER STANDARD ERROR PROCEDURE foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_8() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE GLOBAL AFTER STANDARD EXCEPTION PROCEDURE foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_9() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER ERROR PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_10() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER ERROR PROCEDURE ON foo bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_11() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER ERROR PROCEDURE ON INPUT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_12() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER ERROR PROCEDURE ON OUTPUT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_13() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER ERROR PROCEDURE ON I-O "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_14() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER ERROR PROCEDURE ON EXTEND "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_15() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER ERROR\n    PROCEDURE ON foo\n    GIVING bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_16() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER ERROR\n    PROCEDURE ON foo\n    GIVING bar baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_17() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE GLOBAL AFTER LABEL PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_18() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE GLOBAL AFTER STANDARD LABEL PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_19() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER LABEL PROCEDURE foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_20() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER LABEL PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_21() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER LABEL PROCEDURE ON foo bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_22() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER LABEL PROCEDURE ON OUTPUT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_23() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER LABEL PROCEDURE ON INPUT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_24() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER LABEL PROCEDURE ON I-O "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_25() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER LABEL PROCEDURE ON EXTEND "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_26() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER STANDARD LABEL PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_27() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER STANDARD BEGINNING LABEL PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_28() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER STANDARD ENDING LABEL PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_29() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER STANDARD FILE LABEL PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_30() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER STANDARD REEL LABEL PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_31() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER STANDARD UNIT LABEL PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_32() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER BEGINNING FILE LABEL PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_33() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER BEGINNING REEL LABEL PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_34() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER BEGINNING UNIT LABEL PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_35() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER ENDING FILE LABEL PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_36() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER ENDING REEL LABEL PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUseStatement_37() {
      ParserCombinator parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USE AFTER ENDING UNIT LABEL PROCEDURE ON foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}