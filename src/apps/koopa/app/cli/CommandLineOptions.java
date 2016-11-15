package koopa.app.cli;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import koopa.cobol.sources.SourceFormat;

public class CommandLineOptions {

	private SourceFormat format = SourceFormat.FIXED;
	private boolean preprocess = false;
	private List<String> copybookPaths = new LinkedList<String>();
	private List<String> other = new ArrayList<String>();

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
				if (option.equals("-I")) {

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
		return "Usage: [--free-format | --variable-format] "
				+ "[--preprocess -I <copyboopath>] [source]";
	}
}
