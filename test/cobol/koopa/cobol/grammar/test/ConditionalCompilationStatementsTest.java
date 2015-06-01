package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from ConditionalCompilationStatements.stage. */
public class ConditionalCompilationStatementsTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testCompilerDisplayStatement_1() {
      ParserCombinator parser = grammar.compilerDisplayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" $DISPLAY \"foo\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerDisplayStatement_2() {
      ParserCombinator parser = grammar.compilerDisplayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" $DISPLAY VCS = z\"@(#)2.0\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerDisplayStatement_3() {
      ParserCombinator parser = grammar.compilerDisplayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" $DISPLAY VCS = \"2.0\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerDisplayStatement_4() {
      ParserCombinator parser = grammar.compilerDisplayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" $DISPLAY VCS = "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_5() {
      ParserCombinator parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("\n      $IF foo SET\n        CALL bar.\n      $ELSE\n        CALL baz.\n      $END\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_6() {
      ParserCombinator parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("\n      $IF foo NOT SET\n        CALL bar.\n      $ELSE\n        CALL baz.\n      $END\n"));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_7() {
      ParserCombinator parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("\n      $IF foo DEFINED\n        PERFORM bar.\n      $END\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_8() {
      ParserCombinator parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("\n      $IF foo NOT DEFINED\n        CALL bar.\n      $END\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_9() {
      ParserCombinator parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("\n      $IF foo < 5\n        CALL bar.\n      $END\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_10() {
      ParserCombinator parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("\n      $IF foo NOT < 5\n        CALL baz.\n      $END\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_11() {
      ParserCombinator parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("\n      $IF foo > 5\n        CALL bar.\n      $END\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_12() {
      ParserCombinator parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("\n      $IF foo NOT > 5\n        CALL baz.\n      $END\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_13() {
      ParserCombinator parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("\n      $IF foo = 5\n        CALL bar.\n      $END\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_14() {
      ParserCombinator parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("\n      $IF foo NOT = 5\n        CALL baz.\n      $END\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_15() {
      ParserCombinator parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("\n      $IF foo = 1\n      $IF bar = 2\n        CALL baz.\n      $END\n      $END\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}