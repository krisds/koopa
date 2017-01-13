package koopa.cobol.sources;

import static koopa.core.data.tags.AreaTag.COMPILER_DIRECTIVE;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;

import org.apache.log4j.Logger;

import koopa.cobol.directives.IBMCompilerDirectingStatement;
import koopa.cobol.directives.ISODirective;
import koopa.cobol.directives.MFIncStatement;
import koopa.cobol.directives.MFIncludeStatement;
import koopa.cobol.directives.MFSetStatement;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.Source;

public class CompilerDirectives extends ChainingSource<Data, Data>
		implements Source<Data> {

	private static final Logger LOGGER = Logger
			.getLogger("source.cobol.compiler_directives");

	public CompilerDirectives(Source<Data> source) {
		super(source);
	}

	@Override
	public Data nxt1() {
		final Data d = source.next();

		if (d == null || !(d instanceof Token))
			return d;

		final Token t = (Token) d;

		if (t.hasAnyTag(COMPILER_DIRECTIVE, END_OF_LINE))
			return t;

		if (isMicroFocusSetStatement(t) //
				|| isCompilerDirective(t) //
				|| isMicroFocusIncDirective(t) //
				|| isMicroFocusIncludeDirective(t) //
				|| isIBMCompilerDirectingStatement(t))
			return t.withTags(COMPILER_DIRECTIVE);

		return t;
	}

	// ========================================================================

	private boolean isCompilerDirective(Token token) {
		final SourceFormat referenceFormat = SourceFormat.forToken(token);

		if (!ISODirective.matches(referenceFormat, token))
			return false;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("ISO directive: " + token);

		// TODO Split off inline comments ? Indicator area ?

		return true;
	}

	// ========================================================================

	private boolean isMicroFocusIncDirective(Token token) {
		if (!MFIncStatement.matches(token))
			return false;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Micro Focus -INC statement: " + token);

		return true;
	}

	// ========================================================================

	private boolean isMicroFocusIncludeDirective(Token token) {
		if (!MFIncludeStatement.matches(token))
			return false;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Micro Focus ++INCLUDE statement: " + token);

		return true;
	}

	// ========================================================================

	private boolean isMicroFocusSetStatement(Token token) {
		final SourceFormat referenceFormat = SourceFormat.forToken(token);

		if (!MFSetStatement.matches(referenceFormat, token))
			return false;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Micro Focus compiler directive: " + token);

		return true;
	}

	// ========================================================================

	private boolean isIBMCompilerDirectingStatement(Token token) {
		final SourceFormat referenceFormat = SourceFormat.forToken(token);

		if (!IBMCompilerDirectingStatement.matches(referenceFormat, token))
			return false;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("IBM compiler directive: " + token);

		return true;
	}
}
