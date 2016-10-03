package koopa.core.parsers;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import koopa.core.data.Data;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.parsers.Stack.Frame;
import koopa.core.parsers.combinators.Opt;
import koopa.core.sources.Source;
import koopa.core.streams.Streams;
import koopa.core.targets.Target;
import koopa.core.util.Tuple;

// TODO Take another look at this class, and split things up where useful.
public class Parse {

	private final Stack stack;
	private final Streams streams;
	private final Trace trace;

	// TODO Move these to Stack ?
	private Position finalPosition = Position.ZERO;
	private Frame finalFrame = null;

	private Set<Opt> options = new HashSet<Opt>();

	private List<Tuple<Token, String>> warnings = new LinkedList<Tuple<Token, String>>();
	private List<Tuple<Token, String>> errors = new LinkedList<Tuple<Token, String>>();


	private Parse() {
		this.stack = new Stack();
		this.trace = new Trace();
		this.streams = new Streams(this);
	}

	public static Parse of(Source<Token> source) {
		Parse parse = new Parse();
		parse.getStreams().setSource(source);
		return parse;
	}

	public Parse to(Target<Data> target) {
		streams.addTarget(target);
		return this;
	}

	public <T extends Source<? extends Data>> T getSource(Class<T> clazz) {
		return streams.getSource(clazz);
	}

	public <T extends Target<Data>> T getTarget(Class<T> clazz) {
		return streams.getTarget(clazz);
	}

	public void done() {
		// TODO stack.done() ?
		// TODO trace.done() ?
		streams.done();
	}

	public Stack getStack() {
		return stack;
	}

	public Trace getTrace() {
		return trace;
	}

	public Streams getStreams() {
		return streams;
	}
	
	public Stream getStream() {
		return streams.getStream();
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

	public void warn(Token t, String msg) {
		if (msg != null)
			warnings.add(new Tuple<Token, String>(t, msg));
	}

	public boolean hasWarnings() {
		return !warnings.isEmpty();
	}

	public List<Tuple<Token, String>> getWarnings() {
		return Collections.unmodifiableList(warnings);
	}

	public int getWarningCount() {
		return warnings.size();
	}

	public Tuple<Token, String> getWarning(int index) {
		return warnings.get(index);
	}

	public void error(Token t, String msg) {
		if (msg != null)
			errors.add(new Tuple<Token, String>(t, msg));
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public List<Tuple<Token, String>> getErrors() {
		return Collections.unmodifiableList(errors);
	}

	public int getErrorCount() {
		return errors.size();
	}

	public Tuple<Token, String> getError(int index) {
		return errors.get(index);
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
