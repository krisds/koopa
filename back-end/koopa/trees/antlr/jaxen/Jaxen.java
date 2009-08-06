package koopa.trees.antlr.jaxen;

import java.util.List;

import org.antlr.runtime.tree.CommonTree;
import org.jaxen.JaxenException;

public class Jaxen {

	private static final boolean DEBUG = false;

	public static Object evaluate(CommonTree tree, String expr) {
		try {
			if (DEBUG) {
				System.out.println("*** JAXEN ***");
				System.out.println(expr);
			}

			Object result = new KoopaXPath(expr).evaluate(tree);

			if (DEBUG) {
				if (result instanceof List<?>) {
					final List<?> list = (List<?>) result;
					System.out.println("Got " + list.size() + " answer(s).");

					int i = 1;
					for (Object object : list) {
						System.out.println("# " + i++ + ": " + object);
					}

				} else {
					System.out.println("Got: " + result);
				}

				System.out.println("*** /JAXEN ***");
				System.out.println();
			}

			return result;

		} catch (JaxenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
