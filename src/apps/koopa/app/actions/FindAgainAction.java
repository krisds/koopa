package koopa.app.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import koopa.app.Application;

public class FindAgainAction extends AbstractAction implements Action {

	private static final long serialVersionUID = 1L;

	private FindAction findAction;

	public FindAgainAction(Application application, FindAction findAction) {
		super("Find again");
		this.findAction = findAction;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		new Thread(() -> findAction.search()).start();
	}
}
