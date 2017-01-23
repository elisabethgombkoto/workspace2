package test.at.fhv.sma.struct;

import java.util.List;

public abstract class AdjacencyStructure {
	
	protected final int _numOfVertices;
	
	public AdjacencyStructure(int numOfVertices) {
		_numOfVertices = numOfVertices;
	}
	
	protected void validateVertex(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > _numOfVertices) {
			throw new IndexOutOfBoundsException("Index of Vertex " + index + " is not between 0 and " + _numOfVertices);
		}
	}
	
	protected int getNumOfVertices() {
		return _numOfVertices;
	}
	
	public abstract void print();
	
	public abstract void addEdge(int from, int to, int weight);
	
	public abstract int degree(int vertex);
	
	public abstract List<Edge> getEdges(int vertex);

}
