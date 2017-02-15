package koopa.cobol;

import java.io.File;
import java.io.Reader;
import java.util.List;

import koopa.cobol.grammar.preprocessing.CobolPreprocessingGrammar;
import koopa.cobol.sources.CompilerDirectives;
import koopa.cobol.sources.ContinuationOfLines;
import koopa.cobol.sources.CopyInclude;
import koopa.cobol.sources.InlineComments;
import koopa.cobol.sources.ProgramArea;
import koopa.cobol.sources.Replace;
import koopa.cobol.sources.Replacing;
import koopa.cobol.sources.SourceFormat;
import koopa.core.data.Data;
import koopa.core.data.Token;
import koopa.core.sources.LineSplitter;
import koopa.core.sources.NarrowingSource;
import koopa.core.sources.Source;
import koopa.core.sources.StackOfSources;
import koopa.core.sources.TokenSeparator;
import koopa.core.sources.WideningSource;
import koopa.core.util.LineEndings;

public final class CobolTokens {

	private CobolTokens() {
	}

	public static Source<Token> getNewSource(File file, Reader reader,
			CobolPreprocessingGrammar grammar, SourceFormat format,
			Copybooks copybooks) {

		// Note: The logical unit is a source line, I think.
		// You should never ask for the next line if you haven't resolved the
		// current one.

		final StackOfSources<Data, Source<Data>> inputStack //
				= new StackOfSources<Data, Source<Data>>();

		final List<List<Character>> lineEndings = LineEndings.getChoices();
		final LineSplitter lineSplitter //
				= new LineSplitter(file, reader, lineEndings);

		inputStack.push(
				new WideningSource<Data, Token>(lineSplitter, Token.class));

		// * Detect compiler directives, source format and source listing
		// statements. Apply source format switches.
		final CompilerDirectives compilerDirectives //
				= new CompilerDirectives(inputStack, format);

		// * Split lines according to the source format.
		final ProgramArea programArea //
				= new ProgramArea(compilerDirectives);

		// * Split program text into tokens.
		final TokenSeparator tokenSeparator //
				= new TokenSeparator(programArea);

		// * Inline comments.
		final InlineComments inlineComments //
				= new InlineComments(tokenSeparator);

		final Source<Data> optionalCopybookExpansion;

		if (copybooks == null) {
			// COPY statements will be left alone.
			optionalCopybookExpansion = inlineComments;

		} else {
			// REPLACE statements will be expanded and applied.

			// This stage is tested in
			// koopa.cobol.parser.preprocessing.test.PreprocessingSourceTest2

			// * Handle COPY includes.
			final CopyInclude copyInclude //
					= new CopyInclude( //
							inlineComments, grammar, copybooks, inputStack);

			// * Handle COPY REPLACING.
			final Replacing copyReplacing //
					= new Replacing(copyInclude);
			optionalCopybookExpansion = copyReplacing;
		}

		// * Line continuations.
		final ContinuationOfLines continuationOfLines //
				= new ContinuationOfLines(optionalCopybookExpansion);

		// We may or may not be activating replacements. This variable will just
		// track what we chose in the end.
		final Source<Data> optionalReplaceStatements;

		// We don't need actual copybook paths to implement REPLACE statements.
		// But we do use it as a marker to see whether we should actually be
		// expanding them.
		if (copybooks == null) {
			// REPLACE statements will be left alone.
			optionalReplaceStatements = continuationOfLines;

		} else {
			// REPLACE statements will be expanded and applied.

			// This stage is tested in
			// koopa.cobol.parser.preprocessing.test.PreprocessingSourceTest2

			// * Handle REPLACE statements.
			final Replace replace //
					= new Replace(continuationOfLines, grammar);
			// * Handle actual replacements.
			final Replacing replacing //
					= new Replacing(replace);

			optionalReplaceStatements = replacing;
		}

		// And reduce to return only tokens.
		final Source<Token> tokens = NarrowingSource.narrowing( //
				optionalReplaceStatements, Token.class);

		return tokens;
	}

	public static Source<Token> getNewSource(Reader reader,
			CobolPreprocessingGrammar grammar, SourceFormat format) {
		return getNewSource(null, reader, grammar, format, null);
	}
}
