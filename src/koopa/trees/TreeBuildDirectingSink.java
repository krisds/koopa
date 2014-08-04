package koopa.trees;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.markers.End;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.OnLand;
import koopa.core.data.markers.Start;
import koopa.core.targets.Target;

public class TreeBuildDirectingSink implements Target<Data> {

	// TODO !!! If water/land markers can be nested in other water/land markers
	// we should use a counting scheme rather than a simple boolean.
	private boolean inWater = false;

	private boolean hideWater = false;

	private TreeBuilder builder = null;

	public TreeBuildDirectingSink(TreeBuilder builder, boolean hideWater) {
		assert (builder != null);

		this.builder = builder;
		this.hideWater = hideWater;
	}

	@Override
	public void push(Data data) {
		if (this.inWater && data instanceof OnLand) {
			this.inWater = false;

			if (!this.hideWater)
				this.builder.land();

		} else if (!this.inWater && data instanceof InWater) {
			this.inWater = true;

			if (!this.hideWater)
				this.builder.water((InWater) data);

		} else if (!this.hideWater || !this.inWater) {
			assert (!(data instanceof InWater));
			assert (!(data instanceof OnLand));

			// if (this.inWater) {
			// token.addTag(TreeTag.WATER);
			// }

			if (data instanceof Start) {
				this.builder.down((Start) data);

			} else if (data instanceof End) {
				this.builder.up((End) data);

			} else if (data instanceof Token) {
				this.builder.leaf((Token) data);
			}
		}
	}
}
