package koopa.dsl.stage.runtime.model;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import koopa.core.trees.Tree;
import koopa.core.util.Files;
import koopa.dsl.stage.util.StageUtil;

/**
 * A collection of grammar tests for one or more {@linkplain Target}s.
 * Corresponds to a single ".stage" file.
 */
public class Stage {

	/** The overall suite this this stage belongs to. */
	private final SuiteOfStages suite;

	/** The source file this stage was loaded from. */
	private final File source;

	/** The name of this stage. Which is the name of the {@link #source} file. */
	private final String name;

	/**
	 * Collects all grammar tests and groups them with the grammar rules they
	 * were defined for.
	 */
	private Map<String, Target> targets = new LinkedHashMap<>();

	public Stage(SuiteOfStages suite, File source) throws IOException {
		this.suite = suite;
		this.source = source;
		this.name = Files.getName(source);

		load();
	}

	private void load() throws IOException {
		final Tree ast = StageUtil.getAST(source, false);

		if (ast == null)
			throw new InternalError("Failed to parse stage: " + source);

		for (Tree targetDefinition : ast.getChildren("target")) {
			Target target = new Target(this, targetDefinition);
			targets.put(target.getName(), target);
		}
	}

	public File getSource() {
		return source;
	}

	public Collection<Target> getTargets() {
		return Collections.unmodifiableCollection(targets.values());
	}

	public Target getTarget(String name) {
		return targets.get(name);
	}

	public String getName() {
		return name;
	}

	public SuiteOfStages getSuite() {
		return suite;
	}
}
