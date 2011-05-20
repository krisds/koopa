package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from EvaluateStatement.stage. */
public class EvaluateStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testObject_1() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("ANY");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_2() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TRUE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_3() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("FALSE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_4() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-IDENTIFIER");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_5() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("\"A literal.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_6() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("1234567");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_7() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("123.456");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_8() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("NOT MY-IDENTIFIER");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_9() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("NOT \"A literal.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_10() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("NOT 1234567");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_11() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("NOT 123.456");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_12() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-IDENTIFIER THROUGH ANOTHER-IDENTIFIER");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_13() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("\"A literal.\" THROUGH \"Another literal.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_14() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("1234567 THROUGH 7654321");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_15() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("123.456 THROUGH 654.321");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_16() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("NOT MY-IDENTIFIER THROUGH ANOTHER-IDENTIFIER");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_17() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("NOT \"A literal.\" THROUGH \"Another literal.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_18() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("NOT 1234567 THROUGH 7654321");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_19() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("NOT 123.456 THROUGH 654.321");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_20() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("MY-IDENTIFIER THRU ANOTHER-IDENTIFIER");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_21() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("\"A literal.\" THRU \"Another literal.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_22() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("1234567 THRU 7654321");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_23() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("123.456 THRU 654.321");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_24() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("NOT MY-IDENTIFIER THRU ANOTHER-IDENTIFIER");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_25() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("NOT \"A literal.\" THRU \"Another literal.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_26() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("NOT 1234567 THRU 7654321");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testObject_27() {
      Parser parser = grammar.object();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("NOT 123.456 THRU 654.321");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWhenOther_28() {
      Parser parser = grammar.whenOther();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WHEN OTHER");
      assertFalse(parser.accepts(tokenizer));
    }

    @Test
    public void testWhenOther_29() {
      Parser parser = grammar.whenOther();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WHEN OTHER\n        DISPLAY \"Other.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWhenOther_30() {
      Parser parser = grammar.whenOther();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WHEN OTHER\n        DISPLAY \"Other.\"\n        DISPLAY \"More.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWhen_31() {
      Parser parser = grammar.when();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WHEN ANY\n        DISPLAY \"Good.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWhen_32() {
      Parser parser = grammar.when();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WHEN TRUE ALSO ANY\n        DISPLAY \"Good.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWhen_33() {
      Parser parser = grammar.when();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WHEN TRUE ALSO ANY ALSO 42\n        DISPLAY \"Good.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testWhen_34() {
      Parser parser = grammar.when();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("WHEN ANY\n   WHEN TRUE ALSO ANY\n   WHEN TRUE ALSO ANY ALSO 42\n        DISPLAY \"Good.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEvaluateStatement_35() {
      Parser parser = grammar.evaluateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EVALUATE FOO\n   WHEN 42\n        DISPLAY \"Meaning of life, the universe and everything.\"\n   END-EVALUATE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEvaluateStatement_36() {
      Parser parser = grammar.evaluateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EVALUATE FOO\n   WHEN 42\n        DISPLAY \"Meaning of life, the universe and everything.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEvaluateStatement_37() {
      Parser parser = grammar.evaluateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EVALUATE FOO\n   WHEN 42\n        DISPLAY \"Meaning of life, the universe and everything.\"\n   WHEN OTHER\n        DISPLAY \"Nothing special.\"\n   END-EVALUATE");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEvaluateStatement_38() {
      Parser parser = grammar.evaluateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EVALUATE TRUE\n   WHEN PROCESSING < 100\n        DISPLAY \"Keep going.\"\n   WHEN OTHER\n        DISPLAY \"Done.\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEvaluateStatement_39() {
      Parser parser = grammar.evaluateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EVALUATE FUNCTION LENGTH ( \"ABCDEFGHIJKLMNOPQRST\" )\n   WHEN 20\n        DISPLAY \"OK\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEvaluateStatement_40() {
      Parser parser = grammar.evaluateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("EVALUATE WRK-XN-00001-1 NUMERIC\n   WHEN TRUE\n        DISPLAY \"OK\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}