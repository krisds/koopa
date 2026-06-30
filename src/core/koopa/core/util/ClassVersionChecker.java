package koopa.core.util;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * This class reports its own class version, which helps me verify that things
 * were indeed compiled at the right class level. Even though the build script
 * forces a specific class version, my editor was set at a different level, and
 * that was causing problems...
 * <p>
 * So with this I can now double check easily what version of Java the compiled
 * result is targeted at.
 */
public final class ClassVersionChecker {

	private ClassVersionChecker() {
	}

	// TODO: when on JDK 20+ see java.lang.reflect.ClassFileFormatVersion

	// Java 1.0, has major version 45 like Java 1.1
	private static final int FILE_VERSION_O = 45;

	// Java 28, https://docs.oracle.com/en/java/javase/28/docs/specs/jvms/index.html
	private static final int FILE_VERSION_LATEST = 72; 

	private static final String[] JAVA_VERSIONS = { "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "9", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
			"28" };

	public static void main(String[] args) throws IOException {

		try (final DataInputStream in = new DataInputStream(
				ClassVersionChecker.class.getResourceAsStream("ClassVersionChecker.class"))){

			final int magicNumber = in.readInt();
			if (magicNumber != 0xcafebabe) {
				System.out.println("Not a valid class file!");
				System.exit(1);
			}

			final int minorFileVersion = in.readUnsignedShort();
			final int majorFileVersion = in.readUnsignedShort();
			final String fileVersion = majorFileVersion + "." + minorFileVersion;

			if (45 <= majorFileVersion || FILE_VERSION_LATEST <= majorFileVersion) {
				System.out.println(
						"Generated class file version " + fileVersion + " (Java " + JAVA_VERSIONS[majorFileVersion - FILE_VERSION_O] + ")");
			} else {
				System.out.println("Generated class file version " + fileVersion + " (unknown Java version)");
			}
		}

	}

}