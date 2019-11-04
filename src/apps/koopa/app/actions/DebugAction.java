package koopa.app.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;

import koopa.app.Application;
import koopa.app.components.detail.Detail;
import koopa.app.components.overview.Overview;
import koopa.app.debug.Debug;

public class DebugAction extends AbstractAction implements Action {

	private static final long serialVersionUID = 1L;

	private Application application = null;

	public DebugAction(Application application) {
		super("Debug");
		this.application = application;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		new Thread(() -> {
			Overview overview = application.getOverview();
			Component view = application.getView();

			if (view == overview)
				return;

			if (view instanceof Debug) {
				((Debug) view).reload();

			} else if (view instanceof Detail) {
				Detail detail = (Detail) view;
				File file = detail.getFile();
				Debug debug = new Debug(application, file,
						detail.getCobolParserFactory());
				application.swapView(detail, debug);
			}
		}).start();
	}
}
