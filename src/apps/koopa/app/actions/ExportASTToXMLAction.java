package koopa.app.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import koopa.app.Application;
import koopa.app.ApplicationSupport;
import koopa.core.trees.Tree;
import koopa.core.trees.XMLSerializer;

@SuppressWarnings("serial")
public class ExportASTToXMLAction extends AbstractAction implements Action {

	private static FileFilter filter = new FileFilter() {
		@Override
		public boolean accept(File f) {
			return f.isDirectory() || f.isFile()
					&& f.getName().toUpperCase().endsWith(".XML");
		}

		@Override
		public String getDescription() {
			return "XML file (*.xml)";
		}
	};

	private Application application = null;

	public ExportASTToXMLAction(Application application) {
		super("Export to XML...");
		this.application = application;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		new Thread(() -> {
			final Tree tree = application.getSyntaxTree();
			File file = ApplicationSupport.askUserForFile(false, "last-folder",
					filter, application.getFrame());

			if (file == null) {
				return;
			}

			try {
				XMLSerializer.serialize(tree, file);
				JOptionPane.showMessageDialog(application.getFrame(),
						"AST has been exported.", "Export",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (IOException e) {
				JOptionPane.showMessageDialog(application.getFrame(),
						"Export failed.\n" + e.getMessage(),
						"Input/Output problem", JOptionPane.ERROR_MESSAGE);
			}
		}).start();
	}
}
