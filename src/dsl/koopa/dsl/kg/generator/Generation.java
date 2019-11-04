package koopa.dsl.kg.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.trees.Tree;
import koopa.core.trees.jaxen.Jaxen;
import koopa.core.util.Encoding;
import koopa.core.util.IndentingLogger;
import koopa.core.util.Iterables;
import koopa.dsl.kg.grammar.KGGrammar;
import koopa.templates.Template;
import koopa.templates.TemplateLogic;

public class Generation {

	private static final IndentingLogger LOGGER = new IndentingLogger(
			Logger.getLogger("kg.generation"));

	private final Template TEMPLATE;

	public Generation(Template template) {
		this.TEMPLATE = template;
	}

	public String generate(File grammarFile, Tree ast) throws IOException {
		final File path = grammarFile.getParentFile();

		if (LOGGER.isEnabled())
			LOGGER.add("Processing " + grammarFile + " ...");

		// Each grammar should have an associated properties file containing
		// some extra info needed for creating a valid Java class. We don't make
		// this part of the actual grammar file because we want to keep any
		// native stuff out of there.
		Properties meta = new Properties();

		File propertiesFile = new File(path,
				grammarFile.getName().replace(".kg", ".properties"));
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propertiesFile);
			meta.load(fis);
		} finally {
			if (fis != null)
				fis.close();
		}

		if (LOGGER.isEnabled())
			LOGGER.add("Loaded an additional " + meta.size() + " properties.");

		// One of the things the properties file should define are all the
		// required imports. We collect them here into actual valid Java import
		// statements.
		final List<String> additionalImports = new LinkedList<>();
		for (String key : stringPropertyNames(meta)) {
			if (key.startsWith("import.")) {
				final String importName = key.substring("import.".length());
				final String packageName = meta.getProperty(key);
				additionalImports
						.add("import " + packageName + "." + importName + ";");

			} else if (key.startsWith("static.")) {
				final String importName = key.substring("static.".length());
				final String packageName = meta.getProperty(key);
				additionalImports.add("import static " + packageName + "."
						+ importName + ";");
			}
		}

		// The order in which property names are listed is not stable.
		// So we sort all imports to ensure stability in the generated output.
		Collections.sort(additionalImports);

		if (LOGGER.isEnabled()) {
			LOGGER.add("Properties defined " + additionalImports.size()
					+ " imports:");
			for (String ai : additionalImports)
				LOGGER.add("* " + ai);
		}

		return toCode(grammarFile, ast, meta, additionalImports);
	}

	private String toCode(File grammarFile, Tree ast, final Properties meta,
			List<String> additionalImports) {

		StringBuilder code = new StringBuilder();

		if (!ast.isNode("grammar"))
			throw new InternalError(
					"Was expecting a syntax tree for a Koopa grammar." + ast);

		if (LOGGER.isEnabled())
			LOGGER.indent("+ grammar");

		TEMPLATE.apply("grammar", code, "",
				grammarLogic(grammarFile, ast, meta, additionalImports));

		if (LOGGER.isEnabled())
			LOGGER.dedent();

		return code.toString();
	}

	private TemplateLogic grammarLogic(final File grammarFile, final Tree ast,
			final Properties meta, final List<String> additionalImports) {
		return new TemplateLogic() {
			{
				setValue("grammar_file", grammarFile.toString());

				setValue("name",
						ast.getDescendant("header", "grammar_name", "name")
								.getAllText());

				final Tree base = ast.getDescendant("header", "extends",
						"name");
				setValue("extending", //
						base != null ? base.getAllText() : "Koopa");

				setValue("package", meta.getProperty("package"));
			}

			@Override
			public void call(String target, StringBuilder builder,
					String indent) {

				if (LOGGER.isEnabled())
					LOGGER.indent("+ " + target);

				if ("user_imports".equals(target)) {
					if (LOGGER.isEnabled())
						LOGGER.add("Including " + additionalImports.size()
								+ " user-defined imports.");

					for (String imp : additionalImports) {
						builder.append(indent);
						builder.append(imp);
						builder.append(Encoding.lineSeparator());
					}

				} else if ("rules".equals(target))
					for (Tree rule : ast.getChildren("rule")) {
						TEMPLATE.apply("rule", builder, indent,
								ruleLogic(rule));

						List<?> nestedRules = Jaxen.getMatches(rule,
								".//nested_rule");
						if (nestedRules != null) {
							if (LOGGER.isEnabled())
								LOGGER.indent();

							for (Object nested : nestedRules)
								if (nested instanceof Tree)
									TEMPLATE.apply("rule", builder, indent,
											ruleLogic((Tree) nested));

							if (LOGGER.isEnabled())
								LOGGER.dedent();
						}
					}

				else
					super.call(target, builder, indent);

				if (LOGGER.isEnabled())
					LOGGER.dedent();
			}
		};
	}

	private TemplateLogic ruleLogic(final Tree rule) {
		return new TemplateLogic() {

			private List<String> bindings = new LinkedList<>();
			private List<String> unbindings = new LinkedList<>();

			{
				final String name = getRuleName(rule);
				final String fullyQualifiedName = getFullyQualifiedRuleName(
						rule);
				setValue("name", name);
				setValue("fullyQualifiedName", fullyQualifiedName);

				if (LOGGER.isEnabled())
					LOGGER.add("Generating rule " + fullyQualifiedName);

				final boolean allowKeywords = rule
						.getDescendant("nokeywords") == null;
				final boolean hasPrivateModifier = rule
						.getDescendant("modifier", "private") != null;
				final boolean hasHidingModifier = rule.getDescendant("modifier",
						"hiding") != null;

				setValue("allowKeywords", allowKeywords ? "true" : "false");
				setValue("modifier",
						hasPrivateModifier ? "protected" : "public");
				setValue("visibility", hasPrivateModifier ? "PRIVATE"
						: hasHidingModifier ? "HIDING" : "PUBLIC");

				final Tree locals = rule.getChild("local-variables");
				if (locals != null) {
					List<Tree> declarations = locals.getChildren("declaration");
					for (final Tree decl : declarations) {
						TemplateLogic l = new TemplateLogic() {
							{
								setValue("type",
										decl.getChild("type").getAllText());
								setValue("name",
										decl.getChild("name").getAllText());
							}
						};

						bindings.add(TEMPLATE.apply("binding", l));
						unbindings.add(TEMPLATE.apply("unbinding", l));
					}
				}
			}

			@Override
			public void call(String target, StringBuilder builder,
					String indent) {

				if (LOGGER.isEnabled())
					LOGGER.indent("+ " + target);

				if ("body".equals(target)) {
					final Tree sequence = rule.getChild("sequence");
					final Tree returnValue = rule.getChild("return_value");

					final Tree body;
					if (returnValue == null)
						body = sequence;
					else {
						body = new Tree(Start.on("kg", "sequence"));
						for (int i = 0; i < sequence.getChildCount(); i++)
							body.addChild(sequence.getChild(i));
						body.addChild(returnValue);
					}

					addPart(body, builder, indent, bindings, unbindings);

				} else
					super.call(target, builder, indent);

				if (LOGGER.isEnabled())
					LOGGER.dedent();
			}
		};
	}

	private void addPart(Tree part, StringBuilder builder, String indent,
			List<String> bindings, List<String> unbindings) {

		final String name = part.getName();
		if (("sequence".equals(name) || "nested".equals(name))
				&& partCount(part) == 1) {
			addFirstPart(part, builder, indent, bindings, unbindings);

		} else {
			final String partial = getPartialName(name, part);
			TEMPLATE.apply(partial, builder, indent,
					partLogic(part, bindings, unbindings));
		}
	}

	private String unescaped(String identifier) {
		if (identifier.charAt(0) == '`')
			return identifier.substring(1);
		else
			return identifier;
	}

	private TemplateLogic partLogic(final Tree part,
			final List<String> bindings, final List<String> unbindings) {
		return new TemplateLogic() {
			@Override
			public String getValue(String name) {
				if (name.startsWith("unescaped:"))
					return unescaped(
							getValue(name.substring("unescaped:".length())));

				if (name.startsWith("unquoted:"))
					return unquoted(
							getValue(name.substring("unquoted:".length())));

				// Straight XPath...
				if (name.startsWith("xpath:"))
					return xpath(name.substring("xpath:".length()), part, null);

				// XPath with a fallback value...
				if (name.startsWith("xpath[")) {
					final int index = name.indexOf("]:");
					final String defaultText //
					= name.substring("xpath[".length(), index);
					return xpath(name.substring(index + "]:".length()), part,
							defaultText);
				}

				if ("text".equals(name))
					return part.getAllText();

				if ("fully_qualified_identifier".equals(name))
					return getFullyQualifiedIdentifier(part);

				return super.getValue(name);
			}

			@Override
			public void call(String target, StringBuilder builder,
					String indent) {
				if (LOGGER.isEnabled())
					LOGGER.indent("+ " + target);

				if ("all_part".equals(target))
					addAllParts(part, builder, indent, bindings, unbindings);

				else if ("last_part".equals(target))
					addLastPart(part, builder, indent, bindings, unbindings);

				else if ("first_part".equals(target))
					addFirstPart(part, builder, indent, bindings, unbindings);

				else if ("all_dispatch_literal".equals(target))
					addAllDispatchLiterals(part, builder, indent);

				else if ("all_dispatch_sequence".equals(target))
					addAllDispatchSequences(part, builder, indent, bindings,
							unbindings);

				else if ("all_binding".equals(target)) {
					if (bindings != null)
						for (String b : bindings) {
							builder.append(indent);
							builder.append(b);
						}

				} else if ("all_unbinding".equals(target)) {
					if (unbindings != null)
						for (String b : unbindings) {
							builder.append(indent);
							builder.append(b);
						}

				} else
					super.call(target, builder, indent);

				if (LOGGER.isEnabled())
					LOGGER.dedent();
			}
		};
	}

	private void addAllParts(Tree node, StringBuilder builder, String indent,
			List<String> bindings, List<String> unbindings) {

		boolean first = true;
		for (int i = 0; i < node.getChildCount(); i++) {
			Tree child = node.getChild(i);

			if (!child.isNode())
				continue;

			final String name = child.getName();
			if (!isPart(name))
				continue;

			if (!first)
				insertComma(builder);

			addPart(child, builder, indent, bindings, unbindings);
			first = false;
		}
	}

	private void insertComma(StringBuilder builder) {
		int lastParen = builder.lastIndexOf("\n");
		builder.insert(lastParen, ',');
	}

	private void addFirstPart(Tree node, StringBuilder builder, String indent,
			List<String> bindings, List<String> unbindings) {

		for (int i = 0; i < node.getChildCount(); i++) {
			Tree child = node.getChild(i);

			if (!child.isNode())
				continue;

			final String name = child.getName();

			if (!isPart(name))
				continue;

			addPart(child, builder, indent, bindings, unbindings);
			break;
		}
	}

	private void addLastPart(Tree node, StringBuilder builder, String indent,
			List<String> bindings, List<String> unbindings) {

		for (int i = node.getChildCount() - 1; i >= 0; i--) {
			Tree child = node.getChild(i);

			if (!child.isNode())
				continue;

			final String name = child.getName();

			if (!isPart(name))
				continue;

			addPart(child, builder, indent, bindings, unbindings);
			break;
		}
	}

	private void addAllDispatchLiterals(Tree dispatched, StringBuilder builder,
			String indent) {

		final List<Tree> children = dispatched.getChildren("dispatch");
		for (int i = 0; i < children.size(); i++) {
			Tree d = children.get(i);
			builder.append(indent);
			builder.append("\"");
			appendText(builder, d.getChild("literal"));
			builder.append(i < children.size() - 1 ? "\"," : "\"");
			builder.append(Encoding.lineSeparator());
		}
	}

	private void addAllDispatchSequences(Tree dispatched, StringBuilder builder,
			String indent, List<String> bindings, List<String> unbindings) {

		final List<Tree> children = dispatched.getChildren("dispatch");
		for (int i = 0; i < children.size(); i++) {
			Tree d = children.get(i);
			if (i > 0)
				insertComma(builder);
			addPart(d.getChild("sequence"), builder, indent, bindings,
					unbindings);
		}
	}

	private final Set<String> PART_NAMES = new HashSet<>();
	{
		PART_NAMES.add("sequence");
		PART_NAMES.add("as");
		PART_NAMES.add("star");
		PART_NAMES.add("plus");
		PART_NAMES.add("permutation");
		PART_NAMES.add("dispatched");
		PART_NAMES.add("nested");
		PART_NAMES.add("optional");
		PART_NAMES.add("skipping");
		PART_NAMES.add("negation");
		PART_NAMES.add("lookahead");
		PART_NAMES.add("noskip");
		PART_NAMES.add("tagged");
		PART_NAMES.add("ranged");
		PART_NAMES.add("identifier");
		PART_NAMES.add("scoped_identifier");
		PART_NAMES.add("literal");
		PART_NAMES.add("number");
		PART_NAMES.add("quoted_literal");
		PART_NAMES.add("any");
		PART_NAMES.add("dot");
		PART_NAMES.add("return_value");
		PART_NAMES.add("before");
		PART_NAMES.add("upto");
		PART_NAMES.add("balancing");
		PART_NAMES.add("pair");
		PART_NAMES.add("balanced");
		PART_NAMES.add("unbalanced");
		PART_NAMES.add("closure");
		PART_NAMES.add("todo");
		PART_NAMES.add("notempty");
	}

	private boolean isPart(String name) {
		return PART_NAMES.contains(name);
	}

	private int partCount(Tree node) {
		int count = 0;
		for (int i = 0; i < node.getChildCount(); i++) {
			Tree child = node.getChild(i);

			if (!child.isNode())
				continue;

			final String name = child.getName();

			if (isPart(name))
				count += 1;
		}
		return count;
	}

	private String getPartialName(String name, Tree node) {
		return name;
	}

	private void appendText(StringBuilder b, Tree tree) {
		// TODO Exclude comments.
		for (Token t : tree.getTokens())
			b.append(t.getText());
	}

	private String unquoted(String text) {
		if (text.startsWith("\"") || text.startsWith("'"))
			return text.substring(1, text.length() - 1);
		else
			return text;
	}

	private String xpath(String query, Tree part, String defaultValue) {
		final String allText = Jaxen.getAllText(part, query);
		if (allText == null)
			return defaultValue;
		else
			return allText;
	}

	/**
	 * Equivalent (I hope) to Properties.stringPropertyNames() in later Java
	 * versions.
	 */
	private Set<String> stringPropertyNames(Properties props) {
		Set<String> names = new HashSet<>();

		@SuppressWarnings("unchecked")
		final Enumeration<String> propertyNames = (Enumeration<String>) props
				.propertyNames();

		for (String name : Iterables.forEnumeration(propertyNames))
			names.add(name);

		return names;
	}

	private String getRuleName(final Tree rule) {
		return unescaped(rule.getChild("identifier").getAllText());
	}

	private String getFullyQualifiedRuleName(final Tree rule) {
		final String localName = getRuleName(rule);

		final Tree parent = rule.getParent();
		if (parent == null)
			return localName;
		else if (parent.isNode("rule") || parent.isNode("nested_rule"))
			return getFullyQualifiedRuleName(parent) + KGGrammar.SCOPE_SEPARATOR
					+ localName;
		else
			return localName;
	}

	private String getFullyQualifiedIdentifier(final Tree identifier) {
		// This name may be escaped. Which is fine, we'll match it against
		// another escaped name anyway.
		final String name = identifier.getAllText();

		// Find the rule this identifier is being used in.
		Tree rule = getOwningScope(identifier);
		while (rule != null) {
			// Check all rules which are defined directly inside it.
			final List<Tree> nestedRules = rule.getChildren("nested_rule");
			for (Tree nestedRule : nestedRules) {
				final String nestedRuleName //
						= nestedRule.getChild("identifier").getAllText();
				// If the names match, return the fully qualified name for the
				// rule we found.
				if (name.equals(nestedRuleName))
					return getFullyQualifiedRuleName(nestedRule);
			}
			// If there is no match in the scope of this rule then move up to
			// the scope which defines this rule.
			rule = getOwningScope(rule);
		}

		// If we find no match at all we just assume the name is a global and
		// return it (unescaped).
		return unescaped(name);
	}

	/**
	 * Retrieves the scope (rule or nested_rule) the given item was defined in.
	 */
	private Tree getOwningScope(Tree item) {
		Tree parent = item.getParent();
		while (parent != null //
				&& !parent.isNode("rule") //
				&& !parent.isNode("nested_rule"))
			parent = parent.getParent();
		return parent;
	}
}
