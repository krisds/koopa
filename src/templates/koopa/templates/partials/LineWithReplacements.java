package koopa.templates.partials;

import koopa.core.util.Encoding;
import koopa.templates.TemplateLogic;

public class LineWithReplacements implements Part {

	private final String[] parts;

	public LineWithReplacements(String[] parts) {
		this.parts = parts;
	}

	@Override
	public void applyTo(StringBuilder builder, String indent,
			TemplateLogic logic) {
		builder.append(indent);
		for (int i = 0; i < parts.length; i++) {
			if (i % 2 == 0)
				builder.append(parts[i]);
			else
				builder.append(logic.getValue(parts[i]));
		}

		builder.append(Encoding.lineSeparator());
	}
}
