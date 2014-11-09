package koopa.core.data;

/**
 * A Range represents a the start and end position for a sequence of characters.
 */
public class Range {

	private final Position start;
	private final Position end;

	public Range(Position start, Position end) {
		super();
		this.start = start;
		this.end = end;
	}

	/**
	 * Start position of this range. Which is the position of the first
	 * character in a sequence of characters.
	 */
	public Position getStart() {
		return start;
	}

	/**
	 * End position of this range. Which is the position of the last character
	 * in a sequence of characters.
	 * <p>
	 * If the sequence holds only a single character this will be the same as
	 * the start position.
	 * <p>
	 * Why not choose the position of the character following this sequence
	 * instead ? Because there may not exist such a character, and so that may
	 * not represent a valid position.
	 */
	public Position getEnd() {
		return end;
	}

	/**
	 * Length of this range, which is equivalent to:
	 * <code>{@linkplain #getEnd()} -
	 * {@linkplain #getStart()} + 1.</code>
	 */
	public int getLength() {
		return end.getPositionInFile() - start.getPositionInFile() + 1;
	};

	@Override
	public int hashCode() {
		return start.hashCode() + end.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Range))
			return false;

		Range otherRange = (Range) obj;
		return start.equals(otherRange.start) && end.equals(otherRange.end);
	}

	@Override
	public String toString() {
		return start + " -- " + end;
	}
}
