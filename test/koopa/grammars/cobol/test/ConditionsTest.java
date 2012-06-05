package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from Conditions.stage. */
public class ConditionsTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testCondition_1() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " 1 < 2 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_2() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " 1 < 2 OR 2 > 1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_3() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " 1 < 2 AND 2 > 1 AND V-ARIABLE = 0 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_4() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " V-ARIABLE = 2 OR = 3 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_5() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ( V-ARIABLE = 2 OR = 3 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_6() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " V-ARIABLE NOT = 3 AND ( V-ARIABLE = 2 OR = 3 ) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_7() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " B GREATER THAN C OR EQUAL TO A OR 42 OR C - 1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_8() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " B GREATER THAN C OR EQUAL TO A OR 42 OR (C - 1) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_9() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ZERO - A IS NEGATIVE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_10() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SMALLEST-VALU GREATER THAN SMALL-VALU AND IS NOT LESS THAN EVEN-SMALLER OR SMALLER-VALU ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_11() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " WRK-XN-00001 = \"0\" OR \"1\" OR \"2\" OR IF-TABLE OR \"3\"  ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_12() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " 1 + (TWO * 3) EQUAL TO (TWO * 3) + 1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_13() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " ((NAUGHT EQUAL TO ONE) OR (NOT ((UNO = ONE) OR (TWO = DOS)))) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_14() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " NOT TWO > THREE AND NOT (ON-WRK-SWITCH-1 AND F OR CLASS-1 ALPHABETIC) OR TWO = THREE AND SIGN-1 ZERO ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_15() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " NOT TWO > THREE AND NOT (ON-WRK-SWITCH-1 AND F OR CLASS-1 ALPHABETIC) ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_16() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " NOT TWO > THREE AND NOT (ON-WRK-SWITCH-1 AND F) OR TWO = THREE AND SIGN-1 ZERO ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_17() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " NOT TWO > THREE OR TWO = THREE AND SIGN-1 ZERO ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_18() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " NOT TWO > THREE OR TWO = THREE AND SIGN-1 NUMERIC ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_19() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SIGN-1 ZERO AND NOT TWO > THREE OR TWO = THREE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCondition_20() {
      Parser parser = grammar.condition();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " PARA-FINIC-IVA IS NUMERIC AND PARA-FINIC-IVA NOT = ZEROES AND PARA-FINIC-IVA > W-FECHAH AND PARA-REGANT-IVA IS NUMERIC AND PARA-REGANT-IVA NOT = ZEROES ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}