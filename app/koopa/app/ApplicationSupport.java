package koopa.app;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import org.apache.log4j.Logger;

public class ApplicationSupport {
	private static final Logger LOGGER = Logger.getLogger("config");

	private static final String PROPERTIES_FILE = "koopa.properties";

	private static Properties properties = getProperties();

	public static File askUserForFile(boolean openFile, String key,
			FileFilter filter, Component parent) {
		File start = null;
		if (properties.containsKey(key)) {
			File lastUsed = new File(properties.getProperty(key));
			if (lastUsed.exists()) {
				start = lastUsed.getParentFile();
			}
		}

		JFileChooser chooser = new JFileChooser(start);
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setAcceptAllFileFilterUsed(false);
		if (filter != null) {
			chooser.setFileFilter(filter);
		}

		int returnVal = openFile ? chooser.showOpenDialog(parent) : chooser
				.showSaveDialog(parent);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();

			try {
				properties.setProperty(key, selectedFile.getCanonicalPath());
				saveProperties();

			} catch (IOException e) {
				e.printStackTrace();
			}

			return selectedFile;

		} else
			return null;
	}

	private static synchronized Properties getProperties() {
		if (properties == null) {

			properties = new Properties();
			try {
				properties.load(new FileInputStream(PROPERTIES_FILE));
			} catch (FileNotFoundException e) {
				// Ignore.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return properties;
	}

	private static void saveProperties() throws IOException,
			FileNotFoundException {
		properties.store(new FileOutputStream(PROPERTIES_FILE), null);
	}

	public static void configureFromProperties(String filename,
			ConfigurableApplication app) {
		try {
			LOGGER.info("Loading configuration options from \"" + filename
					+ "\".");

			Properties properties = new Properties();
			properties.load(new FileInputStream(new File(filename)));

			for (Object key : properties.keySet()) {
				final String name = (String) key;
				final String value = properties.getProperty(name);
				app.setOption(name, value);
			}

			LOGGER.info("Configuration loaded.");

		} catch (FileNotFoundException e) {
			LOGGER.info("Could not find \"" + filename
					+ "\". Going with defaults.");

		} catch (IOException e) {
			LOGGER.error("IOException while reading \"" + filename + "\".", e);
		}
	}
}
