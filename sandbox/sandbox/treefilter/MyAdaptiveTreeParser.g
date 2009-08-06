tree grammar MyAdaptiveTreeParser;

options {
  tokenVocab = Cobol;
  language = Java;
  output = none;
}

@header {
  package sandbox.treefilter;
  
  import koopa.util.ANTLR;
}

// ========================================================
// compilationGroup
// ........................................................

compilationGroup
  : { System.out.println("# Adaptive Tree Parser going for a compilationGroup."); }
    compilationUnit*
    { System.out.println("# Adaptive Tree Parser gone for a compilationGroup."); }
  ;

// ========================================================
// copybook
// ........................................................

copybook
  : { System.out.println("# Adaptive Tree Parser going for a copybook."); }
    paragraph*
    { System.out.println("# Adaptive Tree Parser gone for a copybook."); }
  ;

// ========================================================
// compilationUnit
// ........................................................

compilationUnit
  : ^(COMPILATION_UNIT
      PROGRAM_NAME
      { System.out.println("# Program " + ANTLR.getText((Tree) $PROGRAM_NAME)); }
      
      ( FILE_SECTION
        { System.out.println("# Found a file section."); }
      )?
      
      ( 'FILLER'
        { System.out.println("# Found FILLER data."); }
      )?
      
      (declaratives)?
      
      ( paragraph
      | section
      )*
      
      (compilationUnit)*
    )
  ;

// ========================================================
// declaratives
// ........................................................

declaratives
  : ^(DECLARATIVES SECTION_NAME*)
  ;

// ========================================================
// section
// ........................................................

section
  : ^(SECTION SECTION_NAME
      { System.out.println("# Section " + ANTLR.getText((Tree) $SECTION_NAME)); }  
      paragraph*
    )
  ;

// ========================================================
// paragraph
// ........................................................

paragraph
  : ^(PARAGRAPH PARAGRAPH_NAME)
    { System.out.println("# Paragraph " + ANTLR.getText((Tree) $PARAGRAPH_NAME)); }  
  ;
