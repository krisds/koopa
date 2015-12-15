package koopa.dsl.stage.runtime;

import static koopa.core.data.tags.IslandTag.WATER;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.Start;
import koopa.core.grammars.Grammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;
import koopa.core.sources.test.TestTokenizer;
import koopa.core.targets.ListTarget;
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
			ListTarget resultingData = new ListTarget();
			Parse parse = Parse.of(source).to(resultingData);
			assertTrue(targetName + " should accept [" + sample + "]",
					target.accepts(parse));
			assertTrue(targetName + " should accept [" + sample
					+ "] up to the expected point", source.isWhereExpected());

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
					assertFalse(targetName + " should find no water in ["
							+ sample + "]", token.hasTag(WATER));
				}
			}

		} else {
			Parse parse = Parse.of(source);
			assertFalse(targetName + " should accept [" + sample
					+ "] up to the expected point", target.accepts(parse)
					&& source.isWhereExpected());
		}
	}
}
