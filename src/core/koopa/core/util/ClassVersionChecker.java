package koopa.core.util;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class reports its own class version, which helps me verify that things
 * were indeed compiled at the right class level. Even though the build script
 * forces a specific class version, my editor was set at a different level, and
 * that was causing problems...
 * <p>
 * So with this I can now double check easily what version of Java the compiled
 * result is targeted at.
 */
public class ClassVersionChecker {
	public static final Map<String, String> JAVA_VERSIONS = new HashMap<>();

	static {
		JAVA_VERSIONS.put("45.3", "1.0");
		JAVA_VERSIONS.put("45.3", "1.1");
		JAVA_VERSIONS.put("46.0", "1.2");
		JAVA_VERSIONS.put("47.0", "1.3");
		JAVA_VERSIONS.put("48.0", "1.4");
		JAVA_VERSIONS.put("49.0", "1.5");
		JAVA_VERSIONS.put("50.0", "1.6");
		JAVA_VERSIONS.put("51.0", "1.7");
		JAVA_VERSIONS.put("52.0", "1.8");
	}

	public static void main(String[] args) throws IOException {
		DataInputStream in = new DataInputStream(
				ClassVersionChecker.class
						.getResourceAsStream("ClassVersionChecker.class"));

		final int magicNumber = in.readInt();
		if (magicNumber != 0xcafebabe)
			System.out.println("Not a valid class!");

		final int minorVersion = in.readUnsignedShort();
		final int majorVersion = in.readUnsignedShort();
		final String version = majorVersion + "." + minorVersion;

		if (JAVA_VERSIONS.containsKey(version))
			System.out.println("Version " + version + " (Java "
					+ JAVA_VERSIONS.get(version) + ")");
		else
			System.out
					.println("Version " + version + " (unknown Java version)");

		in.close();
	}
}