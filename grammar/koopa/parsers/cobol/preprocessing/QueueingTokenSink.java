package koopa.parsers.cobol.preprocessing;

import java.util.LinkedList;

import koopa.core.data.Data;
import koopa.core.targets.Target;

public class QueueingTokenSink implements Target<Data> {

	private LinkedList<Data> tokens = null;

	public QueueingTokenSink() {
		this.tokens = new LinkedList<Data>();
	}


	@Override
	public void push(Data data) {
		synchronized (this.tokens) {
			this.tokens.add(data);
		}
	}
	public Data next() {
		synchronized (this.tokens) {
			if (this.tokens.isEmpty()) {
				// System.out.println("---- EMPTY");
				return null;
			} else {
				Data head = this.tokens.removeFirst();
				// System.out.println("---- " + head);
				return head;
			}
		}
	}
}
