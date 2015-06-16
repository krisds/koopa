package koopa.core.trees;

import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.Start;

public interface TreeBuilder {

	/**
	 * Start of a tree.
	 */
	void down(Start start);

	/**
	 * End of a tree.
	 */
	void up(End end);

	/**
	 * Leaf of a tree.
	 */
	void leaf(Token token);

	/**
	 * States that we're processing water.
	 */
	void water(InWater water);

	/**
	 * States that we're processing land.
	 */
	void land();
}
