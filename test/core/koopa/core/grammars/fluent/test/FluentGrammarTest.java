package koopa.core.grammars.fluent.test;

import org.junit.Assert;
import org.junit.Test;

public class FluentGrammarTest {

	/**
	 * I was getting a {@linkplain StackOverflowError} previously, due to a bit
	 * of naive coding.
	 */
	@Test
	public void testBuildingRecursiveHelperDoesNotOverflowTheStack() {
		FluentTestGrammar grammar = new FluentTestGrammar();

		grammar.defineHelper("recursive").as("recursive");

		Assert.assertNotNull(grammar.definitionOf("recursive").asParser());
	}
}
