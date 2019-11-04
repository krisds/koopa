package koopa.app.components.detail.source;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import koopa.app.Application;
import koopa.app.listeners.TokenSelectionListener;
import koopa.core.data.Position;
import koopa.core.data.Replaced;
import koopa.core.data.Token;

public class SourceDetails extends JPanel implements TokenSelectionListener {

	private static final long serialVersionUID = 1L;

	private JTextArea text = null;

	public SourceDetails(Application application) {
		setupComponents(application);
	}

	private void setupComponents(Application application) {
		setLayout(new GridLayout(1, 1));

		text = new JTextArea("Please select a token.");
		
		JScrollPane scroll = new JScrollPane(text);
		add(scroll);
	}

	@Override
	public void selectedToken(Token token) {
		StringBuilder msg = new StringBuilder();

		msg.append("From ");
		appendLocation(msg, token.getStart());
		msg.append(".\n");

		msg.append("To ");
		appendLocation(msg, token.getEnd());
		msg.append(".\n");

		Replaced r = token.getReplaced();
		while (r != null) {
			msg.append("\n");
			msg.append("Replacing: \n");
			msg.append("From ");
			appendLocation(msg, r.getStart());
			msg.append(".\n");

			msg.append("To ");
			appendLocation(msg, r.getEnd());
			msg.append(".\n");

			r = r.getContext();
		}

		text.setText(msg.toString());
	}

	private void appendLocation(StringBuilder msg, final Position pos) {
		msg.append("line ");
		msg.append(pos.getLinenumber());
		msg.append(", column ");
		msg.append(pos.getPositionInLine());
		msg.append(" in ");
		msg.append(pos.getResourceName());
	}

	public void close() {
	}
}
