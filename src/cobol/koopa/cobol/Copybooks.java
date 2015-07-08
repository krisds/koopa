package koopa.cobol;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import koopa.core.util.Files;

/** EXPERIMENTAL ! Support for pre-processing. */
public class Copybooks {
	private static final Logger LOGGER = Logger.getLogger("copybooks");

	private List<File> copybookPaths = new ArrayList<File>();

	public void setLookupPaths(List<File> copybookPaths) {
		this.copybookPaths = copybookPaths;
	}

	// TODO Take library name into account.
	public File lookup(String textName, final String libraryName) {
		// Were we given a literal name ?
		final boolean isLiteralTextName = (textName.startsWith("\"") && textName
				.endsWith("\""))
				|| (textName.startsWith("'") && textName.endsWith("'"));

		// So what are we looking for ?
		final String fileName;
		if (isLiteralTextName)
			fileName = textName.substring(1, textName.length() - 1);
		else
			fileName = textName;

		if (copybookPaths == null) {
			if (LOGGER.isInfoEnabled())
				LOGGER.info("Lookup of copybook " + textName + " in "
						+ libraryName + " failed: no copybook paths were set.");
			return null;
		}

		for (File path : copybookPaths) {
			File[] matches = path.listFiles(new FilenameFilter() {
				public boolean accept(File path, String name) {
					if (isLiteralTextName && fileName.equalsIgnoreCase(name)) {
						if (LOGGER.isTraceEnabled())
							LOGGER.info("Lookup of copybook " + fileName
									+ " in " + libraryName + "; testing "
									+ name + "; names match exactly.");

						return true;
					}

					final boolean isCopybook = CobolFiles.isCopybook(name);
					final boolean namesMatch = Files.getName(name)
							.equalsIgnoreCase(Files.getName(fileName));

					if (LOGGER.isTraceEnabled())
						LOGGER.info("Lookup of copybook " + fileName + " in "
								+ libraryName + "; testing " + name
								+ "; copybook: " + isCopybook
								+ "; names match: " + namesMatch);

					return isCopybook && namesMatch;
				}
			});

			if (matches != null && matches.length > 0) {
				if (LOGGER.isInfoEnabled())
					LOGGER.info("Lookup of copybook " + textName + " in "
							+ libraryName + " successfull; found " + matches[0]);

				return matches[0];
			}
		}

		if (LOGGER.isInfoEnabled())
			LOGGER.info("Lookup of copybook " + textName + " in " + libraryName
					+ " failed: not found in " + copybookPaths);
		return null;
	}

	public void addAllFrom(Copybooks copybooks) {
		copybookPaths.addAll(copybooks.copybookPaths);

	}

	public void addPath(File path) {
		copybookPaths.add(path);
	}

	public void removePath(File path) {
		copybookPaths.remove(path);
	}

	public List<File> getPaths() {
		return Collections.unmodifiableList(copybookPaths);
	}
}
