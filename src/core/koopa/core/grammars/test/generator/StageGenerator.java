// $ANTLR 3.1.1 src/core/koopa/core/grammars/test/generator/StageGenerator.g 2015-02-01 13:53:47

  package koopa.core.grammars.test.generator;
  
  import java.util.Date;
  import java.util.List;
  import java.util.LinkedList;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
public class StageGenerator extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STAGE", "PACKAGE", "GRAMMAR", "TOKENIZER", "TARGET", "TEST", "IDENTIFIER", "SEMI", "ACCEPT", "REJECT", "DATA", "COMMENT", "NEWLINE", "WHITESPACE", "NAME", "LETTER", "NUMBER", "'grammar'", "'package'", "'tokenizer'", "'target'"
    };
    public static final int PACKAGE=5;
    public static final int T__24=24;
    public static final int LETTER=19;
    public static final int T__23=23;
    public static final int STAGE=4;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int NUMBER=20;
    public static final int WHITESPACE=17;
    public static final int TARGET=8;
    public static final int EOF=-1;
    public static final int SEMI=11;
    public static final int ACCEPT=12;
    public static final int NAME=18;
    public static final int NEWLINE=16;
    public static final int REJECT=13;
    public static final int IDENTIFIER=10;
    public static final int TOKENIZER=7;
    public static final int TEST=9;
    public static final int COMMENT=15;
    public static final int DATA=14;
    public static final int GRAMMAR=6;

    // delegates
    // delegators


        public StageGenerator(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public StageGenerator(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected StringTemplateGroup templateLib =
      new StringTemplateGroup("StageGeneratorTemplates", AngleBracketTemplateLexer.class);

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

    public String[] getTokenNames() { return StageGenerator.tokenNames; }
    public String getGrammarFileName() { return "src/core/koopa/core/grammars/test/generator/StageGenerator.g"; }


      private int count = 0;


    public static class stage_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "stage"
    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:23:1: stage[String name] : ^( STAGE p= pack g= grammah tok= tokenizer (t= testsForGrammarRule )* ) -> stage(name=namedate=new Date()package=pgrammah=gtokenizer=toktest=tests);
    public final StageGenerator.stage_return stage(String name) throws RecognitionException {
        StageGenerator.stage_return retval = new StageGenerator.stage_return();
        retval.start = input.LT(1);

        StageGenerator.pack_return p = null;

        StageGenerator.grammah_return g = null;

        StageGenerator.tokenizer_return tok = null;

        StageGenerator.testsForGrammarRule_return t = null;


        try {
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:24:3: ( ^( STAGE p= pack g= grammah tok= tokenizer (t= testsForGrammarRule )* ) -> stage(name=namedate=new Date()package=pgrammah=gtokenizer=toktest=tests))
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:24:5: ^( STAGE p= pack g= grammah tok= tokenizer (t= testsForGrammarRule )* )
            {
             List<StringTemplate> tests = new LinkedList<StringTemplate>(); 
            match(input,STAGE,FOLLOW_STAGE_in_stage77); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_pack_in_stage81);
            p=pack();

            state._fsp--;

            pushFollow(FOLLOW_grammah_in_stage85);
            g=grammah();

            state._fsp--;

            pushFollow(FOLLOW_tokenizer_in_stage89);
            tok=tokenizer();

            state._fsp--;

            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:27:7: (t= testsForGrammarRule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==TARGET) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:27:8: t= testsForGrammarRule
            	    {
            	    pushFollow(FOLLOW_testsForGrammarRule_in_stage100);
            	    t=testsForGrammarRule();

            	    state._fsp--;

            	    tests.addAll((t!=null?t.tests:null));

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 32:5: -> stage(name=namedate=new Date()package=pgrammah=gtokenizer=toktest=tests)
            {
                retval.st = templateLib.getInstanceOf("stage",
              new STAttrMap().put("name", name).put("date", new Date()).put("package", p).put("grammah", g).put("tokenizer", tok).put("test", tests));
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
    // $ANTLR end "stage"

    public static class pack_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "pack"
    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:42:1: pack : ^( PACKAGE IDENTIFIER ) -> {%{((CommonTree) $IDENTIFIER).getText()}};
    public final StageGenerator.pack_return pack() throws RecognitionException {
        StageGenerator.pack_return retval = new StageGenerator.pack_return();
        retval.start = input.LT(1);

        CommonTree IDENTIFIER1=null;

        try {
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:43:3: ( ^( PACKAGE IDENTIFIER ) -> {%{((CommonTree) $IDENTIFIER).getText()}})
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:43:5: ^( PACKAGE IDENTIFIER )
            {
            match(input,PACKAGE,FOLLOW_PACKAGE_in_pack236); 

            match(input, Token.DOWN, null); 
            IDENTIFIER1=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_pack238); 

            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 45:5: -> {%{((CommonTree) $IDENTIFIER).getText()}}
            {
                retval.st = new StringTemplate(templateLib,((CommonTree) IDENTIFIER1).getText());
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
    // $ANTLR end "pack"

    public static class grammah_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "grammah"
    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:48:1: grammah : ^( GRAMMAR IDENTIFIER ) -> {%{((CommonTree) $IDENTIFIER).getText()}};
    public final StageGenerator.grammah_return grammah() throws RecognitionException {
        StageGenerator.grammah_return retval = new StageGenerator.grammah_return();
        retval.start = input.LT(1);

        CommonTree IDENTIFIER2=null;

        try {
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:49:3: ( ^( GRAMMAR IDENTIFIER ) -> {%{((CommonTree) $IDENTIFIER).getText()}})
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:49:5: ^( GRAMMAR IDENTIFIER )
            {
            match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammah264); 

            match(input, Token.DOWN, null); 
            IDENTIFIER2=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_grammah266); 

            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 51:5: -> {%{((CommonTree) $IDENTIFIER).getText()}}
            {
                retval.st = new StringTemplate(templateLib,((CommonTree) IDENTIFIER2).getText());
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
    // $ANTLR end "grammah"

    public static class tokenizer_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "tokenizer"
    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:54:1: tokenizer : ^( TOKENIZER IDENTIFIER ) -> {%{((CommonTree) $IDENTIFIER).getText()}};
    public final StageGenerator.tokenizer_return tokenizer() throws RecognitionException {
        StageGenerator.tokenizer_return retval = new StageGenerator.tokenizer_return();
        retval.start = input.LT(1);

        CommonTree IDENTIFIER3=null;

        try {
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:55:3: ( ^( TOKENIZER IDENTIFIER ) -> {%{((CommonTree) $IDENTIFIER).getText()}})
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:55:5: ^( TOKENIZER IDENTIFIER )
            {
            match(input,TOKENIZER,FOLLOW_TOKENIZER_in_tokenizer294); 

            match(input, Token.DOWN, null); 
            IDENTIFIER3=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_tokenizer296); 

            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 57:5: -> {%{((CommonTree) $IDENTIFIER).getText()}}
            {
                retval.st = new StringTemplate(templateLib,((CommonTree) IDENTIFIER3).getText());
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
    // $ANTLR end "tokenizer"

    public static class testsForGrammarRule_return extends TreeRuleReturnScope {
        public List<StringTemplate> tests = new LinkedList<StringTemplate>();
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "testsForGrammarRule"
    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:60:1: testsForGrammarRule returns [List<StringTemplate> tests = new LinkedList<StringTemplate>()] : ^( TARGET i= IDENTIFIER (t= test[((CommonTree) $i).getText()] )* ) ;
    public final StageGenerator.testsForGrammarRule_return testsForGrammarRule() throws RecognitionException {
        StageGenerator.testsForGrammarRule_return retval = new StageGenerator.testsForGrammarRule_return();
        retval.start = input.LT(1);

        CommonTree i=null;
        StageGenerator.test_return t = null;


        try {
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:61:3: ( ^( TARGET i= IDENTIFIER (t= test[((CommonTree) $i).getText()] )* ) )
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:61:5: ^( TARGET i= IDENTIFIER (t= test[((CommonTree) $i).getText()] )* )
            {
            match(input,TARGET,FOLLOW_TARGET_in_testsForGrammarRule326); 

            match(input, Token.DOWN, null); 
            i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_testsForGrammarRule330); 
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:62:8: (t= test[((CommonTree) $i).getText()] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==TEST) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:62:10: t= test[((CommonTree) $i).getText()]
            	    {
            	    pushFollow(FOLLOW_test_in_testsForGrammarRule343);
            	    t=test(((CommonTree) i).getText());

            	    state._fsp--;

            	     retval.tests.add((t!=null?t.st:null)); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
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
    // $ANTLR end "testsForGrammarRule"

    public static class test_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "test"
    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:68:1: test[String target] : ^( TEST ( ACCEPT | REJECT ) DATA ) -> {accept}? accept(name=namenumber=++counttarget=targettoken=data) -> reject(name=namenumber=++counttarget=targettoken=data);
    public final StageGenerator.test_return test(String target) throws RecognitionException {
        StageGenerator.test_return retval = new StageGenerator.test_return();
        retval.start = input.LT(1);

        CommonTree DATA4=null;

        try {
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:69:3: ( ^( TEST ( ACCEPT | REJECT ) DATA ) -> {accept}? accept(name=namenumber=++counttarget=targettoken=data) -> reject(name=namenumber=++counttarget=targettoken=data))
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:69:5: ^( TEST ( ACCEPT | REJECT ) DATA )
            {
            match(input,TEST,FOLLOW_TEST_in_test389); 

             boolean accept = true;
                    String data = ""; 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:73:7: ( ACCEPT | REJECT )
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
                    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:73:9: ACCEPT
                    {
                    match(input,ACCEPT,FOLLOW_ACCEPT_in_test414); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:74:9: REJECT
                    {
                    match(input,REJECT,FOLLOW_REJECT_in_test424); 
                     accept = false; 

                    }
                    break;

            }

            DATA4=(CommonTree)match(input,DATA,FOLLOW_DATA_in_test449); 
             data = ((CommonTree) DATA4).getText(); 

            match(input, Token.UP, null); 
             String name = target.substring(1);
                  name = Character.toUpperCase(target.charAt(0)) + name;
                
                  data = data.substring(1, data.length() - 1);
                  // data = data.replaceAll("\u2022", "\\\\u2022");
                  data = data.replaceAll("\n", "\\\\n");
                  data = data.replaceAll("\"", "\\\\\"");
                


            // TEMPLATE REWRITE
            // 89:5: -> {accept}? accept(name=namenumber=++counttarget=targettoken=data)
            if (accept) {
                retval.st = templateLib.getInstanceOf("accept",
              new STAttrMap().put("name", name).put("number", ++count).put("target", target).put("token", data));
            }
            else // 96:5: -> reject(name=namenumber=++counttarget=targettoken=data)
            {
                retval.st = templateLib.getInstanceOf("reject",
              new STAttrMap().put("name", name).put("number", ++count).put("target", target).put("token", data));
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
    // $ANTLR end "test"

    // Delegated rules


 

    public static final BitSet FOLLOW_STAGE_in_stage77 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_pack_in_stage81 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_grammah_in_stage85 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_tokenizer_in_stage89 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_testsForGrammarRule_in_stage100 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_PACKAGE_in_pack236 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_pack238 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GRAMMAR_in_grammah264 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_grammah266 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TOKENIZER_in_tokenizer294 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_tokenizer296 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TARGET_in_testsForGrammarRule326 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_testsForGrammarRule330 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_test_in_testsForGrammarRule343 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_TEST_in_test389 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACCEPT_in_test414 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_REJECT_in_test424 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DATA_in_test449 = new BitSet(new long[]{0x0000000000000008L});

}