package koopa.core.util;

import java.io.File;
import java.io.FilenameFilter;

public final class FilenameFilters {
	private FilenameFilters() {
	}

	public static final FilenameFilter ALL = new FilenameFilter() {
		public boolean accept(File dir, String name) {
			return true;
		}
	};

	public static final FilenameFilter NONE = new FilenameFilter() {
		public boolean accept(File dir, String name) {
			return false;
		}
	};

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
}
