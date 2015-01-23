package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parser;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from TransformStatement.stage. */
public class TransformStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testTransformStatement_1() {
      Parser parser = grammar.transformStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TRANSFORM foo FROM bar TO baz "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTransformStatement_2() {
      Parser parser = grammar.transformStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TRANSFORM foo CHARACTERS FROM bar TO baz "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTransformStatement_3() {
      Parser parser = grammar.transformStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TRANSFORM foo FROM \"bar\" TO baz "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTransformStatement_4() {
      Parser parser = grammar.transformStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TRANSFORM foo FROM bar TO \"baz\" "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTransformStatement_5() {
      Parser parser = grammar.transformStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TRANSFORM foo FROM \"bar\" TO \"baz\" "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTransformStatement_6() {
      Parser parser = grammar.transformStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TRANSFORM foo FROM bar TO 100 "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testTransformStatement_7() {
      Parser parser = grammar.transformStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TRANSFORM foo FROM 100 TO baz "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }
}