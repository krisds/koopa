package koopa.cobol;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import koopa.core.util.FilenameFilters;
import koopa.core.util.Files;
import koopa.core.util.Select;

import org.apache.log4j.Logger;

/** EXPERIMENTAL ! Support for pre-processing. */
public class Copybooks {

	private static final class IsCopybookNamed implements FilenameFilter {
		private final String fileName;

		private IsCopybookNamed(String fileName) {
			this.fileName = fileName;
		}

		public boolean accept(File path, String name) {
			LOGGER.trace("<" + name + "> <" + path + ">");

			// If the names match exactly then we'll assume we have got the
			// right file.
			if (fileName.equalsIgnoreCase(name)) {
				if (LOGGER.isTraceEnabled())
					LOGGER.trace("- " + name + " ? Yes, exact match.");

				return true;
			}

			final boolean isCopybook = CobolFiles.isCopybook(name);
			final boolean namesMatch = Files.getName(name).equalsIgnoreCase(
					Files.getName(fileName));
			final boolean isMatch = isCopybook && namesMatch;

			if (LOGGER.isTraceEnabled())
				LOGGER.trace("- "
						+ name
						+ " ? "
						+ (isMatch ? "Yes." : "No. Names match: " + namesMatch
								+ "; is copybook: " + isCopybook));

			return isMatch;
		}

		@Override
		public String toString() {
			return fileName;
		}
	}

	private static final Select<File> FIRST = new Select<File>() {
		public File select(File[] list) {
			if (list != null && list.length > 0)
				return list[0];
			else
				return null;
		}
	};

	private static final Logger LOGGER = Logger.getLogger("copybooks");

	private List<File> copybookPaths = new ArrayList<File>();

	public void setLookupPaths(List<File> copybookPaths) {
		this.copybookPaths = copybookPaths;
	}

	// TODO Take library name into account.
	public File lookup(String copybookName, String libraryName,
			final File currentFile) {

		// Unquote the copybook and library names if needed.
		if (isLiteral(copybookName))
			copybookName = copybookName.substring(1, copybookName.length() - 1);
		if (libraryName != null && isLiteral(libraryName))
			libraryName = libraryName.substring(1, libraryName.length() - 1);

		// How do we match candidate files ? Well, they must be different from
		// the current file (which avoids recursion), and they must be a
		// copybook with a matching name.
		final FilenameFilter filter = FilenameFilters.and( //
				FilenameFilters.exclude(currentFile), //
				new IsCopybookNamed(copybookName));

		// How do we decide which of the candidate matching files to accept ?
		// Well, for now we just pick the first match found...
		Select<File> tieBreaker = FIRST;

		// Where do we look for matching files ?
		File match = null;
		// We look in the current folder first, possibly offset by the library
		// name.
		if (currentFile != null)
			match = Files.find(
					Files.offset(libraryName, currentFile.getParentFile()),
					filter, tieBreaker);

		// Then we try all copybook paths in order, again possibly offset by the
		// library name.
		if (match == null)
			match = Files.find(Files.offset(libraryName, copybookPaths),
					filter, tieBreaker);

		if (LOGGER.isTraceEnabled())
			if (match != null)
				LOGGER.trace("Lookup of copybook " + copybookName + " in "
						+ libraryName + " succeeded; found " + match);
			else
				LOGGER.trace("Lookup of copybook " + copybookName + " in "
						+ libraryName + " failed: not found.");

		return match;
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
