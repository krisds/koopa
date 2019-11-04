package koopa.app.components.cobolwords;

import static koopa.cobol.CobolWords.getExtendedCharactersInCopybooks;
import static koopa.cobol.CobolWords.setExtendedCharactersInCopybooks;
import static koopa.cobol.CobolWords.setMaxLength;
import static koopa.cobol.CobolWords.setUseExtendedCharactersInCopybooks;
import static koopa.cobol.CobolWords.useExtendedCharactersInCopybooks;

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
import koopa.cobol.CobolWords;

public class CobolWordSettings extends JDialog {

	private static final long serialVersionUID = 1L;
	private static final String NAME = "COBOL Words";

	private JButton ok;
	private JTextField maxLength;
	private JCheckBox extended;
	private JTextField extendedCharacters;

	public CobolWordSettings(Frame owner) {
		super(owner, NAME, false);

		setupComponents();

		pack();
		setLocationRelativeTo(owner);
	}

	private void setupComponents() {
		setLayout(new BorderLayout(5, 5));

		JPanel config = new JPanel();
		config.setLayout(new GridLayout(2, 1));

		config.add(getLengthConfiguration());
		config.add(getExtendedCharactersInCopybooksConfiguration());

		add(config, BorderLayout.CENTER);

		add(getConfirmation(), BorderLayout.SOUTH);
	}

	private JPanel getLengthConfiguration() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

		panel.add(new JLabel("  Max. length: "));

		maxLength = new JTextField(3);
		maxLength.setText("" + CobolWords.getMaxLength());
		maxLength.getDocument().addDocumentListener(new DocumentListener() {

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
		panel.add(maxLength);

		return panel;
	}

	private JPanel getExtendedCharactersInCopybooksConfiguration() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

		extended = new JCheckBox("Allow in copybook:");
		extended.setSelected(useExtendedCharactersInCopybooks());
		panel.add(extended);

		extendedCharacters = new JTextField(16);
		extendedCharacters.setText(getExtendedCharactersInCopybooks());
		panel.add(extendedCharacters);

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

		final String maxLengthInput = maxLength.getText();
		if (maxLengthInput.length() == 0)
			valid = false;

		if (valid)
			try {
				Integer.parseInt(maxLengthInput);
			} catch (NumberFormatException e) {
				valid = false;
			}

		if (valid)
			valid = extendedCharacters.getText().length() > 0;

		ok.setEnabled(valid);
	}

	private void applyInputs() {
		int maxLengthValue = Integer.parseInt(maxLength.getText());
		boolean extendedValue = extended.isSelected();
		String extendedCharactersValue = extendedCharacters.getText();

		setMaxLength(maxLengthValue);
		setUseExtendedCharactersInCopybooks(extendedValue);
		setExtendedCharactersInCopybooks(extendedCharactersValue);
	}

	public static Action actionToShow(final Application application) {
		return new AbstractAction(NAME + " ...") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				new CobolWordSettings(application.getFrame()).setVisible(true);
			}
		};
	}
}
