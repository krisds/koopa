package koopa.app.actions;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import koopa.app.components.query.XPathQueryingDialog;
import koopa.util.Getter;

import org.antlr.runtime.tree.CommonTree;

@SuppressWarnings("serial")
public class QueryUsingXPathAction extends AbstractAction implements Action {
	private Getter<CommonTree> astGetter = null;
	private Frame parent = null;
	private FileManager manager = null;

	public QueryUsingXPathAction(Getter<CommonTree> astGetter, Frame parent,
			FileManager manager) {
		super("Query using XPath...");
		this.astGetter = astGetter;
		this.parent = parent;
		this.manager = manager;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new ThreadGroup("actions"), new Runnable() {
			public void run() {
				final XPathQueryingDialog dialog = XPathQueryingDialog
						.getDialog(parent, manager, astGetter);

				if (dialog != null) {
					dialog.setVisible(true);
				}

				// TODO What if we didn't get a dialog ?
			}
		}).start();
	}
}
