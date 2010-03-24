package koopa.app.batchit;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import koopa.app.ApplicationSupport;
import koopa.app.ConfigurableApplication;
import koopa.app.actions.ParsingProvider;
import koopa.app.actions.PickAndParseAction;
import koopa.app.parsers.ParseResults;
import koopa.app.parsers.ParsingCoordinator;
import koopa.app.parsers.ParsingListener;
import koopa.app.showit.ShowIt;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.HighlighterFactory;

@SuppressWarnings("serial")
public class BatchIt extends JFrame implements ParsingProvider,
		ConfigurableApplication {

	private JButton pick = null;

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

		ApplicationSupport.configureFromProperties("batchit.properties", this);

		setupToolBar();
		setupComponents();

		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void setupToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		add(toolBar, BorderLayout.PAGE_START);

		pick = new JButton(new PickAndParseAction(this, this));
		toolBar.add(pick);

		toolBar.add(new JLabel("  "));

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

		overviewTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		overviewTable.getColumnModel().getColumn(1).setPreferredWidth(70);
		overviewTable.getColumnModel().getColumn(2).setPreferredWidth(70);
		overviewTable.getColumnModel().getColumn(3).setPreferredWidth(150);
		overviewTable.getColumnModel().getColumn(4).setPreferredWidth(600);

		JScrollPane overviewScroll = new JScrollPane(overviewTable);
		overviewScroll.setBorder(null);

		JXTable detailsTable = new JXTable();
		detailsTable.setBorder(null);
		detailsTable.setModel(parseDetails);
		detailsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		detailsTable.setHighlighters(HighlighterFactory.createSimpleStriping());

		detailsTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		detailsTable.getColumnModel().getColumn(1).setPreferredWidth(40);
		detailsTable.getColumnModel().getColumn(2).setPreferredWidth(40);
		detailsTable.getColumnModel().getColumn(3).setPreferredWidth(150);
		detailsTable.getColumnModel().getColumn(4).setPreferredWidth(600);

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
						new ShowIt(file, true).setVisible(true);
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
		if (name.endsWith(".CBL") || name.endsWith(".CPY")) {
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
}
