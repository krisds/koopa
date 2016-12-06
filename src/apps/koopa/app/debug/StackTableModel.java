package koopa.app.debug;

import javax.swing.table.AbstractTableModel;

import koopa.core.parsers.Stack;

public class StackTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	public static final int MESSAGE_COLUMN = 0;

	private Stack.Frame head = null;

	public void setStack(Stack.Frame stack) {
		this.head = stack;
		fireTableDataChanged();
	}

	public int getColumnCount() {
		return 1;
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case MESSAGE_COLUMN:
			return "Frame";

		default:
			return "????";
		}
	}

	public int getRowCount() {
		if (head == null)
			return 0;

		return head.depth();
	}

	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		default:
			return super.getColumnClass(columnIndex);
		}
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case MESSAGE_COLUMN:
			final Stack.Frame data = head.getFrameUpBy(rowIndex);
			return data.toString();

		default:
			return true;
		}
	}
}
