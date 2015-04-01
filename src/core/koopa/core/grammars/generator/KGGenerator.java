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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACT", "ANY", "ARROW", "AS", "ASSIGN", 
		"BANG", "BODY", "BY", "CASE", "CHOICE", "CLOSE_BRACKET", "CLOSE_PAREN", 
		"COMMA", "COMMENT", "DECLARATION", "DIGIT", "DISPATCHED", "DOLLAR", "DOT", 
		"EQUALS", "EXTENDING", "GRAMMAR", "IDENTIFIER", "LETTER", "LIMIT", "LITERAL", 
		"LOCALS", "LOWERCASE", "META", "NAMED", "NATIVE_CODE", "NEWLINE", "NOSKIP", 
		"NOT", "NUMBER", "OPEN_BRACKET", "OPEN_PAREN", "OPTIONAL", "PERMUTED", 
		"PIPE", "PLUS", "PRIVATE", "PUBLIC", "RETURNS", "RULE", "SEQUENCE", "SKIP_TO", 
		"STAR", "TAG", "TOKEN", "TREE", "UPPERCASE", "WHITESPACE", "WITH", "'def'", 
		"'end'", "'extends'", "'grammar'", "'returns'", "'tree'"
	};
	public static final int EOF=-1;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
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
	public static final int COMMA=16;
	public static final int COMMENT=17;
	public static final int DECLARATION=18;
	public static final int DIGIT=19;
	public static final int DISPATCHED=20;
	public static final int DOLLAR=21;
	public static final int DOT=22;
	public static final int EQUALS=23;
	public static final int EXTENDING=24;
	public static final int GRAMMAR=25;
	public static final int IDENTIFIER=26;
	public static final int LETTER=27;
	public static final int LIMIT=28;
	public static final int LITERAL=29;
	public static final int LOCALS=30;
	public static final int LOWERCASE=31;
	public static final int META=32;
	public static final int NAMED=33;
	public static final int NATIVE_CODE=34;
	public static final int NEWLINE=35;
	public static final int NOSKIP=36;
	public static final int NOT=37;
	public static final int NUMBER=38;
	public static final int OPEN_BRACKET=39;
	public static final int OPEN_PAREN=40;
	public static final int OPTIONAL=41;
	public static final int PERMUTED=42;
	public static final int PIPE=43;
	public static final int PLUS=44;
	public static final int PRIVATE=45;
	public static final int PUBLIC=46;
	public static final int RETURNS=47;
	public static final int RULE=48;
	public static final int SEQUENCE=49;
	public static final int SKIP_TO=50;
	public static final int STAR=51;
	public static final int TAG=52;
	public static final int TOKEN=53;
	public static final int TREE=54;
	public static final int UPPERCASE=55;
	public static final int WHITESPACE=56;
	public static final int WITH=57;

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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:53:1: named returns [String name = null] : ^( NAMED (i= IDENTIFIER |i= TOKEN ) ) ;
	public final KGGenerator.named_return named() throws RecognitionException {
		KGGenerator.named_return retval = new KGGenerator.named_return();
		retval.start = input.LT(1);

		CommonTree i=null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:54:3: ( ^( NAMED (i= IDENTIFIER |i= TOKEN ) ) )
			// src/core/koopa/core/grammars/generator/KGGenerator.g:54:5: ^( NAMED (i= IDENTIFIER |i= TOKEN ) )
			{
			match(input,NAMED,FOLLOW_NAMED_in_named263); 
			match(input, Token.DOWN, null); 
			// src/core/koopa/core/grammars/generator/KGGenerator.g:54:13: (i= IDENTIFIER |i= TOKEN )
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
					// src/core/koopa/core/grammars/generator/KGGenerator.g:54:14: i= IDENTIFIER
					{
					i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_named268); 
					}
					break;
				case 2 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:54:29: i= TOKEN
					{
					i=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_named274); 
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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:59:1: extending returns [String name = null] : ^( EXTENDING (i= IDENTIFIER |i= TOKEN ) ) ;
	public final KGGenerator.extending_return extending() throws RecognitionException {
		KGGenerator.extending_return retval = new KGGenerator.extending_return();
		retval.start = input.LT(1);

		CommonTree i=null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:60:3: ( ^( EXTENDING (i= IDENTIFIER |i= TOKEN ) ) )
			// src/core/koopa/core/grammars/generator/KGGenerator.g:60:5: ^( EXTENDING (i= IDENTIFIER |i= TOKEN ) )
			{
			match(input,EXTENDING,FOLLOW_EXTENDING_in_extending303); 
			match(input, Token.DOWN, null); 
			// src/core/koopa/core/grammars/generator/KGGenerator.g:60:17: (i= IDENTIFIER |i= TOKEN )
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
					// src/core/koopa/core/grammars/generator/KGGenerator.g:60:18: i= IDENTIFIER
					{
					i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_extending308); 
					}
					break;
				case 2 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:60:33: i= TOKEN
					{
					i=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_extending314); 
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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:65:1: rule : ^( RULE ( PUBLIC | PRIVATE ) n= IDENTIFIER (l= locals )? (r= returning )? b= body[bindings, unbindings] ) -> rule(publik=publikname=nbody=bod);
	public final KGGenerator.rule_return rule() throws RecognitionException {
		KGGenerator.rule_return retval = new KGGenerator.rule_return();
		retval.start = input.LT(1);

		CommonTree n=null;
		TreeRuleReturnScope l =null;
		TreeRuleReturnScope r =null;
		TreeRuleReturnScope b =null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:66:3: ( ^( RULE ( PUBLIC | PRIVATE ) n= IDENTIFIER (l= locals )? (r= returning )? b= body[bindings, unbindings] ) -> rule(publik=publikname=nbody=bod))
			// src/core/koopa/core/grammars/generator/KGGenerator.g:66:5: ^( RULE ( PUBLIC | PRIVATE ) n= IDENTIFIER (l= locals )? (r= returning )? b= body[bindings, unbindings] )
			{
			 boolean publik = true;
			      List<String> bindings = null;
			      List<String> unbindings = null;
			      StringTemplate bod = null;
			    
			match(input,RULE,FOLLOW_RULE_in_rule345); 
			match(input, Token.DOWN, null); 
			// src/core/koopa/core/grammars/generator/KGGenerator.g:73:7: ( PUBLIC | PRIVATE )
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
					// src/core/koopa/core/grammars/generator/KGGenerator.g:73:9: PUBLIC
					{
					match(input,PUBLIC,FOLLOW_PUBLIC_in_rule363); 
					 publik = true;  
					}
					break;
				case 2 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:74:9: PRIVATE
					{
					match(input,PRIVATE,FOLLOW_PRIVATE_in_rule377); 
					 publik = false; 
					}
					break;

			}

			n=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule405); 
			// src/core/koopa/core/grammars/generator/KGGenerator.g:79:7: (l= locals )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==LOCALS) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:79:8: l= locals
					{
					pushFollow(FOLLOW_locals_in_rule422);
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

			// src/core/koopa/core/grammars/generator/KGGenerator.g:99:7: (r= returning )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==RETURNS) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:99:8: r= returning
					{
					pushFollow(FOLLOW_returning_in_rule453);
					r=returning();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_body_in_rule466);
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
			// 116:5: -> rule(publik=publikname=nbody=bod)
			{
				retval.st = templateLib.getInstanceOf("rule",new STAttrMap().put("publik", publik).put("name", n).put("body", bod));
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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:123:1: returning : ^( RETURNS i= IDENTIFIER ) -> returning(name=((CommonTree) $i).getText());
	public final KGGenerator.returning_return returning() throws RecognitionException {
		KGGenerator.returning_return retval = new KGGenerator.returning_return();
		retval.start = input.LT(1);

		CommonTree i=null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:124:3: ( ^( RETURNS i= IDENTIFIER ) -> returning(name=((CommonTree) $i).getText()))
			// src/core/koopa/core/grammars/generator/KGGenerator.g:124:5: ^( RETURNS i= IDENTIFIER )
			{
			match(input,RETURNS,FOLLOW_RETURNS_in_returning565); 
			match(input, Token.DOWN, null); 
			i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_returning569); 
			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 126:5: -> returning(name=((CommonTree) $i).getText())
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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:131:1: locals returns [List<Tuple<String, String>> tuples = new LinkedList<Tuple<String, String>>()] : ^( LOCALS (d= declaration )+ ) ;
	public final KGGenerator.locals_return locals() throws RecognitionException {
		KGGenerator.locals_return retval = new KGGenerator.locals_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope d =null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:132:3: ( ^( LOCALS (d= declaration )+ ) )
			// src/core/koopa/core/grammars/generator/KGGenerator.g:132:5: ^( LOCALS (d= declaration )+ )
			{
			match(input,LOCALS,FOLLOW_LOCALS_in_locals618); 
			match(input, Token.DOWN, null); 
			// src/core/koopa/core/grammars/generator/KGGenerator.g:133:7: (d= declaration )+
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
					// src/core/koopa/core/grammars/generator/KGGenerator.g:133:8: d= declaration
					{
					pushFollow(FOLLOW_declaration_in_locals629);
					d=declaration();
					state._fsp--;

					 retval.tuples.add((d!=null?((KGGenerator.declaration_return)d).tuple:null)); 
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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:139:1: declaration returns [Tuple<String, String> tuple = null] : ^( DECLARATION (a= IDENTIFIER |a= TOKEN ) (b= IDENTIFIER |b= TOKEN ) ) ;
	public final KGGenerator.declaration_return declaration() throws RecognitionException {
		KGGenerator.declaration_return retval = new KGGenerator.declaration_return();
		retval.start = input.LT(1);

		CommonTree a=null;
		CommonTree b=null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:140:3: ( ^( DECLARATION (a= IDENTIFIER |a= TOKEN ) (b= IDENTIFIER |b= TOKEN ) ) )
			// src/core/koopa/core/grammars/generator/KGGenerator.g:140:5: ^( DECLARATION (a= IDENTIFIER |a= TOKEN ) (b= IDENTIFIER |b= TOKEN ) )
			{
			match(input,DECLARATION,FOLLOW_DECLARATION_in_declaration672); 
			match(input, Token.DOWN, null); 
			// src/core/koopa/core/grammars/generator/KGGenerator.g:140:19: (a= IDENTIFIER |a= TOKEN )
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
					// src/core/koopa/core/grammars/generator/KGGenerator.g:140:20: a= IDENTIFIER
					{
					a=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration677); 
					}
					break;
				case 2 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:140:33: a= TOKEN
					{
					a=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_declaration681); 
					}
					break;

			}

			// src/core/koopa/core/grammars/generator/KGGenerator.g:140:42: (b= IDENTIFIER |b= TOKEN )
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
					// src/core/koopa/core/grammars/generator/KGGenerator.g:140:43: b= IDENTIFIER
					{
					b=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration687); 
					}
					break;
				case 2 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:140:56: b= TOKEN
					{
					b=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_declaration691); 
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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:144:1: body[ List<String> bindings, List<String> unbindings ] : ( ^( SEQUENCE (b= body[bindings, unbindings] )+ ) -> sequence(step=steps)| ^( ACT n= NATIVE_CODE ) -> apply(bind=bindingsnative_code=nunbind=unbindings)|t= TAG -> tag(text=name)| ANY -> any(|l= LITERAL -> token(text=unquoted)|n= NUMBER -> token(text=n)|i= IDENTIFIER -> call(name=i)|t= TOKEN -> token(text=t)|d= DOT -> token(text=d)| ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER |t= TOKEN |n= NUMBER |d= DOT ) ) -> assign(name=lvalue=body)| ^( STAR b= body[bindings, unbindings] ) -> star(body=b)| ^( PLUS b= body[bindings, unbindings] ) -> plus(body=b)| ^( CHOICE (b= body[bindings, unbindings] )+ ) -> choice(step=steps)| ^( DISPATCHED (c= caze )+ ) -> dispatched(keys=keysrules=rules)| ^( OPTIONAL b= body[bindings, unbindings] ) -> optional(body=b)| ^( SKIP_TO b= body[bindings, unbindings] ) -> skipto(body=b)| ^( PERMUTED (b= body[bindings, unbindings] )+ ) -> permuted(choice=choices)| ^( NOT b= body[bindings, unbindings] ) -> not(body=b)| ^( NOSKIP b= body[bindings, unbindings] ) -> opt(option=optionbody=b)| ^( LIMIT b_t= body[bindings, unbindings] b_l= body[bindings, unbindings] ) -> limit(target=b_tlimiter=b_l)| ^( AS i= IDENTIFIER b= body[bindings, unbindings] ) -> as(name=ibody=b));
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
			// src/core/koopa/core/grammars/generator/KGGenerator.g:145:3: ( ^( SEQUENCE (b= body[bindings, unbindings] )+ ) -> sequence(step=steps)| ^( ACT n= NATIVE_CODE ) -> apply(bind=bindingsnative_code=nunbind=unbindings)|t= TAG -> tag(text=name)| ANY -> any(|l= LITERAL -> token(text=unquoted)|n= NUMBER -> token(text=n)|i= IDENTIFIER -> call(name=i)|t= TOKEN -> token(text=t)|d= DOT -> token(text=d)| ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER |t= TOKEN |n= NUMBER |d= DOT ) ) -> assign(name=lvalue=body)| ^( STAR b= body[bindings, unbindings] ) -> star(body=b)| ^( PLUS b= body[bindings, unbindings] ) -> plus(body=b)| ^( CHOICE (b= body[bindings, unbindings] )+ ) -> choice(step=steps)| ^( DISPATCHED (c= caze )+ ) -> dispatched(keys=keysrules=rules)| ^( OPTIONAL b= body[bindings, unbindings] ) -> optional(body=b)| ^( SKIP_TO b= body[bindings, unbindings] ) -> skipto(body=b)| ^( PERMUTED (b= body[bindings, unbindings] )+ ) -> permuted(choice=choices)| ^( NOT b= body[bindings, unbindings] ) -> not(body=b)| ^( NOSKIP b= body[bindings, unbindings] ) -> opt(option=optionbody=b)| ^( LIMIT b_t= body[bindings, unbindings] b_l= body[bindings, unbindings] ) -> limit(target=b_tlimiter=b_l)| ^( AS i= IDENTIFIER b= body[bindings, unbindings] ) -> as(name=ibody=b))
			int alt16=21;
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
			case TAG:
				{
				alt16=3;
				}
				break;
			case ANY:
				{
				alt16=4;
				}
				break;
			case LITERAL:
				{
				alt16=5;
				}
				break;
			case NUMBER:
				{
				alt16=6;
				}
				break;
			case IDENTIFIER:
				{
				alt16=7;
				}
				break;
			case TOKEN:
				{
				alt16=8;
				}
				break;
			case DOT:
				{
				alt16=9;
				}
				break;
			case ASSIGN:
				{
				alt16=10;
				}
				break;
			case STAR:
				{
				alt16=11;
				}
				break;
			case PLUS:
				{
				alt16=12;
				}
				break;
			case CHOICE:
				{
				alt16=13;
				}
				break;
			case DISPATCHED:
				{
				alt16=14;
				}
				break;
			case OPTIONAL:
				{
				alt16=15;
				}
				break;
			case SKIP_TO:
				{
				alt16=16;
				}
				break;
			case PERMUTED:
				{
				alt16=17;
				}
				break;
			case NOT:
				{
				alt16=18;
				}
				break;
			case NOSKIP:
				{
				alt16=19;
				}
				break;
			case LIMIT:
				{
				alt16=20;
				}
				break;
			case AS:
				{
				alt16=21;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}
			switch (alt16) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:145:5: ^( SEQUENCE (b= body[bindings, unbindings] )+ )
					{
					 List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
					match(input,SEQUENCE,FOLLOW_SEQUENCE_in_body721); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/grammars/generator/KGGenerator.g:147:7: (b= body[bindings, unbindings] )+
					int cnt11=0;
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( ((LA11_0 >= ACT && LA11_0 <= ANY)||(LA11_0 >= AS && LA11_0 <= ASSIGN)||LA11_0==CHOICE||LA11_0==DISPATCHED||LA11_0==DOT||LA11_0==IDENTIFIER||(LA11_0 >= LIMIT && LA11_0 <= LITERAL)||(LA11_0 >= NOSKIP && LA11_0 <= NUMBER)||(LA11_0 >= OPTIONAL && LA11_0 <= PERMUTED)||LA11_0==PLUS||(LA11_0 >= SEQUENCE && LA11_0 <= TOKEN)) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KGGenerator.g:147:8: b= body[bindings, unbindings]
							{
							pushFollow(FOLLOW_body_in_body732);
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
					// 152:5: -> sequence(step=steps)
					{
						retval.st = templateLib.getInstanceOf("sequence",new STAttrMap().put("step", steps));
					}



					}
					break;
				case 2 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:156:5: ^( ACT n= NATIVE_CODE )
					{
					match(input,ACT,FOLLOW_ACT_in_body800); 
					match(input, Token.DOWN, null); 
					n=(CommonTree)match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_body804); 
					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 158:5: -> apply(bind=bindingsnative_code=nunbind=unbindings)
					{
						retval.st = templateLib.getInstanceOf("apply",new STAttrMap().put("bind", bindings).put("native_code", n).put("unbind", unbindings));
					}



					}
					break;
				case 3 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:164:5: t= TAG
					{
					t=(CommonTree)match(input,TAG,FOLLOW_TAG_in_body874); 
					 String name = ((CommonTree) t).getText();
					      name = name.substring(1, name.length()); 
						
					// TEMPLATE REWRITE
					// 170:5: -> tag(text=name)
					{
						retval.st = templateLib.getInstanceOf("tag",new STAttrMap().put("text", name));
					}



					}
					break;
				case 4 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:174:5: ANY
					{
					match(input,ANY,FOLLOW_ANY_in_body913); 
					// TEMPLATE REWRITE
					// 176:5: -> any(
					{
						retval.st = templateLib.getInstanceOf("any");
					}



					}
					break;
				case 5 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:178:5: l= LITERAL
					{
					l=(CommonTree)match(input,LITERAL,FOLLOW_LITERAL_in_body935); 
					 String unquoted = ((CommonTree) l).getText();
					      unquoted = unquoted.substring(1, unquoted.length() - 1); 
					    
					// TEMPLATE REWRITE
					// 184:5: -> token(text=unquoted)
					{
						retval.st = templateLib.getInstanceOf("token",new STAttrMap().put("text", unquoted));
					}



					}
					break;
				case 6 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:188:5: n= NUMBER
					{
					n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body985); 
					// TEMPLATE REWRITE
					// 190:5: -> token(text=n)
					{
						retval.st = templateLib.getInstanceOf("token",new STAttrMap().put("text", n));
					}



					}
					break;
				case 7 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:194:5: i= IDENTIFIER
					{
					i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body1024); 
					// TEMPLATE REWRITE
					// 196:5: -> call(name=i)
					{
						retval.st = templateLib.getInstanceOf("call",new STAttrMap().put("name", i));
					}



					}
					break;
				case 8 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:200:5: t= TOKEN
					{
					t=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_body1067); 
					// TEMPLATE REWRITE
					// 202:5: -> token(text=t)
					{
						retval.st = templateLib.getInstanceOf("token",new STAttrMap().put("text", t));
					}



					}
					break;
				case 9 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:206:5: d= DOT
					{
					d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body1108); 
					// TEMPLATE REWRITE
					// 208:5: -> token(text=d)
					{
						retval.st = templateLib.getInstanceOf("token",new STAttrMap().put("text", d));
					}



					}
					break;
				case 10 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:212:5: ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER |t= TOKEN |n= NUMBER |d= DOT ) )
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_body1148); 
					match(input, Token.DOWN, null); 
					l=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body1152); 
					// src/core/koopa/core/grammars/generator/KGGenerator.g:212:27: (i= IDENTIFIER |t= TOKEN |n= NUMBER |d= DOT )
					int alt12=4;
					switch ( input.LA(1) ) {
					case IDENTIFIER:
						{
						alt12=1;
						}
						break;
					case TOKEN:
						{
						alt12=2;
						}
						break;
					case NUMBER:
						{
						alt12=3;
						}
						break;
					case DOT:
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
							// src/core/koopa/core/grammars/generator/KGGenerator.g:212:28: i= IDENTIFIER
							{
							i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body1157); 
							}
							break;
						case 2 :
							// src/core/koopa/core/grammars/generator/KGGenerator.g:212:43: t= TOKEN
							{
							t=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_body1163); 
							}
							break;
						case 3 :
							// src/core/koopa/core/grammars/generator/KGGenerator.g:212:53: n= NUMBER
							{
							n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body1169); 
							}
							break;
						case 4 :
							// src/core/koopa/core/grammars/generator/KGGenerator.g:212:64: d= DOT
							{
							d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body1175); 
							}
							break;

					}

					match(input, Token.UP, null); 

					 StringTemplate body = null;
					      if (i != null) {
					        body = templateLib.getInstanceOf("call",new STAttrMap().put("name", i));
					      
					      } else if (t != null) {
					        body = templateLib.getInstanceOf("token",new STAttrMap().put("text", t));
					      
					      } else if (n != null) {
					        body = templateLib.getInstanceOf("token",new STAttrMap().put("text", n));
					      
					      } else {
					        body = templateLib.getInstanceOf("token",new STAttrMap().put("text", "."));
					      }
					    
					// TEMPLATE REWRITE
					// 236:5: -> assign(name=lvalue=body)
					{
						retval.st = templateLib.getInstanceOf("assign",new STAttrMap().put("name", l).put("value", body));
					}



					}
					break;
				case 11 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:241:5: ^( STAR b= body[bindings, unbindings] )
					{
					match(input,STAR,FOLLOW_STAR_in_body1236); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1240);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 243:5: -> star(body=b)
					{
						retval.st = templateLib.getInstanceOf("star",new STAttrMap().put("body", b));
					}



					}
					break;
				case 12 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:247:5: ^( PLUS b= body[bindings, unbindings] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_body1282); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1286);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 249:5: -> plus(body=b)
					{
						retval.st = templateLib.getInstanceOf("plus",new STAttrMap().put("body", b));
					}



					}
					break;
				case 13 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:253:5: ^( CHOICE (b= body[bindings, unbindings] )+ )
					{
					 List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
					match(input,CHOICE,FOLLOW_CHOICE_in_body1334); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/grammars/generator/KGGenerator.g:255:7: (b= body[bindings, unbindings] )+
					int cnt13=0;
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( ((LA13_0 >= ACT && LA13_0 <= ANY)||(LA13_0 >= AS && LA13_0 <= ASSIGN)||LA13_0==CHOICE||LA13_0==DISPATCHED||LA13_0==DOT||LA13_0==IDENTIFIER||(LA13_0 >= LIMIT && LA13_0 <= LITERAL)||(LA13_0 >= NOSKIP && LA13_0 <= NUMBER)||(LA13_0 >= OPTIONAL && LA13_0 <= PERMUTED)||LA13_0==PLUS||(LA13_0 >= SEQUENCE && LA13_0 <= TOKEN)) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KGGenerator.g:255:8: b= body[bindings, unbindings]
							{
							pushFollow(FOLLOW_body_in_body1345);
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
					// 260:5: -> choice(step=steps)
					{
						retval.st = templateLib.getInstanceOf("choice",new STAttrMap().put("step", steps));
					}



					}
					break;
				case 14 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:264:5: ^( DISPATCHED (c= caze )+ )
					{
					 List<String> keys = new ArrayList<String>();
					      List<StringTemplate> rules = new ArrayList<StringTemplate>();
					    
					match(input,DISPATCHED,FOLLOW_DISPATCHED_in_body1419); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/grammars/generator/KGGenerator.g:268:7: (c= caze )+
					int cnt14=0;
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==CASE) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KGGenerator.g:268:8: c= caze
							{
							pushFollow(FOLLOW_caze_in_body1430);
							c=caze();
							state._fsp--;

							 keys.add((c!=null?((KGGenerator.caze_return)c).key:null)); rules.add((c!=null?((KGGenerator.caze_return)c).body:null)); 
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

					// TEMPLATE REWRITE
					// 273:5: -> dispatched(keys=keysrules=rules)
					{
						retval.st = templateLib.getInstanceOf("dispatched",new STAttrMap().put("keys", keys).put("rules", rules));
					}



					}
					break;
				case 15 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:278:5: ^( OPTIONAL b= body[bindings, unbindings] )
					{
					match(input,OPTIONAL,FOLLOW_OPTIONAL_in_body1510); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1514);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 280:5: -> optional(body=b)
					{
						retval.st = templateLib.getInstanceOf("optional",new STAttrMap().put("body", b));
					}



					}
					break;
				case 16 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:284:5: ^( SKIP_TO b= body[bindings, unbindings] )
					{
					match(input,SKIP_TO,FOLLOW_SKIP_TO_in_body1556); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1560);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 286:5: -> skipto(body=b)
					{
						retval.st = templateLib.getInstanceOf("skipto",new STAttrMap().put("body", b));
					}



					}
					break;
				case 17 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:290:5: ^( PERMUTED (b= body[bindings, unbindings] )+ )
					{
					 List<StringTemplate> choices = new LinkedList<StringTemplate>(); 
					match(input,PERMUTED,FOLLOW_PERMUTED_in_body1606); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/grammars/generator/KGGenerator.g:292:7: (b= body[bindings, unbindings] )+
					int cnt15=0;
					loop15:
					while (true) {
						int alt15=2;
						int LA15_0 = input.LA(1);
						if ( ((LA15_0 >= ACT && LA15_0 <= ANY)||(LA15_0 >= AS && LA15_0 <= ASSIGN)||LA15_0==CHOICE||LA15_0==DISPATCHED||LA15_0==DOT||LA15_0==IDENTIFIER||(LA15_0 >= LIMIT && LA15_0 <= LITERAL)||(LA15_0 >= NOSKIP && LA15_0 <= NUMBER)||(LA15_0 >= OPTIONAL && LA15_0 <= PERMUTED)||LA15_0==PLUS||(LA15_0 >= SEQUENCE && LA15_0 <= TOKEN)) ) {
							alt15=1;
						}

						switch (alt15) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KGGenerator.g:292:8: b= body[bindings, unbindings]
							{
							pushFollow(FOLLOW_body_in_body1617);
							b=body(bindings, unbindings);
							state._fsp--;

							 choices.add((b!=null?((StringTemplate)b.getTemplate()):null)); 
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

					// TEMPLATE REWRITE
					// 297:5: -> permuted(choice=choices)
					{
						retval.st = templateLib.getInstanceOf("permuted",new STAttrMap().put("choice", choices));
					}



					}
					break;
				case 18 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:301:5: ^( NOT b= body[bindings, unbindings] )
					{
					match(input,NOT,FOLLOW_NOT_in_body1679); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1683);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 303:5: -> not(body=b)
					{
						retval.st = templateLib.getInstanceOf("not",new STAttrMap().put("body", b));
					}



					}
					break;
				case 19 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:307:5: ^( NOSKIP b= body[bindings, unbindings] )
					{
					match(input,NOSKIP,FOLLOW_NOSKIP_in_body1723); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1727);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					 String option = "NOSKIP"; 
					// TEMPLATE REWRITE
					// 310:5: -> opt(option=optionbody=b)
					{
						retval.st = templateLib.getInstanceOf("opt",new STAttrMap().put("option", option).put("body", b));
					}



					}
					break;
				case 20 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:315:5: ^( LIMIT b_t= body[bindings, unbindings] b_l= body[bindings, unbindings] )
					{
					match(input,LIMIT,FOLLOW_LIMIT_in_body1785); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body1789);
					b_t=body(bindings, unbindings);
					state._fsp--;

					pushFollow(FOLLOW_body_in_body1794);
					b_l=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 317:5: -> limit(target=b_tlimiter=b_l)
					{
						retval.st = templateLib.getInstanceOf("limit",new STAttrMap().put("target", b_t).put("limiter", b_l));
					}



					}
					break;
				case 21 :
					// src/core/koopa/core/grammars/generator/KGGenerator.g:322:5: ^( AS i= IDENTIFIER b= body[bindings, unbindings] )
					{
					match(input,AS,FOLLOW_AS_in_body1851); 
					match(input, Token.DOWN, null); 
					i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body1855); 
					pushFollow(FOLLOW_body_in_body1859);
					b=body(bindings, unbindings);
					state._fsp--;

					match(input, Token.UP, null); 

					// TEMPLATE REWRITE
					// 324:5: -> as(name=ibody=b)
					{
						retval.st = templateLib.getInstanceOf("as",new STAttrMap().put("name", i).put("body", b));
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
	// src/core/koopa/core/grammars/generator/KGGenerator.g:330:1: caze returns [ String key, StringTemplate body ] : ^( CASE t= TOKEN b= body[null, null] ) ;
	public final KGGenerator.caze_return caze() throws RecognitionException {
		KGGenerator.caze_return retval = new KGGenerator.caze_return();
		retval.start = input.LT(1);

		CommonTree t=null;
		TreeRuleReturnScope b =null;

		try {
			// src/core/koopa/core/grammars/generator/KGGenerator.g:331:3: ( ^( CASE t= TOKEN b= body[null, null] ) )
			// src/core/koopa/core/grammars/generator/KGGenerator.g:331:5: ^( CASE t= TOKEN b= body[null, null] )
			{
			match(input,CASE,FOLLOW_CASE_in_caze1922); 
			match(input, Token.DOWN, null); 
			t=(CommonTree)match(input,TOKEN,FOLLOW_TOKEN_in_caze1926); 
			pushFollow(FOLLOW_body_in_caze1930);
			b=body(null, null);
			state._fsp--;

			match(input, Token.UP, null); 

			 retval.key = ((CommonTree) t).getText();
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
	public static final BitSet FOLLOW_meta_in_koopa76 = new BitSet(new long[]{0x0001000000000008L});
	public static final BitSet FOLLOW_rule_in_koopa88 = new BitSet(new long[]{0x0001000000000008L});
	public static final BitSet FOLLOW_META_in_meta222 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_named_in_meta226 = new BitSet(new long[]{0x0000000001000008L});
	public static final BitSet FOLLOW_extending_in_meta231 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NAMED_in_named263 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_named268 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_in_named274 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EXTENDING_in_extending303 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_extending308 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_in_extending314 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RULE_in_rule345 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_PUBLIC_in_rule363 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_PRIVATE_in_rule377 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_rule405 = new BitSet(new long[]{0x003E9670745021B0L});
	public static final BitSet FOLLOW_locals_in_rule422 = new BitSet(new long[]{0x003E9670345021B0L});
	public static final BitSet FOLLOW_returning_in_rule453 = new BitSet(new long[]{0x003E1670345021B0L});
	public static final BitSet FOLLOW_body_in_rule466 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURNS_in_returning565 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_returning569 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOCALS_in_locals618 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_locals629 = new BitSet(new long[]{0x0000000000040008L});
	public static final BitSet FOLLOW_DECLARATION_in_declaration672 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration677 = new BitSet(new long[]{0x0020000004000000L});
	public static final BitSet FOLLOW_TOKEN_in_declaration681 = new BitSet(new long[]{0x0020000004000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration687 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_in_declaration691 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SEQUENCE_in_body721 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body732 = new BitSet(new long[]{0x003E1670345021B8L});
	public static final BitSet FOLLOW_ACT_in_body800 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_NATIVE_CODE_in_body804 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TAG_in_body874 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ANY_in_body913 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LITERAL_in_body935 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_body985 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body1024 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TOKEN_in_body1067 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_body1108 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_body1148 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body1152 = new BitSet(new long[]{0x0020004004400000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body1157 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TOKEN_in_body1163 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NUMBER_in_body1169 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DOT_in_body1175 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STAR_in_body1236 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1240 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_body1282 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1286 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHOICE_in_body1334 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1345 = new BitSet(new long[]{0x003E1670345021B8L});
	public static final BitSet FOLLOW_DISPATCHED_in_body1419 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_caze_in_body1430 = new BitSet(new long[]{0x0000000000001008L});
	public static final BitSet FOLLOW_OPTIONAL_in_body1510 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1514 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SKIP_TO_in_body1556 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1560 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PERMUTED_in_body1606 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1617 = new BitSet(new long[]{0x003E1670345021B8L});
	public static final BitSet FOLLOW_NOT_in_body1679 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1683 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOSKIP_in_body1723 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1727 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LIMIT_in_body1785 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body1789 = new BitSet(new long[]{0x003E1670345021B0L});
	public static final BitSet FOLLOW_body_in_body1794 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AS_in_body1851 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body1855 = new BitSet(new long[]{0x003E1670345021B0L});
	public static final BitSet FOLLOW_body_in_body1859 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CASE_in_caze1922 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TOKEN_in_caze1926 = new BitSet(new long[]{0x003E1670345021B0L});
	public static final BitSet FOLLOW_body_in_caze1930 = new BitSet(new long[]{0x0000000000000008L});
}
