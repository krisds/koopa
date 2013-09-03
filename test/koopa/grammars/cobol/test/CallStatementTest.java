package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from CallStatement.stage. */
public class CallStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testCallStatement_1() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_2() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL \"MY-SERVICE\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_3() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL 42 ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_4() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL 42.42 ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_5() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING MY-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_6() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING \"MY-DATA\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_7() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING MY-DATA MY-OTHER-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_8() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING \"MY-DATA\" MY-OTHER-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_9() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY REFERENCE MY-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_10() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY REFERENCE \"MY-DATA\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_11() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY REFERENCE OMITTED ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_12() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY REFERENCE MY-DATA MY-OTHER-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_13() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY REFERENCE \"MY-DATA\" MY-OTHER-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_14() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING REFERENCE MY-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_15() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING REFERENCE MY-DATA MY-OTHER-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_16() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING REFERENCE \"MY-DATA\" MY-OTHER-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_17() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY CONTENT MY-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_18() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY CONTENT LENGTH OF MY-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_19() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY CONTENT \"DATA\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_20() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY CONTENT 1234 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_21() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY CONTENT 1234.567 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_22() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY CONTENT MY-DATA MY-OTHER-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_23() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING CONTENT MY-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_24() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING CONTENT LENGTH OF MY-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_25() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING CONTENT \"DATA\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_26() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING CONTENT 1234 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_27() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING CONTENT 1234.567 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_28() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING CONTENT MY-DATA MY-OTHER-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_29() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY VALUE MY-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_30() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY VALUE LENGTH OF MY-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_31() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY VALUE \"DATA\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_32() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY VALUE 1234 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_33() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY VALUE 1234.567 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_34() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING BY VALUE MY-DATA MY-OTHER-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_35() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING VALUE MY-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_36() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING VALUE LENGTH OF MY-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_37() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING VALUE \"DATA\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_38() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING VALUE 1234 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_39() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING VALUE 1234.567 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_40() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING VALUE MY-DATA MY-OTHER-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_41() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE GIVING A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_42() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE GIVING ADDRESS OF A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_43() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE GIVING INTO A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_44() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE RETURNING A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_45() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE RETURNING ADDRESS OF A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_46() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE RETURNING INTO A ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_47() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE GIVING NULL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_48() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING\n     BY REFERENCE MY-REFERENCED-DATA\n     BY CONTENT MY-CONTENT-DATA\n     BY VALUE MY-VALUE-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_49() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING\n     BY CONTENT MY-CONTENT-DATA\n     BY VALUE MY-VALUE-DATA\n     BY REFERENCE MY-REFERENCED-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_50() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING\n     REFERENCE MY-REFERENCED-DATA\n     BY VALUE MY-VALUE-DATA\n     CONTENT MY-CONTENT-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_51() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING\n     CONTENT MY-CONTENT-DATA\n     VALUE MY-VALUE-DATA\n     REFERENCE MY-REFERENCED-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_52() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING\n     MY-REFERENCED-DATA\n     BY VALUE MY-VALUE-DATA\n     BY CONTENT MY-CONTENT-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_53() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING\n     BY REFERENCE MY-REFERENCED-DATA\n     BY CONTENT MY-CONTENT-DATA\n     BY VALUE MY-VALUE-DATA\n     BY REFERENCE MY-OTHER-REFERENCED-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_54() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING\n     BY CONTENT MY-CONTENT-DATA\n     BY REFERENCE MY-REFERENCED-DATA\n     BY CONTENT MY-OTHER-CONTENT-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_55() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING\n     BY REFERENCE MY-REFERENCED-DATA\n     BY CONTENT MY-CONTENT-DATA\n     BY REFERENCE MY-OTHER-REFERENCED-DATA\n     BY CONTENT MY-OTHER-CONTENT-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_56() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING\n     BY CONTENT MY-CONTENT-DATA\n     BY REFERENCE MY-REFERENCED-DATA\n     BY CONTENT MY-OTHER-CONTENT-DATA\n     BY REFERENCE MY-OTHER-REFERENCED-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_57() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING\n     MY-REFERENCED-DATA\n     BY CONTENT MY-CONTENT-DATA\n     BY REFERENCE MY-OTHER-REFERENCED-DATA\n     BY CONTENT MY-OTHER-CONTENT-DATA ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_58() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE\n     ON OVERFLOW\n        DISPLAY \"SERVICE OVERFLOW\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_59() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE\n     OVERFLOW\n        DISPLAY \"SERVICE OVERFLOW\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_60() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE\n     ON EXCEPTION\n        DISPLAY \"SERVICE EXCEPTION\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_61() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE\n     EXCEPTION\n        DISPLAY \"SERVICE EXCEPTION\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_62() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE\n     NOT ON EXCEPTION\n        DISPLAY \"NO SERVICE EXCEPTION\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_63() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE\n     NOT EXCEPTION\n        DISPLAY \"NO SERVICE EXCEPTION\" ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_64() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE\n     ON EXCEPTION\n        DISPLAY \"SERVICE EXCEPTION\"\n     ON OVERFLOW\n        DISPLAY \"SERVICE OVERFLOW\" ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_65() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE\n     NOT ON EXCEPTION\n        DISPLAY \"SERVICE EXCEPTION\"\n     ON OVERFLOW\n        DISPLAY \"SERVICE OVERFLOW\" ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_66() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE END-CALL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_67() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE USING MY-DATA END-CALL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_68() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL MY-SERVICE\n 	 ON EXCEPTION\n		DISPLAY \"SERVICE EXCEPTION\"\n   END-CALL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_69() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL 'sub'\n      USING '123'\n            OMITTED\n            OMITTED\n            '456'\n    END-CALL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_70() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL foo 'bar' ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_71() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL foo 'bar' USING baz ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_72() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL foo AS bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_73() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL 'sub' AS bar ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_74() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL NESTED ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_75() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL NESTED ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_76() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL 'sub' AS NESTED ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_77() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL 'sub' AS NESTED USING CONTENT foo + 1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_78() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL 'sub' AS NESTED USING VALUE foo + 1 ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_79() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL x\"AF\" USING set-bit-pairs user-key-control ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_80() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL nx\"AF\" USING set-bit-pairs user-key-control ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_81() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL h\"AF\" USING set-bit-pairs user-key-control ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_82() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL 'sub' AS NESTED USING foo + 1 ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_83() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL 'sub' AS NESTED USING REFERENCE foo + 1 ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_84() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL foo \"bar\"\n     USING BY REFERENCE bar-name\n           BY REFERENCE bar-handle\n           BY VALUE     0 SIZE 4\n     RETURNING bar-status\n   END-CALL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_85() {
      Parser parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " CALL foo \"bar\"\n     USING BY VALUE bar-handle\n           BY REFERENCE baz\n           BY VALUE LENGTH OF baz SIZE 4\n     RETURNING ret\n   END-CALL ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}