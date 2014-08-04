package koopa.app.components.sourceview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import koopa.cobol.data.tags.AreaTag;
import koopa.core.data.Token;
import koopa.core.sources.ChainableSource;

public class SourceViewIntermediateTokenizer extends ChainableSource<Token> {

	private List<List<Token>> lines = new ArrayList<List<Token>>();

	@Override
	protected Token nxt1() {
		Token token = source.next();

		if (token != null && !token.hasTag(AreaTag.PROGRAM_TEXT_AREA)) {
			registerToken(token);
		}

		return token;
	}

	private void registerToken(Token token) {
		// if (token instanceof CompositeToken) {
		// 	final CompositeToken composite = (CompositeToken) token;
		// 	final int size = composite.size();
		// 	for (int i = 0; i < size; i++) {
		// 		Token innerToken = composite.getToken(i);
		// 		registerToken(innerToken);
		// 	}
		// 
		// } else {
			final int linenumber = token.getStart().getLinenumber();

			while (linenumber >= lines.size()) {
				lines.add(new LinkedList<Token>());
			}

			List<Token> line = lines.get(linenumber);

			line.add(token);
		// }
	}

	public List<List<Token>> getLines() {
		return lines;
	}
}
