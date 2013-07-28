package koopa.app.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;

import koopa.app.components.grammarview.GrammarView;

@SuppressWarnings("serial")
public class ShowGrammarAction extends AbstractAction implements Action {

	private static JFrame frame = null;

	public ShowGrammarAction() {
		super("Show grammar...");
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new Runnable() {
			public void run() {
				if (frame == null) {
					frame = new JFrame("Cobol grammar");

					final GrammarView grammarView = new GrammarView(
							"/koopa/grammars/cobol/Cobol.kg");
					frame.add(grammarView);
					frame.setSize(800, 600);
				}
				frame.setVisible(true);
			}
		}).start();
	}
}
