package koopa.core.sources.test.samples;

import static koopa.core.data.tags.SyntacticTag.END_OF_LINE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Data;
import koopa.core.data.Position;
import koopa.core.data.Range;
import koopa.core.data.Token;
import koopa.core.sources.Source;

/**
 * A block is a series of non-empty lines, interpreted as follows:
 * <ul>
 * <li>The first line represents the input to be split into {@linkplain Token}s.
 * This line is required.</li>
 * <li>The second line defines the ranges for the expected {@linkplain Token}s.
 * (See {@link #allRangesFrom(Token)} for more details.) This line is optional.
 * </li>
 * <li>Each following line defines annotations for the corresponding
 * {@linkplain Token}s. (See {@link #allAnnotations(List)} for more details.)
 * These lines are optional.</li>
 * </ul>
 */
class Block {

	/**
	 * When there are multiple {@linkplain Block}s, this field acts as a
	 * sequence number for them.
	 */
	private final int index;

	private final Token input;
	private final List<Range> ranges;
	private final List<Annotation> annotations;

	public Block(int index, List<Token> lines) {
		assert (lines.size() >= 1);

		this.index = index;
		this.input = lines.get(0);
		this.ranges = allRangesFrom(lines.size() >= 2 ? lines.get(1) : null);
		this.annotations = allAnnotations(
				lines.size() > 2 ? lines.subList(2, lines.size()) : null);
	}

	/**
	 * Token {@linkplain Range}s are either of the form "&lt; .... &gt;", where
	 * "&lt;" marks the start of the range and "&gt;" the end, or of the form
	 * "^", which marks both start and end.
	 * <p>
	 * Note: within a range definition you can use any character. So the
	 * following is a valid range:
	 * "&lt; the quick brown fox jumped over the lazy dog &gt;". Having said
	 * that, simple dashes are preferred.
	 * <p>
	 * It may happen that a token is split over multiple lines. In order to
	 * declare this you may use a "+" rather than "&lt;" or "&gt;" to show that
	 * there is more.
	 * <p>
	 * If there are parts of a line you don't want to define a range for (e.g.
	 * because something gets replaced), just use spaces instead.
	 */
	private List<Range> allRangesFrom(Token token) {
		if (token == null)
			return null;

		int pos = 0;

		List<Range> ranges = new ArrayList<>();
		final String line = token.getText();

		while (true) {
			// End-of-line means we're done with these ranges.
			if (pos >= line.length())
				break;

			// Next character should mark the start of a range.
			char c = line.charAt(pos++);

			switch (c) {
			case ' ':
				// No range.
				break;

			case '^':
				// Single character range.
				final Position position = new Position(
						token.getStart().getLinenumber() - 1, index, pos);
				ranges.add(new Range(position, position));
				break;

			case '<':
			case '+':
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
				if (continuesIncompleteAnnotation)
					begin = null;
				else
					begin = new Position(token.getStart().getLinenumber() - 1,
							index, start);

				final Position end;
				if (isIncompleteAnnotation)
					end = null;
				else
					end = new Position(token.getStart().getLinenumber() - 1,
							index, pos);

				ranges.add(new Range(begin, end));
				break;

			default:
				// Something else. We don't allow that, for now.
				throw new IllegalStateException(
						"Unexpected character in token range: " + c);
			}
		}

		return ranges;
	}

	/**
	 * An annotation can be any of the following:
	 * <ul>
	 * <li>A legal Java identifier. E.g. <code>TEXT</code>,
	 * <code>SOURCE_FORMAT</code>, <code>t</code>, etc.</li>
	 * <li>A single, non-whitespace character. E.g. <code>.</code>,
	 * <code>:</code>, <code>:</code>, <code>?</code>, etc.</li>
	 * <li>A percent sign (<code>%</code>) is treated as whitespace.</li>
	 * </ul>
	 * <p>
	 * An annotation may be negated by preceding it with an exclamation mark (
	 * <code>!</code>). E.g. <code>!TEXT</code>, <code>!:</code>, etc.
	 * <p>
	 * The annotations on a single line are related sequentially to the token
	 * {@linkplain Range}s defined earlier. There should be an equal number of
	 * annotations as there are token ranges.
	 * <p>
	 * It is possible to define multiple annotations for a single token
	 * {@linkplain Range} on the same line. To do so simply combine them with a
	 * forward slash (<code>/</code>). E.g. <code>FIXED/TEXT/!COMMENT</code>.
	 * <b>Note that you can only do this with identifiers.</b> I.e. the
	 * following is not allowed: <code>./:/?</code>.
	 * <p>
	 * An equals sign (<code>=</code>) is interpreted as being a repetition of
	 * the previous annotation. E.g. <code>FIXED/TEXT ==</code> is equivalent to
	 * <code>FIXED/TEXT FIXED/TEXT FIXED/TEXT</code>.
	 * <p>
	 * Each of the given line should have an equal number of annotations. These
	 * are then combined as they appeared on each line into the final
	 * annotations. I.e. the first annotation on the first line gets combined
	 * with the first annotation on each subsequent line. The second annotation
	 * on the first line with the second annotation on each subsequent line. And
	 * so on.
	 */
	private List<Annotation> allAnnotations(List<Token> lines) {
		if (lines == null || lines.isEmpty())
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
		boolean canBeContinued = false;

		final LinkedList<Annotation> annotations = new LinkedList<>();

		final String line = token.getText();
		while (true) {
			// End-of line ?
			if (pos >= line.length())
				break;

			char c = line.charAt(pos++);

			// Whitespace or equivalent ?
			if (Character.isWhitespace(c) || c == '%') {
				canBeContinued = false;
				continue;
			}

			// Repeat the previous annotation ?
			if (c == '=') {
				if (annotations.isEmpty())
					throw new IllegalStateException("Line "
							+ token.getStart().getLinenumber() + ", column "
							+ pos
							+ ": repeat operator without a preceding category.");

				// Note: we must make a copy as they may get combined with
				// annotations on other lines.
				annotations.addLast(new Annotation(annotations.getLast()));
				continue;
			}

			// Are we continuing an (set of) annotation(s), or starting a new
			// one ?
			final Annotation annotation;
			if (c == '/' && pos < line.length() - 1) {
				// Continuing...
				if (!canBeContinued)
					throw new IllegalStateException("Line "
							+ token.getStart().getLinenumber() + ", column "
							+ pos
							+ ": separator found at start of a list of categories.");

				annotation = annotations.get(annotations.size() - 1);
				c = line.charAt(pos++);

			} else {
				// New one...
				annotation = new Annotation();
				annotations.add(annotation);
			}

			// Is the annotation being inverted ?
			final boolean inverted = (c == '!' && pos < line.length() - 1);
			if (inverted)
				c = line.charAt(pos++);

			// Are we processing a Java identifier, or some other character ?
			if (!Character.isJavaIdentifierStart(c)) {
				// Some other character...
				annotation.add("" + c, !inverted);

				canBeContinued = false;

			} else {
				// A Java identifier, which we'll scan for now...
				final int start = pos - 1;
				while (pos < line.length()
						&& Character.isJavaIdentifierStart(line.charAt(pos)))
					pos++;

				final String category = line.substring(start, pos);
				annotation.add(category, !inverted);

				canBeContinued = true;
			}
		}

		return annotations;
	}

	public String getInput() {
		return input.getText() + "\n";
	}

	public List<Range> getRanges() {
		return ranges;
	}

	public boolean hasAnnotations() {
		return annotations != null && !annotations.isEmpty();
	}

	public List<Annotation> getAnnotations() {
		return annotations;
	}

	@Override
	public String toString() {
		return index + "\n" + input + "\n" + ranges;
	}

	/**
	 * Returns the next {@linkplain Block} to be found in the given
	 * {@linkplain Source}. This will skip any leading blank lines and comments
	 * there may still be.
	 * <p>
	 * If there was no block to be found in the source this returns
	 * <code>null</code> instead.
	 */
	public static Block nextFrom(int index, Source source) {
		Data d = source.next();

		// Skip empty lines...
		while (d != null //
				&& (!(d instanceof Token) //
						|| isEndOfLine((Token) d) //
						|| isComment((Token) d) //
						|| isBlank((Token) d))) {
			d = source.next();
		}

		// Grab non-empty lines...
		final List<Token> lines = new ArrayList<>();
		while (d != null //
				&& (d instanceof Token)
				&& !isEndOfLine((Token) d) //
				&& !isComment((Token) d) //
				&& !isBlank((Token) d)) {

			lines.add((Token) d);
			d = source.next();

			// Skip end-of-lines...
			if (d != null && d instanceof Token && isEndOfLine((Token) d))
				d = source.next();
		}

		if (lines.isEmpty())
			return null;
		else
			return new Block(index, lines);
	}

	private static boolean isEndOfLine(Token t) {
		return t.hasTag(END_OF_LINE);
	}

	/**
	 * A line is blank when it has nothing but whitespace characters.
	 */
	private static boolean isBlank(Token t) {
		return t.getText().trim().length() == 0;
	}

	/**
	 * A line is a comment when it starts with a hash mark (<code>#</code>) as
	 * the first character.
	 */
	private static boolean isComment(Token t) {
		return t.getText().startsWith("#");
	}
}