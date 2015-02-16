package koopa.core.treeparsers.test;

import static koopa.core.util.test.Util.token;
import static koopa.core.util.test.Util.tree;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.treeparsers.BasicTreeStream;
import koopa.core.treeparsers.Tree;
import koopa.core.treeparsers.TreeStream;

import org.junit.Assert;
import org.junit.Test;

public class TreeStreamTest {

	@Test
	public void canWalkDepthFirst() {
		Tree calvin = token("Calvin");
		Tree hobbes = token("Hobbes");
		Tree susie = token("Susie");
		Tree rosalyn = token("Rosalyn");

		Tree mainCharacters = tree("main", calvin, hobbes);
		Tree supportingCharacters = tree("supporting", susie, rosalyn);

		Tree characters = tree("characters", mainCharacters,
				supportingCharacters);

		TreeStream stream = new BasicTreeStream(characters);

		assertStartOf("characters", stream.forward());
		assertStartOf("main", stream.forward());
		assertToken("Calvin", stream.forward());
		assertToken("Hobbes", stream.forward());
		assertStartOf("supporting", stream.forward());
		assertToken("Susie", stream.forward());
		assertToken("Rosalyn", stream.forward());
		Assert.assertNull(stream.forward());
	}

	@Test
	public void willScopeCorrectly() {
		Tree calvin = token("Calvin");
		Tree hobbes = token("Hobbes");
		Tree susie = token("Susie");
		Tree rosalyn = token("Rosalyn");

		Tree mainCharacters = tree("main", calvin, hobbes);
		Tree supportingCharacters = tree("supporting", susie, rosalyn);

		tree("characters", mainCharacters, supportingCharacters);

		TreeStream stream = new BasicTreeStream(mainCharacters);

		assertStartOf("main", stream.forward());
		assertToken("Calvin", stream.forward());
		assertToken("Hobbes", stream.forward());
		Assert.assertNull(stream.forward());
	}

	@Test
	public void willSkipCorrectly() {
		Tree calvin = token("Calvin");
		Tree hobbes = token("Hobbes");
		Tree susie = token("Susie");
		Tree rosalyn = token("Rosalyn");

		Tree mainCharacters = tree("main", calvin, hobbes);
		Tree supportingCharacters = tree("supporting", susie, rosalyn);

		Tree characters = tree("characters", mainCharacters,
				supportingCharacters);

		TreeStream stream = new BasicTreeStream(characters);

		assertStartOf("characters", stream.forward());

		assertStartOf("main", stream.forward());

		TreeStream subStream = stream.forSubtree();

		assertToken("Calvin", subStream.forward());

		subStream.commitSubtree();

		assertStartOf("supporting", stream.forward());
	}

	@Test
	public void willSaveAndRestoreState() {
		Tree calvin = token("Calvin");
		Tree hobbes = token("Hobbes");
		Tree susie = token("Susie");
		Tree rosalyn = token("Rosalyn");

		Tree mainCharacters = tree("main", calvin, hobbes);
		Tree supportingCharacters = tree("supporting", susie, rosalyn);

		Tree characters = tree("characters", mainCharacters,
				supportingCharacters);

		TreeStream stream = new BasicTreeStream(characters);

		assertStartOf("characters", stream.forward());

		stream.bookmark();

		assertStartOf("main", stream.forward());
		assertToken("Calvin", stream.forward());

		stream.rewind();

		assertStartOf("main", stream.forward());
		assertToken("Calvin", stream.forward());
	}

	private void assertStartOf(String name, Data data) {
		Assert.assertTrue("No Start: " + data, data instanceof Start);

		Start start = (Start) data;
		Assert.assertEquals(name, start.getName());
	}

	private void assertToken(String text, Data data) {
		Assert.assertTrue("No Token: " + data, data instanceof Token);

		Token token = (Token) data;
		Assert.assertEquals(text, token.getText());
	}
}
