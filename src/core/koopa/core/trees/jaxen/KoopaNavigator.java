package koopa.core.trees.jaxen;

import java.util.Iterator;

import koopa.core.data.Data;
import koopa.core.data.Marker;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.trees.Tree;

import org.apache.log4j.Logger;
import org.jaxen.DefaultNavigator;
import org.jaxen.FunctionCallException;
import org.jaxen.Navigator;
import org.jaxen.UnsupportedAxisException;
import org.jaxen.XPath;
import org.jaxen.saxpath.SAXPathException;

@SuppressWarnings("serial")
public class KoopaNavigator extends DefaultNavigator {

	private static final Logger LOGGER = Logger.getLogger("xpath");

	private static final KoopaNavigator INSTANCE = new KoopaNavigator();

	private KoopaNavigator() {

	}

	public static Navigator getInstance() {
		return INSTANCE;
	}

	@Override
	public Iterator<?> getChildAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getChildAxisIterator(" + foo + ")");

		return new ChildAxisIterator((Tree) foo);
	}

	@Override
	public Iterator<?> getDescendantOrSelfAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".getDescendantOrSelfAxisIterator(" + foo + ")");

		return new DescendantOrSelfAxisIterator((Tree) foo);
	}

	@Override
	public Iterator<?> getAncestorAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".getAncestorAxisIterator(" + foo + ")");

		return super.getAncestorAxisIterator(foo);
	}

	@Override
	public Iterator<?> getAncestorOrSelfAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".getAncestorOrSelfAxisIterator(" + foo + ")");

		return super.getAncestorOrSelfAxisIterator(foo);
	}

	@Override
	public Iterator<?> getAttributeAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".getAttributeAxisIterator(" + foo + ")");

		return new AttributeAxisIterator((Tree) foo);
	}

	@Override
	public Iterator<?> getDescendantAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".getDescendantAxisIterator(" + foo + ")");

		return super.getDescendantAxisIterator(foo);
	}

	@Override
	public Object getDocument(String url) throws FunctionCallException {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getDocument(" + url + ")");

		return super.getDocument(url);
	}

	@Override
	public Object getDocumentNode(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getDocumentNode(" + foo + ")");

		Tree tree = (Tree) foo;
		Tree root = tree.getRoot();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(" => " + root);

		return root;
	}

	@Override
	public Object getElementById(Object foo, String elementId) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getElementById(" + foo + ", "
					+ elementId + ")");

		return super.getElementById(foo, elementId);
	}

	@Override
	public Iterator<?> getFollowingAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".getFollowingAxisIterator(" + foo + ")");

		return super.getFollowingAxisIterator(foo);
	}

	@Override
	public Iterator<?> getFollowingSiblingAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".getFollowingSiblingAxisIterator(" + foo + ")");

		return new FollowingSibilingAxisIterator((Tree) foo);
	}

	@Override
	public Iterator<?> getNamespaceAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".getNamespaceAxisIterator(" + foo + ")");

		return super.getNamespaceAxisIterator(foo);
	}

	@Override
	public short getNodeType(Object node) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getNodeType(" + node + ")");

		return super.getNodeType(node);
	}

	@Override
	public Iterator<?> getParentAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getParentAxisIterator(" + foo + ")");

		return new ParentAxisIterator((Tree) foo);
	}

	@Override
	public Object getParentNode(Object foo) throws UnsupportedAxisException {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getParentNode(" + foo + ")");

		if (foo instanceof Tree) {
			final Tree tree = (Tree) foo;
			return tree.getParent();

		} else if (foo instanceof TreeAttribute) {
			final TreeAttribute attribute = (TreeAttribute) foo;
			return attribute.getTree();

		} else {
			return null;
		}
	}

	@Override
	public Iterator<?> getPrecedingAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".getPrecedingAxisIterator(" + foo + ")");

		return super.getPrecedingAxisIterator(foo);
	}

	@Override
	public Iterator<?> getPrecedingSiblingAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".getPrecedingSiblingAxisIterator(" + foo + ")");

		return super.getPrecedingSiblingAxisIterator(foo);
	}

	@Override
	public String getProcessingInstructionData(Object obj) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".getProcessingInstructionData(" + obj + ")");

		return super.getProcessingInstructionData(obj);
	}

	@Override
	public String getProcessingInstructionTarget(Object obj) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".getProcessingInstructionTarget(" + obj + ")");

		return super.getProcessingInstructionTarget(obj);
	}

	@Override
	public Iterator<?> getSelfAxisIterator(Object foo)
			throws UnsupportedAxisException {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getSelfAxisIterator(" + foo + ")");

		return super.getSelfAxisIterator(foo);
	}

	@Override
	public String translateNamespacePrefixToUri(String prefix, Object element) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".translateNamespacePrefixToUri(" + prefix + ", "
					+ element + ")");

		return super.translateNamespacePrefixToUri(prefix, element);
	}

	@Override
	public String getAttributeName(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getAttributeName(" + foo + ")");

		final TreeAttribute attribute = (TreeAttribute) foo;
		return attribute.getName();
	}

	@Override
	public String getAttributeNamespaceUri(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".getAttributeNamespaceUri(" + foo + ")");

		return "";
	}

	@Override
	public String getAttributeQName(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getAttributeQName(" + foo + ")");

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttributeStringValue(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".getAttributeStringValue(" + foo + ")");

		final TreeAttribute attribute = (TreeAttribute) foo;
		return attribute.getValue();
	}

	@Override
	public String getCommentStringValue(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getCommentStringValue(" + foo + ")");

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getElementName(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getElementName(" + foo + ")");

		final Tree tree = (Tree) foo;
		String name = null;

		Data data = tree.getData();
		if (data instanceof Marker)
			name = ((Marker) data).getName();

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(" => " + name);

		return name;
	}

	@Override
	public String getElementNamespaceUri(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getElementNamespaceUri(" + foo + ")");

		String namespace = "";

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(" => " + namespace);

		return namespace;
	}

	@Override
	public String getElementQName(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getElementQName(" + foo + ")");

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getElementStringValue(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getElementStringValue(" + foo + ")");

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNamespacePrefix(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getNamespacePrefix(" + foo + ")");

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNamespaceStringValue(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace(this.getClass().getName()
					+ ".getNamespaceStringValue(" + foo + ")");

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTextStringValue(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.getTextStringValue(" + foo + ")");

		final Tree tree = (Tree) foo;
		final Data koopa = tree.getData();

		if (koopa instanceof Token)
			return ((Token) koopa).getText();

		return null;
	}

	@Override
	public boolean isAttribute(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.isAttribute(" + foo + ")");

		return foo instanceof TreeAttribute;
	}

	@Override
	public boolean isComment(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.isComment(" + foo + ")");

		if (!(foo instanceof Tree))
			return false;

		final Tree tree = (Tree) foo;

		Data data = tree.getData();
		if (!(data instanceof Token))
			return false;

		Token token = (Token) data;
		final boolean isComment = token.hasTag(AreaTag.COMMENT);

		if (LOGGER.isTraceEnabled())
			LOGGER.trace(" => " + isComment);

		return isComment;
	}

	@Override
	public boolean isDocument(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.isDocument(" + foo + ")");

		return false;
	}

	@Override
	public boolean isElement(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.isElement(" + foo + ")");

		if (foo instanceof Tree) {
			final Tree tree = (Tree) foo;
			final Data koopa = tree.getData();

			final boolean isElement = koopa instanceof Marker;

			if (LOGGER.isTraceEnabled())
				LOGGER.trace(" => " + isElement);

			return isElement;

		} else {
			if (LOGGER.isTraceEnabled())
				LOGGER.trace(" => " + false);

			return false;
		}
	}

	@Override
	public boolean isNamespace(Object foo) {
		return false;
	}

	@Override
	public boolean isProcessingInstruction(Object foo) {
		return false;
	}

	@Override
	public boolean isText(Object foo) {
		if (LOGGER.isTraceEnabled())
			LOGGER.trace("KoopaNavigator.isText(" + foo + ")");

		if (isComment(foo))
			return false;

		if (!(foo instanceof Tree))
			return false;

		final Tree tree = (Tree) foo;
		final Data koopa = tree.getData();

		return koopa instanceof Token;
	}

	@Override
	public XPath parseXPath(String foo) throws SAXPathException {
		return new KoopaXPath(foo);
	}
}
