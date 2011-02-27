package koopa.tokenizers.cobol.tags;

public enum ContinuationsTag {
	/**
	 * This token is being continued with another (marked with
	 * {@link PseudoTag#CONTINUING}).
	 */
	CONTINUED,

	/**
	 * This token is being skipped as part of a continuation.
	 */
	SKIPPED,

	/**
	 * This token is continuing another (marked with {@link PseudoTag#CONTINUED}
	 * ).
	 */
	CONTINUING,

	/**
	 * This token is continuing another and has a leading quote (which is not
	 * really part of the continuation).
	 */
	LEADING_QUOTE
}
