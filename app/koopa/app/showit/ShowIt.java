package koopa.app.showit;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.DefaultMutableTreeNode;

import org.antlr.runtime.tree.CommonTree;

import koopa.app.ApplicationSupport;
import koopa.app.ConfigurableApplication;
import koopa.app.actions.ExportASTToXMLAction;
import koopa.app.actions.FileManager;
import koopa.app.actions.OpenFileAction;
import koopa.app.components.outline.CobolOutline;
import koopa.app.components.outline.Reference;
import koopa.app.components.sourceview.SourceView;
import koopa.app.parsers.ParseResults;
import koopa.app.parsers.ParsingCoordinator;
import koopa.app.parsers.ParsingListener;
import koopa.tokenizers.generic.IntermediateTokenizer;
import koopa.tokens.Token;
import koopa.util.Getter;

@SuppressWarnings("serial")
public class ShowIt extends JFrame implements FileManager,
		ConfigurableApplication {

	private ParseResults results = null;
	private ParsingCoordinator coordinator = null;
	private SourceView pane = null;
	private CobolOutline outline = null;

	private JMenuItem saveXML = null;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ShowIt().setVisible(true);
			}
		});
	}

	public ShowIt() {
		this(new File("testsuite/cobol85/CM101M.CBL"), false);
	}

	public ShowIt(File file, boolean isDialog) {
		super("Koopa Show It - " + file);

		this.coordinator = new ParsingCoordinator();

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
		// Be nice to mac users.
		System.setProperty("apple.laf.useScreenMenuBar", "true");

		JMenuBar bar = new JMenuBar();

		JMenu file = new JMenu("File");

		if (!isDialog) {
			JMenuItem open = new JMenuItem(new OpenFileAction(this,
					new FileFilter() {
						public boolean accept(File f) {
							if (!f.isFile())
								return false;
							final String name = f.getName().toUpperCase();
							return name.endsWith(".CBL")
									|| name.endsWith(".CPY");
						}

						public String getDescription() {
							return "Cobol file (*.cpy, *.cbl)";
						}
					}, this));

			open.setAccelerator(KeyStroke.getKeyStroke("meta O"));
			file.add(open);

			file.addSeparator();
		}

		saveXML = new JMenuItem(new ExportASTToXMLAction(
				new Getter<CommonTree>() {
					public CommonTree getIt() {
						return results.getTree();
					}
				}, new FileFilter() {
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

		saveXML.setEnabled(false);
		saveXML.setAccelerator(KeyStroke.getKeyStroke("meta E"));
		file.add(saveXML);

		bar.add(file);

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
					final Token token = ref.getToken();
					pane.scrollTo(token.getStart().getPositionInFile());
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
		setTitle("Koopa Show It - " + file);

		if (saveXML != null) {
			saveXML.setEnabled(false);
		}

		try {
			results = this.coordinator.parse(file);

			if (saveXML != null && results.getErrorCount() == 0
					&& results.getTree() != null) {
				saveXML.setEnabled(true);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
