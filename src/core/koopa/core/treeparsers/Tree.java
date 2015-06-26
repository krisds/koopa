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

	/**
	 * Builds up a string representation of the program text being held in this
	 * tree.
	 * <p>
	 * This does not take {@linkplain AreaTag#COMMENT}s into account.
	 */
	public String getProgramText() {
		StringBuilder builder = new StringBuilder();
		gather(builder, new Token[] { null });
		return builder.toString();
	}

	// The context array is just a poor-man's struct to carry the previously
	// seen token.
	private void gather(StringBuilder builder, Token[] context) {
		if (!children.isEmpty()) {
			for (int i = 0; i < children.size(); i++)
				children.get(i).gather(builder, context);

			return;
		}

		if (!(data instanceof Token))
			return;

		Token token = (Token) data;

		if (!token.hasTag(PROGRAM_TEXT_AREA))
			return;

		if (token.hasTag(COMMENT))
			return;

		if (context[0] != null && builder.length() > 0
				&& context[0].getEnd().getPositionInFile() + 1 //
				< token.getStart().getPositionInFile())
			builder.append(" ");

		builder.append(token.getText());
		context[0] = token;
	}

	public Data getData() {
		return data;
	}

	@Deprecated
	public Position getStart() {
		return getStartPosition();
	}

	/**
	 * Searches the tree for the first known start position.
	 * <p>
	 * This does not take {@linkplain AreaTag#COMMENT}s into account.
	 */
	public Position getStartPosition() {
		Token start = getStartToken();
		return start == null ? null : start.getStart();
	}

	/**
	 * Searches the tree for the first non-{@linkplain AreaTag#COMMENT} token.
	 */
	public Token getStartToken() {
		if (data instanceof Token) {
			Token token = (Token) data;

			if (!(token.hasTag(COMMENT)))
				return token;
		}

		for (int i = 0; i < children.size(); i++) {
			Token token = children.get(i).getStartToken();

			if (token != null)
				return token;
		}

		return null;
	}

	@Deprecated
	public Position getEnd() {
		return getEndPosition();
	}

	/**
	 * Searches the tree for the last known end position.
	 * <p>
	 * This does not take {@linkplain AreaTag#COMMENT}s into account.
	 */
	public Position getEndPosition() {
		Token end = getEndToken();
		return end == null ? null : end.getEnd();
	}

	/**
	 * Searches the tree for the last known end non-{@linkplain AreaTag#COMMENT}
	 * token.
	 */
	public Token getEndToken() {
		if (data instanceof Token) {
			Token token = (Token) data;

			if (!(token.hasTag(COMMENT)))
				return token;
		}

		for (int i = children.size() - 1; i >= 0; i--) {
			Token token = children.get(i).getEndToken();

			if (token != null)
				return token;
		}

		return null;
	}

	/**
	 * Searches the tree for the first known start position.
	 */
	public Position getRawStart() {
		if (data instanceof Token) {
			Token token = (Token) data;
			return token.getStart();
		}

		for (int i = 0; i < children.size(); i++) {
			Position position = children.get(i).getRawStart();

			if (position != null)
				return position;
		}

		return null;
	}

	/**
	 * Searches the tree for the last known end position.
	 */
	public Position getRawEnd() {
		if (data instanceof Token) {
			Token token = (Token) data;
			return token.getEnd();
		}

		for (int i = children.size() - 1; i >= 0; i--) {
			Position position = children.get(i).getRawEnd();

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

	public void insertChild(int index, Tree child) {
		children.add(index, child);
		child.parent = this;
		for (int i = index; i < children.size(); i++)
			children.get(i).childIndex = i;
	}

	public void removeChild(int index) {
		Tree child = children.remove(index);
		child.childIndex = -1;
		child.parent = null;
		for (int i = index; i < children.size(); i++)
			children.get(i).childIndex = i;
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
		return getStartPosition().getLinenumber();
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
