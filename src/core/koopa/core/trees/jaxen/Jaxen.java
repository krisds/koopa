package koopa.core.trees.jaxen;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jaxen.JaxenException;

import koopa.core.trees.Tree;

public class Jaxen {

	private static final Logger LOGGER = LogManager.getLogger("xpath");

	public static List<?> evaluate(Tree tree, String expr) {
		try {
			if (LOGGER.isTraceEnabled())
				LOGGER.trace("evaluating: {}", expr);

			Object result = new KoopaXPath(expr).evaluate(tree);

			if (result == null) {
				return null;

			} else if (result instanceof List<?>) {
				final List<?> list = (List<?>) result;

				if (LOGGER.isTraceEnabled()) {
					LOGGER.trace("Got {} answer(s) for xpath: {}", list.size(), expr);

					int i = 1;
					for (Object object : list)
						LOGGER.trace("# {}: {}", i++, object);
				}

				return list;

			} else {
				if (LOGGER.isTraceEnabled())
					LOGGER.trace("Got {} for xpath: {}", result,  expr);

				final List<Object> singleton = new ArrayList<>(1);
				singleton.add(result);
				return singleton;
			}

		} catch (JaxenException e) {
			throw new XPathException(e.getMessage());
		}
	}

	/**
	 * Evaluate the XPath and return all matches.
	 */
	public static List<?> getMatches(Tree tree, String xpath) {
		return evaluate(tree, xpath);
	}

	/**
	 * Evaluate the XPath and if there is a single match return that.
	 */
	public static Tree getMatch(Tree tree, String xpath) {
		final List<?> values = evaluate(tree, xpath);
		if (values == null || values.size() != 1)
			return null;
		else
			return (Tree) values.get(0);
	}

	/**
	 * Evaluate the XPath and if there is a single match return the text of that
	 * single match.
	 */
	public static String getAllText(Tree tree, String xpath) {
		Tree match = getMatch(tree, xpath);

		if (match == null)
			return null;
		else
			return match.getAllText();
	}
}
