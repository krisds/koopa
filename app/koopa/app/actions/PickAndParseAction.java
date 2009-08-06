package koopa.app.actions;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;

import koopa.app.ApplicationSupport;

@SuppressWarnings("serial")
public class PickAndParseAction extends AbstractAction implements Action {
	private ParsingProvider provider = null;
	private Component parent = null;

	public PickAndParseAction(ParsingProvider provider, Component parent) {
		super("Pick and parse...");
		this.provider = provider;
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new ThreadGroup("parsing"), new Runnable() {

			public void run() {
				File file = ApplicationSupport.askUserForFile("last-folder",
						null, parent);

				if (file != null) {
					PickAndParseAction.this.provider.walkAndParse(file);
				}
			}
		}).start();
	}
}
