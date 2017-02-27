package koopa.core.data.tags;

import koopa.core.data.Token;

/**
 * Every token which goes into the parser should have one (and only one) of
 * these tags.
 */
public enum AreaTag {
	/**
	 * This token participates in the actual text of the program. By default it
	 * is these tokens which will be parsed.
	 */
	PROGRAM_TEXT_AREA,

	/**
	 * This token holds a comment (possibly an inline comment).
	 */
	COMMENT,

	/**
	 * This token is something we don't care about. But is definitely <i>NOT</i>
	 * {@link #PROGRAM_TEXT_AREA}.
	 */
	SKIPPED,

	/**
	 * This token holds a compiler directive.
	 */
	COMPILER_DIRECTIVE;

	/**
	 * Whether or not the given {@linkplain Token} has any of the tags defined
	 * in this enum.
	 */
	public static boolean isDefinedOn(Token token) {
		return token.hasAnyTag( //
				PROGRAM_TEXT_AREA, //
				COMMENT, //
				SKIPPED, //
				COMPILER_DIRECTIVE);
	}
}
