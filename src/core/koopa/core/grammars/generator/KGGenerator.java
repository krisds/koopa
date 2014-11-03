// $ANTLR 3.1.1 src/core/koopa/core/grammars/generator/KGGenerator.g 2014-11-03 08:19:39

  package koopa.core.grammars.generator;
  
  import java.util.List;
  import java.util.LinkedList;
  import java.util.Date;
  import java.util.Set;
  import java.util.HashSet;

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "GRAMMAR", "RULE", "BODY", "RETURNS", "SEQUENCE", "CHOICE", "OPTIONAL", "ACT", "ASSIGN", "DECLARATION", "LOCALS", "PERMUTED", "IDENTIFIER", "OPEN_PAREN", "CLOSE_PAREN", "EQUALS", "COMMA", "NATIVE_CODE", "TAG", "ANY", "LITERAL", "NUMBER", "DOT", "STAR", "PLUS", "OPEN_BRACKET", "CLOSE_BRACKET", "SKIP_TO", "BANG", "NOT", "NOSKIP", "PIPE", "COMMENT", "NEWLINE", "LETTER", "DIGIT", "WHITESPACE", "'def'", "'returns'", "'end'"
    };
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int SKIP_TO=31;
    public static final int ACT=11;
    public static final int LOCALS=14;
    public static final int T__41=41;
    public static final int STAR=27;
    public static final int RULE=5;
    public static final int LETTER=38;
    public static final int NUMBER=25;
    public static final int OPEN_PAREN=17;
    public static final int WHITESPACE=40;
    public static final int LITERAL=24;
    public static final int BANG=32;
    public static final int EQUALS=19;
    public static final int NOT=33;
    public static final int NOSKIP=34;
    public static final int EOF=-1;
    public static final int DECLARATION=13;
    public static final int TAG=22;
    public static final int OPTIONAL=10;
    public static final int SEQUENCE=8;
    public static final int OPEN_BRACKET=29;
    public static final int ANY=23;
    public static final int NATIVE_CODE=21;
    public static final int NEWLINE=37;
    public static final int COMMA=20;
    public static final int IDENTIFIER=16;
    public static final int ASSIGN=12;
    public static final int PLUS=28;
    public static final int PIPE=35;
    public static final int BODY=6;
    public static final int CLOSE_PAREN=18;
    public static final int DIGIT=39;
    public static final int COMMENT=36;
    public static final int DOT=26;
    public static final int PERMUTED=15;
    public static final int GRAMMAR=4;
    public static final int CHOICE=9;
    public static final int RETURNS=7;
    public static final int CLOSE_BRACKET=30;

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
    // src/core/koopa/core/grammars/generator/KGGenerator.g:25:1: koopa[String name, String pack, String pack, String imports, String supportCode] : ^( GRAMMAR (r+= rule )* ) -> koopa(name=namedate=new Date()package=packimports=importsrule=$rsupport_code=supportCode);
    public final KGGenerator.koopa_return koopa(String name, String pack, String imports, String supportCode) throws RecognitionException {
        KGGenerator.koopa_return retval = new KGGenerator.koopa_return();
        retval.start = input.LT(1);

        List list_r=null;
        RuleReturnScope r = null;
        try {
            // src/core/koopa/core/grammars/generator/KGGenerator.g:26:3: ( ^( GRAMMAR (r+= rule )* ) -> koopa(name=namedate=new Date()package=packimports=importsrule=$rsupport_code=supportCode))
            // src/core/koopa/core/grammars/generator/KGGenerator.g:26:5: ^( GRAMMAR (r+= rule )* )
            {
            match(input,GRAMMAR,FOLLOW_GRAMMAR_in_koopa68); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/core/koopa/core/grammars/generator/KGGenerator.g:27:7: (r+= rule )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // src/core/koopa/core/grammars/generator/KGGenerator.g:27:8: r+= rule
                	    {
                	    pushFollow(FOLLOW_rule_in_koopa79);
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
            }


            // TEMPLATE REWRITE
            // 30:5: -> koopa(name=namedate=new Date()package=packimports=importsrule=$rsupport_code=supportCode)
            {
                retval.st = templateLib.getInstanceOf("koopa",
              new STAttrMap().put("name", name).put("date", new Date()).put("package", pack).put("imports", imports).put("rule", list_r).put("support_code", supportCode));
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

    public static class rule_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rule"
    // src/core/koopa/core/grammars/generator/KGGenerator.g:40:1: rule : ^( RULE n= IDENTIFIER (l= locals )? (r= returning )? b= body[bindings, unbindings] ) -> rule(name=nbody=bod);
    public final KGGenerator.rule_return rule() throws RecognitionException {
        KGGenerator.rule_return retval = new KGGenerator.rule_return();
        retval.start = input.LT(1);

        CommonTree n=null;
        KGGenerator.locals_return l = null;

        KGGenerator.returning_return r = null;

        KGGenerator.body_return b = null;


        try {
            // src/core/koopa/core/grammars/generator/KGGenerator.g:41:3: ( ^( RULE n= IDENTIFIER (l= locals )? (r= returning )? b= body[bindings, unbindings] ) -> rule(name=nbody=bod))
            // src/core/koopa/core/grammars/generator/KGGenerator.g:41:5: ^( RULE n= IDENTIFIER (l= locals )? (r= returning )? b= body[bindings, unbindings] )
            {
             List<String> bindings = null;
                  List<String> unbindings = null;
                  StringTemplate bod = null;
                
            match(input,RULE,FOLLOW_RULE_in_rule204); 

            match(input, Token.DOWN, null); 
            n=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule208); 
            // src/core/koopa/core/grammars/generator/KGGenerator.g:46:7: (l= locals )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==LOCALS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:46:8: l= locals
                    {
                    pushFollow(FOLLOW_locals_in_rule220);
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

            // src/core/koopa/core/grammars/generator/KGGenerator.g:66:7: (r= returning )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RETURNS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:66:8: r= returning
                    {
                    pushFollow(FOLLOW_returning_in_rule251);
                    r=returning();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_body_in_rule264);
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
            // 84:5: -> rule(name=nbody=bod)
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
    // src/core/koopa/core/grammars/generator/KGGenerator.g:90:1: returning : ^( RETURNS i= IDENTIFIER ) -> returning(name=((CommonTree) $i).getText());
    public final KGGenerator.returning_return returning() throws RecognitionException {
        KGGenerator.returning_return retval = new KGGenerator.returning_return();
        retval.start = input.LT(1);

        CommonTree i=null;

        try {
            // src/core/koopa/core/grammars/generator/KGGenerator.g:91:3: ( ^( RETURNS i= IDENTIFIER ) -> returning(name=((CommonTree) $i).getText()))
            // src/core/koopa/core/grammars/generator/KGGenerator.g:91:5: ^( RETURNS i= IDENTIFIER )
            {
            match(input,RETURNS,FOLLOW_RETURNS_in_returning352); 

            match(input, Token.DOWN, null); 
            i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_returning356); 

            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 93:5: -> returning(name=((CommonTree) $i).getText())
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
    // src/core/koopa/core/grammars/generator/KGGenerator.g:98:1: locals returns [List<Tuple<String, String>> tuples = new LinkedList<Tuple<String, String>>()] : ^( LOCALS (d= declaration )+ ) ;
    public final KGGenerator.locals_return locals() throws RecognitionException {
        KGGenerator.locals_return retval = new KGGenerator.locals_return();
        retval.start = input.LT(1);

        KGGenerator.declaration_return d = null;


        try {
            // src/core/koopa/core/grammars/generator/KGGenerator.g:99:3: ( ^( LOCALS (d= declaration )+ ) )
            // src/core/koopa/core/grammars/generator/KGGenerator.g:99:5: ^( LOCALS (d= declaration )+ )
            {
            match(input,LOCALS,FOLLOW_LOCALS_in_locals405); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/grammars/generator/KGGenerator.g:100:7: (d= declaration )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==DECLARATION) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/core/koopa/core/grammars/generator/KGGenerator.g:100:8: d= declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_locals416);
            	    d=declaration();

            	    state._fsp--;

            	     retval.tuples.add((d!=null?d.tuple:null)); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
    // src/core/koopa/core/grammars/generator/KGGenerator.g:106:1: declaration returns [Tuple<String, String> tuple = null] : ^( DECLARATION a= IDENTIFIER b= IDENTIFIER ) ;
    public final KGGenerator.declaration_return declaration() throws RecognitionException {
        KGGenerator.declaration_return retval = new KGGenerator.declaration_return();
        retval.start = input.LT(1);

        CommonTree a=null;
        CommonTree b=null;

        try {
            // src/core/koopa/core/grammars/generator/KGGenerator.g:107:3: ( ^( DECLARATION a= IDENTIFIER b= IDENTIFIER ) )
            // src/core/koopa/core/grammars/generator/KGGenerator.g:107:5: ^( DECLARATION a= IDENTIFIER b= IDENTIFIER )
            {
            match(input,DECLARATION,FOLLOW_DECLARATION_in_declaration459); 

            match(input, Token.DOWN, null); 
            a=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration463); 
            b=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration467); 

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
    // src/core/koopa/core/grammars/generator/KGGenerator.g:111:1: body[ List<String> bindings, List<String> unbindings ] : ( ^( SEQUENCE (b= body[bindings, unbindings] )+ ) -> sequence(step=steps) | ^( ACT n= NATIVE_CODE ) -> apply(bind=bindingsnative_code=nunbind=unbindings) | t= TAG -> tag(text=name) | ANY -> any() | l= LITERAL -> token(text=unquoted) | n= NUMBER -> token(text=n) | i= IDENTIFIER -> {isLowerCase}? call(name=i) -> token(text=i) | d= DOT -> token(text=d) | ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT ) ) -> assign(name=lvalue=body) | ^( STAR b= body[bindings, unbindings] ) -> star(body=b) | ^( PLUS b= body[bindings, unbindings] ) -> plus(body=b) | ^( CHOICE (b= body[bindings, unbindings] )+ ) -> choice(step=steps) | ^( OPTIONAL b= body[bindings, unbindings] ) -> optional(body=b) | ^( SKIP_TO b= body[bindings, unbindings] ) -> skipto(body=b) | ^( PERMUTED (b= body[bindings, unbindings] )+ ) -> permuted(choice=choices) | ^( NOT b= body[bindings, unbindings] ) -> not(body=b) | ^( NOSKIP b= body[bindings, unbindings] ) -> opt(option=optionbody=b));
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
            // src/core/koopa/core/grammars/generator/KGGenerator.g:112:3: ( ^( SEQUENCE (b= body[bindings, unbindings] )+ ) -> sequence(step=steps) | ^( ACT n= NATIVE_CODE ) -> apply(bind=bindingsnative_code=nunbind=unbindings) | t= TAG -> tag(text=name) | ANY -> any() | l= LITERAL -> token(text=unquoted) | n= NUMBER -> token(text=n) | i= IDENTIFIER -> {isLowerCase}? call(name=i) -> token(text=i) | d= DOT -> token(text=d) | ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT ) ) -> assign(name=lvalue=body) | ^( STAR b= body[bindings, unbindings] ) -> star(body=b) | ^( PLUS b= body[bindings, unbindings] ) -> plus(body=b) | ^( CHOICE (b= body[bindings, unbindings] )+ ) -> choice(step=steps) | ^( OPTIONAL b= body[bindings, unbindings] ) -> optional(body=b) | ^( SKIP_TO b= body[bindings, unbindings] ) -> skipto(body=b) | ^( PERMUTED (b= body[bindings, unbindings] )+ ) -> permuted(choice=choices) | ^( NOT b= body[bindings, unbindings] ) -> not(body=b) | ^( NOSKIP b= body[bindings, unbindings] ) -> opt(option=optionbody=b))
            int alt9=17;
            switch ( input.LA(1) ) {
            case SEQUENCE:
                {
                alt9=1;
                }
                break;
            case ACT:
                {
                alt9=2;
                }
                break;
            case TAG:
                {
                alt9=3;
                }
                break;
            case ANY:
                {
                alt9=4;
                }
                break;
            case LITERAL:
                {
                alt9=5;
                }
                break;
            case NUMBER:
                {
                alt9=6;
                }
                break;
            case IDENTIFIER:
                {
                alt9=7;
                }
                break;
            case DOT:
                {
                alt9=8;
                }
                break;
            case ASSIGN:
                {
                alt9=9;
                }
                break;
            case STAR:
                {
                alt9=10;
                }
                break;
            case PLUS:
                {
                alt9=11;
                }
                break;
            case CHOICE:
                {
                alt9=12;
                }
                break;
            case OPTIONAL:
                {
                alt9=13;
                }
                break;
            case SKIP_TO:
                {
                alt9=14;
                }
                break;
            case PERMUTED:
                {
                alt9=15;
                }
                break;
            case NOT:
                {
                alt9=16;
                }
                break;
            case NOSKIP:
                {
                alt9=17;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:112:5: ^( SEQUENCE (b= body[bindings, unbindings] )+ )
                    {
                     List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
                    match(input,SEQUENCE,FOLLOW_SEQUENCE_in_body496); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:114:7: (b= body[bindings, unbindings] )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=SEQUENCE && LA5_0<=ASSIGN)||(LA5_0>=PERMUTED && LA5_0<=IDENTIFIER)||(LA5_0>=TAG && LA5_0<=PLUS)||LA5_0==SKIP_TO||(LA5_0>=NOT && LA5_0<=NOSKIP)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KGGenerator.g:114:8: b= body[bindings, unbindings]
                    	    {
                    	    pushFollow(FOLLOW_body_in_body507);
                    	    b=body(bindings, unbindings);

                    	    state._fsp--;

                    	     steps.add(b.st); 

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


                    // TEMPLATE REWRITE
                    // 119:5: -> sequence(step=steps)
                    {
                        retval.st = templateLib.getInstanceOf("sequence",
                      new STAttrMap().put("step", steps));
                    }


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:123:5: ^( ACT n= NATIVE_CODE )
                    {
                    match(input,ACT,FOLLOW_ACT_in_body575); 

                    match(input, Token.DOWN, null); 
                    n=(CommonTree)match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_body579); 

                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 125:5: -> apply(bind=bindingsnative_code=nunbind=unbindings)
                    {
                        retval.st = templateLib.getInstanceOf("apply",
                      new STAttrMap().put("bind", bindings).put("native_code", n).put("unbind", unbindings));
                    }


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:131:5: t= TAG
                    {
                    t=(CommonTree)match(input,TAG,FOLLOW_TAG_in_body649); 
                     String name = ((CommonTree) t).getText();
                          name = name.substring(1, name.length()); 
                    	


                    // TEMPLATE REWRITE
                    // 137:5: -> tag(text=name)
                    {
                        retval.st = templateLib.getInstanceOf("tag",
                      new STAttrMap().put("text", name));
                    }


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:141:5: ANY
                    {
                    match(input,ANY,FOLLOW_ANY_in_body688); 


                    // TEMPLATE REWRITE
                    // 143:5: -> any()
                    {
                        retval.st = templateLib.getInstanceOf("any");
                    }


                    }
                    break;
                case 5 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:145:5: l= LITERAL
                    {
                    l=(CommonTree)match(input,LITERAL,FOLLOW_LITERAL_in_body710); 
                     String unquoted = ((CommonTree) l).getText();
                          unquoted = unquoted.substring(1, unquoted.length() - 1); 
                        


                    // TEMPLATE REWRITE
                    // 151:5: -> token(text=unquoted)
                    {
                        retval.st = templateLib.getInstanceOf("token",
                      new STAttrMap().put("text", unquoted));
                    }


                    }
                    break;
                case 6 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:155:5: n= NUMBER
                    {
                    n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body760); 


                    // TEMPLATE REWRITE
                    // 157:5: -> token(text=n)
                    {
                        retval.st = templateLib.getInstanceOf("token",
                      new STAttrMap().put("text", n));
                    }


                    }
                    break;
                case 7 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:161:5: i= IDENTIFIER
                    {
                    i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body799); 
                     String text = ((CommonTree) i).getText();
                     	  boolean isLowerCase = Character.isLowerCase(text.charAt(0));
                        


                    // TEMPLATE REWRITE
                    // 167:5: -> {isLowerCase}? call(name=i)
                    if (isLowerCase) {
                        retval.st = templateLib.getInstanceOf("call",
                      new STAttrMap().put("name", i));
                    }
                    else // 171:5: -> token(text=i)
                    {
                        retval.st = templateLib.getInstanceOf("token",
                      new STAttrMap().put("text", i));
                    }


                    }
                    break;
                case 8 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:175:5: d= DOT
                    {
                    d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body881); 


                    // TEMPLATE REWRITE
                    // 177:5: -> token(text=d)
                    {
                        retval.st = templateLib.getInstanceOf("token",
                      new STAttrMap().put("text", d));
                    }


                    }
                    break;
                case 9 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:181:5: ^( ASSIGN l= IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT ) )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_body921); 

                    match(input, Token.DOWN, null); 
                    l=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body925); 
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:181:27: (i= IDENTIFIER | n= NUMBER | d= DOT )
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
                            // src/core/koopa/core/grammars/generator/KGGenerator.g:181:28: i= IDENTIFIER
                            {
                            i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body930); 

                            }
                            break;
                        case 2 :
                            // src/core/koopa/core/grammars/generator/KGGenerator.g:181:43: n= NUMBER
                            {
                            n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body936); 

                            }
                            break;
                        case 3 :
                            // src/core/koopa/core/grammars/generator/KGGenerator.g:181:54: d= DOT
                            {
                            d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body942); 

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
                    // 207:5: -> assign(name=lvalue=body)
                    {
                        retval.st = templateLib.getInstanceOf("assign",
                      new STAttrMap().put("name", l).put("value", body));
                    }


                    }
                    break;
                case 10 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:212:5: ^( STAR b= body[bindings, unbindings] )
                    {
                    match(input,STAR,FOLLOW_STAR_in_body1003); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1007);
                    b=body(bindings, unbindings);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 214:5: -> star(body=b)
                    {
                        retval.st = templateLib.getInstanceOf("star",
                      new STAttrMap().put("body", b));
                    }


                    }
                    break;
                case 11 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:218:5: ^( PLUS b= body[bindings, unbindings] )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_body1049); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1053);
                    b=body(bindings, unbindings);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 220:5: -> plus(body=b)
                    {
                        retval.st = templateLib.getInstanceOf("plus",
                      new STAttrMap().put("body", b));
                    }


                    }
                    break;
                case 12 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:224:5: ^( CHOICE (b= body[bindings, unbindings] )+ )
                    {
                     List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
                    match(input,CHOICE,FOLLOW_CHOICE_in_body1101); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:226:7: (b= body[bindings, unbindings] )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>=SEQUENCE && LA7_0<=ASSIGN)||(LA7_0>=PERMUTED && LA7_0<=IDENTIFIER)||(LA7_0>=TAG && LA7_0<=PLUS)||LA7_0==SKIP_TO||(LA7_0>=NOT && LA7_0<=NOSKIP)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KGGenerator.g:226:8: b= body[bindings, unbindings]
                    	    {
                    	    pushFollow(FOLLOW_body_in_body1112);
                    	    b=body(bindings, unbindings);

                    	    state._fsp--;

                    	     steps.add(b.st); 

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


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 231:5: -> choice(step=steps)
                    {
                        retval.st = templateLib.getInstanceOf("choice",
                      new STAttrMap().put("step", steps));
                    }


                    }
                    break;
                case 13 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:235:5: ^( OPTIONAL b= body[bindings, unbindings] )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_body1180); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1184);
                    b=body(bindings, unbindings);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 237:5: -> optional(body=b)
                    {
                        retval.st = templateLib.getInstanceOf("optional",
                      new STAttrMap().put("body", b));
                    }


                    }
                    break;
                case 14 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:241:5: ^( SKIP_TO b= body[bindings, unbindings] )
                    {
                    match(input,SKIP_TO,FOLLOW_SKIP_TO_in_body1226); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1230);
                    b=body(bindings, unbindings);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 243:5: -> skipto(body=b)
                    {
                        retval.st = templateLib.getInstanceOf("skipto",
                      new STAttrMap().put("body", b));
                    }


                    }
                    break;
                case 15 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:247:5: ^( PERMUTED (b= body[bindings, unbindings] )+ )
                    {
                     List<StringTemplate> choices = new LinkedList<StringTemplate>(); 
                    match(input,PERMUTED,FOLLOW_PERMUTED_in_body1276); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:249:7: (b= body[bindings, unbindings] )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>=SEQUENCE && LA8_0<=ASSIGN)||(LA8_0>=PERMUTED && LA8_0<=IDENTIFIER)||(LA8_0>=TAG && LA8_0<=PLUS)||LA8_0==SKIP_TO||(LA8_0>=NOT && LA8_0<=NOSKIP)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // src/core/koopa/core/grammars/generator/KGGenerator.g:249:8: b= body[bindings, unbindings]
                    	    {
                    	    pushFollow(FOLLOW_body_in_body1287);
                    	    b=body(bindings, unbindings);

                    	    state._fsp--;

                    	     choices.add(b.st); 

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
                    // 254:5: -> permuted(choice=choices)
                    {
                        retval.st = templateLib.getInstanceOf("permuted",
                      new STAttrMap().put("choice", choices));
                    }


                    }
                    break;
                case 16 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:258:5: ^( NOT b= body[bindings, unbindings] )
                    {
                    match(input,NOT,FOLLOW_NOT_in_body1349); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1353);
                    b=body(bindings, unbindings);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 260:5: -> not(body=b)
                    {
                        retval.st = templateLib.getInstanceOf("not",
                      new STAttrMap().put("body", b));
                    }


                    }
                    break;
                case 17 :
                    // src/core/koopa/core/grammars/generator/KGGenerator.g:264:5: ^( NOSKIP b= body[bindings, unbindings] )
                    {
                    match(input,NOSKIP,FOLLOW_NOSKIP_in_body1393); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1397);
                    b=body(bindings, unbindings);

                    state._fsp--;


                    match(input, Token.UP, null); 
                     String option = "NOSKIP"; 


                    // TEMPLATE REWRITE
                    // 267:5: -> opt(option=optionbody=b)
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
    public static final BitSet FOLLOW_rule_in_koopa79 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_RULE_in_rule204 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule208 = new BitSet(new long[]{0x000000069FC1DF80L});
    public static final BitSet FOLLOW_locals_in_rule220 = new BitSet(new long[]{0x000000069FC1DF80L});
    public static final BitSet FOLLOW_returning_in_rule251 = new BitSet(new long[]{0x000000069FC1DF80L});
    public static final BitSet FOLLOW_body_in_rule264 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURNS_in_returning352 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_returning356 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOCALS_in_locals405 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaration_in_locals416 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_DECLARATION_in_declaration459 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration463 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration467 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEQUENCE_in_body496 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body507 = new BitSet(new long[]{0x000000069FC1DF88L});
    public static final BitSet FOLLOW_ACT_in_body575 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NATIVE_CODE_in_body579 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TAG_in_body649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANY_in_body688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_body710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_body760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_body881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_body921 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body925 = new BitSet(new long[]{0x0000000006010000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body930 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NUMBER_in_body936 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_body942 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_body1003 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1007 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_body1049 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1053 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHOICE_in_body1101 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1112 = new BitSet(new long[]{0x000000069FC1DF88L});
    public static final BitSet FOLLOW_OPTIONAL_in_body1180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1184 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SKIP_TO_in_body1226 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1230 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERMUTED_in_body1276 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1287 = new BitSet(new long[]{0x000000069FC1DF88L});
    public static final BitSet FOLLOW_NOT_in_body1349 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1353 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOSKIP_in_body1393 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1397 = new BitSet(new long[]{0x0000000000000008L});

}