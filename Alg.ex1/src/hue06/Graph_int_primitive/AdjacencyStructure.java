package hue06.Graph_int_primitive;

import java.util.List;



public abstract class AdjacencyStructure {
	
private final int _nummberOfVertices;
	
	public AdjacencyStructure(int numOfVertices) {
		_nummberOfVertices = numOfVertices;
	}
	
	protected void validateVertex(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > _nummberOfVertices) {
			throw new IndexOutOfBoundsException("Index of Vertex " + index + " is not between 0 and " + _nummberOfVertices);
		}
	}
	
	protected int getNumOfVertices() {
		return _nummberOfVertices;
	}
	
	/**
	 * stellt je nach Typ auf der Konsole die Werte Von den Graph dar
	 * System.out.println();
	 * 
	 * @see {@link AdjacencyList} print()
	 * @see {@link AdjacencyMatrix} print()
	 */
	public abstract void print();
	
	
	/**
	 * erstellt die Graph, damit, dass die Kanten je nach Typ fest legt
	 * @see {@link AdjacencyList} 
	 * @see {@link AdjacencyMatrix}
	 */
	public abstract void addEdgeToAdjacensyListOrMatrix(int from, int to, int weight);
	
	
	/**
	 * gibt denAnzahl von aus und eingehende Kanten von einem Knote als int wert zurück
	 * @see {@link AdjacencyList} addEdgeToAdjacensyListOrMatrix()
	 * @see {@link AdjacencyMatrix}addEdgeToAdjacensyListOrMatrix()
	 */
	public abstract int degreeOfVertex(int vertex);
	
	
	/**
	 * Liefert alle kanten von non einem Knoten aus, in eine Liste
	 *  inklusive nicht vorhandende Kanten, die werden mit 0 iniziallisiert
	 * 
	 * @see {@link AdjacencyList} degree()
	 * @see {@link AdjacencyMatrix}degree()
	 */
	public abstract List<Edge> getEdges(int vertex);
	
	
	/**
	 //TODO noch nicht fertig implementiert
	 * @see {@link AdjacencyList} getEdges()
	 * @see {@link AdjacencyMatrix}getEdges()
	 */
	public abstract void removeEdgeFromAdjacensy(int vertex, int vertex2);

	

}
