package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from FileSection.stage. */
public class FileSectionTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testFileSection_1() {
      ParserCombinator parser = grammar.fileSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("\n       FILE SECTION.\n\n       FD  FPM203S1\n           BLOCK CONTAINS 0 RECORDS\n           RECORDING MODE IS F\n           LABEL RECORDS ARE STANDARD.\n       01  REG-SALIDA                     PIC X(200).\n\n       FD  FGRERROR\n           BLOCK CONTAINS 0 RECORDS\n           RECORDING MODE IS F\n           LABEL RECORDS ARE STANDARD.\n       01  REG-FGRERROR                     PIC X(402).\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}