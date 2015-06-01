package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from WriteStatement.stage. */
public class WriteStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testWriteStatement_1() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_2() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_3() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD FROM MY-SOMETHING\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_4() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ADVANCING N LINE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_5() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ADVANCING 1 LINE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_6() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ADVANCING ZERO LINE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_7() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ADVANCING N LINES\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_8() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ADVANCING 1 LINES\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_9() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ADVANCING ZERO LINES\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_10() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER N LINE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_11() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER 1 LINE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_12() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ZERO LINE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_13() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER N LINES\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_14() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER 1 LINES\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_15() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ZERO LINES\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_16() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ADVANCING N\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_17() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ADVANCING 1\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_18() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ADVANCING ZERO\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_19() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER N\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_20() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER 1\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_21() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ZERO\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_22() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ADVANCING N LINE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_23() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ADVANCING 1 LINE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_24() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ADVANCING ZERO LINE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_25() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ADVANCING N LINES\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_26() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ADVANCING 1 LINES\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_27() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ADVANCING ZERO LINES\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_28() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE N LINE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_29() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE 1 LINE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_30() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ZERO LINE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_31() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE N LINES\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_32() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE 1 LINES\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_33() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ZERO LINES\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_34() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ADVANCING N\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_35() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ADVANCING 1\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_36() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ADVANCING ZERO\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_37() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE N\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_38() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE 1\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_39() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ZERO\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_40() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ADVANCING MY-MNEMONIC\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_41() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER MY-MNEMONIC\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_42() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ADVANCING MY-MNEMONIC\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_43() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE MY-MNEMONIC\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_44() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ADVANCING PAGE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_45() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER PAGE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_46() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ADVANCING PAGE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_47() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE PAGE\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_48() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ADVANCING TAB\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_49() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER TAB\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_50() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ADVANCING TAB\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_51() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE TAB\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_52() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER ADVANCING FORMFEED\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_53() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     AFTER FORMFEED\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_54() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ADVANCING FORMFEED\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_55() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE FORMFEED\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_56() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD\n     BEFORE ADVANCING ZERO\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_57() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   AT END-OF-PAGE\n      DISPLAY \"End of page.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_58() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   AT EOP\n      DISPLAY \"End of page.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_59() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   END-OF-PAGE\n      DISPLAY \"End of page.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_60() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   EOP\n      DISPLAY \"End of page.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_61() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   NOT AT END-OF-PAGE\n      DISPLAY \"Elsewhere on page.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_62() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   NOT AT EOP\n      DISPLAY \"Elsewhere on page.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_63() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   NOT END-OF-PAGE\n      DISPLAY \"Elsewhere on page.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_64() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   NOT EOP\n      DISPLAY \"Elsewhere on page.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_65() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   INVALID KEY\n      DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_66() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   INVALID\n      DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_67() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_68() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   NOT INVALID\n      DISPLAY \"A-OK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_69() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   AT END-OF-PAGE\n      DISPLAY \"End of page.\" \n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_70() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   AT EOP\n      DISPLAY \"End of page.\" \n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_71() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   END-OF-PAGE\n      DISPLAY \"End of page.\" \n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_72() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   EOP\n      DISPLAY \"End of page.\" \n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_73() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   NOT AT END-OF-PAGE\n      DISPLAY \"Elsewhere on page.\" \n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_74() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   NOT AT EOP\n      DISPLAY \"Elsewhere on page.\" \n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_75() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   NOT END-OF-PAGE\n      DISPLAY \"Elsewhere on page.\" \n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_76() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   NOT EOP\n      DISPLAY \"Elsewhere on page.\" \n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_77() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   INVALID KEY\n      DISPLAY \"Oops.\" \n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_78() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   INVALID\n      DISPLAY \"Oops.\" \n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_79() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" \n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_80() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   NOT INVALID\n      DISPLAY \"A-OK.\" \n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_81() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   WITH NO LOCK\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_82() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   WITH LOCK\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_83() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   NO LOCK\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_84() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   LOCK\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_85() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   RETRY N TIMES\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_86() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   RETRY 3 TIMES\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_87() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   RETRY FOR N SECONDS\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_88() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   RETRY FOR 3 SECONDS\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_89() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE MY-RECORD \n   RETRY FOREVER\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_90() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE myrec \n   FROM something\n   BEFORE num-item\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_91() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE myrec \n   FROM something\n   AFTER num-item\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_92() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE myrec\n   FROM \"something\"\n   BEFORE num-item\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_93() {
      ParserCombinator parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WRITE myrec \n   FROM \"something\"\n   AFTER num-item\n   END-WRITE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}