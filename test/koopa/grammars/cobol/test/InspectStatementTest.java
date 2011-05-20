package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.cobol.TestTokenizer;

import org.junit.Test;

/** This code was generated from InspectStatement.stage. */
public class InspectStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testTallyingPhrase_1() {
      Parser parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TALLYING WRK-DU-999-1 FOR ALL \"A\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_2() {
      Parser parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TALLYING WRK-DU-999-2 FOR LEADING \"A\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_3() {
      Parser parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TALLYING WRK-DU-999-3 FOR CHARACTERS BEFORE \".\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_4() {
      Parser parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TALLYING WRK-DU-999-4 FOR CHARACTERS AFTER \"AL\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_5() {
      Parser parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TALLYING WRK-DU-999-1 FOR ALL \"A\"\n            WRK-DU-999-2 FOR ALL \"B\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_6() {
      Parser parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TALLYING WRK-DU-999-1 FOR LEADING \"A\"\n            WRK-DU-999-2 FOR LEADING \"B\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testTallyingPhrase_7() {
      Parser parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TALLYING WRK-DU-999-1 FOR LEADING \"S\" AFTER WS-Y\n                                     \"S\" AFTER \"U\"\n                                     \"T\" AFTER WS-Y\n                                     \"T\" AFTER \"U\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInspectStatement_8() {
      Parser parser = grammar.inspectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("INSPECT WRK-XN-83-1 \n     TALLYING\n         WRK-DU-999-1 FOR ALL \"A\"\n         WRK-DU-999-2 FOR LEADING \"AH\"\n         WRK-DU-999-3 FOR CHARACTERS BEFORE \".\"\n         WRK-DU-999-4 FOR CHARACTERS AFTER \"AL\"\n     REPLACING\n         FIRST \"L \" BY \"ZZ\" AFTER INITIAL \"AL\"\n         FIRST \"BAD\" BY \"ZZZ\" AFTER \"L \"\n         LEADING \"BAD\" BY \"ZZZ\" BEFORE INITIAL \"Q\"\n         FIRST \"BAD\" BY \"ZZZ\" BEFORE INITIAL \"Z\"\n         FIRST \"BAD\" BY \"ZZZ\" AFTER \"ALL \"\n         ALL \".\" BY \"Z\" AFTER \"AL\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }

    @Test
    public void testInspectStatement_9() {
      Parser parser = grammar.inspectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("INSPECT TEST-32-DATA \n     TALLYING \n         WRK-DU-999-1 FOR LEADING \"S\" AFTER WS-Y\n                                  \"S\" AFTER \"U\"\n                                  \"T\" AFTER WS-Y\n                                  \"T\" AFTER \"U\"");
      assertTrue(parser.accepts(tokenizer));
      assertTrue(tokenizer.isWhereExpected());
    }
}