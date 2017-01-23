package ILIAS;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/**
 * 
 */

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
	 * Initialisiert _cost[] array  mit Infinity
	 *  Index von StartVertex ist 0;
	 */
	public void initialAlgo() {
		for (int i = 0; i < _costs.length; i++) {
			_costs[i] = Integer.MAX_VALUE;
		}
		_costs[_listTargetVertex.indexOf(_vertexFrom)] = 0;
	}


	public abstract void startAlgo(Vertex currVertex, Integer cost, Set<Vertex> visitedVertices);
//	{
//		Set<Vertex> verticesVisited = visitedVertices != null ? visitedVertices : new HashSet<Vertex>();
//		
//		if(!verticesVisited.contains(currVertex)){
//			LinkedList<Edge> edges = currVertex.get_adjList();
//			if (!edges.isEmpty()) {
//				for (Edge e : edges) {
//					if (_costs[_listTargetVertex.indexOf(e.getTargetVertex())] == Integer.MAX_VALUE
//							|| _costs[_listTargetVertex.indexOf(e.getTargetVertex())] > cost + e.getCost()) {
//						_costs[_listTargetVertex.indexOf(e.getTargetVertex())] = cost + e.getCost();
//					}
//					verticesVisited.add(currVertex);
//					startAlgo(e.getTargetVertex(), cost + e.getCost(), visitedVertices);
//
//				}
//
//			}
//
//		}
//	}
	public void printCost() {
		System.out.println(getClass().getSimpleName());
		System.out.println("Shortest Path from " + _vertexFrom.get_designation());
		for (Vertex n : _listTargetVertex) {
			System.out.print(" to " + n.get_designation());
			System.out.println(" cost: " + _costs[_listTargetVertex.indexOf(n)]);
		}
	}
}
