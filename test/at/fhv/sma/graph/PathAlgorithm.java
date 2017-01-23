package at.fhv.sma.graph;

/**
 * Represents an algorithm to compare different paths of an graph.
 * 
 * @author Sebastian Malin
 *
 */
public abstract class PathAlgorithm {
	
	protected Path _path = null;
	
	/**
	 * Checks the condition and stores the path if the condition matches.
	 * 
	 * @param newPath the path to compare
	 */
	public abstract void setPath(Path newPath);
	
	public Path getPath() {
		return _path;
	}

}
