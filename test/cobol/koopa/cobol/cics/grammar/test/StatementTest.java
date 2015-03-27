package koopa.cobol.cics.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parser;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from Statement.stage. */
public class StatementTest extends TestCase {

  private static koopa.cobol.cics.grammar.CICSGrammar grammar = new koopa.cobol.cics.grammar.CICSGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testCicsStatement_1() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ\n     FILE('FILE001')                \n     INTO(REC1)\n     RIDFLD(EID2)\n     LENGTH(LENGTH OF REC1) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_2() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECEIVE MAP('FILE1')                  \n     MAPSET('FILE02') "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_3() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECEIVE MAP ('ZnnAM01')                                    \n     INTO (ZnnAM01I)\n     MAPSET ('ZnnAMAP') "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_4() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND MAP('FILE')                    \n     MAPSET('FILE01') "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_5() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND MAP('FILE1')\n     MAPSET('FILE02')              \n     ERASE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_6() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND MAP ('ZnnAM01')\n     FROM (ZnnAM01O)\n     MAPSET ('ZnnAMAP')\n     ERASE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_7() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND MAP('MSGLINE') \n     MAPSET('AIXCSET')\n     FREEKB "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_8() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ADDRESS SET(ptr)\n     USING(address of struc01) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_9() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ASKTIME ABSTIME(utime) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_10() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BIF DEEDIT\n     FIELD(CONTG)\n     LENGTH(9) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_11() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTER TRACENUM(123)\n     FROM(USER-TRACE-ENTRY) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_12() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FREEMAIN DATAPOINTER(AREA-POINTER) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_13() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" NOT-A-CICS-COMMAND "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_14() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READQ TS QUEUE(W-QUEUE) INTO(W-REC) ITEM(3) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_15() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READQ TS QUEUE(W-QUEUE) SET(W-REC-PTR) ITEM(W-NUMB) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_16() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READQ TS QUEUE(W-QUEUE) SET(W-REC-PTR) NEXT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_17() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ FILE ('AFILE') RIDFLD(W-KEY) KEYLENGTH(18) INTO(W-REC) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_18() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ FILE (W-FILE) RIDFLD(W-KEY) INTO(W-REC) SYSID('CICS') "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_19() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE FILE ('AFILE') RIDFLD(W-KEY) FROM(W-REC) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_20() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE FILE('W-FILE') RIDFLD(W-KEY) FROM(W-REC) SYSID(W-CICS) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_21() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINK PROGRAM('PROG1') COMMAREA(W-DATA) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_22() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XCTL PROGRAM(W-PGM) SYSID('CICS') "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_23() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XCTL PROGRAM(W-PGM) SYSID(W-CICS) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_24() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XCTL PROGRAM('PROG1') COMMAREA(W-DATA) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_25() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XCTL PROGRAM(PROGRAM-NAME(ACTION-SUB)) RESP(RESPONSE-CODE) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_26() {
      Parser parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINK PROGRAM(W-PGM) SYSID('CICS') "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOption_27() {
      Parser parser = grammar.option();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" (PROGRAM-NAME) "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOption_28() {
      Parser parser = grammar.option();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM (PROGRAM-NAME) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOption_29() {
      Parser parser = grammar.option();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM (PROGRAM-NAME(ACTION-SUB)) "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOption_30() {
      Parser parser = grammar.option();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM )PROGRAM-NAME( "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOption_31() {
      Parser parser = grammar.option();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM (PROGRAM-NAME ACTION-SUB)) "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOption_32() {
      Parser parser = grammar.option();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM (PROGRAM-NAME(ACTION-SUB)  "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }
}