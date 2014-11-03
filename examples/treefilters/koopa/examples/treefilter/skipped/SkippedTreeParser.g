tree grammar SkippedTreeParser;

options {
  tokenVocab = Cobol;
  language = Java;
  output = none;
}

@header {
  package koopa.examples.treefilter.skipped;
  
  import koopa.core.util.ANTLR;
}

@members {
  private int count = 0;
}

// ========================================================
// compilationGroup
// ........................................................

compilationGroup
  : skipped*
    { System.out.println("Found " + this.count + " token(s) which got skipped in this program."); }
  ;

// ========================================================
// copybook
// ........................................................

copybook
  : skipped*
    { System.out.println("Found " + this.count + " token(s) which got skipped in this copybook."); }
  ;

// ========================================================
// skipped
// ........................................................

skipped
  : WATER
    { this.count += ((Tree) $WATER).getChildCount(); }
  ;
