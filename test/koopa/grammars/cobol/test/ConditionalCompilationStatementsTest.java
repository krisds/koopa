package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from ConditionalCompilationStatements.stage. */
public class ConditionalCompilationStatementsTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testCompilerDisplayStatement_1() {
      Parser parser = grammar.compilerDisplayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " $DISPLAY \"foo\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerDisplayStatement_2() {
      Parser parser = grammar.compilerDisplayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " $DISPLAY VCS = z\"@(#)2.0\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerDisplayStatement_3() {
      Parser parser = grammar.compilerDisplayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " $DISPLAY VCS = \"2.0\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerDisplayStatement_4() {
      Parser parser = grammar.compilerDisplayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " $DISPLAY VCS = ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_5() {
      Parser parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FIXED, "\n      $IF foo SET\n        CALL bar.\n      $ELSE\n        CALL baz.\n      $END\n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_6() {
      Parser parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FIXED, "\n      $IF foo NOT SET\n        CALL bar.\n      $ELSE\n        CALL baz.\n      $END\n");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_7() {
      Parser parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FIXED, "\n      $IF foo DEFINED\n        PERFORM bar.\n      $END\n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_8() {
      Parser parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FIXED, "\n      $IF foo NOT DEFINED\n        CALL bar.\n      $END\n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_9() {
      Parser parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FIXED, "\n      $IF foo < 5\n        CALL bar.\n      $END\n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_10() {
      Parser parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FIXED, "\n      $IF foo NOT < 5\n        CALL baz.\n      $END\n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_11() {
      Parser parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FIXED, "\n      $IF foo > 5\n        CALL bar.\n      $END\n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_12() {
      Parser parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FIXED, "\n      $IF foo NOT > 5\n        CALL baz.\n      $END\n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_13() {
      Parser parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FIXED, "\n      $IF foo = 5\n        CALL bar.\n      $END\n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_14() {
      Parser parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FIXED, "\n      $IF foo NOT = 5\n        CALL baz.\n      $END\n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCompilerIfStatement_15() {
      Parser parser = grammar.compilerIfStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FIXED, "\n      $IF foo = 1\n      $IF bar = 2\n        CALL baz.\n      $END\n      $END\n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}