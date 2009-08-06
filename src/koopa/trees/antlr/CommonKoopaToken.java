package koopa.trees.antlr;

import koopa.tokens.Position;
import koopa.tokens.Token;
import koopa.tokenstreams.Marker;

import org.antlr.runtime.CommonToken;

@SuppressWarnings("serial")
public class CommonKoopaToken extends CommonToken {
	private Token token = null;

	public CommonKoopaToken(final Token token, final TokenTypes types) {
		super(1);

		this.token = token;

		if (token instanceof Marker) {
			final Marker marker = (Marker) token;
			final String name = marker.getName();

			setType(types.forNode(name));
			setText(name);

		} else {
			setType(types.forLiteral(token.getText()));
			setText(token.getText());

			final Position position = token.getStart();
			setLine(position.getLinenumber());
			setCharPositionInLine(position.getPositionInLine());
		}
	}

	public Token getKoopaToken() {
		return token;
	}
}
