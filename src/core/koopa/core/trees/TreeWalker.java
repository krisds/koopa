package koopa.core.trees;

/**
 * Utility class for walking a {@linkplain Tree} depth-first.
 */
public class TreeWalker {

	/**
	 * This stores the state at a certain point in the traversal. You can use
	 * these to restore the state to any point.
	 */
	public final class State {
		private final Tree scope;
		private final Tree current;
		private final boolean started;
		private final boolean skip;

		private State(TreeWalker walker) {
			this.scope = walker.scope;
			this.current = walker.current;
			this.started = walker.started;
			this.skip = walker.skip;
		}

		private void apply(TreeWalker walker) {
			walker.scope = this.scope;
			walker.current = this.current;
			walker.started = this.started;
			walker.skip = this.skip;
		}

		@Override
		public String toString() {
			return "[" + current + "//" + scope + "]";
		}
	}

	private Tree scope = null;

	/** Have we started the walk ? */
	private boolean started = false;

	/** Have we been asked to skip a subtree ? */
	private boolean skip = false;

	/** Where are we in the walk ? */
	private Tree current = null;

	public TreeWalker(Tree scope) {
		this.scope = scope;
	}

	/**
	 * Get the next {@linkplain Tree} in the walk.
	 */
	public Tree next() {
		if (skip) {
			skip = false;

			if (right() || upAndRight())
				return current;

			current = null;
			return current;
		}

		if (done() || start() || down() || right() || upAndRight())
			return current;

		current = null;
		return current;
	}

	/**
	 * Are we at the end of the tree ?
	 */
	private boolean done() {
		return started && current == null;
	}

	/**
	 * If we're not already walking the tree, this starts doing so.
	 */
	private boolean start() {
		if (started)
			return false;

		started = true;
		current = scope;
		return true;
	}

	/**
	 * If the current node has children, this moves to the first child.
	 */
	private boolean down() {
		if (current.getChildCount() == 0)
			return false;

		current = current.getChild(0);
		return true;
	}

	/**
	 * If the current node has a sibling following it, this moves to that
	 * sibling.
	 */
	private boolean right() {
		if (current == scope)
			return false;

		final Tree parent = current.getParent();
		if (parent == null)
			return false;

		final int siblingIndex = current.getChildIndex() + 1;
		if (siblingIndex >= parent.getChildCount())
			return false;

		current = parent.getChild(siblingIndex);
		return true;
	}

	/**
	 * If the current tree has a parent, and it is not the same as the scope,
	 * this moves to that parent.
	 */
	private boolean up() {
		if (current == scope)
			return false;

		final Tree parent = current.getParent();

		if (parent == null)
			return false;

		current = parent;
		return true;
	}

	/**
	 * Tries to walk up until it can go right. Which it will do if it can.
	 */
	private boolean upAndRight() {
		final Tree temp = current;

		while (up())
			if (right())
				return true;

		current = temp;
		return false;
	}

	/**
	 * Makes it so that nothing else in the given tree will be seen.
	 * <p>
	 * <b>Note.</b> This assumes that the current position is somewhere in the
	 * given subtree, but there is no explicit check that this is indeed true...
	 */
	public void skipRemainderOfTree(Tree toBeSkipped) {
		current = toBeSkipped;
		skip = true;
	}

	public Tree getCurrent() {
		return current;
	}

	/**
	 * Get a memento containing the current state of the TreeWalker.
	 */
	public State getState() {
		return new State(this);
	}

	/**
	 * Set the state of this TreeWalker to a previous configuration (retrieved
	 * via {@linkplain #getState()}).
	 */
	public void setState(State state) {
		state.apply(this);
	}

	public Tree getScope() {
		return scope;
	}
}
