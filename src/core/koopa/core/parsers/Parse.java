package koopa.core.parsers;

import java.util.HashSet;
import java.util.Set;

import koopa.core.data.Position;
import koopa.core.parsers.Stack.Frame;
import koopa.core.parsers.combinators.Opt;
import koopa.core.sources.Source;
import koopa.core.streams.Flow;
import koopa.core.targets.Target;

public class Parse {

	private final Stack stack;
	private final Trace trace;
	private final Messages messages;
	private final Flow flow;

	// TODO Move these to Stack ?
	private Position finalPosition = Position.ZERO;
	private Frame finalFrame = null;

	private Set<Opt> options = new HashSet<>();

	private Parse() {
		this.stack = new Stack();
		this.trace = new Trace();
		this.messages = new Messages();
		this.flow = new Flow(this);
	}

	private Parse(Trace trace, Messages messages) {
		this.stack = new Stack();
		this.trace = trace;
		this.messages = messages;
		this.flow = new Flow(this);
	}

	public Parse ofNested(Source source) {
		// TODO Shared stack ?
		final Parse parse = new Parse(trace, messages);
		parse.getFlow().setSource(source);
		return parse;
	}

	public static Parse of(Source source) {
		Parse parse = new Parse();
		parse.getFlow().setSource(source);
		return parse;
	}

	public Parse to(Target target) {
		flow.addTarget(target);
		return this;
	}

	public <T extends Source> T getSource(Class<T> clazz) {
		return flow.getSource(clazz);
	}

	public <T extends Target> T getTarget(Class<T> clazz) {
		return flow.getTarget(clazz);
	}

	public void done() {
		// TODO stack.done() ?
		// TODO trace.done() ?
		flow.done();
	}

	public Stack getStack() {
		return stack;
	}

	public Trace getTrace() {
		return trace;
	}

	public Flow getFlow() {
		return flow;
	}

	public Stream getStream() {
		return flow.getStream();
	}

	public Messages getMessages() {
		return messages;
	}

	public boolean getOption(Opt noskip) {
		throw new UnsupportedOperationException();
	}

	public boolean isSet(Opt opt) {
		return options.contains(opt);
	}

	public void set(Opt opt, boolean on) {
		if (on)
			options.add(opt);
		else
			options.remove(opt);
	}

	public Position getFinalPosition() {
		return finalPosition;
	}

	public Frame getFinalFrame() {
		return finalFrame;
	}

	public void setFinalMatch(Position position, Frame frame) {
		this.finalPosition = position;
		this.finalFrame = frame;
	}

	// ========================================================================

	private static int hashCounter = 0;
	private final int HASHCODE = hashCounter++;

	/**
	 * For {@linkplain Parse} instances, equality boils down to object identity.
	 */
	@Override
	public boolean equals(Object obj) {
		return this == obj;
	}

	/**
	 * Hashcodes for {@linkplain Parse} objects are nothing more than a
	 * sequentially generated identifier.
	 */
	@Override
	public int hashCode() {
		return HASHCODE;
	}
}
