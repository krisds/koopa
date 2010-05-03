package koopa.app.components.query;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import koopa.tokens.Token;
import koopa.tokenstreams.Marker;
import koopa.trees.antlr.CommonKoopaToken;
import koopa.trees.antlr.jaxen.ANTLRTreeAttribute;

import org.antlr.runtime.tree.CommonTree;

@SuppressWarnings("serial")
public class XPathResults extends AbstractTableModel {

	public static final int TYPE_COLUMN = 0;
	public static final int TEXT_COLUMN = 1;

	private List<?> results = null;

	public int getColumnCount() {
		return 2;
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case TYPE_COLUMN:
			return "Type";

		case TEXT_COLUMN:
			return "Text";

		default:
			return "????";
		}
	}

	public int getRowCount() {
		return results == null ? 0 : results.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case TYPE_COLUMN: {
			final Object value = results.get(rowIndex);
			if (value instanceof CommonTree) {
				final CommonTree tree = (CommonTree) value;
				final Token token = ((CommonKoopaToken) tree.getToken())
						.getKoopaToken();

				if (token instanceof Marker) {
					return XPathResultType.NODE;

				} else {
					return XPathResultType.TOKEN;
				}

			} else if (value instanceof ANTLRTreeAttribute) {
				return XPathResultType.ATTRIBUTE;

			} else {
				return XPathResultType.OTHER;
			}
		}

		case TEXT_COLUMN:
			return results.get(rowIndex).toString();

		default:
			return true;
		}
	}

	public void setResults(List<?> results) {
		this.results = results;

		fireTableDataChanged();
	}
}
