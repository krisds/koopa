package koopa.app.components.detailstable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListSelectionModel;

import koopa.app.batchit.ParseDetails;
import koopa.tokens.Token;
import koopa.util.Tuple;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.HighlighterFactory;

public class DetailsTable extends JXTable {

	private static final long serialVersionUID = 1L;

	private ParseDetails parseDetails;

	private List<DetailsTableListener> listeners = new ArrayList<DetailsTableListener>();

	public DetailsTable(ParseDetails parseDetails) {
		this.parseDetails = parseDetails;

		setup();
	}

	private void setup() {
		setBorder(null);
		setModel(parseDetails);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setHighlighters(HighlighterFactory.createSimpleStriping());

		getColumnModel().getColumn(0).setPreferredWidth(70);
		getColumnModel().getColumn(1).setPreferredWidth(40);
		getColumnModel().getColumn(2).setPreferredWidth(40);
		getColumnModel().getColumn(3).setPreferredWidth(150);
		getColumnModel().getColumn(4).setPreferredWidth(600);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = getSelectedRow();
					if (row < 0)
						return;
					Tuple<Token, String> detail = parseDetails.getDetails(row);
					fireUserSelectedDetail(detail);
				}
			}
		});
	}

	public void addListener(DetailsTableListener listener) {
		this.listeners.add(listener);
	}

	public void selectDetail(Tuple<Token, String> detail) {
		int index = parseDetails.getIndex(detail);
		if (index >= 0) {
			getSelectionModel().setSelectionInterval(index, index);
			fireUserSelectedDetail(detail);
		}
	}

	private void fireUserSelectedDetail(Tuple<Token, String> detail) {
		for (DetailsTableListener listener : listeners) {
			listener.userSelectedDetail(detail);
		}
	}
}
