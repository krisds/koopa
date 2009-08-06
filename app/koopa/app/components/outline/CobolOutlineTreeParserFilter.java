package koopa.app.components.outline;

import koopa.trees.antlr.filter.Filter;
import koopa.trees.antlr.filter.FutureFilter;
import koopa.trees.antlr.filter.TreeNodeStreamFilter;

public class CobolOutlineTreeParserFilter extends TreeNodeStreamFilter {

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
               tree(CobolOutlineTreeParser.COMPILATION_UNIT,
                   seq(
                       node(CobolOutlineTreeParser.PROGRAM_NAME),
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
               tree(CobolOutlineTreeParser.PROCEDURE_DIVISION,
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
               tree(CobolOutlineTreeParser.DECLARATIVES,
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
               tree(CobolOutlineTreeParser.DECLARATIVE_SECTION,
                   seq(
                       node(CobolOutlineTreeParser.SECTION_NAME),
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
               tree(CobolOutlineTreeParser.SECTION,
                   seq(
                       node(CobolOutlineTreeParser.SECTION_NAME),
                       star(
                           paragraph()
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
               tree(CobolOutlineTreeParser.PARAGRAPH,
                   seq(
                       node(CobolOutlineTreeParser.PARAGRAPH_NAME)
                   )
               )
           );
        }
        
        return paragraphFilter;
    }
}