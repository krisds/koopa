package koopa.app.menus;

import static koopa.app.ApplicationSupport.MODIFIER;
import static koopa.app.ApplicationSupport.setAccelerators;

import java.awt.Component;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import koopa.app.Application;
import koopa.app.Textual;
import koopa.app.actions.FindAction;
import koopa.app.actions.FindAgainAction;
import koopa.app.actions.GoToLineAction;

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
		final Component view = application.getView();

		final boolean textual = (view instanceof Textual);

		setEnabled(textual);
		find.setEnabled(textual);
		findAgain.setEnabled(textual);
		goToLine.setEnabled(textual);
	}
}
