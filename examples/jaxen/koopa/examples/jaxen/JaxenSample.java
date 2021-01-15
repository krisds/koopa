package koopa.examples.jaxen;

import java.io.File;
import java.io.IOException;
import java.util.List;

import koopa.cobol.parser.CobolParser;
import koopa.cobol.parser.ParseResults;
import koopa.cobol.projects.StandardCobolProject;
import koopa.core.parsers.Messages;
import koopa.core.parsers.Parse;
import koopa.core.trees.KoopaTreeBuilder;
import koopa.core.trees.Tree;
import koopa.core.trees.jaxen.Jaxen;

public class JaxenSample {

	public static void main(String[] args) throws IOException {
		final CobolParser parser = new CobolParser();
		parser.setProject(new StandardCobolProject());
		parser.setBuildTrees(true);

		final ParseResults result = parser
				.parse(new File("testsuite/cobol85/CM101M.CBL"));

		if (result.isValidInput())
			System.out.println("Input is valid.");
		else
			System.out.println("Input is faulty.");

		final Parse parse = result.getParse();
		final Messages messages = parse.getMessages();
		System.out.println("  " + messages.getErrorCount() + " error(s).");
		System.out.println("  " + messages.getWarningCount() + " warning(s).");

		Tree tree = parse.getTarget(KoopaTreeBuilder.class).getTree();

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
		jax(tree, "//dataDivision//node()[@tag=\"STRING\"]");
		jax(tree, "//dataDivision//node()[@tag=\"NUMBER\"]");
		jax(tree, "//node()[@line<100 and @tag=\"STRING\"]");
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
