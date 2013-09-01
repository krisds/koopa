package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from ProcedureDivision.stage. */
public class ProcedureDivisionTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testStatement_1() {
      Parser parser = grammar.statement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " DISPLAY FIELD ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testStatement_2() {
      Parser parser = grammar.statement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " TRANSMOGRIFY ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testSentence_3() {
      Parser parser = grammar.sentence();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSentence_4() {
      Parser parser = grammar.sentence();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " DISPLAY FIELD . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSentence_5() {
      Parser parser = grammar.sentence();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ADD A TO B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSentence_6() {
      Parser parser = grammar.sentence();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ADD A TO B\n   DISPLAY B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_7() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PARAGRAPH-07 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_8() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PARAGRAPH-08 .\n   ADD A TO B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_9() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PARAGRAPH-09 .\n   ADD A TO B .\n   DISPLAY B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_10() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PARAGRAPH-09 .\n   ADD A TO B\n   DISPLAY B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_11() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " 10 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_12() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " 11 .\n   ADD A TO B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_13() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " 12 .\n   ADD A TO B .\n   DISPLAY B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testParagraph_14() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " 13 .\n   ADD A TO B\n   DISPLAY B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_15() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SECTION-10 SECTION . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_16() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " 10 SECTION . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_17() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SECTION-11 SECTION .\n   ADD A TO B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_18() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " 11 SECTION .\n   ADD A TO B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_19() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SECTION-12 SECTION .\n   ADD A TO B .\n   DISPLAY B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_20() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " 12 SECTION .\n   ADD A TO B .\n   DISPLAY B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_21() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SECTION-12 SECTION .\n   ADD A TO B\n   DISPLAY B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_22() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " 12 SECTION .\n   ADD A TO B\n   DISPLAY B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_23() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SECTION-13 SECTION .\n   PARAGRAPH-13 .\n   DISPLAY 13 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_24() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " 13 SECTION .\n   PARAGRAPH-13 .\n   DISPLAY 13 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_25() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " 13 SECTION .\n   14 .\n   DISPLAY 13 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_26() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SECTION-14 SECTION .\n   ADD A TO B .\n   PARAGRAPH-14 .\n   DISPLAY 14 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSection_27() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SECTION-15 SECTION .\n   ADD A TO B .\n   PARAGRAPH-15-A .\n   DISPLAY 15A .\n   PARAGRAPH-15-B .\n   DISPLAY 15B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeclarativeSection_28() {
      Parser parser = grammar.declarativeSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON MASTER-FILE . \n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeclarativeSection_29() {
      Parser parser = grammar.declarativeSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON MASTER-FILE . \n     DISPLAY \"Input error \" . \n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeclarativeSection_30() {
      Parser parser = grammar.declarativeSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " INPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON MASTER-FILE . \n   REPORT-ERROR . \n     DISPLAY \"Input error \" . \n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeclaratives_31() {
      Parser parser = grammar.declaratives();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " DECLARATIVES .\n   INPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON MASTER-FILE . \n   REPORT-ERROR . \n     DISPLAY \"Input error \" . \n   END DECLARATIVES .\n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDeclaratives_32() {
      Parser parser = grammar.declaratives();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " DECLARATIVES .\n   END DECLARATIVES .\n");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_33() {
      Parser parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USING BY REFERENCE A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_34() {
      Parser parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USING REFERENCE A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_35() {
      Parser parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USING A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_36() {
      Parser parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USING BY VALUE A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_37() {
      Parser parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " USING VALUE A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_38() {
      Parser parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAINING BY REFERENCE A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_39() {
      Parser parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAINING REFERENCE A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_40() {
      Parser parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAINING A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_41() {
      Parser parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAINING BY VALUE A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testUsingOrChainingPhrase_42() {
      Parser parser = grammar.usingOrChainingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CHAINING VALUE A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_43() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_44() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION USING DATA-AREA . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_45() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION USING DATA-AREA-A DATA-AREA-B DATA-AREA-C . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_46() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION CHAINING DATA-AREA . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_47() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION CHAINING DATA-AREA-A DATA-AREA-B DATA-AREA-C . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_48() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION USING DATA-AREA-A CHAINING DATA-AREA-B . ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_49() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION CHAINING DATA-AREA-A USING DATA-AREA-B . ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_50() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   DISPLAY 18 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_51() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   DISPLAY 19 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_52() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   PARAGRAPH-20 .\n   DISPLAY 20 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_53() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   PARAGRAPH-21 .\n   DISPLAY 21 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_54() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   DISPLAY 22A .\n   PARAGRAPH-22 .\n   DISPLAY 22B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_55() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   DISPLAY 23A .\n   PARAGRAPH-23 .\n   DISPLAY 23B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_56() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   SECTION-24 SECTION .\n   DISPLAY 24 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_57() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   SECTION-25 SECTION .\n   DISPLAY 25 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_58() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   DISPLAY 26A .\n   SECTION-26 SECTION .\n   DISPLAY 26B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_59() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   DISPLAY 27A .\n   SECTION-27 SECTION .\n   DISPLAY 27B . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_60() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   DISPLAY 28A .\n   SECTION-28 SECTION .\n   DISPLAY 28B .\n   PARAGRAPH-28 .\n   DISPLAY 28C . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_61() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   DISPLAY 29A .\n   SECTION-29 SECTION .\n   DISPLAY 29B .\n   PARAGRAPH-29 .\n   DISPLAY 29C . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_62() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   DISPLAY 30A .\n   PARAGRAPH-30 .\n   DISPLAY 30B .\n   SECTION-30 SECTION .\n   DISPLAY 30C . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_63() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   DISPLAY 31A .\n   PARAGRAPH-31 .\n   DISPLAY 31B .\n   SECTION-31 SECTION .\n   DISPLAY 31C . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_64() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   DISPLAY 32A .\n   PARAGRAPH-32A .\n   DISPLAY 32B .\n   SECTION-32 SECTION .\n   DISPLAY 32C .\n   PARAGRAPH-32B .\n   DISPLAY 32D . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_65() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION .\n   DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   DISPLAY 33A .\n   PARAGRAPH-33A .\n   DISPLAY 33B .\n   SECTION-33 SECTION .\n   DISPLAY 33C .\n   PARAGRAPH-33B .\n   DISPLAY 33D . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_66() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION USING\n     BY VALUE Arg1,\n     BY REFERENCE Arg2,\n     BY REFERENCE Arg3.\n   000-Main.\n     DISPLAY 'Starting cobsub.cbl'.\n     DISPLAY 'Arg1=' Arg1.\n     DISPLAY 'Arg2=' Arg2.\n     DISPLAY 'Arg3=' Arg3.\n     MOVE 'X' TO Arg1 (1:1).\n     MOVE 'X' TO Arg2 (1:1).\n     MOVE 987654321 TO Arg3.\n     MOVE 2 TO RETURN-CODE.\n     GOBACK. ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_67() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION foo .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_68() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION foo USING\n     BY REFERENCE ANY .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_69() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION foo USING\n     BY REFERENCE bar DELIMITED .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_70() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION foo USING\n     BY REFERENCE bar DELIMITED BY SIZE .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_71() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION foo USING\n     BY VALUE ANY .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_72() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION foo USING\n     BY VALUE bar REPEATED .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_73() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION foo USING\n     BY VALUE bar REPEATED 1 TO 10 .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_74() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION foo USING\n     BY VALUE bar REPEATED 1 TO 10\n     GIVING baz .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_75() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION foo USING\n     BY VALUE bar REPEATED 1 TO 10\n     RETURNING baz .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_76() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION foo USING\n     BY OUTPUT .\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_77() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PROCEDURE DIVISION foo USING\n     BY OUTPUT foo AS bar.\n   000-Main.\n     DISPLAY \"Hello, world!\" .\n     GOBACK. ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_78() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " DECLARATIVES .\n   OUTPUT-ERROR SECTION .\n     USE AFTER ERROR PROCEDURE ON OUTPUT .\n   REPORT-ERROR .\n     DISPLAY \"Output error.\" .\n   END DECLARATIVES .\n   DISPLAY 33A .\n   PARAGRAPH-33A .\n   DISPLAY 33B .\n   SECTION-33 SECTION .\n   DISPLAY 33C .\n   PARAGRAPH-33B .\n   DISPLAY 33D . ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testProcedureDivision_79() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " 000-Main.\n     DISPLAY 'Starting cobsub.cbl'.\n     DISPLAY 'Arg1=' Arg1.\n     DISPLAY 'Arg2=' Arg2.\n     DISPLAY 'Arg3=' Arg3.\n     MOVE 'X' TO Arg1 (1:1).\n     MOVE 'X' TO Arg2 (1:1).\n     MOVE 987654321 TO Arg3.\n     MOVE 2 TO RETURN-CODE.\n     GOBACK. ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }
}