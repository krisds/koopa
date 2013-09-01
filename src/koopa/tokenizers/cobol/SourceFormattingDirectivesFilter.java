package koopa.tokenizers.cobol;

import java.util.regex.Pattern;

import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokens.Token;

import org.apache.log4j.Logger;

public class SourceFormattingDirectivesFilter implements Tokenizer {

	private static final Logger LOGGER = Logger
			.getLogger("tokenising.source_formatting");

	// TODO Add "TITLE string" directive.
	private static final String REGEX = "^\\s*(SKIP1|SKIP2|SKIP3|EJECT)\\s*\\.?\\s*$";

	private static final Pattern PATTERN = Pattern.compile(REGEX);

	private Tokenizer tokenizer = null;

	public SourceFormattingDirectivesFilter(Tokenizer tokenizer) {
		assert (tokenizer != null);
		this.tokenizer = tokenizer;
	}

	public Token nextToken() {
		final Token token = tokenizer.nextToken();

		if (token == null) {
			return token;
		}

		if (!token.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
			return token;
		}

		final String text = token.getText();

		if (text == null) {
			return token;
		}

		if (PATTERN.matcher(text).matches()) {
			if (LOGGER.isTraceEnabled()) {
				LOGGER.trace("Marking " + token
						+ " as a source formatting directive.");
			}

			token.removeTag(AreaTag.PROGRAM_TEXT_AREA);
			// token.addTag(AreaTag.COMMENT);
			token.addTag(AreaTag.SOURCE_FORMATTING_DIRECTIVE);
		}

		return token;
	}

	public void quit() {
		tokenizer.quit();
	}
}
