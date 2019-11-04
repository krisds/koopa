package koopa.app.debug.log;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import koopa.app.debug.StackTable;
import koopa.app.debug.StackTableModel;

public class ParseLogWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private final String name;

	private ParseLogTableModel logModel = null;
	private ParseLogTable logTable = null;

	private StackTableModel stackModel;
	private StackTable stackTable;

	public ParseLogWindow(String name) {
		setTitle(name + " (Parse Log)");

		this.name = name;
		setupComponents();

		logTable.addSelectionListener(index -> {
			final ParseLog log = logModel.getParseLog();
			if (log == null)
				stackModel.setStack(null);
			else
				stackModel.setStack(log.getEvent(index).getStack());
		});

		final Rectangle screenSize = getGraphicsConfiguration().getBounds();
		setSize(screenSize.width - 200, screenSize.height - 200);
		setLocationRelativeTo(null);
	}

	private void setupComponents() {
		logModel = new ParseLogTableModel();
		logTable = new ParseLogTable(logModel);

		final JScrollPane logScroller = new JScrollPane();
		logScroller.setViewportView(logTable);

		stackModel = new StackTableModel();
		stackTable = new StackTable(stackModel);

		final JScrollPane stackScroller = new JScrollPane();
		stackScroller.setViewportView(stackTable);

		final JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				logScroller, stackScroller);
		split.setResizeWeight(0.8);

		add(split);
	}

	public void setParseLog(ParseLog log) {
		logTable.clearSelection();
		logModel.setParseLog(log);

		final int last = log.size() - 1;
		if (last >= 0) {
			logTable.setRowSelectionInterval(last, last);
			logTable.scrollRectToVisible(logTable.getCellRect(last, 0, true));
		}

		setTitle(log.size() + " events - " + name + " (Parse Log)");
	}

	public ParseLog getParseLog() {
		return logModel.getParseLog();
	}

	public ParseLogTable getTable() {
		return logTable;
	}
}
