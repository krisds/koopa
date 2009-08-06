package koopa.parsers.markers;

import koopa.tokens.Token;
import koopa.tokenstreams.Marker;

public class WaterMarker extends Marker {

	private Token token = null;

	public WaterMarker() {
	}

	public Token getToken() {
		return this.token;
	}

	public void setToken(Token token) {
		this.token = token;

		if (token != null) {
			this.start = token.getStart();
			this.end = token.getEnd();
			this.text = token.getText();

		} else {
			this.start = null;
			this.end = null;
			this.text = null;
		}
	}

	public String toString() {
		return "\\\\" + this.token.toString() + "~~";
	}

	public String getName() {
		return "water";
	}
}
