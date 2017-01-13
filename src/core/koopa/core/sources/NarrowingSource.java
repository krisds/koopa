package koopa.core.sources;

import koopa.core.data.Data;
import koopa.core.data.Token;

/**
 * This class adapts a {@linkplain Source} of one type, say A, to become a
 * {@linkplain Source} of another type, say B, as long as B is a more specific
 * type than A.
 * <p>
 * <b>Note that this means you may lose data, as it will be filtered out when it
 * doesn't match the expected output type.</b>
 */
public class NarrowingSource<A extends Data, B extends A>
		extends ChainingSource<A, B> implements Source<B> {

	/**
	 * We need the original type at runtime. Sadly Java erases everything, so we
	 * have to track it ourselves.
	 */
	private final Class<B> clazz;

	public NarrowingSource(Source<A> source, Class<B> clazz) {
		super(source);
		this.clazz = clazz;
	}

	/**
	 * This discards anything which is not of the more specific type.
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected B nxt1() {
		while (true) {
			Data data = source.next();
			if (data == null)
				return null;
			else if (clazz.isInstance(data))
				return (B) data;
		}
	}

	public static <X extends Data, Y extends X> NarrowingSource<X, Y> narrowing(
			Source<X> source, Class<Y> clazz) {
		return new NarrowingSource<X, Y>(source, clazz);
	}
}
