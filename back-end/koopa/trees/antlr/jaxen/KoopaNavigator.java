package koopa.trees.antlr.jaxen;

import java.util.Iterator;

import koopa.tokens.Token;
import koopa.tokenstreams.Marker;
import koopa.trees.antlr.CommonKoopaToken;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.jaxen.DefaultNavigator;
import org.jaxen.FunctionCallException;
import org.jaxen.Navigator;
import org.jaxen.UnsupportedAxisException;
import org.jaxen.XPath;
import org.jaxen.saxpath.SAXPathException;

@SuppressWarnings("serial")
public class KoopaNavigator extends DefaultNavigator {

	private static final boolean DEBUG = false;

	private static final KoopaNavigator INSTANCE = new KoopaNavigator();

	private KoopaNavigator() {

	}

	public static Navigator getInstance() {
		return INSTANCE;
	}

	public Iterator<?> getChildAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getChildAxisIterator(" + foo + ")");
		}
		return new ANTLRTreeChildAxisIterator((Tree) foo);
	}

	public Iterator<?> getDescendantOrSelfAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getDescendantOrSelfAxisIterator(" + foo + ")");
		}

		return new ANTLRTreeDescendantOrSelfAxisIterator((Tree) foo);
	}

	public Iterator<?> getAncestorAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getAncestorAxisIterator(" + foo + ")");
		}
		return super.getAncestorAxisIterator(foo);
	}

	public Iterator<?> getAncestorOrSelfAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getAncestorOrSelfAxisIterator(" + foo + ")");
		}
		return super.getAncestorOrSelfAxisIterator(foo);
	}

	public Iterator<?> getAttributeAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getAttributeAxisIterator(" + foo + ")");
		}

		return new ANTLRTreeAttributeAxisIterator((Tree) foo);
	}

	public Iterator<?> getDescendantAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getDescendantAxisIterator(" + foo + ")");
		}
		return super.getDescendantAxisIterator(foo);
	}

	public Object getDocument(String url) throws FunctionCallException {
		if (DEBUG) {
			System.out.println(this.getClass().getName() + ".getDocument("
					+ url + ")");
		}
		return super.getDocument(url);
	}

	public Object getDocumentNode(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName() + ".getDocumentNode("
					+ foo + ")");
		}

		Tree tree = (Tree) foo;
		while (tree.getParent() != null) {
			tree = tree.getParent();
		}

		return tree;
	}

	public Object getElementById(Object foo, String elementId) {
		if (DEBUG) {
			System.out.println(this.getClass().getName() + ".getElementById("
					+ foo + ", " + elementId + ")");
		}
		return super.getElementById(foo, elementId);
	}

	public Iterator<?> getFollowingAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getFollowingAxisIterator(" + foo + ")");
		}
		return super.getFollowingAxisIterator(foo);
	}

	public Iterator<?> getFollowingSiblingAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getFollowingSiblingAxisIterator(" + foo + ")");
		}

		return new ANTLRTreeFollowingSibilingAxisIterator((Tree) foo);
	}

	public Iterator<?> getNamespaceAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getNamespaceAxisIterator(" + foo + ")");
		}
		return super.getNamespaceAxisIterator(foo);
	}

	public short getNodeType(Object node) {
		if (DEBUG) {
			System.out.println(this.getClass().getName() + ".getNodeType("
					+ node + ")");
		}
		return super.getNodeType(node);
	}

	public Iterator<?> getParentAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getParentAxisIterator(" + foo + ")");
		}
		return super.getParentAxisIterator(foo);
	}

	public Object getParentNode(Object foo) throws UnsupportedAxisException {
		if (DEBUG) {
			System.out.println(this.getClass().getName() + ".getParentNode("
					+ foo + ")");
		}

		if (foo instanceof Tree) {
			final Tree tree = (Tree) foo;
			return tree.getParent();

		} else if (foo instanceof ANTLRTreeAttribute) {
			final ANTLRTreeAttribute attribute = (ANTLRTreeAttribute) foo;
			return attribute.getTree();

		} else {
			return null;
		}
	}

	public Iterator<?> getPrecedingAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getPrecedingAxisIterator(" + foo + ")");
		}
		return super.getPrecedingAxisIterator(foo);
	}

	public Iterator<?> getPrecedingSiblingAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getPrecedingSiblingAxisIterator(" + foo + ")");
		}
		return super.getPrecedingSiblingAxisIterator(foo);
	}

	public String getProcessingInstructionData(Object obj) {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getProcessingInstructionData(" + obj + ")");
		}
		return super.getProcessingInstructionData(obj);
	}

	public String getProcessingInstructionTarget(Object obj) {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getProcessingInstructionTarget(" + obj + ")");
		}
		return super.getProcessingInstructionTarget(obj);
	}

	public Iterator<?> getSelfAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getSelfAxisIterator(" + foo + ")");
		}
		return super.getSelfAxisIterator(foo);
	}

	public String translateNamespacePrefixToUri(String prefix, Object element) {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".translateNamespacePrefixToUri(" + prefix + ", "
					+ element + ")");
		}
		return super.translateNamespacePrefixToUri(prefix, element);
	}

	public String getAttributeName(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName() + ".getAttributeName("
					+ foo + ")");
		}

		final ANTLRTreeAttribute attribute = (ANTLRTreeAttribute) foo;
		return attribute.getName();
	}

	public String getAttributeNamespaceUri(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getAttributeNamespaceUri(" + foo + ")");
		}

		return "";
	}

	public String getAttributeQName(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getAttributeQName(" + foo + ")");
		}
		// TODO Auto-generated method stub
		return null;
	}

	public String getAttributeStringValue(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getAttributeStringValue(" + foo + ")");
		}

		final ANTLRTreeAttribute attribute = (ANTLRTreeAttribute) foo;
		return attribute.getValue();
	}

	public String getCommentStringValue(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getCommentStringValue(" + foo + ")");
		}
		// TODO Auto-generated method stub
		return null;
	}

	public String getElementName(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName() + ".getElementName("
					+ foo + ")");
		}

		final Tree tree = (Tree) foo;

		return tree.getText();
	}

	public String getElementNamespaceUri(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getElementNamespaceUri(" + foo + ")");
		}
		return "";
	}

	public String getElementQName(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName() + ".getElementQName("
					+ foo + ")");
		}
		// TODO Auto-generated method stub
		return null;
	}

	public String getElementStringValue(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getElementStringValue(" + foo + ")");
		}
		// TODO Auto-generated method stub
		return null;
	}

	public String getNamespacePrefix(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getNamespacePrefix(" + foo + ")");
		}
		// TODO Auto-generated method stub
		return null;
	}

	public String getNamespaceStringValue(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getNamespaceStringValue(" + foo + ")");
		}
		// TODO Auto-generated method stub
		return null;
	}

	public String getTextStringValue(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName()
					+ ".getTextStringValue(" + foo + ")");
		}

		final CommonTree tree = (CommonTree) foo;
		final CommonKoopaToken token = (CommonKoopaToken) tree.getToken();
		final Token koopa = token.getKoopaToken();

		return koopa.getText();
	}

	public boolean isAttribute(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName() + ".isAttribute("
					+ foo + ")");
		}

		return foo instanceof ANTLRTreeAttribute;
	}

	public boolean isComment(Object foo) {
		return false;
	}

	public boolean isDocument(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName() + ".isDocument(" + foo
					+ ")");
		}

		return false;
	}

	public boolean isElement(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName() + ".isElement(" + foo
					+ ")");
		}

		if (foo instanceof Tree) {
			final CommonTree tree = (CommonTree) foo;
			final CommonKoopaToken token = (CommonKoopaToken) tree.getToken();
			final Token koopa = token.getKoopaToken();

			return koopa instanceof Marker;

		} else {
			return false;
		}
	}

	public boolean isNamespace(Object foo) {
		return false;
	}

	public boolean isProcessingInstruction(Object foo) {
		return false;
	}

	public boolean isText(Object foo) {
		if (DEBUG) {
			System.out.println(this.getClass().getName() + ".isText(" + foo
					+ ")");
		}

		if (foo instanceof Tree) {
			final CommonTree tree = (CommonTree) foo;
			final CommonKoopaToken token = (CommonKoopaToken) tree.getToken();
			final Token koopa = token.getKoopaToken();

			return !(koopa instanceof Marker);

		} else {
			return false;
		}
	}

	public XPath parseXPath(String foo) throws SAXPathException {
		return new KoopaXPath(foo);
	}
}
