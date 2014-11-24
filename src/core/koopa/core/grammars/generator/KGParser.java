// $ANTLR 3.1.1 src/core/koopa/core/grammars/generator/KG.g 2014-11-24 20:27:59

  package koopa.core.grammars.generator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class KGParser extends Parser {
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
    public static final int EXTENDING=7;
    public static final int COMMA=24;
    public static final int IDENTIFIER=19;
    public static final int PIPE=38;
    public static final int PLUS=31;
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


        public KGParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public KGParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return KGParser.tokenNames; }
    public String getGrammarFileName() { return "src/core/koopa/core/grammars/generator/KG.g"; }


      //private boolean verifyNativeCode(Token code) {
      //  return JavaGrammarUtil.isValidJava(code.getText());
      //}


    public static class koopa_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "koopa"
    // src/core/koopa/core/grammars/generator/KG.g:40:1: koopa : meta ( rule )* EOF -> ^( GRAMMAR meta ( rule )* ) ;
    public final KGParser.koopa_return koopa() throws RecognitionException {
        KGParser.koopa_return retval = new KGParser.koopa_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF3=null;
        KGParser.meta_return meta1 = null;

        KGParser.rule_return rule2 = null;


        CommonTree EOF3_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_rule=new RewriteRuleSubtreeStream(adaptor,"rule rule");
        RewriteRuleSubtreeStream stream_meta=new RewriteRuleSubtreeStream(adaptor,"rule meta");
        try {
            // src/core/koopa/core/grammars/generator/KG.g:41:3: ( meta ( rule )* EOF -> ^( GRAMMAR meta ( rule )* ) )
            // src/core/koopa/core/grammars/generator/KG.g:41:5: meta ( rule )* EOF
            {
            pushFollow(FOLLOW_meta_in_koopa131);
            meta1=meta();

            state._fsp--;

            stream_meta.add(meta1.getTree());
            // src/core/koopa/core/grammars/generator/KG.g:43:5: ( rule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==46) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:43:5: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_koopa140);
            	    rule2=rule();

            	    state._fsp--;

            	    stream_rule.add(rule2.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_koopa143);  
            stream_EOF.add(EOF3);



            // AST REWRITE
            // elements: meta, rule
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 45:5: -> ^( GRAMMAR meta ( rule )* )
            {
                // src/core/koopa/core/grammars/generator/KG.g:45:8: ^( GRAMMAR meta ( rule )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(GRAMMAR, "GRAMMAR"), root_1);

                adaptor.addChild(root_1, stream_meta.nextTree());
                // src/core/koopa/core/grammars/generator/KG.g:45:23: ( rule )*
                while ( stream_rule.hasNext() ) {
                    adaptor.addChild(root_1, stream_rule.nextTree());

                }
                stream_rule.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "koopa"

    public static class meta_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "meta"
    // src/core/koopa/core/grammars/generator/KG.g:48:1: meta : 'grammar' n= IDENTIFIER ( 'extends' s= IDENTIFIER )? DOT -> { s == null }? ^( META ^( NAMED $n) ) -> ^( META ^( NAMED $n) ^( EXTENDING $s) ) ;
    public final KGParser.meta_return meta() throws RecognitionException {
        KGParser.meta_return retval = new KGParser.meta_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token n=null;
        Token s=null;
        Token string_literal4=null;
        Token string_literal5=null;
        Token DOT6=null;

        CommonTree n_tree=null;
        CommonTree s_tree=null;
        CommonTree string_literal4_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree DOT6_tree=null;
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/core/koopa/core/grammars/generator/KG.g:49:3: ( 'grammar' n= IDENTIFIER ( 'extends' s= IDENTIFIER )? DOT -> { s == null }? ^( META ^( NAMED $n) ) -> ^( META ^( NAMED $n) ^( EXTENDING $s) ) )
            // src/core/koopa/core/grammars/generator/KG.g:49:5: 'grammar' n= IDENTIFIER ( 'extends' s= IDENTIFIER )? DOT
            {
            string_literal4=(Token)match(input,44,FOLLOW_44_in_meta174);  
            stream_44.add(string_literal4);

            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_meta178);  
            stream_IDENTIFIER.add(n);

            // src/core/koopa/core/grammars/generator/KG.g:50:5: ( 'extends' s= IDENTIFIER )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==45) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KG.g:50:6: 'extends' s= IDENTIFIER
                    {
                    string_literal5=(Token)match(input,45,FOLLOW_45_in_meta185);  
                    stream_45.add(string_literal5);

                    s=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_meta189);  
                    stream_IDENTIFIER.add(s);


                    }
                    break;

            }

            DOT6=(Token)match(input,DOT,FOLLOW_DOT_in_meta197);  
            stream_DOT.add(DOT6);



            // AST REWRITE
            // elements: n, n, s
            // token labels: s, n
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            RewriteRuleTokenStream stream_n=new RewriteRuleTokenStream(adaptor,"token n",n);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 53:5: -> { s == null }? ^( META ^( NAMED $n) )
            if ( s == null ) {
                // src/core/koopa/core/grammars/generator/KG.g:53:23: ^( META ^( NAMED $n) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(META, "META"), root_1);

                // src/core/koopa/core/grammars/generator/KG.g:53:30: ^( NAMED $n)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED, "NAMED"), root_2);

                adaptor.addChild(root_2, stream_n.nextNode());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 55:5: -> ^( META ^( NAMED $n) ^( EXTENDING $s) )
            {
                // src/core/koopa/core/grammars/generator/KG.g:55:8: ^( META ^( NAMED $n) ^( EXTENDING $s) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(META, "META"), root_1);

                // src/core/koopa/core/grammars/generator/KG.g:55:15: ^( NAMED $n)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED, "NAMED"), root_2);

                adaptor.addChild(root_2, stream_n.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                // src/core/koopa/core/grammars/generator/KG.g:55:27: ^( EXTENDING $s)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXTENDING, "EXTENDING"), root_2);

                adaptor.addChild(root_2, stream_s.nextNode());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "meta"

    public static class rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rule"
    // src/core/koopa/core/grammars/generator/KG.g:58:1: rule : 'def' i= IDENTIFIER ( OPEN_PAREN l= locals CLOSE_PAREN )? ( 'returns' r= IDENTIFIER )? EQUALS sequence 'end' -> { l != null && r != null }? ^( RULE $i locals ^( RETURNS $r) sequence ) -> { l != null && r == null }? ^( RULE $i locals sequence ) -> { l == null && r != null }? ^( RULE $i ^( RETURNS $r) sequence ) -> ^( RULE $i sequence ) ;
    public final KGParser.rule_return rule() throws RecognitionException {
        KGParser.rule_return retval = new KGParser.rule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token i=null;
        Token r=null;
        Token string_literal7=null;
        Token OPEN_PAREN8=null;
        Token CLOSE_PAREN9=null;
        Token string_literal10=null;
        Token EQUALS11=null;
        Token string_literal13=null;
        KGParser.locals_return l = null;

        KGParser.sequence_return sequence12 = null;


        CommonTree i_tree=null;
        CommonTree r_tree=null;
        CommonTree string_literal7_tree=null;
        CommonTree OPEN_PAREN8_tree=null;
        CommonTree CLOSE_PAREN9_tree=null;
        CommonTree string_literal10_tree=null;
        CommonTree EQUALS11_tree=null;
        CommonTree string_literal13_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_OPEN_PAREN=new RewriteRuleTokenStream(adaptor,"token OPEN_PAREN");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_CLOSE_PAREN=new RewriteRuleTokenStream(adaptor,"token CLOSE_PAREN");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_locals=new RewriteRuleSubtreeStream(adaptor,"rule locals");
        RewriteRuleSubtreeStream stream_sequence=new RewriteRuleSubtreeStream(adaptor,"rule sequence");
        try {
            // src/core/koopa/core/grammars/generator/KG.g:59:3: ( 'def' i= IDENTIFIER ( OPEN_PAREN l= locals CLOSE_PAREN )? ( 'returns' r= IDENTIFIER )? EQUALS sequence 'end' -> { l != null && r != null }? ^( RULE $i locals ^( RETURNS $r) sequence ) -> { l != null && r == null }? ^( RULE $i locals sequence ) -> { l == null && r != null }? ^( RULE $i ^( RETURNS $r) sequence ) -> ^( RULE $i sequence ) )
            // src/core/koopa/core/grammars/generator/KG.g:59:5: 'def' i= IDENTIFIER ( OPEN_PAREN l= locals CLOSE_PAREN )? ( 'returns' r= IDENTIFIER )? EQUALS sequence 'end'
            {
            string_literal7=(Token)match(input,46,FOLLOW_46_in_rule263);  
            stream_46.add(string_literal7);

            i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule267);  
            stream_IDENTIFIER.add(i);

            // src/core/koopa/core/grammars/generator/KG.g:60:7: ( OPEN_PAREN l= locals CLOSE_PAREN )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==OPEN_PAREN) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KG.g:60:8: OPEN_PAREN l= locals CLOSE_PAREN
                    {
                    OPEN_PAREN8=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_rule276);  
                    stream_OPEN_PAREN.add(OPEN_PAREN8);

                    pushFollow(FOLLOW_locals_in_rule280);
                    l=locals();

                    state._fsp--;

                    stream_locals.add(l.getTree());
                    CLOSE_PAREN9=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_rule282);  
                    stream_CLOSE_PAREN.add(CLOSE_PAREN9);


                    }
                    break;

            }

            // src/core/koopa/core/grammars/generator/KG.g:61:7: ( 'returns' r= IDENTIFIER )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==47) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KG.g:61:8: 'returns' r= IDENTIFIER
                    {
                    string_literal10=(Token)match(input,47,FOLLOW_47_in_rule293);  
                    stream_47.add(string_literal10);

                    r=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule297);  
                    stream_IDENTIFIER.add(r);


                    }
                    break;

            }

            EQUALS11=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_rule301);  
            stream_EQUALS.add(EQUALS11);

            pushFollow(FOLLOW_sequence_in_rule312);
            sequence12=sequence();

            state._fsp--;

            stream_sequence.add(sequence12.getTree());
            string_literal13=(Token)match(input,48,FOLLOW_48_in_rule321);  
            stream_48.add(string_literal13);



            // AST REWRITE
            // elements: i, i, locals, sequence, r, sequence, i, i, r, sequence, locals, sequence
            // token labels: r, i
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
            RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 67:5: -> { l != null && r != null }? ^( RULE $i locals ^( RETURNS $r) sequence )
            if ( l != null && r != null ) {
                // src/core/koopa/core/grammars/generator/KG.g:67:36: ^( RULE $i locals ^( RETURNS $r) sequence )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);

                adaptor.addChild(root_1, stream_i.nextNode());
                adaptor.addChild(root_1, stream_locals.nextTree());
                // src/core/koopa/core/grammars/generator/KG.g:67:53: ^( RETURNS $r)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RETURNS, "RETURNS"), root_2);

                adaptor.addChild(root_2, stream_r.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                adaptor.addChild(root_1, stream_sequence.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 68:5: -> { l != null && r == null }? ^( RULE $i locals sequence )
            if ( l != null && r == null ) {
                // src/core/koopa/core/grammars/generator/KG.g:68:36: ^( RULE $i locals sequence )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);

                adaptor.addChild(root_1, stream_i.nextNode());
                adaptor.addChild(root_1, stream_locals.nextTree());
                adaptor.addChild(root_1, stream_sequence.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 69:5: -> { l == null && r != null }? ^( RULE $i ^( RETURNS $r) sequence )
            if ( l == null && r != null ) {
                // src/core/koopa/core/grammars/generator/KG.g:69:36: ^( RULE $i ^( RETURNS $r) sequence )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);

                adaptor.addChild(root_1, stream_i.nextNode());
                // src/core/koopa/core/grammars/generator/KG.g:69:46: ^( RETURNS $r)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RETURNS, "RETURNS"), root_2);

                adaptor.addChild(root_2, stream_r.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                adaptor.addChild(root_1, stream_sequence.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 70:5: -> ^( RULE $i sequence )
            {
                // src/core/koopa/core/grammars/generator/KG.g:70:8: ^( RULE $i sequence )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);

                adaptor.addChild(root_1, stream_i.nextNode());
                adaptor.addChild(root_1, stream_sequence.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rule"

    public static class locals_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "locals"
    // src/core/koopa/core/grammars/generator/KG.g:73:1: locals : declaration ( COMMA declaration )* -> ^( LOCALS ( declaration )+ ) ;
    public final KGParser.locals_return locals() throws RecognitionException {
        KGParser.locals_return retval = new KGParser.locals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA15=null;
        KGParser.declaration_return declaration14 = null;

        KGParser.declaration_return declaration16 = null;


        CommonTree COMMA15_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_declaration=new RewriteRuleSubtreeStream(adaptor,"rule declaration");
        try {
            // src/core/koopa/core/grammars/generator/KG.g:74:3: ( declaration ( COMMA declaration )* -> ^( LOCALS ( declaration )+ ) )
            // src/core/koopa/core/grammars/generator/KG.g:74:5: declaration ( COMMA declaration )*
            {
            pushFollow(FOLLOW_declaration_in_locals419);
            declaration14=declaration();

            state._fsp--;

            stream_declaration.add(declaration14.getTree());
            // src/core/koopa/core/grammars/generator/KG.g:74:17: ( COMMA declaration )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMMA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:74:18: COMMA declaration
            	    {
            	    COMMA15=(Token)match(input,COMMA,FOLLOW_COMMA_in_locals422);  
            	    stream_COMMA.add(COMMA15);

            	    pushFollow(FOLLOW_declaration_in_locals424);
            	    declaration16=declaration();

            	    state._fsp--;

            	    stream_declaration.add(declaration16.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);



            // AST REWRITE
            // elements: declaration
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 76:5: -> ^( LOCALS ( declaration )+ )
            {
                // src/core/koopa/core/grammars/generator/KG.g:76:8: ^( LOCALS ( declaration )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LOCALS, "LOCALS"), root_1);

                if ( !(stream_declaration.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_declaration.hasNext() ) {
                    adaptor.addChild(root_1, stream_declaration.nextTree());

                }
                stream_declaration.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "locals"

    public static class declaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaration"
    // src/core/koopa/core/grammars/generator/KG.g:79:1: declaration : IDENTIFIER IDENTIFIER -> ^( DECLARATION IDENTIFIER IDENTIFIER ) ;
    public final KGParser.declaration_return declaration() throws RecognitionException {
        KGParser.declaration_return retval = new KGParser.declaration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENTIFIER17=null;
        Token IDENTIFIER18=null;

        CommonTree IDENTIFIER17_tree=null;
        CommonTree IDENTIFIER18_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/core/koopa/core/grammars/generator/KG.g:80:3: ( IDENTIFIER IDENTIFIER -> ^( DECLARATION IDENTIFIER IDENTIFIER ) )
            // src/core/koopa/core/grammars/generator/KG.g:80:5: IDENTIFIER IDENTIFIER
            {
            IDENTIFIER17=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration453);  
            stream_IDENTIFIER.add(IDENTIFIER17);

            IDENTIFIER18=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration455);  
            stream_IDENTIFIER.add(IDENTIFIER18);



            // AST REWRITE
            // elements: IDENTIFIER, IDENTIFIER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 82:5: -> ^( DECLARATION IDENTIFIER IDENTIFIER )
            {
                // src/core/koopa/core/grammars/generator/KG.g:82:8: ^( DECLARATION IDENTIFIER IDENTIFIER )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECLARATION, "DECLARATION"), root_1);

                adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declaration"

    public static class sequence_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sequence"
    // src/core/koopa/core/grammars/generator/KG.g:85:1: sequence : (p+= part )+ -> { $p.size() > 1 }? ^( SEQUENCE ( part )+ ) -> ( part )+ ;
    public final KGParser.sequence_return sequence() throws RecognitionException {
        KGParser.sequence_return retval = new KGParser.sequence_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        List list_p=null;
        RuleReturnScope p = null;
        RewriteRuleSubtreeStream stream_part=new RewriteRuleSubtreeStream(adaptor,"rule part");
        try {
            // src/core/koopa/core/grammars/generator/KG.g:86:3: ( (p+= part )+ -> { $p.size() > 1 }? ^( SEQUENCE ( part )+ ) -> ( part )+ )
            // src/core/koopa/core/grammars/generator/KG.g:86:5: (p+= part )+
            {
            // src/core/koopa/core/grammars/generator/KG.g:86:6: (p+= part )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=IDENTIFIER && LA6_0<=OPEN_PAREN)||(LA6_0>=NATIVE_CODE && LA6_0<=NUMBER)||LA6_0==OPEN_BRACKET||(LA6_0>=SKIP_TO && LA6_0<=NOSKIP)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:86:6: p+= part
            	    {
            	    pushFollow(FOLLOW_part_in_sequence485);
            	    p=part();

            	    state._fsp--;

            	    stream_part.add(p.getTree());
            	    if (list_p==null) list_p=new ArrayList();
            	    list_p.add(p.getTree());


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



            // AST REWRITE
            // elements: part, part
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 88:5: -> { $p.size() > 1 }? ^( SEQUENCE ( part )+ )
            if ( list_p.size() > 1 ) {
                // src/core/koopa/core/grammars/generator/KG.g:88:27: ^( SEQUENCE ( part )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SEQUENCE, "SEQUENCE"), root_1);

                if ( !(stream_part.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_part.hasNext() ) {
                    adaptor.addChild(root_1, stream_part.nextTree());

                }
                stream_part.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 89:5: -> ( part )+
            {
                if ( !(stream_part.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_part.hasNext() ) {
                    adaptor.addChild(root_0, stream_part.nextTree());

                }
                stream_part.reset();

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sequence"

    public static class part_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "part"
    // src/core/koopa/core/grammars/generator/KG.g:92:1: part : (code= NATIVE_CODE -> ^( ACT NATIVE_CODE ) | TAG | ANY | LITERAL | NUMBER | a= IDENTIFIER (e= EQUALS (b= IDENTIFIER | b= NUMBER | b= DOT ) )? -> { e != null }? ^( ASSIGN $a $b) -> IDENTIFIER | DOT | OPEN_PAREN sequence (m+= more )* CLOSE_PAREN (r= STAR | r= PLUS )? -> { r != null && m != null }? ^( $r ^( CHOICE sequence ( more )* ) ) -> { r != null && m == null }? ^( $r sequence ) -> { r == null && m != null }? ^( CHOICE sequence ( more )* ) -> sequence | OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET (r= STAR | r= PLUS )? -> { r != null && m != null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) ) -> { r != null && m == null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) ) -> { r == null && m != null }? ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) -> ^( OPTIONAL sequence ) | SKIP_TO part -> ^( SKIP_TO part ) | BANG OPEN_PAREN sequence (m+= more )* CLOSE_PAREN -> { m == null }? ^( OPTIONAL sequence ) -> ^( PERMUTED sequence ( more )* ) | NOT part -> ^( NOT part ) | NOSKIP part -> ^( NOSKIP part ) );
    public final KGParser.part_return part() throws RecognitionException {
        KGParser.part_return retval = new KGParser.part_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token code=null;
        Token a=null;
        Token e=null;
        Token b=null;
        Token r=null;
        Token TAG19=null;
        Token ANY20=null;
        Token LITERAL21=null;
        Token NUMBER22=null;
        Token DOT23=null;
        Token OPEN_PAREN24=null;
        Token CLOSE_PAREN26=null;
        Token OPEN_BRACKET27=null;
        Token CLOSE_BRACKET29=null;
        Token SKIP_TO30=null;
        Token BANG32=null;
        Token OPEN_PAREN33=null;
        Token CLOSE_PAREN35=null;
        Token NOT36=null;
        Token NOSKIP38=null;
        List list_m=null;
        KGParser.sequence_return sequence25 = null;

        KGParser.sequence_return sequence28 = null;

        KGParser.part_return part31 = null;

        KGParser.sequence_return sequence34 = null;

        KGParser.part_return part37 = null;

        KGParser.part_return part39 = null;

        RuleReturnScope m = null;
        CommonTree code_tree=null;
        CommonTree a_tree=null;
        CommonTree e_tree=null;
        CommonTree b_tree=null;
        CommonTree r_tree=null;
        CommonTree TAG19_tree=null;
        CommonTree ANY20_tree=null;
        CommonTree LITERAL21_tree=null;
        CommonTree NUMBER22_tree=null;
        CommonTree DOT23_tree=null;
        CommonTree OPEN_PAREN24_tree=null;
        CommonTree CLOSE_PAREN26_tree=null;
        CommonTree OPEN_BRACKET27_tree=null;
        CommonTree CLOSE_BRACKET29_tree=null;
        CommonTree SKIP_TO30_tree=null;
        CommonTree BANG32_tree=null;
        CommonTree OPEN_PAREN33_tree=null;
        CommonTree CLOSE_PAREN35_tree=null;
        CommonTree NOT36_tree=null;
        CommonTree NOSKIP38_tree=null;
        RewriteRuleTokenStream stream_OPEN_BRACKET=new RewriteRuleTokenStream(adaptor,"token OPEN_BRACKET");
        RewriteRuleTokenStream stream_SKIP_TO=new RewriteRuleTokenStream(adaptor,"token SKIP_TO");
        RewriteRuleTokenStream stream_NATIVE_CODE=new RewriteRuleTokenStream(adaptor,"token NATIVE_CODE");
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
        RewriteRuleTokenStream stream_OPEN_PAREN=new RewriteRuleTokenStream(adaptor,"token OPEN_PAREN");
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_BANG=new RewriteRuleTokenStream(adaptor,"token BANG");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_CLOSE_PAREN=new RewriteRuleTokenStream(adaptor,"token CLOSE_PAREN");
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_NOSKIP=new RewriteRuleTokenStream(adaptor,"token NOSKIP");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_CLOSE_BRACKET=new RewriteRuleTokenStream(adaptor,"token CLOSE_BRACKET");
        RewriteRuleSubtreeStream stream_more=new RewriteRuleSubtreeStream(adaptor,"rule more");
        RewriteRuleSubtreeStream stream_sequence=new RewriteRuleSubtreeStream(adaptor,"rule sequence");
        RewriteRuleSubtreeStream stream_part=new RewriteRuleSubtreeStream(adaptor,"rule part");
        try {
            // src/core/koopa/core/grammars/generator/KG.g:93:3: (code= NATIVE_CODE -> ^( ACT NATIVE_CODE ) | TAG | ANY | LITERAL | NUMBER | a= IDENTIFIER (e= EQUALS (b= IDENTIFIER | b= NUMBER | b= DOT ) )? -> { e != null }? ^( ASSIGN $a $b) -> IDENTIFIER | DOT | OPEN_PAREN sequence (m+= more )* CLOSE_PAREN (r= STAR | r= PLUS )? -> { r != null && m != null }? ^( $r ^( CHOICE sequence ( more )* ) ) -> { r != null && m == null }? ^( $r sequence ) -> { r == null && m != null }? ^( CHOICE sequence ( more )* ) -> sequence | OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET (r= STAR | r= PLUS )? -> { r != null && m != null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) ) -> { r != null && m == null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) ) -> { r == null && m != null }? ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) -> ^( OPTIONAL sequence ) | SKIP_TO part -> ^( SKIP_TO part ) | BANG OPEN_PAREN sequence (m+= more )* CLOSE_PAREN -> { m == null }? ^( OPTIONAL sequence ) -> ^( PERMUTED sequence ( more )* ) | NOT part -> ^( NOT part ) | NOSKIP part -> ^( NOSKIP part ) )
            int alt14=13;
            switch ( input.LA(1) ) {
            case NATIVE_CODE:
                {
                alt14=1;
                }
                break;
            case TAG:
                {
                alt14=2;
                }
                break;
            case ANY:
                {
                alt14=3;
                }
                break;
            case LITERAL:
                {
                alt14=4;
                }
                break;
            case NUMBER:
                {
                alt14=5;
                }
                break;
            case IDENTIFIER:
                {
                alt14=6;
                }
                break;
            case DOT:
                {
                alt14=7;
                }
                break;
            case OPEN_PAREN:
                {
                alt14=8;
                }
                break;
            case OPEN_BRACKET:
                {
                alt14=9;
                }
                break;
            case SKIP_TO:
                {
                alt14=10;
                }
                break;
            case BANG:
                {
                alt14=11;
                }
                break;
            case NOT:
                {
                alt14=12;
                }
                break;
            case NOSKIP:
                {
                alt14=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KG.g:93:5: code= NATIVE_CODE
                    {
                    code=(Token)match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_part526);  
                    stream_NATIVE_CODE.add(code);

                     // if (!verifyNativeCode(code)) {
                          //	throw new RecognitionException("Not a valid java block.", code.getFilename(), code.getLine(), code.getColumn());
                          // }
                        


                    // AST REWRITE
                    // elements: NATIVE_CODE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 98:5: -> ^( ACT NATIVE_CODE )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:98:8: ^( ACT NATIVE_CODE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ACT, "ACT"), root_1);

                        adaptor.addChild(root_1, stream_NATIVE_CODE.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // src/core/koopa/core/grammars/generator/KG.g:100:5: TAG
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    TAG19=(Token)match(input,TAG,FOLLOW_TAG_in_part551); 
                    TAG19_tree = (CommonTree)adaptor.create(TAG19);
                    adaptor.addChild(root_0, TAG19_tree);


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/grammars/generator/KG.g:102:5: ANY
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ANY20=(Token)match(input,ANY,FOLLOW_ANY_in_part558); 
                    ANY20_tree = (CommonTree)adaptor.create(ANY20);
                    adaptor.addChild(root_0, ANY20_tree);


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/grammars/generator/KG.g:104:5: LITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LITERAL21=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_part565); 
                    LITERAL21_tree = (CommonTree)adaptor.create(LITERAL21);
                    adaptor.addChild(root_0, LITERAL21_tree);


                    }
                    break;
                case 5 :
                    // src/core/koopa/core/grammars/generator/KG.g:106:5: NUMBER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NUMBER22=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_part572); 
                    NUMBER22_tree = (CommonTree)adaptor.create(NUMBER22);
                    adaptor.addChild(root_0, NUMBER22_tree);


                    }
                    break;
                case 6 :
                    // src/core/koopa/core/grammars/generator/KG.g:108:5: a= IDENTIFIER (e= EQUALS (b= IDENTIFIER | b= NUMBER | b= DOT ) )?
                    {
                    a=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_part583);  
                    stream_IDENTIFIER.add(a);

                    // src/core/koopa/core/grammars/generator/KG.g:109:5: (e= EQUALS (b= IDENTIFIER | b= NUMBER | b= DOT ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==EQUALS) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // src/core/koopa/core/grammars/generator/KG.g:109:6: e= EQUALS (b= IDENTIFIER | b= NUMBER | b= DOT )
                            {
                            e=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_part593);  
                            stream_EQUALS.add(e);

                            // src/core/koopa/core/grammars/generator/KG.g:109:15: (b= IDENTIFIER | b= NUMBER | b= DOT )
                            int alt7=3;
                            switch ( input.LA(1) ) {
                            case IDENTIFIER:
                                {
                                alt7=1;
                                }
                                break;
                            case NUMBER:
                                {
                                alt7=2;
                                }
                                break;
                            case DOT:
                                {
                                alt7=3;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 7, 0, input);

                                throw nvae;
                            }

                            switch (alt7) {
                                case 1 :
                                    // src/core/koopa/core/grammars/generator/KG.g:109:16: b= IDENTIFIER
                                    {
                                    b=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_part598);  
                                    stream_IDENTIFIER.add(b);


                                    }
                                    break;
                                case 2 :
                                    // src/core/koopa/core/grammars/generator/KG.g:109:31: b= NUMBER
                                    {
                                    b=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_part604);  
                                    stream_NUMBER.add(b);


                                    }
                                    break;
                                case 3 :
                                    // src/core/koopa/core/grammars/generator/KG.g:109:42: b= DOT
                                    {
                                    b=(Token)match(input,DOT,FOLLOW_DOT_in_part610);  
                                    stream_DOT.add(b);


                                    }
                                    break;

                            }


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: a, b, IDENTIFIER
                    // token labels: b, a
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_b=new RewriteRuleTokenStream(adaptor,"token b",b);
                    RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 111:5: -> { e != null }? ^( ASSIGN $a $b)
                    if ( e != null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:111:23: ^( ASSIGN $a $b)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGN, "ASSIGN"), root_1);

                        adaptor.addChild(root_1, stream_a.nextNode());
                        adaptor.addChild(root_1, stream_b.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 112:5: -> IDENTIFIER
                    {
                        adaptor.addChild(root_0, stream_IDENTIFIER.nextNode());

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 7 :
                    // src/core/koopa/core/grammars/generator/KG.g:114:5: DOT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DOT23=(Token)match(input,DOT,FOLLOW_DOT_in_part651); 
                    DOT23_tree = (CommonTree)adaptor.create(DOT23);
                    adaptor.addChild(root_0, DOT23_tree);


                    }
                    break;
                case 8 :
                    // src/core/koopa/core/grammars/generator/KG.g:116:5: OPEN_PAREN sequence (m+= more )* CLOSE_PAREN (r= STAR | r= PLUS )?
                    {
                    OPEN_PAREN24=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_part658);  
                    stream_OPEN_PAREN.add(OPEN_PAREN24);

                    pushFollow(FOLLOW_sequence_in_part660);
                    sequence25=sequence();

                    state._fsp--;

                    stream_sequence.add(sequence25.getTree());
                    // src/core/koopa/core/grammars/generator/KG.g:116:26: (m+= more )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==PIPE) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KG.g:116:26: m+= more
                    	    {
                    	    pushFollow(FOLLOW_more_in_part664);
                    	    m=more();

                    	    state._fsp--;

                    	    stream_more.add(m.getTree());
                    	    if (list_m==null) list_m=new ArrayList();
                    	    list_m.add(m.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    CLOSE_PAREN26=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_part667);  
                    stream_CLOSE_PAREN.add(CLOSE_PAREN26);

                    // src/core/koopa/core/grammars/generator/KG.g:116:46: (r= STAR | r= PLUS )?
                    int alt10=3;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==STAR) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==PLUS) ) {
                        alt10=2;
                    }
                    switch (alt10) {
                        case 1 :
                            // src/core/koopa/core/grammars/generator/KG.g:116:47: r= STAR
                            {
                            r=(Token)match(input,STAR,FOLLOW_STAR_in_part672);  
                            stream_STAR.add(r);


                            }
                            break;
                        case 2 :
                            // src/core/koopa/core/grammars/generator/KG.g:116:56: r= PLUS
                            {
                            r=(Token)match(input,PLUS,FOLLOW_PLUS_in_part678);  
                            stream_PLUS.add(r);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: r, sequence, sequence, sequence, sequence, more, r, more
                    // token labels: r
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 118:5: -> { r != null && m != null }? ^( $r ^( CHOICE sequence ( more )* ) )
                    if ( r != null && m != null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:118:36: ^( $r ^( CHOICE sequence ( more )* ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);

                        // src/core/koopa/core/grammars/generator/KG.g:118:41: ^( CHOICE sequence ( more )* )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_2);

                        adaptor.addChild(root_2, stream_sequence.nextTree());
                        // src/core/koopa/core/grammars/generator/KG.g:118:59: ( more )*
                        while ( stream_more.hasNext() ) {
                            adaptor.addChild(root_2, stream_more.nextTree());

                        }
                        stream_more.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 119:5: -> { r != null && m == null }? ^( $r sequence )
                    if ( r != null && m == null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:119:36: ^( $r sequence )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_sequence.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 120:5: -> { r == null && m != null }? ^( CHOICE sequence ( more )* )
                    if ( r == null && m != null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:120:36: ^( CHOICE sequence ( more )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_1);

                        adaptor.addChild(root_1, stream_sequence.nextTree());
                        // src/core/koopa/core/grammars/generator/KG.g:120:54: ( more )*
                        while ( stream_more.hasNext() ) {
                            adaptor.addChild(root_1, stream_more.nextTree());

                        }
                        stream_more.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 121:5: -> sequence
                    {
                        adaptor.addChild(root_0, stream_sequence.nextTree());

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 9 :
                    // src/core/koopa/core/grammars/generator/KG.g:123:5: OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET (r= STAR | r= PLUS )?
                    {
                    OPEN_BRACKET27=(Token)match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_part750);  
                    stream_OPEN_BRACKET.add(OPEN_BRACKET27);

                    pushFollow(FOLLOW_sequence_in_part752);
                    sequence28=sequence();

                    state._fsp--;

                    stream_sequence.add(sequence28.getTree());
                    // src/core/koopa/core/grammars/generator/KG.g:123:28: (m+= more )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==PIPE) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KG.g:123:28: m+= more
                    	    {
                    	    pushFollow(FOLLOW_more_in_part756);
                    	    m=more();

                    	    state._fsp--;

                    	    stream_more.add(m.getTree());
                    	    if (list_m==null) list_m=new ArrayList();
                    	    list_m.add(m.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    CLOSE_BRACKET29=(Token)match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_part759);  
                    stream_CLOSE_BRACKET.add(CLOSE_BRACKET29);

                    // src/core/koopa/core/grammars/generator/KG.g:123:50: (r= STAR | r= PLUS )?
                    int alt12=3;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==STAR) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==PLUS) ) {
                        alt12=2;
                    }
                    switch (alt12) {
                        case 1 :
                            // src/core/koopa/core/grammars/generator/KG.g:123:51: r= STAR
                            {
                            r=(Token)match(input,STAR,FOLLOW_STAR_in_part764);  
                            stream_STAR.add(r);


                            }
                            break;
                        case 2 :
                            // src/core/koopa/core/grammars/generator/KG.g:123:60: r= PLUS
                            {
                            r=(Token)match(input,PLUS,FOLLOW_PLUS_in_part770);  
                            stream_PLUS.add(r);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: r, sequence, r, more, sequence, sequence, more, sequence
                    // token labels: r
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 125:5: -> { r != null && m != null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) )
                    if ( r != null && m != null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:125:36: ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);

                        // src/core/koopa/core/grammars/generator/KG.g:125:41: ^( OPTIONAL ^( CHOICE sequence ( more )* ) )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_2);

                        // src/core/koopa/core/grammars/generator/KG.g:125:52: ^( CHOICE sequence ( more )* )
                        {
                        CommonTree root_3 = (CommonTree)adaptor.nil();
                        root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_3);

                        adaptor.addChild(root_3, stream_sequence.nextTree());
                        // src/core/koopa/core/grammars/generator/KG.g:125:70: ( more )*
                        while ( stream_more.hasNext() ) {
                            adaptor.addChild(root_3, stream_more.nextTree());

                        }
                        stream_more.reset();

                        adaptor.addChild(root_2, root_3);
                        }

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 126:5: -> { r != null && m == null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) )
                    if ( r != null && m == null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:126:36: ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);

                        // src/core/koopa/core/grammars/generator/KG.g:126:41: ^( OPTIONAL ^( CHOICE sequence ) )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_2);

                        // src/core/koopa/core/grammars/generator/KG.g:126:52: ^( CHOICE sequence )
                        {
                        CommonTree root_3 = (CommonTree)adaptor.nil();
                        root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_3);

                        adaptor.addChild(root_3, stream_sequence.nextTree());

                        adaptor.addChild(root_2, root_3);
                        }

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 127:5: -> { r == null && m != null }? ^( OPTIONAL ^( CHOICE sequence ( more )* ) )
                    if ( r == null && m != null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:127:36: ^( OPTIONAL ^( CHOICE sequence ( more )* ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_1);

                        // src/core/koopa/core/grammars/generator/KG.g:127:47: ^( CHOICE sequence ( more )* )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_2);

                        adaptor.addChild(root_2, stream_sequence.nextTree());
                        // src/core/koopa/core/grammars/generator/KG.g:127:65: ( more )*
                        while ( stream_more.hasNext() ) {
                            adaptor.addChild(root_2, stream_more.nextTree());

                        }
                        stream_more.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 128:5: -> ^( OPTIONAL sequence )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:128:8: ^( OPTIONAL sequence )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_1);

                        adaptor.addChild(root_1, stream_sequence.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 10 :
                    // src/core/koopa/core/grammars/generator/KG.g:130:5: SKIP_TO part
                    {
                    SKIP_TO30=(Token)match(input,SKIP_TO,FOLLOW_SKIP_TO_in_part862);  
                    stream_SKIP_TO.add(SKIP_TO30);

                    pushFollow(FOLLOW_part_in_part864);
                    part31=part();

                    state._fsp--;

                    stream_part.add(part31.getTree());


                    // AST REWRITE
                    // elements: part, SKIP_TO
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 132:5: -> ^( SKIP_TO part )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:132:8: ^( SKIP_TO part )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_SKIP_TO.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_part.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 11 :
                    // src/core/koopa/core/grammars/generator/KG.g:134:5: BANG OPEN_PAREN sequence (m+= more )* CLOSE_PAREN
                    {
                    BANG32=(Token)match(input,BANG,FOLLOW_BANG_in_part888);  
                    stream_BANG.add(BANG32);

                    OPEN_PAREN33=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_part890);  
                    stream_OPEN_PAREN.add(OPEN_PAREN33);

                    pushFollow(FOLLOW_sequence_in_part892);
                    sequence34=sequence();

                    state._fsp--;

                    stream_sequence.add(sequence34.getTree());
                    // src/core/koopa/core/grammars/generator/KG.g:134:31: (m+= more )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==PIPE) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KG.g:134:31: m+= more
                    	    {
                    	    pushFollow(FOLLOW_more_in_part896);
                    	    m=more();

                    	    state._fsp--;

                    	    stream_more.add(m.getTree());
                    	    if (list_m==null) list_m=new ArrayList();
                    	    list_m.add(m.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    CLOSE_PAREN35=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_part899);  
                    stream_CLOSE_PAREN.add(CLOSE_PAREN35);



                    // AST REWRITE
                    // elements: sequence, sequence, more
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 136:5: -> { m == null }? ^( OPTIONAL sequence )
                    if ( m == null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:136:23: ^( OPTIONAL sequence )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_1);

                        adaptor.addChild(root_1, stream_sequence.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 137:5: -> ^( PERMUTED sequence ( more )* )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:137:8: ^( PERMUTED sequence ( more )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PERMUTED, "PERMUTED"), root_1);

                        adaptor.addChild(root_1, stream_sequence.nextTree());
                        // src/core/koopa/core/grammars/generator/KG.g:137:28: ( more )*
                        while ( stream_more.hasNext() ) {
                            adaptor.addChild(root_1, stream_more.nextTree());

                        }
                        stream_more.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 12 :
                    // src/core/koopa/core/grammars/generator/KG.g:139:5: NOT part
                    {
                    NOT36=(Token)match(input,NOT,FOLLOW_NOT_in_part942);  
                    stream_NOT.add(NOT36);

                    pushFollow(FOLLOW_part_in_part944);
                    part37=part();

                    state._fsp--;

                    stream_part.add(part37.getTree());


                    // AST REWRITE
                    // elements: NOT, part
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 140:5: -> ^( NOT part )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:140:8: ^( NOT part )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_NOT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_part.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 13 :
                    // src/core/koopa/core/grammars/generator/KG.g:142:5: NOSKIP part
                    {
                    NOSKIP38=(Token)match(input,NOSKIP,FOLLOW_NOSKIP_in_part963);  
                    stream_NOSKIP.add(NOSKIP38);

                    pushFollow(FOLLOW_part_in_part965);
                    part39=part();

                    state._fsp--;

                    stream_part.add(part39.getTree());


                    // AST REWRITE
                    // elements: NOSKIP, part
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 143:3: -> ^( NOSKIP part )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:143:6: ^( NOSKIP part )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_NOSKIP.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_part.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "part"

    public static class more_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "more"
    // src/core/koopa/core/grammars/generator/KG.g:147:1: more : PIPE sequence -> sequence ;
    public final KGParser.more_return more() throws RecognitionException {
        KGParser.more_return retval = new KGParser.more_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PIPE40=null;
        KGParser.sequence_return sequence41 = null;


        CommonTree PIPE40_tree=null;
        RewriteRuleTokenStream stream_PIPE=new RewriteRuleTokenStream(adaptor,"token PIPE");
        RewriteRuleSubtreeStream stream_sequence=new RewriteRuleSubtreeStream(adaptor,"rule sequence");
        try {
            // src/core/koopa/core/grammars/generator/KG.g:148:3: ( PIPE sequence -> sequence )
            // src/core/koopa/core/grammars/generator/KG.g:148:5: PIPE sequence
            {
            PIPE40=(Token)match(input,PIPE,FOLLOW_PIPE_in_more989);  
            stream_PIPE.add(PIPE40);

            pushFollow(FOLLOW_sequence_in_more991);
            sequence41=sequence();

            state._fsp--;

            stream_sequence.add(sequence41.getTree());


            // AST REWRITE
            // elements: sequence
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 150:5: -> sequence
            {
                adaptor.addChild(root_0, stream_sequence.nextTree());

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "more"

    // Delegated rules


 

    public static final BitSet FOLLOW_meta_in_koopa131 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule_in_koopa140 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_EOF_in_koopa143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_meta174 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_meta178 = new BitSet(new long[]{0x0000200000100000L});
    public static final BitSet FOLLOW_45_in_meta185 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_meta189 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_DOT_in_meta197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule263 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule267 = new BitSet(new long[]{0x0000800000A00000L});
    public static final BitSet FOLLOW_OPEN_PAREN_in_rule276 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_locals_in_rule280 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_CLOSE_PAREN_in_rule282 = new BitSet(new long[]{0x0000800000800000L});
    public static final BitSet FOLLOW_47_in_rule293 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule297 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_EQUALS_in_rule301 = new BitSet(new long[]{0x0000003D3E380000L});
    public static final BitSet FOLLOW_sequence_in_rule312 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_rule321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_locals419 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_COMMA_in_locals422 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_declaration_in_locals424 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration453 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_part_in_sequence485 = new BitSet(new long[]{0x0000003D3E380002L});
    public static final BitSet FOLLOW_NATIVE_CODE_in_part526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TAG_in_part551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANY_in_part558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_part565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_part572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_part583 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_EQUALS_in_part593 = new BitSet(new long[]{0x0000000020180000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_part598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_part604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_part610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_part651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_PAREN_in_part658 = new BitSet(new long[]{0x0000003D3E380000L});
    public static final BitSet FOLLOW_sequence_in_part660 = new BitSet(new long[]{0x0000004000400000L});
    public static final BitSet FOLLOW_more_in_part664 = new BitSet(new long[]{0x0000004000400000L});
    public static final BitSet FOLLOW_CLOSE_PAREN_in_part667 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_STAR_in_part672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_part678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_BRACKET_in_part750 = new BitSet(new long[]{0x0000003D3E380000L});
    public static final BitSet FOLLOW_sequence_in_part752 = new BitSet(new long[]{0x0000004200000000L});
    public static final BitSet FOLLOW_more_in_part756 = new BitSet(new long[]{0x0000004200000000L});
    public static final BitSet FOLLOW_CLOSE_BRACKET_in_part759 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_STAR_in_part764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_part770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SKIP_TO_in_part862 = new BitSet(new long[]{0x0000003D3E380000L});
    public static final BitSet FOLLOW_part_in_part864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_part888 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_OPEN_PAREN_in_part890 = new BitSet(new long[]{0x0000003D3E380000L});
    public static final BitSet FOLLOW_sequence_in_part892 = new BitSet(new long[]{0x0000004000400000L});
    public static final BitSet FOLLOW_more_in_part896 = new BitSet(new long[]{0x0000004000400000L});
    public static final BitSet FOLLOW_CLOSE_PAREN_in_part899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_part942 = new BitSet(new long[]{0x0000003D3E380000L});
    public static final BitSet FOLLOW_part_in_part944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOSKIP_in_part963 = new BitSet(new long[]{0x0000003D3E380000L});
    public static final BitSet FOLLOW_part_in_part965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIPE_in_more989 = new BitSet(new long[]{0x0000003D3E380000L});
    public static final BitSet FOLLOW_sequence_in_more991 = new BitSet(new long[]{0x0000000000000002L});

}