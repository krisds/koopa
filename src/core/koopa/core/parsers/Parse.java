package koopa.core.parsers;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.grammars.combinators.Opt;
import koopa.core.sources.NullSource;
import koopa.core.sources.Source;
import koopa.core.targets.CompositeTarget;
import koopa.core.targets.NullTarget;
import koopa.core.targets.Target;
import koopa.core.targets.WaterTagger;
import koopa.core.util.Tuple;

// TODO Take another look at this class, and split things up where useful.
public class Parse {

	private Stack stack;

	private Source<Token> source = new NullSource<Token>();
	private List<Target<Data>> targets = new LinkedList<Target<Data>>();
	private Stream stream = null;

	private Set<Opt> options = new HashSet<Opt>();

	private List<Tuple<Token, String>> warnings = new LinkedList<Tuple<Token, String>>();
	private List<Tuple<Token, String>> errors = new LinkedList<Tuple<Token, String>>();

	private Trace trace = new Trace();

	private Parse() {
		this.stack = new Stack();
	}

	public static Parse of(Source<Token> source) {
		Parse parse = new Parse();
		parse.setSource(source);
		return parse;
	}

	public Stack getStack() {
		return stack;
	}

	public void setSource(Source<Token> source) {
		if (source == null)
			source = new NullSource<Token>();

		this.source = source;
	}

	public void addTarget(Target<Data> target) {
		if (target != null)
			targets.add(target);
	}

	public Parse to(Target<Data> target) {
		addTarget(target);
		return this;
	}

	public void setStream(Stream stream) {
		this.stream = stream;
		this.stream.setParse(this);
	}

	public Stream getStream() {
		if (stream == null) {
			if (targets.isEmpty())
				setStream(new BaseStream(source, new NullTarget<Data>()));
			else
				setStream(new BaseStream(source, new WaterTagger(all(targets))));
		}

		return stream;
	}

	private Target<Data> all(List<Target<Data>> targets) {
		if (targets.size() == 1)
			return targets.get(0);

		CompositeTarget<Data> composite = new CompositeTarget<Data>();
		for (Target<Data> target : targets)
			composite.addTarget(target);
		return composite;
	}

	public Trace getTrace() {
		return trace;
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

	@SuppressWarnings("unchecked")
	public <T extends Target<Data>> T getTarget(Class<T> clazz) {
		for (Target<Data> target : targets)
			if (clazz.isInstance(target))
				return (T) target;

		return null;
	}

	public void removeTarget(Class<? extends Target<Data>> clazz) {
		Target<Data> target = getTarget(clazz);
		if (target != null)
			targets.remove(target);
	}
}
