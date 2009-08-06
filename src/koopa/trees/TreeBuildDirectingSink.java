package koopa.trees;


import java.util.List;

import koopa.parsers.markers.DownMarker;
import koopa.parsers.markers.LandMarker;
import koopa.parsers.markers.UpMarker;
import koopa.parsers.markers.WaterMarker;
import koopa.tokens.Token;
import koopa.tokenstreams.TokenSink;

public class TreeBuildDirectingSink implements TokenSink {

	// TODO !!! If water/land markers can be nested in other water/land markers
	// we should use a counting scheme rather than a simple boolean.
	private boolean inWater = false;

	private boolean hideWater = false;

	private TreeBuilder builder = null;

	private TokenSink nextSink = null;

	public TreeBuildDirectingSink(TreeBuilder builder, boolean hideWater) {
		assert (builder != null);

		this.builder = builder;
		this.hideWater = hideWater;
	}

	public void addAll(List<Token> tokens) {
		for (Token token : tokens) {
			if (this.inWater && token instanceof LandMarker) {
				this.inWater = false;

				if (!this.hideWater) {
					this.builder.land();
				}

				continue;

			} else if (!this.inWater && token instanceof WaterMarker) {
				this.inWater = true;

				if (!this.hideWater) {
					this.builder.water((WaterMarker) token);
				}

				continue;

			} else if (!this.hideWater || !this.inWater) {
				assert (!(token instanceof WaterMarker));
				assert (!(token instanceof LandMarker));

				if (this.inWater) {
					token.addTag(TreeTag.WATER);
				}

				if (token instanceof DownMarker) {
					this.builder.down((DownMarker) token);

				} else if (token instanceof UpMarker) {
					this.builder.up((UpMarker) token);

				} else {
					this.builder.leaf(token);
				}
			}
		}

		if (this.nextSink != null) {
			this.nextSink.addAll(tokens);
		}
	}

	public void setNextSink(TokenSink next) {
		this.nextSink = next;
	}
}
