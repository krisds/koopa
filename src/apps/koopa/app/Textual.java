package koopa.app;

public interface Textual {

	boolean find(String pattern);

	int getAdjustedLineCount();

	void scrollToLine(int line);
}
