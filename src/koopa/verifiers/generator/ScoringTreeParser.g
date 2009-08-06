tree grammar ScoringTreeParser;

options {
  tokenVocab = Scoring;
  language = Java;
  output = none;
  ASTLabelType=CommonTree;
}

@header{
  package koopa.verifiers.generator;
}

scoring
  : ^(SCORING verification*)
  ;

verification
  : ^(VERIFICATION IDENTIFIER assertion*)
  ;

assertion
  : ^(ACCEPT sequence response)
  | ^(REJECT sequence response)
  ;

sequence
  : ^(SEQUENCE part+)
  ;

part
  : IDENTIFIER
  | ^(BANG IDENTIFIER)
  ;

response
  : ^(WARN STRING_LITERAL)
  | ^(ERROR STRING_LITERAL)
  ;
