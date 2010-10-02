package koopa.processing.cyclomp;

import koopa.trees.antlr.filter.Filter;
import koopa.trees.antlr.filter.FutureFilter;
import koopa.trees.antlr.filter.TreeNodeStreamFilter;

public class CyclomaticComplexityTreeParserFilter extends TreeNodeStreamFilter {

    // ========================================================
    // Compiled filter rules. These were generated from the
    // grammar.
    // --------------------------------------------------------

    // ========================================================
    // compilationGroup
    // ........................................................

    private Filter compilationGroupFilter = null;

    public Filter compilationGroup() {
        if (compilationGroupFilter == null) {
           FutureFilter future = new FutureFilter();
           compilationGroupFilter = future;
           future.setFilter(
               star(
                   compilationUnit()
               )
           );
        }
        
        return compilationGroupFilter;
    }

    // ========================================================
    // copybook
    // ........................................................

    private Filter copybookFilter = null;

    public Filter copybook() {
        if (copybookFilter == null) {
           FutureFilter future = new FutureFilter();
           copybookFilter = future;
           future.setFilter(
               star(
                   paragraph()
               )
           );
        }
        
        return copybookFilter;
    }

    // ========================================================
    // compilationUnit
    // ........................................................

    private Filter compilationUnitFilter = null;

    public Filter compilationUnit() {
        if (compilationUnitFilter == null) {
           FutureFilter future = new FutureFilter();
           compilationUnitFilter = future;
           future.setFilter(
               tree(CyclomaticComplexityTreeParser.COMPILATION_UNIT,
                   seq(
                       node(CyclomaticComplexityTreeParser.PROGRAM_NAME),
                       opt(
                           seq(
                               procedureDivision(),
                               star(
                                   compilationUnit()
                               )
                           )
                       )
                   )
               )
           );
        }
        
        return compilationUnitFilter;
    }

    // ========================================================
    // procedureDivision
    // ........................................................

    private Filter procedureDivisionFilter = null;

    public Filter procedureDivision() {
        if (procedureDivisionFilter == null) {
           FutureFilter future = new FutureFilter();
           procedureDivisionFilter = future;
           future.setFilter(
               tree(CyclomaticComplexityTreeParser.PROCEDURE_DIVISION,
                   seq(
                       opt(
                           declaratives()
                       ),
                       star(
                           or(
                               paragraph(),
                               section()
                           )
                       )
                   )
               )
           );
        }
        
        return procedureDivisionFilter;
    }

    // ========================================================
    // declaratives
    // ........................................................

    private Filter declarativesFilter = null;

    public Filter declaratives() {
        if (declarativesFilter == null) {
           FutureFilter future = new FutureFilter();
           declarativesFilter = future;
           future.setFilter(
               tree(CyclomaticComplexityTreeParser.DECLARATIVES,
                   seq(
                       star(
                           declarativeSection()
                       )
                   )
               )
           );
        }
        
        return declarativesFilter;
    }

    // ========================================================
    // declarativeSection
    // ........................................................

    private Filter declarativeSectionFilter = null;

    public Filter declarativeSection() {
        if (declarativeSectionFilter == null) {
           FutureFilter future = new FutureFilter();
           declarativeSectionFilter = future;
           future.setFilter(
               tree(CyclomaticComplexityTreeParser.DECLARATIVE_SECTION,
                   seq(
                       node(CyclomaticComplexityTreeParser.SECTION_NAME),
                       star(
                           paragraph()
                       )
                   )
               )
           );
        }
        
        return declarativeSectionFilter;
    }

    // ========================================================
    // section
    // ........................................................

    private Filter sectionFilter = null;

    public Filter section() {
        if (sectionFilter == null) {
           FutureFilter future = new FutureFilter();
           sectionFilter = future;
           future.setFilter(
               tree(CyclomaticComplexityTreeParser.SECTION,
                   seq(
                       node(CyclomaticComplexityTreeParser.SECTION_NAME),
                       star(
                           or(
                               statement(),
                               paragraph()
                           )
                       )
                   )
               )
           );
        }
        
        return sectionFilter;
    }

    // ========================================================
    // paragraph
    // ........................................................

    private Filter paragraphFilter = null;

    public Filter paragraph() {
        if (paragraphFilter == null) {
           FutureFilter future = new FutureFilter();
           paragraphFilter = future;
           future.setFilter(
               tree(CyclomaticComplexityTreeParser.PARAGRAPH,
                   seq(
                       node(CyclomaticComplexityTreeParser.PARAGRAPH_NAME),
                       star(
                           statement()
                       )
                   )
               )
           );
        }
        
        return paragraphFilter;
    }

    // ========================================================
    // statement
    // ........................................................

    private Filter statementFilter = null;

    public Filter statement() {
        if (statementFilter == null) {
           FutureFilter future = new FutureFilter();
           statementFilter = future;
           future.setFilter(
               tree(CyclomaticComplexityTreeParser.STATEMENT,
                   seq(
                       star(
                           nestedStatements()
                       )
                   )
               )
           );
        }
        
        return statementFilter;
    }

    // ========================================================
    // nestedStatements
    // ........................................................

    private Filter nestedStatementsFilter = null;

    public Filter nestedStatements() {
        if (nestedStatementsFilter == null) {
           FutureFilter future = new FutureFilter();
           nestedStatementsFilter = future;
           future.setFilter(
               tree(CyclomaticComplexityTreeParser.NESTED_STATEMENTS,
                   seq(
                       star(
                           statement()
                       )
                   )
               )
           );
        }
        
        return nestedStatementsFilter;
    }
}