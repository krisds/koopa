package koopa.grammars.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import koopa.parsers.Metrics;
import koopa.parsers.ParseResults;
import koopa.parsers.cobol.ParsingCoordinator;
import koopa.tokens.Token;
import koopa.util.Tuple;
import au.com.bytecode.opencsv.CSVWriter;

// TODO Reduce this to a class which generates a results file.
// The actual regression test is now in Cobol85RegressionTest.
public class RegressionTest {

	private static ParsingCoordinator coordinator = null;

	public static void main(String[] args) throws IOException {
		// Logger.getLogger("parser").setLevel(Level.TRACE);

		if (args.length != 3) {
			System.err
					.println("Please pass the right paramaters: target-csv results-csv target-folder");
			System.exit(-1);
		}

		final File targetFile = new File(args[0]);
		final File resultsFile = new File(args[1]);
		final File folder = new File(args[2]);

		// TODO Accept from command line ?
		final boolean verbose = false;

		// --------------------------------------------------------------------
		// Load in previous results.

		final Map<String, TargetResult> targetResults;
		if (!targetFile.exists()) {
			System.out
					.println("No prior test results. Will be gathering results only, not comparing them.");
			targetResults = null;

		} else {
			targetResults = TargetResult.loadFromFile(targetFile);
			if (verbose) {
				System.out.println("Loaded " + targetResults.size()
						+ " targets for this regression test.");
			}
		}

		// --------------------------------------------------------------------
		// Look for test files.

		final List<File> subjects = new LinkedList<File>();
		collectSubjects(folder, subjects);
		if (verbose) {
			System.out.println("Found " + subjects.size()
					+ " subjects for testing.");
		}

		// --------------------------------------------------------------------
		// Run the test.

		boolean sawRegressions = false;

		coordinator = new ParsingCoordinator();
		coordinator.setKeepingTrackOfTokens(true);

		final FileWriter fw = new FileWriter(resultsFile);
		final BufferedWriter bw = new BufferedWriter(fw);
		final CSVWriter writer = new CSVWriter(bw);

		try {
			// Write out the header for the CSV.
			writeResultsHeader(writer);

			// Iterate over all test files...
			for (final File subject : subjects) {
				try {
					boolean nameReported = false;

					if (verbose) {
						System.out.println(subject.getName());
						nameReported = true;
					}

					// Parse the file...
					final ParseResults result = coordinator.parse(subject);

					// Write out the results...
					writeNextResult(writer, subject, result);

					// Regression testing...
					if (targetResults != null) {
						final TargetResult target = targetResults.get(subject
								.getName());

						if (target == null) {
							// This is a new file...
							if (!nameReported) {
								System.out.println(subject.getName());
								nameReported = true;
							}

							System.out
									.println("  This was a previously unknown file.");
							sawRegressions = true;

						} else {
							// We have previous test results, which we'll now
							// compare...
							final List<String> messages = target
									.getComparison(result);

							if (messages != null && messages.size() > 0) {
								if (!nameReported) {
									System.out.println(subject.getName());
									nameReported = true;
								}

								for (String message : messages) {
									System.out.println(message);
								}

								sawRegressions = true;
							}

							// Removing this target from the list.
							targetResults.remove(subject.getName());
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
					// TODO Exit ?
				}
			}

		} finally {
			writer.close();
		}

		// Write out any file mentioned in the original test report which we
		// didn't find in the new run.
		if (!targetResults.isEmpty()) {
			for (String target : targetResults.keySet()) {
				System.out.println(target);
				System.out.println("- File not found.");
			}
			sawRegressions = true;
		}

		System.exit(sawRegressions ? 1 : 0);
	}

	private static void writeResultsHeader(final CSVWriter writer)
			throws IOException {
		final String[] header = new String[] { "File", "Valid",
				"Number of tokens", "Coverage", "Number of errors", "Errors",
				"Number of warnings", "Warnings" };
		writer.writeNext(header);
		writer.flush();
	}

	private static void writeNextResult(CSVWriter writer, File target,
			ParseResults results) throws IOException {
		final String[] entries = new String[8];
		final boolean valid = results.isValidInput();
		final float coverage = Metrics.getCoverage(results);
		final int tokenCount = Metrics.getSignificantTokenCount(results);

		final int errorCount = results.getErrorCount();
		String errors = "";
		for (int i = 0; i < errorCount; i++) {
			if (i > 0) {
				errors += "\n";
			}
			final Tuple<Token, String> error = results.getError(i);
			errors += error.getFirst() + " " + error.getSecond();
		}

		final int warningCount = results.getWarningCount();
		String warnings = "";
		for (int i = 0; i < warningCount; i++) {
			if (i > 0) {
				warnings += "\n";
			}
			final Tuple<Token, String> warning = results.getWarning(i);
			warnings += warning.getFirst() + " " + warning.getSecond();
		}

		// TODO Output results.
		entries[0] = target.getName();
		entries[1] = "" + valid;
		entries[2] = "" + tokenCount;
		entries[3] = "" + coverage;
		entries[4] = "" + errorCount;
		entries[5] = "" + errors;
		entries[6] = "" + warningCount;
		entries[7] = "" + warnings;
		writer.writeNext(entries);
		writer.flush();
	}

	private static void collectSubjects(File file, List<File> targets) {
		if (file == null || !file.exists()) {
			return;
		}

		if (file.isDirectory()) {
			for (File child : file.listFiles()) {
				collectSubjects(child, targets);
			}

			return;
		}

		String name = file.getName().toUpperCase();
		if (name.endsWith(".CBL") || name.endsWith(".COB")
				|| name.endsWith(".CPY") || name.endsWith(".COPY")) {
			targets.add(file);
		}
	}
}
