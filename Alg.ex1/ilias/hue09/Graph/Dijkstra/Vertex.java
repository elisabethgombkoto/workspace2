/**
 * 
 */
package hue09.Graph.Dijkstra;

import java.util.LinkedList;

/**
 * @author Elisabeth Gombkötö
 *
 */

public class Vertex {
	
	private String _designation;
	private LinkedList<Edge> _adjList = new LinkedList<Edge>();

	/**
	 * Constructor
	 * @param String s- name of the Vertex
	 */
	public Vertex(String s) {
		_designation = s;
	}

	public String get_designation() {
		return _designation;
	}

	public void addEdge(Edge e) {
		get_adjList().add(e);
	}

	public Edge getEdgeTo(Vertex n) {
		for (Edge e : get_adjList()) {
			if (e.target.equals(n))
				return e;
		}
		return null;
	}


	public LinkedList<Edge> get_adjList() {
		return _adjList;
	}

	public void set_adjList(LinkedList<Edge> _adjList) {
		this._adjList = _adjList;
	}

}
