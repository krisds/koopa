package koopa.tokenizers.cobol.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;
import koopa.tokenizers.cobol.CompilerDirectivesTokenizer;
import koopa.tokenizers.cobol.SourceFormat;
import koopa.tokenizers.cobol.tags.AreaTag;
import koopa.tokens.Token;

import org.junit.Test;

// TODO Get these test lines from a file, either through a specialized JUnit runner, or by generating this test class from a DSL (like the stages). 
public class CompilerDirectivesTokenizerTest extends TestCase {

	@Test
	public void testSourceFormatIsFree_1() {
		isACompilerDirective("123456 >> source format is free  ");
	}

	@Test
	public void testSourceFormatIsFree_2() {
		isACompilerDirective("123456 >> source format free  ");
	}

	@Test
	public void testSourceFormatIsFree_3() {
		isACompilerDirective("123456 >> source is free  ");
	}

	@Test
	public void testSourceFormatIsFree_4() {
		isACompilerDirective("123456 >> source free  ");
	}

	@Test
	public void testSourceFormatIsFixed_1() {
		isACompilerDirective("123456 >> source format is fixed  ");
	}

	@Test
	public void testSourceFormatIsFixed_2() {
		isACompilerDirective("123456 >> source format fixed  ");
	}

	@Test
	public void testSourceFormatIsFixed_3() {
		isACompilerDirective("123456 >> source is fixed  ");
	}

	@Test
	public void testSourceFormatIsFixed_4() {
		isACompilerDirective("123456 >> source fixed  ");
	}

	// TODO More.

	private void isACompilerDirective(String text) {
		List<Token> tokens = fixed(text);

		Assert.assertTrue(tokens.size() == 1);

		final Token token = tokens.get(0);
		Assert.assertTrue(token.hasTag(AreaTag.COMPILER_DIRECTIVE));
		Assert.assertEquals(text, token.getText());
	}

	private List<Token> fixed(String text) {
		return process(text, SourceFormat.FIXED);
	}

	private List<Token> process(String text, SourceFormat format) {
		CompilerDirectivesTokenizer tokenizer = new CompilerDirectivesTokenizer(
				new SingleTokenTokenizer(text), format);

		List<Token> tokens = new ArrayList<Token>();

		Token token = null;
		while ((token = tokenizer.nextToken()) != null)
			tokens.add(token);

		return tokens;
	}
}
