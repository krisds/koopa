package koopa.app.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import koopa.app.Application;
import koopa.app.components.query.XPathQueryingDialog;

@SuppressWarnings("serial")
public class QueryUsingXPathAction extends AbstractAction implements Action {
	private Application application = null;

	public QueryUsingXPathAction(Application application) {
		super("Find by XPath...");
		this.application = application;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		new Thread(() -> {
			final XPathQueryingDialog dialog = XPathQueryingDialog.getDialog(
					application.getFrame(), application);

			dialog.setVisible(true);
		}).start();
	}
}
