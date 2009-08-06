package koopa.app.components.sourceview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import koopa.parsers.markers.LandMarker;
import koopa.parsers.markers.WaterMarker;
import koopa.tokens.CompositeToken;
import koopa.tokens.Token;
import koopa.tokenstreams.Marker;
import koopa.tokenstreams.TokenSink;


public class SourceViewSink implements TokenSink {

	// There is difference between these two which is of importance. The
	// "tokens" list can have tokens which crosses line boundaries. The "lines"
	// list can not.
	private List<List<Token>> lines = new ArrayList<List<Token>>();
	private List<Token> tokens = new ArrayList<Token>();

	private boolean inWater = false;

	private TokenSink next = null;

	public List<List<Token>> getLines() {
		return lines;
	}

	public void addAll(List<Token> tokens) {
		for (Token token : tokens) {
			if (token instanceof Marker) {
				if (token instanceof WaterMarker) {
					this.inWater = true;

				} else if (token instanceof LandMarker) {
					this.inWater = false;
				}

			} else if (!this.inWater) {
				registerToken(token);
				this.tokens.add(token);
			}
		}

		if (this.next != null) {
			this.next.addAll(tokens);
		}
	}

	private void registerToken(Token token) {
		if (token instanceof CompositeToken) {
			final CompositeToken composite = (CompositeToken) token;
			final int size = composite.size();
			for (int i = 0; i < size; i++) {
				Token innerToken = composite.getToken(i);
				registerToken(innerToken);
			}

		} else {
			final int linenumber = token.getStart().getLinenumber();

			List<Token> line = null;
			if (linenumber < lines.size()) {
				line = lines.get(linenumber);
			} else {
				lines.add(line = new LinkedList<Token>());
			}

			line.add(token);
		}
	}

	public void setNextSink(TokenSink next) {
		this.next = next;
	}

	public Token getTokenAt(int position) {
		final int size = this.tokens.size();

		if (size == 0) {
			return null;
		}

		int left = 0;
		int right = size - 1;

		while (true) {
			if (left >= right) {
				break;
			}

			int mid = (left + right) >> 1;

			Token t = this.tokens.get(mid);
			if (position < t.getStart().getPositionInFile()) {
				right = mid - 1;
				continue;
			}

			if (position > t.getEnd().getPositionInFile()) {
				left = mid + 1;
				continue;
			}

			return t;
		}

		if (left > right) {
			return null;
		}

		Token t = this.tokens.get(left);
		if (position >= t.getStart().getPositionInFile()
				&& position <= t.getEnd().getPositionInFile()) {
			return t;
		}

		return null;
	}
}
