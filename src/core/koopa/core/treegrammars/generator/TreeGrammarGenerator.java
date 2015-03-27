// $ANTLR 3.5.2 src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g

  package koopa.core.treegrammars.generator;
  
  import java.util.Collections;
  import java.util.Date;
  import java.util.List;
  import java.util.LinkedList;
  import java.util.Set;
  import java.util.HashSet;
  import java.util.Properties;

  import koopa.core.util.Tuple;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
@SuppressWarnings("all")
public class TreeGrammarGenerator extends TreeParser {
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
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public TreeGrammarGenerator(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public TreeGrammarGenerator(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected StringTemplateGroup templateLib =
	  new StringTemplateGroup("TreeGrammarGeneratorTemplates", AngleBracketTemplateLexer.class);

	public void setTemplateLib(StringTemplateGroup templateLib) {
	  this.templateLib = templateLib;
	}
	public StringTemplateGroup getTemplateLib() {
	  return templateLib;
	}
	/** allows convenient multi-value initialization:
	 *  "new STAttrMap().put(...).put(...)"
	 */
	@SuppressWarnings("serial")
	public static class STAttrMap extends HashMap<String, Object> {
		public STAttrMap put(String attrName, Object value) {
			super.put(attrName, value);
			return this;
		}
	}
	@Override public String[] getTokenNames() { return TreeGrammarGenerator.tokenNames; }
	@Override public String getGrammarFileName() { return "src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g"; }




	public static class koopa_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "koopa"
	// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:27:1: koopa[Properties p, String imports] : ^( GRAMMAR meta[p] (r+= rule )* ) -> treegrammar(name=p.getProperty(\"named\")extending=p.getProperty(\"extending\")date=new Date()package=p.getProperty(\"package\")imports=importsrule=$r);
	public final TreeGrammarGenerator.koopa_return koopa(Properties p, String imports) throws RecognitionException {
		TreeGrammarGenerator.koopa_return retval = new TreeGrammarGenerator.koopa_return();
		retval.start = input.LT(1);

		List<Object> list_r=null;
		RuleReturnScope r = null;
		try {
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:28:3: ( ^( GRAMMAR meta[p] (r+= rule )* ) -> treegrammar(name=p.getProperty(\"named\")extending=p.getProperty(\"extending\")date=new Date()package=p.getProperty(\"package\")imports=importsrule=$r))
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:28:5: ^( GRAMMAR meta[p] (r+= rule )* )
			{
			match(input,GRAMMAR,FOLLOW_GRAMMAR_in_koopa68); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_meta_in_koopa76);
			meta(p);
			state._fsp--;

			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:30:7: (r+= rule )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==RULE) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:30:8: r+= rule
					{
					pushFollow(FOLLOW_rule_in_koopa88);
					r=rule();
					state._fsp--;

					if (list_r==null) list_r=new ArrayList<Object>();
					list_r.add(r.getTemplate());
					}
					break;

				default :
					break loop1;
				}
			}

			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 33:5: -> treegrammar(name=p.getProperty(\"named\")extending=p.getProperty(\"extending\")date=new Date()package=p.getProperty(\"package\")imports=importsrule=$r)
			{
				retval.st = templateLib.getInstanceOf("treegrammar",new STAttrMap().put("name", p.getProperty("named")).put("extending", p.getProperty("extending")).put("date", new Date()).put("package", p.getProperty("package")).put("imports", imports).put("rule", list_r));
			}



			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "koopa"


	public static class meta_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "meta"
	// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:44:1: meta[ Properties meta ] : ^( META TREE n= named (e= extending )? ) ;
	public final TreeGrammarGenerator.meta_return meta(Properties meta) throws RecognitionException {
		TreeGrammarGenerator.meta_return retval = new TreeGrammarGenerator.meta_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope n =null;
		TreeRuleReturnScope e =null;

		try {
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:45:3: ( ^( META TREE n= named (e= extending )? ) )
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:45:5: ^( META TREE n= named (e= extending )? )
			{
			match(input,META,FOLLOW_META_in_meta204); 
			match(input, Token.DOWN, null); 
			match(input,TREE,FOLLOW_TREE_in_meta206); 
			pushFollow(FOLLOW_named_in_meta210);
			n=named();
			state._fsp--;

			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:45:25: (e= extending )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==EXTENDING) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:45:26: e= extending
					{
					pushFollow(FOLLOW_extending_in_meta215);
					e=extending();
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 

			 meta.setProperty("named", (n!=null?((TreeGrammarGenerator.named_return)n).name:null));
			    
			      if (e != null) meta.setProperty("extending", (e!=null?((TreeGrammarGenerator.extending_return)e).name:null));
			      else meta.setProperty("extending", "Tree");
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "meta"


	public static class named_return extends TreeRuleReturnScope {
		public String name = null;
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "named"
	// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:54:1: named returns [String name = null] : ^( NAMED i= IDENTIFIER ) ;
	public final TreeGrammarGenerator.named_return named() throws RecognitionException {
		TreeGrammarGenerator.named_return retval = new TreeGrammarGenerator.named_return();
		retval.start = input.LT(1);

		CommonTree i=null;

		try {
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:55:3: ( ^( NAMED i= IDENTIFIER ) )
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:55:5: ^( NAMED i= IDENTIFIER )
			{
			match(input,NAMED,FOLLOW_NAMED_in_named247); 
			match(input, Token.DOWN, null); 
			i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_named251); 
			match(input, Token.UP, null); 

			 retval.name = ((CommonTree) i).getText(); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "named"


	public static class extending_return extends TreeRuleReturnScope {
		public String name = null;
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "extending"
	// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:60:1: extending returns [String name = null] : ^( EXTENDING i= IDENTIFIER ) ;
	public final TreeGrammarGenerator.extending_return extending() throws RecognitionException {
		TreeGrammarGenerator.extending_return retval = new TreeGrammarGenerator.extending_return();
		retval.start = input.LT(1);

		CommonTree i=null;

		try {
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:61:3: ( ^( EXTENDING i= IDENTIFIER ) )
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:61:5: ^( EXTENDING i= IDENTIFIER )
			{
			match(input,EXTENDING,FOLLOW_EXTENDING_in_extending279); 
			match(input, Token.DOWN, null); 
			i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_extending283); 
			match(input, Token.UP, null); 

			 retval.name = ((CommonTree) i).getText(); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "extending"


	public static class rule_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "rule"
	// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:67:1: rule : ^( RULE ( PUBLIC | PRIVATE ) n= IDENTIFIER (l= locals )? (r= returning )? b= body[bindings, unbindings] ) -> rule(name=$nbody=bod);
	public final TreeGrammarGenerator.rule_return rule() throws RecognitionException {
		TreeGrammarGenerator.rule_return retval = new TreeGrammarGenerator.rule_return();
		retval.start = input.LT(1);

		CommonTree n=null;
		TreeRuleReturnScope l =null;
		TreeRuleReturnScope r =null;
		TreeRuleReturnScope b =null;

		try {
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:68:3: ( ^( RULE ( PUBLIC | PRIVATE ) n= IDENTIFIER (l= locals )? (r= returning )? b= body[bindings, unbindings] ) -> rule(name=$nbody=bod))
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:68:5: ^( RULE ( PUBLIC | PRIVATE ) n= IDENTIFIER (l= locals )? (r= returning )? b= body[bindings, unbindings] )
			{
			 List<String> bindings = null;
			      List<String> unbindings = null;
			      StringTemplate bod = null;
			    
			match(input,RULE,FOLLOW_RULE_in_rule314); 
			match(input, Token.DOWN, null); 
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:73:7: ( PUBLIC | PRIVATE )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==PUBLIC) ) {
				alt3=1;
			}
			else if ( (LA3_0==PRIVATE) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:73:8: PUBLIC
					{
					match(input,PUBLIC,FOLLOW_PUBLIC_in_rule324); 
					}
					break;
				case 2 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:73:17: PRIVATE
					{
					match(input,PRIVATE,FOLLOW_PRIVATE_in_rule328); 
					}
					break;

			}

			n=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule339); 
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:76:7: (l= locals )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==LOCALS) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:76:8: l= locals
					{
					pushFollow(FOLLOW_locals_in_rule357);
					l=locals();
					state._fsp--;

					 bindings = new LinkedList<String>();
					          unbindings = new LinkedList<String>();
					          
					          for(Tuple<String, String> tuple : (l!=null?((TreeGrammarGenerator.locals_return)l).tuples:null)) {
					            String type = tuple.getFirst();
					            String name = tuple.getSecond();

					            bindings.add(templateLib.getInstanceOf("bind",new STAttrMap().put("name", name).put("type", type)).toString());
					            
					            unbindings.add(templateLib.getInstanceOf("unbind",new STAttrMap().put("name", name)).toString());
					          }
					        
					}
					break;

			}

			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:96:7: (r= returning )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==RETURNS) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:96:8: r= returning
					{
					pushFollow(FOLLOW_returning_in_rule394);
					r=returning();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_body_in_rule413);
			b=body(bindings, unbindings);
			state._fsp--;

			 if (r != null) {
			          List<StringTemplate> steps = new LinkedList<StringTemplate>();
			          steps.add((b!=null?((StringTemplate)b.getTemplate()):null));
			          steps.add((r!=null?((StringTemplate)r.getTemplate()):null));
			          bod = templateLib.getInstanceOf("sequence",new STAttrMap().put("step", steps));
			          
			        } else {
			          bod = (b!=null?((StringTemplate)b.getTemplate()):null);
			        }
			      
			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 113:5: -> rule(name=$nbody=bod)
			{
				retval.st = templateLib.getInstanceOf("rule",new STAttrMap().put("name", n).put("body", bod));
			}



			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rule"


	public static class returning_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "returning"
	// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:119:1: returning : ^( RETURNS i= IDENTIFIER ) -> returning(name=((CommonTree) $i).getText());
	public final TreeGrammarGenerator.returning_return returning() throws RecognitionException {
		TreeGrammarGenerator.returning_return retval = new TreeGrammarGenerator.returning_return();
		retval.start = input.LT(1);

		CommonTree i=null;

		try {
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:120:3: ( ^( RETURNS i= IDENTIFIER ) -> returning(name=((CommonTree) $i).getText()))
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:120:5: ^( RETURNS i= IDENTIFIER )
			{
			match(input,RETURNS,FOLLOW_RETURNS_in_returning485); 
			match(input, Token.DOWN, null); 
			i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_returning489); 
			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 122:5: -> returning(name=((CommonTree) $i).getText())
			{
				retval.st = templateLib.getInstanceOf("returning",new STAttrMap().put("name", ((CommonTree) i).getText()));
			}



			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "returning"


	public static class locals_return extends TreeRuleReturnScope {
		public List<Tuple<String, String>> tuples = new LinkedList<Tuple<String, String>>();
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "locals"
	// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:127:1: locals returns [List<Tuple<String, String>> tuples = new LinkedList<Tuple<String, String>>()] : ^( LOCALS (d= declaration )+ ) ;
	public final TreeGrammarGenerator.locals_return locals() throws RecognitionException {
		TreeGrammarGenerator.locals_return retval = new TreeGrammarGenerator.locals_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope d =null;

		try {
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:128:3: ( ^( LOCALS (d= declaration )+ ) )
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:128:5: ^( LOCALS (d= declaration )+ )
			{
			match(input,LOCALS,FOLLOW_LOCALS_in_locals538); 
			match(input, Token.DOWN, null); 
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:129:7: (d= declaration )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==DECLARATION) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:129:8: d= declaration
					{
					pushFollow(FOLLOW_declaration_in_locals549);
					d=declaration();
					state._fsp--;

					 retval.tuples.add((d!=null?((TreeGrammarGenerator.declaration_return)d).tuple:null)); 
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "locals"


	public static class declaration_return extends TreeRuleReturnScope {
		public Tuple<String, String> tuple = null;
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "declaration"
	// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:135:1: declaration returns [Tuple<String, String> tuple = null] : ^( DECLARATION a= IDENTIFIER b= IDENTIFIER ) ;
	public final TreeGrammarGenerator.declaration_return declaration() throws RecognitionException {
		TreeGrammarGenerator.declaration_return retval = new TreeGrammarGenerator.declaration_return();
		retval.start = input.LT(1);

		CommonTree a=null;
		CommonTree b=null;

		try {
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:136:3: ( ^( DECLARATION a= IDENTIFIER b= IDENTIFIER ) )
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:136:5: ^( DECLARATION a= IDENTIFIER b= IDENTIFIER )
			{
			match(input,DECLARATION,FOLLOW_DECLARATION_in_declaration592); 
			match(input, Token.DOWN, null); 
			a=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration596); 
			b=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration600); 
			match(input, Token.UP, null); 

			 retval.tuple = new Tuple<String, String>(((CommonTree) a).getText(), ((CommonTree) b).getText()); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declaration"


	public static class body_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "body"
	// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:140:1: body[ List<String> bindings, List<String> unbindings ] : ( ^( SEQUENCE (b= body[bindings, unbindings] )+ ) -> sequence(step=steps)| ^( ACT n= NATIVE_CODE ) -> apply(bind=bindingsunbind=unbindingsnative_code=n)| ANY -> any(| TAG |i= IDENTIFIER -> {isLowerCase}? call(name=i) -> token(text=i)|l= LITERAL |n= NUMBER |d= DOT -> token(text=d)| ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER |n= NUMBER |d= DOT |a= ANY ) ) -> assign(name=lvalue=body)| ^( STAR b= body[bindings, unbindings] ) -> star(body=b)| ^( PLUS b= body[bindings, unbindings] ) -> plus(body=b)| ^( CHOICE (b= body[bindings, unbindings] )+ ) -> choice(step=steps)| ^( OPTIONAL b= body[bindings, unbindings] ) -> opt(body=b)| ^( SKIP_TO body[bindings, unbindings] ) | ^( NOT body[bindings, unbindings] ) | ^( NOSKIP ( body[bindings, unbindings] )+ ) | ^( PERMUTED ( body[bindings, unbindings] )+ ) | ^( LIMIT b_t= body[bindings, unbindings] b_l= body[bindings, unbindings] ) -> limit(target=b_tlimiter=b_l));
	public final TreeGrammarGenerator.body_return body(List<String> bindings, List<String> unbindings) throws RecognitionException {
		TreeGrammarGenerator.body_return retval = new TreeGrammarGenerator.body_return();
		retval.start = input.LT(1);

		CommonTree n=null;
		CommonTree i=null;
		CommonTree l=null;
		CommonTree d=null;
		CommonTree a=null;
		TreeRuleReturnScope b =null;
		TreeRuleReturnScope b_t =null;
		TreeRuleReturnScope b_l =null;

		try {
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:141:3: ( ^( SEQUENCE (b= body[bindings, unbindings] )+ ) -> sequence(step=steps)| ^( ACT n= NATIVE_CODE ) -> apply(bind=bindingsunbind=unbindingsnative_code=n)| ANY -> any(| TAG |i= IDENTIFIER -> {isLowerCase}? call(name=i) -> token(text=i)|l= LITERAL |n= NUMBER |d= DOT -> token(text=d)| ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER |n= NUMBER |d= DOT |a= ANY ) ) -> assign(name=lvalue=body)| ^( STAR b= body[bindings, unbindings] ) -> star(body=b)| ^( PLUS b= body[bindings, unbindings] ) -> plus(body=b)| ^( CHOICE (b= body[bindings, unbindings] )+ ) -> choice(step=steps)| ^( OPTIONAL b= body[bindings, unbindings] ) -> opt(body=b)| ^( SKIP_TO body[bindings, unbindings] ) | ^( NOT body[bindings, unbindings] ) | ^( NOSKIP ( body[bindings, unbindings] )+ ) | ^( PERMUTED ( body[bindings, unbindings] )+ ) | ^( LIMIT b_t= body[bindings, unbindings] b_l= body[bindings, unbindings] ) -> limit(target=b_tlimiter=b_l))
			int alt12=18;
			switch ( input.LA(1) ) {
			case SEQUENCE:
				{
				alt12=1;
				}
				break;
			case ACT:
				{
				alt12=2;
				}
				break;
			case ANY:
				{
				alt12=3;
				}
				break;
			case TAG:
				{
				alt12=4;
				}
				break;
			case IDENTIFIER:
				{
				alt12=5;
				}
				break;
			case LITERAL:
				{
				alt12=6;
				}
				break;
			case NUMBER:
				{
				alt12=7;
				}
				break;
			case DOT:
				{
				alt12=8;
				}
				break;
			case ASSIGN:
				{
				alt12=9;
				}
				break;
			case STAR:
				{
				alt12=10;
				}
				break;
			case PLUS:
				{
				alt12=11;
				}
				break;
			case CHOICE:
				{
				alt12=12;
				}
				break;
			case OPTIONAL:
				{
				alt12=13;
				}
				break;
			case SKIP_TO:
				{
				alt12=14;
				}
				break;
			case NOT:
				{
				alt12=15;
				}
				break;
			case NOSKIP:
				{
				alt12=16;
				}
				break;
			case PERMUTED:
				{
				alt12=17;
				}
				break;
			case LIMIT:
				{
				alt12=18;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:141:5: ^( SEQUENCE (b= body[bindings, unbindings] )+ )
					{
					 List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
					match(input,SEQUENCE,FOLLOW_SEQUENCE_in_body629); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:143:7: (b= body[bindings, unbindings] )+
					int cnt7=0;
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( ((LA7_0 >= ACT && LA7_0 <= ANY)||LA7_0==ASSIGN||LA7_0==CHOICE||LA7_0==DOT||LA7_0==IDENTIFIER||(LA7_0 >= LIMIT && LA7_0 <= LITERAL)||(LA7_0 >= NOSKIP && LA7_0 <= NUMBER)||(LA7_0 >= OPTIONAL && LA7_0 <= PERMUTED)||LA7_0==PLUS||(LA7_0 >= SEQUENCE && LA7_0 <= TAG)) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:143:8: b= body[bindings, unbindings]
							{
							pushFollow(FOLLOW_body_in_body641);
							b=body(bindings, unbindings);
							state._fsp--;

							 steps.add((b!=null?((StringTemplate)b.getTemplate()):null)); 
							}
							break;

						default :
							if ( cnt7 >= 1 ) break loop7;
							EarlyExitException eee = new EarlyExitException(7, input);
							throw eee;
						}
						cnt7++;
					}

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 148:5: -> sequence(step=steps)
					{
						retval.st = templateLib.getInstanceOf("sequence",new STAttrMap().put("step", steps));
					}



					}
					break;
				case 2 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:152:5: ^( ACT n= NATIVE_CODE )
					{
					match(input,ACT,FOLLOW_ACT_in_body709); 
					match(input, Token.DOWN, null); 
					n=(CommonTree)match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_body713); 
					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 154:5: -> apply(bind=bindingsunbind=unbindingsnative_code=n)
					{
						retval.st = templateLib.getInstanceOf("apply",new STAttrMap().put("bind", bindings).put("unbind", unbindings).put("native_code", n));
					}



					}
					break;
				case 3 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:160:5: ANY
					{
					match(input,ANY,FOLLOW_ANY_in_body781); 
					// TEMPLATE REWRITE
					// 162:5: -> any(
					{
						retval.st = templateLib.getInstanceOf("any");
					}



					}
					break;
				case 4 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:164:5: TAG
					{
					match(input,TAG,FOLLOW_TAG_in_body799); 
					}
					break;
				case 5 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:166:5: i= IDENTIFIER
					{
					i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body808); 
					 String text = ((CommonTree) i).getText();
					 	  boolean isLowerCase = Character.isLowerCase(text.charAt(0));
					    
					// TEMPLATE REWRITE
					// 172:5: -> {isLowerCase}? call(name=i)
					if (isLowerCase) {
						retval.st = templateLib.getInstanceOf("call",new STAttrMap().put("name", i));
					}

					else // 176:5: -> token(text=i)
					{
						retval.st = templateLib.getInstanceOf("token",new STAttrMap().put("text", i));
					}



					}
					break;
				case 6 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:180:5: l= LITERAL
					{
					l=(CommonTree)match(input,LITERAL,FOLLOW_LITERAL_in_body890); 
					}
					break;
				case 7 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:182:5: n= NUMBER
					{
					n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body899); 
					}
					break;
				case 8 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:184:5: d= DOT
					{
					d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body910); 
					// TEMPLATE REWRITE
					// 186:5: -> token(text=d)
					{
						retval.st = templateLib.getInstanceOf("token",new STAttrMap().put("text", d));
					}



					}
					break;
				case 9 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:190:5: ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER |n= NUMBER |d= DOT |a= ANY ) )
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_body954); 
					match(input, Token.DOWN, null); 
					l=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body958); 
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:190:27: (i= IDENTIFIER |n= NUMBER |d= DOT |a= ANY )
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
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:190:28: i= IDENTIFIER
							{
							i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body963); 
							}
							break;
						case 2 :
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:190:43: n= NUMBER
							{
							n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body969); 
							}
							break;
						case 3 :
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:190:54: d= DOT
							{
							d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body975); 
							}
							break;
						case 4 :
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:190:62: a= ANY
							{
							a=(CommonTree)match(input,ANY,FOLLOW_ANY_in_body981); 
							}
							break;

					}

					match(input, Token.UP, null); 

					 StringTemplate body = null;
					      if (i != null) {
					        String text = ((CommonTree) i).getText();
					        if (Character.isLowerCase(text.charAt(0))) {
					          body = templateLib.getInstanceOf("call",new STAttrMap().put("name", i));
					        } else {
					          body = templateLib.getInstanceOf("token",new STAttrMap().put("text", i));
					        }
					      
					      } else if (n != null) {
					        body = templateLib.getInstanceOf("token",new STAttrMap().put("text", n));
					      
					      } else if (d != null) {
					        body = templateLib.getInstanceOf("token",new STAttrMap().put("text", "."));
					      
					      } else {
					        body = templateLib.getInstanceOf("any");
					      }
					    
					// TEMPLATE REWRITE
					// 219:5: -> assign(name=lvalue=body)
					{
						retval.st = templateLib.getInstanceOf("assign",new STAttrMap().put("name", l).put("value", body));
					}



					}
					break;
				case 10 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:224:5: ^( STAR b= body[bindings, unbindings] )
					{
					match(input,STAR,FOLLOW_STAR_in_body1042); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1046);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 226:5: -> star(body=b)
					{
						retval.st = templateLib.getInstanceOf("star",new STAttrMap().put("body", b));
					}



					}
					break;
				case 11 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:230:5: ^( PLUS b= body[bindings, unbindings] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_body1088); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1092);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 232:5: -> plus(body=b)
					{
						retval.st = templateLib.getInstanceOf("plus",new STAttrMap().put("body", b));
					}



					}
					break;
				case 12 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:236:5: ^( CHOICE (b= body[bindings, unbindings] )+ )
					{
					 List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
					match(input,CHOICE,FOLLOW_CHOICE_in_body1142); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:238:7: (b= body[bindings, unbindings] )+
					int cnt9=0;
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( ((LA9_0 >= ACT && LA9_0 <= ANY)||LA9_0==ASSIGN||LA9_0==CHOICE||LA9_0==DOT||LA9_0==IDENTIFIER||(LA9_0 >= LIMIT && LA9_0 <= LITERAL)||(LA9_0 >= NOSKIP && LA9_0 <= NUMBER)||(LA9_0 >= OPTIONAL && LA9_0 <= PERMUTED)||LA9_0==PLUS||(LA9_0 >= SEQUENCE && LA9_0 <= TAG)) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:238:8: b= body[bindings, unbindings]
							{
							pushFollow(FOLLOW_body_in_body1153);
							b=body(bindings, unbindings);
							state._fsp--;

							 steps.add((b!=null?((StringTemplate)b.getTemplate()):null)); 
							}
							break;

						default :
							if ( cnt9 >= 1 ) break loop9;
							EarlyExitException eee = new EarlyExitException(9, input);
							throw eee;
						}
						cnt9++;
					}

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 243:5: -> choice(step=steps)
					{
						retval.st = templateLib.getInstanceOf("choice",new STAttrMap().put("step", steps));
					}



					}
					break;
				case 13 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:247:5: ^( OPTIONAL b= body[bindings, unbindings] )
					{
					match(input,OPTIONAL,FOLLOW_OPTIONAL_in_body1221); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1231);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 251:5: -> opt(body=b)
					{
						retval.st = templateLib.getInstanceOf("opt",new STAttrMap().put("body", b));
					}



					}
					break;
				case 14 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:255:5: ^( SKIP_TO body[bindings, unbindings] )
					{
					match(input,SKIP_TO,FOLLOW_SKIP_TO_in_body1282); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1290);
					body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 15 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:259:5: ^( NOT body[bindings, unbindings] )
					{
					match(input,NOT,FOLLOW_NOT_in_body1307); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1309);
					body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 16 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:261:5: ^( NOSKIP ( body[bindings, unbindings] )+ )
					{
					match(input,NOSKIP,FOLLOW_NOSKIP_in_body1319); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:262:7: ( body[bindings, unbindings] )+
					int cnt10=0;
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( ((LA10_0 >= ACT && LA10_0 <= ANY)||LA10_0==ASSIGN||LA10_0==CHOICE||LA10_0==DOT||LA10_0==IDENTIFIER||(LA10_0 >= LIMIT && LA10_0 <= LITERAL)||(LA10_0 >= NOSKIP && LA10_0 <= NUMBER)||(LA10_0 >= OPTIONAL && LA10_0 <= PERMUTED)||LA10_0==PLUS||(LA10_0 >= SEQUENCE && LA10_0 <= TAG)) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:262:8: body[bindings, unbindings]
							{
							pushFollow(FOLLOW_body_in_body1329);
							body(bindings, unbindings);
							state._fsp--;

							}
							break;

						default :
							if ( cnt10 >= 1 ) break loop10;
							EarlyExitException eee = new EarlyExitException(10, input);
							throw eee;
						}
						cnt10++;
					}

					match(input, Token.UP, null); 

					}
					break;
				case 17 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:266:5: ^( PERMUTED ( body[bindings, unbindings] )+ )
					{
					match(input,PERMUTED,FOLLOW_PERMUTED_in_body1357); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:267:7: ( body[bindings, unbindings] )+
					int cnt11=0;
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( ((LA11_0 >= ACT && LA11_0 <= ANY)||LA11_0==ASSIGN||LA11_0==CHOICE||LA11_0==DOT||LA11_0==IDENTIFIER||(LA11_0 >= LIMIT && LA11_0 <= LITERAL)||(LA11_0 >= NOSKIP && LA11_0 <= NUMBER)||(LA11_0 >= OPTIONAL && LA11_0 <= PERMUTED)||LA11_0==PLUS||(LA11_0 >= SEQUENCE && LA11_0 <= TAG)) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:267:8: body[bindings, unbindings]
							{
							pushFollow(FOLLOW_body_in_body1367);
							body(bindings, unbindings);
							state._fsp--;

							}
							break;

						default :
							if ( cnt11 >= 1 ) break loop11;
							EarlyExitException eee = new EarlyExitException(11, input);
							throw eee;
						}
						cnt11++;
					}

					match(input, Token.UP, null); 

					}
					break;
				case 18 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:271:5: ^( LIMIT b_t= body[bindings, unbindings] b_l= body[bindings, unbindings] )
					{
					match(input,LIMIT,FOLLOW_LIMIT_in_body1395); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1399);
					b_t=body(bindings, unbindings);
					state._fsp--;

					pushFollow(FOLLOW_body_in_body1404);
					b_l=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 273:5: -> limit(target=b_tlimiter=b_l)
					{
						retval.st = templateLib.getInstanceOf("limit",new STAttrMap().put("target", b_t).put("limiter", b_l));
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "body"

	// Delegated rules



	public static final BitSet FOLLOW_GRAMMAR_in_koopa68 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_meta_in_koopa76 = new BitSet(new long[]{0x0000400000000008L});
	public static final BitSet FOLLOW_rule_in_koopa88 = new BitSet(new long[]{0x0000400000000008L});
	public static final BitSet FOLLOW_META_in_meta204 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TREE_in_meta206 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_named_in_meta210 = new BitSet(new long[]{0x0000000000800008L});
	public static final BitSet FOLLOW_extending_in_meta215 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NAMED_in_named247 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_named251 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EXTENDING_in_extending279 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_extending283 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RULE_in_rule314 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_PUBLIC_in_rule324 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_PRIVATE_in_rule328 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_rule339 = new BitSet(new long[]{0x0007A59C3A2010B0L});
	public static final BitSet FOLLOW_locals_in_rule357 = new BitSet(new long[]{0x0007A59C1A2010B0L});
	public static final BitSet FOLLOW_returning_in_rule394 = new BitSet(new long[]{0x0007859C1A2010B0L});
	public static final BitSet FOLLOW_body_in_rule413 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURNS_in_returning485 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_returning489 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOCALS_in_locals538 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_locals549 = new BitSet(new long[]{0x0000000000020008L});
	public static final BitSet FOLLOW_DECLARATION_in_declaration592 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration596 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration600 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SEQUENCE_in_body629 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body641 = new BitSet(new long[]{0x0007859C1A2010B8L});
	public static final BitSet FOLLOW_ACT_in_body709 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_NATIVE_CODE_in_body713 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ANY_in_body781 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TAG_in_body799 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LITERAL_in_body890 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_body899 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_body910 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_body954 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body958 = new BitSet(new long[]{0x0000001002200020L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body963 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NUMBER_in_body969 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DOT_in_body975 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ANY_in_body981 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STAR_in_body1042 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1046 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_body1088 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1092 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHOICE_in_body1142 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1153 = new BitSet(new long[]{0x0007859C1A2010B8L});
	public static final BitSet FOLLOW_OPTIONAL_in_body1221 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1231 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SKIP_TO_in_body1282 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1290 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_in_body1307 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1309 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOSKIP_in_body1319 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1329 = new BitSet(new long[]{0x0007859C1A2010B8L});
	public static final BitSet FOLLOW_PERMUTED_in_body1357 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1367 = new BitSet(new long[]{0x0007859C1A2010B8L});
	public static final BitSet FOLLOW_LIMIT_in_body1395 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1399 = new BitSet(new long[]{0x0007859C1A2010B0L});
	public static final BitSet FOLLOW_body_in_body1404 = new BitSet(new long[]{0x0000000000000008L});
}
