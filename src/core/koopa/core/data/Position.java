package koopa.core.data;

/**
 * Representation of a position in a file. This tracks both overall position in
 * the file, as well as a position relative to a linenumber. All values are
 * character based, not byte based.
 * <p>
 * <b>Trying to keep this class immutable.</b>
 */
public final class Position {

	public static final Position ZERO = new Position(null, 0, 0, 0);

	private final String resourceName;
	private final int linenumber;
	private final int positionInFile;
	private final int positionInLine;

	public Position(int positionInFile, int linenumber, int positionInLine) {
		this(null, positionInFile, linenumber, positionInLine);
	}

	public Position(String filename, int positionInFile, int linenumber,
			int positionInLine) {
		this.resourceName = filename;
		this.positionInFile = positionInFile;
		this.linenumber = linenumber;
		this.positionInLine = positionInLine;
	}

	public String getResourceName() {
		return resourceName;
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
		return new Position(resourceName, positionInFile + offset, linenumber,
				positionInLine + offset);
	}

	public String toString() {
		if (resourceName != null)
			return resourceName + "@" + linenumber + ":" + positionInLine;
		else
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
		if (resourceName != null && !resourceName.equals(other.resourceName))
			return false;

		return positionInFile == other.positionInFile;
	}
}
