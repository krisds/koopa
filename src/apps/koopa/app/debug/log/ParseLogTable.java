package koopa.app.debug.log;

import static koopa.app.debug.log.ParseLogTableModel.KIND_COLUMN;
import static koopa.app.debug.log.ParseLogTableModel.MESSAGE_COLUMN;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.ListSelectionModel;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.HighlighterFactory;

// TODO Can has tree table ?
public class ParseLogTable extends JXTable {

	private static final long serialVersionUID = 1L;

	private ParseLogTableModel model;
	private Set<SelectionListener> listeners = new LinkedHashSet<>();

	public ParseLogTable(ParseLogTableModel model) {
		this.model = model;

		setup();
	}

	private void setup() {
		setBorder(null);
		setModel(model);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setHighlighters(HighlighterFactory.createSimpleStriping());

		getColumnModel().getColumn(KIND_COLUMN).setPreferredWidth(50);
		getColumnModel().getColumn(MESSAGE_COLUMN).setPreferredWidth(950);

		getSelectionModel()
				.addListSelectionListener(e -> {
					if (e.getValueIsAdjusting())
						return;

					int row = getSelectedRow();
					if (row < 0)
						return;

					for (SelectionListener listener : listeners)
						listener.selectionChanged(row);
				});
	}

	public void close() {
		model = null;
	}

	public void addSelectionListener(SelectionListener listener) {
		listeners.add(listener);
	}

	public interface SelectionListener {
		void selectionChanged(int index);
	}
}
