package koopa.dsl.stage.runtime;

import static koopa.core.data.tags.IslandTag.WATER;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.Start;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.sources.Source;
import koopa.core.sources.test.TestTokenizer;
import koopa.core.targets.ListTarget;
import koopa.core.util.Files;
import koopa.core.util.Reflect;
import koopa.dsl.stage.runtime.model.SuiteOfStages;

/**
 * Base for a test suite which wants to exercise the different rules of a
 * grammar. All you need to do is provide a list of stage files (via
 * {@linkplain #getStageFiles()}, give it an instance of your grammar (via
 * {@linkplain #getGrammar()}, and tell it how an input is to be tokenized (via
 * {@link #getSourceForSample(String, Grammar)}).
 */
public abstract class GrammarTestSuite {

	public abstract File[] getStageFiles();

	public abstract Grammar getGrammar();

	public abstract Source getSourceForSample(String sample,
			Grammar grammar);

	/**
	 * Generates dynamic tests for all grammar rules defined in the stage files.
	 * Each test exercises a specific grammar rule with sample input that should
	 * either be accepted or rejected.
	 */
	@TestFactory
	public Stream<DynamicTest> generateGrammarTests() throws IOException {
		final File[] sources = getStageFiles();
		if (sources == null || sources.length == 0) {
			throw new IllegalStateException("No stage files provided");
		}

		final SuiteOfStages testsuite = new SuiteOfStages(sources);

		return testsuite.getStages().stream()
			.flatMap(stage -> stage.getTargets().stream()
				.flatMap(target -> {
					AtomicInteger index = new AtomicInteger(0);
					return target.getTests().stream()
						.map(test -> DynamicTest.dynamicTest(
							formatTestName(test, index.getAndIncrement()),
							() -> executeTest(test)
						));
				}));
	}

	/**
	 * Formats a test name for display in test results.
	 */
	private String formatTestName(GrammarTest test, int index) {
		return Files.getName(test.getStage()) + ":" + test.getTarget() + ":" + index
				+ " " + (test.shouldAccept() ? "accept" : "reject")
				+ " [" + test.getSample() + "]";
	}

	/**
	 * Executes a single grammar test.
	 * <p>
	 * If the test should accept ({@linkplain GrammarTest#shouldAccept()} then
	 * we check that the parse was successful and reached the expected point. We
	 * also verify that there is no water in the output, apart from that found
	 * between "unknown" start and end markers.
	 * <p>
	 * If the test should reject then we check that the parse failed, or that it
	 * did not reach the expected point in the input.
	 */
	private void executeTest(GrammarTest test) throws IOException {
		final Grammar grammar = getGrammar();
		final String targetName = test.getTarget();

		final ParserCombinator target = Reflect.getParser(grammar, targetName);
		assertNotNull(target, "Parser for target '" + targetName + "' should not be null");

		final TestTokenizer source = new TestTokenizer(
				getSourceForSample(test.getSample(), grammar));

		if (test.shouldAccept()) {
			ListTarget resultingData = new ListTarget();
			Parse parse = Parse.of(source).to(resultingData);

			try {
				final boolean accepts = target.accepts(parse);

				assertTrue(accepts,
						targetName + " should accept [" + test.getSample() + "]");
				assertTrue(source.isWhereExpected(),
						targetName + " should accept [" + test.getSample()
								+ "] up to the expected point. Got to "
								/*+ parse.getFinalFrame().toTrace()*/ + ".");

			} catch (Exception e) {
				e.printStackTrace();
				fail(targetName + " should accept [" + test.getSample()
						+ "], but threw " + e);
			}

			int inUnknown = 0;
			for (Data data : resultingData) {
				if (data instanceof Start) {
					Start start = (Start) data;
					if ("unknown".equals(start.getName()))
						inUnknown += 1;

				} else if (data instanceof End) {
					End end = (End) data;
					if ("unknown".equals(end.getName()))
						inUnknown -= 1;

				} else if (inUnknown == 0 && data instanceof Token) {
					Token token = (Token) data;
					assertFalse(token.hasTag(WATER),
							targetName + " should find no water in ["
									+ test.getSample() + "]");
				}
			}

		} else {
			Parse parse = Parse.of(source);
			assertFalse(target.accepts(parse) && source.isWhereExpected(),
					targetName + " should reject [" + test.getSample() + "]");
		}
	}
}
