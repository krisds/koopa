package koopa.tokenizers.cobol.tags;

/**
 * Every token which goes into the parser should have one (and only one) of
 * these tags.
 */
public enum AreaTag {
	SEQUENCE_NUMBER_AREA, INDICATOR_AREA, PROGRAM_TEXT_AREA, IDENTIFICATION_AREA, END_OF_LINE,

	/**
	 * This token holds a comment (possibly an inline comment).
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
