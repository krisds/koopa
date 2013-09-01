package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from AcceptStatement.stage. */
public class AcceptStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testAcceptStatement_1() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_2() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_3() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     ON EXCEPTION DISPLAY \"OOPS\"\n     NOT ON EXCEPTION DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_4() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     ON EXCEPTION DISPLAY \"OOPS\"\n     NOT ON EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_5() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     EXCEPTION DISPLAY \"OOPS\"\n     NOT EXCEPTION DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_6() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     EXCEPTION DISPLAY \"OOPS\"\n     NOT EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_7() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     ON EXCEPTION DISPLAY \"OOPS\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_8() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     ON EXCEPTION DISPLAY \"OOPS\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_9() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     NOT ON EXCEPTION DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_10() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     NOT ON EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_11() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM CRT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_12() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM TERMINAL-INFO ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_13() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM SYSTEM-INFO ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_14() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM INPUT STATUS ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_15() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM ESCAPE KEY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_16() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM EXCEPTION STATUS ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_17() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM LINE NUMBER ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_18() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM USER NAME ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_19() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM COMMAND-LINE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_20() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM STANDARD OBJECT MY-OBJECT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_21() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM THREAD HANDLE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_22() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM WINDOW HANDLE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_23() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_24() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_25() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY-OF-WEEK ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_26() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM TIME ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_27() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YEAR ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_28() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE YYYYMMDD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_29() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE CENTURY-DATE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_30() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YYYYMMDD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_31() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM CENTURY-DATE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_32() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY YYYYDDD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_33() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY CENTURY-DAY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_34() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YYYYDDD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_35() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM CENTURY-DAY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_36() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_37() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_38() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY-OF-WEEK END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_39() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM TIME END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_40() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YEAR END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_41() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE YYYYMMDD END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_42() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE CENTURY-DATE END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_43() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YYYYMMDD END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_44() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM CENTURY-DATE END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_45() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY YYYYDDD END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_46() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY CENTURY-DAY END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_47() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YYYYDDD END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_48() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM CENTURY-DAY END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_49() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo MESSAGE COUNT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_50() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo MESSAGE COUNT END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_51() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo COUNT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_52() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo COUNT END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_53() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_54() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_55() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     ON EXCEPTION DISPLAY \"OOPS\"\n     NOT ON EXCEPTION DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_56() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo \n     ON EXCEPTION DISPLAY \"OOPS\"\n     NOT ON EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_57() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     EXCEPTION DISPLAY \"OOPS\"\n     NOT EXCEPTION DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_58() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n   EXCEPTION DISPLAY \"OOPS\"\n     NOT EXCEPTION DISPLAY \"OK\"\n     END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_59() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     ON EXCEPTION DISPLAY \"OOPS\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_60() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     ON EXCEPTION DISPLAY \"OOPS\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_61() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     NOT ON EXCEPTION DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_62() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     NOT ON EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_63() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT LINE NUMBER 27 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_64() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT LINE 27 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_65() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT COLUMN NUMBER 27 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_66() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT COLUMN 27 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_67() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT COL NUMBER 27 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_68() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT COL 27 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_69() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT LINE NUMBER 27 COLUMN NUMBER 28 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_70() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT COLUMN NUMBER 27 LINE NUMBER 28 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_71() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM LINE NUMBER ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_72() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM USER NAME ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_73() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM ESCAPE KEY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_74() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM EXCEPTION STATUS ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_75() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM LINE NUMBER END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_76() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM USER NAME END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_77() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM ESCAPE KEY END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_78() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM EXCEPTION STATUS END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_79() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     ON ESCAPE DISPLAY \"OOPS\"\n     NOT ON ESCAPE DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_80() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo \n     ON ESCAPE DISPLAY \"OOPS\"\n     NOT ON ESCAPE DISPLAY \"OK\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_81() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     ESCAPE DISPLAY \"OOPS\"\n     NOT ESCAPE DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_82() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n   ESCAPE DISPLAY \"OOPS\"\n     NOT ESCAPE DISPLAY \"OK\"\n     END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_83() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     ON ESCAPE DISPLAY \"OOPS\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_84() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     ON ESCAPE DISPLAY \"OOPS\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_85() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     NOT ON ESCAPE DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_86() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     NOT ON ESCAPE DISPLAY \"OK\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_87() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo AT bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_88() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo AT LINE 10 COL 10 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_89() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo AT LINE NUMBER 10 COLUMN NUMBER 10 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_90() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo AT LINE NUMBER bar COLUMN NUMBER 10 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_91() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo AT LINE NUMBER 10 COLUMN NUMBER bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_92() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo AT LINE NUMBER bar COLUMN NUMBER baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_93() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo MODE BLOCK ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_94() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo MODE IS BLOCK ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_95() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH AUTO ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_96() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH AUTO-SKIP ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_97() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH BELL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_98() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH BEEP ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_99() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH BLINK ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_100() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH FULL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_101() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH LENGTH-CHECK ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_102() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH GRID ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_103() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH HIGHLIGHT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_104() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH LOWLIGHT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_105() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH LEFTLINE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_106() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH OVERLINE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_107() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH PROMPT \">\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_108() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH PROMPT bar ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_109() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH PROMPT CHARACTER \">\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_110() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH PROMPT CHARACTER IS \">\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_111() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH PROMPT CHARACTER IS bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_112() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH REQUIRED ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_113() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH EMPTY-CHECK ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_114() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH REVERSE-VIDEO ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_115() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH SECURE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_116() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH NO-ECHO ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_117() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH SIZE ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_118() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH SIZE bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_119() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH SIZE IS bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_120() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH SIZE 10 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_121() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH SIZE IS 10 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_122() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH UNDERLINE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_123() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH FOREGROUND-COLOR IS 1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_124() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH FOREGROUND-COLOR 1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_125() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH BACKGROUND-COLOR IS 1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_126() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH BACKGROUND-COLOR 1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_127() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH CONTROL bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_128() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH CONTROL IS bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_129() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH CONTROL \"bar\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_130() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH CONTROL IS \"bar\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_131() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH TIME-OUT ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_132() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH TIME-OUT AFTER ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_133() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH TIME-OUT AFTER bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_134() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH TIME-OUT AFTER 60 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_135() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH TIMEOUT ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_136() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH TIMEOUT AFTER ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_137() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH TIMEOUT AFTER bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_138() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH TIMEOUT AFTER 60 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_139() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH LEFT-JUSTIFY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_140() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH RIGHT-JUSTIFY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_141() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH SPACE-FILL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_142() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH TRAILING-SIGN ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_143() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH UPDATE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_144() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH UPPER ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_145() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH LOWER ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_146() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH ZERO-FILL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_147() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo WITH\n     AUTO\n     BELL\n     BLINK\n     GRID\n     HIGHLIGHT\n     REQUIRED\n     SIZE IS 10\n     UNDERLINE\n     FOREGROUND-COLOR IS 1\n     BACKGROUND-COLOR IS 10\n     TIMEOUT AFTER 60\n     UPPER\n     SPACE-FILL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}