package koopa.templates;

import java.util.HashMap;
import java.util.Map;

import koopa.templates.partials.CallTo;
import koopa.templates.partials.LineWithReplacements;
import koopa.templates.partials.Partial;
import koopa.templates.partials.VerbatimLine;

public class Template {

	private Map<String, Partial> partials = new HashMap<String, Partial>();
	private Partial beingDefined = null;

	public void definePartial(String name) {
		assert (beingDefined == null);

		beingDefined = new Partial();
		partials.put(name, beingDefined);
	}

	public void addVerbatimLine(String text) {
		assert (beingDefined != null);

		beingDefined.add(new VerbatimLine(text));
	}

	public void addLineWithReplacements(String[] parts) {
		assert (beingDefined != null);

		beingDefined.add(new LineWithReplacements(parts));
	}

	public void addCall(String indent, String target) {
		assert (beingDefined != null);

		beingDefined.add(new CallTo(target, indent));
	}

	public void end() {
		assert (beingDefined != null);

		beingDefined = null;
	}

	public void apply(String name, StringBuilder builder, String indent,
			TemplateLogic logic) {
		assert (hasPartial(name)) : "Missing partial for '" + name + "'.";

		partials.get(name).applyTo(builder, indent, logic);
	}

	public String apply(String name, TemplateLogic logic) {
		assert (hasPartial(name));

		StringBuilder builder = new StringBuilder();
		apply(name, builder, "", logic);
		return builder.toString();
	}

	public boolean hasPartial(String name) {
		return partials.containsKey(name);
	}
}
