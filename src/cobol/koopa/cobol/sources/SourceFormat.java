package koopa.cobol.sources;

import koopa.cobol.data.tags.CobolAreaTag;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;

public enum SourceFormat {
	/**
	 * In fixed format source code is divided into areas:
	 * <ul>
	 * <li>Columns 1-6: sequence number (cfr.
	 * {@linkplain CobolAreaTag#SEQUENCE_NUMBER_AREA}).</li>
	 * <li>Column 7: indicator area (cfr.
	 * {@linkplain CobolAreaTag#INDICATOR_AREA}).</li>
	 * <li>Column 8-11: area A (becomes {@linkplain AreaTag#PROGRAM_TEXT_AREA}).
	 * </li>
	 * <li>Columns 12-72: area B (becomes {@linkplain AreaTag#PROGRAM_TEXT_AREA}
	 * ).</li>
	 * <li>Columns 73 and beyond: ignored (becomes {@linkplain AreaTag#COMMENT}
	 * ).</li>
	 * </ul>
	 */
	FIXED, //

	/**
	 * In free format source code the entire line counts as source code (and
	 * becomes {@linkplain AreaTag#PROGRAM_TEXT_AREA}). The first character can
	 * be used as an indicator (cfr. {@linkplain CobolAreaTag#INDICATOR_AREA}).
	 */
	FREE, //

	/**
	 * Variable format source code works like {@link #FIXED} format, except that
	 * area B is not limited in size.
	 */
	VARIABLE;

	/**
	 * Checks the given token's tags for its source format. If no source format
	 * was set on the token this returns the default of {@linkplain #FIXED}.
	 */
	public static SourceFormat forToken(Token token) {
		if (token.hasTag(FREE))
			return FREE;
		else if (token.hasTag(VARIABLE))
			return VARIABLE;
		else
			return FIXED;
	}

	/**
	 * Same as {@link #valueOf(String)}, except that it returns
	 * <code>null</code> rather than throw an
	 * {@linkplain IllegalArgumentException} when the given name does not match.
	 */
	public static SourceFormat fromName(String name) {
		try {
			return valueOf(name.toUpperCase());
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}
