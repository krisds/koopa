package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parser;
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
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-01 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_2() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-01 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_3() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-01 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_4() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-01\" . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_5() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-01\" . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_6() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-01\" . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_7() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-01   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_8() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID   TEST-01   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_9() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID   TEST-01 . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_10() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-02   INITIAL . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_11() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-02\" INITIAL . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_12() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-02   INITIAL   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_13() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-02\" INITIAL   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_14() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-03   COMMON . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_15() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-03\" COMMON . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_16() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-03   COMMON   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_17() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-03\" COMMON   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_18() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-04   INITIAL COMMON . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_19() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-04\" INITIAL COMMON . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_20() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-04   INITIAL COMMON   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_21() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-04\" INITIAL COMMON   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_22() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-05   COMMON INITIAL . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_23() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-05\" COMMON INITIAL . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_24() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-05   COMMON INITIAL   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_25() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-05\" COMMON INITIAL   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_26() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-06   IS INITIAL . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_27() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-06\" IS INITIAL . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_28() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-06   IS INITIAL   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_29() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-06\" IS INITIAL   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_30() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-07   IS COMMON . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_31() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-07\" IS COMMON . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_32() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-07   IS COMMON   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_33() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-07\" IS COMMON   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_34() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-08   IS INITIAL COMMON . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_35() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-08\" IS INITIAL COMMON . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_36() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-08   IS INITIAL COMMON   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_37() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-08\" IS INITIAL COMMON   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_38() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-09   IS COMMON INITIAL . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_39() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-09\" IS COMMON INITIAL . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_40() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-09   IS COMMON INITIAL   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_41() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-09\" IS COMMON INITIAL   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_42() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-10   IS INITIAL PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_43() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-10\" IS INITIAL PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_44() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-10   IS INITIAL PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_45() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-10\" IS INITIAL PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_46() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-11   IS COMMON PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_47() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-11\" IS COMMON PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_48() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-11   IS COMMON PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_49() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-11\" IS COMMON PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_50() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-12   IS INITIAL COMMON PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_51() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-12\" IS INITIAL COMMON PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_52() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-12   IS INITIAL COMMON PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_53() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-12\" IS INITIAL COMMON PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_54() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-13   IS COMMON INITIAL PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_55() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-13\" IS COMMON INITIAL PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_56() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-13   IS COMMON INITIAL PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_57() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-13\" IS COMMON INITIAL PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_58() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-14   INITIAL PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_59() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-14\" INITIAL PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_60() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-14   INITIAL PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_61() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-14\" INITIAL PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_62() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-15   COMMON PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_63() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-15\" COMMON PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_64() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-15   COMMON PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_65() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-15\" COMMON PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_66() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-16   INITIAL COMMON PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_67() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-16\" INITIAL COMMON PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_68() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-16   INITIAL COMMON PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_69() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-16\" INITIAL COMMON PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_70() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-17   COMMON INITIAL PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_71() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-17\" COMMON INITIAL PROGRAM . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_72() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . TEST-17   COMMON INITIAL PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testProgramIdParagraph_73() {
      Parser parser = grammar.programIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" PROGRAM-ID . \"TEST-17\" COMMON INITIAL PROGRAM   "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_74() {
      Parser parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_75() {
      Parser parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo  AS \"bar\" . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_76() {
      Parser parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo INHERITS FROM bar . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_77() {
      Parser parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo INHERITS FROM bar baz . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_78() {
      Parser parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo INHERITS FROM bar IS STATIC FINAL PUBLIC . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_79() {
      Parser parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo PUBLIC IMPLEMENTS bar baz . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_80() {
      Parser parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo PUBLIC\n   ATTRIBUTE bar (b1 NAME b2 = v2 NAME b3 = v3 b4)\n   IMPLEMENTS baz . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_81() {
      Parser parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo PUBLIC\n   ATTRIBUTE bar ()\n   IMPLEMENTS baz . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_82() {
      Parser parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo PUBLIC\n   ATTRIBUTE bar (b1)\n   IMPLEMENTS baz . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_83() {
      Parser parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo PUBLIC\n   ATTRIBUTE bar (b1 b2)\n   IMPLEMENTS baz . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_84() {
      Parser parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo PUBLIC\n   ATTRIBUTE bar (b1 b2)\n   ATTRIBUTE baz (b3)\n   IMPLEMENTS boojum . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_85() {
      Parser parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo\n   ATTRIBUTE bar (NAME snark = \"boojum\")\n   IMPLEMENTS baz . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testClassIdParagraph_86() {
      Parser parser = grammar.classIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" CLASS-ID . foo\n   CUSTOM-ATTRIBUTE IS bar (snark = \"boojum\")\n   IMPLEMENTS baz . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMethodIdParagraph_87() {
      Parser parser = grammar.methodIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" METHOD-ID . foo . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMethodIdParagraph_88() {
      Parser parser = grammar.methodIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" METHOD-ID . foo  AS \"bar\" . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testMethodIdParagraph_89() {
      Parser parser = grammar.methodIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" METHOD-ID . GET PROPERTY foo . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFactoryParagraph_90() {
      Parser parser = grammar.factoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FACTORY . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFactoryParagraph_91() {
      Parser parser = grammar.factoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FACTORY . IMPLEMENTS foo . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFactoryParagraph_92() {
      Parser parser = grammar.factoryParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FACTORY . IMPLEMENTS foo bar . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFunctionIdParagraph_93() {
      Parser parser = grammar.functionIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION-ID . foo "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFunctionPrototypeIdParagraph_94() {
      Parser parser = grammar.functionPrototypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION-ID . foo AS \"bar\" PROTOTYPE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFunctionPrototypeIdParagraph_95() {
      Parser parser = grammar.functionPrototypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION-ID . foo PROTOTYPE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testFunctionPrototypeIdParagraph_96() {
      Parser parser = grammar.functionPrototypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FUNCTION-ID . foo IS PROTOTYPE "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDelegateIdParagraph_97() {
      Parser parser = grammar.delegateIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELEGATE-ID . foo . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testDelegateIdParagraph_98() {
      Parser parser = grammar.delegateIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" DELEGATE-ID . foo IS PROTECTED . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnumIdParagraph_99() {
      Parser parser = grammar.enumIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENUM-ID . foo . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnumIdParagraph_100() {
      Parser parser = grammar.enumIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENUM-ID . foo IS PUBLIC . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnumIdParagraph_101() {
      Parser parser = grammar.enumIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENUM-ID . foo IS PRIVATE . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnumIdParagraph_102() {
      Parser parser = grammar.enumIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENUM-ID . foo IS PROTECTED . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testEnumIdParagraph_103() {
      Parser parser = grammar.enumIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ENUM-ID . foo IS INTERNAL . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIteratorIdParagraph_104() {
      Parser parser = grammar.iteratorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ITERATOR-ID . foo . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIteratorIdParagraph_105() {
      Parser parser = grammar.iteratorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ITERATOR-ID . foo AS \"baz\" . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testIteratorIdParagraph_106() {
      Parser parser = grammar.iteratorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ITERATOR-ID . foo AS \"baz\" PUBLIC . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_107() {
      Parser parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . = . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_108() {
      Parser parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . = EXTENSION . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_109() {
      Parser parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . <> . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_110() {
      Parser parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . + . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_111() {
      Parser parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . - . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_112() {
      Parser parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . * . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_113() {
      Parser parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . / . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_114() {
      Parser parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . B-AND . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_115() {
      Parser parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . B-XOR . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_116() {
      Parser parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . B-NOT . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_117() {
      Parser parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . IMPLICIT . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testOperatorIdParagraph_118() {
      Parser parser = grammar.operatorIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" OPERATOR-ID . EXPLICIT . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueTypeIdParagraph_119() {
      Parser parser = grammar.valueTypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUETYPE-ID . foo . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueTypeIdParagraph_120() {
      Parser parser = grammar.valueTypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUETYPE-ID . foo PARTIAL . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueTypeIdParagraph_121() {
      Parser parser = grammar.valueTypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUETYPE-ID . foo IMPLEMENTS bar . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueTypeIdParagraph_122() {
      Parser parser = grammar.valueTypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUETYPE-ID . foo\n   ATTRIBUTE bar (b1 b2)\n   IMPLEMENTS baz . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testValueTypeIdParagraph_123() {
      Parser parser = grammar.valueTypeIdParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" VALUETYPE-ID . foo\n   ATTRIBUTE bar (b1 b2)\n   ATTRIBUTE baz ()\n   IMPLEMENTS boojum . "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}