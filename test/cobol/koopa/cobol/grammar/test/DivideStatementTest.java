package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from DivideStatement.stage. */
public class DivideStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testDivision_format1_1() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING C REMAINDER D "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_2() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING C ROUNDED REMAINDER D "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_3() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A BY B GIVING C REMAINDER D "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_4() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A BY B GIVING C ROUNDED REMAINDER D "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_5() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO INTO 2 GIVING C REMAINDER D "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_6() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO INTO 2 GIVING C ROUNDED REMAINDER D "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_7() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO BY 2 GIVING C REMAINDER D "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_8() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO BY 2 GIVING C ROUNDED REMAINDER D "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_9() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING FUNCTION FN ( X ) REMAINDER D "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_10() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING C REMAINDER FUNCTION FN ( X ) "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_11() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING EXCEPTION-OBJECT REMAINDER D "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_12() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING C REMAINDER EXCEPTION-OBJECT "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_13() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING NULL REMAINDER D "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_14() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING C REMAINDER NULL "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_15() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING SELF REMAINDER D "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_16() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING C REMAINDER SELF "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_17() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING SUPER REMAINDER D "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_18() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING C REMAINDER SUPER "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_19() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING MY-CLASS-NAME OF SUPER REMAINDER D "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_20() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING C REMAINDER MY-CLASS-NAME OF SUPER "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_21() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING ADDRESS OF SOMETHING REMAINDER D "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format1_22() {
      ParserCombinator parser = grammar.division_format1();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING C REMAINDER ADDRESS OF SOMETHING "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_23() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING C "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_24() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING C D "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_25() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A BY B GIVING C "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_26() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A BY B GIVING C D "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_27() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING C ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_28() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING C ROUNDED D ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_29() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A BY B GIVING C ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_30() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A BY B GIVING C ROUNDED D ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_31() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO INTO 2 GIVING C "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_32() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO INTO 2 GIVING C D "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_33() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO BY 2 GIVING C "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_34() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO BY 2 GIVING C D "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_35() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO INTO 2 GIVING C ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_36() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO INTO 2 GIVING C ROUNDED D ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_37() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO BY 2 GIVING C ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_38() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO BY 2 GIVING C ROUNDED D ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_39() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING FUNCTION FN ( X ) "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_40() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING EXCEPTION-OBJECT "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_41() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING NULL "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_42() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING SELF "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_43() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING SUPER "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_44() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING MY-CLASS-NAME OF SUPER "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format2_45() {
      ParserCombinator parser = grammar.division_format2();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B GIVING ADDRESS OF SOMETHING "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format3_46() {
      ParserCombinator parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format3_47() {
      ParserCombinator parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B C "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format3_48() {
      ParserCombinator parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format3_49() {
      ParserCombinator parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO B ROUNDED C ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format3_50() {
      ParserCombinator parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO INTO B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format3_51() {
      ParserCombinator parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO INTO B C "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format3_52() {
      ParserCombinator parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO INTO B ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format3_53() {
      ParserCombinator parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ZERO INTO B ROUNDED C ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format3_54() {
      ParserCombinator parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO FUNCTION FN ( X ) "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format3_55() {
      ParserCombinator parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO EXCEPTION-OBJECT "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format3_56() {
      ParserCombinator parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO NULL "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format3_57() {
      ParserCombinator parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO SELF "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format3_58() {
      ParserCombinator parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO SUPER "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format3_59() {
      ParserCombinator parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO MY-CLASS-NAME OF SUPER "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivision_format3_60() {
      ParserCombinator parser = grammar.division_format3();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" A INTO ADDRESS OF SOMETHING "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_61() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_62() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B GIVING C # . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_63() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B\n     ON SIZE ERROR\n        DISPLAY \"OOPS\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_64() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B GIVING C\n     ON SIZE ERROR\n        DISPLAY \"OOPS\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_65() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B\n     SIZE ERROR\n        DISPLAY \"OOPS\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_66() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B GIVING C\n     SIZE ERROR\n        DISPLAY \"OOPS\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_67() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_68() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B GIVING C\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_69() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B\n     NOT SIZE ERROR\n        DISPLAY \"AOK\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_70() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B GIVING C\n     NOT SIZE ERROR\n        DISPLAY \"AOK\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_71() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_72() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B GIVING C\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_73() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\"\n   END-DIVIDE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_74() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B GIVING C\n     ON SIZE ERROR\n        DISPLAY \"OOPS\"\n     NOT ON SIZE ERROR\n        DISPLAY \"AOK\"\n   END-DIVIDE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_75() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B\n   END-DIVIDE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_76() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B GIVING C\n   END-DIVIDE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDivideStatement_77() {
      ParserCombinator parser = grammar.divideStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DIVIDE A INTO B GIVING TALLY\n   END-DIVIDE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}