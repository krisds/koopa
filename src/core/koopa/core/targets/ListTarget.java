package koopa.core.targets;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import koopa.core.data.Data;

/**
 * Simple {@linkplain Target} implementation which collects all its data into a
 * {@linkplain List}.
 */
public class ListTarget implements Target<Data> {

	private static final Logger LOGGER = Logger.getLogger("target.list");

	private List<Data> packets = new ArrayList<Data>();

	public void push(Data packet) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("<< " + packet);
		
		packets.add(packet);
	}

	public boolean isEmpty() {
		return packets.isEmpty();
	}

	public int size() {
		return packets.size();
	}

	public Data get(int i) {
		return packets.get(i);
	}
}
