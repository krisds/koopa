package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from ReadStatement.stage. */
public class ReadStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testReadStatement_1() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \u2022 .");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_2() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE\n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_3() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE\n     WITH NO LOCK\n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_4() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE\n     NO LOCK\n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_5() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE\n     NEXT RECORD\n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_6() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE\n     PREVIOUS RECORD\n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_7() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE\n     RECORD\n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_8() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE\n     INTO MY-VALUE\n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_9() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE\n     KEY IS MY-KEY\n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_10() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE\n     KEY MY-KEY\n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_11() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   AT END\n      DISPLAY \"Nothing more to see here.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_12() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   END\n      DISPLAY \"Nothing more to see here.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_13() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   NOT AT END\n      DISPLAY \"Look at that...\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_14() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   NOT END\n      DISPLAY \"Look at that...\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_15() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   INVALID KEY\n      DISPLAY \"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_16() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   INVALID\n      DISPLAY \"Oops.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_17() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   NOT INVALID KEY\n      DISPLAY \"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_18() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   NOT INVALID\n      DISPLAY \"A-OK.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_19() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   AT END\n      DISPLAY \"Nothing more to see here.\" \n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_20() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   END\n      DISPLAY \"Nothing more to see here.\" \n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_21() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   NOT AT END\n      DISPLAY \"Look at that...\" \n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_22() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   NOT END\n      DISPLAY \"Look at that...\" \n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_23() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   INVALID KEY\n      DISPLAY \"Oops.\" \n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_24() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   INVALID\n      DISPLAY \"Oops.\" \n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_25() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   NOT INVALID KEY\n      DISPLAY \"A-OK.\" \n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReadStatement_26() {
      Parser parser = grammar.readStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, "READ MY-FILE \n   NOT INVALID\n      DISPLAY \"A-OK.\" \n   END-READ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}