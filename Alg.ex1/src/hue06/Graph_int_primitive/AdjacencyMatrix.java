package hue06.Graph_int_primitive;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class AdjacencyMatrix extends AdjacencyStructure {
	
private Edge[][] _matrix;

	
	/**
	 * Constructor
	 * Erzeugt für den Graph einen MatrixDatenStructur mit dem eingelesenen Daten
	 * die nicht vorhandenen Kanten werden mit null iniziallisiert
	 * @param numOfVertices
	 */
	public AdjacencyMatrix(int numOfVertices) {
		super(numOfVertices);
		_matrix = new Edge[numOfVertices][numOfVertices];
	}
	
	/* (non-Javadoc)
	 * @see hue06.Graph_int_primitive.AdjacencyStructure#addEdgeToAdjacensyListOrMatrix(int, int, int)
	 */
	@Override
	public void addEdgeToAdjacensyListOrMatrix(int start, int end, int weight) {
		validateVertex(start);
		validateVertex(end);
		_matrix[start][end] = new Edge(start, end, weight);
	}

	/* (non-Javadoc)
	 * @see hue06.Graph_int_primitive.AdjacencyStructure#print()
	 */
	@Override
	public void print() {
		String line = " |\t";
		for(int i = 1; i < _matrix.length; i++) {
			line = line.concat("|" +i + "|\t");
		}
		System.out.println(line);
		line = "";
		for(int i = 1; i < _matrix.length +1; i++) {
			line = line.concat("--\t");
		}
		System.out.println(line);
		for(int i = 1; i < _matrix.length; i++) {
			line = "";
			line = line.concat(" |" + i  + "  |\t");
			for(int j = 1; j < _matrix[i].length; j++) {
				if(_matrix[i][j] != null) {
					line = line.concat( "|" + _matrix[i][j].getWeight() + "|\t");

				} else {
					line = line.concat("|" +"0" + "|\t");
				}
				
			}
			
			System.out.println(line);
			
		}
	}

	/* (non-Javadoc)
	 * @see hue06.Graph_int_primitive.AdjacencyStructure#degree(int)
	 */
	@Override
	public int degreeOfVertex(int vertex) {
		validateVertex(vertex);
		int degree = 0;
		for(int i = 1; i < _matrix[vertex].length; i++) {
			if(_matrix[vertex][i] != null) {
				degree++;
			}
		}
		return degree;
	}

	/* (non-Javadoc)
	 * @see hue06.Graph_int_primitive.AdjacencyStructure#getEdges(int)
	 */
	@Override
	public List<Edge> getEdges(int vertex) {
		validateVertex(vertex);
		LinkedList<Edge> edges = new LinkedList<Edge>();
		
		for(Edge e : _matrix[vertex]) {
			edges.add(e);
		}
		//FIX ME gibt leider auch null zurück in der Liste
		return edges;
	}

	@Override
	public void removeEdgeFromAdjacensy(int vertex, int vertex2) {
		// TODO Auto-generated method stub
		
	}

}
