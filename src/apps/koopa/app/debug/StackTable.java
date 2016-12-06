package koopa.app.debug;

import javax.swing.ListSelectionModel;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.HighlighterFactory;

public class StackTable extends JXTable {

	private static final long serialVersionUID = 1L;

	private StackTableModel model;

	public StackTable(StackTableModel model) {
		this.model = model;

		setup();
	}

	private void setup() {
		setBorder(null);
		setModel(model);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setHighlighters(HighlighterFactory.createSimpleStriping());

		// getColumnModel().getColumn(0).setPreferredWidth(70);
	}

	public void close() {
		model = null;
	}
}
