package koopa.app.parsers;


import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.antlr.runtime.tree.CommonTree;

import koopa.tokens.Token;
import koopa.util.Tuple;

public class ParseResults {

	private File file = null;

	private boolean validInput = false;

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

	public void setTree(CommonTree tree) {
		this.tree  = tree;
	}
	
	public CommonTree getTree() {
		return this.tree;
	}
}
