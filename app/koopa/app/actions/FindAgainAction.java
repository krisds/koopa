package koopa.app.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import koopa.app.Application;
import koopa.app.components.detail.Detail;

public class FindAgainAction extends AbstractAction implements Action {

	private static final long serialVersionUID = 1L;

	private Application application = null;
	private Component parent = null;
	private FindAction findAction;

	public FindAgainAction(Application application, Component parent,
			FindAction findAction) {
		super("Find again");
		this.application = application;
		this.parent = parent;
		this.findAction = findAction;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new Runnable() {
			public void run() {
				Detail detail = (Detail) application.getView();

				String search = findAction.getLastSearch();
				if (!detail.find(search))
					JOptionPane.showMessageDialog(parent, "No match for '"
							+ search + "'.", "Not found",
							JOptionPane.ERROR_MESSAGE);
			}
		}).start();
	}
}
