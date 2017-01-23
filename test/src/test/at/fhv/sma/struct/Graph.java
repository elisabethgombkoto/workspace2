package test.at.fhv.sma.struct;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	
	protected enum AdjacencyStructureType {
		MATRIX, LIST
	}
	
	private AdjacencyStructure _adjstruct = null;
	
	private Graph(int numOfVertices, AdjacencyStructureType adjType) {
		switch (adjType) {
		case MATRIX:
			_adjstruct = new AdjacencyMatrix(numOfVertices);
			break;
		case LIST:
			_adjstruct = new AdjacencyList(numOfVertices);
			break;
		default:
			break;
		}
	}
	
	private void addEdge(int from, int to, int weight) {
		_adjstruct.addEdge(from, to, weight);
	}
	
	public static Graph createGraph(String filename, AdjacencyStructureType adjType) throws IOException {
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		
		line = br.readLine();	// read vertex line
		String[] sVertices = line.substring(line.indexOf('{')+1, line.lastIndexOf('}')).split(",");
		int[] iVertices = test.at.fhv.sma.util.FileUtil.stringToIntArray(sVertices);
		
		Graph g = new Graph(iVertices.length + 1, adjType);
		
		line = br.readLine();	// read edge line
		String[] sEdges = line.substring(line.indexOf('{')+2, line.lastIndexOf('}')-1).split("\\],\\[");
		
		int[] iEdge;
		for(String e : sEdges) {
			iEdge = test.at.fhv.sma.util.FileUtil.stringToIntArray(e.split(","));
			g.addEdge(iEdge[0], iEdge[1], iEdge[2]);
		}
		
		br.close();
		return g;
	}
	
	public boolean hasEulerPath() {
		int oddNodes = 0;
		int numOfVert = _adjstruct.getNumOfVertices();
		
		for(int i = 1; i < numOfVert; i ++) {
			if((_adjstruct.degree(i) % 2) != 0) {
				oddNodes++;
			}
		}
			
		if((oddNodes == 0) || (oddNodes == 2)) {
			return true;
		}
		return false;
	}
	
	public boolean hasEulerTour() {
		int oddNodes = 0;
		int numOfVert = _adjstruct.getNumOfVertices();
		
		for(int i = 1; i < numOfVert; i ++) {
			if((_adjstruct.degree(i) % 2) != 0) {
				oddNodes++;
			}
		}
			
		if(oddNodes == 0) {
			return true;
		}
		
		return false;
	}
	
	private void findEulerPath(int startVertex) {
		List<Edge> closeList = new LinkedList<Edge>();	// visited true
//		int[] path = new int[_adjstruct.getNumOfVertices()];
		
		List<Edge> edges = _adjstruct.getEdges(startVertex);
		for(Edge e : edges) {
			if(!edgeIsVisited(closeList, e)) {
				closeList.add(e);
				findEulerPath(e.getNode2());
			}
		}
	}
	
	private boolean edgeIsVisited(List<Edge> closeList, Edge edge) {
		for(Edge e : closeList) {
			if(e == edge) {
				return true;
			}
		}
		return false;
	}
	
	public void print() {
		_adjstruct.print();
	}
	
	
}
