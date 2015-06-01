package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from AllocateStatement.stage. */
public class AllocateStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testAllocateStatement_1() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE based-var\n   INITIALIZED\n   RETURNING pointer-var "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_2() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE based-var\n   INITIALIZED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_3() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE based-var\n   RETURNING pointer-var "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_4() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE based-var "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_5() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE 13 CHARACTERS\n   INITIALIZED\n   RETURNING pointer-var "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_6() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE 13 CHARACTERS\n   INITIALIZED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_7() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE 13 CHARACTERS\n   RETURNING pointer-var "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_8() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE 13 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_9() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE N + 2 CHARACTERS\n   INITIALIZED\n   RETURNING pointer-var "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_10() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE N + 2 CHARACTERS\n   INITIALIZED "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_11() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE N + 2 CHARACTERS\n   RETURNING pointer-var "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_12() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE N + 2 CHARACTERS "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_13() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE FUNCTION FN ( X ) "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_14() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE based-var RETURNING FUNCTION FN ( X ) "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_15() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE EXCEPTION-OBJECT "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_16() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE NULL "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_17() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE SELF "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_18() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE SUPER "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_19() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE MY-CLASS-NAME OF SUPER "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testAllocateStatement_20() {
      ParserCombinator parser = grammar.allocateStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" ALLOCATE ADDRESS OF SOMETHING "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }
}