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

	@Override
	public void actionPerformed(ActionEvent ae) {
		new Thread(() -> application.showGrammarRules()).start();
	}
}
