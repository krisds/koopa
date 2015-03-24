package koopa.cobol.cics.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parser;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from ReadFile.stage. */
public class ReadFileTest extends TestCase {

  private static koopa.cobol.cics.grammar.CICSGrammar grammar = new koopa.cobol.cics.grammar.CICSGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testCicsReadFile_1() {
      Parser parser = grammar.cicsReadFile();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ\n     FILE('FILE001')                \n     INTO(REC1)\n     RIDFLD(EID2)\n     LENGTH(LENGTH OF REC1) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}