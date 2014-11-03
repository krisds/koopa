package koopa.core.data;

/**
 * Representation of a position in a file. This tracks both overall position in
 * the file, as well as a position relative to a linenumber. All values are
 * character based, not byte based.
 * <p>
 * <b>Trying to keep this class immutable.</b>
 */
public final class Position {

	private final int linenumber;
	private final int positionInFile;
	private final int positionInLine;

	public Position(int positionInFile, int linenumber, int positionInLine) {
		this.positionInFile = positionInFile;
		this.linenumber = linenumber;
		this.positionInLine = positionInLine;
	}

	public int getLinenumber() {
		return linenumber;
	}

	public int getPositionInFile() {
		return positionInFile;
	}

	public int getPositionInLine() {
		return positionInLine;
	}

	public Position offsetBy(int offset) {
		return new Position(positionInFile + offset, linenumber, positionInLine
				+ offset);
	}

	public String toString() {
		return linenumber + ":" + positionInLine;
	}

	@Override
	public int hashCode() {
		return positionInFile;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Position))
			return false;

		Position other = (Position) obj;
		return positionInFile == other.positionInFile;
	}
}
