package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.sources.test.TestTokenizer;
import koopa.core.parsers.Parser;

import org.junit.Test;

/** This code was generated from FileSection.stage. */
public class FileSectionTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

    @Test
    public void testFileSection_1() {
      Parser parser = grammar.fileSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FIXED, "\n       FILE SECTION.\n\n       FD  FPM203S1\n           BLOCK CONTAINS 0 RECORDS\n           RECORDING MODE IS F\n           LABEL RECORDS ARE STANDARD.\n       01  REG-SALIDA                     PIC X(200).\n\n       FD  FGRERROR\n           BLOCK CONTAINS 0 RECORDS\n           RECORDING MODE IS F\n           LABEL RECORDS ARE STANDARD.\n       01  REG-FGRERROR                     PIC X(402).\n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}