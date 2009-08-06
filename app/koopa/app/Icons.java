package koopa.app;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class Icons {
	private static Map<String, ImageIcon> icons = new HashMap<String, ImageIcon>();

	public static synchronized ImageIcon getIcon(String reference) {
		if (icons.containsKey(reference)) {
			return icons.get(reference);
		}

		URL resource = Icons.class.getResource(reference);
		if (resource == null) {
			System.out.println("Warning: could not find resource for "
					+ reference);
			return null;
		}

		ImageIcon icon = new ImageIcon(resource);
		icons.put(reference, icon);

		return icon;
	}
}
