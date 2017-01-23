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
public class DijkstraAlgo extends Algo{
	public DijkstraAlgo(Graph graph, Vertex startNode) {
		_graph = graph;
		_vertexFrom = startNode;
		_listTargetVertex = new LinkedList<Vertex>(graph.get_nodeSet().values());
		_costs = new Integer[_listTargetVertex.size()];
		initialAlgo();
		startAlgo(startNode, 0, null);

	}
	/* (non-Javadoc)
	 * @see hue09.Graph.Dijkstra.Algo#startAlgo(hue09.Graph.Dijkstra.Vertex, java.lang.Integer, java.util.Set)
	 * 
	 * führ die Dijkstra Algoritmus aus
	 */
	@Override
	public void startAlgo(Vertex currVertex, Integer cost, Set<Vertex> visitedVertices) {
		Set<Vertex> verticesVisited = visitedVertices != null ? visitedVertices : new HashSet<Vertex>();
		
		if(!verticesVisited.contains(currVertex)){
			LinkedList<Edge> edges = currVertex.get_adjList();
			if (!edges.isEmpty()) {
				for (Edge e : edges) {
					if (_costs[_listTargetVertex.indexOf(e.getTargetVertex())] == Integer.MAX_VALUE
							|| _costs[_listTargetVertex.indexOf(e.getTargetVertex())] > cost + e.getCost()) {
						_costs[_listTargetVertex.indexOf(e.getTargetVertex())] = cost + e.getCost();
					}
					verticesVisited.add(currVertex);
					startAlgo(e.getTargetVertex(), cost + e.getCost(), visitedVertices);

				}

			}

		}
	}

}
