package sandbox.treefilter;

import koopa.trees.antlr.filter.Filter;
import koopa.trees.antlr.filter.FutureFilter;
import koopa.trees.antlr.filter.TreeNodeStreamFilter;

public class MyAdaptiveTreeParserFilter extends TreeNodeStreamFilter {

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
               tree(MyAdaptiveTreeParser.COMPILATION_UNIT,
                   seq(
                       node(MyAdaptiveTreeParser.PROGRAM_NAME),
                       opt(
                           node(MyAdaptiveTreeParser.FILE_SECTION)
                       ),
                       opt(
                           literal("FILLER")
                       ),
                       opt(
                           declaratives()
                       ),
                       star(
                           or(
                               paragraph(),
                               section()
                           )
                       ),
                       star(
                           compilationUnit()
                       )
                   )
               )
           );
        }
        
        return compilationUnitFilter;
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
               tree(MyAdaptiveTreeParser.DECLARATIVES,
                   seq(
                       star(
                           node(MyAdaptiveTreeParser.SECTION_NAME)
                       )
                   )
               )
           );
        }
        
        return declarativesFilter;
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
               tree(MyAdaptiveTreeParser.SECTION,
                   seq(
                       node(MyAdaptiveTreeParser.SECTION_NAME),
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
               tree(MyAdaptiveTreeParser.PARAGRAPH,
                   seq(
                       node(MyAdaptiveTreeParser.PARAGRAPH_NAME)
                   )
               )
           );
        }
        
        return paragraphFilter;
    }
}