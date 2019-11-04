package koopa.app.components.detail.token;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import koopa.app.Application;
import koopa.app.listeners.TokenSelectionListener;
import koopa.core.data.Token;

public class ListOfTags extends JPanel implements TokenSelectionListener {

	private static final long serialVersionUID = 1L;

	private static final Font FONT = new Font("Courier", Font.PLAIN, 14);

	private int index = 0;
	private List<JLabel> labels = new ArrayList<>();

	private JLabel noSelection = null;

	public ListOfTags(Application application) {
		setupComponents();
	}

	private void setupComponents() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);

		noSelection = new JLabel("no selection");
		noSelection.setFont(FONT);

		add(noSelection);
	}

	@Override
	public void selectedToken(Token token) {
		while (index > 0)
			remove(labels.get(--index));

		add(noSelection);

		if (token == null) {
			validate();
			repaint();
			return;
		}

		Set<Object> tags = token.getTags();
		if (tags.isEmpty()) {
			validate();
			repaint();
			return;
		}

		remove(noSelection);

		for (Object tag : tags) {
			add(getLabel(tag));
		}

		validate();
		getParent().validate();
		repaint();
	}

	private JLabel getLabel(Object crumb) {
		JLabel label;

		if (index < labels.size()) {
			label = labels.get(index);
			label.setText(crumb.toString());

		} else {
			label = new JLabel(crumb.toString());
			labels.add(label);

			label.setFont(FONT);
		}

		index += 1;
		return label;
	}

	public void close() {
	}
}
