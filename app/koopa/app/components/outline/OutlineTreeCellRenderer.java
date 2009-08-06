package koopa.app.components.outline;


import java.awt.Component;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import koopa.app.Icons;
import koopa.app.parsers.ParseResults;

@SuppressWarnings("serial")
public class OutlineTreeCellRenderer extends DefaultTreeCellRenderer {
	final static ImageIcon PLAIN = Icons
			.getIcon("/koopa/app/resources/document_a4_blank.png");

	final static ImageIcon OK = Icons
			.getIcon("/koopa/app/resources/document_a4_okay.png");

	final static ImageIcon ERROR = Icons
			.getIcon("/koopa/app/resources/document_a4_remove.png");

	final static ImageIcon WARNING = Icons
			.getIcon("/koopa/app/resources/document_a4_warning.png");

	public OutlineTreeCellRenderer() {
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {

		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
				row, hasFocus);

		final DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
		final Object object = node.getUserObject();

		if (object instanceof Reference) {
			final Icon icon = ((Reference) object).getIcon();
			if (icon != null) {
				setIcon(icon);
			}

		} else if (object instanceof File) {
			final File file = (File) object;

			setText(file.getName());
			setIcon(PLAIN);

		} else if (object instanceof ParseResults) {
			final ParseResults results = (ParseResults) object;
			final File file = results.getFile();

			setText(file.getName());
			if (results.getErrorCount() > 0) {
				setIcon(ERROR);
			} else if (results.getWarningCount() > 0) {
				setIcon(WARNING);
			} else {
				setIcon(OK);
			}
		}

		return this;
	}
}
