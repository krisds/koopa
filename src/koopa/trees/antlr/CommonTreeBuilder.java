package koopa.trees.antlr;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import koopa.parsers.markers.DownMarker;
import koopa.parsers.markers.UpMarker;
import koopa.parsers.markers.WaterMarker;
import koopa.tokens.Token;
import koopa.trees.TreeBuilder;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;

public class CommonTreeBuilder implements TreeBuilder {

	private Stack<CommonTree> treeparts = new Stack<CommonTree>();

	private List<CommonTree> trees = new LinkedList<CommonTree>();

	private TokenTypes types = null;

	public CommonTreeBuilder(TokenTypes types) {
		assert (types != null);
		this.types = types;
	}

	public List<CommonTree> getTrees() {
		return this.trees;
	}

	public void down(DownMarker down) {
		CommonToken antlrToken = new CommonKoopaToken(down, this.types);
		CommonTree antlrTree = new CommonTree(antlrToken);

		if (!this.treeparts.isEmpty()) {
			this.treeparts.peek().addChild(antlrTree);
		}

		this.treeparts.push(antlrTree);
	}

	public void leaf(Token token) {
		registerPossibleStart(token);

		CommonToken antlrToken = new CommonKoopaToken(token, this.types);
		CommonTree antlrTree = new CommonTree(antlrToken);
		this.treeparts.peek().addChild(antlrTree);
	}

	public void up(UpMarker up) {
		assert (!this.treeparts.isEmpty());

		final CommonTree antlrTree = this.treeparts.pop();

		registerEnd(antlrTree);

		if (this.treeparts.isEmpty()) {
			this.trees.add(antlrTree);
		}
	}

	public void water(WaterMarker water) {
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

		registerEnd(antlrTree);

		if (this.treeparts.isEmpty()) {
			this.trees.add(antlrTree);
		}
	}

	private void registerPossibleStart(Token token) {
		int i = this.treeparts.size() - 1;

		while (i >= 0) {
			final CommonTree antlrTree = this.treeparts.get(i);
			final CommonKoopaToken antlrToken = (CommonKoopaToken) antlrTree
					.getToken();
			final Token koopaToken = antlrToken.getKoopaToken();

			if (koopaToken.getStart() == null) {
				koopaToken.setStart(token.getStart());
				i -= 1;
			} else {
				break;
			}
		}
	}

	private void registerEnd(final CommonTree antlrTree) {
		final int count = antlrTree.getChildCount();

		int i = count - 1;
		while (i >= 0) {
			final CommonTree antlrChild = (CommonTree) antlrTree.getChild(i);
			final CommonKoopaToken commonKoopaToken = (CommonKoopaToken) antlrChild
					.getToken();
			final Token koopaToken = commonKoopaToken.getKoopaToken();

			if (koopaToken != null && koopaToken.getEnd() != null) {
				((CommonKoopaToken) antlrTree.getToken()).getKoopaToken()
						.setEnd(koopaToken.getEnd());
				break;
			}

			i -= 1;
		}
	}
}
