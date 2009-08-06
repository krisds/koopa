package koopa.trees.antlr;

import java.io.File;

import org.antlr.runtime.tree.CommonTree;

public interface CommonTreeProcessor {
	public boolean processes(CommonTree tree, File file);
}
