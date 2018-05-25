package koopa.dsl.kg.grammar;

import static koopa.core.data.tags.SyntacticTag.NUMBER;
import static koopa.core.data.tags.SyntacticTag.STRING;
import static koopa.core.data.tags.SyntacticTag.WORD;
import koopa.core.grammars.fluent.FluentGrammar;
import koopa.core.parsers.ParserCombinator;

/**
 * A grammar for defining grammars.
 * <p>
 * Check kg.stage to see a definition of itself using its own grammar.
 */
public class KGGrammar extends FluentGrammar {

	public static final String SCOPE_SEPARATOR = "$";

	@Override
	public String getNamespace() {
		return "kg";
	}

	@Override
	public boolean isCaseSensitive() {
		return true;
	}

	// ------------------------------------------------------------------------

	public KGGrammar() {
		// header rule* eof
		define("grammar").as("header", many("rule"), eof());

		// 'grammar' name ['extends' name] '.'
		define("header").as( //
				"grammar_name", //
				optional("extends"), //
				"==.==" //
		);
		define("grammar_name").as("++grammar++", "name");
		define("extends").as("++extends++", "name");

		// [modifier] 'def' [nokeywords] identifier '='
		// sequence (nested_rule)* 'end'
		define("rule").as( //
				optional("modifier"), //
				"++def++", //
				optional("nokeywords"), //
				"identifier", //
				"=====", "sequence", //
				many("nested_rule"), //
				"++end++" //
		);

		// 'where' [modifier] 'def' [nokeywords] identifier '='
		// sequence (nested_rule)* 'end'
		define("nested_rule").as( //
				"++where++", //
				optional("modifier"), //
				"++def++", //
				optional("nokeywords"), //
				"identifier", //
				"=====", "sequence", //
				many("nested_rule"), //
				"++end++" //
		);

		define("modifier").as(oneOf( //
				with("public").as("++public++"), //
				with("private").as("++private++"), //
				with("hiding").as("++hiding++")));

		define("sequence").as(oneOf( //
				with("as").as("identifier", "==:==", "sequence"), //
				oneOrMore("part") //
		));

		defineHelper("part").as(oneOf( //
				with("star").as("repeatable", "==*=="), //
				with("plus").as("repeatable", "==+==", not(noskip("==+=="))), //
				"balancing", //
				"before", //
				"upto", //
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
				"ranged", //
				"balanced", //
				"unbalanced", //
				"notempty", //
				"todo", //
				"tree", //
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
				"scoped_identifier", //
				"identifier", //
				"literal", //
				"number", //
				"quoted_literal", //
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
				with("nested").as(alternating("sequence", "==|==")), //
				"==]==" //
		);

		// '!' '(' sequence ('|' sequence)* ')'
		define("permutation").as("==!==", //
				noskip("==(=="), alternating("sequence", "==|=="), "==)==");

		// '!' '[' sequence ('|' sequence)* ']'
		defineHelper("optional-permutation") //
				.with("optional").with("permutation").as( //
						"==!==", //
						noskip("==[=="), alternating("sequence", "==|=="),
						"==]==");

		// '$' '(' dispatch ('|' dispatch)* ')'
		define("dispatched").as( //
				"==$==", noskip("==(=="), //
				alternating("dispatch", "==|=="), //
				"==)==" //
		);
		// literal '=>' sequence
		define("dispatch").as("literal", "=====", noskip("==>=="), "sequence");

		// '-->' part
		define("skipping").as("==-==", noskip("==-==", "==>=="), "part");

		// '%not' part
		define("negation").as("==%==", noskip("==not=="), "part");

		// '%at' part
		define("lookahead").as("==%==", noskip("==at=="), "part");

		// ('+' ++ '+' part)+
		define("noskip").as(oneOrMore("==+==", noskip("==+=="), "part"));

		// '%nokeywords'
		define("nokeywords").as("==%==", noskip("==nokeywords=="));

		// @ ++ name
		define("tagged").as("==@==", noskip("name"));

		// '<' ++ ( number '.' '.' number '>' )
		define("ranged").as("==<==", //
				noskip(with("begin").as(oneOf("==_==", "number")), //
						"==.==", "==.==", //
						with("end").as(oneOf("==_==", "number")), //
						"==>=="));

		// identifier
		define("name").as(notAKeyword("word"));

		// identifier
		define("type").as(notAKeyword("word"));

		// ( '`' ++ (%someLowercase word)
		// | %noKeyword (%someLowercase word) )
		define("identifier").as(oneOf(//
				// Any escaped identifier.
				all("==`==", noskip(someLowercase("word"))), //
				// Or any identifier which is not a keyword.
				notAKeyword(someLowercase("word"))));

		// %uppercase word
		define("literal").as(allUppercase("word"));

		// identifier ++ (':' ':' identifier)
		define("scoped_identifier").as( //
				"identifier", noskip("==:==", "==:==", "identifier"));

		defineHelper("word").as( //
				tagged(WORD), any(), //
				noskip(many(oneOf( //
						"==-==", //
						"==_==", //
						token(SCOPE_SEPARATOR), //
						all(tagged(WORD), any()), //
						all(tagged(NUMBER), any()) //
				))));

		// @QUOTED_LITERAL _
		define("quoted_literal").as(tagged(STRING), any());

		// @NUMBER _
		define("number").as(tagged(NUMBER), any());

		// atom '%before' part
		define("before").as("atom", "==%==", noskip("==before=="), "closure");

		// atom '%upto' part
		define("upto").as("atom", "==%==", noskip("==upto=="), "closure");

		// '{' part '}'
		define("closure").as("=={==", "sequence", "==}==");

		// '%balancing' pair+ atom
		define("balancing").as( //
				"==%==", noskip("==balancing=="), oneOrMore("pair"), "atom");
		// '(' closure closure ')'
		define("pair").as("==<==", "closure", "closure", "==>==");

		// '%nested' part
		define("balanced").as("==%==", noskip("==nested=="), "atom");

		// '%notnested' atom
		define("unbalanced").as("==%==", noskip("==notnested=="), "atom");

		// '%notempty' atom
		define("notempty").as("==%==", noskip("==notempty=="), "atom");

		// ( '<' ++([namespace ':'] word '/' '>')
		// | '<' ++([namespace ':'] word '>') part* '<' ++('/' '>')
		// )
		defineHelper("namespace").as("word");
		define("tree")
				.as(oneOf( //
						all("==<==",
								noskip(optional("namespace", "==:=="), "word",
										"==/==", "==>==")), //
						all("==<==",
								noskip(optional("namespace", "==:=="), "word",
										"==>=="), //
								many("part"), //
								"==<==", noskip("==/==", "==>=="))));

		// '...'
		define("todo").as("==.==", noskip("==.==", "==.=="));
	}

	// ------------------------------------------------------------------------

	public ParserCombinator grammar() {
		return definitionOf("grammar").asParser();
	}

	public ParserCombinator rule() {
		return definitionOf("rule").asParser();
	}

	public ParserCombinator scopedIdentifier() {
		return definitionOf("scoped_identifier").asParser();
	}

	public ParserCombinator identifier() {
		return definitionOf("identifier").asParser();
	}

	public ParserCombinator literal() {
		return definitionOf("literal").asParser();
	}

	public ParserCombinator name() {
		return definitionOf("name").asParser();
	}

	public ParserCombinator word() {
		return definitionOf("word").asParser();
	}

	public ParserCombinator tree() {
		return definitionOf("tree").asParser();
	}
}
