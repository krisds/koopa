package koopa.app.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import koopa.app.Application;
import koopa.app.components.detail.Detail;
import koopa.app.listeners.TokenSelectionListener;
import koopa.core.data.Token;
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
				final Detail detail = (Detail) application.getView();
				final String filename = detail.getFile().getName();
				final TreeFrame treeFrame = new TreeFrame(filename + " - AST",
						tree);

				final TokenSelectionListener tokenSelectionListener = new TokenSelectionListener() {
					public void selectedToken(Token token) {
						treeFrame.select(token);
					}
				};

				detail.addTokenSelectionListener(tokenSelectionListener);

				treeFrame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						detail.removeTokenSelectionListener(tokenSelectionListener);
					}
				});

				treeFrame.setVisible(true);
			}
		});
	}
}
