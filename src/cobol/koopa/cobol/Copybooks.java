package koopa.cobol;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import koopa.core.util.Files;

/** EXPERIMENTAL ! Support for pre-processing. */
public class Copybooks {
	private List<File> copybookPaths = new ArrayList<File>();

	public void setLookupPaths(List<File> copybookPaths) {
		this.copybookPaths = copybookPaths;
	}

	// TODO Take library name into account.
	public File lookup(final String textName, final String libraryName) {
		if (this.copybookPaths == null)
			return null;

		for (File path : this.copybookPaths) {
			File[] matches = path.listFiles(new FilenameFilter() {
				public boolean accept(File path, String name) {
					return CobolFiles.isCopybook(name)
							&& Files.getName(name).equalsIgnoreCase(textName);
				}
			});

			if (matches != null && matches.length > 0)
				return matches[0];
		}

		return null;
	}

}
