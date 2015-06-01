package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from CallStatement.stage. */
public class CallStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testCallStatement_1() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_2() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL \"MY-SERVICE\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_3() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL 42 "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_4() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL 42.42 "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_5() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING MY-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_6() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING \"MY-DATA\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_7() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING MY-DATA MY-OTHER-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_8() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING \"MY-DATA\" MY-OTHER-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_9() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY REFERENCE MY-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_10() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY REFERENCE \"MY-DATA\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_11() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY REFERENCE OMITTED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_12() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY REFERENCE MY-DATA MY-OTHER-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_13() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY REFERENCE \"MY-DATA\" MY-OTHER-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_14() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING REFERENCE MY-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_15() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING REFERENCE MY-DATA MY-OTHER-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_16() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING REFERENCE \"MY-DATA\" MY-OTHER-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_17() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY CONTENT MY-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_18() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY CONTENT LENGTH OF MY-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_19() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY CONTENT \"DATA\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_20() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY CONTENT 1234 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_21() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY CONTENT 1234.567 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_22() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY CONTENT MY-DATA MY-OTHER-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_23() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING CONTENT MY-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_24() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING CONTENT LENGTH OF MY-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_25() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING CONTENT \"DATA\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_26() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING CONTENT 1234 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_27() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING CONTENT 1234.567 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_28() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING CONTENT MY-DATA MY-OTHER-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_29() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY VALUE MY-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_30() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY VALUE LENGTH OF MY-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_31() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY VALUE \"DATA\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_32() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY VALUE 1234 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_33() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY VALUE 1234.567 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_34() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING BY VALUE MY-DATA MY-OTHER-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_35() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING VALUE MY-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_36() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING VALUE LENGTH OF MY-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_37() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING VALUE \"DATA\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_38() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING VALUE 1234 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_39() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING VALUE 1234.567 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_40() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING VALUE MY-DATA MY-OTHER-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_41() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE GIVING A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_42() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE GIVING ADDRESS OF A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_43() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE GIVING INTO A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_44() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE RETURNING A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_45() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE RETURNING ADDRESS OF A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_46() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE RETURNING INTO A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_47() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE GIVING NULL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_48() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING\n     BY REFERENCE MY-REFERENCED-DATA\n     BY CONTENT MY-CONTENT-DATA\n     BY VALUE MY-VALUE-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_49() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING\n     BY CONTENT MY-CONTENT-DATA\n     BY VALUE MY-VALUE-DATA\n     BY REFERENCE MY-REFERENCED-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_50() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING\n     REFERENCE MY-REFERENCED-DATA\n     BY VALUE MY-VALUE-DATA\n     CONTENT MY-CONTENT-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_51() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING\n     CONTENT MY-CONTENT-DATA\n     VALUE MY-VALUE-DATA\n     REFERENCE MY-REFERENCED-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_52() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING\n     MY-REFERENCED-DATA\n     BY VALUE MY-VALUE-DATA\n     BY CONTENT MY-CONTENT-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_53() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING\n     BY REFERENCE MY-REFERENCED-DATA\n     BY CONTENT MY-CONTENT-DATA\n     BY VALUE MY-VALUE-DATA\n     BY REFERENCE MY-OTHER-REFERENCED-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_54() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING\n     BY CONTENT MY-CONTENT-DATA\n     BY REFERENCE MY-REFERENCED-DATA\n     BY CONTENT MY-OTHER-CONTENT-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_55() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING\n     BY REFERENCE MY-REFERENCED-DATA\n     BY CONTENT MY-CONTENT-DATA\n     BY REFERENCE MY-OTHER-REFERENCED-DATA\n     BY CONTENT MY-OTHER-CONTENT-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_56() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING\n     BY CONTENT MY-CONTENT-DATA\n     BY REFERENCE MY-REFERENCED-DATA\n     BY CONTENT MY-OTHER-CONTENT-DATA\n     BY REFERENCE MY-OTHER-REFERENCED-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_57() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING\n     MY-REFERENCED-DATA\n     BY CONTENT MY-CONTENT-DATA\n     BY REFERENCE MY-OTHER-REFERENCED-DATA\n     BY CONTENT MY-OTHER-CONTENT-DATA "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_58() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE\n     ON OVERFLOW\n        DISPLAY \"SERVICE OVERFLOW\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_59() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE\n     OVERFLOW\n        DISPLAY \"SERVICE OVERFLOW\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_60() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE\n     ON EXCEPTION\n        DISPLAY \"SERVICE EXCEPTION\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_61() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE\n     EXCEPTION\n        DISPLAY \"SERVICE EXCEPTION\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_62() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE\n     NOT ON EXCEPTION\n        DISPLAY \"NO SERVICE EXCEPTION\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_63() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE\n     NOT EXCEPTION\n        DISPLAY \"NO SERVICE EXCEPTION\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_64() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE\n     ON EXCEPTION\n        DISPLAY \"SERVICE EXCEPTION\"\n     ON OVERFLOW\n        DISPLAY \"SERVICE OVERFLOW\" "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_65() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE\n     NOT ON EXCEPTION\n        DISPLAY \"SERVICE EXCEPTION\"\n     ON OVERFLOW\n        DISPLAY \"SERVICE OVERFLOW\" "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_66() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE END-CALL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_67() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE USING MY-DATA END-CALL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_68() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL MY-SERVICE\n 	 ON EXCEPTION\n		DISPLAY \"SERVICE EXCEPTION\"\n   END-CALL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_69() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL 'sub'\n      USING '123'\n            OMITTED\n            OMITTED\n            '456'\n    END-CALL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_70() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL foo 'bar' "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_71() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL foo 'bar' USING baz "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_72() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL foo AS bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_73() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL 'sub' AS bar "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_74() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL NESTED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_75() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL NESTED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_76() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL 'sub' AS NESTED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_77() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL 'sub' AS NESTED USING CONTENT foo + 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_78() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL 'sub' AS NESTED USING VALUE foo + 1 "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_79() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL x\"AF\" USING set-bit-pairs user-key-control "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_80() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL nx\"AF\" USING set-bit-pairs user-key-control "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_81() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL h\"AF\" USING set-bit-pairs user-key-control "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_82() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL 'sub' AS NESTED USING foo + 1 "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_83() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL 'sub' AS NESTED USING REFERENCE foo + 1 "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_84() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL foo \"bar\"\n     USING BY REFERENCE bar-name\n           BY REFERENCE bar-handle\n           BY VALUE     0 SIZE 4\n     RETURNING bar-status\n   END-CALL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testCallStatement_85() {
      ParserCombinator parser = grammar.callStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CALL foo \"bar\"\n     USING BY VALUE bar-handle\n           BY REFERENCE baz\n           BY VALUE LENGTH OF baz SIZE 4\n     RETURNING ret\n   END-CALL "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}