// $ANTLR 3.1.1 src/core/koopa/core/grammars/generator/KG.g 2014-11-03 08:19:37

  package koopa.core.grammars.generator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class KGLexer extends Lexer {
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int SKIP_TO=31;
    public static final int ACT=11;
    public static final int LOCALS=14;
    public static final int T__41=41;
    public static final int STAR=27;
    public static final int RULE=5;
    public static final int LETTER=38;
    public static final int NUMBER=25;
    public static final int OPEN_PAREN=17;
    public static final int WHITESPACE=40;
    public static final int LITERAL=24;
    public static final int BANG=32;
    public static final int EQUALS=19;
    public static final int NOT=33;
    public static final int NOSKIP=34;
    public static final int EOF=-1;
    public static final int DECLARATION=13;
    public static final int TAG=22;
    public static final int OPTIONAL=10;
    public static final int SEQUENCE=8;
    public static final int OPEN_BRACKET=29;
    public static final int ANY=23;
    public static final int NATIVE_CODE=21;
    public static final int NEWLINE=37;
    public static final int COMMA=20;
    public static final int IDENTIFIER=16;
    public static final int ASSIGN=12;
    public static final int PLUS=28;
    public static final int PIPE=35;
    public static final int BODY=6;
    public static final int CLOSE_PAREN=18;
    public static final int DIGIT=39;
    public static final int COMMENT=36;
    public static final int DOT=26;
    public static final int PERMUTED=15;
    public static final int GRAMMAR=4;
    public static final int CHOICE=9;
    public static final int RETURNS=7;
    public static final int CLOSE_BRACKET=30;

    // delegates
    // delegators

    public KGLexer() {;} 
    public KGLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public KGLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "src/core/koopa/core/grammars/generator/KG.g"; }

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:7:7: ( 'def' )
            // src/core/koopa/core/grammars/generator/KG.g:7:9: 'def'
            {
            match("def"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:8:7: ( 'returns' )
            // src/core/koopa/core/grammars/generator/KG.g:8:9: 'returns'
            {
            match("returns"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:9:7: ( 'end' )
            // src/core/koopa/core/grammars/generator/KG.g:9:9: 'end'
            {
            match("end"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:138:9: ( '#' (~ ( '\\n' | '\\r' ) )* )
            // src/core/koopa/core/grammars/generator/KG.g:138:11: '#' (~ ( '\\n' | '\\r' ) )*
            {
            match('#'); if (state.failed) return ;
            // src/core/koopa/core/grammars/generator/KG.g:138:15: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:138:16: ~ ( '\\n' | '\\r' )
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
            // src/core/koopa/core/grammars/generator/KG.g:140:9: ( ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' ) )
            // src/core/koopa/core/grammars/generator/KG.g:140:11: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
            {
            // src/core/koopa/core/grammars/generator/KG.g:140:11: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='\n') && (synpred1_KG())) {
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
                    // src/core/koopa/core/grammars/generator/KG.g:140:13: ( '\\r\\n' )=> '\\r\\n'
                    {
                    match("\r\n"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/grammars/generator/KG.g:140:34: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/grammars/generator/KG.g:140:41: '\\n'
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

    // $ANTLR start "NOSKIP"
    public final void mNOSKIP() throws RecognitionException {
        try {
            int _type = NOSKIP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:142:8: ( '%noskip' )
            // src/core/koopa/core/grammars/generator/KG.g:142:10: '%noskip'
            {
            match("%noskip"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOSKIP"

    // $ANTLR start "TAG"
    public final void mTAG() throws RecognitionException {
        try {
            int _type = TAG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:144:5: ( '@' LETTER ( LETTER | DIGIT | '-' | '_' )* )
            // src/core/koopa/core/grammars/generator/KG.g:144:7: '@' LETTER ( LETTER | DIGIT | '-' | '_' )*
            {
            match('@'); if (state.failed) return ;
            mLETTER(); if (state.failed) return ;
            // src/core/koopa/core/grammars/generator/KG.g:144:18: ( LETTER | DIGIT | '-' | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='-'||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TAG"

    // $ANTLR start "ANY"
    public final void mANY() throws RecognitionException {
        try {
            int _type = ANY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:146:5: ( '_' )
            // src/core/koopa/core/grammars/generator/KG.g:146:7: '_'
            {
            match('_'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANY"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:148:12: ( LETTER ( LETTER | DIGIT | '-' | '_' )* )
            // src/core/koopa/core/grammars/generator/KG.g:148:14: LETTER ( LETTER | DIGIT | '-' | '_' )*
            {
            mLETTER(); if (state.failed) return ;
            // src/core/koopa/core/grammars/generator/KG.g:148:21: ( LETTER | DIGIT | '-' | '_' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='-'||(LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "LITERAL"
    public final void mLITERAL() throws RecognitionException {
        try {
            int _type = LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:150:9: ( '\\'' (~ ( '\\'' | '\\n' | '\\r' ) )+ '\\'' )
            // src/core/koopa/core/grammars/generator/KG.g:150:11: '\\'' (~ ( '\\'' | '\\n' | '\\r' ) )+ '\\''
            {
            match('\''); if (state.failed) return ;
            // src/core/koopa/core/grammars/generator/KG.g:150:16: (~ ( '\\'' | '\\n' | '\\r' ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='\f')||(LA5_0>='\u000E' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:150:17: ~ ( '\\'' | '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
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
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            match('\''); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LITERAL"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:152:8: ( ( DIGIT )+ )
            // src/core/koopa/core/grammars/generator/KG.g:152:10: ( DIGIT )+
            {
            // src/core/koopa/core/grammars/generator/KG.g:152:10: ( DIGIT )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:152:10: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:154:12: ( ( ' ' | '\\t' )+ )
            // src/core/koopa/core/grammars/generator/KG.g:154:14: ( ' ' | '\\t' )+
            {
            // src/core/koopa/core/grammars/generator/KG.g:154:14: ( ' ' | '\\t' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\t'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:
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
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:156:8: ( '=' )
            // src/core/koopa/core/grammars/generator/KG.g:156:10: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "OPEN_PAREN"
    public final void mOPEN_PAREN() throws RecognitionException {
        try {
            int _type = OPEN_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:158:12: ( '(' )
            // src/core/koopa/core/grammars/generator/KG.g:158:14: '('
            {
            match('('); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPEN_PAREN"

    // $ANTLR start "CLOSE_PAREN"
    public final void mCLOSE_PAREN() throws RecognitionException {
        try {
            int _type = CLOSE_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:160:13: ( ')' )
            // src/core/koopa/core/grammars/generator/KG.g:160:15: ')'
            {
            match(')'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSE_PAREN"

    // $ANTLR start "OPEN_BRACKET"
    public final void mOPEN_BRACKET() throws RecognitionException {
        try {
            int _type = OPEN_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:162:14: ( '[' )
            // src/core/koopa/core/grammars/generator/KG.g:162:16: '['
            {
            match('['); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPEN_BRACKET"

    // $ANTLR start "CLOSE_BRACKET"
    public final void mCLOSE_BRACKET() throws RecognitionException {
        try {
            int _type = CLOSE_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:164:15: ( ']' )
            // src/core/koopa/core/grammars/generator/KG.g:164:17: ']'
            {
            match(']'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSE_BRACKET"

    // $ANTLR start "NATIVE_CODE"
    public final void mNATIVE_CODE() throws RecognitionException {
        try {
            int _type = NATIVE_CODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:168:13: ( '{' (~ '}' )* '}' )
            // src/core/koopa/core/grammars/generator/KG.g:168:15: '{' (~ '}' )* '}'
            {
            match('{'); if (state.failed) return ;
            // src/core/koopa/core/grammars/generator/KG.g:168:19: (~ '}' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='|')||(LA8_0>='~' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:168:20: ~ '}'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='|')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
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
            	    break loop8;
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
    // $ANTLR end "NATIVE_CODE"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:170:6: ( '*' )
            // src/core/koopa/core/grammars/generator/KG.g:170:8: '*'
            {
            match('*'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:172:6: ( '+' )
            // src/core/koopa/core/grammars/generator/KG.g:172:8: '+'
            {
            match('+'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "SKIP_TO"
    public final void mSKIP_TO() throws RecognitionException {
        try {
            int _type = SKIP_TO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:174:9: ( '-->' )
            // src/core/koopa/core/grammars/generator/KG.g:174:11: '-->'
            {
            match("-->"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SKIP_TO"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:176:5: ( '.' )
            // src/core/koopa/core/grammars/generator/KG.g:176:7: '.'
            {
            match('.'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:178:6: ( '|' )
            // src/core/koopa/core/grammars/generator/KG.g:178:8: '|'
            {
            match('|'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PIPE"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:180:7: ( ',' )
            // src/core/koopa/core/grammars/generator/KG.g:180:9: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "BANG"
    public final void mBANG() throws RecognitionException {
        try {
            int _type = BANG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:182:6: ( '!' )
            // src/core/koopa/core/grammars/generator/KG.g:182:8: '!'
            {
            match('!'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BANG"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:184:5: ( '-' )
            // src/core/koopa/core/grammars/generator/KG.g:184:7: '-'
            {
            match('-'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KG.g:186:17: ( 'a' .. 'z' | 'A' .. 'Z' )
            // src/core/koopa/core/grammars/generator/KG.g:
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

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KG.g:187:16: ( '0' .. '9' )
            // src/core/koopa/core/grammars/generator/KG.g:187:18: '0' .. '9'
            {
            matchRange('0','9'); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    public void mTokens() throws RecognitionException {
        // src/core/koopa/core/grammars/generator/KG.g:1:8: ( T__41 | T__42 | T__43 | COMMENT | NEWLINE | NOSKIP | TAG | ANY | IDENTIFIER | LITERAL | NUMBER | WHITESPACE | EQUALS | OPEN_PAREN | CLOSE_PAREN | OPEN_BRACKET | CLOSE_BRACKET | NATIVE_CODE | STAR | PLUS | SKIP_TO | DOT | PIPE | COMMA | BANG | NOT )
        int alt9=26;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // src/core/koopa/core/grammars/generator/KG.g:1:10: T__41
                {
                mT__41(); if (state.failed) return ;

                }
                break;
            case 2 :
                // src/core/koopa/core/grammars/generator/KG.g:1:16: T__42
                {
                mT__42(); if (state.failed) return ;

                }
                break;
            case 3 :
                // src/core/koopa/core/grammars/generator/KG.g:1:22: T__43
                {
                mT__43(); if (state.failed) return ;

                }
                break;
            case 4 :
                // src/core/koopa/core/grammars/generator/KG.g:1:28: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 5 :
                // src/core/koopa/core/grammars/generator/KG.g:1:36: NEWLINE
                {
                mNEWLINE(); if (state.failed) return ;

                }
                break;
            case 6 :
                // src/core/koopa/core/grammars/generator/KG.g:1:44: NOSKIP
                {
                mNOSKIP(); if (state.failed) return ;

                }
                break;
            case 7 :
                // src/core/koopa/core/grammars/generator/KG.g:1:51: TAG
                {
                mTAG(); if (state.failed) return ;

                }
                break;
            case 8 :
                // src/core/koopa/core/grammars/generator/KG.g:1:55: ANY
                {
                mANY(); if (state.failed) return ;

                }
                break;
            case 9 :
                // src/core/koopa/core/grammars/generator/KG.g:1:59: IDENTIFIER
                {
                mIDENTIFIER(); if (state.failed) return ;

                }
                break;
            case 10 :
                // src/core/koopa/core/grammars/generator/KG.g:1:70: LITERAL
                {
                mLITERAL(); if (state.failed) return ;

                }
                break;
            case 11 :
                // src/core/koopa/core/grammars/generator/KG.g:1:78: NUMBER
                {
                mNUMBER(); if (state.failed) return ;

                }
                break;
            case 12 :
                // src/core/koopa/core/grammars/generator/KG.g:1:85: WHITESPACE
                {
                mWHITESPACE(); if (state.failed) return ;

                }
                break;
            case 13 :
                // src/core/koopa/core/grammars/generator/KG.g:1:96: EQUALS
                {
                mEQUALS(); if (state.failed) return ;

                }
                break;
            case 14 :
                // src/core/koopa/core/grammars/generator/KG.g:1:103: OPEN_PAREN
                {
                mOPEN_PAREN(); if (state.failed) return ;

                }
                break;
            case 15 :
                // src/core/koopa/core/grammars/generator/KG.g:1:114: CLOSE_PAREN
                {
                mCLOSE_PAREN(); if (state.failed) return ;

                }
                break;
            case 16 :
                // src/core/koopa/core/grammars/generator/KG.g:1:126: OPEN_BRACKET
                {
                mOPEN_BRACKET(); if (state.failed) return ;

                }
                break;
            case 17 :
                // src/core/koopa/core/grammars/generator/KG.g:1:139: CLOSE_BRACKET
                {
                mCLOSE_BRACKET(); if (state.failed) return ;

                }
                break;
            case 18 :
                // src/core/koopa/core/grammars/generator/KG.g:1:153: NATIVE_CODE
                {
                mNATIVE_CODE(); if (state.failed) return ;

                }
                break;
            case 19 :
                // src/core/koopa/core/grammars/generator/KG.g:1:165: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 20 :
                // src/core/koopa/core/grammars/generator/KG.g:1:170: PLUS
                {
                mPLUS(); if (state.failed) return ;

                }
                break;
            case 21 :
                // src/core/koopa/core/grammars/generator/KG.g:1:175: SKIP_TO
                {
                mSKIP_TO(); if (state.failed) return ;

                }
                break;
            case 22 :
                // src/core/koopa/core/grammars/generator/KG.g:1:183: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 23 :
                // src/core/koopa/core/grammars/generator/KG.g:1:187: PIPE
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 24 :
                // src/core/koopa/core/grammars/generator/KG.g:1:192: COMMA
                {
                mCOMMA(); if (state.failed) return ;

                }
                break;
            case 25 :
                // src/core/koopa/core/grammars/generator/KG.g:1:198: BANG
                {
                mBANG(); if (state.failed) return ;

                }
                break;
            case 26 :
                // src/core/koopa/core/grammars/generator/KG.g:1:203: NOT
                {
                mNOT(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_KG
    public final void synpred1_KG_fragment() throws RecognitionException {   
        // src/core/koopa/core/grammars/generator/KG.g:140:13: ( '\\r\\n' )
        // src/core/koopa/core/grammars/generator/KG.g:140:14: '\\r\\n'
        {
        match("\r\n"); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred1_KG

    public final boolean synpred1_KG() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_KG_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\3\11\21\uffff\1\36\4\uffff\3\11\2\uffff\1\42\1\11\1\44"+
        "\1\uffff\1\11\1\uffff\2\11\1\50\1\uffff";
    static final String DFA9_eofS =
        "\51\uffff";
    static final String DFA9_minS =
        "\1\11\2\145\1\156\21\uffff\1\55\4\uffff\1\146\1\164\1\144\2\uffff"+
        "\1\55\1\165\1\55\1\uffff\1\162\1\uffff\1\156\1\163\1\55\1\uffff";
    static final String DFA9_maxS =
        "\1\174\2\145\1\156\21\uffff\1\55\4\uffff\1\146\1\164\1\144\2\uffff"+
        "\1\172\1\165\1\172\1\uffff\1\162\1\uffff\1\156\1\163\1\172\1\uffff";
    static final String DFA9_acceptS =
        "\4\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
        "\1\20\1\21\1\22\1\23\1\24\1\uffff\1\26\1\27\1\30\1\31\3\uffff\1"+
        "\25\1\32\3\uffff\1\1\1\uffff\1\3\3\uffff\1\2";
    static final String DFA9_specialS =
        "\51\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\14\1\5\2\uffff\1\5\22\uffff\1\14\1\31\1\uffff\1\4\1\uffff"+
            "\1\6\1\uffff\1\12\1\16\1\17\1\23\1\24\1\30\1\25\1\26\1\uffff"+
            "\12\13\3\uffff\1\15\2\uffff\1\7\32\11\1\20\1\uffff\1\21\1\uffff"+
            "\1\10\1\uffff\3\11\1\1\1\3\14\11\1\2\10\11\1\22\1\27",
            "\1\32",
            "\1\33",
            "\1\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\35",
            "",
            "",
            "",
            "",
            "\1\37",
            "\1\40",
            "\1\41",
            "",
            "",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\43",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "",
            "\1\45",
            "",
            "\1\46",
            "\1\47",
            "\1\11\2\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__41 | T__42 | T__43 | COMMENT | NEWLINE | NOSKIP | TAG | ANY | IDENTIFIER | LITERAL | NUMBER | WHITESPACE | EQUALS | OPEN_PAREN | CLOSE_PAREN | OPEN_BRACKET | CLOSE_BRACKET | NATIVE_CODE | STAR | PLUS | SKIP_TO | DOT | PIPE | COMMA | BANG | NOT );";
        }
    }
 

}