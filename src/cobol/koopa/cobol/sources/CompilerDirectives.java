package koopa.cobol.sources;

import static koopa.core.data.tags.AreaTag.COMPILER_DIRECTIVE;

import java.util.LinkedList;

import org.apache.log4j.Logger;

import koopa.cobol.directives.IBMCompilerDirectingStatement;
import koopa.cobol.directives.ISODirective;
import koopa.cobol.directives.MFIncStatement;
import koopa.cobol.directives.MFIncludeStatement;
import koopa.cobol.directives.MFSetStatement;
import koopa.core.data.Token;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.Source;

public class CompilerDirectives extends ChainingSource<Token, Token>
		implements Source<Token> {

	private static final Logger LOGGER = Logger
			.getLogger("source.cobol.compiler_directives");

	private final LinkedList<Token> queuedTokens = new LinkedList<Token>();

	private SourceFormat referenceFormat;

	public CompilerDirectives(Source<Token> source,
			SourceFormat initialReferenceFormat) {
		super(source);

		assert (source != null);
		assert (initialReferenceFormat != null);

		this.referenceFormat = initialReferenceFormat;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Initial reference format: " + referenceFormat);
	}

	@Override
	public Token nxt1() {
		if (!queuedTokens.isEmpty())
			return queuedTokens.removeFirst();

		final Token token = source.next();

		if (token == null)
			return null;

		if (token.tagCount() > 0)
			return token.withTags(referenceFormat);

		if (isMicroFocusSetStatement(token))
			return queuedTokens.removeFirst();

		if (isCompilerDirective(token))
			return queuedTokens.removeFirst();

		if (isMicroFocusIncDirective(token))
			return queuedTokens.removeFirst();

		if (isMicroFocusIncludeDirective(token))
			return queuedTokens.removeFirst();

		if (isIBMCompilerDirectingStatement(token))
			return queuedTokens.removeFirst();

		return token.withTags(referenceFormat);
	}

	public void close() {
		source.close();
	}

	// ========================================================================

	private boolean isCompilerDirective(Token token) {
		if (!ISODirective.matches(referenceFormat, token))
			return false;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("ISO directive: " + token);

		final SourceFormat format = ISODirective.getSourceFormat(token);

		queuedTokens.addFirst(//
				token.withTags(COMPILER_DIRECTIVE, referenceFormat));

		// TODO Split off inline comments ? Indicator area ?

		if (format != null)
			referenceFormat = format;

		return true;
	}

	// ========================================================================

	private boolean isMicroFocusIncDirective(Token token) {
		if (!MFIncStatement.matches(token))
			return false;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Micro Focus -INC statement: " + token);

		queuedTokens
				.addFirst(token.withTags(COMPILER_DIRECTIVE, referenceFormat));

		return true;
	}

	// ========================================================================

	private boolean isMicroFocusIncludeDirective(Token token) {
		if (!MFIncludeStatement.matches(token))
			return false;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Micro Focus ++INCLUDE statement: " + token);

		queuedTokens
				.addFirst(token.withTags(COMPILER_DIRECTIVE, referenceFormat));

		return true;
	}

	// ========================================================================

	private boolean isMicroFocusSetStatement(Token token) {
		if (!MFSetStatement.matches(referenceFormat, token))
			return false;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("Micro Focus compiler directive: " + token);

		final SourceFormat format = MFSetStatement.getSourceFormat(token);

		queuedTokens
				.addFirst(token.withTags(COMPILER_DIRECTIVE, referenceFormat));

		if (format != null)
			referenceFormat = format;

		return true;
	}

	// ========================================================================

	private boolean isIBMCompilerDirectingStatement(Token token) {
		if (!IBMCompilerDirectingStatement.matches(referenceFormat, token))
			return false;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("IBM compiler directive: " + token);

		queuedTokens
				.addFirst(token.withTags(COMPILER_DIRECTIVE, referenceFormat));

		return true;
	}
}
