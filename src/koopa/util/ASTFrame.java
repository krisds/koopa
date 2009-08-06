package koopa.util;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import org.antlr.runtime.tree.CommonTree;

/**
 * @author Jörg Werner
 * 
 */
@SuppressWarnings("serial")
public class ASTFrame extends JFrame {

	public ASTFrame(String lab, CommonTree t) {
		super(lab);

		JTree tree = new ASTJTree(t);

		JScrollPane scrollPane = new JScrollPane(tree);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(scrollPane);

		Container content = getContentPane();
		content.add(panel, BorderLayout.CENTER);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Frame f = (Frame) e.getSource();
				f.setVisible(false);
				f.dispose();
				// System.exit(0);
			}
		});

		pack();
	}

}
