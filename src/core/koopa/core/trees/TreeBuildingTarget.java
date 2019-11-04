package koopa.core.trees;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.OnLand;
import koopa.core.data.markers.Start;
import koopa.core.targets.Target;

public abstract class TreeBuildingTarget implements Target {

	private final boolean hideWater;

	// TODO !!! If water/land markers can be nested in other water/land markers
	// we should use a counting scheme rather than a simple boolean.
	private boolean inWater = false;

	public TreeBuildingTarget(boolean hideWater) {
		this.hideWater = hideWater;
	}

	@Override
	public void push(Data data) {
		if (inWater && data instanceof OnLand) {
			inWater = false;

			if (!hideWater)
				land();

		} else if (!inWater && data instanceof InWater) {
			inWater = true;

			if (!hideWater)
				water((InWater) data);

		} else if (!hideWater || !inWater) {
			assert (!(data instanceof InWater));
			assert (!(data instanceof OnLand));

			if (data instanceof Start)
				down((Start) data);
			else if (data instanceof End)
				up((End) data);
			else if (data instanceof Token)
				leaf((Token) data);
		}
	}

	@Override
	public void done() {
	}

	/**
	 * Start of a tree.
	 */
	protected abstract void down(Start start);

	/**
	 * End of a tree.
	 */
	protected abstract void up(End end);

	/**
	 * Leaf of a tree.
	 */
	protected abstract void leaf(Token token);

	/**
	 * States that we're processing water.
	 */
	protected abstract void water(InWater water);

	/**
	 * States that we're processing land.
	 */
	protected abstract void land();
}
