grammar KG;

options {
  output=AST;
  ASTLabelType=CommonTree;
} 

tokens {
  GRAMMAR;
  RULE;
  BODY;
  RETURNS;
  SEQUENCE;
  CHOICE;
  OPTIONAL;
  ACT;
  ASSIGN;
  DECLARATION;
  LOCALS;
  PERMUTED;
}

@header{
  package koopa.grammars.generator;
}

@members {
  //private boolean verifyNativeCode(Token code) {
  //  return JavaGrammarUtil.isValidJava(code.getText());
  //}
}

@lexer::header{
  package koopa.grammars.generator;
}

koopa
  : rule* EOF
  
    -> ^(GRAMMAR rule*)
  ;

rule
  : 'def' i=IDENTIFIER
      (OPEN_PAREN l=locals CLOSE_PAREN)?
      ('returns' r=IDENTIFIER)? EQUALS
  
      sequence
  
    'end'

    -> { l != null && r != null }? ^(RULE $i locals ^(RETURNS $r) sequence)
    -> { l != null && r == null }? ^(RULE $i locals sequence)
    -> { l == null && r != null }? ^(RULE $i ^(RETURNS $r) sequence)
    -> ^(RULE $i sequence)
  ;

locals
  : declaration (COMMA declaration)*

    -> ^(LOCALS declaration+)
  ;

declaration
  : IDENTIFIER IDENTIFIER

    -> ^(DECLARATION IDENTIFIER IDENTIFIER)
  ;

sequence
  : p+=part+

    -> { $p.size() > 1 }? ^(SEQUENCE part+)
    -> part+
  ;

part
  : code=NATIVE_CODE
    { // if (!verifyNativeCode(code)) {
      //	throw new RecognitionException("Not a valid java block.", code.getFilename(), code.getLine(), code.getColumn());
      // }
    }
    -> ^(ACT NATIVE_CODE)

  | LITERAL

  | NUMBER
  
  | a=IDENTIFIER 
    (e=EQUALS (b=IDENTIFIER | b=NUMBER | b=DOT))?
    
    -> { e != null }? ^(ASSIGN $a $b)
    -> IDENTIFIER

  | DOT

  | OPEN_PAREN sequence m+=more* CLOSE_PAREN (r=STAR | r=PLUS)?

    -> { r != null && m != null }? ^($r ^(CHOICE sequence more*))
    -> { r != null && m == null }? ^($r sequence)
    -> { r == null && m != null }? ^(CHOICE sequence more*)
    -> sequence

  | OPEN_BRACKET sequence m+=more* CLOSE_BRACKET (r=STAR | r=PLUS)?

    -> { r != null && m != null }? ^($r ^(OPTIONAL ^(CHOICE sequence more*)))
    -> { r != null && m == null }? ^($r ^(OPTIONAL ^(CHOICE sequence)))
    -> { r == null && m != null }? ^(OPTIONAL ^(CHOICE sequence more*))
    -> ^(OPTIONAL sequence)

  | SKIP_TO part
  
    -> ^(SKIP_TO part)
  
  | BANG OPEN_PAREN sequence m+=more* CLOSE_PAREN
    
    -> { m == null }? ^(OPTIONAL sequence)
    -> ^(PERMUTED sequence more*)
  
  | NOT part
    -> ^(NOT part)
  ;

more
  : PIPE sequence
  
    -> sequence
  ;
  
COMMENT : '#' (~('\n' | '\r'))* { $channel = HIDDEN; } ;

NEWLINE : ( ('\r\n') => '\r\n' | '\r' | '\n' ) { $channel = HIDDEN; } ;

IDENTIFIER : LETTER ( LETTER | DIGIT | '-' | '_' )* ;

LITERAL : '\'' (~('\'' | '\n' | '\r'))+ '\'';

NUMBER : DIGIT+ ;

WHITESPACE : (' ' | '\t')+ { $channel = HIDDEN; } ;

EQUALS : '=' ;

OPEN_PAREN : '(' ;

CLOSE_PAREN : ')' ;

OPEN_BRACKET : '[' ;

CLOSE_BRACKET : ']' ;

// TODO Balanced braces ?
// TODO Newlines.
NATIVE_CODE : '{' (~ '}')* '}' ;

STAR : '*' ;

PLUS : '+' ;

SKIP_TO : '-->' ;

DOT : '.' ;

PIPE : '|' ;

COMMA : ',' ;

BANG : '!' ;

NOT : '-' ;

fragment LETTER : 'a'..'z' | 'A'..'Z' ;
fragment DIGIT : '0'..'9' ;
