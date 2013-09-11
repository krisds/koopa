package koopa.app.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import koopa.app.Application;
import koopa.app.components.detail.Detail;

public class FindAction extends AbstractAction implements Action {

	private static final long serialVersionUID = 1L;

	private String lastSearch = null;

	private Application application = null;
	private Component parent = null;

	public FindAction(Application application, Component parent) {
		super("Find...");
		this.application = application;
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new Runnable() {
			public void run() {
				Detail detail = (Detail) application.getView();

				String input = (String) JOptionPane.showInputDialog(parent,
						"Find...");

				if (input == null)
					return;

				lastSearch = input;

				if (!detail.find(input))
					JOptionPane.showMessageDialog(parent, "No match for '"
							+ input + "'.", "Not found",
							JOptionPane.ERROR_MESSAGE);
			}
		}).start();
	}

	public String getLastSearch() {
		return lastSearch;
	}
}
