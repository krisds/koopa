package koopa.app.components.detail.token;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import koopa.app.Application;
import koopa.app.listeners.TokenSelectionListener;
import koopa.core.data.Token;
import koopa.core.trees.Tree;

public class TokenDetails extends JPanel implements TokenSelectionListener {

	private static final long serialVersionUID = 1L;

	private static final Font FONT = new Font("Courier", Font.PLAIN, 14);

	private ListOfGrammarRules rules = null;
	private ListOfTags tags = null;
	private JTextArea text = null;
	private JTextArea hex = null;

	public TokenDetails(Application application) {
		setupComponents(application);
	}

	private void setupComponents(Application application) {
		setLayout(new GridLayout(1, 3));

		rules = new ListOfGrammarRules(application);
		JScrollPane scrollingBreadcrumb = new JScrollPane(rules);
		scrollingBreadcrumb.setBorder(BorderFactory.createTitledBorder("Path"));
		add(scrollingBreadcrumb);

		tags = new ListOfTags(application);
		JScrollPane scrollingTags = new JScrollPane(tags);
		scrollingTags.setBorder(BorderFactory.createTitledBorder("Tags"));
		add(scrollingTags);

		text = new JTextArea();
		text.setFont(FONT);
		text.setEditable(false);
		JScrollPane scrollingText = new JScrollPane(text);
		scrollingText.setBorder(BorderFactory.createTitledBorder("Text"));
		add(scrollingText);

		hex = new JTextArea();
		hex.setFont(FONT);
		hex.setLineWrap(true);
		hex.setEditable(false);
		JScrollPane scrollingHex = new JScrollPane(hex);
		scrollingHex.setBorder(BorderFactory.createTitledBorder("Hex"));
		add(scrollingHex);
	}

	public void setParseTree(Tree tree) {
		rules.setParseTree(tree);
	}

	@Override
	public void selectedToken(Token token) {
		rules.selectedToken(token);
		tags.selectedToken(token);
		text.setText(token.getText());
		hex.setText(toHex(token.getText()));
	}

	private static String toHex(String text) {
		StringBuffer hex = new StringBuffer();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			String hexString = Integer.toHexString(c);

			if (hex.length() > 0)
				hex.append(' ');

			if (hexString.length() == 1)
				hex.append('0');

			hex.append(hexString);
		}
		return hex.toString().toUpperCase();
	}

	public void close() {
		rules.close();
		tags.close();
	}
}
