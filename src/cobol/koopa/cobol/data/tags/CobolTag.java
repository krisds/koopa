package koopa.cobol.data.tags;

import koopa.core.data.tags.AreaTag;

public enum CobolTag {

	/**
	 * This token hold a source format directive which switches the source
	 * format for subsequent lines.
	 * <p>
	 * This overlaps with {@link AreaTag#COMPILER_DIRECTIVE}.
	 */
	SOURCE_FORMAT_DIRECTIVE,

	/**
	 * This token holds a source listing directive.
	 * <p>
	 * This overlaps with {@link AreaTag#COMPILER_DIRECTIVE}.
	 */
	SOURCE_LISTING_DIRECTIVE;
}
