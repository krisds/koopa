package koopa.app.components.misc;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import koopa.app.Application;

public class Tab extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel title;
	private Application application;
	private Component component;

	public Tab(String title, Application application, Component component) {
		super();
		this.application = application;
		this.component = component;

		setup();
		setTitle(title);
	}

	public void setTitle(String title) {
		this.title.setText(title);
	}

	private void setup() {
		setLayout(new GridBagLayout());
		setOpaque(false);

		title = new JLabel("unnamed");
		JLabel close = new JLabel("x");

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;

		add(title, gbc);

		gbc.gridx++;
		gbc.weightx = 0;
		add(close, gbc);

		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				application.closeView(component);
			}
		});
	}
}
