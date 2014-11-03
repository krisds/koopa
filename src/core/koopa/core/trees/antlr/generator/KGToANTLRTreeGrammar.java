// $ANTLR 3.1.1 src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g 2014-11-03 08:19:45

  package koopa.core.trees.antlr.generator;
  
  import java.util.Collections;
  import java.util.Date;
  import java.util.List;
  import java.util.LinkedList;
  import java.util.Set;
  import java.util.HashSet;

  import koopa.core.trees.antlr.ANTLRNaming;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
public class KGToANTLRTreeGrammar extends TreeParser {
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


        public KGToANTLRTreeGrammar(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public KGToANTLRTreeGrammar(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected StringTemplateGroup templateLib =
      new StringTemplateGroup("KGToANTLRTreeGrammarTemplates", AngleBracketTemplateLexer.class);

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

    public String[] getTokenNames() { return KGToANTLRTreeGrammar.tokenNames; }
    public String getGrammarFileName() { return "src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g"; }


      private Set<String> literals = new HashSet<String>();
      
      private void literal(String literal) {
        literals.add(literal);
      }
      
      private List<String> antlrifiedLiterals() {
        List<String> list = new LinkedList<String>();

        for (String lit : literals) {
          list.add(ANTLRNaming.forLiteral(lit));
        }
        
        Collections.sort(list);
        
        return list;
      }


    public static class koopa_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "koopa"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:43:1: koopa[String name, String pack, String usercode] : ^( GRAMMAR (r+= rule )* ) -> treegrammar(name=namedate=new Date()pack=packrule=$rliteral=antlrifiedLiterals()usercode=usercode);
    public final KGToANTLRTreeGrammar.koopa_return koopa(String name, String pack, String usercode) throws RecognitionException {
        KGToANTLRTreeGrammar.koopa_return retval = new KGToANTLRTreeGrammar.koopa_return();
        retval.start = input.LT(1);

        List list_r=null;
        RuleReturnScope r = null;
        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:44:3: ( ^( GRAMMAR (r+= rule )* ) -> treegrammar(name=namedate=new Date()pack=packrule=$rliteral=antlrifiedLiterals()usercode=usercode))
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:44:5: ^( GRAMMAR (r+= rule )* )
            {
            match(input,GRAMMAR,FOLLOW_GRAMMAR_in_koopa68); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:45:7: (r+= rule )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:45:8: r+= rule
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
            // 48:5: -> treegrammar(name=namedate=new Date()pack=packrule=$rliteral=antlrifiedLiterals()usercode=usercode)
            {
                retval.st = templateLib.getInstanceOf("treegrammar",
              new STAttrMap().put("name", name).put("date", new Date()).put("pack", pack).put("rule", list_r).put("literal", antlrifiedLiterals()).put("usercode", usercode));
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
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:58:1: rule : ^( RULE n= IDENTIFIER ( locals )? ( returning )? b= body ) -> {$body.len > 0}? rule(name=$ntag=ANTLRNaming.forNode($n.toString())body=b) -> rule(name=$ntag=ANTLRNaming.forNode($n.toString()));
    public final KGToANTLRTreeGrammar.rule_return rule() throws RecognitionException {
        KGToANTLRTreeGrammar.rule_return retval = new KGToANTLRTreeGrammar.rule_return();
        retval.start = input.LT(1);

        CommonTree n=null;
        KGToANTLRTreeGrammar.body_return b = null;


        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:59:3: ( ^( RULE n= IDENTIFIER ( locals )? ( returning )? b= body ) -> {$body.len > 0}? rule(name=$ntag=ANTLRNaming.forNode($n.toString())body=b) -> rule(name=$ntag=ANTLRNaming.forNode($n.toString())))
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:59:5: ^( RULE n= IDENTIFIER ( locals )? ( returning )? b= body )
            {
            match(input,RULE,FOLLOW_RULE_in_rule184); 

            match(input, Token.DOWN, null); 
            n=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule188); 
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:60:7: ( locals )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==LOCALS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:60:7: locals
                    {
                    pushFollow(FOLLOW_locals_in_rule197);
                    locals();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:61:7: ( returning )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RETURNS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:61:7: returning
                    {
                    pushFollow(FOLLOW_returning_in_rule206);
                    returning();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_body_in_rule217);
            b=body();

            state._fsp--;


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 65:5: -> {$body.len > 0}? rule(name=$ntag=ANTLRNaming.forNode($n.toString())body=b)
            if ((b!=null?b.len:0) > 0) {
                retval.st = templateLib.getInstanceOf("rule",
              new STAttrMap().put("name", n).put("tag", ANTLRNaming.forNode(n.toString())).put("body", b));
            }
            else // 71:5: -> rule(name=$ntag=ANTLRNaming.forNode($n.toString()))
            {
                retval.st = templateLib.getInstanceOf("rule",
              new STAttrMap().put("name", n).put("tag", ANTLRNaming.forNode(n.toString())));
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
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:77:1: returning : ^( RETURNS IDENTIFIER ) ;
    public final KGToANTLRTreeGrammar.returning_return returning() throws RecognitionException {
        KGToANTLRTreeGrammar.returning_return retval = new KGToANTLRTreeGrammar.returning_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:78:3: ( ^( RETURNS IDENTIFIER ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:78:5: ^( RETURNS IDENTIFIER )
            {
            match(input,RETURNS,FOLLOW_RETURNS_in_returning332); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_returning334); 

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
    // $ANTLR end "returning"

    public static class locals_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "locals"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:81:1: locals : ^( LOCALS ( declaration )+ ) ;
    public final KGToANTLRTreeGrammar.locals_return locals() throws RecognitionException {
        KGToANTLRTreeGrammar.locals_return retval = new KGToANTLRTreeGrammar.locals_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:82:3: ( ^( LOCALS ( declaration )+ ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:82:5: ^( LOCALS ( declaration )+ )
            {
            match(input,LOCALS,FOLLOW_LOCALS_in_locals351); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:83:7: ( declaration )+
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
            	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:83:7: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_locals359);
            	    declaration();

            	    state._fsp--;


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
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "declaration"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:87:1: declaration : ^( DECLARATION IDENTIFIER IDENTIFIER ) ;
    public final KGToANTLRTreeGrammar.declaration_return declaration() throws RecognitionException {
        KGToANTLRTreeGrammar.declaration_return retval = new KGToANTLRTreeGrammar.declaration_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:88:3: ( ^( DECLARATION IDENTIFIER IDENTIFIER ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:88:5: ^( DECLARATION IDENTIFIER IDENTIFIER )
            {
            match(input,DECLARATION,FOLLOW_DECLARATION_in_declaration380); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration382); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration384); 

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
    // $ANTLR end "declaration"

    public static class body_return extends TreeRuleReturnScope {
        public int len;
        public boolean optional;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "body"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:91:1: body returns [ int len, boolean optional ] : ( ^( SEQUENCE (x= inner_body )+ ) -> {$body.len == 1}? {steps.get(0)} -> {$body.len > 1}? sequence(step=steps) -> {%{\"::seq::\"}} | ^( ACT NATIVE_CODE ) -> {%{\"::act::\"}} | ANY -> {%{\"::any::\"}} | TAG -> {%{\"::tag::\"}} | i= IDENTIFIER -> {isLiteral}? {%{ANTLRNaming.forLiteral(text)}} -> {%{text}} | l= LITERAL -> {%{ANTLRNaming.forLiteral(text)}} | n= NUMBER -> {%{ANTLRNaming.forLiteral(text)}} | DOT -> {%{\"'.'\"}} | ^( ASSIGN IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT ) ) -> {i != null && isLiteral}? {%{ANTLRNaming.forLiteral(text)}} -> {i != null}? {%{text}} -> {%{ANTLRNaming.forLiteral(text)}} | ^( STAR b= inner_body ) -> {$body.len > 0}? star(body=b) -> {%{\"::star::\"}} | ^( PLUS b= inner_body ) -> {$body.len > 0}? plus(body=b) -> {%{\"::plus::\"}} | ^( CHOICE (x= inner_body )+ ) -> {$body.len > 0}? choice(step=steps) -> {%{\"::choice::\"}} | ^( OPTIONAL b= inner_body ) -> {$body.len > 0 && !$b.optional}? opt(body=b) -> {$body.len > 0 && $b.optional}? {$b.st} -> {%{\"::optional::\"}} | ^( SKIP_TO body ) -> water() | ^( NOT body ) -> {%{\"\"}} | ^( NOSKIP (x= inner_body )+ ) -> {$body.len == 1}? {steps.get(0)} -> {$body.len > 1}? sequence(step=steps) -> {%{\"::noskip::\"}} | ^( PERMUTED (x= inner_body )+ ) -> {$body.len > 0}? star(body=y) -> {%{\"::permuted::\"}});
    public final KGToANTLRTreeGrammar.body_return body() throws RecognitionException {
        KGToANTLRTreeGrammar.body_return retval = new KGToANTLRTreeGrammar.body_return();
        retval.start = input.LT(1);

        CommonTree i=null;
        CommonTree l=null;
        CommonTree n=null;
        CommonTree d=null;
        KGToANTLRTreeGrammar.inner_body_return x = null;

        KGToANTLRTreeGrammar.inner_body_return b = null;



            retval.len = 0;
            retval.optional = false;
          
        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:96:3: ( ^( SEQUENCE (x= inner_body )+ ) -> {$body.len == 1}? {steps.get(0)} -> {$body.len > 1}? sequence(step=steps) -> {%{\"::seq::\"}} | ^( ACT NATIVE_CODE ) -> {%{\"::act::\"}} | ANY -> {%{\"::any::\"}} | TAG -> {%{\"::tag::\"}} | i= IDENTIFIER -> {isLiteral}? {%{ANTLRNaming.forLiteral(text)}} -> {%{text}} | l= LITERAL -> {%{ANTLRNaming.forLiteral(text)}} | n= NUMBER -> {%{ANTLRNaming.forLiteral(text)}} | DOT -> {%{\"'.'\"}} | ^( ASSIGN IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT ) ) -> {i != null && isLiteral}? {%{ANTLRNaming.forLiteral(text)}} -> {i != null}? {%{text}} -> {%{ANTLRNaming.forLiteral(text)}} | ^( STAR b= inner_body ) -> {$body.len > 0}? star(body=b) -> {%{\"::star::\"}} | ^( PLUS b= inner_body ) -> {$body.len > 0}? plus(body=b) -> {%{\"::plus::\"}} | ^( CHOICE (x= inner_body )+ ) -> {$body.len > 0}? choice(step=steps) -> {%{\"::choice::\"}} | ^( OPTIONAL b= inner_body ) -> {$body.len > 0 && !$b.optional}? opt(body=b) -> {$body.len > 0 && $b.optional}? {$b.st} -> {%{\"::optional::\"}} | ^( SKIP_TO body ) -> water() | ^( NOT body ) -> {%{\"\"}} | ^( NOSKIP (x= inner_body )+ ) -> {$body.len == 1}? {steps.get(0)} -> {$body.len > 1}? sequence(step=steps) -> {%{\"::noskip::\"}} | ^( PERMUTED (x= inner_body )+ ) -> {$body.len > 0}? star(body=y) -> {%{\"::permuted::\"}})
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
            case ANY:
                {
                alt10=3;
                }
                break;
            case TAG:
                {
                alt10=4;
                }
                break;
            case IDENTIFIER:
                {
                alt10=5;
                }
                break;
            case LITERAL:
                {
                alt10=6;
                }
                break;
            case NUMBER:
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
            case NOT:
                {
                alt10=15;
                }
                break;
            case NOSKIP:
                {
                alt10=16;
                }
                break;
            case PERMUTED:
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
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:96:5: ^( SEQUENCE (x= inner_body )+ )
                    {
                     List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
                    match(input,SEQUENCE,FOLLOW_SEQUENCE_in_body419); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:99:7: (x= inner_body )+
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
                    	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:99:8: x= inner_body
                    	    {
                    	    pushFollow(FOLLOW_inner_body_in_body431);
                    	    x=inner_body();

                    	    state._fsp--;

                    	     if ((x!=null?x.len:0) > 0) {
                    	                steps.add((x!=null?x.st:null));
                    	                retval.len += (x!=null?x.len:0);
                    	              }
                    	            

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
                    // 108:5: -> {$body.len == 1}? {steps.get(0)}
                    if (retval.len == 1) {
                        retval.st = steps.get(0);
                    }
                    else // 109:5: -> {$body.len > 1}? sequence(step=steps)
                    if (retval.len > 1) {
                        retval.st = templateLib.getInstanceOf("sequence",
                      new STAttrMap().put("step", steps));
                    }
                    else // 112:5: -> {%{\"::seq::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::seq::");
                    }


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:114:5: ^( ACT NATIVE_CODE )
                    {
                    match(input,ACT,FOLLOW_ACT_in_body522); 

                    match(input, Token.DOWN, null); 
                    match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_body524); 

                    match(input, Token.UP, null); 
                     retval.len = 0; 


                    // TEMPLATE REWRITE
                    // 118:5: -> {%{\"::act::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::act::");
                    }


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:120:5: ANY
                    {
                    match(input,ANY,FOLLOW_ANY_in_body554); 
                     retval.len = 0; 


                    // TEMPLATE REWRITE
                    // 124:5: -> {%{\"::any::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::any::");
                    }


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:126:5: TAG
                    {
                    match(input,TAG,FOLLOW_TAG_in_body577); 
                     retval.len = 0; 


                    // TEMPLATE REWRITE
                    // 130:5: -> {%{\"::tag::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::tag::");
                    }


                    }
                    break;
                case 5 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:132:5: i= IDENTIFIER
                    {
                    i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body602); 
                     retval.len = 1; 
                     String text = ((CommonTree) i).getText();
                          boolean isLiteral = Character.isUpperCase(text.charAt(0));
                          if (isLiteral) {
                            literal(text);
                          }
                        


                    // TEMPLATE REWRITE
                    // 143:5: -> {isLiteral}? {%{ANTLRNaming.forLiteral(text)}}
                    if (isLiteral) {
                        retval.st = new StringTemplate(templateLib,ANTLRNaming.forLiteral(text));
                    }
                    else // 144:5: -> {%{text}}
                    {
                        retval.st = new StringTemplate(templateLib,text);
                    }


                    }
                    break;
                case 6 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:146:5: l= LITERAL
                    {
                    l=(CommonTree)match(input,LITERAL,FOLLOW_LITERAL_in_body658); 
                     retval.len = 1; 
                     String text = ((CommonTree) l).getText();
                          text = text.substring(1, text.length() - 1);
                          literal(text);
                        


                    // TEMPLATE REWRITE
                    // 155:5: -> {%{ANTLRNaming.forLiteral(text)}}
                    {
                        retval.st = new StringTemplate(templateLib,ANTLRNaming.forLiteral(text));
                    }


                    }
                    break;
                case 7 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:157:5: n= NUMBER
                    {
                    n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body698); 
                     retval.len = 1; 
                     String text = ((CommonTree) n).getText();
                          literal(text);
                        


                    // TEMPLATE REWRITE
                    // 165:5: -> {%{ANTLRNaming.forLiteral(text)}}
                    {
                        retval.st = new StringTemplate(templateLib,ANTLRNaming.forLiteral(text));
                    }


                    }
                    break;
                case 8 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:167:5: DOT
                    {
                    match(input,DOT,FOLLOW_DOT_in_body738); 
                     retval.len = 1; 
                     literal("."); 


                    // TEMPLATE REWRITE
                    // 173:5: -> {%{\"'.'\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"'.'");
                    }


                    }
                    break;
                case 9 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:175:5: ^( ASSIGN IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT ) )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_body783); 

                    match(input, Token.DOWN, null); 
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body785); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:175:25: (i= IDENTIFIER | n= NUMBER | d= DOT )
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
                            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:175:26: i= IDENTIFIER
                            {
                            i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body790); 

                            }
                            break;
                        case 2 :
                            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:175:41: n= NUMBER
                            {
                            n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body796); 

                            }
                            break;
                        case 3 :
                            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:175:52: d= DOT
                            {
                            d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body802); 

                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                     retval.len = 1; 
                     String text = null;
                          boolean isLiteral = false;
                          if (i != null) {
                            text = ((CommonTree) i).getText();
                            isLiteral = Character.isUpperCase(text.charAt(0));
                            if (isLiteral) {
                              literal(text);
                            }
                            
                          } else if (n != null) {
                            text = ((CommonTree) n).getText();
                            literal(text);
                            
                          } else {
                            literal(".");
                          }
                        


                    // TEMPLATE REWRITE
                    // 197:5: -> {i != null && isLiteral}? {%{ANTLRNaming.forLiteral(text)}}
                    if (i != null && isLiteral) {
                        retval.st = new StringTemplate(templateLib,ANTLRNaming.forLiteral(text));
                    }
                    else // 198:5: -> {i != null}? {%{text}}
                    if (i != null) {
                        retval.st = new StringTemplate(templateLib,text);
                    }
                    else // 199:5: -> {%{ANTLRNaming.forLiteral(text)}}
                    {
                        retval.st = new StringTemplate(templateLib,ANTLRNaming.forLiteral(text));
                    }


                    }
                    break;
                case 10 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:201:5: ^( STAR b= inner_body )
                    {
                    match(input,STAR,FOLLOW_STAR_in_body869); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_inner_body_in_body873);
                    b=inner_body();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     retval.len = (b!=null?b.len:0);
                          retval.optional = true;
                        


                    // TEMPLATE REWRITE
                    // 207:5: -> {$body.len > 0}? star(body=b)
                    if (retval.len > 0) {
                        retval.st = templateLib.getInstanceOf("star",
                      new STAttrMap().put("body", b));
                    }
                    else // 210:5: -> {%{\"::star::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::star::");
                    }


                    }
                    break;
                case 11 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:212:5: ^( PLUS b= inner_body )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_body939); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_inner_body_in_body943);
                    b=inner_body();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     retval.len = (b!=null?b.len:0); 


                    // TEMPLATE REWRITE
                    // 216:5: -> {$body.len > 0}? plus(body=b)
                    if (retval.len > 0) {
                        retval.st = templateLib.getInstanceOf("plus",
                      new STAttrMap().put("body", b));
                    }
                    else // 219:5: -> {%{\"::plus::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::plus::");
                    }


                    }
                    break;
                case 12 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:221:5: ^( CHOICE (x= inner_body )+ )
                    {
                     List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
                    match(input,CHOICE,FOLLOW_CHOICE_in_body1015); 

                     retval.optional = true; 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:224:7: (x= inner_body )+
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
                    	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:224:8: x= inner_body
                    	    {
                    	    pushFollow(FOLLOW_inner_body_in_body1034);
                    	    x=inner_body();

                    	    state._fsp--;

                    	     if ((x!=null?x.len:0) > 0) {
                    	                steps.add(x.st);
                    	                retval.len += (x!=null?x.len:0);
                    	                retval.optional = retval.optional && (x!=null?x.optional:false);
                    	              }
                    	            

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
                    // 234:5: -> {$body.len > 0}? choice(step=steps)
                    if (retval.len > 0) {
                        retval.st = templateLib.getInstanceOf("choice",
                      new STAttrMap().put("step", steps));
                    }
                    else // 237:5: -> {%{\"::choice::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::choice::");
                    }


                    }
                    break;
                case 13 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:239:5: ^( OPTIONAL b= inner_body )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_body1117); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_inner_body_in_body1127);
                    b=inner_body();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     retval.len = (b!=null?b.len:0);
                          retval.optional = true;
                        


                    // TEMPLATE REWRITE
                    // 247:5: -> {$body.len > 0 && !$b.optional}? opt(body=b)
                    if (retval.len > 0 && !(b!=null?b.optional:false)) {
                        retval.st = templateLib.getInstanceOf("opt",
                      new STAttrMap().put("body", b));
                    }
                    else // 250:5: -> {$body.len > 0 && $b.optional}? {$b.st}
                    if (retval.len > 0 && (b!=null?b.optional:false)) {
                        retval.st = (b!=null?b.st:null);
                    }
                    else // 251:5: -> {%{\"::optional::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::optional::");
                    }


                    }
                    break;
                case 14 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:254:5: ^( SKIP_TO body )
                    {
                    match(input,SKIP_TO,FOLLOW_SKIP_TO_in_body1216); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1224);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     retval.len = 1;
                          retval.optional = true;
                        


                    // TEMPLATE REWRITE
                    // 262:5: -> water()
                    {
                        retval.st = templateLib.getInstanceOf("water");
                    }


                    }
                    break;
                case 15 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:264:5: ^( NOT body )
                    {
                    match(input,NOT,FOLLOW_NOT_in_body1264); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1266);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     retval.len = 0;
                          retval.optional = true;
                        


                    // TEMPLATE REWRITE
                    // 270:5: -> {%{\"\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"");
                    }


                    }
                    break;
                case 16 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:272:5: ^( NOSKIP (x= inner_body )+ )
                    {
                     List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
                    match(input,NOSKIP,FOLLOW_NOSKIP_in_body1299); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:274:7: (x= inner_body )+
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
                    	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:274:8: x= inner_body
                    	    {
                    	    pushFollow(FOLLOW_inner_body_in_body1311);
                    	    x=inner_body();

                    	    state._fsp--;

                    	     if ((x!=null?x.len:0) > 0) {
                    	                steps.add((x!=null?x.st:null));
                    	                retval.len += (x!=null?x.len:0);
                    	              }
                    	            

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
                    // 283:5: -> {$body.len == 1}? {steps.get(0)}
                    if (retval.len == 1) {
                        retval.st = steps.get(0);
                    }
                    else // 284:5: -> {$body.len > 1}? sequence(step=steps)
                    if (retval.len > 1) {
                        retval.st = templateLib.getInstanceOf("sequence",
                      new STAttrMap().put("step", steps));
                    }
                    else // 287:5: -> {%{\"::noskip::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::noskip::");
                    }


                    }
                    break;
                case 17 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:289:5: ^( PERMUTED (x= inner_body )+ )
                    {
                     List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
                    match(input,PERMUTED,FOLLOW_PERMUTED_in_body1406); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:291:7: (x= inner_body )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=SEQUENCE && LA9_0<=ASSIGN)||(LA9_0>=PERMUTED && LA9_0<=IDENTIFIER)||(LA9_0>=TAG && LA9_0<=PLUS)||LA9_0==SKIP_TO||(LA9_0>=NOT && LA9_0<=NOSKIP)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:291:8: x= inner_body
                    	    {
                    	    pushFollow(FOLLOW_inner_body_in_body1418);
                    	    x=inner_body();

                    	    state._fsp--;

                    	     if ((x!=null?x.len:0) > 0) {
                    	                steps.add(x.st);
                    	                retval.len += (x!=null?x.len:0);
                    	              }
                    	            

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
                     StringTemplate y = templateLib.getInstanceOf("choice",
                      new STAttrMap().put("step", steps));
                          
                          retval.optional = true;
                        


                    // TEMPLATE REWRITE
                    // 307:5: -> {$body.len > 0}? star(body=y)
                    if (retval.len > 0) {
                        retval.st = templateLib.getInstanceOf("star",
                      new STAttrMap().put("body", y));
                    }
                    else // 310:5: -> {%{\"::permuted::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::permuted::");
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

    public static class inner_body_return extends TreeRuleReturnScope {
        public int len;
        public boolean optional;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "inner_body"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:313:1: inner_body returns [ int len, boolean optional ] : body -> {$body.st};
    public final KGToANTLRTreeGrammar.inner_body_return inner_body() throws RecognitionException {
        KGToANTLRTreeGrammar.inner_body_return retval = new KGToANTLRTreeGrammar.inner_body_return();
        retval.start = input.LT(1);

        KGToANTLRTreeGrammar.body_return body1 = null;


        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:314:3: ( body -> {$body.st})
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:314:5: body
            {
            pushFollow(FOLLOW_body_in_inner_body1513);
            body1=body();

            state._fsp--;

             retval.len = (body1!=null?body1.len:0);
                  retval.optional = (body1!=null?body1.optional:false);
                


            // TEMPLATE REWRITE
            // 318:5: -> {$body.st}
            {
                retval.st = (body1!=null?body1.st:null);
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
    // $ANTLR end "inner_body"

    // Delegated rules


 

    public static final BitSet FOLLOW_GRAMMAR_in_koopa68 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rule_in_koopa79 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_RULE_in_rule184 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule188 = new BitSet(new long[]{0x000000069FC1DF80L});
    public static final BitSet FOLLOW_locals_in_rule197 = new BitSet(new long[]{0x000000069FC1DF80L});
    public static final BitSet FOLLOW_returning_in_rule206 = new BitSet(new long[]{0x000000069FC1DF80L});
    public static final BitSet FOLLOW_body_in_rule217 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURNS_in_returning332 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_returning334 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOCALS_in_locals351 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaration_in_locals359 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_DECLARATION_in_declaration380 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration382 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration384 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEQUENCE_in_body419 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inner_body_in_body431 = new BitSet(new long[]{0x000000069FC1DF88L});
    public static final BitSet FOLLOW_ACT_in_body522 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NATIVE_CODE_in_body524 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ANY_in_body554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TAG_in_body577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_body658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_body698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_body738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_body783 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body785 = new BitSet(new long[]{0x0000000006010000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body790 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NUMBER_in_body796 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_body802 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_body869 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inner_body_in_body873 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_body939 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inner_body_in_body943 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHOICE_in_body1015 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inner_body_in_body1034 = new BitSet(new long[]{0x000000069FC1DF88L});
    public static final BitSet FOLLOW_OPTIONAL_in_body1117 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inner_body_in_body1127 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SKIP_TO_in_body1216 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1224 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_body1264 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1266 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOSKIP_in_body1299 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inner_body_in_body1311 = new BitSet(new long[]{0x000000069FC1DF88L});
    public static final BitSet FOLLOW_PERMUTED_in_body1406 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inner_body_in_body1418 = new BitSet(new long[]{0x000000069FC1DF88L});
    public static final BitSet FOLLOW_body_in_inner_body1513 = new BitSet(new long[]{0x0000000000000002L});

}