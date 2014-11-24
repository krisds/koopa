// $ANTLR 3.1.1 src/core/koopa/core/grammars/test/generator/Stage.g 2014-11-24 20:28:03

  package koopa.core.grammars.test.generator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class StageLexer extends Lexer {
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

    public StageLexer() {;} 
    public StageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public StageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "src/core/koopa/core/grammars/test/generator/Stage.g"; }

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/test/generator/Stage.g:7:7: ( 'grammar' )
            // src/core/koopa/core/grammars/test/generator/Stage.g:7:9: 'grammar'
            {
            match("grammar"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/test/generator/Stage.g:8:7: ( 'package' )
            // src/core/koopa/core/grammars/test/generator/Stage.g:8:9: 'package'
            {
            match("package"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/test/generator/Stage.g:9:7: ( 'target' )
            // src/core/koopa/core/grammars/test/generator/Stage.g:9:9: 'target'
            {
            match("target"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/test/generator/Stage.g:58:9: ( '#' (~ ( '\\n' | '\\r' ) )* )
            // src/core/koopa/core/grammars/test/generator/Stage.g:58:11: '#' (~ ( '\\n' | '\\r' ) )*
            {
            match('#'); if (state.failed) return ;
            // src/core/koopa/core/grammars/test/generator/Stage.g:58:15: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/core/koopa/core/grammars/test/generator/Stage.g:58:16: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               _channel = HIDDEN; 
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/test/generator/Stage.g:60:9: ( ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' ) )
            // src/core/koopa/core/grammars/test/generator/Stage.g:60:11: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
            {
            // src/core/koopa/core/grammars/test/generator/Stage.g:60:11: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='\n') && (synpred1_Stage())) {
                    alt2=1;
                }
                else {
                    alt2=2;}
            }
            else if ( (LA2_0=='\n') ) {
                alt2=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // src/core/koopa/core/grammars/test/generator/Stage.g:60:13: ( '\\r\\n' )=> '\\r\\n'
                    {
                    match("\r\n"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/grammars/test/generator/Stage.g:60:34: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/grammars/test/generator/Stage.g:60:41: '\\n'
                    {
                    match('\n'); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               _channel = HIDDEN; 
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/test/generator/Stage.g:62:12: ( ( ' ' | '\\t' )+ )
            // src/core/koopa/core/grammars/test/generator/Stage.g:62:14: ( ' ' | '\\t' )+
            {
            // src/core/koopa/core/grammars/test/generator/Stage.g:62:14: ( ' ' | '\\t' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src/core/koopa/core/grammars/test/generator/Stage.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            if ( state.backtracking==0 ) {
               _channel = HIDDEN; 
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/test/generator/Stage.g:64:6: ( ';' )
            // src/core/koopa/core/grammars/test/generator/Stage.g:64:8: ';'
            {
            match(';'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "ACCEPT"
    public final void mACCEPT() throws RecognitionException {
        try {
            int _type = ACCEPT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/test/generator/Stage.g:66:8: ( '+' )
            // src/core/koopa/core/grammars/test/generator/Stage.g:66:10: '+'
            {
            match('+'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ACCEPT"

    // $ANTLR start "REJECT"
    public final void mREJECT() throws RecognitionException {
        try {
            int _type = REJECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/test/generator/Stage.g:67:8: ( '-' )
            // src/core/koopa/core/grammars/test/generator/Stage.g:67:10: '-'
            {
            match('-'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REJECT"

    // $ANTLR start "FREE_DATA"
    public final void mFREE_DATA() throws RecognitionException {
        try {
            int _type = FREE_DATA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/test/generator/Stage.g:69:11: ( '[' (~ ( '[' | ']' ) )* ']' )
            // src/core/koopa/core/grammars/test/generator/Stage.g:69:13: '[' (~ ( '[' | ']' ) )* ']'
            {
            match('['); if (state.failed) return ;
            // src/core/koopa/core/grammars/test/generator/Stage.g:69:17: (~ ( '[' | ']' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='Z')||LA4_0=='\\'||(LA4_0>='^' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/core/koopa/core/grammars/test/generator/Stage.g:69:18: ~ ( '[' | ']' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='Z')||input.LA(1)=='\\'||(input.LA(1)>='^' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(']'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FREE_DATA"

    // $ANTLR start "FIXED_DATA"
    public final void mFIXED_DATA() throws RecognitionException {
        try {
            int _type = FIXED_DATA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/test/generator/Stage.g:70:12: ( '{' (~ ( '{' | '}' ) )* '}' )
            // src/core/koopa/core/grammars/test/generator/Stage.g:70:14: '{' (~ ( '{' | '}' ) )* '}'
            {
            match('{'); if (state.failed) return ;
            // src/core/koopa/core/grammars/test/generator/Stage.g:70:18: (~ ( '{' | '}' ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='z')||LA5_0=='|'||(LA5_0>='~' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/core/koopa/core/grammars/test/generator/Stage.g:70:19: ~ ( '{' | '}' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='z')||input.LA(1)=='|'||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FIXED_DATA"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/test/generator/Stage.g:72:12: ( NAME ( '.' NAME )* )
            // src/core/koopa/core/grammars/test/generator/Stage.g:72:14: NAME ( '.' NAME )*
            {
            mNAME(); if (state.failed) return ;
            // src/core/koopa/core/grammars/test/generator/Stage.g:72:19: ( '.' NAME )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='.') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/core/koopa/core/grammars/test/generator/Stage.g:72:20: '.' NAME
            	    {
            	    match('.'); if (state.failed) return ;
            	    mNAME(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/test/generator/Stage.g:74:15: ( LETTER ( '_' | LETTER | NUMBER )* )
            // src/core/koopa/core/grammars/test/generator/Stage.g:74:17: LETTER ( '_' | LETTER | NUMBER )*
            {
            mLETTER(); if (state.failed) return ;
            // src/core/koopa/core/grammars/test/generator/Stage.g:74:24: ( '_' | LETTER | NUMBER )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/core/koopa/core/grammars/test/generator/Stage.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "NAME"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/test/generator/Stage.g:75:17: ( 'A' .. 'Z' | 'a' .. 'z' )
            // src/core/koopa/core/grammars/test/generator/Stage.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/test/generator/Stage.g:76:17: ( '0' .. '9' )
            // src/core/koopa/core/grammars/test/generator/Stage.g:76:19: '0' .. '9'
            {
            matchRange('0','9'); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    public void mTokens() throws RecognitionException {
        // src/core/koopa/core/grammars/test/generator/Stage.g:1:8: ( T__21 | T__22 | T__23 | COMMENT | NEWLINE | WHITESPACE | SEMI | ACCEPT | REJECT | FREE_DATA | FIXED_DATA | IDENTIFIER )
        int alt8=12;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // src/core/koopa/core/grammars/test/generator/Stage.g:1:10: T__21
                {
                mT__21(); if (state.failed) return ;

                }
                break;
            case 2 :
                // src/core/koopa/core/grammars/test/generator/Stage.g:1:16: T__22
                {
                mT__22(); if (state.failed) return ;

                }
                break;
            case 3 :
                // src/core/koopa/core/grammars/test/generator/Stage.g:1:22: T__23
                {
                mT__23(); if (state.failed) return ;

                }
                break;
            case 4 :
                // src/core/koopa/core/grammars/test/generator/Stage.g:1:28: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 5 :
                // src/core/koopa/core/grammars/test/generator/Stage.g:1:36: NEWLINE
                {
                mNEWLINE(); if (state.failed) return ;

                }
                break;
            case 6 :
                // src/core/koopa/core/grammars/test/generator/Stage.g:1:44: WHITESPACE
                {
                mWHITESPACE(); if (state.failed) return ;

                }
                break;
            case 7 :
                // src/core/koopa/core/grammars/test/generator/Stage.g:1:55: SEMI
                {
                mSEMI(); if (state.failed) return ;

                }
                break;
            case 8 :
                // src/core/koopa/core/grammars/test/generator/Stage.g:1:60: ACCEPT
                {
                mACCEPT(); if (state.failed) return ;

                }
                break;
            case 9 :
                // src/core/koopa/core/grammars/test/generator/Stage.g:1:67: REJECT
                {
                mREJECT(); if (state.failed) return ;

                }
                break;
            case 10 :
                // src/core/koopa/core/grammars/test/generator/Stage.g:1:74: FREE_DATA
                {
                mFREE_DATA(); if (state.failed) return ;

                }
                break;
            case 11 :
                // src/core/koopa/core/grammars/test/generator/Stage.g:1:84: FIXED_DATA
                {
                mFIXED_DATA(); if (state.failed) return ;

                }
                break;
            case 12 :
                // src/core/koopa/core/grammars/test/generator/Stage.g:1:95: IDENTIFIER
                {
                mIDENTIFIER(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_Stage
    public final void synpred1_Stage_fragment() throws RecognitionException {   
        // src/core/koopa/core/grammars/test/generator/Stage.g:60:13: ( '\\r\\n' )
        // src/core/koopa/core/grammars/test/generator/Stage.g:60:14: '\\r\\n'
        {
        match("\r\n"); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred1_Stage

    public final boolean synpred1_Stage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Stage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\3\14\11\uffff\16\14\1\36\1\37\1\40\3\uffff";
    static final String DFA8_eofS =
        "\41\uffff";
    static final String DFA8_minS =
        "\1\11\1\162\2\141\11\uffff\1\141\1\143\1\162\1\155\1\153\1\147\1"+
        "\155\1\141\1\145\1\141\1\147\1\164\1\162\1\145\3\56\3\uffff";
    static final String DFA8_maxS =
        "\1\173\1\162\2\141\11\uffff\1\141\1\143\1\162\1\155\1\153\1\147"+
        "\1\155\1\141\1\145\1\141\1\147\1\164\1\162\1\145\3\172\3\uffff";
    static final String DFA8_acceptS =
        "\4\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\21\uffff\1\3\1"+
        "\1\1\2";
    static final String DFA8_specialS =
        "\41\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\6\1\5\2\uffff\1\5\22\uffff\1\6\2\uffff\1\4\7\uffff\1\10\1"+
            "\uffff\1\11\15\uffff\1\7\5\uffff\32\14\1\12\5\uffff\6\14\1\1"+
            "\10\14\1\2\3\14\1\3\6\14\1\13",
            "\1\15",
            "\1\16",
            "\1\17",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\20",
            "\1\21",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\14\1\uffff\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "\1\14\1\uffff\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "\1\14\1\uffff\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__21 | T__22 | T__23 | COMMENT | NEWLINE | WHITESPACE | SEMI | ACCEPT | REJECT | FREE_DATA | FIXED_DATA | IDENTIFIER );";
        }
    }
 

}