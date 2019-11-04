package koopa.core.util;

import java.util.WeakHashMap;

public class Memo {

	private static final WeakHashMap<String, Memo> MEMOS = new WeakHashMap<>();
	private final WeakHashMap<Object, Object> memos = new WeakHashMap<>();

	private Memo() {
	}

	public static Memo forSubject(String subject) {
		Memo memo = MEMOS.get(subject);

		if (memo == null) {
			memo = new Memo();
			MEMOS.put(subject, memo);
		}

		return memo;
	}

	public void put(Object key, Object value) {
		memos.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Object key, Class<T> clazz) {
		return (T) memos.get(key);
	}
}
