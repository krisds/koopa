package koopa.core.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.Start;
import koopa.core.data.tags.AreaTag;
import koopa.core.treeparsers.Tree;

public class KoopaTreeBuilder extends TreeBuildingTarget {

	/**
	 * Any leaves preceding the first tree get tracked here. They will be added
	 * to the first tree once we get it.
	 */
	private LinkedList<Tree> leading = new LinkedList<Tree>();

	/**
	 * Tree being built.
	 */
	private Stack<Tree> treeparts = new Stack<Tree>();

	/**
	 * Trees which have been built.
	 */
	private List<Tree> trees = new LinkedList<Tree>();

	public KoopaTreeBuilder() {
		this(false);
	}

	public KoopaTreeBuilder(boolean hideWater) {
		super(hideWater);
	}

	public List<Tree> getTrees() {
		return this.trees;
	}

	public Tree getTree() {
		if (trees.isEmpty())
			return null;
		else
			return trees.get(0);
	}

	/** {@inheritDoc} */
	public void down(Start start) {
		Tree tree = new Tree(start);

		if (!this.treeparts.isEmpty())
			this.treeparts.peek().addChild(tree);
		else
			while (!leading.isEmpty())
				tree.addChild(leading.removeFirst());

		this.treeparts.push(tree);
	}

	/** {@inheritDoc} */
	public void leaf(Token token) {
		if (!token.hasTag(AreaTag.PROGRAM_TEXT_AREA)
				&& !token.hasTag(AreaTag.COMMENT))
			return;

		// We want to ignore all whitespace in the code, as it just makes the
		// tree much bigger than it needs to be. Comments, however, are kept
		// intact.
		if (!token.hasTag(AreaTag.COMMENT)
				&& token.getText().trim().length() == 0)
			return;

		Tree tree = new Tree(token);

		if (!this.treeparts.isEmpty())
			this.treeparts.peek().addChild(tree);
		else
			leading.add(tree);
	}

	/** {@inheritDoc} */
	public void up(End end) {
		assert (!this.treeparts.isEmpty());

		final Tree tree = this.treeparts.pop();

		if (this.treeparts.isEmpty())
			this.trees.add(tree);
	}

	/** {@inheritDoc} */
	public void water(InWater water) {
		Tree tree = new Tree(water);

		if (!this.treeparts.isEmpty())
			this.treeparts.peek().addChild(tree);

		this.treeparts.push(tree);
	}

	/** {@inheritDoc} */
	public void land() {
		assert (!this.treeparts.isEmpty());

		final Tree tree = this.treeparts.pop();

		if (this.treeparts.isEmpty())
			this.trees.add(tree);
	}
}
