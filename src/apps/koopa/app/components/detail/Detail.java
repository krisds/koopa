package koopa.app.components.detail;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.tree.DefaultMutableTreeNode;

import koopa.app.Application;
import koopa.app.HoldingCobolParserFactory;
import koopa.app.CobolParserFactory;
import koopa.app.Textual;
import koopa.app.batchit.ParseDetails;
import koopa.app.components.detail.source.SourceDetails;
import koopa.app.components.detail.token.TokenDetails;
import koopa.app.components.detailstable.DetailsTable;
import koopa.app.components.highlights.Highlights;
import koopa.app.components.outline.CobolOutline;
import koopa.app.components.outline.Reference;
import koopa.app.components.sourceview.SourceView;
import koopa.app.listeners.TokenSelectionListener;
import koopa.cobol.parser.ParseResults;
import koopa.core.data.Token;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;
import koopa.core.util.Tuple;

public class Detail extends JPanel implements HoldingCobolParserFactory, Textual {
	private static final long serialVersionUID = 1L;

	private Application application = null;
	private File cobolFile = null;
	private ParseResults results = null;
	private CobolParserFactory factory = null;
	private ParseDetails parseDetails = new ParseDetails();
	private SourceView sourceView = null;
	private CobolOutline outline = null;
	private DetailsTable detailsTable = null;
	private TokenDetails tokenDetails = null;
	private SourceDetails sourceDetails = null;
	private boolean parsing = false;

	private Tree tree = null;

	public Detail(Application application, File file,
			CobolParserFactory factory) {
		this.application = application;
		this.factory = new CobolParserFactory(factory);
		this.factory.setKeepingTrackOfTokens(true);
		this.factory.setBuildTrees(true);

		setLayout(new BorderLayout());
		setupComponents();
		openFile(file);
		setBorder(null);
	}

	private void setupComponents() {
		sourceView = new SourceView();
		outline = new CobolOutline();

		outline.addTreeSelectionListener(e -> {
			final DefaultMutableTreeNode node = outline.getSelected();

			if (node == null)
				return;
			else if (node.isRoot())
				sourceView.scrollToStart();
			else {
				final Reference ref = (Reference) node.getUserObject();
				sourceView.scrollToToken(ref.getTree().getStartToken());
			}
		});

		tokenDetails = new TokenDetails(application);
		sourceView.addTokenSelectionListener(tokenDetails);

		sourceDetails = new SourceDetails(application);
		sourceView.addTokenSelectionListener(sourceDetails);

		detailsTable = new DetailsTable(parseDetails);

		detailsTable.addListener(detail -> sourceView.scrollToToken(detail
				.getFirst()));

		JScrollPane detailsScroll = new JScrollPane(detailsTable);
		detailsScroll.setBorder(null);

		JSplitPane horizontalSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				outline, sourceView);
		horizontalSplit.setResizeWeight(0.3);

		JPanel x = new JPanel();
		x.setLayout(new BorderLayout());
		x.add(horizontalSplit, BorderLayout.CENTER);

		JTabbedPane foo = new JTabbedPane();
		foo.addTab("Messages", detailsScroll);
		foo.addTab("Selection", tokenDetails);
		foo.addTab("Source", sourceDetails);
		foo.setSelectedIndex(0);

		JSplitPane verticalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, x,
				foo);
		verticalSplit.setResizeWeight(0.8);

		add(verticalSplit, BorderLayout.CENTER);
	}

	public void openFile(File file) {
		if (file == null)
			return;

		if (parsing)
			return;

		parsing = true;
		try {
			this.cobolFile = file;

			results = this.factory.getParser().parse(this.cobolFile);

			tree = results.getParse().getTarget(KoopaTreeBuilder.class)
					.getTree();

			tokenDetails.setParseTree(tree);

			outline.setParseResults(results);
			parseDetails.setParseResults(results);
			sourceView.setParseResults(results);

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			parsing = false;
		}
	}

	public void reloadFile() {
		openFile(this.cobolFile);
	}

	public void scrollToToken(Token token) {
		if (sourceView != null)
			sourceView.scrollToToken(token);
	}

	@Override
	public void scrollToLine(int line) {
		if (sourceView != null)
			sourceView.scrollToLine(line);
	}

	public void selectDetail(Tuple<Token, String> detail) {
		if (detail != null)
			detailsTable.selectDetail(detail);
	}

	public ParseResults getParseResults() {
		return results;
	}

	public boolean isParsing() {
		return parsing;
	}

	public boolean hasSyntaxTree() {
		return tree != null;
	}

	public File getFile() {
		return cobolFile;
	}

	@Override
	public int getAdjustedLineCount() {
		return sourceView.getAdjustedLineCount();
	}
	
	@Override
	public boolean find(String search) {
		return sourceView.find(search);
	}

	@Override
	public CobolParserFactory getCobolParserFactory() {
		return factory;
	}

	public Highlights getNewHighlights() {
		return sourceView.getNewHighlights();
	}

	public Tree getTree() {
		return tree;
	}

	public void addTokenSelectionListener(TokenSelectionListener listener) {
		sourceView.addTokenSelectionListener(listener);
	}

	public void removeTokenSelectionListener(TokenSelectionListener listener) {
		sourceView.removeTokenSelectionListener(listener);
	}

	public void close() {
		sourceView.close();
		outline.close();
		detailsTable.close();
		tokenDetails.close();
		sourceDetails.close();

		factory = null;
		parseDetails = null;
		tree = null;
	}
}
