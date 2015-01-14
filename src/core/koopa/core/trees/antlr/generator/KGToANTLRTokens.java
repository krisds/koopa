// $ANTLR 3.1.1 src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g 2015-01-14 19:05:40

  package koopa.core.trees.antlr.generator;
  
  import koopa.core.trees.antlr.ANTLRNaming;
  import koopa.core.trees.antlr.ANTLRTokensLoader;
  import koopa.core.trees.antlr.ANTLRTokens;
  
  import java.util.Set;
  import java.util.HashSet;
  import java.util.Map;
  import java.util.HashMap;
  
  import java.io.File;
  import java.io.IOException;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class KGToANTLRTokens extends TreeParser {
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


        public KGToANTLRTokens(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public KGToANTLRTokens(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return KGToANTLRTokens.tokenNames; }
    public String getGrammarFileName() { return "src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g"; }


      private ANTLRTokens numbers = new ANTLRTokens();
      private int count = 14;
      private File path = null;

      public void node(String text) {
        text = ANTLRNaming.forNode(text);
        if (!numbers.contains(text))
          numbers.put(text, count++, false);
      }

      public void token(String text) {
        text = ANTLRNaming.forLiteral(text);
        if (!numbers.contains(text))
          numbers.put(text, count++, true);
      }
      
      public ANTLRTokens getTokenTypes() {
        if (!numbers.contains("TOKEN"))
          numbers.put("TOKEN", 11, false);
        
        if (!numbers.contains("WATER"))
          numbers.put("WATER", 12, false);
        
        if (!numbers.contains("COMMENT"))
          numbers.put("COMMENT", 13, false);
        
        return numbers;
      }
      
      public void setPath(File path) {
      	this.path = path;
      }
      
      private void loadTokensForBaseGrammar(String name) {
        try {
          File tokensFile = new File(path, name + ".tokens");
          if (!tokensFile.exists()) {
            System.out.println("Found no tokens for base grammar!");
            return;
          }
          
    	  System.out.println("Loading tokens for base grammar: " + name);
          ANTLRTokensLoader.loadFile(new File(path, name + ".tokens"), numbers);
    	  count = numbers.getMaxValue() + 1;
    	  
    	} catch (IOException e) {
    	  e.printStackTrace();
    	}
      }



    // $ANTLR start "koopa"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:78:1: koopa : ^( GRAMMAR meta ( rule )* ) ;
    public final void koopa() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:79:3: ( ^( GRAMMAR meta ( rule )* ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:79:5: ^( GRAMMAR meta ( rule )* )
            {
            match(input,GRAMMAR,FOLLOW_GRAMMAR_in_koopa66); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_meta_in_koopa68);
            meta();

            state._fsp--;

            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:79:20: ( rule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:79:20: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_koopa70);
            	    rule();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
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
        return ;
    }
    // $ANTLR end "koopa"


    // $ANTLR start "meta"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:82:1: meta : ^( META named ( extending )? ) ;
    public final void meta() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:83:3: ( ^( META named ( extending )? ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:83:5: ^( META named ( extending )? )
            {
            match(input,META,FOLLOW_META_in_meta86); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_named_in_meta88);
            named();

            state._fsp--;

            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:83:18: ( extending )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==EXTENDING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:83:18: extending
                    {
                    pushFollow(FOLLOW_extending_in_meta90);
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
        return ;
    }
    // $ANTLR end "meta"


    // $ANTLR start "named"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:86:1: named : ^( NAMED IDENTIFIER ) ;
    public final void named() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:87:3: ( ^( NAMED IDENTIFIER ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:87:5: ^( NAMED IDENTIFIER )
            {
            match(input,NAMED,FOLLOW_NAMED_in_named106); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_named108); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "named"


    // $ANTLR start "extending"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:90:1: extending : ^( EXTENDING i= IDENTIFIER ) ;
    public final void extending() throws RecognitionException {
        CommonTree i=null;

        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:91:3: ( ^( EXTENDING i= IDENTIFIER ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:91:5: ^( EXTENDING i= IDENTIFIER )
            {
            match(input,EXTENDING,FOLLOW_EXTENDING_in_extending123); 

            match(input, Token.DOWN, null); 
            i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_extending127); 

            match(input, Token.UP, null); 
             loadTokensForBaseGrammar( ((CommonTree) i).getText() ); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "extending"


    // $ANTLR start "rule"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:96:1: rule : ^( RULE i= IDENTIFIER ( locals )? ( returning )? body ) ;
    public final void rule() throws RecognitionException {
        CommonTree i=null;

        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:97:3: ( ^( RULE i= IDENTIFIER ( locals )? ( returning )? body ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:97:5: ^( RULE i= IDENTIFIER ( locals )? ( returning )? body )
            {
            match(input,RULE,FOLLOW_RULE_in_rule151); 

            match(input, Token.DOWN, null); 
            i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule155); 
             node(((CommonTree) i).getText()); 
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:98:7: ( locals )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LOCALS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:98:7: locals
                    {
                    pushFollow(FOLLOW_locals_in_rule167);
                    locals();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:99:7: ( returning )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RETURNS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:99:7: returning
                    {
                    pushFollow(FOLLOW_returning_in_rule176);
                    returning();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_body_in_rule185);
            body();

            state._fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "rule"


    // $ANTLR start "returning"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:104:1: returning : ^( RETURNS IDENTIFIER ) ;
    public final void returning() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:105:3: ( ^( RETURNS IDENTIFIER ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:105:5: ^( RETURNS IDENTIFIER )
            {
            match(input,RETURNS,FOLLOW_RETURNS_in_returning205); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_returning207); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "returning"


    // $ANTLR start "locals"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:108:1: locals : ^( LOCALS ( declaration )+ ) ;
    public final void locals() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:109:3: ( ^( LOCALS ( declaration )+ ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:109:5: ^( LOCALS ( declaration )+ )
            {
            match(input,LOCALS,FOLLOW_LOCALS_in_locals224); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:110:7: ( declaration )+
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
            	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:110:7: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_locals232);
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
        return ;
    }
    // $ANTLR end "locals"


    // $ANTLR start "declaration"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:114:1: declaration : ^( DECLARATION IDENTIFIER IDENTIFIER ) ;
    public final void declaration() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:115:3: ( ^( DECLARATION IDENTIFIER IDENTIFIER ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:115:5: ^( DECLARATION IDENTIFIER IDENTIFIER )
            {
            match(input,DECLARATION,FOLLOW_DECLARATION_in_declaration253); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration255); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration257); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "declaration"


    // $ANTLR start "body"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:118:1: body : ( ^( SEQUENCE ( body )+ ) | ^( ACT NATIVE_CODE ) | TAG | ANY | i= IDENTIFIER | l= LITERAL | n= NUMBER | DOT | ^( ASSIGN IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT | a= ANY ) ) | ^( STAR body ) | ^( PLUS body ) | ^( CHOICE ( body )+ ) | ^( OPTIONAL body ) | ^( SKIP_TO body ) | ^( PERMUTED ( body )+ ) | ^( NOT body ) | ^( NOSKIP body ) );
    public final void body() throws RecognitionException {
        CommonTree i=null;
        CommonTree l=null;
        CommonTree n=null;
        CommonTree d=null;
        CommonTree a=null;

        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:119:3: ( ^( SEQUENCE ( body )+ ) | ^( ACT NATIVE_CODE ) | TAG | ANY | i= IDENTIFIER | l= LITERAL | n= NUMBER | DOT | ^( ASSIGN IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT | a= ANY ) ) | ^( STAR body ) | ^( PLUS body ) | ^( CHOICE ( body )+ ) | ^( OPTIONAL body ) | ^( SKIP_TO body ) | ^( PERMUTED ( body )+ ) | ^( NOT body ) | ^( NOSKIP body ) )
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
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:119:5: ^( SEQUENCE ( body )+ )
                    {
                    match(input,SEQUENCE,FOLLOW_SEQUENCE_in_body272); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:120:7: ( body )+
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
                    	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:120:7: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_body281);
                    	    body();

                    	    state._fsp--;


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

                    }
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:123:5: ^( ACT NATIVE_CODE )
                    {
                    match(input,ACT,FOLLOW_ACT_in_body298); 

                    match(input, Token.DOWN, null); 
                    match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_body300); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:125:5: TAG
                    {
                    match(input,TAG,FOLLOW_TAG_in_body312); 

                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:127:5: ANY
                    {
                    match(input,ANY,FOLLOW_ANY_in_body319); 

                    }
                    break;
                case 5 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:129:5: i= IDENTIFIER
                    {
                    i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body328); 
                     String text = ((CommonTree) i).getText();
                          if (Character.isUpperCase(text.charAt(0))) {
                            token(text);
                          }
                        

                    }
                    break;
                case 6 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:136:5: l= LITERAL
                    {
                    l=(CommonTree)match(input,LITERAL,FOLLOW_LITERAL_in_body345); 
                     String text = ((CommonTree) l).getText();
                          text = text.substring(1, text.length() - 1);
                          token(text);
                        

                    }
                    break;
                case 7 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:142:5: n= NUMBER
                    {
                    n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body362); 
                     token(((CommonTree) n).getText()); 

                    }
                    break;
                case 8 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:145:5: DOT
                    {
                    match(input,DOT,FOLLOW_DOT_in_body377); 
                     token("."); 

                    }
                    break;
                case 9 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:148:5: ^( ASSIGN IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT | a= ANY ) )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_body393); 

                    match(input, Token.DOWN, null); 
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body395); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:148:25: (i= IDENTIFIER | n= NUMBER | d= DOT | a= ANY )
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
                            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:148:26: i= IDENTIFIER
                            {
                            i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body400); 

                            }
                            break;
                        case 2 :
                            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:148:41: n= NUMBER
                            {
                            n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body406); 

                            }
                            break;
                        case 3 :
                            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:148:52: d= DOT
                            {
                            d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body412); 

                            }
                            break;
                        case 4 :
                            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:148:60: a= ANY
                            {
                            a=(CommonTree)match(input,ANY,FOLLOW_ANY_in_body418); 

                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                     if (i != null) {
                            String text = ((CommonTree) i).getText();
                            if (Character.isUpperCase(text.charAt(0))) {
                              token(text);
                            }
                          
                          } else if (n != null) {
                            token(((CommonTree) n).getText());

                          } else if (d != null) {
                            token(".");
                          }
                        

                    }
                    break;
                case 10 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:163:5: ^( STAR body )
                    {
                    match(input,STAR,FOLLOW_STAR_in_body436); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body438);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 11 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:165:5: ^( PLUS body )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_body449); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body451);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 12 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:167:5: ^( CHOICE ( body )+ )
                    {
                    match(input,CHOICE,FOLLOW_CHOICE_in_body462); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:168:7: ( body )+
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
                    	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:168:7: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_body470);
                    	    body();

                    	    state._fsp--;


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

                    }
                    break;
                case 13 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:171:5: ^( OPTIONAL body )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_body489); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body497);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 14 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:175:5: ^( SKIP_TO body )
                    {
                    match(input,SKIP_TO,FOLLOW_SKIP_TO_in_body513); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body521);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 15 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:179:5: ^( PERMUTED ( body )+ )
                    {
                    match(input,PERMUTED,FOLLOW_PERMUTED_in_body537); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:180:7: ( body )+
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
                    	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:180:7: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_body546);
                    	    body();

                    	    state._fsp--;


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

                    }
                    break;
                case 16 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:183:5: ^( NOT body )
                    {
                    match(input,NOT,FOLLOW_NOT_in_body563); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body565);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 17 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:185:5: ^( NOSKIP body )
                    {
                    match(input,NOSKIP,FOLLOW_NOSKIP_in_body576); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body578);
                    body();

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
        }
        return ;
    }
    // $ANTLR end "body"

    // Delegated rules


 

    public static final BitSet FOLLOW_GRAMMAR_in_koopa66 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_meta_in_koopa68 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_rule_in_koopa70 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_META_in_meta86 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_named_in_meta88 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_extending_in_meta90 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NAMED_in_named106 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_named108 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXTENDING_in_extending123 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_extending127 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_in_rule151 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule155 = new BitSet(new long[]{0x00000034FC1EFC00L});
    public static final BitSet FOLLOW_locals_in_rule167 = new BitSet(new long[]{0x00000034FC1EFC00L});
    public static final BitSet FOLLOW_returning_in_rule176 = new BitSet(new long[]{0x00000034FC1EFC00L});
    public static final BitSet FOLLOW_body_in_rule185 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURNS_in_returning205 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_returning207 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOCALS_in_locals224 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaration_in_locals232 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_DECLARATION_in_declaration253 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration255 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration257 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEQUENCE_in_body272 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body281 = new BitSet(new long[]{0x00000034FC1EFC08L});
    public static final BitSet FOLLOW_ACT_in_body298 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NATIVE_CODE_in_body300 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TAG_in_body312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANY_in_body319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_body345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_body362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_body377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_body393 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body395 = new BitSet(new long[]{0x0000000028180000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body400 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NUMBER_in_body406 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_body412 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ANY_in_body418 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_body436 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body438 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_body449 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body451 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHOICE_in_body462 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body470 = new BitSet(new long[]{0x00000034FC1EFC08L});
    public static final BitSet FOLLOW_OPTIONAL_in_body489 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body497 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SKIP_TO_in_body513 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body521 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERMUTED_in_body537 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body546 = new BitSet(new long[]{0x00000034FC1EFC08L});
    public static final BitSet FOLLOW_NOT_in_body563 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body565 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOSKIP_in_body576 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body578 = new BitSet(new long[]{0x0000000000000008L});

}