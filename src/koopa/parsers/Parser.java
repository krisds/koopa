package koopa.parsers;

import java.util.List;

import koopa.parsers.markers.LandMarker;
import koopa.parsers.markers.WaterMarker;
import koopa.tokenizers.Tokenizer;
import koopa.tokenizers.cobol.tags.IslandTag;
import koopa.tokens.Token;
import koopa.tokenstreams.TokenSink;
import koopa.tokenstreams.TokenStream;
import koopa.tokenstreams.generic.MainTokenStream;

public abstract class Parser {
	public final boolean accepts(Tokenizer tokenizer) {
		return accepts(tokenizer, null);
	}

	public final boolean accepts(Tokenizer tokenizer, TokenSink sink) {
		MainTokenStream stream = new MainTokenStream(tokenizer);
		stream.setTokenSink(new WaterTaggingSink(sink));
		boolean accepted = accepts(stream);
		stream.commit();
		return accepted;
	}

	protected abstract boolean accepts(TokenStream stream);

	public class WaterTaggingSink implements TokenSink {

		// TODO !!! If water/land markers can be nested in other water/land
		// markers we should use a counting scheme rather than a simple boolean.
		private boolean inWater = false;

		private TokenSink nextSink = null;

		public WaterTaggingSink(TokenSink nextSink) {
			this.nextSink = nextSink;
		}

		public void addAll(List<Token> tokens) {
			for (Token token : tokens) {
				if (this.inWater && token instanceof LandMarker) {
					this.inWater = false;
					continue;

				} else if (!this.inWater && token instanceof WaterMarker) {
					this.inWater = true;
					continue;

				} else {
					token.addTag(this.inWater ? IslandTag.WATER
							: IslandTag.LAND);
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
}
