package koopa.app.showit;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.DefaultMutableTreeNode;

import koopa.app.ApplicationSupport;
import koopa.app.ConfigurableApplication;
import koopa.app.actions.ExportASTToXMLAction;
import koopa.app.actions.FileManager;
import koopa.app.actions.OpenFileAction;
import koopa.app.actions.QueryUsingXPathAction;
import koopa.app.actions.ReloadFileAction;
import koopa.app.components.outline.CobolOutline;
import koopa.app.components.outline.Reference;
import koopa.app.components.sourceview.SourceView;
import koopa.parsers.Metrics;
import koopa.parsers.ParseResults;
import koopa.parsers.cobol.ParsingCoordinator;
import koopa.parsers.cobol.ParsingListener;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.generic.IntermediateTokenizer;
import koopa.util.Getter;

import org.antlr.runtime.tree.CommonTree;
import org.apache.log4j.PropertyConfigurator;

@SuppressWarnings("serial")
public class ShowIt extends JFrame implements FileManager,
		ConfigurableApplication {

	private File cobolFile = null;
	private ParseResults results = null;
	private ParsingCoordinator coordinator = null;
	private SourceView pane = null;
	private CobolOutline outline = null;

	private JMenu syntaxTree = null;

	private static DecimalFormat coverageFormatter = new DecimalFormat("0.0");

	public static void main(String[] args) {
		final URL resource = ShowIt.class.getResource("/log4j.properties");
		PropertyConfigurator.configure(resource);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ShowIt().setVisible(true);
			}
		});
	}

	public ShowIt() {
		this(new File("testsuite/cobol85/CM101M.CBL"), false,
				SourceFormat.FIXED);
	}

	public ShowIt(File file, boolean isDialog, SourceFormat format) {
		super("Koopa Show It - " + file);

		this.coordinator = new ParsingCoordinator();
		this.coordinator.setKeepingTrackOfTokens(true);
		this.coordinator.setFormat(format);

		ApplicationSupport.configureFromProperties("showit.properties", this);

		setupMenuBar(isDialog);

		setupComponents();
		openFile(file);

		setSize(900, 600);
		setLocationRelativeTo(null);

		if (isDialog) {
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		} else {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
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

	private void setupMenuBar(boolean isDialog) {
		// Be nice to mac users (like myself).
		System.setProperty("apple.laf.useScreenMenuBar", "true");

		final JMenuBar bar = new JMenuBar();

		// File ----------------------------------------------------------------

		final JMenu file = new JMenu("File");

		if (!isDialog) {
			final JMenuItem open = new JMenuItem(new OpenFileAction(this,
					new FileFilter() {
						public boolean accept(File f) {
							if (!f.isFile())
								return false;
							final String name = f.getName().toUpperCase();
							return name.endsWith(".CBL")
									|| name.endsWith(".COB")
									|| name.endsWith(".CPY");
						}

						public String getDescription() {
							return "Cobol file (*.cpy, *.cbl, *.cob)";
						}
					}, this));

			open.setAccelerator(KeyStroke.getKeyStroke("meta O"));
			file.add(open);

			final JMenuItem reload = new JMenuItem(new ReloadFileAction(this));
			reload.setAccelerator(KeyStroke.getKeyStroke("meta R"));
			file.add(reload);
		}

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

		// Syntax tree ---------------------------------------------------------

		this.syntaxTree = new JMenu("Syntax tree");

		Getter<CommonTree> astGetter = new Getter<CommonTree>() {
			public CommonTree getIt() {
				return results.getTree();
			}
		};

		final JMenuItem saveXML = new JMenuItem(new ExportASTToXMLAction(
				astGetter, new FileFilter() {
					public boolean accept(File f) {
						if (!f.isFile())
							return false;
						final String name = f.getName().toUpperCase();
						return name.endsWith(".XML");
					}

					public String getDescription() {
						return "XML file (*.xml)";
					}
				}, this));

		saveXML.setAccelerator(KeyStroke.getKeyStroke("meta E"));
		syntaxTree.add(saveXML);

		syntaxTree.addSeparator();

		final JMenuItem queryUsingXath = new JMenuItem(
				new QueryUsingXPathAction(astGetter, this, this));

		queryUsingXath.setAccelerator(KeyStroke.getKeyStroke("meta P"));
		syntaxTree.add(queryUsingXath);

		bar.add(syntaxTree);

		setJMenuBar(bar);
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

		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, outline,
				pane);
		split.setResizeWeight(0.5);

		getContentPane().add(split, BorderLayout.CENTER);
	}

	public void openFile(File file) {
		if (file == null) {
			return;
		}

		this.cobolFile = file;
		setTitle("Koopa Show It - " + this.cobolFile + " (parsing)");

		if (syntaxTree != null) {
			syntaxTree.setEnabled(false);
		}

		try {
			results = this.coordinator.parse(this.cobolFile);

			if (syntaxTree != null && results.getErrorCount() == 0
					&& results.getTree() != null) {
				syntaxTree.setEnabled(true);
			}

			float coverage = Metrics.getCoverage(results);

			setTitle("Koopa Show It - " + this.cobolFile + " ("
					+ coverageFormatter.format(coverage) + "%)");

		} catch (IOException e) {
			setTitle("Koopa Show It - " + this.cobolFile);
			// TODO Auto-generated catch block
			e.printStackTrace();
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
}
