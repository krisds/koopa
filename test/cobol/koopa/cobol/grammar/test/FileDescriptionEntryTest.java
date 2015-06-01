package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from FileDescriptionEntry.stage. */
public class FileDescriptionEntryTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testBlockContainsClause_1() {
      ParserCombinator parser = grammar.blockContainsClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLOCK CONTAINS 1 TO 7 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlockContainsClause_2() {
      ParserCombinator parser = grammar.blockContainsClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLOCK CONTAINS 1 TO 7 RECORDS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlockContainsClause_3() {
      ParserCombinator parser = grammar.blockContainsClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLOCK CONTAINS 1 TO 7 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlockContainsClause_4() {
      ParserCombinator parser = grammar.blockContainsClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLOCK CONTAINS 1 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlockContainsClause_5() {
      ParserCombinator parser = grammar.blockContainsClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLOCK CONTAINS 1 RECORDS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlockContainsClause_6() {
      ParserCombinator parser = grammar.blockContainsClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLOCK CONTAINS 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlockContainsClause_7() {
      ParserCombinator parser = grammar.blockContainsClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLOCK 1 TO 7 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlockContainsClause_8() {
      ParserCombinator parser = grammar.blockContainsClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLOCK 1 TO 7 RECORDS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlockContainsClause_9() {
      ParserCombinator parser = grammar.blockContainsClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLOCK 1 TO 7 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlockContainsClause_10() {
      ParserCombinator parser = grammar.blockContainsClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLOCK 1 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlockContainsClause_11() {
      ParserCombinator parser = grammar.blockContainsClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLOCK 1 RECORDS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testBlockContainsClause_12() {
      ParserCombinator parser = grammar.blockContainsClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" BLOCK 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCodeSetClause_13() {
      ParserCombinator parser = grammar.codeSetClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CODE-SET IS MY-ALPHABET-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCodeSetClause_14() {
      ParserCombinator parser = grammar.codeSetClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CODE-SET MY-ALPHABET-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_15() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DATA RECORD IS MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_16() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DATA RECORD IS MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_17() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DATA RECORD ARE MY-DATA-NAME "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_18() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DATA RECORD ARE MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_19() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DATA RECORD MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_20() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DATA RECORD MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_21() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DATA RECORDS IS MY-DATA-NAME "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_22() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DATA RECORDS IS MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_23() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DATA RECORDS ARE MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_24() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DATA RECORDS ARE MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_25() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DATA RECORDS MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_26() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DATA RECORDS MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_27() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD IS MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_28() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD IS MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_29() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD ARE MY-DATA-NAME "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_30() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD ARE MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_31() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_32() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_33() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDS IS MY-DATA-NAME "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_34() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDS IS MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_35() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDS ARE MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_36() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDS ARE MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_37() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDS MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDataRecords_38() {
      ParserCombinator parser = grammar.dataRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDS MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_39() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORD IS OMITTED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_40() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORD IS STANDARD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_41() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORD IS MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_42() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORD IS MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_43() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORD ARE OMITTED "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_44() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORD ARE STANDARD "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_45() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORD ARE MY-DATA-NAME "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_46() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORD ARE MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_47() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORD OMITTED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_48() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORD STANDARD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_49() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORD MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_50() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORD MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_51() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORDS IS OMITTED "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_52() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORDS IS STANDARD "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_53() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORDS IS MY-DATA-NAME "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_54() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORDS IS MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_55() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORDS ARE OMITTED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_56() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORDS ARE STANDARD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_57() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORDS ARE MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_58() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORDS ARE MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_59() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORDS OMITTED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_60() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORDS STANDARD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_61() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORDS MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLabelRecords_62() {
      ParserCombinator parser = grammar.labelRecords();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LABEL RECORDS MY-DATA-NAME MY-OTHER-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_63() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_64() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS MY-LINE-COUNT LINES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_65() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_66() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS MY-LINE-COUNT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_67() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE 10 LINES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_68() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE MY-LINE-COUNT LINES "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_69() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE 10 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_70() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE MY-LINE-COUNT "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_71() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     WITH FOOTING AT 20 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_72() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     WITH FOOTING AT MY-FOOTING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_73() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     WITH FOOTING 20 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_74() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     WITH FOOTING MY-FOOTING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_75() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     FOOTING AT 20 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_76() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     FOOTING AT MY-FOOTING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_77() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     FOOTING 20 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_78() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     FOOTING MY-FOOTING "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_79() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     LINES AT TOP 2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_80() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     LINES AT TOP MY-TOP "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_81() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     AT TOP 2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_82() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     AT TOP MY-TOP "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_83() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     LINES TOP 2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_84() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     LINES TOP MY-TOP "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_85() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     TOP 2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_86() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     TOP MY-TOP "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_87() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     LINES AT BOTTOM 2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_88() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     LINES AT BOTTOM MY-TOP "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_89() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     AT BOTTOM 2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_90() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     AT BOTTOM MY-TOP "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_91() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     LINES BOTTOM 2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_92() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     LINES BOTTOM MY-TOP "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_93() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     BOTTOM 2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testLinageClause_94() {
      ParserCombinator parser = grammar.linageClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" LINAGE IS 10 LINES\n     BOTTOM MY-TOP "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_95() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD CONTAINS 2 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_96() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD 2 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_97() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD CONTAINS 2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_98() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD 2 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_99() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD CONTAINS 2 TO 6 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_100() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD 2 TO 6 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_101() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD CONTAINS 2 TO 6 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_102() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD 2 TO 6 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_103() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD IS VARYING IN SIZE FROM 2 TO 6 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_104() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD IS VARYING IN SIZE FROM 2 TO 6 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_105() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD VARYING IN SIZE FROM 2 TO 6 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_106() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD VARYING IN SIZE FROM 2 TO 6 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_107() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD IS VARYING FROM 2 TO 6 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_108() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD IS VARYING FROM 2 TO 6 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_109() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD VARYING FROM 2 TO 6 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_110() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD VARYING FROM 2 TO 6 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_111() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD IS VARYING IN SIZE 2 TO 6 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_112() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD IS VARYING IN SIZE 2 TO 6 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_113() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD VARYING IN SIZE 2 TO 6 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_114() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD VARYING IN SIZE 2 TO 6 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_115() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD IS VARYING 2 TO 6 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_116() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD IS VARYING 2 TO 6 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_117() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD VARYING 2 TO 6 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_118() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD VARYING 2 TO 6 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_119() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD IS VARYING IN SIZE FROM 2 TO 6 CHARACTERS\n     DEPENDING ON MY-FILE-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordClause_120() {
      ParserCombinator parser = grammar.recordClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORD IS VARYING IN SIZE FROM 2 TO 6 CHARACTERS\n     DEPENDING MY-FILE-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_121() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING MODE IS F "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_122() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING MODE IS V "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_123() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING MODE IS U "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_124() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING MODE IS S "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_125() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING MODE F "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_126() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING MODE V "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_127() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING MODE U "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_128() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING MODE S "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_129() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING IS F "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_130() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING IS V "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_131() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING IS U "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_132() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING IS S "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_133() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING F "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_134() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING V "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_135() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING U "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRecordingMode_136() {
      ParserCombinator parser = grammar.recordingMode();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" RECORDING S "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueOf_137() {
      ParserCombinator parser = grammar.valueOf();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE OF IDENTIFICATION IS MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueOf_138() {
      ParserCombinator parser = grammar.valueOf();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE OF IDENTIFICATION MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueOf_139() {
      ParserCombinator parser = grammar.valueOf();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE OF ID IS MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueOf_140() {
      ParserCombinator parser = grammar.valueOf();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE OF ID MY-DATA-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueOf_141() {
      ParserCombinator parser = grammar.valueOf();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE OF IDENTIFICATION IS \"MY LITERAL\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueOf_142() {
      ParserCombinator parser = grammar.valueOf();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE OF IDENTIFICATION \"MY LITERAL\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueOf_143() {
      ParserCombinator parser = grammar.valueOf();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE OF ID IS \"MY LITERAL\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueOf_144() {
      ParserCombinator parser = grammar.valueOf();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUE OF ID \"MY LITERAL\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReportClause_145() {
      ParserCombinator parser = grammar.reportClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPORT IS MY-REPORT-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReportClause_146() {
      ParserCombinator parser = grammar.reportClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPORTS ARE MY-REPORT-NAME MY-OTHER-REPORT-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReportClause_147() {
      ParserCombinator parser = grammar.reportClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPORT MY-REPORT-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReportClause_148() {
      ParserCombinator parser = grammar.reportClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPORTS MY-REPORT-NAME MY-OTHER-REPORT-NAME "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFdFileDescriptionEntry_149() {
      ParserCombinator parser = grammar.fdFileDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FD MY-FILE-NAME . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFdFileDescriptionEntry_150() {
      ParserCombinator parser = grammar.fdFileDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FD FGRERROR\n      BLOCK CONTAINS 0 RECORDS\n      RECORDING MODE IS F\n      LABEL RECORDS ARE STANDARD. "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSdFileDescriptionEntry_151() {
      ParserCombinator parser = grammar.sdFileDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SD MY-FILE-NAME . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSdFileDescriptionEntry_152() {
      ParserCombinator parser = grammar.sdFileDescriptionEntry();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SD MY-FILE-NAME\n      RECORDING MODE IS F\n      BLOCK CONTAINS 0 RECORDS . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}