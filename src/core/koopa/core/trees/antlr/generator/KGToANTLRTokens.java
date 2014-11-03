// $ANTLR 3.1.1 src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g 2014-11-03 08:19:44

  package koopa.core.trees.antlr.generator;
  
  import koopa.core.trees.antlr.ANTLRNaming;
  import koopa.core.trees.antlr.TokenTypes;
  
  import java.util.Set;
  import java.util.HashSet;
  import java.util.Map;
  import java.util.HashMap;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class KGToANTLRTokens extends TreeParser {
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


        public KGToANTLRTokens(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public KGToANTLRTokens(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return KGToANTLRTokens.tokenNames; }
    public String getGrammarFileName() { return "src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g"; }


      private Set<String> tokens = new HashSet<String>();
      private TokenTypes numbers = new TokenTypes();
      private int count = 14;

      public void node(String text) {
        if (!tokens.contains(text)) {
          // System.out.println("node " + text + "=" + count);
          tokens.add(text);
          numbers.put(ANTLRNaming.forNode(text), count++, false);
        }
      }

      public void token(String text) {
        if (!tokens.contains(text)) {
          // System.out.println("token " + text + "=" + count);
          tokens.add(text);
          numbers.put(ANTLRNaming.forLiteral(text), count++, true);
        }
      }
      
      public TokenTypes getTokenTypes() {
        if (!numbers.contains("TOKEN")) {
          numbers.put("TOKEN", 11, false);
        }
        
        if (!numbers.contains("WATER")) {
          numbers.put("WATER", 12, false);
        }
        
        if (!numbers.contains("COMMENT")) {
          numbers.put("COMMENT", 13, false);
        }
        
        return numbers;
      }



    // $ANTLR start "koopa"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:60:1: koopa : ^( GRAMMAR ( rule )* ) ;
    public final void koopa() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:61:3: ( ^( GRAMMAR ( rule )* ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:61:5: ^( GRAMMAR ( rule )* )
            {
            match(input,GRAMMAR,FOLLOW_GRAMMAR_in_koopa66); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:61:15: ( rule )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:61:15: rule
                	    {
                	    pushFollow(FOLLOW_rule_in_koopa68);
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


    // $ANTLR start "rule"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:64:1: rule : ^( RULE i= IDENTIFIER ( locals )? ( returning )? body ) ;
    public final void rule() throws RecognitionException {
        CommonTree i=null;

        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:65:3: ( ^( RULE i= IDENTIFIER ( locals )? ( returning )? body ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:65:5: ^( RULE i= IDENTIFIER ( locals )? ( returning )? body )
            {
            match(input,RULE,FOLLOW_RULE_in_rule84); 

            match(input, Token.DOWN, null); 
            i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule88); 
             node(((CommonTree) i).getText()); 
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:66:7: ( locals )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==LOCALS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:66:7: locals
                    {
                    pushFollow(FOLLOW_locals_in_rule100);
                    locals();

                    state._fsp--;


                    }
                    break;

            }

            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:67:7: ( returning )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RETURNS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:67:7: returning
                    {
                    pushFollow(FOLLOW_returning_in_rule109);
                    returning();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_body_in_rule118);
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
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:72:1: returning : ^( RETURNS IDENTIFIER ) ;
    public final void returning() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:73:3: ( ^( RETURNS IDENTIFIER ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:73:5: ^( RETURNS IDENTIFIER )
            {
            match(input,RETURNS,FOLLOW_RETURNS_in_returning138); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_returning140); 

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
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:76:1: locals : ^( LOCALS ( declaration )+ ) ;
    public final void locals() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:77:3: ( ^( LOCALS ( declaration )+ ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:77:5: ^( LOCALS ( declaration )+ )
            {
            match(input,LOCALS,FOLLOW_LOCALS_in_locals157); 

            match(input, Token.DOWN, null); 
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:78:7: ( declaration )+
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
            	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:78:7: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_locals165);
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
        return ;
    }
    // $ANTLR end "locals"


    // $ANTLR start "declaration"
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:82:1: declaration : ^( DECLARATION IDENTIFIER IDENTIFIER ) ;
    public final void declaration() throws RecognitionException {
        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:83:3: ( ^( DECLARATION IDENTIFIER IDENTIFIER ) )
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:83:5: ^( DECLARATION IDENTIFIER IDENTIFIER )
            {
            match(input,DECLARATION,FOLLOW_DECLARATION_in_declaration186); 

            match(input, Token.DOWN, null); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration188); 
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration190); 

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
    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:86:1: body : ( ^( SEQUENCE ( body )+ ) | ^( ACT NATIVE_CODE ) | TAG | ANY | i= IDENTIFIER | l= LITERAL | n= NUMBER | DOT | ^( ASSIGN IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT ) ) | ^( STAR body ) | ^( PLUS body ) | ^( CHOICE ( body )+ ) | ^( OPTIONAL body ) | ^( SKIP_TO body ) | ^( PERMUTED ( body )+ ) | ^( NOT body ) | ^( NOSKIP body ) );
    public final void body() throws RecognitionException {
        CommonTree i=null;
        CommonTree l=null;
        CommonTree n=null;
        CommonTree d=null;

        try {
            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:87:3: ( ^( SEQUENCE ( body )+ ) | ^( ACT NATIVE_CODE ) | TAG | ANY | i= IDENTIFIER | l= LITERAL | n= NUMBER | DOT | ^( ASSIGN IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT ) ) | ^( STAR body ) | ^( PLUS body ) | ^( CHOICE ( body )+ ) | ^( OPTIONAL body ) | ^( SKIP_TO body ) | ^( PERMUTED ( body )+ ) | ^( NOT body ) | ^( NOSKIP body ) )
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
            case IDENTIFIER:
                {
                alt9=5;
                }
                break;
            case LITERAL:
                {
                alt9=6;
                }
                break;
            case NUMBER:
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
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:87:5: ^( SEQUENCE ( body )+ )
                    {
                    match(input,SEQUENCE,FOLLOW_SEQUENCE_in_body205); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:88:7: ( body )+
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
                    	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:88:7: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_body214);
                    	    body();

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
                    break;
                case 2 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:91:5: ^( ACT NATIVE_CODE )
                    {
                    match(input,ACT,FOLLOW_ACT_in_body231); 

                    match(input, Token.DOWN, null); 
                    match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_body233); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:93:5: TAG
                    {
                    match(input,TAG,FOLLOW_TAG_in_body245); 

                    }
                    break;
                case 4 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:95:5: ANY
                    {
                    match(input,ANY,FOLLOW_ANY_in_body252); 

                    }
                    break;
                case 5 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:97:5: i= IDENTIFIER
                    {
                    i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body261); 
                     String text = ((CommonTree) i).getText();
                          if (Character.isUpperCase(text.charAt(0))) {
                            token(text);
                          }
                        

                    }
                    break;
                case 6 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:104:5: l= LITERAL
                    {
                    l=(CommonTree)match(input,LITERAL,FOLLOW_LITERAL_in_body278); 
                     String text = ((CommonTree) l).getText();
                          text = text.substring(1, text.length() - 1);
                          token(text);
                        

                    }
                    break;
                case 7 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:110:5: n= NUMBER
                    {
                    n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body295); 
                     token(((CommonTree) n).getText()); 

                    }
                    break;
                case 8 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:113:5: DOT
                    {
                    match(input,DOT,FOLLOW_DOT_in_body310); 
                     token("."); 

                    }
                    break;
                case 9 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:116:5: ^( ASSIGN IDENTIFIER (i= IDENTIFIER | n= NUMBER | d= DOT ) )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_body326); 

                    match(input, Token.DOWN, null); 
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body328); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:116:25: (i= IDENTIFIER | n= NUMBER | d= DOT )
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
                            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:116:26: i= IDENTIFIER
                            {
                            i=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body333); 

                            }
                            break;
                        case 2 :
                            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:116:41: n= NUMBER
                            {
                            n=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_body339); 

                            }
                            break;
                        case 3 :
                            // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:116:52: d= DOT
                            {
                            d=(CommonTree)match(input,DOT,FOLLOW_DOT_in_body345); 

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

                          } else {
                            token(".");
                          }
                        

                    }
                    break;
                case 10 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:131:5: ^( STAR body )
                    {
                    match(input,STAR,FOLLOW_STAR_in_body363); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body365);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 11 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:133:5: ^( PLUS body )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_body376); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body378);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 12 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:135:5: ^( CHOICE ( body )+ )
                    {
                    match(input,CHOICE,FOLLOW_CHOICE_in_body389); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:136:7: ( body )+
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
                    	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:136:7: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_body397);
                    	    body();

                    	    state._fsp--;


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

                    }
                    break;
                case 13 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:139:5: ^( OPTIONAL body )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_body416); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body424);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 14 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:143:5: ^( SKIP_TO body )
                    {
                    match(input,SKIP_TO,FOLLOW_SKIP_TO_in_body440); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body448);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 15 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:147:5: ^( PERMUTED ( body )+ )
                    {
                    match(input,PERMUTED,FOLLOW_PERMUTED_in_body464); 

                    match(input, Token.DOWN, null); 
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:148:7: ( body )+
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
                    	    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:148:7: body
                    	    {
                    	    pushFollow(FOLLOW_body_in_body473);
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
                case 16 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:151:5: ^( NOT body )
                    {
                    match(input,NOT,FOLLOW_NOT_in_body490); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body492);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    }
                    break;
                case 17 :
                    // src/core/koopa/core/trees/antlr/generator/KGToANTLRTokens.g:153:5: ^( NOSKIP body )
                    {
                    match(input,NOSKIP,FOLLOW_NOSKIP_in_body503); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_body_in_body505);
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
    public static final BitSet FOLLOW_rule_in_koopa68 = new BitSet(new long[]{0x0000000000000028L});
    public static final BitSet FOLLOW_RULE_in_rule84 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rule88 = new BitSet(new long[]{0x000000069FC1DF80L});
    public static final BitSet FOLLOW_locals_in_rule100 = new BitSet(new long[]{0x000000069FC1DF80L});
    public static final BitSet FOLLOW_returning_in_rule109 = new BitSet(new long[]{0x000000069FC1DF80L});
    public static final BitSet FOLLOW_body_in_rule118 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURNS_in_returning138 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_returning140 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOCALS_in_locals157 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaration_in_locals165 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_DECLARATION_in_declaration186 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration188 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration190 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEQUENCE_in_body205 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body214 = new BitSet(new long[]{0x000000069FC1DF88L});
    public static final BitSet FOLLOW_ACT_in_body231 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NATIVE_CODE_in_body233 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TAG_in_body245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANY_in_body252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_body278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_body295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_body310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_body326 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body328 = new BitSet(new long[]{0x0000000006010000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_body333 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NUMBER_in_body339 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_body345 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_body363 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body365 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_body376 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body378 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHOICE_in_body389 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body397 = new BitSet(new long[]{0x000000069FC1DF88L});
    public static final BitSet FOLLOW_OPTIONAL_in_body416 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body424 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SKIP_TO_in_body440 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body448 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERMUTED_in_body464 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body473 = new BitSet(new long[]{0x000000069FC1DF88L});
    public static final BitSet FOLLOW_NOT_in_body490 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body492 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOSKIP_in_body503 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_body505 = new BitSet(new long[]{0x0000000000000008L});

}