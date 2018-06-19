package koopa.app;

import koopa.cobol.CobolProject;
import koopa.cobol.parser.CobolParser;

/**
 * A wrapper around {@linkplain CobolParser} which can be given the settings for
 * a CobolParser, and will instantiate a parser with these settings when needed.
 */
public class CobolParserFactory {

	private final CobolProject project;

	private boolean keepingTrackOfTokens = false;
	private boolean buildTrees = true;

	public CobolParserFactory(CobolProject project) {
		this.project = project;
	}

	/**
	 * Creates a new coordinator which is a (partial) copy of the given one. In
	 * particular the new project instance will use the same format, and
	 * preprocessing configuration as the given project.
	 */
	public CobolParserFactory(CobolParserFactory factory) {
		this.buildTrees = factory.buildTrees;
		this.keepingTrackOfTokens = factory.keepingTrackOfTokens;
		this.project = factory.project.duplicate();
	}

	public CobolParser getParser() {
		final CobolParser parser = new CobolParser();

		parser.setProject(project);

		parser.setKeepingTrackOfTokens(keepingTrackOfTokens);
		parser.setBuildTrees(buildTrees);

		return parser;
	}

	public boolean isKeepingTrackOfTokens() {
		return keepingTrackOfTokens;
	}

	public void setKeepingTrackOfTokens(boolean keepingTrackOfTokens) {
		this.keepingTrackOfTokens = keepingTrackOfTokens;
	}

	public void setBuildTrees(boolean buildTrees) {
		this.buildTrees = buildTrees;
	}

	public CobolProject getProject() {
		return project;
	}
}
