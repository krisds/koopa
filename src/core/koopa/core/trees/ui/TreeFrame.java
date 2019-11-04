package koopa.core.trees.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import koopa.core.data.Token;
import koopa.core.trees.Tree;

public class TreeFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private final ASTJTree jTree;

	public TreeFrame(String title, Tree t) {
		super(title);

		this.jTree = new ASTJTree(t);

		final JScrollPane scroll = new JScrollPane(jTree);

		final Container content = getContentPane();
		content.add(scroll, BorderLayout.CENTER);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Frame f = (Frame) e.getSource();
				f.setVisible(false);
				f.dispose();
			}
		});

		pack();
	}

	public void select(Token token) {
		jTree.select(token);
	}
}
