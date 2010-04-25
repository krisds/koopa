package koopa.app.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;

import koopa.app.ApplicationSupport;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class PickAndParseAction extends AbstractAction implements Action {

	private static final Logger LOGGER = Logger
			.getLogger("action.pick_and_parse");

	private ParsingProvider provider = null;
	private Component parent = null;

	public PickAndParseAction(ParsingProvider provider, Component parent) {
		super("Pick and parse...");
		this.provider = provider;
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new ThreadGroup("actions"), new Runnable() {
			public void run() {
				final File file = ApplicationSupport.askUserForFile(true,
						"last-folder", null, parent);

				if (file != null) {
					final long start = System.currentTimeMillis();
					PickAndParseAction.this.provider.walkAndParse(file);
					final long end = System.currentTimeMillis();
					LOGGER.debug("Time to parse all: " + (end - start) + "ms.");
				}
			}
		}).start();
	}
}
