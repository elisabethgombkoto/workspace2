package alg.bor4027.ext8.task2;


import java.util.LinkedList;

/**
 * @author Bernd
 *
 */
public class Node {
	private boolean visited;
	private String _label;
	private LinkedList<Edge> _adjList = new LinkedList<Edge>();

	public Node(String s) {
		_label = s;
	}

	public String getLabel() {
		return _label;
	}

	public void addEdge(Edge e) {
		get_adjList().add(e);
	}

	public Edge getEdgeTo(Node n) {
		for (Edge e : get_adjList()) {
			if (e._dest.equals(n))
				return e;
		}
		return null;
	}


/**	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Edge e : get_adjList()) {

			sb.append("==> cost: " + e.getCost() + " ===> " + e.getDestNode().getLabel() + "\n");

		}

		return sb.toString();

	}
	*/

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public LinkedList<Edge> get_adjList() {
		return _adjList;
	}

	public void set_adjList(LinkedList<Edge> _adjList) {
		this._adjList = _adjList;
	}

}
