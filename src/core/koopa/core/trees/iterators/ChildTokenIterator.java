package koopa.core.trees.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import koopa.core.data.Token;
import koopa.core.trees.TokenFilter;
import koopa.core.trees.Tree;

/**
 * Cfr.{@link Tree#childTokens()} and {@link Tree#childTokens(TokenFilter)}.
 */
public class ChildTokenIterator implements Iterator<Token> {

	private final Tree root;
	private final TokenFilter filter;

	private int index = 0;

	public ChildTokenIterator(Tree root) {
		this(root, null);
	}

	public ChildTokenIterator(Tree root, TokenFilter filter) {
		this.root = root;
		this.filter = filter != null ? filter : token -> true;

		if (index < root.getChildCount() && !root.getChild(index).isToken())
			moveToNextMatchingToken();
	}

	@Override
	public boolean hasNext() {
		return index < root.getChildCount();
	}

	@Override
	public Token next() {
		if (!hasNext())
			throw new NoSuchElementException("Called next on an iterator with no more elements");

		Token next = (Token) root.getChild(index).getData();
		moveToNextMatchingToken();
		return next;
	}

	private void moveToNextMatchingToken() {
		do {
			moveToNextToken();
		} while (index < root.getChildCount()
				&& !filter.include((Token) root.getChild(index).getData()));
	}

	private void moveToNextToken() {
		index += 1;
		while (index < root.getChildCount() && !root.getChild(index).isToken())
			index += 1;
	}

}
