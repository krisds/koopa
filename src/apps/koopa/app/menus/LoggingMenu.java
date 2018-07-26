package koopa.app.menus;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import koopa.app.actions.SetLogLevelAction;

public class LoggingMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	public LoggingMenu() {
		super("Logging");

		setupMenu();
	}

	private void setupMenu() {
		// TODO Fetch from log4j.properties in some way ?

		addMenuFor("Grammar", "grammar");

		addSeparator();

		addMenuFor("Line Separation", "source.linesplitter");
		addMenuFor("Source Formatting", "source.cobol.source_format_directives");
		addMenuFor("Compiler Directives", "source.cobol.compiler_directives");
		addMenuFor("Source Listing Directives", "source.cobol.source_listing");
		addMenuFor("Program Area", "source.cobol.program_area");
		addMenuFor("COPY Statements", "source.cobol.copy_include");
		addMenuFor("REPLACE Statements", "source.cobol.replace");
		addMenuFor("Replacements", "source.cobol.replacing");
		addMenuFor("Line Continuations", "source.cobol.continuations");
		addMenuFor("Inline Comments", "source.cobol.inline_comments");
		addMenuFor("Token Separation", "token_separation");
		addMenuFor("Optimization", "optimization");
	}

	private void addMenuFor(String name, String category) {
		final Logger logger = Logger.getLogger(category);

		final JMenu menu = new JMenu(name);
		final ButtonGroup group = new ButtonGroup();

		addLevel(logger, Level.OFF, menu, group);
		addLevel(logger, Level.FATAL, menu, group);
		addLevel(logger, Level.ERROR, menu, group);
		addLevel(logger, Level.WARN, menu, group);
		addLevel(logger, Level.INFO, menu, group);
		addLevel(logger, Level.DEBUG, menu, group);
		addLevel(logger, Level.TRACE, menu, group);
		addLevel(logger, Level.ALL, menu, group);

		add(menu);
	}

	private void addLevel(final Logger logger, Level level, JMenu menu,
			final ButtonGroup group) {

		final JRadioButtonMenuItem item = new JRadioButtonMenuItem();
		item.setAction(new SetLogLevelAction(logger, level));

		final Level currentLevel = logger.getLevel();
		if (level == Level.OFF)
			item.setSelected(currentLevel == level || currentLevel == null);
		else
			item.setSelected(currentLevel == level);

		group.add(item);
		menu.add(item);
	}
}
