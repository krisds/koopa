package koopa.core.grammars.fluent.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class FluentGrammarTest {

	/**
	 * I was getting a {@linkplain StackOverflowError} previously, due to a bit
	 * of naive coding.
	 */
	@Test
	public void testBuildingRecursiveHelperDoesNotOverflowTheStack() {
		FluentTestGrammar grammar = new FluentTestGrammar();

		grammar.defineHelper("recursive").as("recursive");

		assertNotNull(grammar.definitionOf("recursive").asParser());
	}
}
