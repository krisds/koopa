// $ANTLR 3.1.1 src/core/koopa/core/grammars/generator/KGGenerator.g 2014-11-24 20:28:01

  package koopa.core.grammars.generator;
  
  import java.util.List;
  import java.util.LinkedList;
  import java.util.Date;
  import java.util.Set;
  import java.util.HashSet;
  import java.util.Properties;

  import koopa.core.util.Tuple;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
public class KGGenerator extends TreeParser {
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
    public static final int COMMA=24;
    public static final int EXTENDING=7;
    public static final int IDENTIFIER=19;
    public static final int PLUS=31;
    public static final int PIPE=38;
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
    public static class STAttrMap extends HashMap {
      public STAttrMap put(String attrName, Object value) {
        super.put(attrName, value);
        return this;
      }
      public STAttrMap put(String attrName, int value) {
        super.put(attrName, new Integer(value));
        return this;
      }
    }

    public String[] getTokenNames() { return KGGenerator.tokenNames; }
    public String getGrammarFileName() { return "src/core/koopa/core/grammars/generator/KGGenerator.g"; }




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

        List list_r=null;
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
            do {
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

            	    if (list_r==null) list_r=new ArrayList();
            	    list_r.add(r.getTemplate());


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 32:5: -> koopa(name=p.getProperty(\"named\")extending=p.getProperty(\"extending\")date=new Date()package=p.getProperty(\"package\")imports=importsrule=$rsupport_code=supportCode)
            {
                retval.st = templateLib.getInstanceOf("koopa",
              new STAttrMap().put("name", p.getProperty("named")).put("extending", p.getProperty("extending")).put("date", new Date()).put("package", p.getProperty("package")).put("imports", imports).put("rule", list_r).put("support_code", supportCode));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
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

        KGGenerator.named_return n = null;

        KGGenerator.extending_return e = null;


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
             meta.setProperty("named", (n!=null?n.name:null));
                
                  if (e != null) meta.setProperty("extending", (e!=null?e.name:null));
                  else meta.setProperty("extending", "Koopa");
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
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
        KGGenerator.locals_return l = null;

        KGGenerator.returning_return r = null;

        KGGenerator.body_return b = null;


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
                              
                              for(Tuple<String, String> tuple : (l!=null?l.tuples:null)) {
                                String type = tuple.getFirst();
                                String name = tuple.getSecond();

                                bindings.add(templateLib.getInstanceOf("bind",
                      new STAttrMap().put("name", name).put("type", type)).toString());
                                
                                unbindings.add(templateLib.getInstanceOf("unbind",
                      new STAttrMap().put("name", name)).toString());
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
                      steps.add(b.st);
                      steps.add(r.st);
                      bod = templateLib.getInstanceOf("sequence",
              new STAttrMap().put("step", steps));
                      
                    } else {
                      bod = b.st;
                    }
                  

            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 109:5: -> rule(name=nbody=bod)
            {
                retval.st = templateLib.getInstanceOf("rule",
              new STAttrMap().put("name", n).put("body", bod));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
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
    // src/core/koopa/core/grammars/generator/KGGenerator.g:115:1: returning : ^( RETURNS i= IDENTIFIER ) -> returning(name=((CommonTree) $i).getText());
    public final KGGenerator.returning_return returning() throws RecognitionException {
        KGGenerator.returning_return retval = new KGGenerator.returning_return();
        retval.start = input.LT(1);

        CommonTree i=null;

        try {
            // src/core/koopa/core/grammars/generator/KGGenerator.g:116:3: ( ^( RETURNS i= IDENTIFIER ) -> returning(name=((CommonTree) $i).getText()))
            // src/core/koopa/core/grammars/generator/KGGenerator.g:116:5: ^( RETURNS i= IDENTIFIER )
            {
            match(input,RETURNS,FOLLOW_RETURNS_in_returning477); 

            match(input, Token.DOWN, null); 
            i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_returning481); 

            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 118:5: -> returning(name=((CommonTree) $i).getText())
            {
                retval.st = templateLib.getInstanceOf("returning",
              new STAttrMap().put("name", ((CommonTree) i).getText()));
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
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
    // src/core/koopa/core/grammars/generator/KGGenerator.g:123:1: locals returns [List<Tuple<String, String>> tuples = new LinkedList<Tuple<String, String>>()] : ^( LOCALS (d= declaration )+ ) ;
    public final KGGenerator.locals_return locals() throws RecognitionException {
        KGGenerator.locals_return retval = new KGGenerator.locals_return();
        retval.start = input.LT(1);

        KGGenerator.declaration_return d = null;


        try {
            // src/core/koopa/core/grammars/generator/KGGenerator.g:124:3: ( ^( LOCALS (d= declaration )+ ) )
            // src/core/koopa/core/grammars/generator/KGGenerator.g:124:5: ^( LOCALS (d= declaration )+ )
            {
            match(input,LOCALS,FOLLOW_LOCALS_in_locals530); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/grammars/generator/KGGenerator.g:125:7: (d= declaration )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==DECLARATION) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KGGenerator.g:125:8: d= declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_locals541);
            	    d=declaration();

            	    state._fsp--;

            	     retval.tuples.add((d!=null?d.tuple:null)); 

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


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
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
    // src/core/koopa/core/grammars/generator/KGGenerator.g:131:1: declaration returns [Tuple<String, String> tuple = null] : ^( DECLARATION a= IDENTIFIER b= IDENTIFIER ) ;
    public final KGGenerator.declaration_return declaration() throws RecognitionException {
        KGGenerator.declaration_return retval = new KGGenerator.declaration_return();
        retval.start = input.LT(1);

        CommonTree a=null;
        CommonTree b=null;

        try {
            // src/core/koopa/core/grammars/generator/KGGenerator.g:132:3: ( ^( DECLARATION a= IDENTIFIER b= IDENTIFIER ) )
            // src/core/koopa/core/grammars/generator/KGGenerator.g:132:5: ^( DECLARATION a= IDENTIFIER b= IDENTIFIER )
            {
            match(input,DECLARATION,FOLLOW_DECLARATION_in_declaration584); 

            match(input, Token.DOWN, null); 
            a=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration588); 
            b=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration592); 

            match(input, Token.UP, null); 
             retval.tuple = new Tuple<String, String>(((CommonTree) a).getText(), ((CommonTree) b).getText()); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
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
    // src/core/koopa/core/grammars/generator/KGGenerator.g:136:1: body[ List<String> bindings, List<String> unbindings ] : ( ^( SEQUENCE (b= body[bindings, unbindings] )+ ) -> sequence(step=steps) | ^( ACT n= NATIVE_CODE ) -> apply(bind=bindingsnative_code=nunbind=unbindings) | t= TAG -> tag(text=name) | ANY -> any() | l= LITERAL -> token(text=unquoted) | n= NUMBER -> token(text=n) | i= IDENTIFIER -> {isLowerCase}? call(name=i) -> token(text=i) | d= DOT -> token(text=d) | ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT ) ) -> assign(name=lvalue=body) | ^( STAR b= body[bindings, unbindings] ) -> star(body=b) | ^( PLUS b= body[bindings, unbindings] ) -> plus(body=b) | ^( CHOICE (b= body[bindings, unbindings] )+ ) -> choice(step=steps) | ^( OPTIONAL b= body[bindings, unbindings] ) -> optional(body=b) | ^( SKIP_TO b= body[bindings, unbindings] ) -> skipto(body=b) | ^( PERMUTED (b= body[bindings, unbindings] )+ ) -> permuted(choice=choices) | ^( NOT b= body[bindings, unbindings] ) -> not(body=b) | ^( NOSKIP b= body[bindings, unbindings] ) -> opt(option=optionbody=b));
    public final KGGenerator.body_return body(List<String> bindings, List<String> unbindings) throws RecognitionException {
        KGGenerator.body_return retval = new KGGenerator.body_return();
        retval.start = input.LT(1);

        CommonTree n=null;
        CommonTree t=null;
        CommonTree l=null;
        CommonTree i=null;
        CommonTree d=null;
        KGGenerator.body_return b = null;


        try {
            // src/core/koopa/core/grammars/generator/KGGenerator.g:137:3: ( ^( SEQUENCE (b= body[bindings, unbindings] )+ ) -> sequence(step=steps) | ^( ACT n= NATIVE_CODE ) -> apply(bind=bindingsnative_code=nunbind=unbindings) | t= TAG -> tag(text=name) | ANY -> any() | l= LITERAL -> token(text=unquoted) | n= NUMBER -> token(text=n) | i= IDENTIFIER -> {isLowerCase}? call(name=i) -> token(text=i) | d= DOT -> token(text=d) | ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT ) ) -> assign(name=lvalue=body) | ^( STAR b= body[bindings, unbindings] ) -> star(body=b) | ^( PLUS b= body[bindings, unbindings] ) -> plus(body=b) | ^( CHOICE (b= body[bindings, unbindings] )+ ) -> choice(step=steps) | ^( OPTIONAL b= body[bindings, unbindings] ) -> optional(body=b) | ^( SKIP_TO b= body[bindings, unbindings] ) -> skipto(body=b) | ^( PERMUTED (b= body[bindings, unbindings] )+ ) -> permuted(choice=choices) | ^( NOT b= body[bindings, unbindings] ) -> not(body=b) | ^( NOSKIP b= body[bindings, unbindings] ) -> opt(option=optionbody=b))
            int alt10=17;
            switch ( input.LA(1) ) {
            case SEQUENCE:
                {
                alt10=1;
                }
                break;
            case ACT:
                {
                alt10=2;
                }
                break;
            case TAG:
                {
                alt10=3;
                }
                break;
            case ANY:
                {
                alt10=4;
                }
                break;
            case LITERAL:
                {
                alt10=5;
                }
                break;
            case NUMBER:
                {
                alt10=6;
                }
                break;
            case IDENTIFIER:
                {
                alt10=7;
                }
                break;
            case DOT:
                {
                alt10=8;
                }
                break;
            case ASSIGN:
                {
                alt10=9;
                }
                break;
            case STAR:
                {
                alt10=10;
                }
                break;
            case PLUS:
                {
                alt10=11;
                }
                break;
            case CHOICE:
                {
                alt10=12;
                }
                break;
            case OPTIONAL:
                {
                alt10=13;
                }
                break;
            case SKIP_TO:
                {
                alt10=14;
                }
                break;
            case PERMUTED:
                {
                alt10=15;
                }
                break;
            case NOT:
                {
                alt10=16;
                }
                break;
            case NOSKIP:
                {
                alt10=17;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:137:5: ^( SEQUENCE (b= body[bindings, unbindings] )+ )
                    {
                     List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
                    match(input,SEQUENCE,FOLLOW_SEQUENCE_in_body621); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:139:7: (b= body[bindings, unbindings] )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=SEQUENCE && LA6_0<=ASSIGN)||(LA6_0>=PERMUTED && LA6_0<=DOT)||(LA6_0>=TAG && LA6_0<=PLUS)||LA6_0==SKIP_TO||(LA6_0>=NOT && LA6_0<=NOSKIP)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KGGenerator.g:139:8: b= body[bindings, unbindings]
                    	    {
                    	    pushFollow(FOLLOW_body_in_body632);
                    	    b=body(bindings, unbindings);

                    	    state._fsp--;

                    	     steps.add(b.st); 

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


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 144:5: -> sequence(step=steps)
                    {
                        retval.st = templateLib.getInstanceOf("sequence",
                      new STAttrMap().put("step", steps));
                    }


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:148:5: ^( ACT n= NATIVE_CODE )
                    {
                    match(input,ACT,FOLLOW_ACT_in_body700); 

                    match(input, Token.DOWN, null); 
                    n=(CommonTree)match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_body704); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 150:5: -> apply(bind=bindingsnative_code=nunbind=unbindings)
                    {
                        retval.st = templateLib.getInstanceOf("apply",
                      new STAttrMap().put("bind", bindings).put("native_code", n).put("unbind", unbindings));
                    }


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:156:5: t= TAG
                    {
                    t=(CommonTree)match(input,TAG,FOLLOW_TAG_in_body774); 
                     String name = ((CommonTree) t).getText();
                          name = name.substring(1, name.length()); 
                    	


                    // TEMPLATE REWRITE
                    // 162:5: -> tag(text=name)
                    {
                        retval.st = templateLib.getInstanceOf("tag",
                      new STAttrMap().put("text", name));
                    }


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:166:5: ANY
                    {
                    match(input,ANY,FOLLOW_ANY_in_body813); 


                    // TEMPLATE REWRITE
                    // 168:5: -> any()
                    {
                        retval.st = templateLib.getInstanceOf("any");
                    }


                    }
                    break;
                case 5 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:170:5: l= LITERAL
                    {
                    l=(CommonTree)match(input,LITERAL,FOLLOW_LITERAL_in_body835); 
                     String unquoted = ((CommonTree) l).getText();
                          unquoted = unquoted.substring(1, unquoted.length() - 1); 
                        


                    // TEMPLATE REWRITE
                    // 176:5: -> token(text=unquoted)
                    {
                        retval.st = templateLib.getInstanceOf("token",
                      new STAttrMap().put("text", unquoted));
                    }


                    }
                    break;
                case 6 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:180:5: n= NUMBER
                    {
                    n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body885); 


                    // TEMPLATE REWRITE
                    // 182:5: -> token(text=n)
                    {
                        retval.st = templateLib.getInstanceOf("token",
                      new STAttrMap().put("text", n));
                    }


                    }
                    break;
                case 7 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:186:5: i= IDENTIFIER
                    {
                    i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body924); 
                     String text = ((CommonTree) i).getText();
                     	  boolean isLowerCase = Character.isLowerCase(text.charAt(0));
                        


                    // TEMPLATE REWRITE
                    // 192:5: -> {isLowerCase}? call(name=i)
                    if (isLowerCase) {
                        retval.st = templateLib.getInstanceOf("call",
                      new STAttrMap().put("name", i));
                    }
                    else // 196:5: -> token(text=i)
                    {
                        retval.st = templateLib.getInstanceOf("token",
                      new STAttrMap().put("text", i));
                    }


                    }
                    break;
                case 8 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:200:5: d= DOT
                    {
                    d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body1006); 


                    // TEMPLATE REWRITE
                    // 202:5: -> token(text=d)
                    {
                        retval.st = templateLib.getInstanceOf("token",
                      new STAttrMap().put("text", d));
                    }


                    }
                    break;
                case 9 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:206:5: ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT ) )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_body1046); 

                    match(input, Token.DOWN, null); 
                    l=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body1050); 
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:206:27: (i= IDENTIFIER | n= NUMBER | d= DOT )
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
                            // src/core/koopa/core/grammars/generator/KGGenerator.g:206:28: i= IDENTIFIER
                            {
                            i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body1055); 

                            }
                            break;
                        case 2 :
                            // src/core/koopa/core/grammars/generator/KGGenerator.g:206:43: n= NUMBER
                            {
                            n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body1061); 

                            }
                            break;
                        case 3 :
                            // src/core/koopa/core/grammars/generator/KGGenerator.g:206:54: d= DOT
                            {
                            d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body1067); 

                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                     StringTemplate body = null;
                          if (i != null) {
                            String text = ((CommonTree) i).getText();
                            if (Character.isLowerCase(text.charAt(0))) {
                              body = templateLib.getInstanceOf("call",
                      new STAttrMap().put("name", i));
                            } else {
                              body = templateLib.getInstanceOf("token",
                      new STAttrMap().put("text", i));
                            }
                          
                          } else if (n != null) {
                            body = templateLib.getInstanceOf("token",
                      new STAttrMap().put("text", n));
                          
                          } else {
                            body = templateLib.getInstanceOf("token",
                      new STAttrMap().put("text", "."));
                          }
                        


                    // TEMPLATE REWRITE
                    // 232:5: -> assign(name=lvalue=body)
                    {
                        retval.st = templateLib.getInstanceOf("assign",
                      new STAttrMap().put("name", l).put("value", body));
                    }


                    }
                    break;
                case 10 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:237:5: ^( STAR b= body[bindings, unbindings] )
                    {
                    match(input,STAR,FOLLOW_STAR_in_body1128); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1132);
                    b=body(bindings, unbindings);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 239:5: -> star(body=b)
                    {
                        retval.st = templateLib.getInstanceOf("star",
                      new STAttrMap().put("body", b));
                    }


                    }
                    break;
                case 11 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:243:5: ^( PLUS b= body[bindings, unbindings] )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_body1174); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1178);
                    b=body(bindings, unbindings);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 245:5: -> plus(body=b)
                    {
                        retval.st = templateLib.getInstanceOf("plus",
                      new STAttrMap().put("body", b));
                    }


                    }
                    break;
                case 12 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:249:5: ^( CHOICE (b= body[bindings, unbindings] )+ )
                    {
                     List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
                    match(input,CHOICE,FOLLOW_CHOICE_in_body1226); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:251:7: (b= body[bindings, unbindings] )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>=SEQUENCE && LA8_0<=ASSIGN)||(LA8_0>=PERMUTED && LA8_0<=DOT)||(LA8_0>=TAG && LA8_0<=PLUS)||LA8_0==SKIP_TO||(LA8_0>=NOT && LA8_0<=NOSKIP)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KGGenerator.g:251:8: b= body[bindings, unbindings]
                    	    {
                    	    pushFollow(FOLLOW_body_in_body1237);
                    	    b=body(bindings, unbindings);

                    	    state._fsp--;

                    	     steps.add(b.st); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 256:5: -> choice(step=steps)
                    {
                        retval.st = templateLib.getInstanceOf("choice",
                      new STAttrMap().put("step", steps));
                    }


                    }
                    break;
                case 13 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:260:5: ^( OPTIONAL b= body[bindings, unbindings] )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_body1305); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1309);
                    b=body(bindings, unbindings);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 262:5: -> optional(body=b)
                    {
                        retval.st = templateLib.getInstanceOf("optional",
                      new STAttrMap().put("body", b));
                    }


                    }
                    break;
                case 14 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:266:5: ^( SKIP_TO b= body[bindings, unbindings] )
                    {
                    match(input,SKIP_TO,FOLLOW_SKIP_TO_in_body1351); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1355);
                    b=body(bindings, unbindings);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 268:5: -> skipto(body=b)
                    {
                        retval.st = templateLib.getInstanceOf("skipto",
                      new STAttrMap().put("body", b));
                    }


                    }
                    break;
                case 15 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:272:5: ^( PERMUTED (b= body[bindings, unbindings] )+ )
                    {
                     List<StringTemplate> choices = new LinkedList<StringTemplate>(); 
                    match(input,PERMUTED,FOLLOW_PERMUTED_in_body1401); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:274:7: (b= body[bindings, unbindings] )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=SEQUENCE && LA9_0<=ASSIGN)||(LA9_0>=PERMUTED && LA9_0<=DOT)||(LA9_0>=TAG && LA9_0<=PLUS)||LA9_0==SKIP_TO||(LA9_0>=NOT && LA9_0<=NOSKIP)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KGGenerator.g:274:8: b= body[bindings, unbindings]
                    	    {
                    	    pushFollow(FOLLOW_body_in_body1412);
                    	    b=body(bindings, unbindings);

                    	    state._fsp--;

                    	     choices.add(b.st); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 279:5: -> permuted(choice=choices)
                    {
                        retval.st = templateLib.getInstanceOf("permuted",
                      new STAttrMap().put("choice", choices));
                    }


                    }
                    break;
                case 16 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:283:5: ^( NOT b= body[bindings, unbindings] )
                    {
                    match(input,NOT,FOLLOW_NOT_in_body1474); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1478);
                    b=body(bindings, unbindings);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 285:5: -> not(body=b)
                    {
                        retval.st = templateLib.getInstanceOf("not",
                      new STAttrMap().put("body", b));
                    }


                    }
                    break;
                case 17 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:289:5: ^( NOSKIP b= body[bindings, unbindings] )
                    {
                    match(input,NOSKIP,FOLLOW_NOSKIP_in_body1518); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1522);
                    b=body(bindings, unbindings);

                    state._fsp--;


                    match(input, Token.UP, null); 
                     String option = "NOSKIP"; 


                    // TEMPLATE REWRITE
                    // 292:5: -> opt(option=optionbody=b)
                    {
                        retval.st = templateLib.getInstanceOf("opt",
                      new STAttrMap().put("option", option).put("body", b));
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
        }
        return retval;
    }
    // $ANTLR end "body"

    // Delegated rules


 

    public static final BitSet FOLLOW_GRAMMAR_in_koopa68 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_meta_in_koopa76 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_rule_in_koopa88 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_META_in_meta222 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_named_in_meta226 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_extending_in_meta231 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAMED_in_named263 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_named267 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXTENDING_in_extending295 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_extending299 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_in_rule329 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule333 = new BitSet(new long[]{0x00000034FC1EFC00L});
    public static final BitSet FOLLOW_locals_in_rule345 = new BitSet(new long[]{0x00000034FC1EFC00L});
    public static final BitSet FOLLOW_returning_in_rule376 = new BitSet(new long[]{0x00000034FC1EFC00L});
    public static final BitSet FOLLOW_body_in_rule389 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURNS_in_returning477 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_returning481 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOCALS_in_locals530 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaration_in_locals541 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_DECLARATION_in_declaration584 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration588 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration592 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEQUENCE_in_body621 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body632 = new BitSet(new long[]{0x00000034FC1EFC08L});
    public static final BitSet FOLLOW_ACT_in_body700 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NATIVE_CODE_in_body704 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TAG_in_body774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANY_in_body813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_body835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_body885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_body1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_body1046 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body1050 = new BitSet(new long[]{0x0000000020180000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body1055 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NUMBER_in_body1061 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_body1067 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_body1128 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1132 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_body1174 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1178 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHOICE_in_body1226 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1237 = new BitSet(new long[]{0x00000034FC1EFC08L});
    public static final BitSet FOLLOW_OPTIONAL_in_body1305 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1309 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SKIP_TO_in_body1351 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1355 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERMUTED_in_body1401 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1412 = new BitSet(new long[]{0x00000034FC1EFC08L});
    public static final BitSet FOLLOW_NOT_in_body1474 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1478 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOSKIP_in_body1518 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1522 = new BitSet(new long[]{0x0000000000000008L});

}