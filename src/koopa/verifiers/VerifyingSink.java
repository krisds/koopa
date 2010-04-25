package koopa.verifiers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import koopa.parsers.markers.DownMarker;
import koopa.parsers.markers.LandMarker;
import koopa.parsers.markers.UpMarker;
import koopa.parsers.markers.WaterMarker;
import koopa.tokens.Token;
import koopa.tokenstreams.TokenSink;
import koopa.util.Tuple;

public abstract class VerifyingSink implements TokenSink {

	private Stack<Token> scope = new Stack<Token>();

	private List<Tuple<Token, String>> warnings = new LinkedList<Tuple<Token, String>>();

	private List<Tuple<Token, String>> errors = new LinkedList<Tuple<Token, String>>();

	private List<Verifier> waterVerififiers = new LinkedList<Verifier>();

	private Map<String, List<Verifier>> ruleVerifiers = new HashMap<String, List<Verifier>>();

	private Map<String, List<Verifier>> tokenVerifiers = new HashMap<String, List<Verifier>>();

	private TokenSink nextSink = null;

	private boolean checkTokenInTheWater = false;

	public VerifyingSink() {
		initialize();
	}

	public void setNextSink(TokenSink next) {
		this.nextSink = next;
	}

	protected void warn(Token t, String msg) {
		if (msg != null) {
			this.warnings.add(new Tuple<Token, String>(t, msg));
		}
	}

	protected void error(Token t, String msg) {
		if (msg != null) {
			this.errors.add(new Tuple<Token, String>(t, msg));
		}
	}

	public boolean hasWarnings() {
		return !this.warnings.isEmpty();
	}

	public List<Tuple<Token, String>> getWarnings() {
		return this.warnings;
	}

	public boolean hasErrors() {
		return !this.errors.isEmpty();
	}

	public List<Tuple<Token, String>> getErrors() {
		return this.errors;
	}

	public void addAll(List<Token> tokens) {
		for (Token token : tokens) {
			if (checkTokenInTheWater) {
				for (Verifier v : this.waterVerififiers) {
					v.verify(token);
				}

				checkTokenInTheWater = false;

			} else if (token instanceof LandMarker) {
				assert (!scope.isEmpty() && scope.peek() instanceof WaterMarker);
				checkTokenInTheWater = false;
				scope.pop();

			} else if (token instanceof WaterMarker) {
				checkTokenInTheWater = true;
				scope.push(token);

			} else if (token instanceof DownMarker) {

				String name = ((DownMarker) token).getName();
				List<Verifier> verifiers = this.ruleVerifiers.get(name);
				if (verifiers != null) {
					for (Verifier v : verifiers) {
						v.verify(token);
					}
				}

				scope.push(token);

			} else if (token instanceof UpMarker) {
				assert (!scope.isEmpty() && scope.peek() instanceof DownMarker && ((DownMarker) scope
						.peek()).getName().equals(((UpMarker) token).getName()));
				scope.pop();

			} else {
				List<Verifier> verifiers = this.tokenVerifiers.get(token
						.getText());
				if (verifiers != null) {
					for (Verifier v : verifiers) {
						v.verify(token);
					}
				}
			}
		}

		if (this.nextSink != null) {
			this.nextSink.addAll(tokens);
		}
	}

	protected void register(String value, Verifier verifier) {
		if (value.equals("water")) {
			this.waterVerififiers.add(verifier);

		} else if (value.toLowerCase().equals(value)) {
			List<Verifier> verifiers = this.ruleVerifiers.get(value);

			if (verifiers == null) {
				verifiers = new LinkedList<Verifier>();
				this.ruleVerifiers.put(value, verifiers);
			}

			verifiers.add(verifier);

		} else {
			List<Verifier> verifiers = this.tokenVerifiers.get(value);

			if (verifiers == null) {
				verifiers = new LinkedList<Verifier>();
				this.tokenVerifiers.put(value, verifiers);
			}

			verifiers.add(verifier);
		}
	}

	protected int lastIndexOf(String value) {
		for (int i = scope.size() - 1; i >= 0; i--) {
			Token s = scope.get(i);
			if (s instanceof WaterMarker) {
				if (value.equals("water")) {
					return i;
				}
			} else if (((DownMarker) s).getName().equals(value)) {
				return i;
			}
		}

		return -1;
	}

	protected abstract void initialize();
}
