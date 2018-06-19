package koopa.app;

import java.awt.Component;
import java.io.File;

import javax.swing.JFrame;

import koopa.app.components.overview.Overview;
import koopa.core.data.Token;
import koopa.core.trees.Tree;
import koopa.core.util.Tuple;

public interface Application {

	void openFile(File file);

	void openFile(File file, CobolParserFactory factory);

	void openFile(File file, CobolParserFactory factory,
			Tuple<Token, String> detail);

	void reloadFile();

	void closeView();

	void scrollTo(Token token);

	void resultsWereCleared();

	void walkingAndParsing();

	void doneWalkingAndParsing();

	void addApplicationListener(ApplicationListener listener);

	Tree getSyntaxTree();

	// TODO Set up a View type.
	Component getView();

	CobolParserFactory getCobolParserFactory();

	void closeView(Component component);

	void swapView(Component oldView, Component newView);

	void showGrammarRule(String name);

	void showGrammarRules();

	void quitParsing();

	Overview getOverview();

	JFrame getFrame();
}
