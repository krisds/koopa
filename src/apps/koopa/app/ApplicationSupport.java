package koopa.app;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
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

	private static JFileChooser chooser = null;

	public static File askUserForFile(final boolean openFile, String key,
			FileFilter filter, final Component parent) {

		File start = null;
		try {
			if (Arrays.asList(preferences.keys()).contains(key)) {
				String lastUsedFileName = preferences.get(key, null);

				File lastUsed = new File(lastUsedFileName);

				if (lastUsed.exists())
					start = lastUsed.getParentFile();
			}
		} catch (BackingStoreException e) {
			e.printStackTrace();
			start = null;
		}

		if (chooser == null)
			chooser = new JFileChooser();

		if (start == null)
			start = new File(".");

		chooser.setCurrentDirectory(start.isDirectory() ? start : start
				.getParentFile());

		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setAcceptAllFileFilterUsed(false);

		if (filter != null)
			chooser.setFileFilter(filter);

		final int[] returnVal = new int[] { -1 };

		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					returnVal[0] = openFile ? chooser.showOpenDialog(parent)
							: chooser.showSaveDialog(parent);
				}
			});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (returnVal[0] == JFileChooser.APPROVE_OPTION) {
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

	public static File askUserForFolder(String key, final Component parent) {

		File start = null;
		try {
			if (Arrays.asList(preferences.keys()).contains(key)) {
				String lastUsedFileName = preferences.get(key, null);

				File lastUsed = new File(lastUsedFileName);

				if (lastUsed.exists())
					start = lastUsed;
			}
		} catch (BackingStoreException e) {
			e.printStackTrace();
			start = null;
		}

		if (chooser == null)
			chooser = new JFileChooser();

		if (start == null)
			start = new File(".");

		chooser.setCurrentDirectory(start.isDirectory() ? start : start
				.getParentFile());

		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);

		final int[] returnVal = new int[] { -1 };

		returnVal[0] = chooser.showOpenDialog(parent);

		if (returnVal[0] == JFileChooser.APPROVE_OPTION) {
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

	private static synchronized Preferences getPreferences() {
		Preferences preferencesRoot = Preferences.userRoot();
		Preferences appPreferences = preferencesRoot.node(PREFERENCES_ROOT);
		return appPreferences;
	}

	private static synchronized Properties getProperties() {
		if (properties == null) {

			FileInputStream stream = null;
			properties = new Properties();
			try {
				stream = new FileInputStream(PROPERTIES_FILE);
				properties.load(stream);

			} catch (FileNotFoundException e) {
				LOGGER.info("Could not find default properties.");

			} catch (IOException e) {
				LOGGER.error("IOException while reading default properties.", e);

			} finally {
				try {
					if (stream != null)
						stream.close();
				} catch (IOException e) {
					LOGGER.error(
							"IOException while closing default properties.", e);
				}
			}
		}

		return properties;
	}

	public static List<String> getCustomColumnKeys() {
		String customColumnKeys = properties.getProperty(
				PROPERTY_CUSTOM_COLUMNS, "");
		if (customColumnKeys.length() == 0)
			return new ArrayList<String>();
		return Arrays.asList(customColumnKeys.trim().split("\\s*[,;|]\\s*"));
	}

	public static String getCustomColumnProperty(String key, String property) {
		return getCustomColumnProperty(key, property, "");
	}

	public static String getCustomColumnProperty(String key, String property,
			String defaultValue) {
		return properties.getProperty(
				PROPERTY_CUSTOM_COLUMN_PREFIX + key + "." + property,
				defaultValue).trim();
	}

	public static JFrame inFrame(String title, Component component) {
		JFrame frame = new JFrame(title);

		frame.add(component);

		frame.setSize(800, 600);
		return frame;
	}

	public static String getRevision() {
		BufferedReader b = null;
		try {
			InputStream in = ApplicationSupport.class
					.getResourceAsStream("/REVISION");

			if (in == null)
				return "unkown";

			InputStreamReader r = new InputStreamReader(in);
			b = new BufferedReader(r);

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
			try {
				if (b != null)
					b.close();
			} catch (IOException e) {
			}
		}
	}
}
