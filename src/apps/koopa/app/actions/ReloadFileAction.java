package koopa.app.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import koopa.app.Application;

@SuppressWarnings("serial")
public class ReloadFileAction extends AbstractAction implements Action {
	private Application application = null;

	public ReloadFileAction(Application application) {
		super("Reload File");
		this.application = application;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new Runnable() {
			public void run() {
				application.reloadFile();
			}
		}).start();
	}
}
