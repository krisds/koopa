package koopa.core.sources.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Token;
import koopa.core.sources.Source;

// TODO I'm abusing IOExceptions a bit much here.
public class AnnotatedSourceSample {

	private StringBuilder sample = null;

	private List<Annotation> annotations = null;
	private Annotation incompleteAnnotation = null;

	public AnnotatedSourceSample(InputStream stream) throws IOException {
		load(new BufferedReader(new InputStreamReader(stream)));
	}

	public AnnotatedSourceSample(FileReader fileReader) throws IOException {
		load(new BufferedReader(fileReader));
	}

	private void load(BufferedReader in) throws IOException {
		sample = new StringBuilder();
		annotations = new ArrayList<Annotation>();

		int orginalLineNumber = 0;
		int sampleLineNumber = 0;

		while (true) {
			String line = in.readLine();

			// Check for end of input.
			if (line == null)
				break;

			orginalLineNumber += 1;

			// Skip empty lines.
			if (line.trim().length() == 0)
				continue;

			// Comment line.
			if (line.startsWith("#"))
				continue;

			// We found our sample line.
			sample.append(line);
			sample.append('\n');
			// System.out.println("sample: " + line);
			sampleLineNumber += 1;

			// Next line must define the token ranges.
			line = in.readLine();

			// There must be a token range line.
			if (line == null)
				throw new IOException("Premature end of file.");

			orginalLineNumber += 1;

			// And it can't be empty.
			if (line.trim().length() == 0)
				throw new IOException("Missing token range line.");

			// We found the token range definition.
			int numberOfTokens = parseExpectedTokenRanges(line,
					orginalLineNumber, sampleLineNumber);

			// Next line may define the token categories.
			line = in.readLine();

			// It's entirely optional though.
			if (line == null)
				continue;

			orginalLineNumber += 1;

			if (line.trim().length() > 0) {
				// Well, we found one anyway.
				parseTokenCategories(line, numberOfTokens);
			}
		}

		reorderAnnotationsAsExpected();
	}

	/**
	 * Some annotations might define offsets, which means the corresponding
	 * token will appear out-of-order. This is the case, for instance, for
	 * continuation lines.
	 * <p>
	 * Out-of-order tokens are handled by ordering them as expected based on the
	 * given offsets.
	 */
	private void reorderAnnotationsAsExpected() {
		for (int i = 0; i < annotations.size(); i++) {
			Annotation annotation = annotations.get(i);

			int offset = annotation.offset;

			// No offset given: handle next annotation.
			if (offset == 0)
				continue;

			if (offset > 0) {
				// Positive offset: shift token to the right.
				for (int j = 0; j < offset; j++) {
					Annotation nxt = annotations.get(i + j + 1);
					annotations.set(i + j, nxt);
				}

				annotations.set(i + offset, annotation);
				annotation.offset = 0;

			} else {
				// Negative offset: shift token to the left.
				for (int j = 0; j < -offset; j++) {
					Annotation prv = annotations.get(i - j - 1);
					annotations.set(i - j, prv);
				}

				annotations.set(i - offset, annotation);
				annotation.offset = 0;
			}
		}
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
	private int parseExpectedTokenRanges(String line, int originalLineNumber,
			int sampleLineNumber) throws IOException {
		// System.out.println("token range: " + line);

		int count = 0;
		int pos = 0;
		while (true) {
			// End-of-line means we're done with these ranges.
			if (pos >= line.length())
				break;

			// Next character should mark the start of a range.
			char c = line.charAt(pos++);

			if (c == '^') {
				// Single character range.
				annotations.add(new Annotation(originalLineNumber,
						sampleLineNumber, pos, sampleLineNumber, pos));
				count += 1;
				continue;

			} else if (c == '<' || c == '+') {
				// Multi-character range.
				int start = pos;

				// A '+' as the initial marker means we're continuing an
				// existing annotation.
				final boolean continuesIncompleteAnnotation = (c == '+');
				if (continuesIncompleteAnnotation
						&& incompleteAnnotation == null)
					throw new IOException(
							"Unexpected annnotation continuation.");

				// Looking for the end.
				while (true) {
					// There needs to be an end.
					if (pos >= line.length())
						throw new IOException(
								"Unexpected end of line while in token range.");

					c = line.charAt(pos++);

					// Found it ?
					if (c == '>' || c == '+')
						break;
				}

				// A '+' as the closing marker means this annotation will be
				// continued later on.
				boolean isIncompleteAnnotation = (c == '+');

				if (continuesIncompleteAnnotation) {
					// If we're continuing an existing annotation we need to
					// update its expected end position.
					incompleteAnnotation.endLine = sampleLineNumber;
					incompleteAnnotation.positionOnEndLine = pos;

					// And if the annotation is complete, we clear the reference
					// to it so we don't update it further.
					if (!isIncompleteAnnotation)
						incompleteAnnotation = null;

				} else {
					// This annotation is a new one, so we create it.
					Annotation annotation = new Annotation(originalLineNumber,
							sampleLineNumber, start, sampleLineNumber, pos);
					annotations.add(annotation);
					count += 1;

					// And if the annotation is incomplete we register it for
					// further completion.
					if (isIncompleteAnnotation)
						incompleteAnnotation = annotation;
				}

				continue;

			} else {
				// Something else. We don't allow that, for now.
				throw new IOException("Unexpected character in token range: "
						+ c);
			}
		}

		return count;
	}

	/**
	 * Token categories are identifiers which refer to tests set up in the
	 * {@linkplain TokenValidator}.
	 * <p>
	 * An identifier is a sequence of letters, numbers and/or '_'. Or it is a
	 * single non-whitespace character. E.g.:
	 * <ul>
	 * <li>IDENTIFIER</li>
	 * <li>7777</li>
	 * <li>IDENTIFIER_7777</li>
	 * <li>?</li>
	 * <li>:</li>
	 * <li>.</li>
	 * </ul>
	 * Multiple identifiers can be concatenated with a forward slash ('/'). In
	 * that case they will all count towards a single token.
	 */
	private void parseTokenCategories(String line, int numberOfTokensInLine)
			throws IOException {
		// System.out.println("categories: " + line);

		int pos = 0;
		int numberOfTokensFound = 0;

		while (true) {
			// End-of line ?
			if (pos >= line.length())
				break;

			char c = line.charAt(pos++);

			// Whitespace gets skipped.
			if (Character.isWhitespace(c))
				continue;

			// If it is a '+' or '-' then we're looking at a token offset.
			int tokenOffset = 0;
			if (c == '+' || c == '-') {
				int sign = (c == '-' ? -1 : 1);
				final int start = pos - 1;

				while (true) {
					if (pos == line.length()) {
						pos += 1;
						break;
					}

					c = line.charAt(pos++);
					if (c == '/' || !Character.isDigit(c))
						break;
				}

				if (c != '/')
					throw new IOException("Badly defined token offset.");

				if (pos == line.length())
					throw new IOException("Badly defined token offset.");

				String offset = line.substring(start + 1, pos - 1);
				tokenOffset = sign * Integer.parseInt(offset);

				c = line.charAt(pos++);
				if (Character.isWhitespace(c))
					throw new IOException("Badly defined token offset.");
			}

			// OK, so no whitespace. We keep track of the start position:
			final int start = pos - 1;

			// Then we scan for category identifiers.
			while (true) {
				if (pos == line.length()) {
					pos += 1;
					break;
				}

				if (c != '_' && c != '/' && !Character.isLetterOrDigit(c))
					break;

				c = line.charAt(pos++);
			}

			// If there were category identifiers we will have consumed more
			// characters. So if we're somewhere else than where we started we
			// know we should process them.
			if (start < pos - 1) {
				Annotation annotation = annotations.get(annotations.size()
						- numberOfTokensInLine + numberOfTokensFound);
				annotation.categories = line.substring(start, pos - 1).split(
						"/");
				annotation.offset = tokenOffset;
				tokenOffset = 0;
				numberOfTokensFound += 1;
			}

			// We then check the character which ended the category identifiers.
			// If it was the end-of-line we stop. If it was whitespace we start
			// the next iteration.
			if (pos >= line.length())
				break;
			else if (Character.isWhitespace(c))
				continue;

			// Or it may have been a character outside of those for valid
			// category identifiers. In that case we treat that character as a
			// category name of its own. (This is what allows you to use '?',
			// '_', ':', etc.)
			Annotation annotation = annotations.get(annotations.size()
					- numberOfTokensInLine + numberOfTokensFound);
			annotation.categories = new String[] { "" + c };
			annotation.offset = tokenOffset;
			numberOfTokensFound += 1;
		}

		// We're expecting as many categories as there are tokens.
		if (numberOfTokensFound != numberOfTokensInLine)
			throw new IOException("Number of categories ("
					+ numberOfTokensFound
					+ ") does not match number of tokens ("
					+ numberOfTokensInLine + ").");
	}

	/**
	 * Returns the sample lines in the form of a reader.
	 */
	public Reader getReader() {
		return new StringReader(sample.toString());
	}

	/**
	 * Verifies that the tokens coming from the given source align with the
	 * expected output as defined in the sample.
	 */
	public void assertOutputIsAsExpected(Source<Token> source,
			TokenValidator validator) {
		int i = 0;

		while (true) {
			if (i >= annotations.size()) {
				assertNull("Was not expecting any more tokens.", source.next());
				break;
			}

			Annotation annotation = annotations.get(i);

			String message = "Expected a token at line "
					+ annotation.orginalLineNumber + ", positions "
					+ annotation.positionOnStartLine + "--"
					+ annotation.positionOnEndLine;

			Token token = source.next();
			assertNotNull(message, token);

			message += ". Found " + token + " instead.";

			assertEquals(message, annotation.startLine, token.getStart()
					.getLinenumber());
			assertEquals(message, annotation.positionOnStartLine, token
					.getStart().getPositionInLine());

			assertEquals(message, annotation.endLine, token.getEnd()
					.getLinenumber());
			assertEquals(message, annotation.positionOnEndLine, token.getEnd()
					.getPositionInLine());

			if (annotation.categories != null)
				for (String category : annotation.categories)
					validator.validate(token, category);

			i += 1;
		}
	}

	/**
	 * An annotation defines the expected start and end positions for a token,
	 * as well as the categories to which it belongs.
	 */
	private final class Annotation {
		// This is for debugging. Helps figure out what exact line to look at
		// when something goes wrong.
		public final int orginalLineNumber;

		// Start position. Defined once, and once only.
		public final int startLine;
		public final int positionOnStartLine;

		// End position. This may get updated by annotations which continue an
		// earlier incomplete one.
		public int endLine;
		public int positionOnEndLine;

		// The expected categories. What this means is defined by the validator.
		public String[] categories = null;

		// Possible offset for out-of-order tokens.
		public int offset = 0;

		public Annotation(int orginalLineNumber, int startLine,
				int positionOnStartLine, int endLine, int positionOnEndLine) {
			this.orginalLineNumber = orginalLineNumber;

			this.startLine = startLine;
			this.positionOnStartLine = positionOnStartLine;
			this.endLine = endLine;
			this.positionOnEndLine = positionOnEndLine;
		}
	}

	// TODO Implement this for real. Maybe allow/require a marker for this on
	// the first line ?
	public SourceFormat getFormat() {
		return SourceFormat.FIXED;
	}
}
