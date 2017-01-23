package test.at.fhv.sma.struct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyList extends AdjacencyStructure {
	
	private List<LinkedList<Edge>> _adjList = new ArrayList<LinkedList<Edge>>();
	
	public AdjacencyList(int numOfVertices) {
		super(numOfVertices);
		for(int i = 0; i < numOfVertices; i++) {
			_adjList.add(new LinkedList<>());
		}
	}	

	@Override
	public void print() {
		String line = "";
		String sepLine = "--------------------------";
		int vertSize = _adjList.size();
		int edgeSize = 0;
		System.out.println(sepLine);
		for(int i = 1; i < vertSize; i++) {
			line = "";
			line = line.concat(i + "\t| -> |\t");
			edgeSize = _adjList.get(i).size();
			for(int j = 0; j < edgeSize; j++) {
				if((j+1) == edgeSize) {
					line = line.concat(_adjList.get(i).get(j).toStringTargetOnly() + "\t |");
				} else {
					line = line.concat(_adjList.get(i).get(j).toStringTargetOnly() + ",  |\n\t|    |\t");
				}
			}
			System.out.println(line);
			System.out.println(sepLine);
		}
	}
	
	public void addEdge(int startNode, int endNode, int weight) {
		validateVertex(startNode);
		validateVertex(endNode);
		_adjList.get(startNode).add(new Edge(startNode, endNode, weight));
	}
	
	@Override
	public int degree(int vertex) {
		validateVertex(vertex);
		return _adjList.get(vertex).size();
	}

	@Override
	public List<Edge> getEdges(int vertex) {
		validateVertex(vertex);
		return _adjList.get(vertex);
	}

}
