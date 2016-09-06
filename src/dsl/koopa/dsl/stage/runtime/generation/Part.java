package koopa.dsl.stage.runtime.generation;

import java.util.LinkedList;

import koopa.dsl.stage.runtime.model.GrammarTestDefinition;

/**
 * Base class for the different parts which can appear in a
 * {@linkplain GrammarTestDefinition}.
 */
public abstract class Part {

	/** What part is following this one ? */
	protected Part nextPart = null;

	public void setNextPart(Part nextPart) {
		this.nextPart = nextPart;
	}

	public void buildTests(TestBuilder builder) {
		includeInTests(builder, new LinkedList<Part>());
	}

	/**
	 * Add this part to the test(s) being built by the {@linkplain TestBuilder},
	 * then pass the message on the next (queued) parts (via
	 * {@link #addFurtherParts(TestBuilder, LinkedList)}).
	 */
	public abstract void includeInTests(TestBuilder builder,
			LinkedList<Part> furtherParts);

	protected void addFurtherParts(TestBuilder builder,
			LinkedList<Part> furtherParts) {
		if (nextPart != null) {
			nextPart.includeInTests(builder, furtherParts);

		} else if (furtherParts.size() > 0) {
			Part n = furtherParts.removeFirst();
			n.includeInTests(builder, furtherParts);
			furtherParts.addFirst(n);

		} else
			builder.commit();
	}
}
