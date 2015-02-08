// $ANTLR 3.1.1 src/core/koopa/core/grammars/test/generator/StageTreeParser.g

  package koopa.core.grammars.test.generator;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class StageTreeParser extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STAGE", "PACKAGE", "GRAMMAR", "TOKENIZER", "TARGET", "TEST", "IDENTIFIER", "SEMI", "ACCEPT", "REJECT", "DATA", "COMMENT", "NEWLINE", "WHITESPACE", "NAME", "LETTER", "NUMBER", "'grammar'", "'package'", "'tokenizer'", "'target'"
    };
    public static final int PACKAGE=5;
    public static final int T__24=24;
    public static final int LETTER=19;
    public static final int T__23=23;
    public static final int STAGE=4;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int NUMBER=20;
    public static final int WHITESPACE=17;
    public static final int TARGET=8;
    public static final int EOF=-1;
    public static final int SEMI=11;
    public static final int ACCEPT=12;
    public static final int NAME=18;
    public static final int NEWLINE=16;
    public static final int REJECT=13;
    public static final int IDENTIFIER=10;
    public static final int TOKENIZER=7;
    public static final int TEST=9;
    public static final int COMMENT=15;
    public static final int DATA=14;
    public static final int GRAMMAR=6;

    // delegates
    // delegators


        public StageTreeParser(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public StageTreeParser(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return StageTreeParser.tokenNames; }
    public String getGrammarFileName() { return "src/core/koopa/core/grammars/test/generator/StageTreeParser.g"; }



    // $ANTLR start "stage"
    // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:14:1: stage : ^( STAGE pack grammah tokenizer ( testsForGrammarRule )* ) ;
    public final void stage() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:15:3: ( ^( STAGE pack grammah tokenizer ( testsForGrammarRule )* ) )
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:15:5: ^( STAGE pack grammah tokenizer ( testsForGrammarRule )* )
            {
            match(input,STAGE,FOLLOW_STAGE_in_stage59); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_pack_in_stage61);
            pack();

            state._fsp--;

            pushFollow(FOLLOW_grammah_in_stage63);
            grammah();

            state._fsp--;

            pushFollow(FOLLOW_tokenizer_in_stage65);
            tokenizer();

            state._fsp--;

            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:15:36: ( testsForGrammarRule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==TARGET) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:15:36: testsForGrammarRule
            	    {
            	    pushFollow(FOLLOW_testsForGrammarRule_in_stage67);
            	    testsForGrammarRule();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "stage"


    // $ANTLR start "pack"
    // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:18:1: pack : ^( PACKAGE IDENTIFIER ) ;
    public final void pack() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:19:3: ( ^( PACKAGE IDENTIFIER ) )
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:19:5: ^( PACKAGE IDENTIFIER )
            {
            match(input,PACKAGE,FOLLOW_PACKAGE_in_pack85); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_pack87); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "pack"


    // $ANTLR start "grammah"
    // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:22:1: grammah : ^( GRAMMAR IDENTIFIER ) ;
    public final void grammah() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:23:3: ( ^( GRAMMAR IDENTIFIER ) )
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:23:5: ^( GRAMMAR IDENTIFIER )
            {
            match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammah102); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_grammah104); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "grammah"


    // $ANTLR start "tokenizer"
    // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:26:1: tokenizer : ^( TOKENIZER IDENTIFIER ) ;
    public final void tokenizer() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:27:3: ( ^( TOKENIZER IDENTIFIER ) )
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:27:5: ^( TOKENIZER IDENTIFIER )
            {
            match(input,TOKENIZER,FOLLOW_TOKENIZER_in_tokenizer119); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_tokenizer121); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "tokenizer"


    // $ANTLR start "testsForGrammarRule"
    // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:30:1: testsForGrammarRule : ^( TARGET IDENTIFIER ( test )* ) ;
    public final void testsForGrammarRule() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:31:3: ( ^( TARGET IDENTIFIER ( test )* ) )
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:31:5: ^( TARGET IDENTIFIER ( test )* )
            {
            match(input,TARGET,FOLLOW_TARGET_in_testsForGrammarRule136); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_testsForGrammarRule138); 
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:31:25: ( test )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==TEST) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:31:25: test
            	    {
            	    pushFollow(FOLLOW_test_in_testsForGrammarRule140);
            	    test();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "testsForGrammarRule"


    // $ANTLR start "test"
    // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:34:1: test : ^( TEST ( ACCEPT | REJECT ) DATA ) ;
    public final void test() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:35:3: ( ^( TEST ( ACCEPT | REJECT ) DATA ) )
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:35:5: ^( TEST ( ACCEPT | REJECT ) DATA )
            {
            match(input,TEST,FOLLOW_TEST_in_test158); 

            match(input, Token.DOWN, null); 
            if ( (input.LA(1)>=ACCEPT && input.LA(1)<=REJECT) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            match(input,DATA,FOLLOW_DATA_in_test168); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "test"

    // Delegated rules


 

    public static final BitSet FOLLOW_STAGE_in_stage59 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_pack_in_stage61 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_grammah_in_stage63 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_tokenizer_in_stage65 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_testsForGrammarRule_in_stage67 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_PACKAGE_in_pack85 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_pack87 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GRAMMAR_in_grammah102 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_grammah104 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TOKENIZER_in_tokenizer119 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_tokenizer121 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TARGET_in_testsForGrammarRule136 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_testsForGrammarRule138 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_test_in_testsForGrammarRule140 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_TEST_in_test158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_test160 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DATA_in_test168 = new BitSet(new long[]{0x0000000000000008L});

}
