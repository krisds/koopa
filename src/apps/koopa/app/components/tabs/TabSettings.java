package koopa.app.components.tabs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import koopa.app.Application;
import koopa.app.CobolParserFactory;

public class TabSettings extends JDialog {

	private static final long serialVersionUID = 1L;
	private static final String NAME = "Tabs";

	private final CobolParserFactory factory;

	private JButton ok;
	private JTextField tabLength;

	public TabSettings(Frame owner, CobolParserFactory factory) {
		super(owner, NAME, false);

		this.factory = factory;

		setupComponents();

		pack();
		setLocationRelativeTo(owner);
	}

	private void setupComponents() {
		setLayout(new BorderLayout(5, 5));

		JPanel config = new JPanel();
		config.setLayout(new GridLayout(1, 1));

		config.add(getLengthConfiguration());

		add(config, BorderLayout.CENTER);

		add(getConfirmation(), BorderLayout.SOUTH);
	}

	private JPanel getLengthConfiguration() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

		panel.add(new JLabel("Tab length: "));

		tabLength = new JTextField(3);
		tabLength.setText("" + factory.getProject().getDefaultTabLength());
		tabLength.getDocument().addDocumentListener(new DocumentListener() {

			public void removeUpdate(DocumentEvent e) {
				validateInputs();
			}

			public void insertUpdate(DocumentEvent e) {
				validateInputs();
			}

			public void changedUpdate(DocumentEvent e) {
				validateInputs();
			}
		});
		panel.add(tabLength);

		return panel;
	}

	private JPanel getConfirmation() {
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton cancel = new JButton();
		cancel.setAction(new AbstractAction("Cancel") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		buttons.add(cancel);

		ok = new JButton(new AbstractAction("OK") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				applyInputs();
				setVisible(false);
			}
		});
		buttons.add(ok);

		return buttons;
	}

	private void validateInputs() {
		boolean valid = true;

		final String tabLengthInput = tabLength.getText();
		if (tabLengthInput.length() == 0)
			valid = false;

		if (valid)
			try {
				valid = Integer.parseInt(tabLengthInput) > 0;
			} catch (NumberFormatException e) {
				valid = false;
			}

		ok.setEnabled(valid);
	}

	private void applyInputs() {
		int tabLengthValue = Integer.parseInt(tabLength.getText());

		factory.getProject().setDefaultTabLength(tabLengthValue);
	}

	public static Action actionToShow(final Application application) {
		return new AbstractAction(NAME + " ...") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				new TabSettings(application.getFrame(),
						application.getCobolParserFactory()).setVisible(true);
			}
		};
	}
}
