package koopa.app.menus;

import static koopa.app.ApplicationSupport.MODIFIER;
import static koopa.app.ApplicationSupport.setAccelerators;

import java.awt.Component;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import koopa.app.Application;
import koopa.app.actions.CloseFileAction;
import koopa.app.actions.DebugAction;
import koopa.app.actions.ExportBatchResultsToCSVAction;
import koopa.app.actions.OpenFileAction;
import koopa.app.actions.QuitParsingAction;
import koopa.app.actions.ReloadFileAction;
import koopa.app.batchit.ClearResultsAction;
import koopa.app.components.detail.Detail;
import koopa.app.components.overview.Overview;
import koopa.app.debug.Debug;
import koopa.cobol.CobolFiles;

public class FileMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private Application application = null;

	private JMenuItem open = null;
	private JMenuItem reload = null;
	private JMenuItem debug = null;
	private JMenuItem close = null;
	private JMenuItem quitParsing = null;
	private JMenuItem clearResults = null;
	private JMenuItem saveCSV = null;

	public FileMenu(Application application) {
		super("File");

		this.application = application;
		setupMenu();
	}

	private void setupMenu() {

		open = new JMenuItem(new OpenFileAction("Parse ...", application,
				CobolFiles.getSwingFileFilter(false), this));

		setAccelerators(open, MODIFIER + " O");
		add(open);

		reload = new JMenuItem(new ReloadFileAction(application));
		setAccelerators(reload, MODIFIER + " R");
		add(reload);

		debug = new JMenuItem(new DebugAction(application));
		setAccelerators(debug, MODIFIER + " D");
		add(debug);

		close = new JMenuItem(new CloseFileAction(application));
		setAccelerators(close, MODIFIER + " W", "ESCAPE");
		add(close);

		addSeparator();

		quitParsing = new JMenuItem(new QuitParsingAction(application));
		setAccelerators(quitParsing, MODIFIER + " B");
		add(quitParsing);

		addSeparator();

		clearResults = new JMenuItem(
				new ClearResultsAction(application.getOverview()));
		add(clearResults);

		saveCSV = new JMenuItem(new ExportBatchResultsToCSVAction(
				() -> application.getOverview().getResults(), this));

		setAccelerators(saveCSV, MODIFIER + " E");
		add(saveCSV);
	}

	// TODO Via ApplicationListener ?
	public void update() {
		Overview overview = application.getOverview();
		Component view = application.getView();

		if (view == application.getOverview()) {
			boolean isParsing = overview.isParsing();
			boolean hasResults = !isParsing
					&& overview.getResults().getRowCount() > 0;

			open.setEnabled(!isParsing);
			reload.setEnabled(false);
			debug.setEnabled(false);
			close.setEnabled(false);
			quitParsing.setEnabled(isParsing);
			clearResults.setEnabled(hasResults);
			saveCSV.setEnabled(hasResults);

		} else if (view instanceof Detail) {
			Detail detail = (Detail) view;

			boolean isParsing = overview.isParsing();
			boolean canDoExtraActions = !isParsing && !detail.isParsing();

			open.setEnabled(canDoExtraActions);
			reload.setEnabled(canDoExtraActions);
			debug.setEnabled(canDoExtraActions);
			close.setEnabled(canDoExtraActions);
			quitParsing.setEnabled(isParsing);
			clearResults.setEnabled(false);
			saveCSV.setEnabled(false);
			
		} else if (view instanceof Debug) {
			Debug debug = (Debug) view;

			boolean isParsing = overview.isParsing();
			boolean canDoExtraActions = !isParsing && !debug.isParsing();

			open.setEnabled(canDoExtraActions);
			reload.setEnabled(canDoExtraActions);
			debug.setEnabled(canDoExtraActions);
			close.setEnabled(canDoExtraActions);
			quitParsing.setEnabled(isParsing);
			clearResults.setEnabled(false);
			saveCSV.setEnabled(false);
		}
	}
}
