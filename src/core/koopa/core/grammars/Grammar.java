package koopa.core.grammars;

import static koopa.core.grammars.combinators.Opt.NOSKIP;
import koopa.core.data.Token;
import koopa.core.parsers.Parse;
import koopa.core.parsers.Stream;

public abstract class Grammar {

	/**
	 * Whether or not a token contributes to program text.
	 * <p>
	 * It is up to actual grammars to override this and implement as needed.
	 */
	public abstract boolean isProgramText(Token token);

	/**
	 * Whether or not a piece of text represents a separator (or whitespace).
	 * <p>
	 * It is up to actual grammars to override this and implement as needed.
	 */
	public abstract boolean isSeparator(String text);

	/**
	 * Whether or not a token represents a separator.
	 * <p>
	 * By default this delegates to {@linkplain Grammar#isSeparator(String)}.
	 */
	public boolean isSeparator(Token token, Parse parseStack) {
		return isSeparator(token.getText());
	}

	/**
	 * Skips all tokens which are either not program text, or which are
	 * separators.
	 * <p>
	 * If the {@linkplain #noskip} option is active then this will only skip
	 * tokens which are not program text.
	 * <p>
	 * Subclasses may use this as needed in custom parsers.
	 */
	public void skipSeparators(Parse parse) {
		skipOtherSeparators(parse, null);
	}

	/**
	 * Skips all tokens which are either not program text, or which are
	 * separators other than the given one.
	 * <p>
	 * If the {@linkplain #noskip} option is active then this will only skip
	 * tokens which are not program text.
	 * <p>
	 * Subclasses may use this as needed in custom parsers.
	 */
	public void skipOtherSeparators(Parse parse, String sep) {
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

			if (sep != null && sep.equals(token.getText()))
				return;

			if (isSeparator(token, stream.getParse())) {
				stream.skip();
				continue;
			}

			return;
		}
	}

	/**
	 * What is this grammar's namespace ? This will help separate grammar rules
	 * with matching names from different grammars, which is of importance when
	 * composing grammars.
	 */
	public abstract String getNamespace();
}