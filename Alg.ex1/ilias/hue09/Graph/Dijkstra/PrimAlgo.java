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
public class PrimAlgo extends Algo{
	public PrimAlgo(Graph graph, Vertex vertexFrom){
		_graph = graph;
		_vertexFrom = vertexFrom;
		_listTargetVertex = new LinkedList<Vertex>(graph.get_nodeSet().values());
		_costs = new Integer[_listTargetVertex.size()];
		
		initialAlgo();
		startAlgo(vertexFrom, 0, null);
	}

	/* 
	 * startet PrimAlgo mit übergebenen StartNode und 
	 */
	@Override
	public void startAlgo(Vertex currVertex, Integer cost,Set<Vertex> visitedVertices) {
		Set<Vertex> verticesVisited = visitedVertices != null ? visitedVertices : new HashSet<Vertex>();
		
		if(!verticesVisited.contains(currVertex)){		
			LinkedList<Edge> edges = currVertex.get_adjList();
			while (!edges.isEmpty()){
				Edge min = edges.getFirst();
				for (Edge e : edges){
					if (min.getCost() > e.getCost()){
						min = edges.get(edges.indexOf(e));
					}
				}
				min = edges.remove(edges.indexOf(min));
				if (_costs[_listTargetVertex.indexOf(min.getTargetVertex())] == Integer.MAX_VALUE
					|| _costs[_listTargetVertex.indexOf(min.getTargetVertex())] > cost + min.getCost()){
					_costs[_listTargetVertex.indexOf(min.getTargetVertex())] = cost + min.getCost();
					
				}
				verticesVisited.add(currVertex);
				startAlgo(min.getTargetVertex(), cost + min.getCost(), verticesVisited);
					
			}
	
		}
		
	}
}
