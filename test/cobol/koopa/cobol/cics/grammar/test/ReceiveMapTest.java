package koopa.cobol.cics.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parser;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from ReceiveMap.stage. */
public class ReceiveMapTest extends TestCase {

  private static koopa.cobol.cics.grammar.CICSGrammar grammar = new koopa.cobol.cics.grammar.CICSGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testCicsReceiveMap_1() {
      Parser parser = grammar.cicsReceiveMap();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECEIVE MAP('FILE1')                  \n     MAPSET('FILE02') "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsReceiveMap_2() {
      Parser parser = grammar.cicsReceiveMap();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECEIVE MAP ('ZnnAM01')                                    \n     INTO (ZnnAM01I)\n     MAPSET ('ZnnAMAP') "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}