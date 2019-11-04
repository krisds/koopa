package koopa.app.components.fileextensions;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import koopa.cobol.CobolFiles;
import koopa.core.util.Strings;

public class FileExtensions extends JDialog {

	private static final long serialVersionUID = 1L;
	private static final String NAME = "File Extensions";

	private JButton ok;
	private JTextField forSources;
	private JTextField forCopybooks;

	public FileExtensions(Frame owner) {
		super(owner, NAME, false);

		setupComponents();

		pack();
		setLocationRelativeTo(owner);
	}

	private void setupComponents() {
		setLayout(new BorderLayout(5, 5));

		JPanel config = new JPanel();
		config.setLayout(new GridLayout(2, 2));

		forSources = new JTextField(16);
		forCopybooks = new JTextField(16);

		config.add(getExtensionsConfiguration("Source Files: ", forSources,
				CobolFiles.getSourceExtensions()));
		config.add(getExtensionsConfiguration(" Copybooks: ", forCopybooks,
				CobolFiles.getCopybookExtensions()));

		add(config, BorderLayout.CENTER);

		add(getConfirmation(), BorderLayout.SOUTH);
	}

	private JPanel getExtensionsConfiguration(String label, JTextField text,
			List<String> extensions) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

		panel.add(new JLabel(label));

		text.setToolTipText("Values are comma-separated and case-insensitive. "
				+ "Leading and trailing whitespace will be ignored.");
		text.setText(Strings.join(",", extensions));
		text.getDocument().addDocumentListener(new DocumentListener() {

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
		panel.add(text);

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

		valid = valid && isValidInput(forSources.getText());
		valid = valid && isValidInput(forCopybooks.getText());

		ok.setEnabled(valid);
	}

	private boolean isValidInput(String text) {
		Pattern p = Pattern.compile("^\\S*(,\\S*)*$");
		Matcher m = p.matcher(text);
		return m.matches();
	}

	private void applyInputs() {
		CobolFiles.setSourceExtensions(forSources.getText().split(","));
		CobolFiles.setCopybookExtensions(forCopybooks.getText().split(","));
	}

	public static Action actionToShow(final Application application) {
		return new AbstractAction(NAME + " ...") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				new FileExtensions(application.getFrame()).setVisible(true);
			}
		};
	}
}
