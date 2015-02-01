package koopa.core.trees.jaxen;

import org.jaxen.BaseXPath;
import org.jaxen.JaxenException;

@SuppressWarnings("serial")
public class KoopaXPath extends BaseXPath {

	public KoopaXPath(String xpathExpr) throws JaxenException {
		super(xpathExpr, KoopaNavigator.getInstance());
	}
}
