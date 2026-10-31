package koopa.core.trees.test;

import static koopa.core.util.test.Util.t;
import static koopa.core.util.test.Util.tree;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import koopa.core.data.markers.End;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.OnLand;
import koopa.core.data.markers.Start;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;

public class KoopaTreeBuilderTest {

	private static final Start NODE = Start.on("test", "node");
	private static final End NODE_END = End.on("test", "node");

	@Test
	public void graftsASubtreeAtTheCurrentPosition() {
		final KoopaTreeBuilder builder = new KoopaTreeBuilder(null);
		final Tree subtree = tree("directive", t("EJECT"));

		builder.push(NODE);
		builder.push(t("before"));
		builder.push(subtree);
		builder.push(t("after"));
		builder.push(NODE_END);

		final Tree built = builder.getTree();
		assertEquals(3, built.getChildCount());
		assertSame(subtree, built.getChild(1));
	}

	@Test
	public void keepsALeadingSubtreeForTheFirstTree() {
		final KoopaTreeBuilder builder = new KoopaTreeBuilder(null);
		final Tree subtree = tree("directive", t("EJECT"));

		builder.push(subtree);
		builder.push(NODE);
		builder.push(t("text"));
		builder.push(NODE_END);

		final Tree built = builder.getTree();
		assertEquals(2, built.getChildCount());
		assertSame(subtree, built.getChild(0));
	}

	@Test
	public void keepsASubtreeInsideWater() {
		final KoopaTreeBuilder builder = new KoopaTreeBuilder(null);
		final Tree subtree = tree("directive", t("EJECT"));

		builder.push(NODE);
		builder.push(InWater.getInstance());
		builder.push(subtree);
		builder.push(OnLand.getInstance());
		builder.push(NODE_END);

		final Tree built = builder.getTree();
		assertEquals(1, built.getChildCount());
		final Tree water = built.getChild(0);
		assertSame(InWater.getInstance(), water.getData());
		assertEquals(1, water.getChildCount());
		assertSame(subtree, water.getChild(0));
	}

	@Test
	public void dropsASubtreeInsideHiddenWater() {
		final KoopaTreeBuilder builder = new KoopaTreeBuilder(null, true);
		final Tree subtree = tree("directive", t("EJECT"));

		builder.push(NODE);
		builder.push(InWater.getInstance());
		builder.push(subtree);
		builder.push(OnLand.getInstance());
		builder.push(t("text"));
		builder.push(NODE_END);

		final Tree built = builder.getTree();
		assertEquals(1, built.getChildCount());
		assertEquals("text", built.getChild(0).getText());
	}
}
