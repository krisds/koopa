package koopa.examples.jaxen;

import java.io.File;
import java.io.IOException;
import java.util.List;

import koopa.cobol.parser.ParseResults;
import koopa.cobol.parser.cobol.ParsingCoordinator;
import koopa.core.treeparsers.Tree;
import koopa.core.trees.jaxen.Jaxen;

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

		Tree tree = result.getTree();

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
		jax(tree, "//text()");
		jax(tree, "//compilationUnit//text()");
		jax(tree, "//procedureDivision//text()");
		jax(tree, "//procedureDivision//statement/verb/text()");
		jax(tree, "//identificationDivision/descendant-or-self::node()");
		jax(tree, "//node()[@line=100]");
		jax(tree, "//text()[@line=100]");
		jax(tree, "//text()[@line<10]");
		jax(tree, "//text()[@line<10]/@tag");
		jax(tree, "//dataDivision//node()[@tag=\"STRING_LITERAL\"]");
		jax(tree, "//dataDivision//node()[@tag=\"INTEGER_LITERAL\"]");
		jax(tree, "//node()[@line<100 and @tag=\"STRING_LITERAL\"]");
		jax(tree, "//node()[@tag=\"WATER\"]");
		jax(tree, "//performStatement[./procedureName]");
		jax(tree, "//comment()");
	}

	private static void jax(Tree tree, String expr) {
		final List<?> matches = Jaxen.evaluate(tree, expr);

		if (matches == null)
			System.out.println("xpath:" + expr + " => " + matches);
		else if (matches.isEmpty())
			System.out.println("xpath:" + expr + " => " + matches);
		else if (matches.size() == 1)
			System.out.println("xpath:" + expr + " => " + matches.get(0));
		else {
			System.out.println("xpath:" + expr + " => ");
			for (Object match : matches)
				System.out.println("    " + match);
		}
	}
}
