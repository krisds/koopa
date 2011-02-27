package koopa.app.batchit;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

@SuppressWarnings("serial")
public class ClearResultsAction extends AbstractAction implements Action {

	private BatchIt batchIt = null;

	public ClearResultsAction(BatchIt provider) {
		super("Clear all results...");
		this.batchIt = provider;
	}

	public void actionPerformed(ActionEvent ae) {
		// TODO Run in separate thread ?
		this.batchIt.clearResults();
	}
}
