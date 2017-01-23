package test.at.fhv.sma.struct;

public class Edge {
	
	private Integer _node1 = 0;
	private Integer _node2 = 0;
	private int _weight = 0;
	private boolean _visited = false;
	
	public Edge(int node1, int node2, int weight) {
		_node1 = node1;
		_node2 = node2;
		_weight = weight;
	}
	
	public int getNode1() {
		return _node1;
	}
	
	public int getNode2() {
		return _node2;
	}
	
	public int getWeight() {
		return _weight;
	}
	
	public void setVisited(boolean visited) {
		_visited = visited;
	}
	
	public boolean isVisited() {
		return _visited;
	}
	
	public String toStringTargetOnly() {
		return "[" + _node2 + ", " + _weight + "]";
	}
	
	@Override
	public String toString() {
		return "[" + _node1 + ", " + _node2 + ", " + _weight + "]";
	}

}
