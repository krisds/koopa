package koopa.tokenizers.cobol;


import java.io.IOException;
import java.util.LinkedList;

import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokenizers.cobol.tags.PseudoTag;
import koopa.tokenizers.cobol.tags.SyntacticTag;
import koopa.tokenizers.util.ThreadedTokenizerBase;
import koopa.tokens.CompositeToken;
import koopa.tokens.Token;

public class ContinuedTokenizer extends ThreadedTokenizerBase implements
		Tokenizer {

	private static final boolean DEBUG = false;

	private Tokenizer tokenizer = null;

	private Token lastNonBlank = null;
	private LinkedList<Token> lastBlanks = new LinkedList<Token>();

	public ContinuedTokenizer(Tokenizer tokenizer) {
		assert (tokenizer != null);
		this.tokenizer = tokenizer;
	}

	protected void tokenize() throws IOException {
		boolean continuePreviousLine = false;
		boolean skippedStringLiteralMarker = false;
		boolean seriesIsForStringLiteral = false;

		while (!hasQuit()) {
			final Token token = tokenizer.nextToken();
			if (DEBUG) {
				System.out.println("  <- " + token);
			}

			if (token == null) {
				if (DEBUG) {
					System.out.println("End of input.");
				}

				enqueue(null);
				break;

			} else if (!token.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
				// TODO Correct ?
				enqueue(token);
				skippedStringLiteralMarker = false;

			} else if (continuePreviousLine) {
				if (!skippedStringLiteralMarker
						&& token.hasTag(SyntacticTag.SEPARATOR)
						&& (token.getText().equals("\"") || token.getText()
								.equals("'"))) {

					if (DEBUG) {
						System.out.println(token
								+ " marks continuation of string literal.");
					}

					skippedStringLiteralMarker = !token
							.hasTag(PseudoTag.CONTINUED);
					seriesIsForStringLiteral = true;

				} else if (token.hasTag(PseudoTag.CONTINUED)) {
					if (DEBUG) {
						System.out.println(token + " continues a series.");
					}

					continuePreviousLine = true;
					skippedStringLiteralMarker = false;

					if (seriesIsForStringLiteral) {
						// String literal => enqueue previous.
						enqueue(token);

					} else if (fitTogether(this.lastNonBlank, token)) {
						// Not string literal, and pieces may be fit together =>
						// weld pieces together.

						if (this.lastNonBlank instanceof CompositeToken) {
							CompositeToken composite = (CompositeToken) this.lastNonBlank;
							composite.addToken(token);

						} else {
							CompositeToken composite = new CompositeToken();
							composite.addTag(AreaTag.PROGRAM_TEXT_AREA);
							composite.addTag(SyntacticTag.CHARACTER_STRING);
							composite.addToken(this.lastNonBlank);
							composite.addToken(token);
							this.lastNonBlank = composite;
						}

						this.lastBlanks.clear();

					} else {
						// Not string literal and pieces do not fit together =>
						// enqueue all.
						this.lastBlanks.clear();
						enqueue(token);
					}

				} else {
					if (DEBUG) {
						System.out.println(token + " closes a series.");
					}
					continuePreviousLine = false;
					skippedStringLiteralMarker = false;

					if (seriesIsForStringLiteral) {
						// String literal => enqueue all.
						enqueue(token);

					} else if (fitTogether(this.lastNonBlank, token)) {
						// Not string literal, and pieces may be fit together =>
						// weld pieces together.

						if (this.lastNonBlank instanceof CompositeToken) {
							CompositeToken composite = (CompositeToken) this.lastNonBlank;
							composite.addToken(token);

						} else {
							CompositeToken composite = new CompositeToken();
							composite.addTag(AreaTag.PROGRAM_TEXT_AREA);
							composite.addTag(SyntacticTag.CHARACTER_STRING);
							composite.addToken(this.lastNonBlank);
							composite.addToken(token);
							this.lastNonBlank = composite;
						}

						this.lastBlanks.clear();

					} else {
						// Not string literal and pieces do not fit together =>
						// enqueue all.
						this.lastBlanks.clear();
						enqueue(token);
					}

					seriesIsForStringLiteral = false;
				}

			} else {
				if (token.hasTag(PseudoTag.CONTINUED)) {
					if (DEBUG) {
						System.out.println(token + " starts a series.");
					}

					continuePreviousLine = true;
					enqueue(token);

				} else {
					if (DEBUG) {
						System.out.println(token + " stands alone.");
					}

					enqueue(token);
					continuePreviousLine = false;
				}
			}
		}
	}

	private boolean fitTogether(Token first, final Token second) {
		if (!first.hasTag(SyntacticTag.CHARACTER_STRING)) {
			return false;
		}

		if (second.hasTag(SyntacticTag.CHARACTER_STRING)) {
			return true;
		}

		if (second.hasTag(SyntacticTag.SEPARATOR)
				&& (second.getText().equals(".") || second.getText()
						.equals(",")) && holdsInteger(first)) {
			// Decimal separator ?
			return true;
		}

		return false;
	}

	private boolean holdsInteger(Token token) {
		try {
			Integer.parseInt(token.getText());
			return true;

		} catch (NumberFormatException e) {
			return false;

		}
	}

	protected void enqueue(Token token) {
		if (token != null && isBlank(token)) {
			this.lastBlanks.add(token);

		} else {
			if (this.lastNonBlank != null) {
				if (DEBUG
						&& this.lastNonBlank.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
					System.out.println("  -> " + this.lastNonBlank);
				}

				super.enqueue(this.lastNonBlank);
			}

			for (Token blank : this.lastBlanks) {
				if (DEBUG && blank.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
					System.out.println("  -> " + blank);
				}

				super.enqueue(blank);
			}

			this.lastBlanks.clear();

			this.lastNonBlank = token;
		}
	}

	private boolean isBlank(Token token) {
		return token.hasTag(SyntacticTag.SEPARATOR)
				&& token.getText().trim().length() == 0;
	}

	public void quit() {
		quitMe();
		tokenizer.quit();
	}
}
