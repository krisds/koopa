package koopa.cobol.grammar.preprocessing;

import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.AreaTag.SKIPPED;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;
import static koopa.core.data.tags.SyntacticTag.NUMBER;
import static koopa.core.data.tags.SyntacticTag.SEPARATOR;
import static koopa.core.data.tags.SyntacticTag.WHITESPACE;
import static koopa.core.data.tags.SyntacticTag.WORD;
import static koopa.core.grammars.combinators.Scoped.Visibility.PRIVATE;

import koopa.cobol.CobolWords;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.grammars.KoopaGrammar;
import koopa.core.parsers.FutureParser;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

public abstract class CobolPreprocessingBaseGrammar extends KoopaGrammar {

	@Override
	public String getNamespace() {
		return "cobol-pp";
	}

	@Override
	public boolean isCaseSensitive() {
		return false;
	}

	// ============================================================================
	// Program text and separators
	// ............................................................................

	@Override
	public boolean canBeSkipped(Data d, Parse parse) {
		if (!(d instanceof Token))
			return false;

		final Token t = (Token) d;

		if (t.hasAnyTag(WHITESPACE, END_OF_LINE))
			return true;

		final String text = t.getText();

		// "Whereas in other contexts, the comma, semicolon, and space can be
		// used interchangeably as separators, the comma has special relevance
		// in the argument lists of intrinsic functions. It is sometimes
		// necessary to use commas as separators between arguments to resolve
		// ambiguity." - Compaq COBOL Reference Manual
		// http://h30266.www3.hp.com/odl/vax/progtool/cobol57a/6296/6296_profile_037.html
		//
		// The testsuite has an example in which this is relevant. Unfortunately
		// I could not find the explanation for this in the standard. The above
		// quote made the difference clear though.
		if (parse != null && ",".equals(text)
				&& parse.getStack().isMatching("function"))
			return false;

		return text.equals(",") || text.equals(";")
				|| text.trim().length() == 0;
	}

	// ============================================================================
	// Words
	// ............................................................................

	private ParserCombinator wordParser = null;

	private ParserCombinator word() {
		if (wordParser == null) {
			FutureParser future = scoped("word", PRIVATE);
			wordParser = future;
			future.setParser(new ParserCombinator() {
				@Override
				public boolean matches(Parse parse) {
					skipAll(parse);
					return matchesWord(parse);
				}

				@Override
				public String toString() {
					return "cobol-pp:word";
				}
			});
		}
		return wordParser;
	}

	/**
	 * <i>"A COBOL word is a character-string of not more than 31 characters
	 * that forms a compiler-directive word, a context-sensitive word, an
	 * intrinsic-function-name, a reserved word, a system-name, or a
	 * user-defined word. Each character of a COBOL word that is not a special
	 * character word shall be selected from the set of basic letters, basic
	 * digits, extended letters, and the basic special characters hyphen and
	 * underscore. The hyphen or underscore shall not appear as the first or
	 * last character in such words."</i>
	 * <p>
	 * 
	 * <i>"Except where specific rules apply, the hyphen (-) and the underline
	 * (_) are treated as the same character in a user- defined word. The
	 * underline (_), however, can begin or end a user-defined word, and the
	 * hyphen (-) cannot."</i>
	 * 
	 * Description from:
	 * <a href="http://h71000.www7.hp.com/doc/82final/6296/6296pro_002.html">HP
	 * COBOL Reference Manual - Character Strings</a>.
	 * <p>
	 * Because anything in a copybook can be replaced via the COPY statement,
	 * some COBOL words may contain characters which are not legal otherwise. We
	 * allow this behaviour to be configured via
	 * {@linkplain CobolWords#useExtendedCharactersInCopybooks()} and
	 * {@linkplain CobolWords#isExtendedPart(String)}.
	 * <p>
	 * Note: This will skip all intermediate separators.
	 */
	private boolean matchesWord(Parse parse) {
		boolean extendedRules = CobolWords.useExtendedCharactersInCopybooks()
				&& parse.getStack().isMatching("copybook");

		final Stream stream = parse.getStream();

		skipAll(parse);

		StringBuilder word = new StringBuilder();
		while (true) {
			final Data d = stream.forward();

			if (d == null) {
				// End of the stream, so end of the token.
				break;
			}

			if (!(d instanceof Token)) {
				stream.rewind(d);
				break;
			}

			final Token t = (Token) d;

			if (t.hasTag(SKIPPED)) {
				// Skipped by continuation. So not part of the word, but not a
				// definite end to it either.

			} else if (extendedRules && t.hasTag(PROGRAM_TEXT_AREA)
					&& CobolWords.isExtendedPart(t.getText())) {
				// Allowing this separator to be part of a COBOL word.
				word.append(t.getText());

			} else if (!t.hasTag(PROGRAM_TEXT_AREA) || !isCobolWordPart(t)) {
				// Not part of a legal word, so end of the token.
				stream.rewind(t);
				break;

			} else {
				// Everything else gets added to the word.
				word.append(t.getText());
			}
		}

		if (word.length() == 0)
			return false;

		final String text = word.toString();

		if (!CobolWords.accepts(text)) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().add("no; illegal word: " + text);

			return false;

		} else
			return true;
	}

	private boolean isCobolWordPart(Token token) {
		if (token.hasAnyTag(WORD, NUMBER))
			return true;

		if (token.hasTag(SEPARATOR)) {
			String text = token.getText();

			if ("_".equals(text) || "-".equals(text))
				return true;
		}

		return false;
	}

	// ----------------------------------------------------------------------------
	// cobolWord
	// ............................................................................

	private ParserCombinator cobolWordParser = null;

	/**
	 * A cobolWord is any {@link #word()} that is not a keyword.
	 */
	// TODO Add a %nokeyword to KG, and define this in CobolPreprocessing.kg
	// instead.
	public ParserCombinator cobolWord() {
		if (cobolWordParser == null) {
			FutureParser future = scoped("cobolWord");
			cobolWordParser = future;

			future.setParser(notAKeyword(word()));
		}
		return cobolWordParser;
	}

	// ----------------------------------------------------------------------------
	// keyword
	// ............................................................................

	/**
	 * Any {@link #word()} can be a keyword.
	 */
	@Override
	public ParserCombinator keyword() {
		return word();
	}
}