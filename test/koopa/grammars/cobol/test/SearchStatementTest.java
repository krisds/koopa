package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class SearchStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testAtEnd_1() {
      Parser parser = grammar.atEnd();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("AT", "END", "DISPLAY", "\"FOO\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testAtEnd_2() {
      Parser parser = grammar.atEnd();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("END", "DISPLAY", "\"FOO\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testNotAtEnd_3() {
      Parser parser = grammar.notAtEnd();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("NOT", "AT", "END", "DISPLAY", 
        "\"FOO\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(4, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testNotAtEnd_4() {
      Parser parser = grammar.notAtEnd();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("NOT", "END", "DISPLAY", "\"FOO\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_5() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "WHEN", 
        "TRUE", "DISPLAY", "\"Found one.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_6() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "WHEN", 
        "TRUE", "DISPLAY", "\"Found one.\"", "END-SEARCH");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_7() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "WHEN", 
        "TRUE", "NEXT", "SENTENCE");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_8() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "WHEN", 
        "TRUE", "NEXT", "SENTENCE", "END-SEARCH");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_9() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "VARYING", 
        "EMPLOYEE-NUMBER", "WHEN", "TRUE", "DISPLAY", "\"Found one.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_10() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "VARYING", 
        "EMPLOYEE-NUMBER", "WHEN", "TRUE", "DISPLAY", "\"Found one.\"", "END-SEARCH");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_11() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "AT", "END", 
        "DISPLAY", "\"No-one found.\"", "WHEN", "TRUE", "DISPLAY", "\"Found one.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_12() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "AT", "END", 
        "DISPLAY", "\"No-one found.\"", "WHEN", "TRUE", "DISPLAY", "\"Found one.\"", 
        "END-SEARCH");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_13() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "VARYING", 
        "EMPLOYEE-NUMBER", "AT", "END", "DISPLAY", "\"No-one found.\"", "WHEN", 
        "TRUE", "DISPLAY", "\"Found one.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_14() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "VARYING", 
        "EMPLOYEE-NUMBER", "AT", "END", "DISPLAY", "\"No-one found.\"", "WHEN", 
        "TRUE", "DISPLAY", "\"Found one.\"", "END-SEARCH");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(13, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_15() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "END", 
        "DISPLAY", "\"No-one found.\"", "WHEN", "TRUE", "DISPLAY", "\"Found one.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_16() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "END", 
        "DISPLAY", "\"No-one found.\"", "WHEN", "TRUE", "DISPLAY", "\"Found one.\"", 
        "END-SEARCH");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_17() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "VARYING", 
        "EMPLOYEE-NUMBER", "END", "DISPLAY", "\"No-one found.\"", "WHEN", "TRUE", 
        "DISPLAY", "\"Found one.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_18() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "VARYING", 
        "EMPLOYEE-NUMBER", "END", "DISPLAY", "\"No-one found.\"", "WHEN", "TRUE", 
        "DISPLAY", "\"Found one.\"", "END-SEARCH");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_19() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "WHEN", 
        "TRUE", "DISPLAY", "\"Found one.\"", "DISPLAY", "\"Really!\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_20() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "WHEN", 
        "TRUE", "DISPLAY", "\"Found one.\"", "DISPLAY", "\"Really!\"", "END-SEARCH");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_21() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "WHEN", 
        "TRUE", "DISPLAY", "\"Found one.\"", "WHEN", "FALSE", "DISPLAY", "\"Found one... not!\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_22() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "WHEN", 
        "TRUE", "DISPLAY", "\"Found one.\"", "WHEN", "FALSE", "DISPLAY", "\"Found one... not!\"", 
        "END-SEARCH");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_23() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "WHEN", 
        "TRUE", "DISPLAY", "\"Found one.\"", "DISPLAY", "\"Really!\"", "WHEN", "FALSE", 
        "DISPLAY", "\"Found one... not!\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_24() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "EMPLOYEES", "WHEN", 
        "TRUE", "DISPLAY", "\"Found one.\"", "DISPLAY", "\"Really!\"", "WHEN", "FALSE", 
        "DISPLAY", "\"Found one... not!\"", "END-SEARCH");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(13, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_25() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "ALL", "EMPLOYEES", 
        "WHEN", "TRUE", "DISPLAY", "\"Found one.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_26() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "ALL", "EMPLOYEES", 
        "WHEN", "TRUE", "DISPLAY", "\"Found one.\"", "END-SEARCH");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_27() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "ALL", "EMPLOYEES", 
        "AT", "END", "DISPLAY", "\"No-one found.\"", "WHEN", "TRUE", "DISPLAY", 
        "\"Found one.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_28() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "ALL", "EMPLOYEES", 
        "AT", "END", "DISPLAY", "\"No-one found.\"", "WHEN", "TRUE", "DISPLAY", 
        "\"Found one.\"", "END-SEARCH");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_29() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "ALL", "EMPLOYEES", 
        "END", "DISPLAY", "\"No-one found.\"", "WHEN", "TRUE", "DISPLAY", "\"Found one.\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_30() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "ALL", "EMPLOYEES", 
        "END", "DISPLAY", "\"No-one found.\"", "WHEN", "TRUE", "DISPLAY", "\"Found one.\"", 
        "END-SEARCH");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSearchStatement_31() {
      Parser parser = grammar.searchStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SEARCH", "ALL", "EMPLOYEES", 
        "VARYING", "EMPLOYEE-NUMBER", "WHEN", "TRUE", "DISPLAY", "\"Found one.\"");
      assertFalse(parser.accepts(tokenizer));
    }
}