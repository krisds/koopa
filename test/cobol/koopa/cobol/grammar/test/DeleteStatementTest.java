package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from DeleteStatement.stage. */
public class DeleteStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testDeleteStatement_1() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_2() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE RECORD # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_3() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE\n   END-DELETE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_4() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE RECORD\n   END-DELETE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_5() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE \n   INVALID KEY\n      DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_6() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE RECORD\n   INVALID KEY\n      DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_7() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE \n   INVALID\n      DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_8() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE RECORD\n   INVALID\n      DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_9() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE \n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_10() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE RECORD\n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_11() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE \n   NOT INVALID\n      DISPLAY \"A-OK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_12() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE RECORD\n   NOT INVALID\n      DISPLAY \"A-OK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_13() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE \n   INVALID KEY\n      DISPLAY \"Oops.\" \n   END-DELETE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_14() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE RECORD\n   INVALID KEY\n      DISPLAY \"Oops.\" \n   END-DELETE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_15() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE \n   INVALID\n      DISPLAY \"Oops.\" \n   END-DELETE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_16() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE RECORD\n   INVALID\n      DISPLAY \"Oops.\" \n   END-DELETE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_17() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE \n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" \n   END-DELETE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_18() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE RECORD\n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" \n   END-DELETE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_19() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE \n   NOT INVALID\n      DISPLAY \"A-OK.\" \n   END-DELETE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeleteStatement_20() {
      ParserCombinator parser = grammar.deleteStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELETE MY-FILE RECORD\n   NOT INVALID\n      DISPLAY \"A-OK.\" \n   END-DELETE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}