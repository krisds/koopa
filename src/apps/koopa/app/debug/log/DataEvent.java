package koopa.app.debug.log;

import koopa.core.data.Data;

public class DataEvent {

	public static enum Type {
		PUSH, POP
	}

	private final Type type;
	private final Data data;

	public DataEvent(Type type, Data data) {
		this.type = type;
		this.data = data;
	}

	public Type getType() {
		return type;
	}

	public Data getData() {
		return data;
	}

	@Override
	public String toString() {
		return type + " " + data;
	}
}
