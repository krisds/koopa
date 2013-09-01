package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from IdentificationDivision.stage. */
public class IdentificationDivisionTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testIdentificationDivision_1() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   PROGRAM-ID . TEST-01 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_2() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ID DIVISION .\n   PROGRAM-ID . TEST-01 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_3() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROGRAM-ID . TEST-01 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_4() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   PROGRAM-ID . \"TEST-01\" . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_5() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ID DIVISION .\n   PROGRAM-ID . \"TEST-01\" . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_6() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROGRAM-ID . \"TEST-01\" . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_7() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   PROGRAM-ID . TEST-01 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_8() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   PROGRAM-ID TEST-01 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_9() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   PROGRAM-ID TEST-01 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_10() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROGRAM-ID . TEST-01 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_11() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROGRAM-ID TEST-01 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_12() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROGRAM-ID TEST-01 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_13() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   PROGRAM-ID . TEST-02 INITIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_14() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   PROGRAM-ID . \"TEST-02\" INITIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_15() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   PROGRAM-ID . TEST-02 INITIAL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_16() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-03 COMMON . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_17() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . \"TEST-03\" COMMON . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_18() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-03 COMMON ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_19() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-04 INITIAL COMMON . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_20() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . \"TEST-04\" INITIAL COMMON . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_21() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-04 INITIAL COMMON ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_22() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-05 COMMON INITIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_23() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . \"TEST-05\" COMMON INITIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_24() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-05 COMMON INITIAL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_25() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-06 IS INITIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_26() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . \"TEST-06\" IS INITIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_27() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-06 IS INITIAL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_28() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-07 IS COMMON . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_29() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . \"TEST-07\" IS COMMON . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_30() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-07 IS COMMON ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_31() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-08 IS INITIAL COMMON . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_32() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . \"TEST-08\" IS INITIAL COMMON . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_33() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-08 IS INITIAL COMMON ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_34() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-09 IS COMMON INITIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_35() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . \"TEST-09\" IS COMMON INITIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_36() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-09 IS COMMON INITIAL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_37() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-10 IS INITIAL PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_38() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . \"TEST-10\" IS INITIAL PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_39() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-10 IS INITIAL PROGRAM ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_40() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-11 IS COMMON PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_41() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . \"TEST-11\" IS COMMON PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_42() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-11 IS COMMON PROGRAM ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_43() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-12 IS INITIAL COMMON PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_44() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . \"TEST-12\" IS INITIAL COMMON PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_45() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-12 IS INITIAL COMMON PROGRAM ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_46() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-13 IS COMMON INITIAL PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_47() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . \"TEST-13\" IS COMMON INITIAL PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_48() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-13 IS COMMON INITIAL PROGRAM ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_49() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-14 INITIAL PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_50() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . \"TEST-14\" INITIAL PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_51() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-14 INITIAL PROGRAM ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_52() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-15 COMMON PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_53() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . \"TEST-15\" COMMON PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_54() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-15 COMMON PROGRAM ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_55() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-16 INITIAL COMMON PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_56() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . \"TEST-16\" INITIAL COMMON PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_57() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-16 INITIAL COMMON PROGRAM ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_58() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-17 COMMON INITIAL PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_59() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . \"TEST-17\" COMMON INITIAL PROGRAM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_60() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION . \n   PROGRAM-ID . TEST-17 COMMON INITIAL PROGRAM ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_61() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   CLASS-ID . foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_62() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CLASS-ID . foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_63() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   CLASS-ID . foo  AS \"bar\" . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_64() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   CLASS-ID . foo INHERITS FROM bar . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_65() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   CLASS-ID . foo INHERITS FROM bar baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_66() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   CLASS-ID . foo INHERITS FROM bar IS STATIC FINAL PUBLIC . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_67() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   CLASS-ID . foo PUBLIC IMPLEMENTS bar baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_68() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   CLASS-ID . foo PUBLIC\n   ATTRIBUTE bar (b1 NAME b2 = v2 NAME b3 = v3 b4)\n   IMPLEMENTS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_69() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   CLASS-ID . foo PUBLIC\n   ATTRIBUTE bar ()\n   IMPLEMENTS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_70() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   CLASS-ID . foo PUBLIC\n   ATTRIBUTE bar (b1)\n   IMPLEMENTS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_71() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   CLASS-ID . foo PUBLIC\n   ATTRIBUTE bar (b1 b2)\n   IMPLEMENTS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_72() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   CLASS-ID . foo PUBLIC\n   ATTRIBUTE bar (b1 b2)\n   ATTRIBUTE baz (b3)\n   IMPLEMENTS boojum . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_73() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   CLASS-ID . foo\n   ATTRIBUTE bar (NAME snark = \"boojum\")\n   IMPLEMENTS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_74() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   CLASS-ID . foo\n   CUSTOM-ATTRIBUTE IS bar (snark = \"boojum\")\n   IMPLEMENTS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_75() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   METHOD-ID . foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_76() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " METHOD-ID . foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_77() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   METHOD-ID . foo  AS \"bar\" . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_78() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   METHOD-ID . GET PROPERTY foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_79() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   METHOD-ID . SET PROPERTY foo SYNC . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_80() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   METHOD-ID . foo IS STATIC PUBLIC . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_81() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   METHOD-ID . foo ABSTRACT FOR bar . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_82() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " IDENTIFICATION DIVISION .\n   METHOD-ID . foo PUBLIC USING bar . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_83() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FACTORY . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_84() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FACTORY . IMPLEMENTS foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_85() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FACTORY . IMPLEMENTS foo bar . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_86() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STATIC . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_87() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " STATIC . IMPLEMENTS foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_88() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INTERFACE-ID . foo INTERNAL INHERITS FROM bar USING baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_89() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION-ID . foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_90() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION-ID . foo AS \"bar\" PROTOTYPE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_91() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION-ID . foo PROTOTYPE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_92() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION-ID . foo IS PROTOTYPE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_93() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " DELEGATE-ID . foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_94() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " DELEGATE-ID . foo IS PROTECTED . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_95() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENUM-ID . foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_96() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENUM-ID . foo IS PUBLIC . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_97() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENUM-ID . foo IS PRIVATE . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_98() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENUM-ID . foo IS PROTECTED . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_99() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ENUM-ID . foo IS INTERNAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_100() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ITERATOR-ID . foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_101() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ITERATOR-ID . foo AS \"baz\" . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_102() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ITERATOR-ID . foo AS \"baz\" PUBLIC . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_103() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " OPERATOR-ID . = . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_104() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " OPERATOR-ID . = EXTENSION . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_105() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " OPERATOR-ID . <> . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_106() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " OPERATOR-ID . + . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_107() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " OPERATOR-ID . - . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_108() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " OPERATOR-ID . * . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_109() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " OPERATOR-ID . / . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_110() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " OPERATOR-ID . B-AND . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_111() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " OPERATOR-ID . B-XOR . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_112() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " OPERATOR-ID . B-NOT . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_113() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " OPERATOR-ID . IMPLICIT . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_114() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " OPERATOR-ID . EXPLICIT . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_115() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " VALUETYPE-ID . foo . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_116() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " VALUETYPE-ID . foo PARTIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_117() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " VALUETYPE-ID . foo IMPLEMENTS bar . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_118() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " VALUETYPE-ID . foo\n   ATTRIBUTE bar (b1 b2)\n   IMPLEMENTS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentificationDivision_119() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " VALUETYPE-ID . foo\n   ATTRIBUTE bar (b1 b2)\n   ATTRIBUTE baz ()\n   IMPLEMENTS boojum . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}