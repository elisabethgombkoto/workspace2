package hue06.task1.GarphErzeugen;

import javax.management.InvalidAttributeValueException;

public abstract class Algoritmus {
	
	protected Path _path = null;
	
	public abstract void setPath(Path possiblePath) throws InvalidAttributeValueException;
	
	/**
	 * @return the _path of given Algoritmus
	 * @see Klothilde_999Cost
	 * @see Klotmilde_minCost
	 * @see Klotwilde_MaxCost
	 */
	public Path get_path() {
		return _path;
	}
}
