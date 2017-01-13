package koopa.cobol.sources;

import java.util.List;

import koopa.cobol.parser.preprocessing.replacing.ReplacingPhrase;
import koopa.core.data.Data;

public class ReplacementData implements Data {

	private final List<ReplacingPhrase> replacements;
	private final boolean activate;

	/**
	 * If {@link #activate} is <code>true</code>: whether or not
	 * {@link #replacements} replace all previously defined
	 * {@link #replacements} or not. E.g. <code>false</code> in case of a
	 * <code>REPLACE ALSO</code>, but <code>true</code> otherwise.
	 * <p>
	 * If {@link #activate} is <code>false</code>: whether or not we're
	 * deactivating all {@link #replacements} ever defined, or just the most
	 * recently activated ones. E.g. <code>true</code> in case of a
	 * <code>REPLACE LAST OFF</code>, but <code>false</code> in case of a
	 * <code>REPLACE OFF</code>.
	 * <p>
	 * For <code>COPY</code> statements this should always be <code>false</code>
	 * as replacement clauses in a <code>COPY</code> statement are additive.
	 */
	private final boolean global;

	public ReplacementData(boolean activate, boolean global,
			List<ReplacingPhrase> replacements) {

		this.replacements = replacements;
		this.activate = activate;
		this.global = global;
	}

	public boolean activates() {
		return activate;
	}

	/**
	 * See {@link #global}.
	 */
	public boolean isGlobal() {
		return global;
	}

	public List<ReplacingPhrase> getReplacements() {
		return replacements;
	}
}
