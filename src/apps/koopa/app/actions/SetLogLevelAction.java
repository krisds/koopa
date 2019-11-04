package koopa.app.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import koopa.core.util.Strings;

public class SetLogLevelAction extends AbstractAction implements Action {

	private static final long serialVersionUID = 1L;

	private final Logger logger;
	private final Level level;

	public SetLogLevelAction(Logger logger, Level level) {
		super(Strings.titleCase(level.toString().toLowerCase()));

		this.logger = logger;
		this.level = level;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		logger.setLevel(level);
	}
}
