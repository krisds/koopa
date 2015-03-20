grammar KG;

options {
  output=AST;
  ASTLabelType=CommonTree;
} 

tokens {
  GRAMMAR;
  META;
  TREE;
  NAMED;
  EXTENDING;
  RULE;
  BODY;
  RETURNS;
  SEQUENCE;
  CHOICE;
  DISPATCHED;
  CASE;
  OPTIONAL;
  ACT;
  ASSIGN;
  DECLARATION;
  LOCALS;
  PERMUTED;
}

@header{
  package koopa.core.grammars.generator;
}

@members {
  //private boolean verifyNativeCode(Token code) {
  //  return JavaGrammarUtil.isValidJava(code.getText());
  //}
}

@lexer::header{
  package koopa.core.grammars.generator;
}

koopa
  : meta
  
    rule* EOF
  
    -> ^(GRAMMAR meta rule*)
  ;

meta
  : (t='tree')? 'grammar' n=IDENTIFIER
    ('extends' s=IDENTIFIER)?
    DOT
    
    -> { t == null && s == null }? ^(META ^(NAMED $n))
    -> { t == null && s != null }? ^(META ^(NAMED $n) ^(EXTENDING $s))
    -> { t != null && s == null }? ^(META TREE ^(NAMED $n))
    -> ^(META TREE ^(NAMED $n) ^(EXTENDING $s))
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

  | TAG

  | ANY

  | LITERAL

  | NUMBER
  
  | a=IDENTIFIER 
    (e=EQUALS (b=IDENTIFIER | b=NUMBER | b=DOT | b=ANY))?
    
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
  
  | BANG OPEN_BRACKET sequence m+=more* CLOSE_BRACKET
    
    -> { m == null }? ^(OPTIONAL sequence)
    -> ^(OPTIONAL ^(PERMUTED sequence more*))
  
  | BANG OPEN_PAREN sequence m+=more* CLOSE_PAREN
    
    -> { m == null }? sequence
    -> ^(PERMUTED sequence more*)
  
  | DOLLAR OPEN_PAREN dispatch m+=more_dispatch* CLOSE_PAREN
    
    -> { m == null }? ^(DISPATCHED dispatch)
    -> ^(DISPATCHED dispatch more_dispatch*)
  
  | NOT part
    -> ^(NOT part)

  | NOSKIP part
  -> ^(NOSKIP part)

  | LIMIT part BY part
  -> ^(LIMIT part part)

  | WITH p=part SKIP_TO q=part
  -> ^(SEQUENCE
       ^(LIMIT $p $q)
       ^(SKIP_TO $q))
  ;

more
  : PIPE sequence
  
    -> sequence
  ;
  
dispatch
  : IDENTIFIER ARROW sequence
  
    -> ^(CASE IDENTIFIER sequence)
  ;
  
more_dispatch
  : PIPE dispatch
  
    -> dispatch
  ;


COMMENT : '#' (~('\n' | '\r'))* { $channel = HIDDEN; } ;

NEWLINE : ( ('\r\n') => '\r\n' | '\r' | '\n' ) { $channel = HIDDEN; } ;

NOSKIP : '%noskip' ;

LIMIT : '%limit' ;

BY : '%by' ;

ARROW : '=>' ;

TAG : '@' LETTER ( LETTER | DIGIT | '-' | '_' )* ;

ANY : '_' ;

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

WITH : '---' ;
SKIP_TO : '-->' ;

DOT : '.' ;

PIPE : '|' ;

COMMA : ',' ;

BANG : '!' ;

DOLLAR : '$' ;

NOT : '-' ;

fragment LETTER : 'a'..'z' | 'A'..'Z' ;
fragment DIGIT : '0'..'9' ;
