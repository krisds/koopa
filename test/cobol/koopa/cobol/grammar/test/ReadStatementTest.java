package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from ReadStatement.stage. */
public class ReadStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testReadStatement_1() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_2() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_3() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     WITH NO LOCK\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_4() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     NO LOCK\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_5() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     WITH LOCK\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_6() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     LOCK\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_7() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     NEXT RECORD\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_8() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     PREVIOUS RECORD\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_9() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     NEXT\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_10() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     PREVIOUS\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_11() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     RECORD\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_12() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     INTO MY-VALUE\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_13() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     KEY IS MY-KEY\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_14() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     KEY MY-KEY\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_15() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   AT END\n      DISPLAY \"Nothing more to see here.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_16() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   END\n      DISPLAY \"Nothing more to see here.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_17() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   NOT AT END\n      DISPLAY \"Look at that...\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_18() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   NOT END\n      DISPLAY \"Look at that...\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_19() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   INVALID KEY\n      DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_20() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   INVALID\n      DISPLAY \"Oops.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_21() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_22() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   NOT INVALID\n      DISPLAY \"A-OK.\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_23() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   AT END\n      DISPLAY \"Nothing more to see here.\" \n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_24() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   END\n      DISPLAY \"Nothing more to see here.\" \n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_25() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   NOT AT END\n      DISPLAY \"Look at that...\" \n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_26() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   NOT END\n      DISPLAY \"Look at that...\" \n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_27() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   INVALID KEY\n      DISPLAY \"Oops.\" \n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_28() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   INVALID\n      DISPLAY \"Oops.\" \n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_29() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" \n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_30() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n   NOT INVALID\n      DISPLAY \"A-OK.\" \n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_31() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     ADVANCING ON LOCK\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_32() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     ADVANCING LOCK\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_33() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     IGNORING LOCK\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_34() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n     RETRY N TIMES\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_35() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n     RETRY 3 TIMES\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_36() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n     RETRY FOR N SECONDS\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_37() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n     RETRY FOR 3 SECONDS\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_38() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE \n     RETRY FOREVER\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_39() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     KEY IS FUNCTION FN ( X )\n   END-READ "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_40() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     KEY IS EXCEPTION-OBJECT\n   END-READ "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_41() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     KEY IS NULL\n   END-READ "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_42() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     KEY IS SELF\n   END-READ "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_43() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     KEY IS SUPER\n   END-READ "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_44() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     KEY IS MY-CLASS-NAME OF SUPER\n   END-READ "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_45() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ MY-FILE\n     KEY IS ADDRESS OF SOMETHING\n   END-READ "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_46() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ foo\n    END DISPLAY \"Done.\"\n    NOT END DISPLAY \"Wait.\"\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_47() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ foo\n    NEXT RECORD INTO bar\n    AT END DISPLAY \"Done.\"\n    NOT AT END DISPLAY \"Wait.\"\n   END-READ "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_48() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ stock-file WITH KEPT LOCK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_49() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ stock-file WITH WAIT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_50() {
      ParserCombinator parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" READ stock-file WAIT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}