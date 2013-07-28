package koopa.app.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import koopa.app.Application;

@SuppressWarnings("serial")
public class ShowGrammarAction extends AbstractAction implements Action {

	private Application application;

	public ShowGrammarAction(Application application) {
		super("Show grammar...");
		this.application = application;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new Runnable() {
			public void run() {
				application.showGrammarRules();
			}
		}).start();
	}
}
