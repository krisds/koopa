package koopa.app.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import koopa.app.Application;
import koopa.app.ApplicationSupport;
import koopa.trees.antlr.CommonTreeSerializer;

import org.antlr.runtime.tree.CommonTree;

@SuppressWarnings("serial")
public class ExportASTToXMLAction extends AbstractAction implements Action {

	private static FileFilter filter = new FileFilter() {
		public boolean accept(File f) {
			if (!f.isFile())
				return false;
			final String name = f.getName().toUpperCase();
			return name.endsWith(".XML");
		}

		public String getDescription() {
			return "XML file (*.xml)";
		}
	};

	private Component parent = null;
	private Application application = null;

	public ExportASTToXMLAction(Application application, Component parent) {
		super("Export to XML...");
		this.application = application;
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new Runnable() {
			public void run() {
				final CommonTree tree = application.getSyntaxTree();
				File file = ApplicationSupport.askUserForFile(false,
						"last-folder", filter, parent);

				if (file == null) {
					return;
				}

				try {
					CommonTreeSerializer.serialize(tree, file);
					JOptionPane.showMessageDialog(parent,
							"AST has been exported.", "Export",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (IOException e) {
					JOptionPane.showMessageDialog(parent, "Export failed.\n"
							+ e.getMessage(), "Input/Output problem",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}).start();
	}
}
