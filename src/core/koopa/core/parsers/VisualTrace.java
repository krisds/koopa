package koopa.core.parsers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;

import koopa.core.util.JVM;

/**
 * <b>Please do not use this class unless you really have to and know what
 * you're doing !</b>
 * <p>
 * This class acts as a tracer which will open a window with a tree
 * representation of the trace.
 */
public class VisualTrace extends Trace {

	private Stack<DefaultMutableTreeNode> nodes = new Stack<>();
	private JFrame frame = null;

	private final boolean preventShutdown;

	public VisualTrace() {
		this(false);
	}

	public VisualTrace(boolean preventShutdown) {
		this.preventShutdown = preventShutdown;
	}

	private void ensureFrameIsAvailable() {
		if (frame != null)
			return;

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Parse Trace");
		nodes.push(root);

		JTree tree = new JTree(root);

		JScrollPane treeView = new JScrollPane(tree);

		frame = new JFrame("Parse Trace");
		frame.add(treeView);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				JVM.enableSystemExitCall();
			}
		});

		if (preventShutdown) {
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			JVM.forbidSystemExitCall();
		}

		frame.setVisible(true);
	}

	@Override
	public void add(String message) {
		super.add(message);

		ensureFrameIsAvailable();
		nodes.peek().add(new DefaultMutableTreeNode(message));
	}

	@Override
	public void indent(String message) {
		super.indent(message);

		ensureFrameIsAvailable();
		final DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(message);
		nodes.peek().add(newChild);
		nodes.push(newChild);
	}

	@Override
	public void dedent(String message) {
		super.dedent(message);

		ensureFrameIsAvailable();
		nodes.pop().setUserObject(message);
		// nodes.peek().add(new DefaultMutableTreeNode(message));
	}
}
