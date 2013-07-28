package koopa.app;

import java.awt.Component;
import java.io.File;

import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokens.Token;
import koopa.util.Tuple;

import org.antlr.runtime.tree.CommonTree;

public interface Application {

	void openFile(File file);

	void openFile(File file, SourceFormat format);

	void openFile(File file, SourceFormat format, Tuple<Token, String> detail);

	void reloadFile();

	void closeView();

	void scrollTo(int position);

	void resultsWereCleared();

	void walkingAndParsing();

	void doneWalkingAndParsing();

	void addApplicationListener(ApplicationListener listener);

	CommonTree getSyntaxTree();

	// TODO Set up a View type.
	Component getView();

	void closeView(Component component);

	void showGrammarRule(String name);

	void showGrammarRules();
}
