package koopa.templates.partials;

import koopa.templates.TemplateLogic;

public interface Part {

	void applyTo(StringBuilder builder, String indent, TemplateLogic logic);

}
