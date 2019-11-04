package koopa.cobol.projects;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import koopa.cobol.CobolProject;
import koopa.cobol.util.CopybookPaths;
import koopa.core.util.FilenameFilters;
import koopa.core.util.Files;
import koopa.core.util.Select;

/**
 * A {@link BasicCobolProject} which resolves copybooks by means of copybook
 * paths.
 */
public class StandardCobolProject extends BasicCobolProject
		implements CobolProject, CopybookPaths {

	private static final Logger LOGGER = Logger.getLogger("copybooks");

	private List<File> copybookPaths = new ArrayList<>();

	@Override
	public CobolProject duplicate() {
		final StandardCobolProject project = new StandardCobolProject();
		copyBasicSettingsInto(project);
		copyDefaultSettingsInto(project);
		return project;
	}

	private void copyDefaultSettingsInto(final StandardCobolProject project) {
		project.copybookPaths.addAll(copybookPaths);
	}

	@Override
	public void addCopybookPath(File path) {
		if (path == null)
			throw new NullPointerException("Null path");
		if (!path.isDirectory())
			throw new IllegalArgumentException("Not a folder: " + path);
		copybookPaths.add(path);
	}

	@Override
	public void removeCopybookPath(File path) {
		copybookPaths.remove(path);
	}

	@Override
	public List<File> getCopybookPaths() {
		return Collections.unmodifiableList(copybookPaths);
	}

	private static final Select<File> FIRST = list -> {
		if (list != null && list.length > 0)
			return list[0];
		else
			return null;
	};

	@Override
	public File locateCopybook(String textName, String libraryName,
			File sourceFile) {
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
			match = Files.find(Files.offset(libraryName, copybookPaths), filter,
					tieBreaker);

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
