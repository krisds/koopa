package koopa.app.batchit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import koopa.app.parsers.Metrics;
import koopa.app.parsers.ParseResults;

@SuppressWarnings("serial")
public class BatchResults extends AbstractTableModel {

	public static final int STATUS_COLUMN = 0;
	public static final int ERRORS_COLUMN = 1;
	public static final int WARNINGS_COLUMN = 2;
	public static final int COVERAGE_COLUMN = 3;
	public static final int FILE_COLUMN = 4;
	public static final int PATH_COLUMN = 5;

	private List<File> files = new ArrayList<File>();
	private List<ParseResults> parseResults = new ArrayList<ParseResults>();
	private List<Float> coverage = new ArrayList<Float>();

	public enum Status {
		OK, WARNING, ERROR
	}

	public int getColumnCount() {
		return 6;
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

		case COVERAGE_COLUMN:
			return "Coverage";

		default:
			return "????";
		}
	}

	public int getRowCount() {
		return this.files.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case STATUS_COLUMN: {
			ParseResults results = this.parseResults.get(rowIndex);
			if (!results.isValidInput() || results.getErrorCount() > 0) {
				return Status.ERROR;

			} else if (results.getWarningCount() > 0) {
				return Status.WARNING;

			} else {
				return Status.OK;
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

		case COVERAGE_COLUMN:
			return this.coverage.get(rowIndex);

		default:
			return true;
		}
	}

	public void add(ParseResults results) {
		File file = results.getFile();

		int index = this.files.indexOf(file);

		if (index >= 0) {
			this.parseResults.set(index, results);
			this.coverage.set(index, Metrics.getCoverage(results));
			fireTableRowsUpdated(index, index);

		} else {

			this.files.add(file);
			this.parseResults.add(results);
			this.coverage.add(Metrics.getCoverage(results));

			index = files.size() - 1;
			fireTableRowsInserted(index, index);
		}

		// TODO Nicer way to do the following ?
		// Clear these as they can take up a lot of memory, and are not needed
		// here anymore.
		results.clearTree();
		results.clearTokens();
	}

	public ParseResults getResults(int i) {
		return this.parseResults.get(i);
	}
}
