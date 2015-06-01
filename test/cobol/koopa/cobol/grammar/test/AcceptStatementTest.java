package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from AcceptStatement.stage. */
public class AcceptStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testAcceptStatement_1() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_2() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM bar END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_3() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM bar\n     ON EXCEPTION DISPLAY \"OOPS\"\n     NOT ON EXCEPTION DISPLAY \"OK\"\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_4() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM bar\n     ON EXCEPTION DISPLAY \"OOPS\"\n     NOT ON EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_5() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM bar\n     EXCEPTION DISPLAY \"OOPS\"\n     NOT EXCEPTION DISPLAY \"OK\"\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_6() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM bar\n     EXCEPTION DISPLAY \"OOPS\"\n     NOT EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_7() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM bar\n     ON EXCEPTION DISPLAY \"OOPS\"\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_8() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM bar\n     ON EXCEPTION DISPLAY \"OOPS\"\n   END-ACCEPT\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_9() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM bar\n     NOT ON EXCEPTION DISPLAY \"OK\"\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_10() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM bar\n     NOT ON EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_11() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT fee FROM CRT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_12() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT fee FROM TERMINAL-INFO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_13() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT fee FROM SYSTEM-INFO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_14() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT fee FROM INPUT STATUS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_15() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT fee FROM ESCAPE KEY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_16() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT fee FROM EXCEPTION STATUS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_17() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT fee FROM LINE NUMBER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_18() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT fee FROM USER NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_19() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT fee FROM COMMAND-LINE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_20() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT fee FROM STANDARD OBJECT MY-OBJECT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_21() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT fee FROM THREAD HANDLE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_22() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT fee FROM WINDOW HANDLE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_23() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM DATE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_24() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM DAY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_25() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM DAY-OF-WEEK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_26() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM TIME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_27() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM YEAR "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_28() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM DATE YYYYMMDD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_29() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM DATE CENTURY-DATE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_30() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM YYYYMMDD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_31() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM CENTURY-DATE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_32() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM DAY YYYYDDD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_33() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM DAY CENTURY-DAY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_34() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM YYYYDDD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_35() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM CENTURY-DAY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_36() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM DATE END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_37() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM DAY END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_38() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM DAY-OF-WEEK END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_39() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM TIME END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_40() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM YEAR END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_41() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM DATE YYYYMMDD END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_42() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM DATE CENTURY-DATE END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_43() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM YYYYMMDD END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_44() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM CENTURY-DATE END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_45() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM DAY YYYYDDD END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_46() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM DAY CENTURY-DAY END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_47() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM YYYYDDD END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_48() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM CENTURY-DAY END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_49() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo MESSAGE COUNT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_50() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo MESSAGE COUNT END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_51() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo COUNT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_52() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo COUNT END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_53() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_54() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_55() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo\n     ON EXCEPTION DISPLAY \"OOPS\"\n     NOT ON EXCEPTION DISPLAY \"OK\"\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_56() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo \n     ON EXCEPTION DISPLAY \"OOPS\"\n     NOT ON EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_57() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo\n     EXCEPTION DISPLAY \"OOPS\"\n     NOT EXCEPTION DISPLAY \"OK\"\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_58() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo\n   EXCEPTION DISPLAY \"OOPS\"\n     NOT EXCEPTION DISPLAY \"OK\"\n     END-ACCEPT\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_59() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo\n     ON EXCEPTION DISPLAY \"OOPS\"\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_60() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo\n     ON EXCEPTION DISPLAY \"OOPS\"\n   END-ACCEPT\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_61() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo\n     NOT ON EXCEPTION DISPLAY \"OK\"\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_62() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo\n     NOT ON EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_63() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT MYVAR AT LINE NUMBER 27 END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_64() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT MYVAR AT LINE 27 END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_65() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT MYVAR AT COLUMN NUMBER 27 END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_66() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT MYVAR AT COLUMN 27 END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_67() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT MYVAR AT COL NUMBER 27 END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_68() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT MYVAR AT COL 27 END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_69() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT MYVAR AT LINE NUMBER 27 COLUMN NUMBER 28 END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_70() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT MYVAR AT COLUMN NUMBER 27 LINE NUMBER 28 END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_71() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM LINE NUMBER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_72() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM USER NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_73() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM ESCAPE KEY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_74() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM EXCEPTION STATUS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_75() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM LINE NUMBER END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_76() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM USER NAME END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_77() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM ESCAPE KEY END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_78() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo FROM EXCEPTION STATUS END-ACCEPT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_79() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo\n     ON ESCAPE DISPLAY \"OOPS\"\n     NOT ON ESCAPE DISPLAY \"OK\"\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_80() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo \n     ON ESCAPE DISPLAY \"OOPS\"\n     NOT ON ESCAPE DISPLAY \"OK\"\n   END-ACCEPT\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_81() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo\n     ESCAPE DISPLAY \"OOPS\"\n     NOT ESCAPE DISPLAY \"OK\"\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_82() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo\n   ESCAPE DISPLAY \"OOPS\"\n     NOT ESCAPE DISPLAY \"OK\"\n     END-ACCEPT\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_83() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo\n     ON ESCAPE DISPLAY \"OOPS\"\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_84() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo\n     ON ESCAPE DISPLAY \"OOPS\"\n   END-ACCEPT\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_85() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo\n     NOT ON ESCAPE DISPLAY \"OK\"\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_86() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo\n     NOT ON ESCAPE DISPLAY \"OK\"\n   END-ACCEPT\n "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_87() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo AT bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_88() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo AT LINE 10 COL 10 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_89() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo AT LINE NUMBER 10 COLUMN NUMBER 10 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_90() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo AT LINE NUMBER bar COLUMN NUMBER 10 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_91() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo AT LINE NUMBER 10 COLUMN NUMBER bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_92() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo AT LINE NUMBER bar COLUMN NUMBER baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_93() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo MODE BLOCK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_94() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo MODE IS BLOCK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_95() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH AUTO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_96() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH AUTO-SKIP "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_97() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH BELL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_98() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH BEEP "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_99() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH BLINK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_100() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH FULL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_101() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH LENGTH-CHECK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_102() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH GRID "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_103() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH HIGHLIGHT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_104() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH LOWLIGHT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_105() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH LEFTLINE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_106() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH OVERLINE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_107() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH PROMPT \">\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_108() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH PROMPT bar "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_109() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH PROMPT CHARACTER \">\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_110() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH PROMPT CHARACTER IS \">\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_111() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH PROMPT CHARACTER IS bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_112() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH REQUIRED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_113() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH EMPTY-CHECK "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_114() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH REVERSE-VIDEO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_115() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH SECURE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_116() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH NO-ECHO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_117() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH SIZE "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_118() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH SIZE bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_119() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH SIZE IS bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_120() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH SIZE 10 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_121() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH SIZE IS 10 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_122() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH UNDERLINE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_123() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH FOREGROUND-COLOR IS 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_124() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH FOREGROUND-COLOR 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_125() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH BACKGROUND-COLOR IS 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_126() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH BACKGROUND-COLOR 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_127() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH CONTROL bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_128() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH CONTROL IS bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_129() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH CONTROL \"bar\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_130() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH CONTROL IS \"bar\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_131() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH TIME-OUT "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_132() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH TIME-OUT AFTER "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_133() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH TIME-OUT AFTER bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_134() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH TIME-OUT AFTER 60 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_135() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH TIMEOUT "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_136() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH TIMEOUT AFTER "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_137() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH TIMEOUT AFTER bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_138() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH TIMEOUT AFTER 60 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_139() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH LEFT-JUSTIFY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_140() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH RIGHT-JUSTIFY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_141() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH SPACE-FILL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_142() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH TRAILING-SIGN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_143() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH UPDATE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_144() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH UPPER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_145() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH LOWER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_146() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH ZERO-FILL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_147() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT foo WITH\n     AUTO\n     BELL\n     BLINK\n     GRID\n     HIGHLIGHT\n     REQUIRED\n     SIZE IS 10\n     UNDERLINE\n     FOREGROUND-COLOR IS 1\n     BACKGROUND-COLOR IS 10\n     TIMEOUT AFTER 60\n     UPPER\n     SPACE-FILL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_148() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ACCEPT WANO-ACID-PART AT 0851 WITH SIZE 4 UPDATE AUTO ZERO-FILL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_149() {
      ParserCombinator parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" accept   ws-env-lines   from lines "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}