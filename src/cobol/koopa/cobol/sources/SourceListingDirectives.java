package koopa.cobol.sources;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static koopa.cobol.data.tags.CobolTag.SOURCE_LISTING_DIRECTIVE;
import static koopa.core.data.tags.AreaTag.COMPILER_DIRECTIVE;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.Source;

/**
 * Looks for, and tags, following source formatting directives:
 * <p>
 * 
 * <b>EJECT</b>
 * <ul>
 * <li><i>"The EJECT statement specifies that the next source statement is to be
 * printed at the top of the next page."</i></li>
 * <li><i>"The EJECT statement must be the only statement on the line. You may
 * write it in either Area A or Area B, and you may terminate it with a
 * separator period."</i></li>
 * <li><i>"The EJECT statement has no effect on the compilation of the source
 * program itself."</i></li>
 * </ul>
 * Source: <a href=
 * "http://www-01.ibm.com/support/knowledgecenter/SSAE4W_9.1.0/com.ibm.etools.iseries.langref.doc/evfeb4ls270.htm"
 * >IBM Knowledge Center - COBOL/400 Language Help - EJECT Statement</a>
 * <p>
 * 
 * <b>SKIP1, SKIP2, SKIP3</b>
 * <ul>
 * <li><i>
 * "The SKIP1, SKIP2 and SKIP3 statements control the vertical spacing of the source code listing produced by your COBOL system. They specify the lines to be skipped in the source code listing."
 * </i></li>
 * <li><i>"The statement can begin in area A or in area B, must be the only
 * statement on the line and can optionally be followed by a period. "</i></li>
 * </ul>
 * Source: <a href=
 * "https://supportline.microfocus.com/documentation/books/mx31/lhcomp0q.htm" >
 * Micro Focus Support Line - The SKIP1, SKIP2 and SKIP3 Statements</a>
 */
public class SourceListingDirectives extends ChainingSource<Data, Data>
		implements Source<Data> {

	private static final Logger LOGGER = Logger
			.getLogger("source.cobol.source_listing");

	private static final String REGEX //
			= "^\\s*(SKIP1|SKIP2|SKIP3|EJECT)\\s*\\.?\\s*$";

	private static final Pattern PATTERN //
			= Pattern.compile(REGEX, CASE_INSENSITIVE);

	public SourceListingDirectives(Source<Data> source) {
		super(source);
	}

	@Override
	public Data nxt1() {
		final Data d = source.next();

		if (d == null || !(d instanceof Token))
			return d;

		final Token t = (Token) d;

		if (!t.hasTag(PROGRAM_TEXT_AREA))
			return t;

		final String text = t.getText();

		if (text == null)
			return t;

		if (PATTERN.matcher(text).matches()) {
			if (LOGGER.isTraceEnabled())
				LOGGER.trace(
						"Marking " + t + " as a source listing directive.");

			return t.withoutTags(PROGRAM_TEXT_AREA)
					.withTags(SOURCE_LISTING_DIRECTIVE, COMPILER_DIRECTIVE);

		} else
			return t;
	}
}
