package koopa.templates.partials;

import koopa.core.util.Encoding;
import koopa.templates.TemplateLogic;

public class VerbatimLine implements Part {

	private final String text;

	public VerbatimLine(String text) {
		this.text = text;
	}

	@Override
	public void applyTo(StringBuilder builder, String indent,
			TemplateLogic logic) {
		builder.append(indent);
		builder.append(text);
		builder.append(Encoding.lineSeparator());
	}
}
