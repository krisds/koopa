package koopa.trees;

import koopa.parsers.markers.DownMarker;
import koopa.parsers.markers.UpMarker;
import koopa.parsers.markers.WaterMarker;
import koopa.tokens.Token;

public interface TreeBuilder {

	void down(DownMarker token);

	void up(UpMarker token);

	void leaf(Token token);

	void water(WaterMarker token);

	void land();
}
