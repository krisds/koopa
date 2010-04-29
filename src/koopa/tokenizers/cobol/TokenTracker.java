package koopa.tokenizers.cobol;

import java.util.ArrayList;
import java.util.List;

import koopa.tokens.Token;

public class TokenTracker {
	private List<Token> tokens = null;

	public TokenTracker() {
		this.tokens = new ArrayList<Token>();
	}

	public void add(Token token) {
		this.tokens.add(token);
	}

	public List<Token> getTokens() {
		return tokens;
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

	public int getTokenCount() {
		return this.tokens.size();
	}
}
