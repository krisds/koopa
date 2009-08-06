tree grammar CobolOutlineTreeParser;

options {
  tokenVocab = Cobol;
  language = Java;
  output = none;
}

@header {
  package koopa.app.components.outline;
  
  import koopa.app.Icons;
  import koopa.util.ANTLR;
  
  import java.util.Stack;
  import java.util.List;
  import java.util.LinkedList;
  import javax.swing.Icon;
  import javax.swing.tree.DefaultMutableTreeNode;
}

@members {
  private static final Icon PARAGRAPH_ICON = Icons
      .getIcon("/koopa/app/resources/view_less_text.png");

  private static final Icon SECTION_ICON = Icons
      .getIcon("/koopa/app/resources/view_more_text.png");

  private static final Icon DECLARATIVES_ICON = Icons
      .getIcon("/koopa/app/resources/view_thumbnail.png");

  private static final Icon PROGRAM_ICON = Icons
      .getIcon("/koopa/app/resources/document_a4_marked.png");

  private Stack<DefaultMutableTreeNode> nodes = new Stack<DefaultMutableTreeNode>();
  
  private List<DefaultMutableTreeNode> trees = new LinkedList<DefaultMutableTreeNode>();
  
  private void push(Reference ref) {
    DefaultMutableTreeNode node = new DefaultMutableTreeNode(ref);
    if (!this.nodes.isEmpty()) {
      this.nodes.peek().add(node);
    }
    
    this.nodes.push(node);
  }
  
  private void pop() {
    DefaultMutableTreeNode node = this.nodes.pop();
    if (this.nodes.isEmpty()) {
      this.trees.add(node);
    }
  }
  
  public List<DefaultMutableTreeNode> getTrees() {
    return this.trees;
  }
}

compilationGroup
  : compilationUnit*
  ;

copybook
  : paragraph*
  ;

compilationUnit
  : ^(COMPILATION_UNIT PROGRAM_NAME
      { push(new Reference((Tree) $COMPILATION_UNIT,
                           ANTLR.getText((Tree) $PROGRAM_NAME), PROGRAM_ICON)); }

      ( procedureDivision      
        compilationUnit*
      )?
      { pop(); }
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
      { push(new Reference((Tree) $DECLARATIVES, "DECLARATIVES", DECLARATIVES_ICON)); }
      declarativeSection*
      { pop(); }
     )
  ;

declarativeSection
  : ^(DECLARATIVE_SECTION SECTION_NAME
      { push(new Reference((Tree) $DECLARATIVE_SECTION,
                           ANTLR.getText((Tree) $SECTION_NAME), SECTION_ICON)); }
      paragraph*
      { pop(); }
    )
  ;

section
  : ^(SECTION SECTION_NAME
      { push(new Reference((Tree) $SECTION,
                            ANTLR.getText((Tree) $SECTION_NAME), SECTION_ICON)); }
      paragraph*
      { pop(); }
    )
  ;

paragraph
  : ^(PARAGRAPH PARAGRAPH_NAME)
    { push(new Reference((Tree) $PARAGRAPH,
                          ANTLR.getText((Tree) $PARAGRAPH_NAME), PARAGRAPH_ICON)); }
    { pop(); }
  ;
