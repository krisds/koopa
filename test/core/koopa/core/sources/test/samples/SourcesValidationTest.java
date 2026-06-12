package koopa.core.sources.test.samples;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.sources.test.DataValidator;
import koopa.core.trees.Tree;
import koopa.core.util.test.FileBasedTest;

/**
 * This class provides the infrastructure for testing the different sources. It
 * looks for ".sample" files, and runs each one it finds through a JUnit test.
 */
public abstract class SourcesValidationTest
		implements FileBasedTest, DataValidator {

	protected abstract File getFolder();

	@Override
	public File[] getFiles() {
		File folder = getFolder();

		List<File> sources = koopa.core.util.Files.listFilesRecursively(folder,
				Sample.getFilenameFilter());

		return sources.toArray(new File[sources.size()]);
	}

	protected File file;

	@Override
	public void setFile(File file) {
		this.file = file;
	}

	@TestFactory
	public Stream<DynamicTest> generateFileTests() {
		return Arrays.stream(getFiles())
			.map(file -> DynamicTest.dynamicTest(
				file.getName(),
				() -> testFile(file)
			));
	}

	private void testFile(File file) throws IOException {
		setFile(file);
		// Clear categories before setUp
		TOKEN_CATEGORIES.clear();
		NODE_CATEGORIES.clear();
		setUp();  // Call setUp for each test
		testSampleValidates();
	}

	protected void setUp() {
		// Override in subclasses to provide per-test setup
	}

	private void testSampleValidates() throws IOException {
		Sample sample = Sample.from(file);

		Source source = getSource(file.getAbsolutePath(), sample);

		sample.assertOutputIsAsExpected(source, this);
	}

	protected abstract Source getSource(String resourceName, Sample sample);

	private Map<String, Tags> TOKEN_CATEGORIES = new HashMap<>();
	private Map<String, NodeType> NODE_CATEGORIES = new HashMap<>();

	protected void addTokenCategory(String category, Object[] required) {
		addTokenCategory(category, required, null);
	}

	protected void addTokenCategory(String category, Object[] required,
			Object[] forbidden) {
		assert (!TOKEN_CATEGORIES.containsKey(category));
		TOKEN_CATEGORIES.put(category, new Tags(required, forbidden));
	}

	protected void addNodeCategory(String category, String namespace,
			String name) {
		assert (!NODE_CATEGORIES.containsKey(category));
		NODE_CATEGORIES.put(category, new NodeType(namespace, name));
	}

	@Override
	public void validate(Token token, String category, boolean required) {
		if ("-".equalsIgnoreCase(category)) {
			// A "don't care". For when you don't care.
			return;
		}

		if ("?".equalsIgnoreCase(category)) {
			// This one is used for debugging.
			System.out.println(token);
			return;
		}

		if (TOKEN_CATEGORIES.containsKey(category)) {
			final Tags tags = TOKEN_CATEGORIES.get(category);

			if (required)
				assertRequiredCategory(token, category, tags);
			else
				assertForbiddenCategory(token, category, tags);

		} else {
			System.out.println(
					"Warning! Unknown category '" + category + "' on " + token);
		}
	}

	@Override
	public void validate(Tree tree, String category, boolean required) {
		if ("-".equalsIgnoreCase(category)) {
			// A "don't care". For when you don't care.
			return;
		}

		if ("?".equalsIgnoreCase(category)) {
			// This one is used for debugging.
			System.out.println(tree);
			return;
		}

		if (NODE_CATEGORIES.containsKey(category)) {
			final NodeType type = NODE_CATEGORIES.get(category);

			final String msg;
			if (required)
				msg = "Category " + category + ": requires " + type + ". Got: "
						+ tree;
			else
				msg = "Category " + category + ": forbids" + type + ". Got: "
						+ tree;

			assertTrue( type.name.equals(tree.getName()) == required);
			if (type.namespace != null)
				assertTrue(
						type.namespace.equals(tree.getNamespace()) == required);

		} else {
			System.out.println(
					"Warning! Unknown category '" + category + "' on " + tree);
		}
	}

	private void assertRequiredCategory(Token token, String category,
			final Tags tags) {
		if (tags.required != null)
			for (Object tag : tags.required)
				assertTrue(token.hasTag(tag),
						"Category " + category + ": requires " + tag + " on " + token + ".");

		if (tags.forbidden != null)
			for (Object tag : tags.forbidden)
				assertFalse(token.hasTag(tag),
						"Category " + category + ": forbids " + tag + " on " + token + ".");
	}

	private void assertForbiddenCategory(Token token, String category,
			final Tags tags) {
		if (tags.required != null)
			for (Object tag : tags.required)
				assertFalse(token.hasTag(tag),
						"Category !" + category + ": forbids " + tag + " on " + token + ".");

		// We don't assume that the negation of a category suddenly makes its
		// forbidden elements required.
	}

	private final class Tags {
		final Object[] required;
		final Object[] forbidden;

		public Tags(Object[] required, Object[] forbidden) {
			this.required = required;
			this.forbidden = forbidden;
		}
	}

	private final class NodeType {
		final String namespace;
		final String name;

		public NodeType(String namespace, String name) {
			super();
			this.namespace = namespace;
			this.name = name;
		}

		@Override
		public String toString() {
			if (namespace == null)
				return "<" + name + ">";
			else
				return "<" + namespace + ":" + name + ">";
		}
	}
}
