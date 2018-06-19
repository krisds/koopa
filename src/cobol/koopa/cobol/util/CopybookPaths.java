package koopa.cobol.util;

import java.io.File;
import java.util.List;

/**
 * Define copybook locations by lookup paths.
 * <p>
 * All paths should identify folders, not files.
 */
public interface CopybookPaths {

	/**
	 * Add a path to this list. The path should not be <code>null</code> and
	 * must be a folder.
	 */
	void addCopybookPath(File path);

	void removeCopybookPath(File path);

	List<File> getCopybookPaths();
}
