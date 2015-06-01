package koopa.cobol.grammar.test;

import junit.framework.TestCase;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;

import org.junit.Test;

/** This code was generated from InspectStatement.stage. */
public class InspectStatementTest extends TestCase {

  private static koopa.cobol.grammar.CobolGrammar grammar = new koopa.cobol.grammar.CobolGrammar();

  private Source<Token> getTokenizer(String input) {
    return koopa.cobol.sources.test.CobolTestSource.forSample(input);
  }

    @Test
    public void testTallyingPhrase_1() {
      ParserCombinator parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TALLYING WRK-DU-999-1 FOR ALL \"A\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_2() {
      ParserCombinator parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TALLYING WRK-DU-999-2 FOR LEADING \"A\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_3() {
      ParserCombinator parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TALLYING WRK-DU-999-2 FOR TRAILING \"A\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_4() {
      ParserCombinator parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TALLYING WRK-DU-999-3 FOR CHARACTERS BEFORE \".\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_5() {
      ParserCombinator parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TALLYING WRK-DU-999-4 FOR CHARACTERS AFTER \"AL\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_6() {
      ParserCombinator parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TALLYING WRK-DU-999-1 FOR ALL \"A\"\n            WRK-DU-999-2 FOR ALL \"B\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_7() {
      ParserCombinator parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TALLYING WRK-DU-999-1 FOR LEADING \"A\"\n            WRK-DU-999-2 FOR LEADING \"B\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_8() {
      ParserCombinator parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TALLYING WRK-DU-999-1 FOR LEADING \"S\" AFTER WS-Y\n                                     \"S\" AFTER \"U\"\n                                     \"T\" AFTER WS-Y\n                                     \"T\" AFTER \"U\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_9() {
      ParserCombinator parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TALLYING FUNCTION FN ( X ) FOR ALL \"A\" "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_10() {
      ParserCombinator parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TALLYING EXCEPTION-OBJECT FOR ALL \"A\" "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_11() {
      ParserCombinator parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TALLYING NULL FOR ALL \"A\" "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_12() {
      ParserCombinator parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TALLYING SELF FOR ALL \"A\" "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_13() {
      ParserCombinator parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TALLYING SUPER FOR ALL \"A\" "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_14() {
      ParserCombinator parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TALLYING MY-CLASS-NAME OF SUPER FOR ALL \"A\" "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_15() {
      ParserCombinator parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" TALLYING ADDRESS OF SOMETHING FOR ALL \"A\" "));
      assertFalse(parser.accepts(Parse.of(tokenizer)) && tokenizer.isWhereExpected());
    }

    @Test
    public void testReplacingPhrase_16() {
      ParserCombinator parser = grammar.replacingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPLACING CHARACTERS BY \"A\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReplacingPhrase_17() {
      ParserCombinator parser = grammar.replacingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPLACING ALL SPACES BY A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReplacingPhrase_18() {
      ParserCombinator parser = grammar.replacingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPLACING LEADING SPACES BY A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReplacingPhrase_19() {
      ParserCombinator parser = grammar.replacingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPLACING FIRST SPACES BY A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testReplacingPhrase_20() {
      ParserCombinator parser = grammar.replacingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" REPLACING TRAILING SPACES BY A "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInspectStatement_21() {
      ParserCombinator parser = grammar.inspectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INSPECT WRK-XN-83-1 \n     TALLYING\n         WRK-DU-999-1 FOR ALL \"A\"\n         WRK-DU-999-2 FOR LEADING \"AH\"\n         WRK-DU-999-3 FOR CHARACTERS BEFORE \".\"\n         WRK-DU-999-4 FOR CHARACTERS AFTER \"AL\"\n     REPLACING\n         FIRST \"L \" BY \"ZZ\" AFTER INITIAL \"AL\"\n         FIRST \"BAD\" BY \"ZZZ\" AFTER \"L \"\n         LEADING \"BAD\" BY \"ZZZ\" BEFORE INITIAL \"Q\"\n         FIRST \"BAD\" BY \"ZZZ\" BEFORE INITIAL \"Z\"\n         FIRST \"BAD\" BY \"ZZZ\" AFTER \"ALL \"\n         ALL \".\" BY \"Z\" AFTER \"AL\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInspectStatement_22() {
      ParserCombinator parser = grammar.inspectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer(getTokenizer(" INSPECT TEST-32-DATA \n     TALLYING \n         WRK-DU-999-1 FOR LEADING \"S\" AFTER WS-Y\n                                  \"S\" AFTER \"U\"\n                                  \"T\" AFTER WS-Y\n                                  \"T\" AFTER \"U\" "));
      assertTrue(parser.accepts(Parse.of(tokenizer)));
      assertTrue(tokenizer.isWhereExpected());
    }
}