package koopa.core.trees.jaxen;

import java.util.ArrayList;
import java.util.List;

import koopa.core.treeparsers.Tree;

import org.apache.log4j.Logger;
import org.jaxen.JaxenException;

public class Jaxen {

	private static final Logger LOGGER = Logger.getLogger("xpath");

	public static List<?> evaluate(Tree tree, String expr) {
		try {
			if (LOGGER.isTraceEnabled())
				LOGGER.trace("evaluating: " + expr);

			Object result = new KoopaXPath(expr).evaluate(tree);

			if (result == null) {
				return null;

			} else if (result instanceof List<?>) {
				final List<?> list = (List<?>) result;

				if (LOGGER.isTraceEnabled()) {
					LOGGER.trace("Got " + list.size()
							+ " answer(s) for xpath: " + expr);

					int i = 1;
					for (Object object : list)
						LOGGER.trace("# " + i++ + ": " + object);
				}

				return list;

			} else {
				if (LOGGER.isTraceEnabled())
					LOGGER.trace("Got " + result + " for xpath: " + expr);

				final List<Object> singleton = new ArrayList<Object>(1);
				singleton.add(result);
				return singleton;
			}

		} catch (JaxenException e) {
			throw new XPathException(e.getMessage());
		}
	}
}
