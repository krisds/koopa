// $ANTLR 3.1.1 src/core/koopa/core/grammars/test/generator/Stage.g 2014-11-24 20:28:03

  package koopa.core.grammars.test.generator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class StageParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STAGE", "GRAMMAR", "PACKAGE", "TARGET", "TEST", "IDENTIFIER", "SEMI", "ACCEPT", "REJECT", "FREE_DATA", "FIXED_DATA", "COMMENT", "NEWLINE", "WHITESPACE", "NAME", "LETTER", "NUMBER", "'grammar'", "'package'", "'target'"
    };
    public static final int PACKAGE=6;
    public static final int LETTER=19;
    public static final int T__23=23;
    public static final int STAGE=4;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int NUMBER=20;
    public static final int WHITESPACE=17;
    public static final int TARGET=7;
    public static final int EOF=-1;
    public static final int SEMI=10;
    public static final int ACCEPT=11;
    public static final int NAME=18;
    public static final int NEWLINE=16;
    public static final int FIXED_DATA=14;
    public static final int IDENTIFIER=9;
    public static final int REJECT=12;
    public static final int TEST=8;
    public static final int FREE_DATA=13;
    public static final int COMMENT=15;
    public static final int GRAMMAR=5;

    // delegates
    // delegators


        public StageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public StageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return StageParser.tokenNames; }
    public String getGrammarFileName() { return "src/core/koopa/core/grammars/test/generator/Stage.g"; }


    public static class stage_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stage"
    // src/core/koopa/core/grammars/test/generator/Stage.g:24:1: stage : packageDeclaration grammarDeclaration ( testsForGrammarRule )* EOF -> ^( STAGE packageDeclaration grammarDeclaration ( testsForGrammarRule )* ) ;
    public final StageParser.stage_return stage() throws RecognitionException {
        StageParser.stage_return retval = new StageParser.stage_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF4=null;
        StageParser.packageDeclaration_return packageDeclaration1 = null;

        StageParser.grammarDeclaration_return grammarDeclaration2 = null;

        StageParser.testsForGrammarRule_return testsForGrammarRule3 = null;


        CommonTree EOF4_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_grammarDeclaration=new RewriteRuleSubtreeStream(adaptor,"rule grammarDeclaration");
        RewriteRuleSubtreeStream stream_packageDeclaration=new RewriteRuleSubtreeStream(adaptor,"rule packageDeclaration");
        RewriteRuleSubtreeStream stream_testsForGrammarRule=new RewriteRuleSubtreeStream(adaptor,"rule testsForGrammarRule");
        try {
            // src/core/koopa/core/grammars/test/generator/Stage.g:25:3: ( packageDeclaration grammarDeclaration ( testsForGrammarRule )* EOF -> ^( STAGE packageDeclaration grammarDeclaration ( testsForGrammarRule )* ) )
            // src/core/koopa/core/grammars/test/generator/Stage.g:25:5: packageDeclaration grammarDeclaration ( testsForGrammarRule )* EOF
            {
            pushFollow(FOLLOW_packageDeclaration_in_stage74);
            packageDeclaration1=packageDeclaration();

            state._fsp--;

            stream_packageDeclaration.add(packageDeclaration1.getTree());
            pushFollow(FOLLOW_grammarDeclaration_in_stage80);
            grammarDeclaration2=grammarDeclaration();

            state._fsp--;

            stream_grammarDeclaration.add(grammarDeclaration2.getTree());
            // src/core/koopa/core/grammars/test/generator/Stage.g:27:5: ( testsForGrammarRule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==23) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/core/koopa/core/grammars/test/generator/Stage.g:27:5: testsForGrammarRule
            	    {
            	    pushFollow(FOLLOW_testsForGrammarRule_in_stage86);
            	    testsForGrammarRule3=testsForGrammarRule();

            	    state._fsp--;

            	    stream_testsForGrammarRule.add(testsForGrammarRule3.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_stage93);  
            stream_EOF.add(EOF4);



            // AST REWRITE
            // elements: grammarDeclaration, packageDeclaration, testsForGrammarRule
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 30:5: -> ^( STAGE packageDeclaration grammarDeclaration ( testsForGrammarRule )* )
            {
                // src/core/koopa/core/grammars/test/generator/Stage.g:30:8: ^( STAGE packageDeclaration grammarDeclaration ( testsForGrammarRule )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STAGE, "STAGE"), root_1);

                adaptor.addChild(root_1, stream_packageDeclaration.nextTree());
                adaptor.addChild(root_1, stream_grammarDeclaration.nextTree());
                // src/core/koopa/core/grammars/test/generator/Stage.g:30:54: ( testsForGrammarRule )*
                while ( stream_testsForGrammarRule.hasNext() ) {
                    adaptor.addChild(root_1, stream_testsForGrammarRule.nextTree());

                }
                stream_testsForGrammarRule.reset();

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
    // $ANTLR end "stage"

    public static class grammarDeclaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "grammarDeclaration"
    // src/core/koopa/core/grammars/test/generator/Stage.g:33:1: grammarDeclaration : 'grammar' IDENTIFIER SEMI -> ^( GRAMMAR IDENTIFIER ) ;
    public final StageParser.grammarDeclaration_return grammarDeclaration() throws RecognitionException {
        StageParser.grammarDeclaration_return retval = new StageParser.grammarDeclaration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal5=null;
        Token IDENTIFIER6=null;
        Token SEMI7=null;

        CommonTree string_literal5_tree=null;
        CommonTree IDENTIFIER6_tree=null;
        CommonTree SEMI7_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/core/koopa/core/grammars/test/generator/Stage.g:34:3: ( 'grammar' IDENTIFIER SEMI -> ^( GRAMMAR IDENTIFIER ) )
            // src/core/koopa/core/grammars/test/generator/Stage.g:34:5: 'grammar' IDENTIFIER SEMI
            {
            string_literal5=(Token)match(input,21,FOLLOW_21_in_grammarDeclaration124);  
            stream_21.add(string_literal5);

            IDENTIFIER6=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_grammarDeclaration126);  
            stream_IDENTIFIER.add(IDENTIFIER6);

            SEMI7=(Token)match(input,SEMI,FOLLOW_SEMI_in_grammarDeclaration128);  
            stream_SEMI.add(SEMI7);



            // AST REWRITE
            // elements: IDENTIFIER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 36:5: -> ^( GRAMMAR IDENTIFIER )
            {
                // src/core/koopa/core/grammars/test/generator/Stage.g:36:8: ^( GRAMMAR IDENTIFIER )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(GRAMMAR, "GRAMMAR"), root_1);

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
    // $ANTLR end "grammarDeclaration"

    public static class packageDeclaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "packageDeclaration"
    // src/core/koopa/core/grammars/test/generator/Stage.g:39:1: packageDeclaration : 'package' IDENTIFIER SEMI -> ^( PACKAGE IDENTIFIER ) ;
    public final StageParser.packageDeclaration_return packageDeclaration() throws RecognitionException {
        StageParser.packageDeclaration_return retval = new StageParser.packageDeclaration_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal8=null;
        Token IDENTIFIER9=null;
        Token SEMI10=null;

        CommonTree string_literal8_tree=null;
        CommonTree IDENTIFIER9_tree=null;
        CommonTree SEMI10_tree=null;
        RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            // src/core/koopa/core/grammars/test/generator/Stage.g:40:3: ( 'package' IDENTIFIER SEMI -> ^( PACKAGE IDENTIFIER ) )
            // src/core/koopa/core/grammars/test/generator/Stage.g:40:5: 'package' IDENTIFIER SEMI
            {
            string_literal8=(Token)match(input,22,FOLLOW_22_in_packageDeclaration154);  
            stream_22.add(string_literal8);

            IDENTIFIER9=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_packageDeclaration156);  
            stream_IDENTIFIER.add(IDENTIFIER9);

            SEMI10=(Token)match(input,SEMI,FOLLOW_SEMI_in_packageDeclaration158);  
            stream_SEMI.add(SEMI10);



            // AST REWRITE
            // elements: IDENTIFIER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 42:5: -> ^( PACKAGE IDENTIFIER )
            {
                // src/core/koopa/core/grammars/test/generator/Stage.g:42:8: ^( PACKAGE IDENTIFIER )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PACKAGE, "PACKAGE"), root_1);

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
    // $ANTLR end "packageDeclaration"

    public static class testsForGrammarRule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "testsForGrammarRule"
    // src/core/koopa/core/grammars/test/generator/Stage.g:45:1: testsForGrammarRule : 'target' IDENTIFIER SEMI ( testcase )* -> ^( TARGET IDENTIFIER ( testcase )* ) ;
    public final StageParser.testsForGrammarRule_return testsForGrammarRule() throws RecognitionException {
        StageParser.testsForGrammarRule_return retval = new StageParser.testsForGrammarRule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal11=null;
        Token IDENTIFIER12=null;
        Token SEMI13=null;
        StageParser.testcase_return testcase14 = null;


        CommonTree string_literal11_tree=null;
        CommonTree IDENTIFIER12_tree=null;
        CommonTree SEMI13_tree=null;
        RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_testcase=new RewriteRuleSubtreeStream(adaptor,"rule testcase");
        try {
            // src/core/koopa/core/grammars/test/generator/Stage.g:46:3: ( 'target' IDENTIFIER SEMI ( testcase )* -> ^( TARGET IDENTIFIER ( testcase )* ) )
            // src/core/koopa/core/grammars/test/generator/Stage.g:46:5: 'target' IDENTIFIER SEMI ( testcase )*
            {
            string_literal11=(Token)match(input,23,FOLLOW_23_in_testsForGrammarRule184);  
            stream_23.add(string_literal11);

            IDENTIFIER12=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_testsForGrammarRule186);  
            stream_IDENTIFIER.add(IDENTIFIER12);

            SEMI13=(Token)match(input,SEMI,FOLLOW_SEMI_in_testsForGrammarRule188);  
            stream_SEMI.add(SEMI13);

            // src/core/koopa/core/grammars/test/generator/Stage.g:47:5: ( testcase )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=ACCEPT && LA2_0<=REJECT)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/core/koopa/core/grammars/test/generator/Stage.g:47:5: testcase
            	    {
            	    pushFollow(FOLLOW_testcase_in_testsForGrammarRule194);
            	    testcase14=testcase();

            	    state._fsp--;

            	    stream_testcase.add(testcase14.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);



            // AST REWRITE
            // elements: IDENTIFIER, testcase
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 49:5: -> ^( TARGET IDENTIFIER ( testcase )* )
            {
                // src/core/koopa/core/grammars/test/generator/Stage.g:49:8: ^( TARGET IDENTIFIER ( testcase )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TARGET, "TARGET"), root_1);

                adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                // src/core/koopa/core/grammars/test/generator/Stage.g:49:28: ( testcase )*
                while ( stream_testcase.hasNext() ) {
                    adaptor.addChild(root_1, stream_testcase.nextTree());

                }
                stream_testcase.reset();

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
    // $ANTLR end "testsForGrammarRule"

    public static class testcase_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "testcase"
    // src/core/koopa/core/grammars/test/generator/Stage.g:52:1: testcase : (t= ACCEPT | t= REJECT ) (d= FREE_DATA | d= FIXED_DATA ) -> ^( TEST $t $d) ;
    public final StageParser.testcase_return testcase() throws RecognitionException {
        StageParser.testcase_return retval = new StageParser.testcase_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token t=null;
        Token d=null;

        CommonTree t_tree=null;
        CommonTree d_tree=null;
        RewriteRuleTokenStream stream_FREE_DATA=new RewriteRuleTokenStream(adaptor,"token FREE_DATA");
        RewriteRuleTokenStream stream_FIXED_DATA=new RewriteRuleTokenStream(adaptor,"token FIXED_DATA");
        RewriteRuleTokenStream stream_ACCEPT=new RewriteRuleTokenStream(adaptor,"token ACCEPT");
        RewriteRuleTokenStream stream_REJECT=new RewriteRuleTokenStream(adaptor,"token REJECT");

        try {
            // src/core/koopa/core/grammars/test/generator/Stage.g:53:3: ( (t= ACCEPT | t= REJECT ) (d= FREE_DATA | d= FIXED_DATA ) -> ^( TEST $t $d) )
            // src/core/koopa/core/grammars/test/generator/Stage.g:53:5: (t= ACCEPT | t= REJECT ) (d= FREE_DATA | d= FIXED_DATA )
            {
            // src/core/koopa/core/grammars/test/generator/Stage.g:53:5: (t= ACCEPT | t= REJECT )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ACCEPT) ) {
                alt3=1;
            }
            else if ( (LA3_0==REJECT) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // src/core/koopa/core/grammars/test/generator/Stage.g:53:6: t= ACCEPT
                    {
                    t=(Token)match(input,ACCEPT,FOLLOW_ACCEPT_in_testcase227);  
                    stream_ACCEPT.add(t);


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/grammars/test/generator/Stage.g:53:17: t= REJECT
                    {
                    t=(Token)match(input,REJECT,FOLLOW_REJECT_in_testcase233);  
                    stream_REJECT.add(t);


                    }
                    break;

            }

            // src/core/koopa/core/grammars/test/generator/Stage.g:53:27: (d= FREE_DATA | d= FIXED_DATA )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==FREE_DATA) ) {
                alt4=1;
            }
            else if ( (LA4_0==FIXED_DATA) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // src/core/koopa/core/grammars/test/generator/Stage.g:53:28: d= FREE_DATA
                    {
                    d=(Token)match(input,FREE_DATA,FOLLOW_FREE_DATA_in_testcase239);  
                    stream_FREE_DATA.add(d);


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/grammars/test/generator/Stage.g:53:42: d= FIXED_DATA
                    {
                    d=(Token)match(input,FIXED_DATA,FOLLOW_FIXED_DATA_in_testcase245);  
                    stream_FIXED_DATA.add(d);


                    }
                    break;

            }



            // AST REWRITE
            // elements: d, t
            // token labels: d, t
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_d=new RewriteRuleTokenStream(adaptor,"token d",d);
            RewriteRuleTokenStream stream_t=new RewriteRuleTokenStream(adaptor,"token t",t);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 55:5: -> ^( TEST $t $d)
            {
                // src/core/koopa/core/grammars/test/generator/Stage.g:55:8: ^( TEST $t $d)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TEST, "TEST"), root_1);

                adaptor.addChild(root_1, stream_t.nextNode());
                adaptor.addChild(root_1, stream_d.nextNode());

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
    // $ANTLR end "testcase"

    // Delegated rules


 

    public static final BitSet FOLLOW_packageDeclaration_in_stage74 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_grammarDeclaration_in_stage80 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_testsForGrammarRule_in_stage86 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_EOF_in_stage93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_grammarDeclaration124 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_IDENTIFIER_in_grammarDeclaration126 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_SEMI_in_grammarDeclaration128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_packageDeclaration154 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_IDENTIFIER_in_packageDeclaration156 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_SEMI_in_packageDeclaration158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_testsForGrammarRule184 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_IDENTIFIER_in_testsForGrammarRule186 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_SEMI_in_testsForGrammarRule188 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_testcase_in_testsForGrammarRule194 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_ACCEPT_in_testcase227 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_REJECT_in_testcase233 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_FREE_DATA_in_testcase239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FIXED_DATA_in_testcase245 = new BitSet(new long[]{0x0000000000000002L});

}