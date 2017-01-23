package alg.bor4027.ext8.task2;

import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * @author Bernd
 *
 */
public class Graph {

	private HashMap<String, Node> _nodeSet = new HashMap<String, Node>();

	public Node addNode(String label) throws NodeAlreadyDefinedException {
		if (get_nodeSet().containsKey(label)) {
			throw new NodeAlreadyDefinedException();
		}
		Node n = new Node(label);
		get_nodeSet().put(label, n);
		return n;

	}

	public Node getNode(String label) throws NoSuchElementException {
		Node n = get_nodeSet().get(label);
		if (n == null){
			throw new NoSuchElementException();
		}
		return n;
	}

	public void addEdge(String src, String dest, int cost){
		Node srcNode = getNode(src);
		Node destNode = getNode(dest);
		srcNode.addEdge(new Edge(destNode, cost));
	}

	public HashMap<String, Node> get_nodeSet() {
		return _nodeSet;
	}


	
}
