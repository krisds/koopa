package koopa.cobol.cics.grammar;

import koopa.cobol.grammar.preprocessing.CobolPreprocessingBaseGrammar;

public class CICSBaseGrammar extends CobolPreprocessingBaseGrammar {

	@Override
	protected String getNamespace() {
		return "cics";
	}
}
