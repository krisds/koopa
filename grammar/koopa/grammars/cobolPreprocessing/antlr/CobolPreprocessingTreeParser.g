tree grammar CobolPreprocessingTreeParser;

options {
  tokenVocab = CobolPreprocessing;
  language = Java;
  output = none;
}

@header {
  package koopa.grammars.cobolPreprocessing.antlr;
}

// ========================================================
// preprocessing
// ........................................................

preprocessing
  : ^(PREPROCESSING
      ( ( (water)?
        preprocessingDirective
      ) )*
    )
  ;

// ========================================================
// preprocessingDirective
// ........................................................

preprocessingDirective
  : ^(PREPROCESSING_DIRECTIVE
      copyStatement
    )
  ;

// ========================================================
// copyStatement
// ........................................................

copyStatement
  : ^(COPY_STATEMENT
      ( 'COPY'
        textName
        ( ( ( 'OF'
        | 'IN'
        )
          libraryName
        ) )?
        ( 'SUPPRESS' )?
        ( copyReplacingPhrase )?
        '.'
      )
    )
  ;

// ========================================================
// copyReplacingPhrase
// ........................................................

copyReplacingPhrase
  : ^(COPY_REPLACING_PHRASE
      ( 'REPLACING'
        ( copyReplacementInstruction )+
      )
    )
  ;

// ========================================================
// copyReplacementInstruction
// ........................................................

copyReplacementInstruction
  : ^(COPY_REPLACEMENT_INSTRUCTION
      ( copyOperandName
        'BY'
        copyOperandName
      )
    )
  ;

// ========================================================
// copyOperandName
// ........................................................

copyOperandName
  : ^(COPY_OPERAND_NAME
      ( pseudoLiteral
      | literal
      | cobolWord
      )
    )
  ;

// ========================================================
// textName
// ........................................................

textName
  : ^(TEXT_NAME
      ( cobolWord
      | alphanumeric
      )
    )
  ;

// ========================================================
// libraryName
// ........................................................

libraryName
  : ^(LIBRARY_NAME
      cobolWord
    )
  ;

// ========================================================
// literal
// ........................................................

literal
  : ^(LITERAL
      ( numeric
      | alphanumeric
      )
    )
  ;

// ========================================================
// numeric
// ........................................................

numeric
  : ^(NUMERIC
      ( integer
      | decimal
      | hexadecimal
      )
    )
  ;

// ========================================================

water
  : ^(WATER token*)
  ;

token
  : TOKEN
  | '.'
  | 'BY'
  | 'COPY'
  | 'IN'
  | 'OF'
  | 'REPLACING'
  | 'SUPPRESS'
  ;

// ========================================================

cobolWord
  : ^(COBOL_WORD token)
  ;

integer
  : ^(INTEGER token)
  ;

decimal
  : ^(DECIMAL token)
  ;

hexadecimal
  : ^(HEXADECIMAL token)
  ;

alphanumeric
  : ^(ALPHANUMERIC token)
  ;

pictureString
  : ^(PICTURE_STRING token+)
  ;

levelNumber
  : ^(LEVEL_NUMBER token)
  ;

pseudoLiteral
  : ^(PSEUDO_LITERAL token)
  ;
