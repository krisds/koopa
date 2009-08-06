package koopa.trees.antlr;

import java.util.Map;
import java.util.Properties;

public class TokenTypes {
	private Properties types = null;

	private int tokenType;

	public TokenTypes(Properties types) {
		assert (types != null);
		this.types = types;
		this.tokenType = Integer.parseInt(this.types.getProperty("TOKEN"));
	}

	public TokenTypes(Map<String, Integer> types) {
		assert (types != null);
		this.types = new Properties();
		this.types.putAll(types);
		this.tokenType = types.get("TOKEN");
	}

	public int forNode(String name) {
		String type = this.types.getProperty(ANTLRNaming.forNode(name));
		try {
			return Integer.parseInt(type);

		} catch (NumberFormatException e) {
			System.err.println("Conversion error for " + name + "=" + type);
			throw e;
		}
	}

	public int forLiteral(String text) {
		String type = this.types.getProperty(ANTLRNaming.forLiteral(text));

		if (type == null) {
			// TODO I'm assuming that all literals are in uppercase. This is
			// required by the GG file format, so it should be a safe
			// assumption. Still, I wouldn't mind taking another look at this
			// and see if there isn't a more robust solution.
			type = this.types.getProperty(ANTLRNaming.forLiteral(text
					.toUpperCase()));
		}

		if (type != null) {
			return Integer.parseInt(type);
		} else {
			return tokenType;
		}
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		for (Object key : this.types.keySet()) {
			buffer.append(key);
			buffer.append("=");
			buffer.append(this.types.get(key));
			buffer.append("\n");
		}

		return buffer.toString();
	}
}
