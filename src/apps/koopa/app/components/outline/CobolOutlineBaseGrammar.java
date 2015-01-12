package koopa.app.components.outline;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;

import koopa.app.Icons;
import koopa.core.treegrammars.TreeGrammar;

public class CobolOutlineBaseGrammar extends TreeGrammar {
	protected static final Icon PARAGRAPH_ICON = Icons
			.getIcon("/koopa/app/resources/splashy/view_less_text.png");

	protected static final Icon SECTION_ICON = Icons
			.getIcon("/koopa/app/resources/splashy/view_more_text.png");

	protected static final Icon DECLARATIVES_ICON = Icons
			.getIcon("/koopa/app/resources/splashy/view_thumbnail.png");

	protected static final Icon PROGRAM_ICON = Icons
			.getIcon("/koopa/app/resources/splashy/document_a4_marked.png");

	private Stack<DefaultMutableTreeNode> nodes = new Stack<DefaultMutableTreeNode>();

	private List<DefaultMutableTreeNode> trees = new LinkedList<DefaultMutableTreeNode>();

	protected void push(Reference ref) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(ref);
		if (!this.nodes.isEmpty()) {
			this.nodes.peek().add(node);
		}

		this.nodes.push(node);
	}

	protected void pop() {
		DefaultMutableTreeNode node = this.nodes.pop();
		if (this.nodes.isEmpty()) {
			this.trees.add(node);
		}
	}

	public List<DefaultMutableTreeNode> getTrees() {
		return this.trees;
	}

}
