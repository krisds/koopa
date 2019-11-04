package koopa.app.components.copybookpaths;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import koopa.app.Application;
import koopa.app.ApplicationSupport;
import koopa.app.CobolParserFactory;
import koopa.cobol.CobolProject;
import koopa.cobol.util.CopybookPaths;

/**
 * This is a basic {@linkplain JDialog} for manipulating the copy book paths in
 * a {@linkplain CobolParserFactory} instance.
 */
public class CopybookPathsSelector extends JDialog {

	private static final long serialVersionUID = 1L;
	private static final String NAME = "Copybook Paths";

	private CopybookPaths configurablePaths;

	public CopybookPathsSelector(Frame owner, CobolParserFactory factory) {
		super(owner, NAME, false);

		CobolProject project = factory.getProject();

		if (project instanceof CopybookPaths) {
			configurablePaths = (CopybookPaths) project;
			setupComponents();

		} else {
			setupWarning(project);
		}

		setSize(600, 300);
		setLocationRelativeTo(owner);
	}

	private void setupComponents() {
		setLayout(new BorderLayout());

		final DefaultListModel model = new DefaultListModel();
		final JList pathsList = new JList(model);

		for (File path : configurablePaths.getCopybookPaths())
			model.addElement(path);

		JScrollPane scrollablePathsList = new JScrollPane(pathsList);
		scrollablePathsList.setBorder(null);

		add(scrollablePathsList, BorderLayout.CENTER);

		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(buttons, BorderLayout.SOUTH);

		JButton addCopybookPathButton = new JButton();
		buttons.add(addCopybookPathButton);

		final JButton removeCopybookPathButton = new JButton();
		buttons.add(removeCopybookPathButton);

		JButton okButton = new JButton();
		buttons.add(okButton);

		setupInteractions(model, pathsList, addCopybookPathButton,
				removeCopybookPathButton, okButton);
	}

	private void setupWarning(CobolProject project) {
		setLayout(new BorderLayout());

		add(new JLabel(project.getClass()
				+ " does not support configurable copybook paths."),
				BorderLayout.CENTER);
	}

	private void setupInteractions(final DefaultListModel model,
			final JList pathsList, JButton addCopybookPathButton,
			final JButton removeCopybookPathButton, JButton okButton) {

		addCopybookPathButton.setAction(new AbstractAction(
				"Add Copybook Path...") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				File path = ApplicationSupport.askUserForFolder("last-folder",
						CopybookPathsSelector.this);

				if (path == null)
					return;

				configurablePaths.addCopybookPath(path);
				model.addElement(path);
			}
		});

		removeCopybookPathButton.setAction(new AbstractAction(
				"Remove selected paths") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				int[] selectedIndices = pathsList.getSelectedIndices();
				for (int i = selectedIndices.length - 1; i >= 0; i--) {
					configurablePaths.removeCopybookPath((File) model
							.get(selectedIndices[i]));
					model.removeElementAt(selectedIndices[i]);
				}
			}
		});

		okButton.setAction(new AbstractAction("Done") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				CopybookPathsSelector.this.setVisible(false);
			}
		});

		removeCopybookPathButton.setEnabled(false);
		pathsList.addListSelectionListener(e -> {
			if (e.getValueIsAdjusting())
				return;

			removeCopybookPathButton.setEnabled(!pathsList.isSelectionEmpty());
		});
	}

	public static Action actionToShow(final Application application) {
		return new AbstractAction(NAME + " ...") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				final CobolParserFactory factory = application
						.getCobolParserFactory();

				new CopybookPathsSelector(application.getFrame(), factory)
						.setVisible(true);
			}
		};
	}
}
