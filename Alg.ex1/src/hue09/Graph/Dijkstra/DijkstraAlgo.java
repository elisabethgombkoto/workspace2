/**
 * 
 */
package hue09.Graph.Dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;



/**
 * @author Elisabeth
 *
 */
public class DijkstraAlgo extends Algo implements Relaxationable{
	public DijkstraAlgo(Graph graph, Vertex startNode) {
		_graph = graph;
		_vertexFrom = startNode;
		_listTargetVertex = new LinkedList<Vertex>(graph.get_nodeSet().values());
		_costs = new Integer[_listTargetVertex.size()];
		initialAlgo();
		startAlgo(startNode, 0, null);

	}
	
	
	/* (non-Javadoc)
	 * @see hue09.Graph.Dijkstra.Relaxationable#relaxation(hue09.Graph.Dijkstra.Edge, java.lang.Integer)
	 */
	@Override
	public void relaxation(Edge e, Integer cost) {
		if (_costs[_listTargetVertex.indexOf(e.getTargetVertex())] == Integer.MAX_VALUE
				|| _costs[_listTargetVertex.indexOf(e.getTargetVertex())] > cost + e.getCost()) {
			_costs[_listTargetVertex.indexOf(e.getTargetVertex())] = cost + e.getCost();
		}
		
	}

	
}
