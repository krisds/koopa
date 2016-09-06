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

	/** A sequence of letters, and dashes. The first character must be a letter. */
	WORD,

	/**
	 * Anything which is not a {@linkplain #STRING}, {@linkplain #NUMBER} or
	 * {@linkplain #WORD}.
	 */
	SEPARATOR,

	/**
	 * A more specific kind of {@linkplain #SEPARATOR}. Any tokens with this tag
	 * must also have the {@linkplain #SEPARATOR} tag.
	 */
	WHITESPACE,

	/** Pretty much what you think it is. */
	END_OF_LINE,
}
