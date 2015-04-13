package koopa.cobol;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/** EXPERIMENTAL ! Support for preprocessing. */
public class Copybooks {
	private List<File> copybookPaths = new ArrayList<File>();

	public void setLookupPaths(List<File> copybookPaths) {
		this.copybookPaths = copybookPaths;
	}

	// TODO Smarter lookup system, with variations in extensions.
	public File lookup(final String textName, final String libraryName) {
		if (this.copybookPaths == null)
			return null;

		for (File path : this.copybookPaths) {
			File[] matches = path.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.equalsIgnoreCase(textName + ".cpy");
				}
			});

			if (matches != null && matches.length > 0)
				return matches[0];
		}

		return null;
	}

}
