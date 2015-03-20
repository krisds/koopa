package koopa.app.components.sourceview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Token;
import koopa.core.data.markers.InWater;
import koopa.core.data.markers.OnLand;
import koopa.core.targets.Target;

public class SourceViewSink implements Target<Data> {

	// There is difference between these two which is of importance. The
	// "tokens" list can have tokens which crosses line boundaries. The "lines"
	// list can not.
	private List<List<Token>> lines = new ArrayList<List<Token>>();
	private List<Token> tokens = new ArrayList<Token>();

	private boolean inWater = false;

	public List<List<Token>> getLines() {
		return lines;
	}

	public void push(Data data) {
		if (data instanceof Marker) {
			if (data instanceof InWater) {
				this.inWater = true;

			} else if (data instanceof OnLand) {
				this.inWater = false;
			}

		}
		if (data instanceof Token) {
			Token token = (Token) data;

			if (!this.inWater) {
				registerToken(token);
				this.tokens.add(token);
			}
		}
	}

	private void registerToken(Token token) {
		// if (token instanceof CompositeToken) {
		// final CompositeToken composite = (CompositeToken) token;
		// final int size = composite.size();
		// for (int i = 0; i < size; i++) {
		// Token innerToken = composite.getToken(i);
		// registerToken(innerToken);
		// }
		//
		// } else {
		final int linenumber = token.getStart().getLinenumber();

		List<Token> line = null;
		if (linenumber < lines.size()) {
			line = lines.get(linenumber);
		} else {
			lines.add(line = new LinkedList<Token>());
		}

		line.add(token);
		// }
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
