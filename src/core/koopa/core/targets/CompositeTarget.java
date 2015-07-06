package koopa.core.targets;

import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Data;

/**
 * This target forwards each data item to a collection of other targets.
 */
public class CompositeTarget<T extends Data> implements Target<T> {

	private final List<Target<T>> targets = new LinkedList<Target<T>>();

	public void push(T data) {
		for (Target<T> target : targets)
			target.push(data);
	}

	public void addTarget(Target<T> target) {
		assert (target != null);
		targets.add(target);
	}
}
