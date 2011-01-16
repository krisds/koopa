package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class MoveStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testMoveStatement_1() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "EMPLOYEE-RECORD", "TO", 
        "PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testMoveStatement_2() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "\"TEXT\"", "TO", "PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testMoveStatement_3() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "42", "TO", "PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testMoveStatement_4() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "42.42", "TO", "PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testMoveStatement_5() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "ZERO", "TO", "PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testMoveStatement_6() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "ALL", "ZEROES", "TO", 
        "PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testMoveStatement_7() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "CORRESPONDING", "EMPLOYEE-RECORD", 
        "TO", "PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testMoveStatement_8() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "CORR", "EMPLOYEE-RECORD", 
        "TO", "PAYROLL-CHECK");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testMoveStatement_9() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "CORRESPONDING", "EMPLOYEE-RECORD", 
        "TO", "PAYROLL-CHECK", "EMPLOYEE-LIST");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testMoveStatement_10() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "CORR", "EMPLOYEE-RECORD", 
        "TO", "PAYROLL-CHECK", "EMPLOYEE-LIST");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testMoveStatement_11() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "CORRESPONDING", "\"TEXT\"", 
        "TO", "PAYROLL-CHECK");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testMoveStatement_12() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "CORRESPONDING", "42", 
        "TO", "PAYROLL-CHECK");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testMoveStatement_13() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "CORRESPONDING", "42.42", 
        "TO", "PAYROLL-CHECK");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testMoveStatement_14() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "CORR", "\"TEXT\"", "TO", 
        "PAYROLL-CHECK");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testMoveStatement_15() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "CORR", "42", "TO", "PAYROLL-CHECK");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testMoveStatement_16() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "CORR", "42.42", "TO", 
        "PAYROLL-CHECK");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testMoveStatement_17() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "DEBUG-LINE", "TO", "DBLINE-HOLD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testMoveStatement_18() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "LINE-COUNTER", "TO", 
        "COMPUTED-18V0");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testMoveStatement_19() {
      Parser parser = grammar.moveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MOVE", "PAGE-COUNTER", "TO", 
        "COMPUTED-18V0");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }
}