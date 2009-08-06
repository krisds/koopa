package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class ExecStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testExecStatement_1() {
      Parser parser = grammar.execStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EXEC");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testExecStatement_2() {
      Parser parser = grammar.execStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EXEC", "END-EXEC");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testExecStatement_3() {
      Parser parser = grammar.execStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EXEC", "SQL");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testExecStatement_4() {
      Parser parser = grammar.execStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EXEC", "SQL", "END-EXEC");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testExecStatement_5() {
      Parser parser = grammar.execStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EXEC", "SQL", "INCLUDE", "payroll", 
        "END-EXEC");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testExecStatement_6() {
      Parser parser = grammar.execStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EXEC", "CICS", "END-EXEC");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testExecStatement_7() {
      Parser parser = grammar.execStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EXEC", "CICS", "FEE", "FOO", 
        "FUM", "END-EXEC");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }
}