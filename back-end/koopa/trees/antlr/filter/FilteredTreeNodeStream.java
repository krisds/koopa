package koopa.trees.antlr.filter;


import java.util.ArrayList;
import java.util.List;

import koopa.trees.antlr.filter.filters.BracketedFilter;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.Tree;
import org.antlr.runtime.tree.TreeAdaptor;
import org.antlr.runtime.tree.TreeNodeStream;

public class FilteredTreeNodeStream implements TreeNodeStream {

	private static final boolean DEBUG = false;

	private FilteringTokenizer tokenizer = null;

	private List<Tree> tokens = null;

	private int position = -1;

	public FilteredTreeNodeStream(Tree tree, Filter f) {
		this.tokenizer = new FilteringTokenizer(tree);

		final boolean success = new BracketedFilter(f).filter(this.tokenizer);

		if (success) {
			this.tokens = new ArrayList<Tree>(this.tokenizer
					.getConsumedTokens());

			if (DEBUG) {
				for (Tree t : this.tokens) {
					System.out.println("--> " + t + "; line " + t.getLine()
							+ ", char " + t.getCharPositionInLine());
				}
			}

		} else {
			// TODO Flag the mismatch somehow.
			this.tokens = new ArrayList<Tree>(0);
		}
	}

	public Object LT(int i) {
		// System.out.print("FTNS.LT(" + i + ") => ");

		Tree token = null;
		if (i > 0) {
			token = this.tokens.get(this.position + i);
		}

		// System.out.println(token);
		return token;
	}

	public Object get(int i) {
		// System.out.println("FTNS.get(" + i + ")");
		// TODO Auto-generated method stub
		return null;
	}

	public TokenStream getTokenStream() {
		System.out.println("FTNS.getTokenStream()");
		// TODO Auto-generated method stub
		return null;
	}

	public TreeAdaptor getTreeAdaptor() {
		final TreeAdaptor adaptor = this.tokenizer.getTreeAdaptor();
		// System.out.println("FTNS.getTreeAdaptor() => " + adaptor);
		return adaptor;
	}

	public Object getTreeSource() {
		System.out.println("FTNS.getTreeSource()");
		// TODO Auto-generated method stub
		return null;
	}

	public void replaceChildren(Object parent, int startChildIndex,
			int stopChildIndex, Object t) {
		System.out.println("FTNS.replaceChildren(Object parent, ...)");
		// TODO Auto-generated method stub

	}

	public void setUniqueNavigationNodes(boolean uniqueNavigationNodes) {
		System.out
				.println("FTNS.setUniqueNavigationNodes(boolean uniqueNavigationNodes)");
		// TODO Auto-generated method stub

	}

	public String toString(Object start, Object stop) {
		System.out.println("FTNS.toString(Object start, Object stop)");
		// TODO Auto-generated method stub
		return null;
	}

	public int LA(int i) {
		// System.out.print("FTNS.LA(" + i + ") => ");

		if (this.position + i < this.tokens.size()) {
			int type = this.tokens.get(this.position + i).getType();
			// System.out.println(type);
			return type;

		} else {
			return Token.EOF;
		}
	}

	public void consume() {
		// System.out.println("FTNS.consume()");
		this.position += 1;
	}

	public String getSourceName() {
		System.out.println("FTNS.getSourceName()");
		// TODO Auto-generated method stub
		return null;
	}

	public int index() {
		// System.out.println("FTNS.index() => " + (this.position + 1));
		// TODO Auto-generated method stub
		return this.position + 1;
	}

	public int mark() {
		System.out.println("FTNS.mark()");
		// TODO Auto-generated method stub
		return 0;
	}

	public void release(int marker) {
		System.out.println("FTNS.release(int marker)");
		// TODO Auto-generated method stub

	}

	public void rewind() {
		System.out.println("FTNS.rewind()");
		// TODO Auto-generated method stub

	}

	public void rewind(int marker) {
		System.out.println("FTNS.rewind(int marker)");
		// TODO Auto-generated method stub

	}

	public void seek(int index) {
		System.out.println("FTNS.seek(int index)");
		// TODO Auto-generated method stub

	}

	public int size() {
		System.out.println("FTNS.size()");
		// TODO Auto-generated method stub
		return 0;
	}
}
