package koopa.app.batchit;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import koopa.app.ApplicationSupport;
import koopa.cobol.parser.Metrics;
import koopa.cobol.parser.ParseResults;
import koopa.core.parsers.Parse;
import koopa.core.targets.TokenTracker;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;
import koopa.core.trees.jaxen.Jaxen;
import koopa.core.trees.jaxen.XPathException;

@SuppressWarnings("serial")
public class BatchResults extends AbstractTableModel {
	public static final int STATUS_COLUMN = 0;
	public static final int ERRORS_COLUMN = 1;
	public static final int WARNINGS_COLUMN = 2;
	public static final int TOKEN_COUNT_COLUMN = 3;
	public static final int COVERAGE_COLUMN = 4;

	public static final int LINES_COLUMN = 5;
	public static final int CODE_COLUMN = 6;
	public static final int COMMENTS_COLUMN = 7;

	public static final int FILE_COLUMN = 8;
	public static final int PATH_COLUMN = 9;
	public static final int TIME_COLUMN = 10;
	public static final int CUSTOM_COLUMNS = 11;

	private static List<String> customKeys;

	private List<File> files = new ArrayList<>();
	private List<ParseResults> parseResults = new ArrayList<>();
	private List<Integer> tokenCount = new ArrayList<>();
	private List<Float> coverage = new ArrayList<>();
	private HashMap<String, ArrayList<Object>> custom = new HashMap<>();

	public enum Status {
		OK, WARNING, ERROR
	}

	public BatchResults() {
		super();

		customKeys = ApplicationSupport.getCustomColumnKeys();

		// Create value lists:
		for (String key : customKeys)
			custom.put(key, new ArrayList<>());
	}

	@Override
	public int getColumnCount() {
		return CUSTOM_COLUMNS + customKeys.size();
	}

	@Override
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

		case TOKEN_COUNT_COLUMN:
			return "Tokens";

		case LINES_COLUMN:
			return "LOC";

		case CODE_COLUMN:
			return "SLOC";

		case COMMENTS_COLUMN:
			return "CLOC";

		case TIME_COLUMN:
			return "Time (ms)";

		default:
			// Return titles for custom columns:
			int customColumnIndex = columnIndex - CUSTOM_COLUMNS;

			if (customColumnIndex < customKeys.size()) {
				String key = customKeys.get(customColumnIndex);
				return ApplicationSupport.getCustomColumnProperty(key, "title");
			}

			return "<Unknown>";
		}
	}

	@Override
	public int getRowCount() {
		return files.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case STATUS_COLUMN: {
			final ParseResults results = parseResults.get(rowIndex);
			final Parse parse = results.getParse();

			if (!results.isValidInput() || parse.getMessages().hasErrors())
				return Status.ERROR;
			else if (parse.getMessages().hasWarnings())
				return Status.WARNING;
			else
				return Status.OK;
		}

		case FILE_COLUMN:
			return files.get(rowIndex).getName();

		case PATH_COLUMN:
			return files.get(rowIndex).getParent();

		case WARNINGS_COLUMN:
			return parseResults.get(rowIndex).getParse().getMessages()
					.getWarningCount();

		case ERRORS_COLUMN:
			return parseResults.get(rowIndex).getParse().getMessages()
					.getErrorCount();

		case COVERAGE_COLUMN:
			return coverage.get(rowIndex);

		case TOKEN_COUNT_COLUMN:
			return tokenCount.get(rowIndex);

		case LINES_COLUMN:
			return parseResults.get(rowIndex).getNumberOfLines();

		case CODE_COLUMN:
			return parseResults.get(rowIndex).getNumberOfLinesWithCode();

		case COMMENTS_COLUMN:
			return parseResults.get(rowIndex).getNumberOfLinesWithComments();
		
		case TIME_COLUMN:
			return parseResults.get(rowIndex).getTime();

		default:
			// Get values from each custom report column key:

			int customColumnIndex = columnIndex - CUSTOM_COLUMNS;

			if (customColumnIndex < customKeys.size()) {
				String key = customKeys.get(customColumnIndex);
				if (rowIndex < custom.get(key).size())
					return custom.get(key).get(rowIndex);
			}

			return false;
		}
	}

	private void add(ParseResults results, String customColumnKey, int index) {
		String customXPathQuery = ApplicationSupport
				.getCustomColumnProperty(customColumnKey, "xpath", null);

		Object value = null;

		if (customXPathQuery != null) {
			try {
				final KoopaTreeBuilder treeBuilder = results.getParse()
						.getTarget(KoopaTreeBuilder.class);
				final Tree tree = treeBuilder.getTree();
				List<?> matches = Jaxen.evaluate(tree, customXPathQuery);

				if (matches == null)
					value = null;
				else if (matches.size() > 1)
					value = matches.toString();
				else if (matches.size() == 1)
					value = matches.get(0).toString();

			} catch (NullPointerException e) {
				e.printStackTrace();
				value = e.getMessage();
			} catch (XPathException e) {
				e.printStackTrace();
				value = e.getMessage();
			}
		}

		if (index >= 0)
			custom.get(customColumnKey).set(index, value);
		else
			custom.get(customColumnKey).add(value);
	}

	public void add(ParseResults results) {
		final File file = results.getFile();

		int index = files.indexOf(file);

		if (index >= 0) {
			parseResults.set(index, results);
			coverage.set(index, Metrics.getCoverage(results));
			tokenCount.set(index, Metrics.getSignificantTokenCount(results));

			for (String key : customKeys)
				add(results, key, index);

			fireTableRowsUpdated(index, index);

		} else {
			files.add(file);
			parseResults.add(results);
			coverage.add(Metrics.getCoverage(results));
			tokenCount.add(Metrics.getSignificantTokenCount(results));

			for (String key : customKeys)
				add(results, key, index);

			index = files.size() - 1;
			fireTableRowsInserted(index, index);
		}

		// TODO Nicer way to do the following ?
		// Clear these as they can take up a lot of memory, and are not needed
		// here anymore.
		results.getParse().getFlow().removeTarget(KoopaTreeBuilder.class);
		results.getParse().getFlow().removeTarget(TokenTracker.class);
	}

	public ParseResults getResults(int i) {
		return parseResults.get(i);
	}

	public void clear() {
		files.clear();
		parseResults.clear();
		tokenCount.clear();
		coverage.clear();

		// Clear custom column values:
		for (String key : customKeys)
			custom.get(key).clear();

		fireTableDataChanged();
	}
}
