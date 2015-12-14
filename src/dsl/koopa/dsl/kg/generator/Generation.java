package koopa.dsl.kg.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import koopa.core.data.Token;
import koopa.core.data.markers.Start;
import koopa.core.trees.Tree;
import koopa.core.util.Encoding;
import koopa.core.util.Iterables;
import koopa.templates.Template;
import koopa.templates.TemplateLogic;

public class Generation {

	private final Template TEMPLATE;

	public Generation(Template template) {
		this.TEMPLATE = template;
	}

	public String generate(File grammarFile, Tree ast) throws IOException {

		File path = grammarFile.getParentFile();

		// Each grammar should have an associated properties file containing
		// some extra info needed for creating a valid Java class. We don't make
		// this part of the actual grammar file because we want to keep any
		// native stuff out of there.
		Properties meta = new Properties();

		File propertiesFile = new File(path, grammarFile.getName().replace(
				".kg", ".properties"));
		meta.load(new FileInputStream(propertiesFile));

		// One of the things the properties file should define are all the
		// required imports. We collect them here into actual valid Java import
		// statements.
		final List<String> additionalImports = new LinkedList<String>();
		for (String key : stringPropertyNames(meta)) {
			if (key.startsWith("import.")) {
				final String importName = key.substring("import.".length());
				final String packageName = meta.getProperty(key);
				additionalImports.add("import " + packageName + "."
						+ importName + ";");

			} else if (key.startsWith("static.")) {
				final String importName = key.substring("static.".length());
				final String packageName = meta.getProperty(key);
				additionalImports.add("import static " + packageName + "."
						+ importName + ";");
			}
		}

		return toCode(ast, meta, additionalImports);
	}

	private String toCode(Tree ast, final Properties meta,
			List<String> additionalImports) {

		StringBuilder code = new StringBuilder();

		if (!ast.isNode("grammar"))
			throw new InternalError(
					"Was expecting a syntax tree for a Koopa grammar." + ast);

		TEMPLATE.apply("grammar", code, "",
				grammarLogic(ast, meta, additionalImports));

		return code.toString();
	}

	private TemplateLogic grammarLogic(final Tree ast, final Properties meta,
			final List<String> additionalImports) {
		return new TemplateLogic() {
			{
				setValue("name",
						ast.getDescendant("header", "grammar_name", "name")
								.getAllText());

				final Tree base = ast
						.getDescendant("header", "extends", "name");
				setValue("extending", //
						base != null ? base.getAllText() : "Koopa");

				setValue("package", meta.getProperty("package"));
			}

			public void call(String target, StringBuilder builder, String indent) {
				if ("user_imports".equals(target))
					for (String imp : additionalImports) {
						builder.append(indent);
						builder.append(imp);
						builder.append(Encoding.lineSeparator());
					}

				else if ("rules".equals(target))
					for (Tree rule : ast.getChildren("rule"))
						TEMPLATE.apply("rule", builder, indent, ruleLogic(rule));

				else
					super.call(target, builder, indent);
			}

		};
	}

	private TemplateLogic ruleLogic(final Tree rule) {
		return new TemplateLogic() {

			private List<String> bindings = new LinkedList<String>();
			private List<String> unbindings = new LinkedList<String>();

			{
				setValue("name", rule.getChild("identifier").getAllText());

				final boolean allowKeywords = rule.getDescendant("nokeywords") == null;
				final boolean hasPrivateModifier = rule.getDescendant(
						"modifier", "private") != null;
				final boolean hasHidingModifier = rule.getDescendant(
						"modifier", "hiding") != null;

				setValue("allowKeywords", allowKeywords ? "true" : "false");
				setValue("modifier", hasPrivateModifier ? "protected"
						: "public");
				setValue("visibility", hasPrivateModifier ? "PRIVATE"
						: hasHidingModifier ? "HIDING" : "PUBLIC");

				final Tree locals = rule.getChild("local-variables");
				if (locals != null) {
					List<Tree> declarations = locals.getChildren("declaration");
					for (final Tree decl : declarations) {
						TemplateLogic l = new TemplateLogic() {
							{
								setValue("type", decl.getChild("type")
										.getAllText());
								setValue("name", decl.getChild("name")
										.getAllText());
							}
						};

						bindings.add(TEMPLATE.apply("binding", l));
						unbindings.add(TEMPLATE.apply("unbinding", l));
					}
				}
			}

			public void call(String target, StringBuilder builder, String indent) {
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

	private TemplateLogic partLogic(final Tree part,
			final List<String> bindings, final List<String> unbindings) {
		return new TemplateLogic() {
			public String getValue(String name) {
				if ("text".equals(name))
					return part.getAllText();

				if (name.startsWith("text_of_"))
					return part.getChild(name.substring("text_of_".length()))
							.getAllText();

				if ("unquoted_text".equals(name))
					return unquoted(part.getAllText());

				return super.getValue(name);
			}

			public void call(String target, StringBuilder builder, String indent) {
				if ("all_part".equals(target))
					addAllParts(part, builder, indent, bindings, unbindings);

				else if ("last_part".equals(target))
					addLastPart(part, builder, indent, bindings, unbindings);

				else if ("first_part".equals(target))
					addFirstPart(part, builder, indent, bindings, unbindings);

				else if ("limiter".equals(target))
					addFirstPart(part.getChild("limiter"), builder, indent,
							bindings, unbindings);

				else if ("all_dispatch_literal".equals(target))
					addAllDispatchLiterals(part, builder, indent);

				else if ("all_dispatch_sequence".equals(target))
					addAllDispatchSequences(part, builder, indent, bindings,
							unbindings);

				else if ("limited_and_comma".equals(target)) {
					addFirstPart(part.getChild("limited"), builder, indent,
							bindings, unbindings);
					insertComma(builder);

				} else if ("all_binding".equals(target)) {
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
		int lastParen = builder.lastIndexOf(")");
		builder.insert(lastParen + 1, ',');
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

	private void addAllDispatchSequences(Tree dispatched,
			StringBuilder builder, String indent, List<String> bindings,
			List<String> unbindings) {

		final List<Tree> children = dispatched.getChildren("dispatch");
		for (int i = 0; i < children.size(); i++) {
			Tree d = children.get(i);
			if (i > 0)
				insertComma(builder);
			addPart(d.getChild("sequence"), builder, indent, bindings,
					unbindings);
		}
	}

	private final Set<String> PART_NAMES = new HashSet<String>();
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
		PART_NAMES.add("limited");
		PART_NAMES.add("noskip");
		PART_NAMES.add("tagged");
		PART_NAMES.add("assign");
		PART_NAMES.add("identifier");
		PART_NAMES.add("literal");
		PART_NAMES.add("number");
		PART_NAMES.add("quoted_literal");
		PART_NAMES.add("native_code");
		PART_NAMES.add("any");
		PART_NAMES.add("dot");
		PART_NAMES.add("return_value");
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
		if ("skipping".equals(name)) {
			if (node.getChild("limited") == null)
				return "skip_to";
			else
				return "limited";
		}

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

	/**
	 * Equivalent (I hope) to Properties.stringPropertyNames() in later Java
	 * versions.
	 */
	private Set<String> stringPropertyNames(Properties props) {
		Set<String> names = new HashSet<String>();

		@SuppressWarnings("unchecked")
		final Enumeration<String> propertyNames = (Enumeration<String>) props
				.propertyNames();

		for (String name : Iterables.forEnumeration(propertyNames))
			names.add(name);

		return names;
	}
}
