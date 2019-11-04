package koopa.core.streams;

import java.util.LinkedList;
import java.util.List;

import koopa.core.parsers.Parse;
import koopa.core.parsers.Stream;
import koopa.core.sources.NullSource;
import koopa.core.sources.Source;
import koopa.core.targets.CompositeTarget;
import koopa.core.targets.NullTarget;
import koopa.core.targets.Target;
import koopa.core.targets.WaterTagger;

// TODO Better name ?
public class Flow {

	private final Parse parse;

	private Source source = new NullSource();
	private List<Target> targets = new LinkedList<>();

	private WaterTagger waterTagger;

	private BaseStream base = null;
	private LimitedStream limited = null;

	private boolean limitsEnabled = true;

	public Flow(Parse parse) {
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
			base = new BaseStream(source, new NullTarget());
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

	private Target all(List<Target> targets) {
		if (targets.size() == 1)
			return targets.get(0);

		CompositeTarget composite = new CompositeTarget();
		for (Target target : targets)
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
		//
		// If there's a WaterTagger, it will call done on all targets.
		if (waterTagger != null)
			waterTagger.done();
		else
			for (Target target : targets)
				target.done();

	}

	public void setSource(Source source) {
		if (source == null)
			source = new NullSource();

		this.source = source;
	}

	public void addTarget(Target target) {
		if (target != null)
			targets.add(target);
	}

	public <T extends Source> T getSource(Class<T> clazz) {
		if (source == null)
			return null;
		else
			return source.getSource(clazz);
	}

	public Source getSource() {
		return source;
	}

	@SuppressWarnings("unchecked")
	public <T extends Target> T getTarget(Class<T> clazz) {
		for (Target target : targets)
			if (clazz.isInstance(target))
				return (T) target;

		return null;
	}

	public void removeTarget(Class<? extends Target> clazz) {
		Target target = getTarget(clazz);
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
