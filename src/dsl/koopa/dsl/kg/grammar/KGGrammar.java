package koopa.dsl.kg.grammar;

import static koopa.dsl.kg.tags.KGTag.COMMENT;
import static koopa.dsl.kg.tags.KGTag.IDENTIFIER;
import static koopa.dsl.kg.tags.KGTag.LITERAL;
import static koopa.dsl.kg.tags.KGTag.NATIVE_CODE_BLOCK;
import static koopa.dsl.kg.tags.KGTag.NUMBER;
import static koopa.dsl.kg.tags.KGTag.QUOTED_LITERAL;
import static koopa.dsl.kg.tags.KGTag.TEXT;
import static koopa.dsl.kg.tags.KGTag.WHITESPACE;
import static koopa.dsl.kg.tags.KGTag.WORD;
import koopa.core.data.Token;
import koopa.core.grammars.fluent.FluentGrammar;
import koopa.core.parsers.Parse;
import koopa.core.parsers.ParserCombinator;

public class KGGrammar extends FluentGrammar {

	public KGGrammar() {
		// header rule* eof
		define("grammar").as("header", many("rule"), eof());

		// ['tree'] 'grammar' name ['extends' name] '.'
		define("header").as( //
				optional("tree"), //
				"grammar_name", //
				optional("extends"), //
				"==.==" //
		);
		define("tree").as("==tree==");
		define("grammar_name").as("==grammar==", "name");
		define("extends").as("==extends==", "name");

		// [modifier] 'def' [nokeywords] identifier [locals] [returning] '='
		// sequence 'end'
		define("rule").as( //
				optional("modifier"), //
				"==def==", //
				optional("nokeywords"), //
				"identifier", //
				optional("local-variables"), //
				optional("return_value"), //
				"=====", "sequence", "==end==" //
		);

		define("modifier").as(oneOf( //
				with("public").as("==public=="), //
				with("private").as("==private=="), //
				with("hiding").as("==hiding==")));
		define("local-variables").as( //
				"==(==", alternating("declaration", "==,=="), "==)==");
		define("declaration").as("type", "name");
		define("return_value").as("==returns==", "identifier");

		define("sequence").as(oneOf( //
				with("as").as("identifier", "==:==", "sequence"), //
				oneOrMore("part") //
				));

		defineHelper("part").as(oneOf( //
				with("star").as("repeatable", "==*=="), //
				with("plus").as("repeatable", "==+=="), //
				"atom" //
		));

		defineHelper("atom").as(oneOf( //
				"permutation", //
				"optional-permutation", //
				"dispatched", //
				"nested", //
				"optional", //
				"skipping", //
				"negation", //
				"lookahead", //
				"noskip", //
				"tagged", //

				with("assign").as("identifier", "=====", "rvalue"), //
				"rvalue" //
		));

		defineHelper("repeatable").as(oneOf( //
				"permutation", //
				"optional-permutation", //
				"dispatched", //
				"nested", //
				"optional", //
				"rvalue" //
		));

		defineHelper("rvalue").as(oneOf( //
				"identifier", //
				"literal", //
				"number", //
				"quoted_literal", //
				"native_code", //
				with("any").as("==_=="), //
				with("dot").as("==.==") //
				));

		// '(' sequence ('|' sequence)* ')'
		define("nested").as( //
				"==(==", alternating("sequence", "==|=="), "==)==" //
		);

		// '[' sequence ('|' sequence)* ']'
		define("optional").as( //
				"==[==", //
				oneOf(with("nested").as(alternating("sequence", "==|==")), //
						"sequence"), //
				"==]==" //
		);

		// '!' '(' sequence ('|' sequence)* ')'
		define("permutation").as("==!==", //
				"==(==", alternating("sequence", "==|=="), "==)==");

		// '!' '[' sequence ('|' sequence)* ']'
		defineHelper("optional-permutation") //
				.with("optional").with("permutation").as( //
						"==!==", //
						"==[==", alternating("sequence", "==|=="), "==]==");

		// '$' '(' dispatch ('|' dispatch)* ')'
		define("dispatched").as( //
				"==$==", "==(==", //
				"dispatch", many("==|==", "dispatch"), //
				"==)==" //
		);
		// literal '=>' sequence
		define("dispatch").as("literal", "=====", noskip("==>=="), "sequence");

		// [ limited : '---' part ' ] ( limiter: '-->' part )
		define("skipping").as(optional("limited"), "limiter");
		define("limited").as("==-==", noskip("==-==", "==-=="), "part");
		define("limiter").as("==-==", noskip("==-==", "==>=="), "part");

		// '%not' part
		define("negation").as("==%==", noskip("==not=="), "part");

		// '%at' part
		define("lookahead").as("==%==", noskip("==at=="), "part");

		// '%noskip' part
		define("noskip").as("==%==", noskip("==noskip=="), "part");

		// '%nokeywords' part
		define("nokeywords").as("==%==", noskip("==nokeywords=="));

		// @name
		define("tagged").as("==@==", noskip("name"));

		// @WORD _
		define("name").as(tagged(WORD), userDefined());

		// @WORD _
		define("type").as(tagged(WORD), userDefined());

		// @IDENTIFIER _
		define("identifier").as(tagged(IDENTIFIER), userDefined());

		// @LITERAL _
		define("literal").as(tagged(LITERAL), userDefined());

		// @QUOTED_LITERAL _
		define("quoted_literal").as(tagged(QUOTED_LITERAL), userDefined());

		// @NUMBER _
		define("number").as(tagged(NUMBER), userDefined());

		// @NATIVE_CODE _
		define("native_code").as(tagged(NATIVE_CODE_BLOCK), userDefined());
	}

	public ParserCombinator grammar() {
		return definitionOf("grammar").asParser();
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
		return "kg";
	}
}
