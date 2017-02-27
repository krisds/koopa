package koopa.cobol.parser.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import koopa.cobol.parser.Metrics;
import koopa.cobol.parser.ParseResults;
import koopa.cobol.sources.CopyInclude;
import koopa.cobol.sources.Replace;
import koopa.core.data.Token;
import koopa.core.parsers.Parse;
import koopa.core.trees.Tree;
import koopa.core.util.Tuple;

public class TestResult {

	/**
	 * Just a quick override, useful when working on the sources.
	 */
	private static final boolean TEST_TOKEN_COUNT = true;

	/**
	 * Just a quick override, useful when working on the sources.
	 */
	private static final boolean TEST_COVERAGE = true;

	private String name = null;
	private boolean valid = false;
	private int tokenCount = 0;
	private float coverage = 0;

	private int errorCount = 0;
	private List<Tuple<Token, String>> errors = null;

	private int warningCount = 0;
	private List<Tuple<Token, String>> warnings = null;

	private int preprocessedDirectivesCount = 0;

	public static TestResult from(ParseResults parseResults) {
		TestResult result = new TestResult();

		final Parse parse = parseResults.getParse();

		result.name = parseResults.getFile().getName();
		result.valid = parseResults.isValidInput();
		result.tokenCount = Metrics.getSignificantTokenCount(parseResults);
		result.coverage = Metrics.getCoverage(parseResults);
		result.errorCount = parse.getMessages().getErrorCount();
		result.warningCount = parse.getMessages().getWarningCount();

		result.errors = parse.getMessages().getErrors();
		result.warnings = parse.getMessages().getWarnings();

		final CopyInclude copyInclude = parse.getSource(CopyInclude.class);
		if (copyInclude != null) {
			final List<Tree> handledDirectives = copyInclude
					.getHandledDirectives();
			result.preprocessedDirectivesCount += handledDirectives.size();
		}

		final Replace replace = parse.getSource(Replace.class);
		if (replace != null) {
			final List<Tree> handledDirectives = replace.getHandledDirectives();
			result.preprocessedDirectivesCount += handledDirectives.size();
		}

		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public int getTokenCount() {
		return tokenCount;
	}

	public void setTokenCount(int tokenCount) {
		this.tokenCount = tokenCount;
	}

	public float getCoverage() {
		return coverage;
	}

	public void setCoverage(float coverage) {
		this.coverage = coverage;
	}

	public int getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}

	public int getWarningCount() {
		return warningCount;
	}

	public void setWarningCount(int warningCount) {
		this.warningCount = warningCount;
	}

	public int getPreprocessedDirectivesCount() {
		return preprocessedDirectivesCount;
	}

	public void setPreprocessedDirectivesCount(
			int preprocessedDirectivesCount) {
		this.preprocessedDirectivesCount = preprocessedDirectivesCount;
	}

	public List<String> getComparison(TestResult actual) {
		final List<String> messages = new ArrayList<String>();
		if (actual.valid != this.valid) {
			if (this.valid)
				messages.add("- This file used to parse. It no longer does.");
			else
				messages.add(
						"+ This file used to fail parsing. It is now valid.");
		}

		if (TEST_TOKEN_COUNT && actual.tokenCount != this.tokenCount) {
			// Positive case: when valid and count went up ?
			if (actual.tokenCount < this.tokenCount) {
				messages.add("  Number of tokens went down from "
						+ this.tokenCount + " to " + actual.tokenCount + ".");

			} else {
				messages.add("  Number of tokens went up from "
						+ this.tokenCount + " to " + actual.tokenCount + ".");
			}
		}

		if (TEST_COVERAGE && actual.coverage != this.coverage) {
			if (actual.coverage < this.coverage) {
				messages.add("- Coverage went down from " + this.coverage
						+ " to " + actual.coverage + ".");

			} else {
				messages.add("+ Coverage went up from " + this.coverage + " to "
						+ actual.coverage + ".");
			}
		}

		if (actual.errorCount != this.errorCount) {
			if (actual.errorCount < this.errorCount)
				messages.add("+ Error count went down from " + this.errorCount
						+ " to " + actual.errorCount + ".");
			else
				messages.add("- Error count went up from " + this.errorCount
						+ " to " + actual.errorCount + ".");
		}

		// TODO Errors.

		if (actual.warningCount != this.warningCount) {
			if (actual.warningCount < this.warningCount)
				messages.add(
						"+ Warning count went down from " + this.warningCount
								+ " to " + actual.warningCount + ".");

			else
				messages.add("- Warning count went up from " + this.warningCount
						+ " to " + actual.warningCount + ".");
		}

		// TODO Warnings.

		if (actual.preprocessedDirectivesCount != this.preprocessedDirectivesCount) {
			if (actual.preprocessedDirectivesCount < this.preprocessedDirectivesCount)
				messages.add("+ Preprocessed directives count went down from "
						+ this.preprocessedDirectivesCount + " to "
						+ actual.preprocessedDirectivesCount + ".");
			else
				messages.add("- Preprocessed directives count went up from "
						+ this.preprocessedDirectivesCount + " to "
						+ actual.preprocessedDirectivesCount + ".");
		}

		return messages;
	}

	public static Map<String, TestResult> loadFromFile(File expectedFile)
			throws IOException {
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(expectedFile));
			String[] entries = null;

			// Header.
			if ((entries = reader.readNext()) == null) {
				return null;
			}

			final Map<String, TestResult> targets = new HashMap<String, TestResult>();

			// Entries.
			while ((entries = reader.readNext()) != null) {
				final String name = entries[0];
				final String valid = entries[1];
				final String tokenCount = entries[2];
				final String coverage = entries[3];
				final String errorCount = entries[4];
				// final String errors = entries[5];
				final String warningCount = entries[6];
				// final String warnings = entries[7];
				final String preprocessedDirectivesCount = entries[8];

				TestResult results = new TestResult();
				results.setName(name);
				results.setValid("true".equalsIgnoreCase(valid));
				results.setTokenCount(Integer.parseInt(tokenCount));
				results.setCoverage(Float.parseFloat(coverage));
				results.setErrorCount(Integer.parseInt(errorCount));
				// TODO List of errors.
				results.setWarningCount(Integer.parseInt(warningCount));
				// TODO List of warnings.
				results.setPreprocessedDirectivesCount(
						Integer.parseInt(preprocessedDirectivesCount));

				targets.put(name, results);
			}

			return targets;

		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public static void saveToFile(Map<String, TestResult> results,
			File targetFile) throws IOException {

		final FileWriter fw = new FileWriter(targetFile);
		final BufferedWriter bw = new BufferedWriter(fw);
		final CSVWriter writer = new CSVWriter(bw);

		try {
			// Write out the header for the CSV.
			writeResultsHeader(writer);

			Set<String> keys = results.keySet();
			List<String> sortedKeys = new ArrayList<String>(keys);
			Collections.sort(sortedKeys);

			for (String key : sortedKeys)
				writeNextResult(writer, key, results.get(key));

		} finally {
			if (writer != null)
				writer.close();
		}
	}

	private static void writeResultsHeader(final CSVWriter writer)
			throws IOException {
		final String[] header = new String[] { "File", "Valid",
				"Number of tokens", "Coverage", "Number of errors", "Errors",
				"Number of warnings", "Warnings",
				"Number of preprocessed directives" };
		writer.writeNext(header);
		writer.flush();
	}

	private static void writeNextResult(CSVWriter writer, String name,
			TestResult results) throws IOException {
		final String[] entries = new String[9];

		String errors = "";
		for (Tuple<Token, String> error : results.errors) {
			if (errors.length() > 0)
				errors += "\n";

			errors += error.getFirst() + " " + error.getSecond();
		}

		String warnings = "";
		for (Tuple<Token, String> warning : results.warnings) {
			if (warnings.length() > 0)
				warnings += "\n";

			warnings += warning.getFirst() + " " + warning.getSecond();
		}

		entries[0] = name;
		entries[1] = "" + results.valid;
		entries[2] = "" + results.tokenCount;
		entries[3] = "" + results.coverage;
		entries[4] = "" + results.errorCount;
		entries[5] = "" + errors;
		entries[6] = "" + results.warningCount;
		entries[7] = "" + warnings;
		entries[8] = "" + results.preprocessedDirectivesCount;
		writer.writeNext(entries);
		writer.flush();
	}
}
