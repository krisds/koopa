package koopa.app;

import org.apache.log4j.Logger;

import koopa.cobol.CobolProject;
import koopa.cobol.projects.StandardCobolProject;

public class ApplicationConfig {

	private static final String KOOPA_COBOL_PROJECT_CLASS = "koopa.cobol.project_class";

	private static final Logger LOGGER = Logger.getLogger("copybooks");

	private static Class<? extends CobolProject> projectClass = StandardCobolProject.class;

	static {
		final String className = System.getProperty(KOOPA_COBOL_PROJECT_CLASS);

		try {
			if (className != null) {
				if (LOGGER.isDebugEnabled())
					LOGGER.debug("Attempting to instantiate project class: "
							+ className + " ...");

				final Class<?> givenClass = Class.forName(className);
				// This cast may fail if the class we loaded is not a
				// CobolProject. In that case we just want the thing to break
				// with a ClassCastException, I think.
				projectClass = (Class<? extends CobolProject>) givenClass;
			}

		} catch (ClassNotFoundException e) {
			LOGGER.error("Failed to set project class: " + className
					+ ". Using default instead.", e);
		}
	}

	public static void setProjectClass(Class<? extends CobolProject> clazz) {
		projectClass = clazz;
	}

	// TODO @Deprecated ? Kill this ?
	public static CobolProject getANewProject() {
		try {
			if (LOGGER.isDebugEnabled())
				LOGGER.debug("Attempting to instantiate project class: "
						+ projectClass + " ...");

			return projectClass.newInstance();

		} catch (InstantiationException e) {
			LOGGER.error("Failed to set project class: " + projectClass
					+ ". Using default instead.", e);
			return new StandardCobolProject();

		} catch (IllegalAccessException e) {
			LOGGER.error("Failed to set project class: " + projectClass
					+ ". Using default instead.", e);
			return new StandardCobolProject();
		}
	}
}
