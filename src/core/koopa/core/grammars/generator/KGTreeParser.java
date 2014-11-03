// $ANTLR 3.1.1 src/core/koopa/core/grammars/generator/KGTreeParser.g 2014-11-03 08:19:38

  package koopa.core.grammars.generator;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class KGTreeParser extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "GRAMMAR", "RULE", "BODY", "RETURNS", "SEQUENCE", "CHOICE", "OPTIONAL", "ACT", "ASSIGN", "DECLARATION", "LOCALS", "PERMUTED", "IDENTIFIER", "OPEN_PAREN", "CLOSE_PAREN", "EQUALS", "COMMA", "NATIVE_CODE", "TAG", "ANY", "LITERAL", "NUMBER", "DOT", "STAR", "PLUS", "OPEN_BRACKET", "CLOSE_BRACKET", "SKIP_TO", "BANG", "NOT", "NOSKIP", "PIPE", "COMMENT", "NEWLINE", "LETTER", "DIGIT", "WHITESPACE", "'def'", "'returns'", "'end'"
    };
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


        public KGTreeParser(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public KGTreeParser(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return KGTreeParser.tokenNames; }
    public String getGrammarFileName() { return "src/core/koopa/core/grammars/generator/KGTreeParser.g"; }





    // $ANTLR start "koopa"
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:17:1: koopa : ^( GRAMMAR ( rule )* ) ;
    public final void koopa() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:18:3: ( ^( GRAMMAR ( rule )* ) )
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:18:5: ^( GRAMMAR ( rule )* )
            {
            match(input,GRAMMAR,FOLLOW_GRAMMAR_in_koopa66); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/core/koopa/core/grammars/generator/KGTreeParser.g:18:15: ( rule )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // src/core/koopa/core/grammars/generator/KGTreeParser.g:18:15: rule
                	    {
                	    pushFollow(FOLLOW_rule_in_koopa68);
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


    // $ANTLR start "rule"
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:21:1: rule : ^( RULE IDENTIFIER ( locals )? ( returning )? body ) ;
    public final void rule() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:22:3: ( ^( RULE IDENTIFIER ( locals )? ( returning )? body ) )
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:22:5: ^( RULE IDENTIFIER ( locals )? ( returning )? body )
            {
            match(input,RULE,FOLLOW_RULE_in_rule84); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule86); 
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:23:7: ( locals )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==LOCALS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:23:7: locals
                    {
                    pushFollow(FOLLOW_locals_in_rule95);
                    locals();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/grammars/generator/KGTreeParser.g:24:7: ( returning )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RETURNS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:24:7: returning
                    {
                    pushFollow(FOLLOW_returning_in_rule104);
                    returning();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_body_in_rule113);
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
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:29:1: returning : ^( RETURNS IDENTIFIER ) ;
    public final void returning() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:30:3: ( ^( RETURNS IDENTIFIER ) )
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:30:5: ^( RETURNS IDENTIFIER )
            {
            match(input,RETURNS,FOLLOW_RETURNS_in_returning133); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_returning135); 

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
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:33:1: locals : ^( LOCALS ( declaration )+ ) ;
    public final void locals() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:34:3: ( ^( LOCALS ( declaration )+ ) )
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:34:5: ^( LOCALS ( declaration )+ )
            {
            match(input,LOCALS,FOLLOW_LOCALS_in_locals152); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:35:7: ( declaration )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==DECLARATION) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KGTreeParser.g:35:7: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_locals160);
            	    declaration();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:39:1: declaration : ^( DECLARATION IDENTIFIER IDENTIFIER ) ;
    public final void declaration() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:40:3: ( ^( DECLARATION IDENTIFIER IDENTIFIER ) )
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:40:5: ^( DECLARATION IDENTIFIER IDENTIFIER )
            {
            match(input,DECLARATION,FOLLOW_DECLARATION_in_declaration181); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration183); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration185); 

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
    // src/core/koopa/core/grammars/generator/KGTreeParser.g:43:1: body : ( ^( SEQUENCE ( body )+ ) | ^( ACT NATIVE_CODE ) | IDENTIFIER | TAG | ANY | LITERAL | NUMBER | DOT | ^( ASSIGN IDENTIFIER ( IDENTIFIER | NUMBER | DOT ) ) | ^( STAR body ) | ^( PLUS body ) | ^( CHOICE ( body )+ ) | ^( OPTIONAL body ) | ^( SKIP_TO body ) | ^( PERMUTED ( body )+ ) | ^( NOT body ) | ^( NOSKIP body ) );
    public final void body() throws RecognitionException {
        try {
            // src/core/koopa/core/grammars/generator/KGTreeParser.g:44:3: ( ^( SEQUENCE ( body )+ ) | ^( ACT NATIVE_CODE ) | IDENTIFIER | TAG | ANY | LITERAL | NUMBER | DOT | ^( ASSIGN IDENTIFIER ( IDENTIFIER | NUMBER | DOT ) ) | ^( STAR body ) | ^( PLUS body ) | ^( CHOICE ( body )+ ) | ^( OPTIONAL body ) | ^( SKIP_TO body ) | ^( PERMUTED ( body )+ ) | ^( NOT body ) | ^( NOSKIP body ) )
            int alt8=17;
            switch ( input.LA(1) ) {
            case SEQUENCE:
                {
                alt8=1;
                }
                break;
            case ACT:
                {
                alt8=2;
                }
                break;
            case IDENTIFIER:
                {
                alt8=3;
                }
                break;
            case TAG:
                {
                alt8=4;
                }
                break;
            case ANY:
                {
                alt8=5;
                }
                break;
            case LITERAL:
                {
                alt8=6;
                }
                break;
            case NUMBER:
                {
                alt8=7;
                }
                break;
            case DOT:
                {
                alt8=8;
                }
                break;
            case ASSIGN:
                {
                alt8=9;
                }
                break;
            case STAR:
                {
                alt8=10;
                }
                break;
            case PLUS:
                {
                alt8=11;
                }
                break;
            case CHOICE:
                {
                alt8=12;
                }
                break;
            case OPTIONAL:
                {
                alt8=13;
                }
                break;
            case SKIP_TO:
                {
                alt8=14;
                }
                break;
            case PERMUTED:
                {
                alt8=15;
                }
                break;
            case NOT:
                {
                alt8=16;
                }
                break;
            case NOSKIP:
                {
                alt8=17;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:44:5: ^( SEQUENCE ( body )+ )
                    {
                    match(input,SEQUENCE,FOLLOW_SEQUENCE_in_body200); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:45:7: ( body )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=SEQUENCE && LA5_0<=ASSIGN)||(LA5_0>=PERMUTED && LA5_0<=IDENTIFIER)||(LA5_0>=TAG && LA5_0<=PLUS)||LA5_0==SKIP_TO||(LA5_0>=NOT && LA5_0<=NOSKIP)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KGTreeParser.g:45:7: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_body209);
                    	    body();

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
                    break;
                case 2 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:48:5: ^( ACT NATIVE_CODE )
                    {
                    match(input,ACT,FOLLOW_ACT_in_body226); 

                    match(input, Token.DOWN, null); 
                    match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_body228); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:50:5: IDENTIFIER
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body240); 

                    }
                    break;
                case 4 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:52:5: TAG
                    {
                    match(input,TAG,FOLLOW_TAG_in_body249); 

                    }
                    break;
                case 5 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:54:5: ANY
                    {
                    match(input,ANY,FOLLOW_ANY_in_body256); 

                    }
                    break;
                case 6 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:56:5: LITERAL
                    {
                    match(input,LITERAL,FOLLOW_LITERAL_in_body263); 

                    }
                    break;
                case 7 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:58:5: NUMBER
                    {
                    match(input,NUMBER,FOLLOW_NUMBER_in_body272); 

                    }
                    break;
                case 8 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:60:5: DOT
                    {
                    match(input,DOT,FOLLOW_DOT_in_body281); 

                    }
                    break;
                case 9 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:62:5: ^( ASSIGN IDENTIFIER ( IDENTIFIER | NUMBER | DOT ) )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_body291); 

                    match(input, Token.DOWN, null); 
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body293); 
                    if ( input.LA(1)==IDENTIFIER||(input.LA(1)>=NUMBER && input.LA(1)<=DOT) ) {
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
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:64:5: ^( STAR body )
                    {
                    match(input,STAR,FOLLOW_STAR_in_body316); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body318);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 11 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:66:5: ^( PLUS body )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_body329); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body331);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 12 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:68:5: ^( CHOICE ( body )+ )
                    {
                    match(input,CHOICE,FOLLOW_CHOICE_in_body342); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:69:7: ( body )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=SEQUENCE && LA6_0<=ASSIGN)||(LA6_0>=PERMUTED && LA6_0<=IDENTIFIER)||(LA6_0>=TAG && LA6_0<=PLUS)||LA6_0==SKIP_TO||(LA6_0>=NOT && LA6_0<=NOSKIP)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KGTreeParser.g:69:7: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_body350);
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
                case 13 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:72:5: ^( OPTIONAL body )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_body369); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body377);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 14 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:76:5: ^( SKIP_TO body )
                    {
                    match(input,SKIP_TO,FOLLOW_SKIP_TO_in_body393); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body401);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 15 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:80:5: ^( PERMUTED ( body )+ )
                    {
                    match(input,PERMUTED,FOLLOW_PERMUTED_in_body417); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:81:7: ( body )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>=SEQUENCE && LA7_0<=ASSIGN)||(LA7_0>=PERMUTED && LA7_0<=IDENTIFIER)||(LA7_0>=TAG && LA7_0<=PLUS)||LA7_0==SKIP_TO||(LA7_0>=NOT && LA7_0<=NOSKIP)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KGTreeParser.g:81:7: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_body426);
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
                case 16 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:84:5: ^( NOT body )
                    {
                    match(input,NOT,FOLLOW_NOT_in_body443); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body445);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 17 :
                    // src/core/koopa/core/grammars/generator/KGTreeParser.g:86:5: ^( NOSKIP body )
                    {
                    match(input,NOSKIP,FOLLOW_NOSKIP_in_body454); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body456);
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
    public static final BitSet FOLLOW_rule_in_koopa68 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_RULE_in_rule84 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule86 = new BitSet(new long[]{0x000000069FC1DF80L});
    public static final BitSet FOLLOW_locals_in_rule95 = new BitSet(new long[]{0x000000069FC1DF80L});
    public static final BitSet FOLLOW_returning_in_rule104 = new BitSet(new long[]{0x000000069FC1DF80L});
    public static final BitSet FOLLOW_body_in_rule113 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURNS_in_returning133 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_returning135 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOCALS_in_locals152 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaration_in_locals160 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_DECLARATION_in_declaration181 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration183 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration185 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEQUENCE_in_body200 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body209 = new BitSet(new long[]{0x000000069FC1DF88L});
    public static final BitSet FOLLOW_ACT_in_body226 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NATIVE_CODE_in_body228 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TAG_in_body249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANY_in_body256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_body263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_body272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_body281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_body291 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body293 = new BitSet(new long[]{0x0000000006010000L});
    public static final BitSet FOLLOW_set_in_body295 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_body316 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body318 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_body329 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body331 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHOICE_in_body342 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body350 = new BitSet(new long[]{0x000000069FC1DF88L});
    public static final BitSet FOLLOW_OPTIONAL_in_body369 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body377 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SKIP_TO_in_body393 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body401 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERMUTED_in_body417 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body426 = new BitSet(new long[]{0x000000069FC1DF88L});
    public static final BitSet FOLLOW_NOT_in_body443 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body445 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOSKIP_in_body454 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body456 = new BitSet(new long[]{0x0000000000000008L});

}