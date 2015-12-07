package koopa.cobol;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.filechooser.FileFilter;

import org.apache.log4j.Logger;

import koopa.core.util.Files;

/**
 * This class offers a number of utility functions which help in selecting Cobol
 * source files and copybooks. You can basically ask it whether a file is a
 * Cobol file, and it will test for this by checking the file's extension
 * against a number of known extensions (ignoring case).
 * <p>
 * In addition you can ask this class for {@linkplain java.io.FileFilter} and
 * {@linkplain FilenameFilter} instances which will fall back on the same logic.
 * <p>
 * So what extensions are covered ? Well, by default you get these:
 * <ul>
 * <li>For source files: CBL and COB.</li>
 * <li>For copybooks: CPY and COPY.</li>
 * </ul>
 * <p>
 * These defaults can be modified by passing a comma separated list of
 * extensions to one of the following system properties:
 * <ul>
 * <li>koopa.sources; for identifying source files</li>
 * <li>koopa.copybooks; for identifying copybooks</li>
 * <li>koopa.cobolFileExtensions; synonym for koopa.sources, and here for
 * backwards compatibility</li>
 * </ul>
 * So, for example,
 * <code>-Dkoopa.sources=cbl,cob -Dkoopa.copybooks=cpy,copy</code> is equivalent
 * to the default.
 * <p>
 * By setting your own extensions for any category, the defaults for that
 * category will not be set. So setting
 * <code>-Dkoopa.sources=cbl -Dkoopa.copybooks=cob</code> means that <b>only</b>
 * files with extension 'cbl' will be seen as source files, and <b>only</b>
 * files with extension 'cob' will be seen as copybooks.
 */
public class CobolFiles {
	private static final Logger LOGGER = Logger.getLogger("cobol.files");

	private static Set<String> SOURCE_EXTENSIONS = new LinkedHashSet<String>();
	private static Set<String> COPYBOOK_EXTENSIONS = new LinkedHashSet<String>();

	private static String DESCRIPTION = "";

	static {
		configure();
	}

	/**
	 * Reconfigure the extension support. This allows you to override the
	 * different system properties in code and make sure they get used.
	 */
	public static void configure() {
		SOURCE_EXTENSIONS.clear();
		COPYBOOK_EXTENSIONS.clear();

		if (System.getProperty("koopa.cobolFileExtensions") == null
				&& System.getProperty("koopa.sources") == null) {
			SOURCE_EXTENSIONS.add(".CBL");
			SOURCE_EXTENSIONS.add(".COB");

		} else {
			addSourceExtensions(System.getProperty("koopa.cobolFileExtensions"));
			addSourceExtensions(System.getProperty("koopa.sources"));
		}

		if (System.getProperty("koopa.copybooks") == null) {
			COPYBOOK_EXTENSIONS.add(".CPY");
			COPYBOOK_EXTENSIONS.add(".COPY");
		} else
			addCopybookExtensions(System.getProperty("koopa.copybooks"));

		for (String extension : SOURCE_EXTENSIONS) {
			if (DESCRIPTION.length() > 0)
				DESCRIPTION += ", ";

			DESCRIPTION += extension;
		}

		for (String extension : COPYBOOK_EXTENSIONS) {
			if (DESCRIPTION.length() > 0)
				DESCRIPTION += ", ";

			DESCRIPTION += extension;
		}

		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Cobol source extensions: " + SOURCE_EXTENSIONS);
			LOGGER.trace("Cobol copybook extensions: " + COPYBOOK_EXTENSIONS);
		}
	}

	private static void addSourceExtensions(String extraSourceExtensions) {
		if (extraSourceExtensions == null)
			return;

		for (String extraExtension : extraSourceExtensions.split(",")) {
			extraExtension = extraExtension.trim().toUpperCase();

			if ("".equals(extraExtension))
				SOURCE_EXTENSIONS.add("");
			else {
				final String extension = "." + extraExtension;
				COPYBOOK_EXTENSIONS.remove(extension);
				SOURCE_EXTENSIONS.add(extension);
			}
		}
	}

	private static void addCopybookExtensions(String extraSourceExtensions) {
		if (extraSourceExtensions == null)
			return;

		for (String extraExtension : extraSourceExtensions.split(",")) {
			extraExtension = extraExtension.trim().toUpperCase();

			if ("".equals(extraExtension))
				COPYBOOK_EXTENSIONS.add("");
			else {
				final String extension = "." + extraExtension;

				SOURCE_EXTENSIONS.remove(extension);
				COPYBOOK_EXTENSIONS.add(extension);
			}
		}
	}

	public static FileFilter getSwingFileFilter() {
		return getSwingFileFilter(true);
	}

	public static FileFilter getSwingFileFilter(final boolean filesOnly) {
		return new FileFilter() {
			public boolean accept(File f) {
				if (!filesOnly && f.isDirectory())
					return true;

				return isCobolFile(f);
			}

			public String getDescription() {
				return "Cobol file (" + DESCRIPTION + ")";
			}
		};
	}

	public static java.io.FileFilter getFileFilter() {
		return getFileFilter(true);
	}

	public static java.io.FileFilter getFileFilter(final boolean filesOnly) {
		return new java.io.FileFilter() {
			public boolean accept(File f) {
				if (!filesOnly && f.isDirectory())
					return true;

				return isCobolFile(f);
			}
		};
	}

	public static FilenameFilter getFilenameFilter() {
		return getFilenameFilter(true);
	}

	public static FilenameFilter getFilenameFilter(final boolean filesOnly) {
		return new FilenameFilter() {
			public boolean accept(File dir, String name) {
				if (!filesOnly && dir.isDirectory())
					return true;

				return isCobolFileName(name);
			}
		};
	}

	public static FilenameFilter getCopybookFilenameFilter() {
		return getCopybookFilenameFilter(true);
	}

	public static FilenameFilter getCopybookFilenameFilter(
			final boolean filesOnly) {
		return new FilenameFilter() {
			public boolean accept(File path, String name) {
				if (!filesOnly && path.isDirectory())
					return true;

				return isCopybook(path);
			}
		};
	}

	public static boolean isCobolFile(File file) {
		if (!file.isFile())
			return false;

		return isCobolFileName(file.getName());
	}

	public static boolean isCobolFileName(String name) {
		final String extension = Files.getExtension(name).toUpperCase();
		return SOURCE_EXTENSIONS.contains(extension)
				|| COPYBOOK_EXTENSIONS.contains(extension);
	}

	public static boolean isCopybook(File file) {
		final String extension = Files.getExtension(file).toUpperCase();
		return COPYBOOK_EXTENSIONS.contains(extension);
	}

	public static boolean isCopybook(String filename) {
		final String extension = Files.getExtension(filename).toUpperCase();
		return COPYBOOK_EXTENSIONS.contains(extension);
	}
}
