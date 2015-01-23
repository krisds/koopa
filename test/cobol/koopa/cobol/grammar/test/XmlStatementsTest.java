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
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     ON EXCEPTION PERFORM p1\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_6() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     ON EXCEPTION PERFORM p1\n     NOT ON EXCEPTION PERFORM p2\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_7() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     NOT ON EXCEPTION PERFORM p2\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlGenerateStatement_8() {
      Parser parser = grammar.xmlGenerateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML GENERATE foo FROM bar\n     COUNT IN baz\n     ON EXCEPTION PERFORM p1\n     NOT ON EXCEPTION PERFORM p2\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_9() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_10() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_11() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo\n     PROCESSING PROCEDURE IS bar\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_12() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo\n     PROCESSING PROCEDURE IS bar THROUGH baz\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_13() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo\n     PROCESSING PROCEDURE IS bar THRU baz\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_14() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo\n     ON EXCEPTION PERFORM p1\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_15() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo\n     ON EXCEPTION PERFORM p1\n     NOT ON EXCEPTION PERFORM p2\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_16() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo\n     NOT ON EXCEPTION PERFORM p2\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testXmlParseStatement_17() {
      Parser parser = grammar.xmlParseStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" XML PARSE foo\n     PROCESSING PROCEDURE IS bar THROUGH baz\n     ON EXCEPTION PERFORM p1\n     NOT ON EXCEPTION PERFORM p2\n   END-XML "));
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}