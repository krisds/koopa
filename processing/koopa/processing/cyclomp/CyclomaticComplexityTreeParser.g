tree grammar CyclomaticComplexityTreeParser;

options {
  tokenVocab = Cobol;
  language = Java;
  output = none;
}

@header {
  package koopa.processing.cyclomp;
  
  import koopa.util.ANTLR;
}

@members {
}

compilationGroup
  : compilationUnit*
  ;

copybook
  : paragraph*
  ;

compilationUnit
  : ^(COMPILATION_UNIT PROGRAM_NAME
      ( procedureDivision      
        compilationUnit*
      )?
    )
  ;

procedureDivision
  : ^(PROCEDURE_DIVISION

      (declaratives)?
      
      ( paragraph
      | section
      )*
    )
  ;

declaratives
  : ^(DECLARATIVES
      declarativeSection*
     )
  ;

declarativeSection returns [ int cyclomp = 1; ]
  : ^(DECLARATIVE_SECTION SECTION_NAME
      (paragraph
        { $declarativeSection.cyclomp += $paragraph.cyclomp - 1; }
      )*
      { System.out.println("# Section " + ANTLR.getText((Tree) $DECLARATIVE_SECTION) + ": " + $declarativeSection.cyclomp); }
    )
  ;

section returns [ int cyclomp = 1; ]
  : ^(SECTION SECTION_NAME
      ( statement
        { $section.cyclomp += $statement.cyclomp; }
      | paragraph
        { $section.cyclomp += $paragraph.cyclomp - 1; }
      )*
      { System.out.println("# Section " + ANTLR.getText((Tree) $SECTION_NAME) + ": " + $section.cyclomp); }
    )
  ;

paragraph returns [ int cyclomp = 1; ]
  : ^(PARAGRAPH PARAGRAPH_NAME
      (statement
        { $paragraph.cyclomp += $statement.cyclomp; }
      )*
      { System.out.println("# Paragraph " + ANTLR.getText((Tree) $PARAGRAPH_NAME) + ": " + $paragraph.cyclomp); }
    )
  ;

statement returns [ int cyclomp = 0; ]
  : ^(STATEMENT
      (nestedStatements
        { $statement.cyclomp += $nestedStatements.cyclomp + 1; }
      )*
      // { System.out.println("# Statement " + $STATEMENT + ": " + $statement.cyclomp); }
    )
  ;

nestedStatements returns [ int cyclomp = 0; ]
  : ^(NESTED_STATEMENTS 
      (statement
        { $nestedStatements.cyclomp += $statement.cyclomp; }
      )*
      // { System.out.println("# Nested statement " + $NESTED_STATEMENTS + ": " + $nestedStatements.cyclomp); }
    )
  ;
