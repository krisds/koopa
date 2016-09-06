package koopa.dsl.stage.runtime.generation;

import java.util.LinkedList;

import koopa.core.sources.test.TestTokenizer;

/**
 * This marks a point in the grammar unit test where we expect the parser to end
 * up processing the input. Sometimes an example needs to extend beyond the
 * grammar rule you're testing, but still want to make sure it parses the part
 * you think it parses. That's what the marker is for.
 */
public class Mark extends Part {

	private static final String MARKER = " " + TestTokenizer.MARKER_TEXT + " ";

	@Override
	public void includeInTests(TestBuilder builder,
			LinkedList<Part> furtherParts) {
		builder.push(MARKER);
		addFurtherParts(builder, furtherParts);
		builder.pop();
	}
}
