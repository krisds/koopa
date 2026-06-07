package koopa.core.parsers;

import org.apache.logging.log4j.LogManager;

import koopa.core.util.IndentingLogger;

public class Trace extends IndentingLogger {
	public Trace() {
		super(LogManager.getLogger("grammar"));
	}
}
