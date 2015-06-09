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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACT", "ANY", "ARROW", "AS", "ASSIGN", 
		"BANG", "BODY", "BY", "CASE", "CHOICE", "CLOSE_BRACKET", "CLOSE_PAREN", 
		"COLON", "COMMA", "COMMENT", "DECLARATION", "DIGIT", "DISPATCHED", "DOLLAR", 
		"DOT", "EQUALS", "EXTENDING", "GRAMMAR", "IDENTIFIER", "LETTER", "LIMIT", 
		"LITERAL", "LOCALS", "LOWERCASE", "META", "NAMED", "NATIVE_CODE", "NEWLINE", 
		"NOSKIP", "NOT", "NUMBER", "OPEN_BRACKET", "OPEN_PAREN", "OPTIONAL", "PERMUTED", 
		"PIPE", "PLUS", "PRIVATE", "PUBLIC", "RETURNS", "RULE", "SEQUENCE", "SKIP_TO", 
		"STAR", "TAG", "TOKEN", "TREE", "UPPERCASE", "WHITESPACE", "WITH", "'def'", 
		"'end'", "'extends'", "'grammar'", "'returns'", "'tree'"
	};
	public static final int EOF=-1;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int T__64=64;
	public static final int ACT=4;
	public static final int ANY=5;
	public static final int ARROW=6;
	public static final int AS=7;
	public static final int ASSIGN=8;
	public static final int BANG=9;
	public static final int BODY=10;
	public static final int BY=11;
	public static final int CASE=12;
	public static final int CHOICE=13;
	public static final int CLOSE_BRACKET=14;
	public static final int CLOSE_PAREN=15;
	public static final int COLON=16;
	public static final int COMMA=17;
	public static final int COMMENT=18;
	public static final int DECLARATION=19;
	public static final int DIGIT=20;
	public static final int DISPATCHED=21;
	public static final int DOLLAR=22;
	public static final int DOT=23;
	public static final int EQUALS=24;
	public static final int EXTENDING=25;
	public static final int GRAMMAR=26;
	public static final int IDENTIFIER=27;
	public static final int LETTER=28;
	public static final int LIMIT=29;
	public static final int LITERAL=30;
	public static final int LOCALS=31;
	public static final int LOWERCASE=32;
	public static final int META=33;
	public static final int NAMED=34;
	public static final int NATIVE_CODE=35;
	public static final int NEWLINE=36;
	public static final int NOSKIP=37;
	public static final int NOT=38;
	public static final int NUMBER=39;
	public static final int OPEN_BRACKET=40;
	public static final int OPEN_PAREN=41;
	public static final int OPTIONAL=42;
	public static final int PERMUTED=43;
	public static final int PIPE=44;
	public static final int PLUS=45;
	public static final int PRIVATE=46;
	public static final int PUBLIC=47;
	public static final int RETURNS=48;
	public static final int RULE=49;
	public static final int SEQUENCE=50;
	public static final int SKIP_TO=51;
	public static final int STAR=52;
	public static final int TAG=53;
	public static final int TOKEN=54;
	public static final int TREE=55;
	public static final int UPPERCASE=56;
	public static final int WHITESPACE=57;
	public static final int WITH=58;

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
	// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:54:1: named returns [String name = null] : ^( NAMED (i= IDENTIFIER |i= TOKEN ) ) ;
	public final TreeGrammarGenerator.named_return named() throws RecognitionException {
		TreeGrammarGenerator.named_return retval = new TreeGrammarGenerator.named_return();
		retval.start = input.LT(1);

		CommonTree i=null;

		try {
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:55:3: ( ^( NAMED (i= IDENTIFIER |i= TOKEN ) ) )
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:55:5: ^( NAMED (i= IDENTIFIER |i= TOKEN ) )
			{
			match(input,NAMED,FOLLOW_NAMED_in_named247); 
			match(input, Token.DOWN, null); 
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:55:13: (i= IDENTIFIER |i= TOKEN )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==IDENTIFIER) ) {
				alt3=1;
			}
			else if ( (LA3_0==TOKEN) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:55:14: i= IDENTIFIER
					{
					i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_named252); 
					}
					break;
				case 2 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:55:29: i= TOKEN
					{
					i=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_named258); 
					}
					break;

			}

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
	// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:60:1: extending returns [String name = null] : ^( EXTENDING (i= IDENTIFIER |i= TOKEN ) ) ;
	public final TreeGrammarGenerator.extending_return extending() throws RecognitionException {
		TreeGrammarGenerator.extending_return retval = new TreeGrammarGenerator.extending_return();
		retval.start = input.LT(1);

		CommonTree i=null;

		try {
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:61:3: ( ^( EXTENDING (i= IDENTIFIER |i= TOKEN ) ) )
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:61:5: ^( EXTENDING (i= IDENTIFIER |i= TOKEN ) )
			{
			match(input,EXTENDING,FOLLOW_EXTENDING_in_extending287); 
			match(input, Token.DOWN, null); 
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:61:17: (i= IDENTIFIER |i= TOKEN )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==IDENTIFIER) ) {
				alt4=1;
			}
			else if ( (LA4_0==TOKEN) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:61:18: i= IDENTIFIER
					{
					i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_extending292); 
					}
					break;
				case 2 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:61:33: i= TOKEN
					{
					i=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_extending298); 
					}
					break;

			}

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
			    
			match(input,RULE,FOLLOW_RULE_in_rule330); 
			match(input, Token.DOWN, null); 
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:73:7: ( PUBLIC | PRIVATE )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==PUBLIC) ) {
				alt5=1;
			}
			else if ( (LA5_0==PRIVATE) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:73:8: PUBLIC
					{
					match(input,PUBLIC,FOLLOW_PUBLIC_in_rule340); 
					}
					break;
				case 2 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:73:17: PRIVATE
					{
					match(input,PRIVATE,FOLLOW_PRIVATE_in_rule344); 
					}
					break;

			}

			n=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule355); 
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:76:7: (l= locals )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==LOCALS) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:76:8: l= locals
					{
					pushFollow(FOLLOW_locals_in_rule373);
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
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==RETURNS) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:96:8: r= returning
					{
					pushFollow(FOLLOW_returning_in_rule410);
					r=returning();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_body_in_rule429);
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
			match(input,RETURNS,FOLLOW_RETURNS_in_returning501); 
			match(input, Token.DOWN, null); 
			i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_returning505); 
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
			match(input,LOCALS,FOLLOW_LOCALS_in_locals554); 
			match(input, Token.DOWN, null); 
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:129:7: (d= declaration )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==DECLARATION) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:129:8: d= declaration
					{
					pushFollow(FOLLOW_declaration_in_locals565);
					d=declaration();
					state._fsp--;

					 retval.tuples.add((d!=null?((TreeGrammarGenerator.declaration_return)d).tuple:null)); 
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
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
	// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:135:1: declaration returns [Tuple<String, String> tuple = null] : ^( DECLARATION (a= IDENTIFIER |a= TOKEN ) (b= IDENTIFIER |b= TOKEN ) ) ;
	public final TreeGrammarGenerator.declaration_return declaration() throws RecognitionException {
		TreeGrammarGenerator.declaration_return retval = new TreeGrammarGenerator.declaration_return();
		retval.start = input.LT(1);

		CommonTree a=null;
		CommonTree b=null;

		try {
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:136:3: ( ^( DECLARATION (a= IDENTIFIER |a= TOKEN ) (b= IDENTIFIER |b= TOKEN ) ) )
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:136:5: ^( DECLARATION (a= IDENTIFIER |a= TOKEN ) (b= IDENTIFIER |b= TOKEN ) )
			{
			match(input,DECLARATION,FOLLOW_DECLARATION_in_declaration608); 
			match(input, Token.DOWN, null); 
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:136:19: (a= IDENTIFIER |a= TOKEN )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==IDENTIFIER) ) {
				alt9=1;
			}
			else if ( (LA9_0==TOKEN) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:136:20: a= IDENTIFIER
					{
					a=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration613); 
					}
					break;
				case 2 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:136:33: a= TOKEN
					{
					a=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_declaration617); 
					}
					break;

			}

			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:136:42: (b= IDENTIFIER |b= TOKEN )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==IDENTIFIER) ) {
				alt10=1;
			}
			else if ( (LA10_0==TOKEN) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:136:43: b= IDENTIFIER
					{
					b=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration623); 
					}
					break;
				case 2 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:136:56: b= TOKEN
					{
					b=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_declaration627); 
					}
					break;

			}

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
	// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:140:1: body[ List<String> bindings, List<String> unbindings ] : ( ^( SEQUENCE (b= body[bindings, unbindings] )+ ) -> sequence(step=steps)| ^( ACT n= NATIVE_CODE ) -> apply(bind=bindingsunbind=unbindingsnative_code=n)| ANY -> any(| TAG |i= IDENTIFIER -> {isLowerCase}? call(name=i) -> token(text=i)|l= LITERAL |n= NUMBER |d= DOT -> token(text=d)| ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER |n= NUMBER |d= DOT |a= ANY ) ) -> assign(name=lvalue=body)| ^( STAR b= body[bindings, unbindings] ) -> star(body=b)| ^( PLUS b= body[bindings, unbindings] ) -> plus(body=b)| ^( CHOICE (b= body[bindings, unbindings] )+ ) -> choice(step=steps)| ^( OPTIONAL b= body[bindings, unbindings] ) -> opt(body=b)| ^( SKIP_TO body[bindings, unbindings] ) | ^( NOT body[bindings, unbindings] ) | ^( NOSKIP ( body[bindings, unbindings] )+ ) | ^( PERMUTED ( body[bindings, unbindings] )+ ) | ^( LIMIT b_t= body[bindings, unbindings] b_l= body[bindings, unbindings] ) -> limit(target=b_tlimiter=b_l)| ^( AS IDENTIFIER b= body[bindings, unbindings] ) );
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
			// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:141:3: ( ^( SEQUENCE (b= body[bindings, unbindings] )+ ) -> sequence(step=steps)| ^( ACT n= NATIVE_CODE ) -> apply(bind=bindingsunbind=unbindingsnative_code=n)| ANY -> any(| TAG |i= IDENTIFIER -> {isLowerCase}? call(name=i) -> token(text=i)|l= LITERAL |n= NUMBER |d= DOT -> token(text=d)| ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER |n= NUMBER |d= DOT |a= ANY ) ) -> assign(name=lvalue=body)| ^( STAR b= body[bindings, unbindings] ) -> star(body=b)| ^( PLUS b= body[bindings, unbindings] ) -> plus(body=b)| ^( CHOICE (b= body[bindings, unbindings] )+ ) -> choice(step=steps)| ^( OPTIONAL b= body[bindings, unbindings] ) -> opt(body=b)| ^( SKIP_TO body[bindings, unbindings] ) | ^( NOT body[bindings, unbindings] ) | ^( NOSKIP ( body[bindings, unbindings] )+ ) | ^( PERMUTED ( body[bindings, unbindings] )+ ) | ^( LIMIT b_t= body[bindings, unbindings] b_l= body[bindings, unbindings] ) -> limit(target=b_tlimiter=b_l)| ^( AS IDENTIFIER b= body[bindings, unbindings] ) )
			int alt16=19;
			switch ( input.LA(1) ) {
			case SEQUENCE:
				{
				alt16=1;
				}
				break;
			case ACT:
				{
				alt16=2;
				}
				break;
			case ANY:
				{
				alt16=3;
				}
				break;
			case TAG:
				{
				alt16=4;
				}
				break;
			case IDENTIFIER:
				{
				alt16=5;
				}
				break;
			case LITERAL:
				{
				alt16=6;
				}
				break;
			case NUMBER:
				{
				alt16=7;
				}
				break;
			case DOT:
				{
				alt16=8;
				}
				break;
			case ASSIGN:
				{
				alt16=9;
				}
				break;
			case STAR:
				{
				alt16=10;
				}
				break;
			case PLUS:
				{
				alt16=11;
				}
				break;
			case CHOICE:
				{
				alt16=12;
				}
				break;
			case OPTIONAL:
				{
				alt16=13;
				}
				break;
			case SKIP_TO:
				{
				alt16=14;
				}
				break;
			case NOT:
				{
				alt16=15;
				}
				break;
			case NOSKIP:
				{
				alt16=16;
				}
				break;
			case PERMUTED:
				{
				alt16=17;
				}
				break;
			case LIMIT:
				{
				alt16=18;
				}
				break;
			case AS:
				{
				alt16=19;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}
			switch (alt16) {
				case 1 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:141:5: ^( SEQUENCE (b= body[bindings, unbindings] )+ )
					{
					 List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
					match(input,SEQUENCE,FOLLOW_SEQUENCE_in_body657); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:143:7: (b= body[bindings, unbindings] )+
					int cnt11=0;
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( ((LA11_0 >= ACT && LA11_0 <= ANY)||(LA11_0 >= AS && LA11_0 <= ASSIGN)||LA11_0==CHOICE||LA11_0==DOT||LA11_0==IDENTIFIER||(LA11_0 >= LIMIT && LA11_0 <= LITERAL)||(LA11_0 >= NOSKIP && LA11_0 <= NUMBER)||(LA11_0 >= OPTIONAL && LA11_0 <= PERMUTED)||LA11_0==PLUS||(LA11_0 >= SEQUENCE && LA11_0 <= TAG)) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:143:8: b= body[bindings, unbindings]
							{
							pushFollow(FOLLOW_body_in_body669);
							b=body(bindings, unbindings);
							state._fsp--;

							 steps.add((b!=null?((StringTemplate)b.getTemplate()):null)); 
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
					match(input,ACT,FOLLOW_ACT_in_body737); 
					match(input, Token.DOWN, null); 
					n=(CommonTree)match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_body741); 
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
					match(input,ANY,FOLLOW_ANY_in_body809); 
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
					match(input,TAG,FOLLOW_TAG_in_body827); 
					}
					break;
				case 5 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:166:5: i= IDENTIFIER
					{
					i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body836); 
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
					l=(CommonTree)match(input,LITERAL,FOLLOW_LITERAL_in_body918); 
					}
					break;
				case 7 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:182:5: n= NUMBER
					{
					n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body927); 
					}
					break;
				case 8 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:184:5: d= DOT
					{
					d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body938); 
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
					match(input,ASSIGN,FOLLOW_ASSIGN_in_body982); 
					match(input, Token.DOWN, null); 
					l=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body986); 
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:190:27: (i= IDENTIFIER |n= NUMBER |d= DOT |a= ANY )
					int alt12=4;
					switch ( input.LA(1) ) {
					case IDENTIFIER:
						{
						alt12=1;
						}
						break;
					case NUMBER:
						{
						alt12=2;
						}
						break;
					case DOT:
						{
						alt12=3;
						}
						break;
					case ANY:
						{
						alt12=4;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 12, 0, input);
						throw nvae;
					}
					switch (alt12) {
						case 1 :
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:190:28: i= IDENTIFIER
							{
							i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body991); 
							}
							break;
						case 2 :
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:190:43: n= NUMBER
							{
							n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body997); 
							}
							break;
						case 3 :
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:190:54: d= DOT
							{
							d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body1003); 
							}
							break;
						case 4 :
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:190:62: a= ANY
							{
							a=(CommonTree)match(input,ANY,FOLLOW_ANY_in_body1009); 
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
					match(input,STAR,FOLLOW_STAR_in_body1070); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1074);
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
					match(input,PLUS,FOLLOW_PLUS_in_body1116); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1120);
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
					match(input,CHOICE,FOLLOW_CHOICE_in_body1170); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:238:7: (b= body[bindings, unbindings] )+
					int cnt13=0;
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( ((LA13_0 >= ACT && LA13_0 <= ANY)||(LA13_0 >= AS && LA13_0 <= ASSIGN)||LA13_0==CHOICE||LA13_0==DOT||LA13_0==IDENTIFIER||(LA13_0 >= LIMIT && LA13_0 <= LITERAL)||(LA13_0 >= NOSKIP && LA13_0 <= NUMBER)||(LA13_0 >= OPTIONAL && LA13_0 <= PERMUTED)||LA13_0==PLUS||(LA13_0 >= SEQUENCE && LA13_0 <= TAG)) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:238:8: b= body[bindings, unbindings]
							{
							pushFollow(FOLLOW_body_in_body1181);
							b=body(bindings, unbindings);
							state._fsp--;

							 steps.add((b!=null?((StringTemplate)b.getTemplate()):null)); 
							}
							break;

						default :
							if ( cnt13 >= 1 ) break loop13;
							EarlyExitException eee = new EarlyExitException(13, input);
							throw eee;
						}
						cnt13++;
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
					match(input,OPTIONAL,FOLLOW_OPTIONAL_in_body1249); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1259);
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
					match(input,SKIP_TO,FOLLOW_SKIP_TO_in_body1310); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1318);
					body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 15 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:259:5: ^( NOT body[bindings, unbindings] )
					{
					match(input,NOT,FOLLOW_NOT_in_body1335); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1337);
					body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 16 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:261:5: ^( NOSKIP ( body[bindings, unbindings] )+ )
					{
					match(input,NOSKIP,FOLLOW_NOSKIP_in_body1347); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:262:7: ( body[bindings, unbindings] )+
					int cnt14=0;
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( ((LA14_0 >= ACT && LA14_0 <= ANY)||(LA14_0 >= AS && LA14_0 <= ASSIGN)||LA14_0==CHOICE||LA14_0==DOT||LA14_0==IDENTIFIER||(LA14_0 >= LIMIT && LA14_0 <= LITERAL)||(LA14_0 >= NOSKIP && LA14_0 <= NUMBER)||(LA14_0 >= OPTIONAL && LA14_0 <= PERMUTED)||LA14_0==PLUS||(LA14_0 >= SEQUENCE && LA14_0 <= TAG)) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:262:8: body[bindings, unbindings]
							{
							pushFollow(FOLLOW_body_in_body1357);
							body(bindings, unbindings);
							state._fsp--;

							}
							break;

						default :
							if ( cnt14 >= 1 ) break loop14;
							EarlyExitException eee = new EarlyExitException(14, input);
							throw eee;
						}
						cnt14++;
					}

					match(input, Token.UP, null); 

					}
					break;
				case 17 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:266:5: ^( PERMUTED ( body[bindings, unbindings] )+ )
					{
					match(input,PERMUTED,FOLLOW_PERMUTED_in_body1385); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:267:7: ( body[bindings, unbindings] )+
					int cnt15=0;
					loop15:
					while (true) {
						int alt15=2;
						int LA15_0 = input.LA(1);
						if ( ((LA15_0 >= ACT && LA15_0 <= ANY)||(LA15_0 >= AS && LA15_0 <= ASSIGN)||LA15_0==CHOICE||LA15_0==DOT||LA15_0==IDENTIFIER||(LA15_0 >= LIMIT && LA15_0 <= LITERAL)||(LA15_0 >= NOSKIP && LA15_0 <= NUMBER)||(LA15_0 >= OPTIONAL && LA15_0 <= PERMUTED)||LA15_0==PLUS||(LA15_0 >= SEQUENCE && LA15_0 <= TAG)) ) {
							alt15=1;
						}

						switch (alt15) {
						case 1 :
							// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:267:8: body[bindings, unbindings]
							{
							pushFollow(FOLLOW_body_in_body1395);
							body(bindings, unbindings);
							state._fsp--;

							}
							break;

						default :
							if ( cnt15 >= 1 ) break loop15;
							EarlyExitException eee = new EarlyExitException(15, input);
							throw eee;
						}
						cnt15++;
					}

					match(input, Token.UP, null); 

					}
					break;
				case 18 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:271:5: ^( LIMIT b_t= body[bindings, unbindings] b_l= body[bindings, unbindings] )
					{
					match(input,LIMIT,FOLLOW_LIMIT_in_body1423); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1427);
					b_t=body(bindings, unbindings);
					state._fsp--;

					pushFollow(FOLLOW_body_in_body1432);
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
				case 19 :
					// src/core/koopa/core/treegrammars/generator/TreeGrammarGenerator.g:278:5: ^( AS IDENTIFIER b= body[bindings, unbindings] )
					{
					match(input,AS,FOLLOW_AS_in_body1485); 
					match(input, Token.DOWN, null); 
					match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body1487); 
					pushFollow(FOLLOW_body_in_body1491);
					b=body(bindings, unbindings);
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
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "body"

	// Delegated rules



	public static final BitSet FOLLOW_GRAMMAR_in_koopa68 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_meta_in_koopa76 = new BitSet(new long[]{0x0002000000000008L});
	public static final BitSet FOLLOW_rule_in_koopa88 = new BitSet(new long[]{0x0002000000000008L});
	public static final BitSet FOLLOW_META_in_meta204 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TREE_in_meta206 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_named_in_meta210 = new BitSet(new long[]{0x0000000002000008L});
	public static final BitSet FOLLOW_extending_in_meta215 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NAMED_in_named247 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_named252 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_in_named258 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EXTENDING_in_extending287 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_extending292 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_in_extending298 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RULE_in_rule330 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_PUBLIC_in_rule340 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_PRIVATE_in_rule344 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_rule355 = new BitSet(new long[]{0x003D2CE0E88021B0L});
	public static final BitSet FOLLOW_locals_in_rule373 = new BitSet(new long[]{0x003D2CE0688021B0L});
	public static final BitSet FOLLOW_returning_in_rule410 = new BitSet(new long[]{0x003C2CE0688021B0L});
	public static final BitSet FOLLOW_body_in_rule429 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURNS_in_returning501 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_returning505 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOCALS_in_locals554 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_locals565 = new BitSet(new long[]{0x0000000000080008L});
	public static final BitSet FOLLOW_DECLARATION_in_declaration608 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration613 = new BitSet(new long[]{0x0040000008000000L});
	public static final BitSet FOLLOW_TOKEN_in_declaration617 = new BitSet(new long[]{0x0040000008000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration623 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_in_declaration627 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SEQUENCE_in_body657 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body669 = new BitSet(new long[]{0x003C2CE0688021B8L});
	public static final BitSet FOLLOW_ACT_in_body737 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_NATIVE_CODE_in_body741 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ANY_in_body809 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TAG_in_body827 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body836 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LITERAL_in_body918 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_body927 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_body938 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_body982 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body986 = new BitSet(new long[]{0x0000008008800020L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body991 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NUMBER_in_body997 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DOT_in_body1003 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ANY_in_body1009 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STAR_in_body1070 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1074 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_body1116 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1120 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHOICE_in_body1170 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1181 = new BitSet(new long[]{0x003C2CE0688021B8L});
	public static final BitSet FOLLOW_OPTIONAL_in_body1249 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1259 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SKIP_TO_in_body1310 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1318 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_in_body1335 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1337 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOSKIP_in_body1347 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1357 = new BitSet(new long[]{0x003C2CE0688021B8L});
	public static final BitSet FOLLOW_PERMUTED_in_body1385 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1395 = new BitSet(new long[]{0x003C2CE0688021B8L});
	public static final BitSet FOLLOW_LIMIT_in_body1423 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1427 = new BitSet(new long[]{0x003C2CE0688021B0L});
	public static final BitSet FOLLOW_body_in_body1432 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AS_in_body1485 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body1487 = new BitSet(new long[]{0x003C2CE0688021B0L});
	public static final BitSet FOLLOW_body_in_body1491 = new BitSet(new long[]{0x0000000000000008L});
}
