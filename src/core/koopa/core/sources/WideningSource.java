package koopa.core.sources;

import koopa.core.data.Data;

/**
 * This class adapts a {@linkplain Source} of one type, say A, to become a
 * {@linkplain Source} of another type, say B, as long as B is a less specific
 * type than A.
 */
public class WideningSource<B extends Data, A extends B>
		extends ChainingSource<A, B> implements Source<B> {

	/**
	 * We need the original type at runtime. Sadly Java erases everything, so we
	 * have to track it ourselves.
	 */
	private final Class<A> clazz;

	public WideningSource(Source<A> source, Class<A> clazz) {
		super(source);
		this.clazz = clazz;
	}

	@Override
	protected B nxt1() {
		return source.next();
	}

	/**
	 * If we unshift something which is less specific than the original type, we
	 * just discard it.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void unshift(B data) {
		if (clazz.isInstance(data))
			source.unshift((A) data);
	}
	

	public static <Y extends Data, X extends Y> WideningSource<Y, X> widening(
			Class<Y> clazzY, Source<X> source, Class<X> clazz) {
		return new WideningSource<Y, X>(source, clazz);
	}
}
