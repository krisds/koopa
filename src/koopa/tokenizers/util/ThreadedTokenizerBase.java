package koopa.tokenizers.util;


import java.io.IOException;

import koopa.tokens.Token;

public abstract class ThreadedTokenizerBase {

	private boolean tokenizing = false;
	private SynchronizedTokenQueue queue = null;
	private boolean quit = false;

	private AssertionError error = null;

	public ThreadedTokenizerBase() {
		this.queue = new SynchronizedTokenQueue();
	}

	private void startTokenizing() {
		new Thread(new Runnable() {
			public void run() {
				try {
					tokenizing = true;
					tokenize();
					quitMe();
					quit();
					queue.inactivate();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				} catch (AssertionError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					error = e;
					quit();
				}
			}
		}, this.getClass().getSimpleName()).start();
	}

	/**
	 * Note: This method may <code>Thread.sleep(...)</code> at the end of its
	 * execution. It does this when the queue has too many elements in it. It
	 * then waits for its consumers to process those first.
	 */
	protected void enqueue(Token token) {
		queue.enqueue(token);

		while (!quit && queue.size() >= 100) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}
	}

	protected abstract void tokenize() throws IOException;

	public abstract void quit();

	public Token nextToken() {
		synchronized (this) {
			if (!tokenizing)
				startTokenizing();
		}

		if (error != null) {
			throw error;
		}

		return queue.nextToken();
	}

	protected void quitMe() {
		quit = true;
		queue.inactivate();
	}

	protected boolean hasQuit() {
		return quit;
	}
}
