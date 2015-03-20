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

public class KoopaTreeBuilder implements TreeBuilder {

	private Stack<Tree> treeparts = new Stack<Tree>();
	private List<Tree> trees = new LinkedList<Tree>();

	public KoopaTreeBuilder() {
	}

	public List<Tree> getTrees() {
		return this.trees;
	}

	public void down(Start start) {
		Tree tree = new Tree(start);

		if (!this.treeparts.isEmpty())
			this.treeparts.peek().addChild(tree);

		this.treeparts.push(tree);
	}

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
		this.treeparts.peek().addChild(tree);
	}

	public void up(End end) {
		assert (!this.treeparts.isEmpty());

		final Tree tree = this.treeparts.pop();

		if (this.treeparts.isEmpty())
			this.trees.add(tree);
	}

	public void water(InWater water) {
		Tree tree = new Tree(water);

		if (!this.treeparts.isEmpty())
			this.treeparts.peek().addChild(tree);

		this.treeparts.push(tree);
	}

	public void land() {
		assert (!this.treeparts.isEmpty());

		final Tree tree = this.treeparts.pop();

		if (this.treeparts.isEmpty())
			this.trees.add(tree);
	}
}
