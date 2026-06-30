package koopa.app.components.misc;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import koopa.app.Icons;
import koopa.app.batchit.BatchResults;
import koopa.app.batchit.BatchResults.Status;

public class StatusRenderer extends DefaultTableCellRenderer implements
		TableCellRenderer {

	private static final long serialVersionUID = -4744958969024365852L;

	private static final ImageIcon OK = Icons
            .getIcon("/koopa/app/resources/document-ok.png");

	private static final ImageIcon ERROR = Icons
			.getIcon("/koopa/app/resources/document-error.png");

	private static final ImageIcon WARNING = Icons
            .getIcon("/koopa/app/resources/document-warning.png");

	@Override
	public void setValue(Object value) {
		if (value == null) {
			// TODO Question mark instead.
			setIcon(ERROR);
			return;
		}

		if (!(value instanceof BatchResults.Status)) {
			// TODO Question mark instead.
			setIcon(ERROR);
			return;
		}

		switch ((Status) value) {
		case ERROR:
			setIcon(ERROR);
			break;

		case WARNING:
			setIcon(WARNING);
			break;

		case OK:
			setIcon(OK);
			break;

		default:
			// TODO Question mark instead.
			setIcon(ERROR);
			break;
		}
	}
}
