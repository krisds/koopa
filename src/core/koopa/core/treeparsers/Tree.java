package koopa.core.treeparsers;

import java.util.ArrayList;
import java.util.List;

import koopa.core.data.Data;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;

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
		gather(builder, AreaTag.PROGRAM_TEXT_AREA);
		return builder.toString();
	}

	private void gather(StringBuilder builder, Object tag) {
		if (!children.isEmpty()) {
			for (int i = 0; i < children.size(); i++)
				children.get(i).gather(builder, tag);

		} else {
			if (!(data instanceof Token))
				return;

			if (tag != null && !((Token) data).hasTag(tag))
				return;

			builder.append(getText());
		}
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
}
