package hue06.Graph_int_primitive;

public class Edge {
	
	private Integer _vertexFrist = 0;
	private Integer _vertexSecond = 0;
	private int _weight = 0;
	
	
	/**
	 * Constructor.
	 * als Object erzeugt eine Kante eines Graphes mit ein und ausgang Knoten und 
	 * @param node1
	 * @param node2
	 * @param weight
	 */
	public Edge(int node1, int node2, int weight) {
		_vertexFrist = node1;
		_vertexSecond = node2;
		_weight = weight;
	}
	
	public int getFirstVertexFromEdge() {
		return _vertexFrist;
	}
	
	/**
	 * @return
	 */
	public int getSecondVertexFromEdge() {
		return _vertexSecond;
	}
	
	public int getWeight() {
		return _weight;
	}
	
	/**
	 * es wird von der Kante die zweite Punke und sein Gewicht 
	 * ausgegeben
	 * @see java.lang.Object#toString()
	 */
	public String toStringTargetOnly() {
		return "[" + _vertexSecond + ", " + _weight + "]";
	}
	/**
	 * es wird von der Kante die zwei dazuhörige Punkte und sein Gewicht 
	 * ausgegeben
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "[" + _vertexFrist + ", " + _vertexSecond + ", " + _weight + "]";
	}
	
	
	/**
	 * vergleicht nur die Haswerte von den Objecten
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @see  {@link Edge} @Override hashCode()
	 */
	@Override
	public boolean equals(Object obj) {
		return hashCode() == obj.hashCode();
	}
	/**
	 * die Kante mit <xfrom, yto> und <yto, xfrom>
	 * bekomment den gleichen hashwerte
	 * 
	 * @see java.lang.Object#hashCode()
	 * @see {@link Edge} @Override equals()
	 */
	
	@Override
	public int hashCode() {
		int hash = 5;
		int min = getFirstVertexFromEdge() < getSecondVertexFromEdge() ? getFirstVertexFromEdge() : getSecondVertexFromEdge();
		int max = min == getFirstVertexFromEdge() ? getSecondVertexFromEdge() : getFirstVertexFromEdge();
		hash = 89*hash + min;
		hash = 89*hash + max;
		// TODO Auto-generated method stub
		return hash;
	}

}
