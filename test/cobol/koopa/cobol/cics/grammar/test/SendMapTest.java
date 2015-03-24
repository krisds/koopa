package koopa.cobol.cics.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parser;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from SendMap.stage. */
public class SendMapTest extends TestCase {

  private static koopa.cobol.cics.grammar.CICSGrammar grammar = new koopa.cobol.cics.grammar.CICSGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testCicsSendMap_1() {
      Parser parser = grammar.cicsSendMap();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND MAP('FILE')                    \n     MAPSET('FILE01') "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsSendMap_2() {
      Parser parser = grammar.cicsSendMap();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND MAP('FILE1')\n     MAPSET('FILE02')              \n     ERASE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsSendMap_3() {
      Parser parser = grammar.cicsSendMap();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND MAP ('ZnnAM01')\n     FROM (ZnnAM01O)\n     MAPSET ('ZnnAMAP')\n     ERASE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsSendMap_4() {
      Parser parser = grammar.cicsSendMap();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND MAP('MSGLINE') \n     MAPSET('AIXCSET')\n     FREEKB "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}