package koopa.templates.partials;

import koopa.templates.TemplateLogic;

public class CallTo implements Part {

	private final String target;
	private final String indent;

	public CallTo(String target, String indent) {
		this.target = target;
		this.indent = indent;
	}

	@Override
	public void applyTo(StringBuilder builder, String indent,
			TemplateLogic logic) {
		logic.call(target, builder, indent + this.indent);
	}
}
