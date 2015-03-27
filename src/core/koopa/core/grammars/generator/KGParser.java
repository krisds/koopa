// $ANTLR 3.5.2 src/core/koopa/core/grammars/generator/KG.g

  package koopa.core.grammars.generator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class KGParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACT", "ANY", "ARROW", "ASSIGN", 
		"BANG", "BODY", "BY", "CASE", "CHOICE", "CLOSE_BRACKET", "CLOSE_PAREN", 
		"COMMA", "COMMENT", "DECLARATION", "DIGIT", "DISPATCHED", "DOLLAR", "DOT", 
		"EQUALS", "EXTENDING", "GRAMMAR", "IDENTIFIER", "LETTER", "LIMIT", "LITERAL", 
		"LOCALS", "META", "NAMED", "NATIVE_CODE", "NEWLINE", "NOSKIP", "NOT", 
		"NUMBER", "OPEN_BRACKET", "OPEN_PAREN", "OPTIONAL", "PERMUTED", "PIPE", 
		"PLUS", "PRIVATE", "PUBLIC", "RETURNS", "RULE", "SEQUENCE", "SKIP_TO", 
		"STAR", "TAG", "TREE", "WHITESPACE", "WITH", "'def'", "'end'", "'extends'", 
		"'grammar'", "'returns'", "'tree'"
	};
	public static final int EOF=-1;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int ACT=4;
	public static final int ANY=5;
	public static final int ARROW=6;
	public static final int ASSIGN=7;
	public static final int BANG=8;
	public static final int BODY=9;
	public static final int BY=10;
	public static final int CASE=11;
	public static final int CHOICE=12;
	public static final int CLOSE_BRACKET=13;
	public static final int CLOSE_PAREN=14;
	public static final int COMMA=15;
	public static final int COMMENT=16;
	public static final int DECLARATION=17;
	public static final int DIGIT=18;
	public static final int DISPATCHED=19;
	public static final int DOLLAR=20;
	public static final int DOT=21;
	public static final int EQUALS=22;
	public static final int EXTENDING=23;
	public static final int GRAMMAR=24;
	public static final int IDENTIFIER=25;
	public static final int LETTER=26;
	public static final int LIMIT=27;
	public static final int LITERAL=28;
	public static final int LOCALS=29;
	public static final int META=30;
	public static final int NAMED=31;
	public static final int NATIVE_CODE=32;
	public static final int NEWLINE=33;
	public static final int NOSKIP=34;
	public static final int NOT=35;
	public static final int NUMBER=36;
	public static final int OPEN_BRACKET=37;
	public static final int OPEN_PAREN=38;
	public static final int OPTIONAL=39;
	public static final int PERMUTED=40;
	public static final int PIPE=41;
	public static final int PLUS=42;
	public static final int PRIVATE=43;
	public static final int PUBLIC=44;
	public static final int RETURNS=45;
	public static final int RULE=46;
	public static final int SEQUENCE=47;
	public static final int SKIP_TO=48;
	public static final int STAR=49;
	public static final int TAG=50;
	public static final int TREE=51;
	public static final int WHITESPACE=52;
	public static final int WITH=53;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

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
	@Override public String[] getTokenNames() { return KGParser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/core/koopa/core/grammars/generator/KG.g"; }


	  //private boolean verifyNativeCode(Token code) {
	  //  return JavaGrammarUtil.isValidJava(code.getText());
	  //}


	public static class koopa_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "koopa"
	// src/core/koopa/core/grammars/generator/KG.g:43:1: koopa : meta ( rule )* EOF -> ^( GRAMMAR meta ( rule )* ) ;
	public final KGParser.koopa_return koopa() throws RecognitionException {
		KGParser.koopa_return retval = new KGParser.koopa_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EOF3=null;
		ParserRuleReturnScope meta1 =null;
		ParserRuleReturnScope rule2 =null;

		CommonTree EOF3_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_meta=new RewriteRuleSubtreeStream(adaptor,"rule meta");
		RewriteRuleSubtreeStream stream_rule=new RewriteRuleSubtreeStream(adaptor,"rule rule");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:44:3: ( meta ( rule )* EOF -> ^( GRAMMAR meta ( rule )* ) )
			// src/core/koopa/core/grammars/generator/KG.g:44:5: meta ( rule )* EOF
			{
			pushFollow(FOLLOW_meta_in_koopa146);
			meta1=meta();
			state._fsp--;

			stream_meta.add(meta1.getTree());
			// src/core/koopa/core/grammars/generator/KG.g:46:5: ( rule )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= PRIVATE && LA1_0 <= PUBLIC)||LA1_0==54) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:46:5: rule
					{
					pushFollow(FOLLOW_rule_in_koopa155);
					rule2=rule();
					state._fsp--;

					stream_rule.add(rule2.getTree());
					}
					break;

				default :
					break loop1;
				}
			}

			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_koopa158);  
			stream_EOF.add(EOF3);

			// AST REWRITE
			// elements: meta, rule
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 48:5: -> ^( GRAMMAR meta ( rule )* )
			{
				// src/core/koopa/core/grammars/generator/KG.g:48:8: ^( GRAMMAR meta ( rule )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(GRAMMAR, "GRAMMAR"), root_1);
				adaptor.addChild(root_1, stream_meta.nextTree());
				// src/core/koopa/core/grammars/generator/KG.g:48:23: ( rule )*
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "koopa"


	public static class meta_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "meta"
	// src/core/koopa/core/grammars/generator/KG.g:51:1: meta : (t= 'tree' )? 'grammar' n= IDENTIFIER ( 'extends' s= IDENTIFIER )? DOT -> { t == null && s == null }? ^( META ^( NAMED $n) ) -> { t == null && s != null }? ^( META ^( NAMED $n) ^( EXTENDING $s) ) -> { t != null && s == null }? ^( META TREE ^( NAMED $n) ) -> ^( META TREE ^( NAMED $n) ^( EXTENDING $s) ) ;
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
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:52:3: ( (t= 'tree' )? 'grammar' n= IDENTIFIER ( 'extends' s= IDENTIFIER )? DOT -> { t == null && s == null }? ^( META ^( NAMED $n) ) -> { t == null && s != null }? ^( META ^( NAMED $n) ^( EXTENDING $s) ) -> { t != null && s == null }? ^( META TREE ^( NAMED $n) ) -> ^( META TREE ^( NAMED $n) ^( EXTENDING $s) ) )
			// src/core/koopa/core/grammars/generator/KG.g:52:5: (t= 'tree' )? 'grammar' n= IDENTIFIER ( 'extends' s= IDENTIFIER )? DOT
			{
			// src/core/koopa/core/grammars/generator/KG.g:52:5: (t= 'tree' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==59) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:52:6: t= 'tree'
					{
					t=(Token)match(input,59,FOLLOW_59_in_meta192);  
					stream_59.add(t);

					}
					break;

			}

			string_literal4=(Token)match(input,57,FOLLOW_57_in_meta196);  
			stream_57.add(string_literal4);

			n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_meta200);  
			stream_IDENTIFIER.add(n);

			// src/core/koopa/core/grammars/generator/KG.g:53:5: ( 'extends' s= IDENTIFIER )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==56) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:53:6: 'extends' s= IDENTIFIER
					{
					string_literal5=(Token)match(input,56,FOLLOW_56_in_meta207);  
					stream_56.add(string_literal5);

					s=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_meta211);  
					stream_IDENTIFIER.add(s);

					}
					break;

			}

			DOT6=(Token)match(input,DOT,FOLLOW_DOT_in_meta219);  
			stream_DOT.add(DOT6);

			// AST REWRITE
			// elements: n, n, n, s, n, s
			// token labels: s, n
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
			RewriteRuleTokenStream stream_n=new RewriteRuleTokenStream(adaptor,"token n",n);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 56:5: -> { t == null && s == null }? ^( META ^( NAMED $n) )
			if ( t == null && s == null ) {
				// src/core/koopa/core/grammars/generator/KG.g:56:36: ^( META ^( NAMED $n) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(META, "META"), root_1);
				// src/core/koopa/core/grammars/generator/KG.g:56:43: ^( NAMED $n)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED, "NAMED"), root_2);
				adaptor.addChild(root_2, stream_n.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}

			else // 57:5: -> { t == null && s != null }? ^( META ^( NAMED $n) ^( EXTENDING $s) )
			if ( t == null && s != null ) {
				// src/core/koopa/core/grammars/generator/KG.g:57:36: ^( META ^( NAMED $n) ^( EXTENDING $s) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(META, "META"), root_1);
				// src/core/koopa/core/grammars/generator/KG.g:57:43: ^( NAMED $n)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED, "NAMED"), root_2);
				adaptor.addChild(root_2, stream_n.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				// src/core/koopa/core/grammars/generator/KG.g:57:55: ^( EXTENDING $s)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXTENDING, "EXTENDING"), root_2);
				adaptor.addChild(root_2, stream_s.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}

			else // 58:5: -> { t != null && s == null }? ^( META TREE ^( NAMED $n) )
			if ( t != null && s == null ) {
				// src/core/koopa/core/grammars/generator/KG.g:58:36: ^( META TREE ^( NAMED $n) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(META, "META"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TREE, "TREE"));
				// src/core/koopa/core/grammars/generator/KG.g:58:48: ^( NAMED $n)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED, "NAMED"), root_2);
				adaptor.addChild(root_2, stream_n.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}

			else // 59:5: -> ^( META TREE ^( NAMED $n) ^( EXTENDING $s) )
			{
				// src/core/koopa/core/grammars/generator/KG.g:59:8: ^( META TREE ^( NAMED $n) ^( EXTENDING $s) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(META, "META"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TREE, "TREE"));
				// src/core/koopa/core/grammars/generator/KG.g:59:20: ^( NAMED $n)
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NAMED, "NAMED"), root_2);
				adaptor.addChild(root_2, stream_n.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				// src/core/koopa/core/grammars/generator/KG.g:59:32: ^( EXTENDING $s)
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "meta"


	public static class modifier_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "modifier"
	// src/core/koopa/core/grammars/generator/KG.g:62:1: modifier : ( PUBLIC -> PUBLIC | PRIVATE -> PRIVATE );
	public final KGParser.modifier_return modifier() throws RecognitionException {
		KGParser.modifier_return retval = new KGParser.modifier_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token PUBLIC7=null;
		Token PRIVATE8=null;

		CommonTree PUBLIC7_tree=null;
		CommonTree PRIVATE8_tree=null;
		RewriteRuleTokenStream stream_PUBLIC=new RewriteRuleTokenStream(adaptor,"token PUBLIC");
		RewriteRuleTokenStream stream_PRIVATE=new RewriteRuleTokenStream(adaptor,"token PRIVATE");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:63:3: ( PUBLIC -> PUBLIC | PRIVATE -> PRIVATE )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==PUBLIC) ) {
				alt4=1;
			}
			else if ( (LA4_0==PRIVATE) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:63:5: PUBLIC
					{
					PUBLIC7=(Token)match(input,PUBLIC,FOLLOW_PUBLIC_in_modifier329);  
					stream_PUBLIC.add(PUBLIC7);

					// AST REWRITE
					// elements: PUBLIC
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 63:15: -> PUBLIC
					{
						adaptor.addChild(root_0, stream_PUBLIC.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// src/core/koopa/core/grammars/generator/KG.g:64:5: PRIVATE
					{
					PRIVATE8=(Token)match(input,PRIVATE,FOLLOW_PRIVATE_in_modifier342);  
					stream_PRIVATE.add(PRIVATE8);

					// AST REWRITE
					// elements: PRIVATE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 64:15: -> PRIVATE
					{
						adaptor.addChild(root_0, stream_PRIVATE.nextNode());
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "modifier"


	public static class rule_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rule"
	// src/core/koopa/core/grammars/generator/KG.g:67:1: rule : (v= modifier )? 'def' i= IDENTIFIER ( OPEN_PAREN l= locals CLOSE_PAREN )? ( 'returns' r= IDENTIFIER )? EQUALS sequence 'end' -> { v != null && l != null && r != null }? ^( RULE $v $i locals ^( RETURNS $r) sequence ) -> { v != null && l != null && r == null }? ^( RULE $v $i locals sequence ) -> { v != null && l == null && r != null }? ^( RULE $v $i ^( RETURNS $r) sequence ) -> { v != null && l == null && r == null }? ^( RULE $v $i sequence ) -> { v == null && l != null && r != null }? ^( RULE PUBLIC $i locals ^( RETURNS $r) sequence ) -> { v == null && l != null && r == null }? ^( RULE PUBLIC $i locals sequence ) -> { v == null && l == null && r != null }? ^( RULE PUBLIC $i ^( RETURNS $r) sequence ) -> ^( RULE PUBLIC $i sequence ) ;
	public final KGParser.rule_return rule() throws RecognitionException {
		KGParser.rule_return retval = new KGParser.rule_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;
		Token r=null;
		Token string_literal9=null;
		Token OPEN_PAREN10=null;
		Token CLOSE_PAREN11=null;
		Token string_literal12=null;
		Token EQUALS13=null;
		Token string_literal15=null;
		ParserRuleReturnScope v =null;
		ParserRuleReturnScope l =null;
		ParserRuleReturnScope sequence14 =null;

		CommonTree i_tree=null;
		CommonTree r_tree=null;
		CommonTree string_literal9_tree=null;
		CommonTree OPEN_PAREN10_tree=null;
		CommonTree CLOSE_PAREN11_tree=null;
		CommonTree string_literal12_tree=null;
		CommonTree EQUALS13_tree=null;
		CommonTree string_literal15_tree=null;
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_OPEN_PAREN=new RewriteRuleTokenStream(adaptor,"token OPEN_PAREN");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
		RewriteRuleTokenStream stream_CLOSE_PAREN=new RewriteRuleTokenStream(adaptor,"token CLOSE_PAREN");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_sequence=new RewriteRuleSubtreeStream(adaptor,"rule sequence");
		RewriteRuleSubtreeStream stream_modifier=new RewriteRuleSubtreeStream(adaptor,"rule modifier");
		RewriteRuleSubtreeStream stream_locals=new RewriteRuleSubtreeStream(adaptor,"rule locals");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:68:3: ( (v= modifier )? 'def' i= IDENTIFIER ( OPEN_PAREN l= locals CLOSE_PAREN )? ( 'returns' r= IDENTIFIER )? EQUALS sequence 'end' -> { v != null && l != null && r != null }? ^( RULE $v $i locals ^( RETURNS $r) sequence ) -> { v != null && l != null && r == null }? ^( RULE $v $i locals sequence ) -> { v != null && l == null && r != null }? ^( RULE $v $i ^( RETURNS $r) sequence ) -> { v != null && l == null && r == null }? ^( RULE $v $i sequence ) -> { v == null && l != null && r != null }? ^( RULE PUBLIC $i locals ^( RETURNS $r) sequence ) -> { v == null && l != null && r == null }? ^( RULE PUBLIC $i locals sequence ) -> { v == null && l == null && r != null }? ^( RULE PUBLIC $i ^( RETURNS $r) sequence ) -> ^( RULE PUBLIC $i sequence ) )
			// src/core/koopa/core/grammars/generator/KG.g:68:5: (v= modifier )? 'def' i= IDENTIFIER ( OPEN_PAREN l= locals CLOSE_PAREN )? ( 'returns' r= IDENTIFIER )? EQUALS sequence 'end'
			{
			// src/core/koopa/core/grammars/generator/KG.g:68:5: (v= modifier )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( ((LA5_0 >= PRIVATE && LA5_0 <= PUBLIC)) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:68:6: v= modifier
					{
					pushFollow(FOLLOW_modifier_in_rule364);
					v=modifier();
					state._fsp--;

					stream_modifier.add(v.getTree());
					}
					break;

			}

			string_literal9=(Token)match(input,54,FOLLOW_54_in_rule368);  
			stream_54.add(string_literal9);

			i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule372);  
			stream_IDENTIFIER.add(i);

			// src/core/koopa/core/grammars/generator/KG.g:69:7: ( OPEN_PAREN l= locals CLOSE_PAREN )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==OPEN_PAREN) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:69:8: OPEN_PAREN l= locals CLOSE_PAREN
					{
					OPEN_PAREN10=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_rule381);  
					stream_OPEN_PAREN.add(OPEN_PAREN10);

					pushFollow(FOLLOW_locals_in_rule385);
					l=locals();
					state._fsp--;

					stream_locals.add(l.getTree());
					CLOSE_PAREN11=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_rule387);  
					stream_CLOSE_PAREN.add(CLOSE_PAREN11);

					}
					break;

			}

			// src/core/koopa/core/grammars/generator/KG.g:70:7: ( 'returns' r= IDENTIFIER )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==58) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:70:8: 'returns' r= IDENTIFIER
					{
					string_literal12=(Token)match(input,58,FOLLOW_58_in_rule398);  
					stream_58.add(string_literal12);

					r=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule402);  
					stream_IDENTIFIER.add(r);

					}
					break;

			}

			EQUALS13=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_rule406);  
			stream_EQUALS.add(EQUALS13);

			pushFollow(FOLLOW_sequence_in_rule417);
			sequence14=sequence();
			state._fsp--;

			stream_sequence.add(sequence14.getTree());
			string_literal15=(Token)match(input,55,FOLLOW_55_in_rule426);  
			stream_55.add(string_literal15);

			// AST REWRITE
			// elements: v, i, i, r, i, sequence, v, sequence, i, v, i, sequence, i, locals, r, r, sequence, sequence, i, r, locals, sequence, i, locals, v, locals, sequence, sequence
			// token labels: r, i
			// rule labels: v, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"rule v",v!=null?v.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 76:5: -> { v != null && l != null && r != null }? ^( RULE $v $i locals ^( RETURNS $r) sequence )
			if ( v != null && l != null && r != null ) {
				// src/core/koopa/core/grammars/generator/KG.g:76:49: ^( RULE $v $i locals ^( RETURNS $r) sequence )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);
				adaptor.addChild(root_1, stream_v.nextTree());
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_locals.nextTree());
				// src/core/koopa/core/grammars/generator/KG.g:76:69: ^( RETURNS $r)
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

			else // 77:5: -> { v != null && l != null && r == null }? ^( RULE $v $i locals sequence )
			if ( v != null && l != null && r == null ) {
				// src/core/koopa/core/grammars/generator/KG.g:77:49: ^( RULE $v $i locals sequence )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);
				adaptor.addChild(root_1, stream_v.nextTree());
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_locals.nextTree());
				adaptor.addChild(root_1, stream_sequence.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}

			else // 79:5: -> { v != null && l == null && r != null }? ^( RULE $v $i ^( RETURNS $r) sequence )
			if ( v != null && l == null && r != null ) {
				// src/core/koopa/core/grammars/generator/KG.g:79:49: ^( RULE $v $i ^( RETURNS $r) sequence )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);
				adaptor.addChild(root_1, stream_v.nextTree());
				adaptor.addChild(root_1, stream_i.nextNode());
				// src/core/koopa/core/grammars/generator/KG.g:79:62: ^( RETURNS $r)
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

			else // 80:5: -> { v != null && l == null && r == null }? ^( RULE $v $i sequence )
			if ( v != null && l == null && r == null ) {
				// src/core/koopa/core/grammars/generator/KG.g:80:49: ^( RULE $v $i sequence )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);
				adaptor.addChild(root_1, stream_v.nextTree());
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_sequence.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}

			else // 82:5: -> { v == null && l != null && r != null }? ^( RULE PUBLIC $i locals ^( RETURNS $r) sequence )
			if ( v == null && l != null && r != null ) {
				// src/core/koopa/core/grammars/generator/KG.g:82:49: ^( RULE PUBLIC $i locals ^( RETURNS $r) sequence )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(PUBLIC, "PUBLIC"));
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_locals.nextTree());
				// src/core/koopa/core/grammars/generator/KG.g:82:73: ^( RETURNS $r)
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

			else // 83:5: -> { v == null && l != null && r == null }? ^( RULE PUBLIC $i locals sequence )
			if ( v == null && l != null && r == null ) {
				// src/core/koopa/core/grammars/generator/KG.g:83:49: ^( RULE PUBLIC $i locals sequence )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(PUBLIC, "PUBLIC"));
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_locals.nextTree());
				adaptor.addChild(root_1, stream_sequence.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}

			else // 85:5: -> { v == null && l == null && r != null }? ^( RULE PUBLIC $i ^( RETURNS $r) sequence )
			if ( v == null && l == null && r != null ) {
				// src/core/koopa/core/grammars/generator/KG.g:85:49: ^( RULE PUBLIC $i ^( RETURNS $r) sequence )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(PUBLIC, "PUBLIC"));
				adaptor.addChild(root_1, stream_i.nextNode());
				// src/core/koopa/core/grammars/generator/KG.g:85:66: ^( RETURNS $r)
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

			else // 86:5: -> ^( RULE PUBLIC $i sequence )
			{
				// src/core/koopa/core/grammars/generator/KG.g:86:49: ^( RULE PUBLIC $i sequence )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RULE, "RULE"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(PUBLIC, "PUBLIC"));
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rule"


	public static class locals_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "locals"
	// src/core/koopa/core/grammars/generator/KG.g:89:1: locals : declaration ( COMMA declaration )* -> ^( LOCALS ( declaration )+ ) ;
	public final KGParser.locals_return locals() throws RecognitionException {
		KGParser.locals_return retval = new KGParser.locals_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA17=null;
		ParserRuleReturnScope declaration16 =null;
		ParserRuleReturnScope declaration18 =null;

		CommonTree COMMA17_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_declaration=new RewriteRuleSubtreeStream(adaptor,"rule declaration");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:90:3: ( declaration ( COMMA declaration )* -> ^( LOCALS ( declaration )+ ) )
			// src/core/koopa/core/grammars/generator/KG.g:90:5: declaration ( COMMA declaration )*
			{
			pushFollow(FOLLOW_declaration_in_locals686);
			declaration16=declaration();
			state._fsp--;

			stream_declaration.add(declaration16.getTree());
			// src/core/koopa/core/grammars/generator/KG.g:90:17: ( COMMA declaration )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==COMMA) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:90:18: COMMA declaration
					{
					COMMA17=(Token)match(input,COMMA,FOLLOW_COMMA_in_locals689);  
					stream_COMMA.add(COMMA17);

					pushFollow(FOLLOW_declaration_in_locals691);
					declaration18=declaration();
					state._fsp--;

					stream_declaration.add(declaration18.getTree());
					}
					break;

				default :
					break loop8;
				}
			}

			// AST REWRITE
			// elements: declaration
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 92:5: -> ^( LOCALS ( declaration )+ )
			{
				// src/core/koopa/core/grammars/generator/KG.g:92:8: ^( LOCALS ( declaration )+ )
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "locals"


	public static class declaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "declaration"
	// src/core/koopa/core/grammars/generator/KG.g:95:1: declaration : IDENTIFIER IDENTIFIER -> ^( DECLARATION IDENTIFIER IDENTIFIER ) ;
	public final KGParser.declaration_return declaration() throws RecognitionException {
		KGParser.declaration_return retval = new KGParser.declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENTIFIER19=null;
		Token IDENTIFIER20=null;

		CommonTree IDENTIFIER19_tree=null;
		CommonTree IDENTIFIER20_tree=null;
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:96:3: ( IDENTIFIER IDENTIFIER -> ^( DECLARATION IDENTIFIER IDENTIFIER ) )
			// src/core/koopa/core/grammars/generator/KG.g:96:5: IDENTIFIER IDENTIFIER
			{
			IDENTIFIER19=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration720);  
			stream_IDENTIFIER.add(IDENTIFIER19);

			IDENTIFIER20=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration722);  
			stream_IDENTIFIER.add(IDENTIFIER20);

			// AST REWRITE
			// elements: IDENTIFIER, IDENTIFIER
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 98:5: -> ^( DECLARATION IDENTIFIER IDENTIFIER )
			{
				// src/core/koopa/core/grammars/generator/KG.g:98:8: ^( DECLARATION IDENTIFIER IDENTIFIER )
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declaration"


	public static class sequence_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "sequence"
	// src/core/koopa/core/grammars/generator/KG.g:101:1: sequence : (p+= part )+ -> { $p.size() > 1 }? ^( SEQUENCE ( part )+ ) -> ( part )+ ;
	public final KGParser.sequence_return sequence() throws RecognitionException {
		KGParser.sequence_return retval = new KGParser.sequence_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		List<Object> list_p=null;
		RuleReturnScope p = null;
		RewriteRuleSubtreeStream stream_part=new RewriteRuleSubtreeStream(adaptor,"rule part");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:102:3: ( (p+= part )+ -> { $p.size() > 1 }? ^( SEQUENCE ( part )+ ) -> ( part )+ )
			// src/core/koopa/core/grammars/generator/KG.g:102:5: (p+= part )+
			{
			// src/core/koopa/core/grammars/generator/KG.g:102:6: (p+= part )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==ANY||LA9_0==BANG||(LA9_0 >= DOLLAR && LA9_0 <= DOT)||LA9_0==IDENTIFIER||(LA9_0 >= LIMIT && LA9_0 <= LITERAL)||LA9_0==NATIVE_CODE||(LA9_0 >= NOSKIP && LA9_0 <= OPEN_PAREN)||LA9_0==SKIP_TO||LA9_0==TAG||LA9_0==WITH) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:102:6: p+= part
					{
					pushFollow(FOLLOW_part_in_sequence752);
					p=part();
					state._fsp--;

					stream_part.add(p.getTree());
					if (list_p==null) list_p=new ArrayList<Object>();
					list_p.add(p.getTree());
					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			// AST REWRITE
			// elements: part, part
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 104:5: -> { $p.size() > 1 }? ^( SEQUENCE ( part )+ )
			if ( list_p.size() > 1 ) {
				// src/core/koopa/core/grammars/generator/KG.g:104:27: ^( SEQUENCE ( part )+ )
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

			else // 105:5: -> ( part )+
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "sequence"


	public static class part_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "part"
	// src/core/koopa/core/grammars/generator/KG.g:108:1: part : (code= NATIVE_CODE -> ^( ACT NATIVE_CODE ) | TAG | ANY | LITERAL | NUMBER |a= IDENTIFIER (e= EQUALS (b= IDENTIFIER |b= NUMBER |b= DOT |b= ANY ) )? -> { e != null }? ^( ASSIGN $a $b) -> IDENTIFIER | DOT | OPEN_PAREN sequence (m+= more )* CLOSE_PAREN (r= STAR |r= PLUS )? -> { r != null && m != null }? ^( $r ^( CHOICE sequence ( more )* ) ) -> { r != null && m == null }? ^( $r sequence ) -> { r == null && m != null }? ^( CHOICE sequence ( more )* ) -> sequence | OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET (r= STAR |r= PLUS )? -> { r != null && m != null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) ) -> { r != null && m == null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) ) -> { r == null && m != null }? ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) -> ^( OPTIONAL sequence ) | SKIP_TO part -> ^( SKIP_TO part ) | BANG OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET -> { m == null }? ^( OPTIONAL sequence ) -> ^( OPTIONAL ^( PERMUTED sequence ( more )* ) ) | BANG OPEN_PAREN sequence (m+= more )* CLOSE_PAREN -> { m == null }? sequence -> ^( PERMUTED sequence ( more )* ) | DOLLAR OPEN_PAREN dispatch (m+= more_dispatch )* CLOSE_PAREN -> { m == null }? ^( DISPATCHED dispatch ) -> ^( DISPATCHED dispatch ( more_dispatch )* ) | NOT part -> ^( NOT part ) | NOSKIP part -> ^( NOSKIP part ) | LIMIT part BY part -> ^( LIMIT part part ) | WITH p= part SKIP_TO q= part -> ^( SEQUENCE ^( LIMIT $p $q) ^( SKIP_TO $q) ) );
	public final KGParser.part_return part() throws RecognitionException {
		KGParser.part_return retval = new KGParser.part_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token code=null;
		Token a=null;
		Token e=null;
		Token b=null;
		Token r=null;
		Token TAG21=null;
		Token ANY22=null;
		Token LITERAL23=null;
		Token NUMBER24=null;
		Token DOT25=null;
		Token OPEN_PAREN26=null;
		Token CLOSE_PAREN28=null;
		Token OPEN_BRACKET29=null;
		Token CLOSE_BRACKET31=null;
		Token SKIP_TO32=null;
		Token BANG34=null;
		Token OPEN_BRACKET35=null;
		Token CLOSE_BRACKET37=null;
		Token BANG38=null;
		Token OPEN_PAREN39=null;
		Token CLOSE_PAREN41=null;
		Token DOLLAR42=null;
		Token OPEN_PAREN43=null;
		Token CLOSE_PAREN45=null;
		Token NOT46=null;
		Token NOSKIP48=null;
		Token LIMIT50=null;
		Token BY52=null;
		Token WITH54=null;
		Token SKIP_TO55=null;
		List<Object> list_m=null;
		ParserRuleReturnScope p =null;
		ParserRuleReturnScope q =null;
		ParserRuleReturnScope sequence27 =null;
		ParserRuleReturnScope sequence30 =null;
		ParserRuleReturnScope part33 =null;
		ParserRuleReturnScope sequence36 =null;
		ParserRuleReturnScope sequence40 =null;
		ParserRuleReturnScope dispatch44 =null;
		ParserRuleReturnScope part47 =null;
		ParserRuleReturnScope part49 =null;
		ParserRuleReturnScope part51 =null;
		ParserRuleReturnScope part53 =null;
		RuleReturnScope m = null;
		CommonTree code_tree=null;
		CommonTree a_tree=null;
		CommonTree e_tree=null;
		CommonTree b_tree=null;
		CommonTree r_tree=null;
		CommonTree TAG21_tree=null;
		CommonTree ANY22_tree=null;
		CommonTree LITERAL23_tree=null;
		CommonTree NUMBER24_tree=null;
		CommonTree DOT25_tree=null;
		CommonTree OPEN_PAREN26_tree=null;
		CommonTree CLOSE_PAREN28_tree=null;
		CommonTree OPEN_BRACKET29_tree=null;
		CommonTree CLOSE_BRACKET31_tree=null;
		CommonTree SKIP_TO32_tree=null;
		CommonTree BANG34_tree=null;
		CommonTree OPEN_BRACKET35_tree=null;
		CommonTree CLOSE_BRACKET37_tree=null;
		CommonTree BANG38_tree=null;
		CommonTree OPEN_PAREN39_tree=null;
		CommonTree CLOSE_PAREN41_tree=null;
		CommonTree DOLLAR42_tree=null;
		CommonTree OPEN_PAREN43_tree=null;
		CommonTree CLOSE_PAREN45_tree=null;
		CommonTree NOT46_tree=null;
		CommonTree NOSKIP48_tree=null;
		CommonTree LIMIT50_tree=null;
		CommonTree BY52_tree=null;
		CommonTree WITH54_tree=null;
		CommonTree SKIP_TO55_tree=null;
		RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
		RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
		RewriteRuleTokenStream stream_BANG=new RewriteRuleTokenStream(adaptor,"token BANG");
		RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
		RewriteRuleTokenStream stream_OPEN_BRACKET=new RewriteRuleTokenStream(adaptor,"token OPEN_BRACKET");
		RewriteRuleTokenStream stream_CLOSE_BRACKET=new RewriteRuleTokenStream(adaptor,"token CLOSE_BRACKET");
		RewriteRuleTokenStream stream_LIMIT=new RewriteRuleTokenStream(adaptor,"token LIMIT");
		RewriteRuleTokenStream stream_ANY=new RewriteRuleTokenStream(adaptor,"token ANY");
		RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
		RewriteRuleTokenStream stream_SKIP_TO=new RewriteRuleTokenStream(adaptor,"token SKIP_TO");
		RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
		RewriteRuleTokenStream stream_OPEN_PAREN=new RewriteRuleTokenStream(adaptor,"token OPEN_PAREN");
		RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
		RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
		RewriteRuleTokenStream stream_NATIVE_CODE=new RewriteRuleTokenStream(adaptor,"token NATIVE_CODE");
		RewriteRuleTokenStream stream_DOLLAR=new RewriteRuleTokenStream(adaptor,"token DOLLAR");
		RewriteRuleTokenStream stream_NOSKIP=new RewriteRuleTokenStream(adaptor,"token NOSKIP");
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
		RewriteRuleTokenStream stream_CLOSE_PAREN=new RewriteRuleTokenStream(adaptor,"token CLOSE_PAREN");
		RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
		RewriteRuleSubtreeStream stream_sequence=new RewriteRuleSubtreeStream(adaptor,"rule sequence");
		RewriteRuleSubtreeStream stream_dispatch=new RewriteRuleSubtreeStream(adaptor,"rule dispatch");
		RewriteRuleSubtreeStream stream_more_dispatch=new RewriteRuleSubtreeStream(adaptor,"rule more_dispatch");
		RewriteRuleSubtreeStream stream_more=new RewriteRuleSubtreeStream(adaptor,"rule more");
		RewriteRuleSubtreeStream stream_part=new RewriteRuleSubtreeStream(adaptor,"rule part");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:109:3: (code= NATIVE_CODE -> ^( ACT NATIVE_CODE ) | TAG | ANY | LITERAL | NUMBER |a= IDENTIFIER (e= EQUALS (b= IDENTIFIER |b= NUMBER |b= DOT |b= ANY ) )? -> { e != null }? ^( ASSIGN $a $b) -> IDENTIFIER | DOT | OPEN_PAREN sequence (m+= more )* CLOSE_PAREN (r= STAR |r= PLUS )? -> { r != null && m != null }? ^( $r ^( CHOICE sequence ( more )* ) ) -> { r != null && m == null }? ^( $r sequence ) -> { r == null && m != null }? ^( CHOICE sequence ( more )* ) -> sequence | OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET (r= STAR |r= PLUS )? -> { r != null && m != null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) ) -> { r != null && m == null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) ) -> { r == null && m != null }? ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) -> ^( OPTIONAL sequence ) | SKIP_TO part -> ^( SKIP_TO part ) | BANG OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET -> { m == null }? ^( OPTIONAL sequence ) -> ^( OPTIONAL ^( PERMUTED sequence ( more )* ) ) | BANG OPEN_PAREN sequence (m+= more )* CLOSE_PAREN -> { m == null }? sequence -> ^( PERMUTED sequence ( more )* ) | DOLLAR OPEN_PAREN dispatch (m+= more_dispatch )* CLOSE_PAREN -> { m == null }? ^( DISPATCHED dispatch ) -> ^( DISPATCHED dispatch ( more_dispatch )* ) | NOT part -> ^( NOT part ) | NOSKIP part -> ^( NOSKIP part ) | LIMIT part BY part -> ^( LIMIT part part ) | WITH p= part SKIP_TO q= part -> ^( SEQUENCE ^( LIMIT $p $q) ^( SKIP_TO $q) ) )
			int alt19=17;
			switch ( input.LA(1) ) {
			case NATIVE_CODE:
				{
				alt19=1;
				}
				break;
			case TAG:
				{
				alt19=2;
				}
				break;
			case ANY:
				{
				alt19=3;
				}
				break;
			case LITERAL:
				{
				alt19=4;
				}
				break;
			case NUMBER:
				{
				alt19=5;
				}
				break;
			case IDENTIFIER:
				{
				alt19=6;
				}
				break;
			case DOT:
				{
				alt19=7;
				}
				break;
			case OPEN_PAREN:
				{
				alt19=8;
				}
				break;
			case OPEN_BRACKET:
				{
				alt19=9;
				}
				break;
			case SKIP_TO:
				{
				alt19=10;
				}
				break;
			case BANG:
				{
				int LA19_11 = input.LA(2);
				if ( (LA19_11==OPEN_BRACKET) ) {
					alt19=11;
				}
				else if ( (LA19_11==OPEN_PAREN) ) {
					alt19=12;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 19, 11, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case DOLLAR:
				{
				alt19=13;
				}
				break;
			case NOT:
				{
				alt19=14;
				}
				break;
			case NOSKIP:
				{
				alt19=15;
				}
				break;
			case LIMIT:
				{
				alt19=16;
				}
				break;
			case WITH:
				{
				alt19=17;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}
			switch (alt19) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:109:5: code= NATIVE_CODE
					{
					code=(Token)match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_part793);  
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
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 114:5: -> ^( ACT NATIVE_CODE )
					{
						// src/core/koopa/core/grammars/generator/KG.g:114:8: ^( ACT NATIVE_CODE )
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
					// src/core/koopa/core/grammars/generator/KG.g:116:5: TAG
					{
					root_0 = (CommonTree)adaptor.nil();


					TAG21=(Token)match(input,TAG,FOLLOW_TAG_in_part818); 
					TAG21_tree = (CommonTree)adaptor.create(TAG21);
					adaptor.addChild(root_0, TAG21_tree);

					}
					break;
				case 3 :
					// src/core/koopa/core/grammars/generator/KG.g:118:5: ANY
					{
					root_0 = (CommonTree)adaptor.nil();


					ANY22=(Token)match(input,ANY,FOLLOW_ANY_in_part825); 
					ANY22_tree = (CommonTree)adaptor.create(ANY22);
					adaptor.addChild(root_0, ANY22_tree);

					}
					break;
				case 4 :
					// src/core/koopa/core/grammars/generator/KG.g:120:5: LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					LITERAL23=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_part832); 
					LITERAL23_tree = (CommonTree)adaptor.create(LITERAL23);
					adaptor.addChild(root_0, LITERAL23_tree);

					}
					break;
				case 5 :
					// src/core/koopa/core/grammars/generator/KG.g:122:5: NUMBER
					{
					root_0 = (CommonTree)adaptor.nil();


					NUMBER24=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_part839); 
					NUMBER24_tree = (CommonTree)adaptor.create(NUMBER24);
					adaptor.addChild(root_0, NUMBER24_tree);

					}
					break;
				case 6 :
					// src/core/koopa/core/grammars/generator/KG.g:124:5: a= IDENTIFIER (e= EQUALS (b= IDENTIFIER |b= NUMBER |b= DOT |b= ANY ) )?
					{
					a=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_part850);  
					stream_IDENTIFIER.add(a);

					// src/core/koopa/core/grammars/generator/KG.g:125:5: (e= EQUALS (b= IDENTIFIER |b= NUMBER |b= DOT |b= ANY ) )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==EQUALS) ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KG.g:125:6: e= EQUALS (b= IDENTIFIER |b= NUMBER |b= DOT |b= ANY )
							{
							e=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_part860);  
							stream_EQUALS.add(e);

							// src/core/koopa/core/grammars/generator/KG.g:125:15: (b= IDENTIFIER |b= NUMBER |b= DOT |b= ANY )
							int alt10=4;
							switch ( input.LA(1) ) {
							case IDENTIFIER:
								{
								alt10=1;
								}
								break;
							case NUMBER:
								{
								alt10=2;
								}
								break;
							case DOT:
								{
								alt10=3;
								}
								break;
							case ANY:
								{
								alt10=4;
								}
								break;
							default:
								NoViableAltException nvae =
									new NoViableAltException("", 10, 0, input);
								throw nvae;
							}
							switch (alt10) {
								case 1 :
									// src/core/koopa/core/grammars/generator/KG.g:125:16: b= IDENTIFIER
									{
									b=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_part865);  
									stream_IDENTIFIER.add(b);

									}
									break;
								case 2 :
									// src/core/koopa/core/grammars/generator/KG.g:125:31: b= NUMBER
									{
									b=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_part871);  
									stream_NUMBER.add(b);

									}
									break;
								case 3 :
									// src/core/koopa/core/grammars/generator/KG.g:125:42: b= DOT
									{
									b=(Token)match(input,DOT,FOLLOW_DOT_in_part877);  
									stream_DOT.add(b);

									}
									break;
								case 4 :
									// src/core/koopa/core/grammars/generator/KG.g:125:50: b= ANY
									{
									b=(Token)match(input,ANY,FOLLOW_ANY_in_part883);  
									stream_ANY.add(b);

									}
									break;

							}

							}
							break;

					}

					// AST REWRITE
					// elements: b, IDENTIFIER, a
					// token labels: a, b
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
					RewriteRuleTokenStream stream_b=new RewriteRuleTokenStream(adaptor,"token b",b);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 127:5: -> { e != null }? ^( ASSIGN $a $b)
					if ( e != null ) {
						// src/core/koopa/core/grammars/generator/KG.g:127:23: ^( ASSIGN $a $b)
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGN, "ASSIGN"), root_1);
						adaptor.addChild(root_1, stream_a.nextNode());
						adaptor.addChild(root_1, stream_b.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}

					else // 128:5: -> IDENTIFIER
					{
						adaptor.addChild(root_0, stream_IDENTIFIER.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 7 :
					// src/core/koopa/core/grammars/generator/KG.g:130:5: DOT
					{
					root_0 = (CommonTree)adaptor.nil();


					DOT25=(Token)match(input,DOT,FOLLOW_DOT_in_part924); 
					DOT25_tree = (CommonTree)adaptor.create(DOT25);
					adaptor.addChild(root_0, DOT25_tree);

					}
					break;
				case 8 :
					// src/core/koopa/core/grammars/generator/KG.g:132:5: OPEN_PAREN sequence (m+= more )* CLOSE_PAREN (r= STAR |r= PLUS )?
					{
					OPEN_PAREN26=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_part931);  
					stream_OPEN_PAREN.add(OPEN_PAREN26);

					pushFollow(FOLLOW_sequence_in_part933);
					sequence27=sequence();
					state._fsp--;

					stream_sequence.add(sequence27.getTree());
					// src/core/koopa/core/grammars/generator/KG.g:132:26: (m+= more )*
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0==PIPE) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KG.g:132:26: m+= more
							{
							pushFollow(FOLLOW_more_in_part937);
							m=more();
							state._fsp--;

							stream_more.add(m.getTree());
							if (list_m==null) list_m=new ArrayList<Object>();
							list_m.add(m.getTree());
							}
							break;

						default :
							break loop12;
						}
					}

					CLOSE_PAREN28=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_part940);  
					stream_CLOSE_PAREN.add(CLOSE_PAREN28);

					// src/core/koopa/core/grammars/generator/KG.g:132:46: (r= STAR |r= PLUS )?
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
							// src/core/koopa/core/grammars/generator/KG.g:132:47: r= STAR
							{
							r=(Token)match(input,STAR,FOLLOW_STAR_in_part945);  
							stream_STAR.add(r);

							}
							break;
						case 2 :
							// src/core/koopa/core/grammars/generator/KG.g:132:56: r= PLUS
							{
							r=(Token)match(input,PLUS,FOLLOW_PLUS_in_part951);  
							stream_PLUS.add(r);

							}
							break;

					}

					// AST REWRITE
					// elements: sequence, sequence, sequence, r, more, more, r, sequence
					// token labels: r
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 134:5: -> { r != null && m != null }? ^( $r ^( CHOICE sequence ( more )* ) )
					if ( r != null && m != null ) {
						// src/core/koopa/core/grammars/generator/KG.g:134:36: ^( $r ^( CHOICE sequence ( more )* ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);
						// src/core/koopa/core/grammars/generator/KG.g:134:41: ^( CHOICE sequence ( more )* )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_2);
						adaptor.addChild(root_2, stream_sequence.nextTree());
						// src/core/koopa/core/grammars/generator/KG.g:134:59: ( more )*
						while ( stream_more.hasNext() ) {
							adaptor.addChild(root_2, stream_more.nextTree());
						}
						stream_more.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}

					else // 135:5: -> { r != null && m == null }? ^( $r sequence )
					if ( r != null && m == null ) {
						// src/core/koopa/core/grammars/generator/KG.g:135:36: ^( $r sequence )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);
						adaptor.addChild(root_1, stream_sequence.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}

					else // 136:5: -> { r == null && m != null }? ^( CHOICE sequence ( more )* )
					if ( r == null && m != null ) {
						// src/core/koopa/core/grammars/generator/KG.g:136:36: ^( CHOICE sequence ( more )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_1);
						adaptor.addChild(root_1, stream_sequence.nextTree());
						// src/core/koopa/core/grammars/generator/KG.g:136:54: ( more )*
						while ( stream_more.hasNext() ) {
							adaptor.addChild(root_1, stream_more.nextTree());
						}
						stream_more.reset();

						adaptor.addChild(root_0, root_1);
						}

					}

					else // 137:5: -> sequence
					{
						adaptor.addChild(root_0, stream_sequence.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 9 :
					// src/core/koopa/core/grammars/generator/KG.g:139:5: OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET (r= STAR |r= PLUS )?
					{
					OPEN_BRACKET29=(Token)match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_part1023);  
					stream_OPEN_BRACKET.add(OPEN_BRACKET29);

					pushFollow(FOLLOW_sequence_in_part1025);
					sequence30=sequence();
					state._fsp--;

					stream_sequence.add(sequence30.getTree());
					// src/core/koopa/core/grammars/generator/KG.g:139:28: (m+= more )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==PIPE) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KG.g:139:28: m+= more
							{
							pushFollow(FOLLOW_more_in_part1029);
							m=more();
							state._fsp--;

							stream_more.add(m.getTree());
							if (list_m==null) list_m=new ArrayList<Object>();
							list_m.add(m.getTree());
							}
							break;

						default :
							break loop14;
						}
					}

					CLOSE_BRACKET31=(Token)match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_part1032);  
					stream_CLOSE_BRACKET.add(CLOSE_BRACKET31);

					// src/core/koopa/core/grammars/generator/KG.g:139:50: (r= STAR |r= PLUS )?
					int alt15=3;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==STAR) ) {
						alt15=1;
					}
					else if ( (LA15_0==PLUS) ) {
						alt15=2;
					}
					switch (alt15) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KG.g:139:51: r= STAR
							{
							r=(Token)match(input,STAR,FOLLOW_STAR_in_part1037);  
							stream_STAR.add(r);

							}
							break;
						case 2 :
							// src/core/koopa/core/grammars/generator/KG.g:139:60: r= PLUS
							{
							r=(Token)match(input,PLUS,FOLLOW_PLUS_in_part1043);  
							stream_PLUS.add(r);

							}
							break;

					}

					// AST REWRITE
					// elements: sequence, sequence, r, more, r, sequence, more, sequence
					// token labels: r
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 141:5: -> { r != null && m != null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) )
					if ( r != null && m != null ) {
						// src/core/koopa/core/grammars/generator/KG.g:141:36: ^( $r ^( OPTIONAL ^( CHOICE sequence ( more )* ) ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);
						// src/core/koopa/core/grammars/generator/KG.g:141:41: ^( OPTIONAL ^( CHOICE sequence ( more )* ) )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_2);
						// src/core/koopa/core/grammars/generator/KG.g:141:52: ^( CHOICE sequence ( more )* )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_3);
						adaptor.addChild(root_3, stream_sequence.nextTree());
						// src/core/koopa/core/grammars/generator/KG.g:141:70: ( more )*
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

					else // 142:5: -> { r != null && m == null }? ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) )
					if ( r != null && m == null ) {
						// src/core/koopa/core/grammars/generator/KG.g:142:36: ^( $r ^( OPTIONAL ^( CHOICE sequence ) ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_r.nextNode(), root_1);
						// src/core/koopa/core/grammars/generator/KG.g:142:41: ^( OPTIONAL ^( CHOICE sequence ) )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_2);
						// src/core/koopa/core/grammars/generator/KG.g:142:52: ^( CHOICE sequence )
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

					else // 143:5: -> { r == null && m != null }? ^( OPTIONAL ^( CHOICE sequence ( more )* ) )
					if ( r == null && m != null ) {
						// src/core/koopa/core/grammars/generator/KG.g:143:36: ^( OPTIONAL ^( CHOICE sequence ( more )* ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_1);
						// src/core/koopa/core/grammars/generator/KG.g:143:47: ^( CHOICE sequence ( more )* )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CHOICE, "CHOICE"), root_2);
						adaptor.addChild(root_2, stream_sequence.nextTree());
						// src/core/koopa/core/grammars/generator/KG.g:143:65: ( more )*
						while ( stream_more.hasNext() ) {
							adaptor.addChild(root_2, stream_more.nextTree());
						}
						stream_more.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}

					else // 144:5: -> ^( OPTIONAL sequence )
					{
						// src/core/koopa/core/grammars/generator/KG.g:144:8: ^( OPTIONAL sequence )
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
					// src/core/koopa/core/grammars/generator/KG.g:146:5: SKIP_TO part
					{
					SKIP_TO32=(Token)match(input,SKIP_TO,FOLLOW_SKIP_TO_in_part1135);  
					stream_SKIP_TO.add(SKIP_TO32);

					pushFollow(FOLLOW_part_in_part1137);
					part33=part();
					state._fsp--;

					stream_part.add(part33.getTree());
					// AST REWRITE
					// elements: part, SKIP_TO
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 148:5: -> ^( SKIP_TO part )
					{
						// src/core/koopa/core/grammars/generator/KG.g:148:8: ^( SKIP_TO part )
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
					// src/core/koopa/core/grammars/generator/KG.g:150:5: BANG OPEN_BRACKET sequence (m+= more )* CLOSE_BRACKET
					{
					BANG34=(Token)match(input,BANG,FOLLOW_BANG_in_part1161);  
					stream_BANG.add(BANG34);

					OPEN_BRACKET35=(Token)match(input,OPEN_BRACKET,FOLLOW_OPEN_BRACKET_in_part1163);  
					stream_OPEN_BRACKET.add(OPEN_BRACKET35);

					pushFollow(FOLLOW_sequence_in_part1165);
					sequence36=sequence();
					state._fsp--;

					stream_sequence.add(sequence36.getTree());
					// src/core/koopa/core/grammars/generator/KG.g:150:33: (m+= more )*
					loop16:
					while (true) {
						int alt16=2;
						int LA16_0 = input.LA(1);
						if ( (LA16_0==PIPE) ) {
							alt16=1;
						}

						switch (alt16) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KG.g:150:33: m+= more
							{
							pushFollow(FOLLOW_more_in_part1169);
							m=more();
							state._fsp--;

							stream_more.add(m.getTree());
							if (list_m==null) list_m=new ArrayList<Object>();
							list_m.add(m.getTree());
							}
							break;

						default :
							break loop16;
						}
					}

					CLOSE_BRACKET37=(Token)match(input,CLOSE_BRACKET,FOLLOW_CLOSE_BRACKET_in_part1172);  
					stream_CLOSE_BRACKET.add(CLOSE_BRACKET37);

					// AST REWRITE
					// elements: sequence, more, sequence
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 152:5: -> { m == null }? ^( OPTIONAL sequence )
					if ( m == null ) {
						// src/core/koopa/core/grammars/generator/KG.g:152:23: ^( OPTIONAL sequence )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_1);
						adaptor.addChild(root_1, stream_sequence.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}

					else // 153:5: -> ^( OPTIONAL ^( PERMUTED sequence ( more )* ) )
					{
						// src/core/koopa/core/grammars/generator/KG.g:153:8: ^( OPTIONAL ^( PERMUTED sequence ( more )* ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(OPTIONAL, "OPTIONAL"), root_1);
						// src/core/koopa/core/grammars/generator/KG.g:153:19: ^( PERMUTED sequence ( more )* )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PERMUTED, "PERMUTED"), root_2);
						adaptor.addChild(root_2, stream_sequence.nextTree());
						// src/core/koopa/core/grammars/generator/KG.g:153:39: ( more )*
						while ( stream_more.hasNext() ) {
							adaptor.addChild(root_2, stream_more.nextTree());
						}
						stream_more.reset();

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 12 :
					// src/core/koopa/core/grammars/generator/KG.g:155:5: BANG OPEN_PAREN sequence (m+= more )* CLOSE_PAREN
					{
					BANG38=(Token)match(input,BANG,FOLLOW_BANG_in_part1219);  
					stream_BANG.add(BANG38);

					OPEN_PAREN39=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_part1221);  
					stream_OPEN_PAREN.add(OPEN_PAREN39);

					pushFollow(FOLLOW_sequence_in_part1223);
					sequence40=sequence();
					state._fsp--;

					stream_sequence.add(sequence40.getTree());
					// src/core/koopa/core/grammars/generator/KG.g:155:31: (m+= more )*
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( (LA17_0==PIPE) ) {
							alt17=1;
						}

						switch (alt17) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KG.g:155:31: m+= more
							{
							pushFollow(FOLLOW_more_in_part1227);
							m=more();
							state._fsp--;

							stream_more.add(m.getTree());
							if (list_m==null) list_m=new ArrayList<Object>();
							list_m.add(m.getTree());
							}
							break;

						default :
							break loop17;
						}
					}

					CLOSE_PAREN41=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_part1230);  
					stream_CLOSE_PAREN.add(CLOSE_PAREN41);

					// AST REWRITE
					// elements: more, sequence, sequence
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 157:5: -> { m == null }? sequence
					if ( m == null ) {
						adaptor.addChild(root_0, stream_sequence.nextTree());
					}

					else // 158:5: -> ^( PERMUTED sequence ( more )* )
					{
						// src/core/koopa/core/grammars/generator/KG.g:158:8: ^( PERMUTED sequence ( more )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PERMUTED, "PERMUTED"), root_1);
						adaptor.addChild(root_1, stream_sequence.nextTree());
						// src/core/koopa/core/grammars/generator/KG.g:158:28: ( more )*
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
				case 13 :
					// src/core/koopa/core/grammars/generator/KG.g:160:5: DOLLAR OPEN_PAREN dispatch (m+= more_dispatch )* CLOSE_PAREN
					{
					DOLLAR42=(Token)match(input,DOLLAR,FOLLOW_DOLLAR_in_part1269);  
					stream_DOLLAR.add(DOLLAR42);

					OPEN_PAREN43=(Token)match(input,OPEN_PAREN,FOLLOW_OPEN_PAREN_in_part1271);  
					stream_OPEN_PAREN.add(OPEN_PAREN43);

					pushFollow(FOLLOW_dispatch_in_part1273);
					dispatch44=dispatch();
					state._fsp--;

					stream_dispatch.add(dispatch44.getTree());
					// src/core/koopa/core/grammars/generator/KG.g:160:33: (m+= more_dispatch )*
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( (LA18_0==PIPE) ) {
							alt18=1;
						}

						switch (alt18) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KG.g:160:33: m+= more_dispatch
							{
							pushFollow(FOLLOW_more_dispatch_in_part1277);
							m=more_dispatch();
							state._fsp--;

							stream_more_dispatch.add(m.getTree());
							if (list_m==null) list_m=new ArrayList<Object>();
							list_m.add(m.getTree());
							}
							break;

						default :
							break loop18;
						}
					}

					CLOSE_PAREN45=(Token)match(input,CLOSE_PAREN,FOLLOW_CLOSE_PAREN_in_part1280);  
					stream_CLOSE_PAREN.add(CLOSE_PAREN45);

					// AST REWRITE
					// elements: dispatch, dispatch, more_dispatch
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 162:5: -> { m == null }? ^( DISPATCHED dispatch )
					if ( m == null ) {
						// src/core/koopa/core/grammars/generator/KG.g:162:23: ^( DISPATCHED dispatch )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DISPATCHED, "DISPATCHED"), root_1);
						adaptor.addChild(root_1, stream_dispatch.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}

					else // 163:5: -> ^( DISPATCHED dispatch ( more_dispatch )* )
					{
						// src/core/koopa/core/grammars/generator/KG.g:163:8: ^( DISPATCHED dispatch ( more_dispatch )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DISPATCHED, "DISPATCHED"), root_1);
						adaptor.addChild(root_1, stream_dispatch.nextTree());
						// src/core/koopa/core/grammars/generator/KG.g:163:30: ( more_dispatch )*
						while ( stream_more_dispatch.hasNext() ) {
							adaptor.addChild(root_1, stream_more_dispatch.nextTree());
						}
						stream_more_dispatch.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 14 :
					// src/core/koopa/core/grammars/generator/KG.g:165:5: NOT part
					{
					NOT46=(Token)match(input,NOT,FOLLOW_NOT_in_part1323);  
					stream_NOT.add(NOT46);

					pushFollow(FOLLOW_part_in_part1325);
					part47=part();
					state._fsp--;

					stream_part.add(part47.getTree());
					// AST REWRITE
					// elements: NOT, part
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 166:5: -> ^( NOT part )
					{
						// src/core/koopa/core/grammars/generator/KG.g:166:8: ^( NOT part )
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
				case 15 :
					// src/core/koopa/core/grammars/generator/KG.g:168:5: NOSKIP part
					{
					NOSKIP48=(Token)match(input,NOSKIP,FOLLOW_NOSKIP_in_part1344);  
					stream_NOSKIP.add(NOSKIP48);

					pushFollow(FOLLOW_part_in_part1346);
					part49=part();
					state._fsp--;

					stream_part.add(part49.getTree());
					// AST REWRITE
					// elements: NOSKIP, part
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 169:3: -> ^( NOSKIP part )
					{
						// src/core/koopa/core/grammars/generator/KG.g:169:6: ^( NOSKIP part )
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
				case 16 :
					// src/core/koopa/core/grammars/generator/KG.g:171:5: LIMIT part BY part
					{
					LIMIT50=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_part1363);  
					stream_LIMIT.add(LIMIT50);

					pushFollow(FOLLOW_part_in_part1365);
					part51=part();
					state._fsp--;

					stream_part.add(part51.getTree());
					BY52=(Token)match(input,BY,FOLLOW_BY_in_part1367);  
					stream_BY.add(BY52);

					pushFollow(FOLLOW_part_in_part1369);
					part53=part();
					state._fsp--;

					stream_part.add(part53.getTree());
					// AST REWRITE
					// elements: part, LIMIT, part
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 172:3: -> ^( LIMIT part part )
					{
						// src/core/koopa/core/grammars/generator/KG.g:172:6: ^( LIMIT part part )
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
				case 17 :
					// src/core/koopa/core/grammars/generator/KG.g:174:5: WITH p= part SKIP_TO q= part
					{
					WITH54=(Token)match(input,WITH,FOLLOW_WITH_in_part1388);  
					stream_WITH.add(WITH54);

					pushFollow(FOLLOW_part_in_part1392);
					p=part();
					state._fsp--;

					stream_part.add(p.getTree());
					SKIP_TO55=(Token)match(input,SKIP_TO,FOLLOW_SKIP_TO_in_part1394);  
					stream_SKIP_TO.add(SKIP_TO55);

					pushFollow(FOLLOW_part_in_part1398);
					q=part();
					state._fsp--;

					stream_part.add(q.getTree());
					// AST REWRITE
					// elements: q, p, q, SKIP_TO
					// token labels: 
					// rule labels: p, q, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.getTree():null);
					RewriteRuleSubtreeStream stream_q=new RewriteRuleSubtreeStream(adaptor,"rule q",q!=null?q.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 175:3: -> ^( SEQUENCE ^( LIMIT $p $q) ^( SKIP_TO $q) )
					{
						// src/core/koopa/core/grammars/generator/KG.g:175:6: ^( SEQUENCE ^( LIMIT $p $q) ^( SKIP_TO $q) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SEQUENCE, "SEQUENCE"), root_1);
						// src/core/koopa/core/grammars/generator/KG.g:176:8: ^( LIMIT $p $q)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIMIT, "LIMIT"), root_2);
						adaptor.addChild(root_2, stream_p.nextTree());
						adaptor.addChild(root_2, stream_q.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// src/core/koopa/core/grammars/generator/KG.g:177:8: ^( SKIP_TO $q)
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot(stream_SKIP_TO.nextNode(), root_2);
						adaptor.addChild(root_2, stream_q.nextTree());
						adaptor.addChild(root_1, root_2);
						}

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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "part"


	public static class more_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "more"
	// src/core/koopa/core/grammars/generator/KG.g:180:1: more : PIPE sequence -> sequence ;
	public final KGParser.more_return more() throws RecognitionException {
		KGParser.more_return retval = new KGParser.more_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token PIPE56=null;
		ParserRuleReturnScope sequence57 =null;

		CommonTree PIPE56_tree=null;
		RewriteRuleTokenStream stream_PIPE=new RewriteRuleTokenStream(adaptor,"token PIPE");
		RewriteRuleSubtreeStream stream_sequence=new RewriteRuleSubtreeStream(adaptor,"rule sequence");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:181:3: ( PIPE sequence -> sequence )
			// src/core/koopa/core/grammars/generator/KG.g:181:5: PIPE sequence
			{
			PIPE56=(Token)match(input,PIPE,FOLLOW_PIPE_in_more1450);  
			stream_PIPE.add(PIPE56);

			pushFollow(FOLLOW_sequence_in_more1452);
			sequence57=sequence();
			state._fsp--;

			stream_sequence.add(sequence57.getTree());
			// AST REWRITE
			// elements: sequence
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 183:5: -> sequence
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "more"


	public static class dispatch_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dispatch"
	// src/core/koopa/core/grammars/generator/KG.g:186:1: dispatch : IDENTIFIER ARROW sequence -> ^( CASE IDENTIFIER sequence ) ;
	public final KGParser.dispatch_return dispatch() throws RecognitionException {
		KGParser.dispatch_return retval = new KGParser.dispatch_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENTIFIER58=null;
		Token ARROW59=null;
		ParserRuleReturnScope sequence60 =null;

		CommonTree IDENTIFIER58_tree=null;
		CommonTree ARROW59_tree=null;
		RewriteRuleTokenStream stream_ARROW=new RewriteRuleTokenStream(adaptor,"token ARROW");
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
		RewriteRuleSubtreeStream stream_sequence=new RewriteRuleSubtreeStream(adaptor,"rule sequence");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:187:3: ( IDENTIFIER ARROW sequence -> ^( CASE IDENTIFIER sequence ) )
			// src/core/koopa/core/grammars/generator/KG.g:187:5: IDENTIFIER ARROW sequence
			{
			IDENTIFIER58=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_dispatch1478);  
			stream_IDENTIFIER.add(IDENTIFIER58);

			ARROW59=(Token)match(input,ARROW,FOLLOW_ARROW_in_dispatch1480);  
			stream_ARROW.add(ARROW59);

			pushFollow(FOLLOW_sequence_in_dispatch1482);
			sequence60=sequence();
			state._fsp--;

			stream_sequence.add(sequence60.getTree());
			// AST REWRITE
			// elements: sequence, IDENTIFIER
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 189:5: -> ^( CASE IDENTIFIER sequence )
			{
				// src/core/koopa/core/grammars/generator/KG.g:189:8: ^( CASE IDENTIFIER sequence )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CASE, "CASE"), root_1);
				adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dispatch"


	public static class more_dispatch_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "more_dispatch"
	// src/core/koopa/core/grammars/generator/KG.g:192:1: more_dispatch : PIPE dispatch -> dispatch ;
	public final KGParser.more_dispatch_return more_dispatch() throws RecognitionException {
		KGParser.more_dispatch_return retval = new KGParser.more_dispatch_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token PIPE61=null;
		ParserRuleReturnScope dispatch62 =null;

		CommonTree PIPE61_tree=null;
		RewriteRuleTokenStream stream_PIPE=new RewriteRuleTokenStream(adaptor,"token PIPE");
		RewriteRuleSubtreeStream stream_dispatch=new RewriteRuleSubtreeStream(adaptor,"rule dispatch");

		try {
			// src/core/koopa/core/grammars/generator/KG.g:193:3: ( PIPE dispatch -> dispatch )
			// src/core/koopa/core/grammars/generator/KG.g:193:5: PIPE dispatch
			{
			PIPE61=(Token)match(input,PIPE,FOLLOW_PIPE_in_more_dispatch1514);  
			stream_PIPE.add(PIPE61);

			pushFollow(FOLLOW_dispatch_in_more_dispatch1516);
			dispatch62=dispatch();
			state._fsp--;

			stream_dispatch.add(dispatch62.getTree());
			// AST REWRITE
			// elements: dispatch
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 195:5: -> dispatch
			{
				adaptor.addChild(root_0, stream_dispatch.nextTree());
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
	// $ANTLR end "more_dispatch"

	// Delegated rules



	public static final BitSet FOLLOW_meta_in_koopa146 = new BitSet(new long[]{0x0040180000000000L});
	public static final BitSet FOLLOW_rule_in_koopa155 = new BitSet(new long[]{0x0040180000000000L});
	public static final BitSet FOLLOW_EOF_in_koopa158 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_meta192 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_meta196 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_meta200 = new BitSet(new long[]{0x0100000000200000L});
	public static final BitSet FOLLOW_56_in_meta207 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_meta211 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_DOT_in_meta219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PUBLIC_in_modifier329 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRIVATE_in_modifier342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_modifier_in_rule364 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_rule368 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_rule372 = new BitSet(new long[]{0x0400004000400000L});
	public static final BitSet FOLLOW_OPEN_PAREN_in_rule381 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_locals_in_rule385 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CLOSE_PAREN_in_rule387 = new BitSet(new long[]{0x0400000000400000L});
	public static final BitSet FOLLOW_58_in_rule398 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_rule402 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_EQUALS_in_rule406 = new BitSet(new long[]{0x0025007D1A300120L});
	public static final BitSet FOLLOW_sequence_in_rule417 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_rule426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_in_locals686 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_COMMA_in_locals689 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_declaration_in_locals691 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration720 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_part_in_sequence752 = new BitSet(new long[]{0x0025007D1A300122L});
	public static final BitSet FOLLOW_NATIVE_CODE_in_part793 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TAG_in_part818 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ANY_in_part825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LITERAL_in_part832 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_part839 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_part850 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_EQUALS_in_part860 = new BitSet(new long[]{0x0000001002200020L});
	public static final BitSet FOLLOW_IDENTIFIER_in_part865 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_part871 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_part877 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ANY_in_part883 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_part924 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_PAREN_in_part931 = new BitSet(new long[]{0x0025007D1A300120L});
	public static final BitSet FOLLOW_sequence_in_part933 = new BitSet(new long[]{0x0000020000004000L});
	public static final BitSet FOLLOW_more_in_part937 = new BitSet(new long[]{0x0000020000004000L});
	public static final BitSet FOLLOW_CLOSE_PAREN_in_part940 = new BitSet(new long[]{0x0002040000000002L});
	public static final BitSet FOLLOW_STAR_in_part945 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_part951 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_BRACKET_in_part1023 = new BitSet(new long[]{0x0025007D1A300120L});
	public static final BitSet FOLLOW_sequence_in_part1025 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_more_in_part1029 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_CLOSE_BRACKET_in_part1032 = new BitSet(new long[]{0x0002040000000002L});
	public static final BitSet FOLLOW_STAR_in_part1037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_part1043 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SKIP_TO_in_part1135 = new BitSet(new long[]{0x0025007D1A300120L});
	public static final BitSet FOLLOW_part_in_part1137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_part1161 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_OPEN_BRACKET_in_part1163 = new BitSet(new long[]{0x0025007D1A300120L});
	public static final BitSet FOLLOW_sequence_in_part1165 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_more_in_part1169 = new BitSet(new long[]{0x0000020000002000L});
	public static final BitSet FOLLOW_CLOSE_BRACKET_in_part1172 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_part1219 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_OPEN_PAREN_in_part1221 = new BitSet(new long[]{0x0025007D1A300120L});
	public static final BitSet FOLLOW_sequence_in_part1223 = new BitSet(new long[]{0x0000020000004000L});
	public static final BitSet FOLLOW_more_in_part1227 = new BitSet(new long[]{0x0000020000004000L});
	public static final BitSet FOLLOW_CLOSE_PAREN_in_part1230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOLLAR_in_part1269 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_OPEN_PAREN_in_part1271 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_dispatch_in_part1273 = new BitSet(new long[]{0x0000020000004000L});
	public static final BitSet FOLLOW_more_dispatch_in_part1277 = new BitSet(new long[]{0x0000020000004000L});
	public static final BitSet FOLLOW_CLOSE_PAREN_in_part1280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_part1323 = new BitSet(new long[]{0x0025007D1A300120L});
	public static final BitSet FOLLOW_part_in_part1325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOSKIP_in_part1344 = new BitSet(new long[]{0x0025007D1A300120L});
	public static final BitSet FOLLOW_part_in_part1346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LIMIT_in_part1363 = new BitSet(new long[]{0x0025007D1A300120L});
	public static final BitSet FOLLOW_part_in_part1365 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_BY_in_part1367 = new BitSet(new long[]{0x0025007D1A300120L});
	public static final BitSet FOLLOW_part_in_part1369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WITH_in_part1388 = new BitSet(new long[]{0x0025007D1A300120L});
	public static final BitSet FOLLOW_part_in_part1392 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_SKIP_TO_in_part1394 = new BitSet(new long[]{0x0025007D1A300120L});
	public static final BitSet FOLLOW_part_in_part1398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PIPE_in_more1450 = new BitSet(new long[]{0x0025007D1A300120L});
	public static final BitSet FOLLOW_sequence_in_more1452 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_dispatch1478 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ARROW_in_dispatch1480 = new BitSet(new long[]{0x0025007D1A300120L});
	public static final BitSet FOLLOW_sequence_in_dispatch1482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PIPE_in_more_dispatch1514 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_dispatch_in_more_dispatch1516 = new BitSet(new long[]{0x0000000000000002L});
}
