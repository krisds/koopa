package koopa.core.parsers.combinators;

import koopa.core.parsers.Parse;

/**
 * Java 8 would call these lambdas. :-)
 */
public interface Block {
	public void apply(Parse parse);
}
