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
  : (t='tree')? 'grammar' n=name
    ('extends' s=name)?
    DOT
    
    -> { t == null && s == null }? ^(META      ^(NAMED $n)                )
    -> { t == null && s != null }? ^(META      ^(NAMED $n) ^(EXTENDING $s))
    -> { t != null && s == null }? ^(META TREE ^(NAMED $n)                )
    ->                             ^(META TREE ^(NAMED $n) ^(EXTENDING $s))
  ;

name
  : IDENTIFIER -> IDENTIFIER
  | TOKEN      -> TOKEN
  ;

modifier
  : PUBLIC     -> PUBLIC
  | PRIVATE    -> PRIVATE
  ;

rule
  : (v=modifier)? 'def' i=IDENTIFIER
      (OPEN_PAREN l=locals CLOSE_PAREN)?
      ('returns' r=IDENTIFIER)? EQUALS
  
      sequence
  
    'end'

    -> { v != null && l != null && r != null }? ^(RULE $v $i locals ^(RETURNS $r) sequence)
    -> { v != null && l != null && r == null }? ^(RULE $v $i locals sequence)
    
    -> { v != null && l == null && r != null }? ^(RULE $v $i ^(RETURNS $r) sequence)
    -> { v != null && l == null && r == null }? ^(RULE $v $i sequence)
    
    -> { v == null && l != null && r != null }? ^(RULE PUBLIC $i locals ^(RETURNS $r) sequence)
    -> { v == null && l != null && r == null }? ^(RULE PUBLIC $i locals sequence)
    
    -> { v == null && l == null && r != null }? ^(RULE PUBLIC $i ^(RETURNS $r) sequence)
    ->                                          ^(RULE PUBLIC $i sequence)
  ;

locals
  : declaration (COMMA declaration)*

    -> ^(LOCALS declaration+)
  ;

declaration
  : type=name n=name

    -> ^(DECLARATION $type $n)
  ;

sequence
  : (i=IDENTIFIER COLON)? p+=part+
  
    -> { i != null && $p.size() > 1  }? ^(AS $i ^(SEQUENCE part+))
    -> { i != null && $p.size() == 1 }? ^(AS $i            part+ )
    -> { i == null && $p.size() > 1  }?         ^(SEQUENCE part+)
    ->                                                     part+
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
    (e=EQUALS (b=IDENTIFIER | b=TOKEN | b=NUMBER | b=DOT | b=ANY))?
    
    -> { e != null }? ^(ASSIGN $a $b)
    -> IDENTIFIER
  
  | TOKEN

  | DOT

  | OPEN_PAREN sequence m+=more* CLOSE_PAREN (r=STAR | r=PLUS)?

    -> { r != null && m != null }? ^($r ^(CHOICE sequence more*))
    -> { r != null && m == null }? ^($r          sequence       )
    -> { r == null && m != null }?      ^(CHOICE sequence more*)
    ->                                           sequence

  | OPEN_BRACKET sequence m+=more* CLOSE_BRACKET (r=STAR | r=PLUS)?

    -> { r != null && m != null }? ^($r ^(OPTIONAL ^(CHOICE sequence more*)))
    -> { r != null && m == null }? ^($r ^(OPTIONAL ^(CHOICE sequence      )))
    -> { r == null && m != null }?      ^(OPTIONAL ^(CHOICE sequence more*))
    ->                                  ^(OPTIONAL          sequence       )

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
  : TOKEN ARROW sequence
  
    -> ^(CASE TOKEN sequence)
  ;
  
more_dispatch
  : PIPE dispatch
  
    -> dispatch
  ;


COMMENT : '#' (~('\n' | '\r'))* { $channel = HIDDEN; } ;

NEWLINE : ( ('\r\n') => '\r\n' | '\r' | '\n' ) { $channel = HIDDEN; } ;

PRIVATE : 'private' ;
PUBLIC  : 'public'  ;

NOSKIP  : '%noskip' ;
LIMIT   : '%limit'  ;
BY      : '%by'     ;
AS      : '%as'     ;
NOT     : '%not'    ;

ARROW   : '=>'      ;

TAG : '@' LETTER ( LETTER | DIGIT | '-' | '_' )* ;

ANY : '_' ;

IDENTIFIER : LOWERCASE ( LETTER | DIGIT | '-' | '_' )* ;
TOKEN      : UPPERCASE ( LETTER | DIGIT | '-' | '_' )* ;

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

COLON : ':' ;

fragment LETTER    : LOWERCASE | UPPERCASE ;
fragment LOWERCASE : 'a'..'z' ;
fragment UPPERCASE : 'A'..'Z' ;
fragment DIGIT     : '0'..'9' ;
