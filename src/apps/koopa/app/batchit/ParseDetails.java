package koopa.app.batchit;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import koopa.app.Icons;
import koopa.cobol.parser.ParseResults;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.parsers.Messages;
import koopa.core.util.Files;
import koopa.core.util.Tuple;

@SuppressWarnings("serial")
public class ParseDetails extends AbstractTableModel {

	private static final int STATUS_COLUMN = 0;
	private static final int LINE_COLUMN = 1;
	private static final int CHAR_COLUMN = 2;
	private static final int TOKEN_COLUMN = 3;
	private static final int MESSAGE_COLUMN = 4;
	private static final int RESOURCE_COLUMN = 5;

	private ParseResults parseResults = null;

	final static ImageIcon ERROR = Icons
			.getIcon("/koopa/app/resources/splashy/remove.png");

	final static ImageIcon WARNING = Icons
			.getIcon("/koopa/app/resources/splashy/warning_triangle.png");

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
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

		case RESOURCE_COLUMN:
			return "Resource";

		default:
			return "????";
		}
	}

	@Override
	public int getRowCount() {
		if (parseResults == null)
			return 0;

		final Messages messages = parseResults.getParse().getMessages();
		return messages.getErrorCount() + messages.getWarningCount();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case STATUS_COLUMN:
			return ImageIcon.class;

		default:
			return super.getColumnClass(columnIndex);
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		final Token token = getDetails(rowIndex).getFirst();
		switch (columnIndex) {
		case STATUS_COLUMN: {
			if (rowIndex < parseResults.getParse().getMessages()
					.getErrorCount())
				return ERROR;
			else
				return WARNING;
		}

		case MESSAGE_COLUMN:
			return getDetails(rowIndex).getSecond();

		case TOKEN_COLUMN:
			return token != null ? token.getText() : "";

		case LINE_COLUMN:
			try {
				return token != null ? token.getStart()
						.getLinenumber() : "-";

			} catch (NullPointerException e) {
				return "-";
			}

		case CHAR_COLUMN:
			try {
				return token != null ? token.getStart()
						.getPositionInLine() : "-";

			} catch (NullPointerException e) {
				return "-";
			}

		case RESOURCE_COLUMN:
			try {
				return token != null ? Files.getFilename(token
						.getStart().getResourceName()) : "-";

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
		final Messages messages = parseResults.getParse().getMessages();
		final int errorCount = messages.getErrorCount();

		if (i < errorCount)
			return messages.getError(i);
		else
			return messages.getWarning(i - errorCount);
	}

	public int getIndex(Tuple<Token, String> detail) {
		final Position end = detail.getFirst().getEnd();
		final Position start = detail.getFirst().getStart();
		final Messages messages = parseResults.getParse().getMessages();
		final int errorCount = messages.getErrorCount();

		for (int i = 0; i < errorCount; i++) {
			final Tuple<Token, String> error = messages.getError(i);
			if (error.getFirst().getStart().equals(start)
					&& error.getFirst().getEnd().equals(end))
				return i;
		}

		for (int i = 0; i < messages.getWarningCount(); i++) {
			final Tuple<Token, String> warning = messages.getWarning(i);
			if (warning.getFirst().getStart().equals(start)
					&& warning.getFirst().getEnd().equals(end))
				return i + errorCount;
		}

		return -1;
	}
}
