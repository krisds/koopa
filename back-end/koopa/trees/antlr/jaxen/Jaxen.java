package koopa.trees.antlr.jaxen;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.tree.CommonTree;
import org.jaxen.JaxenException;

public class Jaxen {

	private static final boolean DEBUG = false;

	public static List<?> evaluate(CommonTree tree, String expr) {
		try {
			if (DEBUG) {
				System.out.println("XPath: " + expr);
			}

			Object result = new KoopaXPath(expr).evaluate(tree);

			if (result == null) {
				return null;

			} else if (result instanceof List<?>) {
				final List<?> list = (List<?>) result;

				if (DEBUG) {
					System.out.println("Got " + list.size() + " answer(s).");

					int i = 1;
					for (Object object : list) {
						System.out.println("# " + i++ + ": " + object);
					}
				}

				return list;

			} else {
				if (DEBUG) {
					System.out.println("Got: " + result);
				}

				final List<Object> singleton = new ArrayList<Object>(1);
				singleton.add(result);
				return singleton;
			}

		} catch (JaxenException e) {
			throw new XPathException(e.getMessage());
		}
	}
}
