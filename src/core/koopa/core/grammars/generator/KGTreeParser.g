tree grammar KGTreeParser;

options {
  tokenVocab = KG;
  language = Java;
  output = none;
  ASTLabelType=CommonTree;
}

@header {
  package koopa.core.grammars.generator;
}

@members {
}

koopa
  : ^(GRAMMAR meta rule*)
  ;

meta
  : ^(META named extending?)
  ;

named
  : ^(NAMED IDENTIFIER)
  ;

extending
  : ^(EXTENDING IDENTIFIER)
  ;

rule
  : ^(RULE IDENTIFIER 
      locals?
      returning?
      body
    )
  ;

returning
  : ^(RETURNS IDENTIFIER)
  ;
  
locals
  : ^(LOCALS
      declaration+
    )
  ;

declaration
  : ^(DECLARATION IDENTIFIER IDENTIFIER)
  ;

body
  : ^(SEQUENCE 
      body+
    )
  
  | ^(ACT NATIVE_CODE)
    
  | IDENTIFIER
  
  | TAG

  | ANY

  | LITERAL
  
  | NUMBER
  
  | DOT
  
  | ^(ASSIGN IDENTIFIER (IDENTIFIER | NUMBER | DOT | ANY))
  
  | ^(STAR body)
  
  | ^(PLUS body)
  
  | ^(CHOICE
      body+
    )
    
  | ^(OPTIONAL
      body
    )
  
  | ^(SKIP_TO
      body
    )
  
  | ^(PERMUTED 
      body+
    )
  
  | ^(NOT body)

  | ^(NOSKIP body)
  
  | ^(LIMIT body body)
  ;
