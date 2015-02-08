// $ANTLR 3.1.1 src/core/koopa/core/grammars/generator/KGTreeParser.g

  package koopa.core.grammars.generator;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class KGTreeParser extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "GRAMMAR", "META", "TREE", "NAMED", "EXTENDING", "RULE", "BODY", "RETURNS", "SEQUENCE", "CHOICE", "DISPATCHED", "CASE", "OPTIONAL", "ACT", "ASSIGN", "DECLARATION", "LOCALS", "PERMUTED", "IDENTIFIER", "DOT", "OPEN_PAREN", "CLOSE_PAREN", "EQUALS", "COMMA", "NATIVE_CODE", "TAG", "ANY", "LITERAL", "NUMBER", "STAR", "PLUS", "OPEN_BRACKET", "CLOSE_BRACKET", "SKIP_TO", "BANG", "DOLLAR", "NOT", "NOSKIP", "LIMIT", "BY", "PIPE", "ARROW", "COMMENT", "NEWLINE", "LETTER", "DIGIT", "WHITESPACE", "'tree'", "'grammar'", "'extends'", "'def'", "'returns'", "'end'"
    };
    public static final int DOLLAR=39;
    public static final int SKIP_TO=37;
    public static final int STAR=33;
    public static final int DISPATCHED=14;
    public static final int LIMIT=42;
    public static final int LETTER=48;
    public static final int CASE=15;
    public static final int EQUALS=26;
    public static final int NOT=40;
    public static final int NOSKIP=41;
    public static final int EOF=-1;
    public static final int DECLARATION=19;
    public static final int META=5;
    public static final int T__55=55;
    public static final int OPEN_BRACKET=35;
    public static final int T__56=56;
    public static final int T__51=51;
    public static final int NATIVE_CODE=28;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int TREE=6;
    public static final int T__54=54;
    public static final int EXTENDING=8;
    public static final int COMMA=27;
    public static final int IDENTIFIER=22;
    public static final int PIPE=44;
    public static final int PLUS=34;
    public static final int BODY=10;
    public static final int CLOSE_PAREN=25;
    public static final int DIGIT=49;
    public static final int COMMENT=46;
    public static final int DOT=23;
    public static final int GRAMMAR=4;
    public static final int CHOICE=13;
    public static final int RETURNS=11;
    public static final int BY=43;
    public static final int ACT=17;
    public static final int LOCALS=20;
    public static final int RULE=9;
    public static final int NUMBER=32;
    public static final int OPEN_PAREN=24;
    public static final int WHITESPACE=50;
    public static final int LITERAL=31;
    public static final int BANG=38;
    public static final int TAG=29;
    public static final int OPTIONAL=16;
    public static final int SEQUENCE=12;
    public static final int ANY=30;
    public static final int NEWLINE=47;
    public static final int NAMED=7;
    public static final int ASSIGN=18;
    public static final int ARROW=45;
    public static final int PERMUTED=21;
    public static final int CLOSE_BRACKET=36;

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
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:21:1: meta : ^( META ( TREE )? named ( extending )? ) ;
    public final void meta() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:22:3: ( ^( META ( TREE )? named ( extending )? ) )
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:22:5: ^( META ( TREE )? named ( extending )? )
            {
            match(input,META,FOLLOW_META_in_meta86); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:22:12: ( TREE )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==TREE) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:22:12: TREE
                    {
                    match(input,TREE,FOLLOW_TREE_in_meta88); 

                    }
                    break;

            }

            pushFollow(FOLLOW_named_in_meta91);
            named();

            state._fsp--;

            // src/core/koopa/core/grammars/generator/KGTreeParser.g:22:24: ( extending )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==EXTENDING) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:22:24: extending
                    {
                    pushFollow(FOLLOW_extending_in_meta93);
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
            match(input,NAMED,FOLLOW_NAMED_in_named109); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_named111); 

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
            match(input,EXTENDING,FOLLOW_EXTENDING_in_extending126); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_extending128); 

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
            match(input,RULE,FOLLOW_RULE_in_rule143); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule145); 
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:35:7: ( locals )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==LOCALS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:35:7: locals
                    {
                    pushFollow(FOLLOW_locals_in_rule154);
                    locals();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/grammars/generator/KGTreeParser.g:36:7: ( returning )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RETURNS) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:36:7: returning
                    {
                    pushFollow(FOLLOW_returning_in_rule163);
                    returning();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_body_in_rule172);
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
            match(input,RETURNS,FOLLOW_RETURNS_in_returning192); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_returning194); 

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
            match(input,LOCALS,FOLLOW_LOCALS_in_locals211); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:47:7: ( declaration )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==DECLARATION) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KGTreeParser.g:47:7: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_locals219);
            	    declaration();

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
            match(input,DECLARATION,FOLLOW_DECLARATION_in_declaration240); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration242); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration244); 

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
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:55:1: body : ( ^( SEQUENCE ( body )+ ) | ^( ACT NATIVE_CODE ) | IDENTIFIER | TAG | ANY | LITERAL | NUMBER | DOT | ^( ASSIGN IDENTIFIER ( IDENTIFIER | NUMBER | DOT | ANY ) ) | ^( STAR body ) | ^( PLUS body ) | ^( CHOICE ( body )+ ) | ^( OPTIONAL body ) | ^( SKIP_TO body ) | ^( PERMUTED ( body )+ ) | ^( NOT body ) | ^( NOSKIP body ) | ^( LIMIT body body ) );
    public final void body() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:56:3: ( ^( SEQUENCE ( body )+ ) | ^( ACT NATIVE_CODE ) | IDENTIFIER | TAG | ANY | LITERAL | NUMBER | DOT | ^( ASSIGN IDENTIFIER ( IDENTIFIER | NUMBER | DOT | ANY ) ) | ^( STAR body ) | ^( PLUS body ) | ^( CHOICE ( body )+ ) | ^( OPTIONAL body ) | ^( SKIP_TO body ) | ^( PERMUTED ( body )+ ) | ^( NOT body ) | ^( NOSKIP body ) | ^( LIMIT body body ) )
            int alt10=18;
            switch ( input.LA(1) ) {
            case SEQUENCE:
                {
                alt10=1;
                }
                break;
            case ACT:
                {
                alt10=2;
                }
                break;
            case IDENTIFIER:
                {
                alt10=3;
                }
                break;
            case TAG:
                {
                alt10=4;
                }
                break;
            case ANY:
                {
                alt10=5;
                }
                break;
            case LITERAL:
                {
                alt10=6;
                }
                break;
            case NUMBER:
                {
                alt10=7;
                }
                break;
            case DOT:
                {
                alt10=8;
                }
                break;
            case ASSIGN:
                {
                alt10=9;
                }
                break;
            case STAR:
                {
                alt10=10;
                }
                break;
            case PLUS:
                {
                alt10=11;
                }
                break;
            case CHOICE:
                {
                alt10=12;
                }
                break;
            case OPTIONAL:
                {
                alt10=13;
                }
                break;
            case SKIP_TO:
                {
                alt10=14;
                }
                break;
            case PERMUTED:
                {
                alt10=15;
                }
                break;
            case NOT:
                {
                alt10=16;
                }
                break;
            case NOSKIP:
                {
                alt10=17;
                }
                break;
            case LIMIT:
                {
                alt10=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:56:5: ^( SEQUENCE ( body )+ )
                    {
                    match(input,SEQUENCE,FOLLOW_SEQUENCE_in_body259); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:57:7: ( body )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>=SEQUENCE && LA7_0<=CHOICE)||(LA7_0>=OPTIONAL && LA7_0<=ASSIGN)||(LA7_0>=PERMUTED && LA7_0<=DOT)||(LA7_0>=TAG && LA7_0<=PLUS)||LA7_0==SKIP_TO||(LA7_0>=NOT && LA7_0<=LIMIT)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KGTreeParser.g:57:7: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_body268);
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
                case 2 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:60:5: ^( ACT NATIVE_CODE )
                    {
                    match(input,ACT,FOLLOW_ACT_in_body285); 

                    match(input, Token.DOWN, null); 
                    match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_body287); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:62:5: IDENTIFIER
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body299); 

                    }
                    break;
                case 4 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:64:5: TAG
                    {
                    match(input,TAG,FOLLOW_TAG_in_body308); 

                    }
                    break;
                case 5 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:66:5: ANY
                    {
                    match(input,ANY,FOLLOW_ANY_in_body315); 

                    }
                    break;
                case 6 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:68:5: LITERAL
                    {
                    match(input,LITERAL,FOLLOW_LITERAL_in_body322); 

                    }
                    break;
                case 7 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:70:5: NUMBER
                    {
                    match(input,NUMBER,FOLLOW_NUMBER_in_body331); 

                    }
                    break;
                case 8 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:72:5: DOT
                    {
                    match(input,DOT,FOLLOW_DOT_in_body340); 

                    }
                    break;
                case 9 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:74:5: ^( ASSIGN IDENTIFIER ( IDENTIFIER | NUMBER | DOT | ANY ) )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_body350); 

                    match(input, Token.DOWN, null); 
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body352); 
                    if ( (input.LA(1)>=IDENTIFIER && input.LA(1)<=DOT)||input.LA(1)==ANY||input.LA(1)==NUMBER ) {
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
                    match(input,STAR,FOLLOW_STAR_in_body379); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body381);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 11 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:78:5: ^( PLUS body )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_body392); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body394);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 12 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:80:5: ^( CHOICE ( body )+ )
                    {
                    match(input,CHOICE,FOLLOW_CHOICE_in_body405); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:81:7: ( body )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>=SEQUENCE && LA8_0<=CHOICE)||(LA8_0>=OPTIONAL && LA8_0<=ASSIGN)||(LA8_0>=PERMUTED && LA8_0<=DOT)||(LA8_0>=TAG && LA8_0<=PLUS)||LA8_0==SKIP_TO||(LA8_0>=NOT && LA8_0<=LIMIT)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KGTreeParser.g:81:7: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_body413);
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
                case 13 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:84:5: ^( OPTIONAL body )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_body432); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body440);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 14 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:88:5: ^( SKIP_TO body )
                    {
                    match(input,SKIP_TO,FOLLOW_SKIP_TO_in_body456); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body464);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 15 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:92:5: ^( PERMUTED ( body )+ )
                    {
                    match(input,PERMUTED,FOLLOW_PERMUTED_in_body480); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:93:7: ( body )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=SEQUENCE && LA9_0<=CHOICE)||(LA9_0>=OPTIONAL && LA9_0<=ASSIGN)||(LA9_0>=PERMUTED && LA9_0<=DOT)||(LA9_0>=TAG && LA9_0<=PLUS)||LA9_0==SKIP_TO||(LA9_0>=NOT && LA9_0<=LIMIT)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KGTreeParser.g:93:7: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_body489);
                    	    body();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 16 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:96:5: ^( NOT body )
                    {
                    match(input,NOT,FOLLOW_NOT_in_body506); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body508);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 17 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:98:5: ^( NOSKIP body )
                    {
                    match(input,NOSKIP,FOLLOW_NOSKIP_in_body517); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body519);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 18 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:100:5: ^( LIMIT body body )
                    {
                    match(input,LIMIT,FOLLOW_LIMIT_in_body530); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body532);
                    body();

                    state._fsp--;

                    pushFollow(FOLLOW_body_in_body534);
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
    public static final BitSet FOLLOW_meta_in_koopa68 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_rule_in_koopa70 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_META_in_meta86 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TREE_in_meta88 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_named_in_meta91 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_extending_in_meta93 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAMED_in_named109 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_named111 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXTENDING_in_extending126 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_extending128 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_in_rule143 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule145 = new BitSet(new long[]{0x00000727E0F73800L});
    public static final BitSet FOLLOW_locals_in_rule154 = new BitSet(new long[]{0x00000727E0F73800L});
    public static final BitSet FOLLOW_returning_in_rule163 = new BitSet(new long[]{0x00000727E0F73800L});
    public static final BitSet FOLLOW_body_in_rule172 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURNS_in_returning192 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_returning194 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOCALS_in_locals211 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaration_in_locals219 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_DECLARATION_in_declaration240 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration242 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration244 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEQUENCE_in_body259 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body268 = new BitSet(new long[]{0x00000727E0F73808L});
    public static final BitSet FOLLOW_ACT_in_body285 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NATIVE_CODE_in_body287 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TAG_in_body308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANY_in_body315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_body322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_body331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_body340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_body350 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body352 = new BitSet(new long[]{0x0000000140C00000L});
    public static final BitSet FOLLOW_set_in_body354 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_body379 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body381 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_body392 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body394 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHOICE_in_body405 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body413 = new BitSet(new long[]{0x00000727E0F73808L});
    public static final BitSet FOLLOW_OPTIONAL_in_body432 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body440 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SKIP_TO_in_body456 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body464 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERMUTED_in_body480 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body489 = new BitSet(new long[]{0x00000727E0F73808L});
    public static final BitSet FOLLOW_NOT_in_body506 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body508 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOSKIP_in_body517 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body519 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_body530 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body532 = new BitSet(new long[]{0x00000727E0F73800L});
    public static final BitSet FOLLOW_body_in_body534 = new BitSet(new long[]{0x0000000000000008L});

}
