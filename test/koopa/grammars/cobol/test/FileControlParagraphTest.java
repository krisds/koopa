package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from FileControlParagraph.stage. */
public class FileControlParagraphTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testFileControlParagraph_1() {
      Parser parser = grammar.fileControlParagraph();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " FILE-CONTROL .\n     SELECT foo ASSIGN 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_2() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_3() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT OPTIONAL foo ASSIGN 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_4() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT NOT OPTIONAL foo ASSIGN 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_5() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT NOT foo ASSIGN 'bar.dat' . ");
      assertFalse(parser.accepts(tokenizer) && tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_6() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_7() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO EXTERNAL 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_8() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO DYNAMIC 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_9() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO DISK FROM bar . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_10() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO DISK FILE 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_11() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO FILE 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_12() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO DISK . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_13() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO DISK DISPLAY . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_14() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO DISK 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_15() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO DISK 'bar.dat' 'baz.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_16() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO LINE ADVANCING 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_17() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO LINE ADVANCING FILE 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_18() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO REEL 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_19() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO REEL FILE 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_20() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO MULTIPLE REEL 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_21() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO MULTIPLE REEL FILE 'bar.dat' 'baz.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_22() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO UNIT 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_23() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO UNIT FILE 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_24() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO MULTIPLE UNIT 'bar.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_25() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO MULTIPLE UNIT FILE 'bar.dat' 'baz.dat' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_26() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO KEYBOARD . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_27() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO KEYBOARD bar . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_28() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO DISPLAY . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_29() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO DISPLAY bar . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_30() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO PRINTER . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_31() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO PRINTER DISPLAY . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_32() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO PRINTER bar . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_33() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO PRINTER-L . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_34() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO PRINTER-L bar . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_35() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO 'bar.dat' RESERVE 1 AREA . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_36() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO 'bar.dat' RESERVE 2 AREAS . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_37() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO 'bar.dat' RESERVE NO AREAS . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_38() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO 'bar.dat' RESERVE 2 ALTERNATE AREAS . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_39() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN TO 'bar.dat' RESERVE NO ALTERNATE AREAS . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_40() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SEQUENTIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_41() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' ORGANIZATION SEQUENTIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_42() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' ORGANIZATION IS SEQUENTIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_43() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' ORGANIZATION IS LINE SEQUENTIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_44() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' ORGANIZATION IS RECORD SEQUENTIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_45() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' ORGANIZATION IS RECORD BINARY SEQUENTIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_46() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SEQUENTIAL ACCESS SEQUENTIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_47() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SEQUENTIAL ACCESS IS SEQUENTIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_48() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SEQUENTIAL ACCESS MODE SEQUENTIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_49() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SEQUENTIAL PADDING '0' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_50() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SEQUENTIAL PADDING IS '0' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_51() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SEQUENTIAL PADDING CHARACTER '0' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_52() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SEQUENTIAL PADDING CHARACTER IS '0' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_53() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SEQUENTIAL PADDING CHARACTER IS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_54() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' RELATIVE . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_55() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' ORGANIZATION RELATIVE . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_56() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' ORGANIZATION IS RELATIVE . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_57() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' ORGANIZATION RELATIVE RELATIVE baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_58() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' ORGANIZATION RELATIVE RELATIVE IS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_59() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' ORGANIZATION RELATIVE RELATIVE KEY baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_60() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' ORGANIZATION RELATIVE RELATIVE KEY IS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_61() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' RELATIVE ACCESS MODE IS SEQUENTIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_62() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' RELATIVE ACCESS MODE IS DYNAMIC . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_63() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' RELATIVE ACCESS MODE IS RANDOM . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_64() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_65() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' ORGANIZATION INDEXED . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_66() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' ORGANIZATION IS INDEXED . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_67() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED RECORD KEY IS baz = boojum . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_68() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED RECORD KEY IS baz SOURCE boojum . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_69() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED RECORD KEY IS baz SOURCE IS boojum . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_70() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_71() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD IS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_72() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_73() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_74() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD baz = boojum . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_75() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD IS baz = boojum . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_76() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_77() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz = boojum . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_78() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz SOURCE boojum . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_79() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz SOURCE IS boojum . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_80() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD baz DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_81() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD IS baz DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_82() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_83() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_84() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD baz = boojum DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_85() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD IS baz = boojum DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_86() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_87() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz = boojum DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_88() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz SOURCE boojum DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_89() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz SOURCE IS boojum DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_90() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD baz WITH DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_91() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD IS baz WITH DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_92() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz WITH DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_93() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz WITH DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_94() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD baz = boojum WITH DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_95() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD IS baz = boojum WITH DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_96() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum WITH DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_97() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz = boojum WITH DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_98() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz SOURCE boojum WITH DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_99() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz SOURCE IS boojum WITH DUPLICATES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_100() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED RECORD KEY IS baz PASSWORD boojum . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_101() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED RECORD KEY IS baz PASSWORD IS boojum . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_102() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz PASSWORD boojum . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_103() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY IS baz PASSWORD IS boojum . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_104() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum SUPPRESS ZEROS . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_105() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum SUPPRESS WHEN ZERO . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_106() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum SUPPRESS SPACES . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_107() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum SUPPRESS 'x' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_108() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum SUPPRESS WHEN 'x' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_109() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' INDEXED ALTERNATE RECORD KEY baz = boojum SUPPRESS ALL 'x' . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_110() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' FILE STATUS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_111() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' FILE STATUS IS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_112() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SORT STATUS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_113() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SORT STATUS IS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_114() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK EXCLUSIVE . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_115() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE EXCLUSIVE . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_116() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE IS EXCLUSIVE . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_117() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE IS MANUAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_118() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE IS MANUAL LOCK ON MULTIPLE RECORDS . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_119() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE IS MANUAL WITH LOCK ON MULTIPLE RECORDS . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_120() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE IS MANUAL LOCK ON RECORD . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_121() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE IS MANUAL WITH LOCK ON RECORD . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_122() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE IS MANUAL ROLLBACK . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_123() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE IS MANUAL WITH ROLLBACK . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_124() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE IS AUTOMATIC . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_125() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE IS AUTOMATIC LOCK ON MULTIPLE RECORDS . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_126() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE IS AUTOMATIC WITH LOCK ON MULTIPLE RECORDS . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_127() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE IS AUTOMATIC LOCK ON RECORD . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_128() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE IS AUTOMATIC WITH LOCK ON RECORD . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_129() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE IS AUTOMATIC ROLLBACK . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_130() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' LOCK MODE IS AUTOMATIC WITH ROLLBACK . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_131() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' COLLATING baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_132() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' COLLATING SEQUENCE baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_133() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' COLLATING SEQUENCE IS baz . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_134() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' RECORD DELIMITER STANDARD-1 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_135() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' RECORD DELIMITER IS STANDARD-1 . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_136() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' RECORD DELIMITER \"baz\" . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_137() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' RECORD DELIMITER IS \"baz\" . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_138() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SHARING ALL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_139() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SHARING WITH ALL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_140() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SHARING ALL OTHER . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_141() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SHARING NO . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_142() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SHARING WITH NO . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_143() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SHARING NO OTHER . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_144() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SHARING READ ONLY . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_145() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT foo ASSIGN 'bar.dat' SHARING WITH READ ONLY . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_146() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT outputFile ASSIGN 'CBL2BTR.BTR'\n     ORGANIZATION INDEXED\n     ACCESS DYNAMIC\n     RECORD KEY IS oFKey\n     FILE STATUS fileStatus . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_147() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT btrieveFile ASSIGN 'CBL2BTR.BTR'\n     ORGANIZATION INDEXED\n     ACCESS DYNAMIC\n     RECORD KEY IS oFKey\n     LOCK MODE IS AUTOMATIC\n     FILE STATUS fileStatus . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testSelectStatement_148() {
      Parser parser = grammar.selectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(SourceFormat.FREE, " SELECT outputFile ASSIGN 'OSVSAAOF.DAT'\n     ORGANIZATION SEQUENTIAL . ");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}