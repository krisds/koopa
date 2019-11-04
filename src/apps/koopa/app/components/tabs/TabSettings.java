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
import koopa.cobol.CobolProject;
import koopa.core.util.TabStops;

public class TabSettings extends JDialog {

	private static final long serialVersionUID = 1L;
	private static final String NAME = "Tabs";

	private final CobolParserFactory factory;

	private JButton ok;
	private JTextField tabLength;
	private JTextField tabStops;

	public TabSettings(Frame owner, CobolParserFactory factory) {
		super(owner, NAME, false);

		this.factory = factory;

		setupComponents();

		pack();
		setLocationRelativeTo(owner);
	}

	private void setupComponents() {
		final DocumentListener listener = new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				validateInputs();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				validateInputs();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validateInputs();
			}
		};

		setLayout(new BorderLayout(5, 5));

		JPanel config = new JPanel();
		config.setLayout(new GridLayout(2, 1));

		config.add(getLengthConfiguration(listener));
		config.add(getTabStopsConfiguration(listener));

		add(config, BorderLayout.CENTER);

		add(getConfirmation(), BorderLayout.SOUTH);
	}

	private JPanel getLengthConfiguration(DocumentListener listener) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

		panel.add(new JLabel("Tab length: "));

		tabLength = new JTextField(16);
		tabLength.setText("" + factory.getProject().getDefaultTabLength());
		tabLength.getDocument().addDocumentListener(listener);
		panel.add(tabLength);

		return panel;
	}

	private JPanel getTabStopsConfiguration(DocumentListener listener) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

		panel.add(new JLabel(" Tab stops: "));

		tabStops = new JTextField(16);
		tabStops.setText(factory.getProject().getDefaultTabStops().toString());
		tabStops.getDocument().addDocumentListener(listener);
		panel.add(tabStops);

		return panel;
	}

	private JPanel getConfirmation() {
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton cancel = new JButton();
		cancel.setAction(new AbstractAction("Cancel") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		buttons.add(cancel);

		ok = new JButton(new AbstractAction("OK") {
			private static final long serialVersionUID = 1L;

			@Override
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

		if (valid) {
			try {
				new TabStops().fromString(tabStops.getText());
			} catch (IllegalArgumentException e) {
				valid = false;
			}
		}

		ok.setEnabled(valid);
	}

	private void applyInputs() {
		final CobolProject project = factory.getProject();

		final int tabLengthValue = Integer.parseInt(tabLength.getText());
		project.setDefaultTabLength(tabLengthValue);

		final TabStops stops = new TabStops().fromString(tabStops.getText());
		project.setDefaultTabStops(stops);
	}

	public static Action actionToShow(final Application application) {
		return new AbstractAction(NAME + " ...") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				new TabSettings(application.getFrame(),
						application.getCobolParserFactory()).setVisible(true);
			}
		};
	}
}
