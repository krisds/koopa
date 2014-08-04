package sandbox.jaxen;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.tree.CommonTree;

import koopa.parsers.ParseResults;
import koopa.parsers.cobol.ParsingCoordinator;
import koopa.trees.antlr.jaxen.Jaxen;

public class JaxenSample {

	public static void main(String[] args) throws IOException {
		ParsingCoordinator coordinator = new ParsingCoordinator();
		ParseResults result = coordinator.parse(new File(
				"testsuite/cobol85/CM101M.CBL"));

		if (result.isValidInput())
			System.out.println("Input is valid.");
		else
			System.out.println("Input is faulty.");

		System.out.println("  " + result.getErrorCount() + " error(s).");
		System.out.println("  " + result.getWarningCount() + " warning(s).");

		CommonTree tree = result.getTree();

		jax(tree, "/compilationUnit");
		jax(tree, "//compilationUnit");
		jax(tree, "//compilationUnit//programName//text()");
		jax(tree, "//node()[text()=\"CM101M\"]");
		jax(tree, "//dataDescriptionEntry//dataName//text()");
		jax(tree,
				"//workingStorageSection/dataDescriptionEntry[position()=1]//dataName//text()");
		jax(tree,
				"//workingStorageSection/dataDescriptionEntry[last()]//dataName//text()");
		jax(tree,
				"//workingStorageSection/dataDescriptionEntry[position()<5]//dataName//text()");
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

	private static void jax(CommonTree tree, String expr) {
		System.out.println("xpath:" + expr + " => "
				+ Jaxen.evaluate(tree, expr));
	}
}
