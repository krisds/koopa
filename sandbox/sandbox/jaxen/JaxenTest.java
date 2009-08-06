package sandbox.jaxen;

import java.io.File;
import java.io.IOException;

import koopa.app.parsers.ParseResults;
import koopa.app.parsers.ParsingCoordinator;


public class JaxenTest {

	public static void main(String[] args) throws IOException {
		ParsingCoordinator coordinator = new ParsingCoordinator();
		coordinator.addParsingListener(new MyJaxenParsingListener());

		ParseResults result = coordinator.parse(new File(
				"testsuite/cobol85/CM101M.CBL"));

		if (result.isValidInput()) {
			System.out.println("Input is valid.");

		} else {
			System.out.println("Input is faulty.");
		}

		System.out.println("  " + result.getErrorCount() + " error(s).");
		System.out.println("  " + result.getWarningCount() + " warning(s).");
	}
}
