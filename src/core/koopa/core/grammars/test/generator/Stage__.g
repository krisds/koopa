lexer grammar Stage;

@header {
  package koopa.core.grammars.test.generator;
}

T__21 : 'grammar' ;
T__22 : 'package' ;
T__23 : 'target' ;

// $ANTLR src "src/core/koopa/core/grammars/test/generator/Stage.g" 58
COMMENT : '#' (~('\n' | '\r'))* { $channel = HIDDEN; } ;

// $ANTLR src "src/core/koopa/core/grammars/test/generator/Stage.g" 60
NEWLINE : ( ('\r\n') => '\r\n' | '\r' | '\n' ) { $channel = HIDDEN; } ;

// $ANTLR src "src/core/koopa/core/grammars/test/generator/Stage.g" 62
WHITESPACE : (' ' | '\t')+ { $channel = HIDDEN; } ;

// $ANTLR src "src/core/koopa/core/grammars/test/generator/Stage.g" 64
SEMI : ';' ;

// $ANTLR src "src/core/koopa/core/grammars/test/generator/Stage.g" 66
ACCEPT : '+' ;
// $ANTLR src "src/core/koopa/core/grammars/test/generator/Stage.g" 67
REJECT : '-' ;

// $ANTLR src "src/core/koopa/core/grammars/test/generator/Stage.g" 69
FREE_DATA : '[' (~('[' | ']'))* ']' ;
// $ANTLR src "src/core/koopa/core/grammars/test/generator/Stage.g" 70
FIXED_DATA : '{' (~('{' | '}'))* '}' ;

// $ANTLR src "src/core/koopa/core/grammars/test/generator/Stage.g" 72
IDENTIFIER : NAME ('.' NAME)* ;

// $ANTLR src "src/core/koopa/core/grammars/test/generator/Stage.g" 74
fragment NAME : LETTER ('_' | LETTER | NUMBER)*;
// $ANTLR src "src/core/koopa/core/grammars/test/generator/Stage.g" 75
fragment LETTER : 'A' .. 'Z' | 'a' .. 'z' ;
// $ANTLR src "src/core/koopa/core/grammars/test/generator/Stage.g" 76
fragment NUMBER : '0' .. '9' ;
