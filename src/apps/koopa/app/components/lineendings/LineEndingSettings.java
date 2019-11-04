package koopa.app.components.lineendings;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import koopa.app.Application;
import koopa.core.util.LineEndings;

public class LineEndingSettings extends JDialog {

	private static final long serialVersionUID = 1L;
	private static final String NAME = "Line Endings";

	private JButton ok;
	private JTextField lineEndings;
	private JCheckBox sticky;

	public LineEndingSettings(Frame owner) {
		super(owner, NAME, false);

		setupComponents();

		pack();
		setLocationRelativeTo(owner);
	}

	private void setupComponents() {
		setLayout(new BorderLayout(5, 5));

		JPanel config = new JPanel();
		config.setLayout(new GridLayout(2, 1));

		config.add(getExtendedCharactersInCopybooksConfiguration());
		config.add(getStickyConfiguration());

		add(config, BorderLayout.CENTER);

		add(getConfirmation(), BorderLayout.SOUTH);
	}

	private JPanel getStickyConfiguration() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

		sticky = new JCheckBox("Sticky line endings");
		sticky.setSelected(LineEndings.areSticky());
		panel.add(sticky);

		return panel;
	}

	private JPanel getExtendedCharactersInCopybooksConfiguration() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

		panel.add(new JLabel("  Line endings: "));

		lineEndings = new JTextField(16);
		lineEndings
				.setText(LineEndings.encodeChoices(LineEndings.getChoices()));
		lineEndings.getDocument().addDocumentListener(new DocumentListener() {

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
		});
		panel.add(lineEndings);

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

		String lineEndingsValue = lineEndings.getText();
		valid = LineEndings.isValidDefinition(lineEndingsValue);

		ok.setEnabled(valid);
	}

	private void applyInputs() {
		final String lineEndingsValue = lineEndings.getText();
		final boolean stickyValue = sticky.isSelected();

		LineEndings.setChoices(lineEndingsValue);
		LineEndings.setSticky(stickyValue);
	}

	public static Action actionToShow(final Application application) {
		return new AbstractAction(NAME + " ...") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				new LineEndingSettings(application.getFrame()).setVisible(true);
			}
		};
	}
}
