package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parser;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from XmlStatements.stage. */
public class XmlStatementsTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testXmlGenerateStatement_1() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_2() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_3() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     COUNT baz\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_4() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     COUNT IN baz\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_5() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     WITH ENCODING SOME-ENCODING\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_6() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     ENCODING SOME-ENCODING\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_7() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     WITH XML-DECLARATION\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_8() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     XML-DECLARATION\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_9() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     WITH ATTRIBUTES\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_10() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     ATTRIBUTES\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_11() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     NAMESPACE IS NS\n     NAMESPACE-PREFIX IS NP\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_12() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     NAMESPACE NS\n     NAMESPACE-PREFIX NP\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_13() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     NAMESPACE IS NS\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_14() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     ON EXCEPTION PERFORM p1\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_15() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     ON EXCEPTION PERFORM p1\n     NOT ON EXCEPTION PERFORM p2\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_16() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     NOT ON EXCEPTION PERFORM p2\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_17() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     COUNT IN baz\n     ON EXCEPTION PERFORM p1\n     NOT ON EXCEPTION PERFORM p2\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_18() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE FWP05-DES-DATOS FROM mensaje\n     COUNT IN W-CONTADOR\n     WITH ENCODING W-ENCODING\n     WITH XML-DECLARATION "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_19() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_20() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_21() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo\n     PROCESSING PROCEDURE IS bar\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_22() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo\n     PROCESSING PROCEDURE IS bar THROUGH baz\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_23() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo\n     PROCESSING PROCEDURE IS bar THRU baz\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_24() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo\n     ON EXCEPTION PERFORM p1\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_25() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo\n     ON EXCEPTION PERFORM p1\n     NOT ON EXCEPTION PERFORM p2\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_26() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo\n     NOT ON EXCEPTION PERFORM p2\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_27() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo\n     PROCESSING PROCEDURE IS bar THROUGH baz\n     ON EXCEPTION PERFORM p1\n     NOT ON EXCEPTION PERFORM p2\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}