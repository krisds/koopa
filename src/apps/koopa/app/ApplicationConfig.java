package koopa.app;

import java.lang.reflect.InvocationTargetException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import koopa.cobol.CobolProject;
import koopa.cobol.projects.StandardCobolProject;

public class ApplicationConfig {

	private static final String KOOPA_COBOL_PROJECT_CLASS = "koopa.cobol.project_class";

	private static final Logger LOGGER = LogManager.getLogger("copybooks");

	private static Class<? extends CobolProject> projectClass = StandardCobolProject.class;

	static {
		final String className = System.getProperty(KOOPA_COBOL_PROJECT_CLASS);

		try {
			if (className != null) {
				if (LOGGER.isDebugEnabled())
					LOGGER.debug("Attempting to instantiate project class: {} ...", className);

				final Class<?> givenClass = Class.forName(className);
				// This cast may fail if the class we loaded is not a
				// CobolProject. In that case we just want the thing to break
				// with a ClassCastException, I think.
				projectClass = givenClass.asSubclass(CobolProject.class);
			}

		} catch (ClassNotFoundException e) {
			LOGGER.error("Failed to set project class: {}. Using default instead.", className, e);
		}
	}

	public static void setProjectClass(Class<? extends CobolProject> clazz) {
		projectClass = clazz;
	}

	// TODO @Deprecated ? Kill this ?
	public static CobolProject getANewProject() {
		if (LOGGER.isDebugEnabled())
			LOGGER.debug("Attempting to instantiate project class: {} ...", projectClass);

		try {
			return projectClass.getDeclaredConstructor().newInstance();
		} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException e) {
			LOGGER.error("Failed to set project class: {}. Using default instead.", projectClass, e);
			return new StandardCobolProject();
		}

	}
}
