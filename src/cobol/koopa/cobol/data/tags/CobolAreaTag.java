package koopa.cobol.data.tags;

/**
 * Some Cobol specific specializations of what can be found in a program.
 */
public enum CobolAreaTag {
	/** Columns 1--6 in a fixed-format source file. */
	SEQUENCE_NUMBER_AREA,

	/** Column 7 in a fixed-format source file. */
	INDICATOR_AREA,

	/** Columns 72 and on in a fixed-format source file. */
	IDENTIFICATION_AREA
}
