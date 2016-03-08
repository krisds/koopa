package koopa.cobol.copybooks;

import java.io.File;
import java.util.List;

/**
 * The spec on copybook resolution:
 * <p>
 * "The implementor shall define the rules for locating the library text
 * referenced by text-name-1 or literal-1. When neither library-name-1 nor
 * literal-2 is specified, a default COBOL library is used. The implementor
 * defines the mechanism for identifying the default COBOL library."
 * <p>
 * The default locator used is {@linkplain DefaultCopybookLocator}, which also
 * acts as an example of how to write one.
 */
public interface CopybookLocator {
	File locate(String textName, String libraryName, File sourceFile,
			List<File> copybookPaths);
}
