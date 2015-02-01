package koopa.core.trees.test;

import static koopa.core.util.test.Util.token;
import static koopa.core.util.test.Util.tree;

import java.io.IOException;

import junit.framework.Assert;
import junit.framework.TestCase;
import koopa.core.trees.XMLSerializer;

import org.junit.Test;

public class XMLSerializerTest extends TestCase {

	@Test
	public void testSerializeNull() throws IOException {
		String actual = XMLSerializer.serialize(null);

		String expected = "<?xml version='1.0' encoding='UTF-8'?>\n"
				+ "<koopa>\n" + "</koopa>\n";

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSerializeAToken() throws IOException {
		String actual = XMLSerializer.serialize(token("COBOL"));

		String expected = "<?xml version='1.0' encoding='UTF-8'?>\n"
				+ "<koopa>\n" + "  <t><![CDATA[COBOL]]></t>\n" + "</koopa>\n";

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSerializeATree() throws IOException {
		String actual = XMLSerializer.serialize(tree("quote", "Stop",
				"bashing", "Cobol"));

		String expected = "<?xml version='1.0' encoding='UTF-8'?>\n"
				+ "<koopa>\n" + "  <quote>\n" + "    <t><![CDATA[Stop]]></t>\n"
				+ "    <t><![CDATA[bashing]]></t>\n"
				+ "    <t><![CDATA[Cobol]]></t>\n" + "  </quote>\n"
				+ "</koopa>\n";

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testEscapingOfCDATAEndMarker() throws IOException {
		String actual = XMLSerializer.serialize(tree("escaped", "DISPLAY",
				"']]>'"));

		String expected = "<?xml version='1.0' encoding='UTF-8'?>\n"
				+ "<koopa>\n" + "  <escaped>\n"
				+ "    <t><![CDATA[DISPLAY]]></t>\n"
				+ "    <t><![CDATA[']]]]><![CDATA[>']]></t>\n"
				+ "  </escaped>\n" + "</koopa>\n";

		Assert.assertEquals(expected, actual);
	}
}
