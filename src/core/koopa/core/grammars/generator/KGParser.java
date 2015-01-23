// $ANTLR 3.1.1 src/core/koopa/core/grammars/generator/KG.g 2015-01-23 17:26:03

  package koopa.core.grammars.generator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class KGParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "GRAMMAR", "META", "TREE", "NAMED", "EXTENDING", "RULE", "BODY", "RETURNS", "SEQUENCE", "CHOICE", "OPTIONAL", "ACT", "ASSIGN", "DECLARATION", "LOCALS", "PERMUTED", "IDENTIFIER", "DOT", "OPEN_PAREN", "CLOSE_PAREN", "EQUALS", "COMMA", "NATIVE_CODE", "TAG", "ANY", "LITERAL", "NUMBER", "STAR", "PLUS", "OPEN_BRACKET", "CLOSE_BRACKET", "SKIP_TO", "BANG", "NOT", "NOSKIP", "LIMIT", "BY", "PIPE", "COMMENT", "NEWLINE", "LETTER", "DIGIT", "WHITESPACE", "'tree'", "'grammar'", "'extends'", "'def'", "'returns'", "'end'"
    };
    public static final int SKIP_TO=35;
    public static final int STAR=31;
    public static final int LETTER=44;
    public static final int LIMIT=39;
    public static final int EQUALS=24;
    public static final int NOT=37;
    public static final int NOSKIP=38;
    public static final int EOF=-1;
    public static final int DECLARATION=17;
    public static final int META=5;
    public static final int OPEN_BRACKET=33;
    public static final int T__51=51;
    public static final int NATIVE_CODE=26;
    public static final int T__52=52;
    public static final int TREE=6;
    public static final int EXTENDING=8;
    public static final int COMMA=25;
    public static final int IDENTIFIER=20;
    public static final int PIPE=41;
    public static final int PLUS=32;
    public static final int BODY=10;
    public static final int CLOSE_PAREN=23;
    public static final int DIGIT=45;
    public static final int COMMENT=42;
    public static final int DOT=21;
    public static final int T__50=50;
    public static final int GRAMMAR=4;
    public static final int CHOICE=13;
    public static final int RETURNS=11;
    public static final int BY=40;
    public static final int ACT=15;
    public static final int LOCALS=18;
    public static final int T__47=47;
    public static final int RULE=9;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int NUMBER=30;
    public static final int WHITESPACE=46;
    public static final int OPEN_PAREN=22;
    public static final int LITERAL=29;
    public static final int BANG=36;
    public static final int OPTIONAL=14;
    public static final int TAG=27;
    public static final int SEQUENCE=12;
    public static final int ANY=28;
    public static final int NEWLINE=43;
    public static final int NAMED=7;
    public static final int ASSIGN=16;
    public static final int PERMUTED=19;
    public static final int CLOSE_BRACKET=34;

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
    // src/core/koopa/core/grammars/generator/KG.g:41:1: koopa : meta ( rule )* EOF -> ^( GRAMMAR meta ( rule )* ) ;
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
            // src/core/koopa/core/grammars/generator/KG.g:42:3: ( meta ( rule )* EOF -> ^( GRAMMAR meta ( rule )* ) )
            // src/core/koopa/core/grammars/generator/KG.g:42:5: meta ( rule )* EOF
            {
            pushFollow(FOLLOW_meta_in_koopa136);
            meta1=meta();

            state._fsp--;

            stream_meta.add(meta1.getTree());
            // src/core/koopa/core/grammars/generator/KG.g:44:5: ( rule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==50) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:44:5: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_koopa145);
            	    rule2=rule();

            	    state._fsp--;

            	    stream_rule.add(rule2.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_koopa148);  
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
            // 46:5: -> ^( GRAMMAR meta ( rule )* )
            {
                // src/core/koopa/core/grammars/generator/KG.g:46:8: ^( GRAMMAR meta ( rule )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(GRAMMAR, "GRAMMAR"), root_1);

                adaptor.addChild(root_1, stream_meta.nextTree());
                // src/core/koopa/core/grammars/generator/KG.g:46:23: ( rule )*
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
    // src/core/koopa/core/grammars/generator/KG.g:49:1: meta : (t= 'tree' )? 'grammar' n= IDENTIFIER ( 'extends' s= IDENTIFIER )? DOT -> { t == null && s == null }? ^( META ^( NAMED $n) ) -> { t == null && s != null }? ^( META ^( NAMED $n) ^( EXTENDING $s) ) -> { t != null && s == null }? ^( META TREE ^( NAMED $n) ) -> ^( META TREE ^( NAMED $n) ^( EXTENDING $s) ) ;
    public final KGParser.meta_return meta() throws RecognitionException {
        KGParser.meta_return retval = new KGParser.meta_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token t=null;
        Token n=null;
        Token s=null;
        Token string_literal4=null;
        Token string_literal5=null;
        Token DOT6=null;

        CommonTree t_tree=null;
        CommonTree n_tree=null;
        CommonTree s_tree=null;
        CommonTree string_literal4_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree DOT6_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/core/koopa/core/grammars/generator/KG.g:50:3: ( (t= 'tree' )? 'grammar' n= IDENTIFIER ( 'extends' s= IDENTIFIER )? DOT -> { t == null && s == null }? ^( META ^( NAMED $n) ) -> { t == null && s != null }? ^( META ^( NAMED $n) ^( EXTENDING $s) ) -> { t != null && s == null }? ^( META TREE ^( NAMED $n) ) -> ^( META TREE ^( NAMED $n) ^( EXTENDING $s) ) )
            // src/core/koopa/core/grammars/generator/KG.g:50:5: (t= 'tree' )? 'grammar' n= IDENTIFIER ( 'extends' s= IDENTIFIER )? DOT
            {
            // src/core/koopa/core/grammars/generator/KG.g:50:5: (t= 'tree' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==47) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KG.g:50:6: t= 'tree'
                    {
                    t=(Token)match(input,47,FOLLOW_47_in_meta182);  
                    stream_47.add(t);


                    }
                    break;

            }

            string_literal4=(Token)match(input,48,FOLLOW_48_in_meta186);  
            stream_48.add(string_literal4);

            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_meta190);  
            stream_IDENTIFIER.add(n);

            // src/core/koopa/core/grammars/generator/KG.g:51:5: ( 'extends' s= IDENTIFIER )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==49) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KG.g:51:6: 'extends' s= IDENTIFIER
                    {
                    string_literal5=(Token)match(input,49,FOLLOW_49_in_meta197);  
                    stream_49.add(string_literal5);

                    s=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_meta201);  
                    stream_IDENTIFIER.add(s);


                    }
                    break;

            }

            DOT6=(Token)match(input,DOT,FOLLOW_DOT_in_meta209);  
            stream_DOT.add(DOT6);



            // AST REWRITE
            // elements: n, s, s, n, n, n
            // token labels: s, n
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            RewriteRuleTokenStream stream_n=new RewriteRuleTokenStream(adaptor,"token n",n);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 54:5: -> { t == null && s == null }? ^( META ^( NAMED $n) )
            if ( t == null && s == null ) {
                // src/core/koopa/core/grammars/generator/KG.g:54:36: ^( META ^( NAMED $n) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(META, "META"), root_1);

                // src/core/koopa/core/grammars/generator/KG.g:54:43: ^( NAMED $n)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED, "NAMED"), root_2);

                adaptor.addChild(root_2, stream_n.nextNode());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 55:5: -> { t == null && s != null }? ^( META ^( NAMED $n) ^( EXTENDING $s) )
            if ( t == null && s != null ) {
                // src/core/koopa/core/grammars/generator/KG.g:55:36: ^( META ^( NAMED $n) ^( EXTENDING $s) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(META, "META"), root_1);

                // src/core/koopa/core/grammars/generator/KG.g:55:43: ^( NAMED $n)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED, "NAMED"), root_2);

                adaptor.addChild(root_2, stream_n.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                // src/core/koopa/core/grammars/generator/KG.g:55:55: ^( EXTENDING $s)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXTENDING, "EXTENDING"), root_2);

                adaptor.addChild(root_2, stream_s.nextNode());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 56:5: -> { t != null && s == null }? ^( META TREE ^( NAMED $n) )
            if ( t != null && s == null ) {
                // src/core/koopa/core/grammars/generator/KG.g:56:36: ^( META TREE ^( NAMED $n) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(META, "META"), root_1);

                adaptor.addChild(root_1, (CommonTree)adaptor.create(TREE, "TREE"));
                // src/core/koopa/core/grammars/generator/KG.g:56:48: ^( NAMED $n)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED, "NAMED"), root_2);

                adaptor.addChild(root_2, stream_n.nextNode());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 57:5: -> ^( META TREE ^( NAMED $n) ^( EXTENDING $s) )
            {
                // src/core/koopa/core/grammars/generator/KG.g:57:8: ^( META TREE ^( NAMED $n) ^( EXTENDING $s) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(META, "META"), root_1);

                adaptor.addChild(root_1, (CommonTree)adaptor.create(TREE, "TREE"));
                // src/core/koopa/core/grammars/generator/KG.g:57:20: ^( NAMED $n)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED, "NAMED"), root_2);

                adaptor.addChild(root_2, stream_n.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                // src/core/koopa/core/grammars/generator/KG.g:57:32: ^( EXTENDING $s)
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
    // src/core/koopa/core/grammars/generator/KG.g:60:1: rule : 'def' i= IDENTIFIER ( OPEN_PAREN l= locals CLOSE_PAREN )? ( 'returns' r= IDENTIFIER )? EQUALS sequence 'end' -> { l != null && r != null }? ^( RULE $i locals ^( RETURNS $r) sequence ) -> { l != null && r == null }? ^( RULE $i locals sequence ) -> { l == null && r != null }? ^( RULE $i ^( RETURNS $r) sequence ) -> ^( RULE $i sequence ) ;
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
        RewriteRuleTokenStream stream_OPEN_PAREN=new RewriteRuleTokenStream(adaptor,"token OPEN_PAREN");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_CLOSE_PAREN=new RewriteRuleTokenStream(adaptor,"token CLOSE_PAREN");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_locals=new RewriteRuleSubtreeStream(adaptor,"rule locals");
        RewriteRuleSubtreeStream stream_sequence=new RewriteRuleSubtreeStream(adaptor,"rule sequence");
        try {
            // src/core/koopa/core/grammars/generator/KG.g:61:3: ( 'def' i= IDENTIFIER ( OPEN_PAREN l= locals CLOSE_PAREN )? ( 'returns' r= IDENTIFIER )? EQUALS sequence 'end' -> { l != null && r != null }? ^( RULE $i locals ^( RETURNS $r) sequence ) -> { l != null && r == null }? ^( RULE $i locals sequence ) -> { l == null && r != null }? ^( RULE $i ^( RETURNS $r) sequence ) -> ^( RULE $i sequence ) )
            // src/core/koopa/core/grammars/generator/KG.g:61:5: 'def' i= IDENTIFIER ( OPEN_PAREN l= locals CLOSE_PAREN )? ( 'returns' r= IDENTIFIER )? EQUALS sequence 'end'
            {
            string_literal7=(Token)match(input,50,FOLLOW_50_in_rule319);  
            stream_50.add(string_literal7);

            i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule323);  
            stream_IDENTIFIER.add(i);

            // src/core/koopa/core/grammars/generator/KG.g:62:7: ( OPEN_PAREN l= locals CLOSE_PAREN )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==OPEN_PAREN) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KG.g:62:8: OPEN_PAREN l= locals CLOSE_PAREN
                    {
                    OPEN_PAREN8=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_rule332);  
                    stream_OPEN_PAREN.add(OPEN_PAREN8);

                    pushFollow(FOLLOW_locals_in_rule336);
                    l=locals();

                    state._fsp--;

                    stream_locals.add(l.getTree());
                    CLOSE_PAREN9=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_rule338);  
                    stream_CLOSE_PAREN.add(CLOSE_PAREN9);


                    }
                    break;

            }

            // src/core/koopa/core/grammars/generator/KG.g:63:7: ( 'returns' r= IDENTIFIER )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==51) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KG.g:63:8: 'returns' r= IDENTIFIER
                    {
                    string_literal10=(Token)match(input,51,FOLLOW_51_in_rule349);  
                    stream_51.add(string_literal10);

                    r=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule353);  
                    stream_IDENTIFIER.add(r);


                    }
                    break;

            }

            EQUALS11=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_rule357);  
            stream_EQUALS.add(EQUALS11);

            pushFollow(FOLLOW_sequence_in_rule368);
            sequence12=sequence();

            state._fsp--;

            stream_sequence.add(sequence12.getTree());
            string_literal13=(Token)match(input,52,FOLLOW_52_in_rule377);  
            stream_52.add(string_literal13);



            // AST REWRITE
            // elements: r, sequence, sequence, i, i, r, i, sequence, i, locals, locals, sequence
            // token labels: r, i
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
            RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 69:5: -> { l != null && r != null }? ^( RULE $i locals ^( RETURNS $r) sequence )
            if ( l != null && r != null ) {
                // src/core/koopa/core/grammars/generator/KG.g:69:36: ^( RULE $i locals ^( RETURNS $r) sequence )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);

                adaptor.addChild(root_1, stream_i.nextNode());
                adaptor.addChild(root_1, stream_locals.nextTree());
                // src/core/koopa/core/grammars/generator/KG.g:69:53: ^( RETURNS $r)
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
            else // 70:5: -> { l != null && r == null }? ^( RULE $i locals sequence )
            if ( l != null && r == null ) {
                // src/core/koopa/core/grammars/generator/KG.g:70:36: ^( RULE $i locals sequence )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);

                adaptor.addChild(root_1, stream_i.nextNode());
                adaptor.addChild(root_1, stream_locals.nextTree());
                adaptor.addChild(root_1, stream_sequence.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 71:5: -> { l == null && r != null }? ^( RULE $i ^( RETURNS $r) sequence )
            if ( l == null && r != null ) {
                // src/core/koopa/core/grammars/generator/KG.g:71:36: ^( RULE $i ^( RETURNS $r) sequence )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);

                adaptor.addChild(root_1, stream_i.nextNode());
                // src/core/koopa/core/grammars/generator/KG.g:71:46: ^( RETURNS $r)
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
            else // 72:5: -> ^( RULE $i sequence )
            {
                // src/core/koopa/core/grammars/generator/KG.g:72:8: ^( RULE $i sequence )
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
    // src/core/koopa/core/grammars/generator/KG.g:75:1: locals : declaration ( COMMA declaration )* -> ^( LOCALS ( declaration )+ ) ;
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
            // src/core/koopa/core/grammars/generator/KG.g:76:3: ( declaration ( COMMA declaration )* -> ^( LOCALS ( declaration )+ ) )
            // src/core/koopa/core/grammars/generator/KG.g:76:5: declaration ( COMMA declaration )*
            {
            pushFollow(FOLLOW_declaration_in_locals475);
            declaration14=declaration();

            state._fsp--;

            stream_declaration.add(declaration14.getTree());
            // src/core/koopa/core/grammars/generator/KG.g:76:17: ( COMMA declaration )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==COMMA) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:76:18: COMMA declaration
            	    {
            	    COMMA15=(Token)match(input,COMMA,FOLLOW_COMMA_in_locals478);  
            	    stream_COMMA.add(COMMA15);

            	    pushFollow(FOLLOW_declaration_in_locals480);
            	    declaration16=declaration();

            	    state._fsp--;

            	    stream_declaration.add(declaration16.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
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
            // 78:5: -> ^( LOCALS ( declaration )+ )
            {
                // src/core/koopa/core/grammars/generator/KG.g:78:8: ^( LOCALS ( declaration )+ )
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
    // src/core/koopa/core/grammars/generator/KG.g:81:1: declaration : IDENTIFIER IDENTIFIER -> ^( DECLARATION IDENTIFIER IDENTIFIER ) ;
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
            // src/core/koopa/core/grammars/generator/KG.g:82:3: ( IDENTIFIER IDENTIFIER -> ^( DECLARATION IDENTIFIER IDENTIFIER ) )
            // src/core/koopa/core/grammars/generator/KG.g:82:5: IDENTIFIER IDENTIFIER
            {
            IDENTIFIER17=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration509);  
            stream_IDENTIFIER.add(IDENTIFIER17);

            IDENTIFIER18=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration511);  
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
            // 84:5: -> ^( DECLARATION IDENTIFIER IDENTIFIER )
            {
                // src/core/koopa/core/grammars/generator/KG.g:84:8: ^( DECLARATION IDENTIFIER IDENTIFIER )
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
    // src/core/koopa/core/grammars/generator/KG.g:87:1: sequence : (p+= part )+ -> { $p.size() > 1 }? ^( SEQUENCE ( part )+ ) -> ( part )+ ;
    public final KGParser.sequence_return sequence() throws RecognitionException {
        KGParser.sequence_return retval = new KGParser.sequence_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        List list_p=null;
        RuleReturnScope p = null;
        RewriteRuleSubtreeStream stream_part=new RewriteRuleSubtreeStream(adaptor,"rule part");
        try {
            // src/core/koopa/core/grammars/generator/KG.g:88:3: ( (p+= part )+ -> { $p.size() > 1 }? ^( SEQUENCE ( part )+ ) -> ( part )+ )
            // src/core/koopa/core/grammars/generator/KG.g:88:5: (p+= part )+
            {
            // src/core/koopa/core/grammars/generator/KG.g:88:6: (p+= part )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=IDENTIFIER && LA7_0<=OPEN_PAREN)||(LA7_0>=NATIVE_CODE && LA7_0<=NUMBER)||LA7_0==OPEN_BRACKET||(LA7_0>=SKIP_TO && LA7_0<=LIMIT)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:88:6: p+= part
            	    {
            	    pushFollow(FOLLOW_part_in_sequence541);
            	    p=part();

            	    state._fsp--;

            	    stream_part.add(p.getTree());
            	    if (list_p==null) list_p=new ArrayList();
            	    list_p.add(p.getTree());


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



            // AST REWRITE
            // elements: part, part
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 90:5: -> { $p.size() > 1 }? ^( SEQUENCE ( part )+ )
            if ( list_p.size() > 1 ) {
                // src/core/koopa/core/grammars/generator/KG.g:90:27: ^( SEQUENCE ( part )+ )
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
            else // 91:5: -> ( part )+
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
    // src/core/koopa/core/grammars/generator/KG.g:94:1: part : (code= NATIVE_CODE -> ^( ACT NATIVE_CODE ) | TAG | ANY | LITERAL | NUMBER | a= IDENTIFIER (e= EQUALS (b= IDENTIFIER | b= NUMBER | b= DOT | b= ANY ) )? -> { e != null }? ^( ASSIGN $a $b) -> IDENTIFIER | DOT | OPEN_PAREN sequence (m+= more )* CLOSE_PAREN (r= STAR | r= PLUS )? -> { r != null && m != null }? ^( $r ^( CHOICE sequence ( more )* ) ) -> { r != null && m == null }? ^( $r sequence ) -> { r == null && m != null }? ^( CHOICE sequence ( more )* ) -> sequence | OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET (r= STAR | r= PLUS )? -> { r != null && m != null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) ) -> { r != null && m == null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) ) -> { r == null && m != null }? ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) -> ^( OPTIONAL sequence ) | SKIP_TO part -> ^( SKIP_TO part ) | BANG OPEN_PAREN sequence (m+= more )* CLOSE_PAREN -> { m == null }? ^( OPTIONAL sequence ) -> ^( PERMUTED sequence ( more )* ) | NOT part -> ^( NOT part ) | NOSKIP part -> ^( NOSKIP part ) | LIMIT part BY part -> ^( LIMIT part part ) );
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
        Token LIMIT40=null;
        Token BY42=null;
        List list_m=null;
        KGParser.sequence_return sequence25 = null;

        KGParser.sequence_return sequence28 = null;

        KGParser.part_return part31 = null;

        KGParser.sequence_return sequence34 = null;

        KGParser.part_return part37 = null;

        KGParser.part_return part39 = null;

        KGParser.part_return part41 = null;

        KGParser.part_return part43 = null;

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
        CommonTree LIMIT40_tree=null;
        CommonTree BY42_tree=null;
        RewriteRuleTokenStream stream_SKIP_TO=new RewriteRuleTokenStream(adaptor,"token SKIP_TO");
        RewriteRuleTokenStream stream_OPEN_BRACKET=new RewriteRuleTokenStream(adaptor,"token OPEN_BRACKET");
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_NATIVE_CODE=new RewriteRuleTokenStream(adaptor,"token NATIVE_CODE");
        RewriteRuleTokenStream stream_ANY=new RewriteRuleTokenStream(adaptor,"token ANY");
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_LIMIT=new RewriteRuleTokenStream(adaptor,"token LIMIT");
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
            // src/core/koopa/core/grammars/generator/KG.g:95:3: (code= NATIVE_CODE -> ^( ACT NATIVE_CODE ) | TAG | ANY | LITERAL | NUMBER | a= IDENTIFIER (e= EQUALS (b= IDENTIFIER | b= NUMBER | b= DOT | b= ANY ) )? -> { e != null }? ^( ASSIGN $a $b) -> IDENTIFIER | DOT | OPEN_PAREN sequence (m+= more )* CLOSE_PAREN (r= STAR | r= PLUS )? -> { r != null && m != null }? ^( $r ^( CHOICE sequence ( more )* ) ) -> { r != null && m == null }? ^( $r sequence ) -> { r == null && m != null }? ^( CHOICE sequence ( more )* ) -> sequence | OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET (r= STAR | r= PLUS )? -> { r != null && m != null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) ) -> { r != null && m == null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) ) -> { r == null && m != null }? ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) -> ^( OPTIONAL sequence ) | SKIP_TO part -> ^( SKIP_TO part ) | BANG OPEN_PAREN sequence (m+= more )* CLOSE_PAREN -> { m == null }? ^( OPTIONAL sequence ) -> ^( PERMUTED sequence ( more )* ) | NOT part -> ^( NOT part ) | NOSKIP part -> ^( NOSKIP part ) | LIMIT part BY part -> ^( LIMIT part part ) )
            int alt15=14;
            switch ( input.LA(1) ) {
            case NATIVE_CODE:
                {
                alt15=1;
                }
                break;
            case TAG:
                {
                alt15=2;
                }
                break;
            case ANY:
                {
                alt15=3;
                }
                break;
            case LITERAL:
                {
                alt15=4;
                }
                break;
            case NUMBER:
                {
                alt15=5;
                }
                break;
            case IDENTIFIER:
                {
                alt15=6;
                }
                break;
            case DOT:
                {
                alt15=7;
                }
                break;
            case OPEN_PAREN:
                {
                alt15=8;
                }
                break;
            case OPEN_BRACKET:
                {
                alt15=9;
                }
                break;
            case SKIP_TO:
                {
                alt15=10;
                }
                break;
            case BANG:
                {
                alt15=11;
                }
                break;
            case NOT:
                {
                alt15=12;
                }
                break;
            case NOSKIP:
                {
                alt15=13;
                }
                break;
            case LIMIT:
                {
                alt15=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KG.g:95:5: code= NATIVE_CODE
                    {
                    code=(Token)match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_part582);  
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
                    // 100:5: -> ^( ACT NATIVE_CODE )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:100:8: ^( ACT NATIVE_CODE )
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
                    // src/core/koopa/core/grammars/generator/KG.g:102:5: TAG
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    TAG19=(Token)match(input,TAG,FOLLOW_TAG_in_part607); 
                    TAG19_tree = (CommonTree)adaptor.create(TAG19);
                    adaptor.addChild(root_0, TAG19_tree);


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/grammars/generator/KG.g:104:5: ANY
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ANY20=(Token)match(input,ANY,FOLLOW_ANY_in_part614); 
                    ANY20_tree = (CommonTree)adaptor.create(ANY20);
                    adaptor.addChild(root_0, ANY20_tree);


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/grammars/generator/KG.g:106:5: LITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LITERAL21=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_part621); 
                    LITERAL21_tree = (CommonTree)adaptor.create(LITERAL21);
                    adaptor.addChild(root_0, LITERAL21_tree);


                    }
                    break;
                case 5 :
                    // src/core/koopa/core/grammars/generator/KG.g:108:5: NUMBER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NUMBER22=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_part628); 
                    NUMBER22_tree = (CommonTree)adaptor.create(NUMBER22);
                    adaptor.addChild(root_0, NUMBER22_tree);


                    }
                    break;
                case 6 :
                    // src/core/koopa/core/grammars/generator/KG.g:110:5: a= IDENTIFIER (e= EQUALS (b= IDENTIFIER | b= NUMBER | b= DOT | b= ANY ) )?
                    {
                    a=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_part639);  
                    stream_IDENTIFIER.add(a);

                    // src/core/koopa/core/grammars/generator/KG.g:111:5: (e= EQUALS (b= IDENTIFIER | b= NUMBER | b= DOT | b= ANY ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==EQUALS) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // src/core/koopa/core/grammars/generator/KG.g:111:6: e= EQUALS (b= IDENTIFIER | b= NUMBER | b= DOT | b= ANY )
                            {
                            e=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_part649);  
                            stream_EQUALS.add(e);

                            // src/core/koopa/core/grammars/generator/KG.g:111:15: (b= IDENTIFIER | b= NUMBER | b= DOT | b= ANY )
                            int alt8=4;
                            switch ( input.LA(1) ) {
                            case IDENTIFIER:
                                {
                                alt8=1;
                                }
                                break;
                            case NUMBER:
                                {
                                alt8=2;
                                }
                                break;
                            case DOT:
                                {
                                alt8=3;
                                }
                                break;
                            case ANY:
                                {
                                alt8=4;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 8, 0, input);

                                throw nvae;
                            }

                            switch (alt8) {
                                case 1 :
                                    // src/core/koopa/core/grammars/generator/KG.g:111:16: b= IDENTIFIER
                                    {
                                    b=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_part654);  
                                    stream_IDENTIFIER.add(b);


                                    }
                                    break;
                                case 2 :
                                    // src/core/koopa/core/grammars/generator/KG.g:111:31: b= NUMBER
                                    {
                                    b=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_part660);  
                                    stream_NUMBER.add(b);


                                    }
                                    break;
                                case 3 :
                                    // src/core/koopa/core/grammars/generator/KG.g:111:42: b= DOT
                                    {
                                    b=(Token)match(input,DOT,FOLLOW_DOT_in_part666);  
                                    stream_DOT.add(b);


                                    }
                                    break;
                                case 4 :
                                    // src/core/koopa/core/grammars/generator/KG.g:111:50: b= ANY
                                    {
                                    b=(Token)match(input,ANY,FOLLOW_ANY_in_part672);  
                                    stream_ANY.add(b);


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
                    // 113:5: -> { e != null }? ^( ASSIGN $a $b)
                    if ( e != null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:113:23: ^( ASSIGN $a $b)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGN, "ASSIGN"), root_1);

                        adaptor.addChild(root_1, stream_a.nextNode());
                        adaptor.addChild(root_1, stream_b.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 114:5: -> IDENTIFIER
                    {
                        adaptor.addChild(root_0, stream_IDENTIFIER.nextNode());

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 7 :
                    // src/core/koopa/core/grammars/generator/KG.g:116:5: DOT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DOT23=(Token)match(input,DOT,FOLLOW_DOT_in_part713); 
                    DOT23_tree = (CommonTree)adaptor.create(DOT23);
                    adaptor.addChild(root_0, DOT23_tree);


                    }
                    break;
                case 8 :
                    // src/core/koopa/core/grammars/generator/KG.g:118:5: OPEN_PAREN sequence (m+= more )* CLOSE_PAREN (r= STAR | r= PLUS )?
                    {
                    OPEN_PAREN24=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_part720);  
                    stream_OPEN_PAREN.add(OPEN_PAREN24);

                    pushFollow(FOLLOW_sequence_in_part722);
                    sequence25=sequence();

                    state._fsp--;

                    stream_sequence.add(sequence25.getTree());
                    // src/core/koopa/core/grammars/generator/KG.g:118:26: (m+= more )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==PIPE) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KG.g:118:26: m+= more
                    	    {
                    	    pushFollow(FOLLOW_more_in_part726);
                    	    m=more();

                    	    state._fsp--;

                    	    stream_more.add(m.getTree());
                    	    if (list_m==null) list_m=new ArrayList();
                    	    list_m.add(m.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    CLOSE_PAREN26=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_part729);  
                    stream_CLOSE_PAREN.add(CLOSE_PAREN26);

                    // src/core/koopa/core/grammars/generator/KG.g:118:46: (r= STAR | r= PLUS )?
                    int alt11=3;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==STAR) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==PLUS) ) {
                        alt11=2;
                    }
                    switch (alt11) {
                        case 1 :
                            // src/core/koopa/core/grammars/generator/KG.g:118:47: r= STAR
                            {
                            r=(Token)match(input,STAR,FOLLOW_STAR_in_part734);  
                            stream_STAR.add(r);


                            }
                            break;
                        case 2 :
                            // src/core/koopa/core/grammars/generator/KG.g:118:56: r= PLUS
                            {
                            r=(Token)match(input,PLUS,FOLLOW_PLUS_in_part740);  
                            stream_PLUS.add(r);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: more, sequence, more, r, sequence, sequence, sequence, r
                    // token labels: r
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 120:5: -> { r != null && m != null }? ^( $r ^( CHOICE sequence ( more )* ) )
                    if ( r != null && m != null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:120:36: ^( $r ^( CHOICE sequence ( more )* ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);

                        // src/core/koopa/core/grammars/generator/KG.g:120:41: ^( CHOICE sequence ( more )* )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_2);

                        adaptor.addChild(root_2, stream_sequence.nextTree());
                        // src/core/koopa/core/grammars/generator/KG.g:120:59: ( more )*
                        while ( stream_more.hasNext() ) {
                            adaptor.addChild(root_2, stream_more.nextTree());

                        }
                        stream_more.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 121:5: -> { r != null && m == null }? ^( $r sequence )
                    if ( r != null && m == null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:121:36: ^( $r sequence )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_sequence.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 122:5: -> { r == null && m != null }? ^( CHOICE sequence ( more )* )
                    if ( r == null && m != null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:122:36: ^( CHOICE sequence ( more )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_1);

                        adaptor.addChild(root_1, stream_sequence.nextTree());
                        // src/core/koopa/core/grammars/generator/KG.g:122:54: ( more )*
                        while ( stream_more.hasNext() ) {
                            adaptor.addChild(root_1, stream_more.nextTree());

                        }
                        stream_more.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 123:5: -> sequence
                    {
                        adaptor.addChild(root_0, stream_sequence.nextTree());

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 9 :
                    // src/core/koopa/core/grammars/generator/KG.g:125:5: OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET (r= STAR | r= PLUS )?
                    {
                    OPEN_BRACKET27=(Token)match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_part812);  
                    stream_OPEN_BRACKET.add(OPEN_BRACKET27);

                    pushFollow(FOLLOW_sequence_in_part814);
                    sequence28=sequence();

                    state._fsp--;

                    stream_sequence.add(sequence28.getTree());
                    // src/core/koopa/core/grammars/generator/KG.g:125:28: (m+= more )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==PIPE) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KG.g:125:28: m+= more
                    	    {
                    	    pushFollow(FOLLOW_more_in_part818);
                    	    m=more();

                    	    state._fsp--;

                    	    stream_more.add(m.getTree());
                    	    if (list_m==null) list_m=new ArrayList();
                    	    list_m.add(m.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    CLOSE_BRACKET29=(Token)match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_part821);  
                    stream_CLOSE_BRACKET.add(CLOSE_BRACKET29);

                    // src/core/koopa/core/grammars/generator/KG.g:125:50: (r= STAR | r= PLUS )?
                    int alt13=3;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==STAR) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==PLUS) ) {
                        alt13=2;
                    }
                    switch (alt13) {
                        case 1 :
                            // src/core/koopa/core/grammars/generator/KG.g:125:51: r= STAR
                            {
                            r=(Token)match(input,STAR,FOLLOW_STAR_in_part826);  
                            stream_STAR.add(r);


                            }
                            break;
                        case 2 :
                            // src/core/koopa/core/grammars/generator/KG.g:125:60: r= PLUS
                            {
                            r=(Token)match(input,PLUS,FOLLOW_PLUS_in_part832);  
                            stream_PLUS.add(r);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: r, sequence, sequence, r, more, more, sequence, sequence
                    // token labels: r
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 127:5: -> { r != null && m != null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) )
                    if ( r != null && m != null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:127:36: ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);

                        // src/core/koopa/core/grammars/generator/KG.g:127:41: ^( OPTIONAL ^( CHOICE sequence ( more )* ) )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_2);

                        // src/core/koopa/core/grammars/generator/KG.g:127:52: ^( CHOICE sequence ( more )* )
                        {
                        CommonTree root_3 = (CommonTree)adaptor.nil();
                        root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_3);

                        adaptor.addChild(root_3, stream_sequence.nextTree());
                        // src/core/koopa/core/grammars/generator/KG.g:127:70: ( more )*
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
                    else // 128:5: -> { r != null && m == null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) )
                    if ( r != null && m == null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:128:36: ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);

                        // src/core/koopa/core/grammars/generator/KG.g:128:41: ^( OPTIONAL ^( CHOICE sequence ) )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_2);

                        // src/core/koopa/core/grammars/generator/KG.g:128:52: ^( CHOICE sequence )
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
                    else // 129:5: -> { r == null && m != null }? ^( OPTIONAL ^( CHOICE sequence ( more )* ) )
                    if ( r == null && m != null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:129:36: ^( OPTIONAL ^( CHOICE sequence ( more )* ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_1);

                        // src/core/koopa/core/grammars/generator/KG.g:129:47: ^( CHOICE sequence ( more )* )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_2);

                        adaptor.addChild(root_2, stream_sequence.nextTree());
                        // src/core/koopa/core/grammars/generator/KG.g:129:65: ( more )*
                        while ( stream_more.hasNext() ) {
                            adaptor.addChild(root_2, stream_more.nextTree());

                        }
                        stream_more.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 130:5: -> ^( OPTIONAL sequence )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:130:8: ^( OPTIONAL sequence )
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
                    // src/core/koopa/core/grammars/generator/KG.g:132:5: SKIP_TO part
                    {
                    SKIP_TO30=(Token)match(input,SKIP_TO,FOLLOW_SKIP_TO_in_part924);  
                    stream_SKIP_TO.add(SKIP_TO30);

                    pushFollow(FOLLOW_part_in_part926);
                    part31=part();

                    state._fsp--;

                    stream_part.add(part31.getTree());


                    // AST REWRITE
                    // elements: SKIP_TO, part
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 134:5: -> ^( SKIP_TO part )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:134:8: ^( SKIP_TO part )
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
                    // src/core/koopa/core/grammars/generator/KG.g:136:5: BANG OPEN_PAREN sequence (m+= more )* CLOSE_PAREN
                    {
                    BANG32=(Token)match(input,BANG,FOLLOW_BANG_in_part950);  
                    stream_BANG.add(BANG32);

                    OPEN_PAREN33=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_part952);  
                    stream_OPEN_PAREN.add(OPEN_PAREN33);

                    pushFollow(FOLLOW_sequence_in_part954);
                    sequence34=sequence();

                    state._fsp--;

                    stream_sequence.add(sequence34.getTree());
                    // src/core/koopa/core/grammars/generator/KG.g:136:31: (m+= more )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==PIPE) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KG.g:136:31: m+= more
                    	    {
                    	    pushFollow(FOLLOW_more_in_part958);
                    	    m=more();

                    	    state._fsp--;

                    	    stream_more.add(m.getTree());
                    	    if (list_m==null) list_m=new ArrayList();
                    	    list_m.add(m.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    CLOSE_PAREN35=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_part961);  
                    stream_CLOSE_PAREN.add(CLOSE_PAREN35);



                    // AST REWRITE
                    // elements: sequence, more, sequence
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 138:5: -> { m == null }? ^( OPTIONAL sequence )
                    if ( m == null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:138:23: ^( OPTIONAL sequence )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_1);

                        adaptor.addChild(root_1, stream_sequence.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 139:5: -> ^( PERMUTED sequence ( more )* )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:139:8: ^( PERMUTED sequence ( more )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PERMUTED, "PERMUTED"), root_1);

                        adaptor.addChild(root_1, stream_sequence.nextTree());
                        // src/core/koopa/core/grammars/generator/KG.g:139:28: ( more )*
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
                    // src/core/koopa/core/grammars/generator/KG.g:141:5: NOT part
                    {
                    NOT36=(Token)match(input,NOT,FOLLOW_NOT_in_part1004);  
                    stream_NOT.add(NOT36);

                    pushFollow(FOLLOW_part_in_part1006);
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
                    // 142:5: -> ^( NOT part )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:142:8: ^( NOT part )
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
                    // src/core/koopa/core/grammars/generator/KG.g:144:5: NOSKIP part
                    {
                    NOSKIP38=(Token)match(input,NOSKIP,FOLLOW_NOSKIP_in_part1025);  
                    stream_NOSKIP.add(NOSKIP38);

                    pushFollow(FOLLOW_part_in_part1027);
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
                    // 145:3: -> ^( NOSKIP part )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:145:6: ^( NOSKIP part )
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
                case 14 :
                    // src/core/koopa/core/grammars/generator/KG.g:147:5: LIMIT part BY part
                    {
                    LIMIT40=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_part1044);  
                    stream_LIMIT.add(LIMIT40);

                    pushFollow(FOLLOW_part_in_part1046);
                    part41=part();

                    state._fsp--;

                    stream_part.add(part41.getTree());
                    BY42=(Token)match(input,BY,FOLLOW_BY_in_part1048);  
                    stream_BY.add(BY42);

                    pushFollow(FOLLOW_part_in_part1050);
                    part43=part();

                    state._fsp--;

                    stream_part.add(part43.getTree());


                    // AST REWRITE
                    // elements: part, part, LIMIT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 148:3: -> ^( LIMIT part part )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:148:6: ^( LIMIT part part )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_LIMIT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_part.nextTree());
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
    // src/core/koopa/core/grammars/generator/KG.g:152:1: more : PIPE sequence -> sequence ;
    public final KGParser.more_return more() throws RecognitionException {
        KGParser.more_return retval = new KGParser.more_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PIPE44=null;
        KGParser.sequence_return sequence45 = null;


        CommonTree PIPE44_tree=null;
        RewriteRuleTokenStream stream_PIPE=new RewriteRuleTokenStream(adaptor,"token PIPE");
        RewriteRuleSubtreeStream stream_sequence=new RewriteRuleSubtreeStream(adaptor,"rule sequence");
        try {
            // src/core/koopa/core/grammars/generator/KG.g:153:3: ( PIPE sequence -> sequence )
            // src/core/koopa/core/grammars/generator/KG.g:153:5: PIPE sequence
            {
            PIPE44=(Token)match(input,PIPE,FOLLOW_PIPE_in_more1076);  
            stream_PIPE.add(PIPE44);

            pushFollow(FOLLOW_sequence_in_more1078);
            sequence45=sequence();

            state._fsp--;

            stream_sequence.add(sequence45.getTree());


            // AST REWRITE
            // elements: sequence
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 155:5: -> sequence
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


 

    public static final BitSet FOLLOW_meta_in_koopa136 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule_in_koopa145 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_EOF_in_koopa148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_meta182 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_meta186 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_meta190 = new BitSet(new long[]{0x0002000000200000L});
    public static final BitSet FOLLOW_49_in_meta197 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_meta201 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DOT_in_meta209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule319 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule323 = new BitSet(new long[]{0x0008000001400000L});
    public static final BitSet FOLLOW_OPEN_PAREN_in_rule332 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_locals_in_rule336 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLOSE_PAREN_in_rule338 = new BitSet(new long[]{0x0008000001000000L});
    public static final BitSet FOLLOW_51_in_rule349 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule353 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_EQUALS_in_rule357 = new BitSet(new long[]{0x000000FA7C700000L});
    public static final BitSet FOLLOW_sequence_in_rule368 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_rule377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_locals475 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_locals478 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_declaration_in_locals480 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration509 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_part_in_sequence541 = new BitSet(new long[]{0x000000FA7C700002L});
    public static final BitSet FOLLOW_NATIVE_CODE_in_part582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TAG_in_part607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANY_in_part614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_part621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_part628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_part639 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_EQUALS_in_part649 = new BitSet(new long[]{0x0000000050300000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_part654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_part660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_part666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANY_in_part672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_part713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_PAREN_in_part720 = new BitSet(new long[]{0x000000FA7C700000L});
    public static final BitSet FOLLOW_sequence_in_part722 = new BitSet(new long[]{0x0000020000800000L});
    public static final BitSet FOLLOW_more_in_part726 = new BitSet(new long[]{0x0000020000800000L});
    public static final BitSet FOLLOW_CLOSE_PAREN_in_part729 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_STAR_in_part734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_part740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_BRACKET_in_part812 = new BitSet(new long[]{0x000000FA7C700000L});
    public static final BitSet FOLLOW_sequence_in_part814 = new BitSet(new long[]{0x0000020400000000L});
    public static final BitSet FOLLOW_more_in_part818 = new BitSet(new long[]{0x0000020400000000L});
    public static final BitSet FOLLOW_CLOSE_BRACKET_in_part821 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_STAR_in_part826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_part832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SKIP_TO_in_part924 = new BitSet(new long[]{0x000000FA7C700000L});
    public static final BitSet FOLLOW_part_in_part926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_part950 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_OPEN_PAREN_in_part952 = new BitSet(new long[]{0x000000FA7C700000L});
    public static final BitSet FOLLOW_sequence_in_part954 = new BitSet(new long[]{0x0000020000800000L});
    public static final BitSet FOLLOW_more_in_part958 = new BitSet(new long[]{0x0000020000800000L});
    public static final BitSet FOLLOW_CLOSE_PAREN_in_part961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_part1004 = new BitSet(new long[]{0x000000FA7C700000L});
    public static final BitSet FOLLOW_part_in_part1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOSKIP_in_part1025 = new BitSet(new long[]{0x000000FA7C700000L});
    public static final BitSet FOLLOW_part_in_part1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_part1044 = new BitSet(new long[]{0x000000FA7C700000L});
    public static final BitSet FOLLOW_part_in_part1046 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_BY_in_part1048 = new BitSet(new long[]{0x000000FA7C700000L});
    public static final BitSet FOLLOW_part_in_part1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIPE_in_more1076 = new BitSet(new long[]{0x000000FA7C700000L});
    public static final BitSet FOLLOW_sequence_in_more1078 = new BitSet(new long[]{0x0000000000000002L});

}