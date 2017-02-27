package koopa.core.util;

import org.apache.log4j.Logger;

public class IndentingLogger {

	private static final String DENT = "  ";

	private final Logger logger;
	private final boolean enabled;

	private String indent = "";

	public IndentingLogger(Logger logger) {
		this.logger = logger;
		this.enabled = logger.isTraceEnabled();
	}

	private boolean quiet = false;
	private int silence = 0;

	public void quiet(boolean quiet) {
		this.quiet = quiet;
	}

	public void silence(boolean b) {
		silence += (b ? 1 : -1);
	}

	public boolean isEnabled() {
		return enabled && !quiet && silence <= 0;
	}

	public void add(final String message) {
		if (isEnabled())
			logger.trace(indent + message);
	}

	public void indent() {
		indent += DENT;
	}

	public void indent(final String message) {
		add(message);
		indent();
	}

	public void dedent(final String message) {
		dedent();
		add(message);
	}

	public void dedent() {
		indent = indent.substring(0, indent.length() - DENT.length());
	}
}
