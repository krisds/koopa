package koopa.cobol;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import koopa.cobol.copybooks.CopybookLocator;
import koopa.cobol.copybooks.DefaultCopybookLocator;

import org.apache.log4j.Logger;

/**
 * This class helps you look up a copybook based on its name.
 * <p>
 * There are two ways of configuring how this works. One is by setting the paths
 * in which to look. The other is by installing a custom
 * {@linkplain CopybookLocator} via the <code>koopa.copybooks.locator</code>
 * system property.
 */
public class Copybooks {

	private static final Logger LOGGER = Logger.getLogger("copybooks");

	private static CopybookLocator locator = new DefaultCopybookLocator();

	static {
		final String className = System.getProperty("koopa.copybooks.locator");

		try {
			if (className != null) {
				if (LOGGER.isDebugEnabled())
					LOGGER.debug("Attempting to instantiate copybook locator: "
							+ className + " ...");

				Class<?> locatorClass = Class.forName(className);
				// This cast may fail if the class we loaded is not a
				// CopybookLocator. In that case we just want the thing to break
				// with a ClassCastException, I think.
				CopybookLocator l = (CopybookLocator) locatorClass
						.newInstance();
				locator = l;
			}

		} catch (ClassNotFoundException e) {
			LOGGER.error("Failed to set copybook locator: " + className
					+ ". Using default instead.", e);

		} catch (InstantiationException e) {
			LOGGER.error("Failed to set copybook locator: " + className
					+ ". Using default instead.", e);

		} catch (IllegalAccessException e) {
			LOGGER.error("Failed to set copybook locator: " + className
					+ ". Using default instead.", e);
		}
	}

	private List<File> copybookPaths = new ArrayList<File>();

	public File locate(String textName, String libraryName, File sourceFile) {
		return locator.locate(textName, libraryName, sourceFile, copybookPaths);
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
