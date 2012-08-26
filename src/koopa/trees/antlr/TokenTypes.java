package koopa.trees.antlr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.tree.CommonTree;

public class TokenTypes {
	private Map<String, Integer> types = null;
	private Set<Integer> literals = null;

	public TokenTypes() {
		this.types = new HashMap<String, Integer>();
		this.literals = new HashSet<Integer>();
	}

	public int forNode(String name) {
		Integer type = this.types.get(ANTLRNaming.forNode(name));
		return type.intValue();
	}

	public int forLiteral(String text) {
		Integer type = this.types.get(ANTLRNaming.forLiteral(text));

		if (type == null) {
			// TODO I'm assuming that all literals are in uppercase. This is
			// required by the GG file format, so it should be a safe
			// assumption. Still, I wouldn't mind taking another look at this
			// and see if there isn't a more robust solution.
			type = this.types.get(ANTLRNaming.forLiteral(text.toUpperCase()));
		}

		if (type != null) {
			return type.intValue();

		} else {
			return this.types.get("TOKEN").intValue();
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

	public void put(String key, int value, boolean literal) {
		this.types.put(key, value);
		if (literal) {
			this.literals.add(value);
		}
	}

	public boolean contains(String key) {
		return this.types.containsKey(key);
	}

	public boolean isLiteral(int value) {
		return this.literals.contains(value);
	}

	public boolean isToken(int value) {
		return this.types.get("TOKEN").intValue() == value;
	}
	
	public boolean isNodeOfType(CommonTree node, String type) {
		return forNode(type) == node.getType();
	}
}
