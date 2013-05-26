package koopa.app.batchit;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import koopa.app.Icons;
import koopa.parsers.ParseResults;
import koopa.tokens.Position;
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
		if (parseResults == null) {
			return 0;
		}

		return parseResults.getErrorCount() + parseResults.getWarningCount();
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
			if (rowIndex < parseResults.getErrorCount()) {
				return ERROR;
			} else {
				return WARNING;
			}
		}

		case MESSAGE_COLUMN:
			return getDetails(rowIndex).getSecond();

		case TOKEN_COLUMN:
			return getDetails(rowIndex).getFirst().getText();

		case LINE_COLUMN:
			try {
				return getDetails(rowIndex).getFirst().getStart()
						.getLinenumber();

			} catch (NullPointerException e) {
				return "-";
			}

		case CHAR_COLUMN:
			try {
				return getDetails(rowIndex).getFirst().getStart()
						.getPositionInLine();

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

	public Tuple<Token, String> getDetails(int i) {
		if (i < parseResults.getErrorCount()) {
			return parseResults.getError(i);

		} else {
			return parseResults.getWarning(i - parseResults.getErrorCount());
		}
	}

	public int getIndex(Tuple<Token, String> detail) {
		final Position end = detail.getFirst().getEnd();
		final Position start = detail.getFirst().getStart();

		for (int i = 0; i < parseResults.getErrorCount(); i++) {
			final Tuple<Token, String> error = parseResults.getError(i);
			if (error.getFirst().getStart().equals(start)
					&& error.getFirst().getEnd().equals(end))
				return i;
		}

		for (int i = 0; i < parseResults.getWarningCount(); i++) {
			final Tuple<Token, String> warning = parseResults.getWarning(i);
			if (warning.getFirst().getStart().equals(start)
					&& warning.getFirst().getEnd().equals(end))
				return i + parseResults.getErrorCount();
		}

		return -1;
	}
}
