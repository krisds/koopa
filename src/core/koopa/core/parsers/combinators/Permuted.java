package koopa.core.parsers.combinators;

import java.util.ArrayList;
import java.util.List;

import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * This {@linkplain ParserCombinator} tries to match a list of
 * {@linkplain ParserCombinator}s. Whenever it finds a match that parser gets
 * removed from the list and another round of matching is started. We need at
 * least one successful match to declare the overall matching successful.
 */
public class Permuted extends NAryParserDecorator {

	private static final String SYMBOL = "!(...|...)";

	public Permuted(ParserCombinator[] parsers) {
		super(parsers);
	}

	@Override
	public boolean matches(Parse parse) {
		final Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(SYMBOL + " ?");

		List<ParserCombinator> remaining = new ArrayList<>();
		for (ParserCombinator parser : parsers)
			remaining.add(parser);

		int i = 0;
		while (i < remaining.size()) {
			stream.bookmark();

			if (remaining.get(i).accepts(parse)) {
				stream.commit();
				remaining.remove(i);
				i = 0;

			} else {
				stream.rewind();
				i++;
			}
		}

		final boolean accepts = remaining.size() < parsers.length;

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent(SYMBOL + " : " + (accepts ? "yes" : "no"));

		return accepts;
	}

	@Override
	public String toString() {
		return SYMBOL;
	}
}