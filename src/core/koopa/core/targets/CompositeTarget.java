package koopa.core.targets;

import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Data;

/**
 * This target forwards each data item to a collection of other targets.
 */
public class CompositeTarget implements Target {

	private final List<Target> targets = new LinkedList<>();

	@Override
	public void push(Data data) {
		for (Target target : targets)
			target.push(data);
	}

	@Override
	public void done() {
		for (Target target : targets)
			target.done();
	}

	public void addTarget(Target target) {
		assert (target != null);
		targets.add(target);
	}
}
