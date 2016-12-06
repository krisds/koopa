package koopa.app.components.progress;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class ProgressDialog extends JDialog {

	public static void main(String[] args) {
		final ProgressDialog progressDialog = new ProgressDialog(null,
				"Gathering logs...");

		progressDialog.setVisible(true);
	}

	private static final long serialVersionUID = 1L;

	private JLabel label;

	private JProgressBar progressBar;

	public ProgressDialog(Frame owner, String title) {
		super(owner, title, false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		setupComponents();

		pack();
		final Dimension size = getSize();
		setSize(size.width * 2, size.height);

		setLocationRelativeTo(owner);
	}

	private void setupComponents() {
		setLayout(new BorderLayout(5, 5));

		EmptyBorder eb = new EmptyBorder(new Insets(10, 10, 10, 10));

		JPanel config = new JPanel();
		config.setBorder(eb);
		config.setLayout(new GridLayout(2, 1));

		label = new JLabel("Waiting...");
		config.add(label);

		progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		config.add(progressBar);

		add(config, BorderLayout.CENTER);
	}

	public void setMessage(String message) {
		label.setText(message);
	}

	public void setDone() {
		progressBar.setIndeterminate(false);
		progressBar.setValue(100);
	}
}
