package koopa.app.debug.log;

import javax.swing.table.AbstractTableModel;

import org.apache.log4j.spi.LoggingEvent;

public class ParseLogTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	public static final int KIND_COLUMN = 0;
	public static final int MESSAGE_COLUMN = 1;

	private ParseLog log = null;

	public void setParseLog(ParseLog log) {
		this.log = log;
		fireTableDataChanged();
	}

	public ParseLog getParseLog() {
		return log;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case KIND_COLUMN:
			return "Kind";

		case MESSAGE_COLUMN:
			return "Message";

		default:
			return "????";
		}
	}

	@Override
	public int getRowCount() {
		if (log == null)
			return 0;

		return log.size();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		default:
			return super.getColumnClass(columnIndex);
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		final Object data = log.getEvent(rowIndex).getData();
		
		switch (columnIndex) {
		case KIND_COLUMN:
			if (data instanceof LoggingEvent)
				return ((LoggingEvent) data).getLevel();
			else if (data instanceof DataEvent)
				return ((DataEvent) data).getType();
			else
				return "";

		case MESSAGE_COLUMN:
			if (data instanceof LoggingEvent)
				return ((LoggingEvent) data).getRenderedMessage();
			else if (data instanceof DataEvent)
				return ((DataEvent) data).getData();
			else
				return data.toString();

		default:
			return true;
		}
	}
}
