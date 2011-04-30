package koopa.app.actions;

import java.io.File;

public interface FileManager {

	void openFile(File file);

	void reloadFile();

	void scrollTo(int position);
}
