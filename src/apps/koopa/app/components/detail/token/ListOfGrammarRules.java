package koopa.app.components.detail.token;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import koopa.app.Application;
import koopa.app.listeners.TokenSelectionListener;
import koopa.core.data.Token;
import koopa.core.trees.Tree;

public class ListOfGrammarRules extends JPanel implements
		TokenSelectionListener {

	private static final long serialVersionUID = 1L;

	private static final Font FONT = new Font("Courier", Font.PLAIN, 14);

	private Application application = null;
	private Tree parseTree = null;

	private int index = 0;
	private List<JLabel> labels = new ArrayList<>();

	private JLabel noSelection = null;

	private MouseAdapter mouseClickListener = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel label = (JLabel) e.getSource();
			application.showGrammarRule(label.getText());
		}
	};

	public ListOfGrammarRules(Application application) {
		this.application = application;
		setupComponents();
	}

	private void setupComponents() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);

		noSelection = new JLabel("no selection");
		noSelection.setFont(FONT);

		add(noSelection);
	}

	@Override
	public void selectedToken(Token token) {
		while (index > 0)
			remove(labels.get(--index));

		add(noSelection);

		if (token == null) {
			validate();
			repaint();
			return;
		}

		Tree node = parseTree.find(token);

		if (node == null) {
			validate();
			repaint();
			return;
		}

		LinkedList<String> breadcrumb = new LinkedList<>();
		while (node != null) {
			if (node.isNode())
				breadcrumb.add(node.getName());

			node = node.getParent();
		}

		if (breadcrumb.isEmpty()) {
			validate();
			repaint();
			return;
		}

		remove(noSelection);

		for (String crumb : breadcrumb)
			add(getLabel(crumb));

		validate();
		getParent().validate();
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

	public void setParseTree(Tree tree) {
		while (index > 0)
			remove(labels.get(--index));

		add(noSelection);

		this.parseTree = tree;

		validate();
		repaint();
	}

	public void close() {
		parseTree = null;
	}
}
