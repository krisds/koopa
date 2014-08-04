package koopa.cobol.sources;

import static koopa.cobol.data.tags.AreaTag.PROGRAM_TEXT_AREA;
import static koopa.cobol.data.tags.AreaTag.SOURCE_FORMATTING_DIRECTIVE;

import java.util.regex.Pattern;

import koopa.core.data.Token;
import koopa.core.sources.BasicSource;
import koopa.core.sources.Source;

import org.apache.log4j.Logger;

public class SourceFormattingDirectives extends BasicSource<Token> implements
		Source<Token> {

	private static final Logger LOGGER = Logger
			.getLogger("tokenising.source_formatting");

	// TODO Add "TITLE string" directive.
	private static final String REGEX = "^\\s*(SKIP1|SKIP2|SKIP3|EJECT)\\s*\\.?\\s*$";

	private static final Pattern PATTERN = Pattern.compile(REGEX);

	private Source<? extends Token> source = null;

	public SourceFormattingDirectives(Source<? extends Token> source) {
		assert (source != null);
		this.source = source;
	}

	@Override
	public Token nxt1() {
		Token token = source.next();

		if (token == null)
			return token;

		if (!token.hasTag(PROGRAM_TEXT_AREA))
			return token;

		final String text = token.getText();

		if (text == null)
			return token;

		if (PATTERN.matcher(text).matches()) {
			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Marking " + token
						+ " as a source formatting directive.");

			token = token.replacingTag(PROGRAM_TEXT_AREA,
					SOURCE_FORMATTING_DIRECTIVE);
		}

		return token;
	}

	@Override
	public void close() {
		source.close();
	}
}
