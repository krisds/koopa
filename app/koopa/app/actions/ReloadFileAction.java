package koopa.app.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

@SuppressWarnings("serial")
public class ReloadFileAction extends AbstractAction implements Action {
	private FileManager manager = null;

	public ReloadFileAction(FileManager manager) {
		super("Reload File");
		this.manager = manager;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new Runnable() {
			public void run() {
				manager.reloadFile();
			}
		}).start();
	}
}
