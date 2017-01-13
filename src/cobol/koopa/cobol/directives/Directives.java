package koopa.cobol.directives;

import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Token;

public final class Directives {

	private Directives() {
	}

	public static SourceFormat getSourceFormat(Token token,
			SourceFormat format) {

		if (MFSetStatement.matches(format, token))
			return MFSetStatement.getSourceFormat(token);

		if (ISODirective.matches(format, token))
			return ISODirective.getSourceFormat(token);

		if (MFIncStatement.matches(token))
			return null;

		if (MFIncludeStatement.matches(token))
			return null;

		if (IBMCompilerDirectingStatement.matches(format, token))
			return null;

		return null;
	}
}
