package koopa.app.components.breadcrumb;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import koopa.app.Application;
import koopa.app.listeners.TokenSelectionListener;
import koopa.parsers.ParseResults;
import koopa.parsers.cobol.CobolParser;
import koopa.parsers.cobol.ParsingCoordinator;
import koopa.parsers.cobol.ParsingListener;
import koopa.tokens.Position;
import koopa.tokens.Token;
import koopa.tokenstreams.Marker;
import koopa.util.ANTLR;

import org.antlr.runtime.tree.CommonTree;

// TODO Style this a bit better.
@SuppressWarnings("serial")
public class Breadcrumb extends JPanel implements ParsingListener,
		TokenSelectionListener {

	private static final Font FONT = new Font("Courier", Font.PLAIN, 10);

	private Application application = null;
	private CommonTree parseTree = null;

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

	public Breadcrumb(Application application, ParsingCoordinator coordinator) {
		this.application = application;

		coordinator.addParsingListener(this);

		setupComponents();
	}

	private void setupComponents() {
		setLayout(new FlowLayout(FlowLayout.LEFT));

		noSelection = new JLabel("no selection");
		noSelection.setFont(FONT);

		add(noSelection);

		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	}

	@Override
	public void beforeParsing(File file, CobolParser config) {
		while (index > 0)
			remove(labels.get(--index));

		add(noSelection);

		validate();
		repaint();
	}

	@Override
	public void afterParsing(File file, ParseResults results) {
		this.parseTree = results.getTree();
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

	private List<String> find(Token token, CommonTree tree,
			List<String> breadcrumb) {

		if (token == null)
			return breadcrumb;

		Token node = ANTLR.getToken(tree);

		if (node == null)
			return breadcrumb;

		// TODO Really found it ?
		if (!(node instanceof Marker))
			return breadcrumb;

		breadcrumb.add(((Marker) node).getName());

		// TODO Binary search instead.
		for (int i = 0; i < tree.getChildCount(); i++) {
			CommonTree child = (CommonTree) tree.getChild(i);

			Position start = ANTLR.getStart(child);
			Position end = ANTLR.getEnd(child);

			if (token.getStart().getPositionInFile() >= start
					.getPositionInFile()
					&& token.getEnd().getPositionInFile() <= end
							.getPositionInFile()) {
				find(token, child, breadcrumb);
				break;
			}
		}

		return breadcrumb;
	}
}
