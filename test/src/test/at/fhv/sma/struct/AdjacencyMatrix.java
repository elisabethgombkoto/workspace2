package test.at.fhv.sma.struct;

import java.util.LinkedList;
import java.util.List;

public class AdjacencyMatrix extends AdjacencyStructure {
	
	private Edge[][] _matrix;
	
	public AdjacencyMatrix(int numOfVertices) {
		super(numOfVertices);
		_matrix = new Edge[numOfVertices][numOfVertices];
	}
	
	public void addEdge(int index1, int index2, int weight) {
		validateVertex(index1);
		validateVertex(index2);
		_matrix[index1][index2] = new Edge(index1, index2, weight);
	}

	@Override
	public void print() {
		String line = "     |\t";
		for(int i = 1; i < _matrix.length; i++) {
			line = line.concat(i + "\t");
		}
		System.out.println(line);
		line = "";
		for(int i = 1; i < _matrix.length +1; i++) {
			line = line.concat("-----\t");
		}
		System.out.println(line);
		for(int i = 1; i < _matrix.length; i++) {
			line = "";
			line = line.concat(i + "    |\t");
			for(int j = 1; j < _matrix[i].length; j++) {
				if(_matrix[i][j] != null) {
					line = line.concat(_matrix[i][j].getWeight() + "\t");
				} else {
					line = line.concat("0" + "\t");
				}
			}
			System.out.println(line);
		}
	}

	@Override
	public int degree(int vertex) {
		validateVertex(vertex);
		int degree = 0;
		for(int i = 1; i < _matrix[vertex].length; i++) {
			if(_matrix[vertex][i] != null) {
				degree++;
			}
		}
		return degree;
	}

	@Override
	public List<Edge> getEdges(int vertex) {
		validateVertex(vertex);
		LinkedList<Edge> edges = new LinkedList<Edge>();
		
		for(Edge e : _matrix[vertex]) {
			edges.add(e);
		}
		
		return edges;
	}

}
