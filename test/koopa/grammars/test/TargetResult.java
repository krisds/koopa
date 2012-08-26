package koopa.grammars.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

import koopa.parsers.Metrics;
import koopa.parsers.ParseResults;

public class TargetResult {

	private String name = null;
	private boolean valid = false;
	private int tokenCount = 0;
	private float coverage = 0;
	private int errorCount = 0;
	// String errors = entries[5];
	private int warningCount = 0;

	// String warnings = entries[7];
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

	public List<String> getComparison(ParseResults result) {
		final List<String> messages = new ArrayList<String>();
		if (result.isValidInput() != this.valid) {
			if (this.valid) {
				messages.add("- This file used to parse. It no longer does.");
			} else {
				messages.add("+ This file used to fail parsing. It is now valid.");
			}
		}

		final int tokenCount = Metrics.getSignificantTokenCount(result);
		if (tokenCount != this.tokenCount) {
			// Positive case: when valid and count went up ?
			if (tokenCount < this.tokenCount) {
				messages.add("  Number of tokens went down from "
						+ this.tokenCount + " to " + tokenCount + ".");

			} else {
				messages.add("  Number of tokens went up from "
						+ this.tokenCount + " to " + tokenCount + ".");
			}
		}

		final float coverage = Metrics.getCoverage(result);
		if (coverage != this.coverage) {
			if (coverage < this.coverage) {
				messages.add("- Coverage went down from " + this.coverage
						+ " to " + coverage + ".");

			} else {
				messages.add("+ Coverage went up from " + this.coverage
						+ " to " + coverage + ".");
			}
		}

		if (result.getErrorCount() != this.errorCount) {
			if (result.getErrorCount() < this.errorCount) {
				messages.add("+ Error count went down from " + this.errorCount
						+ " to " + result.getErrorCount() + ".");

			} else {
				messages.add("- Error count went up from " + this.errorCount
						+ " to " + result.getErrorCount() + ".");
			}
		}

		// TODO Errors.

		if (result.getWarningCount() != this.warningCount) {
			if (result.getWarningCount() < this.warningCount) {
				messages.add("+ Warning count went down from "
						+ this.warningCount + " to " + result.getWarningCount()
						+ ".");

			} else {
				messages.add("- Warning count went up from "
						+ this.warningCount + " to " + result.getWarningCount()
						+ ".");
			}
		}

		// TODO Warnings.

		return messages;
	}

	public static Map<String, TargetResult> loadFromFile(File expectedFile)
			throws IOException {
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(expectedFile));
			String[] entries = null;

			// Header.
			if ((entries = reader.readNext()) == null) {
				return null;
			}

			final Map<String, TargetResult> targets = new HashMap<String, TargetResult>();

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

				TargetResult results = new TargetResult();
				results.setName(name);
				results.setValid("true".equalsIgnoreCase(valid));
				results.setTokenCount(Integer.parseInt(tokenCount));
				results.setCoverage(Float.parseFloat(coverage));
				results.setErrorCount(Integer.parseInt(errorCount));
				// TODO List of errors.
				results.setWarningCount(Integer.parseInt(warningCount));
				// TODO List of warnings.

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

}
