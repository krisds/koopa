package koopa.util.test;

import java.io.File;

public interface FileBasedTest {
	File[] getFiles();

	void setFile(File source);
}
