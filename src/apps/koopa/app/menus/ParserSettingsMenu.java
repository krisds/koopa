package koopa.app.menus;

import static koopa.cobol.sources.SourceFormat.FIXED;
import static koopa.cobol.sources.SourceFormat.FREE;
import static koopa.cobol.sources.SourceFormat.VARIABLE;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import koopa.app.Application;
import koopa.app.CobolParserFactory;
import koopa.app.actions.SetSourceFormatAction;
import koopa.app.components.cobolwords.CobolWordSettings;
import koopa.app.components.copybookpaths.CopybookPathsSelector;
import koopa.app.components.fileextensions.FileExtensions;
import koopa.app.components.lineendings.LineEndingSettings;
import koopa.app.components.overview.Overview;
import koopa.app.components.tabs.TabSettings;
import koopa.cobol.CobolProject;

public class ParserSettingsMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private Application application;

	private JMenu sourceFormat = null;
	private JRadioButtonMenuItem fixedFormat = null;
	private JRadioButtonMenuItem freeFormat = null;
	private JRadioButtonMenuItem variableFormat = null;
	private JMenu preprocessing = null;
	private JRadioButtonMenuItem preprocessingEnabled = null;
	private JRadioButtonMenuItem preprocessingDisabled = null;
	private JMenuItem copybookPath = null;

	public ParserSettingsMenu(Application application) {
		super("Parser settings");

		this.application = application;
		setupMenu();
	}

	private void setupMenu() {
		sourceFormat = new JMenu("Source format");
		add(sourceFormat);

		final ButtonGroup group = new ButtonGroup();

		fixedFormat = new JRadioButtonMenuItem();
		fixedFormat.setAction(
				new SetSourceFormatAction(application, "Fixed", FIXED));

		fixedFormat.setSelected(true);
		group.add(fixedFormat);
		sourceFormat.add(fixedFormat);

		freeFormat = new JRadioButtonMenuItem();
		freeFormat.setAction(
				new SetSourceFormatAction(application, "Free", FREE));

		group.add(freeFormat);
		sourceFormat.add(freeFormat);

		variableFormat = new JRadioButtonMenuItem();
		variableFormat.setAction(
				new SetSourceFormatAction(application, "Variable", VARIABLE));

		group.add(variableFormat);
		sourceFormat.add(variableFormat);

		preprocessing = new JMenu("Preprocessing");
		add(preprocessing);

		final ButtonGroup preprocessingGroup = new ButtonGroup();
		preprocessingEnabled = new JRadioButtonMenuItem();
		preprocessingDisabled = new JRadioButtonMenuItem("Disabled");
		preprocessingGroup.add(preprocessingEnabled);
		preprocessingGroup.add(preprocessingDisabled);

		AbstractAction enablePreprocessing = new AbstractAction("Enabled") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				application.getCobolParserFactory().getProject()
						.setDefaultPreprocessing(true);
			}
		};

		AbstractAction disablePreprocessing = new AbstractAction("Disabled") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				application.getCobolParserFactory().getProject()
						.setDefaultPreprocessing(false);
			}
		};

		preprocessingEnabled.setAction(enablePreprocessing);
		preprocessingDisabled.setAction(disablePreprocessing);

		preprocessing.add(preprocessingEnabled);
		preprocessing.add(preprocessingDisabled);
		preprocessingDisabled.setSelected(true);

		preprocessing.addSeparator();

		copybookPath = new JMenuItem();
		copybookPath.setAction(CopybookPathsSelector.actionToShow(application));
		preprocessing.add(copybookPath);

		addSeparator();

		JMenuItem fileExtensions = new JMenuItem();
		fileExtensions.setAction(FileExtensions.actionToShow(application));
		add(fileExtensions);

		JMenuItem lineEndings = new JMenuItem();
		lineEndings.setAction(LineEndingSettings.actionToShow(application));
		add(lineEndings);

		JMenuItem tabSettings = new JMenuItem();
		tabSettings.setAction(TabSettings.actionToShow(application));
		add(tabSettings);

		JMenuItem cobolWords = new JMenuItem();
		cobolWords.setAction(CobolWordSettings.actionToShow(application));
		add(cobolWords);
	}

	public void update() {
		final Overview overview = application.getOverview();
		setEnabled(!overview.isParsing());

		final CobolParserFactory factory = application.getCobolParserFactory();
		if (factory != null) {
			final CobolProject project = factory.getProject();

			switch (project.getDefaultFormat()) {
			case FIXED:
				fixedFormat.setSelected(true);
				break;
			case FREE:
				freeFormat.setSelected(true);
				break;
			case VARIABLE:
				variableFormat.setSelected(true);
				break;
			}

			preprocessingEnabled.setSelected(project.isDefaultPreprocessing());
		}
	}
}
