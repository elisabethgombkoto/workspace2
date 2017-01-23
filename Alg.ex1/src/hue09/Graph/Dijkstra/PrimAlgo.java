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
public class PrimAlgo extends Algo implements Relaxationable{
	public PrimAlgo(Graph graph, Vertex vertexFrom){
		_graph = graph;
		_vertexFrom = vertexFrom;
		_listTargetVertex = new LinkedList<Vertex>(graph.get_nodeSet().values());
		_costs = new Integer[_listTargetVertex.size()];
		
		initialAlgo();
		startAlgo(vertexFrom, 0, null);
	}

	
	/**
	 * 
	 */
	public void relaxation(Edge min, Integer cost) {
		if (_costs[_listTargetVertex.indexOf(min.getTargetVertex())] == Integer.MAX_VALUE
				|| _costs[_listTargetVertex.indexOf(min.getTargetVertex())] > cost + min.getCost()){
				_costs[_listTargetVertex.indexOf(min.getTargetVertex())] = cost + min.getCost();
				
			}
		
	}
}
