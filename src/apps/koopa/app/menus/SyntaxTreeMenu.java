package koopa.app.menus;

import static koopa.app.ApplicationSupport.MODIFIER;
import static koopa.app.ApplicationSupport.setAccelerators;

import java.awt.Component;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import koopa.app.Application;
import koopa.app.actions.ExportASTToXMLAction;
import koopa.app.actions.QueryUsingXPathAction;
import koopa.app.actions.ShowASTAction;
import koopa.app.actions.ShowGrammarAction;
import koopa.app.components.detail.Detail;

public class SyntaxTreeMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private Application application;

	private JMenuItem showAST = null;
	private JMenuItem saveXML = null;
	private JMenuItem queryUsingXath = null;
	private JMenuItem showGrammar = null;

	public SyntaxTreeMenu(Application application) {
		super("Syntax tree");

		this.application = application;
		setupMenu();
	}

	private void setupMenu() {
		showGrammar = new JMenuItem(new ShowGrammarAction(application));
		// setAccelerators(showGrammar, MODIFIER + " G");
		add(showGrammar);

		addSeparator();

		showAST = new JMenuItem(new ShowASTAction(application));
		add(showAST);

		saveXML = new JMenuItem(new ExportASTToXMLAction(application));
		// setAccelerators(saveXML, MODIFIER + " E");
		add(saveXML);

		queryUsingXath = new JMenuItem(new QueryUsingXPathAction(application));
		setAccelerators(queryUsingXath, MODIFIER + " K");
		add(queryUsingXath);
	}

	public void update() {
		Component view = application.getView();

		if (view instanceof Detail) {
			Detail detail = (Detail) view;

			boolean hasSyntaxTree = detail.hasSyntaxTree();
			showAST.setEnabled(hasSyntaxTree);
			saveXML.setEnabled(hasSyntaxTree);
			queryUsingXath.setEnabled(hasSyntaxTree);

		} else {
			showAST.setEnabled(false);
			saveXML.setEnabled(false);
			queryUsingXath.setEnabled(false);
		}
	}
}
