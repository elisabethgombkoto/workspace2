/**
 * 
 */
package hue09.Graph.Dijkstra;

import java.util.List;
import java.util.Set;



/**
 * @author Elisabeth
 *
 */
public abstract class Algo {
	Graph _graph;
	Vertex _vertexFrom;
	List<Vertex> _listTargetVertex;
	Integer[] _costs;

	/**
	 * Initialisiert _cost[] mit MAX_VALUE (Infinity) und Index am StartNode mit
	 * 0;
	 */
	public void initialAlgo() {
		for (int i = 0; i < _costs.length; i++) {
			_costs[i] = Integer.MAX_VALUE;
		}
		_costs[_listTargetVertex.indexOf(_vertexFrom)] = 0;
	}

	public abstract void startAlgo(Vertex currentNode, Integer cost,Set<Vertex> visitedEdges);

	public void printCost() {
		System.out.println(getClass().getSimpleName());
		System.out.println("Shortest Path from " + _vertexFrom.get_designation());
		for (Vertex n : _listTargetVertex) {
			System.out.print(" to " + n.get_designation());
			System.out.println(" cost: " + _costs[_listTargetVertex.indexOf(n)]);
		}
	}
}
