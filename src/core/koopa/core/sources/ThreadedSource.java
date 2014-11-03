package koopa.core.sources;

import java.io.IOException;

import koopa.core.data.Data;
import koopa.core.util.SynchronizedQueue;

/**
 * Base for implementing a {@linkplain Source} where the data gets generated in
 * a separate thread.
 */
public abstract class ThreadedSource<T extends Data> extends BasicSource<T>
		implements Source<T> {

	private boolean tokenizing = false;
	private SynchronizedQueue<T> queue = null;
	private boolean closed = false;

	private AssertionError error = null;

	public ThreadedSource() {
		this("");
	}

	public ThreadedSource(String name) {
		this.queue = new SynchronizedQueue<T>(name);
	}

	/**
	 * This is the main function which gets run in the worker thread. Subclasses
	 * should implement this, and generate all data items in a continuous
	 * process. Each piece of data should be passed into the
	 * {@linkplain #enqueue(Data)} method, which will make the data available to
	 * clients of the source.
	 */
	protected abstract void tokenize() throws IOException;

	private void startTokenizing() {
		new Thread(new Runnable() {
			public void run() {
				try {
					tokenizing = true;
					tokenize();
					close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				} catch (AssertionError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					error = e;
					close();
				}
			}
		}, this.getClass().getSimpleName()).start();
	}

	/**
	 * Note: This method {@link Thread#yield()}s at the end of its execution.
	 */
	protected void enqueue(T token) {
		queue.enqueue(token);

		Thread.yield();
	}

	protected T nxt1() {
		synchronized (this) {
			if (!tokenizing)
				startTokenizing();
		}

		if (error != null)
			throw error;

		return queue.next();
	}

	/**
	 * <b>Subclasses which want to override this behaviour must call this as
	 * their first step!</b>
	 */
	public void close() {
		closed = true;
		queue.close();
	}

	protected boolean hasClosed() {
		return closed;
	}
}
