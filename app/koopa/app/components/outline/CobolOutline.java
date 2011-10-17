package koopa.app.components.outline;


import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import koopa.parsers.ParseResults;
import koopa.parsers.cobol.CobolParser;
import koopa.parsers.cobol.ParsingCoordinator;
import koopa.parsers.cobol.ParsingListener;

@SuppressWarnings("serial")
public class CobolOutline extends JPanel implements ParsingListener {

	private JTree tree = null;

	private DefaultMutableTreeNode root = null;

	private CobolOutlineTreeProcessor outliner = null;

	public CobolOutline(ParsingCoordinator coordinator) {
		setupComponents();

		coordinator.addParsingListener(this);
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
		this.tree.addTreeSelectionListener(treeSelectionListener);
	}

	public DefaultMutableTreeNode getSelected() {
		return (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
	}

	public void beforeParsing(File file, CobolParser config) {
		this.root.removeAllChildren();
		this.root.setUserObject(file);

		final DefaultTreeModel model = (DefaultTreeModel) this.tree.getModel();

		model.nodeStructureChanged(this.root);

		this.outliner = new CobolOutlineTreeProcessor();
		config.addCommonTreeProcessor(this.outliner);
	}

	public void afterParsing(File file, ParseResults results) {
		this.root.setUserObject(results);

		if (this.outliner.hasTrees()) {
			for (DefaultMutableTreeNode node : this.outliner.getTrees()) {
				this.root.add(node);
			}
		}

		final DefaultTreeModel model = (DefaultTreeModel) this.tree.getModel();
		model.nodeStructureChanged(this.root);
	}
}
