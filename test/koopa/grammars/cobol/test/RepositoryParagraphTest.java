package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from RepositoryParagraph.stage. */
public class RepositoryParagraphTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testRepositoryParagraph_1() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     FUNCTION ALL INTRINSIC . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_2() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     FUNCTION foo INTRINSIC . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_3() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     FUNCTION foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_4() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     FUNCTION foo AS \"foo\" . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_5() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     CLASS foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_6() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     CLASS foo AS \"foo\" . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_7() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     CLASS foo AS \"foo\" EXPANDS bar USING baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_8() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     CLASS foo EXPANDS bar USING baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_9() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     INTERFACE foo AS \"foo\" . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_10() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     INTERFACE foo AS \"foo\" EXPANDS bar USING baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_11() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     INTERFACE foo EXPANDS bar USING baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_12() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     PROGRAM foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_13() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     PROGRAM foo AS \"foo\" . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_14() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     PROPERTY foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_15() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     PROPERTY foo AS \"foo\" . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRepositoryParagraph_16() {
      Parser parser = grammar.repositoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " REPOSITORY .\n     FUNCTION ALL INTRINSIC\n     FUNCTION foo AS \"foo\"\n     CLASS foo AS \"foo\" EXPANDS bar USING baz\n     INTERFACE foo AS \"foo\" EXPANDS bar USING baz\n     PROGRAM foo AS \"foo\"\n     PROPERTY foo AS \"foo\" . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}