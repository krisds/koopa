// $ANTLR 3.5.2 src/core/koopa/core/grammars/generator/KGGenerator.g

  package koopa.core.grammars.generator;
  
  import java.util.List;
  import java.util.LinkedList;
  import java.util.Date;
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
public class KGGenerator extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACT", "ANY", "ARROW", "ASSIGN", 
		"BANG", "BODY", "BY", "CASE", "CHOICE", "CLOSE_BRACKET", "CLOSE_PAREN", 
		"COMMA", "COMMENT", "DECLARATION", "DIGIT", "DISPATCHED", "DOLLAR", "DOT", 
		"EQUALS", "EXTENDING", "GRAMMAR", "IDENTIFIER", "LETTER", "LIMIT", "LITERAL", 
		"LOCALS", "META", "NAMED", "NATIVE_CODE", "NEWLINE", "NOSKIP", "NOT", 
		"NUMBER", "OPEN_BRACKET", "OPEN_PAREN", "OPTIONAL", "PERMUTED", "PIPE", 
		"PLUS", "RETURNS", "RULE", "SEQUENCE", "SKIP_TO", "STAR", "TAG", "TREE", 
		"WHITESPACE", "'def'", "'end'", "'extends'", "'grammar'", "'returns'", 
		"'tree'"
	};
	public static final int EOF=-1;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
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
	public static final int RETURNS=43;
	public static final int RULE=44;
	public static final int SEQUENCE=45;
	public static final int SKIP_TO=46;
	public static final int STAR=47;
	public static final int TAG=48;
	public static final int TREE=49;
	public static final int WHITESPACE=50;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public KGGenerator(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public KGGenerator(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected StringTemplateGroup templateLib =
	  new StringTemplateGroup("KGGeneratorTemplates", AngleBracketTemplateLexer.class);

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
	@Override public String[] getTokenNames() { return KGGenerator.tokenNames; }
	@Override public String getGrammarFileName() { return "src/core/koopa/core/grammars/generator/KGGenerator.g"; }




	public static class koopa_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "koopa"
	// src/core/koopa/core/grammars/generator/KGGenerator.g:26:1: koopa[Properties p, String imports, String supportCode] : ^( GRAMMAR meta[p] (r+= rule )* ) -> koopa(name=p.getProperty(\"named\")extending=p.getProperty(\"extending\")date=new Date()package=p.getProperty(\"package\")imports=importsrule=$rsupport_code=supportCode);
	public final KGGenerator.koopa_return koopa(Properties p, String imports, String supportCode) throws RecognitionException {
		KGGenerator.koopa_return retval = new KGGenerator.koopa_return();
		retval.start = input.LT(1);

		List<Object> list_r=null;
		RuleReturnScope r = null;
		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:27:3: ( ^( GRAMMAR meta[p] (r+= rule )* ) -> koopa(name=p.getProperty(\"named\")extending=p.getProperty(\"extending\")date=new Date()package=p.getProperty(\"package\")imports=importsrule=$rsupport_code=supportCode))
			// src/core/koopa/core/grammars/generator/KGGenerator.g:27:5: ^( GRAMMAR meta[p] (r+= rule )* )
			{
			match(input,GRAMMAR,FOLLOW_GRAMMAR_in_koopa68); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_meta_in_koopa76);
			meta(p);
			state._fsp--;

			// src/core/koopa/core/grammars/generator/KGGenerator.g:29:7: (r+= rule )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==RULE) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:29:8: r+= rule
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
			// 32:5: -> koopa(name=p.getProperty(\"named\")extending=p.getProperty(\"extending\")date=new Date()package=p.getProperty(\"package\")imports=importsrule=$rsupport_code=supportCode)
			{
				retval.st = templateLib.getInstanceOf("koopa",new STAttrMap().put("name", p.getProperty("named")).put("extending", p.getProperty("extending")).put("date", new Date()).put("package", p.getProperty("package")).put("imports", imports).put("rule", list_r).put("support_code", supportCode));
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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:43:1: meta[ Properties meta ] : ^( META n= named (e= extending )? ) ;
	public final KGGenerator.meta_return meta(Properties meta) throws RecognitionException {
		KGGenerator.meta_return retval = new KGGenerator.meta_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope n =null;
		TreeRuleReturnScope e =null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:44:3: ( ^( META n= named (e= extending )? ) )
			// src/core/koopa/core/grammars/generator/KGGenerator.g:44:5: ^( META n= named (e= extending )? )
			{
			match(input,META,FOLLOW_META_in_meta222); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_named_in_meta226);
			n=named();
			state._fsp--;

			// src/core/koopa/core/grammars/generator/KGGenerator.g:44:20: (e= extending )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==EXTENDING) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:44:21: e= extending
					{
					pushFollow(FOLLOW_extending_in_meta231);
					e=extending();
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 

			 meta.setProperty("named", (n!=null?((KGGenerator.named_return)n).name:null));
			    
			      if (e != null) meta.setProperty("extending", (e!=null?((KGGenerator.extending_return)e).name:null));
			      else meta.setProperty("extending", "Koopa");
			    
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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:53:1: named returns [String name = null] : ^( NAMED i= IDENTIFIER ) ;
	public final KGGenerator.named_return named() throws RecognitionException {
		KGGenerator.named_return retval = new KGGenerator.named_return();
		retval.start = input.LT(1);

		CommonTree i=null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:54:3: ( ^( NAMED i= IDENTIFIER ) )
			// src/core/koopa/core/grammars/generator/KGGenerator.g:54:5: ^( NAMED i= IDENTIFIER )
			{
			match(input,NAMED,FOLLOW_NAMED_in_named263); 
			match(input, Token.DOWN, null); 
			i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_named267); 
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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:59:1: extending returns [String name = null] : ^( EXTENDING i= IDENTIFIER ) ;
	public final KGGenerator.extending_return extending() throws RecognitionException {
		KGGenerator.extending_return retval = new KGGenerator.extending_return();
		retval.start = input.LT(1);

		CommonTree i=null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:60:3: ( ^( EXTENDING i= IDENTIFIER ) )
			// src/core/koopa/core/grammars/generator/KGGenerator.g:60:5: ^( EXTENDING i= IDENTIFIER )
			{
			match(input,EXTENDING,FOLLOW_EXTENDING_in_extending295); 
			match(input, Token.DOWN, null); 
			i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_extending299); 
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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:65:1: rule : ^( RULE n= IDENTIFIER (l= locals )? (r= returning )? b= body[bindings, unbindings] ) -> rule(name=nbody=bod);
	public final KGGenerator.rule_return rule() throws RecognitionException {
		KGGenerator.rule_return retval = new KGGenerator.rule_return();
		retval.start = input.LT(1);

		CommonTree n=null;
		TreeRuleReturnScope l =null;
		TreeRuleReturnScope r =null;
		TreeRuleReturnScope b =null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:66:3: ( ^( RULE n= IDENTIFIER (l= locals )? (r= returning )? b= body[bindings, unbindings] ) -> rule(name=nbody=bod))
			// src/core/koopa/core/grammars/generator/KGGenerator.g:66:5: ^( RULE n= IDENTIFIER (l= locals )? (r= returning )? b= body[bindings, unbindings] )
			{
			 List<String> bindings = null;
			      List<String> unbindings = null;
			      StringTemplate bod = null;
			    
			match(input,RULE,FOLLOW_RULE_in_rule329); 
			match(input, Token.DOWN, null); 
			n=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule333); 
			// src/core/koopa/core/grammars/generator/KGGenerator.g:71:7: (l= locals )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==LOCALS) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:71:8: l= locals
					{
					pushFollow(FOLLOW_locals_in_rule345);
					l=locals();
					state._fsp--;

					 bindings = new LinkedList<String>();
					          unbindings = new LinkedList<String>();
					          
					          for(Tuple<String, String> tuple : (l!=null?((KGGenerator.locals_return)l).tuples:null)) {
					            String type = tuple.getFirst();
					            String name = tuple.getSecond();

					            bindings.add(templateLib.getInstanceOf("bind",new STAttrMap().put("name", name).put("type", type)).toString());
					            
					            unbindings.add(templateLib.getInstanceOf("unbind",new STAttrMap().put("name", name)).toString());
					          }
					        
					}
					break;

			}

			// src/core/koopa/core/grammars/generator/KGGenerator.g:91:7: (r= returning )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==RETURNS) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:91:8: r= returning
					{
					pushFollow(FOLLOW_returning_in_rule376);
					r=returning();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_body_in_rule389);
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
			// 108:5: -> rule(name=nbody=bod)
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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:114:1: returning : ^( RETURNS i= IDENTIFIER ) -> returning(name=((CommonTree) $i).getText());
	public final KGGenerator.returning_return returning() throws RecognitionException {
		KGGenerator.returning_return retval = new KGGenerator.returning_return();
		retval.start = input.LT(1);

		CommonTree i=null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:115:3: ( ^( RETURNS i= IDENTIFIER ) -> returning(name=((CommonTree) $i).getText()))
			// src/core/koopa/core/grammars/generator/KGGenerator.g:115:5: ^( RETURNS i= IDENTIFIER )
			{
			match(input,RETURNS,FOLLOW_RETURNS_in_returning472); 
			match(input, Token.DOWN, null); 
			i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_returning476); 
			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 117:5: -> returning(name=((CommonTree) $i).getText())
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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:122:1: locals returns [List<Tuple<String, String>> tuples = new LinkedList<Tuple<String, String>>()] : ^( LOCALS (d= declaration )+ ) ;
	public final KGGenerator.locals_return locals() throws RecognitionException {
		KGGenerator.locals_return retval = new KGGenerator.locals_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope d =null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:123:3: ( ^( LOCALS (d= declaration )+ ) )
			// src/core/koopa/core/grammars/generator/KGGenerator.g:123:5: ^( LOCALS (d= declaration )+ )
			{
			match(input,LOCALS,FOLLOW_LOCALS_in_locals525); 
			match(input, Token.DOWN, null); 
			// src/core/koopa/core/grammars/generator/KGGenerator.g:124:7: (d= declaration )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==DECLARATION) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:124:8: d= declaration
					{
					pushFollow(FOLLOW_declaration_in_locals536);
					d=declaration();
					state._fsp--;

					 retval.tuples.add((d!=null?((KGGenerator.declaration_return)d).tuple:null)); 
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:130:1: declaration returns [Tuple<String, String> tuple = null] : ^( DECLARATION a= IDENTIFIER b= IDENTIFIER ) ;
	public final KGGenerator.declaration_return declaration() throws RecognitionException {
		KGGenerator.declaration_return retval = new KGGenerator.declaration_return();
		retval.start = input.LT(1);

		CommonTree a=null;
		CommonTree b=null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:131:3: ( ^( DECLARATION a= IDENTIFIER b= IDENTIFIER ) )
			// src/core/koopa/core/grammars/generator/KGGenerator.g:131:5: ^( DECLARATION a= IDENTIFIER b= IDENTIFIER )
			{
			match(input,DECLARATION,FOLLOW_DECLARATION_in_declaration579); 
			match(input, Token.DOWN, null); 
			a=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration583); 
			b=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration587); 
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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:135:1: body[ List<String> bindings, List<String> unbindings ] : ( ^( SEQUENCE (b= body[bindings, unbindings] )+ ) -> sequence(step=steps)| ^( ACT n= NATIVE_CODE ) -> apply(bind=bindingsnative_code=nunbind=unbindings)|t= TAG -> tag(text=name)| ANY -> any(|l= LITERAL -> token(text=unquoted)|n= NUMBER -> token(text=n)|i= IDENTIFIER -> {isLowerCase}? call(name=i) -> token(text=i)|d= DOT -> token(text=d)| ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER |n= NUMBER |d= DOT ) ) -> assign(name=lvalue=body)| ^( STAR b= body[bindings, unbindings] ) -> star(body=b)| ^( PLUS b= body[bindings, unbindings] ) -> plus(body=b)| ^( CHOICE (b= body[bindings, unbindings] )+ ) -> choice(step=steps)| ^( DISPATCHED (c= caze )+ ) -> dispatched(keys=keysrules=rules)| ^( OPTIONAL b= body[bindings, unbindings] ) -> optional(body=b)| ^( SKIP_TO b= body[bindings, unbindings] ) -> skipto(body=b)| ^( PERMUTED (b= body[bindings, unbindings] )+ ) -> permuted(choice=choices)| ^( NOT b= body[bindings, unbindings] ) -> not(body=b)| ^( NOSKIP b= body[bindings, unbindings] ) -> opt(option=optionbody=b)| ^( LIMIT b_t= body[bindings, unbindings] b_l= body[bindings, unbindings] ) -> limit(target=b_tlimiter=b_l));
	public final KGGenerator.body_return body(List<String> bindings, List<String> unbindings) throws RecognitionException {
		KGGenerator.body_return retval = new KGGenerator.body_return();
		retval.start = input.LT(1);

		CommonTree n=null;
		CommonTree t=null;
		CommonTree l=null;
		CommonTree i=null;
		CommonTree d=null;
		TreeRuleReturnScope b =null;
		TreeRuleReturnScope c =null;
		TreeRuleReturnScope b_t =null;
		TreeRuleReturnScope b_l =null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:136:3: ( ^( SEQUENCE (b= body[bindings, unbindings] )+ ) -> sequence(step=steps)| ^( ACT n= NATIVE_CODE ) -> apply(bind=bindingsnative_code=nunbind=unbindings)|t= TAG -> tag(text=name)| ANY -> any(|l= LITERAL -> token(text=unquoted)|n= NUMBER -> token(text=n)|i= IDENTIFIER -> {isLowerCase}? call(name=i) -> token(text=i)|d= DOT -> token(text=d)| ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER |n= NUMBER |d= DOT ) ) -> assign(name=lvalue=body)| ^( STAR b= body[bindings, unbindings] ) -> star(body=b)| ^( PLUS b= body[bindings, unbindings] ) -> plus(body=b)| ^( CHOICE (b= body[bindings, unbindings] )+ ) -> choice(step=steps)| ^( DISPATCHED (c= caze )+ ) -> dispatched(keys=keysrules=rules)| ^( OPTIONAL b= body[bindings, unbindings] ) -> optional(body=b)| ^( SKIP_TO b= body[bindings, unbindings] ) -> skipto(body=b)| ^( PERMUTED (b= body[bindings, unbindings] )+ ) -> permuted(choice=choices)| ^( NOT b= body[bindings, unbindings] ) -> not(body=b)| ^( NOSKIP b= body[bindings, unbindings] ) -> opt(option=optionbody=b)| ^( LIMIT b_t= body[bindings, unbindings] b_l= body[bindings, unbindings] ) -> limit(target=b_tlimiter=b_l))
			int alt11=19;
			switch ( input.LA(1) ) {
			case SEQUENCE:
				{
				alt11=1;
				}
				break;
			case ACT:
				{
				alt11=2;
				}
				break;
			case TAG:
				{
				alt11=3;
				}
				break;
			case ANY:
				{
				alt11=4;
				}
				break;
			case LITERAL:
				{
				alt11=5;
				}
				break;
			case NUMBER:
				{
				alt11=6;
				}
				break;
			case IDENTIFIER:
				{
				alt11=7;
				}
				break;
			case DOT:
				{
				alt11=8;
				}
				break;
			case ASSIGN:
				{
				alt11=9;
				}
				break;
			case STAR:
				{
				alt11=10;
				}
				break;
			case PLUS:
				{
				alt11=11;
				}
				break;
			case CHOICE:
				{
				alt11=12;
				}
				break;
			case DISPATCHED:
				{
				alt11=13;
				}
				break;
			case OPTIONAL:
				{
				alt11=14;
				}
				break;
			case SKIP_TO:
				{
				alt11=15;
				}
				break;
			case PERMUTED:
				{
				alt11=16;
				}
				break;
			case NOT:
				{
				alt11=17;
				}
				break;
			case NOSKIP:
				{
				alt11=18;
				}
				break;
			case LIMIT:
				{
				alt11=19;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:136:5: ^( SEQUENCE (b= body[bindings, unbindings] )+ )
					{
					 List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
					match(input,SEQUENCE,FOLLOW_SEQUENCE_in_body616); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/grammars/generator/KGGenerator.g:138:7: (b= body[bindings, unbindings] )+
					int cnt6=0;
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( ((LA6_0 >= ACT && LA6_0 <= ANY)||LA6_0==ASSIGN||LA6_0==CHOICE||LA6_0==DISPATCHED||LA6_0==DOT||LA6_0==IDENTIFIER||(LA6_0 >= LIMIT && LA6_0 <= LITERAL)||(LA6_0 >= NOSKIP && LA6_0 <= NUMBER)||(LA6_0 >= OPTIONAL && LA6_0 <= PERMUTED)||LA6_0==PLUS||(LA6_0 >= SEQUENCE && LA6_0 <= TAG)) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KGGenerator.g:138:8: b= body[bindings, unbindings]
							{
							pushFollow(FOLLOW_body_in_body627);
							b=body(bindings, unbindings);
							state._fsp--;

							 steps.add((b!=null?((StringTemplate)b.getTemplate()):null)); 
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

					// TEMPLATE REWRITE
					// 143:5: -> sequence(step=steps)
					{
						retval.st = templateLib.getInstanceOf("sequence",new STAttrMap().put("step", steps));
					}



					}
					break;
				case 2 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:147:5: ^( ACT n= NATIVE_CODE )
					{
					match(input,ACT,FOLLOW_ACT_in_body695); 
					match(input, Token.DOWN, null); 
					n=(CommonTree)match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_body699); 
					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 149:5: -> apply(bind=bindingsnative_code=nunbind=unbindings)
					{
						retval.st = templateLib.getInstanceOf("apply",new STAttrMap().put("bind", bindings).put("native_code", n).put("unbind", unbindings));
					}



					}
					break;
				case 3 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:155:5: t= TAG
					{
					t=(CommonTree)match(input,TAG,FOLLOW_TAG_in_body769); 
					 String name = ((CommonTree) t).getText();
					      name = name.substring(1, name.length()); 
						
					// TEMPLATE REWRITE
					// 161:5: -> tag(text=name)
					{
						retval.st = templateLib.getInstanceOf("tag",new STAttrMap().put("text", name));
					}



					}
					break;
				case 4 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:165:5: ANY
					{
					match(input,ANY,FOLLOW_ANY_in_body808); 
					// TEMPLATE REWRITE
					// 167:5: -> any(
					{
						retval.st = templateLib.getInstanceOf("any");
					}



					}
					break;
				case 5 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:169:5: l= LITERAL
					{
					l=(CommonTree)match(input,LITERAL,FOLLOW_LITERAL_in_body830); 
					 String unquoted = ((CommonTree) l).getText();
					      unquoted = unquoted.substring(1, unquoted.length() - 1); 
					    
					// TEMPLATE REWRITE
					// 175:5: -> token(text=unquoted)
					{
						retval.st = templateLib.getInstanceOf("token",new STAttrMap().put("text", unquoted));
					}



					}
					break;
				case 6 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:179:5: n= NUMBER
					{
					n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body880); 
					// TEMPLATE REWRITE
					// 181:5: -> token(text=n)
					{
						retval.st = templateLib.getInstanceOf("token",new STAttrMap().put("text", n));
					}



					}
					break;
				case 7 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:185:5: i= IDENTIFIER
					{
					i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body919); 
					 String text = ((CommonTree) i).getText();
					 	  boolean isLowerCase = Character.isLowerCase(text.charAt(0));
					    
					// TEMPLATE REWRITE
					// 191:5: -> {isLowerCase}? call(name=i)
					if (isLowerCase) {
						retval.st = templateLib.getInstanceOf("call",new STAttrMap().put("name", i));
					}

					else // 195:5: -> token(text=i)
					{
						retval.st = templateLib.getInstanceOf("token",new STAttrMap().put("text", i));
					}



					}
					break;
				case 8 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:199:5: d= DOT
					{
					d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body1001); 
					// TEMPLATE REWRITE
					// 201:5: -> token(text=d)
					{
						retval.st = templateLib.getInstanceOf("token",new STAttrMap().put("text", d));
					}



					}
					break;
				case 9 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:205:5: ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER |n= NUMBER |d= DOT ) )
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_body1041); 
					match(input, Token.DOWN, null); 
					l=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body1045); 
					// src/core/koopa/core/grammars/generator/KGGenerator.g:205:27: (i= IDENTIFIER |n= NUMBER |d= DOT )
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
							// src/core/koopa/core/grammars/generator/KGGenerator.g:205:28: i= IDENTIFIER
							{
							i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body1050); 
							}
							break;
						case 2 :
							// src/core/koopa/core/grammars/generator/KGGenerator.g:205:43: n= NUMBER
							{
							n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body1056); 
							}
							break;
						case 3 :
							// src/core/koopa/core/grammars/generator/KGGenerator.g:205:54: d= DOT
							{
							d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body1062); 
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
					      
					      } else {
					        body = templateLib.getInstanceOf("token",new STAttrMap().put("text", "."));
					      }
					    
					// TEMPLATE REWRITE
					// 231:5: -> assign(name=lvalue=body)
					{
						retval.st = templateLib.getInstanceOf("assign",new STAttrMap().put("name", l).put("value", body));
					}



					}
					break;
				case 10 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:236:5: ^( STAR b= body[bindings, unbindings] )
					{
					match(input,STAR,FOLLOW_STAR_in_body1123); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1127);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 238:5: -> star(body=b)
					{
						retval.st = templateLib.getInstanceOf("star",new STAttrMap().put("body", b));
					}



					}
					break;
				case 11 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:242:5: ^( PLUS b= body[bindings, unbindings] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_body1169); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1173);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 244:5: -> plus(body=b)
					{
						retval.st = templateLib.getInstanceOf("plus",new STAttrMap().put("body", b));
					}



					}
					break;
				case 12 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:248:5: ^( CHOICE (b= body[bindings, unbindings] )+ )
					{
					 List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
					match(input,CHOICE,FOLLOW_CHOICE_in_body1221); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/grammars/generator/KGGenerator.g:250:7: (b= body[bindings, unbindings] )+
					int cnt8=0;
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( ((LA8_0 >= ACT && LA8_0 <= ANY)||LA8_0==ASSIGN||LA8_0==CHOICE||LA8_0==DISPATCHED||LA8_0==DOT||LA8_0==IDENTIFIER||(LA8_0 >= LIMIT && LA8_0 <= LITERAL)||(LA8_0 >= NOSKIP && LA8_0 <= NUMBER)||(LA8_0 >= OPTIONAL && LA8_0 <= PERMUTED)||LA8_0==PLUS||(LA8_0 >= SEQUENCE && LA8_0 <= TAG)) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KGGenerator.g:250:8: b= body[bindings, unbindings]
							{
							pushFollow(FOLLOW_body_in_body1232);
							b=body(bindings, unbindings);
							state._fsp--;

							 steps.add((b!=null?((StringTemplate)b.getTemplate()):null)); 
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

					// TEMPLATE REWRITE
					// 255:5: -> choice(step=steps)
					{
						retval.st = templateLib.getInstanceOf("choice",new STAttrMap().put("step", steps));
					}



					}
					break;
				case 13 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:259:5: ^( DISPATCHED (c= caze )+ )
					{
					 List<String> keys = new ArrayList<String>();
					      List<StringTemplate> rules = new ArrayList<StringTemplate>();
					    
					match(input,DISPATCHED,FOLLOW_DISPATCHED_in_body1306); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/grammars/generator/KGGenerator.g:263:7: (c= caze )+
					int cnt9=0;
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==CASE) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KGGenerator.g:263:8: c= caze
							{
							pushFollow(FOLLOW_caze_in_body1317);
							c=caze();
							state._fsp--;

							 keys.add((c!=null?((KGGenerator.caze_return)c).key:null)); rules.add((c!=null?((KGGenerator.caze_return)c).body:null)); 
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
					// 268:5: -> dispatched(keys=keysrules=rules)
					{
						retval.st = templateLib.getInstanceOf("dispatched",new STAttrMap().put("keys", keys).put("rules", rules));
					}



					}
					break;
				case 14 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:273:5: ^( OPTIONAL b= body[bindings, unbindings] )
					{
					match(input,OPTIONAL,FOLLOW_OPTIONAL_in_body1397); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1401);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 275:5: -> optional(body=b)
					{
						retval.st = templateLib.getInstanceOf("optional",new STAttrMap().put("body", b));
					}



					}
					break;
				case 15 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:279:5: ^( SKIP_TO b= body[bindings, unbindings] )
					{
					match(input,SKIP_TO,FOLLOW_SKIP_TO_in_body1443); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1447);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 281:5: -> skipto(body=b)
					{
						retval.st = templateLib.getInstanceOf("skipto",new STAttrMap().put("body", b));
					}



					}
					break;
				case 16 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:285:5: ^( PERMUTED (b= body[bindings, unbindings] )+ )
					{
					 List<StringTemplate> choices = new LinkedList<StringTemplate>(); 
					match(input,PERMUTED,FOLLOW_PERMUTED_in_body1493); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/grammars/generator/KGGenerator.g:287:7: (b= body[bindings, unbindings] )+
					int cnt10=0;
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( ((LA10_0 >= ACT && LA10_0 <= ANY)||LA10_0==ASSIGN||LA10_0==CHOICE||LA10_0==DISPATCHED||LA10_0==DOT||LA10_0==IDENTIFIER||(LA10_0 >= LIMIT && LA10_0 <= LITERAL)||(LA10_0 >= NOSKIP && LA10_0 <= NUMBER)||(LA10_0 >= OPTIONAL && LA10_0 <= PERMUTED)||LA10_0==PLUS||(LA10_0 >= SEQUENCE && LA10_0 <= TAG)) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KGGenerator.g:287:8: b= body[bindings, unbindings]
							{
							pushFollow(FOLLOW_body_in_body1504);
							b=body(bindings, unbindings);
							state._fsp--;

							 choices.add((b!=null?((StringTemplate)b.getTemplate()):null)); 
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

					// TEMPLATE REWRITE
					// 292:5: -> permuted(choice=choices)
					{
						retval.st = templateLib.getInstanceOf("permuted",new STAttrMap().put("choice", choices));
					}



					}
					break;
				case 17 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:296:5: ^( NOT b= body[bindings, unbindings] )
					{
					match(input,NOT,FOLLOW_NOT_in_body1566); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1570);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 298:5: -> not(body=b)
					{
						retval.st = templateLib.getInstanceOf("not",new STAttrMap().put("body", b));
					}



					}
					break;
				case 18 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:302:5: ^( NOSKIP b= body[bindings, unbindings] )
					{
					match(input,NOSKIP,FOLLOW_NOSKIP_in_body1610); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1614);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					 String option = "NOSKIP"; 
					// TEMPLATE REWRITE
					// 305:5: -> opt(option=optionbody=b)
					{
						retval.st = templateLib.getInstanceOf("opt",new STAttrMap().put("option", option).put("body", b));
					}



					}
					break;
				case 19 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:310:5: ^( LIMIT b_t= body[bindings, unbindings] b_l= body[bindings, unbindings] )
					{
					match(input,LIMIT,FOLLOW_LIMIT_in_body1672); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1676);
					b_t=body(bindings, unbindings);
					state._fsp--;

					pushFollow(FOLLOW_body_in_body1681);
					b_l=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 312:5: -> limit(target=b_tlimiter=b_l)
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


	public static class caze_return extends TreeRuleReturnScope {
		public String key;
		public StringTemplate body;
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "caze"
	// src/core/koopa/core/grammars/generator/KGGenerator.g:318:1: caze returns [ String key, StringTemplate body ] : ^( CASE i= IDENTIFIER b= body[null, null] ) ;
	public final KGGenerator.caze_return caze() throws RecognitionException {
		KGGenerator.caze_return retval = new KGGenerator.caze_return();
		retval.start = input.LT(1);

		CommonTree i=null;
		TreeRuleReturnScope b =null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:319:3: ( ^( CASE i= IDENTIFIER b= body[null, null] ) )
			// src/core/koopa/core/grammars/generator/KGGenerator.g:319:5: ^( CASE i= IDENTIFIER b= body[null, null] )
			{
			match(input,CASE,FOLLOW_CASE_in_caze1744); 
			match(input, Token.DOWN, null); 
			i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_caze1748); 
			pushFollow(FOLLOW_body_in_caze1752);
			b=body(null, null);
			state._fsp--;

			match(input, Token.UP, null); 

			 retval.key = ((CommonTree) i).getText();
			      retval.body = (b!=null?((StringTemplate)b.getTemplate()):null);
			    
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
	// $ANTLR end "caze"

	// Delegated rules



	public static final BitSet FOLLOW_GRAMMAR_in_koopa68 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_meta_in_koopa76 = new BitSet(new long[]{0x0000100000000008L});
	public static final BitSet FOLLOW_rule_in_koopa88 = new BitSet(new long[]{0x0000100000000008L});
	public static final BitSet FOLLOW_META_in_meta222 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_named_in_meta226 = new BitSet(new long[]{0x0000000000800008L});
	public static final BitSet FOLLOW_extending_in_meta231 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NAMED_in_named263 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_named267 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EXTENDING_in_extending295 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_extending299 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RULE_in_rule329 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_rule333 = new BitSet(new long[]{0x0001ED9C3A2810B0L});
	public static final BitSet FOLLOW_locals_in_rule345 = new BitSet(new long[]{0x0001ED9C1A2810B0L});
	public static final BitSet FOLLOW_returning_in_rule376 = new BitSet(new long[]{0x0001E59C1A2810B0L});
	public static final BitSet FOLLOW_body_in_rule389 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURNS_in_returning472 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_returning476 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOCALS_in_locals525 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_locals536 = new BitSet(new long[]{0x0000000000020008L});
	public static final BitSet FOLLOW_DECLARATION_in_declaration579 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration583 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration587 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SEQUENCE_in_body616 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body627 = new BitSet(new long[]{0x0001E59C1A2810B8L});
	public static final BitSet FOLLOW_ACT_in_body695 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_NATIVE_CODE_in_body699 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TAG_in_body769 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ANY_in_body808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LITERAL_in_body830 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_body880 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body919 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_body1001 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_body1041 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body1045 = new BitSet(new long[]{0x0000001002200000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body1050 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NUMBER_in_body1056 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DOT_in_body1062 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STAR_in_body1123 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1127 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_body1169 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1173 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHOICE_in_body1221 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1232 = new BitSet(new long[]{0x0001E59C1A2810B8L});
	public static final BitSet FOLLOW_DISPATCHED_in_body1306 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_caze_in_body1317 = new BitSet(new long[]{0x0000000000000808L});
	public static final BitSet FOLLOW_OPTIONAL_in_body1397 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1401 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SKIP_TO_in_body1443 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1447 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PERMUTED_in_body1493 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1504 = new BitSet(new long[]{0x0001E59C1A2810B8L});
	public static final BitSet FOLLOW_NOT_in_body1566 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1570 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOSKIP_in_body1610 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1614 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LIMIT_in_body1672 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1676 = new BitSet(new long[]{0x0001E59C1A2810B0L});
	public static final BitSet FOLLOW_body_in_body1681 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CASE_in_caze1744 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_caze1748 = new BitSet(new long[]{0x0001E59C1A2810B0L});
	public static final BitSet FOLLOW_body_in_caze1752 = new BitSet(new long[]{0x0000000000000008L});
}
