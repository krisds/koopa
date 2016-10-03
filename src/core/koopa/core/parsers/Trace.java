package koopa.core.parsers;

import org.apache.log4j.Logger;

import koopa.core.util.IndentingLogger;

public class Trace extends IndentingLogger {
	public Trace() {
		super(Logger.getLogger("grammar"));
	}
}
