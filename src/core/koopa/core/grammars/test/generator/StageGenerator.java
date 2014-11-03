// $ANTLR 3.1.1 src/core/koopa/core/grammars/test/generator/StageGenerator.g 2014-11-03 08:19:43

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STAGE", "GRAMMAR", "PACKAGE", "TARGET", "TEST", "IDENTIFIER", "SEMI", "ACCEPT", "REJECT", "FREE_DATA", "FIXED_DATA", "COMMENT", "NEWLINE", "WHITESPACE", "NAME", "LETTER", "NUMBER", "'grammar'", "'package'", "'target'"
    };
    public static final int PACKAGE=6;
    public static final int T__23=23;
    public static final int LETTER=19;
    public static final int STAGE=4;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int NUMBER=20;
    public static final int WHITESPACE=17;
    public static final int TARGET=7;
    public static final int EOF=-1;
    public static final int SEMI=10;
    public static final int ACCEPT=11;
    public static final int NAME=18;
    public static final int NEWLINE=16;
    public static final int FIXED_DATA=14;
    public static final int REJECT=12;
    public static final int IDENTIFIER=9;
    public static final int TEST=8;
    public static final int FREE_DATA=13;
    public static final int COMMENT=15;
    public static final int GRAMMAR=5;

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
    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:23:1: stage[String name] : ^( STAGE p= pack g= grammah (t= testsForGrammarRule )* ) -> stage(name=namedate=new Date()package=pgrammah=gtest=tests);
    public final StageGenerator.stage_return stage(String name) throws RecognitionException {
        StageGenerator.stage_return retval = new StageGenerator.stage_return();
        retval.start = input.LT(1);

        StageGenerator.pack_return p = null;

        StageGenerator.grammah_return g = null;

        StageGenerator.testsForGrammarRule_return t = null;


        try {
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:24:3: ( ^( STAGE p= pack g= grammah (t= testsForGrammarRule )* ) -> stage(name=namedate=new Date()package=pgrammah=gtest=tests))
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:24:5: ^( STAGE p= pack g= grammah (t= testsForGrammarRule )* )
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
            	    pushFollow(FOLLOW_testsForGrammarRule_in_stage97);
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
            // 32:5: -> stage(name=namedate=new Date()package=pgrammah=gtest=tests)
            {
                retval.st = templateLib.getInstanceOf("stage",
              new STAttrMap().put("name", name).put("date", new Date()).put("package", p).put("grammah", g).put("test", tests));
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
    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:41:1: pack : ^( PACKAGE IDENTIFIER ) -> {%{((CommonTree) $IDENTIFIER).getText()}};
    public final StageGenerator.pack_return pack() throws RecognitionException {
        StageGenerator.pack_return retval = new StageGenerator.pack_return();
        retval.start = input.LT(1);

        CommonTree IDENTIFIER1=null;

        try {
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:42:3: ( ^( PACKAGE IDENTIFIER ) -> {%{((CommonTree) $IDENTIFIER).getText()}})
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:42:5: ^( PACKAGE IDENTIFIER )
            {
            match(input,PACKAGE,FOLLOW_PACKAGE_in_pack220); 

            match(input, Token.DOWN, null); 
            IDENTIFIER1=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_pack222); 

            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 44:5: -> {%{((CommonTree) $IDENTIFIER).getText()}}
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
    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:47:1: grammah : ^( GRAMMAR IDENTIFIER ) -> {%{((CommonTree) $IDENTIFIER).getText()}};
    public final StageGenerator.grammah_return grammah() throws RecognitionException {
        StageGenerator.grammah_return retval = new StageGenerator.grammah_return();
        retval.start = input.LT(1);

        CommonTree IDENTIFIER2=null;

        try {
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:48:3: ( ^( GRAMMAR IDENTIFIER ) -> {%{((CommonTree) $IDENTIFIER).getText()}})
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:48:5: ^( GRAMMAR IDENTIFIER )
            {
            match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammah248); 

            match(input, Token.DOWN, null); 
            IDENTIFIER2=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_grammah250); 

            match(input, Token.UP, null); 


            // TEMPLATE REWRITE
            // 50:5: -> {%{((CommonTree) $IDENTIFIER).getText()}}
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

    public static class testsForGrammarRule_return extends TreeRuleReturnScope {
        public List<StringTemplate> tests = new LinkedList<StringTemplate>();
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "testsForGrammarRule"
    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:53:1: testsForGrammarRule returns [List<StringTemplate> tests = new LinkedList<StringTemplate>()] : ^( TARGET i= IDENTIFIER (t= test[((CommonTree) $i).getText()] )* ) ;
    public final StageGenerator.testsForGrammarRule_return testsForGrammarRule() throws RecognitionException {
        StageGenerator.testsForGrammarRule_return retval = new StageGenerator.testsForGrammarRule_return();
        retval.start = input.LT(1);

        CommonTree i=null;
        StageGenerator.test_return t = null;


        try {
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:54:3: ( ^( TARGET i= IDENTIFIER (t= test[((CommonTree) $i).getText()] )* ) )
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:54:5: ^( TARGET i= IDENTIFIER (t= test[((CommonTree) $i).getText()] )* )
            {
            match(input,TARGET,FOLLOW_TARGET_in_testsForGrammarRule280); 

            match(input, Token.DOWN, null); 
            i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_testsForGrammarRule284); 
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:55:8: (t= test[((CommonTree) $i).getText()] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==TEST) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:55:10: t= test[((CommonTree) $i).getText()]
            	    {
            	    pushFollow(FOLLOW_test_in_testsForGrammarRule297);
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
    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:61:1: test[String target] : ^( TEST ( ACCEPT | REJECT ) ( FREE_DATA | FIXED_DATA ) ) -> {accept}? accept(name=namenumber=++counttarget=targettoken=dataformat=free) -> reject(name=namenumber=++counttarget=targettoken=dataformat=free);
    public final StageGenerator.test_return test(String target) throws RecognitionException {
        StageGenerator.test_return retval = new StageGenerator.test_return();
        retval.start = input.LT(1);

        CommonTree FREE_DATA3=null;
        CommonTree FIXED_DATA4=null;

        try {
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:62:3: ( ^( TEST ( ACCEPT | REJECT ) ( FREE_DATA | FIXED_DATA ) ) -> {accept}? accept(name=namenumber=++counttarget=targettoken=dataformat=free) -> reject(name=namenumber=++counttarget=targettoken=dataformat=free))
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:62:5: ^( TEST ( ACCEPT | REJECT ) ( FREE_DATA | FIXED_DATA ) )
            {
            match(input,TEST,FOLLOW_TEST_in_test343); 

             boolean accept = true;
                    boolean free = true;
                    String data = ""; 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:67:7: ( ACCEPT | REJECT )
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
                    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:67:9: ACCEPT
                    {
                    match(input,ACCEPT,FOLLOW_ACCEPT_in_test368); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:68:9: REJECT
                    {
                    match(input,REJECT,FOLLOW_REJECT_in_test378); 
                     accept = false; 

                    }
                    break;

            }

            // src/core/koopa/core/grammars/test/generator/StageGenerator.g:71:7: ( FREE_DATA | FIXED_DATA )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==FREE_DATA) ) {
                alt4=1;
            }
            else if ( (LA4_0==FIXED_DATA) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:71:9: FREE_DATA
                    {
                    FREE_DATA3=(CommonTree)match(input,FREE_DATA,FOLLOW_FREE_DATA_in_test405); 
                     data = ((CommonTree) FREE_DATA3).getText(); 

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/grammars/test/generator/StageGenerator.g:74:9: FIXED_DATA
                    {
                    FIXED_DATA4=(CommonTree)match(input,FIXED_DATA,FOLLOW_FIXED_DATA_in_test432); 
                     data = ((CommonTree) FIXED_DATA4).getText();
                              free = false;
                            

                    }
                    break;

            }


            match(input, Token.UP, null); 
             String name = target.substring(1);
                  name = Character.toUpperCase(target.charAt(0)) + name;
                
             data = data.substring(1, data.length() - 1);
                  // data = data.replaceAll("\u2022", "\\\\u2022");
                  data = data.replaceAll("\n", "\\\\n");
                  data = data.replaceAll("\"", "\\\\\"");
                


            // TEMPLATE REWRITE
            // 91:5: -> {accept}? accept(name=namenumber=++counttarget=targettoken=dataformat=free)
            if (accept) {
                retval.st = templateLib.getInstanceOf("accept",
              new STAttrMap().put("name", name).put("number", ++count).put("target", target).put("token", data).put("format", free));
            }
            else // 99:5: -> reject(name=namenumber=++counttarget=targettoken=dataformat=free)
            {
                retval.st = templateLib.getInstanceOf("reject",
              new STAttrMap().put("name", name).put("number", ++count).put("target", target).put("token", data).put("format", free));
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
    public static final BitSet FOLLOW_pack_in_stage81 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_grammah_in_stage85 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_testsForGrammarRule_in_stage97 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_PACKAGE_in_pack220 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_pack222 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GRAMMAR_in_grammah248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_grammah250 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TARGET_in_testsForGrammarRule280 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_testsForGrammarRule284 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_test_in_testsForGrammarRule297 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_TEST_in_test343 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACCEPT_in_test368 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_REJECT_in_test378 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_FREE_DATA_in_test405 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIXED_DATA_in_test432 = new BitSet(new long[]{0x0000000000000008L});

}