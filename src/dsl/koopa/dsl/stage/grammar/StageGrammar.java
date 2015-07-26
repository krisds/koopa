package koopa.dsl.stage.grammar;

import static koopa.dsl.stage.tags.StageTag.COMMENT;
import static koopa.dsl.stage.tags.StageTag.IDENTIFIER;
import static koopa.dsl.stage.tags.StageTag.SAMPLE;
import static koopa.dsl.stage.tags.StageTag.TEXT;
import static koopa.dsl.stage.tags.StageTag.WHITESPACE;
import koopa.core.data.Token;
import koopa.core.grammars.fluent.FluentGrammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

public class StageGrammar extends FluentGrammar {

	public StageGrammar() {
		define("stage").as( //
				"package", //
				"grammar", //
				"tokenizer", //
				oneOrMore("suite"), //
				eof());

		define("package").as("==package==", "qualified_name", "==;==");
		define("grammar").as("==grammar==", "qualified_name", "==;==");
		define("tokenizer").as("==tokenizer==", "qualified_name", "==;==");
		define("suite").as("target", many("test"));
		define("target").as("==target==", "identifier", "==;==");
		define("test").as(oneOf("accept", "reject"), "sample");
		define("accept").as("==+==");
		define("reject").as("==-==");

		// TODO noskip
		define("qualified_name").as(alternating("identifier", "==.=="));
		define("identifier").as(tagged(IDENTIFIER), any());
		define("sample").as(tagged(SAMPLE), any());
	}

	public ParserCombinator stage() {
		return definitionOf("stage").asParser();
	}

	// ------------------------------------------------------------------------

	@Override
	public boolean isCaseSensitive() {
		return true;
	}

	@Override
	public boolean isProgramText(Token token) {
		return token.hasTag(TEXT);
	}

	@Override
	public boolean isComment(Token token) {
		return token.hasTag(COMMENT);
	}

	@Override
	public boolean isSeparator(String text) {
		return text.trim().length() == 0;
	}

	@Override
	public boolean isSeparator(Token token, Parse parseStack) {
		return token.hasTag(WHITESPACE);
	}

	@Override
	public String getNamespace() {
		return "stage";
	}
}
