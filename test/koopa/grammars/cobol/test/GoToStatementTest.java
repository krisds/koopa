package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from GoToStatement.stage. */
public class GoToStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testGoToStatement_1() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "GO TO OTHER-PLACE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_2() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "GO OTHER-PLACE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_3() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "GO TO 42");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_4() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "GO 42");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_5() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "GO TO OTHER-PLACE\n     DEPENDING ON SOME-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_6() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "GO OTHER-PLACE\n     DEPENDING ON SOME-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_7() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "GO TO OTHER-PLACE\n         YET-ANOTHER-PLACE\n         STILL-SOME-OTHER-PLACE\n     DEPENDING ON SOME-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_8() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "GO OTHER-PLACE\n         YET-ANOTHER-PLACE\n         STILL-SOME-OTHER-PLACE\n     DEPENDING ON SOME-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_9() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "GO TO OTHER-PLACE\n         YET-ANOTHER-PLACE\n         STILL-SOME-OTHER-PLACE\n     DEPENDING SOME-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGoToStatement_10() {
      Parser parser = grammar.goToStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "GO OTHER-PLACE\n         YET-ANOTHER-PLACE\n         STILL-SOME-OTHER-PLACE\n     DEPENDING SOME-VALUE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}