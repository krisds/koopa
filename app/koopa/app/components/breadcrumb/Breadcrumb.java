package koopa.app.components.breadcrumb;

import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import koopa.app.listeners.TokenSelectionListener;
import koopa.parsers.ParseResults;
import koopa.parsers.cobol.CobolParser;
import koopa.parsers.cobol.ParsingCoordinator;
import koopa.parsers.cobol.ParsingListener;
import koopa.tokens.BasicToken;
import koopa.tokens.Position;
import koopa.tokens.Token;
import koopa.tokenstreams.Marker;
import koopa.util.ANTLR;

import org.antlr.runtime.tree.CommonTree;

// TODO Style this a bit better.
@SuppressWarnings("serial")
public class Breadcrumb extends JPanel implements ParsingListener,
		TokenSelectionListener {

	private JLabel label = null;
	private CommonTree parseTree = null;

	public Breadcrumb(ParsingCoordinator coordinator) {
		coordinator.addParsingListener(this);

		setupComponents();
	}

	private void setupComponents() {
		setLayout(new FlowLayout(FlowLayout.LEFT));

		label = new JLabel("no selection");
		label.setFont(new Font("Courier", Font.PLAIN, 10));

		add(label);
		
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	}

	@Override
	public void beforeParsing(File file, CobolParser config) {
		label.setText("no selection");
	}

	@Override
	public void afterParsing(File file, ParseResults results) {
		this.parseTree = results.getTree();
	}

	@Override
	public void selectedToken(Token token) {
		if (token == null) {
			label.setText("no selection");
			return;
		}

		List<String> breadcrumb = find(token, parseTree,
				new LinkedList<String>());

		String path = "";

		for (String crumb : breadcrumb) {
			path += "/" + crumb;
		}

		label.setText(path);
	}

	private List<String> find(Token token, CommonTree tree,
			List<String> breadcrumb) {
		if (token == null)
			return breadcrumb;

		Token node = ANTLR.getToken(tree);

		// TODO Found it ?
		if (node instanceof BasicToken)
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
