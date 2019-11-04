package koopa.cobol.projects;

import java.io.File;
import java.io.FilenameFilter;

import koopa.cobol.CobolFiles;
import koopa.core.util.Files;

import org.apache.log4j.Logger;

/**
 * This {@linkplain FilenameFilter} accepts files which are copybooks (as
 * defined by {@linkplain CobolFiles#isCopybook(File)} with a name (
 * {@linkplain Files#getName(String)}) which matches the given one.
 * <p>
 * For use by the {@linkplain StandardCobolProject} only.
 */
class IsCopybookNamed implements FilenameFilter {
	private static final Logger LOGGER = Logger.getLogger("copybooks");

	private final String fileName;

	public IsCopybookNamed(String fileName) {
		this.fileName = fileName;
	}

	@Override
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
		final boolean namesMatch = Files.getName(name)
				.equalsIgnoreCase(Files.getName(fileName));
		final boolean isMatch = isCopybook && namesMatch;

		if (LOGGER.isTraceEnabled())
			LOGGER.trace("- " + name + " ? "
					+ (isMatch ? "Yes."
							: "No. Names match: " + namesMatch
									+ "; is copybook: " + isCopybook));

		return isMatch;
	}

	@Override
	public String toString() {
		return fileName;
	}
}