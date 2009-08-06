package koopa.trees.antlr.filter.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;

public class GenerateANTLRv3TreeFilters {

	public static void main(String[] args) throws IOException,
			RecognitionException {

		for (String target : args) {
			process(new File(target));
		}
	}

	private static void process(File file) {
		if (!file.exists()) {
			return;

		} else if (file.isDirectory()) {
			File[] files = file.listFiles();

			for (File stage : files) {
				process(stage);
			}

		} else if (file.getName().endsWith(".filter.properties")) {
			try {
				ANTLRToFilter.generate(file);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
