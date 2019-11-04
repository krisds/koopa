package koopa.app.cli;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import koopa.cobol.sources.SourceFormat;
import koopa.core.util.TabStops;

public class CommandLineOptions {

	private SourceFormat format = SourceFormat.FIXED;
	private int tabLength = 1;
	private TabStops tabStops = new TabStops();
	private boolean preprocess = false;
	private List<String> copybookPaths = new LinkedList<>();
	private List<String> other = new ArrayList<>();

	public CommandLineOptions(String[] args) {
		for (int i = 0; i < args.length; i++) {
			String option = args[i];

			if (option.startsWith("--")) {
				if (option.equals("--free-format"))
					format = SourceFormat.FREE;
				else if (option.equals("--variable-format"))
					format = SourceFormat.VARIABLE;
				else if (option.equals("--preprocess"))
					preprocess = true;
				else
					throw new IllegalArgumentException(
							"Unknown option: " + option);

			} else if (option.startsWith("-")) {
				if (option.equals("-tab-length")) {
					i += 1;
					if (i >= args.length)
						throw new IllegalArgumentException(
								"Missing tab length definition.");

					try {
						tabLength = Integer.parseInt(args[i]);
					} catch (NumberFormatException e) {
						throw new IllegalArgumentException(
								"Tab length must be a positive number.");
					}

					if (tabLength <= 0)
						throw new IllegalArgumentException(
								"Tab length must be a positive number.");

				} else if (option.equals("-tab-stops")) {
					i += 1;
					if (i >= args.length)
						throw new IllegalArgumentException(
								"Missing tab stops definition.");

					tabStops = new TabStops().fromString(args[i]);

				} else if (option.equals("-I")) {
					i += 1;
					if (i >= args.length)
						throw new IllegalArgumentException(
								"Missing copybook path definition.");

					copybookPaths.add(args[i]);

				} else
					throw new IllegalArgumentException(
							"Unknown option: " + option);

			} else
				other.add(option);
		}
	}

	public SourceFormat getFormat() {
		return format;
	}

	public int getTabLength() {
		return tabLength;
	}

	public TabStops getTabStops() {
		return tabStops;
	}

	public boolean isPreprocess() {
		return preprocess;
	}

	public List<String> getCopybookPaths() {
		return copybookPaths;
	}

	public List<String> getOther() {
		return other;
	}

	public String usage() {
		return "Usage: [--free-format | --variable-format] " //
				+ "[--preprocess -I <copyboopath>] " //
				+ "[-tab-length <number>] [-tab-stops <csv>] " //
				+ "[source]";
	}
}
