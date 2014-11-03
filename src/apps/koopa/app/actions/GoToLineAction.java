package koopa.app.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import koopa.app.Application;
import koopa.app.components.detail.Detail;

public class GoToLineAction extends AbstractAction implements Action {

	private static final long serialVersionUID = 1L;

	private Application application = null;
	private Component parent = null;

	public GoToLineAction(Application application, Component parent) {
		super("Go to line...");
		this.application = application;
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new Runnable() {
			public void run() {
				Detail detail = (Detail) application.getView();

				final int numberOfLines = detail.getNumberOfLines();

				String input = (String) JOptionPane.showInputDialog(parent,
						"Enter line number (1 to " + numberOfLines + ")");

				if (input == null)
					return;

				try {
					int lineNumber = Integer.parseInt(input);

					if (lineNumber < 1 || lineNumber > numberOfLines)
						JOptionPane.showMessageDialog(parent,
								"Line number should be between 1 and "
										+ numberOfLines + ".",
								"Line number out of range.",
								JOptionPane.ERROR_MESSAGE);
					else
						detail.scrollToLine(lineNumber - 1);

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(parent, "Not a number: '"
							+ input + "'", "Not a number.",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}).start();
	}
}
