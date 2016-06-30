package koopa.cobol.parser.preprocessing;

import java.io.File;

import koopa.cobol.grammar.preprocessing.CobolPreprocessingGrammar;
import koopa.cobol.parser.preprocessing.replacing.ReplacingSource;
import koopa.core.data.Data;
import koopa.core.data.Replaced;
import koopa.core.data.Token;
import koopa.core.sources.ChainingSource;
import koopa.core.sources.Source;
import koopa.core.sources.NarrowingSource;
import koopa.core.sources.WideningSource;

/**
 * This represents an input for the preprocessor. It takes an initial
 * {@linkplain Source} of {@linkplain Token}s and does two things to it:
 * <ol>
 * <li>It parses the source by means of the
 * {@linkplain CobolPreprocessingGrammar#preprocessing()} grammar. This is
 * handled in a separate class,
 * {@linkplain SourceWithParsedPreprocessingDirectives}.</li>
 * <li>It applies any replacements which may have been defined to be applied to
 * the incoming tokens. This too is handled in a separate class,
 * {@linkplain ReplacingSource}.</li>
 * </ol>
 * The combination of both is what gets returned as the result.
 */
class PreprocessorInput extends ChainingSource<Token, Data>
		implements Source<Data> {

	private final File file;
	private final Replaced replaced;

	private ReplacingSource withReplacements;
	private SourceWithParsedPreprocessingDirectives sourceWithParsedPreprocessingDirectives;

	public PreprocessorInput(File file, Source<Token> source) {
		this(file, source, null, null);
	}

	public PreprocessorInput(File file, Source<Token> source,
			ReplacingSource replacing, Replaced replacement) {
		super(source);

		this.file = file;
		this.replaced = replacement;

		// The source may see its contents being replaced.
		this.withReplacements = replacing;
		if (this.withReplacements != null)
			this.withReplacements.setSource( //
					new WideningSource<Data, Token>(this.source, Token.class));

		// The final source gets pushed through a preprocessing grammar, which
		// looks out for preprocessing directives.
		this.sourceWithParsedPreprocessingDirectives = //
				new SourceWithParsedPreprocessingDirectives( //
						this.withReplacements == null ? //
								this.source : //
								new NarrowingSource<Data, Token>(
										this.withReplacements, Token.class));
	}

	@Override
	protected Data nxt1() {
		return asReplacing(sourceWithParsedPreprocessingDirectives.next());
	}

	private Data asReplacing(Data data) {
		if (data == null)
			return null;
		else if (replaced != null && data instanceof Token)
			return ((Token) data).asReplacing(replaced);
		else
			return data;
	}

	public void close() {
		sourceWithParsedPreprocessingDirectives.close();
	}

	public File getFile() {
		return file;
	}

	public Replaced getReplaced() {
		return replaced;
	}
}