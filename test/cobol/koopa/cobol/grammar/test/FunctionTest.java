package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from Function.stage. */
public class FunctionTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testIdentifier_format1_1() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION ACOS ( IND ( 5 ) / 9 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_2() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION ASIN ( A / 9 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_3() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION ATAN ( A * 0.45 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_4() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION COS ( B ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_5() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION SIN ( 90 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_6() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION TAN ( FUNCTION ATAN ( X + Y ) ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_7() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION BOOLEAN-OF-INTEGER ( 10 2 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_8() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION DATE-OF-INTEGER ( 365 * Y ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_9() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION DATE-TO-YYYYMMDD ( 1000000 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_10() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION DATE-TO-YYYYMMDD ( 851003 50 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_11() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION DATE-TO-YYYYMMDD ( FUNCTION DATE-OF-INTEGER ( 365 * Y ), (-10) ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_12() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION DAY-OF-INTEGER ( 365 * Y ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_13() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION DAY-TO-YYYYMMDD ( 1000000 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_14() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION DAY-TO-YYYYMMDD ( 1000000 50 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_15() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION DAY-TO-YYYYMMDD ( FUNCTION DAY-OF-INTEGER ( 365 * Y ), (-10) ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_16() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION INTEGER-OF-BOOLEAN ( FUNCTION BOOLEAN-OF-INTEGER ( 10 2 ) ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_17() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION INTEGER-OF-DATE ( 20130815 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_18() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION INTEGER-OF-DAY ( YYYY * 1000 + DDD ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_19() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION YEAR-TO-YYYY ( 13 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_20() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION YEAR-TO-YYYY ( 95 50 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_21() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION ABS ( 1 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_22() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION ABS ( -1 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_23() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION ANNUITY ( B / 2  8 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_24() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION CHAR ( 10 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_25() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION CHAR-NATIONAL ( 10 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_26() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION CURRENT-DATE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_27() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION DISPLAY-OF ( n\"foo\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_28() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION DISPLAY-OF ( n\"bar\" \"?\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_29() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION DISPLAY-OF ( n\"baz\" 1208 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_30() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION NATIONAL-OF ( \"foo\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_31() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION NATIONAL-OF ( \"bar\" n\"?\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_32() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION NATIONAL-OF ( \"baz\" 1208 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_33() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION E "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_34() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION EXP ( P / 2 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_35() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION EXP10 ( 9.04 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_36() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION FACTORIAL ( 5 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_37() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION FRACTION-PART ( FUNCTION PI ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_38() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION FRACTION-PART ( 19 / 7 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_39() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION FRACTION-PART ( 1.5 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_40() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION INTEGER-PART ( FUNCTION PI ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_41() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION INTEGER-PART ( 19 / 7 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_42() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION INTEGER-PART ( 1.5 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_43() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION INTEGER ( FUNCTION PI ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_44() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION INTEGER ( 19 / 7 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_45() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION INTEGER ( 1.5 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_46() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION LENGTH ( \"A\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_47() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION LENGTH ( n\"AB\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_48() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION LENGTH-AN ( \"ABC\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_49() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION LOG ( FUNCTION E ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_50() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION LOG10 ( 10 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_51() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION MAX ( A * B  ( C + 1 ) / 2  3 + 4 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_52() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION MAX ( \"A\" \"B\" \"C\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_53() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION MEAN ( A * B  ( C + 1 ) / 2  3 + 4 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_54() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION MEDIAN ( A * B  ( C + 1 ) / 2  3 + 4 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_55() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION MIDRANGE ( A * B  ( C + 1 ) / 2  3 + 4 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_56() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION MIN ( A * B  ( C + 1 ) / 2  3 + 4 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_57() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION MIN ( \"A\" \"B\" \"C\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_58() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION RANGE ( A * B  ( C + 1 ) / 2  3 + 4 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_59() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION MOD ( 11 5 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_60() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION MOD ( -11 5 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_61() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION MOD ( 11 -5 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_62() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION MOD ( -11 -5 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_63() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION NUMVAL ( foo ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_64() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION NUMVAL ( \"  2  \" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_65() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION NUMVAL ( \"-2.5\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_66() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION NUMVAL ( n\"3.14\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_67() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION NUMVAL ( \"3,14\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_68() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION NUMVAL-C ( foo ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_69() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION NUMVAL-C ( \"  2  \" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_70() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION NUMVAL-C ( \"-2.5\" \"$\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_71() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION NUMVAL-C ( n\"3,14\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_72() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION NUMVAL-C ( \"3.14\" \"£\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_73() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION ORD ( char ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_74() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION ORD ( \"A\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_75() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION ORD ( n\"A\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_76() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION ORD-MAX ( char-1 char-2 char-3 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_77() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION ORD-MAX ( \"A\" \"B\" \"C\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_78() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION ORD-MAX ( n\"A\" n\"B\" n\"C\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_79() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION ORD-MIN ( char-1 char-2 char-3 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_80() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION ORD-MIN ( \"A\" \"B\" \"C\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_81() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION ORD-MIN ( n\"A\" n\"B\" n\"C\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_82() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION PI "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_83() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION PRESENT-VALUE ( 5 100 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_84() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION PRESENT-VALUE ( 5 100 200 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_85() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION PRESENT-VALUE ( 5 100 200 300 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_86() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION PRESENT-VALUE ( 5 100 200 300 foo ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_87() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION RANDOM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_88() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION RANDOM ( seed ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_89() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION REM ( 11 5 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_90() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION REM ( -11 5 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_91() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION REM ( 11 -5 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_92() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION REM ( -11 -5 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_93() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION REVERSE ( \"oof\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_94() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION REVERSE ( n\"rab\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_95() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION SIGN ( -5 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_96() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION SIGN ( 0 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_97() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION SIGN ( 5 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_98() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION SQRT ( 2 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_99() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION SQRT ( 2 * FUNCTION PI ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_100() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION STANDARD-DEVIATION ( 5.4 -2.1 -14.7 0.2 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_101() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION VARIANCE ( 5.4 -2.1 -14.7 0.2 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_102() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION SUM ( 5 -2 -14 0 ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_103() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION LOWER-CASE ( \"FOO\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_104() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION LOWER-CASE ( n\"FOO\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_105() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION UPPER-CASE ( \"bar\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_106() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION UPPER-CASE ( n\"bar\" ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_107() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION WHEN-COMPILED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_108() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_109() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION foo () "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_110() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION foo ( bar ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIdentifier_format1_111() {
      ParserCombinator parser = grammar.identifier_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION foo ( bar baz ) "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}