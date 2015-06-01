package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from IdentificationDivision.stage. */
public class IdentificationDivisionTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testProgramIdParagraph_1() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-01 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_2() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-01 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_3() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-01 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_4() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-01\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_5() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-01\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_6() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-01\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_7() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-01   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_8() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID   TEST-01   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_9() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID   TEST-01 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_10() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-02   INITIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_11() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-02\" INITIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_12() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-02   INITIAL   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_13() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-02\" INITIAL   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_14() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-03   COMMON . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_15() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-03\" COMMON . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_16() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-03   COMMON   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_17() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-03\" COMMON   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_18() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-04   INITIAL COMMON . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_19() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-04\" INITIAL COMMON . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_20() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-04   INITIAL COMMON   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_21() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-04\" INITIAL COMMON   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_22() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-05   COMMON INITIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_23() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-05\" COMMON INITIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_24() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-05   COMMON INITIAL   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_25() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-05\" COMMON INITIAL   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_26() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-06   IS INITIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_27() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-06\" IS INITIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_28() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-06   IS INITIAL   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_29() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-06\" IS INITIAL   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_30() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-07   IS COMMON . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_31() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-07\" IS COMMON . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_32() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-07   IS COMMON   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_33() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-07\" IS COMMON   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_34() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-08   IS INITIAL COMMON . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_35() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-08\" IS INITIAL COMMON . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_36() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-08   IS INITIAL COMMON   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_37() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-08\" IS INITIAL COMMON   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_38() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-09   IS COMMON INITIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_39() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-09\" IS COMMON INITIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_40() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-09   IS COMMON INITIAL   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_41() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-09\" IS COMMON INITIAL   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_42() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-10   IS INITIAL PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_43() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-10\" IS INITIAL PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_44() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-10   IS INITIAL PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_45() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-10\" IS INITIAL PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_46() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-11   IS COMMON PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_47() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-11\" IS COMMON PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_48() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-11   IS COMMON PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_49() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-11\" IS COMMON PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_50() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-12   IS INITIAL COMMON PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_51() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-12\" IS INITIAL COMMON PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_52() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-12   IS INITIAL COMMON PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_53() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-12\" IS INITIAL COMMON PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_54() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-13   IS COMMON INITIAL PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_55() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-13\" IS COMMON INITIAL PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_56() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-13   IS COMMON INITIAL PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_57() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-13\" IS COMMON INITIAL PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_58() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-14   INITIAL PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_59() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-14\" INITIAL PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_60() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-14   INITIAL PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_61() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-14\" INITIAL PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_62() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-15   COMMON PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_63() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-15\" COMMON PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_64() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-15   COMMON PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_65() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-15\" COMMON PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_66() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-16   INITIAL COMMON PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_67() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-16\" INITIAL COMMON PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_68() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-16   INITIAL COMMON PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_69() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-16\" INITIAL COMMON PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_70() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-17   COMMON INITIAL PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_71() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-17\" COMMON INITIAL PROGRAM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_72() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-17   COMMON INITIAL PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_73() {
      ParserCombinator parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-17\" COMMON INITIAL PROGRAM   "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_74() {
      ParserCombinator parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_75() {
      ParserCombinator parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo  AS \"bar\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_76() {
      ParserCombinator parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo INHERITS FROM bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_77() {
      ParserCombinator parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo INHERITS FROM bar baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_78() {
      ParserCombinator parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo INHERITS FROM bar IS STATIC FINAL PUBLIC . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_79() {
      ParserCombinator parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo PUBLIC IMPLEMENTS bar baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_80() {
      ParserCombinator parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo PUBLIC\n   ATTRIBUTE bar (b1 NAME b2 = v2 NAME b3 = v3 b4)\n   IMPLEMENTS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_81() {
      ParserCombinator parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo PUBLIC\n   ATTRIBUTE bar ()\n   IMPLEMENTS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_82() {
      ParserCombinator parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo PUBLIC\n   ATTRIBUTE bar (b1)\n   IMPLEMENTS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_83() {
      ParserCombinator parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo PUBLIC\n   ATTRIBUTE bar (b1 b2)\n   IMPLEMENTS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_84() {
      ParserCombinator parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo PUBLIC\n   ATTRIBUTE bar (b1 b2)\n   ATTRIBUTE baz (b3)\n   IMPLEMENTS boojum . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_85() {
      ParserCombinator parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo\n   ATTRIBUTE bar (NAME snark = \"boojum\")\n   IMPLEMENTS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_86() {
      ParserCombinator parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo\n   CUSTOM-ATTRIBUTE IS bar (snark = \"boojum\")\n   IMPLEMENTS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMethodIdParagraph_87() {
      ParserCombinator parser = grammar.methodIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" METHOD-ID . foo . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMethodIdParagraph_88() {
      ParserCombinator parser = grammar.methodIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" METHOD-ID . foo  AS \"bar\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMethodIdParagraph_89() {
      ParserCombinator parser = grammar.methodIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" METHOD-ID . GET PROPERTY foo . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFactoryParagraph_90() {
      ParserCombinator parser = grammar.factoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FACTORY . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFactoryParagraph_91() {
      ParserCombinator parser = grammar.factoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FACTORY . IMPLEMENTS foo . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFactoryParagraph_92() {
      ParserCombinator parser = grammar.factoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FACTORY . IMPLEMENTS foo bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFunctionIdParagraph_93() {
      ParserCombinator parser = grammar.functionIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION-ID . foo "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFunctionPrototypeIdParagraph_94() {
      ParserCombinator parser = grammar.functionPrototypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION-ID . foo AS \"bar\" PROTOTYPE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFunctionPrototypeIdParagraph_95() {
      ParserCombinator parser = grammar.functionPrototypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION-ID . foo PROTOTYPE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFunctionPrototypeIdParagraph_96() {
      ParserCombinator parser = grammar.functionPrototypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION-ID . foo IS PROTOTYPE "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDelegateIdParagraph_97() {
      ParserCombinator parser = grammar.delegateIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELEGATE-ID . foo . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDelegateIdParagraph_98() {
      ParserCombinator parser = grammar.delegateIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELEGATE-ID . foo IS PROTECTED . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnumIdParagraph_99() {
      ParserCombinator parser = grammar.enumIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENUM-ID . foo . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnumIdParagraph_100() {
      ParserCombinator parser = grammar.enumIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENUM-ID . foo IS PUBLIC . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnumIdParagraph_101() {
      ParserCombinator parser = grammar.enumIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENUM-ID . foo IS PRIVATE . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnumIdParagraph_102() {
      ParserCombinator parser = grammar.enumIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENUM-ID . foo IS PROTECTED . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnumIdParagraph_103() {
      ParserCombinator parser = grammar.enumIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENUM-ID . foo IS INTERNAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIteratorIdParagraph_104() {
      ParserCombinator parser = grammar.iteratorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ITERATOR-ID . foo . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIteratorIdParagraph_105() {
      ParserCombinator parser = grammar.iteratorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ITERATOR-ID . foo AS \"baz\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIteratorIdParagraph_106() {
      ParserCombinator parser = grammar.iteratorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ITERATOR-ID . foo AS \"baz\" PUBLIC . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_107() {
      ParserCombinator parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . = . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_108() {
      ParserCombinator parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . = EXTENSION . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_109() {
      ParserCombinator parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . <> . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_110() {
      ParserCombinator parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . + . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_111() {
      ParserCombinator parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . - . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_112() {
      ParserCombinator parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . * . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_113() {
      ParserCombinator parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . / . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_114() {
      ParserCombinator parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . B-AND . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_115() {
      ParserCombinator parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . B-XOR . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_116() {
      ParserCombinator parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . B-NOT . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_117() {
      ParserCombinator parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . IMPLICIT . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_118() {
      ParserCombinator parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . EXPLICIT . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueTypeIdParagraph_119() {
      ParserCombinator parser = grammar.valueTypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUETYPE-ID . foo . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueTypeIdParagraph_120() {
      ParserCombinator parser = grammar.valueTypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUETYPE-ID . foo PARTIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueTypeIdParagraph_121() {
      ParserCombinator parser = grammar.valueTypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUETYPE-ID . foo IMPLEMENTS bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueTypeIdParagraph_122() {
      ParserCombinator parser = grammar.valueTypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUETYPE-ID . foo\n   ATTRIBUTE bar (b1 b2)\n   IMPLEMENTS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueTypeIdParagraph_123() {
      ParserCombinator parser = grammar.valueTypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUETYPE-ID . foo\n   ATTRIBUTE bar (b1 b2)\n   ATTRIBUTE baz ()\n   IMPLEMENTS boojum . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}