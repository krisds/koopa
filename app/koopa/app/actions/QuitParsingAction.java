package koopa.app.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import koopa.app.Application;

public class QuitParsingAction extends AbstractAction implements Action {

	private static final long serialVersionUID = 1L;

	private Application application = null;

	public QuitParsingAction(Application application) {
		super("Quit parsing");
		this.application = application;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new Runnable() {
			public void run() {
				application.quitParsing();
			}
		}).start();
	}
}
