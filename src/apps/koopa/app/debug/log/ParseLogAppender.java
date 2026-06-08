package koopa.app.debug.log;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;

public class ParseLogAppender extends AbstractAppender {

	private final ParseLog log;

	public ParseLogAppender(String name, ParseLog log) {
		super(name, null, null, true, Property.EMPTY_ARRAY);
		this.log = log;
	}

	@Override
	public void append(LogEvent event) {
		log.registerLogging(event);
	}

}