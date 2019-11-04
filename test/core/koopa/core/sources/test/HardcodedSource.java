package koopa.core.sources.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import koopa.core.data.Data;
import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.sources.BasicSource;
import koopa.core.sources.Source;

/**
 * Simple source of tokens which accepts a list of strings and tags, and returns
 * them in sequence as tokens. Token positions are calculated from the length of
 * the individual strings. Tags are added to the following string.
 * <p>
 * <b>For testing purposes only.</b>
 */
public class HardcodedSource extends BasicSource
		implements Source {

	private final List<Data> data;
	private int index;

	public HardcodedSource(List<Data> tagsAndTokens) {
		this.data = tagsAndTokens;
		this.index = 0;
	}

	@Override
	public Data nxt1() {
		if (index >= data.size())
			return null;
		else
			return data.get(index++);
	}

	@Override
	public void close() {
	}

	public static HardcodedSource from(Object... objects) {
		return from(Arrays.asList(objects));
	}
	
	public static HardcodedSource from(List<Object> objects) {
		final List<Data> data = new ArrayList<>();
		
		Position p = new Position(0, 0, 0);
		final List<Object> tags = new ArrayList<>();
		for (Object o : objects) {
			if (o instanceof Data) {
				data.add((Data) o);
				tags.clear();
				continue;
			}
			
			if (o instanceof String) {
				final String s = (String) o;
				final Position start = p.offsetBy(1);
				final Position end = start.offsetBy(s.length() - 1);
				data.add(new Token(s, start, end).withTags(tags.toArray()));
				tags.clear();
				p = end;
				continue;
			}
			
			tags.add(o);
		}
		
		return new HardcodedSource(data);
	}
}
