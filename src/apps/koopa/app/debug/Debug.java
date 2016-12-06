package koopa.app.debug;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JPanel;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;

import koopa.app.Application;
import koopa.app.Textual;
import koopa.app.components.progress.ProgressDialog;
import koopa.app.debug.log.ParseLog;
import koopa.app.debug.log.ParseLogAppender;
import koopa.app.debug.log.ParseLogTable;
import koopa.app.debug.log.ParseLogWindow;
import koopa.cobol.parser.Coordinated;
import koopa.cobol.parser.ParsingCoordinator;

public class Debug extends JPanel implements Coordinated, Textual {
	private static final long serialVersionUID = 1L;

	private final Application application;
	private final ParsingCoordinator coordinator;

	private Code code = null;
	private CodeView view = null;

	private boolean parsing = false;
	private ParseLogWindow parseLogWindow = null;

	public Debug(Application application, File file,
			ParsingCoordinator parsingCoordinator) {
		this.application = application;
		this.coordinator = new ParsingCoordinator(parsingCoordinator);
		this.coordinator.setKeepingTrackOfTokens(true);

		setLayout(new BorderLayout());
		setupComponents();
		open(file);
		setBorder(null);
	}

	private void setupComponents() {
		view = new CodeView();
		add(view);
	}

	public ParsingCoordinator getParsingCoordinator() {
		return coordinator;
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
		new Thread(new Runnable() {
			public void run() {
				while (parsing) {
					try {
						progress.setMessage(
								"Captured " + log.size() + " events sofar...");
						Thread.sleep(250);
					} catch (InterruptedException e) {
					}
					progress.setMessage("Captured " + log.size() + " events.");
					progress.setDone();
				}
			}
		}).start();

		Logger.getRootLogger().addAppender(appender);
		code.parse(coordinator, log);
		Logger.getRootLogger().removeAppender(appender);

		if (parseLogWindow == null) {
			parseLogWindow = new ParseLogWindow(code.getFile().getPath());
			parseLogWindow.getTable().addSelectionListener(
					new ParseLogTable.SelectionListener() {
						public void selectionChanged(int index) {
							final ParseLog log = parseLogWindow.getParseLog();
							code.moveToEvent(index, log);
						}
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

	public boolean find(String pattern) {
		return view.find(pattern);
	}

	public int getAdjustedLineCount() {
		return view.getAdjustedLineCount();
	}

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
