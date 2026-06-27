package koopa.core.trees.jaxen.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.IOException;

import org.jaxen.JaxenException;
import org.jaxen.Navigator;
import org.jaxen.pattern.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import koopa.core.data.Marker;
import koopa.core.data.Token;
import koopa.core.data.tags.AreaTag;
import koopa.core.trees.Tree;
import koopa.core.trees.jaxen.KoopaNavigator;
import koopa.core.trees.jaxen.TreeAttribute;
import koopa.core.util.test.Util;

@TestMethodOrder(value = OrderAnnotation.class)
class KoopaNavigatorTest {

    // ----------------------------------------------------------------------
    //     isXXX node type testers
    // ----------------------------------------------------------------------

	@Order(1)
	@DisplayName("isXXX node type testers")
	@MethodSource(value = "createAllNodeTypes")
	@ParameterizedTest(name = "node type: {1}")
	void isNodeType(final Object node, final NodeTypes nodeType) throws IOException, JaxenException {
		final Navigator nav = getNavigator();
		// @formatter:off
		assertAll(
			() -> assertSame(nodeType == NodeTypes.ATTRIBUTE_NODE, nav.isAttribute(node), () -> nodeType + " - isAttribute(" + node + ")"),
			() -> assertSame(nodeType == NodeTypes.COMMENT_NODE, nav.isComment(node), () -> nodeType + " - isComment(" + node + ")"),
			() -> assertSame(nodeType == NodeTypes.DOCUMENT_NODE, nav.isDocument(node), () -> nodeType + " - isDocument(" + node + ")"),
			() -> assertSame(nodeType == NodeTypes.ELEMENT_NODE, nav.isElement(node), () -> nodeType + " - isElement(" + node + ")"),
			// () -> assertSame(nodeType == NodeTypes.NAMESPACE_NODE, nav.isNamespace(node), () -> nodeType + " - isNamespace(" + node + ")"),
			// () -> assertSame(nodeType == NodeTypes.PROCESSING_INSTRUCTION_NODE, nav.isProcessingInstruction(node), () -> nodeType + " - isProcessingInstruction(" + node + ")"),
			() -> assertSame(nodeType == NodeTypes.TEXT_NODE, nav.isText(node), () -> nodeType + " - isText(" + node + ")")
		);
		// @formatter:on
	}

    // ----------------------------------------------------------------------
    //     String-Value extractors
    // ----------------------------------------------------------------------

	@Order(2)
	@DisplayName("getXXXStringValue extractors")
	@MethodSource(value = "createAllNodeTypes")
	@ParameterizedTest(name = "node type: {1}")
	void getXXXStringValue(final Object node, final NodeTypes nodeType) {
		final Navigator nav = getNavigator();
		// @formatter:off
		assertAll(
			() -> assertSame(nav.isAttribute(node) ? ((TreeAttribute) node).getValue() : "", nav.getAttributeStringValue(node), () -> "getAttributeStringValue(" + node + ")"),
			() -> assertSame(nav.isComment(node) ? ((Token) ((Tree) node).getData()).getText() : "", nav.getCommentStringValue(node), () -> "getCommentStringValue(" + node + ")"),
			() -> assertSame(nav.isElement(node) ? ((Marker) ((Tree) node).getData()).getName() : "", nav.getElementStringValue(node), () -> "getElementStringValue(" + node + ")"),
			() -> assertSame("", nav.getNamespaceStringValue(node), () -> "getNamespaceStringValue(" + node + ")"),
			() -> assertSame(nav.isText(node) ? ((Token) ((Tree) node).getData()).getText() : "", nav.getTextStringValue(node), () -> "getTextStringValue(" + node + ")")
		);
		// @formatter:on
	}

	// ----------------------------------------------------------------------
	//     Test utility methods
	// ----------------------------------------------------------------------

	static final TreeAttribute createAttribute(final String name, final String value) {
		return new TreeAttribute(null, name, value);
	}

	static final Tree createComment(final String text) {
		return Util.token(text, AreaTag.COMMENT);
	}

	static final Tree createDocument() {
		return Util.tree("koopa");
	}

	static final Tree createElement(final String name) {
		final Tree element = Util.tree(name);
		Util.tree("koopa", element);
		return element;
	}

	static final Tree createNamespace(Object object) {
		return null;
	}

	static final Tree createProcessingInstruction(Object object) {
		return null;
	}

	static final Tree createText(final String text) {
		return Util.token(text);
	}

	static Navigator getNavigator() {
		return KoopaNavigator.getInstance();
	}

	static final Arguments[] createAllNodeTypes() {
		// @formatter:off
		return new Arguments[] {
			Arguments.of(createAttribute("attrName", "attrValue"), NodeTypes.ATTRIBUTE_NODE),
			Arguments.of(createComment("This is a comment"), NodeTypes.COMMENT_NODE),
			Arguments.of(createDocument(), NodeTypes.DOCUMENT_NODE),
			Arguments.of(createElement("elementName"), NodeTypes.ELEMENT_NODE),
			// Arguments.of(createNamespace(null), NodeTypes.NAMESPACE_NODE),
			// Arguments.of(createProcessingInstruction(null), NodeTypes.PROCESSING_INSTRUCTION_NODE),
			Arguments.of(createText("This is a text"), NodeTypes.TEXT_NODE)
		};
		// @formatter:on
	}

	static enum NodeTypes {
		// @formatter:off
		ATTRIBUTE_NODE(Pattern.ATTRIBUTE_NODE),
		COMMENT_NODE(Pattern.COMMENT_NODE),
		DOCUMENT_NODE(Pattern.DOCUMENT_NODE),
		ELEMENT_NODE(Pattern.ELEMENT_NODE),
		//NAMESPACE_NODE(Pattern.NAMESPACE_NODE),
		//PROCESSING_INSTRUCTION_NODE(Pattern.PROCESSING_INSTRUCTION_NODE),
		TEXT_NODE(Pattern.TEXT_NODE);
		// @formatter:on

		private final short typeCode;

		private NodeTypes(final short typeCode) {
			this.typeCode = typeCode;
		}

		final short getTypeCode() {
			return typeCode;
		}

	}

}
