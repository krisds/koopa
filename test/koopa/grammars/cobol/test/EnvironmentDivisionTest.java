package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class EnvironmentDivisionTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testEnvironmentDivision_1() {
      Parser parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ENVIRONMENT", "DIVISION", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testEnvironmentDivision_2() {
      Parser parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ENVIRONMENT", "DIVISION", ".", 
        "CONFIGURATION", "SECTION", ".", "SPECIAL-NAMES", ".", "DECIMAL-POINT", 
        "IS", "COMMA", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testEnvironmentDivision_3() {
      Parser parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ENVIRONMENT", "DIVISION", ".", 
        "CONFIGURATION", "SECTION", ".", "SPECIAL-NAMES", ".", "DECIMAL-POINT", 
        "COMMA", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }
}