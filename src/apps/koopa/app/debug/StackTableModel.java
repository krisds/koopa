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

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case MESSAGE_COLUMN:
			return "Frame";

		default:
			return "????";
		}
	}

	@Override
	public int getRowCount() {
		if (head == null)
			return 0;

		return head.depth();
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
		switch (columnIndex) {
		case MESSAGE_COLUMN:
			final Stack.Frame data = head.getFrameUpBy(rowIndex);
			return data.toString();

		default:
			return true;
		}
	}
}
