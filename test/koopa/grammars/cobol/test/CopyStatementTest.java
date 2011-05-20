package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from CopyStatement.stage. */
public class CopyStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testCopyStatement_1() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY FOO .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCopyStatement_2() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY FOO IN FUM .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCopyStatement_3() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY FOO REPLACING ==FEE== BY ==FUM== .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCopyStatement_4() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY FOO REPLACING FEE BY FUM .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCopyStatement_5() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY FOO REPLACING \"FEE\" BY \"FUM\" .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCopyStatement_6() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY FOO SUPPRESS .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCopyStatement_7() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY FOO IN FUM SUPPRESS .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCopyStatement_8() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY FOO SUPPRESS REPLACING ==FEE== BY ==FUM== .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCopyStatement_9() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY FOO SUPPRESS REPLACING FEE BY FUM .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCopyStatement_10() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY FOO SUPPRESS REPLACING \"FEE\" BY \"FUM\" .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCopyStatement_11() {
      Parser parser = grammar.copyStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("COPY \"WORKSTOR.WS\" .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}