package koopa.app.components.outline;

import koopa.core.parsers.Parse;
import koopa.core.parsers.combinators.Block;
import koopa.core.treegrammars.TreeGrammar;
import koopa.core.treeparsers.FutureTreeParser;
import koopa.core.treeparsers.TreeParser;

import koopa.core.trees.Tree;
import koopa.app.components.outline.CobolOutlineBaseGrammar;

public class CobolOutlineTreeGrammar extends CobolOutlineBaseGrammar {
    public CobolOutlineTreeGrammar() {
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
          star(
            sourceUnit()
          )
        );
      }
    
      return compilationGroupParser;
    }
    
    // ========================================================
    // copybook
    // ........................................................
    
    private TreeParser copybookParser = null;
    
    public TreeParser copybook() {
      if (copybookParser == null) {
        FutureTreeParser future = scoped("copybook");
        copybookParser = future;
        future.setParser(
          sequence(
            star(
              paragraph()
            ),
            star(
              section()
            ),
            star(
              sourceUnit()
            )
          )
        );
      }
    
      return copybookParser;
    }
    
    // ========================================================
    // sourceUnit
    // ........................................................
    
    private TreeParser sourceUnitParser = null;
    
    public TreeParser sourceUnit() {
      if (sourceUnitParser == null) {
        FutureTreeParser future = scoped("sourceUnit");
        sourceUnitParser = future;
        future.setParser(
          sequence(
            assign("name",
              programName()
            ),
            apply(new Block() {
              public void apply(Parse parse) {
                Tree name = (Tree) scope.get("name");
                { push(new Reference(getCurrentTree(), name.getProgramText(), PROGRAM_ICON)); }
                scope.set("name", name);
              }
            }),
            optional(
              declaratives()
            ),
            limited(
              star(
                paragraph()
              ),
              section()
            ),
            star(
              section()
            ),
            star(
              paragraph()
            ),
            apply(new Block() {
              public void apply(Parse parse) {
                Tree name = (Tree) scope.get("name");
                { pop(); }
                scope.set("name", name);
              }
            })
          )
        );
      }
    
      return sourceUnitParser;
    }
    
    // ========================================================
    // declaratives
    // ........................................................
    
    private TreeParser declarativesParser = null;
    
    public TreeParser declaratives() {
      if (declarativesParser == null) {
        FutureTreeParser future = scoped("declaratives");
        declarativesParser = future;
        future.setParser(
          sequence(
            apply(new Block() {
              public void apply(Parse parse) {
                { push(new Reference(getCurrentTree(), "DECLARATIVES", DECLARATIVES_ICON)); }
              }
            }),
            star(
              declarativeSection()
            ),
            apply(new Block() {
              public void apply(Parse parse) {
                { pop(); }
              }
            })
          )
        );
      }
    
      return declarativesParser;
    }
    
    // ========================================================
    // declarativeSection
    // ........................................................
    
    private TreeParser declarativeSectionParser = null;
    
    public TreeParser declarativeSection() {
      if (declarativeSectionParser == null) {
        FutureTreeParser future = scoped("declarativeSection");
        declarativeSectionParser = future;
        future.setParser(
          sequence(
            assign("name",
              sectionName()
            ),
            apply(new Block() {
              public void apply(Parse parse) {
                Tree name = (Tree) scope.get("name");
                { push(new Reference(getCurrentTree(), name.getProgramText(), SECTION_ICON)); }
                scope.set("name", name);
              }
            }),
            star(
              paragraph()
            ),
            apply(new Block() {
              public void apply(Parse parse) {
                Tree name = (Tree) scope.get("name");
                { pop(); }
                scope.set("name", name);
              }
            })
          )
        );
      }
    
      return declarativeSectionParser;
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
                Tree name = (Tree) scope.get("name");
                { push(new Reference(getCurrentTree(), name.getProgramText(), SECTION_ICON)); }
                scope.set("name", name);
              }
            }),
            star(
              paragraph()
            ),
            apply(new Block() {
              public void apply(Parse parse) {
                Tree name = (Tree) scope.get("name");
                { pop(); }
                scope.set("name", name);
              }
            })
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
            assign("name",
              paragraphName()
            ),
            apply(new Block() {
              public void apply(Parse parse) {
                Tree name = (Tree) scope.get("name");
                { push(new Reference(getCurrentTree(), name.getProgramText(), PARAGRAPH_ICON)); pop(); }
                scope.set("name", name);
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
          any()
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
          any()
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
