// $ANTLR 3.5.2 src/core/koopa/core/grammars/test/generator/Stage.g

  package koopa.core.grammars.test.generator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class StageParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACCEPT", "COMMENT", "DATA", "GRAMMAR", 
		"IDENTIFIER", "LETTER", "NAME", "NEWLINE", "NUMBER", "PACKAGE", "REJECT", 
		"SEMI", "STAGE", "TARGET", "TEST", "TOKENIZER", "WHITESPACE", "'grammar'", 
		"'package'", "'target'", "'tokenizer'"
	};
	public static final int EOF=-1;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int ACCEPT=4;
	public static final int COMMENT=5;
	public static final int DATA=6;
	public static final int GRAMMAR=7;
	public static final int IDENTIFIER=8;
	public static final int LETTER=9;
	public static final int NAME=10;
	public static final int NEWLINE=11;
	public static final int NUMBER=12;
	public static final int PACKAGE=13;
	public static final int REJECT=14;
	public static final int SEMI=15;
	public static final int STAGE=16;
	public static final int TARGET=17;
	public static final int TEST=18;
	public static final int TOKENIZER=19;
	public static final int WHITESPACE=20;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

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
	@Override public String[] getTokenNames() { return StageParser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/core/koopa/core/grammars/test/generator/Stage.g"; }


	public static class stage_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "stage"
	// src/core/koopa/core/grammars/test/generator/Stage.g:25:1: stage : packageDeclaration grammarDeclaration tokenizerDeclaration ( testsForGrammarRule )* EOF -> ^( STAGE packageDeclaration grammarDeclaration tokenizerDeclaration ( testsForGrammarRule )* ) ;
	public final StageParser.stage_return stage() throws RecognitionException {
		StageParser.stage_return retval = new StageParser.stage_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EOF5=null;
		ParserRuleReturnScope packageDeclaration1 =null;
		ParserRuleReturnScope grammarDeclaration2 =null;
		ParserRuleReturnScope tokenizerDeclaration3 =null;
		ParserRuleReturnScope testsForGrammarRule4 =null;

		CommonTree EOF5_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_grammarDeclaration=new RewriteRuleSubtreeStream(adaptor,"rule grammarDeclaration");
		RewriteRuleSubtreeStream stream_packageDeclaration=new RewriteRuleSubtreeStream(adaptor,"rule packageDeclaration");
		RewriteRuleSubtreeStream stream_testsForGrammarRule=new RewriteRuleSubtreeStream(adaptor,"rule testsForGrammarRule");
		RewriteRuleSubtreeStream stream_tokenizerDeclaration=new RewriteRuleSubtreeStream(adaptor,"rule tokenizerDeclaration");

		try {
			// src/core/koopa/core/grammars/test/generator/Stage.g:26:3: ( packageDeclaration grammarDeclaration tokenizerDeclaration ( testsForGrammarRule )* EOF -> ^( STAGE packageDeclaration grammarDeclaration tokenizerDeclaration ( testsForGrammarRule )* ) )
			// src/core/koopa/core/grammars/test/generator/Stage.g:26:5: packageDeclaration grammarDeclaration tokenizerDeclaration ( testsForGrammarRule )* EOF
			{
			pushFollow(FOLLOW_packageDeclaration_in_stage79);
			packageDeclaration1=packageDeclaration();
			state._fsp--;

			stream_packageDeclaration.add(packageDeclaration1.getTree());
			pushFollow(FOLLOW_grammarDeclaration_in_stage85);
			grammarDeclaration2=grammarDeclaration();
			state._fsp--;

			stream_grammarDeclaration.add(grammarDeclaration2.getTree());
			pushFollow(FOLLOW_tokenizerDeclaration_in_stage91);
			tokenizerDeclaration3=tokenizerDeclaration();
			state._fsp--;

			stream_tokenizerDeclaration.add(tokenizerDeclaration3.getTree());
			// src/core/koopa/core/grammars/test/generator/Stage.g:29:5: ( testsForGrammarRule )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==23) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/core/koopa/core/grammars/test/generator/Stage.g:29:5: testsForGrammarRule
					{
					pushFollow(FOLLOW_testsForGrammarRule_in_stage97);
					testsForGrammarRule4=testsForGrammarRule();
					state._fsp--;

					stream_testsForGrammarRule.add(testsForGrammarRule4.getTree());
					}
					break;

				default :
					break loop1;
				}
			}

			EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_stage104);  
			stream_EOF.add(EOF5);

			// AST REWRITE
			// elements: tokenizerDeclaration, grammarDeclaration, testsForGrammarRule, packageDeclaration
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 32:5: -> ^( STAGE packageDeclaration grammarDeclaration tokenizerDeclaration ( testsForGrammarRule )* )
			{
				// src/core/koopa/core/grammars/test/generator/Stage.g:32:8: ^( STAGE packageDeclaration grammarDeclaration tokenizerDeclaration ( testsForGrammarRule )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STAGE, "STAGE"), root_1);
				adaptor.addChild(root_1, stream_packageDeclaration.nextTree());
				adaptor.addChild(root_1, stream_grammarDeclaration.nextTree());
				adaptor.addChild(root_1, stream_tokenizerDeclaration.nextTree());
				// src/core/koopa/core/grammars/test/generator/Stage.g:32:75: ( testsForGrammarRule )*
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "stage"


	public static class grammarDeclaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "grammarDeclaration"
	// src/core/koopa/core/grammars/test/generator/Stage.g:35:1: grammarDeclaration : 'grammar' IDENTIFIER SEMI -> ^( GRAMMAR IDENTIFIER ) ;
	public final StageParser.grammarDeclaration_return grammarDeclaration() throws RecognitionException {
		StageParser.grammarDeclaration_return retval = new StageParser.grammarDeclaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal6=null;
		Token IDENTIFIER7=null;
		Token SEMI8=null;

		CommonTree string_literal6_tree=null;
		CommonTree IDENTIFIER7_tree=null;
		CommonTree SEMI8_tree=null;
		RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

		try {
			// src/core/koopa/core/grammars/test/generator/Stage.g:36:3: ( 'grammar' IDENTIFIER SEMI -> ^( GRAMMAR IDENTIFIER ) )
			// src/core/koopa/core/grammars/test/generator/Stage.g:36:5: 'grammar' IDENTIFIER SEMI
			{
			string_literal6=(Token)match(input,21,FOLLOW_21_in_grammarDeclaration137);  
			stream_21.add(string_literal6);

			IDENTIFIER7=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_grammarDeclaration139);  
			stream_IDENTIFIER.add(IDENTIFIER7);

			SEMI8=(Token)match(input,SEMI,FOLLOW_SEMI_in_grammarDeclaration141);  
			stream_SEMI.add(SEMI8);

			// AST REWRITE
			// elements: IDENTIFIER
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 38:5: -> ^( GRAMMAR IDENTIFIER )
			{
				// src/core/koopa/core/grammars/test/generator/Stage.g:38:8: ^( GRAMMAR IDENTIFIER )
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "grammarDeclaration"


	public static class packageDeclaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "packageDeclaration"
	// src/core/koopa/core/grammars/test/generator/Stage.g:41:1: packageDeclaration : 'package' IDENTIFIER SEMI -> ^( PACKAGE IDENTIFIER ) ;
	public final StageParser.packageDeclaration_return packageDeclaration() throws RecognitionException {
		StageParser.packageDeclaration_return retval = new StageParser.packageDeclaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal9=null;
		Token IDENTIFIER10=null;
		Token SEMI11=null;

		CommonTree string_literal9_tree=null;
		CommonTree IDENTIFIER10_tree=null;
		CommonTree SEMI11_tree=null;
		RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

		try {
			// src/core/koopa/core/grammars/test/generator/Stage.g:42:3: ( 'package' IDENTIFIER SEMI -> ^( PACKAGE IDENTIFIER ) )
			// src/core/koopa/core/grammars/test/generator/Stage.g:42:5: 'package' IDENTIFIER SEMI
			{
			string_literal9=(Token)match(input,22,FOLLOW_22_in_packageDeclaration167);  
			stream_22.add(string_literal9);

			IDENTIFIER10=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_packageDeclaration169);  
			stream_IDENTIFIER.add(IDENTIFIER10);

			SEMI11=(Token)match(input,SEMI,FOLLOW_SEMI_in_packageDeclaration171);  
			stream_SEMI.add(SEMI11);

			// AST REWRITE
			// elements: IDENTIFIER
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 44:5: -> ^( PACKAGE IDENTIFIER )
			{
				// src/core/koopa/core/grammars/test/generator/Stage.g:44:8: ^( PACKAGE IDENTIFIER )
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "packageDeclaration"


	public static class tokenizerDeclaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tokenizerDeclaration"
	// src/core/koopa/core/grammars/test/generator/Stage.g:47:1: tokenizerDeclaration : 'tokenizer' IDENTIFIER SEMI -> ^( TOKENIZER IDENTIFIER ) ;
	public final StageParser.tokenizerDeclaration_return tokenizerDeclaration() throws RecognitionException {
		StageParser.tokenizerDeclaration_return retval = new StageParser.tokenizerDeclaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal12=null;
		Token IDENTIFIER13=null;
		Token SEMI14=null;

		CommonTree string_literal12_tree=null;
		CommonTree IDENTIFIER13_tree=null;
		CommonTree SEMI14_tree=null;
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_24=new RewriteRuleTokenStream(adaptor,"token 24");
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

		try {
			// src/core/koopa/core/grammars/test/generator/Stage.g:48:3: ( 'tokenizer' IDENTIFIER SEMI -> ^( TOKENIZER IDENTIFIER ) )
			// src/core/koopa/core/grammars/test/generator/Stage.g:48:5: 'tokenizer' IDENTIFIER SEMI
			{
			string_literal12=(Token)match(input,24,FOLLOW_24_in_tokenizerDeclaration197);  
			stream_24.add(string_literal12);

			IDENTIFIER13=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_tokenizerDeclaration199);  
			stream_IDENTIFIER.add(IDENTIFIER13);

			SEMI14=(Token)match(input,SEMI,FOLLOW_SEMI_in_tokenizerDeclaration201);  
			stream_SEMI.add(SEMI14);

			// AST REWRITE
			// elements: IDENTIFIER
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 50:5: -> ^( TOKENIZER IDENTIFIER )
			{
				// src/core/koopa/core/grammars/test/generator/Stage.g:50:8: ^( TOKENIZER IDENTIFIER )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TOKENIZER, "TOKENIZER"), root_1);
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tokenizerDeclaration"


	public static class testsForGrammarRule_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "testsForGrammarRule"
	// src/core/koopa/core/grammars/test/generator/Stage.g:53:1: testsForGrammarRule : 'target' IDENTIFIER SEMI ( testcase )* -> ^( TARGET IDENTIFIER ( testcase )* ) ;
	public final StageParser.testsForGrammarRule_return testsForGrammarRule() throws RecognitionException {
		StageParser.testsForGrammarRule_return retval = new StageParser.testsForGrammarRule_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal15=null;
		Token IDENTIFIER16=null;
		Token SEMI17=null;
		ParserRuleReturnScope testcase18 =null;

		CommonTree string_literal15_tree=null;
		CommonTree IDENTIFIER16_tree=null;
		CommonTree SEMI17_tree=null;
		RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
		RewriteRuleSubtreeStream stream_testcase=new RewriteRuleSubtreeStream(adaptor,"rule testcase");

		try {
			// src/core/koopa/core/grammars/test/generator/Stage.g:54:3: ( 'target' IDENTIFIER SEMI ( testcase )* -> ^( TARGET IDENTIFIER ( testcase )* ) )
			// src/core/koopa/core/grammars/test/generator/Stage.g:54:5: 'target' IDENTIFIER SEMI ( testcase )*
			{
			string_literal15=(Token)match(input,23,FOLLOW_23_in_testsForGrammarRule227);  
			stream_23.add(string_literal15);

			IDENTIFIER16=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_testsForGrammarRule229);  
			stream_IDENTIFIER.add(IDENTIFIER16);

			SEMI17=(Token)match(input,SEMI,FOLLOW_SEMI_in_testsForGrammarRule231);  
			stream_SEMI.add(SEMI17);

			// src/core/koopa/core/grammars/test/generator/Stage.g:55:5: ( testcase )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==ACCEPT||LA2_0==REJECT) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// src/core/koopa/core/grammars/test/generator/Stage.g:55:5: testcase
					{
					pushFollow(FOLLOW_testcase_in_testsForGrammarRule237);
					testcase18=testcase();
					state._fsp--;

					stream_testcase.add(testcase18.getTree());
					}
					break;

				default :
					break loop2;
				}
			}

			// AST REWRITE
			// elements: testcase, IDENTIFIER
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 57:5: -> ^( TARGET IDENTIFIER ( testcase )* )
			{
				// src/core/koopa/core/grammars/test/generator/Stage.g:57:8: ^( TARGET IDENTIFIER ( testcase )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TARGET, "TARGET"), root_1);
				adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
				// src/core/koopa/core/grammars/test/generator/Stage.g:57:28: ( testcase )*
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "testsForGrammarRule"


	public static class testcase_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "testcase"
	// src/core/koopa/core/grammars/test/generator/Stage.g:60:1: testcase : (t= ACCEPT |t= REJECT ) d= DATA -> ^( TEST $t $d) ;
	public final StageParser.testcase_return testcase() throws RecognitionException {
		StageParser.testcase_return retval = new StageParser.testcase_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token t=null;
		Token d=null;

		CommonTree t_tree=null;
		CommonTree d_tree=null;
		RewriteRuleTokenStream stream_ACCEPT=new RewriteRuleTokenStream(adaptor,"token ACCEPT");
		RewriteRuleTokenStream stream_REJECT=new RewriteRuleTokenStream(adaptor,"token REJECT");
		RewriteRuleTokenStream stream_DATA=new RewriteRuleTokenStream(adaptor,"token DATA");

		try {
			// src/core/koopa/core/grammars/test/generator/Stage.g:61:3: ( (t= ACCEPT |t= REJECT ) d= DATA -> ^( TEST $t $d) )
			// src/core/koopa/core/grammars/test/generator/Stage.g:61:5: (t= ACCEPT |t= REJECT ) d= DATA
			{
			// src/core/koopa/core/grammars/test/generator/Stage.g:61:5: (t= ACCEPT |t= REJECT )
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
					// src/core/koopa/core/grammars/test/generator/Stage.g:61:6: t= ACCEPT
					{
					t=(Token)match(input,ACCEPT,FOLLOW_ACCEPT_in_testcase270);  
					stream_ACCEPT.add(t);

					}
					break;
				case 2 :
					// src/core/koopa/core/grammars/test/generator/Stage.g:61:17: t= REJECT
					{
					t=(Token)match(input,REJECT,FOLLOW_REJECT_in_testcase276);  
					stream_REJECT.add(t);

					}
					break;

			}

			d=(Token)match(input,DATA,FOLLOW_DATA_in_testcase281);  
			stream_DATA.add(d);

			// AST REWRITE
			// elements: t, d
			// token labels: d, t
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_d=new RewriteRuleTokenStream(adaptor,"token d",d);
			RewriteRuleTokenStream stream_t=new RewriteRuleTokenStream(adaptor,"token t",t);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 63:5: -> ^( TEST $t $d)
			{
				// src/core/koopa/core/grammars/test/generator/Stage.g:63:8: ^( TEST $t $d)
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "testcase"

	// Delegated rules



	public static final BitSet FOLLOW_packageDeclaration_in_stage79 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_grammarDeclaration_in_stage85 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_tokenizerDeclaration_in_stage91 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_testsForGrammarRule_in_stage97 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_EOF_in_stage104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_grammarDeclaration137 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_IDENTIFIER_in_grammarDeclaration139 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_SEMI_in_grammarDeclaration141 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_packageDeclaration167 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_IDENTIFIER_in_packageDeclaration169 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_SEMI_in_packageDeclaration171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_tokenizerDeclaration197 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_IDENTIFIER_in_tokenizerDeclaration199 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_SEMI_in_tokenizerDeclaration201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_testsForGrammarRule227 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_IDENTIFIER_in_testsForGrammarRule229 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_SEMI_in_testsForGrammarRule231 = new BitSet(new long[]{0x0000000000004012L});
	public static final BitSet FOLLOW_testcase_in_testsForGrammarRule237 = new BitSet(new long[]{0x0000000000004012L});
	public static final BitSet FOLLOW_ACCEPT_in_testcase270 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_REJECT_in_testcase276 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_DATA_in_testcase281 = new BitSet(new long[]{0x0000000000000002L});
}
