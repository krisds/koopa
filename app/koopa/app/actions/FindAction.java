package koopa.app.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.regex.PatternSyntaxException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import koopa.app.Application;
import koopa.app.components.detail.Detail;

public class FindAction extends AbstractAction implements Action {

	private static final long serialVersionUID = 1L;

	private String lastSearch = "";

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
				final String input = (String) JOptionPane.showInputDialog(
						parent, "Pattern...", lastSearch);

				search(input);
			}
		}).start();
	}

	public void search() {
		search(lastSearch);
	}

	private void search(String input) {
		try {
			// User cancelled.
			if (input == null)
				return;

			lastSearch = input;

			if (input.length() == 0) {
				JOptionPane.showMessageDialog(parent,
						"Can not match empty search pattern.", "Not found",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			Detail detail = (Detail) application.getView();
			if (!detail.find(input))
				JOptionPane.showMessageDialog(parent, "No match for '" + input
						+ "'.", "Not found", JOptionPane.ERROR_MESSAGE);

		} catch (PatternSyntaxException e) {
			JOptionPane
					.showMessageDialog(
							parent,
							"Syntax error in pattern at position "
									+ e.getIndex() + ".", "Not found",
							JOptionPane.ERROR_MESSAGE);
		}
	}

	public String getLastSearch() {
		return lastSearch;
	}
}
