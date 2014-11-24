package koopa.core.trees.antlr;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.Start;
import koopa.core.data.tags.AreaTag;
import koopa.core.trees.TreeBuilder;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;

public class CommonTreeBuilder implements TreeBuilder {

	private Stack<CommonTree> treeparts = new Stack<CommonTree>();
	private List<CommonTree> trees = new LinkedList<CommonTree>();

	private ANTLRTokens types = null;

	public CommonTreeBuilder(ANTLRTokens types) {
		assert (types != null);
		this.types = types;
	}

	public List<CommonTree> getTrees() {
		return this.trees;
	}

	public void down(Start start) {
		CommonToken antlrToken = new CommonKoopaToken(start, this.types);
		CommonTree antlrTree = new CommonTree(antlrToken);

		if (!this.treeparts.isEmpty()) {
			this.treeparts.peek().addChild(antlrTree);
		}

		this.treeparts.push(antlrTree);
	}

	public void leaf(Token token) {
		// TODO registerPossibleStart(token);

		if (!token.hasTag(AreaTag.PROGRAM_TEXT_AREA) && !token.hasTag(AreaTag.COMMENT))
			return;

		if (token.getText().trim().length() == 0)
			return;

		CommonToken antlrToken = new CommonKoopaToken(token, this.types);
		CommonTree antlrTree = new CommonTree(antlrToken);
		this.treeparts.peek().addChild(antlrTree);
	}

	public void up(End end) {
		assert (!this.treeparts.isEmpty());

		final CommonTree antlrTree = this.treeparts.pop();

		// TODO registerEnd(antlrTree);

		if (this.treeparts.isEmpty()) {
			this.trees.add(antlrTree);
		}
	}

	@Override
	public void water(InWater water) {
		CommonToken antlrToken = new CommonKoopaToken(water, this.types);
		CommonTree antlrTree = new CommonTree(antlrToken);

		if (!this.treeparts.isEmpty()) {
			this.treeparts.peek().addChild(antlrTree);
		}

		this.treeparts.push(antlrTree);
	}

	public void land() {
		assert (!this.treeparts.isEmpty());

		final CommonTree antlrTree = this.treeparts.pop();

		// TODO registerEnd(antlrTree);

		if (this.treeparts.isEmpty()) {
			this.trees.add(antlrTree);
		}
	}
}
