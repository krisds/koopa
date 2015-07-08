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

	public File lookup(String textName, final String libraryName) {
		return lookup(textName, libraryName, null);
	}

	// TODO Take library name into account.
	public File lookup(final String textName, final String libraryName,
			File currentPath) {

		// Were we given a literal name ?
		final boolean isLiteralTextName = isLiteral(textName);

		// So what are we looking for ?
		final String fileName;
		if (isLiteralTextName)
			fileName = textName.substring(1, textName.length() - 1);
		else
			fileName = textName;

		// Where are we looking for it ?
		final String relativePathName;
		if (libraryName == null)
			relativePathName = ".";
		else if (isLiteral(libraryName))
			relativePathName = libraryName.substring(1,
					libraryName.length() - 1);
		else
			relativePathName = libraryName;

		// How do we match candidate files ?
		final FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File path, String name) {
				// LOGGER.trace("<" + name + "> <" + path + ">");
				
				if (isLiteralTextName && fileName.equalsIgnoreCase(name)) {
					if (LOGGER.isTraceEnabled())
						LOGGER.trace("- " + name + " ? Yes, exact match.");

					return true;
				}

				final boolean isCopybook = CobolFiles.isCopybook(name);
				final boolean namesMatch = Files.getName(name)
						.equalsIgnoreCase(Files.getName(fileName));
				final boolean isMatch = isCopybook && namesMatch;

				LOGGER.trace("- "
						+ name
						+ " ? "
						+ (isMatch ? "Yes." : "No. Names match: " + namesMatch
								+ "; is copybook: " + isCopybook));

				return isMatch;
			}
		};

		if (currentPath != null) {
			if (LOGGER.isTraceEnabled())
				LOGGER.trace("Looking for " + fileName + " in " + libraryName
						+ " on current path: " + currentPath);

			File[] matches = new File(currentPath, relativePathName)
					.listFiles(filter);

			if (matches != null && matches.length > 0) {
				if (LOGGER.isInfoEnabled())
					LOGGER.info("Looking for " + fileName + " in "
							+ libraryName + " on current path; found "
							+ matches[0]);

				return matches[0];
			}
		}

		if (copybookPaths != null) {
			for (File path : copybookPaths) {
				if (LOGGER.isTraceEnabled())
					LOGGER.trace("Looking for " + fileName + " in "
							+ libraryName + " on copybook path: " + path);

				File[] matches = new File(path, relativePathName)
						.listFiles(filter);

				if (matches != null && matches.length > 0) {
					if (LOGGER.isInfoEnabled())
						LOGGER.info("Looking for " + fileName + " in "
								+ libraryName + " on copybook path; found "
								+ matches[0]);

					return matches[0];
				}
			}
		}

		if (LOGGER.isInfoEnabled())
			LOGGER.info("Lookup of copybook " + textName + " in " + libraryName
					+ " failed: not found.");
		return null;
	}

	private boolean isLiteral(final String name) {
		return (name.startsWith("\"") && name.endsWith("\""))
				|| (name.startsWith("'") && name.endsWith("'"));
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
