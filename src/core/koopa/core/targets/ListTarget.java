package koopa.core.targets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import koopa.core.data.Data;

/**
 * Simple {@linkplain Target} implementation which collects all its data into a
 * {@linkplain List}.
 */
public class ListTarget implements Target, Iterable<Data> {

	private List<Data> packets = new ArrayList<>();

	@Override
	public void push(Data packet) {
		packets.add(packet);
	}

	@Override
	public void done() {
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

	@Override
	public Iterator<Data> iterator() {
		return packets.iterator();
	}
}
