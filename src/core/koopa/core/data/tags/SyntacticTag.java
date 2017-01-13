package koopa.core.data.tags;

/**
 * A list of basic elements to be found inside
 * {@linkplain AreaTag#PROGRAM_TEXT_AREA}.
 */
public enum SyntacticTag {
	/** A piece of text enclosed within single or double quotes. */
	STRING,

	/** A sequence of digits. */
	NUMBER,

	/**
	 * A sequence of letters, and dashes. The first character must be a letter.
	 */
	WORD,

	/**
	 * Anything which is not a {@linkplain #STRING}, {@linkplain #NUMBER} or
	 * {@linkplain #WORD}. Things like punctuation, parentheses, and symbols.
	 */
	SEPARATOR,

	/**
	 * A more specific kind of {@linkplain #SEPARATOR}. Any tokens with this tag
	 * must also have the {@linkplain #SEPARATOR} tag.
	 */
	WHITESPACE,

	/** Pretty much what you think it is. */
	END_OF_LINE,

	/**
	 * This is a meta-tag, which can be applied to others to indicate that the
	 * token has been detected to be incomplete. For example (and as the only
	 * use so far) this can be applied to string literals which lack their
	 * closing quotation marker.
	 */
	INCOMPLETE
}
