package koopa.app.debug;

import java.io.File;
import java.io.IOException;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

import koopa.app.CobolParserFactory;
import koopa.app.debug.log.DataEvent;
import koopa.app.debug.log.DataEvent.Type;
import koopa.app.debug.log.ParseLog;
import koopa.cobol.parser.CobolParser;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.parsers.Parse;
import koopa.core.streams.BaseStream;
import koopa.core.targets.HoldingTarget;
import koopa.core.util.Files;

public class Code extends DefaultStyledDocument {

	private static final long serialVersionUID = 1L;

	private final File file;
	private int position = 0;
	private int event = 0;

	public Code(File file) {
		this.file = file;

		try {
			final String text = Files.getText(file);
			insertString(0, text, null);

			setCharacterAttributes(0, text.length(),
					CodeStyle.forUnparsed(this, false), true);

		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	public File getFile() {
		return file;
	}

	public void parse(CobolParserFactory factory, ParseLog log) {
		parse(factory.getParser(), log);
	}

	private void parse(CobolParser parser, ParseLog log) {
		try {
			clear();

			final Parse parse = parser.getParseSetup(file);

			log.setParse(parse);

			final BaseStream baseStream = parse.getFlow().getBaseStream();
			final HoldingTarget target = baseStream.getTarget();

			final ParsedDocumentBuilder observer = new ParsedDocumentBuilder(
					log);

			target.addObserver(observer);
			parser.parse(file, parse);
			target.removeObserver(observer);

			final int end = position;

			// Grab any pending tokens and add them to the document as unparsed.
			Data token = null;
			while ((token = parse.getStream().forward()) != null)
				insertUnparsed(token);

			// Restore the position in the document to the end of the parse.
			position = end;

			// Set the index in the event log to the last item.
			event = log.size() - 1;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void clear() {
		try {
			remove(0, getLength());
			position = 0;
			event = 0;

		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	private final class ParsedDocumentBuilder
			implements HoldingTarget.RawObserver {

		private final ParseLog log;

		public ParsedDocumentBuilder(ParseLog log) {
			this.log = log;
		}

		@Override
		public void pushed(Data data) {
			if (data == null)
				return;

			log.registerPush(data);
			insertData(data);
		}

		@Override
		public void popping(Data data) {
			if (data == null)
				return;

			log.registerPop(data);
			removeData(data);
		}
	}

	private void insertData(Data data) {
		try {
			if (!(data instanceof Token))
				return;

			final Token token = (Token) data;
			final String text = token.getText();

			final int start = position;
			final int length = text.length();

			if (position >= getLength()) {
				insertString(position, text, null);
				position = getLength();

			} else {
				position += length;
			}

			setCharacterAttributes(start, length,
					CodeStyle.forToken(token, Code.this), true);

		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	private void insertUnparsed(Data d) {
		if (!(d instanceof Token))
			return;
		
		try {
			final Token t = (Token) d;
			final String text = t.getText();

			final int start = position;
			final int length = text.length();

			if (position >= getLength()) {
				insertString(position, text, null);
				position = getLength();

			} else {
				position += length;
			}

			setCharacterAttributes(start, length,
					CodeStyle.forUnparsed(Code.this, false), true);

		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	private void removeData(Data last) {
		if (!(last instanceof Token))
			return;

		final Token token = (Token) last;

		final int length = token.getLength();
		position -= length;

		setCharacterAttributes(position, length,
				CodeStyle.forUnparsed(Code.this, false), true);
	}

	public void moveToEvent(int index, ParseLog log) {
		if (index == event) {
			// Already at selected event.

		} else if (event < index) {
			for (int i = event + 1; i <= index; i++)
				forward(log.getEvent(i).getData());

			event = index;

		} else {
			for (int i = event; i > index; i--)
				rewind(log.getEvent(i).getData());

			event = index;
		}
	}

	private void forward(Object event) {
		if (!(event instanceof DataEvent))
			return;

		final DataEvent dataEvent = (DataEvent) event;

		if (dataEvent.getType() == Type.PUSH)
			insertData(dataEvent.getData());
		else
			removeData(dataEvent.getData());
	}

	private void rewind(Object event) {
		if (!(event instanceof DataEvent))
			return;

		final DataEvent dataEvent = (DataEvent) event;

		if (dataEvent.getType() == Type.POP)
			insertData(dataEvent.getData());
		else
			removeData(dataEvent.getData());
	}
}
