tree grammar StageTreeParser;

options {
  tokenVocab = Stage;
  language = Java;
  output = none;
  ASTLabelType=CommonTree;
}

@header{
  package koopa.core.grammars.test.generator;
}

stage
  : ^(STAGE pack grammah tokenizer testsForGrammarRule*)
  ;
  
pack
  : ^(PACKAGE IDENTIFIER)
  ;

grammah
  : ^(GRAMMAR IDENTIFIER)
  ;

tokenizer
  : ^(TOKENIZER IDENTIFIER)
  ;

testsForGrammarRule
  : ^(TARGET IDENTIFIER test*)
  ;
  
test
  : ^(TEST (ACCEPT | REJECT) DATA)
  ;
