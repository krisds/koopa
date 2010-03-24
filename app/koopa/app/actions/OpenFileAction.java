package koopa.app.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.filechooser.FileFilter;

import koopa.app.ApplicationSupport;

@SuppressWarnings("serial")
public class OpenFileAction extends AbstractAction implements Action {
	private FileManager manager = null;
	private FileFilter filter = null;
	private Component parent = null;

	public OpenFileAction(FileManager manager, FileFilter filter,
			Component parent) {
		super("Open File...");
		this.manager = manager;
		this.filter = filter;
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new ThreadGroup("actions"), new Runnable() {
			public void run() {
				File file = ApplicationSupport.askUserForFile(true,
						"last-folder", filter, parent);

				if (file != null) {
					manager.openFile(file);
				}
			}
		}).start();
	}
}
