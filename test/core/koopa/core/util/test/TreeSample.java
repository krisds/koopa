package koopa.core.util.test;

import static koopa.core.util.test.Util.text;
import static koopa.core.util.test.Util.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import koopa.core.trees.Tree;

// TODO Improve this class. Ideally I'd like tests to be DSL-based files without the Java noise.
public class TreeSample {

	private final List<Object> taggedWords;
	private final List<Tree> trees;

	public TreeSample(List<Object> words, List<Tree> trees) {
		this.taggedWords = words;
		this.trees = trees;
	}

	public List<Object> getTaggedWords() {
		return taggedWords;
	}

	public List<Tree> getTrees() {
		return trees;
	}

	// ========================================================================

	public static TreeSample from(String... lines) {
		List<Tree> roots = new LinkedList<>();
		Stack<Tree> trees = new Stack<>();
		Stack<Integer> depths = new Stack<>();
		List<Object> text = new LinkedList<>();
		int len = 0;

		for (final String line : lines) {
			final int depth = depth(line);

			while (!depths.isEmpty() && depths.peek() >= depth) {
				// System.out.println(
				// "popping " + depths.peek() + " : " + trees.peek());
				trees.pop();
				depths.pop();
			}

			String trimmed = line.trim();

			if (trimmed.startsWith("+")) {
				trimmed = trimmed.substring(1).trim();
				String[] names = trimmed.split("/");
				assert (names.length > 0);
				Tree parent = trees.isEmpty() ? null : trees.peek();
				for (String name : names) {
					// System.out.println(name);
					Tree tree = tree(name);
					if (parent != null)
						parent.addChild(tree);
					parent = tree;
				}

				// System.out.println("pushing " + depth + " : " + parent);
				if (trees.isEmpty())
					roots.add(parent.getRoot());

				trees.push(parent);
				depths.push(depth);

			} else if (trimmed.startsWith(">")) {
				trimmed = trimmed.substring(1).trim();
				// assert (!trees.isEmpty());
				Tree parent = trees.isEmpty() ? null : trees.peek();

				String[] words = trimmed.split("\\s+");
				for (String word : words) {
					final Tree w = text(word, len, len + word.length() - 1);

					if (parent == null)
						roots.add(w);
					else
						parent.addChild(w);

					len += word.length();
					text.add(word);
				}

			} else
				throw new InternalError(
						"Don't know how to handle this line: " + line);
		}

		while (trees.size() > 1) {
			trees.pop();
			depths.pop();
		}

		// for (Tree root : roots) {
		// dump(root, "");
		// }
		// System.out.println();

		TreeSample sample = new TreeSample(text, roots);

		return sample;
	}

	private static int depth(String line) {
		for (int i = 0; i < line.length(); i++)
			if (!Character.isWhitespace(line.charAt(i)))
				return i;

		return line.length();
	}
}