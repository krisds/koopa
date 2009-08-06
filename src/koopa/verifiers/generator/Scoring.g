grammar Scoring;

options {
  output=AST;
  ASTLabelType=CommonTree;
}

tokens {
  SCORING;
  VERIFICATION;
  ACCEPT;
  REJECT;
  SEQUENCE;
  WARN;
  ERROR;
}

@header{
  package koopa.verifiers.generator;
}

//@members {
//}

@lexer::header{
  package koopa.verifiers.generator;
}

scoring
  : verification* EOF
  
    -> ^(SCORING verification*)
  ;

verification
  : 'verify' IDENTIFIER
    assertion*
    
    -> ^(VERIFICATION IDENTIFIER assertion*)
  ;

assertion
  : '+' sequence COLON response
  
  -> ^(ACCEPT sequence response)

  | '-' sequence COLON response

  -> ^(REJECT sequence response)
  ;

sequence
  : part+
  
  -> ^(SEQUENCE part+)
  ;

part
  : IDENTIFIER
  
  -> IDENTIFIER
  
  | BANG IDENTIFIER
  
  -> ^(BANG IDENTIFIER)
  ;

response
  : 'warn' STRING_LITERAL
  
  -> ^(WARN STRING_LITERAL)

  | 'error' STRING_LITERAL
  
  -> ^(ERROR STRING_LITERAL)
  ;


COMMENT : '#' (~('\n' | '\r'))* { $channel = HIDDEN; } ;

NEWLINE : ( ('\r\n') => '\r\n' | '\r' | '\n' ) { $channel = HIDDEN; } ;

IDENTIFIER : LETTER ( LETTER | DIGIT | '-' | '_' )* ;

STRING_LITERAL : '\"' (~('\'' | '\n' | '\r'))+ '\"';

NUMBER : DIGIT+ ;

WHITESPACE : (' ' | '\t')+ { $channel = HIDDEN; } ;

COLON : ':' ;

PLUS : '+' ;

MINUS : '-' ;

BANG : '!' ;

fragment LETTER : 'a'..'z' | 'A'..'Z' ;
fragment DIGIT : '0'..'9' ;
