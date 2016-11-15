package koopa.core.util;

import java.io.File;
import java.io.FilenameFilter;

public final class FilenameFilters {
	private FilenameFilters() {
	}

	/**
	 * This {@linkplain FilenameFilter} accepts all files.
	 */
	public static final FilenameFilter ALL = new FilenameFilter() {
		public boolean accept(File dir, String name) {
			return true;
		}
	};

	/**
	 * This {@linkplain FilenameFilter} rejects all files.
	 */
	public static final FilenameFilter NONE = new FilenameFilter() {
		public boolean accept(File dir, String name) {
			return false;
		}
	};

	/**
	 * Return a {@linkplain FilenameFilter} which accepts all files except the
	 * given one.
	 */
	public static FilenameFilter exclude(File file) {
		if (file == null)
			return ALL;

		final File folder = file.getParentFile();
		final String fileName = file.getName();

		return new FilenameFilter() {
			public boolean accept(File path, String name) {
				return !path.equals(folder) || !name.equalsIgnoreCase(fileName);
			}
		};
	}

	/**
	 * Return a {@linkplain FilenameFilter} which only accepts files which are
	 * accepted by all given filters.
	 */
	public static FilenameFilter and(final FilenameFilter... filters) {
		if (filters == null || filters.length == 0)
			return NONE;

		return new FilenameFilter() {
			public boolean accept(File dir, String name) {
				for (FilenameFilter filter : filters)
					if (!filter.accept(dir, name))
						return false;

				return true;
			}
		};
	}

	/**
	 * Return a {@linkplain FilenameFilter} which only accepts files which have
	 * the given extension (as determined by
	 * {@linkplain Files#getExtension(String)}).
	 */
	public static FilenameFilter forExtension(final String expectedExtension,
			final boolean ignoreCase) {
		return new FilenameFilter() {
			public boolean accept(File dir, String name) {
				final String actualExtension = Files.getExtension(name);

				if (expectedExtension == null)
					return actualExtension == null
							|| actualExtension.equals("");
				else if (ignoreCase)
					return expectedExtension.equalsIgnoreCase(actualExtension);
				else
					return expectedExtension.equals(actualExtension);
			}
		};
	}
}
