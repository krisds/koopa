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
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM TERMINAL-INFO ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_12() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM SYSTEM-INFO ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_13() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM INPUT STATUS ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_14() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM ESCAPE KEY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_15() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM EXCEPTION STATUS ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_16() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM LINE NUMBER ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_17() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM USER NAME ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_18() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM COMMAND-LINE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_19() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM STANDARD OBJECT MY-OBJECT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_20() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM THREAD HANDLE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_21() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT fee FROM WINDOW HANDLE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_22() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_23() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_24() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY-OF-WEEK ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_25() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM TIME ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_26() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YEAR ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_27() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE YYYYMMDD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_28() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE CENTURY-DATE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_29() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YYYYMMDD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_30() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM CENTURY-DATE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_31() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY YYYYDDD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_32() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY CENTURY-DAY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_33() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YYYYDDD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_34() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM CENTURY-DAY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_35() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_36() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_37() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY-OF-WEEK END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_38() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM TIME END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_39() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YEAR END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_40() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE YYYYMMDD END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_41() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE CENTURY-DATE END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_42() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YYYYMMDD END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_43() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM CENTURY-DATE END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_44() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY YYYYDDD END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_45() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY CENTURY-DAY END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_46() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YYYYDDD END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_47() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM CENTURY-DAY END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_48() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo MESSAGE COUNT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_49() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo MESSAGE COUNT END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_50() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo COUNT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_51() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo COUNT END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_52() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_53() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_54() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     ON EXCEPTION DISPLAY \"OOPS\"\n     NOT ON EXCEPTION DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_55() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo \n     ON EXCEPTION DISPLAY \"OOPS\"\n     NOT ON EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_56() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     EXCEPTION DISPLAY \"OOPS\"\n     NOT EXCEPTION DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_57() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n   EXCEPTION DISPLAY \"OOPS\"\n     NOT EXCEPTION DISPLAY \"OK\"\n     END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_58() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     ON EXCEPTION DISPLAY \"OOPS\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_59() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     ON EXCEPTION DISPLAY \"OOPS\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_60() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     NOT ON EXCEPTION DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_61() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     NOT ON EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_62() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT LINE NUMBER 27 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_63() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT LINE 27 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_64() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT COLUMN NUMBER 27 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_65() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT COLUMN 27 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_66() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT COL NUMBER 27 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_67() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT COL 27 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_68() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT LINE NUMBER 27 COLUMN NUMBER 28 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_69() {
      Parser parser = grammar.acceptStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT MYVAR AT COLUMN NUMBER 27 LINE NUMBER 28 END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}