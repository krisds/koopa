package koopa.core.parsers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Token;
import koopa.core.util.Tuple;

public class Messages {

	private List<Tuple<Token, String>> warnings = new LinkedList<>();
	private List<Tuple<Token, String>> errors = new LinkedList<>();

	public Messages() {
	}

	public void warn(Token t, String msg) {
		if (msg != null)
			warnings.add(new Tuple<>(t, msg));
	}

	public boolean hasWarnings() {
		return !warnings.isEmpty();
	}

	public List<Tuple<Token, String>> getWarnings() {
		return Collections.unmodifiableList(warnings);
	}

	public int getWarningCount() {
		return warnings.size();
	}

	public Tuple<Token, String> getWarning(int index) {
		return warnings.get(index);
	}

	public void error(Token t, String msg) {
		if (msg != null)
			errors.add(new Tuple<>(t, msg));
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public List<Tuple<Token, String>> getErrors() {
		return Collections.unmodifiableList(errors);
	}

	public int getErrorCount() {
		return errors.size();
	}

	public Tuple<Token, String> getError(int index) {
		return errors.get(index);
	}
}
