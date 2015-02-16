// $ANTLR 3.5.2 src/core/koopa/core/grammars/test/generator/Stage.g

  package koopa.core.grammars.test.generator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class StageLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int ACCEPT=4;
	public static final int COMMENT=5;
	public static final int DATA=6;
	public static final int GRAMMAR=7;
	public static final int IDENTIFIER=8;
	public static final int LETTER=9;
	public static final int NAME=10;
	public static final int NEWLINE=11;
	public static final int NUMBER=12;
	public static final int PACKAGE=13;
	public static final int REJECT=14;
	public static final int SEMI=15;
	public static final int STAGE=16;
	public static final int TARGET=17;
	public static final int TEST=18;
	public static final int TOKENIZER=19;
	public static final int WHITESPACE=20;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public StageLexer() {} 
	public StageLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public StageLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "src/core/koopa/core/grammars/test/generator/Stage.g"; }

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/test/generator/Stage.g:6:7: ( 'grammar' )
			// src/core/koopa/core/grammars/test/generator/Stage.g:6:9: 'grammar'
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/test/generator/Stage.g:7:7: ( 'package' )
			// src/core/koopa/core/grammars/test/generator/Stage.g:7:9: 'package'
			{
			match("package"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/test/generator/Stage.g:8:7: ( 'target' )
			// src/core/koopa/core/grammars/test/generator/Stage.g:8:9: 'target'
			{
			match("target"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/test/generator/Stage.g:9:7: ( 'tokenizer' )
			// src/core/koopa/core/grammars/test/generator/Stage.g:9:9: 'tokenizer'
			{
			match("tokenizer"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/test/generator/Stage.g:66:9: ( '#' (~ ( '\\n' | '\\r' ) )* )
			// src/core/koopa/core/grammars/test/generator/Stage.g:66:11: '#' (~ ( '\\n' | '\\r' ) )*
			{
			match('#'); if (state.failed) return;
			// src/core/koopa/core/grammars/test/generator/Stage.g:66:15: (~ ( '\\n' | '\\r' ) )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/core/koopa/core/grammars/test/generator/Stage.g:
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
			// src/core/koopa/core/grammars/test/generator/Stage.g:68:9: ( ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' ) )
			// src/core/koopa/core/grammars/test/generator/Stage.g:68:11: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
			{
			// src/core/koopa/core/grammars/test/generator/Stage.g:68:11: ( ( '\\r\\n' )=> '\\r\\n' | '\\r' | '\\n' )
			int alt2=3;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='\r') ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1=='\n') && (synpred1_Stage())) {
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
					// src/core/koopa/core/grammars/test/generator/Stage.g:68:13: ( '\\r\\n' )=> '\\r\\n'
					{
					match("\r\n"); if (state.failed) return;

					}
					break;
				case 2 :
					// src/core/koopa/core/grammars/test/generator/Stage.g:68:34: '\\r'
					{
					match('\r'); if (state.failed) return;
					}
					break;
				case 3 :
					// src/core/koopa/core/grammars/test/generator/Stage.g:68:41: '\\n'
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

	// $ANTLR start "WHITESPACE"
	public final void mWHITESPACE() throws RecognitionException {
		try {
			int _type = WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/test/generator/Stage.g:70:12: ( ( ' ' | '\\t' )+ )
			// src/core/koopa/core/grammars/test/generator/Stage.g:70:14: ( ' ' | '\\t' )+
			{
			// src/core/koopa/core/grammars/test/generator/Stage.g:70:14: ( ' ' | '\\t' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='\t'||LA3_0==' ') ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// src/core/koopa/core/grammars/test/generator/Stage.g:
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
					if ( cnt3 >= 1 ) break loop3;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
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

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/test/generator/Stage.g:72:6: ( ';' )
			// src/core/koopa/core/grammars/test/generator/Stage.g:72:8: ';'
			{
			match(';'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "ACCEPT"
	public final void mACCEPT() throws RecognitionException {
		try {
			int _type = ACCEPT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/test/generator/Stage.g:74:8: ( '+' )
			// src/core/koopa/core/grammars/test/generator/Stage.g:74:10: '+'
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
	// $ANTLR end "ACCEPT"

	// $ANTLR start "REJECT"
	public final void mREJECT() throws RecognitionException {
		try {
			int _type = REJECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/test/generator/Stage.g:75:8: ( '-' )
			// src/core/koopa/core/grammars/test/generator/Stage.g:75:10: '-'
			{
			match('-'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REJECT"

	// $ANTLR start "DATA"
	public final void mDATA() throws RecognitionException {
		try {
			int _type = DATA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/test/generator/Stage.g:77:6: ( '[' (~ ( '[' | ']' ) )* ']' )
			// src/core/koopa/core/grammars/test/generator/Stage.g:77:8: '[' (~ ( '[' | ']' ) )* ']'
			{
			match('['); if (state.failed) return;
			// src/core/koopa/core/grammars/test/generator/Stage.g:77:12: (~ ( '[' | ']' ) )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\u0000' && LA4_0 <= 'Z')||LA4_0=='\\'||(LA4_0 >= '^' && LA4_0 <= '\uFFFF')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// src/core/koopa/core/grammars/test/generator/Stage.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= 'Z')||input.LA(1)=='\\'||(input.LA(1) >= '^' && input.LA(1) <= '\uFFFF') ) {
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

			match(']'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DATA"

	// $ANTLR start "IDENTIFIER"
	public final void mIDENTIFIER() throws RecognitionException {
		try {
			int _type = IDENTIFIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/core/koopa/core/grammars/test/generator/Stage.g:79:12: ( NAME ( '.' NAME )* )
			// src/core/koopa/core/grammars/test/generator/Stage.g:79:14: NAME ( '.' NAME )*
			{
			mNAME(); if (state.failed) return;

			// src/core/koopa/core/grammars/test/generator/Stage.g:79:19: ( '.' NAME )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='.') ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// src/core/koopa/core/grammars/test/generator/Stage.g:79:20: '.' NAME
					{
					match('.'); if (state.failed) return;
					mNAME(); if (state.failed) return;

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
	// $ANTLR end "IDENTIFIER"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/test/generator/Stage.g:81:15: ( LETTER ( '_' | LETTER | NUMBER )* )
			// src/core/koopa/core/grammars/test/generator/Stage.g:81:17: LETTER ( '_' | LETTER | NUMBER )*
			{
			mLETTER(); if (state.failed) return;

			// src/core/koopa/core/grammars/test/generator/Stage.g:81:24: ( '_' | LETTER | NUMBER )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// src/core/koopa/core/grammars/test/generator/Stage.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
					break loop6;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAME"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/test/generator/Stage.g:82:17: ( 'A' .. 'Z' | 'a' .. 'z' )
			// src/core/koopa/core/grammars/test/generator/Stage.g:
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

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			// src/core/koopa/core/grammars/test/generator/Stage.g:83:17: ( '0' .. '9' )
			// src/core/koopa/core/grammars/test/generator/Stage.g:
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
	// $ANTLR end "NUMBER"

	@Override
	public void mTokens() throws RecognitionException {
		// src/core/koopa/core/grammars/test/generator/Stage.g:1:8: ( T__21 | T__22 | T__23 | T__24 | COMMENT | NEWLINE | WHITESPACE | SEMI | ACCEPT | REJECT | DATA | IDENTIFIER )
		int alt7=12;
		switch ( input.LA(1) ) {
		case 'g':
			{
			int LA7_1 = input.LA(2);
			if ( (LA7_1=='r') ) {
				int LA7_12 = input.LA(3);
				if ( (LA7_12=='a') ) {
					int LA7_16 = input.LA(4);
					if ( (LA7_16=='m') ) {
						int LA7_20 = input.LA(5);
						if ( (LA7_20=='m') ) {
							int LA7_24 = input.LA(6);
							if ( (LA7_24=='a') ) {
								int LA7_28 = input.LA(7);
								if ( (LA7_28=='r') ) {
									int LA7_32 = input.LA(8);
									if ( (LA7_32=='.'||(LA7_32 >= '0' && LA7_32 <= '9')||(LA7_32 >= 'A' && LA7_32 <= 'Z')||LA7_32=='_'||(LA7_32 >= 'a' && LA7_32 <= 'z')) ) {
										alt7=12;
									}

									else {
										alt7=1;
									}

								}

								else {
									alt7=12;
								}

							}

							else {
								alt7=12;
							}

						}

						else {
							alt7=12;
						}

					}

					else {
						alt7=12;
					}

				}

				else {
					alt7=12;
				}

			}

			else {
				alt7=12;
			}

			}
			break;
		case 'p':
			{
			int LA7_2 = input.LA(2);
			if ( (LA7_2=='a') ) {
				int LA7_13 = input.LA(3);
				if ( (LA7_13=='c') ) {
					int LA7_17 = input.LA(4);
					if ( (LA7_17=='k') ) {
						int LA7_21 = input.LA(5);
						if ( (LA7_21=='a') ) {
							int LA7_25 = input.LA(6);
							if ( (LA7_25=='g') ) {
								int LA7_29 = input.LA(7);
								if ( (LA7_29=='e') ) {
									int LA7_33 = input.LA(8);
									if ( (LA7_33=='.'||(LA7_33 >= '0' && LA7_33 <= '9')||(LA7_33 >= 'A' && LA7_33 <= 'Z')||LA7_33=='_'||(LA7_33 >= 'a' && LA7_33 <= 'z')) ) {
										alt7=12;
									}

									else {
										alt7=2;
									}

								}

								else {
									alt7=12;
								}

							}

							else {
								alt7=12;
							}

						}

						else {
							alt7=12;
						}

					}

					else {
						alt7=12;
					}

				}

				else {
					alt7=12;
				}

			}

			else {
				alt7=12;
			}

			}
			break;
		case 't':
			{
			switch ( input.LA(2) ) {
			case 'a':
				{
				int LA7_14 = input.LA(3);
				if ( (LA7_14=='r') ) {
					int LA7_18 = input.LA(4);
					if ( (LA7_18=='g') ) {
						int LA7_22 = input.LA(5);
						if ( (LA7_22=='e') ) {
							int LA7_26 = input.LA(6);
							if ( (LA7_26=='t') ) {
								int LA7_30 = input.LA(7);
								if ( (LA7_30=='.'||(LA7_30 >= '0' && LA7_30 <= '9')||(LA7_30 >= 'A' && LA7_30 <= 'Z')||LA7_30=='_'||(LA7_30 >= 'a' && LA7_30 <= 'z')) ) {
									alt7=12;
								}

								else {
									alt7=3;
								}

							}

							else {
								alt7=12;
							}

						}

						else {
							alt7=12;
						}

					}

					else {
						alt7=12;
					}

				}

				else {
					alt7=12;
				}

				}
				break;
			case 'o':
				{
				int LA7_15 = input.LA(3);
				if ( (LA7_15=='k') ) {
					int LA7_19 = input.LA(4);
					if ( (LA7_19=='e') ) {
						int LA7_23 = input.LA(5);
						if ( (LA7_23=='n') ) {
							int LA7_27 = input.LA(6);
							if ( (LA7_27=='i') ) {
								int LA7_31 = input.LA(7);
								if ( (LA7_31=='z') ) {
									int LA7_35 = input.LA(8);
									if ( (LA7_35=='e') ) {
										int LA7_38 = input.LA(9);
										if ( (LA7_38=='r') ) {
											int LA7_39 = input.LA(10);
											if ( (LA7_39=='.'||(LA7_39 >= '0' && LA7_39 <= '9')||(LA7_39 >= 'A' && LA7_39 <= 'Z')||LA7_39=='_'||(LA7_39 >= 'a' && LA7_39 <= 'z')) ) {
												alt7=12;
											}

											else {
												alt7=4;
											}

										}

										else {
											alt7=12;
										}

									}

									else {
										alt7=12;
									}

								}

								else {
									alt7=12;
								}

							}

							else {
								alt7=12;
							}

						}

						else {
							alt7=12;
						}

					}

					else {
						alt7=12;
					}

				}

				else {
					alt7=12;
				}

				}
				break;
			default:
				alt7=12;
			}
			}
			break;
		case '#':
			{
			alt7=5;
			}
			break;
		case '\n':
		case '\r':
			{
			alt7=6;
			}
			break;
		case '\t':
		case ' ':
			{
			alt7=7;
			}
			break;
		case ';':
			{
			alt7=8;
			}
			break;
		case '+':
			{
			alt7=9;
			}
			break;
		case '-':
			{
			alt7=10;
			}
			break;
		case '[':
			{
			alt7=11;
			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'q':
		case 'r':
		case 's':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt7=12;
			}
			break;
		default:
			if (state.backtracking>0) {state.failed=true; return;}
			NoViableAltException nvae =
				new NoViableAltException("", 7, 0, input);
			throw nvae;
		}
		switch (alt7) {
			case 1 :
				// src/core/koopa/core/grammars/test/generator/Stage.g:1:10: T__21
				{
				mT__21(); if (state.failed) return;

				}
				break;
			case 2 :
				// src/core/koopa/core/grammars/test/generator/Stage.g:1:16: T__22
				{
				mT__22(); if (state.failed) return;

				}
				break;
			case 3 :
				// src/core/koopa/core/grammars/test/generator/Stage.g:1:22: T__23
				{
				mT__23(); if (state.failed) return;

				}
				break;
			case 4 :
				// src/core/koopa/core/grammars/test/generator/Stage.g:1:28: T__24
				{
				mT__24(); if (state.failed) return;

				}
				break;
			case 5 :
				// src/core/koopa/core/grammars/test/generator/Stage.g:1:34: COMMENT
				{
				mCOMMENT(); if (state.failed) return;

				}
				break;
			case 6 :
				// src/core/koopa/core/grammars/test/generator/Stage.g:1:42: NEWLINE
				{
				mNEWLINE(); if (state.failed) return;

				}
				break;
			case 7 :
				// src/core/koopa/core/grammars/test/generator/Stage.g:1:50: WHITESPACE
				{
				mWHITESPACE(); if (state.failed) return;

				}
				break;
			case 8 :
				// src/core/koopa/core/grammars/test/generator/Stage.g:1:61: SEMI
				{
				mSEMI(); if (state.failed) return;

				}
				break;
			case 9 :
				// src/core/koopa/core/grammars/test/generator/Stage.g:1:66: ACCEPT
				{
				mACCEPT(); if (state.failed) return;

				}
				break;
			case 10 :
				// src/core/koopa/core/grammars/test/generator/Stage.g:1:73: REJECT
				{
				mREJECT(); if (state.failed) return;

				}
				break;
			case 11 :
				// src/core/koopa/core/grammars/test/generator/Stage.g:1:80: DATA
				{
				mDATA(); if (state.failed) return;

				}
				break;
			case 12 :
				// src/core/koopa/core/grammars/test/generator/Stage.g:1:85: IDENTIFIER
				{
				mIDENTIFIER(); if (state.failed) return;

				}
				break;

		}
	}

	// $ANTLR start synpred1_Stage
	public final void synpred1_Stage_fragment() throws RecognitionException {
		// src/core/koopa/core/grammars/test/generator/Stage.g:68:13: ( '\\r\\n' )
		// src/core/koopa/core/grammars/test/generator/Stage.g:68:14: '\\r\\n'
		{
		match("\r\n"); if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_Stage

	public final boolean synpred1_Stage() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_Stage_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



}
