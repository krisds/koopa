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

import koopa.app.ApplicationSupport;
import koopa.app.ConfigurableApplication;
import koopa.app.actions.FileManager;
import koopa.app.actions.OpenFileAction;
import koopa.app.components.outline.CobolOutline;
import koopa.app.components.outline.Reference;
import koopa.app.components.sourceview.SourceView;
import koopa.app.parsers.ParsingCoordinator;
import koopa.app.parsers.ParsingListener;
import koopa.tokens.Token;

@SuppressWarnings("serial")
public class ShowIt extends JFrame implements FileManager,
		ConfigurableApplication {

	private ParsingCoordinator coordinator = null;
	private SourceView pane = null;
	private CobolOutline outline = null;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ShowIt().setVisible(true);
			}
		});
	}

	public ShowIt() {
		this(new File("testsuite/cobol85/CM101M.CBL"));

		setupMenuBar();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public ShowIt(File file) {
		super("Koopa Show It - " + file);

		this.coordinator = new ParsingCoordinator();

		ApplicationSupport.configureFromProperties("showit.properties", this);

		setupComponents();
		openFile(file);

		setSize(900, 600);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

	private void setupMenuBar() {
		// Be nice to mac users.
		System.setProperty("apple.laf.useScreenMenuBar", "true");

		JMenuBar bar = new JMenuBar();

		JMenu file = new JMenu("File");
		JMenuItem open = new JMenuItem(new OpenFileAction(this,
				new FileFilter() {
					public boolean accept(File f) {
						if (!f.isFile())
							return false;
						final String name = f.getName().toUpperCase();
						return name.endsWith(".CBL") || name.endsWith(".CPY");
					}

					public String getDescription() {
						return "Cobol file (*.CPY, *.CBL)";
					}
				}, this));

		open.setAccelerator(KeyStroke.getKeyStroke("meta O"));
		file.add(open);

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

		try {
			this.coordinator.parse(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
