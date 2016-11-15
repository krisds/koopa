package koopa.core.sources.test.samples;

import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Position;
import koopa.core.data.Range;
import koopa.core.data.Token;
import koopa.core.sources.Source;

class Block {

	private final int index;
	private final Token input;
	private List<Range> ranges;
	private List<Annotation> annotations;

	public Block(int index, List<Token> lines) {
		assert (lines.size() >= 2);

		this.index = index;
		this.input = lines.get(0);
		this.ranges = allRangesFrom(lines.get(1));
		this.annotations = allAnnotations(lines.subList(2, lines.size()));
	}

	/**
	 * Token ranges are either of the form "&lt; .... &gt;", where "&lt;" marks
	 * the start of the range and "&gt;" the end, or of the form "^", which
	 * marks both start and end.
	 * <p>
	 * Note: within a range definition you can use any character. So the
	 * following is a valid range:
	 * "&lt; the quick brown fox jumped over the lazy dog &gt;". Having said
	 * that, simple dashes are preferred.
	 * <p>
	 * It may happen that a token is split over multiple lines. In order to
	 * declare this you may use a "+" rather than "&lt;" or "&gt;" to show that
	 * there is more.
	 */
	private List<Range> allRangesFrom(Token token) {
		int pos = 0;

		List<Range> ranges = new ArrayList<Range>();
		final String line = token.getText();

		while (true) {
			// End-of-line means we're done with these ranges.
			if (pos >= line.length())
				break;

			// Next character should mark the start of a range.
			char c = line.charAt(pos++);

			if (c == '^') {
				// Single character range.
				final Position position = new Position(
						token.getStart().getLinenumber() - 1, index, pos);
				ranges.add(new Range(position, position));
				continue;

			} else if (c == '<' || c == '+') {
				// Multi-character range.
				int start = pos;

				// A '+' as the initial marker means we're continuing an
				// existing annotation.
				final boolean continuesIncompleteAnnotation = (c == '+');

				// Looking for the end.
				while (true) {
					// There needs to be an end.
					if (pos >= line.length())
						throw new IllegalStateException(
								"Unexpected end of line while in token range.");

					c = line.charAt(pos++);

					// Found it ?
					if (c == '>' || c == '+')
						break;
				}

				// A '+' as the closing marker means this annotation will be
				// continued later on.
				boolean isIncompleteAnnotation = (c == '+');

				final Position begin;
				if (continuesIncompleteAnnotation) {
					begin = null;

				} else {
					begin = new Position(token.getStart().getLinenumber() - 1,
							index, start);
				}

				final Position end;
				if (isIncompleteAnnotation)
					end = null;
				else
					end = new Position(token.getStart().getLinenumber() - 1,
							index, pos);

				ranges.add(new Range(begin, end));
				continue;

			} else {
				// Something else. We don't allow that, for now.
				throw new IllegalStateException(
						"Unexpected character in token range: " + c);
			}
		}

		return ranges;
	}

	private List<Annotation> allAnnotations(List<Token> lines) {
		if (lines.isEmpty())
			return null;

		List<Annotation> combined = null;

		for (Token line : lines) {
			List<Annotation> annotations = split(line);

			if (combined == null)
				combined = annotations;
			else {
				if (combined.size() != annotations.size())
					throw new IllegalStateException("Line "
							+ line.getStart().getLinenumber() + " defines "
							+ annotations.size()
							+ " categories, rather than the " + combined.size()
							+ " which were found earlier.");

				for (int i = 0; i < combined.size(); i++)
					combined.get(i).mergeWith(annotations.get(i));
			}
		}

		return combined;
	}

	private List<Annotation> split(Token token) {
		int pos = 0;
		boolean atStart = true;

		List<Annotation> annotations = new LinkedList<Annotation>();

		final String line = token.getText();
		while (true) {
			// End-of line ?
			if (pos >= line.length())
				break;

			char c = line.charAt(pos++);

			if (Character.isWhitespace(c) || c == '%') {
				atStart = true;
				continue;
			}

			if (c == '/') {
				if (atStart)
					throw new IllegalStateException("Line "
							+ token.getStart().getLinenumber() + ", column "
							+ pos
							+ ": separator found at start of a list of categories.");
				continue;
			}

			Annotation annotation = null;
			if (atStart) {
				annotation = new Annotation();
				annotations.add(annotation);
			} else {
				annotation = annotations.get(annotations.size() - 1);
			}

			if (!Character.isJavaIdentifierStart(c)) {
				annotation.add("" + c);

			} else {
				int start = pos - 1;
				while (pos < line.length()
						&& Character.isJavaIdentifierStart(line.charAt(pos)))
					pos++;

				String category = line.substring(start, pos);
				annotation.add(category);
			}

			atStart = false;
		}

		return annotations;
	}

	public String getInput() {
		return input.getText() + "\n";
	}

	public List<Range> getRanges() {
		return ranges;
	}

	public List<Annotation> getAnnotations() {
		return annotations;
	}

	@Override
	public String toString() {
		return index + "\n" + input + "\n" + ranges;
	}

	public static Block nextFrom(int index, Source<Token> source) {
		Token token = source.next();

		while (token != null
				&& (isEndOfLine(token) || isComment(token) || isBlank(token))) {
			token = source.next();
		}

		List<Token> lines = new ArrayList<Token>();
		while (token != null && !isEndOfLine(token) && !isComment(token)
				&& !isBlank(token)) {
			lines.add(token);

			token = source.next();
			if (token != null && isEndOfLine(token))
				token = source.next();
		}

		if (lines.isEmpty())
			return null;
		else
			return new Block(index, lines);
	}

	private static boolean isEndOfLine(Token token) {
		return token.hasTag(END_OF_LINE);
	}

	private static boolean isBlank(Token token) {
		return token.getText().trim().length() == 0;
	}

	private static boolean isComment(Token token) {
		return token.getText().startsWith("#");
	}
}