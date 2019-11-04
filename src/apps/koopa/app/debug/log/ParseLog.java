package koopa.app.debug.log;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.spi.LoggingEvent;

import koopa.core.data.Data;
import koopa.core.parsers.Parse;
import koopa.core.parsers.Stack;
import koopa.core.parsers.Stack.Frame;

public class ParseLog {

	private Parse parse = null;

	private List<Event> events = new ArrayList<>();

	public void setParse(Parse parse) {
		this.parse = parse;
	}

	public int size() {
		return events.size();
	}

	public Event getEvent(int index) {
		return events.get(index);
	}

	public void registerPush(Data data) {
		addEvent(new DataEvent(DataEvent.Type.PUSH, data));
	}

	public void registerPop(Data data) {
		addEvent(new DataEvent(DataEvent.Type.POP, data));
	}

	public void registerLogging(LoggingEvent event) {
		addEvent(event);
	}

	private void addEvent(Object data) {
		final int index = events.size();
		final Stack.Frame stack = parse.getStack().getHead();
		events.add(new Event(index, data, stack));
	}

	public class Event {
		private final int index;
		private final Object data;
		private final Stack.Frame stack;

		public Event(int index, Object data, Frame stack) {
			this.index = index;
			this.data = data;
			this.stack = stack;
		}

		public int getIndex() {
			return index;
		}

		public Object getData() {
			return data;
		}

		public Stack.Frame getStack() {
			return stack;
		}
	}
}
