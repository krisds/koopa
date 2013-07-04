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
    public void testAcceptStatement_fromMnemonic_1() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_2() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_3() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_4() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_5() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     ON EXCEPTION DISPLAY \"OOPS\"\n     NOT ON EXCEPTION DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_6() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     ON EXCEPTION DISPLAY \"OOPS\"\n     NOT ON EXCEPTION DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_7() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo \n     ON EXCEPTION DISPLAY \"OOPS\"\n     NOT ON EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_8() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     ON EXCEPTION DISPLAY \"OOPS\"\n     NOT ON EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_9() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     EXCEPTION DISPLAY \"OOPS\"\n     NOT EXCEPTION DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_10() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     EXCEPTION DISPLAY \"OOPS\"\n     NOT EXCEPTION DISPLAY \"OK\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_11() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n   EXCEPTION DISPLAY \"OOPS\"\n     NOT EXCEPTION DISPLAY \"OK\"\n     END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_12() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     EXCEPTION DISPLAY \"OOPS\"\n     NOT EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_13() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     ON EXCEPTION DISPLAY \"OOPS\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_14() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     ON EXCEPTION DISPLAY \"OOPS\"\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_15() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     ON EXCEPTION DISPLAY \"OOPS\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_16() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     ON EXCEPTION DISPLAY \"OOPS\"\n   END-ACCEPT\n ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_17() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     NOT ON EXCEPTION DISPLAY \"OK\"\n ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_18() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     NOT ON EXCEPTION DISPLAY \"OK\"\n ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_19() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo\n     NOT ON EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromMnemonic_20() {
      Parser parser = grammar.acceptStatement_fromMnemonic();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM bar\n     NOT ON EXCEPTION DISPLAY \"OK\"\n   END-ACCEPT\n ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_21() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_22() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_23() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY-OF-WEEK ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_24() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM TIME ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_25() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YEAR ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_26() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE YYYYMMDD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_27() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE CENTURY-DATE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_28() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YYYYMMDD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_29() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM CENTURY-DATE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_30() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY YYYYDDD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_31() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY CENTURY-DAY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_32() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YYYYDDD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_33() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM CENTURY-DAY ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_34() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_35() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_36() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY-OF-WEEK END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_37() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM TIME END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_38() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YEAR END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_39() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE YYYYMMDD END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_40() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DATE CENTURY-DATE END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_41() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YYYYMMDD END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_42() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM CENTURY-DATE END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_43() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY YYYYDDD END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_44() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM DAY CENTURY-DAY END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_45() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM YYYYDDD END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_fromDate_46() {
      Parser parser = grammar.acceptStatement_fromDate();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo FROM CENTURY-DAY END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_messageCount_47() {
      Parser parser = grammar.acceptStatement_messageCount();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo MESSAGE COUNT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_messageCount_48() {
      Parser parser = grammar.acceptStatement_messageCount();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo MESSAGE COUNT END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_messageCount_49() {
      Parser parser = grammar.acceptStatement_messageCount();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo COUNT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAcceptStatement_messageCount_50() {
      Parser parser = grammar.acceptStatement_messageCount();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ACCEPT foo COUNT END-ACCEPT ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}