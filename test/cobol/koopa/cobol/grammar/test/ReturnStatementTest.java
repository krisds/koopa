package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from ReturnStatement.stage. */
public class ReturnStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testReturnStatement_1() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_2() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_3() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE\n     AT END DISPLAY \"At end.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_4() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE\n     AT END DISPLAY \"At end.\"\n   END-RETURN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_5() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE RECORD\n     AT END DISPLAY \"At end.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_6() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE RECORD\n     AT END DISPLAY \"At end.\"\n   END-RETURN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_7() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE INTO MY-FIELD\n     AT END DISPLAY \"At end.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_8() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE INTO MY-FIELD\n     AT END DISPLAY \"At end.\"\n   END-RETURN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_9() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE RECORD INTO MY-FIELD\n     AT END DISPLAY \"At end.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_10() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE RECORD INTO MY-FIELD\n     AT END DISPLAY \"At end.\"\n   END-RETURN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_11() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_12() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\"\n   END-RETURN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_13() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE RECORD\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_14() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE RECORD\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\"\n   END-RETURN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_15() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE INTO MY-FIELD\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_16() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE INTO MY-FIELD\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\"\n   END-RETURN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_17() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE RECORD INTO MY-FIELD\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_18() {
      ParserCombinator parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RETURN MY-FILE RECORD INTO MY-FIELD\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\"\n   END-RETURN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}