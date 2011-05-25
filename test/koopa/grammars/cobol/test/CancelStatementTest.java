package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from CancelStatement.stage. */
public class CancelStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testCancelStatement_1() {
      Parser parser = grammar.cancelStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CANCEL MY-SUB-PROGRAM ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCancelStatement_2() {
      Parser parser = grammar.cancelStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CANCEL \"MY-SUB-PROGRAM\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCancelStatement_3() {
      Parser parser = grammar.cancelStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CANCEL 42 ");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testCancelStatement_4() {
      Parser parser = grammar.cancelStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CANCEL 42.0 ");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testCancelStatement_5() {
      Parser parser = grammar.cancelStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CANCEL MY-SUB-PROGRAM \"MY-SUB-PROGRAM\" \"MY-OTHER-SUBPROGRAM\" MY-OTHER-SUBPROGRAM ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}