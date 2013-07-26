package koopa.app.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.filechooser.FileFilter;

import koopa.app.Application;
import koopa.app.ApplicationSupport;

@SuppressWarnings("serial")
public class OpenFileAction extends AbstractAction implements Action {
	private Application application = null;
	private FileFilter filter = null;
	private Component parent = null;

	public OpenFileAction(Application application, FileFilter filter,
			Component parent) {
		this("Open File...", application, filter, parent);
	}

	public OpenFileAction(String actionName, Application application,
			FileFilter filter, Component parent) {
		super(actionName);
		this.application = application;
		this.filter = filter;
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new Runnable() {
			public void run() {
				File file = ApplicationSupport.askUserForFile(true,
						"last-folder", filter, parent);

				if (file != null) {
					application.openFile(file);
				}
			}
		}).start();
	}
}
