// $ANTLR 3.1.1 src/core/koopa/core/grammars/generator/KGTreeParser.g 2014-11-24 20:28:00

  package koopa.core.grammars.generator;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class KGTreeParser extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "GRAMMAR", "META", "NAMED", "EXTENDING", "RULE", "BODY", "RETURNS", "SEQUENCE", "CHOICE", "OPTIONAL", "ACT", "ASSIGN", "DECLARATION", "LOCALS", "PERMUTED", "IDENTIFIER", "DOT", "OPEN_PAREN", "CLOSE_PAREN", "EQUALS", "COMMA", "NATIVE_CODE", "TAG", "ANY", "LITERAL", "NUMBER", "STAR", "PLUS", "OPEN_BRACKET", "CLOSE_BRACKET", "SKIP_TO", "BANG", "NOT", "NOSKIP", "PIPE", "COMMENT", "NEWLINE", "LETTER", "DIGIT", "WHITESPACE", "'grammar'", "'extends'", "'def'", "'returns'", "'end'"
    };
    public static final int SKIP_TO=34;
    public static final int STAR=30;
    public static final int LETTER=41;
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
    public static final int PLUS=31;
    public static final int PIPE=38;
    public static final int BODY=9;
    public static final int CLOSE_PAREN=22;
    public static final int DIGIT=42;
    public static final int COMMENT=39;
    public static final int DOT=20;
    public static final int CHOICE=12;
    public static final int GRAMMAR=4;
    public static final int RETURNS=10;
    public static final int ACT=14;
    public static final int LOCALS=17;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int RULE=8;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int NUMBER=29;
    public static final int WHITESPACE=43;
    public static final int OPEN_PAREN=21;
    public static final int LITERAL=28;
    public static final int BANG=35;
    public static final int OPTIONAL=13;
    public static final int TAG=26;
    public static final int SEQUENCE=11;
    public static final int ANY=27;
    public static final int NEWLINE=40;
    public static final int NAMED=6;
    public static final int ASSIGN=15;
    public static final int PERMUTED=18;
    public static final int CLOSE_BRACKET=33;

    // delegates
    // delegators


        public KGTreeParser(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public KGTreeParser(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return KGTreeParser.tokenNames; }
    public String getGrammarFileName() { return "src/core/koopa/core/grammars/generator/KGTreeParser.g"; }





    // $ANTLR start "koopa"
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:17:1: koopa : ^( GRAMMAR meta ( rule )* ) ;
    public final void koopa() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:18:3: ( ^( GRAMMAR meta ( rule )* ) )
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:18:5: ^( GRAMMAR meta ( rule )* )
            {
            match(input,GRAMMAR,FOLLOW_GRAMMAR_in_koopa66); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_meta_in_koopa68);
            meta();

            state._fsp--;

            // src/core/koopa/core/grammars/generator/KGTreeParser.g:18:20: ( rule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KGTreeParser.g:18:20: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_koopa70);
            	    rule();

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
    // $ANTLR end "koopa"


    // $ANTLR start "meta"
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:21:1: meta : ^( META named ( extending )? ) ;
    public final void meta() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:22:3: ( ^( META named ( extending )? ) )
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:22:5: ^( META named ( extending )? )
            {
            match(input,META,FOLLOW_META_in_meta86); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_named_in_meta88);
            named();

            state._fsp--;

            // src/core/koopa/core/grammars/generator/KGTreeParser.g:22:18: ( extending )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==EXTENDING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:22:18: extending
                    {
                    pushFollow(FOLLOW_extending_in_meta90);
                    extending();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "meta"


    // $ANTLR start "named"
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:25:1: named : ^( NAMED IDENTIFIER ) ;
    public final void named() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:26:3: ( ^( NAMED IDENTIFIER ) )
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:26:5: ^( NAMED IDENTIFIER )
            {
            match(input,NAMED,FOLLOW_NAMED_in_named106); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_named108); 

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
    // $ANTLR end "named"


    // $ANTLR start "extending"
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:29:1: extending : ^( EXTENDING IDENTIFIER ) ;
    public final void extending() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:30:3: ( ^( EXTENDING IDENTIFIER ) )
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:30:5: ^( EXTENDING IDENTIFIER )
            {
            match(input,EXTENDING,FOLLOW_EXTENDING_in_extending123); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_extending125); 

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
    // $ANTLR end "extending"


    // $ANTLR start "rule"
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:33:1: rule : ^( RULE IDENTIFIER ( locals )? ( returning )? body ) ;
    public final void rule() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:34:3: ( ^( RULE IDENTIFIER ( locals )? ( returning )? body ) )
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:34:5: ^( RULE IDENTIFIER ( locals )? ( returning )? body )
            {
            match(input,RULE,FOLLOW_RULE_in_rule140); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule142); 
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:35:7: ( locals )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LOCALS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:35:7: locals
                    {
                    pushFollow(FOLLOW_locals_in_rule151);
                    locals();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/grammars/generator/KGTreeParser.g:36:7: ( returning )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RETURNS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:36:7: returning
                    {
                    pushFollow(FOLLOW_returning_in_rule160);
                    returning();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_body_in_rule169);
            body();

            state._fsp--;


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
    // $ANTLR end "rule"


    // $ANTLR start "returning"
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:41:1: returning : ^( RETURNS IDENTIFIER ) ;
    public final void returning() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:42:3: ( ^( RETURNS IDENTIFIER ) )
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:42:5: ^( RETURNS IDENTIFIER )
            {
            match(input,RETURNS,FOLLOW_RETURNS_in_returning189); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_returning191); 

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
    // $ANTLR end "returning"


    // $ANTLR start "locals"
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:45:1: locals : ^( LOCALS ( declaration )+ ) ;
    public final void locals() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:46:3: ( ^( LOCALS ( declaration )+ ) )
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:46:5: ^( LOCALS ( declaration )+ )
            {
            match(input,LOCALS,FOLLOW_LOCALS_in_locals208); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:47:7: ( declaration )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==DECLARATION) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KGTreeParser.g:47:7: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_locals216);
            	    declaration();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
    // $ANTLR end "locals"


    // $ANTLR start "declaration"
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:51:1: declaration : ^( DECLARATION IDENTIFIER IDENTIFIER ) ;
    public final void declaration() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:52:3: ( ^( DECLARATION IDENTIFIER IDENTIFIER ) )
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:52:5: ^( DECLARATION IDENTIFIER IDENTIFIER )
            {
            match(input,DECLARATION,FOLLOW_DECLARATION_in_declaration237); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration239); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration241); 

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
    // $ANTLR end "declaration"


    // $ANTLR start "body"
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:55:1: body : ( ^( SEQUENCE ( body )+ ) | ^( ACT NATIVE_CODE ) | IDENTIFIER | TAG | ANY | LITERAL | NUMBER | DOT | ^( ASSIGN IDENTIFIER ( IDENTIFIER | NUMBER | DOT ) ) | ^( STAR body ) | ^( PLUS body ) | ^( CHOICE ( body )+ ) | ^( OPTIONAL body ) | ^( SKIP_TO body ) | ^( PERMUTED ( body )+ ) | ^( NOT body ) | ^( NOSKIP body ) );
    public final void body() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:56:3: ( ^( SEQUENCE ( body )+ ) | ^( ACT NATIVE_CODE ) | IDENTIFIER | TAG | ANY | LITERAL | NUMBER | DOT | ^( ASSIGN IDENTIFIER ( IDENTIFIER | NUMBER | DOT ) ) | ^( STAR body ) | ^( PLUS body ) | ^( CHOICE ( body )+ ) | ^( OPTIONAL body ) | ^( SKIP_TO body ) | ^( PERMUTED ( body )+ ) | ^( NOT body ) | ^( NOSKIP body ) )
            int alt9=17;
            switch ( input.LA(1) ) {
            case SEQUENCE:
                {
                alt9=1;
                }
                break;
            case ACT:
                {
                alt9=2;
                }
                break;
            case IDENTIFIER:
                {
                alt9=3;
                }
                break;
            case TAG:
                {
                alt9=4;
                }
                break;
            case ANY:
                {
                alt9=5;
                }
                break;
            case LITERAL:
                {
                alt9=6;
                }
                break;
            case NUMBER:
                {
                alt9=7;
                }
                break;
            case DOT:
                {
                alt9=8;
                }
                break;
            case ASSIGN:
                {
                alt9=9;
                }
                break;
            case STAR:
                {
                alt9=10;
                }
                break;
            case PLUS:
                {
                alt9=11;
                }
                break;
            case CHOICE:
                {
                alt9=12;
                }
                break;
            case OPTIONAL:
                {
                alt9=13;
                }
                break;
            case SKIP_TO:
                {
                alt9=14;
                }
                break;
            case PERMUTED:
                {
                alt9=15;
                }
                break;
            case NOT:
                {
                alt9=16;
                }
                break;
            case NOSKIP:
                {
                alt9=17;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:56:5: ^( SEQUENCE ( body )+ )
                    {
                    match(input,SEQUENCE,FOLLOW_SEQUENCE_in_body256); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:57:7: ( body )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=SEQUENCE && LA6_0<=ASSIGN)||(LA6_0>=PERMUTED && LA6_0<=DOT)||(LA6_0>=TAG && LA6_0<=PLUS)||LA6_0==SKIP_TO||(LA6_0>=NOT && LA6_0<=NOSKIP)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KGTreeParser.g:57:7: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_body265);
                    	    body();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:60:5: ^( ACT NATIVE_CODE )
                    {
                    match(input,ACT,FOLLOW_ACT_in_body282); 

                    match(input, Token.DOWN, null); 
                    match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_body284); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:62:5: IDENTIFIER
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body296); 

                    }
                    break;
                case 4 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:64:5: TAG
                    {
                    match(input,TAG,FOLLOW_TAG_in_body305); 

                    }
                    break;
                case 5 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:66:5: ANY
                    {
                    match(input,ANY,FOLLOW_ANY_in_body312); 

                    }
                    break;
                case 6 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:68:5: LITERAL
                    {
                    match(input,LITERAL,FOLLOW_LITERAL_in_body319); 

                    }
                    break;
                case 7 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:70:5: NUMBER
                    {
                    match(input,NUMBER,FOLLOW_NUMBER_in_body328); 

                    }
                    break;
                case 8 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:72:5: DOT
                    {
                    match(input,DOT,FOLLOW_DOT_in_body337); 

                    }
                    break;
                case 9 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:74:5: ^( ASSIGN IDENTIFIER ( IDENTIFIER | NUMBER | DOT ) )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_body347); 

                    match(input, Token.DOWN, null); 
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body349); 
                    if ( (input.LA(1)>=IDENTIFIER && input.LA(1)<=DOT)||input.LA(1)==NUMBER ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 10 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:76:5: ^( STAR body )
                    {
                    match(input,STAR,FOLLOW_STAR_in_body372); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body374);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 11 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:78:5: ^( PLUS body )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_body385); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body387);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 12 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:80:5: ^( CHOICE ( body )+ )
                    {
                    match(input,CHOICE,FOLLOW_CHOICE_in_body398); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:81:7: ( body )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>=SEQUENCE && LA7_0<=ASSIGN)||(LA7_0>=PERMUTED && LA7_0<=DOT)||(LA7_0>=TAG && LA7_0<=PLUS)||LA7_0==SKIP_TO||(LA7_0>=NOT && LA7_0<=NOSKIP)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KGTreeParser.g:81:7: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_body406);
                    	    body();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 13 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:84:5: ^( OPTIONAL body )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_body425); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body433);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 14 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:88:5: ^( SKIP_TO body )
                    {
                    match(input,SKIP_TO,FOLLOW_SKIP_TO_in_body449); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body457);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 15 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:92:5: ^( PERMUTED ( body )+ )
                    {
                    match(input,PERMUTED,FOLLOW_PERMUTED_in_body473); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:93:7: ( body )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>=SEQUENCE && LA8_0<=ASSIGN)||(LA8_0>=PERMUTED && LA8_0<=DOT)||(LA8_0>=TAG && LA8_0<=PLUS)||LA8_0==SKIP_TO||(LA8_0>=NOT && LA8_0<=NOSKIP)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KGTreeParser.g:93:7: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_body482);
                    	    body();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 16 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:96:5: ^( NOT body )
                    {
                    match(input,NOT,FOLLOW_NOT_in_body499); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body501);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 17 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:98:5: ^( NOSKIP body )
                    {
                    match(input,NOSKIP,FOLLOW_NOSKIP_in_body510); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body512);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;

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
    // $ANTLR end "body"

    // Delegated rules


 

    public static final BitSet FOLLOW_GRAMMAR_in_koopa66 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_meta_in_koopa68 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_rule_in_koopa70 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_META_in_meta86 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_named_in_meta88 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_extending_in_meta90 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAMED_in_named106 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_named108 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXTENDING_in_extending123 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_extending125 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_in_rule140 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule142 = new BitSet(new long[]{0x00000034FC1EFC00L});
    public static final BitSet FOLLOW_locals_in_rule151 = new BitSet(new long[]{0x00000034FC1EFC00L});
    public static final BitSet FOLLOW_returning_in_rule160 = new BitSet(new long[]{0x00000034FC1EFC00L});
    public static final BitSet FOLLOW_body_in_rule169 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURNS_in_returning189 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_returning191 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOCALS_in_locals208 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaration_in_locals216 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_DECLARATION_in_declaration237 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration239 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration241 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEQUENCE_in_body256 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body265 = new BitSet(new long[]{0x00000034FC1EFC08L});
    public static final BitSet FOLLOW_ACT_in_body282 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NATIVE_CODE_in_body284 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TAG_in_body305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANY_in_body312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_body319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_body328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_body337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_body347 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body349 = new BitSet(new long[]{0x0000000020180000L});
    public static final BitSet FOLLOW_set_in_body351 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_body372 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body374 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_body385 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body387 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHOICE_in_body398 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body406 = new BitSet(new long[]{0x00000034FC1EFC08L});
    public static final BitSet FOLLOW_OPTIONAL_in_body425 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body433 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SKIP_TO_in_body449 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body457 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERMUTED_in_body473 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body482 = new BitSet(new long[]{0x00000034FC1EFC08L});
    public static final BitSet FOLLOW_NOT_in_body499 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body501 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOSKIP_in_body510 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body512 = new BitSet(new long[]{0x0000000000000008L});

}