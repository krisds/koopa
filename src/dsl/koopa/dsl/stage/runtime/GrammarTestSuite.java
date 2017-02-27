package koopa.dsl.stage.runtime;

import static koopa.core.data.tags.IslandTag.WATER;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

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
import koopa.core.util.Reflect;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Base for a test suite which wants to exercise the different rules of a
 * grammar. All you need to do is provide a list of stage files (via
 * {@linkplain #getStageFiles()}, give it an instance of your grammar (via
 * {@linkplain #getGrammar()}, and tell it how an input is to be tokenized (via
 * {@link #getSourceForSample(String, Grammar)}).
 */
@RunWith(GrammarTestSuiteRunner.class)
public abstract class GrammarTestSuite {

	private GrammarTest test;

	public abstract File[] getStageFiles();

	public abstract Grammar getGrammar();

	public abstract Source getSourceForSample(String sample,
			Grammar grammar);

	public void setTest(GrammarTest test) {
		this.test = test;
	}

	/**
	 * The actual test, based on the data from the {@linkplain GrammarTest}
	 * which will have been set.
	 * <p>
	 * If the test should accept ({@linkplain GrammarTest#shouldAccept()} then
	 * we check that the parse was successful and reached the expected point. We
	 * also verify that there is no water in the output, apart from that found
	 * between "unknown" start and end markers.
	 * <p>
	 * If the test should reject then we check that the parse failed, or that it
	 * did not reach the expected point in the input.
	 */
	@Test
	public void testParsing() throws IOException {
		final Grammar grammar = getGrammar();
		final String targetName = test.getTarget();

		final ParserCombinator target = Reflect.getParser(grammar, targetName);
		assertNotNull(target);

		final TestTokenizer source = new TestTokenizer(
				getSourceForSample(test.getSample(), grammar));

		if (test.shouldAccept()) {
			ListTarget resultingData = new ListTarget();
			Parse parse = Parse.of(source).to(resultingData);

			try {
				final boolean accepts = target.accepts(parse);

				assertTrue(targetName + " should accept [" + test.getSample()
						+ "]", accepts);
				assertTrue(
						targetName + " should accept [" + test.getSample()
								+ "] up to the expected point. Got to "
								/*+ parse.getFinalFrame().toTrace()*/ + ".", //
						source.isWhereExpected());

			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail(targetName + " should accept [" + test.getSample()
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
					assertFalse(
							targetName + " should find no water in ["
									+ test.getSample() + "]",
							token.hasTag(WATER));
				}
			}

		} else {
			Parse parse = Parse.of(source);
			assertFalse(
					targetName + " should reject [" + test.getSample() + "]",
					target.accepts(parse) && source.isWhereExpected());
		}
	}
}
