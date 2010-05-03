package koopa.app.batchit;


import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import koopa.app.Icons;
import koopa.app.parsers.ParseResults;
import koopa.tokens.Token;
import koopa.util.Tuple;

@SuppressWarnings("serial")
public class ParseDetails extends AbstractTableModel {

	private static final int STATUS_COLUMN = 0;
	private static final int LINE_COLUMN = 1;
	private static final int CHAR_COLUMN = 2;
	private static final int TOKEN_COLUMN = 3;
	private static final int MESSAGE_COLUMN = 4;

	private ParseResults parseResults = null;

	final static ImageIcon ERROR = Icons
			.getIcon("/koopa/app/resources/splashy/remove.png");

	final static ImageIcon WARNING = Icons
			.getIcon("/koopa/app/resources/splashy/warning_triangle.png");

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case STATUS_COLUMN:
			return "Status";

		case MESSAGE_COLUMN:
			return "Message";

		case TOKEN_COLUMN:
			return "Token";

		case LINE_COLUMN:
			return "Line";

		case CHAR_COLUMN:
			return "Char";

		default:
			return "????";
		}
	}

	public int getRowCount() {
		if (this.parseResults == null) {
			return 0;
		}

		return this.parseResults.getErrorCount()
				+ this.parseResults.getWarningCount();
	}

	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case STATUS_COLUMN:
			return ImageIcon.class;

		default:
			return super.getColumnClass(columnIndex);
		}
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case STATUS_COLUMN: {
			if (rowIndex < this.parseResults.getErrorCount()) {
				return ERROR;
			} else {
				return WARNING;
			}
		}

		case MESSAGE_COLUMN:
			return get(rowIndex).getSecond();

		case TOKEN_COLUMN:
			return get(rowIndex).getFirst().getText();

		case LINE_COLUMN:
			try {
				return get(rowIndex).getFirst().getStart().getLinenumber();

			} catch (NullPointerException e) {
				return "-";
			}

		case CHAR_COLUMN:
			try {
				return get(rowIndex).getFirst().getStart().getPositionInLine();

			} catch (NullPointerException e) {
				return "-";
			}

		default:
			return true;
		}
	}

	public void setParseResults(ParseResults parseResults) {
		this.parseResults = parseResults;
		fireTableDataChanged();
	}

	private Tuple<Token, String> get(int i) {
		if (i < this.parseResults.getErrorCount()) {
			return this.parseResults.getError(i);

		} else {
			return this.parseResults.getWarning(i
					- this.parseResults.getErrorCount());
		}
	}
}
