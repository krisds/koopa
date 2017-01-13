package koopa.cobol.sources;

import static koopa.cobol.data.tags.CobolTag.SOURCE_FORMAT_DIRECTIVE;
import static koopa.core.data.tags.AreaTag.COMPILER_DIRECTIVE;
import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;

import org.apache.log4j.Logger;

import koopa.cobol.directives.Directives;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.Source;

/**
 * This {@linkplain Source} looks for {@linkplain Directives} which have define
 * a {@linkplain SourceFormat}, and applies this format as needed.
 */
public class SourceFormatDirectives extends ChainingSource<Data, Data>
		implements Source<Data> {

	private static final Logger LOGGER = Logger
			.getLogger("source.cobol.source_format_directives");

	private SourceFormat format;

	public SourceFormatDirectives(Source<Data> source,
			SourceFormat initialFormat) {
		super(source);
		this.format = initialFormat;
	}

	@Override
	protected Data nxt1() {
		final Data d = source.next();

		if (d == null)
			return null;

		if (!(d instanceof Token))
			return d;

		final Token t = ((Token) d).withTags(format);

		if (t.hasTag(END_OF_LINE))
			return t;

		final SourceFormat newFormat = Directives.getSourceFormat(t, format);

		if (newFormat == null)
			return t;
		else {
			if (LOGGER.isDebugEnabled())
				LOGGER.debug("Switching to " + newFormat
						+ " format, as told by: " + t);

			format = newFormat;
			return t.withTags(COMPILER_DIRECTIVE, SOURCE_FORMAT_DIRECTIVE);
		}
	}
}
