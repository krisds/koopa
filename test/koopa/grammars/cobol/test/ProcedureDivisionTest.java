package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class ProcedureDivisionTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testStatement_1() {
      Parser parser = grammar.statement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DISPLAY", "FIELD");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testStatement_2() {
      Parser parser = grammar.statement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TRANSMOGRIFY");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testSentence_3() {
      Parser parser = grammar.sentence();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(1, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSentence_4() {
      Parser parser = grammar.sentence();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DISPLAY", "FIELD", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSentence_5() {
      Parser parser = grammar.sentence();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSentence_6() {
      Parser parser = grammar.sentence();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ADD", "A", "TO", "B", "DISPLAY", 
        "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testParagraph_7() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PARAGRAPH-07", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testParagraph_8() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PARAGRAPH-08", ".", "ADD", "A", 
        "TO", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testParagraph_9() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PARAGRAPH-09", ".", "ADD", "A", 
        "TO", "B", ".", "DISPLAY", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testParagraph_10() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PARAGRAPH-09", ".", "ADD", "A", 
        "TO", "B", "DISPLAY", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testParagraph_11() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("10", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(2, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testParagraph_12() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("11", ".", "ADD", "A", "TO", "B", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testParagraph_13() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("12", ".", "ADD", "A", "TO", "B", 
        ".", "DISPLAY", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testParagraph_14() {
      Parser parser = grammar.paragraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("13", ".", "ADD", "A", "TO", "B", 
        "DISPLAY", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSection_15() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SECTION-10", "SECTION", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSection_16() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("10", "SECTION", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSection_17() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SECTION-11", "SECTION", ".", 
        "ADD", "A", "TO", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSection_18() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("11", "SECTION", ".", "ADD", "A", 
        "TO", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSection_19() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SECTION-12", "SECTION", ".", 
        "ADD", "A", "TO", "B", ".", "DISPLAY", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSection_20() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("12", "SECTION", ".", "ADD", "A", 
        "TO", "B", ".", "DISPLAY", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSection_21() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SECTION-12", "SECTION", ".", 
        "ADD", "A", "TO", "B", "DISPLAY", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSection_22() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("12", "SECTION", ".", "ADD", "A", 
        "TO", "B", "DISPLAY", "B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSection_23() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SECTION-13", "SECTION", ".", 
        "PARAGRAPH-13", ".", "DISPLAY", "13", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSection_24() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("13", "SECTION", ".", "PARAGRAPH-13", 
        ".", "DISPLAY", "13", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSection_25() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("13", "SECTION", ".", "14", ".", 
        "DISPLAY", "13", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSection_26() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SECTION-14", "SECTION", ".", 
        "ADD", "A", "TO", "B", ".", "PARAGRAPH-14", ".", "DISPLAY", "14", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(13, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testSection_27() {
      Parser parser = grammar.section();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("SECTION-15", "SECTION", ".", 
        "ADD", "A", "TO", "B", ".", "PARAGRAPH-15-A", ".", "DISPLAY", "15A", ".", 
        "PARAGRAPH-15-B", ".", "DISPLAY", "15B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(18, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testUseStatement_28() {
      Parser parser = grammar.useStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("USE", "AFTER", "ERROR", "PROCEDURE", 
        "ON", "MASTER-FILE", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeclarativeSection_29() {
      Parser parser = grammar.declarativeSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("INPUT-ERROR", "SECTION", ".", 
        "USE", "AFTER", "ERROR", "PROCEDURE", "ON", "MASTER-FILE", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeclarativeSection_30() {
      Parser parser = grammar.declarativeSection();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("INPUT-ERROR", "SECTION", ".", 
        "USE", "AFTER", "ERROR", "PROCEDURE", "ON", "MASTER-FILE", ".", "REPORT-ERROR", 
        ".", "DISPLAY", "\"Input error \"", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(15, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testDeclaratives_31() {
      Parser parser = grammar.declaratives();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("DECLARATIVES", ".", "INPUT-ERROR", 
        "SECTION", ".", "USE", "AFTER", "ERROR", "PROCEDURE", "ON", "MASTER-FILE", 
        ".", "REPORT-ERROR", ".", "DISPLAY", "\"Input error \"", ".", "END", "DECLARATIVES", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(20, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_32() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(3, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_33() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", "USING", 
        "DATA-AREA", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_34() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", "USING", 
        "DATA-AREA-A", "DATA-AREA-B", "DATA-AREA-C", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_35() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "DISPLAY", "18", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_36() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "DECLARATIVES", ".", "OUTPUT-ERROR", "SECTION", ".", "USE", "AFTER", "ERROR", 
        "PROCEDURE", "ON", "OUTPUT", ".", "REPORT-ERROR", ".", "DISPLAY", "\"Output error.\"", 
        ".", "END", "DECLARATIVES", ".", "DISPLAY", "19", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(26, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_37() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "PARAGRAPH-20", ".", "DISPLAY", "20", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_38() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "DECLARATIVES", ".", "OUTPUT-ERROR", "SECTION", ".", "USE", "AFTER", "ERROR", 
        "PROCEDURE", "ON", "OUTPUT", ".", "REPORT-ERROR", ".", "DISPLAY", "\"Output error.\"", 
        ".", "END", "DECLARATIVES", ".", "PARAGRAPH-21", ".", "DISPLAY", "21", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(28, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_39() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "DISPLAY", "22A", ".", "PARAGRAPH-22", ".", "DISPLAY", "22B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_40() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "DECLARATIVES", ".", "OUTPUT-ERROR", "SECTION", ".", "USE", "AFTER", "ERROR", 
        "PROCEDURE", "ON", "OUTPUT", ".", "REPORT-ERROR", ".", "DISPLAY", "\"Output error.\"", 
        ".", "END", "DECLARATIVES", ".", "DISPLAY", "23A", ".", "PARAGRAPH-23", 
        ".", "DISPLAY", "23B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(31, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_41() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "SECTION-24", "SECTION", ".", "DISPLAY", "24", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_42() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "DECLARATIVES", ".", "OUTPUT-ERROR", "SECTION", ".", "USE", "AFTER", "ERROR", 
        "PROCEDURE", "ON", "OUTPUT", ".", "REPORT-ERROR", ".", "DISPLAY", "\"Output error.\"", 
        ".", "END", "DECLARATIVES", ".", "SECTION-25", "SECTION", ".", "DISPLAY", 
        "25", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(29, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_43() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "DISPLAY", "26A", ".", "SECTION-26", "SECTION", ".", "DISPLAY", "26B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(12, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_44() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "DECLARATIVES", ".", "OUTPUT-ERROR", "SECTION", ".", "USE", "AFTER", "ERROR", 
        "PROCEDURE", "ON", "OUTPUT", ".", "REPORT-ERROR", ".", "DISPLAY", "\"Output error.\"", 
        ".", "END", "DECLARATIVES", ".", "DISPLAY", "27A", ".", "SECTION-27", "SECTION", 
        ".", "DISPLAY", "27B", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(32, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_45() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "DISPLAY", "28A", ".", "SECTION-28", "SECTION", ".", "DISPLAY", "28B", ".", 
        "PARAGRAPH-28", ".", "DISPLAY", "28C", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(17, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_46() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "DECLARATIVES", ".", "OUTPUT-ERROR", "SECTION", ".", "USE", "AFTER", "ERROR", 
        "PROCEDURE", "ON", "OUTPUT", ".", "REPORT-ERROR", ".", "DISPLAY", "\"Output error.\"", 
        ".", "END", "DECLARATIVES", ".", "DISPLAY", "29A", ".", "SECTION-29", "SECTION", 
        ".", "DISPLAY", "29B", ".", "PARAGRAPH-29", ".", "DISPLAY", "29C", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(37, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_47() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "DISPLAY", "30A", ".", "PARAGRAPH-30", ".", "DISPLAY", "30B", ".", "SECTION-30", 
        "SECTION", ".", "DISPLAY", "30C", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(17, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_48() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "DECLARATIVES", ".", "OUTPUT-ERROR", "SECTION", ".", "USE", "AFTER", "ERROR", 
        "PROCEDURE", "ON", "OUTPUT", ".", "REPORT-ERROR", ".", "DISPLAY", "\"Output error.\"", 
        ".", "END", "DECLARATIVES", ".", "DISPLAY", "31A", ".", "PARAGRAPH-31", 
        ".", "DISPLAY", "31B", ".", "SECTION-31", "SECTION", ".", "DISPLAY", "31C", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(37, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_49() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "DISPLAY", "32A", ".", "PARAGRAPH-32A", ".", "DISPLAY", "32B", ".", "SECTION-32", 
        "SECTION", ".", "DISPLAY", "32C", ".", "PARAGRAPH-32B", ".", "DISPLAY", 
        "32D", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(22, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testProcedureDivision_50() {
      Parser parser = grammar.procedureDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("PROCEDURE", "DIVISION", ".", 
        "DECLARATIVES", ".", "OUTPUT-ERROR", "SECTION", ".", "USE", "AFTER", "ERROR", 
        "PROCEDURE", "ON", "OUTPUT", ".", "REPORT-ERROR", ".", "DISPLAY", "\"Output error.\"", 
        ".", "END", "DECLARATIVES", ".", "DISPLAY", "33A", ".", "PARAGRAPH-33A", 
        ".", "DISPLAY", "33B", ".", "SECTION-33", "SECTION", ".", "DISPLAY", "33C", 
        ".", "PARAGRAPH-33B", ".", "DISPLAY", "33D", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(42, tokenizer.getNumberOfProcessedTokens());
    }
}