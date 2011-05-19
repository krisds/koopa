tree grammar KGTreeParser;

options {
  tokenVocab = KG;
  language = Java;
  output = none;
  ASTLabelType=CommonTree;
}

@header {
  package koopa.grammars.generator;
}

@members {
}

koopa
  : ^(GRAMMAR rule*)
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
  
  | LITERAL
  
  | NUMBER
  
  | DOT
  
  | ^(ASSIGN IDENTIFIER (IDENTIFIER | NUMBER | DOT))
  
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
  ;
