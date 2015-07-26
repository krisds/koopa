package koopa.examples.treegrammars;

import koopa.core.parsers.Parse;
import koopa.core.parsers.combinators.Block;
import koopa.core.treegrammars.TreeGrammar;
import koopa.core.treeparsers.FutureTreeParser;
import koopa.core.treeparsers.TreeParser;

import koopa.examples.treegrammars.CobolStructureBaseGrammar;
import koopa.core.trees.Tree;

public class CobolStructureTreeGrammar extends CobolStructureBaseGrammar {
    public CobolStructureTreeGrammar() {
    }
    
    // ========================================================
    // compilationGroup
    // ........................................................
    
    private TreeParser compilationGroupParser = null;
    
    public TreeParser compilationGroup() {
      if (compilationGroupParser == null) {
        FutureTreeParser future = scoped("compilationGroup");
        compilationGroupParser = future;
        future.setParser(
          sequence(
            compilationUnit(),
            apply(new Block() {
              public void apply(Parse parse) {
                { reportWordFrequencies(); }
              }
            })
          )
        );
      }
    
      return compilationGroupParser;
    }
    
    // ========================================================
    // compilationUnit
    // ........................................................
    
    private TreeParser compilationUnitParser = null;
    
    public TreeParser compilationUnit() {
      if (compilationUnitParser == null) {
        FutureTreeParser future = scoped("compilationUnit");
        compilationUnitParser = future;
        future.setParser(
          sequence(
            programName(),
            star(
              section()
            ),
            star(
              paragraph()
            )
          )
        );
      }
    
      return compilationUnitParser;
    }
    
    // ========================================================
    // section
    // ........................................................
    
    private TreeParser sectionParser = null;
    
    public TreeParser section() {
      if (sectionParser == null) {
        FutureTreeParser future = scoped("section");
        sectionParser = future;
        future.setParser(
          sequence(
            assign("name",
              sectionName()
            ),
            apply(new Block() {
              public void apply(Parse parse) {
                String name = (String) scope.get("name");
                { process("SECTION", name); }
                scope.set("name", name);
              }
            }),
            star(
              paragraph()
            )
          )
        );
      }
    
      return sectionParser;
    }
    
    // ========================================================
    // paragraph
    // ........................................................
    
    private TreeParser paragraphParser = null;
    
    public TreeParser paragraph() {
      if (paragraphParser == null) {
        FutureTreeParser future = scoped("paragraph");
        paragraphParser = future;
        future.setParser(
          sequence(
            assign("t",
              paragraphName()
            ),
            apply(new Block() {
              public void apply(Parse parse) {
                Tree t = (Tree) scope.get("t");
                { process("PARAGRAPH", t.getProgramText()); }
                scope.set("t", t);
              }
            })
          )
        );
      }
    
      return paragraphParser;
    }
    
    // ========================================================
    // programName
    // ........................................................
    
    private TreeParser programNameParser = null;
    
    public TreeParser programName() {
      if (programNameParser == null) {
        FutureTreeParser future = scoped("programName");
        programNameParser = future;
        future.setParser(
          sequence(
            assign("t",
              any()
            ),
            apply(new Block() {
              public void apply(Parse parse) {
                Tree t = (Tree) scope.get("t");
                { process("PROGRAM", t.getProgramText()); }
                scope.set("t", t);
              }
            })
          )
        );
      }
    
      return programNameParser;
    }
    
    // ========================================================
    // sectionName
    // ........................................................
    
    private TreeParser sectionNameParser = null;
    
    public TreeParser sectionName() {
      if (sectionNameParser == null) {
        FutureTreeParser future = scoped("sectionName");
        sectionNameParser = future;
        future.setParser(
          sequence(
            assign("t",
              any()
            ),
            apply(new Block() {
              public void apply(Parse parse) {
                Tree t = (Tree) scope.get("t");
                String name = (String) scope.get("name");
                { name = t.getProgramText(); }
                scope.set("t", t);
                scope.set("name", name);
              }
            }),
            returning("name")
          )
        );
      }
    
      return sectionNameParser;
    }
    
    // ========================================================
    // paragraphName
    // ........................................................
    
    private TreeParser paragraphNameParser = null;
    
    public TreeParser paragraphName() {
      if (paragraphNameParser == null) {
        FutureTreeParser future = scoped("paragraphName");
        paragraphNameParser = future;
        future.setParser(
          any()
        );
      }
    
      return paragraphNameParser;
    }
    
}
