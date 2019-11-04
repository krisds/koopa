package koopa.dsl.stage.runtime.model;

import java.util.LinkedList;
import java.util.List;

import koopa.core.trees.Tree;
import koopa.dsl.stage.runtime.GrammarTest;
import koopa.dsl.stage.runtime.GrammarTestSuiteRunner;
import koopa.dsl.stage.runtime.generation.Part;
import koopa.dsl.stage.runtime.generation.TestBuilder;

/**
 * A collection of tests (through {@linkplain GrammarTestDefinition}s) for a
 * specific grammar rule.
 */
public class Target {

	/** The {@linkplain Stage} this collection of tests was defined in. */
	private final Stage stage;

	/** The name of the grammar rule we're testing. */
	private final String name;

	/** All tests defined for this grammar rule. */
	private final List<GrammarTestDefinition> testDefinitions;

	/**
	 * The subset of {@link #testDefinitions} which are formative (cfr.
	 * {@linkplain} {@link GrammarTestDefinition#isFormative()}).
	 */
	private final List<GrammarTestDefinition> formativeDefinitions;

	/**
	 * When generating actual tests, this variable helps cycle through all
	 * definitions.
	 */
	private int nextDefinitionToBeUsedWhenReferenced = 0;

	public Target(Stage stage, Tree targetDefinition) {
		this.stage = stage;

		this.name = targetDefinition.getChild("identifier").getAllText();

		this.testDefinitions = new LinkedList<>();
		this.formativeDefinitions = new LinkedList<>();

		for (Tree testDefinition : targetDefinition.getChildren("test")) {
			GrammarTestDefinition def = new GrammarTestDefinition(this,
					testDefinition);

			this.testDefinitions.add(def);

			if (def.isFormative())
				this.formativeDefinitions.add(def);
		}
	}

	public Stage getStage() {
		return stage;
	}

	public SuiteOfStages getSuite() {
		return stage.getSuite();
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	public List<GrammarTest> getTests() {
		List<GrammarTest> tests = new LinkedList<>();

		for (GrammarTestDefinition def : testDefinitions)
			tests.addAll(def.getTests());

		return tests;
	}

	public void includeInTests(TestBuilder builder, LinkedList<Part> next) {
		if (formativeDefinitions.isEmpty()) {
			return;

		} else if (!GrammarTestSuiteRunner.RANDOMIZE_TESTS) {
			// When not in random mode we cycle through the formative
			// definitions when asked for a sample to be included in the tests.
			final int index = nextDefinitionToBeUsedWhenReferenced;
			nextDefinitionToBeUsedWhenReferenced = (nextDefinitionToBeUsedWhenReferenced + 1)
					% formativeDefinitions.size();
			formativeDefinitions.get(index).includeInTests(builder, next);
			return;

		} else {
			// In random mode we just pick a random formative definition to
			// provide the sample to be included in the tests.
			int random = GrammarTestSuiteRunner.RANDOMIZER
					.nextInt(formativeDefinitions.size());
			formativeDefinitions.get(random).includeInTests(builder, next);
			return;
		}
	}
}