package koopa.core.parsers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.grammars.combinators.Opt;
import koopa.core.sources.NullSource;
import koopa.core.sources.Source;
import koopa.core.targets.NullTarget;
import koopa.core.targets.Target;
import koopa.core.targets.WaterTagger;
import koopa.core.util.Tuple;

// TODO Take another look at this class, and split things up where useful.
public class Parse {

	private Stack stack;

	private Source<Token> source = new NullSource<Token>();
	private Target<Data> target = new NullTarget<Data>();
	private Stream stream = null;

	private Set<Opt> options = new HashSet<Opt>();

	private List<Tuple<Token, String>> warnings = new LinkedList<Tuple<Token, String>>();

	private Trace trace = new Trace();

	private Parse() {
		this.stack = new Stack();
	}

	public static Parse of(Source<Token> source) {
		return of(source, null);
	}

	public static Parse of(Source<Token> source, Target<Data> target) {
		Parse parse = new Parse();
		parse.setSource(source);
		parse.setTarget(target);
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

	public void setTarget(Target<Data> target) {
		if (target == null)
			target = new NullTarget<Data>();

		this.target = target;
	}

	public void setStream(Stream stream) {
		this.stream = stream;
		this.stream.setParse(this);
	}

	public Stream getStream() {
		if (stream == null)
			setStream(new BaseStream(source, new WaterTagger(target)));

		return stream;
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
		if (msg != null) {
			this.warnings.add(new Tuple<Token, String>(t, msg));
		}
	}

	public boolean hasWarnings() {
		return !this.warnings.isEmpty();
	}

	public List<Tuple<Token, String>> getWarnings() {
		return this.warnings;
	}

}
