// $ANTLR 3.1.1 src/core/koopa/core/grammars/generator/KG.g 2015-01-22 21:19:48

  package koopa.core.grammars.generator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class KGLexer extends Lexer {
    public static final int SKIP_TO=34;
    public static final int STAR=30;
    public static final int LIMIT=38;
    public static final int LETTER=43;
    public static final int EQUALS=23;
    public static final int NOT=36;
    public static final int NOSKIP=37;
    public static final int EOF=-1;
    public static final int DECLARATION=16;
    public static final int META=5;
    public static final int OPEN_BRACKET=32;
    public static final int NATIVE_CODE=25;
    public static final int COMMA=24;
    public static final int EXTENDING=7;
    public static final int IDENTIFIER=19;
    public static final int PIPE=40;
    public static final int PLUS=31;
    public static final int BODY=9;
    public static final int CLOSE_PAREN=22;
    public static final int DIGIT=44;
    public static final int COMMENT=41;
    public static final int DOT=20;
    public static final int T__50=50;
    public static final int CHOICE=12;
    public static final int GRAMMAR=4;
    public static final int RETURNS=10;
    public static final int BY=39;
    public static final int ACT=14;
    public static final int LOCALS=17;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int RULE=8;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int NUMBER=29;
    public static final int WHITESPACE=45;
    public static final int OPEN_PAREN=21;
    public static final int LITERAL=28;
    public static final int BANG=35;
    public static final int TAG=26;
    public static final int OPTIONAL=13;
    public static final int SEQUENCE=11;
    public static final int ANY=27;
    public static final int NEWLINE=42;
    public static final int NAMED=6;
    public static final int ASSIGN=15;
    public static final int PERMUTED=18;
    public static final int CLOSE_BRACKET=33;

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

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:7:7: ( 'grammar' )
            // src/core/koopa/core/grammars/generator/KG.g:7:9: 'grammar'
            {
            match("grammar"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:8:7: ( 'extends' )
            // src/core/koopa/core/grammars/generator/KG.g:8:9: 'extends'
            {
            match("extends"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:9:7: ( 'def' )
            // src/core/koopa/core/grammars/generator/KG.g:9:9: 'def'
            {
            match("def"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:10:7: ( 'returns' )
            // src/core/koopa/core/grammars/generator/KG.g:10:9: 'returns'
            {
            match("returns"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:11:7: ( 'end' )
            // src/core/koopa/core/grammars/generator/KG.g:11:9: 'end'
            {
            match("end"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:156:9: ( '#' (~ ( '\\n' | '\\r' ) )* )
            // src/core/koopa/core/grammars/generator/KG.g:156:11: '#' (~ ( '\\n' | '\\r' ) )*
            {
            match('#'); if (state.failed) return ;
            // src/core/koopa/core/grammars/generator/KG.g:156:15: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:156:16: ~ ( '\\n' | '\\r' )
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
            // src/core/koopa/core/grammars/generator/KG.g:158:9: ( ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' ) )
            // src/core/koopa/core/grammars/generator/KG.g:158:11: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
            {
            // src/core/koopa/core/grammars/generator/KG.g:158:11: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
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
                    // src/core/koopa/core/grammars/generator/KG.g:158:13: ( '\\r\\n' )=> '\\r\\n'
                    {
                    match("\r\n"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/grammars/generator/KG.g:158:34: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/grammars/generator/KG.g:158:41: '\\n'
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
            // src/core/koopa/core/grammars/generator/KG.g:160:8: ( '%noskip' )
            // src/core/koopa/core/grammars/generator/KG.g:160:10: '%noskip'
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

    // $ANTLR start "LIMIT"
    public final void mLIMIT() throws RecognitionException {
        try {
            int _type = LIMIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:162:7: ( '%limit' )
            // src/core/koopa/core/grammars/generator/KG.g:162:9: '%limit'
            {
            match("%limit"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LIMIT"

    // $ANTLR start "BY"
    public final void mBY() throws RecognitionException {
        try {
            int _type = BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:164:4: ( '%by' )
            // src/core/koopa/core/grammars/generator/KG.g:164:6: '%by'
            {
            match("%by"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BY"

    // $ANTLR start "TAG"
    public final void mTAG() throws RecognitionException {
        try {
            int _type = TAG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/core/koopa/core/grammars/generator/KG.g:166:5: ( '@' LETTER ( LETTER | DIGIT | '-' | '_' )* )
            // src/core/koopa/core/grammars/generator/KG.g:166:7: '@' LETTER ( LETTER | DIGIT | '-' | '_' )*
            {
            match('@'); if (state.failed) return ;
            mLETTER(); if (state.failed) return ;
            // src/core/koopa/core/grammars/generator/KG.g:166:18: ( LETTER | DIGIT | '-' | '_' )*
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
            // src/core/koopa/core/grammars/generator/KG.g:168:5: ( '_' )
            // src/core/koopa/core/grammars/generator/KG.g:168:7: '_'
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
            // src/core/koopa/core/grammars/generator/KG.g:170:12: ( LETTER ( LETTER | DIGIT | '-' | '_' )* )
            // src/core/koopa/core/grammars/generator/KG.g:170:14: LETTER ( LETTER | DIGIT | '-' | '_' )*
            {
            mLETTER(); if (state.failed) return ;
            // src/core/koopa/core/grammars/generator/KG.g:170:21: ( LETTER | DIGIT | '-' | '_' )*
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
            // src/core/koopa/core/grammars/generator/KG.g:172:9: ( '\\'' (~ ( '\\'' | '\\n' | '\\r' ) )+ '\\'' )
            // src/core/koopa/core/grammars/generator/KG.g:172:11: '\\'' (~ ( '\\'' | '\\n' | '\\r' ) )+ '\\''
            {
            match('\''); if (state.failed) return ;
            // src/core/koopa/core/grammars/generator/KG.g:172:16: (~ ( '\\'' | '\\n' | '\\r' ) )+
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
            	    // src/core/koopa/core/grammars/generator/KG.g:172:17: ~ ( '\\'' | '\\n' | '\\r' )
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
            // src/core/koopa/core/grammars/generator/KG.g:174:8: ( ( DIGIT )+ )
            // src/core/koopa/core/grammars/generator/KG.g:174:10: ( DIGIT )+
            {
            // src/core/koopa/core/grammars/generator/KG.g:174:10: ( DIGIT )+
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
            	    // src/core/koopa/core/grammars/generator/KG.g:174:10: DIGIT
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
            // src/core/koopa/core/grammars/generator/KG.g:176:12: ( ( ' ' | '\\t' )+ )
            // src/core/koopa/core/grammars/generator/KG.g:176:14: ( ' ' | '\\t' )+
            {
            // src/core/koopa/core/grammars/generator/KG.g:176:14: ( ' ' | '\\t' )+
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
            // src/core/koopa/core/grammars/generator/KG.g:178:8: ( '=' )
            // src/core/koopa/core/grammars/generator/KG.g:178:10: '='
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
            // src/core/koopa/core/grammars/generator/KG.g:180:12: ( '(' )
            // src/core/koopa/core/grammars/generator/KG.g:180:14: '('
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
            // src/core/koopa/core/grammars/generator/KG.g:182:13: ( ')' )
            // src/core/koopa/core/grammars/generator/KG.g:182:15: ')'
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
            // src/core/koopa/core/grammars/generator/KG.g:184:14: ( '[' )
            // src/core/koopa/core/grammars/generator/KG.g:184:16: '['
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
            // src/core/koopa/core/grammars/generator/KG.g:186:15: ( ']' )
            // src/core/koopa/core/grammars/generator/KG.g:186:17: ']'
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
            // src/core/koopa/core/grammars/generator/KG.g:190:13: ( '{' (~ '}' )* '}' )
            // src/core/koopa/core/grammars/generator/KG.g:190:15: '{' (~ '}' )* '}'
            {
            match('{'); if (state.failed) return ;
            // src/core/koopa/core/grammars/generator/KG.g:190:19: (~ '}' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='|')||(LA8_0>='~' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:190:20: ~ '}'
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
            // src/core/koopa/core/grammars/generator/KG.g:192:6: ( '*' )
            // src/core/koopa/core/grammars/generator/KG.g:192:8: '*'
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
            // src/core/koopa/core/grammars/generator/KG.g:194:6: ( '+' )
            // src/core/koopa/core/grammars/generator/KG.g:194:8: '+'
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
            // src/core/koopa/core/grammars/generator/KG.g:196:9: ( '-->' )
            // src/core/koopa/core/grammars/generator/KG.g:196:11: '-->'
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
            // src/core/koopa/core/grammars/generator/KG.g:198:5: ( '.' )
            // src/core/koopa/core/grammars/generator/KG.g:198:7: '.'
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
            // src/core/koopa/core/grammars/generator/KG.g:200:6: ( '|' )
            // src/core/koopa/core/grammars/generator/KG.g:200:8: '|'
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
            // src/core/koopa/core/grammars/generator/KG.g:202:7: ( ',' )
            // src/core/koopa/core/grammars/generator/KG.g:202:9: ','
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
            // src/core/koopa/core/grammars/generator/KG.g:204:6: ( '!' )
            // src/core/koopa/core/grammars/generator/KG.g:204:8: '!'
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
            // src/core/koopa/core/grammars/generator/KG.g:206:5: ( '-' )
            // src/core/koopa/core/grammars/generator/KG.g:206:7: '-'
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
            // src/core/koopa/core/grammars/generator/KG.g:208:17: ( 'a' .. 'z' | 'A' .. 'Z' )
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
            // src/core/koopa/core/grammars/generator/KG.g:209:16: ( '0' .. '9' )
            // src/core/koopa/core/grammars/generator/KG.g:209:18: '0' .. '9'
            {
            matchRange('0','9'); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    public void mTokens() throws RecognitionException {
        // src/core/koopa/core/grammars/generator/KG.g:1:8: ( T__46 | T__47 | T__48 | T__49 | T__50 | COMMENT | NEWLINE | NOSKIP | LIMIT | BY | TAG | ANY | IDENTIFIER | LITERAL | NUMBER | WHITESPACE | EQUALS | OPEN_PAREN | CLOSE_PAREN | OPEN_BRACKET | CLOSE_BRACKET | NATIVE_CODE | STAR | PLUS | SKIP_TO | DOT | PIPE | COMMA | BANG | NOT )
        int alt9=30;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // src/core/koopa/core/grammars/generator/KG.g:1:10: T__46
                {
                mT__46(); if (state.failed) return ;

                }
                break;
            case 2 :
                // src/core/koopa/core/grammars/generator/KG.g:1:16: T__47
                {
                mT__47(); if (state.failed) return ;

                }
                break;
            case 3 :
                // src/core/koopa/core/grammars/generator/KG.g:1:22: T__48
                {
                mT__48(); if (state.failed) return ;

                }
                break;
            case 4 :
                // src/core/koopa/core/grammars/generator/KG.g:1:28: T__49
                {
                mT__49(); if (state.failed) return ;

                }
                break;
            case 5 :
                // src/core/koopa/core/grammars/generator/KG.g:1:34: T__50
                {
                mT__50(); if (state.failed) return ;

                }
                break;
            case 6 :
                // src/core/koopa/core/grammars/generator/KG.g:1:40: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 7 :
                // src/core/koopa/core/grammars/generator/KG.g:1:48: NEWLINE
                {
                mNEWLINE(); if (state.failed) return ;

                }
                break;
            case 8 :
                // src/core/koopa/core/grammars/generator/KG.g:1:56: NOSKIP
                {
                mNOSKIP(); if (state.failed) return ;

                }
                break;
            case 9 :
                // src/core/koopa/core/grammars/generator/KG.g:1:63: LIMIT
                {
                mLIMIT(); if (state.failed) return ;

                }
                break;
            case 10 :
                // src/core/koopa/core/grammars/generator/KG.g:1:69: BY
                {
                mBY(); if (state.failed) return ;

                }
                break;
            case 11 :
                // src/core/koopa/core/grammars/generator/KG.g:1:72: TAG
                {
                mTAG(); if (state.failed) return ;

                }
                break;
            case 12 :
                // src/core/koopa/core/grammars/generator/KG.g:1:76: ANY
                {
                mANY(); if (state.failed) return ;

                }
                break;
            case 13 :
                // src/core/koopa/core/grammars/generator/KG.g:1:80: IDENTIFIER
                {
                mIDENTIFIER(); if (state.failed) return ;

                }
                break;
            case 14 :
                // src/core/koopa/core/grammars/generator/KG.g:1:91: LITERAL
                {
                mLITERAL(); if (state.failed) return ;

                }
                break;
            case 15 :
                // src/core/koopa/core/grammars/generator/KG.g:1:99: NUMBER
                {
                mNUMBER(); if (state.failed) return ;

                }
                break;
            case 16 :
                // src/core/koopa/core/grammars/generator/KG.g:1:106: WHITESPACE
                {
                mWHITESPACE(); if (state.failed) return ;

                }
                break;
            case 17 :
                // src/core/koopa/core/grammars/generator/KG.g:1:117: EQUALS
                {
                mEQUALS(); if (state.failed) return ;

                }
                break;
            case 18 :
                // src/core/koopa/core/grammars/generator/KG.g:1:124: OPEN_PAREN
                {
                mOPEN_PAREN(); if (state.failed) return ;

                }
                break;
            case 19 :
                // src/core/koopa/core/grammars/generator/KG.g:1:135: CLOSE_PAREN
                {
                mCLOSE_PAREN(); if (state.failed) return ;

                }
                break;
            case 20 :
                // src/core/koopa/core/grammars/generator/KG.g:1:147: OPEN_BRACKET
                {
                mOPEN_BRACKET(); if (state.failed) return ;

                }
                break;
            case 21 :
                // src/core/koopa/core/grammars/generator/KG.g:1:160: CLOSE_BRACKET
                {
                mCLOSE_BRACKET(); if (state.failed) return ;

                }
                break;
            case 22 :
                // src/core/koopa/core/grammars/generator/KG.g:1:174: NATIVE_CODE
                {
                mNATIVE_CODE(); if (state.failed) return ;

                }
                break;
            case 23 :
                // src/core/koopa/core/grammars/generator/KG.g:1:186: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 24 :
                // src/core/koopa/core/grammars/generator/KG.g:1:191: PLUS
                {
                mPLUS(); if (state.failed) return ;

                }
                break;
            case 25 :
                // src/core/koopa/core/grammars/generator/KG.g:1:196: SKIP_TO
                {
                mSKIP_TO(); if (state.failed) return ;

                }
                break;
            case 26 :
                // src/core/koopa/core/grammars/generator/KG.g:1:204: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 27 :
                // src/core/koopa/core/grammars/generator/KG.g:1:208: PIPE
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 28 :
                // src/core/koopa/core/grammars/generator/KG.g:1:213: COMMA
                {
                mCOMMA(); if (state.failed) return ;

                }
                break;
            case 29 :
                // src/core/koopa/core/grammars/generator/KG.g:1:219: BANG
                {
                mBANG(); if (state.failed) return ;

                }
                break;
            case 30 :
                // src/core/koopa/core/grammars/generator/KG.g:1:224: NOT
                {
                mNOT(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_KG
    public final void synpred1_KG_fragment() throws RecognitionException {   
        // src/core/koopa/core/grammars/generator/KG.g:158:13: ( '\\r\\n' )
        // src/core/koopa/core/grammars/generator/KG.g:158:14: '\\r\\n'
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
        "\1\uffff\4\12\21\uffff\1\44\4\uffff\5\12\5\uffff\2\12\1\54\1\55"+
        "\3\12\2\uffff\7\12\1\70\1\71\1\72\3\uffff";
    static final String DFA9_eofS =
        "\73\uffff";
    static final String DFA9_minS =
        "\1\11\1\162\1\156\2\145\2\uffff\1\142\16\uffff\1\55\4\uffff\1\141"+
        "\1\164\1\144\1\146\1\164\5\uffff\1\155\1\145\2\55\1\165\1\155\1"+
        "\156\2\uffff\1\162\1\141\1\144\1\156\1\162\2\163\3\55\3\uffff";
    static final String DFA9_maxS =
        "\1\174\1\162\1\170\2\145\2\uffff\1\156\16\uffff\1\55\4\uffff\1\141"+
        "\1\164\1\144\1\146\1\164\5\uffff\1\155\1\145\2\172\1\165\1\155\1"+
        "\156\2\uffff\1\162\1\141\1\144\1\156\1\162\2\163\3\172\3\uffff";
    static final String DFA9_acceptS =
        "\5\uffff\1\6\1\7\1\uffff\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22"+
        "\1\23\1\24\1\25\1\26\1\27\1\30\1\uffff\1\32\1\33\1\34\1\35\5\uffff"+
        "\1\10\1\11\1\12\1\31\1\36\7\uffff\1\5\1\3\12\uffff\1\1\1\2\1\4";
    static final String DFA9_specialS =
        "\73\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\15\1\6\2\uffff\1\6\22\uffff\1\15\1\32\1\uffff\1\5\1\uffff"+
            "\1\7\1\uffff\1\13\1\17\1\20\1\24\1\25\1\31\1\26\1\27\1\uffff"+
            "\12\14\3\uffff\1\16\2\uffff\1\10\32\12\1\21\1\uffff\1\22\1\uffff"+
            "\1\11\1\uffff\3\12\1\3\1\2\1\12\1\1\12\12\1\4\10\12\1\23\1\30",
            "\1\33",
            "\1\35\11\uffff\1\34",
            "\1\36",
            "\1\37",
            "",
            "",
            "\1\42\11\uffff\1\41\1\uffff\1\40",
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
            "\1\43",
            "",
            "",
            "",
            "",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "",
            "",
            "",
            "",
            "",
            "\1\52",
            "\1\53",
            "\1\12\2\uffff\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
            "\1\12\2\uffff\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
            "\1\56",
            "\1\57",
            "\1\60",
            "",
            "",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\12\2\uffff\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
            "\1\12\2\uffff\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
            "\1\12\2\uffff\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
            "",
            "",
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
            return "1:1: Tokens : ( T__46 | T__47 | T__48 | T__49 | T__50 | COMMENT | NEWLINE | NOSKIP | LIMIT | BY | TAG | ANY | IDENTIFIER | LITERAL | NUMBER | WHITESPACE | EQUALS | OPEN_PAREN | CLOSE_PAREN | OPEN_BRACKET | CLOSE_BRACKET | NATIVE_CODE | STAR | PLUS | SKIP_TO | DOT | PIPE | COMMA | BANG | NOT );";
        }
    }
 

}