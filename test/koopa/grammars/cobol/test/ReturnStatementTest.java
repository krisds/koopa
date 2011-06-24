package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from ReturnStatement.stage. */
public class ReturnStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testReturnStatement_1() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_2() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_3() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE\n     AT END DISPLAY \"At end.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_4() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE\n     AT END DISPLAY \"At end.\"\n   END-RETURN ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_5() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE RECORD\n     AT END DISPLAY \"At end.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_6() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE RECORD\n     AT END DISPLAY \"At end.\"\n   END-RETURN ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_7() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE INTO MY-FIELD\n     AT END DISPLAY \"At end.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_8() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE INTO MY-FIELD\n     AT END DISPLAY \"At end.\"\n   END-RETURN ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_9() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE RECORD INTO MY-FIELD\n     AT END DISPLAY \"At end.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_10() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE RECORD INTO MY-FIELD\n     AT END DISPLAY \"At end.\"\n   END-RETURN ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_11() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_12() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\"\n   END-RETURN ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_13() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE RECORD\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_14() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE RECORD\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\"\n   END-RETURN ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_15() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE INTO MY-FIELD\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_16() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE INTO MY-FIELD\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\"\n   END-RETURN ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_17() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE RECORD INTO MY-FIELD\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReturnStatement_18() {
      Parser parser = grammar.returnStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RETURN MY-FILE RECORD INTO MY-FIELD\n     AT END DISPLAY \"At end.\"\n     NOT AT END DISPLAY \"Not at end.\"\n   END-RETURN ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}