package koopa.core.trees.test;

import static koopa.core.util.test.Util.token;
import static koopa.core.util.test.Util.tree;
import koopa.core.trees.Tree;
import koopa.core.trees.TreeWalker;

import org.junit.Assert;
import org.junit.Test;

public class TreeWalkerTest {

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

		TreeWalker walker = new TreeWalker(characters);
		Assert.assertSame(characters, walker.next());
		Assert.assertSame(characters, walker.getCurrent());

		Assert.assertSame(mainCharacters, walker.next());
		Assert.assertSame(mainCharacters, walker.getCurrent());

		Assert.assertSame(calvin, walker.next());
		Assert.assertSame(calvin, walker.getCurrent());

		Assert.assertSame(hobbes, walker.next());
		Assert.assertSame(hobbes, walker.getCurrent());

		Assert.assertSame(supportingCharacters, walker.next());
		Assert.assertSame(supportingCharacters, walker.getCurrent());

		Assert.assertSame(susie, walker.next());
		Assert.assertSame(susie, walker.getCurrent());

		Assert.assertSame(rosalyn, walker.next());
		Assert.assertSame(rosalyn, walker.getCurrent());

		Assert.assertSame(null, walker.next());
		Assert.assertSame(null, walker.getCurrent());
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

		TreeWalker walker = new TreeWalker(mainCharacters);
		Assert.assertSame(mainCharacters, walker.next());
		Assert.assertSame(calvin, walker.next());
		Assert.assertSame(hobbes, walker.next());
		Assert.assertSame(null, walker.next());
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

		TreeWalker walker = new TreeWalker(characters);
		Assert.assertSame(characters, walker.next());
		Assert.assertSame(mainCharacters, walker.next());
		Assert.assertSame(calvin, walker.next());

		walker.skipRemainderOfTree(mainCharacters);

		Assert.assertSame(supportingCharacters, walker.next());

		walker.skipRemainderOfTree(supportingCharacters);

		Assert.assertSame(null, walker.next());
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

		TreeWalker walker = new TreeWalker(characters);

		Assert.assertSame(characters, walker.next());

		TreeWalker.State state = walker.getState();

		Assert.assertSame(mainCharacters, walker.next());
		Assert.assertSame(calvin, walker.next());

		walker.setState(state);

		Assert.assertSame(mainCharacters, walker.next());
		Assert.assertSame(calvin, walker.next());
	}
}
