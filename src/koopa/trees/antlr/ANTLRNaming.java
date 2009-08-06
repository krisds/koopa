package koopa.trees.antlr;

public class ANTLRNaming {
	public static String forNode(String name) {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);

			if (Character.isUpperCase(c)) {
				buffer.append('_');
				buffer.append(c);

			} else {
				buffer.append(Character.toUpperCase(c));
			}
		}

		return buffer.toString();
	}

	public static String forLiteral(String text) {
		return "'" + text + "'";
	}
}
