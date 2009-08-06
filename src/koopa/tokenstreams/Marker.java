package koopa.tokenstreams;

import koopa.tokens.BasicToken;

public abstract class Marker extends BasicToken {

	private boolean committed = false;

	public Marker() {
		super(null, null, null);
	}

	public boolean wasCommitted() {
		return this.committed;
	}

	public void commit() {
		this.committed = true;
	}
	
	public abstract String getName();
}
