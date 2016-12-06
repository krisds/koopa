package koopa.app.debug.log;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class ParseLogAppender extends AppenderSkeleton {
	private final ParseLog log;

	public ParseLogAppender(ParseLog log) {
		this.log = log;
	}

	public boolean requiresLayout() {
		return false;
	}

	public void close() {
	}

	@Override
	protected void append(LoggingEvent event) {
		log.registerLogging(event);
	}
}