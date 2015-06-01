package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
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
      ParserCombinator parser = grammar.dataDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DATA DIVISION .\n   WORKING-STORAGE Section .\n   COPY \"WORKSTOR.WS\" .\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDivision_2() {
      ParserCombinator parser = grammar.dataDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WORKING-STORAGE Section .\n   COPY \"WORKSTOR.WS\" .\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRedefinesClause_3() {
      ParserCombinator parser = grammar.redefinesClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REDEFINES TEST-1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPictureClause_4() {
      ParserCombinator parser = grammar.pictureClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PIC Z.ZZZ.ZZ9,99 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPictureClause_5() {
      ParserCombinator parser = grammar.pictureClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PIC ---.---.--9 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPictureClause_6() {
      ParserCombinator parser = grammar.pictureClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PIC 99999999.999 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPictureClause_7() {
      ParserCombinator parser = grammar.pictureClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PIC ZZZZZ9.99999 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPictureClause_8() {
      ParserCombinator parser = grammar.pictureClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PIC Z99.99 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlankWhenZeroClause_9() {
      ParserCombinator parser = grammar.blankWhenZeroClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLANK WHEN ZERO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlankWhenZeroClause_10() {
      ParserCombinator parser = grammar.blankWhenZeroClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLANK WHEN ZEROS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlankWhenZeroClause_11() {
      ParserCombinator parser = grammar.blankWhenZeroClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLANK WHEN ZEROES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlankWhenZeroClause_12() {
      ParserCombinator parser = grammar.blankWhenZeroClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLANK ZERO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlankWhenZeroClause_13() {
      ParserCombinator parser = grammar.blankWhenZeroClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLANK ZEROS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlankWhenZeroClause_14() {
      ParserCombinator parser = grammar.blankWhenZeroClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLANK ZEROES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpace_15() {
      ParserCombinator parser = grammar.space();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPACE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSpace_16() {
      ParserCombinator parser = grammar.space();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SPACES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExternalClause_17() {
      ParserCombinator parser = grammar.externalClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" EXTERNAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExternalClause_18() {
      ParserCombinator parser = grammar.externalClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IS EXTERNAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExternalClause_19() {
      ParserCombinator parser = grammar.externalClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IS EXTERNAL AS \"foo\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExternalClause_20() {
      ParserCombinator parser = grammar.externalClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IS EXTERNAL BY \"foo\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testExternalClause_21() {
      ParserCombinator parser = grammar.externalClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" EXTERNAL \"foo\" "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_22() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_23() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY NO GET "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_24() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY NO SET "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_25() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY WITH NO GET "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_26() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY WITH NO SET "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_27() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY IS FINAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_28() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY NO GET IS FINAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_29() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY NO SET IS FINAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_30() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY WITH NO GET IS FINAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_31() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY WITH NO SET IS FINAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_32() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY FINAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_33() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY NO GET FINAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_34() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY NO SET FINAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_35() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY WITH NO GET FINAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_36() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY WITH NO SET FINAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_37() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY GET "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_38() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY SET "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_39() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY WITH GET "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testPropertyClause_40() {
      ParserCombinator parser = grammar.propertyClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROPERTY WITH SET "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testGlobalClause_41() {
      ParserCombinator parser = grammar.globalClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IS GLOBAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGlobalClause_42() {
      ParserCombinator parser = grammar.globalClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GLOBAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTypedefClause_43() {
      ParserCombinator parser = grammar.typedefClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IS TYPEDEF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTypedefClause_44() {
      ParserCombinator parser = grammar.typedefClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TYPEDEF "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTypedefClause_45() {
      ParserCombinator parser = grammar.typedefClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IS TYPEDEF STRONG "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTypedefClause_46() {
      ParserCombinator parser = grammar.typedefClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TYPEDEF STRONG "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testThreadLocalClause_47() {
      ParserCombinator parser = grammar.threadLocalClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" IS THREAD-LOCAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testThreadLocalClause_48() {
      ParserCombinator parser = grammar.threadLocalClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" THREAD-LOCAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testJustified_49() {
      ParserCombinator parser = grammar.justified();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" JUSTIFIED RIGHT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testJustified_50() {
      ParserCombinator parser = grammar.justified();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" JUST RIGHT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_51() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_52() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_53() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42.0 TIMES "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_54() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42.0 "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_55() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   ASCENDING KEY IS MY-KEY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_56() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING KEY IS MY-KEY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_57() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   ASCENDING MY-KEY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_58() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING MY-KEY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_59() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   ASCENDING MY-KEY MY-OTHER-KEY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_60() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING MY-KEY MY-OTHER-KEY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_61() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   ASCENDING KEY IS MY-KEY MY-OTHER-KEY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_62() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING KEY IS MY-KEY MY-OTHER-KEY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_63() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   ASCENDING KEY IS MY-ASC-KEY MY-OTHER-ASC-KEY \n   DESCENDING KEY IS MY-DESC-KEY MY-OTHER-DESC-KEY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_64() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING KEY IS MY-DESC-KEY MY-OTHER-DESC-KEY\n   ASCENDING KEY IS MY-ASC-KEY MY-OTHER-ASC-KEY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_65() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES\n   INDEXED BY MY-INDEX "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_66() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES\n   INDEXED BY MY-INDEX MY-OTHER-INDEX "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_67() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING KEY IS MY-DESC-KEY MY-OTHER-DESC-KEY\n   ASCENDING MY-ASC-KEY MY-OTHER-ASC-KEY\n   INDEXED BY MY-INDEX MY-OTHER-INDEX "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_68() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 7 TO 42 TIMES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_69() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 7 TO 42.0 TIMES "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_70() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 7.0 TO 42 TIMES "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_71() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 7.0 TO 42.0 TIMES "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_72() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 7 TO 42 TIMES DEPENDING ON MY-FIELD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_73() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 7 TO 42 TIMES DEPENDING ON MY-FIELD OF MY-RECORD IN MY-OTHER-RECORD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_74() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON MY-FIELD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_75() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 7 TO 42 TIMES DEPENDING ON MY-FIELD\n   DESCENDING KEY IS MY-DESC-KEY MY-OTHER-DESC-KEY\n   ASCENDING MY-ASC-KEY MY-OTHER-ASC-KEY\n   INDEXED BY MY-INDEX MY-OTHER-INDEX "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_76() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS DYNAMIC\n   CAPACITY IN MY-CAPACITY\n   FROM 7 TO 42\n   INITIALIZED\n   DESCENDING KEY IS MY-DESC-KEY MY-OTHER-DESC-KEY\n   ASCENDING MY-ASC-KEY MY-OTHER-ASC-KEY\n   INDEXED BY MY-INDEX MY-OTHER-INDEX "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_77() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   ASCENDING KEY IS MY-KEY OF MY-TABLE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_78() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   ASCENDING KEY IS MY-KEY IN MY-TABLE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_79() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING KEY IS MY-KEY OF MY-TABLE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_80() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES \n   DESCENDING KEY IS MY-KEY IN MY-TABLE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_81() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON FUNCTION FN ( X ) "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_82() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON EXCEPTION-OBJECT "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_83() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON NULL "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_84() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON SELF "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_85() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON SUPER "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_86() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON MY-CLASS-NAME OF SUPER "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_87() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES DEPENDING ON ADDRESS OF SOMETHING "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_88() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES ASCENDING KEY IS FUNCTION FN ( X ) "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_89() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES ASCENDING KEY IS EXCEPTION-OBJECT "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_90() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES ASCENDING KEY IS NULL "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_91() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES ASCENDING KEY IS SELF "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_92() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES ASCENDING KEY IS SUPER "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_93() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES ASCENDING KEY IS MY-CLASS-NAME OF SUPER "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testOccursClause_94() {
      ParserCombinator parser = grammar.occursClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OCCURS 42 TIMES ASCENDING KEY IS ADDRESS OF SOMETHING "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_95() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LEADING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_96() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TRAILING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_97() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LEADING SEPARATE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_98() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TRAILING SEPARATE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_99() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LEADING SEPARATE CHARACTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_100() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TRAILING SEPARATE CHARACTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_101() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN LEADING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_102() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN TRAILING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_103() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN IS LEADING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_104() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN IS TRAILING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_105() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN LEADING SEPARATE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_106() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN TRAILING SEPARATE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_107() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN IS LEADING SEPARATE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_108() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN IS TRAILING SEPARATE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_109() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN LEADING SEPARATE CHARACTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_110() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN TRAILING SEPARATE CHARACTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_111() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN IS LEADING SEPARATE CHARACTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSignClause_112() {
      ParserCombinator parser = grammar.signClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SIGN IS TRAILING SEPARATE CHARACTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSynchronizedClause_113() {
      ParserCombinator parser = grammar.synchronizedClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SYNCHRONIZED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSynchronizedClause_114() {
      ParserCombinator parser = grammar.synchronizedClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SYNC "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSynchronizedClause_115() {
      ParserCombinator parser = grammar.synchronizedClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SYNCHRONIZED LEFT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSynchronizedClause_116() {
      ParserCombinator parser = grammar.synchronizedClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SYNC LEFT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSynchronizedClause_117() {
      ParserCombinator parser = grammar.synchronizedClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SYNCHRONIZED RIGHT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSynchronizedClause_118() {
      ParserCombinator parser = grammar.synchronizedClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SYNC RIGHT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_119() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_120() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_121() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_122() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-CHAR "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_123() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-CHAR "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_124() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-CHAR "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_125() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-CHAR SIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_126() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-CHAR SIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_127() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-CHAR SIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_128() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-CHAR UNSIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_129() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-CHAR UNSIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_130() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-CHAR UNSIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_131() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-LONG "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_132() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-LONG "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_133() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-LONG "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_134() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-LONG SIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_135() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-LONG SIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_136() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-LONG SIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_137() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-LONG UNSIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_138() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-LONG UNSIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_139() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-LONG UNSIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_140() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-SHORT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_141() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-SHORT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_142() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-SHORT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_143() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-SHORT SIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_144() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-SHORT SIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_145() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-SHORT SIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_146() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-SHORT UNSIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_147() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-SHORT UNSIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_148() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-SHORT UNSIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_149() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-DOUBLE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_150() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-DOUBLE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_151() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-DOUBLE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_152() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-DOUBLE SIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_153() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-DOUBLE SIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_154() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-DOUBLE SIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_155() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-DOUBLE UNSIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_156() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-DOUBLE UNSIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_157() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-DOUBLE UNSIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_158() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BINARY-C-LONG "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_159() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BINARY-C-LONG "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_160() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BINARY-C-LONG "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_161() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FLOAT-SHORT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_162() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE FLOAT-SHORT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_163() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS FLOAT-SHORT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_164() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FLOAT-LONG "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_165() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE FLOAT-LONG "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_166() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS FLOAT-LONG "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_167() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FLOAT-EXTENDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_168() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE FLOAT-EXTENDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_169() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS FLOAT-EXTENDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_170() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BIT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_171() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE BIT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_172() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS BIT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_173() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHARACTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_174() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE CHARACTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_175() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS CHARACTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_176() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTATIONAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_177() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMPUTATIONAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_178() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMPUTATIONAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_179() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMP "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_180() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMP "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_181() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMP "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_182() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DECIMAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_183() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE DECIMAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_184() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS DECIMAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_185() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_186() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE DISPLAY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_187() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS DISPLAY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_188() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INDEX "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_189() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE INDEX "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_190() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS INDEX "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_191() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PACKED-DECIMAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_192() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE PACKED-DECIMAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_193() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS PACKED-DECIMAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_194() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTATIONAL-1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_195() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMPUTATIONAL-1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_196() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMPUTATIONAL-1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_197() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMP-1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_198() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMP-1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_199() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMP-1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_200() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTATIONAL-2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_201() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMPUTATIONAL-2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_202() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMPUTATIONAL-2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_203() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMP-2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_204() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMP-2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_205() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMP-2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_206() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTATIONAL-3 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_207() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMPUTATIONAL-3 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_208() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMPUTATIONAL-3 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_209() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMP-3 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_210() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMP-3 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_211() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMP-3 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_212() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTATIONAL-5 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_213() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMPUTATIONAL-5 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_214() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMPUTATIONAL-5 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_215() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMP-5 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_216() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMP-5 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_217() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMP-5 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_218() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMPUTATIONAL-X "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_219() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMPUTATIONAL-X "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_220() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMPUTATIONAL-X "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_221() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMP-X "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_222() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE COMP-X "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_223() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS COMP-X "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_224() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" POINTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_225() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE POINTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_226() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS POINTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_227() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MONITOR-POINTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_228() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE MONITOR-POINTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_229() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS MONITOR-POINTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_230() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" MUTEX-POINTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_231() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE MUTEX-POINTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_232() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS MUTEX-POINTER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_233() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" NATIONAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_234() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE NATIONAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_235() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS NATIONAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_236() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("          OBJECT REFERENCE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_237() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE    OBJECT REFERENCE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_238() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS OBJECT REFERENCE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_239() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("          OBJECT REFERENCE            ACTIVE-CLASS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_240() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE    OBJECT REFERENCE            ACTIVE-CLASS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_241() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS OBJECT REFERENCE            ACTIVE-CLASS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_242() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("          OBJECT REFERENCE FACTORY OF ACTIVE-CLASS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_243() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE    OBJECT REFERENCE FACTORY OF ACTIVE-CLASS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_244() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS OBJECT REFERENCE FACTORY OF ACTIVE-CLASS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_245() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("          OBJECT REFERENCE            foo ONLY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_246() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE    OBJECT REFERENCE            foo ONLY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_247() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS OBJECT REFERENCE            foo ONLY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_248() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("          OBJECT REFERENCE FACTORY OF foo ONLY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_249() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE    OBJECT REFERENCE FACTORY OF foo ONLY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_250() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS OBJECT REFERENCE FACTORY OF foo ONLY "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_251() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("          OBJECT REFERENCE            foo EVENT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_252() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE    OBJECT REFERENCE            foo EVENT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_253() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS OBJECT REFERENCE            foo EVENT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_254() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer("          OBJECT REFERENCE FACTORY OF foo EVENT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_255() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE    OBJECT REFERENCE FACTORY OF foo EVENT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsageClause_256() {
      ParserCombinator parser = grammar.usageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USAGE IS OBJECT REFERENCE FACTORY OF foo EVENT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_257() {
      ParserCombinator parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE IS ZERO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_258() {
      ParserCombinator parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE ZERO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_259() {
      ParserCombinator parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE IS 42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_260() {
      ParserCombinator parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE 42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_261() {
      ParserCombinator parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE IS 42.10 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_262() {
      ParserCombinator parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE 42.10 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_263() {
      ParserCombinator parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE IS \"this is a constant\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_264() {
      ParserCombinator parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE \"this is a constant\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_265() {
      ParserCombinator parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUES ARE \"this is a constant\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_266() {
      ParserCombinator parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE IS NULL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_267() {
      ParserCombinator parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE NULL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_268() {
      ParserCombinator parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE IS 'this is a constant' "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_269() {
      ParserCombinator parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE 'this is a constant' "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_270() {
      ParserCombinator parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE IS SOME-CONSTANT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueClause_271() {
      ParserCombinator parser = grammar.valueClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE SOME-CONSTANT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWhenSetToFalseClause_272() {
      ParserCombinator parser = grammar.whenSetToFalseClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WHEN SET TO FALSE IS 'A' "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWhenSetToFalseClause_273() {
      ParserCombinator parser = grammar.whenSetToFalseClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WHEN SET TO FALSE 'A' "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWhenSetToFalseClause_274() {
      ParserCombinator parser = grammar.whenSetToFalseClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FALSE IS 'A' "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWhenSetToFalseClause_275() {
      ParserCombinator parser = grammar.whenSetToFalseClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FALSE 'A' "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_276() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 17 FILLER . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_277() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 17 TEST-2 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_278() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 01 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_279() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 1 TEST-3 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_280() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 11 TEST-4 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_281() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 49 TEST-5 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_282() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 77 TEST-6 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_283() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 0 TEST-7 . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_284() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 50 TEST-8 . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_285() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" AA TEST-9 . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_286() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FUBAR RENAMES OOPS THROUGH SNAFU . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_287() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-13A\n    VALUE -1 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_288() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-13B\n      VALUE IS \"AAA\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_289() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-14\n      VALUE \"BBB\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_290() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-15\n      VALUES ARE \"CCC\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_291() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-16\n      VALUES \"DDD\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_292() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-17\n      VALUES ARE 0 THROUGH 10 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_293() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-18\n      VALUES ARE 0 THROUGH 10\n                 20 THROUGH 30 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_294() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-19\n      VALUES ARE 0 THROUGH 10\n                 20 THROUGH 30\n                 66 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_295() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-20\n      VALUES ARE 0 THROUGH 10\n                 15\n                 20 THROUGH 30 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_296() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-21\n      VALUE IS ZERO . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_297() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-22\n      VALUE IS 'B'\n      WHEN SET TO FALSE IS 'A' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_298() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-23\n      VALUE IS 'B'\n      WHEN SET TO FALSE 'A' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_299() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-24\n      VALUE IS 'B'\n      FALSE IS 'A' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_300() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 TEST-25\n      VALUE IS 'B'\n      FALSE 'A' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_301() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 foo VALUE DFHVALUE ( AAAA )\n                DFHVALUE ( BBBB ) . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_302() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 88 foo VALUE DFHRESP  ( CCCC ) . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_303() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 BUFFER\n      POINTER\n      VALUE NULL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_304() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo ANY LENGTH . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_305() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo ANY LENGTH . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_306() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo ANY LENGTH\n   BLANK WHEN ZERO . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_307() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo IS EXTERNAL AS \"bar\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_308() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PUBLIC . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_309() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo INTERNAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_310() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PRIVATE . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_311() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PROTECTED . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_312() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo ATTRIBUTE bar ( n ) . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_313() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PUBLIC\n   ATTRIBUTE bar ( NAME n = v ) . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_314() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PRIVATE\n   CUSTOM-ATTRIBUTE bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_315() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PROTECTED\n   CUSTOM-ATTRIBUTE bar ( n = v ) . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_316() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo IS TYPEDEF . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_317() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo IS THREAD-LOCAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_318() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PROPERTY . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_319() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 05 foo PROPERTY WITH NO SET . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_320() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 77 OPTIONS PIC S9(9) BINARY . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_321() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 01 based-var PIC X(80) BASED . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_322() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FUNCTION FN ( X ) . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_323() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FOO\n      THROUGH FUNCTION FN ( X ) . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_324() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES EXCEPTION-OBJECT . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_325() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FOO\n      THROUGH EXCEPTION-OBJECT . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_326() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES NULL . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_327() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FOO\n      THROUGH NULL . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_328() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES SELF . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_329() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FOO\n      THROUGH SELF . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_330() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES SUPER . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_331() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FOO\n      THROUGH SUPER . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_332() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES MY-CLASS-NAME OF SUPER . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_333() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FOO\n      THROUGH MY-CLASS-NAME OF SUPER . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_334() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES ADDRESS OF SOMETHING . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataDescriptionEntry_335() {
      ParserCombinator parser = grammar.dataDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 66 FAULTY\n      RENAMES FOO\n      THROUGH ADDRESS OF SOMETHING . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testLocalStorageSection_336() {
      ParserCombinator parser = grammar.localStorageSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LOCAL-STORAGE Section .\n   COPY \"LOCLSTOR.LS\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLocalStorageSection_337() {
      ParserCombinator parser = grammar.localStorageSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LOCAL-STORAGE SECTION .\n   77 OPTIONS PIC S9(9) BINARY . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWorkingStorageSection_338() {
      ParserCombinator parser = grammar.workingStorageSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" WORKING-STORAGE Section .\n   COPY \"WORKSTOR.WS\" .\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testThreadLocalStorageSection_339() {
      ParserCombinator parser = grammar.threadLocalStorageSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" THREAD-LOCAL-STORAGE Section .\n   COPY \"THRDSTOR.LS\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testThreadLocalStorageSection_340() {
      ParserCombinator parser = grammar.threadLocalStorageSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" THREAD-LOCAL-STORAGE SECTION .\n   77 OPTIONS PIC S9(9) BINARY . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObjectStorageSection_341() {
      ParserCombinator parser = grammar.objectStorageSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OBJECT-STORAGE Section .\n   COPY \"OBJSTOR.OS\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObjectStorageSection_342() {
      ParserCombinator parser = grammar.objectStorageSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OBJECT-STORAGE SECTION .\n   77 OPTIONS PIC S9(9) BINARY . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_343() {
      ParserCombinator parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_344() {
      ParserCombinator parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  CM-INQUE-1 FOR INPUT . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_345() {
      ParserCombinator parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  CM-INQUE-1 FOR INITIAL INPUT . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_346() {
      ParserCombinator parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  COMMNAME FOR INITIAL INPUT\n       SYMBOLIC SUB-QUEUE-1 IS CQ . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_347() {
      ParserCombinator parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  CM-INQUE-1 FOR INPUT\n       SYMBOLIC QUEUE IS MAIN-QUEUE\n       SYMBOLIC SUB-QUEUE-1 IS NO-SPEC-1\n       SYMBOLIC SUB-QUEUE-2 IS NO-SPEC-2\n       SYMBOLIC SUB-QUEUE-3 IS NO-SPEC-3\n       MESSAGE DATE IS DATE-RECEIVED\n       MESSAGE TIME IS TIME-RECEIVED\n       SYMBOLIC SOURCE IS WHERE-FROM\n       TEXT LENGTH IS MSG-LENGTH\n       END KEY IS END-KEY\n       STATUS KEY IS STATUS-KEY\n       MESSAGE COUNT IS MSG-COUNT . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_348() {
      ParserCombinator parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  CM-INQUE-1 FOR INPUT\n       MAIN-QUEUE NO-SPEC-1 NO-SPEC-2 NO-SPEC-3 FILLER\n       TIME-RECEIVED FILLER IN-LENGTH END-KEY IN-STATUS\n       FILLER . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_349() {
      ParserCombinator parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  CM-OUTQUE-1 FOR OUTPUT\n       DESTINATION COUNT IS ONE\n       TEXT LENGTH IS MSG-LENGTH\n       STATUS KEY IS STATUS-KEY\n       ERROR KEY IS ERR-KEY\n       SYMBOLIC DESTINATION IS SYM-DEST . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_350() {
      ParserCombinator parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  COMM2 FOR OUTPUT\n       DESTINATION TABLE OCCURS 7 TIMES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCommunicationSection_351() {
      ParserCombinator parser = grammar.communicationSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" COMMUNICATION SECTION .\n   CD  COMMNAME FOR INITIAL INPUT\n       SYMBOLIC SUB-QUEUE-1 IS CQ .\n   01  CREC .\n       03  CNAME1 PIC X(8) .\n       03  CQ     PIC 9(8) .\n       03  FILLER PIC X(62) .\n       03  CINT   PIC 9 .\n       03  FILLER PIC X(8) .\n   CD  COMM2 FOR OUTPUT\n       DESTINATION TABLE OCCURS 7 TIMES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReportSection_352() {
      ParserCombinator parser = grammar.reportSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPORT SECTION . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReportSection_353() {
      ParserCombinator parser = grammar.reportSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPORT SECTION .\n   RD  RW-FS2-REPORT-1\n       PAGE LIMIT 20\n       FIRST DETAIL 1\n       LAST DETAIL 20 .\n       01  RW-FS2-GROUP\n           LINE NUMBER IS PLUS 1\n           TYPE IS DETAIL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReportSection_354() {
      ParserCombinator parser = grammar.reportSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPORT SECTION .\n   RD  RW-FS1-REPORT-1\n       PAGE LIMIT IS 20 LINES .\n   01  RW-FS1-GROUP\n       TYPE IS DETAIL .\n       03  RW-FS1-ELEM\n           LINE NUMBER IS PLUS 1\n           COLUMN NUMBER IS 5\n           PICTURE X(76)\n           SOURCE IS REPORT-LINE-IMAGE . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReportSection_355() {
      ParserCombinator parser = grammar.reportSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPORT SECTION .\n   RD  RW-FS3-REPORT-1\n       PAGE 30\n       HEADING 1\n       FIRST DETAIL 6\n       LAST DETAIL 20 . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testReportSection_356() {
      ParserCombinator parser = grammar.reportSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPORT SECTION .\n   RD  RFIL2 .\n       01  RREC\n           TYPE IS DETAIL .\n           02  PIC 9(8)\n               SOURCE IS RKEY\n               COLUMN NUMBER IS 1\n               LINE NUMBER IS PLUS 1 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFormatClause_357() {
      ParserCombinator parser = grammar.formatClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FORMAT BIT DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFormatClause_358() {
      ParserCombinator parser = grammar.formatClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FORMAT CHARACTER DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFormatClause_359() {
      ParserCombinator parser = grammar.formatClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FORMAT NUMERIC DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFormatClause_360() {
      ParserCombinator parser = grammar.formatClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FORMAT BIT CHARACTER NUMERIC DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFormatClause_361() {
      ParserCombinator parser = grammar.formatClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FORMAT DATA "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testFormatClause_362() {
      ParserCombinator parser = grammar.formatClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FORMAT BIT NUMERIC BIT DATA "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAlignedClause_363() {
      ParserCombinator parser = grammar.alignedClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALIGNED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAnyLengthClause_364() {
      ParserCombinator parser = grammar.anyLengthClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ANY LENGTH "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBasedClause_365() {
      ParserCombinator parser = grammar.basedClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BASED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testConstantRecordClause_366() {
      ParserCombinator parser = grammar.constantRecordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CONSTANT RECORD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGroupUsageClause_367() {
      ParserCombinator parser = grammar.groupUsageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GROUP-USAGE IS BIT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGroupUsageClause_368() {
      ParserCombinator parser = grammar.groupUsageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GROUP-USAGE BIT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGroupUsageClause_369() {
      ParserCombinator parser = grammar.groupUsageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GROUP-USAGE IS NATIONAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testGroupUsageClause_370() {
      ParserCombinator parser = grammar.groupUsageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" GROUP-USAGE NATIONAL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSameAsClause_371() {
      ParserCombinator parser = grammar.sameAsClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SAME AS FOO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSameAsClause_372() {
      ParserCombinator parser = grammar.sameAsClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SAME FOO "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectWhenClause_373() {
      ParserCombinator parser = grammar.selectWhenClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT WHEN OTHER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectWhenClause_374() {
      ParserCombinator parser = grammar.selectWhenClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT WHEN MY-CONDITION "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectWhenClause_375() {
      ParserCombinator parser = grammar.selectWhenClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT OTHER "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectWhenClause_376() {
      ParserCombinator parser = grammar.selectWhenClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT MY-CONDITION "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testTypeNameTypeClause_377() {
      ParserCombinator parser = grammar.typeNameTypeClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TYPE MY-TYPE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassClause_378() {
      ParserCombinator parser = grammar.classClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS IS NUMERIC "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassClause_379() {
      ParserCombinator parser = grammar.classClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS NUMERIC "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassClause_380() {
      ParserCombinator parser = grammar.classClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS IS ALPHABETIC "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassClause_381() {
      ParserCombinator parser = grammar.classClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS ALPHABETIC "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassClause_382() {
      ParserCombinator parser = grammar.classClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS IS ALPHABETIC-LOWER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassClause_383() {
      ParserCombinator parser = grammar.classClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS ALPHABETIC-LOWER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassClause_384() {
      ParserCombinator parser = grammar.classClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS IS ALPHABETIC-UPPER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassClause_385() {
      ParserCombinator parser = grammar.classClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS ALPHABETIC-UPPER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassClause_386() {
      ParserCombinator parser = grammar.classClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS IS BOOLEAN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassClause_387() {
      ParserCombinator parser = grammar.classClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS BOOLEAN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassClause_388() {
      ParserCombinator parser = grammar.classClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS IS MY-ALPHABET "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassClause_389() {
      ParserCombinator parser = grammar.classClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS MY-ALPHABET "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassClause_390() {
      ParserCombinator parser = grammar.classClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS IS MY-CLASS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassClause_391() {
      ParserCombinator parser = grammar.classClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS MY-CLASS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDefaultClause_392() {
      ParserCombinator parser = grammar.defaultClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DEFAULT IS NONE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDefaultClause_393() {
      ParserCombinator parser = grammar.defaultClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DEFAULT NONE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDefaultClause_394() {
      ParserCombinator parser = grammar.defaultClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DEFAULT IS \"COBOL\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDefaultClause_395() {
      ParserCombinator parser = grammar.defaultClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DEFAULT \"COBOL\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDefaultClause_396() {
      ParserCombinator parser = grammar.defaultClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DEFAULT IS MY-DEFAULT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDefaultClause_397() {
      ParserCombinator parser = grammar.defaultClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DEFAULT MY-DEFAULT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDestinationClause_398() {
      ParserCombinator parser = grammar.destinationClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DESTINATION IS MOUNT-DOOM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDestinationClause_399() {
      ParserCombinator parser = grammar.destinationClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DESTINATION MOUNT-DOOM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDestinationClause_400() {
      ParserCombinator parser = grammar.destinationClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DESTINATION IS MORDOR MOUNT-DOOM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDestinationClause_401() {
      ParserCombinator parser = grammar.destinationClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DESTINATION MORDOR MOUNT-DOOM "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvalidClause_402() {
      ParserCombinator parser = grammar.invalidClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVALID WHEN A < B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInvalidClause_403() {
      ParserCombinator parser = grammar.invalidClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INVALID A < B "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testPresentWhenClause_404() {
      ParserCombinator parser = grammar.presentWhenClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PRESENT WHEN A < B "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testPresentWhenClause_405() {
      ParserCombinator parser = grammar.presentWhenClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PRESENT A < B "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_406() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALIDATE-STATUS IS \"OK\" WHEN NO ERROR FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_407() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALIDATE-STATUS    \"OK\" WHEN NO ERROR FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_408() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VAL-STATUS      IS \"OK\" WHEN NO ERROR FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_409() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VAL-STATUS         \"OK\" WHEN NO ERROR FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_410() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALIDATE-STATUS IS JUST-FINE WHEN NO ERROR FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_411() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALIDATE-STATUS    JUST-FINE WHEN NO ERROR FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_412() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VAL-STATUS      IS JUST-FINE WHEN NO ERROR FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_413() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VAL-STATUS         JUST-FINE WHEN NO ERROR FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_414() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALIDATE-STATUS IS JUST-FINE WHEN NO ERROR FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_415() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALIDATE-STATUS IS JUST-FINE WHEN    ERROR FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_416() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALIDATE-STATUS IS JUST-FINE      NO ERROR FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_417() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALIDATE-STATUS IS JUST-FINE         ERROR FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_418() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALIDATE-STATUS IS JUST-FINE WHEN NO ERROR\n   ON FORMAT\n   FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_419() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALIDATE-STATUS IS JUST-FINE WHEN NO ERROR\n   ON CONTENT\n   FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_420() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALIDATE-STATUS IS JUST-FINE WHEN NO ERROR\n   ON RELATION\n   FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_421() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALIDATE-STATUS IS JUST-FINE WHEN NO ERROR\n   ON RELATION CONTENT FORMAT\n   FOR MISSION-PARAMETERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValidateStatusClause_422() {
      ParserCombinator parser = grammar.validateStatusClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALIDATE-STATUS IS JUST-FINE WHEN NO ERROR\n   ON RELATION FORMAT RELATION\n   FOR MISSION-PARAMETERS "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testLineClause_423() {
      ParserCombinator parser = grammar.lineClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINE NUMBER IS  PLUS 42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLineClause_424() {
      ParserCombinator parser = grammar.lineClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINE NUMBER IS     + 42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLineClause_425() {
      ParserCombinator parser = grammar.lineClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINE NUMBER IS MINUS 42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLineClause_426() {
      ParserCombinator parser = grammar.lineClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINE NUMBER IS     - 42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLineClause_427() {
      ParserCombinator parser = grammar.lineClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINE NUMBER IS  PLUS FORTY-TWO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLineClause_428() {
      ParserCombinator parser = grammar.lineClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINE NUMBER IS     + FORTY-TWO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLineClause_429() {
      ParserCombinator parser = grammar.lineClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINE NUMBER IS MINUS FORTY-TWO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLineClause_430() {
      ParserCombinator parser = grammar.lineClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINE NUMBER IS     - FORTY-TWO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLineClause_431() {
      ParserCombinator parser = grammar.lineClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINE NUMBER IS 42 ON NEXT PAGE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLineClause_432() {
      ParserCombinator parser = grammar.lineClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINE NUMBER IS 42              "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLineClause_433() {
      ParserCombinator parser = grammar.lineClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINE NUMBER IS    ON NEXT PAGE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLineClause_434() {
      ParserCombinator parser = grammar.lineClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINE NUMBERS ARE 1 2 3 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLineClause_435() {
      ParserCombinator parser = grammar.lineClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINES        ARE 1 2 3 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testHighlightClause_436() {
      ParserCombinator parser = grammar.highlightClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" HIGHLIGHT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testHighlightClause_437() {
      ParserCombinator parser = grammar.highlightClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LOWLIGHT  "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReverseVideoClause_438() {
      ParserCombinator parser = grammar.reverseVideoClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REVERSE-VIDEO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUnderlineClause_439() {
      ParserCombinator parser = grammar.underlineClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" UNDERLINE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testForegroundColorClause_440() {
      ParserCombinator parser = grammar.foregroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FOREGROUND-COLOUR IS 42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testForegroundColorClause_441() {
      ParserCombinator parser = grammar.foregroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FOREGROUND-COLOR  IS 42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testForegroundColorClause_442() {
      ParserCombinator parser = grammar.foregroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FOREGROUND-COLOUR IS ORANGE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testForegroundColorClause_443() {
      ParserCombinator parser = grammar.foregroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FOREGROUND-COLOR  IS ORANGE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testForegroundColorClause_444() {
      ParserCombinator parser = grammar.foregroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FOREGROUND-COLOUR    42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testForegroundColorClause_445() {
      ParserCombinator parser = grammar.foregroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FOREGROUND-COLOR     42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testForegroundColorClause_446() {
      ParserCombinator parser = grammar.foregroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FOREGROUND-COLOUR    ORANGE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testForegroundColorClause_447() {
      ParserCombinator parser = grammar.foregroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FOREGROUND-COLOR     ORANGE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBackgroundColorClause_448() {
      ParserCombinator parser = grammar.backgroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BACKGROUND-COLOUR IS 42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBackgroundColorClause_449() {
      ParserCombinator parser = grammar.backgroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BACKGROUND-COLOR  IS 42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBackgroundColorClause_450() {
      ParserCombinator parser = grammar.backgroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BACKGROUND-COLOUR IS ORANGE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBackgroundColorClause_451() {
      ParserCombinator parser = grammar.backgroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BACKGROUND-COLOR  IS ORANGE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBackgroundColorClause_452() {
      ParserCombinator parser = grammar.backgroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BACKGROUND-COLOUR    42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBackgroundColorClause_453() {
      ParserCombinator parser = grammar.backgroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BACKGROUND-COLOR     42 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBackgroundColorClause_454() {
      ParserCombinator parser = grammar.backgroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BACKGROUND-COLOUR    ORANGE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBackgroundColorClause_455() {
      ParserCombinator parser = grammar.backgroundColorClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BACKGROUND-COLOR     ORANGE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testConstantEntry_456() {
      ParserCombinator parser = grammar.constantEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE NEXT . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testConstantEntry_457() {
      ParserCombinator parser = grammar.constantEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE NEXT + 1 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testConstantEntry_458() {
      ParserCombinator parser = grammar.constantEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE START bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testConstantEntry_459() {
      ParserCombinator parser = grammar.constantEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE START OF bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testConstantEntry_460() {
      ParserCombinator parser = grammar.constantEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foobar VALUE START OF foo + LENGTH OF bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testConstantEntry_461() {
      ParserCombinator parser = grammar.constantEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE LENGTH bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testConstantEntry_462() {
      ParserCombinator parser = grammar.constantEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE LENGTH OF bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testConstantEntry_463() {
      ParserCombinator parser = grammar.constantEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foobar VALUE \"foo\" & bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testConstantEntry_464() {
      ParserCombinator parser = grammar.constantEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE 4 * 2 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testConstantEntry_465() {
      ParserCombinator parser = grammar.constantEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 foo VALUE 4 * bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testConstantEntry_466() {
      ParserCombinator parser = grammar.constantEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 lines-to-display . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testConstantEntry_467() {
      ParserCombinator parser = grammar.constantEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 lines-to-display value is 12 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testConstantEntry_468() {
      ParserCombinator parser = grammar.constantEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 78 lines-to-display value 12 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRenamesClause_469() {
      ParserCombinator parser = grammar.renamesClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RENAMES THAT-THING                                     "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRenamesClause_470() {
      ParserCombinator parser = grammar.renamesClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RENAMES THAT-THING          THROUGH THIS-THING         "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRenamesClause_471() {
      ParserCombinator parser = grammar.renamesClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RENAMES THAT-THING          THRU    THIS-THING         "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRenamesClause_472() {
      ParserCombinator parser = grammar.renamesClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RENAMES THAT-THING OF YOURS                            "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRenamesClause_473() {
      ParserCombinator parser = grammar.renamesClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RENAMES THAT-THING OF YOURS THROUGH THIS-THING OF MINE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRenamesClause_474() {
      ParserCombinator parser = grammar.renamesClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RENAMES THAT-THING OF YOURS THRU    THIS-THING OF MINE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}