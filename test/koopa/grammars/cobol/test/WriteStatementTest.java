package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from WriteStatement.stage. */
public class WriteStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testWriteStatement_1() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \u2022 .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_2() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_3() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD FROM MY-SOMETHING\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_4() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     AFTER ADVANCING 1 LINE\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_5() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     AFTER 1 LINE\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_6() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     AFTER ADVANCING 1\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_7() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     AFTER 1\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_8() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     BEFORE ADVANCING 1 LINE\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_9() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     BEFORE 1 LINE\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_10() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     BEFORE ADVANCING 1\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_11() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     BEFORE 1\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_12() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     AFTER ADVANCING N LINE\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_13() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     AFTER N LINE\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_14() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     AFTER ADVANCING N\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_15() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     AFTER N\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_16() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     BEFORE ADVANCING N LINE\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_17() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     BEFORE N LINE\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_18() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     BEFORE ADVANCING N\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_19() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     BEFORE N\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_20() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     AFTER ADVANCING MY-MNEMONIC\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_21() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     AFTER MY-MNEMONIC\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_22() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     BEFORE ADVANCING MY-MNEMONIC\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_23() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     BEFORE MY-MNEMONIC\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_24() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     AFTER ADVANCING PAGE\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_25() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     AFTER PAGE\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_26() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     BEFORE ADVANCING PAGE\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_27() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     BEFORE PAGE\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_28() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD\n     BEFORE ADVANCING ZERO\n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_29() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   AT END-OF-PAGE\n      DISPLAY \"End of page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_30() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   AT EOP\n      DISPLAY \"End of page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_31() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   END-OF-PAGE\n      DISPLAY \"End of page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_32() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   EOP\n      DISPLAY \"End of page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_33() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   NOT AT END-OF-PAGE\n      DISPLAY \"Elsewhere on page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_34() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   NOT AT EOP\n      DISPLAY \"Elsewhere on page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_35() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   NOT END-OF-PAGE\n      DISPLAY \"Elsewhere on page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_36() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   NOT EOP\n      DISPLAY \"Elsewhere on page.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_37() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   INVALID KEY\n      DISPLAY \"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_38() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   INVALID\n      DISPLAY \"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_39() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   NOT INVALID KEY\n      DISPLAY \"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_40() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   NOT INVALID\n      DISPLAY \"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_41() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   AT END-OF-PAGE\n      DISPLAY \"End of page.\" \n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_42() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   AT EOP\n      DISPLAY \"End of page.\" \n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_43() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   END-OF-PAGE\n      DISPLAY \"End of page.\" \n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_44() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   EOP\n      DISPLAY \"End of page.\" \n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_45() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   NOT AT END-OF-PAGE\n      DISPLAY \"Elsewhere on page.\" \n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_46() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   NOT AT EOP\n      DISPLAY \"Elsewhere on page.\" \n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_47() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   NOT END-OF-PAGE\n      DISPLAY \"Elsewhere on page.\" \n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_48() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   NOT EOP\n      DISPLAY \"Elsewhere on page.\" \n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_49() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   INVALID KEY\n      DISPLAY \"Oops.\" \n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_50() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   INVALID\n      DISPLAY \"Oops.\" \n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_51() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" \n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWriteStatement_52() {
      Parser parser = grammar.writeStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "WRITE MY-RECORD \n   NOT INVALID\n      DISPLAY \"A-OK.\" \n   END-WRITE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}