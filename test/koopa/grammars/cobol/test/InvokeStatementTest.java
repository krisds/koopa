package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from InvokeStatement.stage. */
public class InvokeStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testInvokeStatement_1() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_2() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo AS bar ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_3() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo AS OBJECT bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_4() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo AS OBJECT \"bar\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_5() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo AS baz bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_6() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo AS baz \"bar\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_7() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_8() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING REFERENCE baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_9() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING BY REFERENCE baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_10() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING BY REFERENCE OMITTED ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_11() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING BY REFERENCE ADDRESS OF baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_12() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar USING\n     BY REFERENCE baz\n     BY REFERENCE ADDRESS OF baz\n     BY REFERENCE OMITTED ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_13() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING CONTENT baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_14() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING BY CONTENT baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_15() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING BY CONTENT \"baz\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_16() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING BY CONTENT baz + 1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_17() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING BY CONTENT LENGTH OF baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_18() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar USING\n     BY CONTENT baz\n     BY CONTENT \"baz\"\n     BY CONTENT baz + 1\n     BY CONTENT LENGTH OF baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_19() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING VALUE baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_20() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING BY VALUE baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_21() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING BY VALUE 100 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_22() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING BY VALUE 100 SIZE 200 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_23() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING BY VALUE 100 SIZE IS 200 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_24() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING BY VALUE baz + 1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_25() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING BY VALUE LENGTH OF baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_26() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar USING\n     BY VALUE baz\n     BY VALUE 100\n     BY VALUE 100 SIZE 200\n     BY VALUE baz + 1\n     BY VALUE LENGTH OF baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_27() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n   RETURNING baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_28() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n   GIVING baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_29() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n   RETURNING INTO baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_30() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n   GIVING INTO baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_31() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n   RETURNING ADDRESS OF baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_32() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n   GIVING ADDRESS OF baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_33() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar USING\n     BY REFERENCE baz\n     BY REFERENCE ADDRESS OF baz\n     BY REFERENCE OMITTED\n     BY CONTENT baz\n     BY CONTENT \"baz\"\n     BY CONTENT baz + 1\n     BY CONTENT LENGTH OF baz\n     BY VALUE baz\n     BY VALUE 100\n     BY VALUE 100 SIZE 200\n     BY VALUE baz + 1\n     BY VALUE LENGTH OF baz\n     RETURNING ADDRESS OF baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvokeStatement_34() {
      Parser parser = grammar.invokeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INVOKE foo bar\n     USING BY REFERENCE bar\n     USING BY CONTENT bar ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }
}