package koopa.core.trees.test;

import static koopa.core.util.test.Util.token;
import static koopa.core.util.test.Util.tree;
import koopa.core.trees.Tree;
import koopa.core.trees.TreeWalker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
		assertSame(characters, walker.next());
		assertSame(characters, walker.getCurrent());

		assertSame(mainCharacters, walker.next());
		assertSame(mainCharacters, walker.getCurrent());

		assertSame(calvin, walker.next());
		assertSame(calvin, walker.getCurrent());

		assertSame(hobbes, walker.next());
		assertSame(hobbes, walker.getCurrent());

		assertSame(supportingCharacters, walker.next());
		assertSame(supportingCharacters, walker.getCurrent());

		assertSame(susie, walker.next());
		assertSame(susie, walker.getCurrent());

		assertSame(rosalyn, walker.next());
		assertSame(rosalyn, walker.getCurrent());

		assertSame(null, walker.next());
		assertSame(null, walker.getCurrent());
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
		assertSame(mainCharacters, walker.next());
		assertSame(calvin, walker.next());
		assertSame(hobbes, walker.next());
		assertSame(null, walker.next());
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
		assertSame(characters, walker.next());
		assertSame(mainCharacters, walker.next());
		assertSame(calvin, walker.next());

		walker.skipRemainderOfTree(mainCharacters);

		assertSame(supportingCharacters, walker.next());

		walker.skipRemainderOfTree(supportingCharacters);

		assertSame(null, walker.next());
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

		assertSame(characters, walker.next());

		TreeWalker.State state = walker.getState();

		assertSame(mainCharacters, walker.next());
		assertSame(calvin, walker.next());

		walker.setState(state);

		assertSame(mainCharacters, walker.next());
		assertSame(calvin, walker.next());
	}
}
