package koopa.cobol.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.List;

import javax.swing.filechooser.FileFilter;

public class CobolSupport {

	private static List<String> EXTENSIONS = new LinkedList<>();

	private static String DESCRIPTION = "";

	static {
		EXTENSIONS.add(".CPY");
		EXTENSIONS.add(".COPY");
		EXTENSIONS.add(".CBL");
		EXTENSIONS.add(".COB");

		String extraExtensions = System
				.getProperty("koopa.cobolFileExtensions");

		if (extraExtensions != null)
			for (String extraExtension : extraExtensions.split(","))
				EXTENSIONS.add("." + extraExtension.trim().toUpperCase());

		for (String extension : EXTENSIONS) {
			if (DESCRIPTION.length() > 0)
				DESCRIPTION += ", ";

			DESCRIPTION += extension;
		}
	}

	public static FileFilter getCobolFileFilter() {
		return getCobolFileFilter(true);
	}

	public static FileFilter getCobolFileFilter(final boolean filesOnly) {
		return new FileFilter() {
			@Override
			public boolean accept(File f) {
				if (!filesOnly && f.isDirectory())
					return true;

				return isCobolFile(f);
			}

			@Override
			public String getDescription() {
				return "Cobol file (" + DESCRIPTION + ")";
			}
		};
	}

	public static FilenameFilter getFilenameFilter() {
		return (dir, name) -> isCobolFileName(name);
	}

	public static boolean isCobolFile(File file) {
		if (!file.isFile())
			return false;

		return isCobolFileName(file.getName());
	}

	public static boolean isCobolFileName(String name) {
		name = name.toUpperCase();

		for (String extension : EXTENSIONS)
			if (name.endsWith(extension))
				return true;

		return false;
	}
}
