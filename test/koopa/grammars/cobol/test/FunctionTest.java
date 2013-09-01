package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from Function.stage. */
public class FunctionTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testIdentifier_format1_1() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION ACOS ( IND ( 5 ) / 9 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_2() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION ASIN ( A / 9 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_3() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION ATAN ( A * 0.45 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_4() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION COS ( B ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_5() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION SIN ( 90 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_6() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION TAN ( FUNCTION ATAN ( X + Y ) ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_7() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION BOOLEAN-OF-INTEGER ( 10 2 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_8() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION DATE-OF-INTEGER ( 365 * Y ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_9() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION DATE-TO-YYYYMMDD ( 1000000 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_10() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION DATE-TO-YYYYMMDD ( 851003 50 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_11() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION DATE-TO-YYYYMMDD ( FUNCTION DATE-OF-INTEGER ( 365 * Y ), (-10) ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_12() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION DAY-OF-INTEGER ( 365 * Y ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_13() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION DAY-TO-YYYYMMDD ( 1000000 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_14() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION DAY-TO-YYYYMMDD ( 1000000 50 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_15() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION DAY-TO-YYYYMMDD ( FUNCTION DAY-OF-INTEGER ( 365 * Y ), (-10) ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_16() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION INTEGER-OF-BOOLEAN ( FUNCTION BOOLEAN-OF-INTEGER ( 10 2 ) ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_17() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION INTEGER-OF-DATE ( 20130815 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_18() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION INTEGER-OF-DAY ( YYYY * 1000 + DDD ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_19() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION YEAR-TO-YYYY ( 13 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_20() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION YEAR-TO-YYYY ( 95 50 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_21() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION ABS ( 1 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_22() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION ABS ( -1 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_23() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION ANNUITY ( B / 2  8 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_24() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION CHAR ( 10 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_25() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION CHAR-NATIONAL ( 10 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_26() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION CURRENT-DATE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_27() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION DISPLAY-OF ( n\"foo\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_28() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION DISPLAY-OF ( n\"bar\" \"?\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_29() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION DISPLAY-OF ( n\"baz\" 1208 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_30() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION NATIONAL-OF ( \"foo\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_31() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION NATIONAL-OF ( \"bar\" n\"?\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_32() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION NATIONAL-OF ( \"baz\" 1208 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_33() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION E ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_34() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION EXP ( P / 2 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_35() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION EXP10 ( 9.04 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_36() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION FACTORIAL ( 5 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_37() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION FRACTION-PART ( FUNCTION PI ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_38() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION FRACTION-PART ( 19 / 7 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_39() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION FRACTION-PART ( 1.5 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_40() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION INTEGER-PART ( FUNCTION PI ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_41() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION INTEGER-PART ( 19 / 7 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_42() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION INTEGER-PART ( 1.5 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_43() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION INTEGER ( FUNCTION PI ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_44() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION INTEGER ( 19 / 7 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_45() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION INTEGER ( 1.5 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_46() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION LENGTH ( \"A\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_47() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION LENGTH ( n\"AB\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_48() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION LENGTH-AN ( \"ABC\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_49() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION LOG ( FUNCTION E ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_50() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION LOG10 ( 10 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_51() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION MAX ( A * B  ( C + 1 ) / 2  3 + 4 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_52() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION MAX ( \"A\" \"B\" \"C\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_53() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION MEAN ( A * B  ( C + 1 ) / 2  3 + 4 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_54() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION MEDIAN ( A * B  ( C + 1 ) / 2  3 + 4 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_55() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION MIDRANGE ( A * B  ( C + 1 ) / 2  3 + 4 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_56() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION MIN ( A * B  ( C + 1 ) / 2  3 + 4 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_57() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION MIN ( \"A\" \"B\" \"C\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_58() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION RANGE ( A * B  ( C + 1 ) / 2  3 + 4 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_59() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION MOD ( 11 5 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_60() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION MOD ( -11 5 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_61() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION MOD ( 11 -5 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_62() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION MOD ( -11 -5 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_63() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION NUMVAL ( foo ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_64() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION NUMVAL ( \"  2  \" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_65() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION NUMVAL ( \"-2.5\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_66() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION NUMVAL ( n\"3.14\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_67() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION NUMVAL ( \"3,14\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_68() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION NUMVAL-C ( foo ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_69() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION NUMVAL-C ( \"  2  \" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_70() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION NUMVAL-C ( \"-2.5\" \"$\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_71() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION NUMVAL-C ( n\"3,14\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_72() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION NUMVAL-C ( \"3.14\" \"£\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_73() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION ORD ( char ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_74() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION ORD ( \"A\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_75() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION ORD ( n\"A\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_76() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION ORD-MAX ( char-1 char-2 char-3 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_77() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION ORD-MAX ( \"A\" \"B\" \"C\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_78() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION ORD-MAX ( n\"A\" n\"B\" n\"C\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_79() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION ORD-MIN ( char-1 char-2 char-3 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_80() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION ORD-MIN ( \"A\" \"B\" \"C\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_81() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION ORD-MIN ( n\"A\" n\"B\" n\"C\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_82() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION PI ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_83() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION PRESENT-VALUE ( 5 100 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_84() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION PRESENT-VALUE ( 5 100 200 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_85() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION PRESENT-VALUE ( 5 100 200 300 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_86() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION PRESENT-VALUE ( 5 100 200 300 foo ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_87() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION RANDOM ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_88() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION RANDOM ( seed ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_89() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION REM ( 11 5 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_90() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION REM ( -11 5 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_91() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION REM ( 11 -5 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_92() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION REM ( -11 -5 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_93() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION REVERSE ( \"oof\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_94() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION REVERSE ( n\"rab\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_95() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION SIGN ( -5 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_96() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION SIGN ( 0 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_97() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION SIGN ( 5 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_98() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION SQRT ( 2 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_99() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION SQRT ( 2 * FUNCTION PI ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_100() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION STANDARD-DEVIATION ( 5.4 -2.1 -14.7 0.2 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_101() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION VARIANCE ( 5.4 -2.1 -14.7 0.2 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_102() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION SUM ( 5 -2 -14 0 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_103() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION LOWER-CASE ( \"FOO\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_104() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION LOWER-CASE ( n\"FOO\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_105() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION UPPER-CASE ( \"bar\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_106() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION UPPER-CASE ( n\"bar\" ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_107() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION WHEN-COMPILED ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_108() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION foo ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_109() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION foo () ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_110() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION foo ( bar ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_111() {
      Parser parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FUNCTION foo ( bar baz ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}