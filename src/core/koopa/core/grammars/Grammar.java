package koopa.core.grammars;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;
import static koopa.core.data.tags.SyntacticTag.WHITESPACE;
import static koopa.core.parsers.combinators.Opt.NOSKIP;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.data.tags.SyntacticTag;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;
import koopa.core.parsers.combinators.Opt;

/**
 * This defines the basic details of a grammar, as well as the source of actual
 * {@linkplain ParserCombinator}s.
 * <p>
 * <strong>It is expected that this class and the {@linkplain ParserCombinator}
 * s it generates are thread safe.</strong> Any state needed while parsing
 * should be part of the {@linkplain Parse} instance used.
 */
public abstract class Grammar {

	/**
	 * What is this grammar's namespace ? This will help separate grammar rules
	 * with matching names from different grammars, which is of importance when
	 * composing grammars.
	 */
	public abstract String getNamespace();

	/**
	 * Whether or not a token contributes to program text.
	 * <p>
	 * Program text is the part of the tokens which will be parsed. Anything
	 * which is not program text will be ignored.
	 * <p>
	 * The default implementation tests whether a token is program text by
	 * looking for the presence of a {@linkplain AreaTag#PROGRAM_TEXT_AREA} tag,
	 * and the absence of a {@linkplain AreaTag#COMMENT} tag.
	 */
	public boolean isProgramText(Token token) {
		return token.hasTag(PROGRAM_TEXT_AREA) && !token.hasTag(COMMENT);
	}

	/**
	 * Whether or not a token can be skipped at a given point in the parse.
	 * <p>
	 * This should only be called on tokens which are program text (as decided
	 * by {@link #isProgramText(Token)}).
	 * <p>
	 * The default implementation tests whether a token is program text by
	 * looking for the presence of either a {@linkplain SyntacticTag#WHITESPACE}
	 * tag, or a {@linkplain SyntacticTag#END_OF_LINE} tag.
	 */
	public boolean canBeSkipped(Token token, Parse parse) {
		return token.hasAnyTag(WHITESPACE, END_OF_LINE);
	}

	/**
	 * Should matching be case sensitive or not ?
	 */
	public abstract boolean isCaseSensitive();

	/**
	 * Normalize program text so it can be used in string comparison.
	 * <p>
	 * Basically, this will {@linkplain String#toUpperCase()} what you give it
	 * if {@link #isCaseSensitive()} is <code>true</code>, or return it as is
	 * otherwise.
	 */
	public String comparableText(String word) {
		if (word == null)
			return null;
		else if (isCaseSensitive())
			return word;
		else
			return word.toUpperCase();
	}

	/**
	 * This is equivalent to {@linkplain #skipOther(Parse, String)}, with the
	 * second parameter set to <code>null</code>.
	 */
	public void skipAll(Parse parse) {
		skipOther(parse, null);
	}

	/**
	 * Skips all tokens which are either not program text (via
	 * {@linkplain #isProgramText(Token)}), or which can be skipped (via
	 * {@linkplain #canBeSkipped(Token, Parse)}).
	 * <p>
	 * This will not skip program text tokens matching the <code>text</code>
	 * parameter, unless it is set to <code>null</code>.
	 * <p>
	 * If the {@linkplain Opt#NOSKIP} option is active then this will only skip
	 * tokens which are not program text.
	 * <p>
	 * Subclasses may use this as needed in custom parsers.
	 */
	public void skipOther(Parse parse, String text) {
		text = comparableText(text);
		while (true) {
			Stream stream = parse.getStream();
			Token token = stream.peek();

			if (token == null)
				return;

			if (!isProgramText(token)) {
				stream.skip();
				continue;
			}

			if (parse.isSet(NOSKIP))
				return;

			if (text != null && text.equals(comparableText(token.getText())))
				return;

			if (canBeSkipped(token, stream.getParse())) {
				stream.skip();
				continue;
			}

			return;
		}
	}

	/**
	 * Matches a <i>potential</i> keyword. There is no need to actually test
	 * whether it is a keyword, as Koopa tries to do that automatically anyway.
	 */
	public abstract ParserCombinator keyword();
}