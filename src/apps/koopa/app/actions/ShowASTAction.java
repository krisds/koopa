package koopa.app.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import koopa.app.Application;
import koopa.app.components.detail.Detail;
import koopa.core.trees.Tree;
import koopa.core.trees.ui.TreeFrame;

public class ShowASTAction extends AbstractAction implements Action {

	private static final long serialVersionUID = 1L;

	private Application application = null;

	public ShowASTAction(Application application, Component parent) {
		super("Show AST...");
		this.application = application;
	}

	public void actionPerformed(ActionEvent ae) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final Tree tree = application.getSyntaxTree();
				String filename = ((Detail) application.getView()).getFile()
						.getName();
				new TreeFrame(filename + " - AST", tree).setVisible(true);
			}
		});
	}
}
