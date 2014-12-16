// $ANTLR 3.1.1 src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g 2014-12-15 22:16:43

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
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:43:1: koopa[String name, String pack, String usercode] : ^( GRAMMAR meta (r+= rule )* ) -> treegrammar(name=namedate=new Date()pack=packrule=$rliteral=antlrifiedLiterals()usercode=usercode);
    public final KGToANTLRTreeGrammar.koopa_return koopa(String name, String pack, String usercode) throws RecognitionException {
        KGToANTLRTreeGrammar.koopa_return retval = new KGToANTLRTreeGrammar.koopa_return();
        retval.start = input.LT(1);

        List list_r=null;
        RuleReturnScope r = null;
        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:44:3: ( ^( GRAMMAR meta (r+= rule )* ) -> treegrammar(name=namedate=new Date()pack=packrule=$rliteral=antlrifiedLiterals()usercode=usercode))
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:44:5: ^( GRAMMAR meta (r+= rule )* )
            {
            match(input,GRAMMAR,FOLLOW_GRAMMAR_in_koopa68); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_meta_in_koopa76);
            meta();

            state._fsp--;

            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:46:7: (r+= rule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:46:8: r+= rule
            	    {
            	    pushFollow(FOLLOW_rule_in_koopa87);
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
            // 49:5: -> treegrammar(name=namedate=new Date()pack=packrule=$rliteral=antlrifiedLiterals()usercode=usercode)
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

    public static class meta_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "meta"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:59:1: meta : ^( META named ( extending )? ) ;
    public final KGToANTLRTreeGrammar.meta_return meta() throws RecognitionException {
        KGToANTLRTreeGrammar.meta_return retval = new KGToANTLRTreeGrammar.meta_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:60:3: ( ^( META named ( extending )? ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:60:5: ^( META named ( extending )? )
            {
            match(input,META,FOLLOW_META_in_meta192); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_named_in_meta194);
            named();

            state._fsp--;

            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:60:18: ( extending )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==EXTENDING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:60:18: extending
                    {
                    pushFollow(FOLLOW_extending_in_meta196);
                    extending();

                    state._fsp--;


                    }
                    break;

            }


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
    // $ANTLR end "meta"

    public static class named_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "named"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:63:1: named : ^( NAMED IDENTIFIER ) ;
    public final KGToANTLRTreeGrammar.named_return named() throws RecognitionException {
        KGToANTLRTreeGrammar.named_return retval = new KGToANTLRTreeGrammar.named_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:64:3: ( ^( NAMED IDENTIFIER ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:64:5: ^( NAMED IDENTIFIER )
            {
            match(input,NAMED,FOLLOW_NAMED_in_named212); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_named214); 

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
    // $ANTLR end "named"

    public static class extending_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "extending"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:67:1: extending : ^( EXTENDING IDENTIFIER ) ;
    public final KGToANTLRTreeGrammar.extending_return extending() throws RecognitionException {
        KGToANTLRTreeGrammar.extending_return retval = new KGToANTLRTreeGrammar.extending_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:68:3: ( ^( EXTENDING IDENTIFIER ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:68:5: ^( EXTENDING IDENTIFIER )
            {
            match(input,EXTENDING,FOLLOW_EXTENDING_in_extending229); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_extending231); 

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
    // $ANTLR end "extending"

    public static class rule_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "rule"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:71:1: rule : ^( RULE n= IDENTIFIER ( locals )? ( returning )? b= body ) -> {$body.len > 0}? rule(name=$ntag=ANTLRNaming.forNode($n.toString())body=b) -> rule(name=$ntag=ANTLRNaming.forNode($n.toString()));
    public final KGToANTLRTreeGrammar.rule_return rule() throws RecognitionException {
        KGToANTLRTreeGrammar.rule_return retval = new KGToANTLRTreeGrammar.rule_return();
        retval.start = input.LT(1);

        CommonTree n=null;
        KGToANTLRTreeGrammar.body_return b = null;


        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:72:3: ( ^( RULE n= IDENTIFIER ( locals )? ( returning )? b= body ) -> {$body.len > 0}? rule(name=$ntag=ANTLRNaming.forNode($n.toString())body=b) -> rule(name=$ntag=ANTLRNaming.forNode($n.toString())))
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:72:5: ^( RULE n= IDENTIFIER ( locals )? ( returning )? b= body )
            {
            match(input,RULE,FOLLOW_RULE_in_rule246); 

            match(input, Token.DOWN, null); 
            n=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule250); 
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:73:7: ( locals )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LOCALS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:73:7: locals
                    {
                    pushFollow(FOLLOW_locals_in_rule259);
                    locals();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:74:7: ( returning )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RETURNS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:74:7: returning
                    {
                    pushFollow(FOLLOW_returning_in_rule268);
                    returning();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_body_in_rule279);
            b=body();

            state._fsp--;


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 78:5: -> {$body.len > 0}? rule(name=$ntag=ANTLRNaming.forNode($n.toString())body=b)
            if ((b!=null?b.len:0) > 0) {
                retval.st = templateLib.getInstanceOf("rule",
              new STAttrMap().put("name", n).put("tag", ANTLRNaming.forNode(n.toString())).put("body", b));
            }
            else // 84:5: -> rule(name=$ntag=ANTLRNaming.forNode($n.toString()))
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
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:90:1: returning : ^( RETURNS IDENTIFIER ) ;
    public final KGToANTLRTreeGrammar.returning_return returning() throws RecognitionException {
        KGToANTLRTreeGrammar.returning_return retval = new KGToANTLRTreeGrammar.returning_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:91:3: ( ^( RETURNS IDENTIFIER ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:91:5: ^( RETURNS IDENTIFIER )
            {
            match(input,RETURNS,FOLLOW_RETURNS_in_returning394); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_returning396); 

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
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:94:1: locals : ^( LOCALS ( declaration )+ ) ;
    public final KGToANTLRTreeGrammar.locals_return locals() throws RecognitionException {
        KGToANTLRTreeGrammar.locals_return retval = new KGToANTLRTreeGrammar.locals_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:95:3: ( ^( LOCALS ( declaration )+ ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:95:5: ^( LOCALS ( declaration )+ )
            {
            match(input,LOCALS,FOLLOW_LOCALS_in_locals413); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:96:7: ( declaration )+
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
            	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:96:7: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_locals421);
            	    declaration();

            	    state._fsp--;


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
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "declaration"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:100:1: declaration : ^( DECLARATION IDENTIFIER IDENTIFIER ) ;
    public final KGToANTLRTreeGrammar.declaration_return declaration() throws RecognitionException {
        KGToANTLRTreeGrammar.declaration_return retval = new KGToANTLRTreeGrammar.declaration_return();
        retval.start = input.LT(1);

        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:101:3: ( ^( DECLARATION IDENTIFIER IDENTIFIER ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:101:5: ^( DECLARATION IDENTIFIER IDENTIFIER )
            {
            match(input,DECLARATION,FOLLOW_DECLARATION_in_declaration442); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration444); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration446); 

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
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:104:1: body returns [ int len, boolean optional ] : ( ^( SEQUENCE (x= inner_body )+ ) -> {$body.len == 1}? {steps.get(0)} -> {$body.len > 1}? sequence(step=steps) -> {%{\"::seq::\"}} | ^( ACT NATIVE_CODE ) -> {%{\"::act::\"}} | ANY -> {%{\"::any::\"}} | TAG -> {%{\"::tag::\"}} | i= IDENTIFIER -> {isLiteral}? {%{ANTLRNaming.forLiteral(text)}} -> {%{text}} | l= LITERAL -> {%{ANTLRNaming.forLiteral(text)}} | n= NUMBER -> {%{ANTLRNaming.forLiteral(text)}} | DOT -> {%{\"'.'\"}} | ^( ASSIGN IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT | a= ANY ) ) -> {i != null && isLiteral}? {%{ANTLRNaming.forLiteral(text)}} -> {i != null}? {%{text}} -> {%{ANTLRNaming.forLiteral(text)}} | ^( STAR b= inner_body ) -> {$body.len > 0}? star(body=b) -> {%{\"::star::\"}} | ^( PLUS b= inner_body ) -> {$body.len > 0}? plus(body=b) -> {%{\"::plus::\"}} | ^( CHOICE (x= inner_body )+ ) -> {$body.len > 0}? choice(step=steps) -> {%{\"::choice::\"}} | ^( OPTIONAL b= inner_body ) -> {$body.len > 0 && !$b.optional}? opt(body=b) -> {$body.len > 0 && $b.optional}? {$b.st} -> {%{\"::optional::\"}} | ^( SKIP_TO body ) -> water() | ^( NOT body ) -> {%{\"\"}} | ^( NOSKIP (x= inner_body )+ ) -> {$body.len == 1}? {steps.get(0)} -> {$body.len > 1}? sequence(step=steps) -> {%{\"::noskip::\"}} | ^( PERMUTED (x= inner_body )+ ) -> {$body.len > 0}? star(body=y) -> {%{\"::permuted::\"}});
    public final KGToANTLRTreeGrammar.body_return body() throws RecognitionException {
        KGToANTLRTreeGrammar.body_return retval = new KGToANTLRTreeGrammar.body_return();
        retval.start = input.LT(1);

        CommonTree i=null;
        CommonTree l=null;
        CommonTree n=null;
        CommonTree d=null;
        CommonTree a=null;
        KGToANTLRTreeGrammar.inner_body_return x = null;

        KGToANTLRTreeGrammar.inner_body_return b = null;



            retval.len = 0;
            retval.optional = false;
          
        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:109:3: ( ^( SEQUENCE (x= inner_body )+ ) -> {$body.len == 1}? {steps.get(0)} -> {$body.len > 1}? sequence(step=steps) -> {%{\"::seq::\"}} | ^( ACT NATIVE_CODE ) -> {%{\"::act::\"}} | ANY -> {%{\"::any::\"}} | TAG -> {%{\"::tag::\"}} | i= IDENTIFIER -> {isLiteral}? {%{ANTLRNaming.forLiteral(text)}} -> {%{text}} | l= LITERAL -> {%{ANTLRNaming.forLiteral(text)}} | n= NUMBER -> {%{ANTLRNaming.forLiteral(text)}} | DOT -> {%{\"'.'\"}} | ^( ASSIGN IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT | a= ANY ) ) -> {i != null && isLiteral}? {%{ANTLRNaming.forLiteral(text)}} -> {i != null}? {%{text}} -> {%{ANTLRNaming.forLiteral(text)}} | ^( STAR b= inner_body ) -> {$body.len > 0}? star(body=b) -> {%{\"::star::\"}} | ^( PLUS b= inner_body ) -> {$body.len > 0}? plus(body=b) -> {%{\"::plus::\"}} | ^( CHOICE (x= inner_body )+ ) -> {$body.len > 0}? choice(step=steps) -> {%{\"::choice::\"}} | ^( OPTIONAL b= inner_body ) -> {$body.len > 0 && !$b.optional}? opt(body=b) -> {$body.len > 0 && $b.optional}? {$b.st} -> {%{\"::optional::\"}} | ^( SKIP_TO body ) -> water() | ^( NOT body ) -> {%{\"\"}} | ^( NOSKIP (x= inner_body )+ ) -> {$body.len == 1}? {steps.get(0)} -> {$body.len > 1}? sequence(step=steps) -> {%{\"::noskip::\"}} | ^( PERMUTED (x= inner_body )+ ) -> {$body.len > 0}? star(body=y) -> {%{\"::permuted::\"}})
            int alt11=17;
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
            case ANY:
                {
                alt11=3;
                }
                break;
            case TAG:
                {
                alt11=4;
                }
                break;
            case IDENTIFIER:
                {
                alt11=5;
                }
                break;
            case LITERAL:
                {
                alt11=6;
                }
                break;
            case NUMBER:
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
            case OPTIONAL:
                {
                alt11=13;
                }
                break;
            case SKIP_TO:
                {
                alt11=14;
                }
                break;
            case NOT:
                {
                alt11=15;
                }
                break;
            case NOSKIP:
                {
                alt11=16;
                }
                break;
            case PERMUTED:
                {
                alt11=17;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:109:5: ^( SEQUENCE (x= inner_body )+ )
                    {
                     List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
                    match(input,SEQUENCE,FOLLOW_SEQUENCE_in_body481); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:112:7: (x= inner_body )+
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
                    	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:112:8: x= inner_body
                    	    {
                    	    pushFollow(FOLLOW_inner_body_in_body493);
                    	    x=inner_body();

                    	    state._fsp--;

                    	     if ((x!=null?x.len:0) > 0) {
                    	                steps.add((x!=null?x.st:null));
                    	                retval.len += (x!=null?x.len:0);
                    	              }
                    	            

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
                    // 121:5: -> {$body.len == 1}? {steps.get(0)}
                    if (retval.len == 1) {
                        retval.st = steps.get(0);
                    }
                    else // 122:5: -> {$body.len > 1}? sequence(step=steps)
                    if (retval.len > 1) {
                        retval.st = templateLib.getInstanceOf("sequence",
                      new STAttrMap().put("step", steps));
                    }
                    else // 125:5: -> {%{\"::seq::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::seq::");
                    }


                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:127:5: ^( ACT NATIVE_CODE )
                    {
                    match(input,ACT,FOLLOW_ACT_in_body584); 

                    match(input, Token.DOWN, null); 
                    match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_body586); 

                    match(input, Token.UP, null); 
                     retval.len = 0; 


                    // TEMPLATE REWRITE
                    // 131:5: -> {%{\"::act::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::act::");
                    }


                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:133:5: ANY
                    {
                    match(input,ANY,FOLLOW_ANY_in_body616); 
                     retval.len = 0; 


                    // TEMPLATE REWRITE
                    // 137:5: -> {%{\"::any::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::any::");
                    }


                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:139:5: TAG
                    {
                    match(input,TAG,FOLLOW_TAG_in_body639); 
                     retval.len = 0; 


                    // TEMPLATE REWRITE
                    // 143:5: -> {%{\"::tag::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::tag::");
                    }


                    }
                    break;
                case 5 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:145:5: i= IDENTIFIER
                    {
                    i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body664); 
                     retval.len = 1; 
                     String text = ((CommonTree) i).getText();
                          boolean isLiteral = Character.isUpperCase(text.charAt(0));
                          if (isLiteral) {
                            literal(text);
                          }
                        


                    // TEMPLATE REWRITE
                    // 156:5: -> {isLiteral}? {%{ANTLRNaming.forLiteral(text)}}
                    if (isLiteral) {
                        retval.st = new StringTemplate(templateLib,ANTLRNaming.forLiteral(text));
                    }
                    else // 157:5: -> {%{text}}
                    {
                        retval.st = new StringTemplate(templateLib,text);
                    }


                    }
                    break;
                case 6 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:159:5: l= LITERAL
                    {
                    l=(CommonTree)match(input,LITERAL,FOLLOW_LITERAL_in_body720); 
                     retval.len = 1; 
                     String text = ((CommonTree) l).getText();
                          text = text.substring(1, text.length() - 1);
                          literal(text);
                        


                    // TEMPLATE REWRITE
                    // 168:5: -> {%{ANTLRNaming.forLiteral(text)}}
                    {
                        retval.st = new StringTemplate(templateLib,ANTLRNaming.forLiteral(text));
                    }


                    }
                    break;
                case 7 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:170:5: n= NUMBER
                    {
                    n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body760); 
                     retval.len = 1; 
                     String text = ((CommonTree) n).getText();
                          literal(text);
                        


                    // TEMPLATE REWRITE
                    // 178:5: -> {%{ANTLRNaming.forLiteral(text)}}
                    {
                        retval.st = new StringTemplate(templateLib,ANTLRNaming.forLiteral(text));
                    }


                    }
                    break;
                case 8 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:180:5: DOT
                    {
                    match(input,DOT,FOLLOW_DOT_in_body800); 
                     retval.len = 1; 
                     literal("."); 


                    // TEMPLATE REWRITE
                    // 186:5: -> {%{\"'.'\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"'.'");
                    }


                    }
                    break;
                case 9 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:188:5: ^( ASSIGN IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT | a= ANY ) )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_body845); 

                    match(input, Token.DOWN, null); 
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body847); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:188:25: (i= IDENTIFIER | n= NUMBER | d= DOT | a= ANY )
                    int alt7=4;
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
                    case ANY:
                        {
                        alt7=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;
                    }

                    switch (alt7) {
                        case 1 :
                            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:188:26: i= IDENTIFIER
                            {
                            i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body852); 

                            }
                            break;
                        case 2 :
                            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:188:41: n= NUMBER
                            {
                            n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body858); 

                            }
                            break;
                        case 3 :
                            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:188:52: d= DOT
                            {
                            d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body864); 

                            }
                            break;
                        case 4 :
                            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:188:60: a= ANY
                            {
                            a=(CommonTree)match(input,ANY,FOLLOW_ANY_in_body870); 

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
                            
                          } else if (d != null) {
                            literal(".");
                          }
                        


                    // TEMPLATE REWRITE
                    // 210:5: -> {i != null && isLiteral}? {%{ANTLRNaming.forLiteral(text)}}
                    if (i != null && isLiteral) {
                        retval.st = new StringTemplate(templateLib,ANTLRNaming.forLiteral(text));
                    }
                    else // 211:5: -> {i != null}? {%{text}}
                    if (i != null) {
                        retval.st = new StringTemplate(templateLib,text);
                    }
                    else // 212:5: -> {%{ANTLRNaming.forLiteral(text)}}
                    {
                        retval.st = new StringTemplate(templateLib,ANTLRNaming.forLiteral(text));
                    }


                    }
                    break;
                case 10 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:214:5: ^( STAR b= inner_body )
                    {
                    match(input,STAR,FOLLOW_STAR_in_body937); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_inner_body_in_body941);
                    b=inner_body();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     retval.len = (b!=null?b.len:0);
                          retval.optional = true;
                        


                    // TEMPLATE REWRITE
                    // 220:5: -> {$body.len > 0}? star(body=b)
                    if (retval.len > 0) {
                        retval.st = templateLib.getInstanceOf("star",
                      new STAttrMap().put("body", b));
                    }
                    else // 223:5: -> {%{\"::star::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::star::");
                    }


                    }
                    break;
                case 11 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:225:5: ^( PLUS b= inner_body )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_body1007); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_inner_body_in_body1011);
                    b=inner_body();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     retval.len = (b!=null?b.len:0); 


                    // TEMPLATE REWRITE
                    // 229:5: -> {$body.len > 0}? plus(body=b)
                    if (retval.len > 0) {
                        retval.st = templateLib.getInstanceOf("plus",
                      new STAttrMap().put("body", b));
                    }
                    else // 232:5: -> {%{\"::plus::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::plus::");
                    }


                    }
                    break;
                case 12 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:234:5: ^( CHOICE (x= inner_body )+ )
                    {
                     List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
                    match(input,CHOICE,FOLLOW_CHOICE_in_body1083); 

                     retval.optional = true; 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:237:7: (x= inner_body )+
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
                    	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:237:8: x= inner_body
                    	    {
                    	    pushFollow(FOLLOW_inner_body_in_body1102);
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
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


                    match(input, Token.UP, null); 


                    // TEMPLATE REWRITE
                    // 247:5: -> {$body.len > 0}? choice(step=steps)
                    if (retval.len > 0) {
                        retval.st = templateLib.getInstanceOf("choice",
                      new STAttrMap().put("step", steps));
                    }
                    else // 250:5: -> {%{\"::choice::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::choice::");
                    }


                    }
                    break;
                case 13 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:252:5: ^( OPTIONAL b= inner_body )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_body1185); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_inner_body_in_body1195);
                    b=inner_body();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     retval.len = (b!=null?b.len:0);
                          retval.optional = true;
                        


                    // TEMPLATE REWRITE
                    // 260:5: -> {$body.len > 0 && !$b.optional}? opt(body=b)
                    if (retval.len > 0 && !(b!=null?b.optional:false)) {
                        retval.st = templateLib.getInstanceOf("opt",
                      new STAttrMap().put("body", b));
                    }
                    else // 263:5: -> {$body.len > 0 && $b.optional}? {$b.st}
                    if (retval.len > 0 && (b!=null?b.optional:false)) {
                        retval.st = (b!=null?b.st:null);
                    }
                    else // 264:5: -> {%{\"::optional::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::optional::");
                    }


                    }
                    break;
                case 14 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:267:5: ^( SKIP_TO body )
                    {
                    match(input,SKIP_TO,FOLLOW_SKIP_TO_in_body1284); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1292);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     retval.len = 1;
                          retval.optional = true;
                        


                    // TEMPLATE REWRITE
                    // 275:5: -> water()
                    {
                        retval.st = templateLib.getInstanceOf("water");
                    }


                    }
                    break;
                case 15 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:277:5: ^( NOT body )
                    {
                    match(input,NOT,FOLLOW_NOT_in_body1332); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body1334);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     retval.len = 0;
                          retval.optional = true;
                        


                    // TEMPLATE REWRITE
                    // 283:5: -> {%{\"\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"");
                    }


                    }
                    break;
                case 16 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:285:5: ^( NOSKIP (x= inner_body )+ )
                    {
                     List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
                    match(input,NOSKIP,FOLLOW_NOSKIP_in_body1367); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:287:7: (x= inner_body )+
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
                    	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:287:8: x= inner_body
                    	    {
                    	    pushFollow(FOLLOW_inner_body_in_body1379);
                    	    x=inner_body();

                    	    state._fsp--;

                    	     if ((x!=null?x.len:0) > 0) {
                    	                steps.add((x!=null?x.st:null));
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


                    // TEMPLATE REWRITE
                    // 296:5: -> {$body.len == 1}? {steps.get(0)}
                    if (retval.len == 1) {
                        retval.st = steps.get(0);
                    }
                    else // 297:5: -> {$body.len > 1}? sequence(step=steps)
                    if (retval.len > 1) {
                        retval.st = templateLib.getInstanceOf("sequence",
                      new STAttrMap().put("step", steps));
                    }
                    else // 300:5: -> {%{\"::noskip::\"}}
                    {
                        retval.st = new StringTemplate(templateLib,"::noskip::");
                    }


                    }
                    break;
                case 17 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:302:5: ^( PERMUTED (x= inner_body )+ )
                    {
                     List<StringTemplate> steps = new LinkedList<StringTemplate>(); 
                    match(input,PERMUTED,FOLLOW_PERMUTED_in_body1474); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:304:7: (x= inner_body )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>=SEQUENCE && LA10_0<=ASSIGN)||(LA10_0>=PERMUTED && LA10_0<=DOT)||(LA10_0>=TAG && LA10_0<=PLUS)||LA10_0==SKIP_TO||(LA10_0>=NOT && LA10_0<=NOSKIP)) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:304:8: x= inner_body
                    	    {
                    	    pushFollow(FOLLOW_inner_body_in_body1486);
                    	    x=inner_body();

                    	    state._fsp--;

                    	     if ((x!=null?x.len:0) > 0) {
                    	                steps.add(x.st);
                    	                retval.len += (x!=null?x.len:0);
                    	              }
                    	            

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);


                    match(input, Token.UP, null); 
                     StringTemplate y = templateLib.getInstanceOf("choice",
                      new STAttrMap().put("step", steps));
                          
                          retval.optional = true;
                        


                    // TEMPLATE REWRITE
                    // 320:5: -> {$body.len > 0}? star(body=y)
                    if (retval.len > 0) {
                        retval.st = templateLib.getInstanceOf("star",
                      new STAttrMap().put("body", y));
                    }
                    else // 323:5: -> {%{\"::permuted::\"}}
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
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:326:1: inner_body returns [ int len, boolean optional ] : body -> {$body.st};
    public final KGToANTLRTreeGrammar.inner_body_return inner_body() throws RecognitionException {
        KGToANTLRTreeGrammar.inner_body_return retval = new KGToANTLRTreeGrammar.inner_body_return();
        retval.start = input.LT(1);

        KGToANTLRTreeGrammar.body_return body1 = null;


        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:327:3: ( body -> {$body.st})
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTreeGrammar.g:327:5: body
            {
            pushFollow(FOLLOW_body_in_inner_body1581);
            body1=body();

            state._fsp--;

             retval.len = (body1!=null?body1.len:0);
                  retval.optional = (body1!=null?body1.optional:false);
                


            // TEMPLATE REWRITE
            // 331:5: -> {$body.st}
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
    public static final BitSet FOLLOW_meta_in_koopa76 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_rule_in_koopa87 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_META_in_meta192 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_named_in_meta194 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_extending_in_meta196 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAMED_in_named212 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_named214 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXTENDING_in_extending229 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_extending231 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_in_rule246 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule250 = new BitSet(new long[]{0x00000034FC1EFC00L});
    public static final BitSet FOLLOW_locals_in_rule259 = new BitSet(new long[]{0x00000034FC1EFC00L});
    public static final BitSet FOLLOW_returning_in_rule268 = new BitSet(new long[]{0x00000034FC1EFC00L});
    public static final BitSet FOLLOW_body_in_rule279 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURNS_in_returning394 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_returning396 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOCALS_in_locals413 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaration_in_locals421 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_DECLARATION_in_declaration442 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration444 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration446 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEQUENCE_in_body481 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inner_body_in_body493 = new BitSet(new long[]{0x00000034FC1EFC08L});
    public static final BitSet FOLLOW_ACT_in_body584 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NATIVE_CODE_in_body586 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ANY_in_body616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TAG_in_body639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_body720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_body760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_body800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_body845 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body847 = new BitSet(new long[]{0x0000000028180000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body852 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NUMBER_in_body858 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_body864 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ANY_in_body870 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_body937 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inner_body_in_body941 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_body1007 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inner_body_in_body1011 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHOICE_in_body1083 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inner_body_in_body1102 = new BitSet(new long[]{0x00000034FC1EFC08L});
    public static final BitSet FOLLOW_OPTIONAL_in_body1185 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inner_body_in_body1195 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SKIP_TO_in_body1284 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1292 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_body1332 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body1334 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOSKIP_in_body1367 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inner_body_in_body1379 = new BitSet(new long[]{0x00000034FC1EFC08L});
    public static final BitSet FOLLOW_PERMUTED_in_body1474 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_inner_body_in_body1486 = new BitSet(new long[]{0x00000034FC1EFC08L});
    public static final BitSet FOLLOW_body_in_inner_body1581 = new BitSet(new long[]{0x0000000000000002L});

}