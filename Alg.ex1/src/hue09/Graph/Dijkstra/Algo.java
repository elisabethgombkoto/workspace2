/**
 * 
 */
package hue09.Graph.Dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;



/**
 * @author Elisabeth
 *
 */
public abstract class Algo implements Relaxationable {
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
	/* 
	 * startet PrimAlgo mit übergebenen StartNode und 
	 */
	
	public void startAlgo(Vertex currVertex, Integer cost,Set<Vertex> visitedVertices) {
		Set<Vertex> closeList = visitedVertices != null ? visitedVertices : new HashSet<Vertex>();
		
		if(!closeList.contains(currVertex)){		
			LinkedList<Edge> edges = currVertex.get_adjList();
			while (!edges.isEmpty()){
				Edge min = edges.getFirst();
				for (Edge e : edges){
					if (min.getCost() > e.getCost()){
						min = edges.get(edges.indexOf(e));
					}
				}
				min = edges.remove(edges.indexOf(min));
				relaxation(min, cost);
//				if (_costs[_listTargetVertex.indexOf(min.getTargetVertex())] == Integer.MAX_VALUE
//					|| _costs[_listTargetVertex.indexOf(min.getTargetVertex())] > cost + min.getCost()){
//					_costs[_listTargetVertex.indexOf(min.getTargetVertex())] = cost + min.getCost();
//					
//				}
				closeList.add(currVertex);
				startAlgo(min.getTargetVertex(), cost + min.getCost(), closeList);
					
			}
	
		}
		
	}

	
	/**
	 * @param min
	 * @param cost
	 */
	public abstract void relaxation(Edge min, Integer cost);

	public void printCost() {
		System.out.println(getClass().getSimpleName());
		System.out.println("Shortest Path from " + _vertexFrom.get_designation());
		for (Vertex n : _listTargetVertex) {
			
			System.out.print(" to " + n.get_designation());
			System.out.println(" cost: " + _costs[_listTargetVertex.indexOf(n)]  );
		}
		
	}
}
