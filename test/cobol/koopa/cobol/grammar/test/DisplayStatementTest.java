package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from DisplayStatement.stage. */
public class DisplayStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testDisplayStatement_1() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY \"foo\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_2() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY \"foo\" END-DISPLAY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_3() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_4() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo END-DISPLAY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_5() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo bar baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_6() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo bar baz END-DISPLAY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_7() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY A, B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_8() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo UPON CRT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_9() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo UPON bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_10() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo NO ADVANCING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_11() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo WITH NO ADVANCING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_12() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo EXCEPTION DISPLAY \"foo\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_13() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo ON EXCEPTION DISPLAY \"foo\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_14() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo NOT EXCEPTION DISPLAY \"foo\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_15() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo NOT ON EXCEPTION DISPLAY \"foo\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_16() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY \"Do you want to run the function \"\n     function-name \"? \" WITH NO ADVANCING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_17() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo\n     UPON CRT\n     WITH NO ADVANCING\n     ON EXCEPTION DISPLAY \"bar\"\n   END-DISPLAY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_18() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY OMITTED AT 2301 END-DISPLAY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_19() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY OMITTED AT bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_20() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY \"foo\" AT 2301 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_21() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY \"foo\" AT bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_22() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_23() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_24() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT LINE 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_25() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT COLUMN 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_26() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT LINE 1 COLUMN 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_27() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT COLUMN 1 LINE 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_28() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo LINE 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_29() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo COLUMN 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_30() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo LINE 1 COLUMN 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_31() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT LINE 1 COL 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_32() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT LINE 1 POS 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_33() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT LINE 1 POSITION 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_34() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT LINE bar COLUMN baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_35() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT LINE NUMBER 1 COLUMN NUMBER 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_36() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 MODE BLOCK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_37() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 MODE IS BLOCK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_38() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH BELL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_39() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH BEEP "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_40() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH BLINK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_41() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH GRID "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_42() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH ERASE EOL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_43() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH ERASE EOS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_44() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH HIGHLIGHT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_45() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH LOWLIGHT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_46() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH LEFTLINE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_47() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH OVERLINE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_48() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH REVERSE-VIDEO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_49() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH SIZE 10 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_50() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH SIZE IS 10 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_51() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH SIZE bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_52() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH SIZE IS bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_53() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH UNDERLINE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_54() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH FOREGROUND-COLOR 0 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_55() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH FOREGROUND-COLOUR 0 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_56() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH FOREGROUND-COLOR IS 0 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_57() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH FOREGROUND-COLOUR IS 0 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_58() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH BACKGROUND-COLOR 0 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_59() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH BACKGROUND-COLOUR 0 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_60() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH BACKGROUND-COLOR IS 0 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_61() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH BACKGROUND-COLOUR IS 0 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_62() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH CONTROL \"bar\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_63() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH CONTROL IS \"bar\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_64() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH CONTROL bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_65() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH CONTROL IS bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_66() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH BLANK SCREEN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_67() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo AT 2301 WITH BLANK LINE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_68() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY foo\n     AT LINE 0 COLUMN 0\n     UPON CRT\n     MODE IS BLOCK\n     WITH BELL\n          BLINK\n          HIGHLIGHT\n          UNDERLINE\n          FOREGROUND-COLOR IS 0\n          BACKGROUND-COLOR IS 10\n          BLANK SCREEN\n   END-DISPLAY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDisplayStatement_69() {
      ParserCombinator parser = grammar.displayStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY \" \" AT 2401 ERASE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}