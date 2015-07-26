package koopa.dsl.stage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import koopa.core.data.Token;
import koopa.core.sources.Source;
import koopa.core.trees.Tree;
import koopa.core.trees.ui.TreeFrame;
import koopa.dsl.stage.source.StageTokens;
import koopa.dsl.stage.util.StageUtil;

public class Main {
	public static void main(String[] args) throws IOException {
		File input = new File(
				"test/cobol/koopa/cobol/grammar/test/ExecStatement.stage");

		Tree ast = StageUtil.getAST(input);

		if (ast != null) {
			System.out.println(ast);
			new TreeFrame(input.getName(), ast).setVisible(true);
		} else {

			final Source<Token> source = StageTokens.getNewSource(//
					input.getName(), new FileReader(input));

			Token token = null;
			while ((token = source.next()) != null)
				System.out.println(token);

		}
	}
}
