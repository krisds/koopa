package koopa.cobol;

import java.io.File;

import koopa.cobol.grammar.CobolGrammar;
import koopa.cobol.sources.SourceFormat;
import koopa.core.parsers.ParserCombinator;
import koopa.core.util.TabStops;

/**
 * The CobolProject defines how Cobol files should be handled/parsed. What
 * formatting do they use ? What parser/grammar rule should be applied ? What
 * files are copybooks ? Where is a certain named copybook ?
 */
public interface CobolProject {

	/**
	 * What {@linkplain CobolGrammar} should be used ?
	 */
	CobolGrammar getGrammar();

	/**
	 * The <code>sourceFile</code> is looking for copybook <code>textName</code>
	 * of <code>libraryName</code>. This should return the right file for that
	 * copybook, or <code>null</code> if it couldn't be found.
	 * <p>
	 * The spec on copybook resolution:
	 * <p>
	 * "The implementor shall define the rules for locating the library text
	 * referenced by text-name-1 or literal-1. When neither library-name-1 nor
	 * literal-2 is specified, a default COBOL library is used. The implementor
	 * defines the mechanism for identifying the default COBOL library."
	 */
	File locateCopybook(String textName, String libraryName, File sourceFile);

	/**
	 * What parser/grammar rule should be used to parse the file ?
	 */
	ParserCombinator parserFor(File file);

	/**
	 * What's the default {@linkplain SourceFormat} ?
	 */
	SourceFormat getDefaultFormat();

	/**
	 * Set the default {@linkplain SourceFormat}.
	 */
	void setDefaultFormat(SourceFormat format);

	/**
	 * What's the {@linkplain SourceFormat} for this specific file ?
	 */
	SourceFormat getFormat(File file);

	/**
	 * What's the default tab length to use ? (As a number of spaces.)
	 */
	int getDefaultTabLength();

	/**
	 * Set the default tab length to use. (As a number of spaces.)
	 */
	void setDefaultTabLength(int tabLengthValue);

	/**
	 * What's the default tab length to use for this specific file ? (As a
	 * number of spaces.)
	 */
	int getTabLength(File file);

	/**
	 * What are the default tab stops to use ?
	 */
	TabStops getDefaultTabStops();
	
	/**
	 * Set the default tab stops to use.
	 */
	void setDefaultTabStops(TabStops tabStops);
	
	/**
	 * What are the tab stops to use for this specific file ?
	 */
	TabStops getTabStops(File file);
	
	/**
	 * Should we be preprocessing files by default ?
	 */
	boolean isDefaultPreprocessing();

	/**
	 * Define whether we should be preprocessing files by default.
	 */
	void setDefaultPreprocessing(boolean preprocessing);

	/**
	 * Should we be preprocessing this specific file ?
	 */
	boolean isPreprocessing(File file);

	/**
	 * Get a copy of this CobolProject with the same settings.
	 */
	CobolProject duplicate();
}
