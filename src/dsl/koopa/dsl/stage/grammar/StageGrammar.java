package koopa.dsl.stage.grammar;

import static koopa.core.data.tags.SyntacticTag.NUMBER;
import static koopa.core.data.tags.SyntacticTag.WORD;
import koopa.core.grammars.fluent.FluentGrammar;
import koopa.core.parsers.ParserCombinator;

public class StageGrammar extends FluentGrammar {

	public StageGrammar() {
		define("stage").as(oneOrMore("target"), eof());

		define("target").as( //
				"==target==", "identifier", "==;==", //
				many("test"));

		define("test").as(oneOf("accept", "reject"), "sample");

		define("accept").as("==+==");

		define("reject").as("==-==");

		define("sample").as( //
				oneOrMore(oneOf("fragment", "reference")), //
				optional("mark", oneOrMore(oneOf("fragment", "reference"))));

		define("fragment").as("bracketed");
		defineHelper("bracketed").as( //
				"==[==", //
				many(oneOf("bracketed", all(not("==]=="), any()))), //
				"==]==");

		define("reference").as(oneOf( //
				all("stageName", noskip("==:==", "targetName")), //
				"targetName"));

		define("mark").as("==<==", noskip("==>=="));

		define("stageName").as("identifier");
		define("targetName").as("identifier");

		define("identifier").as(notAKeyword( //
				tagged(WORD), any(), //
				optional(noskip(oneOrMore(oneOf( //
						"==_==", //
						"==$==", //
						all(tagged(WORD), any()), //
						all(tagged(NUMBER), any())//
				))))));
	}

	public ParserCombinator stage() {
		return definitionOf("stage").asParser();
	}

	public ParserCombinator identifier() {
		return definitionOf("identifier").asParser();
	}

	// ------------------------------------------------------------------------

	@Override
	public boolean isCaseSensitive() {
		return true;
	}

	@Override
	public String getNamespace() {
		return "stage";
	}
}
