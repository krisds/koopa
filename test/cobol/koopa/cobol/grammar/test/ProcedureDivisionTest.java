package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from ProcedureDivision.stage. */
public class ProcedureDivisionTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testStatement_1() {
      ParserCombinator parser = grammar.statement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY FIELD "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStatement_2() {
      ParserCombinator parser = grammar.statement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TRANSMOGRIFY "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testSentence_3() {
      ParserCombinator parser = grammar.sentence();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSentence_4() {
      ParserCombinator parser = grammar.sentence();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DISPLAY FIELD . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSentence_5() {
      ParserCombinator parser = grammar.sentence();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ADD A TO B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSentence_6() {
      ParserCombinator parser = grammar.sentence();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ADD A TO B\n   DISPLAY B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_7() {
      ParserCombinator parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PARAGRAPH-07 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_8() {
      ParserCombinator parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PARAGRAPH-08 .\n   ADD A TO B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_9() {
      ParserCombinator parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PARAGRAPH-09 .\n   ADD A TO B .\n   DISPLAY B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_10() {
      ParserCombinator parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PARAGRAPH-09 .\n   ADD A TO B\n   DISPLAY B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_11() {
      ParserCombinator parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 10 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_12() {
      ParserCombinator parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 11 .\n   ADD A TO B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_13() {
      ParserCombinator parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 12 .\n   ADD A TO B .\n   DISPLAY B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_14() {
      ParserCombinator parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 13 .\n   ADD A TO B\n   DISPLAY B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_15() {
      ParserCombinator parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SECTION-10 SECTION . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_16() {
      ParserCombinator parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 10 SECTION . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_17() {
      ParserCombinator parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SECTION-11 SECTION .\n   ADD A TO B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_18() {
      ParserCombinator parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 11 SECTION .\n   ADD A TO B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_19() {
      ParserCombinator parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SECTION-12 SECTION .\n   ADD A TO B .\n   DISPLAY B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_20() {
      ParserCombinator parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 12 SECTION .\n   ADD A TO B .\n   DISPLAY B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_21() {
      ParserCombinator parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SECTION-12 SECTION .\n   ADD A TO B\n   DISPLAY B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_22() {
      ParserCombinator parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 12 SECTION .\n   ADD A TO B\n   DISPLAY B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_23() {
      ParserCombinator parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SECTION-13 SECTION .\n   PARAGRAPH-13 .\n   DISPLAY 13 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_24() {
      ParserCombinator parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 13 SECTION .\n   PARAGRAPH-13 .\n   DISPLAY 13 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_25() {
      ParserCombinator parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 13 SECTION .\n   14 .\n   DISPLAY 13 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_26() {
      ParserCombinator parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SECTION-14 SECTION .\n   ADD A TO B .\n   PARAGRAPH-14 .\n   DISPLAY 14 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_27() {
      ParserCombinator parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SECTION-15 SECTION .\n   ADD A TO B .\n   PARAGRAPH-15-A .\n   DISPLAY 15A .\n   PARAGRAPH-15-B .\n   DISPLAY 15B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeclarativeSection_28() {
      ParserCombinator parser = grammar.declarativeSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON MASTER-FILE . \n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeclarativeSection_29() {
      ParserCombinator parser = grammar.declarativeSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON MASTER-FILE . \n     DISPLAY \"Input error \" . \n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeclarativeSection_30() {
      ParserCombinator parser = grammar.declarativeSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON MASTER-FILE . \n   REPORT-ERROR . \n     DISPLAY \"Input error \" . \n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeclaratives_31() {
      ParserCombinator parser = grammar.declaratives();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DECLARATIVES .\n   INPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON MASTER-FILE . \n   REPORT-ERROR . \n     DISPLAY \"Input error \" . \n   END DECLARATIVES .\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeclaratives_32() {
      ParserCombinator parser = grammar.declaratives();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DECLARATIVES .\n   END DECLARATIVES .\n"));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_33() {
      ParserCombinator parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USING BY REFERENCE A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_34() {
      ParserCombinator parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USING REFERENCE A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_35() {
      ParserCombinator parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USING A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_36() {
      ParserCombinator parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USING BY VALUE A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_37() {
      ParserCombinator parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" USING VALUE A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_38() {
      ParserCombinator parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAINING BY REFERENCE A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_39() {
      ParserCombinator parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAINING REFERENCE A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_40() {
      ParserCombinator parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAINING A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_41() {
      ParserCombinator parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAINING BY VALUE A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_42() {
      ParserCombinator parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CHAINING VALUE A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_43() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_44() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION USING DATA-AREA . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_45() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION USING DATA-AREA-A DATA-AREA-B DATA-AREA-C . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_46() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION CHAINING DATA-AREA . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_47() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION CHAINING DATA-AREA-A DATA-AREA-B DATA-AREA-C . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_48() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION USING DATA-AREA-A CHAINING DATA-AREA-B . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_49() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION CHAINING DATA-AREA-A USING DATA-AREA-B . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_50() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   DISPLAY 18 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_51() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   DISPLAY 19 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_52() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   PARAGRAPH-20 .\n   DISPLAY 20 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_53() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   PARAGRAPH-21 .\n   DISPLAY 21 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_54() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   DISPLAY 22A .\n   PARAGRAPH-22 .\n   DISPLAY 22B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_55() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   DISPLAY 23A .\n   PARAGRAPH-23 .\n   DISPLAY 23B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_56() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   SECTION-24 SECTION .\n   DISPLAY 24 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_57() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   SECTION-25 SECTION .\n   DISPLAY 25 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_58() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   DISPLAY 26A .\n   SECTION-26 SECTION .\n   DISPLAY 26B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_59() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   DISPLAY 27A .\n   SECTION-27 SECTION .\n   DISPLAY 27B . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_60() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   DISPLAY 28A .\n   SECTION-28 SECTION .\n   DISPLAY 28B .\n   PARAGRAPH-28 .\n   DISPLAY 28C . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_61() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   DISPLAY 29A .\n   SECTION-29 SECTION .\n   DISPLAY 29B .\n   PARAGRAPH-29 .\n   DISPLAY 29C . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_62() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   DISPLAY 30A .\n   PARAGRAPH-30 .\n   DISPLAY 30B .\n   SECTION-30 SECTION .\n   DISPLAY 30C . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_63() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   DISPLAY 31A .\n   PARAGRAPH-31 .\n   DISPLAY 31B .\n   SECTION-31 SECTION .\n   DISPLAY 31C . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_64() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   DISPLAY 32A .\n   PARAGRAPH-32A .\n   DISPLAY 32B .\n   SECTION-32 SECTION .\n   DISPLAY 32C .\n   PARAGRAPH-32B .\n   DISPLAY 32D . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_65() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   DISPLAY 33A .\n   PARAGRAPH-33A .\n   DISPLAY 33B .\n   SECTION-33 SECTION .\n   DISPLAY 33C .\n   PARAGRAPH-33B .\n   DISPLAY 33D . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_66() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION USING\n     BY VALUE Arg1,\n     BY REFERENCE Arg2,\n     BY REFERENCE Arg3.\n   000-Main.\n     DISPLAY 'Starting cobsub.cbl'.\n     DISPLAY 'Arg1=' Arg1.\n     DISPLAY 'Arg2=' Arg2.\n     DISPLAY 'Arg3=' Arg3.\n     MOVE 'X' TO Arg1 (1:1).\n     MOVE 'X' TO Arg2 (1:1).\n     MOVE 987654321 TO Arg3.\n     MOVE 2 TO RETURN-CODE.\n     GOBACK. "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_67() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION foo .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_68() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION foo USING\n     BY REFERENCE ANY .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_69() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION foo USING\n     BY REFERENCE bar DELIMITED .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_70() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION foo USING\n     BY REFERENCE bar DELIMITED BY SIZE .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_71() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION foo USING\n     BY VALUE ANY .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_72() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION foo USING\n     BY VALUE bar REPEATED .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_73() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION foo USING\n     BY VALUE bar REPEATED 1 TO 10 .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_74() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION foo USING\n     BY VALUE bar REPEATED 1 TO 10\n     GIVING baz .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_75() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION foo USING\n     BY VALUE bar REPEATED 1 TO 10\n     RETURNING baz .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_76() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION foo USING\n     BY OUTPUT .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_77() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROCEDURE DIVISION foo USING\n     BY OUTPUT foo AS bar.\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_78() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   DISPLAY 33A .\n   PARAGRAPH-33A .\n   DISPLAY 33B .\n   SECTION-33 SECTION .\n   DISPLAY 33C .\n   PARAGRAPH-33B .\n   DISPLAY 33D . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_79() {
      ParserCombinator parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" 000-Main.\n     DISPLAY 'Starting cobsub.cbl'.\n     DISPLAY 'Arg1=' Arg1.\n     DISPLAY 'Arg2=' Arg2.\n     DISPLAY 'Arg3=' Arg3.\n     MOVE 'X' TO Arg1 (1:1).\n     MOVE 'X' TO Arg2 (1:1).\n     MOVE 987654321 TO Arg3.\n     MOVE 2 TO RETURN-CODE.\n     GOBACK. "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_80() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_81() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE IS AWAY-FROM-ZERO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_82() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE    AWAY-FROM-ZERO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_83() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE IS NEAREST-AWAY-FROM-ZERO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_84() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE    NEAREST-AWAY-FROM-ZERO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_85() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE IS NEAREST-EVEN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_86() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE    NEAREST-EVEN "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_87() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE IS NEAREST-TOWARD-ZERO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_88() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE    NEAREST-TOWARD-ZERO "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_89() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE IS PROHIBITED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_90() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE    PROHIBITED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_91() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE IS TOWARD-GREATER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_92() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE    TOWARD-GREATER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_93() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE IS TOWARD-LESSER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_94() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE    TOWARD-LESSER "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_95() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE IS TRUNCATION "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRoundedPhrase_96() {
      ParserCombinator parser = grammar.roundedPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ROUNDED MODE    TRUNCATION "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSecureClause_97() {
      ParserCombinator parser = grammar.secureClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SECURE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testRequiredClause_98() {
      ParserCombinator parser = grammar.requiredClause();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REQUIRED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}