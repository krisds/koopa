grammar Stage;

options {
  output=AST;
  ASTLabelType=CommonTree;
}

tokens {
  STAGE;
  PACKAGE;
  GRAMMAR;
  TOKENIZER;
  TARGET;
  TEST;
}

@header{
  package koopa.core.grammars.test.generator;
}

@lexer::header{
  package koopa.core.grammars.test.generator;
}

stage
  : packageDeclaration
    grammarDeclaration
    tokenizerDeclaration
    testsForGrammarRule*
    EOF

    -> ^(STAGE packageDeclaration grammarDeclaration tokenizerDeclaration testsForGrammarRule*)
  ;

grammarDeclaration
  : 'grammar' IDENTIFIER SEMI

    -> ^(GRAMMAR IDENTIFIER)
  ;

packageDeclaration
  : 'package' IDENTIFIER SEMI

    -> ^(PACKAGE IDENTIFIER)
  ;

tokenizerDeclaration
  : 'tokenizer' IDENTIFIER SEMI

    -> ^(TOKENIZER IDENTIFIER)
  ;

testsForGrammarRule
  : 'target' IDENTIFIER SEMI
    testcase*

    -> ^(TARGET IDENTIFIER testcase*)
  ;

testcase
  : (t=ACCEPT | t=REJECT) d=DATA

    -> ^(TEST $t $d)
  ;

COMMENT : '#' (~('\n' | '\r'))* { $channel = HIDDEN; } ;

NEWLINE : ( ('\r\n') => '\r\n' | '\r' | '\n' ) { $channel = HIDDEN; } ;

WHITESPACE : (' ' | '\t')+ { $channel = HIDDEN; } ;

SEMI : ';' ;

ACCEPT : '+' ;
REJECT : '-' ;

DATA : '[' (~('[' | ']'))* ']' ;

IDENTIFIER : NAME ('.' NAME)* ;

fragment NAME : LETTER ('_' | LETTER | NUMBER)*;
fragment LETTER : 'A' .. 'Z' | 'a' .. 'z' ;
fragment NUMBER : '0' .. '9' ;
