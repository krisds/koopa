package koopa.app.debug;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JPanel;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;

import koopa.app.Application;
import koopa.app.HoldingCobolParserFactory;
import koopa.app.CobolParserFactory;
import koopa.app.Textual;
import koopa.app.components.progress.ProgressDialog;
import koopa.app.debug.log.ParseLog;
import koopa.app.debug.log.ParseLogAppender;
import koopa.app.debug.log.ParseLogWindow;

public class Debug extends JPanel implements HoldingCobolParserFactory, Textual {
	private static final long serialVersionUID = 1L;

	private final Application application;
	private final CobolParserFactory factory;

	private Code code = null;
	private CodeView view = null;

	private boolean parsing = false;
	private ParseLogWindow parseLogWindow = null;

	public Debug(Application application, File file,
			CobolParserFactory factory) {
		this.application = application;
		this.factory = new CobolParserFactory(factory);
		this.factory.setKeepingTrackOfTokens(true);

		setLayout(new BorderLayout());
		setupComponents();
		open(file);
		setBorder(null);
	}

	private void setupComponents() {
		view = new CodeView();
		add(view);
	}

	@Override
	public CobolParserFactory getCobolParserFactory() {
		return factory;
	}

	private void open(File file) {
		code = new Code(file);
		view.setStyledDocument(code);
		reload();
	}

	public void reload() {
		parsing = true;

		final ParseLog log = new ParseLog();
		Appender appender = new ParseLogAppender(log);

		final ProgressDialog progress = new ProgressDialog(
				application.getFrame(), "Recording parse...");
		progress.setVisible(true);
		new Thread(() -> {
			while (parsing) {
				try {
					progress.setMessage("Captured " + log.size()
							+ " events sofar...");
					Thread.sleep(250);
				} catch (InterruptedException e) {
				}
				progress.setMessage("Captured " + log.size() + " events.");
				progress.setDone();
			}
		}).start();

		Logger.getRootLogger().addAppender(appender);
		code.parse(factory, log);
		Logger.getRootLogger().removeAppender(appender);

		if (parseLogWindow == null) {
			parseLogWindow = new ParseLogWindow(code.getFile().getPath());
			parseLogWindow.getTable().addSelectionListener(index -> {
				final ParseLog log1 = parseLogWindow.getParseLog();
				code.moveToEvent(index, log1);
			});
		}

		parseLogWindow.setParseLog(log);
		parseLogWindow.setVisible(true);
		parsing = false;

		progress.setVisible(false);
	}

	public boolean isParsing() {
		return parsing;
	}

	@Override
	public boolean find(String pattern) {
		return view.find(pattern);
	}

	@Override
	public int getAdjustedLineCount() {
		return view.getAdjustedLineCount();
	}

	@Override
	public void scrollToLine(int line) {
		view.scrollToLine(line);
	}

	public void close() {
		if (parseLogWindow != null)
			parseLogWindow.setVisible(false);

		code = null;
		view = null;
		parseLogWindow = null;
	}
}
