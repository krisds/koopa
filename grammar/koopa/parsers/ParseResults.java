package koopa.parsers;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import koopa.tokenizers.cobol.TokenTracker;
import koopa.tokens.Token;
import koopa.util.Tuple;

import org.antlr.runtime.tree.CommonTree;

public class ParseResults {

	private final File file;

	private boolean validInput = false;

	private TokenTracker tokenTracker = null;

	private List<Tuple<Token, String>> warnings = new LinkedList<Tuple<Token, String>>();

	private List<Tuple<Token, String>> errors = new LinkedList<Tuple<Token, String>>();

	private CommonTree tree = null;

	public ParseResults(File file) {
		this.file = file;
		this.validInput = false;
	}

	public void setValidInput(boolean validity) {
		this.validInput = validity;
	}

	public void addWarning(Token t, String msg) {
		if (msg != null) {
			this.warnings.add(new Tuple<Token, String>(t, msg));
		}
	}

	public void addError(Token t, String msg) {
		if (msg != null) {
			this.errors.add(new Tuple<Token, String>(t, msg));
		}
	}

	public File getFile() {
		return this.file;
	}

	public boolean isValidInput() {
		return this.validInput;
	}

	public int getWarningCount() {
		return this.warnings.size();
	}

	public int getErrorCount() {
		return this.errors.size();
	}

	public Tuple<Token, String> getError(int i) {
		return this.errors.get(i);
	}

	public Tuple<Token, String> getWarning(int i) {
		return this.warnings.get(i);
	}

	public TokenTracker getTokenTracker() {
		return tokenTracker;
	}

	public void setTokenTracker(TokenTracker tokenTracker) {
		this.tokenTracker = tokenTracker;
	}

	public void setTree(CommonTree tree) {
		this.tree = tree;
	}

	public CommonTree getTree() {
		return this.tree;
	}

	public void clearTree() {
		this.tree = null;
	}

	public void clearTokens() {
		this.tokenTracker = null;
	}

	public ParseResults copy() {
		ParseResults copy = new ParseResults(file);
		copy.validInput = validInput;
		copy.tokenTracker = tokenTracker;
		copy.warnings = warnings;
		copy.errors = errors;
		copy.tree = tree;
		return copy;
	}
}
