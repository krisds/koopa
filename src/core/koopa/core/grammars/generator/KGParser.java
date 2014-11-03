// $ANTLR 3.1.1 src/core/koopa/core/grammars/generator/KG.g 2014-11-03 08:19:37

  package koopa.core.grammars.generator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class KGParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "GRAMMAR", "RULE", "BODY", "RETURNS", "SEQUENCE", "CHOICE", "OPTIONAL", "ACT", "ASSIGN", "DECLARATION", "LOCALS", "PERMUTED", "IDENTIFIER", "OPEN_PAREN", "CLOSE_PAREN", "EQUALS", "COMMA", "NATIVE_CODE", "TAG", "ANY", "LITERAL", "NUMBER", "DOT", "STAR", "PLUS", "OPEN_BRACKET", "CLOSE_BRACKET", "SKIP_TO", "BANG", "NOT", "NOSKIP", "PIPE", "COMMENT", "NEWLINE", "LETTER", "DIGIT", "WHITESPACE", "'def'", "'returns'", "'end'"
    };
    public static final int SKIP_TO=31;
    public static final int STAR=27;
    public static final int LETTER=38;
    public static final int EQUALS=19;
    public static final int NOT=33;
    public static final int NOSKIP=34;
    public static final int EOF=-1;
    public static final int DECLARATION=13;
    public static final int OPEN_BRACKET=29;
    public static final int NATIVE_CODE=21;
    public static final int COMMA=20;
    public static final int IDENTIFIER=16;
    public static final int PLUS=28;
    public static final int PIPE=35;
    public static final int BODY=6;
    public static final int CLOSE_PAREN=18;
    public static final int DIGIT=39;
    public static final int DOT=26;
    public static final int COMMENT=36;
    public static final int CHOICE=9;
    public static final int GRAMMAR=4;
    public static final int RETURNS=7;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int LOCALS=14;
    public static final int ACT=11;
    public static final int T__41=41;
    public static final int RULE=5;
    public static final int NUMBER=25;
    public static final int WHITESPACE=40;
    public static final int OPEN_PAREN=17;
    public static final int LITERAL=24;
    public static final int BANG=32;
    public static final int OPTIONAL=10;
    public static final int TAG=22;
    public static final int SEQUENCE=8;
    public static final int ANY=23;
    public static final int NEWLINE=37;
    public static final int ASSIGN=12;
    public static final int PERMUTED=15;
    public static final int CLOSE_BRACKET=30;

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
    // src/core/koopa/core/grammars/generator/KG.g:37:1: koopa : ( rule )* EOF -> ^( GRAMMAR ( rule )* ) ;
    public final KGParser.koopa_return koopa() throws RecognitionException {
        KGParser.koopa_return retval = new KGParser.koopa_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        KGParser.rule_return rule1 = null;


        CommonTree EOF2_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_rule=new RewriteRuleSubtreeStream(adaptor,"rule rule");
        try {
            // src/core/koopa/core/grammars/generator/KG.g:38:3: ( ( rule )* EOF -> ^( GRAMMAR ( rule )* ) )
            // src/core/koopa/core/grammars/generator/KG.g:38:5: ( rule )* EOF
            {
            // src/core/koopa/core/grammars/generator/KG.g:38:5: ( rule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==41) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:38:5: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_koopa116);
            	    rule1=rule();

            	    state._fsp--;

            	    stream_rule.add(rule1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_koopa119);  
            stream_EOF.add(EOF2);



            // AST REWRITE
            // elements: rule
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 40:5: -> ^( GRAMMAR ( rule )* )
            {
                // src/core/koopa/core/grammars/generator/KG.g:40:8: ^( GRAMMAR ( rule )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(GRAMMAR, "GRAMMAR"), root_1);

                // src/core/koopa/core/grammars/generator/KG.g:40:18: ( rule )*
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

    public static class rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rule"
    // src/core/koopa/core/grammars/generator/KG.g:43:1: rule : 'def' i= IDENTIFIER ( OPEN_PAREN l= locals CLOSE_PAREN )? ( 'returns' r= IDENTIFIER )? EQUALS sequence 'end' -> { l != null && r != null }? ^( RULE $i locals ^( RETURNS $r) sequence ) -> { l != null && r == null }? ^( RULE $i locals sequence ) -> { l == null && r != null }? ^( RULE $i ^( RETURNS $r) sequence ) -> ^( RULE $i sequence ) ;
    public final KGParser.rule_return rule() throws RecognitionException {
        KGParser.rule_return retval = new KGParser.rule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token i=null;
        Token r=null;
        Token string_literal3=null;
        Token OPEN_PAREN4=null;
        Token CLOSE_PAREN5=null;
        Token string_literal6=null;
        Token EQUALS7=null;
        Token string_literal9=null;
        KGParser.locals_return l = null;

        KGParser.sequence_return sequence8 = null;


        CommonTree i_tree=null;
        CommonTree r_tree=null;
        CommonTree string_literal3_tree=null;
        CommonTree OPEN_PAREN4_tree=null;
        CommonTree CLOSE_PAREN5_tree=null;
        CommonTree string_literal6_tree=null;
        CommonTree EQUALS7_tree=null;
        CommonTree string_literal9_tree=null;
        RewriteRuleTokenStream stream_OPEN_PAREN=new RewriteRuleTokenStream(adaptor,"token OPEN_PAREN");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_CLOSE_PAREN=new RewriteRuleTokenStream(adaptor,"token CLOSE_PAREN");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_locals=new RewriteRuleSubtreeStream(adaptor,"rule locals");
        RewriteRuleSubtreeStream stream_sequence=new RewriteRuleSubtreeStream(adaptor,"rule sequence");
        try {
            // src/core/koopa/core/grammars/generator/KG.g:44:3: ( 'def' i= IDENTIFIER ( OPEN_PAREN l= locals CLOSE_PAREN )? ( 'returns' r= IDENTIFIER )? EQUALS sequence 'end' -> { l != null && r != null }? ^( RULE $i locals ^( RETURNS $r) sequence ) -> { l != null && r == null }? ^( RULE $i locals sequence ) -> { l == null && r != null }? ^( RULE $i ^( RETURNS $r) sequence ) -> ^( RULE $i sequence ) )
            // src/core/koopa/core/grammars/generator/KG.g:44:5: 'def' i= IDENTIFIER ( OPEN_PAREN l= locals CLOSE_PAREN )? ( 'returns' r= IDENTIFIER )? EQUALS sequence 'end'
            {
            string_literal3=(Token)match(input,41,FOLLOW_41_in_rule148);  
            stream_41.add(string_literal3);

            i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule152);  
            stream_IDENTIFIER.add(i);

            // src/core/koopa/core/grammars/generator/KG.g:45:7: ( OPEN_PAREN l= locals CLOSE_PAREN )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==OPEN_PAREN) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KG.g:45:8: OPEN_PAREN l= locals CLOSE_PAREN
                    {
                    OPEN_PAREN4=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_rule161);  
                    stream_OPEN_PAREN.add(OPEN_PAREN4);

                    pushFollow(FOLLOW_locals_in_rule165);
                    l=locals();

                    state._fsp--;

                    stream_locals.add(l.getTree());
                    CLOSE_PAREN5=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_rule167);  
                    stream_CLOSE_PAREN.add(CLOSE_PAREN5);


                    }
                    break;

            }

            // src/core/koopa/core/grammars/generator/KG.g:46:7: ( 'returns' r= IDENTIFIER )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==42) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KG.g:46:8: 'returns' r= IDENTIFIER
                    {
                    string_literal6=(Token)match(input,42,FOLLOW_42_in_rule178);  
                    stream_42.add(string_literal6);

                    r=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule182);  
                    stream_IDENTIFIER.add(r);


                    }
                    break;

            }

            EQUALS7=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_rule186);  
            stream_EQUALS.add(EQUALS7);

            pushFollow(FOLLOW_sequence_in_rule197);
            sequence8=sequence();

            state._fsp--;

            stream_sequence.add(sequence8.getTree());
            string_literal9=(Token)match(input,43,FOLLOW_43_in_rule206);  
            stream_43.add(string_literal9);



            // AST REWRITE
            // elements: locals, i, sequence, r, i, sequence, sequence, sequence, r, i, i, locals
            // token labels: r, i
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
            RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 52:5: -> { l != null && r != null }? ^( RULE $i locals ^( RETURNS $r) sequence )
            if ( l != null && r != null ) {
                // src/core/koopa/core/grammars/generator/KG.g:52:36: ^( RULE $i locals ^( RETURNS $r) sequence )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);

                adaptor.addChild(root_1, stream_i.nextNode());
                adaptor.addChild(root_1, stream_locals.nextTree());
                // src/core/koopa/core/grammars/generator/KG.g:52:53: ^( RETURNS $r)
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
            else // 53:5: -> { l != null && r == null }? ^( RULE $i locals sequence )
            if ( l != null && r == null ) {
                // src/core/koopa/core/grammars/generator/KG.g:53:36: ^( RULE $i locals sequence )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);

                adaptor.addChild(root_1, stream_i.nextNode());
                adaptor.addChild(root_1, stream_locals.nextTree());
                adaptor.addChild(root_1, stream_sequence.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 54:5: -> { l == null && r != null }? ^( RULE $i ^( RETURNS $r) sequence )
            if ( l == null && r != null ) {
                // src/core/koopa/core/grammars/generator/KG.g:54:36: ^( RULE $i ^( RETURNS $r) sequence )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);

                adaptor.addChild(root_1, stream_i.nextNode());
                // src/core/koopa/core/grammars/generator/KG.g:54:46: ^( RETURNS $r)
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
            else // 55:5: -> ^( RULE $i sequence )
            {
                // src/core/koopa/core/grammars/generator/KG.g:55:8: ^( RULE $i sequence )
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
    // src/core/koopa/core/grammars/generator/KG.g:58:1: locals : declaration ( COMMA declaration )* -> ^( LOCALS ( declaration )+ ) ;
    public final KGParser.locals_return locals() throws RecognitionException {
        KGParser.locals_return retval = new KGParser.locals_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA11=null;
        KGParser.declaration_return declaration10 = null;

        KGParser.declaration_return declaration12 = null;


        CommonTree COMMA11_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_declaration=new RewriteRuleSubtreeStream(adaptor,"rule declaration");
        try {
            // src/core/koopa/core/grammars/generator/KG.g:59:3: ( declaration ( COMMA declaration )* -> ^( LOCALS ( declaration )+ ) )
            // src/core/koopa/core/grammars/generator/KG.g:59:5: declaration ( COMMA declaration )*
            {
            pushFollow(FOLLOW_declaration_in_locals304);
            declaration10=declaration();

            state._fsp--;

            stream_declaration.add(declaration10.getTree());
            // src/core/koopa/core/grammars/generator/KG.g:59:17: ( COMMA declaration )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==COMMA) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:59:18: COMMA declaration
            	    {
            	    COMMA11=(Token)match(input,COMMA,FOLLOW_COMMA_in_locals307);  
            	    stream_COMMA.add(COMMA11);

            	    pushFollow(FOLLOW_declaration_in_locals309);
            	    declaration12=declaration();

            	    state._fsp--;

            	    stream_declaration.add(declaration12.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
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
            // 61:5: -> ^( LOCALS ( declaration )+ )
            {
                // src/core/koopa/core/grammars/generator/KG.g:61:8: ^( LOCALS ( declaration )+ )
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
    // src/core/koopa/core/grammars/generator/KG.g:64:1: declaration : IDENTIFIER IDENTIFIER -> ^( DECLARATION IDENTIFIER IDENTIFIER ) ;
    public final KGParser.declaration_return declaration() throws RecognitionException {
        KGParser.declaration_return retval = new KGParser.declaration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENTIFIER13=null;
        Token IDENTIFIER14=null;

        CommonTree IDENTIFIER13_tree=null;
        CommonTree IDENTIFIER14_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/core/koopa/core/grammars/generator/KG.g:65:3: ( IDENTIFIER IDENTIFIER -> ^( DECLARATION IDENTIFIER IDENTIFIER ) )
            // src/core/koopa/core/grammars/generator/KG.g:65:5: IDENTIFIER IDENTIFIER
            {
            IDENTIFIER13=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration338);  
            stream_IDENTIFIER.add(IDENTIFIER13);

            IDENTIFIER14=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration340);  
            stream_IDENTIFIER.add(IDENTIFIER14);



            // AST REWRITE
            // elements: IDENTIFIER, IDENTIFIER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 67:5: -> ^( DECLARATION IDENTIFIER IDENTIFIER )
            {
                // src/core/koopa/core/grammars/generator/KG.g:67:8: ^( DECLARATION IDENTIFIER IDENTIFIER )
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
    // src/core/koopa/core/grammars/generator/KG.g:70:1: sequence : (p+= part )+ -> { $p.size() > 1 }? ^( SEQUENCE ( part )+ ) -> ( part )+ ;
    public final KGParser.sequence_return sequence() throws RecognitionException {
        KGParser.sequence_return retval = new KGParser.sequence_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        List list_p=null;
        RuleReturnScope p = null;
        RewriteRuleSubtreeStream stream_part=new RewriteRuleSubtreeStream(adaptor,"rule part");
        try {
            // src/core/koopa/core/grammars/generator/KG.g:71:3: ( (p+= part )+ -> { $p.size() > 1 }? ^( SEQUENCE ( part )+ ) -> ( part )+ )
            // src/core/koopa/core/grammars/generator/KG.g:71:5: (p+= part )+
            {
            // src/core/koopa/core/grammars/generator/KG.g:71:6: (p+= part )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=IDENTIFIER && LA5_0<=OPEN_PAREN)||(LA5_0>=NATIVE_CODE && LA5_0<=DOT)||LA5_0==OPEN_BRACKET||(LA5_0>=SKIP_TO && LA5_0<=NOSKIP)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KG.g:71:6: p+= part
            	    {
            	    pushFollow(FOLLOW_part_in_sequence370);
            	    p=part();

            	    state._fsp--;

            	    stream_part.add(p.getTree());
            	    if (list_p==null) list_p=new ArrayList();
            	    list_p.add(p.getTree());


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



            // AST REWRITE
            // elements: part, part
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 73:5: -> { $p.size() > 1 }? ^( SEQUENCE ( part )+ )
            if ( list_p.size() > 1 ) {
                // src/core/koopa/core/grammars/generator/KG.g:73:27: ^( SEQUENCE ( part )+ )
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
            else // 74:5: -> ( part )+
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
    // src/core/koopa/core/grammars/generator/KG.g:77:1: part : (code= NATIVE_CODE -> ^( ACT NATIVE_CODE ) | TAG | ANY | LITERAL | NUMBER | a= IDENTIFIER (e= EQUALS (b= IDENTIFIER | b= NUMBER | b= DOT ) )? -> { e != null }? ^( ASSIGN $a $b) -> IDENTIFIER | DOT | OPEN_PAREN sequence (m+= more )* CLOSE_PAREN (r= STAR | r= PLUS )? -> { r != null && m != null }? ^( $r ^( CHOICE sequence ( more )* ) ) -> { r != null && m == null }? ^( $r sequence ) -> { r == null && m != null }? ^( CHOICE sequence ( more )* ) -> sequence | OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET (r= STAR | r= PLUS )? -> { r != null && m != null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) ) -> { r != null && m == null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) ) -> { r == null && m != null }? ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) -> ^( OPTIONAL sequence ) | SKIP_TO part -> ^( SKIP_TO part ) | BANG OPEN_PAREN sequence (m+= more )* CLOSE_PAREN -> { m == null }? ^( OPTIONAL sequence ) -> ^( PERMUTED sequence ( more )* ) | NOT part -> ^( NOT part ) | NOSKIP part -> ^( NOSKIP part ) );
    public final KGParser.part_return part() throws RecognitionException {
        KGParser.part_return retval = new KGParser.part_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token code=null;
        Token a=null;
        Token e=null;
        Token b=null;
        Token r=null;
        Token TAG15=null;
        Token ANY16=null;
        Token LITERAL17=null;
        Token NUMBER18=null;
        Token DOT19=null;
        Token OPEN_PAREN20=null;
        Token CLOSE_PAREN22=null;
        Token OPEN_BRACKET23=null;
        Token CLOSE_BRACKET25=null;
        Token SKIP_TO26=null;
        Token BANG28=null;
        Token OPEN_PAREN29=null;
        Token CLOSE_PAREN31=null;
        Token NOT32=null;
        Token NOSKIP34=null;
        List list_m=null;
        KGParser.sequence_return sequence21 = null;

        KGParser.sequence_return sequence24 = null;

        KGParser.part_return part27 = null;

        KGParser.sequence_return sequence30 = null;

        KGParser.part_return part33 = null;

        KGParser.part_return part35 = null;

        RuleReturnScope m = null;
        CommonTree code_tree=null;
        CommonTree a_tree=null;
        CommonTree e_tree=null;
        CommonTree b_tree=null;
        CommonTree r_tree=null;
        CommonTree TAG15_tree=null;
        CommonTree ANY16_tree=null;
        CommonTree LITERAL17_tree=null;
        CommonTree NUMBER18_tree=null;
        CommonTree DOT19_tree=null;
        CommonTree OPEN_PAREN20_tree=null;
        CommonTree CLOSE_PAREN22_tree=null;
        CommonTree OPEN_BRACKET23_tree=null;
        CommonTree CLOSE_BRACKET25_tree=null;
        CommonTree SKIP_TO26_tree=null;
        CommonTree BANG28_tree=null;
        CommonTree OPEN_PAREN29_tree=null;
        CommonTree CLOSE_PAREN31_tree=null;
        CommonTree NOT32_tree=null;
        CommonTree NOSKIP34_tree=null;
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
            // src/core/koopa/core/grammars/generator/KG.g:78:3: (code= NATIVE_CODE -> ^( ACT NATIVE_CODE ) | TAG | ANY | LITERAL | NUMBER | a= IDENTIFIER (e= EQUALS (b= IDENTIFIER | b= NUMBER | b= DOT ) )? -> { e != null }? ^( ASSIGN $a $b) -> IDENTIFIER | DOT | OPEN_PAREN sequence (m+= more )* CLOSE_PAREN (r= STAR | r= PLUS )? -> { r != null && m != null }? ^( $r ^( CHOICE sequence ( more )* ) ) -> { r != null && m == null }? ^( $r sequence ) -> { r == null && m != null }? ^( CHOICE sequence ( more )* ) -> sequence | OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET (r= STAR | r= PLUS )? -> { r != null && m != null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) ) -> { r != null && m == null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) ) -> { r == null && m != null }? ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) -> ^( OPTIONAL sequence ) | SKIP_TO part -> ^( SKIP_TO part ) | BANG OPEN_PAREN sequence (m+= more )* CLOSE_PAREN -> { m == null }? ^( OPTIONAL sequence ) -> ^( PERMUTED sequence ( more )* ) | NOT part -> ^( NOT part ) | NOSKIP part -> ^( NOSKIP part ) )
            int alt13=13;
            switch ( input.LA(1) ) {
            case NATIVE_CODE:
                {
                alt13=1;
                }
                break;
            case TAG:
                {
                alt13=2;
                }
                break;
            case ANY:
                {
                alt13=3;
                }
                break;
            case LITERAL:
                {
                alt13=4;
                }
                break;
            case NUMBER:
                {
                alt13=5;
                }
                break;
            case IDENTIFIER:
                {
                alt13=6;
                }
                break;
            case DOT:
                {
                alt13=7;
                }
                break;
            case OPEN_PAREN:
                {
                alt13=8;
                }
                break;
            case OPEN_BRACKET:
                {
                alt13=9;
                }
                break;
            case SKIP_TO:
                {
                alt13=10;
                }
                break;
            case BANG:
                {
                alt13=11;
                }
                break;
            case NOT:
                {
                alt13=12;
                }
                break;
            case NOSKIP:
                {
                alt13=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KG.g:78:5: code= NATIVE_CODE
                    {
                    code=(Token)match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_part411);  
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
                    // 83:5: -> ^( ACT NATIVE_CODE )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:83:8: ^( ACT NATIVE_CODE )
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
                    // src/core/koopa/core/grammars/generator/KG.g:85:5: TAG
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    TAG15=(Token)match(input,TAG,FOLLOW_TAG_in_part436); 
                    TAG15_tree = (CommonTree)adaptor.create(TAG15);
                    adaptor.addChild(root_0, TAG15_tree);


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/grammars/generator/KG.g:87:5: ANY
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ANY16=(Token)match(input,ANY,FOLLOW_ANY_in_part443); 
                    ANY16_tree = (CommonTree)adaptor.create(ANY16);
                    adaptor.addChild(root_0, ANY16_tree);


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/grammars/generator/KG.g:89:5: LITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LITERAL17=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_part450); 
                    LITERAL17_tree = (CommonTree)adaptor.create(LITERAL17);
                    adaptor.addChild(root_0, LITERAL17_tree);


                    }
                    break;
                case 5 :
                    // src/core/koopa/core/grammars/generator/KG.g:91:5: NUMBER
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NUMBER18=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_part457); 
                    NUMBER18_tree = (CommonTree)adaptor.create(NUMBER18);
                    adaptor.addChild(root_0, NUMBER18_tree);


                    }
                    break;
                case 6 :
                    // src/core/koopa/core/grammars/generator/KG.g:93:5: a= IDENTIFIER (e= EQUALS (b= IDENTIFIER | b= NUMBER | b= DOT ) )?
                    {
                    a=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_part468);  
                    stream_IDENTIFIER.add(a);

                    // src/core/koopa/core/grammars/generator/KG.g:94:5: (e= EQUALS (b= IDENTIFIER | b= NUMBER | b= DOT ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==EQUALS) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // src/core/koopa/core/grammars/generator/KG.g:94:6: e= EQUALS (b= IDENTIFIER | b= NUMBER | b= DOT )
                            {
                            e=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_part478);  
                            stream_EQUALS.add(e);

                            // src/core/koopa/core/grammars/generator/KG.g:94:15: (b= IDENTIFIER | b= NUMBER | b= DOT )
                            int alt6=3;
                            switch ( input.LA(1) ) {
                            case IDENTIFIER:
                                {
                                alt6=1;
                                }
                                break;
                            case NUMBER:
                                {
                                alt6=2;
                                }
                                break;
                            case DOT:
                                {
                                alt6=3;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 0, input);

                                throw nvae;
                            }

                            switch (alt6) {
                                case 1 :
                                    // src/core/koopa/core/grammars/generator/KG.g:94:16: b= IDENTIFIER
                                    {
                                    b=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_part483);  
                                    stream_IDENTIFIER.add(b);


                                    }
                                    break;
                                case 2 :
                                    // src/core/koopa/core/grammars/generator/KG.g:94:31: b= NUMBER
                                    {
                                    b=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_part489);  
                                    stream_NUMBER.add(b);


                                    }
                                    break;
                                case 3 :
                                    // src/core/koopa/core/grammars/generator/KG.g:94:42: b= DOT
                                    {
                                    b=(Token)match(input,DOT,FOLLOW_DOT_in_part495);  
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
                    // 96:5: -> { e != null }? ^( ASSIGN $a $b)
                    if ( e != null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:96:23: ^( ASSIGN $a $b)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGN, "ASSIGN"), root_1);

                        adaptor.addChild(root_1, stream_a.nextNode());
                        adaptor.addChild(root_1, stream_b.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 97:5: -> IDENTIFIER
                    {
                        adaptor.addChild(root_0, stream_IDENTIFIER.nextNode());

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 7 :
                    // src/core/koopa/core/grammars/generator/KG.g:99:5: DOT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DOT19=(Token)match(input,DOT,FOLLOW_DOT_in_part536); 
                    DOT19_tree = (CommonTree)adaptor.create(DOT19);
                    adaptor.addChild(root_0, DOT19_tree);


                    }
                    break;
                case 8 :
                    // src/core/koopa/core/grammars/generator/KG.g:101:5: OPEN_PAREN sequence (m+= more )* CLOSE_PAREN (r= STAR | r= PLUS )?
                    {
                    OPEN_PAREN20=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_part543);  
                    stream_OPEN_PAREN.add(OPEN_PAREN20);

                    pushFollow(FOLLOW_sequence_in_part545);
                    sequence21=sequence();

                    state._fsp--;

                    stream_sequence.add(sequence21.getTree());
                    // src/core/koopa/core/grammars/generator/KG.g:101:26: (m+= more )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==PIPE) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KG.g:101:26: m+= more
                    	    {
                    	    pushFollow(FOLLOW_more_in_part549);
                    	    m=more();

                    	    state._fsp--;

                    	    stream_more.add(m.getTree());
                    	    if (list_m==null) list_m=new ArrayList();
                    	    list_m.add(m.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    CLOSE_PAREN22=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_part552);  
                    stream_CLOSE_PAREN.add(CLOSE_PAREN22);

                    // src/core/koopa/core/grammars/generator/KG.g:101:46: (r= STAR | r= PLUS )?
                    int alt9=3;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==STAR) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==PLUS) ) {
                        alt9=2;
                    }
                    switch (alt9) {
                        case 1 :
                            // src/core/koopa/core/grammars/generator/KG.g:101:47: r= STAR
                            {
                            r=(Token)match(input,STAR,FOLLOW_STAR_in_part557);  
                            stream_STAR.add(r);


                            }
                            break;
                        case 2 :
                            // src/core/koopa/core/grammars/generator/KG.g:101:56: r= PLUS
                            {
                            r=(Token)match(input,PLUS,FOLLOW_PLUS_in_part563);  
                            stream_PLUS.add(r);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: more, r, more, sequence, r, sequence, sequence, sequence
                    // token labels: r
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 103:5: -> { r != null && m != null }? ^( $r ^( CHOICE sequence ( more )* ) )
                    if ( r != null && m != null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:103:36: ^( $r ^( CHOICE sequence ( more )* ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);

                        // src/core/koopa/core/grammars/generator/KG.g:103:41: ^( CHOICE sequence ( more )* )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_2);

                        adaptor.addChild(root_2, stream_sequence.nextTree());
                        // src/core/koopa/core/grammars/generator/KG.g:103:59: ( more )*
                        while ( stream_more.hasNext() ) {
                            adaptor.addChild(root_2, stream_more.nextTree());

                        }
                        stream_more.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 104:5: -> { r != null && m == null }? ^( $r sequence )
                    if ( r != null && m == null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:104:36: ^( $r sequence )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_sequence.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 105:5: -> { r == null && m != null }? ^( CHOICE sequence ( more )* )
                    if ( r == null && m != null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:105:36: ^( CHOICE sequence ( more )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_1);

                        adaptor.addChild(root_1, stream_sequence.nextTree());
                        // src/core/koopa/core/grammars/generator/KG.g:105:54: ( more )*
                        while ( stream_more.hasNext() ) {
                            adaptor.addChild(root_1, stream_more.nextTree());

                        }
                        stream_more.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 106:5: -> sequence
                    {
                        adaptor.addChild(root_0, stream_sequence.nextTree());

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 9 :
                    // src/core/koopa/core/grammars/generator/KG.g:108:5: OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET (r= STAR | r= PLUS )?
                    {
                    OPEN_BRACKET23=(Token)match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_part635);  
                    stream_OPEN_BRACKET.add(OPEN_BRACKET23);

                    pushFollow(FOLLOW_sequence_in_part637);
                    sequence24=sequence();

                    state._fsp--;

                    stream_sequence.add(sequence24.getTree());
                    // src/core/koopa/core/grammars/generator/KG.g:108:28: (m+= more )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==PIPE) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KG.g:108:28: m+= more
                    	    {
                    	    pushFollow(FOLLOW_more_in_part641);
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

                    CLOSE_BRACKET25=(Token)match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_part644);  
                    stream_CLOSE_BRACKET.add(CLOSE_BRACKET25);

                    // src/core/koopa/core/grammars/generator/KG.g:108:50: (r= STAR | r= PLUS )?
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
                            // src/core/koopa/core/grammars/generator/KG.g:108:51: r= STAR
                            {
                            r=(Token)match(input,STAR,FOLLOW_STAR_in_part649);  
                            stream_STAR.add(r);


                            }
                            break;
                        case 2 :
                            // src/core/koopa/core/grammars/generator/KG.g:108:60: r= PLUS
                            {
                            r=(Token)match(input,PLUS,FOLLOW_PLUS_in_part655);  
                            stream_PLUS.add(r);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: sequence, r, more, sequence, r, sequence, more, sequence
                    // token labels: r
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 110:5: -> { r != null && m != null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) )
                    if ( r != null && m != null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:110:36: ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);

                        // src/core/koopa/core/grammars/generator/KG.g:110:41: ^( OPTIONAL ^( CHOICE sequence ( more )* ) )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_2);

                        // src/core/koopa/core/grammars/generator/KG.g:110:52: ^( CHOICE sequence ( more )* )
                        {
                        CommonTree root_3 = (CommonTree)adaptor.nil();
                        root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_3);

                        adaptor.addChild(root_3, stream_sequence.nextTree());
                        // src/core/koopa/core/grammars/generator/KG.g:110:70: ( more )*
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
                    else // 111:5: -> { r != null && m == null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) )
                    if ( r != null && m == null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:111:36: ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);

                        // src/core/koopa/core/grammars/generator/KG.g:111:41: ^( OPTIONAL ^( CHOICE sequence ) )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_2);

                        // src/core/koopa/core/grammars/generator/KG.g:111:52: ^( CHOICE sequence )
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
                    else // 112:5: -> { r == null && m != null }? ^( OPTIONAL ^( CHOICE sequence ( more )* ) )
                    if ( r == null && m != null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:112:36: ^( OPTIONAL ^( CHOICE sequence ( more )* ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_1);

                        // src/core/koopa/core/grammars/generator/KG.g:112:47: ^( CHOICE sequence ( more )* )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_2);

                        adaptor.addChild(root_2, stream_sequence.nextTree());
                        // src/core/koopa/core/grammars/generator/KG.g:112:65: ( more )*
                        while ( stream_more.hasNext() ) {
                            adaptor.addChild(root_2, stream_more.nextTree());

                        }
                        stream_more.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 113:5: -> ^( OPTIONAL sequence )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:113:8: ^( OPTIONAL sequence )
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
                    // src/core/koopa/core/grammars/generator/KG.g:115:5: SKIP_TO part
                    {
                    SKIP_TO26=(Token)match(input,SKIP_TO,FOLLOW_SKIP_TO_in_part747);  
                    stream_SKIP_TO.add(SKIP_TO26);

                    pushFollow(FOLLOW_part_in_part749);
                    part27=part();

                    state._fsp--;

                    stream_part.add(part27.getTree());


                    // AST REWRITE
                    // elements: SKIP_TO, part
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 117:5: -> ^( SKIP_TO part )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:117:8: ^( SKIP_TO part )
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
                    // src/core/koopa/core/grammars/generator/KG.g:119:5: BANG OPEN_PAREN sequence (m+= more )* CLOSE_PAREN
                    {
                    BANG28=(Token)match(input,BANG,FOLLOW_BANG_in_part773);  
                    stream_BANG.add(BANG28);

                    OPEN_PAREN29=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_part775);  
                    stream_OPEN_PAREN.add(OPEN_PAREN29);

                    pushFollow(FOLLOW_sequence_in_part777);
                    sequence30=sequence();

                    state._fsp--;

                    stream_sequence.add(sequence30.getTree());
                    // src/core/koopa/core/grammars/generator/KG.g:119:31: (m+= more )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==PIPE) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KG.g:119:31: m+= more
                    	    {
                    	    pushFollow(FOLLOW_more_in_part781);
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

                    CLOSE_PAREN31=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_part784);  
                    stream_CLOSE_PAREN.add(CLOSE_PAREN31);



                    // AST REWRITE
                    // elements: sequence, more, sequence
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 121:5: -> { m == null }? ^( OPTIONAL sequence )
                    if ( m == null ) {
                        // src/core/koopa/core/grammars/generator/KG.g:121:23: ^( OPTIONAL sequence )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_1);

                        adaptor.addChild(root_1, stream_sequence.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 122:5: -> ^( PERMUTED sequence ( more )* )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:122:8: ^( PERMUTED sequence ( more )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PERMUTED, "PERMUTED"), root_1);

                        adaptor.addChild(root_1, stream_sequence.nextTree());
                        // src/core/koopa/core/grammars/generator/KG.g:122:28: ( more )*
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
                    // src/core/koopa/core/grammars/generator/KG.g:124:5: NOT part
                    {
                    NOT32=(Token)match(input,NOT,FOLLOW_NOT_in_part827);  
                    stream_NOT.add(NOT32);

                    pushFollow(FOLLOW_part_in_part829);
                    part33=part();

                    state._fsp--;

                    stream_part.add(part33.getTree());


                    // AST REWRITE
                    // elements: NOT, part
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 125:5: -> ^( NOT part )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:125:8: ^( NOT part )
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
                    // src/core/koopa/core/grammars/generator/KG.g:127:5: NOSKIP part
                    {
                    NOSKIP34=(Token)match(input,NOSKIP,FOLLOW_NOSKIP_in_part848);  
                    stream_NOSKIP.add(NOSKIP34);

                    pushFollow(FOLLOW_part_in_part850);
                    part35=part();

                    state._fsp--;

                    stream_part.add(part35.getTree());


                    // AST REWRITE
                    // elements: part, NOSKIP
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 128:3: -> ^( NOSKIP part )
                    {
                        // src/core/koopa/core/grammars/generator/KG.g:128:6: ^( NOSKIP part )
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
    // src/core/koopa/core/grammars/generator/KG.g:132:1: more : PIPE sequence -> sequence ;
    public final KGParser.more_return more() throws RecognitionException {
        KGParser.more_return retval = new KGParser.more_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PIPE36=null;
        KGParser.sequence_return sequence37 = null;


        CommonTree PIPE36_tree=null;
        RewriteRuleTokenStream stream_PIPE=new RewriteRuleTokenStream(adaptor,"token PIPE");
        RewriteRuleSubtreeStream stream_sequence=new RewriteRuleSubtreeStream(adaptor,"rule sequence");
        try {
            // src/core/koopa/core/grammars/generator/KG.g:133:3: ( PIPE sequence -> sequence )
            // src/core/koopa/core/grammars/generator/KG.g:133:5: PIPE sequence
            {
            PIPE36=(Token)match(input,PIPE,FOLLOW_PIPE_in_more874);  
            stream_PIPE.add(PIPE36);

            pushFollow(FOLLOW_sequence_in_more876);
            sequence37=sequence();

            state._fsp--;

            stream_sequence.add(sequence37.getTree());


            // AST REWRITE
            // elements: sequence
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 135:5: -> sequence
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


 

    public static final BitSet FOLLOW_rule_in_koopa116 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_EOF_in_koopa119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule148 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule152 = new BitSet(new long[]{0x00000400000A0000L});
    public static final BitSet FOLLOW_OPEN_PAREN_in_rule161 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_locals_in_rule165 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_CLOSE_PAREN_in_rule167 = new BitSet(new long[]{0x0000040000080000L});
    public static final BitSet FOLLOW_42_in_rule178 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule182 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_EQUALS_in_rule186 = new BitSet(new long[]{0x00000007A7E30000L});
    public static final BitSet FOLLOW_sequence_in_rule197 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_rule206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_locals304 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_COMMA_in_locals307 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_declaration_in_locals309 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration338 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_part_in_sequence370 = new BitSet(new long[]{0x00000007A7E30002L});
    public static final BitSet FOLLOW_NATIVE_CODE_in_part411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TAG_in_part436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANY_in_part443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_part450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_part457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_part468 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_EQUALS_in_part478 = new BitSet(new long[]{0x0000000006010000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_part483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_part489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_part495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_part536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_PAREN_in_part543 = new BitSet(new long[]{0x00000007A7E30000L});
    public static final BitSet FOLLOW_sequence_in_part545 = new BitSet(new long[]{0x0000000800040000L});
    public static final BitSet FOLLOW_more_in_part549 = new BitSet(new long[]{0x0000000800040000L});
    public static final BitSet FOLLOW_CLOSE_PAREN_in_part552 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_STAR_in_part557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_part563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_BRACKET_in_part635 = new BitSet(new long[]{0x00000007A7E30000L});
    public static final BitSet FOLLOW_sequence_in_part637 = new BitSet(new long[]{0x0000000840000000L});
    public static final BitSet FOLLOW_more_in_part641 = new BitSet(new long[]{0x0000000840000000L});
    public static final BitSet FOLLOW_CLOSE_BRACKET_in_part644 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_STAR_in_part649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_part655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SKIP_TO_in_part747 = new BitSet(new long[]{0x00000007A7E30000L});
    public static final BitSet FOLLOW_part_in_part749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_part773 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_OPEN_PAREN_in_part775 = new BitSet(new long[]{0x00000007A7E30000L});
    public static final BitSet FOLLOW_sequence_in_part777 = new BitSet(new long[]{0x0000000800040000L});
    public static final BitSet FOLLOW_more_in_part781 = new BitSet(new long[]{0x0000000800040000L});
    public static final BitSet FOLLOW_CLOSE_PAREN_in_part784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_part827 = new BitSet(new long[]{0x00000007A7E30000L});
    public static final BitSet FOLLOW_part_in_part829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOSKIP_in_part848 = new BitSet(new long[]{0x00000007A7E30000L});
    public static final BitSet FOLLOW_part_in_part850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIPE_in_more874 = new BitSet(new long[]{0x00000007A7E30000L});
    public static final BitSet FOLLOW_sequence_in_more876 = new BitSet(new long[]{0x0000000000000002L});

}