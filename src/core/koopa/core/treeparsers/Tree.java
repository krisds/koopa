package koopa.core.treeparsers;

import static koopa.core.data.tags.AreaTag.COMMENT;
import static koopa.core.data.tags.AreaTag.PROGRAM_TEXT_AREA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Data;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.data.markers.Start;

public class Tree {

	private Data data;

	private List<Tree> children;
	private int childIndex = -1;
	private Tree parent;

	public Tree(Data data) {
		this.data = data;
		this.children = new ArrayList<Tree>();
		this.parent = null;
	}

	public String getText() {
		if (data instanceof Token)
			return ((Token) data).getText();
		else
			return "";
	}

	public String getProgramText() {
		StringBuilder builder = new StringBuilder();
		gather(builder);
		return builder.toString();
	}

	private void gather(StringBuilder builder) {
		if (!children.isEmpty()) {
			for (int i = 0; i < children.size(); i++)
				children.get(i).gather(builder);

			return;
		}

		if (!(data instanceof Token))
			return;

		Token token = (Token) data;

		if (!token.hasTag(PROGRAM_TEXT_AREA))
			return;
		if (token.hasTag(COMMENT))
			return;

		if (builder.length() > 0)
			builder.append(" ");

		builder.append(token.getText());
	}

	public Data getData() {
		return data;
	}

	public Position getStart() {
		final Position start = (data instanceof Token) ? ((Token) data)
				.getStart() : null;

		if (start != null)
			return start;

		for (int i = 0; i < children.size(); i++) {
			Position position = children.get(i).getStart();

			if (position != null)
				return position;
		}

		return null;
	}

	public Position getEnd() {
		final Position end = (data instanceof Token) ? ((Token) data).getEnd()
				: null;

		if (end != null)
			return end;

		for (int i = children.size() - 1; i >= 0; i--) {
			Position position = children.get(i).getEnd();

			if (position != null)
				return position;
		}

		return null;
	}

	public void addChild(Tree child) {
		child.childIndex = children.size();
		children.add(child);
		child.parent = this;
	}

	public boolean hasChildren() {
		return !children.isEmpty();
	}

	public int getChildCount() {
		return children.size();
	}

	public Tree getChild(int i) {
		return children.get(i);
	}

	public List<Tree> getChildren() {
		return new ArrayList<Tree>(children);
	}

	public Tree getParent() {
		return parent;
	}

	public int getChildIndex() {
		return childIndex;
	}

	public int getLine() {
		return getStart().getLinenumber();
	}

	@Override
	public String toString() {
		return data.toString();
	}

	public Tree getRoot() {
		if (parent == null)
			return this;
		else
			return parent.getRoot();
	}

	public List<Token> getTokens() {
		final LinkedList<Token> tokens = new LinkedList<Token>();
		gather(tokens);
		return tokens;
	}

	private void gather(List<Token> tokens) {
		if (!children.isEmpty()) {
			for (int i = 0; i < children.size(); i++)
				children.get(i).gather(tokens);

		} else {
			if (!(data instanceof Token))
				return;

			tokens.add((Token) data);
		}
	}

	public boolean isNode(String name) {
		if (data == null)
			return false;

		if ((data instanceof Start))
			return false;

		return name.equals(((Start) data).getName());
	}
}
