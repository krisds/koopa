package koopa.dsl.stage.runtime.generation;

import java.util.LinkedList;

import koopa.core.trees.Tree;

/** A fragment is just a piece of text. */
public class Fragment extends Part {

	private final String text;

	public Fragment(Tree definition) {
		final String allText = definition.getAllText();
		this.text = allText.substring(1, allText.length() - 1);
	}

	@Override
	public void includeInTests(TestBuilder builder,
			LinkedList<Part> furtherParts) {
		builder.push(text);
		addFurtherParts(builder, furtherParts);
		builder.pop();
	}
}
