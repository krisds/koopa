// $ANTLR 3.5.2 src/core/koopa/core/grammars/generator/KGTreeParser.g

  package koopa.core.grammars.generator;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class KGTreeParser extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACT", "ANY", "ARROW", "AS", "ASSIGN", 
		"BANG", "BODY", "BY", "CASE", "CHOICE", "CLOSE_BRACKET", "CLOSE_PAREN", 
		"COLON", "COMMA", "COMMENT", "DECLARATION", "DIGIT", "DISPATCHED", "DOLLAR", 
		"DOT", "EQUALS", "EXTENDING", "GRAMMAR", "IDENTIFIER", "LETTER", "LIMIT", 
		"LITERAL", "LOCALS", "LOWERCASE", "META", "NAMED", "NATIVE_CODE", "NEWLINE", 
		"NOSKIP", "NOT", "NUMBER", "OPEN_BRACKET", "OPEN_PAREN", "OPTIONAL", "PERMUTED", 
		"PIPE", "PLUS", "PRIVATE", "PUBLIC", "RETURNS", "RULE", "SEQUENCE", "SKIP_TO", 
		"STAR", "TAG", "TOKEN", "TREE", "UPPERCASE", "WHITESPACE", "WITH", "'def'", 
		"'end'", "'extends'", "'grammar'", "'returns'", "'tree'"
	};
	public static final int EOF=-1;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int T__64=64;
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
	public static final int COLON=16;
	public static final int COMMA=17;
	public static final int COMMENT=18;
	public static final int DECLARATION=19;
	public static final int DIGIT=20;
	public static final int DISPATCHED=21;
	public static final int DOLLAR=22;
	public static final int DOT=23;
	public static final int EQUALS=24;
	public static final int EXTENDING=25;
	public static final int GRAMMAR=26;
	public static final int IDENTIFIER=27;
	public static final int LETTER=28;
	public static final int LIMIT=29;
	public static final int LITERAL=30;
	public static final int LOCALS=31;
	public static final int LOWERCASE=32;
	public static final int META=33;
	public static final int NAMED=34;
	public static final int NATIVE_CODE=35;
	public static final int NEWLINE=36;
	public static final int NOSKIP=37;
	public static final int NOT=38;
	public static final int NUMBER=39;
	public static final int OPEN_BRACKET=40;
	public static final int OPEN_PAREN=41;
	public static final int OPTIONAL=42;
	public static final int PERMUTED=43;
	public static final int PIPE=44;
	public static final int PLUS=45;
	public static final int PRIVATE=46;
	public static final int PUBLIC=47;
	public static final int RETURNS=48;
	public static final int RULE=49;
	public static final int SEQUENCE=50;
	public static final int SKIP_TO=51;
	public static final int STAR=52;
	public static final int TAG=53;
	public static final int TOKEN=54;
	public static final int TREE=55;
	public static final int UPPERCASE=56;
	public static final int WHITESPACE=57;
	public static final int WITH=58;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public KGTreeParser(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public KGTreeParser(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return KGTreeParser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/core/koopa/core/grammars/generator/KGTreeParser.g"; }





	// $ANTLR start "koopa"
	// src/core/koopa/core/grammars/generator/KGTreeParser.g:17:1: koopa : ^( GRAMMAR meta ( rule )* ) ;
	public final void koopa() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:18:3: ( ^( GRAMMAR meta ( rule )* ) )
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:18:5: ^( GRAMMAR meta ( rule )* )
			{
			match(input,GRAMMAR,FOLLOW_GRAMMAR_in_koopa66); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_meta_in_koopa68);
			meta();
			state._fsp--;

			// src/core/koopa/core/grammars/generator/KGTreeParser.g:18:20: ( rule )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==RULE) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:18:20: rule
					{
					pushFollow(FOLLOW_rule_in_koopa70);
					rule();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
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
	}
	// $ANTLR end "koopa"



	// $ANTLR start "meta"
	// src/core/koopa/core/grammars/generator/KGTreeParser.g:21:1: meta : ^( META ( TREE )? named ( extending )? ) ;
	public final void meta() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:22:3: ( ^( META ( TREE )? named ( extending )? ) )
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:22:5: ^( META ( TREE )? named ( extending )? )
			{
			match(input,META,FOLLOW_META_in_meta86); 
			match(input, Token.DOWN, null); 
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:22:12: ( TREE )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==TREE) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:22:12: TREE
					{
					match(input,TREE,FOLLOW_TREE_in_meta88); 
					}
					break;

			}

			pushFollow(FOLLOW_named_in_meta91);
			named();
			state._fsp--;

			// src/core/koopa/core/grammars/generator/KGTreeParser.g:22:24: ( extending )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==EXTENDING) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:22:24: extending
					{
					pushFollow(FOLLOW_extending_in_meta93);
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
			// do for sure before leaving
		}
	}
	// $ANTLR end "meta"



	// $ANTLR start "named"
	// src/core/koopa/core/grammars/generator/KGTreeParser.g:25:1: named : ^( NAMED IDENTIFIER ) ;
	public final void named() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:26:3: ( ^( NAMED IDENTIFIER ) )
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:26:5: ^( NAMED IDENTIFIER )
			{
			match(input,NAMED,FOLLOW_NAMED_in_named109); 
			match(input, Token.DOWN, null); 
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_named111); 
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
	}
	// $ANTLR end "named"



	// $ANTLR start "extending"
	// src/core/koopa/core/grammars/generator/KGTreeParser.g:29:1: extending : ^( EXTENDING IDENTIFIER ) ;
	public final void extending() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:30:3: ( ^( EXTENDING IDENTIFIER ) )
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:30:5: ^( EXTENDING IDENTIFIER )
			{
			match(input,EXTENDING,FOLLOW_EXTENDING_in_extending126); 
			match(input, Token.DOWN, null); 
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_extending128); 
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
	}
	// $ANTLR end "extending"



	// $ANTLR start "rule"
	// src/core/koopa/core/grammars/generator/KGTreeParser.g:33:1: rule : ^( RULE ( PUBLIC | PRIVATE ) IDENTIFIER ( locals )? ( returning )? body ) ;
	public final void rule() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:34:3: ( ^( RULE ( PUBLIC | PRIVATE ) IDENTIFIER ( locals )? ( returning )? body ) )
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:34:5: ^( RULE ( PUBLIC | PRIVATE ) IDENTIFIER ( locals )? ( returning )? body )
			{
			match(input,RULE,FOLLOW_RULE_in_rule143); 
			match(input, Token.DOWN, null); 
			if ( (input.LA(1) >= PRIVATE && input.LA(1) <= PUBLIC) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rule165); 
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:37:7: ( locals )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==LOCALS) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:37:7: locals
					{
					pushFollow(FOLLOW_locals_in_rule174);
					locals();
					state._fsp--;

					}
					break;

			}

			// src/core/koopa/core/grammars/generator/KGTreeParser.g:38:7: ( returning )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==RETURNS) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:38:7: returning
					{
					pushFollow(FOLLOW_returning_in_rule183);
					returning();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_body_in_rule192);
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
			// do for sure before leaving
		}
	}
	// $ANTLR end "rule"



	// $ANTLR start "returning"
	// src/core/koopa/core/grammars/generator/KGTreeParser.g:43:1: returning : ^( RETURNS IDENTIFIER ) ;
	public final void returning() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:44:3: ( ^( RETURNS IDENTIFIER ) )
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:44:5: ^( RETURNS IDENTIFIER )
			{
			match(input,RETURNS,FOLLOW_RETURNS_in_returning212); 
			match(input, Token.DOWN, null); 
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_returning214); 
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
	}
	// $ANTLR end "returning"



	// $ANTLR start "locals"
	// src/core/koopa/core/grammars/generator/KGTreeParser.g:47:1: locals : ^( LOCALS ( declaration )+ ) ;
	public final void locals() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:48:3: ( ^( LOCALS ( declaration )+ ) )
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:48:5: ^( LOCALS ( declaration )+ )
			{
			match(input,LOCALS,FOLLOW_LOCALS_in_locals231); 
			match(input, Token.DOWN, null); 
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:49:7: ( declaration )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==DECLARATION) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:49:7: declaration
					{
					pushFollow(FOLLOW_declaration_in_locals239);
					declaration();
					state._fsp--;

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

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "locals"



	// $ANTLR start "declaration"
	// src/core/koopa/core/grammars/generator/KGTreeParser.g:53:1: declaration : ^( DECLARATION IDENTIFIER IDENTIFIER ) ;
	public final void declaration() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:54:3: ( ^( DECLARATION IDENTIFIER IDENTIFIER ) )
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:54:5: ^( DECLARATION IDENTIFIER IDENTIFIER )
			{
			match(input,DECLARATION,FOLLOW_DECLARATION_in_declaration260); 
			match(input, Token.DOWN, null); 
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration262); 
			match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration264); 
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
	}
	// $ANTLR end "declaration"



	// $ANTLR start "body"
	// src/core/koopa/core/grammars/generator/KGTreeParser.g:57:1: body : ( ^( SEQUENCE ( body )+ ) | ^( ACT NATIVE_CODE ) | IDENTIFIER | TAG | ANY | LITERAL | NUMBER | DOT | ^( ASSIGN IDENTIFIER ( IDENTIFIER | NUMBER | DOT | ANY ) ) | ^( STAR body ) | ^( PLUS body ) | ^( CHOICE ( body )+ ) | ^( OPTIONAL body ) | ^( SKIP_TO body ) | ^( PERMUTED ( body )+ ) | ^( NOT body ) | ^( NOSKIP body ) | ^( LIMIT body body ) | ^( AS IDENTIFIER body ) );
	public final void body() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/generator/KGTreeParser.g:58:3: ( ^( SEQUENCE ( body )+ ) | ^( ACT NATIVE_CODE ) | IDENTIFIER | TAG | ANY | LITERAL | NUMBER | DOT | ^( ASSIGN IDENTIFIER ( IDENTIFIER | NUMBER | DOT | ANY ) ) | ^( STAR body ) | ^( PLUS body ) | ^( CHOICE ( body )+ ) | ^( OPTIONAL body ) | ^( SKIP_TO body ) | ^( PERMUTED ( body )+ ) | ^( NOT body ) | ^( NOSKIP body ) | ^( LIMIT body body ) | ^( AS IDENTIFIER body ) )
			int alt10=19;
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
			case IDENTIFIER:
				{
				alt10=3;
				}
				break;
			case TAG:
				{
				alt10=4;
				}
				break;
			case ANY:
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
			case LIMIT:
				{
				alt10=18;
				}
				break;
			case AS:
				{
				alt10=19;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:58:5: ^( SEQUENCE ( body )+ )
					{
					match(input,SEQUENCE,FOLLOW_SEQUENCE_in_body279); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:59:7: ( body )+
					int cnt7=0;
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( ((LA7_0 >= ACT && LA7_0 <= ANY)||(LA7_0 >= AS && LA7_0 <= ASSIGN)||LA7_0==CHOICE||LA7_0==DOT||LA7_0==IDENTIFIER||(LA7_0 >= LIMIT && LA7_0 <= LITERAL)||(LA7_0 >= NOSKIP && LA7_0 <= NUMBER)||(LA7_0 >= OPTIONAL && LA7_0 <= PERMUTED)||LA7_0==PLUS||(LA7_0 >= SEQUENCE && LA7_0 <= TAG)) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KGTreeParser.g:59:7: body
							{
							pushFollow(FOLLOW_body_in_body288);
							body();
							state._fsp--;

							}
							break;

						default :
							if ( cnt7 >= 1 ) break loop7;
							EarlyExitException eee = new EarlyExitException(7, input);
							throw eee;
						}
						cnt7++;
					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:62:5: ^( ACT NATIVE_CODE )
					{
					match(input,ACT,FOLLOW_ACT_in_body305); 
					match(input, Token.DOWN, null); 
					match(input,NATIVE_CODE,FOLLOW_NATIVE_CODE_in_body307); 
					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:64:5: IDENTIFIER
					{
					match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body319); 
					}
					break;
				case 4 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:66:5: TAG
					{
					match(input,TAG,FOLLOW_TAG_in_body328); 
					}
					break;
				case 5 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:68:5: ANY
					{
					match(input,ANY,FOLLOW_ANY_in_body335); 
					}
					break;
				case 6 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:70:5: LITERAL
					{
					match(input,LITERAL,FOLLOW_LITERAL_in_body342); 
					}
					break;
				case 7 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:72:5: NUMBER
					{
					match(input,NUMBER,FOLLOW_NUMBER_in_body351); 
					}
					break;
				case 8 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:74:5: DOT
					{
					match(input,DOT,FOLLOW_DOT_in_body360); 
					}
					break;
				case 9 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:76:5: ^( ASSIGN IDENTIFIER ( IDENTIFIER | NUMBER | DOT | ANY ) )
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_body370); 
					match(input, Token.DOWN, null); 
					match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body372); 
					if ( input.LA(1)==ANY||input.LA(1)==DOT||input.LA(1)==IDENTIFIER||input.LA(1)==NUMBER ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					match(input, Token.UP, null); 

					}
					break;
				case 10 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:78:5: ^( STAR body )
					{
					match(input,STAR,FOLLOW_STAR_in_body399); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body401);
					body();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 11 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:80:5: ^( PLUS body )
					{
					match(input,PLUS,FOLLOW_PLUS_in_body412); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body414);
					body();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 12 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:82:5: ^( CHOICE ( body )+ )
					{
					match(input,CHOICE,FOLLOW_CHOICE_in_body425); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:83:7: ( body )+
					int cnt8=0;
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( ((LA8_0 >= ACT && LA8_0 <= ANY)||(LA8_0 >= AS && LA8_0 <= ASSIGN)||LA8_0==CHOICE||LA8_0==DOT||LA8_0==IDENTIFIER||(LA8_0 >= LIMIT && LA8_0 <= LITERAL)||(LA8_0 >= NOSKIP && LA8_0 <= NUMBER)||(LA8_0 >= OPTIONAL && LA8_0 <= PERMUTED)||LA8_0==PLUS||(LA8_0 >= SEQUENCE && LA8_0 <= TAG)) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KGTreeParser.g:83:7: body
							{
							pushFollow(FOLLOW_body_in_body433);
							body();
							state._fsp--;

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
					break;
				case 13 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:86:5: ^( OPTIONAL body )
					{
					match(input,OPTIONAL,FOLLOW_OPTIONAL_in_body452); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body460);
					body();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 14 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:90:5: ^( SKIP_TO body )
					{
					match(input,SKIP_TO,FOLLOW_SKIP_TO_in_body476); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body484);
					body();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 15 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:94:5: ^( PERMUTED ( body )+ )
					{
					match(input,PERMUTED,FOLLOW_PERMUTED_in_body500); 
					match(input, Token.DOWN, null); 
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:95:7: ( body )+
					int cnt9=0;
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( ((LA9_0 >= ACT && LA9_0 <= ANY)||(LA9_0 >= AS && LA9_0 <= ASSIGN)||LA9_0==CHOICE||LA9_0==DOT||LA9_0==IDENTIFIER||(LA9_0 >= LIMIT && LA9_0 <= LITERAL)||(LA9_0 >= NOSKIP && LA9_0 <= NUMBER)||(LA9_0 >= OPTIONAL && LA9_0 <= PERMUTED)||LA9_0==PLUS||(LA9_0 >= SEQUENCE && LA9_0 <= TAG)) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// src/core/koopa/core/grammars/generator/KGTreeParser.g:95:7: body
							{
							pushFollow(FOLLOW_body_in_body509);
							body();
							state._fsp--;

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

					}
					break;
				case 16 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:98:5: ^( NOT body )
					{
					match(input,NOT,FOLLOW_NOT_in_body526); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body528);
					body();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 17 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:100:5: ^( NOSKIP body )
					{
					match(input,NOSKIP,FOLLOW_NOSKIP_in_body537); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body539);
					body();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 18 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:102:5: ^( LIMIT body body )
					{
					match(input,LIMIT,FOLLOW_LIMIT_in_body550); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_body_in_body552);
					body();
					state._fsp--;

					pushFollow(FOLLOW_body_in_body554);
					body();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;
				case 19 :
					// src/core/koopa/core/grammars/generator/KGTreeParser.g:104:5: ^( AS IDENTIFIER body )
					{
					match(input,AS,FOLLOW_AS_in_body563); 
					match(input, Token.DOWN, null); 
					match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_body565); 
					pushFollow(FOLLOW_body_in_body567);
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
			// do for sure before leaving
		}
	}
	// $ANTLR end "body"

	// Delegated rules



	public static final BitSet FOLLOW_GRAMMAR_in_koopa66 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_meta_in_koopa68 = new BitSet(new long[]{0x0002000000000008L});
	public static final BitSet FOLLOW_rule_in_koopa70 = new BitSet(new long[]{0x0002000000000008L});
	public static final BitSet FOLLOW_META_in_meta86 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TREE_in_meta88 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_named_in_meta91 = new BitSet(new long[]{0x0000000002000008L});
	public static final BitSet FOLLOW_extending_in_meta93 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NAMED_in_named109 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_named111 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EXTENDING_in_extending126 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_extending128 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RULE_in_rule143 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_set_in_rule151 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_rule165 = new BitSet(new long[]{0x003D2CE0E88021B0L});
	public static final BitSet FOLLOW_locals_in_rule174 = new BitSet(new long[]{0x003D2CE0688021B0L});
	public static final BitSet FOLLOW_returning_in_rule183 = new BitSet(new long[]{0x003C2CE0688021B0L});
	public static final BitSet FOLLOW_body_in_rule192 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURNS_in_returning212 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_returning214 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOCALS_in_locals231 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_locals239 = new BitSet(new long[]{0x0000000000080008L});
	public static final BitSet FOLLOW_DECLARATION_in_declaration260 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration262 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_declaration264 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SEQUENCE_in_body279 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body288 = new BitSet(new long[]{0x003C2CE0688021B8L});
	public static final BitSet FOLLOW_ACT_in_body305 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_NATIVE_CODE_in_body307 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body319 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TAG_in_body328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ANY_in_body335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LITERAL_in_body342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_body351 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_body360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_body370 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body372 = new BitSet(new long[]{0x0000008008800020L});
	public static final BitSet FOLLOW_set_in_body374 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STAR_in_body399 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body401 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_body412 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body414 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_CHOICE_in_body425 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body433 = new BitSet(new long[]{0x003C2CE0688021B8L});
	public static final BitSet FOLLOW_OPTIONAL_in_body452 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body460 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SKIP_TO_in_body476 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body484 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PERMUTED_in_body500 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body509 = new BitSet(new long[]{0x003C2CE0688021B8L});
	public static final BitSet FOLLOW_NOT_in_body526 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body528 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOSKIP_in_body537 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body539 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LIMIT_in_body550 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_body_in_body552 = new BitSet(new long[]{0x003C2CE0688021B0L});
	public static final BitSet FOLLOW_body_in_body554 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AS_in_body563 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENTIFIER_in_body565 = new BitSet(new long[]{0x003C2CE0688021B0L});
	public static final BitSet FOLLOW_body_in_body567 = new BitSet(new long[]{0x0000000000000008L});
}
