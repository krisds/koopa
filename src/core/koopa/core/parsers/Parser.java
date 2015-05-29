package koopa.core.parsers;

import static koopa.core.data.tags.IslandTag.LAND;
import static koopa.core.data.tags.IslandTag.WATER;

import java.util.Set;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.OnLand;
import koopa.core.data.tags.IslandTag;
import koopa.core.parsers.ParseStack.Frame;
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

		ParseStream stream = new BasicParseStream(tokenizer, new WaterTagger(
				sink));
		boolean accepted = accepts(stream);
		stream.commit();
		return accepted;
	}

	/**
	 * This method should <b>not</b> get called directly by clients! They should
	 * use {@linkplain #accepts(Source, Target)} instead.
	 */
	public final boolean accepts(ParseStream stream) {
		stream.getStack().push(this);
		try {
			return matches(stream);

		} finally {
			stream.getStack().pop();
		}
	}

	/**
	 * Actual parser combinators must implement this according to whatever logic
	 * they need.
	 */
	protected abstract boolean matches(ParseStream stream);

	// ------------------------------------------------------------------------

	public void addAllKeywordsInScopeTo(Set<String> keywords) {
	}

	public void addAllLeadingKeywordsTo(Set<String> keywords) {
	}

	/**
	 * Whether or not this parser can say that it
	 * {@linkplain #accepts(ParseStream)} without actually having consumed
	 * anything from the stream.
	 * <p>
	 * <b>By default this answers <code>false</code>.</b> So it's saying it will
	 * consume a token, which seems a reasonable thing for a parser to do.
	 */
	public boolean canMatchEmptyInputs() {
		return false;
	}

	public boolean isKeyword(String word, Frame frame) {
		return frame.up().isKeyword(word);
	}

	/**
	 * Is this parser matching a rule with the given name ?
	 */
	public boolean isMatching(String name) {
		return false;
	}

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
