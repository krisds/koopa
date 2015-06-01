package koopa.cobol.cics.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
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
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ\n     FILE('FILE001')                \n     INTO(REC1)\n     RIDFLD(EID2)\n     LENGTH(LENGTH OF REC1) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_2() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECEIVE MAP('FILE1')                  \n     MAPSET('FILE02') "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_3() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECEIVE MAP ('ZnnAM01')                                    \n     INTO (ZnnAM01I)\n     MAPSET ('ZnnAMAP') "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_4() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND MAP('FILE')                    \n     MAPSET('FILE01') "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_5() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND MAP('FILE1')\n     MAPSET('FILE02')              \n     ERASE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_6() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND MAP ('ZnnAM01')\n     FROM (ZnnAM01O)\n     MAPSET ('ZnnAMAP')\n     ERASE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_7() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND MAP('MSGLINE') \n     MAPSET('AIXCSET')\n     FREEKB "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_8() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ADDRESS SET(ptr)\n     USING(address of struc01) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_9() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ASKTIME ABSTIME(utime) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_10() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BIF DEEDIT\n     FIELD(CONTG)\n     LENGTH(9) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_11() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENTER TRACENUM(123)\n     FROM(USER-TRACE-ENTRY) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_12() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FREEMAIN DATAPOINTER(AREA-POINTER) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_13() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" NOT-A-CICS-COMMAND "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_14() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READQ TS QUEUE(W-QUEUE) INTO(W-REC) ITEM(3) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_15() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READQ TS QUEUE(W-QUEUE) SET(W-REC-PTR) ITEM(W-NUMB) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_16() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READQ TS QUEUE(W-QUEUE) SET(W-REC-PTR) NEXT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_17() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ FILE ('AFILE') RIDFLD(W-KEY) KEYLENGTH(18) INTO(W-REC) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_18() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ FILE (W-FILE) RIDFLD(W-KEY) INTO(W-REC) SYSID('CICS') "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_19() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE FILE ('AFILE') RIDFLD(W-KEY) FROM(W-REC) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_20() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE FILE('W-FILE') RIDFLD(W-KEY) FROM(W-REC) SYSID(W-CICS) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_21() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINK PROGRAM('PROG1') COMMAREA(W-DATA) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_22() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XCTL PROGRAM(W-PGM) SYSID('CICS') "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_23() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XCTL PROGRAM(W-PGM) SYSID(W-CICS) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_24() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XCTL PROGRAM('PROG1') COMMAREA(W-DATA) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_25() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XCTL PROGRAM(PROGRAM-NAME(ACTION-SUB)) RESP(RESPONSE-CODE) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCicsStatement_26() {
      ParserCombinator parser = grammar.cicsStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINK PROGRAM(W-PGM) SYSID('CICS') "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOption_27() {
      ParserCombinator parser = grammar.option();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" (PROGRAM-NAME) "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOption_28() {
      ParserCombinator parser = grammar.option();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM (PROGRAM-NAME) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOption_29() {
      ParserCombinator parser = grammar.option();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM (PROGRAM-NAME(ACTION-SUB)) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOption_30() {
      ParserCombinator parser = grammar.option();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM )PROGRAM-NAME( "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOption_31() {
      ParserCombinator parser = grammar.option();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM (PROGRAM-NAME ACTION-SUB)) "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOption_32() {
      ParserCombinator parser = grammar.option();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM (PROGRAM-NAME(ACTION-SUB)  "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }
}