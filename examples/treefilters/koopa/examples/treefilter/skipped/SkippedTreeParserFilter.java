package koopa.examples.treefilter.skipped;

import koopa.core.trees.antlr.filter.Filter;
import koopa.core.trees.antlr.filter.FutureFilter;
import koopa.core.trees.antlr.filter.TreeNodeStreamFilter;

public class SkippedTreeParserFilter extends TreeNodeStreamFilter {

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
                   skipped()
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
                   skipped()
               )
           );
        }
        
        return copybookFilter;
    }

    // ========================================================
    // skipped
    // ........................................................

    private Filter skippedFilter = null;

    public Filter skipped() {
        if (skippedFilter == null) {
           FutureFilter future = new FutureFilter();
           skippedFilter = future;
           future.setFilter(
               node(SkippedTreeParser.WATER)
           );
        }
        
        return skippedFilter;
    }
}