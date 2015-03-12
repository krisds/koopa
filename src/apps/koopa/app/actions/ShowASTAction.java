package koopa.app.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import koopa.app.Application;
import koopa.app.components.astview.ASTFrame;
import koopa.app.components.detail.Detail;
import koopa.core.treeparsers.Tree;

public class ShowASTAction extends AbstractAction implements Action {

	private static final long serialVersionUID = 1L;

	private Component parent = null;
	private Application application = null;

	public ShowASTAction(Application application, Component parent) {
		super("Show AST...");
		this.application = application;
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent ae) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				final Tree tree = application.getSyntaxTree();
				String filename = ((Detail) application.getView()).getFile()
						.getName();
				new ASTFrame(filename + " - AST", tree).setVisible(true);
			}
		});
	}
}
