package koopa.trees.antlr.filter.filters;

import koopa.trees.antlr.filter.Filter;

public class Log {

	private static int depth = 0;

	public static void enter(Filter filter) {
		depth += 1;
		log("Entered " + filter);
	}

	public static void exit(Filter filter) {
		log("Exited " + filter);
		depth -= 1;
	}

	public static void fail(Filter filter) {
		log("Failed " + filter);
		depth -= 1;
	}

	public static void log(String msg) {
		for (int i = 0; i < depth; i++) {
			System.out.print("  ");
		}

		System.out.println(msg);
	}
}
