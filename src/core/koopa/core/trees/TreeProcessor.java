package koopa.core.trees;

import java.io.File;

import koopa.core.treeparsers.Tree;

public interface TreeProcessor {
	boolean processes(Tree tree, File file);
}
