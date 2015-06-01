package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from EnvironmentDivision.stage. */
public class EnvironmentDivisionTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testEnvironmentDivision_1() {
      ParserCombinator parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENVIRONMENT DIVISION . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnvironmentDivision_2() {
      ParserCombinator parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENVIRONMENT DIVISION .\n   CONFIGURATION SECTION .\n   SPECIAL-NAMES .\n   DECIMAL-POINT IS COMMA . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnvironmentDivision_3() {
      ParserCombinator parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENVIRONMENT DIVISION .\n   CONFIGURATION SECTION .\n   SPECIAL-NAMES . \n   DECIMAL-POINT COMMA . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnvironmentDivision_4() {
      ParserCombinator parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CONFIGURATION SECTION .\n   SPECIAL-NAMES . \n   DECIMAL-POINT COMMA . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnvironmentDivision_5() {
      ParserCombinator parser = grammar.environmentDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPECIAL-NAMES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObjectSection_6() {
      ParserCombinator parser = grammar.objectSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OBJECT SECTION .\n     CLASS-CONTROL .\n       olesup is class \"olesup\"\n       wordapp is class \"$OLE$word.application\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObjectSection_7() {
      ParserCombinator parser = grammar.objectSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-CONTROL .\n     olesup is class \"olesup\"\n     wordapp is class \"$OLE$word.application\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}