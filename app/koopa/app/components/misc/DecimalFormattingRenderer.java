package koopa.app.components.misc;

import java.text.DecimalFormat;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class DecimalFormattingRenderer extends DefaultTableCellRenderer
		implements TableCellRenderer {

	private static final long serialVersionUID = -4744958969024365852L;

	private DecimalFormat format = null;

	public DecimalFormattingRenderer(String pattern) {
		this.format = new DecimalFormat(pattern);
	}

	public void setValue(Object value) {
		try {
			setText((value == null) ? "" : format.format(value));

		} catch (IllegalArgumentException e) {
			setText("na");
		}
	}
}
