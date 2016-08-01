package koopa.app.menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import koopa.app.Application;
import koopa.app.actions.ShowMarkdownAction;

public class HelpMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private Application application = null;

	private JMenuItem readme = null;
	private JMenuItem contributors = null;
	private JMenuItem license = null;

	public HelpMenu(Application application) {
		super("Help");

		this.application = application;
		setupMenu();
	}

	private void setupMenu() {
		readme = new JMenuItem(new ShowMarkdownAction(application,
				"README...", "/README.md", "README"));
		add(readme);
		
		contributors = new JMenuItem(new ShowMarkdownAction(application,
				"Contributors...", "/CONTRIBUTORS.md", "Contributors"));
		add(contributors);
		
		license = new JMenuItem(new ShowMarkdownAction(application,
				"License...", "/LICENSE.md", "License"));
		add(license);
	}

	// TODO Via ApplicationListener ?
	public void update() {
	}
}
