grammar Stage;

options {
  output=AST;
  ASTLabelType=CommonTree;
}

tokens {
  STAGE;
  GRAMMAR;
  PACKAGE;
  TARGET;
  TEST;
}

@header{
  package koopa.grammars.test.generator;
}

@lexer::header{
  package koopa.grammars.test.generator;
}

stage
  : packageDeclaration
    grammarDeclaration
    testsForGrammarRule*
    EOF

    -> ^(STAGE packageDeclaration grammarDeclaration testsForGrammarRule*)
  ;

grammarDeclaration
  : 'grammar' IDENTIFIER SEMI

    -> ^(GRAMMAR IDENTIFIER)
  ;

packageDeclaration
  : 'package' IDENTIFIER SEMI

    -> ^(PACKAGE IDENTIFIER)
  ;

testsForGrammarRule
  : 'target' IDENTIFIER SEMI
    testcase*

    -> ^(TARGET IDENTIFIER testcase*)
  ;

testcase
  : (t=ACCEPT | t=REJECT) CDATA

    -> ^(TEST $t CDATA)
  ;

COMMENT : '#' (~('\n' | '\r'))* { $channel = HIDDEN; } ;

NEWLINE : ( ('\r\n') => '\r\n' | '\r' | '\n' ) { $channel = HIDDEN; } ;

WHITESPACE : (' ' | '\t')+ { $channel = HIDDEN; } ;

SEMI : ';' ;

ACCEPT : '+' ;
REJECT : '-' ;

CDATA : '[' (~('[' | ']'))* ']' ;

IDENTIFIER : NAME ('.' NAME)* ;

fragment NAME : LETTER ('_' | LETTER | NUMBER)*;
fragment LETTER : 'A' .. 'Z' | 'a' .. 'z' ;
fragment NUMBER : '0' .. '9' ;
