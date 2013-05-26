package koopa.app.batchit;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;

import koopa.app.ApplicationSupport;
import koopa.app.ConfigurableApplication;
import koopa.app.actions.ExportBatchResultsToCSVAction;
import koopa.app.actions.ParsingProvider;
import koopa.app.actions.PickAndParseAction;
import koopa.app.components.detailstable.DetailsTable;
import koopa.app.components.detailstable.DetailsTableListener;
import koopa.app.components.misc.DecimalFormattingRenderer;
import koopa.app.components.misc.StatusRenderer;
import koopa.app.showit.ShowIt;
import koopa.parsers.ParseResults;
import koopa.parsers.cobol.ParsingCoordinator;
import koopa.parsers.cobol.ParsingListener;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.generic.IntermediateTokenizer;
import koopa.tokens.Token;
import koopa.util.Getter;
import koopa.util.Tuple;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.HighlighterFactory;

@SuppressWarnings("serial")
public class BatchIt extends JFrame implements ParsingProvider,
		ConfigurableApplication {

	private JMenuItem pick = null;

	private JMenuItem clearResults = null;

	private JMenuItem saveCSV = null;

	private JProgressBar progress = null;

	private BatchResults results = new BatchResults();

	private ParseDetails parseDetails = new ParseDetails();

	private ParsingCoordinator coordinator = null;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new BatchIt().setVisible(true);
			}
		});
	}

	public BatchIt() {
		super("Koopa Batch It");

		this.coordinator = new ParsingCoordinator();
		this.coordinator.setKeepingTrackOfTokens(true);

		ApplicationSupport.configureFromProperties("batchit.properties", this);

		setupMenuBar();
		setupToolBar();
		setupComponents();

		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void setupMenuBar() {
		// Be nice to mac users.
		System.setProperty("apple.laf.useScreenMenuBar", "true");

		JMenuBar bar = new JMenuBar();

		JMenu file = new JMenu("File");
		this.pick = new JMenuItem(new PickAndParseAction(this, this));

		this.pick.setAccelerator(KeyStroke.getKeyStroke("meta O"));
		file.add(this.pick);

		file.addSeparator();

		this.clearResults = new JMenuItem(new ClearResultsAction(this));
		this.clearResults.setEnabled(false);
		file.add(this.clearResults);

		saveCSV = new JMenuItem(new ExportBatchResultsToCSVAction(
				new Getter<BatchResults>() {
					public BatchResults getIt() {
						return results;
					}
				}, new FileFilter() {
					public boolean accept(File f) {
						if (!f.isFile())
							return false;
						final String name = f.getName().toUpperCase();
						return name.endsWith(".CSV");
					}

					public String getDescription() {
						return "CSV file (*.csv)";
					}
				}, this));

		saveCSV.setEnabled(false);
		saveCSV.setAccelerator(KeyStroke.getKeyStroke("meta E"));
		file.add(saveCSV);

		bar.add(file);

		// Parser settings ----------------------------------------------------

		// TODO Clicking the same radioButtonMenuItem twice deselects it !?

		final JMenu parserSettings = new JMenu("Parser settings");

		final ButtonGroup group = new ButtonGroup();

		final JRadioButtonMenuItem fixedFormat = new JRadioButtonMenuItem();

		AbstractAction selectFixedFormat = new AbstractAction("Fixed format") {
			public void actionPerformed(ActionEvent e) {
				coordinator.setFormat(SourceFormat.FIXED);
			}
		};

		fixedFormat.setAction(selectFixedFormat);

		fixedFormat.setSelected(true);
		group.add(fixedFormat);
		parserSettings.add(fixedFormat);

		final JRadioButtonMenuItem freeFormat = new JRadioButtonMenuItem();

		AbstractAction selectFreeFormat = new AbstractAction("Free format") {
			public void actionPerformed(ActionEvent e) {
				coordinator.setFormat(SourceFormat.FREE);
			}
		};

		freeFormat.setAction(selectFreeFormat);

		group.add(freeFormat);
		parserSettings.add(freeFormat);

		bar.add(parserSettings);

		setJMenuBar(bar);
	}

	private void setupToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		add(toolBar, BorderLayout.PAGE_END);

		// pick = new JButton(new PickAndParseAction(this, this));
		// toolBar.add(pick);

		// toolBar.add(new JLabel("  "));

		progress = new JProgressBar();
		toolBar.add(progress);
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
		overviewTable.getColumnModel().getColumn(BatchResults.FILE_COLUMN)
				.setPreferredWidth(150);
		overviewTable.getColumnModel().getColumn(BatchResults.PATH_COLUMN)
				.setPreferredWidth(600);

		overviewTable.getColumnModel().getColumn(BatchResults.STATUS_COLUMN)
				.setCellRenderer(new StatusRenderer());
		overviewTable.getColumnModel().getColumn(BatchResults.COVERAGE_COLUMN)
				.setCellRenderer(new DecimalFormattingRenderer("0.0"));

		JScrollPane overviewScroll = new JScrollPane(overviewTable);
		overviewScroll.setBorder(null);

		final DetailsTable detailsTable = new DetailsTable(parseDetails);

		detailsTable.addListener(new DetailsTableListener() {
			@Override
			public void userSelectedDetail(Tuple<Token, String> detail) {
				final int selected = overviewTable
						.convertRowIndexToModel(overviewTable.getSelectedRow());
				final File file = results.getResults(selected).getFile();
				final ShowIt showIt = new ShowIt(file, true, coordinator.getFormat());
				showIt.setVisible(true);
				showIt.selectDetail(detail);
			}
		});

		JScrollPane detailsScroll = new JScrollPane(detailsTable);
		detailsScroll.setBorder(null);

		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				overviewScroll, detailsScroll);
		split.setResizeWeight(0.8);

		getContentPane().add(split, BorderLayout.CENTER);

		overviewTable.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						if (!e.getValueIsAdjusting()) {
							final int selected = overviewTable
									.convertRowIndexToModel(overviewTable
											.getSelectedRow());
							if (selected >= 0) {
								parseDetails.setParseResults(results
										.getResults(selected));
							}
						}
					}
				});

		overviewTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = overviewTable.rowAtPoint(new Point(e.getX(), e
							.getY()));

					if (row >= 0) {
						final int selected = overviewTable
								.convertRowIndexToModel(row);
						final File file = results.getResults(selected)
								.getFile();
						new ShowIt(file, true, coordinator.getFormat())
								.setVisible(true);
					}
				}
			}
		});
	}

	public void walkAndParse(File file) {
		this.pick.setEnabled(false);
		this.progress.setIndeterminate(true);

		List<File> targets = new LinkedList<File>();
		walk(file, targets);

		this.progress.setValue(0);
		this.progress.setMaximum(targets.size());
		this.progress.setIndeterminate(false);

		int count = 0;
		for (File target : targets) {
			parse(target);
			this.progress.setValue(++count);
		}

		this.pick.setEnabled(true);

		final boolean hasResults = this.results.getRowCount() > 0;
		this.clearResults.setEnabled(hasResults);
		this.saveCSV.setEnabled(hasResults);
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

		String name = file.getName().toUpperCase();
		if (name.endsWith(".CBL") || name.endsWith(".COB")
				|| name.endsWith(".CPY")) {
			targets.add(file);
		}
	}

	private void parse(File file) {
		try {
			this.results.add(this.coordinator.parse(file));

		} catch (IOException e) {
			ParseResults failed = new ParseResults(file);
			failed.setValidInput(false);
			failed.addError(null, e.getMessage());
			this.results.add(failed);
			e.printStackTrace();
		}
	}

	public Component getGUI() {
		return this;
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

	public void clearResults() {
		this.results.clear();
		this.clearResults.setEnabled(false);
		this.saveCSV.setEnabled(false);
	}
}
