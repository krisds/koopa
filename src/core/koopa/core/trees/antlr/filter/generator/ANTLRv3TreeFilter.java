// $ANTLR 3.1.1 src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g 2014-11-24 20:28:12

  package koopa.core.trees.antlr.filter.generator;
  
  import java.util.List;
  import java.util.LinkedList;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
/** ANTLR v3 tree grammar to walk trees created by ANTLRv3.g */
public class ANTLRv3TreeFilter extends TreeParser {
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


        public ANTLRv3TreeFilter(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public ANTLRv3TreeFilter(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected StringTemplateGroup templateLib =
      new StringTemplateGroup("ANTLRv3TreeFilterTemplates", AngleBracketTemplateLexer.class);

    public void setTemplateLib(StringTemplateGroup templateLib) {
      this.templateLib = templateLib;
    }
    public StringTemplateGroup getTemplateLib() {
      return templateLib;
    }
    /** allows convenient multi-value initialization:
     *  "new STAttrMap().put(...).put(...)"
     */
    public static class STAttrMap extends HashMap {
      public STAttrMap put(String attrName, Object value) {
        super.put(attrName, value);
        return this;
      }
      public STAttrMap put(String attrName, int value) {
        super.put(attrName, new Integer(value));
        return this;
      }
    }

    public String[] getTokenNames() { return ANTLRv3TreeFilter.tokenNames; }
    public String getGrammarFileName() { return "src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g"; }


      private String scope = null;


    public static class grammarDef_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "grammarDef"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:49:1: grammarDef[String pack] : ^( grammarType ID ( DOC_COMMENT )? ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* (r+= rule )+ ) -> filter(id=$IDrule=$rpack=pack);
    public final ANTLRv3TreeFilter.grammarDef_return grammarDef(String pack) throws RecognitionException {
        ANTLRv3TreeFilter.grammarDef_return retval = new ANTLRv3TreeFilter.grammarDef_return();
        retval.start = input.LT(1);

        CommonTree ID1=null;
        List list_r=null;
        RuleReturnScope r = null;
        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:50:3: ( ^( grammarType ID ( DOC_COMMENT )? ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* (r+= rule )+ ) -> filter(id=$IDrule=$rpack=pack))
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:50:5: ^( grammarType ID ( DOC_COMMENT )? ( optionsSpec )? ( tokensSpec )? ( attrScope )* ( action )* (r+= rule )+ )
            {
            pushFollow(FOLLOW_grammarType_in_grammarDef65);
            grammarType();

            state._fsp--;


            match(input, Token.DOWN, null); 
            ID1=(CommonTree)match(input,ID,FOLLOW_ID_in_grammarDef67); 
             scope = (ID1!=null?ID1.getText():null); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:54:8: ( DOC_COMMENT )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==DOC_COMMENT) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:54:8: DOC_COMMENT
                    {
                    match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammarDef101); 

                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:54:21: ( optionsSpec )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==OPTIONS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:54:21: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_grammarDef104);
                    optionsSpec();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:54:34: ( tokensSpec )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==TOKENS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:54:34: tokensSpec
                    {
                    pushFollow(FOLLOW_tokensSpec_in_grammarDef107);
                    tokensSpec();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:54:46: ( attrScope )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==SCOPE) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:54:46: attrScope
            	    {
            	    pushFollow(FOLLOW_attrScope_in_grammarDef110);
            	    attrScope();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:54:57: ( action )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==72) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:54:57: action
            	    {
            	    pushFollow(FOLLOW_action_in_grammarDef113);
            	    action();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:54:65: (r+= rule )+
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
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:54:66: r+= rule
            	    {
            	    pushFollow(FOLLOW_rule_in_grammarDef119);
            	    r=rule();

            	    state._fsp--;

            	    if (list_r==null) list_r=new ArrayList();
            	    list_r.add(r.getTemplate());


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


            // TEMPLATE REWRITE
            // 56:5: -> filter(id=$IDrule=$rpack=pack)
            {
                retval.st = templateLib.getInstanceOf("filter",
              new STAttrMap().put("id", ID1).put("rule", list_r).put("pack", pack));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "grammarDef"

    public static class grammarType_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "grammarType"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:63:1: grammarType : ( LEXER_GRAMMAR | PARSER_GRAMMAR | TREE_GRAMMAR | COMBINED_GRAMMAR );
    public final ANTLRv3TreeFilter.grammarType_return grammarType() throws RecognitionException {
        ANTLRv3TreeFilter.grammarType_return retval = new ANTLRv3TreeFilter.grammarType_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:64:3: ( LEXER_GRAMMAR | PARSER_GRAMMAR | TREE_GRAMMAR | COMBINED_GRAMMAR )
            int alt7=4;
            switch ( input.LA(1) ) {
            case LEXER_GRAMMAR:
                {
                alt7=1;
                }
                break;
            case PARSER_GRAMMAR:
                {
                alt7=2;
                }
                break;
            case TREE_GRAMMAR:
                {
                alt7=3;
                }
                break;
            case COMBINED_GRAMMAR:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:64:5: LEXER_GRAMMAR
                    {
                    match(input,LEXER_GRAMMAR,FOLLOW_LEXER_GRAMMAR_in_grammarType195); 
                     if (true) throw new UnsupportedSyntaxException("Only tree grammars are allowed."); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:66:5: PARSER_GRAMMAR
                    {
                    match(input,PARSER_GRAMMAR,FOLLOW_PARSER_GRAMMAR_in_grammarType207); 
                     if (true) throw new UnsupportedSyntaxException("Only tree grammars are allowed."); 

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:68:5: TREE_GRAMMAR
                    {
                    match(input,TREE_GRAMMAR,FOLLOW_TREE_GRAMMAR_in_grammarType219); 

                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:69:5: COMBINED_GRAMMAR
                    {
                    match(input,COMBINED_GRAMMAR,FOLLOW_COMBINED_GRAMMAR_in_grammarType225); 
                     if (true) throw new UnsupportedSyntaxException("Only tree grammars are allowed."); 

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
        return retval;
    }
    // $ANTLR end "grammarType"

    public static class tokensSpec_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "tokensSpec"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:73:1: tokensSpec : ^( TOKENS ( tokenSpec )+ ) ;
    public final ANTLRv3TreeFilter.tokensSpec_return tokensSpec() throws RecognitionException {
        ANTLRv3TreeFilter.tokensSpec_return retval = new ANTLRv3TreeFilter.tokensSpec_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:74:2: ( ^( TOKENS ( tokenSpec )+ ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:74:4: ^( TOKENS ( tokenSpec )+ )
            {
            match(input,TOKENS,FOLLOW_TOKENS_in_tokensSpec244); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:74:13: ( tokenSpec )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==TOKEN_REF||LA8_0==71) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:74:13: tokenSpec
            	    {
            	    pushFollow(FOLLOW_tokenSpec_in_tokensSpec246);
            	    tokenSpec();

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "tokensSpec"

    public static class tokenSpec_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "tokenSpec"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:77:1: tokenSpec : ( ^( '=' TOKEN_REF STRING_LITERAL ) | ^( '=' TOKEN_REF CHAR_LITERAL ) | TOKEN_REF );
    public final ANTLRv3TreeFilter.tokenSpec_return tokenSpec() throws RecognitionException {
        ANTLRv3TreeFilter.tokenSpec_return retval = new ANTLRv3TreeFilter.tokenSpec_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:78:2: ( ^( '=' TOKEN_REF STRING_LITERAL ) | ^( '=' TOKEN_REF CHAR_LITERAL ) | TOKEN_REF )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==71) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==DOWN) ) {
                    int LA9_3 = input.LA(3);

                    if ( (LA9_3==TOKEN_REF) ) {
                        int LA9_4 = input.LA(4);

                        if ( (LA9_4==STRING_LITERAL) ) {
                            alt9=1;
                        }
                        else if ( (LA9_4==CHAR_LITERAL) ) {
                            alt9=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA9_0==TOKEN_REF) ) {
                alt9=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:78:4: ^( '=' TOKEN_REF STRING_LITERAL )
                    {
                    match(input,71,FOLLOW_71_in_tokenSpec260); 

                    match(input, Token.DOWN, null); 
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec262); 
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_tokenSpec264); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:79:4: ^( '=' TOKEN_REF CHAR_LITERAL )
                    {
                    match(input,71,FOLLOW_71_in_tokenSpec271); 

                    match(input, Token.DOWN, null); 
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec273); 
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_tokenSpec275); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:80:4: TOKEN_REF
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec281); 

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
        return retval;
    }
    // $ANTLR end "tokenSpec"

    public static class attrScope_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "attrScope"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:83:1: attrScope : ^( 'scope' ID ACTION ) ;
    public final ANTLRv3TreeFilter.attrScope_return attrScope() throws RecognitionException {
        ANTLRv3TreeFilter.attrScope_return retval = new ANTLRv3TreeFilter.attrScope_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:84:2: ( ^( 'scope' ID ACTION ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:84:4: ^( 'scope' ID ACTION )
            {
            match(input,SCOPE,FOLLOW_SCOPE_in_attrScope293); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_attrScope295); 
            match(input,ACTION,FOLLOW_ACTION_in_attrScope297); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrScope"

    public static class action_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "action"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:87:1: action : ( ^( '@' ID ID ACTION ) | ^( '@' ID ACTION ) );
    public final ANTLRv3TreeFilter.action_return action() throws RecognitionException {
        ANTLRv3TreeFilter.action_return retval = new ANTLRv3TreeFilter.action_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:88:2: ( ^( '@' ID ID ACTION ) | ^( '@' ID ACTION ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==72) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==DOWN) ) {
                    int LA10_2 = input.LA(3);

                    if ( (LA10_2==ID) ) {
                        int LA10_3 = input.LA(4);

                        if ( (LA10_3==ID) ) {
                            alt10=1;
                        }
                        else if ( (LA10_3==ACTION) ) {
                            alt10=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 10, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:88:4: ^( '@' ID ID ACTION )
                    {
                    match(input,72,FOLLOW_72_in_action310); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_action312); 
                    match(input,ID,FOLLOW_ID_in_action314); 
                    match(input,ACTION,FOLLOW_ACTION_in_action316); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:89:4: ^( '@' ID ACTION )
                    {
                    match(input,72,FOLLOW_72_in_action323); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_action325); 
                    match(input,ACTION,FOLLOW_ACTION_in_action327); 

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
        return retval;
    }
    // $ANTLR end "action"

    public static class optionsSpec_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "optionsSpec"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:92:1: optionsSpec : ^( OPTIONS ( option )+ ) ;
    public final ANTLRv3TreeFilter.optionsSpec_return optionsSpec() throws RecognitionException {
        ANTLRv3TreeFilter.optionsSpec_return retval = new ANTLRv3TreeFilter.optionsSpec_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:93:2: ( ^( OPTIONS ( option )+ ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:93:4: ^( OPTIONS ( option )+ )
            {
            match(input,OPTIONS,FOLLOW_OPTIONS_in_optionsSpec340); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:93:14: ( option )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==71) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:93:14: option
            	    {
            	    pushFollow(FOLLOW_option_in_optionsSpec342);
            	    option();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
        return retval;
    }
    // $ANTLR end "optionsSpec"

    public static class option_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "option"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:96:1: option : ^( '=' ID optionValue ) ;
    public final ANTLRv3TreeFilter.option_return option() throws RecognitionException {
        ANTLRv3TreeFilter.option_return retval = new ANTLRv3TreeFilter.option_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:97:5: ( ^( '=' ID optionValue ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:97:9: ^( '=' ID optionValue )
            {
            match(input,71,FOLLOW_71_in_option361); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_option363); 
            pushFollow(FOLLOW_optionValue_in_option365);
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
        return retval;
    }
    // $ANTLR end "option"

    public static class optionValue_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "optionValue"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:100:1: optionValue : ( ID | STRING_LITERAL | CHAR_LITERAL | INT );
    public final ANTLRv3TreeFilter.optionValue_return optionValue() throws RecognitionException {
        ANTLRv3TreeFilter.optionValue_return retval = new ANTLRv3TreeFilter.optionValue_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:101:5: ( ID | STRING_LITERAL | CHAR_LITERAL | INT )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:
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
        return retval;
    }
    // $ANTLR end "optionValue"

    public static class rule_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rule"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:107:1: rule : ^( RULE ID ( modifier )? ( ^( ARG ARG_ACTION ) )? ( ^( RET ARG_ACTION ) )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* al= altList ( exceptionGroup )? EOR ) -> rule(id=$IDbody=al);
    public final ANTLRv3TreeFilter.rule_return rule() throws RecognitionException {
        ANTLRv3TreeFilter.rule_return retval = new ANTLRv3TreeFilter.rule_return();
        retval.start = input.LT(1);

        CommonTree ID2=null;
        ANTLRv3TreeFilter.altList_return al = null;


        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:108:2: ( ^( RULE ID ( modifier )? ( ^( ARG ARG_ACTION ) )? ( ^( RET ARG_ACTION ) )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* al= altList ( exceptionGroup )? EOR ) -> rule(id=$IDbody=al))
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:108:4: ^( RULE ID ( modifier )? ( ^( ARG ARG_ACTION ) )? ( ^( RET ARG_ACTION ) )? ( optionsSpec )? ( ruleScopeSpec )? ( ruleAction )* al= altList ( exceptionGroup )? EOR )
            {
            match(input,RULE,FOLLOW_RULE_in_rule431); 

            match(input, Token.DOWN, null); 
            ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_rule433); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:110:7: ( modifier )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==FRAGMENT||(LA12_0>=75 && LA12_0<=77)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:110:7: modifier
                    {
                    pushFollow(FOLLOW_modifier_in_rule450);
                    modifier();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:110:17: ( ^( ARG ARG_ACTION ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ARG) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:110:18: ^( ARG ARG_ACTION )
                    {
                    match(input,ARG,FOLLOW_ARG_in_rule455); 

                    match(input, Token.DOWN, null); 
                    match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule457); 

                    match(input, Token.UP, null); 

                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:110:38: ( ^( RET ARG_ACTION ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RET) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:110:39: ^( RET ARG_ACTION )
                    {
                    match(input,RET,FOLLOW_RET_in_rule464); 

                    match(input, Token.DOWN, null); 
                    match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule466); 

                    match(input, Token.UP, null); 

                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:111:7: ( optionsSpec )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==OPTIONS) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:111:7: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_rule477);
                    optionsSpec();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:111:20: ( ruleScopeSpec )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==SCOPE) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:111:20: ruleScopeSpec
                    {
                    pushFollow(FOLLOW_ruleScopeSpec_in_rule480);
                    ruleScopeSpec();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:111:35: ( ruleAction )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==72) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:111:35: ruleAction
            	    {
            	    pushFollow(FOLLOW_ruleAction_in_rule483);
            	    ruleAction();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            pushFollow(FOLLOW_altList_in_rule501);
            al=altList();

            state._fsp--;

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:115:8: ( exceptionGroup )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=85 && LA18_0<=86)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:115:8: exceptionGroup
                    {
                    pushFollow(FOLLOW_exceptionGroup_in_rule518);
                    exceptionGroup();

                    state._fsp--;


                    }
                    break;

            }

            match(input,EOR,FOLLOW_EOR_in_rule528); 

            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 119:4: -> rule(id=$IDbody=al)
            {
                retval.st = templateLib.getInstanceOf("rule",
              new STAttrMap().put("id", ID2).put("body", al));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rule"

    public static class modifier_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "modifier"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:125:1: modifier : ( 'protected' | 'public' | 'private' | 'fragment' );
    public final ANTLRv3TreeFilter.modifier_return modifier() throws RecognitionException {
        ANTLRv3TreeFilter.modifier_return retval = new ANTLRv3TreeFilter.modifier_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:126:2: ( 'protected' | 'public' | 'private' | 'fragment' )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:
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
        return retval;
    }
    // $ANTLR end "modifier"

    public static class ruleAction_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "ruleAction"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:129:1: ruleAction : ^( '@' ID ACTION ) ;
    public final ANTLRv3TreeFilter.ruleAction_return ruleAction() throws RecognitionException {
        ANTLRv3TreeFilter.ruleAction_return retval = new ANTLRv3TreeFilter.ruleAction_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:131:2: ( ^( '@' ID ACTION ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:131:4: ^( '@' ID ACTION )
            {
            match(input,72,FOLLOW_72_in_ruleAction610); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_ruleAction612); 
            match(input,ACTION,FOLLOW_ACTION_in_ruleAction614); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ruleAction"

    public static class throwsSpec_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "throwsSpec"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:134:1: throwsSpec : ^( 'throws' ( ID )+ ) ;
    public final ANTLRv3TreeFilter.throwsSpec_return throwsSpec() throws RecognitionException {
        ANTLRv3TreeFilter.throwsSpec_return retval = new ANTLRv3TreeFilter.throwsSpec_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:135:2: ( ^( 'throws' ( ID )+ ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:135:4: ^( 'throws' ( ID )+ )
            {
            match(input,80,FOLLOW_80_in_throwsSpec627); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:135:15: ( ID )+
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
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:135:15: ID
            	    {
            	    match(input,ID,FOLLOW_ID_in_throwsSpec629); 

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "throwsSpec"

    public static class ruleScopeSpec_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "ruleScopeSpec"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:138:1: ruleScopeSpec : ( ^( 'scope' ACTION ) | ^( 'scope' ACTION ( ID )+ ) | ^( 'scope' ( ID )+ ) );
    public final ANTLRv3TreeFilter.ruleScopeSpec_return ruleScopeSpec() throws RecognitionException {
        ANTLRv3TreeFilter.ruleScopeSpec_return retval = new ANTLRv3TreeFilter.ruleScopeSpec_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:139:2: ( ^( 'scope' ACTION ) | ^( 'scope' ACTION ( ID )+ ) | ^( 'scope' ( ID )+ ) )
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==SCOPE) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==DOWN) ) {
                    int LA22_2 = input.LA(3);

                    if ( (LA22_2==ACTION) ) {
                        int LA22_3 = input.LA(4);

                        if ( (LA22_3==UP) ) {
                            alt22=1;
                        }
                        else if ( (LA22_3==ID) ) {
                            alt22=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 22, 3, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA22_2==ID) ) {
                        alt22=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:139:4: ^( 'scope' ACTION )
                    {
                    match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec643); 

                    match(input, Token.DOWN, null); 
                    match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec645); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:140:4: ^( 'scope' ACTION ( ID )+ )
                    {
                    match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec652); 

                    match(input, Token.DOWN, null); 
                    match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec654); 
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:140:21: ( ID )+
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
                    	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:140:21: ID
                    	    {
                    	    match(input,ID,FOLLOW_ID_in_ruleScopeSpec656); 

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
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:141:4: ^( 'scope' ( ID )+ )
                    {
                    match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec664); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:141:14: ( ID )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==ID) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:141:14: ID
                    	    {
                    	    match(input,ID,FOLLOW_ID_in_ruleScopeSpec666); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
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
        return retval;
    }
    // $ANTLR end "ruleScopeSpec"

    public static class block_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "block"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:144:1: block : ^( BLOCK ( optionsSpec )? (a= alternative rewrite )+ EOB ) -> {alts.size() == 1}? {alts.get(0)} -> or(alternative=alts);
    public final ANTLRv3TreeFilter.block_return block() throws RecognitionException {
        ANTLRv3TreeFilter.block_return retval = new ANTLRv3TreeFilter.block_return();
        retval.start = input.LT(1);

        ANTLRv3TreeFilter.alternative_return a = null;


        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:145:3: ( ^( BLOCK ( optionsSpec )? (a= alternative rewrite )+ EOB ) -> {alts.size() == 1}? {alts.get(0)} -> or(alternative=alts))
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:145:5: ^( BLOCK ( optionsSpec )? (a= alternative rewrite )+ EOB )
            {
             List<StringTemplate> alts = new LinkedList<StringTemplate>(); 
            match(input,BLOCK,FOLLOW_BLOCK_in_block691); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:147:14: ( optionsSpec )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==OPTIONS) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:147:14: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_block693);
                    optionsSpec();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:148:8: (a= alternative rewrite )+
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
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:148:10: a= alternative rewrite
            	    {
            	    pushFollow(FOLLOW_alternative_in_block707);
            	    a=alternative();

            	    state._fsp--;

            	    pushFollow(FOLLOW_rewrite_in_block709);
            	    rewrite();

            	    state._fsp--;

            	     if (!(a!=null?a.st:null).toString().equals("epsilon")) {
            	                 alts.add((a!=null?a.st:null));
            	               }
            	             

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

            match(input,EOB,FOLLOW_EOB_in_block739); 

            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 157:5: -> {alts.size() == 1}? {alts.get(0)}
            if (alts.size() == 1) {
                retval.st = alts.get(0);
            }
            else // 158:5: -> or(alternative=alts)
            {
                retval.st = templateLib.getInstanceOf("or",
              new STAttrMap().put("alternative", alts));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class altList_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "altList"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:163:1: altList : ^( BLOCK (a= alternative rewrite )+ EOB ) -> {alts.size() == 1}? {alts.get(0)} -> or(alternative=alts);
    public final ANTLRv3TreeFilter.altList_return altList() throws RecognitionException {
        ANTLRv3TreeFilter.altList_return retval = new ANTLRv3TreeFilter.altList_return();
        retval.start = input.LT(1);

        ANTLRv3TreeFilter.alternative_return a = null;


        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:164:3: ( ^( BLOCK (a= alternative rewrite )+ EOB ) -> {alts.size() == 1}? {alts.get(0)} -> or(alternative=alts))
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:164:5: ^( BLOCK (a= alternative rewrite )+ EOB )
            {
             List<StringTemplate> alts = new LinkedList<StringTemplate>(); 
            match(input,BLOCK,FOLLOW_BLOCK_in_altList812); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:167:8: (a= alternative rewrite )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==ALT) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:167:10: a= alternative rewrite
            	    {
            	    pushFollow(FOLLOW_alternative_in_altList825);
            	    a=alternative();

            	    state._fsp--;

            	    pushFollow(FOLLOW_rewrite_in_altList827);
            	    rewrite();

            	    state._fsp--;

            	     if (!(a!=null?a.st:null).toString().equals("epsilon")) {
            	                 alts.add((a!=null?a.st:null));
            	               }
            	             

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

            match(input,EOB,FOLLOW_EOB_in_altList857); 

            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 176:5: -> {alts.size() == 1}? {alts.get(0)}
            if (alts.size() == 1) {
                retval.st = alts.get(0);
            }
            else // 177:5: -> or(alternative=alts)
            {
                retval.st = templateLib.getInstanceOf("or",
              new STAttrMap().put("alternative", alts));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "altList"

    public static class alternative_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "alternative"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:182:1: alternative : ( ^( ALT (e= element )+ EOA ) -> {elts.size() == 1}? {elts.get(0)} -> seq(element=elts) | ^( ALT EPSILON EOA ) -> {%{\"[>EPSILON<]\"}});
    public final ANTLRv3TreeFilter.alternative_return alternative() throws RecognitionException {
        ANTLRv3TreeFilter.alternative_return retval = new ANTLRv3TreeFilter.alternative_return();
        retval.start = input.LT(1);

        ANTLRv3TreeFilter.element_return e = null;


        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:183:3: ( ^( ALT (e= element )+ EOA ) -> {elts.size() == 1}? {elts.get(0)} -> seq(element=elts) | ^( ALT EPSILON EOA ) -> {%{\"[>EPSILON<]\"}})
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==ALT) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==DOWN) ) {
                    int LA27_2 = input.LA(3);

                    if ( (LA27_2==EPSILON) ) {
                        alt27=2;
                    }
                    else if ( ((LA27_2>=BLOCK && LA27_2<=SYNPRED)||LA27_2==CHAR_RANGE||(LA27_2>=SEMPRED && LA27_2<=SYN_SEMPRED)||(LA27_2>=TREE_BEGIN && LA27_2<=BANG)||(LA27_2>=TOKEN_REF && LA27_2<=ACTION)||LA27_2==RULE_REF||LA27_2==71||LA27_2==87||LA27_2==89||LA27_2==92) ) {
                        alt27=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:183:5: ^( ALT (e= element )+ EOA )
                    {
                     List<StringTemplate> elts = new LinkedList<StringTemplate>(); 
                    match(input,ALT,FOLLOW_ALT_in_alternative930); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:186:8: (e= element )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( ((LA26_0>=BLOCK && LA26_0<=SYNPRED)||LA26_0==CHAR_RANGE||(LA26_0>=SEMPRED && LA26_0<=SYN_SEMPRED)||(LA26_0>=TREE_BEGIN && LA26_0<=BANG)||(LA26_0>=TOKEN_REF && LA26_0<=ACTION)||LA26_0==RULE_REF||LA26_0==71||LA26_0==87||LA26_0==89||LA26_0==92) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:186:10: e= element
                    	    {
                    	    pushFollow(FOLLOW_element_in_alternative943);
                    	    e=element();

                    	    state._fsp--;

                    	     if (!(e!=null?e.st:null).toString().equals("epsilon")) {
                    	                 elts.add((e!=null?e.st:null));
                    	               }
                    	             

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);

                    match(input,EOA,FOLLOW_EOA_in_alternative973); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 195:5: -> {elts.size() == 1}? {elts.get(0)}
                    if (elts.size() == 1) {
                        retval.st = elts.get(0);
                    }
                    else // 196:5: -> seq(element=elts)
                    {
                        retval.st = templateLib.getInstanceOf("seq",
                      new STAttrMap().put("element", elts));
                    }


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:200:5: ^( ALT EPSILON EOA )
                    {
                    match(input,ALT,FOLLOW_ALT_in_alternative1027); 

                    match(input, Token.DOWN, null); 
                    match(input,EPSILON,FOLLOW_EPSILON_in_alternative1029); 
                    match(input,EOA,FOLLOW_EOA_in_alternative1038); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 204:6: -> {%{\"[>EPSILON<]\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"[>EPSILON<]");
                    }


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
        return retval;
    }
    // $ANTLR end "alternative"

    public static class exceptionGroup_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "exceptionGroup"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:207:1: exceptionGroup : ( ( exceptionHandler )+ ( finallyClause )? | finallyClause );
    public final ANTLRv3TreeFilter.exceptionGroup_return exceptionGroup() throws RecognitionException {
        ANTLRv3TreeFilter.exceptionGroup_return retval = new ANTLRv3TreeFilter.exceptionGroup_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:208:2: ( ( exceptionHandler )+ ( finallyClause )? | finallyClause )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==85) ) {
                alt30=1;
            }
            else if ( (LA30_0==86) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:208:4: ( exceptionHandler )+ ( finallyClause )?
                    {
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:208:4: ( exceptionHandler )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==85) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:208:4: exceptionHandler
                    	    {
                    	    pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup1072);
                    	    exceptionHandler();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt28 >= 1 ) break loop28;
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);

                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:208:22: ( finallyClause )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==86) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:208:22: finallyClause
                            {
                            pushFollow(FOLLOW_finallyClause_in_exceptionGroup1075);
                            finallyClause();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:209:4: finallyClause
                    {
                    pushFollow(FOLLOW_finallyClause_in_exceptionGroup1081);
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
        return retval;
    }
    // $ANTLR end "exceptionGroup"

    public static class exceptionHandler_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "exceptionHandler"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:212:1: exceptionHandler : ^( 'catch' ARG_ACTION ACTION ) ;
    public final ANTLRv3TreeFilter.exceptionHandler_return exceptionHandler() throws RecognitionException {
        ANTLRv3TreeFilter.exceptionHandler_return retval = new ANTLRv3TreeFilter.exceptionHandler_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:213:5: ( ^( 'catch' ARG_ACTION ACTION ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:213:10: ^( 'catch' ARG_ACTION ACTION )
            {
            match(input,85,FOLLOW_85_in_exceptionHandler1102); 

            match(input, Token.DOWN, null); 
            match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler1104); 
            match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler1106); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exceptionHandler"

    public static class finallyClause_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "finallyClause"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:216:1: finallyClause : ^( 'finally' ACTION ) ;
    public final ANTLRv3TreeFilter.finallyClause_return finallyClause() throws RecognitionException {
        ANTLRv3TreeFilter.finallyClause_return retval = new ANTLRv3TreeFilter.finallyClause_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:217:5: ( ^( 'finally' ACTION ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:217:10: ^( 'finally' ACTION )
            {
            match(input,86,FOLLOW_86_in_finallyClause1128); 

            match(input, Token.DOWN, null); 
            match(input,ACTION,FOLLOW_ACTION_in_finallyClause1130); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "finallyClause"

    public static class element_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "element"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:220:1: element : elementNoOptionSpec -> {$elementNoOptionSpec.st};
    public final ANTLRv3TreeFilter.element_return element() throws RecognitionException {
        ANTLRv3TreeFilter.element_return retval = new ANTLRv3TreeFilter.element_return();
        retval.start = input.LT(1);

        ANTLRv3TreeFilter.elementNoOptionSpec_return elementNoOptionSpec3 = null;


        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:221:2: ( elementNoOptionSpec -> {$elementNoOptionSpec.st})
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:221:4: elementNoOptionSpec
            {
            pushFollow(FOLLOW_elementNoOptionSpec_in_element1145);
            elementNoOptionSpec3=elementNoOptionSpec();

            state._fsp--;



            // TEMPLATE REWRITE
            // 223:5: -> {$elementNoOptionSpec.st}
            {
                retval.st = (elementNoOptionSpec3!=null?elementNoOptionSpec3.st:null);
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "element"

    public static class elementNoOptionSpec_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "elementNoOptionSpec"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:226:1: elementNoOptionSpec : ( ^( ( '=' | '+=' ) ID block ) -> {$block.st} | ^( ( '=' | '+=' ) ID atom ) -> {$atom.st} | atom -> {$atom.st} | ebnf -> {$ebnf.st} | ACTION -> {%{\"epsilon\"}} | SEMPRED -> {%{\"[>SEMPRED<]\"}} | GATED_SEMPRED -> {%{\"[>GATED_SEMPRED<]\"}} | treeSpec -> {$treeSpec.st});
    public final ANTLRv3TreeFilter.elementNoOptionSpec_return elementNoOptionSpec() throws RecognitionException {
        ANTLRv3TreeFilter.elementNoOptionSpec_return retval = new ANTLRv3TreeFilter.elementNoOptionSpec_return();
        retval.start = input.LT(1);

        ANTLRv3TreeFilter.block_return block4 = null;

        ANTLRv3TreeFilter.atom_return atom5 = null;

        ANTLRv3TreeFilter.atom_return atom6 = null;

        ANTLRv3TreeFilter.ebnf_return ebnf7 = null;

        ANTLRv3TreeFilter.treeSpec_return treeSpec8 = null;


        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:227:2: ( ^( ( '=' | '+=' ) ID block ) -> {$block.st} | ^( ( '=' | '+=' ) ID atom ) -> {$atom.st} | atom -> {$atom.st} | ebnf -> {$ebnf.st} | ACTION -> {%{\"epsilon\"}} | SEMPRED -> {%{\"[>SEMPRED<]\"}} | GATED_SEMPRED -> {%{\"[>GATED_SEMPRED<]\"}} | treeSpec -> {$treeSpec.st})
            int alt33=8;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:227:4: ^( ( '=' | '+=' ) ID block )
                    {
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:227:6: ( '=' | '+=' )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==71) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==87) ) {
                        alt31=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:227:7: '='
                            {
                            match(input,71,FOLLOW_71_in_elementNoOptionSpec1171); 

                            }
                            break;
                        case 2 :
                            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:227:11: '+='
                            {
                            match(input,87,FOLLOW_87_in_elementNoOptionSpec1173); 

                            }
                            break;

                    }


                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_elementNoOptionSpec1176); 
                    pushFollow(FOLLOW_block_in_elementNoOptionSpec1178);
                    block4=block();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 229:5: -> {$block.st}
                    {
                        retval.st = (block4!=null?block4.st:null);
                    }


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:231:4: ^( ( '=' | '+=' ) ID atom )
                    {
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:231:6: ( '=' | '+=' )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==71) ) {
                        alt32=1;
                    }
                    else if ( (LA32_0==87) ) {
                        alt32=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 0, input);

                        throw nvae;
                    }
                    switch (alt32) {
                        case 1 :
                            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:231:7: '='
                            {
                            match(input,71,FOLLOW_71_in_elementNoOptionSpec1196); 

                            }
                            break;
                        case 2 :
                            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:231:11: '+='
                            {
                            match(input,87,FOLLOW_87_in_elementNoOptionSpec1198); 

                            }
                            break;

                    }


                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_elementNoOptionSpec1201); 
                    pushFollow(FOLLOW_atom_in_elementNoOptionSpec1203);
                    atom5=atom();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 233:5: -> {$atom.st}
                    {
                        retval.st = (atom5!=null?atom5.st:null);
                    }


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:235:4: atom
                    {
                    pushFollow(FOLLOW_atom_in_elementNoOptionSpec1219);
                    atom6=atom();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 237:5: -> {$atom.st}
                    {
                        retval.st = (atom6!=null?atom6.st:null);
                    }


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:239:4: ebnf
                    {
                    pushFollow(FOLLOW_ebnf_in_elementNoOptionSpec1234);
                    ebnf7=ebnf();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 241:5: -> {$ebnf.st}
                    {
                        retval.st = (ebnf7!=null?ebnf7.st:null);
                    }


                    }
                    break;
                case 5 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:243:6: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_elementNoOptionSpec1251); 


                    // TEMPLATE REWRITE
                    // 245:5: -> {%{\"epsilon\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"epsilon");
                    }


                    }
                    break;
                case 6 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:247:6: SEMPRED
                    {
                    match(input,SEMPRED,FOLLOW_SEMPRED_in_elementNoOptionSpec1268); 


                    // TEMPLATE REWRITE
                    // 249:5: -> {%{\"[>SEMPRED<]\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"[>SEMPRED<]");
                    }


                    }
                    break;
                case 7 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:251:4: GATED_SEMPRED
                    {
                    match(input,GATED_SEMPRED,FOLLOW_GATED_SEMPRED_in_elementNoOptionSpec1283); 


                    // TEMPLATE REWRITE
                    // 253:5: -> {%{\"[>GATED_SEMPRED<]\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"[>GATED_SEMPRED<]");
                    }


                    }
                    break;
                case 8 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:255:6: treeSpec
                    {
                    pushFollow(FOLLOW_treeSpec_in_elementNoOptionSpec1300);
                    treeSpec8=treeSpec();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 257:5: -> {$treeSpec.st}
                    {
                        retval.st = (treeSpec8!=null?treeSpec8.st:null);
                    }


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
        return retval;
    }
    // $ANTLR end "elementNoOptionSpec"

    public static class atom_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "atom"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:260:1: atom : ( ^( ( '^' | '!' ) atom ) -> {%{\"[>^!atom<]\"}} | range -> {%{\"[>range<]\"}} | notSet -> {%{\"[>notset<]\"}} | ^( RULE_REF ARG_ACTION ) -> ref(id=$RULE_REF) | RULE_REF -> ref(id=$RULE_REF) | terminal -> {$terminal.st});
    public final ANTLRv3TreeFilter.atom_return atom() throws RecognitionException {
        ANTLRv3TreeFilter.atom_return retval = new ANTLRv3TreeFilter.atom_return();
        retval.start = input.LT(1);

        CommonTree RULE_REF9=null;
        CommonTree RULE_REF10=null;
        ANTLRv3TreeFilter.terminal_return terminal11 = null;


        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:261:3: ( ^( ( '^' | '!' ) atom ) -> {%{\"[>^!atom<]\"}} | range -> {%{\"[>range<]\"}} | notSet -> {%{\"[>notset<]\"}} | ^( RULE_REF ARG_ACTION ) -> ref(id=$RULE_REF) | RULE_REF -> ref(id=$RULE_REF) | terminal -> {$terminal.st})
            int alt35=6;
            switch ( input.LA(1) ) {
            case ROOT:
            case BANG:
                {
                alt35=1;
                }
                break;
            case CHAR_RANGE:
                {
                alt35=2;
                }
                break;
            case 89:
                {
                alt35=3;
                }
                break;
            case RULE_REF:
                {
                int LA35_4 = input.LA(2);

                if ( (LA35_4==DOWN) ) {
                    alt35=4;
                }
                else if ( (LA35_4==UP||(LA35_4>=BLOCK && LA35_4<=SYNPRED)||LA35_4==CHAR_RANGE||LA35_4==EOA||(LA35_4>=SEMPRED && LA35_4<=SYN_SEMPRED)||(LA35_4>=TREE_BEGIN && LA35_4<=BANG)||(LA35_4>=TOKEN_REF && LA35_4<=ACTION)||LA35_4==RULE_REF||LA35_4==71||LA35_4==87||LA35_4==89||LA35_4==92) ) {
                    alt35=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 4, input);

                    throw nvae;
                }
                }
                break;
            case TOKEN_REF:
            case STRING_LITERAL:
            case CHAR_LITERAL:
            case 92:
                {
                alt35=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:261:5: ^( ( '^' | '!' ) atom )
                    {
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:261:7: ( '^' | '!' )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==ROOT) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==BANG) ) {
                        alt34=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 0, input);

                        throw nvae;
                    }
                    switch (alt34) {
                        case 1 :
                            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:261:8: '^'
                            {
                            match(input,ROOT,FOLLOW_ROOT_in_atom1323); 

                            }
                            break;
                        case 2 :
                            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:261:12: '!'
                            {
                            match(input,BANG,FOLLOW_BANG_in_atom1325); 

                            }
                            break;

                    }


                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_atom_in_atom1328);
                    atom();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 263:5: -> {%{\"[>^!atom<]\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"[>^!atom<]");
                    }


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:265:4: range
                    {
                    pushFollow(FOLLOW_range_in_atom1344);
                    range();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 267:5: -> {%{\"[>range<]\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"[>range<]");
                    }


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:269:4: notSet
                    {
                    pushFollow(FOLLOW_notSet_in_atom1359);
                    notSet();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 271:5: -> {%{\"[>notset<]\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"[>notset<]");
                    }


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:273:5: ^( RULE_REF ARG_ACTION )
                    {
                    RULE_REF9=(CommonTree)match(input,RULE_REF,FOLLOW_RULE_REF_in_atom1376); 

                    match(input, Token.DOWN, null); 
                    match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1378); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 275:5: -> ref(id=$RULE_REF)
                    {
                        retval.st = templateLib.getInstanceOf("ref",
                      new STAttrMap().put("id", RULE_REF9));
                    }


                    }
                    break;
                case 5 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:279:5: RULE_REF
                    {
                    RULE_REF10=(CommonTree)match(input,RULE_REF,FOLLOW_RULE_REF_in_atom1415); 


                    // TEMPLATE REWRITE
                    // 281:5: -> ref(id=$RULE_REF)
                    {
                        retval.st = templateLib.getInstanceOf("ref",
                      new STAttrMap().put("id", RULE_REF10));
                    }


                    }
                    break;
                case 6 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:285:5: terminal
                    {
                    pushFollow(FOLLOW_terminal_in_atom1451);
                    terminal11=terminal();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 287:5: -> {$terminal.st}
                    {
                        retval.st = (terminal11!=null?terminal11.st:null);
                    }


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
        return retval;
    }
    // $ANTLR end "atom"

    public static class notSet_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "notSet"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:290:1: notSet : ( ^( '~' notTerminal ) | ^( '~' block ) );
    public final ANTLRv3TreeFilter.notSet_return notSet() throws RecognitionException {
        ANTLRv3TreeFilter.notSet_return retval = new ANTLRv3TreeFilter.notSet_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:291:2: ( ^( '~' notTerminal ) | ^( '~' block ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==89) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==DOWN) ) {
                    int LA36_2 = input.LA(3);

                    if ( ((LA36_2>=TOKEN_REF && LA36_2<=CHAR_LITERAL)) ) {
                        alt36=1;
                    }
                    else if ( (LA36_2==BLOCK) ) {
                        alt36=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:291:4: ^( '~' notTerminal )
                    {
                    match(input,89,FOLLOW_89_in_notSet1473); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_notTerminal_in_notSet1475);
                    notTerminal();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:292:4: ^( '~' block )
                    {
                    match(input,89,FOLLOW_89_in_notSet1482); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_notSet1484);
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
        return retval;
    }
    // $ANTLR end "notSet"

    public static class treeSpec_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "treeSpec"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:295:1: treeSpec : ^( TREE_BEGIN TOKEN_REF (e= element )* ) -> {elts.size() == 1}? subtree(element=elts.get(0)scop=scopeid=$TOKEN_REF) -> subtree(element=eltsscop=scopeid=$TOKEN_REF);
    public final ANTLRv3TreeFilter.treeSpec_return treeSpec() throws RecognitionException {
        ANTLRv3TreeFilter.treeSpec_return retval = new ANTLRv3TreeFilter.treeSpec_return();
        retval.start = input.LT(1);

        CommonTree TOKEN_REF12=null;
        ANTLRv3TreeFilter.element_return e = null;


        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:296:2: ( ^( TREE_BEGIN TOKEN_REF (e= element )* ) -> {elts.size() == 1}? subtree(element=elts.get(0)scop=scopeid=$TOKEN_REF) -> subtree(element=eltsscop=scopeid=$TOKEN_REF))
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:296:4: ^( TREE_BEGIN TOKEN_REF (e= element )* )
            {
             List<StringTemplate> elts = new LinkedList<StringTemplate>(); 
            match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_treeSpec1507); 

            match(input, Token.DOWN, null); 
            TOKEN_REF12=(CommonTree)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_treeSpec1534); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:304:8: (e= element )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=BLOCK && LA37_0<=SYNPRED)||LA37_0==CHAR_RANGE||(LA37_0>=SEMPRED && LA37_0<=SYN_SEMPRED)||(LA37_0>=TREE_BEGIN && LA37_0<=BANG)||(LA37_0>=TOKEN_REF && LA37_0<=ACTION)||LA37_0==RULE_REF||LA37_0==71||LA37_0==87||LA37_0==89||LA37_0==92) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:304:10: e= element
            	    {
            	    pushFollow(FOLLOW_element_in_treeSpec1555);
            	    e=element();

            	    state._fsp--;

            	     if (!(e!=null?e.st:null).toString().equals("epsilon")) {
            	                 elts.add((e!=null?e.st:null));
            	               }
            	             

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 312:5: -> {elts.size() == 1}? subtree(element=elts.get(0)scop=scopeid=$TOKEN_REF)
            if (elts.size() == 1) {
                retval.st = templateLib.getInstanceOf("subtree",
              new STAttrMap().put("element", elts.get(0)).put("scop", scope).put("id", TOKEN_REF12));
            }
            else // 318:5: -> subtree(element=eltsscop=scopeid=$TOKEN_REF)
            {
                retval.st = templateLib.getInstanceOf("subtree",
              new STAttrMap().put("element", elts).put("scop", scope).put("id", TOKEN_REF12));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "treeSpec"

    public static class ebnf_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "ebnf"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:325:1: ebnf : ( ^( SYNPRED block ) -> {%{\"[>SYNPRED<]\"}} | SYN_SEMPRED -> {%{\"[>SYN_SEMPRED<]\"}} | ^( OPTIONAL block ) -> opt(block=$block.st) | ^( CLOSURE block ) -> star(block=$block.st) | ^( POSITIVE_CLOSURE block ) -> {%{\"[>POSITIVE_CLOSURE block<]\"}} | block -> {$block.st});
    public final ANTLRv3TreeFilter.ebnf_return ebnf() throws RecognitionException {
        ANTLRv3TreeFilter.ebnf_return retval = new ANTLRv3TreeFilter.ebnf_return();
        retval.start = input.LT(1);

        ANTLRv3TreeFilter.block_return block13 = null;

        ANTLRv3TreeFilter.block_return block14 = null;

        ANTLRv3TreeFilter.block_return block15 = null;


        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:327:2: ( ^( SYNPRED block ) -> {%{\"[>SYNPRED<]\"}} | SYN_SEMPRED -> {%{\"[>SYN_SEMPRED<]\"}} | ^( OPTIONAL block ) -> opt(block=$block.st) | ^( CLOSURE block ) -> star(block=$block.st) | ^( POSITIVE_CLOSURE block ) -> {%{\"[>POSITIVE_CLOSURE block<]\"}} | block -> {$block.st})
            int alt38=6;
            switch ( input.LA(1) ) {
            case SYNPRED:
                {
                alt38=1;
                }
                break;
            case SYN_SEMPRED:
                {
                alt38=2;
                }
                break;
            case OPTIONAL:
                {
                alt38=3;
                }
                break;
            case CLOSURE:
                {
                alt38=4;
                }
                break;
            case POSITIVE_CLOSURE:
                {
                alt38=5;
                }
                break;
            case BLOCK:
                {
                alt38=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:327:4: ^( SYNPRED block )
                    {
                    match(input,SYNPRED,FOLLOW_SYNPRED_in_ebnf1705); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_ebnf1707);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 329:5: -> {%{\"[>SYNPRED<]\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"[>SYNPRED<]");
                    }


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:331:4: SYN_SEMPRED
                    {
                    match(input,SYN_SEMPRED,FOLLOW_SYN_SEMPRED_in_ebnf1723); 


                    // TEMPLATE REWRITE
                    // 333:5: -> {%{\"[>SYN_SEMPRED<]\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"[>SYN_SEMPRED<]");
                    }


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:335:5: ^( OPTIONAL block )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_ebnf1740); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_ebnf1742);
                    block13=block();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 337:5: -> opt(block=$block.st)
                    {
                        retval.st = templateLib.getInstanceOf("opt",
                      new STAttrMap().put("block", (block13!=null?block13.st:null)));
                    }


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:341:5: ^( CLOSURE block )
                    {
                    match(input,CLOSURE,FOLLOW_CLOSURE_in_ebnf1779); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_ebnf1781);
                    block14=block();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 343:5: -> star(block=$block.st)
                    {
                        retval.st = templateLib.getInstanceOf("star",
                      new STAttrMap().put("block", (block14!=null?block14.st:null)));
                    }


                    }
                    break;
                case 5 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:347:5: ^( POSITIVE_CLOSURE block )
                    {
                    match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_ebnf1818); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_ebnf1820);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     if (true) throw new UnsupportedSyntaxException("Positive closures not supported (yet)."); 


                    // TEMPLATE REWRITE
                    // 351:5: -> {%{\"[>POSITIVE_CLOSURE block<]\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"[>POSITIVE_CLOSURE block<]");
                    }


                    }
                    break;
                case 6 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:353:4: block
                    {
                    pushFollow(FOLLOW_block_in_ebnf1843);
                    block15=block();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 355:5: -> {$block.st}
                    {
                        retval.st = (block15!=null?block15.st:null);
                    }


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
        return retval;
    }
    // $ANTLR end "ebnf"

    public static class range_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "range"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:359:1: range : ^( CHAR_RANGE CHAR_LITERAL CHAR_LITERAL ) ;
    public final ANTLRv3TreeFilter.range_return range() throws RecognitionException {
        ANTLRv3TreeFilter.range_return retval = new ANTLRv3TreeFilter.range_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:360:2: ( ^( CHAR_RANGE CHAR_LITERAL CHAR_LITERAL ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:360:4: ^( CHAR_RANGE CHAR_LITERAL CHAR_LITERAL )
            {
            match(input,CHAR_RANGE,FOLLOW_CHAR_RANGE_in_range1865); 

            match(input, Token.DOWN, null); 
            match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range1867); 
            match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_range1869); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "range"

    public static class terminal_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "terminal"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:363:1: terminal : ( CHAR_LITERAL -> literal(value=val) | TOKEN_REF -> token(id=$TOKEN_REFscop=scope) | STRING_LITERAL -> literal(value=val) | ^( TOKEN_REF ARG_ACTION ) -> {%{\"[>TOKEN_REF ARG_ACTION<]\"}} | '.' -> {%{\"[>.<]\"}});
    public final ANTLRv3TreeFilter.terminal_return terminal() throws RecognitionException {
        ANTLRv3TreeFilter.terminal_return retval = new ANTLRv3TreeFilter.terminal_return();
        retval.start = input.LT(1);

        CommonTree CHAR_LITERAL16=null;
        CommonTree TOKEN_REF17=null;
        CommonTree STRING_LITERAL18=null;

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:364:3: ( CHAR_LITERAL -> literal(value=val) | TOKEN_REF -> token(id=$TOKEN_REFscop=scope) | STRING_LITERAL -> literal(value=val) | ^( TOKEN_REF ARG_ACTION ) -> {%{\"[>TOKEN_REF ARG_ACTION<]\"}} | '.' -> {%{\"[>.<]\"}})
            int alt39=5;
            switch ( input.LA(1) ) {
            case CHAR_LITERAL:
                {
                alt39=1;
                }
                break;
            case TOKEN_REF:
                {
                int LA39_2 = input.LA(2);

                if ( (LA39_2==DOWN) ) {
                    alt39=4;
                }
                else if ( (LA39_2==UP||(LA39_2>=BLOCK && LA39_2<=SYNPRED)||LA39_2==CHAR_RANGE||LA39_2==EOA||(LA39_2>=SEMPRED && LA39_2<=SYN_SEMPRED)||(LA39_2>=TREE_BEGIN && LA39_2<=BANG)||(LA39_2>=TOKEN_REF && LA39_2<=ACTION)||LA39_2==RULE_REF||LA39_2==71||LA39_2==87||LA39_2==89||LA39_2==92) ) {
                    alt39=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 2, input);

                    throw nvae;
                }
                }
                break;
            case STRING_LITERAL:
                {
                alt39=3;
                }
                break;
            case 92:
                {
                alt39=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:364:5: CHAR_LITERAL
                    {
                    CHAR_LITERAL16=(CommonTree)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_terminal1882); 
                     String val = (CHAR_LITERAL16!=null?CHAR_LITERAL16.getText():null);
                          val = val.substring(1, val.length() - 1);
                        


                    // TEMPLATE REWRITE
                    // 370:5: -> literal(value=val)
                    {
                        retval.st = templateLib.getInstanceOf("literal",
                      new STAttrMap().put("value", val));
                    }


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:374:5: TOKEN_REF
                    {
                    TOKEN_REF17=(CommonTree)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal1925); 


                    // TEMPLATE REWRITE
                    // 376:5: -> token(id=$TOKEN_REFscop=scope)
                    {
                        retval.st = templateLib.getInstanceOf("token",
                      new STAttrMap().put("id", TOKEN_REF17).put("scop", scope));
                    }


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:381:5: STRING_LITERAL
                    {
                    STRING_LITERAL18=(CommonTree)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_terminal1975); 
                     String val = (STRING_LITERAL18!=null?STRING_LITERAL18.getText():null);
                          val = val.substring(1, val.length() - 1);
                        


                    // TEMPLATE REWRITE
                    // 387:5: -> literal(value=val)
                    {
                        retval.st = templateLib.getInstanceOf("literal",
                      new STAttrMap().put("value", val));
                    }


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:391:5: ^( TOKEN_REF ARG_ACTION )
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal2019); 

                    match(input, Token.DOWN, null); 
                    match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_terminal2021); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 393:5: -> {%{\"[>TOKEN_REF ARG_ACTION<]\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"[>TOKEN_REF ARG_ACTION<]");
                    }


                    }
                    break;
                case 5 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:395:5: '.'
                    {
                    match(input,92,FOLLOW_92_in_terminal2038); 


                    // TEMPLATE REWRITE
                    // 397:5: -> {%{\"[>.<]\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"[>.<]");
                    }


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
        return retval;
    }
    // $ANTLR end "terminal"

    public static class notTerminal_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "notTerminal"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:401:1: notTerminal : ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL );
    public final ANTLRv3TreeFilter.notTerminal_return notTerminal() throws RecognitionException {
        ANTLRv3TreeFilter.notTerminal_return retval = new ANTLRv3TreeFilter.notTerminal_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:402:2: ( CHAR_LITERAL | TOKEN_REF | STRING_LITERAL )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:
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
        return retval;
    }
    // $ANTLR end "notTerminal"

    public static class ebnfSuffix_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "ebnfSuffix"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:407:1: ebnfSuffix : ( OPTIONAL -> {%{\"[>OPTIONAL<]\"}} | CLOSURE -> {%{\"[>CLOSURE<]\"}} | POSITIVE_CLOSURE -> {%{\"[>POSITIVE_CLOSURE<]\"}});
    public final ANTLRv3TreeFilter.ebnfSuffix_return ebnfSuffix() throws RecognitionException {
        ANTLRv3TreeFilter.ebnfSuffix_return retval = new ANTLRv3TreeFilter.ebnfSuffix_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:408:2: ( OPTIONAL -> {%{\"[>OPTIONAL<]\"}} | CLOSURE -> {%{\"[>CLOSURE<]\"}} | POSITIVE_CLOSURE -> {%{\"[>POSITIVE_CLOSURE<]\"}})
            int alt40=3;
            switch ( input.LA(1) ) {
            case OPTIONAL:
                {
                alt40=1;
                }
                break;
            case CLOSURE:
                {
                alt40=2;
                }
                break;
            case POSITIVE_CLOSURE:
                {
                alt40=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:408:4: OPTIONAL
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_ebnfSuffix2081); 


                    // TEMPLATE REWRITE
                    // 410:5: -> {%{\"[>OPTIONAL<]\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"[>OPTIONAL<]");
                    }


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:412:5: CLOSURE
                    {
                    match(input,CLOSURE,FOLLOW_CLOSURE_in_ebnfSuffix2097); 


                    // TEMPLATE REWRITE
                    // 414:5: -> {%{\"[>CLOSURE<]\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"[>CLOSURE<]");
                    }


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:416:5: POSITIVE_CLOSURE
                    {
                    match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_ebnfSuffix2113); 


                    // TEMPLATE REWRITE
                    // 418:5: -> {%{\"[>POSITIVE_CLOSURE<]\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"[>POSITIVE_CLOSURE<]");
                    }


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
        return retval;
    }
    // $ANTLR end "ebnfSuffix"

    public static class rewrite_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rewrite"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:423:1: rewrite : ( ( ^( '->' SEMPRED rewrite_alternative ) )* ^( '->' rewrite_alternative ) | );
    public final ANTLRv3TreeFilter.rewrite_return rewrite() throws RecognitionException {
        ANTLRv3TreeFilter.rewrite_return retval = new ANTLRv3TreeFilter.rewrite_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:424:2: ( ( ^( '->' SEMPRED rewrite_alternative ) )* ^( '->' rewrite_alternative ) | )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==REWRITE) ) {
                alt42=1;
            }
            else if ( (LA42_0==ALT||LA42_0==EOB) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:424:4: ( ^( '->' SEMPRED rewrite_alternative ) )* ^( '->' rewrite_alternative )
                    {
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:424:4: ( ^( '->' SEMPRED rewrite_alternative ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==REWRITE) ) {
                            int LA41_1 = input.LA(2);

                            if ( (LA41_1==DOWN) ) {
                                int LA41_2 = input.LA(3);

                                if ( (LA41_2==SEMPRED) ) {
                                    alt41=1;
                                }


                            }


                        }


                        switch (alt41) {
                    	case 1 :
                    	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:424:5: ^( '->' SEMPRED rewrite_alternative )
                    	    {
                    	    match(input,REWRITE,FOLLOW_REWRITE_in_rewrite2138); 

                    	    match(input, Token.DOWN, null); 
                    	    match(input,SEMPRED,FOLLOW_SEMPRED_in_rewrite2140); 
                    	    pushFollow(FOLLOW_rewrite_alternative_in_rewrite2142);
                    	    rewrite_alternative();

                    	    state._fsp--;


                    	    match(input, Token.UP, null); 

                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);

                    match(input,REWRITE,FOLLOW_REWRITE_in_rewrite2148); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_rewrite_alternative_in_rewrite2150);
                    rewrite_alternative();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:426:2: 
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
        return retval;
    }
    // $ANTLR end "rewrite"

    public static class rewrite_alternative_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rewrite_alternative"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:428:1: rewrite_alternative : ( rewrite_template | rewrite_tree_alternative | ^( ALT EPSILON EOA ) );
    public final ANTLRv3TreeFilter.rewrite_alternative_return rewrite_alternative() throws RecognitionException {
        ANTLRv3TreeFilter.rewrite_alternative_return retval = new ANTLRv3TreeFilter.rewrite_alternative_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:429:2: ( rewrite_template | rewrite_tree_alternative | ^( ALT EPSILON EOA ) )
            int alt43=3;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==TEMPLATE||LA43_0==ACTION) ) {
                alt43=1;
            }
            else if ( (LA43_0==ALT) ) {
                int LA43_2 = input.LA(2);

                if ( (LA43_2==DOWN) ) {
                    int LA43_3 = input.LA(3);

                    if ( (LA43_3==EPSILON) ) {
                        alt43=3;
                    }
                    else if ( ((LA43_3>=BLOCK && LA43_3<=POSITIVE_CLOSURE)||LA43_3==LABEL||LA43_3==TREE_BEGIN||(LA43_3>=TOKEN_REF && LA43_3<=ACTION)||LA43_3==RULE_REF) ) {
                        alt43=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 43, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:429:4: rewrite_template
                    {
                    pushFollow(FOLLOW_rewrite_template_in_rewrite_alternative2165);
                    rewrite_template();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:430:4: rewrite_tree_alternative
                    {
                    pushFollow(FOLLOW_rewrite_tree_alternative_in_rewrite_alternative2170);
                    rewrite_tree_alternative();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:431:9: ^( ALT EPSILON EOA )
                    {
                    match(input,ALT,FOLLOW_ALT_in_rewrite_alternative2181); 

                    match(input, Token.DOWN, null); 
                    match(input,EPSILON,FOLLOW_EPSILON_in_rewrite_alternative2183); 
                    match(input,EOA,FOLLOW_EOA_in_rewrite_alternative2185); 

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
        return retval;
    }
    // $ANTLR end "rewrite_alternative"

    public static class rewrite_tree_block_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rewrite_tree_block"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:434:1: rewrite_tree_block : ^( BLOCK rewrite_tree_alternative EOB ) ;
    public final ANTLRv3TreeFilter.rewrite_tree_block_return rewrite_tree_block() throws RecognitionException {
        ANTLRv3TreeFilter.rewrite_tree_block_return retval = new ANTLRv3TreeFilter.rewrite_tree_block_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:435:5: ( ^( BLOCK rewrite_tree_alternative EOB ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:435:9: ^( BLOCK rewrite_tree_alternative EOB )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_rewrite_tree_block2204); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_rewrite_tree_alternative_in_rewrite_tree_block2206);
            rewrite_tree_alternative();

            state._fsp--;

            match(input,EOB,FOLLOW_EOB_in_rewrite_tree_block2208); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_tree_block"

    public static class rewrite_tree_alternative_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rewrite_tree_alternative"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:438:1: rewrite_tree_alternative : ^( ALT ( rewrite_tree_element )+ EOA ) ;
    public final ANTLRv3TreeFilter.rewrite_tree_alternative_return rewrite_tree_alternative() throws RecognitionException {
        ANTLRv3TreeFilter.rewrite_tree_alternative_return retval = new ANTLRv3TreeFilter.rewrite_tree_alternative_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:439:5: ( ^( ALT ( rewrite_tree_element )+ EOA ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:439:7: ^( ALT ( rewrite_tree_element )+ EOA )
            {
            match(input,ALT,FOLLOW_ALT_in_rewrite_tree_alternative2227); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:439:13: ( rewrite_tree_element )+
            int cnt44=0;
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=BLOCK && LA44_0<=POSITIVE_CLOSURE)||LA44_0==LABEL||LA44_0==TREE_BEGIN||(LA44_0>=TOKEN_REF && LA44_0<=ACTION)||LA44_0==RULE_REF) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:439:13: rewrite_tree_element
            	    {
            	    pushFollow(FOLLOW_rewrite_tree_element_in_rewrite_tree_alternative2229);
            	    rewrite_tree_element();

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

            match(input,EOA,FOLLOW_EOA_in_rewrite_tree_alternative2232); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_tree_alternative"

    public static class rewrite_tree_element_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rewrite_tree_element"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:442:1: rewrite_tree_element : ( rewrite_tree_atom | rewrite_tree | rewrite_tree_block | rewrite_tree_ebnf );
    public final ANTLRv3TreeFilter.rewrite_tree_element_return rewrite_tree_element() throws RecognitionException {
        ANTLRv3TreeFilter.rewrite_tree_element_return retval = new ANTLRv3TreeFilter.rewrite_tree_element_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:443:2: ( rewrite_tree_atom | rewrite_tree | rewrite_tree_block | rewrite_tree_ebnf )
            int alt45=4;
            switch ( input.LA(1) ) {
            case LABEL:
            case TOKEN_REF:
            case STRING_LITERAL:
            case CHAR_LITERAL:
            case ACTION:
            case RULE_REF:
                {
                alt45=1;
                }
                break;
            case TREE_BEGIN:
                {
                alt45=2;
                }
                break;
            case BLOCK:
                {
                alt45=3;
                }
                break;
            case OPTIONAL:
            case CLOSURE:
            case POSITIVE_CLOSURE:
                {
                alt45=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:443:4: rewrite_tree_atom
                    {
                    pushFollow(FOLLOW_rewrite_tree_atom_in_rewrite_tree_element2247);
                    rewrite_tree_atom();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:444:4: rewrite_tree
                    {
                    pushFollow(FOLLOW_rewrite_tree_in_rewrite_tree_element2252);
                    rewrite_tree();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:445:6: rewrite_tree_block
                    {
                    pushFollow(FOLLOW_rewrite_tree_block_in_rewrite_tree_element2259);
                    rewrite_tree_block();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:446:6: rewrite_tree_ebnf
                    {
                    pushFollow(FOLLOW_rewrite_tree_ebnf_in_rewrite_tree_element2266);
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
        return retval;
    }
    // $ANTLR end "rewrite_tree_element"

    public static class rewrite_tree_atom_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rewrite_tree_atom"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:449:1: rewrite_tree_atom : ( CHAR_LITERAL | TOKEN_REF | ^( TOKEN_REF ARG_ACTION ) | RULE_REF | STRING_LITERAL | LABEL | ACTION );
    public final ANTLRv3TreeFilter.rewrite_tree_atom_return rewrite_tree_atom() throws RecognitionException {
        ANTLRv3TreeFilter.rewrite_tree_atom_return retval = new ANTLRv3TreeFilter.rewrite_tree_atom_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:450:5: ( CHAR_LITERAL | TOKEN_REF | ^( TOKEN_REF ARG_ACTION ) | RULE_REF | STRING_LITERAL | LABEL | ACTION )
            int alt46=7;
            switch ( input.LA(1) ) {
            case CHAR_LITERAL:
                {
                alt46=1;
                }
                break;
            case TOKEN_REF:
                {
                int LA46_2 = input.LA(2);

                if ( (LA46_2==DOWN) ) {
                    alt46=3;
                }
                else if ( (LA46_2==UP||(LA46_2>=BLOCK && LA46_2<=POSITIVE_CLOSURE)||LA46_2==EOA||LA46_2==LABEL||LA46_2==TREE_BEGIN||(LA46_2>=TOKEN_REF && LA46_2<=ACTION)||LA46_2==RULE_REF) ) {
                    alt46=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_REF:
                {
                alt46=4;
                }
                break;
            case STRING_LITERAL:
                {
                alt46=5;
                }
                break;
            case LABEL:
                {
                alt46=6;
                }
                break;
            case ACTION:
                {
                alt46=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:450:9: CHAR_LITERAL
                    {
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_rewrite_tree_atom2282); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:451:6: TOKEN_REF
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_rewrite_tree_atom2289); 

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:452:6: ^( TOKEN_REF ARG_ACTION )
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_rewrite_tree_atom2297); 

                    match(input, Token.DOWN, null); 
                    match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rewrite_tree_atom2299); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:453:9: RULE_REF
                    {
                    match(input,RULE_REF,FOLLOW_RULE_REF_in_rewrite_tree_atom2311); 

                    }
                    break;
                case 5 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:454:6: STRING_LITERAL
                    {
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_rewrite_tree_atom2318); 

                    }
                    break;
                case 6 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:455:6: LABEL
                    {
                    match(input,LABEL,FOLLOW_LABEL_in_rewrite_tree_atom2325); 

                    }
                    break;
                case 7 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:456:4: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_rewrite_tree_atom2330); 

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
        return retval;
    }
    // $ANTLR end "rewrite_tree_atom"

    public static class rewrite_tree_ebnf_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rewrite_tree_ebnf"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:459:1: rewrite_tree_ebnf : ^( ebnfSuffix rewrite_tree_block ) ;
    public final ANTLRv3TreeFilter.rewrite_tree_ebnf_return rewrite_tree_ebnf() throws RecognitionException {
        ANTLRv3TreeFilter.rewrite_tree_ebnf_return retval = new ANTLRv3TreeFilter.rewrite_tree_ebnf_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:460:2: ( ^( ebnfSuffix rewrite_tree_block ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:460:4: ^( ebnfSuffix rewrite_tree_block )
            {
            pushFollow(FOLLOW_ebnfSuffix_in_rewrite_tree_ebnf2342);
            ebnfSuffix();

            state._fsp--;


            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_rewrite_tree_block_in_rewrite_tree_ebnf2344);
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
        return retval;
    }
    // $ANTLR end "rewrite_tree_ebnf"

    public static class rewrite_tree_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rewrite_tree"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:463:1: rewrite_tree : ^( TREE_BEGIN rewrite_tree_atom ( rewrite_tree_element )* ) ;
    public final ANTLRv3TreeFilter.rewrite_tree_return rewrite_tree() throws RecognitionException {
        ANTLRv3TreeFilter.rewrite_tree_return retval = new ANTLRv3TreeFilter.rewrite_tree_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:464:2: ( ^( TREE_BEGIN rewrite_tree_atom ( rewrite_tree_element )* ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:464:4: ^( TREE_BEGIN rewrite_tree_atom ( rewrite_tree_element )* )
            {
            match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_rewrite_tree2358); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_rewrite_tree_atom_in_rewrite_tree2360);
            rewrite_tree_atom();

            state._fsp--;

            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:464:35: ( rewrite_tree_element )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=BLOCK && LA47_0<=POSITIVE_CLOSURE)||LA47_0==LABEL||LA47_0==TREE_BEGIN||(LA47_0>=TOKEN_REF && LA47_0<=ACTION)||LA47_0==RULE_REF) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:464:35: rewrite_tree_element
            	    {
            	    pushFollow(FOLLOW_rewrite_tree_element_in_rewrite_tree2362);
            	    rewrite_tree_element();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
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
        return retval;
    }
    // $ANTLR end "rewrite_tree"

    public static class rewrite_template_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rewrite_template"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:467:1: rewrite_template : ( ^( TEMPLATE ID rewrite_template_args ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL ) ) | rewrite_template_ref | rewrite_indirect_template_head | ACTION );
    public final ANTLRv3TreeFilter.rewrite_template_return rewrite_template() throws RecognitionException {
        ANTLRv3TreeFilter.rewrite_template_return retval = new ANTLRv3TreeFilter.rewrite_template_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:468:2: ( ^( TEMPLATE ID rewrite_template_args ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL ) ) | rewrite_template_ref | rewrite_indirect_template_head | ACTION )
            int alt48=4;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:468:6: ^( TEMPLATE ID rewrite_template_args ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL ) )
                    {
                    match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite_template2380); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_rewrite_template2382); 
                    pushFollow(FOLLOW_rewrite_template_args_in_rewrite_template2384);
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
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:471:4: rewrite_template_ref
                    {
                    pushFollow(FOLLOW_rewrite_template_ref_in_rewrite_template2407);
                    rewrite_template_ref();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:472:4: rewrite_indirect_template_head
                    {
                    pushFollow(FOLLOW_rewrite_indirect_template_head_in_rewrite_template2412);
                    rewrite_indirect_template_head();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:473:4: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_rewrite_template2417); 

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
        return retval;
    }
    // $ANTLR end "rewrite_template"

    public static class rewrite_template_ref_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rewrite_template_ref"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:476:1: rewrite_template_ref : ^( TEMPLATE ID rewrite_template_args ) ;
    public final ANTLRv3TreeFilter.rewrite_template_ref_return rewrite_template_ref() throws RecognitionException {
        ANTLRv3TreeFilter.rewrite_template_ref_return retval = new ANTLRv3TreeFilter.rewrite_template_ref_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:478:2: ( ^( TEMPLATE ID rewrite_template_args ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:478:4: ^( TEMPLATE ID rewrite_template_args )
            {
            match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite_template_ref2431); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_rewrite_template_ref2433); 
            pushFollow(FOLLOW_rewrite_template_args_in_rewrite_template_ref2435);
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
        return retval;
    }
    // $ANTLR end "rewrite_template_ref"

    public static class rewrite_indirect_template_head_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rewrite_indirect_template_head"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:481:1: rewrite_indirect_template_head : ^( TEMPLATE ACTION rewrite_template_args ) ;
    public final ANTLRv3TreeFilter.rewrite_indirect_template_head_return rewrite_indirect_template_head() throws RecognitionException {
        ANTLRv3TreeFilter.rewrite_indirect_template_head_return retval = new ANTLRv3TreeFilter.rewrite_indirect_template_head_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:483:2: ( ^( TEMPLATE ACTION rewrite_template_args ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:483:4: ^( TEMPLATE ACTION rewrite_template_args )
            {
            match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite_indirect_template_head2450); 

            match(input, Token.DOWN, null); 
            match(input,ACTION,FOLLOW_ACTION_in_rewrite_indirect_template_head2452); 
            pushFollow(FOLLOW_rewrite_template_args_in_rewrite_indirect_template_head2454);
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
        return retval;
    }
    // $ANTLR end "rewrite_indirect_template_head"

    public static class rewrite_template_args_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rewrite_template_args"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:486:1: rewrite_template_args : ( ^( ARGLIST ( rewrite_template_arg )+ ) | ARGLIST );
    public final ANTLRv3TreeFilter.rewrite_template_args_return rewrite_template_args() throws RecognitionException {
        ANTLRv3TreeFilter.rewrite_template_args_return retval = new ANTLRv3TreeFilter.rewrite_template_args_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:487:2: ( ^( ARGLIST ( rewrite_template_arg )+ ) | ARGLIST )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==ARGLIST) ) {
                int LA50_1 = input.LA(2);

                if ( (LA50_1==DOWN) ) {
                    alt50=1;
                }
                else if ( (LA50_1==UP||(LA50_1>=DOUBLE_QUOTE_STRING_LITERAL && LA50_1<=DOUBLE_ANGLE_STRING_LITERAL)) ) {
                    alt50=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:487:4: ^( ARGLIST ( rewrite_template_arg )+ )
                    {
                    match(input,ARGLIST,FOLLOW_ARGLIST_in_rewrite_template_args2467); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:487:14: ( rewrite_template_arg )+
                    int cnt49=0;
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==ARG) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:487:14: rewrite_template_arg
                    	    {
                    	    pushFollow(FOLLOW_rewrite_template_arg_in_rewrite_template_args2469);
                    	    rewrite_template_arg();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt49 >= 1 ) break loop49;
                                EarlyExitException eee =
                                    new EarlyExitException(49, input);
                                throw eee;
                        }
                        cnt49++;
                    } while (true);


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:488:4: ARGLIST
                    {
                    match(input,ARGLIST,FOLLOW_ARGLIST_in_rewrite_template_args2476); 

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
        return retval;
    }
    // $ANTLR end "rewrite_template_args"

    public static class rewrite_template_arg_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rewrite_template_arg"
    // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:491:1: rewrite_template_arg : ^( ARG ID ACTION ) ;
    public final ANTLRv3TreeFilter.rewrite_template_arg_return rewrite_template_arg() throws RecognitionException {
        ANTLRv3TreeFilter.rewrite_template_arg_return retval = new ANTLRv3TreeFilter.rewrite_template_arg_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:492:2: ( ^( ARG ID ACTION ) )
            // src/core/koopa/core/trees/antlr/filter/generator/ANTLRv3TreeFilter.g:492:6: ^( ARG ID ACTION )
            {
            match(input,ARG,FOLLOW_ARG_in_rewrite_template_arg2490); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_rewrite_template_arg2492); 
            match(input,ACTION,FOLLOW_ACTION_in_rewrite_template_arg2494); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite_template_arg"

    // Delegated rules


    protected DFA33 dfa33 = new DFA33(this);
    protected DFA48 dfa48 = new DFA48(this);
    static final String DFA33_eotS =
        "\15\uffff";
    static final String DFA33_eofS =
        "\15\uffff";
    static final String DFA33_minS =
        "\1\10\2\2\6\uffff\1\24\1\10\2\uffff";
    static final String DFA33_maxS =
        "\1\134\2\2\6\uffff\1\24\1\134\2\uffff";
    static final String DFA33_acceptS =
        "\3\uffff\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff\1\2\1\1";
    static final String DFA33_specialS =
        "\15\uffff}>";
    static final String[] DFA33_transitionS = {
            "\5\4\1\uffff\1\3\21\uffff\1\6\1\7\1\4\2\uffff\1\10\2\3\2\uffff"+
            "\3\3\1\5\3\uffff\1\3\25\uffff\1\1\17\uffff\1\2\1\uffff\1\3\2"+
            "\uffff\1\3",
            "\1\11",
            "\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\12",
            "\1\14\5\uffff\1\13\27\uffff\2\13\2\uffff\3\13\4\uffff\1\13"+
            "\47\uffff\1\13\2\uffff\1\13",
            "",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "226:1: elementNoOptionSpec : ( ^( ( '=' | '+=' ) ID block ) -> {$block.st} | ^( ( '=' | '+=' ) ID atom ) -> {$atom.st} | atom -> {$atom.st} | ebnf -> {$ebnf.st} | ACTION -> {%{\"epsilon\"}} | SEMPRED -> {%{\"[>SEMPRED<]\"}} | GATED_SEMPRED -> {%{\"[>GATED_SEMPRED<]\"}} | treeSpec -> {$treeSpec.st});";
        }
    }
    static final String DFA48_eotS =
        "\20\uffff";
    static final String DFA48_eofS =
        "\20\uffff";
    static final String DFA48_minS =
        "\1\36\1\2\1\uffff\1\24\1\26\1\uffff\1\2\1\25\2\uffff\1\2\1\24\1"+
        "\55\3\3";
    static final String DFA48_maxS =
        "\1\55\1\2\1\uffff\1\55\1\26\1\uffff\1\63\1\25\2\uffff\1\2\1\24\1"+
        "\55\1\3\1\25\1\63";
    static final String DFA48_acceptS =
        "\2\uffff\1\4\2\uffff\1\3\2\uffff\1\2\1\1\6\uffff";
    static final String DFA48_specialS =
        "\20\uffff}>";
    static final String[] DFA48_transitionS = {
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

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "467:1: rewrite_template : ( ^( TEMPLATE ID rewrite_template_args ( DOUBLE_QUOTE_STRING_LITERAL | DOUBLE_ANGLE_STRING_LITERAL ) ) | rewrite_template_ref | rewrite_indirect_template_head | ACTION );";
        }
    }
 

    public static final BitSet FOLLOW_grammarType_in_grammarDef65 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_grammarDef67 = new BitSet(new long[]{0x0000420080000090L,0x0000000000000100L});
    public static final BitSet FOLLOW_DOC_COMMENT_in_grammarDef101 = new BitSet(new long[]{0x0000420080000090L,0x0000000000000100L});
    public static final BitSet FOLLOW_optionsSpec_in_grammarDef104 = new BitSet(new long[]{0x0000420080000090L,0x0000000000000100L});
    public static final BitSet FOLLOW_tokensSpec_in_grammarDef107 = new BitSet(new long[]{0x0000420080000090L,0x0000000000000100L});
    public static final BitSet FOLLOW_attrScope_in_grammarDef110 = new BitSet(new long[]{0x0000420080000090L,0x0000000000000100L});
    public static final BitSet FOLLOW_action_in_grammarDef113 = new BitSet(new long[]{0x0000420080000090L,0x0000000000000100L});
    public static final BitSet FOLLOW_rule_in_grammarDef119 = new BitSet(new long[]{0x0000420080000098L,0x0000000000000100L});
    public static final BitSet FOLLOW_LEXER_GRAMMAR_in_grammarType195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARSER_GRAMMAR_in_grammarType207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TREE_GRAMMAR_in_grammarType219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMBINED_GRAMMAR_in_grammarType225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKENS_in_tokensSpec244 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tokenSpec_in_tokensSpec246 = new BitSet(new long[]{0x0000040000000008L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_tokenSpec260 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec262 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_tokenSpec264 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_71_in_tokenSpec271 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec273 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_tokenSpec275 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SCOPE_in_attrScope293 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_attrScope295 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ACTION_in_attrScope297 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_72_in_action310 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_action312 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ID_in_action314 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ACTION_in_action316 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_72_in_action323 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_action325 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ACTION_in_action327 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OPTIONS_in_optionsSpec340 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_option_in_optionsSpec342 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_option361 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_option363 = new BitSet(new long[]{0x0000980000100000L});
    public static final BitSet FOLLOW_optionValue_in_option365 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_optionValue0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_in_rule431 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rule433 = new BitSet(new long[]{0x0000401080A00100L,0x0000000000003900L});
    public static final BitSet FOLLOW_modifier_in_rule450 = new BitSet(new long[]{0x0000401080A00100L,0x0000000000003900L});
    public static final BitSet FOLLOW_ARG_in_rule455 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rule457 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RET_in_rule464 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rule466 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_optionsSpec_in_rule477 = new BitSet(new long[]{0x0000401080A00100L,0x0000000000003900L});
    public static final BitSet FOLLOW_ruleScopeSpec_in_rule480 = new BitSet(new long[]{0x0000401080A00100L,0x0000000000003900L});
    public static final BitSet FOLLOW_ruleAction_in_rule483 = new BitSet(new long[]{0x0000401080A00100L,0x0000000000003900L});
    public static final BitSet FOLLOW_altList_in_rule501 = new BitSet(new long[]{0x0000000000020000L,0x0000000000600000L});
    public static final BitSet FOLLOW_exceptionGroup_in_rule518 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_EOR_in_rule528 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_modifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleAction610 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_ruleAction612 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ACTION_in_ruleAction614 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_80_in_throwsSpec627 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_throwsSpec629 = new BitSet(new long[]{0x0000000000100008L});
    public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec643 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec645 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec652 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec654 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ID_in_ruleScopeSpec656 = new BitSet(new long[]{0x0000000000100008L});
    public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec664 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_ruleScopeSpec666 = new BitSet(new long[]{0x0000000000100008L});
    public static final BitSet FOLLOW_BLOCK_in_block691 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_optionsSpec_in_block693 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_alternative_in_block707 = new BitSet(new long[]{0x0000010000050000L});
    public static final BitSet FOLLOW_rewrite_in_block709 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_EOB_in_block739 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_altList812 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alternative_in_altList825 = new BitSet(new long[]{0x0000010000050000L});
    public static final BitSet FOLLOW_rewrite_in_altList827 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_EOB_in_altList857 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_alternative930 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_alternative943 = new BitSet(new long[]{0x00023CE700085F00L,0x0000000012800080L});
    public static final BitSet FOLLOW_EOA_in_alternative973 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_alternative1027 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EPSILON_in_alternative1029 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_EOA_in_alternative1038 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup1072 = new BitSet(new long[]{0x0000000000000002L,0x0000000000600000L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_exceptionHandler1102 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler1104 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ACTION_in_exceptionHandler1106 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_86_in_finallyClause1128 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_finallyClause1130 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_elementNoOptionSpec_in_element1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_elementNoOptionSpec1171 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_87_in_elementNoOptionSpec1173 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_elementNoOptionSpec1176 = new BitSet(new long[]{0x0000000400001F00L});
    public static final BitSet FOLLOW_block_in_elementNoOptionSpec1178 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_71_in_elementNoOptionSpec1196 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_87_in_elementNoOptionSpec1198 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_elementNoOptionSpec1201 = new BitSet(new long[]{0x00021CC000004000L,0x0000000012000000L});
    public static final BitSet FOLLOW_atom_in_elementNoOptionSpec1203 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_elementNoOptionSpec1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ebnf_in_elementNoOptionSpec1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_elementNoOptionSpec1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_elementNoOptionSpec1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GATED_SEMPRED_in_elementNoOptionSpec1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_treeSpec_in_elementNoOptionSpec1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROOT_in_atom1323 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BANG_in_atom1325 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atom_in_atom1328 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_range_in_atom1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notSet_in_atom1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REF_in_atom1376 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_atom1378 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_REF_in_atom1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_terminal_in_atom1451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_notSet1473 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_notTerminal_in_notSet1475 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_89_in_notSet1482 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_notSet1484 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_BEGIN_in_treeSpec1507 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_REF_in_treeSpec1534 = new BitSet(new long[]{0x00023CE700085F08L,0x0000000012800080L});
    public static final BitSet FOLLOW_element_in_treeSpec1555 = new BitSet(new long[]{0x00023CE700085F08L,0x0000000012800080L});
    public static final BitSet FOLLOW_SYNPRED_in_ebnf1705 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1707 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SYN_SEMPRED_in_ebnf1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_ebnf1740 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1742 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLOSURE_in_ebnf1779 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1781 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_ebnf1818 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1820 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_ebnf1843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_RANGE_in_range1865 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_range1867 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_range1869 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_terminal1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal2019 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_terminal2021 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_92_in_terminal2038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_notTerminal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_ebnfSuffix2081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLOSURE_in_ebnfSuffix2097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_ebnfSuffix2113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REWRITE_in_rewrite2138 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEMPRED_in_rewrite2140 = new BitSet(new long[]{0x0000200040010000L});
    public static final BitSet FOLLOW_rewrite_alternative_in_rewrite2142 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REWRITE_in_rewrite2148 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_alternative_in_rewrite2150 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rewrite_template_in_rewrite_alternative2165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_tree_alternative_in_rewrite_alternative2170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALT_in_rewrite_alternative2181 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EPSILON_in_rewrite_alternative2183 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_EOA_in_rewrite_alternative2185 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_rewrite_tree_block2204 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_tree_alternative_in_rewrite_tree_block2206 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_EOB_in_rewrite_tree_block2208 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_rewrite_tree_alternative2227 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_tree_element_in_rewrite_tree_alternative2229 = new BitSet(new long[]{0x00023C2020080F00L});
    public static final BitSet FOLLOW_EOA_in_rewrite_tree_alternative2232 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rewrite_tree_atom_in_rewrite_tree_element2247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_tree_in_rewrite_tree_element2252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_tree_block_in_rewrite_tree_element2259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_tree_ebnf_in_rewrite_tree_element2266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_rewrite_tree_atom2282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_rewrite_tree_atom2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_rewrite_tree_atom2297 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rewrite_tree_atom2299 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_REF_in_rewrite_tree_atom2311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_rewrite_tree_atom2318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LABEL_in_rewrite_tree_atom2325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_tree_atom2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ebnfSuffix_in_rewrite_tree_ebnf2342 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_tree_block_in_rewrite_tree_ebnf2344 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_BEGIN_in_rewrite_tree2358 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_tree_atom_in_rewrite_tree2360 = new BitSet(new long[]{0x00023C2020080F08L});
    public static final BitSet FOLLOW_rewrite_tree_element_in_rewrite_tree2362 = new BitSet(new long[]{0x00023C2020080F08L});
    public static final BitSet FOLLOW_TEMPLATE_in_rewrite_template2380 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rewrite_template2382 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_template2384 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_set_in_rewrite_template2391 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rewrite_template_ref_in_rewrite_template2407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_indirect_template_head_in_rewrite_template2412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_template2417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEMPLATE_in_rewrite_template_ref2431 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rewrite_template_ref2433 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_template_ref2435 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TEMPLATE_in_rewrite_indirect_template_head2450 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_indirect_template_head2452 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rewrite_template_args_in_rewrite_indirect_template_head2454 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARGLIST_in_rewrite_template_args2467 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rewrite_template_arg_in_rewrite_template_args2469 = new BitSet(new long[]{0x0000000000200008L});
    public static final BitSet FOLLOW_ARGLIST_in_rewrite_template_args2476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARG_in_rewrite_template_arg2490 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rewrite_template_arg2492 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ACTION_in_rewrite_template_arg2494 = new BitSet(new long[]{0x0000000000000008L});

}