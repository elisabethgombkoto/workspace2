package hue06.Graph_int_primitive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class AdjacencyList extends AdjacencyStructure{

		
private List<LinkedList<Edge>> _adjacencyList = new ArrayList<LinkedList<Edge>>();
	
	/**
	 * Construktor
	 * Erzeugt für den Graph einen ListDatenStructur mit dem eingelesenen Daten
	 * die nicht vorhandenen Kanten werden mit null iniziallisiert
	 * 
	 * @param numOfVertices
	 */
	public AdjacencyList(int numOfVertices) {
		super(numOfVertices);
		for(int i = 0; i < numOfVertices; i++) {
			_adjacencyList.add(new LinkedList<>());
		}
	}	

	/* (non-Javadoc)
	 * @see hue06.Graph_int_primitive.AdjacencyStructure#print()
	 */
	@Override
	public void print() {
		String line = "";
		String abstand = " ";
		int vertSize = _adjacencyList.size();
		int edgeSize = 0;
		System.out.println(abstand);
		for(int i = 1; i < vertSize; i++) {
			line = "";
			line = line.concat(" | "+i +" |"+ "\t ->\t");
			edgeSize = _adjacencyList.get(i).size();
			for(int j = 0; j < edgeSize; j++) {
				if((j+1) == edgeSize) {
					line = line.concat(_adjacencyList.get(i).get(j).toStringTargetOnly() + "\t ");
				} else {
					line = line.concat(_adjacencyList.get(i).get(j).toStringTargetOnly() + ",");
				}
			}
			System.out.println(line);
			System.out.println(abstand);
		}
	}
	
	/* (non-Javadoc)
	 * @see hue06.Graph_int_primitive.AdjacencyStructure#addEdgeToAdjacensyListOrMatrix(int, int, int)
	 */
	@Override
	public void addEdgeToAdjacensyListOrMatrix(int startNode, int endNode, int weight) {
		validateVertex(startNode);
		validateVertex(endNode);
		_adjacencyList.get(startNode).add(new Edge(startNode, endNode, weight));
	}
	
	
	/* (non-Javadoc)
	 * @see hue06.Graph_int_primitive.AdjacencyStructure#removeEdgeFromAdjacensy(int, int)
	 */
	@Override
	public void removeEdgeFromAdjacensy(int vertex1, int vertex2){
		
	//wie kann ich 
	}
	
	/* (non-Javadoc)
	 * @see hue06.Graph_int_primitive.AdjacencyStructure#degreeOfVertex(int)
	 */
	@Override
	public int degreeOfVertex(int vertex) {
		validateVertex(vertex);
		return _adjacencyList.get(vertex).size();
	}

	/* (non-Javadoc)
	 * @see hue06.Graph_int_primitive.AdjacencyStructure#getEdges(int)
	 */
	@Override
	public List<Edge> getEdges(int vertex) {
		validateVertex(vertex);
		return _adjacencyList.get(vertex);
	}
}
