package koopa.dsl.stage.runtime.model;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A collection of {@linkplain Stage}s.
 */
public class SuiteOfStages {

	private final Map<String, Stage> stages;

	public SuiteOfStages(File[] sources) throws IOException {
		stages = new LinkedHashMap<>();

		for (File source : sources) {
			final Stage stage = new Stage(this, source);
			stages.put(stage.getName(), stage);
		}
	}

	public Collection<Stage> getStages() {
		return stages.values();
	}

	public Stage getStage(String name) {
		return stages.get(name);
	}
}
