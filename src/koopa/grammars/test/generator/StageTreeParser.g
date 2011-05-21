tree grammar StageTreeParser;

options {
  tokenVocab = Stage;
  language = Java;
  output = none;
  ASTLabelType=CommonTree;
}

@header{
  package koopa.grammars.test.generator;
}

stage
  : ^(STAGE pack grammah testsForGrammarRule*)
  ;
  
pack
  : ^(PACKAGE IDENTIFIER)
  ;

grammah
  : ^(GRAMMAR IDENTIFIER)
  ;

testsForGrammarRule
  : ^(TARGET IDENTIFIER test*)
  ;
  
test
  : ^(TEST (ACCEPT | REJECT) (FREE_DATA | FIXED_DATA))
  ;
