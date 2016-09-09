package koopa.core.targets;

import java.util.Iterator;
import java.util.LinkedList;

import koopa.core.data.Data;
import koopa.core.util.Iterators;

/**
 * This is a {@linkplain Target} which will refrain from forwarding its
 * {@linkplain Data} to another target until instructed to do so 'via
 * {@link #shiftAllToNextTarget()}).
 * <p>
 * In addition to the delay, you can also retract the data which was pushed up
 * to the point of the last {@link #shiftAllToNextTarget()}.
 */
public class HoldingTarget implements Target<Data> {

	/** The recipient of our {@linkplain Data}. */
	private final Target<Data> target;

	/** The {@linkplain Data} we're holding on to. */
	private final LinkedList<Data> queue;

	public HoldingTarget(Target<Data> target) {
		assert (target != null);
		this.target = target;
		this.queue = new LinkedList<Data>();
	}

	/** {@inheritDoc} */
	public void push(Data data) {
		queue.addLast(data);
	}

	/** {@inheritDoc} */
	public void done() {
	}

	// ========================================================================

	/**
	 * Undoes the latest {@link #push(Data)}, returning the data which was
	 * pushed.
	 */
	public Data pop() {
		assert (!queue.isEmpty());
		return queue.removeLast();
	}

	/**
	 * This will {@linkplain Target#push(Data)} all data which is being held
	 * {@link TokenTracker} the {@link #target}.
	 */
	public void shiftAllToNextTarget() {
		while (!queue.isEmpty()) {
			final Data data = queue.removeFirst();
			target.push(data);
		}
	}

	/**
	 * Whether or not we're holding on to {@linkplain Data}.
	 */
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	/** How much {@linkplain Data} we're holding on to. */
	public int size() {
		return queue.size();
	}

	/**
	 * Get an {@linkplain Iterator} over all {@linkplain Data} being held, in
	 * reverse order.
	 */
	public Iterator<Data> descendingIterator() {
		return Iterators.descendingIterator(queue);
	}

	/**
	 * Get an {@linkplain Iterator} over all {@linkplain Data} being held,
	 * starting at the given index.
	 */
	public Iterator<Data> listIterator(int index) {
		return Iterators.listIterator(queue, index);
	}
}
