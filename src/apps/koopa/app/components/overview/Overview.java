package koopa.app.components.overview;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.HighlighterFactory;

import koopa.app.Application;
import koopa.app.ApplicationSupport;
import koopa.app.HoldingCobolParserFactory;
import koopa.app.CobolParserFactory;
import koopa.app.ApplicationConfig;
import koopa.app.actions.ParsingProvider;
import koopa.app.batchit.BatchResults;
import koopa.app.batchit.ParseDetails;
import koopa.app.components.detailstable.DetailsTable;
import koopa.app.components.misc.DecimalFormattingRenderer;
import koopa.app.components.misc.StatusRenderer;
import koopa.cobol.CobolFiles;
import koopa.cobol.parser.ParseResults;
import koopa.core.parsers.Messages;
import koopa.core.targets.TokenTracker;

@SuppressWarnings("serial")
public class Overview extends JPanel implements ParsingProvider,
		HoldingCobolParserFactory {

	private Application application = null;

	private JProgressBar progress = null;

	private BatchResults results = new BatchResults();

	private ParseDetails parseDetails = new ParseDetails();

	private CobolParserFactory factory = null;

	private boolean parsing = false;

	private boolean quitParsing = false;

	public Overview(Application application) {
		this.application = application;
		factory = new CobolParserFactory(ApplicationConfig.getANewProject());
		factory.setKeepingTrackOfTokens(true);
		factory.setBuildTrees(ApplicationSupport.getCustomColumnsNeedXPath());

		setLayout(new BorderLayout());
		setupComponents();
		setupProgressBar();
		setBorder(null);
	}

	private void setupProgressBar() {
		progress = new JProgressBar();
		progress.setStringPainted(true);
		progress.setString("no parsing in progress");
		add(progress, BorderLayout.SOUTH);
	}

	private void setupComponents() {
		final JXTable overviewTable = new JXTable();

		overviewTable.setBorder(null);
		overviewTable.setModel(results);
		overviewTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		overviewTable
				.setHighlighters(HighlighterFactory.createSimpleStriping());

		overviewTable.getColumnModel().getColumn(BatchResults.STATUS_COLUMN)
				.setPreferredWidth(70);
		overviewTable.getColumnModel().getColumn(BatchResults.ERRORS_COLUMN)
				.setPreferredWidth(70);
		overviewTable.getColumnModel().getColumn(BatchResults.WARNINGS_COLUMN)
				.setPreferredWidth(70);
		overviewTable.getColumnModel()
				.getColumn(BatchResults.TOKEN_COUNT_COLUMN)
				.setPreferredWidth(70);
		overviewTable.getColumnModel().getColumn(BatchResults.COVERAGE_COLUMN)
				.setPreferredWidth(70);
		overviewTable.getColumnModel().getColumn(BatchResults.LINES_COLUMN)
				.setPreferredWidth(70);
		overviewTable.getColumnModel().getColumn(BatchResults.CODE_COLUMN)
				.setPreferredWidth(70);
		overviewTable.getColumnModel().getColumn(BatchResults.COMMENTS_COLUMN)
				.setPreferredWidth(70);
		overviewTable.getColumnModel().getColumn(BatchResults.FILE_COLUMN)
				.setPreferredWidth(150);
		overviewTable.getColumnModel().getColumn(BatchResults.PATH_COLUMN)
				.setPreferredWidth(600);
		overviewTable.getColumnModel().getColumn(BatchResults.TIME_COLUMN)
				.setPreferredWidth(70);

		overviewTable.getColumnModel().getColumn(BatchResults.STATUS_COLUMN)
				.setCellRenderer(new StatusRenderer());
		overviewTable.getColumnModel().getColumn(BatchResults.COVERAGE_COLUMN)
				.setCellRenderer(new DecimalFormattingRenderer("0.0"));

		JScrollPane overviewScroll = new JScrollPane(overviewTable);
		overviewScroll.setBorder(null);

		final DetailsTable detailsTable = new DetailsTable(parseDetails);

		detailsTable.addListener(detail -> {
			final int selected = overviewTable
					.convertRowIndexToModel(overviewTable.getSelectedRow());
			final File file = results.getResults(selected).getFile();
			application.openFile(file, factory, detail);
		});

		JScrollPane detailsScroll = new JScrollPane(detailsTable);
		detailsScroll.setBorder(null);

		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				overviewScroll, detailsScroll);
		split.setResizeWeight(0.8);

		add(split, BorderLayout.CENTER);

		overviewTable.getSelectionModel().addListSelectionListener(
				e -> {
					if (!e.getValueIsAdjusting()) {
						final int selected = overviewTable
								.convertRowIndexToModel(overviewTable
										.getSelectedRow());
						if (selected >= 0) {
							parseDetails.setParseResults(results
									.getResults(selected));
						}
					}
				});

		overviewTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = overviewTable.rowAtPoint(new Point(e.getX(), e
							.getY()));

					if (row >= 0) {
						final int selected = overviewTable
								.convertRowIndexToModel(row);
						final File file = results.getResults(selected)
								.getFile();
						application.openFile(file, factory);
					}
				}
			}
		});
	}

	public boolean isParsing() {
		return parsing;
	}

	@Override
	public void walkAndParse(File file) {
		if (parsing)
			return;

		try {
			parsing = true;
			quitParsing = false;

			application.walkingAndParsing();
			progress.setIndeterminate(true);

			final List<File> targets = new LinkedList<>();
			walk(file, targets);

			progress.setValue(0);
			progress.setMaximum(targets.size());
			progress.setIndeterminate(false);

			int count = 0;

			int ok = 0;
			int withWarning = 0;
			int withError = 0;

			for (File target : targets) {
				final ParseResults results = parse(target);
				final Messages messages = results.getParse().getMessages();

				if (messages.hasErrors())
					withError += 1;
				else if (messages.hasWarnings())
					withWarning += 1;
				else
					ok += 1;

				progress.setValue(++count);
				progress.setString("Parsing: " + ok + " ok, " + withWarning
						+ " with warnings, " + withError + " in error");

				if (quitParsing) {
					progress.setValue(0);
					break;
				}
			}

			if (quitParsing)
				progress.setString("Parsing aborted: " + ok + " ok, "
						+ withWarning + " with warnings, " + withError
						+ " in error");
			else
				progress.setString("Parsing done: " + ok + " ok, "
						+ withWarning + " with warnings, " + withError
						+ " in error");

		} finally {
			parsing = false;
			application.doneWalkingAndParsing();
		}
	}

	private void walk(File file, List<File> targets) {
		if (file == null || !file.exists()) {
			return;
		}

		if (file.isDirectory()) {
			for (File child : file.listFiles()) {
				walk(child, targets);
			}

			return;
		}

		if (CobolFiles.isCobolFile(file)) {
			targets.add(file);
		}
	}

	private ParseResults parse(File file) {
		try {
			final ParseResults parseResults = factory.getParser().parse(file);
			results.add(parseResults);
			parseResults.getParse().getFlow().removeTarget(TokenTracker.class);
			return parseResults;

		} catch (IOException e) {
			ParseResults failed = new ParseResults(file);
			failed.setValidInput(false);
			failed.getParse().getMessages().error(null, e.getMessage());
			results.add(failed);
			e.printStackTrace();
			return failed;
		}
	}

	public void addParseResults(ParseResults parseResults) {
		results.add(parseResults.copy());
	}

	@Override
	public Component getGUI() {
		return this;
	}

	@Override
	public void clearResults() {
		results.clear();
		parseDetails.setParseResults(null);
		application.resultsWereCleared();
	}

	public BatchResults getResults() {
		return results;
	}

	public void quitParsing() {
		quitParsing = true;
	}

	@Override
	public CobolParserFactory getCobolParserFactory() {
		return factory;
	}
}
