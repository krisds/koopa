package koopa.core.parsers;

import static koopa.core.data.tags.IslandTag.LAND;
import static koopa.core.data.tags.IslandTag.WATER;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.markers.OnLand;
import koopa.core.data.markers.InWater;
import koopa.core.data.tags.IslandTag;
import koopa.core.sources.Source;
import koopa.core.targets.NullTarget;
import koopa.core.targets.Target;

// TODO Rename to ParserCombinator ?
public abstract class Parser {
	public final boolean accepts(Source<Token> tokenizer) {
		return accepts(tokenizer, new NullTarget<Data>());
	}

	public final boolean accepts(Source<Token> tokenizer, Target<Data> sink) {
		assert (tokenizer != null);
		assert (sink != null);

		ParseStream stream = new BasicParseStream(tokenizer, new WaterTagger(sink));
		boolean accepted = accepts(stream);
		stream.commit();
		return accepted;
	}

	/**
	 * Actual parser combinators must implement this according to whatever logic
	 * they need. This method should, however, <b>not</b> get called directly by
	 * clients! They should use the one of the forms which accepts a
	 * {@linkplain Source}.
	 */
	public abstract boolean accepts(ParseStream stream);

	// ------------------------------------------------------------------------

	/**
	 * This target removes {@linkplain OnLand} and {@linkplain InWater} markers,
	 * and replaces them with {@linkplain IslandTag#LAND} and
	 * {@linkplain IslandTag#WATER} on the tokens themselves.
	 */
	public class WaterTagger implements Target<Data> {

		// TODO !!! If water/land markers can be nested in other water/land
		// markers we should use a counting scheme rather than a simple boolean.
		private boolean inWater = false;

		private Target<Data> nextSink = null;

		public WaterTagger(Target<Data> nextSink) {
			this.nextSink = nextSink;
		}

		@Override
		public void push(Data packet) {
			if (inWater && packet instanceof OnLand) {
				inWater = false;
				return;
			}

			if (!inWater && packet instanceof InWater) {
				inWater = true;
				return;
			}

			if (packet instanceof Token)
				packet = ((Token) packet).withTags(inWater ? WATER : LAND);

			if (nextSink != null)
				nextSink.push(packet);
		}
	}
}
