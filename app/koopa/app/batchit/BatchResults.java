package koopa.app.batchit;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import koopa.app.Icons;
import koopa.app.parsers.ParseResults;

@SuppressWarnings("serial")
public class BatchResults extends AbstractTableModel {

	private static final int STATUS_COLUMN = 0;
	private static final int ERRORS_COLUMN = 1;
	private static final int WARNINGS_COLUMN = 2;
	private static final int FILE_COLUMN = 3;
	private static final int PATH_COLUMN = 4;

	private List<File> files = new ArrayList<File>();
	private List<ParseResults> parseResults = new ArrayList<ParseResults>();

	final static ImageIcon OK = Icons
			.getIcon("/koopa/app/resources/document_a4_okay.png");

	final static ImageIcon ERROR = Icons
			.getIcon("/koopa/app/resources/document_a4_remove.png");

	final static ImageIcon WARNING = Icons
			.getIcon("/koopa/app/resources/document_a4_warning.png");

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case STATUS_COLUMN:
			return "Status";

		case FILE_COLUMN:
			return "File";

		case PATH_COLUMN:
			return "Path";

		case WARNINGS_COLUMN:
			return "Warnings";

		case ERRORS_COLUMN:
			return "Errors";

		default:
			return "????";
		}
	}

	public int getRowCount() {
		return this.files.size();
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
			ParseResults results = this.parseResults.get(rowIndex);
			if (!results.isValidInput() || results.getErrorCount() > 0) {
				return ERROR;
			} else if (results.getWarningCount() > 0) {
				return WARNING;
			} else {
				return OK;
			}
		}
		case FILE_COLUMN:
			return this.files.get(rowIndex).getName();

		case PATH_COLUMN:
			return this.files.get(rowIndex).getParent();

		case WARNINGS_COLUMN:
			return this.parseResults.get(rowIndex).getWarningCount();

		case ERRORS_COLUMN:
			return this.parseResults.get(rowIndex).getErrorCount();

		default:
			return true;
		}
	}

	public void add(ParseResults results) {
		File file = results.getFile();

		int index = this.files.indexOf(file);

		if (index >= 0) {
			this.parseResults.set(index, results);
			fireTableRowsUpdated(index, index);

		} else {

			this.files.add(file);
			this.parseResults.add(results);

			index = files.size() - 1;
			fireTableRowsInserted(index, index);
		}
	}

	public ParseResults getResults(int i) {
		return this.parseResults.get(i);
	}
}
