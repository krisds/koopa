package koopa.dsl.stage.runtime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.sources.test.TestTokenizer;
import koopa.core.util.Reflect;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Stages.class)
public abstract class AllStagesTest implements SampleBasedTest {

	private String grammarName;
	private String testSourceName;
	private String targetName;
	private boolean shouldAccept;
	private String sample;

	public void setData(String grammarName, String testSourceName,
			String targetName, boolean shouldAccept, String sample) {

		this.grammarName = grammarName;
		this.testSourceName = testSourceName;
		this.targetName = targetName;
		this.shouldAccept = shouldAccept;
		this.sample = sample;
	}

	@Test
	public void testParsing() throws IOException {
		final Grammar grammar = Reflect.asInstanceOf( //
				Grammar.class, grammarName);
		final TestSource testSource = Reflect.asInstanceOf( //
				TestSource.class, testSourceName);
		final ParserCombinator target = Reflect.getParser( //
				grammar, targetName);

		assertNotNull(target);

		final TestTokenizer source = new TestTokenizer(
				testSource.forSample(sample));

		if (shouldAccept) {
			assertTrue(target.accepts(Parse.of(source)));
			assertTrue(source.isWhereExpected());

		} else {
			assertFalse(target.accepts(Parse.of(source))
					&& source.isWhereExpected());
		}
	}
}
