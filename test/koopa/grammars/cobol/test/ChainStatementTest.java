package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from ChainStatement.stage. */
public class ChainStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testChainStatement_1() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_2() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN \"foo\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_3() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n   END-CHAIN ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_4() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN \"foo\"\n   END-CHAIN ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_5() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_6() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING REFERENCE bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_7() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING BY REFERENCE bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_8() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING BY REFERENCE \"bar\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_9() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING BY REFERENCE ADDRESS OF bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_10() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING BY REFERENCE OMITTED ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_11() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo USING\n     BY REFERENCE bar\n     BY REFERENCE \"bar\"\n     BY REFERENCE ADDRESS OF bar\n     BY REFERENCE OMITTED ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_12() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING CONTENT bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_13() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING BY CONTENT bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_14() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING BY CONTENT \"bar\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_15() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING BY CONTENT LENGTH OF bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_16() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo USING\n     BY CONTENT bar\n     BY CONTENT \"bar\"\n     BY CONTENT LENGTH OF bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_17() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING VALUE bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_18() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING BY VALUE bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_19() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING BY VALUE 100 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_20() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING BY VALUE 100 SIZE 200 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_21() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING BY VALUE 100 SIZE IS 200 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_22() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING BY VALUE LENGTH OF bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_23() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo USING\n     BY VALUE bar\n     BY VALUE 100\n     BY VALUE 100 SIZE 200\n     BY VALUE LENGTH OF bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_24() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo USING\n     BY REFERENCE bar\n     BY REFERENCE \"bar\"\n     BY REFERENCE ADDRESS OF bar\n     BY REFERENCE OMITTED\n     BY CONTENT bar\n     BY CONTENT \"bar\"\n     BY CONTENT LENGTH OF bar\n     BY VALUE bar\n     BY VALUE 100\n     BY VALUE 100 SIZE 200\n     BY VALUE LENGTH OF bar\n   END-CHAIN ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testChainStatement_25() {
      Parser parser = grammar.chainStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAIN foo\n     USING BY REFERENCE bar\n     USING BY CONTENT bar ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }
}