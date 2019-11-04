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
import koopa.core.data.Position;
import koopa.core.parsers.Parse;
import koopa.core.trees.Tree;
import koopa.core.util.Files;

public class TestResult {

	/**
	 * Just a quick override, useful when working on the sources.
	 */
	private static final boolean TEST_TOKEN_COUNT = true;

	/**
	 * Just a quick override, useful when working on the sources.
	 */
	private static final boolean TEST_COVERAGE = true;

	/**
	 * The data we track in the CSV for regression testing.
	 */
	private static final Entry<?>[] ENTRIES = new Entry<?>[] { //
			// NOTE Element 0 acts as the key for comparing across runs.
			new Entry<String>("File", StringValue.class) {
				@Override
				public StringValue fromResults(ParseResults results) {
					return new StringValue(results.getFile().getName());
				}

				@Override
				public String diff(String previous, String current) {
					throw new UnsupportedOperationException(
							"Mismatching keys ?");
				}
			}, //
			new Entry<Boolean>("Valid", BooleanValue.class) {
				@Override
				public BooleanValue fromResults(ParseResults results) {
					return new BooleanValue(results.isValidInput());
				}

				@Override
				public String diff(Boolean previous, Boolean actual) {
					if (previous)
						return "- This file used to parse. It no longer does.";
					else
						return "+ This file used to fail parsing. It is now valid.";
				}
			}, //
			new Entry<Integer>("Number of tokens", IntValue.class) {
				@Override
				public IntValue fromResults(ParseResults results) {
					return new IntValue(
							Metrics.getSignificantTokenCount(results));
				}

				@Override
				public String diff(Integer previous, Integer current) {
					if (!TEST_TOKEN_COUNT)
						return null;

					if (current < previous)
						return "- Number of tokens went down from " + previous
								+ " to " + current + ".";
					else
						return "- Number of tokens went up from " + previous
								+ " to " + current + ".";
				}
			}, //
			new Entry<Float>("Coverage", FloatValue.class) {
				@Override
				public FloatValue fromResults(ParseResults results) {
					return new FloatValue(Metrics.getCoverage(results));
				}

				@Override
				public String diff(Float previous, Float current) {
					if (!TEST_COVERAGE)
						return null;

					if (current < previous)
						return "- Coverage went down from " + previous + " to "
								+ current + ".";
					else
						return "+ Coverage went up from " + previous + " to "
								+ current + ".";
				}
			}, //
			new Entry<Integer>("Number of errors", IntValue.class) {
				@Override
				public IntValue fromResults(ParseResults results) {
					return new IntValue(results.getParse().getMessages()
							.getErrorCount());
				}

				@Override
				public String diff(Integer previous, Integer current) {
					if (current < previous)
						return "+ Error count went down from " + previous
								+ " to " + current + ".";
					else
						return "- Error count went up from " + previous
								+ " to " + current + ".";
				}
			}, //
			new Entry<Integer>("Number of warnings", IntValue.class) {
				@Override
				public IntValue fromResults(ParseResults results) {
					return new IntValue(results.getParse().getMessages()
							.getWarningCount());
				}

				@Override
				public String diff(Integer previous, Integer current) {
					if (current < previous)
						return "+ Warning count went down from " + previous
								+ " to " + current + ".";

					else
						return "- Warning count went up from " + previous
								+ " to " + current + ".";
				}
			}, //
			new Entry<Integer>("Number of preprocessed directives",
					IntValue.class) {
				@Override
				public IntValue fromResults(ParseResults results) {
					int count = 0;
					final Parse parse = results.getParse();
					final CopyInclude copyInclude = parse
							.getSource(CopyInclude.class);
					if (copyInclude != null) {
						final List<Tree> handledDirectives = copyInclude
								.getHandledDirectives();
						count += handledDirectives.size();
					}

					final Replace replace = parse.getSource(Replace.class);
					if (replace != null) {
						final List<Tree> handledDirectives = replace
								.getHandledDirectives();
						count += handledDirectives.size();
					}

					return new IntValue(count);
				}

				@Override
				public String diff(Integer previous, Integer current) {
					if (current < previous)
						return "+ Preprocessed directives count went down from "
								+ previous + " to " + current + ".";
					else
						return "- Preprocessed directives count went up from "
								+ previous + " to " + current + ".";
				}
			}, //
			new Entry<Position>("Final position", PositionValue.class) {
				@Override
				public PositionValue fromResults(ParseResults results) {
					return new PositionValue(results.getParse()
							.getFinalPosition());
				}

				@Override
				public String diff(Position previous, Position current) {
					if (current.getLinenumber() < previous.getLinenumber())
						return "- End of parse went down from line "
								+ previous.getLinenumber() + " to "
								+ current.getLinenumber();
					else if (current.getLinenumber() > previous.getLinenumber())
						return "+ End of parse went up from line "
								+ previous.getLinenumber() + " to "
								+ current.getLinenumber();
					else if (current.getPositionInLine() < previous
							.getPositionInLine())
						return "- End of parse went down from column "
								+ previous.getLinenumber() + " to "
								+ current.getLinenumber();
					else if (current.getPositionInLine() > previous
							.getPositionInLine())
						return "+ End of parse went up from column "
								+ previous.getLinenumber() + " to "
								+ current.getLinenumber();
					else
						return null;
				}
			} //
	};

	private static final String[] HEADER;

	static {
		HEADER = new String[ENTRIES.length];
		for (int i = 0; i < HEADER.length; i++)
			HEADER[i] = ENTRIES[i].name;
	}

	@SuppressWarnings("rawtypes")
	private final Value[] values = new Value[ENTRIES.length];

	public String getKey() {
		return values[0].toString();
	}

	public static TestResult from(ParseResults results) {
		final TestResult r = new TestResult();

		for (int i = 0; i < ENTRIES.length; i++)
			r.values[i] = ENTRIES[i].fromResults(results);

		return r;
	}

	public List<String> getComparison(TestResult actual) {
		final List<String> messages = new ArrayList<>();

		for (int i = 0; i < ENTRIES.length; i++) {
			@SuppressWarnings("unchecked")
			final String msg = ENTRIES[i].compare(values[i], actual.values[i]);
			if (msg != null)
				messages.add(msg);
		}

		return messages;
	}

	public static Map<String, TestResult> loadFromFile(File expectedFile)
			throws IOException {
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(expectedFile));

			// CSV Header.
			String[] header = null;
			if ((header = reader.readNext()) == null) {
				return null;
			}

			int columnForEntry[] = new int[HEADER.length];
			for (int i = 0; i < HEADER.length; i++) {
				columnForEntry[i] = -1;
				for (int col = 0; col < header.length; col++)
					if (HEADER[i].equals(header[col])) {
						columnForEntry[i] = col;
						break;
					}
			}

			String[] columns = null;
			final Map<String, TestResult> targets = new HashMap<>();

			// Entries.
			while ((columns = reader.readNext()) != null) {
				TestResult r = new TestResult();

				for (int i = 0; i < r.values.length; i++) {
					if (columnForEntry[i] < 0)
						r.values[i] = null;
					else
						r.values[i] = ENTRIES[i]
								.fromString(columns[columnForEntry[i]]);
				}

				targets.put(r.getKey(), r);
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

		try (final FileWriter fw = new FileWriter(targetFile);
				final BufferedWriter bw = new BufferedWriter(fw);
				final CSVWriter writer = new CSVWriter(bw);) {

			// Write out the header for the CSV.
			writeResultsHeader(writer);

			Set<String> keys = results.keySet();
			List<String> sortedKeys = new ArrayList<>(keys);
			Collections.sort(sortedKeys);

			for (String key : sortedKeys)
				writeNextResult(writer, key, results.get(key));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void writeResultsHeader(final CSVWriter writer)
			throws IOException {
		writer.writeNext(HEADER);
		writer.flush();
	}

	private static void writeNextResult(CSVWriter writer, String name,
			TestResult results) throws IOException {

		final String[] stringValues = new String[results.values.length];
		for (int i = 0; i < stringValues.length; i++)
			stringValues[i] = results.values[i] == null ? ""
					: results.values[i].toString();

		writer.writeNext(stringValues);
		writer.flush();
	}

	private static abstract class Entry<T> {
		public final String name;
		private final Class<? extends Value<T>> clazz;

		public Entry(String name, Class<? extends Value<T>> clazz) {
			this.name = name;
			this.clazz = clazz;
		}

		public String compare(Value<T> previous, Value<T> current) {
			if (previous == null)
				return null;
			else if (previous.value.equals(current.value))
				return null;
			else
				return diff(previous.value, current.value);
		}

		public abstract String diff(T previous, T current);

		public abstract Value<T> fromResults(ParseResults results);

		public Value<T> fromString(String s) {
			if (s == null || s.trim().isEmpty())
				return null;
			try {
				Value<T> v = clazz.newInstance();
				v.initializeFromString(s);
				return v;
			} catch (InstantiationException e) {
				e.printStackTrace();
				return null;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	private static abstract class Value<T> {
		public T value;

		public Value() {
			this.value = null;
		}

		public Value(T value) {
			this.value = value;
		}

		public abstract void initializeFromString(String s);

		@Override
		public String toString() {
			return value == null ? "" : value.toString();
		}
	}

	private static class StringValue extends Value<String> {
		@SuppressWarnings("unused")
		public StringValue() {
		}

		public StringValue(String s) {
			super(s);
		}

		@Override
		public void initializeFromString(String s) {
			this.value = s;
		}
	}

	private static class BooleanValue extends Value<Boolean> {
		@SuppressWarnings("unused")
		public BooleanValue() {
		}

		public BooleanValue(boolean b) {
			super(b);
		}

		@Override
		public void initializeFromString(String s) {
			if (s == null)
				this.value = null;
			else
				this.value = Boolean.valueOf(s);
		}
	}

	private static class IntValue extends Value<Integer> {
		@SuppressWarnings("unused")
		public IntValue() {
		}

		public IntValue(int i) {
			super(i);
		}

		@Override
		public void initializeFromString(String s) {
			if (s == null)
				this.value = null;
			else
				this.value = Integer.valueOf(s);
		}
	}

	private static class FloatValue extends Value<Float> {
		@SuppressWarnings("unused")
		public FloatValue() {
		}

		public FloatValue(float f) {
			super(f);
		}

		@Override
		public void initializeFromString(String s) {
			if (s == null)
				this.value = null;
			else
				this.value = Float.valueOf(s);
		}
	}

	private static class PositionValue extends Value<Position> {
		@SuppressWarnings("unused")
		public PositionValue() {
		}

		public PositionValue(Position p) {
			super(p);
		}

		@Override
		public void initializeFromString(String s) {
			if (s == null)
				this.value = null;
			else {
				final String[] ps = s.split(":");
				this.value = new Position(ps[0], -1, Integer.valueOf(ps[1]),
						Integer.valueOf(ps[2]));
			}
		}

		@Override
		public String toString() {
			if (value == null)
				return "";

			String name = value.getResourceName();
			if (name == null)
				name = "";
			else
				name = Files.getFilename(value.getResourceName());

			return name + ":" + value.getLinenumber() + ":"
					+ value.getPositionInLine();
		}
	}
}
