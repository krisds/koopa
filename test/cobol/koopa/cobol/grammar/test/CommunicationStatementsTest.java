package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from CommunicationStatements.stage. */
public class CommunicationStatementsTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testDisableStatement_1() {
      ParserCombinator parser = grammar.disableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISABLE INPUT          CM-INQUE-1 WITH KEY XXXXX031 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisableStatement_2() {
      ParserCombinator parser = grammar.disableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISABLE INPUT TERMINAL CM-INQUE-1 WITH KEY XXXXX031 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisableStatement_3() {
      ParserCombinator parser = grammar.disableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISABLE I-O TERMINAL   CM-INQUE-1 WITH KEY XXXXX031 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisableStatement_4() {
      ParserCombinator parser = grammar.disableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISABLE OUTPUT         CM-INQUE-1 WITH KEY XXXXX031 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisableStatement_5() {
      ParserCombinator parser = grammar.disableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISABLE INPUT          CM-INQUE-1      KEY XXXXX031 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnableStatement_6() {
      ParserCombinator parser = grammar.enableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENABLE INPUT          CM-INQUE-1 WITH KEY XXXXX031 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnableStatement_7() {
      ParserCombinator parser = grammar.enableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENABLE INPUT TERMINAL CM-INQUE-1 WITH KEY XXXXX031 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnableStatement_8() {
      ParserCombinator parser = grammar.enableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENABLE I-O TERMINAL   CM-INQUE-1 WITH KEY XXXXX031 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnableStatement_9() {
      ParserCombinator parser = grammar.enableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENABLE OUTPUT         CM-INQUE-1 WITH KEY XXXXX031 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnableStatement_10() {
      ParserCombinator parser = grammar.enableStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENABLE INPUT          CM-INQUE-1      KEY XXXXX031 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPurgeStatement_11() {
      ParserCombinator parser = grammar.purgeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PURGE CM-INQUE-1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReceiveStatement_12() {
      ParserCombinator parser = grammar.receiveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECEIVE CM-INQUE-1 MESSAGE INTO MSG "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReceiveStatement_13() {
      ParserCombinator parser = grammar.receiveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECEIVE CM-INQUE-1 MESSAGE INTO INCOMING-MSG\n     NO DATA PERFORM INCREMENT-POLL-COUNT GO TO LOG-MSG "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReceiveStatement_14() {
      ParserCombinator parser = grammar.receiveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECEIVE CM-INQUE-1 MESSAGE INTO INCOMING-MSG\n     WITH DATA PERFORM INCREMENT-POLL-COUNT GO TO LOG-MSG "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReceiveStatement_15() {
      ParserCombinator parser = grammar.receiveStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECEIVE CM-INQUE-1 MESSAGE INTO INCOMING-MSG\n     NO DATA PERFORM INCREMENT-POLL-COUNT GO TO LOG-MSG\n     WITH DATA PERFORM INCREMENT-POLL-COUNT GO TO LOG-MSG "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_16() {
      ParserCombinator parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND CM-OUTQUE-1 FROM MSG-70 WITH EMI "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_17() {
      ParserCombinator parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND CM-OUTQUE-1 FROM MSG-OUT WITH EGI "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_18() {
      ParserCombinator parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND CM-OUTQUE-1 FROM MSG-OUT WITH EMI AFTER PAGE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_19() {
      ParserCombinator parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND CM-OUTQUE-1 FROM MSG-70 WITH EMI AFTER ADVANCING PAGE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_20() {
      ParserCombinator parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND CM-OUTQUE-1 FROM MSG-OUT WITH EMI AFTER ADVANCING 3 LINES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_21() {
      ParserCombinator parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND CM-OUTQUE-1 FROM MSG-OUT WITH EMI AFTER ADVANCING THREE LINES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_22() {
      ParserCombinator parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND CM-OUTQUE-1 FROM MSG-OUT WITH EMI AFTER COMP-THREE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_23() {
      ParserCombinator parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND CM-OUTQUE-1 FROM MSG-OUT WITH EMI BEFORE 2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSendStatement_24() {
      ParserCombinator parser = grammar.sendStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SEND CM-OUTQUE-1 FROM MSG-OUT WITH EMI BEFORE ZERO LINES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}