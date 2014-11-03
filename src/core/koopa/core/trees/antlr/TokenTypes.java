package koopa.core.trees.antlr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.tree.CommonTree;

/**
 * This class stores the information from an ANTLR tokens file in a queryable
 * form.
 */
public class TokenTypes {
	private Map<String, Integer> types = null;
	private Set<Integer> literals = null;

	/**
	 * While you can instantiate this class directly if you must, you should
	 * probably be making use of {@linkplain ANTLRTokenTypesLoader#load(String)}
	 * instead.
	 */
	public TokenTypes() {
		this.types = new HashMap<String, Integer>();
		this.literals = new HashSet<Integer>();
	}

	/**
	 * Use this method to get the right information into here.
	 */
	public void put(String key, int value, boolean literal) {
		this.types.put(key, value);
		if (literal) {
			this.literals.add(value);
		}
	}

	/**
	 * Returns the integer value associated with the given node name.
	 */
	public int forNode(String name) {
		Integer type = this.types.get(ANTLRNaming.forNode(name));
		return type.intValue();
	}

	/**
	 * Returns the integer value associated with the given type.
	 * <p>
	 * The difference between this and {@linkplain #forNode(String)} is that
	 * this version assumes the client has passed the correct ANTLR name.
	 */
	public int forType(String name) {
		return this.types.get(name).intValue();
	}

	/**
	 * Returns the integer value associated with the given literal. If the
	 * literal is not defined this returns the value for the "TOKEN" type
	 * instead.
	 */
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
			return forType("TOKEN");
		}
	}

	/**
	 * Do we know this type ?
	 */
	public boolean contains(String type) {
		return this.types.containsKey(type);
	}

	/**
	 * Is a specific ANTLR integer value used for a literal ?
	 */
	public boolean isLiteral(int value) {
		return this.literals.contains(value);
	}

	/**
	 * Is a specific ANTLR integer value used for a token ?
	 */
	public boolean isToken(int value) {
		return this.types.get("TOKEN").intValue() == value;
	}

	/**
	 * Does the tree node match the logical type ?
	 */
	public boolean isNodeOfType(CommonTree node, String type) {
		return forNode(type) == node.getType();
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
