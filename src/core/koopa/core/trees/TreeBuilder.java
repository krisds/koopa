package koopa.core.trees;

import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.Start;

public interface TreeBuilder {

	void down(Start token);

	void up(End token);

	void leaf(Token token);

	void water(InWater token);

	void land();
}
