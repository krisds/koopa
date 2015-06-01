package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from FileControlParagraph.stage. */
public class FileControlParagraphTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testFileControlParagraph_1() {
      ParserCombinator parser = grammar.fileControlParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" FILE-CONTROL .\n     SELECT foo ASSIGN 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_2() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_3() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT OPTIONAL foo ASSIGN 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_4() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT NOT OPTIONAL foo ASSIGN 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_5() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT NOT foo ASSIGN 'bar.dat' . "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_6() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_7() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO EXTERNAL 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_8() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO DYNAMIC 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_9() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO DISK FROM bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_10() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO DISK FILE 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_11() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO FILE 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_12() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO DISK . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_13() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO DISK DISPLAY . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_14() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO DISK 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_15() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO DISK 'bar.dat' 'baz.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_16() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO LINE ADVANCING 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_17() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO LINE ADVANCING FILE 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_18() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO REEL 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_19() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO REEL FILE 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_20() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO MULTIPLE REEL 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_21() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO MULTIPLE REEL FILE 'bar.dat' 'baz.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_22() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO UNIT 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_23() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO UNIT FILE 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_24() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO MULTIPLE UNIT 'bar.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_25() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO MULTIPLE UNIT FILE 'bar.dat' 'baz.dat' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_26() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO KEYBOARD . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_27() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO KEYBOARD bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_28() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO DISPLAY . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_29() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO DISPLAY bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_30() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO PRINTER . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_31() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO PRINTER DISPLAY . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_32() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO PRINTER bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_33() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO PRINTER-1 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_34() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO PRINTER-1 bar . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_35() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO 'bar.dat' RESERVE 1 AREA . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_36() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO 'bar.dat' RESERVE 2 AREAS . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_37() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO 'bar.dat' RESERVE NO AREAS . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_38() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO 'bar.dat' RESERVE 2 ALTERNATE AREAS . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_39() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN TO 'bar.dat' RESERVE NO ALTERNATE AREAS . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_40() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SEQUENTIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_41() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' ORGANIZATION SEQUENTIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_42() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' ORGANIZATION IS SEQUENTIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_43() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' ORGANIZATION IS LINE SEQUENTIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_44() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' ORGANIZATION IS RECORD SEQUENTIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_45() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' ORGANIZATION IS RECORD BINARY SEQUENTIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_46() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SEQUENTIAL ACCESS SEQUENTIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_47() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SEQUENTIAL ACCESS IS SEQUENTIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_48() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SEQUENTIAL ACCESS MODE SEQUENTIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_49() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SEQUENTIAL PADDING '0' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_50() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SEQUENTIAL PADDING IS '0' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_51() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SEQUENTIAL PADDING CHARACTER '0' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_52() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SEQUENTIAL PADDING CHARACTER IS '0' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_53() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SEQUENTIAL PADDING CHARACTER IS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_54() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' RELATIVE . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_55() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' ORGANIZATION RELATIVE . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_56() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' ORGANIZATION IS RELATIVE . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_57() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' ORGANIZATION RELATIVE RELATIVE baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_58() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' ORGANIZATION RELATIVE RELATIVE IS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_59() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' ORGANIZATION RELATIVE RELATIVE KEY baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_60() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' ORGANIZATION RELATIVE RELATIVE KEY IS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_61() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' RELATIVE ACCESS MODE IS SEQUENTIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_62() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' RELATIVE ACCESS MODE IS DYNAMIC . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_63() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' RELATIVE ACCESS MODE IS RANDOM . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_64() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_65() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' ORGANIZATION INDEXED . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_66() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' ORGANIZATION IS INDEXED . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_67() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED RECORD KEY IS baz = boojum . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_68() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED RECORD KEY IS baz SOURCE boojum . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_69() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED RECORD KEY IS baz SOURCE IS boojum . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_70() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_71() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD IS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_72() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_73() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_74() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD baz = boojum . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_75() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD IS baz = boojum . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_76() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_77() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz = boojum . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_78() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz SOURCE boojum . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_79() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz SOURCE IS boojum . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_80() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD baz DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_81() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD IS baz DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_82() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_83() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_84() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD baz = boojum DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_85() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD IS baz = boojum DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_86() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_87() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz = boojum DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_88() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz SOURCE boojum DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_89() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz SOURCE IS boojum DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_90() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD baz WITH DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_91() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD IS baz WITH DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_92() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz WITH DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_93() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz WITH DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_94() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD baz = boojum WITH DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_95() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD IS baz = boojum WITH DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_96() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum WITH DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_97() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz = boojum WITH DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_98() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz SOURCE boojum WITH DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_99() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz SOURCE IS boojum WITH DUPLICATES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_100() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED RECORD KEY IS baz PASSWORD boojum . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_101() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED RECORD KEY IS baz PASSWORD IS boojum . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_102() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz PASSWORD boojum . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_103() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz PASSWORD IS boojum . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_104() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum SUPPRESS ZEROS . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_105() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum SUPPRESS WHEN ZERO . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_106() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum SUPPRESS SPACES . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_107() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum SUPPRESS 'x' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_108() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum SUPPRESS WHEN 'x' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_109() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum SUPPRESS ALL 'x' . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_110() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' FILE STATUS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_111() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' FILE STATUS IS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_112() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SORT STATUS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_113() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SORT STATUS IS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_114() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK EXCLUSIVE . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_115() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE EXCLUSIVE . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_116() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE IS EXCLUSIVE . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_117() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE IS MANUAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_118() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE IS MANUAL LOCK ON MULTIPLE RECORDS . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_119() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE IS MANUAL WITH LOCK ON MULTIPLE RECORDS . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_120() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE IS MANUAL LOCK ON RECORD . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_121() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE IS MANUAL WITH LOCK ON RECORD . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_122() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE IS MANUAL ROLLBACK . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_123() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE IS MANUAL WITH ROLLBACK . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_124() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE IS AUTOMATIC . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_125() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE IS AUTOMATIC LOCK ON MULTIPLE RECORDS . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_126() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE IS AUTOMATIC WITH LOCK ON MULTIPLE RECORDS . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_127() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE IS AUTOMATIC LOCK ON RECORD . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_128() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE IS AUTOMATIC WITH LOCK ON RECORD . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_129() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE IS AUTOMATIC ROLLBACK . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_130() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' LOCK MODE IS AUTOMATIC WITH ROLLBACK . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_131() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' COLLATING baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_132() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' COLLATING SEQUENCE baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_133() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' COLLATING SEQUENCE IS baz . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_134() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' RECORD DELIMITER STANDARD-1 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_135() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' RECORD DELIMITER IS STANDARD-1 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_136() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' RECORD DELIMITER \"baz\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_137() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' RECORD DELIMITER IS \"baz\" . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_138() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SHARING ALL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_139() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SHARING WITH ALL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_140() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SHARING ALL OTHER . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_141() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SHARING NO . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_142() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SHARING WITH NO . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_143() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SHARING NO OTHER . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_144() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SHARING READ ONLY . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_145() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT foo ASSIGN 'bar.dat' SHARING WITH READ ONLY . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_146() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT outputFile ASSIGN 'CBL2BTR.BTR'\n     ORGANIZATION INDEXED\n     ACCESS DYNAMIC\n     RECORD KEY IS oFKey\n     FILE STATUS fileStatus . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_147() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT btrieveFile ASSIGN 'CBL2BTR.BTR'\n     ORGANIZATION INDEXED\n     ACCESS DYNAMIC\n     RECORD KEY IS oFKey\n     LOCK MODE IS AUTOMATIC\n     FILE STATUS fileStatus . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_148() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT outputFile ASSIGN 'OSVSAAOF.DAT'\n     ORGANIZATION SEQUENTIAL . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_149() {
      ParserCombinator parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" SELECT IX-FD1\n   ASSIGN TO XXXXX024\n   RESERVE  3\n   ORGANIZATION IS INDEXED\n   ACCESS DYNAMIC\n   RECORD  KEY IS IX-FD1-KEY\n   ALTERNATE RECORD IS IX-FD1-ALTKEY1 . "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}