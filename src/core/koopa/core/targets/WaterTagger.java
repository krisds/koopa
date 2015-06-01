package koopa.core.targets;

import static koopa.core.data.tags.IslandTag.LAND;
import static koopa.core.data.tags.IslandTag.WATER;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.OnLand;
import koopa.core.data.tags.IslandTag;

/**
 * This target removes {@linkplain OnLand} and {@linkplain InWater} markers,
 * and replaces them with {@linkplain IslandTag#LAND} and
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