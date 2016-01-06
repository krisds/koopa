package koopa.core.targets;

import static koopa.core.data.tags.IslandTag.LAND;
import static koopa.core.data.tags.IslandTag.WATER;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.OnLand;
import koopa.core.data.tags.IslandTag;

/**
 * This target removes {@linkplain OnLand} and {@linkplain InWater} markers, and
 * replaces them with {@linkplain IslandTag#LAND} and
 * {@linkplain IslandTag#WATER} on the tokens themselves.
 */
public class WaterTagger implements Target<Data> {

	// TODO !!! If water/land markers can be nested in other water/land
	// markers we should use a counting scheme rather than a simple boolean.
	private boolean inWater = false;

	private Target<Data> target = null;

	public WaterTagger(Target<Data> target) {
		this.target = target;
	}

	public void done() {
		// We want to make sure that the water tagger is not responsible for
		// hanging on to memory which could otherwise be freed up. For instance,
		// the target may include tree builders or token trackers, which can be
		// expensive and are something we want to make sure can be reclaimed.
		if (target != null) {
			target.done();
			target = null;
		}
	}

	public void push(Data data) {
		if (inWater && data instanceof OnLand) {
			inWater = false;
			return;
		}

		if (!inWater && data instanceof InWater) {
			inWater = true;
			return;
		}

		if (data instanceof Token)
			data = ((Token) data).withTags(inWater ? WATER : LAND);

		if (target != null)
			target.push(data);
	}
}