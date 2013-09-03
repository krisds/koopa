package koopa.app;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

import org.apache.log4j.Logger;

public class ApplicationSupport {
	private static final Logger LOGGER = Logger.getLogger("config");

	private static final String PROPERTIES_FILE = "koopa.properties";
	private static final String PROPERTY_CUSTOM_COLUMNS = "koopa.customColumns";
	private static final String PROPERTY_CUSTOM_COLUMN_PREFIX = "koopa.customColumn.";	
	private static Properties properties = getProperties();
	
	private static final String PREFERENCES_ROOT = "net.sourceforge.koopa.app.preferences";
	private static Preferences preferences = getPreferences();
	
	private static List<String> EXTENSIONS = new LinkedList<String>();
	
	private static String DESCRIPTION = "";
	
	static {
		EXTENSIONS.add(".CPY");
		EXTENSIONS.add(".COPY");
		EXTENSIONS.add(".CBL");
		EXTENSIONS.add(".COB");

		String extraExtensions = System
				.getProperty("koopa.cobolFileExtensions");
		if (extraExtensions != null) {
			for (String extraExtension : extraExtensions.split(",")) {
				EXTENSIONS.add("." + extraExtension.trim().toUpperCase());
			}
		}

		for (String extension : EXTENSIONS) {
			if (DESCRIPTION.length() > 0)
				DESCRIPTION += ", ";

			DESCRIPTION += extension;
		}
	}

	public static File askUserForFile(boolean openFile, String key,
			FileFilter filter, Component parent) {
		File start = null;
		try {
			if (Arrays.asList(preferences.keys()).contains(key)) {
				String lastUsedFileName = preferences.get(key, null);
				
				File lastUsed = new File(lastUsedFileName);
				
				if (lastUsed.exists()) {
					start = lastUsed.getParentFile();
				}
			}
		} catch (BackingStoreException e) {
			e.printStackTrace();
			start = null;
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
				preferences.put(key, selectedFile.getCanonicalPath());
				
			} catch (IOException e) {
				e.printStackTrace();
			}

			return selectedFile;

		} else
			return null;
	}
	
	private static synchronized Preferences getPreferences () {
		Preferences preferencesRoot = Preferences.userRoot();
		Preferences appPreferences = preferencesRoot.node(PREFERENCES_ROOT);
		return appPreferences;
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
	
	public static List<String> getCustomColumnKeys()
	{
		String customColumnKeys = properties.getProperty(PROPERTY_CUSTOM_COLUMNS, "");
		if (customColumnKeys.length() == 0)
			return new ArrayList<String>();
		return Arrays.asList(customColumnKeys.trim().split("\\s*[,;|]\\s*"));
	}
	
	public static String getCustomColumnProperty (String key, String property)
	{
		return getCustomColumnProperty(key, property, "");
	}
	
	public static String getCustomColumnProperty (String key, String property, String defaultValue)
	{
		return properties.getProperty(PROPERTY_CUSTOM_COLUMN_PREFIX + key + "." + property, defaultValue).trim();
	}
	
	public static void configureFromProperties(String filename, Configurable app) {
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

	public static FileFilter getCobolFileFilter() {
		return getCobolFileFilter(true);
	}

	public static FileFilter getCobolFileFilter(final boolean filesOnly) {
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

	public static FilenameFilter getFilenameFilter() {
		return new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return isCobolFileName(name);
			}
		};
	}

	public static boolean isCobolFile(File file) {
		if (!file.isFile())
			return false;

		return isCobolFileName(file.getName());
	}

	public static boolean isCobolFileName(String name) {
		name = name.toUpperCase();

		for (String extension : EXTENSIONS) {
			if (name.endsWith(extension))
				return true;
		}

		return false;
	}

	public static JFrame inFrame(String title, Component component) {
		JFrame frame = new JFrame(title);

		frame.add(component);

		frame.setSize(800, 600);
		return frame;
	}

	public static String getRevision() {
		InputStream in = null;
		try {
			in = ApplicationSupport.class.getResourceAsStream("/REVISION");

			if (in == null)
				return "unkown";

			InputStreamReader r = new InputStreamReader(in);
			BufferedReader b = new BufferedReader(r);

			String revision = b.readLine();

			if (revision == null)
				return "unkown";

			revision = revision.trim();
			if (revision.length() == 0)
				return "unkown";
			else
				return revision;

		} catch (IOException e) {
			e.printStackTrace();
			return "unkown";

		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
				}
		}
	}
}
