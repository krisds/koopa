package koopa.core.trees.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import koopa.core.trees.Tree;

public class TreeFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public TreeFrame(String title, Tree t) {
		super(title);

		JTree tree = new ASTJTree(t);

		JScrollPane scroll = new JScrollPane(tree);

		Container content = getContentPane();
		content.add(scroll, BorderLayout.CENTER);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Frame f = (Frame) e.getSource();
				f.setVisible(false);
				f.dispose();
			}
		});

		pack();
	}
}
