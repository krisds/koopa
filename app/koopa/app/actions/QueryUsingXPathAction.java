package koopa.app.actions;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import koopa.app.Application;
import koopa.app.components.query.XPathQueryingDialog;

@SuppressWarnings("serial")
public class QueryUsingXPathAction extends AbstractAction implements Action {
	private Frame parent = null;
	private Application application = null;

	public QueryUsingXPathAction(Frame parent, Application application) {
		super("Query using XPath...");
		this.parent = parent;
		this.application = application;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new Runnable() {
			public void run() {
				final XPathQueryingDialog dialog = XPathQueryingDialog
						.getDialog(parent, application);

				dialog.setVisible(true);
			}
		}).start();
	}
}
