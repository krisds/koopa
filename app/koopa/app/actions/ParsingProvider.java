package koopa.app.actions;

import java.awt.Component;
import java.io.File;

public interface ParsingProvider {

	public void walkAndParse(File file);

	public Component getGUI();

}
