package koopa.app.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;

import koopa.app.Application;
import koopa.app.ApplicationSupport;
import koopa.app.components.markdownview.MarkdownView;

@SuppressWarnings("serial")
public class ShowMarkdownAction extends AbstractAction implements Action {

	private final String resourcePath;
	private final String title;

	public ShowMarkdownAction(Application application, String name,
			String resourcePath, String title) {
		super(name);
		this.resourcePath = resourcePath;
		this.title = title;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		new Thread(() -> {
			MarkdownView view = new MarkdownView(resourcePath);
			JFrame frame = ApplicationSupport.inFrame(title, view);
			frame.setVisible(true);
		}).start();
	}
}
