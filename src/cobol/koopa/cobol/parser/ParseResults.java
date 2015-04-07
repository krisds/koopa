package koopa.cobol.parser;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import koopa.core.data.Position;
import koopa.core.data.Token;
import koopa.core.targets.TokenTracker;
import koopa.core.treeparsers.Tree;
import koopa.core.util.Tuple;

public class ParseResults {

	private final File file;

	private boolean validInput = false;

	private TokenTracker tokenTracker = null;

	private List<Tuple<Token, String>> warnings = new LinkedList<Tuple<Token, String>>();

	private List<Tuple<Token, String>> errors = new LinkedList<Tuple<Token, String>>();

	private Tree tree = null;

	private int numberOfLines = -1;

	private int numberOfLinesWithCode = -1;

	private int numberOfLinesWithComments = -1;

	public ParseResults(File file) {
		this.file = file;
		this.validInput = false;
	}

	public void setValidInput(boolean validity) {
		this.validInput = validity;
	}

	public void addWarning(Token t, String msg) {
		if (msg == null)
			return;

		if (t == null)
			t = new Token("", new Position(0, 0, 0), new Position(0, 0, 0));

		this.warnings.add(new Tuple<Token, String>(t, msg));
	}

	public void addError(Token t, String msg) {
		if (msg == null)
			return;

		if (t == null)
			t = new Token("", new Position(0, 0, 0), new Position(0, 0, 0));

		this.errors.add(new Tuple<Token, String>(t, msg));
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

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	public Tree getTree() {
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
		copy.numberOfLines = numberOfLines;
		copy.numberOfLinesWithCode = numberOfLinesWithCode;
		copy.numberOfLinesWithComments = numberOfLinesWithComments;
		return copy;
	}

	public void setNumberOfLines(int numberOfLines) {
		this.numberOfLines = numberOfLines;
	}

	public int getNumberOfLines() {
		return numberOfLines;
	}

	public void setNumberOfLinesWithCode(int numberOfLinesWithCode) {
		this.numberOfLinesWithCode = numberOfLinesWithCode;
	}

	public int getNumberOfLinesWithCode() {
		return numberOfLinesWithCode;
	}

	public void setNumberOfLinesWithComments(int numberOfLinesWithComments) {
		this.numberOfLinesWithComments = numberOfLinesWithComments;
	}

	public int getNumberOfLinesWithComments() {
		return numberOfLinesWithComments;
	}
}
