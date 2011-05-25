package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from EnvironmentDivision.stage. */
public class EnvironmentDivisionTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testEnvironmentDivision_1() {
      Parser parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENVIRONMENT DIVISION . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnvironmentDivision_2() {
      Parser parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENVIRONMENT DIVISION .\n   CONFIGURATION SECTION .\n   SPECIAL-NAMES .\n   DECIMAL-POINT IS COMMA . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnvironmentDivision_3() {
      Parser parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENVIRONMENT DIVISION .\n   CONFIGURATION SECTION .\n   SPECIAL-NAMES . \n   DECIMAL-POINT COMMA . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}