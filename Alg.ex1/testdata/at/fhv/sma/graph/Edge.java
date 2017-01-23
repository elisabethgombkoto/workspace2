package at.fhv.sma.graph;

import at.fhv.sma.math.Calculation;

/**
 * Represents an edge of a graph.
 * 
 * @author Sebastian Malin
 *
 */
public class Edge {
	
	private int _ind1 = 0;
	private int _ind2 = 0;
	private Calculation _calc = null;
	private boolean _visited = false;
	
	/**
	 * Creates an instance of an edge.
	 * 
	 * @param index1 index of node to connect
	 * @param index2 index of node to connect
	 * @param calc an instance of an calculation object
	 */
	public Edge(int index1, int index2, Calculation calc) {
		_calc = calc;
		_ind1 = index1;
		_ind2 = index2;
	}
	
	public int getIndex1() {
		return _ind1;
	}
	
	public int getIndex2() {
		return _ind2;
	}
	
	/**
	 * Invokes the calculate method of the calculate object.
	 * 
	 * @param value the value to calculate with
	 * @return returns the result of the calculation
	 */
	public int calculate(int value) {
		return _calc.calculate(value);
	}
	
	public boolean isVisited() {
		return _visited;
	}
	
	public void setVisited(boolean visited) {
		_visited = visited;
	}
	
	public Calculation getCalculation() {
		return _calc;
	}
	
	@Override
	public String toString() {
		return "(" + _ind1 + ", " + _ind2 + ")";
	}

}
