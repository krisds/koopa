package koopa.core.util;

import java.util.WeakHashMap;

public class Memo {

	private static final WeakHashMap<String, Memo> MEMOS = new WeakHashMap<>();
	private final WeakHashMap<Object, Object> memos = new WeakHashMap<>();

	private Memo() {
	}

	public static Memo forSubject(String subject) {
		return MEMOS.computeIfAbsent(subject, s -> new Memo());
	}

	public void put(Object key, Object value) {
		memos.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Object key, Class<T> clazz) {
		return (T) memos.get(key);
	}
}
