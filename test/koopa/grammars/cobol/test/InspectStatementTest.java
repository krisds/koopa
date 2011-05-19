package koopa.grammars.cobol.test;

import junit.framework.TestCase;
import koopa.parsers.Parser;
import koopa.tokenizers.test.TestTokenizer;

import org.junit.Test;

public class InspectStatementTest extends TestCase {

  private static koopa.grammars.cobol.CobolGrammar grammar = new koopa.grammars.cobol.CobolGrammar();

    @Test
    public void testTallyingPhrase_1() {
      Parser parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TALLYING", "WRK-DU-999-1", "FOR", 
        "ALL", "\"A\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testTallyingPhrase_2() {
      Parser parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TALLYING", "WRK-DU-999-2", "FOR", 
        "LEADING", "\"A\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(5, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testTallyingPhrase_3() {
      Parser parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TALLYING", "WRK-DU-999-3", "FOR", 
        "CHARACTERS", "BEFORE", "\".\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testTallyingPhrase_4() {
      Parser parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TALLYING", "WRK-DU-999-4", "FOR", 
        "CHARACTERS", "AFTER", "\"AL\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(6, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testTallyingPhrase_5() {
      Parser parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TALLYING", "WRK-DU-999-1", "FOR", 
        "ALL", "\"A\"", "WRK-DU-999-2", "FOR", "ALL", "\"B\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testTallyingPhrase_6() {
      Parser parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TALLYING", "WRK-DU-999-1", "FOR", 
        "LEADING", "\"A\"", "WRK-DU-999-2", "FOR", "LEADING", "\"B\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(9, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testTallyingPhrase_7() {
      Parser parser = grammar.tallyingPhrase();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("TALLYING", "WRK-DU-999-1", "FOR", 
        "LEADING", "\"S\"", "AFTER", "WS-Y", "\"S\"", "AFTER", "\"U\"", "\"T\"", 
        "AFTER", "WS-Y", "\"T\"", "AFTER", "\"U\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(16, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testInspectStatement_8() {
      Parser parser = grammar.inspectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("INSPECT", "WRK-XN-83-1", "TALLYING", 
        "WRK-DU-999-1", "FOR", "ALL", "\"A\"", "WRK-DU-999-2", "FOR", "LEADING", 
        "\"AH\"", "WRK-DU-999-3", "FOR", "CHARACTERS", "BEFORE", "\".\"", "WRK-DU-999-4", 
        "FOR", "CHARACTERS", "AFTER", "\"AL\"", "REPLACING", "FIRST", "\"L \"", 
        "BY", "\"ZZ\"", "AFTER", "INITIAL", "\"AL\"", "FIRST", "\"BAD\"", "BY", 
        "\"ZZZ\"", "AFTER", "\"L \"", "LEADING", "\"BAD\"", "BY", "\"ZZZ\"", "BEFORE", 
        "INITIAL", "\"Q\"", "FIRST", "\"BAD\"", "BY", "\"ZZZ\"", "BEFORE", "INITIAL", 
        "\"Z\"", "FIRST", "\"BAD\"", "BY", "\"ZZZ\"", "AFTER", "\"ALL \"", "ALL", 
        "\".\"", "BY", "\"Z\"", "AFTER", "\"AL\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(61, tokenizer.getNumberOfProcessedTokens());
    }

    @Test
    public void testInspectStatement_9() {
      Parser parser = grammar.inspectStatement();
      assertNotNull(parser);
      TestTokenizer tokenizer = new TestTokenizer("INSPECT", "TEST-32-DATA", "TALLYING", 
        "WRK-DU-999-1", "FOR", "LEADING", "\"S\"", "AFTER", "WS-Y", "\"S\"", "AFTER", 
        "\"U\"", "\"T\"", "AFTER", "WS-Y", "\"T\"", "AFTER", "\"U\"");
      assertTrue(parser.accepts(tokenizer));
      assertEquals(18, tokenizer.getNumberOfProcessedTokens());
    }
}