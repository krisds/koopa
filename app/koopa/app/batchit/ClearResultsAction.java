package koopa.app.batchit;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import koopa.app.actions.ParsingProvider;

@SuppressWarnings("serial")
public class ClearResultsAction extends AbstractAction implements Action {

	private ParsingProvider provider = null;

	public ClearResultsAction(ParsingProvider provider) {
		super("Clear all results...");
		this.provider = provider;
	}

	public void actionPerformed(ActionEvent ae) {
		// TODO Run in separate thread ?
		this.provider.clearResults();
	}
}
