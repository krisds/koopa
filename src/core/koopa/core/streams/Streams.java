package koopa.core.streams;

import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.parsers.BaseStream;
import koopa.core.parsers.LimitedStream;
import koopa.core.parsers.Parse;
import koopa.core.parsers.Stream;
import koopa.core.sources.NullSource;
import koopa.core.sources.Source;
import koopa.core.targets.CompositeTarget;
import koopa.core.targets.NullTarget;
import koopa.core.targets.Target;
import koopa.core.targets.WaterTagger;

public class Streams {

	private final Parse parse;

	private Source<Token> source = new NullSource<Token>();
	private List<Target<Data>> targets = new LinkedList<Target<Data>>();

	private WaterTagger waterTagger;

	private BaseStream base = null;
	private LimitedStream limited = null;

	private boolean limitsEnabled = true;

	public Streams(Parse parse) {
		this.parse = parse;
	}

	public Stream getStream() {
		if (limitsEnabled && limited != null && limited.hasLimiters())
			return limited;
		else
			return getBaseStream();
	}

	public BaseStream getBaseStream() {
		if (base != null)
			return base;

		if (targets.isEmpty())
			base = new BaseStream(source, new NullTarget<Data>());
		else {
			waterTagger = new WaterTagger(all(targets));
			base = new BaseStream(source, waterTagger);
		}

		base.setParse(parse);

		return base;
	}

	public LimitedStream getLimitedStream() {
		if (limited != null)
			return limited;

		limited = new LimitedStream(getBaseStream());
		limited.setParse(parse);

		return limited;
	}

	private Target<Data> all(List<Target<Data>> targets) {
		if (targets.size() == 1)
			return targets.get(0);

		CompositeTarget<Data> composite = new CompositeTarget<Data>();
		for (Target<Data> target : targets)
			composite.addTarget(target);
		return composite;
	}

	public void done() {
		// Some of our sources may be threaded. We need to make sure that any
		// threads they hold get stopped. This is what we do here. The message
		// will get passed along the chain of sources, giving each a chance
		// to stop running.
		source.close();

		// While there are no threaded targets at the time of writing, we do
		// want to give them a chance to clean up on completion of the parse.
		for (Target<?> target : targets)
			target.done();

		if (waterTagger != null)
			waterTagger.done();
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

	public <T extends Source<? extends Data>> T getSource(Class<T> clazz) {
		if (source == null)
			return null;
		else
			return source.getSource(clazz);
	}

	public Source<Token> getSource() {
		return source;
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

	public void setLimitsEnabled(boolean enabled) {
		limitsEnabled = enabled;
	}

	public boolean getLimitsEnabled() {
		return limitsEnabled;
	}

	@Deprecated
	public void disableLimits() {
		limitsEnabled = false;
	}

	@Deprecated
	public void enableLimits() {
		limitsEnabled = true;
	}
}
