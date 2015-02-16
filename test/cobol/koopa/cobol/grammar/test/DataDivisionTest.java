package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parser;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from DataDivision.stage. */
public class DataDivisionTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testDataDivision_1() {
      Parser parser = grammar.dataDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DATA DIVISION .\n   WORKING-STORAGE Section .\n   COPY \"WORKSTOR.WS\" .\n"));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDivision_2() {
      Parser parser = grammar.dataDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WORKING-STORAGE Section .\n   COPY \"WORKSTOR.WS\" .\n"));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRedefines_3() {
      Parser parser = grammar.redefines();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REDEFINES TEST-1 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPicture_4() {
      Parser parser = grammar.picture();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PIC Z.ZZZ.ZZ9,99 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPicture_5() {
      Parser parser = grammar.picture();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PIC ---.---.--9 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPicture_6() {
      Parser parser = grammar.picture();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PIC 99999999.999 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPicture_7() {
      Parser parser = grammar.picture();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PIC ZZZZZ9.99999 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPicture_8() {
      Parser parser = grammar.picture();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PIC Z99.99 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlankWhenZero_9() {
      Parser parser = grammar.blankWhenZero();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLANK WHEN ZERO "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlankWhenZero_10() {
      Parser parser = grammar.blankWhenZero();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLANK WHEN ZEROS "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlankWhenZero_11() {
      Parser parser = grammar.blankWhenZero();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLANK WHEN ZEROES "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlankWhenZero_12() {
      Parser parser = grammar.blankWhenZero();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLANK ZERO "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlankWhenZero_13() {
      Parser parser = grammar.blankWhenZero();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLANK ZEROS "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlankWhenZero_14() {
      Parser parser = grammar.blankWhenZero();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLANK ZEROES "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpace_15() {
      Parser parser = grammar.space();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPACE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpace_16() {
      Parser parser = grammar.space();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPACES "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExternal_17() {
      Parser parser = grammar.external();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" EXTERNAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExternal_18() {
      Parser parser = grammar.external();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IS EXTERNAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExternal_19() {
      Parser parser = grammar.external();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IS EXTERNAL AS \"foo\" "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExternal_20() {
      Parser parser = grammar.external();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IS EXTERNAL BY \"foo\" "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExternal_21() {
      Parser parser = grammar.external();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" EXTERNAL \"foo\" "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_22() {
      Parser parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_23() {
      Parser parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY NO GET "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_24() {
      Parser parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY NO SET "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_25() {
      Parser parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY WITH NO GET "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_26() {
      Parser parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY WITH NO SET "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_27() {
      Parser parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY GET "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_28() {
      Parser parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY SET "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_29() {
      Parser parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY WITH GET "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_30() {
      Parser parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY WITH SET "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testGlobal_31() {
      Parser parser = grammar.global();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IS GLOBAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGlobal_32() {
      Parser parser = grammar.global();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GLOBAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTypedefClause_33() {
      Parser parser = grammar.typedefClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IS TYPEDEF "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTypedefClause_34() {
      Parser parser = grammar.typedefClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TYPEDEF "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testThreadLocalClause_35() {
      Parser parser = grammar.threadLocalClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IS THREAD-LOCAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testThreadLocalClause_36() {
      Parser parser = grammar.threadLocalClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" THREAD-LOCAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testJustified_37() {
      Parser parser = grammar.justified();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" JUSTIFIED RIGHT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testJustified_38() {
      Parser parser = grammar.justified();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" JUST RIGHT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_39() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_40() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_41() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42.0 TIMES "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_42() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42.0 "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_43() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   ASCENDING KEY IS MY-KEY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_44() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING KEY IS MY-KEY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_45() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   ASCENDING MY-KEY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_46() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING MY-KEY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_47() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   ASCENDING MY-KEY MY-OTHER-KEY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_48() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING MY-KEY MY-OTHER-KEY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_49() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   ASCENDING KEY IS MY-KEY MY-OTHER-KEY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_50() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING KEY IS MY-KEY MY-OTHER-KEY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_51() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   ASCENDING KEY IS MY-ASC-KEY MY-OTHER-ASC-KEY \n   DESCENDING KEY IS MY-DESC-KEY MY-OTHER-DESC-KEY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_52() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING KEY IS MY-DESC-KEY MY-OTHER-DESC-KEY\n   ASCENDING KEY IS MY-ASC-KEY MY-OTHER-ASC-KEY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_53() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES\n   INDEXED BY MY-INDEX "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_54() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES\n   INDEXED BY MY-INDEX MY-OTHER-INDEX "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_55() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING KEY IS MY-DESC-KEY MY-OTHER-DESC-KEY\n   ASCENDING MY-ASC-KEY MY-OTHER-ASC-KEY\n   INDEXED BY MY-INDEX MY-OTHER-INDEX "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_56() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 7 TO 42 TIMES "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_57() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 7 TO 42.0 TIMES "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_58() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 7.0 TO 42 TIMES "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_59() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 7.0 TO 42.0 TIMES "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_60() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 7 TO 42 TIMES DEPENDING ON MY-FIELD "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_61() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 7 TO 42 TIMES DEPENDING ON MY-FIELD OF MY-RECORD IN MY-OTHER-RECORD "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_62() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON MY-FIELD "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_63() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 7 TO 42 TIMES DEPENDING ON MY-FIELD\n   DESCENDING KEY IS MY-DESC-KEY MY-OTHER-DESC-KEY\n   ASCENDING MY-ASC-KEY MY-OTHER-ASC-KEY\n   INDEXED BY MY-INDEX MY-OTHER-INDEX "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_64() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   ASCENDING KEY IS MY-KEY OF MY-TABLE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_65() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   ASCENDING KEY IS MY-KEY IN MY-TABLE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_66() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING KEY IS MY-KEY OF MY-TABLE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_67() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING KEY IS MY-KEY IN MY-TABLE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_68() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON FUNCTION FN ( X ) "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_69() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON EXCEPTION-OBJECT "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_70() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON NULL "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_71() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON SELF "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_72() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON SUPER "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_73() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON MY-CLASS-NAME OF SUPER "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_74() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON ADDRESS OF SOMETHING "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_75() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES ASCENDING KEY IS FUNCTION FN ( X ) "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_76() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES ASCENDING KEY IS EXCEPTION-OBJECT "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_77() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES ASCENDING KEY IS NULL "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_78() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES ASCENDING KEY IS SELF "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_79() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES ASCENDING KEY IS SUPER "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_80() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES ASCENDING KEY IS MY-CLASS-NAME OF SUPER "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccurs_81() {
      Parser parser = grammar.occurs();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES ASCENDING KEY IS ADDRESS OF SOMETHING "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_82() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LEADING "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_83() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TRAILING "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_84() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LEADING SEPARATE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_85() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TRAILING SEPARATE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_86() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LEADING SEPARATE CHARACTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_87() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TRAILING SEPARATE CHARACTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_88() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN LEADING "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_89() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN TRAILING "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_90() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN IS LEADING "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_91() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN IS TRAILING "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_92() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN LEADING SEPARATE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_93() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN TRAILING SEPARATE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_94() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN IS LEADING SEPARATE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_95() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN IS TRAILING SEPARATE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_96() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN LEADING SEPARATE CHARACTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_97() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN TRAILING SEPARATE CHARACTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_98() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN IS LEADING SEPARATE CHARACTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSign_99() {
      Parser parser = grammar.sign();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN IS TRAILING SEPARATE CHARACTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSync_100() {
      Parser parser = grammar.sync();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SYNCHRONIZED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSync_101() {
      Parser parser = grammar.sync();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SYNC "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSync_102() {
      Parser parser = grammar.sync();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SYNCHRONIZED LEFT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSync_103() {
      Parser parser = grammar.sync();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SYNC LEFT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSync_104() {
      Parser parser = grammar.sync();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SYNCHRONIZED RIGHT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSync_105() {
      Parser parser = grammar.sync();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SYNC RIGHT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_106() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_107() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_108() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_109() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-CHAR "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_110() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-CHAR "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_111() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-CHAR "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_112() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-CHAR SIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_113() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-CHAR SIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_114() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-CHAR SIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_115() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-CHAR UNSIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_116() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-CHAR UNSIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_117() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-CHAR UNSIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_118() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-LONG "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_119() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-LONG "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_120() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-LONG "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_121() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-LONG SIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_122() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-LONG SIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_123() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-LONG SIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_124() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-LONG UNSIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_125() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-LONG UNSIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_126() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-LONG UNSIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_127() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-SHORT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_128() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-SHORT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_129() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-SHORT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_130() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-SHORT SIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_131() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-SHORT SIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_132() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-SHORT SIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_133() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-SHORT UNSIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_134() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-SHORT UNSIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_135() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-SHORT UNSIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_136() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-DOUBLE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_137() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-DOUBLE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_138() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-DOUBLE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_139() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-DOUBLE SIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_140() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-DOUBLE SIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_141() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-DOUBLE SIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_142() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-DOUBLE UNSIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_143() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-DOUBLE UNSIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_144() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-DOUBLE UNSIGNED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_145() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-C-LONG "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_146() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-C-LONG "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_147() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-C-LONG "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_148() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FLOAT-SHORT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_149() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE FLOAT-SHORT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_150() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS FLOAT-SHORT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_151() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FLOAT-LONG "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_152() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE FLOAT-LONG "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_153() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS FLOAT-LONG "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_154() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FLOAT-EXTENDED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_155() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE FLOAT-EXTENDED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_156() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS FLOAT-EXTENDED "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_157() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BIT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_158() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BIT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_159() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BIT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_160() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHARACTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_161() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE CHARACTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_162() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS CHARACTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_163() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTATIONAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_164() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMPUTATIONAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_165() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMPUTATIONAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_166() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMP "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_167() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMP "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_168() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMP "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_169() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DECIMAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_170() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE DECIMAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_171() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS DECIMAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_172() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_173() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE DISPLAY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_174() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS DISPLAY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_175() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INDEX "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_176() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE INDEX "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_177() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS INDEX "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_178() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PACKED-DECIMAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_179() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE PACKED-DECIMAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_180() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS PACKED-DECIMAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_181() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTATIONAL-1 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_182() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMPUTATIONAL-1 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_183() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMPUTATIONAL-1 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_184() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMP-1 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_185() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMP-1 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_186() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMP-1 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_187() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTATIONAL-2 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_188() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMPUTATIONAL-2 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_189() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMPUTATIONAL-2 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_190() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMP-2 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_191() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMP-2 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_192() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMP-2 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_193() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTATIONAL-3 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_194() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMPUTATIONAL-3 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_195() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMPUTATIONAL-3 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_196() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMP-3 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_197() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMP-3 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_198() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMP-3 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_199() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTATIONAL-5 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_200() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMPUTATIONAL-5 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_201() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMPUTATIONAL-5 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_202() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMP-5 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_203() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMP-5 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_204() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMP-5 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_205() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTATIONAL-X "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_206() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMPUTATIONAL-X "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_207() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMPUTATIONAL-X "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_208() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMP-X "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_209() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMP-X "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_210() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMP-X "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_211() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" POINTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_212() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE POINTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_213() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS POINTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_214() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MONITOR-POINTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_215() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE MONITOR-POINTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_216() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS MONITOR-POINTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_217() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MUTEX-POINTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_218() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE MUTEX-POINTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_219() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS MUTEX-POINTER "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_220() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" NATIONAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_221() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE NATIONAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_222() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS NATIONAL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_223() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("          OBJECT REFERENCE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_224() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE    OBJECT REFERENCE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_225() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS OBJECT REFERENCE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_226() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("          OBJECT REFERENCE            ACTIVE-CLASS "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_227() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE    OBJECT REFERENCE            ACTIVE-CLASS "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_228() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS OBJECT REFERENCE            ACTIVE-CLASS "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_229() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("          OBJECT REFERENCE FACTORY OF ACTIVE-CLASS "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_230() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE    OBJECT REFERENCE FACTORY OF ACTIVE-CLASS "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_231() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS OBJECT REFERENCE FACTORY OF ACTIVE-CLASS "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_232() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("          OBJECT REFERENCE            foo ONLY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_233() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE    OBJECT REFERENCE            foo ONLY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_234() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS OBJECT REFERENCE            foo ONLY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_235() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("          OBJECT REFERENCE FACTORY OF foo ONLY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_236() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE    OBJECT REFERENCE FACTORY OF foo ONLY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_237() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS OBJECT REFERENCE FACTORY OF foo ONLY "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_238() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("          OBJECT REFERENCE            foo EVENT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_239() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE    OBJECT REFERENCE            foo EVENT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_240() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS OBJECT REFERENCE            foo EVENT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_241() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("          OBJECT REFERENCE FACTORY OF foo EVENT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_242() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE    OBJECT REFERENCE FACTORY OF foo EVENT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsage_243() {
      Parser parser = grammar.usage();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS OBJECT REFERENCE FACTORY OF foo EVENT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_244() {
      Parser parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE IS ZERO "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_245() {
      Parser parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE ZERO "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_246() {
      Parser parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE IS 42 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_247() {
      Parser parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE 42 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_248() {
      Parser parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE IS 42.10 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_249() {
      Parser parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE 42.10 "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_250() {
      Parser parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE IS \"this is a constant\" "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_251() {
      Parser parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE \"this is a constant\" "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_252() {
      Parser parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUES ARE \"this is a constant\" "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_253() {
      Parser parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE IS NULL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_254() {
      Parser parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE NULL "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_255() {
      Parser parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE IS 'this is a constant' "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_256() {
      Parser parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE 'this is a constant' "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_257() {
      Parser parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE IS SOME-CONSTANT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_258() {
      Parser parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE SOME-CONSTANT "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWhenSetToFalseClause_259() {
      Parser parser = grammar.whenSetToFalseClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WHEN SET TO FALSE IS 'A' "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWhenSetToFalseClause_260() {
      Parser parser = grammar.whenSetToFalseClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WHEN SET TO FALSE 'A' "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWhenSetToFalseClause_261() {
      Parser parser = grammar.whenSetToFalseClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FALSE IS 'A' "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWhenSetToFalseClause_262() {
      Parser parser = grammar.whenSetToFalseClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FALSE 'A' "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_263() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 17 FILLER . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_264() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 17 TEST-2 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_265() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 01 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_266() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 1 TEST-3 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_267() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 11 TEST-4 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_268() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 49 TEST-5 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_269() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 77 TEST-6 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_270() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 0 TEST-7 . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_271() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 50 TEST-8 . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_272() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" AA TEST-9 . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_273() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 TEST-10\n      RENAMES TEST-1 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_274() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 TEST-11\n      RENAMES TEST-2 THROUGH TEST-3 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_275() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 TEST-12\n      RENAMES TEST-4 THRU TEST-5 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_276() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 TEST-10B\n      RENAMES TEST-1 OF TESTSUITE . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_277() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 TEST-11B\n      RENAMES TEST-2 OF TESTSUITE THROUGH TEST-3 OF TESTSUITE . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_278() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 TEST-12B\n      RENAMES TEST-4 OF TESTSUITE THRU TEST-5 OF TESTSUITE . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_279() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-13A\n    VALUE -1 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_280() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-13B\n      VALUE IS \"AAA\" . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_281() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-14\n      VALUE \"BBB\" . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_282() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-15\n      VALUES ARE \"CCC\" . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_283() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-16\n      VALUES \"DDD\" . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_284() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-17\n      VALUES ARE 0 THROUGH 10 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_285() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-18\n      VALUES ARE 0 THROUGH 10\n                 20 THROUGH 30 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_286() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-19\n      VALUES ARE 0 THROUGH 10\n                 20 THROUGH 30\n                 66 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_287() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-20\n      VALUES ARE 0 THROUGH 10\n                 15\n                 20 THROUGH 30 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_288() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-21\n      VALUE IS ZERO . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_289() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-22\n      VALUE IS 'B'\n      WHEN SET TO FALSE IS 'A' . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_290() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-23\n      VALUE IS 'B'\n      WHEN SET TO FALSE 'A' . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_291() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-24\n      VALUE IS 'B'\n      FALSE IS 'A' . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_292() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-25\n      VALUE IS 'B'\n      FALSE 'A' . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_293() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 foo VALUE DFHVALUE ( AAAA )\n                DFHVALUE ( BBBB ) . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_294() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 foo VALUE DFHRESP  ( CCCC ) . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_295() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 BUFFER\n      POINTER\n      VALUE NULL . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_296() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo ANY LENGTH . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_297() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo ANY LENGTH . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_298() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo ANY LENGTH\n   BLANK WHEN ZERO . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_299() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo IS EXTERNAL AS \"bar\" . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_300() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PUBLIC . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_301() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo INTERNAL . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_302() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PRIVATE . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_303() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PROTECTED . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_304() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo ATTRIBUTE bar ( n ) . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_305() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PUBLIC\n   ATTRIBUTE bar ( NAME n = v ) . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_306() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PRIVATE\n   CUSTOM-ATTRIBUTE bar . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_307() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PROTECTED\n   CUSTOM-ATTRIBUTE bar ( n = v ) . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_308() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo IS TYPEDEF . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_309() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo IS THREAD-LOCAL . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_310() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PROPERTY . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_311() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PROPERTY WITH NO SET . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_312() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 77 OPTIONS PIC S9(9) BINARY . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_313() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 lines-to-display . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_314() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 lines-to-display value is 12 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_315() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 lines-to-display value 12 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_316() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE NEXT . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_317() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE NEXT + 1 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_318() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE START bar . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_319() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE START OF bar . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_320() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foobar VALUE START OF foo + LENGTH OF bar . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_321() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE LENGTH bar . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_322() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE LENGTH OF bar . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_323() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foobar VALUE \"foo\" & bar . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_324() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE 4 * 2 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_325() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE bar ** 2 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_326() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE 4 * bar . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_327() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 01 based-var PIC X(80) BASED . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_328() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FUNCTION FN ( X ) . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_329() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FOO\n      THROUGH FUNCTION FN ( X ) . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_330() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES EXCEPTION-OBJECT . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_331() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FOO\n      THROUGH EXCEPTION-OBJECT . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_332() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES NULL . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_333() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FOO\n      THROUGH NULL . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_334() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES SELF . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_335() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FOO\n      THROUGH SELF . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_336() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES SUPER . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_337() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FOO\n      THROUGH SUPER . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_338() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES MY-CLASS-NAME OF SUPER . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_339() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FOO\n      THROUGH MY-CLASS-NAME OF SUPER . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_340() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES ADDRESS OF SOMETHING . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_341() {
      Parser parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FOO\n      THROUGH ADDRESS OF SOMETHING . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testLocalStorageSection_342() {
      Parser parser = grammar.localStorageSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LOCAL-STORAGE Section .\n   COPY \"LOCLSTOR.LS\" . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLocalStorageSection_343() {
      Parser parser = grammar.localStorageSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LOCAL-STORAGE SECTION .\n   77 OPTIONS PIC S9(9) BINARY . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWorkingStorageSection_344() {
      Parser parser = grammar.workingStorageSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WORKING-STORAGE Section .\n   COPY \"WORKSTOR.WS\" .\n"));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testThreadLocalStorageSection_345() {
      Parser parser = grammar.threadLocalStorageSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" THREAD-LOCAL-STORAGE Section .\n   COPY \"THRDSTOR.LS\" . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testThreadLocalStorageSection_346() {
      Parser parser = grammar.threadLocalStorageSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" THREAD-LOCAL-STORAGE SECTION .\n   77 OPTIONS PIC S9(9) BINARY . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObjectStorageSection_347() {
      Parser parser = grammar.objectStorageSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OBJECT-STORAGE Section .\n   COPY \"OBJSTOR.OS\" . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObjectStorageSection_348() {
      Parser parser = grammar.objectStorageSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OBJECT-STORAGE SECTION .\n   77 OPTIONS PIC S9(9) BINARY . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_349() {
      Parser parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_350() {
      Parser parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  CM-INQUE-1 FOR INPUT . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_351() {
      Parser parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  CM-INQUE-1 FOR INITIAL INPUT . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_352() {
      Parser parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  COMMNAME FOR INITIAL INPUT\n       SYMBOLIC SUB-QUEUE-1 IS CQ . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_353() {
      Parser parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  CM-INQUE-1 FOR INPUT\n       SYMBOLIC QUEUE IS MAIN-QUEUE\n       SYMBOLIC SUB-QUEUE-1 IS NO-SPEC-1\n       SYMBOLIC SUB-QUEUE-2 IS NO-SPEC-2\n       SYMBOLIC SUB-QUEUE-3 IS NO-SPEC-3\n       MESSAGE DATE IS DATE-RECEIVED\n       MESSAGE TIME IS TIME-RECEIVED\n       SYMBOLIC SOURCE IS WHERE-FROM\n       TEXT LENGTH IS MSG-LENGTH\n       END KEY IS END-KEY\n       STATUS KEY IS STATUS-KEY\n       MESSAGE COUNT IS MSG-COUNT . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_354() {
      Parser parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  CM-INQUE-1 FOR INPUT\n       MAIN-QUEUE NO-SPEC-1 NO-SPEC-2 NO-SPEC-3 FILLER\n       TIME-RECEIVED FILLER IN-LENGTH END-KEY IN-STATUS\n       FILLER . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_355() {
      Parser parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  CM-OUTQUE-1 FOR OUTPUT\n       DESTINATION COUNT IS ONE\n       TEXT LENGTH IS MSG-LENGTH\n       STATUS KEY IS STATUS-KEY\n       ERROR KEY IS ERR-KEY\n       SYMBOLIC DESTINATION IS SYM-DEST . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_356() {
      Parser parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  COMM2 FOR OUTPUT\n       DESTINATION TABLE OCCURS 7 TIMES . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_357() {
      Parser parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  COMMNAME FOR INITIAL INPUT\n       SYMBOLIC SUB-QUEUE-1 IS CQ .\n   01  CREC .\n       03  CNAME1 PIC X(8) .\n       03  CQ     PIC 9(8) .\n       03  FILLER PIC X(62) .\n       03  CINT   PIC 9 .\n       03  FILLER PIC X(8) .\n   CD  COMM2 FOR OUTPUT\n       DESTINATION TABLE OCCURS 7 TIMES . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReportSection_358() {
      Parser parser = grammar.reportSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPORT SECTION . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReportSection_359() {
      Parser parser = grammar.reportSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPORT SECTION .\n   RD  RW-FS2-REPORT-1\n       PAGE LIMIT 20\n       FIRST DETAIL 1\n       LAST DETAIL 20 .\n       01  RW-FS2-GROUP\n           LINE NUMBER IS PLUS 1\n           TYPE IS DETAIL . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReportSection_360() {
      Parser parser = grammar.reportSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPORT SECTION .\n   RD  RW-FS1-REPORT-1\n       PAGE LIMIT IS 20 LINES .\n   01  RW-FS1-GROUP\n       TYPE IS DETAIL .\n       03  RW-FS1-ELEM\n           LINE NUMBER IS PLUS 1\n           COLUMN NUMBER IS 5\n           PICTURE X(76)\n           SOURCE IS REPORT-LINE-IMAGE . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReportSection_361() {
      Parser parser = grammar.reportSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPORT SECTION .\n   RD  RW-FS3-REPORT-1\n       PAGE 30\n       HEADING 1\n       FIRST DETAIL 6\n       LAST DETAIL 20 . "));
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testReportSection_362() {
      Parser parser = grammar.reportSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPORT SECTION .\n   RD  RFIL2 .\n       01  RREC\n           TYPE IS DETAIL .\n           02  PIC 9(8)\n               SOURCE IS RKEY\n               COLUMN NUMBER IS 1\n               LINE NUMBER IS PLUS 1 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}