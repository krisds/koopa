package koopa.core.trees.antlr;

import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Position;
import koopa.core.data.Token;

import org.antlr.runtime.CommonToken;

/**
 * ANTLR wrapper for a Koopa {@linkplain Data} item. This allows you to build
 * ANTLR compatible trees (useful with ANTLR's tree parsing, which we use in
 * several places), while still retaining access to the original data.
 * <p>
 * The Koopa data gets mapped to correct ANTRL token types by means of a
 * {@linkplain ANTLRTokens} instance, which can be loaded from an ANTLR tokens
 * file.
 */
@SuppressWarnings("serial")
public class CommonKoopaToken extends CommonToken {
	private Data data = null;

	public CommonKoopaToken(final Data data) {
		super(1);

		this.data = data;

		setType(42);

		if (data instanceof Marker) {
			final Marker marker = (Marker) data;
			final String name = marker.getName();

			setText(name);

		} else if (data instanceof Token) {
			Token token = (Token) data;

			setText(token.getText());

			final Position position = token.getStart();
			setLine(position.getLinenumber());
			setCharPositionInLine(position.getPositionInLine());
		}
	}

	public Data getKoopaData() {
		return data;
	}
}
