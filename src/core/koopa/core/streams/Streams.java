package koopa.core.streams;

import java.util.Iterator;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Stream;

public final class Streams {

	private Streams() {
	}

	public static String getProgramTextFromBookmark(Grammar grammar,
			final Stream stream) {
		final StringBuilder programText = new StringBuilder();

		final Iterator<Data> it = stream.fromBookmarkIterator();
		while (it.hasNext()) {
			final Data d = it.next();

			if (!(d instanceof Token) || !grammar.isProgramText(d))
				continue;

			programText.append(((Token) d).getText());
		}

		return programText.toString();
	}
}
