package koopa.core.grammars.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.parsers.Parser;
import koopa.core.sources.test.HardcodedSource;
import koopa.core.targets.ListTarget;

public abstract class GrammarTest {

	private static final String END_OF_INPUT = "$";

	protected final TestGrammar G;

	protected GrammarTest(String... separators) {
		G = new TestGrammar(separators);
	}

	protected List<Object> input(Object... taggedWords) {
		List<Object> r = new ArrayList<Object>(taggedWords.length + 1);
		r.addAll(Arrays.asList(taggedWords));
		return r;
	}

	protected void shouldReject(Parser parser, List<Object> taggedWords) {
		Parser p = G.sequence(parser, G.token(END_OF_INPUT));
		taggedWords.add(END_OF_INPUT);

		HardcodedSource source = new HardcodedSource(taggedWords);
		ListTarget target = new ListTarget();

		Assert.assertFalse(p.accepts(source, target));
	}

	protected void shouldAccept(Parser parser, List<Object> taggedWords) {
		Parser p = G.sequence(parser, G.token(END_OF_INPUT));
		taggedWords.add(END_OF_INPUT);

		HardcodedSource source = new HardcodedSource(taggedWords);
		ListTarget target = new ListTarget();

		Assert.assertTrue(p.accepts(source, target));
		Assert.assertTrue(target.size() > 0);
		final Data packet = target.get(target.size() - 1);
		Assert.assertTrue(packet instanceof Token);
		Assert.assertEquals(END_OF_INPUT, ((Token) packet).getText());
	}
}
