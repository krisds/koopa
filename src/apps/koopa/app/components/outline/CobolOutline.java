package koopa.app.components.outline;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import koopa.cobol.parser.ParseResults;
import koopa.core.trees.KoopaTreeBuilder;

public class CobolOutline extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTree tree = null;

	private DefaultMutableTreeNode root = null;

	public CobolOutline() {
		setupComponents();
	}

	private void setupComponents() {
		root = new DefaultMutableTreeNode("Cobol");

		tree = new JTree(root);
		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		// tree.setRootVisible(false);
		tree.setShowsRootHandles(true);
		tree.setCellRenderer(new OutlineTreeCellRenderer());

		JScrollPane scroll = new JScrollPane(tree);
		scroll.setBorder(null);

		setLayout(new BorderLayout());
		add(scroll, BorderLayout.CENTER);
	}

	public void addTreeSelectionListener(
			TreeSelectionListener treeSelectionListener) {
		tree.addTreeSelectionListener(treeSelectionListener);
	}

	public DefaultMutableTreeNode getSelected() {
		return (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
	}

	public void setParseResults(ParseResults results) {
		root.removeAllChildren();
		root.setUserObject(results);

		CobolOutlineTreeProcessor outliner = new CobolOutlineTreeProcessor();
		outliner.process(results.getParse().getTarget(KoopaTreeBuilder.class)
				.getTree());

		if (outliner.hasTrees())
			for (DefaultMutableTreeNode node : outliner.getTrees())
				root.add(node);

		final DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		model.nodeStructureChanged(root);
	}

	public void close() {
		root.removeAllChildren();
	}
}
