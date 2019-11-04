package koopa.app.components.outline;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;

import koopa.app.Icons;
import koopa.core.trees.Tree;
import koopa.core.trees.TreeWalker;
import koopa.core.trees.jaxen.Jaxen;

public class CobolOutlineTreeProcessor {
	protected static final Icon PARAGRAPH_ICON = Icons
			.getIcon("/koopa/app/resources/splashy/view_less_text.png");

	protected static final Icon SECTION_ICON = Icons
			.getIcon("/koopa/app/resources/splashy/view_more_text.png");

	protected static final Icon DECLARATIVES_ICON = Icons
			.getIcon("/koopa/app/resources/splashy/view_thumbnail.png");

	protected static final Icon PROGRAM_ICON = Icons
			.getIcon("/koopa/app/resources/splashy/document_a4_marked.png");

	private Stack<DefaultMutableTreeNode> nodes = new Stack<>();

	private List<DefaultMutableTreeNode> trees = new LinkedList<>();

	public void process(Tree tree) {
		walk(tree);
	}

	private void walk(Tree ast) {
		final TreeWalker w = new TreeWalker(ast);
		// Always skip the root.
		w.next();

		while (true) {
			final Tree tree = w.next();

			if (tree == null) {
				break;

			} else if (tree.isNode("sourceUnit")) {
				w.skipRemainderOfTree(tree);
				final String name = Jaxen.getAllText(tree, ".//programName");
				push(new Reference(tree, name, PROGRAM_ICON));
				walk(tree);
				pop();

			} else if (tree.isNode("declaratives")) {
				w.skipRemainderOfTree(tree);
				push(new Reference(tree, "DECLARATIVES", DECLARATIVES_ICON));
				walk(tree);
				pop();

			} else if (tree.isNode("declarativeSection")
					|| tree.isNode("section")) {
				w.skipRemainderOfTree(tree);
				final String name = Jaxen.getAllText(tree, ".//sectionName");
				push(new Reference(tree, name, SECTION_ICON));
				walk(tree);
				pop();

			} else if (tree.isNode("paragraph")) {
				w.skipRemainderOfTree(tree);
				final String name = Jaxen.getAllText(tree, ".//paragraphName");
				push(new Reference(tree, name, PARAGRAPH_ICON));
				pop();
			}
		}
	}

	protected void push(Reference ref) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(ref);
		if (!this.nodes.isEmpty())
			this.nodes.peek().add(node);

		this.nodes.push(node);
	}

	protected void pop() {
		DefaultMutableTreeNode node = this.nodes.pop();
		if (this.nodes.isEmpty())
			this.trees.add(node);
	}

	public boolean hasTrees() {
		return this.trees != null && !this.trees.isEmpty();
	}

	public List<DefaultMutableTreeNode> getTrees() {
		return this.trees;
	}
}
