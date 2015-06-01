package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from InvokeStatement.stage. */
public class InvokeStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testInvokeStatement_1() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_2() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo AS bar "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_3() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo AS OBJECT bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_4() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo AS OBJECT \"bar\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_5() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo AS baz bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_6() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo AS baz \"bar\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_7() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_8() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING REFERENCE baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_9() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING BY REFERENCE baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_10() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING BY REFERENCE OMITTED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_11() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING BY REFERENCE ADDRESS OF baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_12() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar USING\n     BY REFERENCE baz\n     BY REFERENCE ADDRESS OF baz\n     BY REFERENCE OMITTED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_13() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING CONTENT baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_14() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING BY CONTENT baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_15() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING BY CONTENT \"baz\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_16() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING BY CONTENT baz + 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_17() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING BY CONTENT LENGTH OF baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_18() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar USING\n     BY CONTENT baz\n     BY CONTENT \"baz\"\n     BY CONTENT baz + 1\n     BY CONTENT LENGTH OF baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_19() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING VALUE baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_20() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING BY VALUE baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_21() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING BY VALUE 100 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_22() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING BY VALUE 100 SIZE 200 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_23() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING BY VALUE 100 SIZE IS 200 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_24() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING BY VALUE baz + 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_25() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING BY VALUE LENGTH OF baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_26() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar USING\n     BY VALUE baz\n     BY VALUE 100\n     BY VALUE 100 SIZE 200\n     BY VALUE baz + 1\n     BY VALUE LENGTH OF baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_27() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n   RETURNING baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_28() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n   GIVING baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_29() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n   RETURNING INTO baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_30() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n   GIVING INTO baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_31() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n   RETURNING ADDRESS OF baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_32() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n   GIVING ADDRESS OF baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_33() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar USING\n     BY REFERENCE baz\n     BY REFERENCE ADDRESS OF baz\n     BY REFERENCE OMITTED\n     BY CONTENT baz\n     BY CONTENT \"baz\"\n     BY CONTENT baz + 1\n     BY CONTENT LENGTH OF baz\n     BY VALUE baz\n     BY VALUE 100\n     BY VALUE 100 SIZE 200\n     BY VALUE baz + 1\n     BY VALUE LENGTH OF baz\n     RETURNING ADDRESS OF baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_34() {
      ParserCombinator parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVOKE foo bar\n     USING BY REFERENCE bar\n     USING BY CONTENT bar "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }
}