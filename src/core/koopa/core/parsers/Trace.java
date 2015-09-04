package koopa.core.parsers;

import org.apache.log4j.Logger;

public class Trace {
	private static final Logger LOGGER = Logger.getLogger("grammar");

	private static final String DENT = "  ";

	private String indent = "";

	private boolean quiet = false;

	public void quiet(boolean quiet) {
		this.quiet = quiet;
	}

	public boolean isEnabled() {
		return !quiet && LOGGER.isTraceEnabled();
	}

	public void indent(final String message) {
		LOGGER.trace(indent + message);
		indent += DENT;
	}

	public void add(final String message) {
		LOGGER.trace(indent + message);
	}

	public void dedent(final String message) {
		indent = indent.substring(0, indent.length() - DENT.length());
		LOGGER.trace(indent + message);
	}
}
