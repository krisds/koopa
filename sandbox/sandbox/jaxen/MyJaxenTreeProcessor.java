package sandbox.jaxen;

import java.io.File;

import koopa.trees.antlr.CommonTreeProcessor;
import koopa.trees.antlr.jaxen.Jaxen;

import org.antlr.runtime.tree.CommonTree;


public class MyJaxenTreeProcessor implements CommonTreeProcessor {

	public boolean processes(CommonTree tree, File file) {
		doJaxenStuff(tree);
		return true;
	}

	private void doJaxenStuff(CommonTree tree) {
		jax(tree, "/compilationUnit");
		jax(tree, "//compilationUnit");
		jax(tree, "//compilationUnit//programName//text()");
		jax(tree, "//node()[text()=\"CM101M\"]");
		jax(tree, "//dataDescriptionEntry//dataName//text()");
		jax(tree, "//workingStorageSection/dataDescriptionEntry[position()=1]//dataName//text()");
		jax(tree, "//workingStorageSection/dataDescriptionEntry[last()]//dataName//text()");
		jax(tree, "//workingStorageSection/dataDescriptionEntry[position()<5]//dataName//text()");
		jax(tree, "//dataDivision//statement");
		jax(tree, "//identificationDivision//*");
		jax(tree, "//identificationDivision//text()");
		jax(tree, "//identificationDivision//node()");
		// jax(tree, "//text()");
		// jax(tree, "//compilationUnit//text()");
		// jax(tree, "//procedureDivision//text()");
		jax(tree, "//procedureDivision//statement/verb/text()");
		// jax(tree, "//identificationDivision/descendant-or-self::node()");
		jax(tree, "//node()[@line=100]");
		jax(tree, "//text()[@line=100]");
		jax(tree, "//text()[@line<10]");
		// jax(tree, "//text()[@line<10]/@tag");
		jax(tree, "//dataDivision//node()[@tag=\"STRING_LITERAL\"]");
		jax(tree, "//dataDivision//node()[@tag=\"INTEGER_LITERAL\"]");
		jax(tree, "//node()[@line<100 and @tag=\"STRING_LITERAL\"]");
		jax(tree, "//node()[@tag=\"WATER\"]");
	}

	private void jax(CommonTree tree, String expr) {
		System.out.println("xpath:" + expr + " => " + Jaxen.evaluate(tree, expr));
	}
}
