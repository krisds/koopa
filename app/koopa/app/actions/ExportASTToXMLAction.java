package koopa.app.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import koopa.app.ApplicationSupport;
import koopa.trees.antlr.CommonTreeSerializer;
import koopa.util.Getter;

import org.antlr.runtime.tree.CommonTree;

@SuppressWarnings("serial")
public class ExportASTToXMLAction extends AbstractAction implements Action {
	private Getter<CommonTree> astGetter = null;
	private FileFilter filter = null;
	private Component parent = null;

	public ExportASTToXMLAction(Getter<CommonTree> astGetter,
			FileFilter filter, Component parent) {
		super("Export to XML...");
		this.astGetter = astGetter;
		this.filter = filter;
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new ThreadGroup("actions"), new Runnable() {
			public void run() {
				final CommonTree tree = astGetter.getIt();
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
