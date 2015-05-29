// $ANTLR 3.5.2 src/core/koopa/core/grammars/generator/KG.g

  package koopa.core.grammars.generator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class KGLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public KGLexer() {} 
	public KGLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public KGLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "src/core/koopa/core/grammars/generator/KG.g"; }

	// $ANTLR start "T__58"
	public final void mT__58() throws RecognitionException {
		try {
			int _type = T__58;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:6:7: ( 'def' )
			// src/core/koopa/core/grammars/generator/KG.g:6:9: 'def'
			{
			match("def"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__58"

	// $ANTLR start "T__59"
	public final void mT__59() throws RecognitionException {
		try {
			int _type = T__59;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:7:7: ( 'end' )
			// src/core/koopa/core/grammars/generator/KG.g:7:9: 'end'
			{
			match("end"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__59"

	// $ANTLR start "T__60"
	public final void mT__60() throws RecognitionException {
		try {
			int _type = T__60;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:8:7: ( 'extends' )
			// src/core/koopa/core/grammars/generator/KG.g:8:9: 'extends'
			{
			match("extends"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__60"

	// $ANTLR start "T__61"
	public final void mT__61() throws RecognitionException {
		try {
			int _type = T__61;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:9:7: ( 'grammar' )
			// src/core/koopa/core/grammars/generator/KG.g:9:9: 'grammar'
			{
			match("grammar"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__61"

	// $ANTLR start "T__62"
	public final void mT__62() throws RecognitionException {
		try {
			int _type = T__62;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:10:7: ( 'returns' )
			// src/core/koopa/core/grammars/generator/KG.g:10:9: 'returns'
			{
			match("returns"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__62"

	// $ANTLR start "T__63"
	public final void mT__63() throws RecognitionException {
		try {
			int _type = T__63;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:11:7: ( 'tree' )
			// src/core/koopa/core/grammars/generator/KG.g:11:9: 'tree'
			{
			match("tree"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__63"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:218:9: ( '#' (~ ( '\\n' | '\\r' ) )* )
			// src/core/koopa/core/grammars/generator/KG.g:218:11: '#' (~ ( '\\n' | '\\r' ) )*
			{
			match('#'); if (state.failed) return;
			// src/core/koopa/core/grammars/generator/KG.g:218:15: (~ ( '\\n' | '\\r' ) )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			if ( state.backtracking==0 ) { _channel = HIDDEN; }
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:220:9: ( ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' ) )
			// src/core/koopa/core/grammars/generator/KG.g:220:11: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
			{
			// src/core/koopa/core/grammars/generator/KG.g:220:11: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
			int alt2=3;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='\r') ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1=='\n') && (synpred1_KG())) {
					alt2=1;
				}

			}
			else if ( (LA2_0=='\n') ) {
				alt2=3;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:220:13: ( '\\r\\n' )=> '\\r\\n'
					{
					match("\r\n"); if (state.failed) return;

					}
					break;
				case 2 :
					// src/core/koopa/core/grammars/generator/KG.g:220:34: '\\r'
					{
					match('\r'); if (state.failed) return;
					}
					break;
				case 3 :
					// src/core/koopa/core/grammars/generator/KG.g:220:41: '\\n'
					{
					match('\n'); if (state.failed) return;
					}
					break;

			}

			if ( state.backtracking==0 ) { _channel = HIDDEN; }
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "PRIVATE"
	public final void mPRIVATE() throws RecognitionException {
		try {
			int _type = PRIVATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:222:9: ( 'private' )
			// src/core/koopa/core/grammars/generator/KG.g:222:11: 'private'
			{
			match("private"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRIVATE"

	// $ANTLR start "PUBLIC"
	public final void mPUBLIC() throws RecognitionException {
		try {
			int _type = PUBLIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:223:9: ( 'public' )
			// src/core/koopa/core/grammars/generator/KG.g:223:11: 'public'
			{
			match("public"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PUBLIC"

	// $ANTLR start "NOSKIP"
	public final void mNOSKIP() throws RecognitionException {
		try {
			int _type = NOSKIP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:225:9: ( '%noskip' )
			// src/core/koopa/core/grammars/generator/KG.g:225:11: '%noskip'
			{
			match("%noskip"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOSKIP"

	// $ANTLR start "LIMIT"
	public final void mLIMIT() throws RecognitionException {
		try {
			int _type = LIMIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:226:9: ( '%limit' )
			// src/core/koopa/core/grammars/generator/KG.g:226:11: '%limit'
			{
			match("%limit"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LIMIT"

	// $ANTLR start "BY"
	public final void mBY() throws RecognitionException {
		try {
			int _type = BY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:227:9: ( '%by' )
			// src/core/koopa/core/grammars/generator/KG.g:227:11: '%by'
			{
			match("%by"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BY"

	// $ANTLR start "AS"
	public final void mAS() throws RecognitionException {
		try {
			int _type = AS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:228:9: ( '%as' )
			// src/core/koopa/core/grammars/generator/KG.g:228:11: '%as'
			{
			match("%as"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AS"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:229:9: ( '%not' )
			// src/core/koopa/core/grammars/generator/KG.g:229:11: '%not'
			{
			match("%not"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "ARROW"
	public final void mARROW() throws RecognitionException {
		try {
			int _type = ARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:231:9: ( '=>' )
			// src/core/koopa/core/grammars/generator/KG.g:231:11: '=>'
			{
			match("=>"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARROW"

	// $ANTLR start "TAG"
	public final void mTAG() throws RecognitionException {
		try {
			int _type = TAG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:233:5: ( '@' LETTER ( LETTER | DIGIT | '-' | '_' )* )
			// src/core/koopa/core/grammars/generator/KG.g:233:7: '@' LETTER ( LETTER | DIGIT | '-' | '_' )*
			{
			match('@'); if (state.failed) return;
			mLETTER(); if (state.failed) return;

			// src/core/koopa/core/grammars/generator/KG.g:233:18: ( LETTER | DIGIT | '-' | '_' )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='-'||(LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:
					{
					if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TAG"

	// $ANTLR start "ANY"
	public final void mANY() throws RecognitionException {
		try {
			int _type = ANY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:235:5: ( '_' )
			// src/core/koopa/core/grammars/generator/KG.g:235:7: '_'
			{
			match('_'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ANY"

	// $ANTLR start "IDENTIFIER"
	public final void mIDENTIFIER() throws RecognitionException {
		try {
			int _type = IDENTIFIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:237:12: ( LOWERCASE ( LETTER | DIGIT | '-' | '_' )* )
			// src/core/koopa/core/grammars/generator/KG.g:237:14: LOWERCASE ( LETTER | DIGIT | '-' | '_' )*
			{
			mLOWERCASE(); if (state.failed) return;

			// src/core/koopa/core/grammars/generator/KG.g:237:24: ( LETTER | DIGIT | '-' | '_' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='-'||(LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:
					{
					if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop4;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENTIFIER"

	// $ANTLR start "TOKEN"
	public final void mTOKEN() throws RecognitionException {
		try {
			int _type = TOKEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:238:12: ( UPPERCASE ( LETTER | DIGIT | '-' | '_' )* )
			// src/core/koopa/core/grammars/generator/KG.g:238:14: UPPERCASE ( LETTER | DIGIT | '-' | '_' )*
			{
			mUPPERCASE(); if (state.failed) return;

			// src/core/koopa/core/grammars/generator/KG.g:238:24: ( LETTER | DIGIT | '-' | '_' )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='-'||(LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:
					{
					if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop5;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TOKEN"

	// $ANTLR start "LITERAL"
	public final void mLITERAL() throws RecognitionException {
		try {
			int _type = LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:240:9: ( '\\'' (~ ( '\\'' | '\\n' | '\\r' ) )+ '\\'' )
			// src/core/koopa/core/grammars/generator/KG.g:240:11: '\\'' (~ ( '\\'' | '\\n' | '\\r' ) )+ '\\''
			{
			match('\''); if (state.failed) return;
			// src/core/koopa/core/grammars/generator/KG.g:240:16: (~ ( '\\'' | '\\n' | '\\r' ) )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\t')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '&')||(LA6_0 >= '(' && LA6_0 <= '\uFFFF')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			match('\''); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LITERAL"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:242:8: ( ( DIGIT )+ )
			// src/core/koopa/core/grammars/generator/KG.g:242:10: ( DIGIT )+
			{
			// src/core/koopa/core/grammars/generator/KG.g:242:10: ( DIGIT )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "WHITESPACE"
	public final void mWHITESPACE() throws RecognitionException {
		try {
			int _type = WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:244:12: ( ( ' ' | '\\t' )+ )
			// src/core/koopa/core/grammars/generator/KG.g:244:14: ( ' ' | '\\t' )+
			{
			// src/core/koopa/core/grammars/generator/KG.g:244:14: ( ' ' | '\\t' )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0=='\t'||LA8_0==' ') ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			if ( state.backtracking==0 ) { _channel = HIDDEN; }
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHITESPACE"

	// $ANTLR start "EQUALS"
	public final void mEQUALS() throws RecognitionException {
		try {
			int _type = EQUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:246:8: ( '=' )
			// src/core/koopa/core/grammars/generator/KG.g:246:10: '='
			{
			match('='); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUALS"

	// $ANTLR start "OPEN_PAREN"
	public final void mOPEN_PAREN() throws RecognitionException {
		try {
			int _type = OPEN_PAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:248:12: ( '(' )
			// src/core/koopa/core/grammars/generator/KG.g:248:14: '('
			{
			match('('); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPEN_PAREN"

	// $ANTLR start "CLOSE_PAREN"
	public final void mCLOSE_PAREN() throws RecognitionException {
		try {
			int _type = CLOSE_PAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:250:13: ( ')' )
			// src/core/koopa/core/grammars/generator/KG.g:250:15: ')'
			{
			match(')'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSE_PAREN"

	// $ANTLR start "OPEN_BRACKET"
	public final void mOPEN_BRACKET() throws RecognitionException {
		try {
			int _type = OPEN_BRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:252:14: ( '[' )
			// src/core/koopa/core/grammars/generator/KG.g:252:16: '['
			{
			match('['); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPEN_BRACKET"

	// $ANTLR start "CLOSE_BRACKET"
	public final void mCLOSE_BRACKET() throws RecognitionException {
		try {
			int _type = CLOSE_BRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:254:15: ( ']' )
			// src/core/koopa/core/grammars/generator/KG.g:254:17: ']'
			{
			match(']'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSE_BRACKET"

	// $ANTLR start "NATIVE_CODE"
	public final void mNATIVE_CODE() throws RecognitionException {
		try {
			int _type = NATIVE_CODE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:258:13: ( '{' (~ '}' )* '}' )
			// src/core/koopa/core/grammars/generator/KG.g:258:15: '{' (~ '}' )* '}'
			{
			match('{'); if (state.failed) return;
			// src/core/koopa/core/grammars/generator/KG.g:258:19: (~ '}' )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '\u0000' && LA9_0 <= '|')||(LA9_0 >= '~' && LA9_0 <= '\uFFFF')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// src/core/koopa/core/grammars/generator/KG.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '|')||(input.LA(1) >= '~' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop9;
				}
			}

			match('}'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NATIVE_CODE"

	// $ANTLR start "STAR"
	public final void mSTAR() throws RecognitionException {
		try {
			int _type = STAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:260:6: ( '*' )
			// src/core/koopa/core/grammars/generator/KG.g:260:8: '*'
			{
			match('*'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STAR"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:262:6: ( '+' )
			// src/core/koopa/core/grammars/generator/KG.g:262:8: '+'
			{
			match('+'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "WITH"
	public final void mWITH() throws RecognitionException {
		try {
			int _type = WITH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:264:6: ( '---' )
			// src/core/koopa/core/grammars/generator/KG.g:264:8: '---'
			{
			match("---"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WITH"

	// $ANTLR start "SKIP_TO"
	public final void mSKIP_TO() throws RecognitionException {
		try {
			int _type = SKIP_TO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:265:9: ( '-->' )
			// src/core/koopa/core/grammars/generator/KG.g:265:11: '-->'
			{
			match("-->"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SKIP_TO"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:267:5: ( '.' )
			// src/core/koopa/core/grammars/generator/KG.g:267:7: '.'
			{
			match('.'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "PIPE"
	public final void mPIPE() throws RecognitionException {
		try {
			int _type = PIPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:269:6: ( '|' )
			// src/core/koopa/core/grammars/generator/KG.g:269:8: '|'
			{
			match('|'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PIPE"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:271:7: ( ',' )
			// src/core/koopa/core/grammars/generator/KG.g:271:9: ','
			{
			match(','); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "BANG"
	public final void mBANG() throws RecognitionException {
		try {
			int _type = BANG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:273:6: ( '!' )
			// src/core/koopa/core/grammars/generator/KG.g:273:8: '!'
			{
			match('!'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BANG"

	// $ANTLR start "DOLLAR"
	public final void mDOLLAR() throws RecognitionException {
		try {
			int _type = DOLLAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/generator/KG.g:275:8: ( '$' )
			// src/core/koopa/core/grammars/generator/KG.g:275:10: '$'
			{
			match('$'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOLLAR"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/generator/KG.g:277:20: ( LOWERCASE | UPPERCASE )
			// src/core/koopa/core/grammars/generator/KG.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "LOWERCASE"
	public final void mLOWERCASE() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/generator/KG.g:278:20: ( 'a' .. 'z' )
			// src/core/koopa/core/grammars/generator/KG.g:
			{
			if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOWERCASE"

	// $ANTLR start "UPPERCASE"
	public final void mUPPERCASE() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/generator/KG.g:279:20: ( 'A' .. 'Z' )
			// src/core/koopa/core/grammars/generator/KG.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UPPERCASE"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/generator/KG.g:280:20: ( '0' .. '9' )
			// src/core/koopa/core/grammars/generator/KG.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	@Override
	public void mTokens() throws RecognitionException {
		// src/core/koopa/core/grammars/generator/KG.g:1:8: ( T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | COMMENT | NEWLINE | PRIVATE | PUBLIC | NOSKIP | LIMIT | BY | AS | NOT | ARROW | TAG | ANY | IDENTIFIER | TOKEN | LITERAL | NUMBER | WHITESPACE | EQUALS | OPEN_PAREN | CLOSE_PAREN | OPEN_BRACKET | CLOSE_BRACKET | NATIVE_CODE | STAR | PLUS | WITH | SKIP_TO | DOT | PIPE | COMMA | BANG | DOLLAR )
		int alt10=38;
		alt10 = dfa10.predict(input);
		switch (alt10) {
			case 1 :
				// src/core/koopa/core/grammars/generator/KG.g:1:10: T__58
				{
				mT__58(); if (state.failed) return;

				}
				break;
			case 2 :
				// src/core/koopa/core/grammars/generator/KG.g:1:16: T__59
				{
				mT__59(); if (state.failed) return;

				}
				break;
			case 3 :
				// src/core/koopa/core/grammars/generator/KG.g:1:22: T__60
				{
				mT__60(); if (state.failed) return;

				}
				break;
			case 4 :
				// src/core/koopa/core/grammars/generator/KG.g:1:28: T__61
				{
				mT__61(); if (state.failed) return;

				}
				break;
			case 5 :
				// src/core/koopa/core/grammars/generator/KG.g:1:34: T__62
				{
				mT__62(); if (state.failed) return;

				}
				break;
			case 6 :
				// src/core/koopa/core/grammars/generator/KG.g:1:40: T__63
				{
				mT__63(); if (state.failed) return;

				}
				break;
			case 7 :
				// src/core/koopa/core/grammars/generator/KG.g:1:46: COMMENT
				{
				mCOMMENT(); if (state.failed) return;

				}
				break;
			case 8 :
				// src/core/koopa/core/grammars/generator/KG.g:1:54: NEWLINE
				{
				mNEWLINE(); if (state.failed) return;

				}
				break;
			case 9 :
				// src/core/koopa/core/grammars/generator/KG.g:1:62: PRIVATE
				{
				mPRIVATE(); if (state.failed) return;

				}
				break;
			case 10 :
				// src/core/koopa/core/grammars/generator/KG.g:1:70: PUBLIC
				{
				mPUBLIC(); if (state.failed) return;

				}
				break;
			case 11 :
				// src/core/koopa/core/grammars/generator/KG.g:1:77: NOSKIP
				{
				mNOSKIP(); if (state.failed) return;

				}
				break;
			case 12 :
				// src/core/koopa/core/grammars/generator/KG.g:1:84: LIMIT
				{
				mLIMIT(); if (state.failed) return;

				}
				break;
			case 13 :
				// src/core/koopa/core/grammars/generator/KG.g:1:90: BY
				{
				mBY(); if (state.failed) return;

				}
				break;
			case 14 :
				// src/core/koopa/core/grammars/generator/KG.g:1:93: AS
				{
				mAS(); if (state.failed) return;

				}
				break;
			case 15 :
				// src/core/koopa/core/grammars/generator/KG.g:1:96: NOT
				{
				mNOT(); if (state.failed) return;

				}
				break;
			case 16 :
				// src/core/koopa/core/grammars/generator/KG.g:1:100: ARROW
				{
				mARROW(); if (state.failed) return;

				}
				break;
			case 17 :
				// src/core/koopa/core/grammars/generator/KG.g:1:106: TAG
				{
				mTAG(); if (state.failed) return;

				}
				break;
			case 18 :
				// src/core/koopa/core/grammars/generator/KG.g:1:110: ANY
				{
				mANY(); if (state.failed) return;

				}
				break;
			case 19 :
				// src/core/koopa/core/grammars/generator/KG.g:1:114: IDENTIFIER
				{
				mIDENTIFIER(); if (state.failed) return;

				}
				break;
			case 20 :
				// src/core/koopa/core/grammars/generator/KG.g:1:125: TOKEN
				{
				mTOKEN(); if (state.failed) return;

				}
				break;
			case 21 :
				// src/core/koopa/core/grammars/generator/KG.g:1:131: LITERAL
				{
				mLITERAL(); if (state.failed) return;

				}
				break;
			case 22 :
				// src/core/koopa/core/grammars/generator/KG.g:1:139: NUMBER
				{
				mNUMBER(); if (state.failed) return;

				}
				break;
			case 23 :
				// src/core/koopa/core/grammars/generator/KG.g:1:146: WHITESPACE
				{
				mWHITESPACE(); if (state.failed) return;

				}
				break;
			case 24 :
				// src/core/koopa/core/grammars/generator/KG.g:1:157: EQUALS
				{
				mEQUALS(); if (state.failed) return;

				}
				break;
			case 25 :
				// src/core/koopa/core/grammars/generator/KG.g:1:164: OPEN_PAREN
				{
				mOPEN_PAREN(); if (state.failed) return;

				}
				break;
			case 26 :
				// src/core/koopa/core/grammars/generator/KG.g:1:175: CLOSE_PAREN
				{
				mCLOSE_PAREN(); if (state.failed) return;

				}
				break;
			case 27 :
				// src/core/koopa/core/grammars/generator/KG.g:1:187: OPEN_BRACKET
				{
				mOPEN_BRACKET(); if (state.failed) return;

				}
				break;
			case 28 :
				// src/core/koopa/core/grammars/generator/KG.g:1:200: CLOSE_BRACKET
				{
				mCLOSE_BRACKET(); if (state.failed) return;

				}
				break;
			case 29 :
				// src/core/koopa/core/grammars/generator/KG.g:1:214: NATIVE_CODE
				{
				mNATIVE_CODE(); if (state.failed) return;

				}
				break;
			case 30 :
				// src/core/koopa/core/grammars/generator/KG.g:1:226: STAR
				{
				mSTAR(); if (state.failed) return;

				}
				break;
			case 31 :
				// src/core/koopa/core/grammars/generator/KG.g:1:231: PLUS
				{
				mPLUS(); if (state.failed) return;

				}
				break;
			case 32 :
				// src/core/koopa/core/grammars/generator/KG.g:1:236: WITH
				{
				mWITH(); if (state.failed) return;

				}
				break;
			case 33 :
				// src/core/koopa/core/grammars/generator/KG.g:1:241: SKIP_TO
				{
				mSKIP_TO(); if (state.failed) return;

				}
				break;
			case 34 :
				// src/core/koopa/core/grammars/generator/KG.g:1:249: DOT
				{
				mDOT(); if (state.failed) return;

				}
				break;
			case 35 :
				// src/core/koopa/core/grammars/generator/KG.g:1:253: PIPE
				{
				mPIPE(); if (state.failed) return;

				}
				break;
			case 36 :
				// src/core/koopa/core/grammars/generator/KG.g:1:258: COMMA
				{
				mCOMMA(); if (state.failed) return;

				}
				break;
			case 37 :
				// src/core/koopa/core/grammars/generator/KG.g:1:264: BANG
				{
				mBANG(); if (state.failed) return;

				}
				break;
			case 38 :
				// src/core/koopa/core/grammars/generator/KG.g:1:269: DOLLAR
				{
				mDOLLAR(); if (state.failed) return;

				}
				break;

		}
	}

	// $ANTLR start synpred1_KG
	public final void synpred1_KG_fragment() throws RecognitionException {
		// src/core/koopa/core/grammars/generator/KG.g:220:13: ( '\\r\\n' )
		// src/core/koopa/core/grammars/generator/KG.g:220:14: '\\r\\n'
		{
		match("\r\n"); if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_KG

	public final boolean synpred1_KG() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_KG_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA10 dfa10 = new DFA10(this);
	static final String DFA10_eotS =
		"\1\uffff\5\15\2\uffff\1\15\1\uffff\1\54\24\uffff\10\15\7\uffff\1\71\1"+
		"\72\6\15\5\uffff\3\15\1\106\2\15\2\uffff\3\15\1\uffff\6\15\1\122\1\123"+
		"\1\124\1\125\1\126\5\uffff";
	static final String DFA10_eofS =
		"\127\uffff";
	static final String DFA10_minS =
		"\1\11\1\145\1\156\1\162\1\145\1\162\2\uffff\1\162\1\141\1\76\16\uffff"+
		"\1\55\5\uffff\1\146\1\144\1\164\1\141\1\164\1\145\1\151\1\142\1\157\5"+
		"\uffff\3\55\1\145\1\155\1\165\1\145\1\166\1\154\1\163\4\uffff\1\156\1"+
		"\155\1\162\1\55\1\141\1\151\2\uffff\1\144\1\141\1\156\1\uffff\1\164\1"+
		"\143\1\163\1\162\1\163\1\145\5\55\5\uffff";
	static final String DFA10_maxS =
		"\1\174\1\145\1\170\1\162\1\145\1\162\2\uffff\1\165\1\156\1\76\16\uffff"+
		"\1\55\5\uffff\1\146\1\144\1\164\1\141\1\164\1\145\1\151\1\142\1\157\5"+
		"\uffff\1\76\2\172\1\145\1\155\1\165\1\145\1\166\1\154\1\164\4\uffff\1"+
		"\156\1\155\1\162\1\172\1\141\1\151\2\uffff\1\144\1\141\1\156\1\uffff\1"+
		"\164\1\143\1\163\1\162\1\163\1\145\5\172\5\uffff";
	static final String DFA10_acceptS =
		"\6\uffff\1\7\1\10\3\uffff\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\31\1\32"+
		"\1\33\1\34\1\35\1\36\1\37\1\uffff\1\42\1\43\1\44\1\45\1\46\11\uffff\1"+
		"\14\1\15\1\16\1\20\1\30\12\uffff\1\40\1\41\1\1\1\2\6\uffff\1\13\1\17\3"+
		"\uffff\1\6\13\uffff\1\12\1\3\1\4\1\5\1\11";
	static final String DFA10_specialS =
		"\127\uffff}>";
	static final String[] DFA10_transitionS = {
			"\1\21\1\7\2\uffff\1\7\22\uffff\1\21\1\35\1\uffff\1\6\1\36\1\11\1\uffff"+
			"\1\17\1\22\1\23\1\27\1\30\1\34\1\31\1\32\1\uffff\12\20\3\uffff\1\12\2"+
			"\uffff\1\13\32\16\1\24\1\uffff\1\25\1\uffff\1\14\1\uffff\3\15\1\1\1\2"+
			"\1\15\1\3\10\15\1\10\1\15\1\4\1\15\1\5\6\15\1\26\1\33",
			"\1\37",
			"\1\40\11\uffff\1\41",
			"\1\42",
			"\1\43",
			"\1\44",
			"",
			"",
			"\1\45\2\uffff\1\46",
			"\1\52\1\51\11\uffff\1\50\1\uffff\1\47",
			"\1\53",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\55",
			"",
			"",
			"",
			"",
			"",
			"\1\56",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"",
			"",
			"",
			"",
			"",
			"\1\67\20\uffff\1\70",
			"\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
			"\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101\1\102",
			"",
			"",
			"",
			"",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
			"\1\107",
			"\1\110",
			"",
			"",
			"\1\111",
			"\1\112",
			"\1\113",
			"",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\121",
			"\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
			"\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
			"\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
			"\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
			"\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
	static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
	static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
	static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
	static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
	static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
	static final short[][] DFA10_transition;

	static {
		int numStates = DFA10_transitionS.length;
		DFA10_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
		}
	}

	protected class DFA10 extends DFA {

		public DFA10(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 10;
			this.eot = DFA10_eot;
			this.eof = DFA10_eof;
			this.min = DFA10_min;
			this.max = DFA10_max;
			this.accept = DFA10_accept;
			this.special = DFA10_special;
			this.transition = DFA10_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | COMMENT | NEWLINE | PRIVATE | PUBLIC | NOSKIP | LIMIT | BY | AS | NOT | ARROW | TAG | ANY | IDENTIFIER | TOKEN | LITERAL | NUMBER | WHITESPACE | EQUALS | OPEN_PAREN | CLOSE_PAREN | OPEN_BRACKET | CLOSE_BRACKET | NATIVE_CODE | STAR | PLUS | WITH | SKIP_TO | DOT | PIPE | COMMA | BANG | DOLLAR );";
		}
	}

}
