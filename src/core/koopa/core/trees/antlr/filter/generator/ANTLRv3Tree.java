// $ANTLR 3.1.1 src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g 2014-11-03 08:19:49

  package koopa.core.trees.antlr.filter.generator;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/** ANTLR v3 tree grammar to walk trees created by ANTLRv3.g */
public class ANTLRv3Tree extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DOC_COMMENT", "PARSER", "LEXER", "RULE", "BLOCK", "OPTIONAL", "CLOSURE", "POSITIVE_CLOSURE", "SYNPRED", "RANGE", "CHAR_RANGE", "EPSILON", "ALT", "EOR", "EOB", "EOA", "ID", "ARG", "ARGLIST", "RET", "LEXER_GRAMMAR", "PARSER_GRAMMAR", "TREE_GRAMMAR", "COMBINED_GRAMMAR", "INITACTION", "LABEL", "TEMPLATE", "SCOPE", "SEMPRED", "GATED_SEMPRED", "SYN_SEMPRED", "BACKTRACK_SEMPRED", "FRAGMENT", "TREE_BEGIN", "ROOT", "BANG", "REWRITE", "TOKENS", "TOKEN_REF", "STRING_LITERAL", "CHAR_LITERAL", "ACTION", "OPTIONS", "INT", "ARG_ACTION", "RULE_REF", "DOUBLE_QUOTE_STRING_LITERAL", "DOUBLE_ANGLE_STRING_LITERAL", "SRC", "SL_COMMENT", "ML_COMMENT", "LITERAL_CHAR", "ESC", "XDIGIT", "NESTED_ARG_ACTION", "ACTION_STRING_LITERAL", "ACTION_CHAR_LITERAL", "NESTED_ACTION", "ACTION_ESC", "WS_LOOP", "WS", "'lexer'", "'parser'", "'tree'", "'grammar'", "';'", "'}'", "'='", "'@'", "'::'", "'*'", "'protected'", "'public'", "'private'", "'returns'", "':'", "'throws'", "','", "'('", "'|'", "')'", "'catch'", "'finally'", "'+='", "'=>'", "'~'", "'?'", "'+'", "'.'", "'$'"
    };
    public static final int BACKTRACK_SEMPRED=35;
    public static final int DOUBLE_ANGLE_STRING_LITERAL=51;
    public static final int LEXER_GRAMMAR=24;
    public static final int EOA=19;
    public static final int ARGLIST=22;
    public static final int EOF=-1;
    public static final int SEMPRED=32;
    public static final int ACTION=45;
    public static final int EOB=18;
    public static final int TOKEN_REF=42;
    public static final int T__93=93;
    public static final int T__91=91;
    public static final int RET=23;
    public static final int T__92=92;
    public static final int STRING_LITERAL=43;
    public static final int T__90=90;
    public static final int ARG=21;
    public static final int EOR=17;
    public static final int ARG_ACTION=48;
    public static final int DOUBLE_QUOTE_STRING_LITERAL=50;
    public static final int NESTED_ARG_ACTION=58;
    public static final int ACTION_CHAR_LITERAL=60;
    public static final int INITACTION=28;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int RULE=7;
    public static final int T__83=83;
    public static final int ACTION_ESC=62;
    public static final int PARSER_GRAMMAR=25;
    public static final int SRC=52;
    public static final int INT=47;
    public static final int CHAR_RANGE=14;
    public static final int EPSILON=15;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int REWRITE=40;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int WS=64;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int COMBINED_GRAMMAR=27;
    public static final int T__70=70;
    public static final int LEXER=6;
    public static final int SL_COMMENT=53;
    public static final int TREE_GRAMMAR=26;
    public static final int T__76=76;
    public static final int CLOSURE=10;
    public static final int T__75=75;
    public static final int PARSER=5;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__65=65;
    public static final int NESTED_ACTION=61;
    public static final int ESC=56;
    public static final int FRAGMENT=36;
    public static final int ID=20;
    public static final int TREE_BEGIN=37;
    public static final int ML_COMMENT=54;
    public static final int ALT=16;
    public static final int SCOPE=31;
    public static final int DOC_COMMENT=4;
    public static final int WS_LOOP=63;
    public static final int RANGE=13;
    public static final int TOKENS=41;
    public static final int GATED_SEMPRED=33;
    public static final int LITERAL_CHAR=55;
    public static final int BANG=39;
    public static final int ACTION_STRING_LITERAL=59;
    public static final int ROOT=38;
    public static final int RULE_REF=49;
    public static final int SYNPRED=12;
    public static final int OPTIONAL=9;
    public static final int CHAR_LITERAL=44;
    public static final int LABEL=29;
    public static final int TEMPLATE=30;
    public static final int SYN_SEMPRED=34;
    public static final int XDIGIT=57;
    public static final int BLOCK=8;
    public static final int POSITIVE_CLOSURE=11;
    public static final int OPTIONS=46;

    // delegates
    // delegators


        public ANTLRv3Tree(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public ANTLRv3Tree(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ANTLRv3Tree.tokenNames; }
    public String getGrammarFileName() { return "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g"; }



    // $ANTLR start "grammarDef"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:41:1: grammarDef : ^( grammarType ID ( DOC_COMMENT )? ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* ( rule )+ ) ;
    public final void grammarDef() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:42:5: ( ^( grammarType ID ( DOC_COMMENT )? ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* ( rule )+ ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:42:9: ^( grammarType ID ( DOC_COMMENT )? ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* ( rule )+ )
            {
            pushFollow(FOLLOW_grammarType_in_grammarDef52);
            grammarType();

            state._fsp--;


            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_grammarDef54); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:42:27: ( DOC_COMMENT )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==DOC_COMMENT) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:42:27: DOC_COMMENT
                    {
                    match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammarDef56); 

                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:42:40: ( optionsSpec )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==OPTIONS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:42:40: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_grammarDef59);
                    optionsSpec();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:42:53: ( tokensSpec )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==TOKENS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:42:53: tokensSpec
                    {
                    pushFollow(FOLLOW_tokensSpec_in_grammarDef62);
                    tokensSpec();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:42:65: ( attrScope )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==SCOPE) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:42:65: attrScope
            	    {
            	    pushFollow(FOLLOW_attrScope_in_grammarDef65);
            	    attrScope();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:42:76: ( action )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==72) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:42:76: action
            	    {
            	    pushFollow(FOLLOW_action_in_grammarDef68);
            	    action();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:42:84: ( rule )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:42:84: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_grammarDef71);
            	    rule();

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
    // $ANTLR end "grammarDef"


    // $ANTLR start "grammarType"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:45:1: grammarType : ( LEXER_GRAMMAR | PARSER_GRAMMAR | TREE_GRAMMAR | COMBINED_GRAMMAR );
    public final void grammarType() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:46:2: ( LEXER_GRAMMAR | PARSER_GRAMMAR | TREE_GRAMMAR | COMBINED_GRAMMAR )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:
            {
            if ( (input.LA(1)>=LEXER_GRAMMAR && input.LA(1)<=COMBINED_GRAMMAR) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "grammarType"


    // $ANTLR start "tokensSpec"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:52:1: tokensSpec : ^( TOKENS ( tokenSpec )+ ) ;
    public final void tokensSpec() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:53:2: ( ^( TOKENS ( tokenSpec )+ ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:53:4: ^( TOKENS ( tokenSpec )+ )
            {
            match(input,TOKENS,FOLLOW_TOKENS_in_tokensSpec119); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:53:13: ( tokenSpec )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==TOKEN_REF||LA7_0==71) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:53:13: tokenSpec
            	    {
            	    pushFollow(FOLLOW_tokenSpec_in_tokensSpec121);
            	    tokenSpec();

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "tokensSpec"


    // $ANTLR start "tokenSpec"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:56:1: tokenSpec : ( ^( '=' TOKEN_REF STRING_LITERAL ) | ^( '=' TOKEN_REF CHAR_LITERAL ) | TOKEN_REF );
    public final void tokenSpec() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:57:2: ( ^( '=' TOKEN_REF STRING_LITERAL ) | ^( '=' TOKEN_REF CHAR_LITERAL ) | TOKEN_REF )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==71) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==DOWN) ) {
                    int LA8_3 = input.LA(3);

                    if ( (LA8_3==TOKEN_REF) ) {
                        int LA8_4 = input.LA(4);

                        if ( (LA8_4==STRING_LITERAL) ) {
                            alt8=1;
                        }
                        else if ( (LA8_4==CHAR_LITERAL) ) {
                            alt8=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 8, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA8_0==TOKEN_REF) ) {
                alt8=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:57:4: ^( '=' TOKEN_REF STRING_LITERAL )
                    {
                    match(input,71,FOLLOW_71_in_tokenSpec135); 

                    match(input, Token.DOWN, null); 
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec137); 
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_tokenSpec139); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:58:4: ^( '=' TOKEN_REF CHAR_LITERAL )
                    {
                    match(input,71,FOLLOW_71_in_tokenSpec146); 

                    match(input, Token.DOWN, null); 
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec148); 
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_tokenSpec150); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:59:4: TOKEN_REF
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec156); 

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
    // $ANTLR end "tokenSpec"


    // $ANTLR start "attrScope"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:62:1: attrScope : ^( 'scope' ID ACTION ) ;
    public final void attrScope() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:63:2: ( ^( 'scope' ID ACTION ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:63:4: ^( 'scope' ID ACTION )
            {
            match(input,SCOPE,FOLLOW_SCOPE_in_attrScope168); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_attrScope170); 
            match(input,ACTION,FOLLOW_ACTION_in_attrScope172); 

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
    // $ANTLR end "attrScope"


    // $ANTLR start "action"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:66:1: action : ( ^( '@' ID ID ACTION ) | ^( '@' ID ACTION ) );
    public final void action() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:67:2: ( ^( '@' ID ID ACTION ) | ^( '@' ID ACTION ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==72) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==DOWN) ) {
                    int LA9_2 = input.LA(3);

                    if ( (LA9_2==ID) ) {
                        int LA9_3 = input.LA(4);

                        if ( (LA9_3==ID) ) {
                            alt9=1;
                        }
                        else if ( (LA9_3==ACTION) ) {
                            alt9=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:67:4: ^( '@' ID ID ACTION )
                    {
                    match(input,72,FOLLOW_72_in_action185); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_action187); 
                    match(input,ID,FOLLOW_ID_in_action189); 
                    match(input,ACTION,FOLLOW_ACTION_in_action191); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:68:4: ^( '@' ID ACTION )
                    {
                    match(input,72,FOLLOW_72_in_action198); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_action200); 
                    match(input,ACTION,FOLLOW_ACTION_in_action202); 

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
    // $ANTLR end "action"


    // $ANTLR start "optionsSpec"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:71:1: optionsSpec : ^( OPTIONS ( option )+ ) ;
    public final void optionsSpec() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:72:2: ( ^( OPTIONS ( option )+ ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:72:4: ^( OPTIONS ( option )+ )
            {
            match(input,OPTIONS,FOLLOW_OPTIONS_in_optionsSpec215); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:72:14: ( option )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==71) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:72:14: option
            	    {
            	    pushFollow(FOLLOW_option_in_optionsSpec217);
            	    option();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
    // $ANTLR end "optionsSpec"


    // $ANTLR start "option"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:75:1: option : ^( '=' ID optionValue ) ;
    public final void option() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:76:5: ( ^( '=' ID optionValue ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:76:9: ^( '=' ID optionValue )
            {
            match(input,71,FOLLOW_71_in_option236); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_option238); 
            pushFollow(FOLLOW_optionValue_in_option240);
            optionValue();

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
    // $ANTLR end "option"


    // $ANTLR start "optionValue"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:79:1: optionValue : ( ID | STRING_LITERAL | CHAR_LITERAL | INT );
    public final void optionValue() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:80:5: ( ID | STRING_LITERAL | CHAR_LITERAL | INT )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:
            {
            if ( input.LA(1)==ID||(input.LA(1)>=STRING_LITERAL && input.LA(1)<=CHAR_LITERAL)||input.LA(1)==INT ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "optionValue"


    // $ANTLR start "rule"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:86:1: rule : ^( RULE ID ( modifier )? ( ^( ARG ARG_ACTION ) )? ( ^( RET ARG_ACTION ) )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* altList ( exceptionGroup )? EOR ) ;
    public final void rule() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:87:2: ( ^( RULE ID ( modifier )? ( ^( ARG ARG_ACTION ) )? ( ^( RET ARG_ACTION ) )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* altList ( exceptionGroup )? EOR ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:87:4: ^( RULE ID ( modifier )? ( ^( ARG ARG_ACTION ) )? ( ^( RET ARG_ACTION ) )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* altList ( exceptionGroup )? EOR )
            {
            match(input,RULE,FOLLOW_RULE_in_rule306); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_rule308); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:87:15: ( modifier )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==FRAGMENT||(LA11_0>=75 && LA11_0<=77)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:87:15: modifier
                    {
                    pushFollow(FOLLOW_modifier_in_rule310);
                    modifier();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:87:25: ( ^( ARG ARG_ACTION ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ARG) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:87:26: ^( ARG ARG_ACTION )
                    {
                    match(input,ARG,FOLLOW_ARG_in_rule315); 

                    match(input, Token.DOWN, null); 
                    match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule317); 

                    match(input, Token.UP, null); 

                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:87:46: ( ^( RET ARG_ACTION ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RET) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:87:47: ^( RET ARG_ACTION )
                    {
                    match(input,RET,FOLLOW_RET_in_rule324); 

                    match(input, Token.DOWN, null); 
                    match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule326); 

                    match(input, Token.UP, null); 

                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:88:9: ( optionsSpec )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==OPTIONS) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:88:9: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_rule339);
                    optionsSpec();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:88:22: ( ruleScopeSpec )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==SCOPE) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:88:22: ruleScopeSpec
                    {
                    pushFollow(FOLLOW_ruleScopeSpec_in_rule342);
                    ruleScopeSpec();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:88:37: ( ruleAction )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==72) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:88:37: ruleAction
            	    {
            	    pushFollow(FOLLOW_ruleAction_in_rule345);
            	    ruleAction();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            pushFollow(FOLLOW_altList_in_rule356);
            altList();

            state._fsp--;

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:90:9: ( exceptionGroup )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=85 && LA17_0<=86)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:90:9: exceptionGroup
                    {
                    pushFollow(FOLLOW_exceptionGroup_in_rule366);
                    exceptionGroup();

                    state._fsp--;


                    }
                    break;

            }

            match(input,EOR,FOLLOW_EOR_in_rule369); 

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


    // $ANTLR start "modifier"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:94:1: modifier : ( 'protected' | 'public' | 'private' | 'fragment' );
    public final void modifier() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:95:2: ( 'protected' | 'public' | 'private' | 'fragment' )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:
            {
            if ( input.LA(1)==FRAGMENT||(input.LA(1)>=75 && input.LA(1)<=77) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "modifier"


    // $ANTLR start "ruleAction"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:98:1: ruleAction : ^( '@' ID ACTION ) ;
    public final void ruleAction() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:100:2: ( ^( '@' ID ACTION ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:100:4: ^( '@' ID ACTION )
            {
            match(input,72,FOLLOW_72_in_ruleAction408); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_ruleAction410); 
            match(input,ACTION,FOLLOW_ACTION_in_ruleAction412); 

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
    // $ANTLR end "ruleAction"


    // $ANTLR start "throwsSpec"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:103:1: throwsSpec : ^( 'throws' ( ID )+ ) ;
    public final void throwsSpec() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:104:2: ( ^( 'throws' ( ID )+ ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:104:4: ^( 'throws' ( ID )+ )
            {
            match(input,80,FOLLOW_80_in_throwsSpec425); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:104:15: ( ID )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:104:15: ID
            	    {
            	    match(input,ID,FOLLOW_ID_in_throwsSpec427); 

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
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
    // $ANTLR end "throwsSpec"


    // $ANTLR start "ruleScopeSpec"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:107:1: ruleScopeSpec : ( ^( 'scope' ACTION ) | ^( 'scope' ACTION ( ID )+ ) | ^( 'scope' ( ID )+ ) );
    public final void ruleScopeSpec() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:108:2: ( ^( 'scope' ACTION ) | ^( 'scope' ACTION ( ID )+ ) | ^( 'scope' ( ID )+ ) )
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==SCOPE) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==DOWN) ) {
                    int LA21_2 = input.LA(3);

                    if ( (LA21_2==ACTION) ) {
                        int LA21_3 = input.LA(4);

                        if ( (LA21_3==UP) ) {
                            alt21=1;
                        }
                        else if ( (LA21_3==ID) ) {
                            alt21=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 21, 3, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA21_2==ID) ) {
                        alt21=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:108:4: ^( 'scope' ACTION )
                    {
                    match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec441); 

                    match(input, Token.DOWN, null); 
                    match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec443); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:109:4: ^( 'scope' ACTION ( ID )+ )
                    {
                    match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec450); 

                    match(input, Token.DOWN, null); 
                    match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec452); 
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:109:21: ( ID )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==ID) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:109:21: ID
                    	    {
                    	    match(input,ID,FOLLOW_ID_in_ruleScopeSpec454); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:110:4: ^( 'scope' ( ID )+ )
                    {
                    match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec462); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:110:14: ( ID )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==ID) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:110:14: ID
                    	    {
                    	    match(input,ID,FOLLOW_ID_in_ruleScopeSpec464); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


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
    // $ANTLR end "ruleScopeSpec"


    // $ANTLR start "block"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:113:1: block : ^( BLOCK ( optionsSpec )? ( alternative rewrite )+ EOB ) ;
    public final void block() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:114:5: ( ^( BLOCK ( optionsSpec )? ( alternative rewrite )+ EOB ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:114:9: ^( BLOCK ( optionsSpec )? ( alternative rewrite )+ EOB )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block484); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:114:18: ( optionsSpec )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==OPTIONS) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:114:18: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_block486);
                    optionsSpec();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:114:31: ( alternative rewrite )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==ALT) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:114:32: alternative rewrite
            	    {
            	    pushFollow(FOLLOW_alternative_in_block490);
            	    alternative();

            	    state._fsp--;

            	    pushFollow(FOLLOW_rewrite_in_block492);
            	    rewrite();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);

            match(input,EOB,FOLLOW_EOB_in_block496); 

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
    // $ANTLR end "block"


    // $ANTLR start "altList"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:117:1: altList : ^( BLOCK ( alternative rewrite )+ EOB ) ;
    public final void altList() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:118:5: ( ^( BLOCK ( alternative rewrite )+ EOB ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:118:9: ^( BLOCK ( alternative rewrite )+ EOB )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_altList519); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:118:18: ( alternative rewrite )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==ALT) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:118:19: alternative rewrite
            	    {
            	    pushFollow(FOLLOW_alternative_in_altList522);
            	    alternative();

            	    state._fsp--;

            	    pushFollow(FOLLOW_rewrite_in_altList524);
            	    rewrite();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            match(input,EOB,FOLLOW_EOB_in_altList528); 

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
    // $ANTLR end "altList"


    // $ANTLR start "alternative"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:121:1: alternative : ( ^( ALT ( element )+ EOA ) | ^( ALT EPSILON EOA ) );
    public final void alternative() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:122:5: ( ^( ALT ( element )+ EOA ) | ^( ALT EPSILON EOA ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==ALT) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==DOWN) ) {
                    int LA26_2 = input.LA(3);

                    if ( (LA26_2==EPSILON) ) {
                        alt26=2;
                    }
                    else if ( ((LA26_2>=BLOCK && LA26_2<=SYNPRED)||LA26_2==CHAR_RANGE||(LA26_2>=SEMPRED && LA26_2<=SYN_SEMPRED)||(LA26_2>=TREE_BEGIN && LA26_2<=BANG)||(LA26_2>=TOKEN_REF && LA26_2<=ACTION)||LA26_2==RULE_REF||LA26_2==71||LA26_2==87||LA26_2==89||LA26_2==92) ) {
                        alt26=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:122:9: ^( ALT ( element )+ EOA )
                    {
                    match(input,ALT,FOLLOW_ALT_in_alternative550); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:122:15: ( element )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>=BLOCK && LA25_0<=SYNPRED)||LA25_0==CHAR_RANGE||(LA25_0>=SEMPRED && LA25_0<=SYN_SEMPRED)||(LA25_0>=TREE_BEGIN && LA25_0<=BANG)||(LA25_0>=TOKEN_REF && LA25_0<=ACTION)||LA25_0==RULE_REF||LA25_0==71||LA25_0==87||LA25_0==89||LA25_0==92) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:122:15: element
                    	    {
                    	    pushFollow(FOLLOW_element_in_alternative552);
                    	    element();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);

                    match(input,EOA,FOLLOW_EOA_in_alternative555); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:123:9: ^( ALT EPSILON EOA )
                    {
                    match(input,ALT,FOLLOW_ALT_in_alternative567); 

                    match(input, Token.DOWN, null); 
                    match(input,EPSILON,FOLLOW_EPSILON_in_alternative569); 
                    match(input,EOA,FOLLOW_EOA_in_alternative571); 

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
    // $ANTLR end "alternative"


    // $ANTLR start "exceptionGroup"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:126:1: exceptionGroup : ( ( exceptionHandler )+ ( finallyClause )? | finallyClause );
    public final void exceptionGroup() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:127:2: ( ( exceptionHandler )+ ( finallyClause )? | finallyClause )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==85) ) {
                alt29=1;
            }
            else if ( (LA29_0==86) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:127:4: ( exceptionHandler )+ ( finallyClause )?
                    {
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:127:4: ( exceptionHandler )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==85) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:127:4: exceptionHandler
                    	    {
                    	    pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup586);
                    	    exceptionHandler();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);

                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:127:22: ( finallyClause )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==86) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:127:22: finallyClause
                            {
                            pushFollow(FOLLOW_finallyClause_in_exceptionGroup589);
                            finallyClause();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:128:4: finallyClause
                    {
                    pushFollow(FOLLOW_finallyClause_in_exceptionGroup595);
                    finallyClause();

                    state._fsp--;


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
    // $ANTLR end "exceptionGroup"


    // $ANTLR start "exceptionHandler"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:131:1: exceptionHandler : ^( 'catch' ARG_ACTION ACTION ) ;
    public final void exceptionHandler() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:132:5: ( ^( 'catch' ARG_ACTION ACTION ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:132:10: ^( 'catch' ARG_ACTION ACTION )
            {
            match(input,85,FOLLOW_85_in_exceptionHandler616); 

            match(input, Token.DOWN, null); 
            match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler618); 
            match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler620); 

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
    // $ANTLR end "exceptionHandler"


    // $ANTLR start "finallyClause"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:135:1: finallyClause : ^( 'finally' ACTION ) ;
    public final void finallyClause() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:136:5: ( ^( 'finally' ACTION ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:136:10: ^( 'finally' ACTION )
            {
            match(input,86,FOLLOW_86_in_finallyClause642); 

            match(input, Token.DOWN, null); 
            match(input,ACTION,FOLLOW_ACTION_in_finallyClause644); 

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
    // $ANTLR end "finallyClause"


    // $ANTLR start "element"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:139:1: element : elementNoOptionSpec ;
    public final void element() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:140:2: ( elementNoOptionSpec )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:140:4: elementNoOptionSpec
            {
            pushFollow(FOLLOW_elementNoOptionSpec_in_element659);
            elementNoOptionSpec();

            state._fsp--;


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
    // $ANTLR end "element"


    // $ANTLR start "elementNoOptionSpec"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:143:1: elementNoOptionSpec : ( ^( ( '=' | '+=' ) ID block ) | ^( ( '=' | '+=' ) ID atom ) | atom | ebnf | ACTION | SEMPRED | GATED_SEMPRED | treeSpec );
    public final void elementNoOptionSpec() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:144:2: ( ^( ( '=' | '+=' ) ID block ) | ^( ( '=' | '+=' ) ID atom ) | atom | ebnf | ACTION | SEMPRED | GATED_SEMPRED | treeSpec )
            int alt30=8;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:144:4: ^( ( '=' | '+=' ) ID block )
                    {
                    if ( input.LA(1)==71||input.LA(1)==87 ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_elementNoOptionSpec677); 
                    pushFollow(FOLLOW_block_in_elementNoOptionSpec679);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:145:4: ^( ( '=' | '+=' ) ID atom )
                    {
                    if ( input.LA(1)==71||input.LA(1)==87 ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_elementNoOptionSpec692); 
                    pushFollow(FOLLOW_atom_in_elementNoOptionSpec694);
                    atom();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:146:4: atom
                    {
                    pushFollow(FOLLOW_atom_in_elementNoOptionSpec700);
                    atom();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:147:4: ebnf
                    {
                    pushFollow(FOLLOW_ebnf_in_elementNoOptionSpec705);
                    ebnf();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:148:6: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_elementNoOptionSpec712); 

                    }
                    break;
                case 6 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:149:6: SEMPRED
                    {
                    match(input,SEMPRED,FOLLOW_SEMPRED_in_elementNoOptionSpec719); 

                    }
                    break;
                case 7 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:150:4: GATED_SEMPRED
                    {
                    match(input,GATED_SEMPRED,FOLLOW_GATED_SEMPRED_in_elementNoOptionSpec724); 

                    }
                    break;
                case 8 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:151:6: treeSpec
                    {
                    pushFollow(FOLLOW_treeSpec_in_elementNoOptionSpec731);
                    treeSpec();

                    state._fsp--;


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
    // $ANTLR end "elementNoOptionSpec"


    // $ANTLR start "atom"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:154:1: atom : ( ^( ( '^' | '!' ) atom ) | range | notSet | ^( RULE_REF ARG_ACTION ) | RULE_REF | terminal );
    public final void atom() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:154:5: ( ^( ( '^' | '!' ) atom ) | range | notSet | ^( RULE_REF ARG_ACTION ) | RULE_REF | terminal )
            int alt31=6;
            switch ( input.LA(1) ) {
            case ROOT:
            case BANG:
                {
                alt31=1;
                }
                break;
            case CHAR_RANGE:
                {
                alt31=2;
                }
                break;
            case 89:
                {
                alt31=3;
                }
                break;
            case RULE_REF:
                {
                int LA31_4 = input.LA(2);

                if ( (LA31_4==DOWN) ) {
                    alt31=4;
                }
                else if ( (LA31_4==UP||(LA31_4>=BLOCK && LA31_4<=SYNPRED)||LA31_4==CHAR_RANGE||LA31_4==EOA||(LA31_4>=SEMPRED && LA31_4<=SYN_SEMPRED)||(LA31_4>=TREE_BEGIN && LA31_4<=BANG)||(LA31_4>=TOKEN_REF && LA31_4<=ACTION)||LA31_4==RULE_REF||LA31_4==71||LA31_4==87||LA31_4==89||LA31_4==92) ) {
                    alt31=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 4, input);

                    throw nvae;
                }
                }
                break;
            case TOKEN_REF:
            case STRING_LITERAL:
            case CHAR_LITERAL:
            case 92:
                {
                alt31=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:154:9: ^( ( '^' | '!' ) atom )
                    {
                    if ( (input.LA(1)>=ROOT && input.LA(1)<=BANG) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_atom_in_atom749);
                    atom();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:155:4: range
                    {
                    pushFollow(FOLLOW_range_in_atom755);
                    range();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:156:4: notSet
                    {
                    pushFollow(FOLLOW_notSet_in_atom760);
                    notSet();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:157:7: ^( RULE_REF ARG_ACTION )
                    {
                    match(input,RULE_REF,FOLLOW_RULE_REF_in_atom769); 

                    match(input, Token.DOWN, null); 
                    match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom771); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:158:7: RULE_REF
                    {
                    match(input,RULE_REF,FOLLOW_RULE_REF_in_atom780); 

                    }
                    break;
                case 6 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:159:9: terminal
                    {
                    pushFollow(FOLLOW_terminal_in_atom790);
                    terminal();

                    state._fsp--;


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
    // $ANTLR end "atom"


    // $ANTLR start "notSet"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:162:1: notSet : ( ^( '~' notTerminal ) | ^( '~' block ) );
    public final void notSet() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:163:2: ( ^( '~' notTerminal ) | ^( '~' block ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==89) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==DOWN) ) {
                    int LA32_2 = input.LA(3);

                    if ( (LA32_2==BLOCK) ) {
                        alt32=2;
                    }
                    else if ( ((LA32_2>=TOKEN_REF && LA32_2<=CHAR_LITERAL)) ) {
                        alt32=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:163:4: ^( '~' notTerminal )
                    {
                    match(input,89,FOLLOW_89_in_notSet805); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_notTerminal_in_notSet807);
                    notTerminal();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:164:4: ^( '~' block )
                    {
                    match(input,89,FOLLOW_89_in_notSet814); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_notSet816);
                    block();

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
    // $ANTLR end "notSet"


    // $ANTLR start "treeSpec"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:167:1: treeSpec : ^( TREE_BEGIN ( element )+ ) ;
    public final void treeSpec() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:168:2: ( ^( TREE_BEGIN ( element )+ ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:168:4: ^( TREE_BEGIN ( element )+ )
            {
            match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_treeSpec829); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:168:17: ( element )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=BLOCK && LA33_0<=SYNPRED)||LA33_0==CHAR_RANGE||(LA33_0>=SEMPRED && LA33_0<=SYN_SEMPRED)||(LA33_0>=TREE_BEGIN && LA33_0<=BANG)||(LA33_0>=TOKEN_REF && LA33_0<=ACTION)||LA33_0==RULE_REF||LA33_0==71||LA33_0==87||LA33_0==89||LA33_0==92) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:168:17: element
            	    {
            	    pushFollow(FOLLOW_element_in_treeSpec831);
            	    element();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
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
    // $ANTLR end "treeSpec"


    // $ANTLR start "ebnf"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:171:1: ebnf : ( ^( SYNPRED block ) | SYN_SEMPRED | ^( ebnfSuffix block ) | block );
    public final void ebnf() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:173:2: ( ^( SYNPRED block ) | SYN_SEMPRED | ^( ebnfSuffix block ) | block )
            int alt34=4;
            switch ( input.LA(1) ) {
            case SYNPRED:
                {
                alt34=1;
                }
                break;
            case SYN_SEMPRED:
                {
                alt34=2;
                }
                break;
            case OPTIONAL:
            case CLOSURE:
            case POSITIVE_CLOSURE:
                {
                alt34=3;
                }
                break;
            case BLOCK:
                {
                alt34=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:173:4: ^( SYNPRED block )
                    {
                    match(input,SYNPRED,FOLLOW_SYNPRED_in_ebnf847); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_ebnf849);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:174:4: SYN_SEMPRED
                    {
                    match(input,SYN_SEMPRED,FOLLOW_SYN_SEMPRED_in_ebnf855); 

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:175:4: ^( ebnfSuffix block )
                    {
                    pushFollow(FOLLOW_ebnfSuffix_in_ebnf861);
                    ebnfSuffix();

                    state._fsp--;


                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_ebnf863);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:176:4: block
                    {
                    pushFollow(FOLLOW_block_in_ebnf869);
                    block();

                    state._fsp--;


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
    // $ANTLR end "ebnf"


    // $ANTLR start "range"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:179:1: range : ^( CHAR_RANGE CHAR_LITERAL CHAR_LITERAL ) ;
    public final void range() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:180:2: ( ^( CHAR_RANGE CHAR_LITERAL CHAR_LITERAL ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:180:4: ^( CHAR_RANGE CHAR_LITERAL CHAR_LITERAL )
            {
            match(input,CHAR_RANGE,FOLLOW_CHAR_RANGE_in_range881); 

            match(input, Token.DOWN, null); 
            match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range883); 
            match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range885); 

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
    // $ANTLR end "range"


    // $ANTLR start "terminal"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:183:1: terminal : ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL | ^( TOKEN_REF ARG_ACTION ) | '.' );
    public final void terminal() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:184:5: ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL | ^( TOKEN_REF ARG_ACTION ) | '.' )
            int alt35=5;
            switch ( input.LA(1) ) {
            case CHAR_LITERAL:
                {
                alt35=1;
                }
                break;
            case TOKEN_REF:
                {
                int LA35_2 = input.LA(2);

                if ( (LA35_2==DOWN) ) {
                    alt35=4;
                }
                else if ( (LA35_2==UP||(LA35_2>=BLOCK && LA35_2<=SYNPRED)||LA35_2==CHAR_RANGE||LA35_2==EOA||(LA35_2>=SEMPRED && LA35_2<=SYN_SEMPRED)||(LA35_2>=TREE_BEGIN && LA35_2<=BANG)||(LA35_2>=TOKEN_REF && LA35_2<=ACTION)||LA35_2==RULE_REF||LA35_2==71||LA35_2==87||LA35_2==89||LA35_2==92) ) {
                    alt35=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 2, input);

                    throw nvae;
                }
                }
                break;
            case STRING_LITERAL:
                {
                alt35=3;
                }
                break;
            case 92:
                {
                alt35=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:184:9: CHAR_LITERAL
                    {
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_terminal902); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:185:7: TOKEN_REF
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal910); 

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:186:7: STRING_LITERAL
                    {
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_terminal918); 

                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:187:7: ^( TOKEN_REF ARG_ACTION )
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal927); 

                    match(input, Token.DOWN, null); 
                    match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_terminal929); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 5 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:188:7: '.'
                    {
                    match(input,92,FOLLOW_92_in_terminal938); 

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
    // $ANTLR end "terminal"


    // $ANTLR start "notTerminal"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:191:1: notTerminal : ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL );
    public final void notTerminal() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:192:2: ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:
            {
            if ( (input.LA(1)>=TOKEN_REF && input.LA(1)<=CHAR_LITERAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "notTerminal"


    // $ANTLR start "ebnfSuffix"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:197:1: ebnfSuffix : ( OPTIONAL | CLOSURE | POSITIVE_CLOSURE );
    public final void ebnfSuffix() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:198:2: ( OPTIONAL | CLOSURE | POSITIVE_CLOSURE )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:
            {
            if ( (input.LA(1)>=OPTIONAL && input.LA(1)<=POSITIVE_CLOSURE) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "ebnfSuffix"


    // $ANTLR start "rewrite"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:205:1: rewrite : ( ( ^( '->' SEMPRED rewrite_alternative ) )* ^( '->' rewrite_alternative ) | );
    public final void rewrite() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:206:2: ( ( ^( '->' SEMPRED rewrite_alternative ) )* ^( '->' rewrite_alternative ) | )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==REWRITE) ) {
                alt37=1;
            }
            else if ( (LA37_0==ALT||LA37_0==EOB) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:206:4: ( ^( '->' SEMPRED rewrite_alternative ) )* ^( '->' rewrite_alternative )
                    {
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:206:4: ( ^( '->' SEMPRED rewrite_alternative ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==REWRITE) ) {
                            int LA36_1 = input.LA(2);

                            if ( (LA36_1==DOWN) ) {
                                int LA36_2 = input.LA(3);

                                if ( (LA36_2==SEMPRED) ) {
                                    alt36=1;
                                }


                            }


                        }


                        switch (alt36) {
                    	case 1 :
                    	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:206:5: ^( '->' SEMPRED rewrite_alternative )
                    	    {
                    	    match(input,REWRITE,FOLLOW_REWRITE_in_rewrite1004); 

                    	    match(input, Token.DOWN, null); 
                    	    match(input,SEMPRED,FOLLOW_SEMPRED_in_rewrite1006); 
                    	    pushFollow(FOLLOW_rewrite_alternative_in_rewrite1008);
                    	    rewrite_alternative();

                    	    state._fsp--;


                    	    match(input, Token.UP, null); 

                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);

                    match(input,REWRITE,FOLLOW_REWRITE_in_rewrite1014); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_rewrite_alternative_in_rewrite1016);
                    rewrite_alternative();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:208:2: 
                    {
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
    // $ANTLR end "rewrite"


    // $ANTLR start "rewrite_alternative"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:210:1: rewrite_alternative : ( rewrite_template | rewrite_tree_alternative | ^( ALT EPSILON EOA ) );
    public final void rewrite_alternative() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:211:2: ( rewrite_template | rewrite_tree_alternative | ^( ALT EPSILON EOA ) )
            int alt38=3;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==TEMPLATE||LA38_0==ACTION) ) {
                alt38=1;
            }
            else if ( (LA38_0==ALT) ) {
                int LA38_2 = input.LA(2);

                if ( (LA38_2==DOWN) ) {
                    int LA38_3 = input.LA(3);

                    if ( (LA38_3==EPSILON) ) {
                        alt38=3;
                    }
                    else if ( ((LA38_3>=BLOCK && LA38_3<=POSITIVE_CLOSURE)||LA38_3==LABEL||LA38_3==TREE_BEGIN||(LA38_3>=TOKEN_REF && LA38_3<=ACTION)||LA38_3==RULE_REF) ) {
                        alt38=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:211:4: rewrite_template
                    {
                    pushFollow(FOLLOW_rewrite_template_in_rewrite_alternative1031);
                    rewrite_template();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:212:4: rewrite_tree_alternative
                    {
                    pushFollow(FOLLOW_rewrite_tree_alternative_in_rewrite_alternative1036);
                    rewrite_tree_alternative();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:213:9: ^( ALT EPSILON EOA )
                    {
                    match(input,ALT,FOLLOW_ALT_in_rewrite_alternative1047); 

                    match(input, Token.DOWN, null); 
                    match(input,EPSILON,FOLLOW_EPSILON_in_rewrite_alternative1049); 
                    match(input,EOA,FOLLOW_EOA_in_rewrite_alternative1051); 

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
    // $ANTLR end "rewrite_alternative"


    // $ANTLR start "rewrite_tree_block"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:216:1: rewrite_tree_block : ^( BLOCK rewrite_tree_alternative EOB ) ;
    public final void rewrite_tree_block() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:217:5: ( ^( BLOCK rewrite_tree_alternative EOB ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:217:9: ^( BLOCK rewrite_tree_alternative EOB )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_rewrite_tree_block1070); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_rewrite_tree_alternative_in_rewrite_tree_block1072);
            rewrite_tree_alternative();

            state._fsp--;

            match(input,EOB,FOLLOW_EOB_in_rewrite_tree_block1074); 

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
    // $ANTLR end "rewrite_tree_block"


    // $ANTLR start "rewrite_tree_alternative"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:220:1: rewrite_tree_alternative : ^( ALT ( rewrite_tree_element )+ EOA ) ;
    public final void rewrite_tree_alternative() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:221:5: ( ^( ALT ( rewrite_tree_element )+ EOA ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:221:7: ^( ALT ( rewrite_tree_element )+ EOA )
            {
            match(input,ALT,FOLLOW_ALT_in_rewrite_tree_alternative1093); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:221:13: ( rewrite_tree_element )+
            int cnt39=0;
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=BLOCK && LA39_0<=POSITIVE_CLOSURE)||LA39_0==LABEL||LA39_0==TREE_BEGIN||(LA39_0>=TOKEN_REF && LA39_0<=ACTION)||LA39_0==RULE_REF) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:221:13: rewrite_tree_element
            	    {
            	    pushFollow(FOLLOW_rewrite_tree_element_in_rewrite_tree_alternative1095);
            	    rewrite_tree_element();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt39 >= 1 ) break loop39;
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
            } while (true);

            match(input,EOA,FOLLOW_EOA_in_rewrite_tree_alternative1098); 

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
    // $ANTLR end "rewrite_tree_alternative"


    // $ANTLR start "rewrite_tree_element"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:224:1: rewrite_tree_element : ( rewrite_tree_atom | rewrite_tree | rewrite_tree_block | rewrite_tree_ebnf );
    public final void rewrite_tree_element() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:225:2: ( rewrite_tree_atom | rewrite_tree | rewrite_tree_block | rewrite_tree_ebnf )
            int alt40=4;
            switch ( input.LA(1) ) {
            case LABEL:
            case TOKEN_REF:
            case STRING_LITERAL:
            case CHAR_LITERAL:
            case ACTION:
            case RULE_REF:
                {
                alt40=1;
                }
                break;
            case TREE_BEGIN:
                {
                alt40=2;
                }
                break;
            case BLOCK:
                {
                alt40=3;
                }
                break;
            case OPTIONAL:
            case CLOSURE:
            case POSITIVE_CLOSURE:
                {
                alt40=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:225:4: rewrite_tree_atom
                    {
                    pushFollow(FOLLOW_rewrite_tree_atom_in_rewrite_tree_element1113);
                    rewrite_tree_atom();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:226:4: rewrite_tree
                    {
                    pushFollow(FOLLOW_rewrite_tree_in_rewrite_tree_element1118);
                    rewrite_tree();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:227:6: rewrite_tree_block
                    {
                    pushFollow(FOLLOW_rewrite_tree_block_in_rewrite_tree_element1125);
                    rewrite_tree_block();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:228:6: rewrite_tree_ebnf
                    {
                    pushFollow(FOLLOW_rewrite_tree_ebnf_in_rewrite_tree_element1132);
                    rewrite_tree_ebnf();

                    state._fsp--;


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
    // $ANTLR end "rewrite_tree_element"


    // $ANTLR start "rewrite_tree_atom"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:231:1: rewrite_tree_atom : ( CHAR_LITERAL | TOKEN_REF | ^( TOKEN_REF ARG_ACTION ) | RULE_REF | STRING_LITERAL | LABEL | ACTION );
    public final void rewrite_tree_atom() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:232:5: ( CHAR_LITERAL | TOKEN_REF | ^( TOKEN_REF ARG_ACTION ) | RULE_REF | STRING_LITERAL | LABEL | ACTION )
            int alt41=7;
            switch ( input.LA(1) ) {
            case CHAR_LITERAL:
                {
                alt41=1;
                }
                break;
            case TOKEN_REF:
                {
                int LA41_2 = input.LA(2);

                if ( (LA41_2==DOWN) ) {
                    alt41=3;
                }
                else if ( (LA41_2==UP||(LA41_2>=BLOCK && LA41_2<=POSITIVE_CLOSURE)||LA41_2==EOA||LA41_2==LABEL||LA41_2==TREE_BEGIN||(LA41_2>=TOKEN_REF && LA41_2<=ACTION)||LA41_2==RULE_REF) ) {
                    alt41=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_REF:
                {
                alt41=4;
                }
                break;
            case STRING_LITERAL:
                {
                alt41=5;
                }
                break;
            case LABEL:
                {
                alt41=6;
                }
                break;
            case ACTION:
                {
                alt41=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:232:9: CHAR_LITERAL
                    {
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_rewrite_tree_atom1148); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:233:6: TOKEN_REF
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_rewrite_tree_atom1155); 

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:234:6: ^( TOKEN_REF ARG_ACTION )
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_rewrite_tree_atom1163); 

                    match(input, Token.DOWN, null); 
                    match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rewrite_tree_atom1165); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:235:9: RULE_REF
                    {
                    match(input,RULE_REF,FOLLOW_RULE_REF_in_rewrite_tree_atom1177); 

                    }
                    break;
                case 5 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:236:6: STRING_LITERAL
                    {
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_rewrite_tree_atom1184); 

                    }
                    break;
                case 6 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:237:6: LABEL
                    {
                    match(input,LABEL,FOLLOW_LABEL_in_rewrite_tree_atom1191); 

                    }
                    break;
                case 7 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:238:4: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_rewrite_tree_atom1196); 

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
    // $ANTLR end "rewrite_tree_atom"


    // $ANTLR start "rewrite_tree_ebnf"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:241:1: rewrite_tree_ebnf : ^( ebnfSuffix rewrite_tree_block ) ;
    public final void rewrite_tree_ebnf() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:242:2: ( ^( ebnfSuffix rewrite_tree_block ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:242:4: ^( ebnfSuffix rewrite_tree_block )
            {
            pushFollow(FOLLOW_ebnfSuffix_in_rewrite_tree_ebnf1208);
            ebnfSuffix();

            state._fsp--;


            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_rewrite_tree_block_in_rewrite_tree_ebnf1210);
            rewrite_tree_block();

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
    // $ANTLR end "rewrite_tree_ebnf"


    // $ANTLR start "rewrite_tree"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:245:1: rewrite_tree : ^( TREE_BEGIN rewrite_tree_atom ( rewrite_tree_element )* ) ;
    public final void rewrite_tree() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:246:2: ( ^( TREE_BEGIN rewrite_tree_atom ( rewrite_tree_element )* ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:246:4: ^( TREE_BEGIN rewrite_tree_atom ( rewrite_tree_element )* )
            {
            match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_rewrite_tree1224); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_rewrite_tree_atom_in_rewrite_tree1226);
            rewrite_tree_atom();

            state._fsp--;

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:246:35: ( rewrite_tree_element )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=BLOCK && LA42_0<=POSITIVE_CLOSURE)||LA42_0==LABEL||LA42_0==TREE_BEGIN||(LA42_0>=TOKEN_REF && LA42_0<=ACTION)||LA42_0==RULE_REF) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:246:35: rewrite_tree_element
            	    {
            	    pushFollow(FOLLOW_rewrite_tree_element_in_rewrite_tree1228);
            	    rewrite_tree_element();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
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
    // $ANTLR end "rewrite_tree"


    // $ANTLR start "rewrite_template"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:249:1: rewrite_template : ( ^( TEMPLATE ID rewrite_template_args ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL ) ) | rewrite_template_ref | rewrite_indirect_template_head | ACTION );
    public final void rewrite_template() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:250:2: ( ^( TEMPLATE ID rewrite_template_args ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL ) ) | rewrite_template_ref | rewrite_indirect_template_head | ACTION )
            int alt43=4;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:250:6: ^( TEMPLATE ID rewrite_template_args ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL ) )
                    {
                    match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite_template1246); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_rewrite_template1248); 
                    pushFollow(FOLLOW_rewrite_template_args_in_rewrite_template1250);
                    rewrite_template_args();

                    state._fsp--;

                    if ( (input.LA(1)>=DOUBLE_QUOTE_STRING_LITERAL && input.LA(1)<=DOUBLE_ANGLE_STRING_LITERAL) ) {
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
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:253:4: rewrite_template_ref
                    {
                    pushFollow(FOLLOW_rewrite_template_ref_in_rewrite_template1273);
                    rewrite_template_ref();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:254:4: rewrite_indirect_template_head
                    {
                    pushFollow(FOLLOW_rewrite_indirect_template_head_in_rewrite_template1278);
                    rewrite_indirect_template_head();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:255:4: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_rewrite_template1283); 

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
    // $ANTLR end "rewrite_template"


    // $ANTLR start "rewrite_template_ref"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:258:1: rewrite_template_ref : ^( TEMPLATE ID rewrite_template_args ) ;
    public final void rewrite_template_ref() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:260:2: ( ^( TEMPLATE ID rewrite_template_args ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:260:4: ^( TEMPLATE ID rewrite_template_args )
            {
            match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite_template_ref1297); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_rewrite_template_ref1299); 
            pushFollow(FOLLOW_rewrite_template_args_in_rewrite_template_ref1301);
            rewrite_template_args();

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
    // $ANTLR end "rewrite_template_ref"


    // $ANTLR start "rewrite_indirect_template_head"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:263:1: rewrite_indirect_template_head : ^( TEMPLATE ACTION rewrite_template_args ) ;
    public final void rewrite_indirect_template_head() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:265:2: ( ^( TEMPLATE ACTION rewrite_template_args ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:265:4: ^( TEMPLATE ACTION rewrite_template_args )
            {
            match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite_indirect_template_head1316); 

            match(input, Token.DOWN, null); 
            match(input,ACTION,FOLLOW_ACTION_in_rewrite_indirect_template_head1318); 
            pushFollow(FOLLOW_rewrite_template_args_in_rewrite_indirect_template_head1320);
            rewrite_template_args();

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
    // $ANTLR end "rewrite_indirect_template_head"


    // $ANTLR start "rewrite_template_args"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:268:1: rewrite_template_args : ( ^( ARGLIST ( rewrite_template_arg )+ ) | ARGLIST );
    public final void rewrite_template_args() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:269:2: ( ^( ARGLIST ( rewrite_template_arg )+ ) | ARGLIST )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==ARGLIST) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==DOWN) ) {
                    alt45=1;
                }
                else if ( (LA45_1==UP||(LA45_1>=DOUBLE_QUOTE_STRING_LITERAL && LA45_1<=DOUBLE_ANGLE_STRING_LITERAL)) ) {
                    alt45=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:269:4: ^( ARGLIST ( rewrite_template_arg )+ )
                    {
                    match(input,ARGLIST,FOLLOW_ARGLIST_in_rewrite_template_args1333); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:269:14: ( rewrite_template_arg )+
                    int cnt44=0;
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==ARG) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:269:14: rewrite_template_arg
                    	    {
                    	    pushFollow(FOLLOW_rewrite_template_arg_in_rewrite_template_args1335);
                    	    rewrite_template_arg();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt44 >= 1 ) break loop44;
                                EarlyExitException eee =
                                    new EarlyExitException(44, input);
                                throw eee;
                        }
                        cnt44++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:270:4: ARGLIST
                    {
                    match(input,ARGLIST,FOLLOW_ARGLIST_in_rewrite_template_args1342); 

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
    // $ANTLR end "rewrite_template_args"


    // $ANTLR start "rewrite_template_arg"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:273:1: rewrite_template_arg : ^( ARG ID ACTION ) ;
    public final void rewrite_template_arg() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:274:2: ( ^( ARG ID ACTION ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3Tree.g:274:6: ^( ARG ID ACTION )
            {
            match(input,ARG,FOLLOW_ARG_in_rewrite_template_arg1356); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_rewrite_template_arg1358); 
            match(input,ACTION,FOLLOW_ACTION_in_rewrite_template_arg1360); 

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
    // $ANTLR end "rewrite_template_arg"

    // Delegated rules


    protected DFA30 dfa30 = new DFA30(this);
    protected DFA43 dfa43 = new DFA43(this);
    static final String DFA30_eotS =
        "\14\uffff";
    static final String DFA30_eofS =
        "\14\uffff";
    static final String DFA30_minS =
        "\1\10\1\2\6\uffff\1\24\1\10\2\uffff";
    static final String DFA30_maxS =
        "\1\134\1\2\6\uffff\1\24\1\134\2\uffff";
    static final String DFA30_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff\1\2\1\1";
    static final String DFA30_specialS =
        "\14\uffff}>";
    static final String[] DFA30_transitionS = {
            "\5\3\1\uffff\1\2\21\uffff\1\5\1\6\1\3\2\uffff\1\7\2\2\2\uffff"+
            "\3\2\1\4\3\uffff\1\2\25\uffff\1\1\17\uffff\1\1\1\uffff\1\2\2"+
            "\uffff\1\2",
            "\1\10",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\11",
            "\1\13\5\uffff\1\12\27\uffff\2\12\2\uffff\3\12\4\uffff\1\12"+
            "\47\uffff\1\12\2\uffff\1\12",
            "",
            ""
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "143:1: elementNoOptionSpec : ( ^( ( '=' | '+=' ) ID block ) | ^( ( '=' | '+=' ) ID atom ) | atom | ebnf | ACTION | SEMPRED | GATED_SEMPRED | treeSpec );";
        }
    }
    static final String DFA43_eotS =
        "\20\uffff";
    static final String DFA43_eofS =
        "\20\uffff";
    static final String DFA43_minS =
        "\1\36\1\2\1\uffff\1\24\1\26\1\uffff\1\2\1\25\2\uffff\1\2\1\24\1"+
        "\55\3\3";
    static final String DFA43_maxS =
        "\1\55\1\2\1\uffff\1\55\1\26\1\uffff\1\63\1\25\2\uffff\1\2\1\24\1"+
        "\55\1\3\1\25\1\63";
    static final String DFA43_acceptS =
        "\2\uffff\1\4\2\uffff\1\3\2\uffff\1\2\1\1\6\uffff";
    static final String DFA43_specialS =
        "\20\uffff}>";
    static final String[] DFA43_transitionS = {
            "\1\1\16\uffff\1\2",
            "\1\3",
            "",
            "\1\4\30\uffff\1\5",
            "\1\6",
            "",
            "\1\7\1\10\56\uffff\2\11",
            "\1\12",
            "",
            "",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17\21\uffff\1\12",
            "\1\10\56\uffff\2\11"
    };

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "249:1: rewrite_template : ( ^( TEMPLATE ID rewrite_template_args ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL ) ) | rewrite_template_ref | rewrite_indirect_template_head | ACTION );";
        }
    }
 

    public static final BitSet FOLLOW_grammarType_in_grammarDef52 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_grammarDef54 = new BitSet(new long[]{0x0000420080000090L,0x0000000000000100L});
    public static final BitSet FOLLOW_DOC_COMMENT_in_grammarDef56 = new BitSet(new long[]{0x0000420080000090L,0x0000000000000100L});
    public static final BitSet FOLLOW_optionsSpec_in_grammarDef59 = new BitSet(new long[]{0x0000420080000090L,0x0000000000000100L});
    public static final BitSet FOLLOW_tokensSpec_in_grammarDef62 = new BitSet(new long[]{0x0000420080000090L,0x0000000000000100L});
    public static final BitSet FOLLOW_attrScope_in_grammarDef65 = new BitSet(new long[]{0x0000420080000090L,0x0000000000000100L});
    public static final BitSet FOLLOW_action_in_grammarDef68 = new BitSet(new long[]{0x0000420080000090L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule_in_grammarDef71 = new BitSet(new long[]{0x0000420080000098L,0x0000000000000100L});
    public static final BitSet FOLLOW_set_in_grammarType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKENS_in_tokensSpec119 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tokenSpec_in_tokensSpec121 = new BitSet(new long[]{0x0000040000000008L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_tokenSpec135 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec137 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_tokenSpec139 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_71_in_tokenSpec146 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec148 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_tokenSpec150 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SCOPE_in_attrScope168 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_attrScope170 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ACTION_in_attrScope172 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_72_in_action185 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_action187 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ID_in_action189 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ACTION_in_action191 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_72_in_action198 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_action200 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ACTION_in_action202 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OPTIONS_in_optionsSpec215 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_option_in_optionsSpec217 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_option236 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_option238 = new BitSet(new long[]{0x0000980000100000L});
    public static final BitSet FOLLOW_optionValue_in_option240 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_optionValue0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_in_rule306 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rule308 = new BitSet(new long[]{0x0000401080A00100L,0x0000000000003900L});
    public static final BitSet FOLLOW_modifier_in_rule310 = new BitSet(new long[]{0x0000401080A00100L,0x0000000000003900L});
    public static final BitSet FOLLOW_ARG_in_rule315 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rule317 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RET_in_rule324 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rule326 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_optionsSpec_in_rule339 = new BitSet(new long[]{0x0000401080A00100L,0x0000000000003900L});
    public static final BitSet FOLLOW_ruleScopeSpec_in_rule342 = new BitSet(new long[]{0x0000401080A00100L,0x0000000000003900L});
    public static final BitSet FOLLOW_ruleAction_in_rule345 = new BitSet(new long[]{0x0000401080A00100L,0x0000000000003900L});
    public static final BitSet FOLLOW_altList_in_rule356 = new BitSet(new long[]{0x0000000000020000L,0x0000000000600000L});
    public static final BitSet FOLLOW_exceptionGroup_in_rule366 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_EOR_in_rule369 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_modifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleAction408 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_ruleAction410 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ACTION_in_ruleAction412 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_80_in_throwsSpec425 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_throwsSpec427 = new BitSet(new long[]{0x0000000000100008L});
    public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec441 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec443 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec450 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec452 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ID_in_ruleScopeSpec454 = new BitSet(new long[]{0x0000000000100008L});
    public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec462 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_ruleScopeSpec464 = new BitSet(new long[]{0x0000000000100008L});
    public static final BitSet FOLLOW_BLOCK_in_block484 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_optionsSpec_in_block486 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_alternative_in_block490 = new BitSet(new long[]{0x0000010000050000L});
    public static final BitSet FOLLOW_rewrite_in_block492 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_EOB_in_block496 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_altList519 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alternative_in_altList522 = new BitSet(new long[]{0x0000010000050000L});
    public static final BitSet FOLLOW_rewrite_in_altList524 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_EOB_in_altList528 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_alternative550 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_alternative552 = new BitSet(new long[]{0x00023CE700085F00L,0x0000000012800080L});
    public static final BitSet FOLLOW_EOA_in_alternative555 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_alternative567 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EPSILON_in_alternative569 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_EOA_in_alternative571 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup586 = new BitSet(new long[]{0x0000000000000002L,0x0000000000600000L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_exceptionHandler616 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler618 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ACTION_in_exceptionHandler620 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_86_in_finallyClause642 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_finallyClause644 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_elementNoOptionSpec_in_element659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_elementNoOptionSpec671 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_elementNoOptionSpec677 = new BitSet(new long[]{0x0000000400001F00L});
    public static final BitSet FOLLOW_block_in_elementNoOptionSpec679 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_elementNoOptionSpec686 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_elementNoOptionSpec692 = new BitSet(new long[]{0x00021CC000004000L,0x0000000012000000L});
    public static final BitSet FOLLOW_atom_in_elementNoOptionSpec694 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_elementNoOptionSpec700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ebnf_in_elementNoOptionSpec705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_elementNoOptionSpec712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_elementNoOptionSpec719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GATED_SEMPRED_in_elementNoOptionSpec724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_treeSpec_in_elementNoOptionSpec731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_atom743 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atom_in_atom749 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_range_in_atom755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notSet_in_atom760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REF_in_atom769 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_atom771 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_REF_in_atom780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_terminal_in_atom790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_notSet805 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_notTerminal_in_notSet807 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_89_in_notSet814 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_notSet816 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_BEGIN_in_treeSpec829 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_treeSpec831 = new BitSet(new long[]{0x00023CE700085F08L,0x0000000012800080L});
    public static final BitSet FOLLOW_SYNPRED_in_ebnf847 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf849 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SYN_SEMPRED_in_ebnf855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ebnfSuffix_in_ebnf861 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf863 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_ebnf869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_RANGE_in_range881 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_range883 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_range885 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_terminal902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal927 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_terminal929 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_92_in_terminal938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_notTerminal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_ebnfSuffix0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REWRITE_in_rewrite1004 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEMPRED_in_rewrite1006 = new BitSet(new long[]{0x0000200040010000L});
    public static final BitSet FOLLOW_rewrite_alternative_in_rewrite1008 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REWRITE_in_rewrite1014 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_alternative_in_rewrite1016 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rewrite_template_in_rewrite_alternative1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_tree_alternative_in_rewrite_alternative1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALT_in_rewrite_alternative1047 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EPSILON_in_rewrite_alternative1049 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_EOA_in_rewrite_alternative1051 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_rewrite_tree_block1070 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_tree_alternative_in_rewrite_tree_block1072 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EOB_in_rewrite_tree_block1074 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_rewrite_tree_alternative1093 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_tree_element_in_rewrite_tree_alternative1095 = new BitSet(new long[]{0x00023C2020080F00L});
    public static final BitSet FOLLOW_EOA_in_rewrite_tree_alternative1098 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rewrite_tree_atom_in_rewrite_tree_element1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_tree_in_rewrite_tree_element1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_tree_block_in_rewrite_tree_element1125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_tree_ebnf_in_rewrite_tree_element1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_rewrite_tree_atom1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_rewrite_tree_atom1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_rewrite_tree_atom1163 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rewrite_tree_atom1165 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_REF_in_rewrite_tree_atom1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_rewrite_tree_atom1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LABEL_in_rewrite_tree_atom1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_tree_atom1196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ebnfSuffix_in_rewrite_tree_ebnf1208 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_tree_block_in_rewrite_tree_ebnf1210 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_BEGIN_in_rewrite_tree1224 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_tree_atom_in_rewrite_tree1226 = new BitSet(new long[]{0x00023C2020080F08L});
    public static final BitSet FOLLOW_rewrite_tree_element_in_rewrite_tree1228 = new BitSet(new long[]{0x00023C2020080F08L});
    public static final BitSet FOLLOW_TEMPLATE_in_rewrite_template1246 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rewrite_template1248 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_template1250 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_set_in_rewrite_template1257 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rewrite_template_ref_in_rewrite_template1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_indirect_template_head_in_rewrite_template1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_template1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEMPLATE_in_rewrite_template_ref1297 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rewrite_template_ref1299 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_template_ref1301 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TEMPLATE_in_rewrite_indirect_template_head1316 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_indirect_template_head1318 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_indirect_template_head1320 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGLIST_in_rewrite_template_args1333 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_template_arg_in_rewrite_template_args1335 = new BitSet(new long[]{0x0000000000200008L});
    public static final BitSet FOLLOW_ARGLIST_in_rewrite_template_args1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARG_in_rewrite_template_arg1356 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rewrite_template_arg1358 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_template_arg1360 = new BitSet(new long[]{0x0000000000000008L});

}