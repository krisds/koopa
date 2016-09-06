package koopa.core.data.tags;

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
	 * <p>
	 * Right now comments may overlap with {@linkplain #PROGRAM_TEXT_AREA}. This
	 * may change in the long run.
	 */
	COMMENT,

	/**
	 * This token holds a source formatting directive.
	 */
	SOURCE_FORMATTING_DIRECTIVE,

	/**
	 * This token holds a compiler directive.
	 */
	COMPILER_DIRECTIVE
}
