package koopa.app.actions;

import java.awt.event.ActionEvent;
import java.util.regex.PatternSyntaxException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import koopa.app.Application;
import koopa.app.Textual;

public class FindAction extends AbstractAction implements Action {

	private static final long serialVersionUID = 1L;

	private String lastSearch = "";

	private Application application = null;

	public FindAction(Application application) {
		super("Find...");
		this.application = application;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		new Thread(() -> {
			final String input = JOptionPane.showInputDialog(
					application.getFrame(), "Pattern...", lastSearch);

			search(input);
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
				JOptionPane.showMessageDialog(application.getFrame(),
						"Can not match empty search pattern.", "Not found",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			Textual detail = (Textual) application.getView();
			if (!detail.find(input))
				JOptionPane.showMessageDialog(application.getFrame(),
						"No match for '" + input + "'.", "Not found",
						JOptionPane.ERROR_MESSAGE);

		} catch (PatternSyntaxException e) {
			JOptionPane
					.showMessageDialog(
							application.getFrame(),
							"Syntax error in pattern at position "
									+ e.getIndex() + ".", "Not found",
							JOptionPane.ERROR_MESSAGE);
		}
	}

	public String getLastSearch() {
		return lastSearch;
	}
}
