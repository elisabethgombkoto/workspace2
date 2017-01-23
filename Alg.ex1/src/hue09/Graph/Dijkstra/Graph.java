/**
 * 
 */
package hue09.Graph.Dijkstra;

import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * @author Elisabeth
 *
 */
public class Graph {
	private HashMap<String, Vertex> _nodeSet = new HashMap<String, Vertex>();
	int _amountOfVertices;
	int _amountOfEdge;

	public Vertex addNode(String label) throws NodeAlreadyDefinedException {
		_amountOfVertices=0;
		if (get_nodeSet().containsKey(label)) {
			throw new NodeAlreadyDefinedException();
		}
		Vertex n = new Vertex(label);
		get_nodeSet().put(label, n);
		_amountOfVertices++;
		return n;

	}

	public Vertex getVertex(String label) throws NoSuchElementException {
		Vertex n = get_nodeSet().get(label);
		if (n == null){
			throw new NoSuchElementException();
		}
		return n;
	}

	public void addEdge(String src, String dest, int cost){
		_amountOfEdge=0;
		Vertex vertexFrom = getVertex(src);
		Vertex vertexto = getVertex(dest);
		vertexFrom.addEdge(new Edge(vertexto, cost));
		_amountOfEdge++;
		
	}

	public HashMap<String, Vertex> get_nodeSet() {
		return _nodeSet;
	}


}
