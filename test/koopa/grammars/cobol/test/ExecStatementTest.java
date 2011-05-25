package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from ExecStatement.stage. */
public class ExecStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testExecStatement_1() {
      Parser parser = grammar.execStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC ");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testExecStatement_2() {
      Parser parser = grammar.execStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC END-EXEC ");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testExecStatement_3() {
      Parser parser = grammar.execStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC SQL ");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testExecStatement_4() {
      Parser parser = grammar.execStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC SQL END-EXEC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExecStatement_5() {
      Parser parser = grammar.execStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS END-EXEC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExecSQLStatement_6() {
      Parser parser = grammar.execSQLStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC SQL END-EXEC ");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testExecSQLStatement_7() {
      Parser parser = grammar.execSQLStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC SQL INCLUDE payroll END-EXEC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExecCICSStatement_8() {
      Parser parser = grammar.execCICSStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS END-EXEC ");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testExecCICSStatement_9() {
      Parser parser = grammar.execCICSStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS READQ TS QUEUE(W-QUEUE) INTO(W-REC) ITEM(3) END-EXEC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExecCICSStatement_10() {
      Parser parser = grammar.execCICSStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS READQ TS QUEUE(W-QUEUE) SET(W-REC-PTR) ITEM(W-NUMB) END-EXEC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExecCICSStatement_11() {
      Parser parser = grammar.execCICSStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS READ QUEUE TS QUEUE END-EXEC ");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testExecCICSStatement_12() {
      Parser parser = grammar.execCICSStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS READQ TS QUEUE(W-QUEUE) SET(W-REC-PTR) NEXT END-EXEC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExecCICSStatement_13() {
      Parser parser = grammar.execCICSStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS READ FILE ('AFILE') RIDFLD(W-KEY) KEYLENGTH(18) INTO(W-REC) END-EXEC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExecCICSStatement_14() {
      Parser parser = grammar.execCICSStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS READ FILE (W-FILE) RIDFLD(W-KEY) INTO(W-REC) SYSID('CICS') END-EXEC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExecCICSStatement_15() {
      Parser parser = grammar.execCICSStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS WRITE FILE ('AFILE') RIDFLD(W-KEY) FROM(W-REC) END-EXEC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExecCICSStatement_16() {
      Parser parser = grammar.execCICSStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS WRITE FILE('W-FILE') RIDFLD(W-KEY) FROM(W-REC) SYSID(W-CICS) END-EXEC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExecCICSStatement_17() {
      Parser parser = grammar.execCICSStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS LINK PROGRAM('PROG1') COMMAREA(W-DATA) END-EXEC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExecCICSStatement_18() {
      Parser parser = grammar.execCICSStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS XCTL PROGRAM(W-PGM) SYSID('CICS') END-EXEC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExecCICSStatement_19() {
      Parser parser = grammar.execCICSStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS XCTL PROGRAM(W-PGM) SYSID(W-CICS) END-EXEC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExecCICSStatement_20() {
      Parser parser = grammar.execCICSStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS XCTL PROGRAM('PROG1') COMMAREA(W-DATA) END-EXEC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExecCICSStatement_21() {
      Parser parser = grammar.execCICSStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS LINK PROGRAM(W-PGM) SYSID('CICS') END-EXEC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExecCICSStatement_22() {
      Parser parser = grammar.execCICSStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " EXEC CICS READ DATA (WHATEVER) RID(W-KEY-WHATEVER) END-EXEC ");
      assertFalse(parser.accepts(tokenizer));
    }
}