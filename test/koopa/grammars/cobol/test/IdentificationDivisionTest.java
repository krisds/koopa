package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class IdentificationDivisionTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testIdentificationDivision_1() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-01", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_2() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-01\"", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_3() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-01");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_4() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-02", "INITIAL", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_5() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-02\"", "INITIAL", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_6() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-02", "INITIAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_7() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-03", "COMMON", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_8() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-03\"", "COMMON", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_9() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-03", "COMMON");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(7, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_10() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-04", "INITIAL", "COMMON", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_11() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-04\"", "INITIAL", "COMMON", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_12() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-04", "INITIAL", "COMMON");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_13() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-05", "COMMON", "INITIAL", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_14() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-05\"", "COMMON", "INITIAL", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_15() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-05", "COMMON", "INITIAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_16() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-06", "IS", "INITIAL", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_17() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-06\"", "IS", "INITIAL", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_18() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-06", "IS", "INITIAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_19() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-07", "IS", "COMMON", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_20() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-07\"", "IS", "COMMON", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_21() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-07", "IS", "COMMON");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_22() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-08", "IS", "INITIAL", "COMMON", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_23() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-08\"", "IS", "INITIAL", "COMMON", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_24() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-08", "IS", "INITIAL", "COMMON");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_25() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-09", "IS", "COMMON", "INITIAL", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_26() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-09\"", "IS", "COMMON", "INITIAL", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_27() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-09", "IS", "COMMON", "INITIAL");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_28() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-10", "IS", "INITIAL", "PROGRAM", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_29() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-10\"", "IS", "INITIAL", "PROGRAM", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_30() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-10", "IS", "INITIAL", "PROGRAM");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_31() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-11", "IS", "COMMON", "PROGRAM", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_32() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-11\"", "IS", "COMMON", "PROGRAM", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_33() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-11", "IS", "COMMON", "PROGRAM");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_34() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-12", "IS", "INITIAL", "COMMON", "PROGRAM", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_35() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-12\"", "IS", "INITIAL", "COMMON", "PROGRAM", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_36() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-12", "IS", "INITIAL", "COMMON", "PROGRAM");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_37() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-13", "IS", "COMMON", "INITIAL", "PROGRAM", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_38() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-13\"", "IS", "COMMON", "INITIAL", "PROGRAM", 
        ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(11, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_39() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-13", "IS", "COMMON", "INITIAL", "PROGRAM");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_40() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-14", "INITIAL", "PROGRAM", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_41() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-14\"", "INITIAL", "PROGRAM", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_42() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-14", "INITIAL", "PROGRAM");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_43() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-15", "COMMON", "PROGRAM", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_44() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-15\"", "COMMON", "PROGRAM", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_45() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-15", "COMMON", "PROGRAM");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(8, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_46() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-16", "INITIAL", "COMMON", "PROGRAM", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_47() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-16\"", "INITIAL", "COMMON", "PROGRAM", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_48() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-16", "INITIAL", "COMMON", "PROGRAM");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_49() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-17", "COMMON", "INITIAL", "PROGRAM", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_50() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "\"TEST-17\"", "COMMON", "INITIAL", "PROGRAM", ".");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(10, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testIdentificationDivision_51() {
      Parser parser = grammar.identificationDivision();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("IDENTIFICATION", "DIVISION", 
        ".", "PROGRAM-ID", ".", "TEST-17", "COMMON", "INITIAL", "PROGRAM");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }
}