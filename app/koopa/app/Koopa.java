package koopa.app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import koopa.app.actions.CloseFileAction;
import koopa.app.actions.ExportASTToXMLAction;
import koopa.app.actions.ExportBatchResultsToCSVAction;
import koopa.app.actions.GoToLineAction;
import koopa.app.actions.OpenFileAction;
import koopa.app.actions.QueryUsingXPathAction;
import koopa.app.actions.ReloadFileAction;
import koopa.app.actions.ShowGrammarAction;
import koopa.app.batchit.BatchResults;
import koopa.app.batchit.ClearResultsAction;
import koopa.app.components.detail.Detail;
import koopa.app.components.misc.Tab;
import koopa.app.components.overview.Overview;
import koopa.parsers.Metrics;
import koopa.parsers.ParseResults;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokens.Token;
import koopa.util.Getter;
import koopa.util.Tuple;

import org.antlr.runtime.tree.CommonTree;
import org.apache.log4j.PropertyConfigurator;

public class Koopa extends JFrame implements Application, Configurable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		final URL resource = Detail.class.getResource("/log4j.properties");
		PropertyConfigurator.configure(resource);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Koopa().setVisible(true);
			}
		});
	}

	private static DecimalFormat coverageFormatter = new DecimalFormat("0.0");

	private List<ApplicationListener> listeners = new ArrayList<ApplicationListener>();

	private JMenu file = null;
	private JMenuItem open = null;
	private JMenuItem reload = null;
	private JMenuItem close = null;
	private JMenuItem clearResults = null;
	private JMenuItem saveCSV = null;

	private JMenu parserSettings = null;
	private JRadioButtonMenuItem fixedFormat = null;
	private JRadioButtonMenuItem freeFormat = null;

	private JMenu navigation = null;
	private JMenuItem goToLine = null;

	private JMenu syntaxTree = null;
	private JMenuItem saveXML = null;
	private JMenuItem queryUsingXath = null;
	private JMenuItem showGrammar = null;

	private JTabbedPane tabbedPane = null;
	private Overview overview = null;

	public Koopa() {
		super("Koopa");

		ApplicationSupport.configureFromProperties("koopa.properties", this);

		setupComponents();
		setupMenuBar();

		updateMenus();

		setupDragAndDropOfFiles();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width - 100, screenSize.height - 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void setOption(String name, String value) {
	}

	private void setupMenuBar() {
		// Be nice to mac users (like me).
		System.setProperty("apple.laf.useScreenMenuBar", "true");

		JMenuBar bar = new JMenuBar();

		// File operations ----------------------------------------------------

		file = new JMenu("File");

		open = new JMenuItem(new OpenFileAction("Parse ...", this,
				ApplicationSupport.getCobolFileFilter(false), this));

		open.setAccelerator(KeyStroke.getKeyStroke("meta O"));
		file.add(open);

		reload = new JMenuItem(new ReloadFileAction(this));
		reload.setAccelerator(KeyStroke.getKeyStroke("meta R"));
		file.add(reload);

		close = new JMenuItem(new CloseFileAction(this));
		KeyStroke keystrokeForClosingATab = KeyStroke.getKeyStroke("meta W");
		KeyStroke alternateKeystrokeForClosingATab = KeyStroke
				.getKeyStroke("ESCAPE");
		close.setAccelerator(keystrokeForClosingATab);
		InputMap im = close.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		im.put(alternateKeystrokeForClosingATab,
				im.get(keystrokeForClosingATab));
		file.add(close);

		file.addSeparator();

		clearResults = new JMenuItem(new ClearResultsAction(overview));
		file.add(clearResults);

		saveCSV = new JMenuItem(new ExportBatchResultsToCSVAction(
				new Getter<BatchResults>() {
					public BatchResults getIt() {
						return overview.getResults();
					}
				}, this));

		saveCSV.setAccelerator(KeyStroke.getKeyStroke("meta E"));
		file.add(saveCSV);

		bar.add(file);

		// --- Parser settings ------------------------------------------------

		parserSettings = new JMenu("Parser settings");

		final ButtonGroup group = new ButtonGroup();

		fixedFormat = new JRadioButtonMenuItem();

		AbstractAction selectFixedFormat = new AbstractAction("Fixed format") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				Component view = getView();
				if (view == overview) {
					overview.setSourceFormat(SourceFormat.FIXED);
				} else {
					((Detail) view).setSourceFormat(SourceFormat.FIXED);
				}
			}
		};

		fixedFormat.setAction(selectFixedFormat);

		fixedFormat.setSelected(true);
		group.add(fixedFormat);
		parserSettings.add(fixedFormat);

		freeFormat = new JRadioButtonMenuItem();

		AbstractAction selectFreeFormat = new AbstractAction("Free format") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				Component view = getView();
				if (view == overview) {
					overview.setSourceFormat(SourceFormat.FREE);
				} else {
					((Detail) view).setSourceFormat(SourceFormat.FREE);
				}
			}
		};

		freeFormat.setAction(selectFreeFormat);

		group.add(freeFormat);
		parserSettings.add(freeFormat);

		bar.add(parserSettings);

		// Navigation ---------------------------------------------------------

		navigation = new JMenu("Navigation");

		goToLine = new JMenuItem(new GoToLineAction(this, this));
		goToLine.setAccelerator(KeyStroke.getKeyStroke("meta L"));
		navigation.add(goToLine);

		bar.add(navigation);

		// Parse results ------------------------------------------------------

		syntaxTree = new JMenu("Syntax tree");

		showGrammar = new JMenuItem(new ShowGrammarAction());
		showGrammar.setAccelerator(KeyStroke.getKeyStroke("meta G"));
		syntaxTree.add(showGrammar);

		syntaxTree.addSeparator();

		saveXML = new JMenuItem(new ExportASTToXMLAction(this, this));
		saveXML.setAccelerator(KeyStroke.getKeyStroke("meta E"));
		syntaxTree.add(saveXML);

		queryUsingXath = new JMenuItem(new QueryUsingXPathAction(this, this));
		queryUsingXath.setAccelerator(KeyStroke.getKeyStroke("meta P"));
		syntaxTree.add(queryUsingXath);

		bar.add(syntaxTree);

		// --------------------------------------------------------------------

		setJMenuBar(bar);
	}

	private void setupComponents() {
		tabbedPane = new JTabbedPane();

		overview = new Overview(this);
		tabbedPane.addTab("Overview", overview);

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				updateMenus();
				fireSwitchedView(getView());
			}
		});

		getContentPane().add(tabbedPane, BorderLayout.CENTER);
	}

	private void setupDragAndDropOfFiles() {
		TransferHandler handler = new TransferHandler() {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean canImport(TransferHandler.TransferSupport info) {
				return info
						.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
			}

			@Override
			public boolean importData(TransferHandler.TransferSupport info) {
				// TODO Check that Koopa isn't already doing something else...

				if (!info.isDrop())
					return false;

				if (!info.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
					JOptionPane.showMessageDialog(Koopa.this,
							"Koopa doesn't accept this type of data.",
							"Sorry...", JOptionPane.ERROR_MESSAGE);
					return false;
				}

				try {
					Transferable t = info.getTransferable();

					@SuppressWarnings("unchecked")
					final List<File> data = (List<File>) t
							.getTransferData(DataFlavor.javaFileListFlavor);

					if (data != null && !data.isEmpty()) {
						new Thread(new Runnable() {
							public void run() {
								if (data.size() == 1) {
									File file = data.get(0);

									if (file.isDirectory()) {
										tabbedPane
												.setSelectedComponent(overview);
										overview.walkAndParse(file);

									} else {
										openFile(file);
									}

								} else {
									tabbedPane.setSelectedComponent(overview);
									for (File file : data)
										overview.walkAndParse(file);
								}
							}
						}).start();
					}

					return true;

				} catch (UnsupportedFlavorException e) {
					return false;

				} catch (IOException e) {
					return false;
				}
			}
		};

		this.setTransferHandler(handler);
	}

	private void updateMenus() {
		Component view = getView();

		if (view == overview) {
			boolean canDoExtraActions = !overview.isParsing();
			boolean hasResults = canDoExtraActions
					&& overview.getResults().getRowCount() > 0;

			// File menu ...
			open.setEnabled(canDoExtraActions);
			reload.setEnabled(false);
			close.setEnabled(false);
			clearResults.setEnabled(hasResults);
			saveCSV.setEnabled(hasResults);

			// Parse settings ...
			parserSettings.setEnabled(canDoExtraActions);
			switch (overview.getSourceFormat()) {
			case FIXED:
				fixedFormat.setSelected(true);
				break;
			case FREE:
				freeFormat.setSelected(true);
				break;
			}

			// Navigation ...
			navigation.setEnabled(false);
			goToLine.setEnabled(false);

			// Syntax tree ...
			saveXML.setEnabled(false);
			queryUsingXath.setEnabled(false);

		} else {
			Detail detail = (Detail) view;

			boolean canDoExtraActions = !overview.isParsing()
					&& !detail.isParsing();

			// File menu ...
			open.setEnabled(canDoExtraActions);
			reload.setEnabled(canDoExtraActions);
			close.setEnabled(canDoExtraActions);
			clearResults.setEnabled(false);
			saveCSV.setEnabled(false);

			// Parse settings ...
			switch (detail.getSourceFormat()) {
			case FIXED:
				fixedFormat.setSelected(true);
				break;
			case FREE:
				freeFormat.setSelected(true);
				break;
			}

			// Navigation ...
			navigation.setEnabled(true);
			goToLine.setEnabled(true);

			// Syntax tree ...
			boolean hasSyntaxTree = detail.hasSyntaxTree();
			saveXML.setEnabled(hasSyntaxTree);
			queryUsingXath.setEnabled(hasSyntaxTree);
		}
	}

	@Override
	public void openFile(File file) {
		Component view = getView();

		if (overview == view) {
			openFile(file, overview.getSourceFormat(), null);

		} else {
			Detail detail = (Detail) view;
			openFile(file, detail.getSourceFormat(), null);
		}
	}

	@Override
	public void openFile(File file, SourceFormat format) {
		openFile(file, format, null);
	}

	@Override
	public void openFile(File file, SourceFormat format,
			Tuple<Token, String> selectedToken) {

		if (file.isDirectory()) {
			overview.walkAndParse(file);
			return;
		}

		// TODO Check if there already exists a tab for the given file. In that
		// case do a reload instead.

		final Detail detail = new Detail(file, true, format);
		overview.addParseResults(detail.getParseResults());

		String title = getTitleForDetail(detail);

		Tab tab = new Tab(title, this, detail);

		tabbedPane.addTab(title, detail);
		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(detail), tab);

		if (selectedToken != null)
			detail.selectDetail(selectedToken);

		tabbedPane.setSelectedComponent(detail);
	}

	private String getTitleForDetail(Detail detail) {
		final ParseResults parseResults = detail.getParseResults();

		float coverage = Metrics.getCoverage(parseResults);
		String title = detail.getFile().getName();
		if (coverage < 100)
			title += " (" + coverageFormatter.format(coverage) + "%)";

		return title;
	}

	@Override
	public void resultsWereCleared() {
		updateMenus();
	}

	@Override
	public void walkingAndParsing() {
		updateMenus();
	}

	@Override
	public void doneWalkingAndParsing() {
		updateMenus();
	}

	@Override
	public void reloadFile() {
		Component view = getView();

		if (view instanceof Detail) {
			Detail detail = (Detail) view;
			detail.reloadFile();

			Tab tab = (Tab) tabbedPane.getTabComponentAt(tabbedPane
					.indexOfComponent(detail));
			tab.setTitle(getTitleForDetail(detail));

			updateMenus();
			fireUpdatedView(view);
		}
	}

	@Override
	public void scrollTo(int position) {
		Component view = getView();

		if (view instanceof Detail) {
			Detail detail = (Detail) view;
			detail.scrollTo(position);
		}
	}

	@Override
	public void addApplicationListener(ApplicationListener listener) {
		listeners.add(listener);
	}

	private void fireSwitchedView(Component view) {
		for (ApplicationListener listener : listeners) {
			listener.switchedView(view);
		}
	}

	private void fireUpdatedView(Component view) {
		for (ApplicationListener listener : listeners) {
			listener.updatedView(view);
		}
	}

	private void fireClosedDetail(Component view) {
		for (ApplicationListener listener : listeners) {
			listener.closedDetail(view);
		}
	}

	@Override
	public CommonTree getSyntaxTree() {
		final Component view = getView();
		if (view == overview)
			return null;
		else
			return ((Detail) view).getParseResults().getTree();
	}

	@Override
	public Component getView() {
		return tabbedPane.getSelectedComponent();
	}

	@Override
	public void closeView(Component component) {
		if (component == overview)
			return;

		int index = tabbedPane.indexOfComponent(component);
		tabbedPane.removeTabAt(index);

		fireClosedDetail(component);
		updateMenus();
	}

	@Override
	public void closeView() {
		closeView(getView());
	}
}
