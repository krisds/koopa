package koopa.app.components.query;

import static java.util.Collections.EMPTY_LIST;
import static koopa.app.components.query.XPathResultType.ATTRIBUTE;
import static koopa.app.components.query.XPathResultType.NODE;
import static koopa.app.components.query.XPathResultType.OTHER;
import static koopa.app.components.query.XPathResultType.TOKEN;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.trees.Tree;
import koopa.core.trees.jaxen.TreeAttribute;

@SuppressWarnings("serial")
public class XPathResults extends AbstractTableModel {

	public static final int TYPE_COLUMN = 0;
	public static final int TEXT_COLUMN = 1;
	public static final int LINE_COLUMN = 2;
	public static final int COLUMN_COLUMN = 3;
	public static final int RESOURCE_COLUMN = 4;

	private List<?> results = null;
	private List<XPathResultType> types = null;
	private List<Token> startTokens = null;

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case TYPE_COLUMN:
			return "Type";

		case TEXT_COLUMN:
			return "Text";

		case LINE_COLUMN:
			return "Line";

		case COLUMN_COLUMN:
			return "Column";

		case RESOURCE_COLUMN:
			return "Resource";

		default:
			return "????";
		}
	}

	@Override
	public int getRowCount() {
		return results == null ? 0 : results.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case TYPE_COLUMN:
			return types.get(rowIndex);

		case TEXT_COLUMN:
			return results.get(rowIndex).toString();

		case LINE_COLUMN: {
			final Position position = startTokens.get(rowIndex).getStart();
			return position != null ? position.getLinenumber() : null;
		}

		case COLUMN_COLUMN: {
			final Position position = startTokens.get(rowIndex).getStart();
			return position != null ? position.getPositionInLine() : null;
		}

		case RESOURCE_COLUMN: {
			final Position position = startTokens.get(rowIndex).getStart();
			return position.getResourceName();
		}

		default:
			return true;
		}
	}

	public void setResults(List<?> results) {
		this.results = results;

		if (results == null)
			results = EMPTY_LIST;

		types = new ArrayList<>(results.size());
		startTokens = new ArrayList<>(results.size());

		for (Object value : results) {
			if (value instanceof Tree) {
				final Tree tree = (Tree) value;
				final Data token = tree.getData();

				if (token instanceof Marker)
					types.add(NODE);
				else
					types.add(TOKEN);

				startTokens.add(tree.getStartToken());

			} else if (value instanceof TreeAttribute) {
				types.add(ATTRIBUTE);
				startTokens.add(null);

			} else {
				types.add(OTHER);
				startTokens.add(null);
			}
		}

		fireTableDataChanged();
	}

	public List<?> getResults() {
		return results;
	}

	public Token getToken(int row) {
		if (row < startTokens.size())
			return startTokens.get(row);
		else
			return null;
	}
}
