lexer grammar KG;

@header {
  package koopa.core.grammars.generator;
}

T__41 : 'def' ;
T__42 : 'returns' ;
T__43 : 'end' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 138
COMMENT : '#' (~('\n' | '\r'))* { $channel = HIDDEN; } ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 140
NEWLINE : ( ('\r\n') => '\r\n' | '\r' | '\n' ) { $channel = HIDDEN; } ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 142
NOSKIP : '%noskip' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 144
TAG : '@' LETTER ( LETTER | DIGIT | '-' | '_' )* ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 146
ANY : '_' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 148
IDENTIFIER : LETTER ( LETTER | DIGIT | '-' | '_' )* ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 150
LITERAL : '\'' (~('\'' | '\n' | '\r'))+ '\'';

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 152
NUMBER : DIGIT+ ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 154
WHITESPACE : (' ' | '\t')+ { $channel = HIDDEN; } ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 156
EQUALS : '=' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 158
OPEN_PAREN : '(' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 160
CLOSE_PAREN : ')' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 162
OPEN_BRACKET : '[' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 164
CLOSE_BRACKET : ']' ;

// TODO Balanced braces ?
// TODO Newlines.
// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 168
NATIVE_CODE : '{' (~ '}')* '}' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 170
STAR : '*' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 172
PLUS : '+' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 174
SKIP_TO : '-->' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 176
DOT : '.' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 178
PIPE : '|' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 180
COMMA : ',' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 182
BANG : '!' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 184
NOT : '-' ;

// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 186
fragment LETTER : 'a'..'z' | 'A'..'Z' ;
// $ANTLR src "src/core/koopa/core/grammars/generator/KG.g" 187
fragment DIGIT : '0'..'9' ;
