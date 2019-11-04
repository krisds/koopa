package koopa.cobol;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.filechooser.FileFilter;

import koopa.core.util.Files;
import koopa.core.util.Strings;

import org.apache.log4j.Logger;

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
 * <li>koopa.cobol.sources; for identifying source files</li>
 * <li>koopa.cobol.copybooks; for identifying copybooks</li>
 * </ul>
 * So, for example,
 * <code>-Dkoopa.cobol.sources=cbl,cob -Dkoopa.cobol.copybooks=cpy,copy</code>
 * is equivalent to the default.
 * <p>
 * By setting your own extensions for any category, the defaults for that
 * category will not be set. So setting
 * <code>-Dkoopa.cobol.sources=cbl -Dkoopa.cobol.copybooks=cob</code> means that
 * <b>only</b> files with extension 'cbl' will be seen as source files, and
 * <b>only</b> files with extension 'cob' will be seen as copybooks.
 */
public class CobolFiles {
	private static final Logger LOGGER = Logger.getLogger("cobol.files");

	private static Set<String> SOURCE_EXTENSIONS = new LinkedHashSet<>();
	private static Set<String> COPYBOOK_EXTENSIONS = new LinkedHashSet<>();

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

		if (System.getProperty("koopa.sources") == null
				&& System.getProperty("koopa.cobol.sources") == null) {
			SOURCE_EXTENSIONS.add("CBL");
			SOURCE_EXTENSIONS.add("COB");

		} else {
			addSourceExtensions(System.getProperty("koopa.sources"));
			addSourceExtensions(System.getProperty("koopa.cobol.sources"));
		}

		if (System.getProperty("koopa.copybooks") == null
				&& System.getProperty("koopa.cobol.copybooks") == null) {
			COPYBOOK_EXTENSIONS.add("CPY");
			COPYBOOK_EXTENSIONS.add("COPY");
		} else {
			addCopybookExtensions(System.getProperty("koopa.copybooks"));
			addCopybookExtensions(System.getProperty("koopa.cobol.copybooks"));
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
				COPYBOOK_EXTENSIONS.remove(extraExtension);
				SOURCE_EXTENSIONS.add(extraExtension);
			}
		}
	}

	/**
	 * This sets the list of source extensions to match those provided.
	 * <p>
	 * If one of the new extensions is found in the list of copybook extensions
	 * it will be removed from that one.
	 */
	public static void setSourceExtensions(String[] extensions) {
		SOURCE_EXTENSIONS.clear();

		if (extensions == null)
			return;

		for (String e : extensions) {
			e = e.trim().toUpperCase();
			COPYBOOK_EXTENSIONS.remove(e);
			SOURCE_EXTENSIONS.add(e);
		}
	}

	/**
	 * This sets the list of copybook extensions to match those provided.
	 * <p>
	 * If one of the new extensions is found in the list of source extensions it
	 * will be removed from that one.
	 */
	public static void setCopybookExtensions(String[] extensions) {
		COPYBOOK_EXTENSIONS.clear();

		if (extensions == null)
			return;

		for (String e : extensions) {
			e = e.trim().toUpperCase();
			SOURCE_EXTENSIONS.remove(e);
			COPYBOOK_EXTENSIONS.add(e);
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
				SOURCE_EXTENSIONS.remove(extraExtension);
				COPYBOOK_EXTENSIONS.add(extraExtension);
			}
		}
	}

	public static FileFilter getSwingFileFilter() {
		return getSwingFileFilter(true);
	}

	private static String getFullDescription() {
		final String sources = Strings.join(", ", SOURCE_EXTENSIONS);
		final String copybooks = Strings.join(", ", COPYBOOK_EXTENSIONS);
		return Strings.join(", ", sources, copybooks);
	}

	public static FileFilter getSwingFileFilter(final boolean filesOnly) {

		return new FileFilter() {
			@Override
			public boolean accept(File f) {
				if (!filesOnly && f.isDirectory())
					return true;

				return isCobolFile(f);
			}

			@Override
			public String getDescription() {
				return "Cobol file (" + getFullDescription() + ")";
			}
		};
	}

	public static java.io.FileFilter getFileFilter() {
		return getFileFilter(true);
	}

	public static java.io.FileFilter getFileFilter(final boolean filesOnly) {
		return f -> {
			if (!filesOnly && f.isDirectory())
				return true;

			return isCobolFile(f);
		};
	}

	public static FilenameFilter getFilenameFilter() {
		return getFilenameFilter(true);
	}

	public static FilenameFilter getFilenameFilter(final boolean filesOnly) {
		return (dir, name) -> {
			if (!filesOnly && dir.isDirectory())
				return true;

			return isCobolFileName(name);
		};
	}

	public static FilenameFilter getCopybookFilenameFilter() {
		return getCopybookFilenameFilter(true);
	}

	public static FilenameFilter getCopybookFilenameFilter(
			final boolean filesOnly) {
		return (path, name) -> {
			if (!filesOnly && path.isDirectory())
				return true;

			return isCopybook(name);
		};
	}

	/**
	 * Does the extension for the given file indicate that it's a Cobol file ?
	 */
	public static boolean isCobolFile(File file) {
		if (!file.isFile())
			return false;

		return isCobolFileName(file.getName());
	}

	/**
	 * Does the extension for the given filename indicate that it's a Cobol file
	 * ?
	 */
	public static boolean isCobolFileName(String name) {
		final String extension = Files.getExtension(name).toUpperCase();
		return SOURCE_EXTENSIONS.contains(extension)
				|| COPYBOOK_EXTENSIONS.contains(extension);
	}

	/**
	 * Does the extension for the given file indicate that it's a copybook ?
	 */
	public static boolean isCopybook(File file) {
		final String extension = Files.getExtension(file).toUpperCase();
		return COPYBOOK_EXTENSIONS.contains(extension);
	}

	/**
	 * Does the extension for the given filename indicate that it's a copybook ?
	 */
	public static boolean isCopybook(String filename) {
		final String extension = Files.getExtension(filename).toUpperCase();
		return COPYBOOK_EXTENSIONS.contains(extension);
	}

	public static List<String> getSourceExtensions() {
		return new ArrayList<>(SOURCE_EXTENSIONS);
	}

	public static List<String> getCopybookExtensions() {
		return new ArrayList<>(COPYBOOK_EXTENSIONS);
	}
}
