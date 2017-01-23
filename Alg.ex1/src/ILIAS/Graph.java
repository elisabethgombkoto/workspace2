package ILIAS;
/**
 * 
 */

import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * @author Elisabeth
 *
 */
public class Graph {
	private HashMap<String, Vertex> _nodeSet = new HashMap<String, Vertex>();

	public Vertex addNode(String label) throws NodeAlreadyDafinedException {
		if (get_nodeSet().containsKey(label)) {
			throw new NodeAlreadyDafinedException();
		}
		Vertex n = new Vertex(label);
		get_nodeSet().put(label, n);
		return n;

	}

	public Vertex getNode(String label) throws NoSuchElementException {
		Vertex n = get_nodeSet().get(label);
		if (n == null){
			throw new NoSuchElementException();
		}
		return n;
	}

	public void addEdge(String src, String dest, int cost){
		Vertex srcNode = getNode(src);
		Vertex destNode = getNode(dest);
		srcNode.addEdge(new Edge(destNode, cost));
	}

	public HashMap<String, Vertex> get_nodeSet() {
		return _nodeSet;
	}

}
