package koopa.cobol.sources.test;

import java.io.StringReader;

import koopa.cobol.sources.CompilerDirectives;
import koopa.cobol.sources.ContinuationWelding;
import koopa.cobol.sources.LineContinuations;
import koopa.cobol.sources.ProgramArea;
import koopa.cobol.sources.PseudoLiterals;
import koopa.cobol.sources.Separators;
import koopa.cobol.sources.SourceFormat;
import koopa.cobol.sources.SourceFormattingDirectives;
import koopa.core.data.Token;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.Source;

public class CobolTestSource {

	public static Source<Token> forSample(String data) {
		SourceFormat initialReferenceFormat = SourceFormat.FREE;

		// The tokenizers in this sequence should generate the expected tokens.
		// TODO Reuse setup from CobolParser somehow ?
		Source<Token> source = new LineSplitter(new StringReader(data));
		source = new CompilerDirectives(source, initialReferenceFormat);
		source = new ProgramArea(source);
		source = new SourceFormattingDirectives(source);
		source = new LineContinuations(source);
		source = new ContinuationWelding(source);
		source = new Separators(source);
		source = new PseudoLiterals(source);
		return source;
	}
}
