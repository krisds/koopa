package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from RepositoryParagraph.stage. */
public class RepositoryParagraphTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testRepositoryParagraph_1() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     FUNCTION ALL INTRINSIC . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_2() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     FUNCTION foo INTRINSIC . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_3() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     FUNCTION foo . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_4() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     FUNCTION foo AS \"foo\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_5() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     CLASS foo . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_6() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     CLASS foo AS \"foo\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_7() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     CLASS foo AS \"foo\" EXPANDS bar USING baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_8() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     CLASS foo EXPANDS bar USING baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_9() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     INTERFACE foo AS \"foo\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_10() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     INTERFACE foo AS \"foo\" EXPANDS bar USING baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_11() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     INTERFACE foo EXPANDS bar USING baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_12() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     PROGRAM foo . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_13() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     PROGRAM foo AS \"foo\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_14() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     PROPERTY foo . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_15() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     PROPERTY foo AS \"foo\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_16() {
      ParserCombinator parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPOSITORY .\n     FUNCTION ALL INTRINSIC\n     FUNCTION foo AS \"foo\"\n     CLASS foo AS \"foo\" EXPANDS bar USING baz\n     INTERFACE foo AS \"foo\" EXPANDS bar USING baz\n     PROGRAM foo AS \"foo\"\n     PROPERTY foo AS \"foo\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}