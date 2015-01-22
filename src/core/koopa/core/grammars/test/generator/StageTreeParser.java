// $ANTLR 3.1.1 src/core/koopa/core/grammars/test/generator/StageTreeParser.g 2015-01-22 21:19:54

  package koopa.core.grammars.test.generator;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class StageTreeParser extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STAGE", "GRAMMAR", "PACKAGE", "TARGET", "TEST", "IDENTIFIER", "SEMI", "ACCEPT", "REJECT", "FREE_DATA", "FIXED_DATA", "COMMENT", "NEWLINE", "WHITESPACE", "NAME", "LETTER", "NUMBER", "'grammar'", "'package'", "'target'"
    };
    public static final int PACKAGE=6;
    public static final int T__23=23;
    public static final int LETTER=19;
    public static final int STAGE=4;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int NUMBER=20;
    public static final int WHITESPACE=17;
    public static final int TARGET=7;
    public static final int EOF=-1;
    public static final int SEMI=10;
    public static final int ACCEPT=11;
    public static final int NAME=18;
    public static final int NEWLINE=16;
    public static final int FIXED_DATA=14;
    public static final int REJECT=12;
    public static final int IDENTIFIER=9;
    public static final int TEST=8;
    public static final int FREE_DATA=13;
    public static final int COMMENT=15;
    public static final int GRAMMAR=5;

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
    // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:14:1: stage : ^( STAGE pack grammah ( testsForGrammarRule )* ) ;
    public final void stage() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:15:3: ( ^( STAGE pack grammah ( testsForGrammarRule )* ) )
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:15:5: ^( STAGE pack grammah ( testsForGrammarRule )* )
            {
            match(input,STAGE,FOLLOW_STAGE_in_stage59); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_pack_in_stage61);
            pack();

            state._fsp--;

            pushFollow(FOLLOW_grammah_in_stage63);
            grammah();

            state._fsp--;

            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:15:26: ( testsForGrammarRule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==TARGET) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:15:26: testsForGrammarRule
            	    {
            	    pushFollow(FOLLOW_testsForGrammarRule_in_stage65);
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
            match(input,PACKAGE,FOLLOW_PACKAGE_in_pack83); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_pack85); 

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
            match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammah100); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_grammah102); 

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


    // $ANTLR start "testsForGrammarRule"
    // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:26:1: testsForGrammarRule : ^( TARGET IDENTIFIER ( test )* ) ;
    public final void testsForGrammarRule() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:27:3: ( ^( TARGET IDENTIFIER ( test )* ) )
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:27:5: ^( TARGET IDENTIFIER ( test )* )
            {
            match(input,TARGET,FOLLOW_TARGET_in_testsForGrammarRule117); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_testsForGrammarRule119); 
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:27:25: ( test )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==TEST) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:27:25: test
            	    {
            	    pushFollow(FOLLOW_test_in_testsForGrammarRule121);
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
    // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:30:1: test : ^( TEST ( ACCEPT | REJECT ) ( FREE_DATA | FIXED_DATA ) ) ;
    public final void test() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:31:3: ( ^( TEST ( ACCEPT | REJECT ) ( FREE_DATA | FIXED_DATA ) ) )
            // src/core/koopa/core/grammars/test/generator/StageTreeParser.g:31:5: ^( TEST ( ACCEPT | REJECT ) ( FREE_DATA | FIXED_DATA ) )
            {
            match(input,TEST,FOLLOW_TEST_in_test139); 

            match(input, Token.DOWN, null); 
            if ( (input.LA(1)>=ACCEPT && input.LA(1)<=REJECT) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( (input.LA(1)>=FREE_DATA && input.LA(1)<=FIXED_DATA) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    public static final BitSet FOLLOW_pack_in_stage61 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_grammah_in_stage63 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_testsForGrammarRule_in_stage65 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_PACKAGE_in_pack83 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_pack85 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GRAMMAR_in_grammah100 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_grammah102 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TARGET_in_testsForGrammarRule117 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_testsForGrammarRule119 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_test_in_testsForGrammarRule121 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_TEST_in_test139 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_test141 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_set_in_test149 = new BitSet(new long[]{0x0000000000000008L});

}