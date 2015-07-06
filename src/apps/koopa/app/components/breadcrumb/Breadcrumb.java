package koopa.app.components.breadcrumb;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import koopa.app.Application;
import koopa.app.listeners.TokenSelectionListener;
import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.treeparsers.Tree;

// TODO Style this a bit better.
@SuppressWarnings("serial")
public class Breadcrumb extends JPanel implements TokenSelectionListener {

	private static final Font FONT = new Font("Courier", Font.PLAIN, 10);

	private Application application = null;
	private Tree parseTree = null;

	private int index = 0;
	private List<JLabel> labels = new ArrayList<JLabel>();

	private JLabel noSelection = null;

	private MouseAdapter mouseClickListener = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel label = (JLabel) e.getSource();
			application.showGrammarRule(label.getText());
		}
	};

	public Breadcrumb(Application application) {
		this.application = application;
		setupComponents();
	}

	private void setupComponents() {
		setLayout(new FlowLayout(FlowLayout.LEFT));

		noSelection = new JLabel("no selection");
		noSelection.setFont(FONT);

		add(noSelection);
	}

	public void selectedToken(Token token) {
		while (index > 0)
			remove(labels.get(--index));

		add(noSelection);

		if (token == null) {
			validate();
			repaint();
			return;
		}

		List<String> breadcrumb = find(token, parseTree,
				new LinkedList<String>());

		if (breadcrumb == null || breadcrumb.isEmpty()) {
			validate();
			repaint();
			return;
		}

		remove(noSelection);

		for (String crumb : breadcrumb) {
			if (index > 0)
				add(getLabel("/"));

			add(getLabel(crumb));
		}

		validate();
		repaint();
	}

	private JLabel getLabel(String crumb) {
		JLabel label;

		if (index < labels.size()) {
			label = labels.get(index);
			label.setText(crumb);

		} else {
			label = new JLabel(crumb);
			labels.add(label);

			label.setFont(FONT);

			if (index % 2 == 0) {
				label.setCursor(new Cursor(Cursor.HAND_CURSOR));
				label.addMouseListener(mouseClickListener);
			}
		}

		index += 1;
		return label;
	}

	private List<String> find(Token token, Tree tree, List<String> breadcrumb) {

		if (token == null)
			return breadcrumb;

		if (tree == null)
			return breadcrumb;

		Data node = tree.getData();

		if (node == null)
			return breadcrumb;

		// TODO Really found it ?
		if (!(node instanceof Marker))
			return breadcrumb;

		breadcrumb.add(((Marker) node).getName());

		// TODO Binary search instead.
		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree child = tree.getChild(i);

			Position start = child.getRawStart();
			Position end = child.getRawEnd();

			Position tokenStart = token.getStart();
			Position tokenEnd = token.getEnd();

			if (tokenStart.getPositionInFile() >= start.getPositionInFile()
					&& tokenEnd.getPositionInFile() <= end.getPositionInFile()) {
				find(token, child, breadcrumb);
				break;
			}
		}

		return breadcrumb;
	}

	public void setParseTree(Tree tree) {
		while (index > 0)
			remove(labels.get(--index));

		add(noSelection);

		this.parseTree = tree;

		validate();
		repaint();
	}
}
