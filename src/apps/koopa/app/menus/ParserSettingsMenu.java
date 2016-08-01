package koopa.app.menus;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import koopa.app.Application;
import koopa.app.components.cobolwords.CobolWordSettings;
import koopa.app.components.copybookpaths.CopybookPathsSelector;
import koopa.app.components.detail.Detail;
import koopa.app.components.fileextensions.FileExtensions;
import koopa.app.components.lineendings.LineEndingSettings;
import koopa.app.components.overview.Overview;
import koopa.cobol.parser.Coordinated;
import koopa.cobol.sources.SourceFormat;

public class ParserSettingsMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private Application application;

	private JMenu sourceFormat = null;
	private JRadioButtonMenuItem fixedFormat = null;
	private JRadioButtonMenuItem freeFormat = null;
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

		AbstractAction selectFixedFormat = new AbstractAction("Fixed") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				final Coordinated view = application.getCoordinatedView();
				view.getParsingCoordinator().setFormat(SourceFormat.FIXED);
			}
		};

		fixedFormat.setAction(selectFixedFormat);

		fixedFormat.setSelected(true);
		group.add(fixedFormat);
		sourceFormat.add(fixedFormat);

		freeFormat = new JRadioButtonMenuItem();

		AbstractAction selectFreeFormat = new AbstractAction("Free") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				final Coordinated view = application.getCoordinatedView();
				view.getParsingCoordinator().setFormat(SourceFormat.FREE);
			}
		};

		freeFormat.setAction(selectFreeFormat);

		group.add(freeFormat);
		sourceFormat.add(freeFormat);

		preprocessing = new JMenu("Preprocessing");
		add(preprocessing);

		final ButtonGroup preprocessingGroup = new ButtonGroup();
		preprocessingEnabled = new JRadioButtonMenuItem();
		preprocessingDisabled = new JRadioButtonMenuItem("Disabled");
		preprocessingGroup.add(preprocessingEnabled);
		preprocessingGroup.add(preprocessingDisabled);

		AbstractAction enablePreprocessing = new AbstractAction("Enabled") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				final Coordinated view = application.getCoordinatedView();
				view.getParsingCoordinator().setPreprocessing(true);
			}
		};

		AbstractAction disablePreprocessing = new AbstractAction("Disabled") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				final Coordinated view = application.getCoordinatedView();
				view.getParsingCoordinator().setPreprocessing(false);
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

		JMenuItem cobolWords = new JMenuItem();
		cobolWords.setAction(CobolWordSettings.actionToShow(application));
		add(cobolWords);
	}

	public void update() {
		Overview overview = application.getOverview();
		Component view = application.getView();

		if (view == overview) {
			boolean isParsing = overview.isParsing();

			setEnabled(!isParsing);
			switch (overview.getParsingCoordinator().getFormat()) {
			case FIXED:
				fixedFormat.setSelected(true);
				break;
			case FREE:
				freeFormat.setSelected(true);
				break;
			}

			if (overview.getParsingCoordinator().isPreprocessing())
				preprocessingEnabled.setSelected(true);
			else
				preprocessingEnabled.setSelected(false);

		} else {
			Detail detail = (Detail) view;

			switch (detail.getParsingCoordinator().getFormat()) {
			case FIXED:
				fixedFormat.setSelected(true);
				break;
			case FREE:
				freeFormat.setSelected(true);
				break;
			}

			if (detail.getParsingCoordinator().isPreprocessing())
				preprocessingEnabled.setSelected(true);
			else
				preprocessingEnabled.setSelected(false);
		}
	}

}
