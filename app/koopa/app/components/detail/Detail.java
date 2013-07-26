package koopa.app.components.detail;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import koopa.app.ApplicationSupport;
import koopa.app.Configurable;
import koopa.app.batchit.ParseDetails;
import koopa.app.components.breadcrumb.Breadcrumb;
import koopa.app.components.detailstable.DetailsTable;
import koopa.app.components.detailstable.DetailsTableListener;
import koopa.app.components.outline.CobolOutline;
import koopa.app.components.outline.Reference;
import koopa.app.components.sourceview.SourceView;
import koopa.parsers.ParseResults;
import koopa.parsers.cobol.ParsingCoordinator;
import koopa.parsers.cobol.ParsingListener;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.generic.IntermediateTokenizer;
import koopa.tokens.Token;
import koopa.util.Tuple;

// TODO Extract commonalities with Overview into a common superclass ?
public class Detail extends JPanel implements Configurable {
	private static final long serialVersionUID = 1L;

	private File cobolFile = null;
	private ParseResults results = null;
	private ParsingCoordinator coordinator = null;
	private ParseDetails parseDetails = new ParseDetails();
	private SourceView pane = null;
	private CobolOutline outline = null;
	private DetailsTable detailsTable = null;
	private Breadcrumb breadcrumb = null;
	private boolean parsing = false;

	public Detail(File file, boolean isDialog, SourceFormat format) {
		this.coordinator = new ParsingCoordinator();
		this.coordinator.setKeepingTrackOfTokens(true);
		this.coordinator.setFormat(format);

		// TODO Can do this better, I think.
		ApplicationSupport
				.configureFromProperties("detailing.properties", this);

		setLayout(new BorderLayout());
		setupComponents();
		openFile(file);
		setBorder(null);
	}

	public void setOption(String name, String value) {
		if (name.startsWith("parsing-listener")) {
			installParsingListener(value);

		} else if (name.startsWith("intermediate-tokenizer")) {
			installIntermediateTokenizer(value);
		}
	}

	private void installIntermediateTokenizer(String classname) {
		try {
			Class<?> clazz = Class.forName(classname);
			Object o = clazz.newInstance();
			if (o instanceof IntermediateTokenizer) {
				this.coordinator
						.addIntermediateTokenizer((IntermediateTokenizer) o);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void installParsingListener(String classname) {
		try {
			Class<?> clazz = Class.forName(classname);
			Object o = clazz.newInstance();
			if (o instanceof ParsingListener) {
				this.coordinator.addParsingListener((ParsingListener) o);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setupComponents() {
		pane = new SourceView(this.coordinator);

		outline = new CobolOutline(this.coordinator);

		outline.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				final DefaultMutableTreeNode node = outline.getSelected();

				if (node == null) {
					return;
				}

				if (!node.isRoot()) {
					final Reference ref = (Reference) node.getUserObject();
					pane.scrollTo(ref.getPositionInFile());

				} else {
					pane.scrollTo(0);
				}
			}
		});

		breadcrumb = new Breadcrumb(this.coordinator);
		pane.addTokenSelectionListener(breadcrumb);

		detailsTable = new DetailsTable(parseDetails);

		detailsTable.addListener(new DetailsTableListener() {
			@Override
			public void userSelectedDetail(Tuple<Token, String> detail) {
				final Token token = detail.getFirst();
				pane.scrollTo(token.getStart().getPositionInFile());
			}
		});

		JScrollPane detailsScroll = new JScrollPane(detailsTable);
		detailsScroll.setBorder(null);

		JSplitPane horizontalSplit = new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT, outline, pane);
		horizontalSplit.setResizeWeight(0.3);

		JPanel x = new JPanel();
		x.setLayout(new BorderLayout());
		x.add(horizontalSplit, BorderLayout.CENTER);
		x.add(breadcrumb, BorderLayout.SOUTH);

		JSplitPane verticalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, x,
				detailsScroll);
		verticalSplit.setResizeWeight(0.8);
		// verticalSplit.setDividerLocation(0.8);

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

			results = this.coordinator.parse(this.cobolFile);

			parseDetails.setParseResults(results);

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			parsing = false;
		}
	}

	public void reloadFile() {
		openFile(this.cobolFile);
	}

	public void scrollTo(int position) {
		if (pane != null) {
			pane.scrollTo(position);
		}
	}

	public void selectDetail(Tuple<Token, String> detail) {
		if (detail != null) {
			detailsTable.selectDetail(detail);
		}
	}

	public ParseResults getParseResults() {
		return results;
	}

	public boolean isParsing() {
		return parsing;
	}

	public SourceFormat getSourceFormat() {
		return coordinator.getFormat();
	}

	public void setSourceFormat(SourceFormat format) {
		coordinator.setFormat(format);
	}

	public boolean hasSyntaxTree() {
		return results.getErrorCount() == 0 && results.getTree() != null;
	}

	public File getFile() {
		return cobolFile;
	}
}
