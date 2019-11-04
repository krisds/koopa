package koopa.cobol.copybooks;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

import koopa.core.util.FilenameFilters;
import koopa.core.util.Files;
import koopa.core.util.Select;

import org.apache.log4j.Logger;

/**
 * The default locator looks for copybooks by name. It searches for these first
 * in the same location as the source file, then in each copybook path. The
 * first match found is used.
 */
public class DefaultCopybookLocator implements CopybookLocator {

	private static final Logger LOGGER = Logger.getLogger("copybooks");

	private static final Select<File> FIRST = list -> {
		if (list != null && list.length > 0)
			return list[0];
		else
			return null;
	};

	@Override
	public File locate(String textName, String libraryName, File sourceFile,
			List<File> copybookPaths) {
		// Unquote the copybook and library names if needed.
		if (isLiteral(textName))
			textName = textName.substring(1, textName.length() - 1);
		if (libraryName != null && isLiteral(libraryName))
			libraryName = libraryName.substring(1, libraryName.length() - 1);

		// How do we match candidate files ? Well, they must be different from
		// the current file (which avoids recursion), and they must be a
		// copybook with a matching name.
		final FilenameFilter filter = FilenameFilters.and( //
				FilenameFilters.exclude(sourceFile), //
				new IsCopybookNamed(textName));

		// How do we decide which of the candidate matching files to accept ?
		// Well, for now we just pick the first match found...
		Select<File> tieBreaker = FIRST;

		// Where do we look for matching files ?
		File match = null;
		// We look in the current folder first, possibly offset by the library
		// name.
		if (sourceFile != null)
			match = Files.find(
					Files.offset(libraryName, sourceFile.getParentFile()),
					filter, tieBreaker);

		// Then we try all copybook paths in order, again possibly offset by the
		// library name.
		if (match == null)
			match = Files.find(Files.offset(libraryName, copybookPaths),
					filter, tieBreaker);

		if (LOGGER.isTraceEnabled())
			if (match != null)
				LOGGER.trace("Lookup of copybook " + textName + " in "
						+ libraryName + " succeeded; found " + match);
			else
				LOGGER.trace("Lookup of copybook " + textName + " in "
						+ libraryName + " failed: not found.");

		return match;
	}

	private boolean isLiteral(final String name) {
		return (name.startsWith("\"") && name.endsWith("\""))
				|| (name.startsWith("'") && name.endsWith("'"));
	}
}
