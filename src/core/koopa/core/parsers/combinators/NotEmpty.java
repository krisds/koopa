package koopa.core.parsers.combinators;

import koopa.core.data.Data;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.parsers.Stream;

/**
 * A {@linkplain ParserCombinator} which will try to match a given
 * {@linkplain ParserCombinator} once, but will only accept its match if it was
 * non-empty.
 */
public class NotEmpty extends UnaryParserDecorator {

	public NotEmpty(ParserCombinator parser) {
		super(parser);
	}

	@Override
	public boolean matches(Parse parse) {
		final Stream stream = parse.getStream();

		if (parse.getTrace().isEnabled())
			parse.getTrace().indent(toString() + " ?");

		final Data initialData = stream.peek();
		if (initialData == null) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(toString() + " : no, at end");
			return false;
		}

		final boolean accepts = parser.accepts(parse);
		if (!accepts) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(toString() + " : no");
			return false;
		}

		final Data finalData = stream.peek();
		if (finalData == initialData) {
			if (parse.getTrace().isEnabled())
				parse.getTrace().dedent(toString() + " : no, nothing consumed");
			return false;
		}

		if (parse.getTrace().isEnabled())
			parse.getTrace().dedent(toString() + " : yes");

		return true;
	}

	@Override
	public boolean canMatchEmptyInputs() {
		return true;
	}

	@Override
	public String toString() {
		return "%notEmpty " + parser;
	}
}