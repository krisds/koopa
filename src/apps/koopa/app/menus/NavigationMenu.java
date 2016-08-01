package koopa.app.menus;

import static koopa.app.ApplicationSupport.MODIFIER;
import static koopa.app.ApplicationSupport.setAccelerators;

import java.awt.Component;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import koopa.app.Application;
import koopa.app.actions.FindAction;
import koopa.app.actions.FindAgainAction;
import koopa.app.actions.GoToLineAction;
import koopa.app.components.overview.Overview;

public class NavigationMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private Application application;

	private JMenuItem goToLine = null;
	private JMenuItem find = null;
	private JMenuItem findAgain = null;

	public NavigationMenu(Application application) {
		super("Navigation");

		this.application = application;
		setupMenu();
	}

	private void setupMenu() {
		goToLine = new JMenuItem(new GoToLineAction(application));
		setAccelerators(goToLine, MODIFIER + " L");
		add(goToLine);

		final FindAction findAction = new FindAction(application);
		find = new JMenuItem(findAction);
		setAccelerators(find, MODIFIER + " F");
		add(find);

		findAgain = new JMenuItem(new FindAgainAction(application, findAction));
		setAccelerators(findAgain, MODIFIER + " G");
		add(findAgain);
	}

	public void update() {
		Overview overview = application.getOverview();
		Component view = application.getView();

		if (view == overview) {
			setEnabled(false);
			goToLine.setEnabled(false);
			find.setEnabled(false);
			findAgain.setEnabled(false);

		} else {
			setEnabled(true);
			goToLine.setEnabled(true);
			find.setEnabled(true);
			findAgain.setEnabled(true);
		}
	}
}
