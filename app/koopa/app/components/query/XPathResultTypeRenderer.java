package koopa.app.components.query;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import koopa.app.Icons;

public class XPathResultTypeRenderer extends DefaultTableCellRenderer implements
		TableCellRenderer {

	private static final long serialVersionUID = -4744958969024365852L;

	private final static ImageIcon NODE = Icons
			.getIcon("/koopa/app/resources/fugue/node-select.png");

	private final static ImageIcon TOKEN = Icons
			.getIcon("/koopa/app/resources/fugue/node-select-child.png");

	private final static ImageIcon ATTRIBUTE = Icons
			.getIcon("/koopa/app/resources/fugue/price-tag.png");

	public void setValue(Object value) {
		if (value == null) {
			// TODO Question mark instead.
			return;
		}

		if (!(value instanceof XPathResultType)) {
			// TODO Question mark instead.
			setIcon(null);
			return;
		}

		final XPathResultType type = (XPathResultType) value;

		switch (type) {
		case NODE:
			setIcon(NODE);
			break;

		case TOKEN:
			setIcon(TOKEN);
			break;

		case ATTRIBUTE:
			setIcon(ATTRIBUTE);
			break;

		case OTHER:
		default:
			// TODO Question mark instead.
			setIcon(null);
			break;
		}
	}
}
