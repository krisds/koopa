package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from CommunicationStatements.stage. */
public class CommunicationStatementsTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testDisableStatement_1() {
      Parser parser = grammar.disableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " DISABLE INPUT          CM-INQUE-1 WITH KEY XXXXX031 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisableStatement_2() {
      Parser parser = grammar.disableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " DISABLE INPUT TERMINAL CM-INQUE-1 WITH KEY XXXXX031 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisableStatement_3() {
      Parser parser = grammar.disableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " DISABLE I-O TERMINAL   CM-INQUE-1 WITH KEY XXXXX031 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisableStatement_4() {
      Parser parser = grammar.disableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " DISABLE OUTPUT         CM-INQUE-1 WITH KEY XXXXX031 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisableStatement_5() {
      Parser parser = grammar.disableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " DISABLE INPUT          CM-INQUE-1      KEY XXXXX031 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnableStatement_6() {
      Parser parser = grammar.enableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENABLE INPUT          CM-INQUE-1 WITH KEY XXXXX031 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnableStatement_7() {
      Parser parser = grammar.enableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENABLE INPUT TERMINAL CM-INQUE-1 WITH KEY XXXXX031 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnableStatement_8() {
      Parser parser = grammar.enableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENABLE I-O TERMINAL   CM-INQUE-1 WITH KEY XXXXX031 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnableStatement_9() {
      Parser parser = grammar.enableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENABLE OUTPUT         CM-INQUE-1 WITH KEY XXXXX031 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnableStatement_10() {
      Parser parser = grammar.enableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENABLE INPUT          CM-INQUE-1      KEY XXXXX031 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPurgeStatement_11() {
      Parser parser = grammar.purgeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PURGE CM-INQUE-1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReceiveStatement_12() {
      Parser parser = grammar.receiveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RECEIVE CM-INQUE-1 MESSAGE INTO MSG ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReceiveStatement_13() {
      Parser parser = grammar.receiveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RECEIVE CM-INQUE-1 MESSAGE INTO INCOMING-MSG\n     NO DATA PERFORM INCREMENT-POLL-COUNT GO TO LOG-MSG ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReceiveStatement_14() {
      Parser parser = grammar.receiveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RECEIVE CM-INQUE-1 MESSAGE INTO INCOMING-MSG\n     WITH DATA PERFORM INCREMENT-POLL-COUNT GO TO LOG-MSG ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReceiveStatement_15() {
      Parser parser = grammar.receiveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " RECEIVE CM-INQUE-1 MESSAGE INTO INCOMING-MSG\n     NO DATA PERFORM INCREMENT-POLL-COUNT GO TO LOG-MSG\n     WITH DATA PERFORM INCREMENT-POLL-COUNT GO TO LOG-MSG ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_16() {
      Parser parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEND CM-OUTQUE-1 FROM MSG-70 WITH EMI ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_17() {
      Parser parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEND CM-OUTQUE-1 FROM MSG-OUT WITH EGI ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_18() {
      Parser parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEND CM-OUTQUE-1 FROM MSG-OUT WITH EMI AFTER PAGE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_19() {
      Parser parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEND CM-OUTQUE-1 FROM MSG-70 WITH EMI AFTER ADVANCING PAGE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_20() {
      Parser parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEND CM-OUTQUE-1 FROM MSG-OUT WITH EMI AFTER ADVANCING 3 LINES ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_21() {
      Parser parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEND CM-OUTQUE-1 FROM MSG-OUT WITH EMI AFTER ADVANCING THREE LINES ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_22() {
      Parser parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEND CM-OUTQUE-1 FROM MSG-OUT WITH EMI AFTER COMP-THREE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_23() {
      Parser parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEND CM-OUTQUE-1 FROM MSG-OUT WITH EMI BEFORE 2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_24() {
      Parser parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SEND CM-OUTQUE-1 FROM MSG-OUT WITH EMI BEFORE ZERO LINES ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}